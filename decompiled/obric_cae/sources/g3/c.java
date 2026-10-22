package g3;

import android.text.TextUtils;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static u8.b a(String r8, List<File> r10, Map<String, String> r11) {
        IHttpService r12 = (IHttpService) e8.c.a(IHttpService.class);     // Catch: Exception -> L30
        if (r12 != null) goto L5;
        r12 = new DefaultHttpServiceImpl();     // Catch: Exception -> L30
    L5:
        u8.e r13 = r12.buildMultipartUpload(r8, "UTF-8", false);     // Catch: Exception -> L30
        if (r10 != null) goto L8;
    L15:
        if (r11 != null) goto L17;
    L22:
        String r14 = new String(r13.finish().f12521b);     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r14) == true) goto L40;
        JSONObject r15 = new JSONObject(r14);     // Catch: JSONException -> L26 Exception -> L30
        return new u8.b(r15.optInt("error_code", 0), r15.optString("message", "").getBytes());
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        return null;
    L40:
        return null;
    L17:
        if (r11.isEmpty() == true) goto L22;
        Iterator<Map.Entry<String, String>> r16 = r11.entrySet().iterator();     // Catch: Exception -> L30
    L20:
        if (r16.hasNext() == false) goto L22;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Exception -> L30
        r13.b(r17.getKey(), r17.getValue());     // Catch: Exception -> L30
        goto L20
    L8:
        if (r10.isEmpty() == true) goto L15;
        Iterator<File> r18 = r10.iterator();     // Catch: Exception -> L30
    L11:
        if (r18.hasNext() == false) goto L15;
        File r19 = r18.next();     // Catch: Exception -> L30
        if (r19.exists() == false) goto L11;
        HashMap r20 = new HashMap();     // Catch: Exception -> L30
        r13.a(r19.getName(), r19, r20);     // Catch: Exception -> L30
    L41:
        return null;
    }
}
