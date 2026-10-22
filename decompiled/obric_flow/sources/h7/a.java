package h7;

import com.bytedance.salamander.anniex.b0;
import m.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f17285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f17286b = false;

    static {
        b0 r5 = new b0(1000, 9);
        f17285a = r5;
        f17286b = true;
        r5.d = new b(10);
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r7.a.a(i7.a.class) != null) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        throw new ClassCastException();     // Catch: Throwable -> L10
    }

    public static void b(j7.a r5) {
        f17285a.c(r5);
        if (td.b.f22124a == false) goto L5;
        io.reactivex.exceptions.a.m("APM-CommonEvent", "cached CommonEvent:" + r5);
    L5:
        a();
    }

    public static void c(j7.a r5) {
        if (td.b.f22124a == false) goto L9;
        StringBuilder r10 = new StringBuilder("trace_data:");
        JSONArray r11 = (JSONArray) r5.f18266b;
        JSONObject r12 = new JSONObject().put("wrapper_array_data", r11);     // Catch: Exception -> L7
        r12.put("log_type", "tracing");     // Catch: Exception -> L7
        r12.put("wrapper_type_description", 1);     // Catch: Exception -> L7
    L8:
        r10.append(r12);
        io.reactivex.exceptions.a.m("APM-CommonEvent", r10.toString());
    L7:
        r12 = null;
    L9:
        p7.a.a(r5);
    }
}
