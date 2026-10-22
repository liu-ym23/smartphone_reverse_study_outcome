package cn.nubia.neopush.protocol.http;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import cn.nubia.neopush.commons.NeoLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class HttpUtils {
    public HttpUtils() {
    }

    private static String getParamString(ArrayList<RequestParam> r5) throws UnsupportedEncodingException {
        StringBuilder r10 = new StringBuilder();
        if (r5 != null) goto L5;
        return "";
    L5:
        if (r5.size() == 0) goto L20;
        int r11 = r5.size();
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L10;
        r10.append(r5.get(r12).key);
        r10.append("=");
        r10.append(URLEncoder.encode(r5.get(r12).value, "utf-8"));
        if (r12 >= (r11 - 1)) goto L14;
        r10.append("&");
    L14:
        r12 = r12 + 1;
        goto L8
    L10:
        return r10.toString();
    L20:
        return "";
    }

    public static String post(String r5, ArrayList<RequestParam> r10) {
        StringBuilder r11 = new StringBuilder();
        String r12 = getParamString(r10);     // Catch: UnsupportedEncodingException -> L5
    L29:
        HttpsURLConnection r13 = (HttpsURLConnection) new URL(r5).openConnection();     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.setDoInput(true);     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.setDoOutput(true);     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.setRequestMethod("POST");     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.setRequestProperty("Content-Length", String.valueOf(r12.getBytes().length));     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.setUseCaches(false);     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.getOutputStream().write(r12.getBytes("UTF-8"));     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.getOutputStream().flush();     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r13.getOutputStream().close();     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        int r14 = r13.getResponseCode();     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        if (r14 != 200) goto L20;
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r13.getInputStream()));     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
    L10:
        String r16 = r15.readLine();     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        if (r16 == null) goto L12;
        r11.append(r16);     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r11.append("\n");     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        goto L10
    L12:
        r15.close();     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
    L25:
        NeoLog.e("llxie", "respones " + r11.toString() + "大小" + r11.toString().getBytes().length);
        return r11.toString();
    L20:
        r11.append("errorcode:");     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
        r11.append(r14);     // Catch: Exception -> L13 IOException -> L15 MalformedURLException -> L17
    L17:
        e = move-exception;
        NeoLog.e("llxie", "MalformedURLException " + e.getMessage());
        r11.append("errorcode:404");
        e.printStackTrace();
    L15:
        e = move-exception;
        NeoLog.e("llxie", "IOException " + e.getMessage());
        r11.append("errorcode:404");
        e.printStackTrace();
    L13:
        e = move-exception;
        NeoLog.e("llxie", "Exception " + e.getMessage());
        r11.append("errorcode:404");
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L29
    }
}
