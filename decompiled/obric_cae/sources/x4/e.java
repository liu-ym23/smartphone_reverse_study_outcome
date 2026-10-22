package x4;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f13409a = null;

    static {
        f13409a = new String[]{WsConstants.KEY_APP_ID, "app_version", "tt_data", "device_id", "bd_did"};
    }

    public static boolean a(b0 r8, String r10, boolean r11, y r12, boolean r13) {
        StringBuilder r14 = new StringBuilder(r10);
        HashMap r15 = new HashMap();
        wd.b.c().a(new d(r13));     // Catch: Throwable -> L5
    L7:
        JSONObject r16 = null;
        f5.a r17 = new f5.a(r10, 200, null, r8.get(c(r14.toString(), r11, r12), r15));     // Catch: Exception -> L13
        r17.toString();     // Catch: Exception -> L11
        int r18 = r.f13543a;     // Catch: Exception -> L11
    L16:
        if (r17 != null) goto L33;
    L25:
        if (r16 != null) goto L27;
    L29:
        return false;
    L27:
        if ("success".equals(r16.optString("message", "")) == false) goto L29;
        return true;
    L33:
        JSONObject r19 = new JSONObject((String) r17.f7328e);     // Catch: JSONException -> L22
        r19.toString();     // Catch: JSONException -> L20
        r16 = r19;
    L20:
        JSONException e10 = e;
        r16 = r19;
    L24:
        r17.toString();
        int r20 = r.f13543a;
        e10.printStackTrace();
    L22:
        e = move-exception;
        e10 = e;
    L11:
        e = e;
    L15:
        int r21 = r.f13543a;
        e.printStackTrace();
    L13:
        e = e;
        r17 = null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public static void b(StringBuilder r8, String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        if (r8.toString().indexOf(63) >= 0) goto L10;
        String r12 = "?";
    L11:
        r8.append(r12);
        r8.append(r10);
        r8.append("=");
        r8.append(Uri.encode(r11));
        return;
    L10:
        r12 = "&";
        goto L11
    }

    public static String c(String r8, boolean r10, y r11) {
        if (TextUtils.isEmpty(r8) == true) goto L21;
        Uri r12 = Uri.parse(r8);
        String r13 = r12.getQuery();
        ArrayList r14 = new ArrayList();
        String[] r15 = f13409a;
        int r16 = 0;
    L6:
        if (r16 >= 5) goto L11;
        String r17 = r15[r16];
        String r18 = r12.getQueryParameter(r17);
        if (TextUtils.isEmpty(r18) == true) goto L10;
        r14.add(new Pair(r17, r18));
    L10:
        r16 = r16 + 1;
        goto L6
    L11:
        Uri.Builder r19 = r12.buildUpon();
        r19.clearQuery();
        Iterator r20 = r14.iterator();
    L13:
        if (r20.hasNext() == false) goto L15;
        Pair r21 = (Pair) r20.next();
        r19.appendQueryParameter((String) r21.first, (String) r21.second);
        goto L13
    L15:
        r19.appendQueryParameter("tt_info", new String(Base64.encode(e(r13, r10, r11), 8)));
        return r19.build().toString();
    L21:
        return r8;
    }

    public static f5.a d(b0 r8, String r10, JSONObject r11, boolean r12, y r13, boolean r14, List r15) {
        HashMap r16 = new HashMap();
        wd.b.c().a(new d(r14));     // Catch: Throwable -> L5
    L7:
        if (r12 == false) goto L9;
        String r17 = "application/octet-stream;tt-data=a";
    L10:
        r16.put("Content-Type", r17);
        if (r15 != null) goto L13;
    L18:
        f5.a r18 = null;
        byte[] r19 = e(r11.toString(), r12, r13);     // Catch: Exception -> L28
        if (r19 == null) goto L23;
        if (r12 == false) goto L23;
        r10 = r10 + "&tt_data=a";     // Catch: Exception -> L28
    L23:
        f5.a r20 = new f5.a(r10, 200, null, r8.post(r10, r19, r16));     // Catch: Exception -> L28
        r20.toString();     // Catch: Exception -> L26
        int r21 = r.f13543a;     // Catch: Exception -> L26
        return r20;
    L26:
        e = e;
        r18 = r20;
    L29:
        int r22 = r.f13543a;
        e.printStackTrace();
        return r18;
    L28:
        e = e;
        goto L29
    L13:
        if (r15.size() <= 0) goto L18;
        int r23 = 0;
    L16:
        if (r23 >= r15.size()) goto L18;
        Pair r24 = (Pair) r15.get(r23);
        r16.put(r24.first, r24.second);
        r23 = r23 + 1;
        goto L16
    L9:
        r17 = "application/json; charset=utf-8";
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public static byte[] e(String r8, boolean r10, y r11) {
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r13 = null;
        if (r10 == false) goto L8;
        GZIPOutputStream r14 = new GZIPOutputStream(r12);     // Catch: Throwable -> L27
        r14.write(r8.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r13 = r14;
    L9:
        if (r13 != null) goto L34;
    L16:
        byte[] r15 = r12.toByteArray();
        if (r10 == false) goto L38;
        if (r11 != null) goto L20;
        return r15;
    L20:
        return r11.a(r15.length, r15);
    L38:
        return r15;
    L34:
        r13.close();     // Catch: IOException -> L15
    L15:
        int r16 = r.f13543a;
    L7:
        r13 = r14;
        goto L36
    L8:
        r12.write(r8.getBytes("UTF-8"));     // Catch: Throwable -> L27
    L36:
        int r17 = r.f13543a;     // Catch: Throwable -> L21
        if (r13 == null) goto L16;
    L21:
        th = move-exception;
        if (r13 != null) goto L28;
    L26:
        throw th;
    L28:
        r13.close();     // Catch: IOException -> L25
    L25:
        int r18 = r.f13543a;
        goto L26
    }
}
