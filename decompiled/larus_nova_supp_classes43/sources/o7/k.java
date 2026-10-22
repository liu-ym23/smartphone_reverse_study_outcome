package o7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.annie.Annie;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Context r10) {
        new Handler(Looper.getMainLooper()).post(new j(r10));
    }

    public static Map a(String r10, String r11) {
        if (r10 == null) goto L7;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(((f9.b) Annie.getService$default(f9.b.class, null, 2, null)).getHeaderMap(r10));
        Iterator r1 = ((CopyOnWriteArrayList) p9.a.c).iterator();
    L5:
        if (r1.hasNext() == false) goto L8;
        r0.putAll(((p9.d) r1.next()).a(r10));
    L8:
        if (r11 != null) goto L10;
    L24:
        return r0;
    L10:
        if (TextUtils.isEmpty(r11) == false) goto L12;
        return r0;
    L12:
        JSONObject r12 = new JSONObject(r11);
        Iterator<String> r13 = r12.keys();
    L13:
        if (r13 == null) goto L24;
        if (r13.hasNext() == false) goto L24;
        String r14 = r13.next();     // Catch: Exception -> L23
        String r15 = r12.optString(r14);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r14) == true) goto L13;
        if (TextUtils.isEmpty(r15) == true) goto L13;
        r0.put(r14, r15);     // Catch: Exception -> L23
        goto L13
    L7:
        r0 = new LinkedHashMap();
        goto L8
    }
}
