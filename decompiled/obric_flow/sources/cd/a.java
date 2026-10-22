package cd;

import android.util.Log;
import java.util.LinkedHashMap;
import rb.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f1171a = null;

    static {
        f1171a = new LinkedHashMap();
    }

    public static b a(String r5) {
        if (r5 == null) goto L8;
        b r10 = (b) f1171a.get(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return new b();
    L8:
        return new b();
    }

    public static void b(String r5, b r10) {
        LinkedHashMap r11 = f1171a;
        if (r5 == null) goto L7;
        if (r10 != null) goto L6;
        r10 = new b();
    L6:
        r11.put(r5, r10);
    L7:
        Log.d("LeakLeak", "ContextProviderManager register: " + r5 + ' ' + r11.size());
    }

    public static void c(String r5) {
        LinkedHashMap r10 = f1171a;
        if (r5 == null) goto L5;
        r10.remove(r5);
    L5:
        Log.d("LeakLeak", "ContextProviderManager unRegister: " + r5 + ' ' + r10.size());
    }
}
