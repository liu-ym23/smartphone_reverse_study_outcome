package com.bytedance.apm6.util;

import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class UrlUtils {
    static int SDK_VERSION = 1;

    static {
    }

    public UrlUtils() {
    }

    public static String addParamsToURL(String r8, Map<String, String> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if (TextUtils.isDigitsOnly(r8) == true) goto L29;
        if (r10 == null) goto L29;
        if (r10.isEmpty() == true) goto L29;
        if (r8.indexOf("?") >= 0) goto L12;
        r8 = r8 + "?";
    L12:
        if (r8.endsWith("?") == false) goto L14;
        StringBuilder r11 = new StringBuilder().append(r8);
    L15:
        r8 = r11.append(encode("sdk_version", RpcUtils.CHARSET_UTF8)).append("=").append(encode(String.valueOf(SDK_VERSION), RpcUtils.CHARSET_UTF8)).toString();
        if (r10 == null) goto L29;
        if (r10.size() <= 0) goto L29;
        Iterator r2 = r10.entrySet().iterator();
    L21:
        if (r2.hasNext() == false) goto L29;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r10.get(r3.getKey()) == null) goto L21;
        if (r8.endsWith("?") == false) goto L27;
        StringBuilder r12 = new StringBuilder().append(r8);
    L28:
        r8 = r12.append(encode(r3.getKey().toString(), RpcUtils.CHARSET_UTF8)).append("=").append(encode(((String) ZeusTransformUtils.preCheckCast(r10.get(r3.getKey()), String.class, "com.obric.memorydata.plugin")).toString(), RpcUtils.CHARSET_UTF8)).toString();
        goto L21
    L27:
        r12 = new StringBuilder().append(r8).append("&");
        goto L28
    L14:
        r11 = new StringBuilder().append(r8).append("&");
    L29:
        return r8;
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = RpcUtils.CHARSET_UTF8;
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String sanitizeUrl(String r3) {
        if (r3 != null) goto L12;
        return null;
    L12:
        URL r1 = new URL(r3);     // Catch: MalformedURLException -> L11
        StringBuffer r4 = new StringBuffer();
        r4.append(r1.getProtocol());
        r4.append("://");
        r4.append(r1.getHost());
        if (r1.getPort() == (-1)) goto L9;
        r4.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r4.append(r1.getPort());
    L9:
        r4.append(r1.getPath());
        return r4.toString();
    L11:
        return null;
    }
}
