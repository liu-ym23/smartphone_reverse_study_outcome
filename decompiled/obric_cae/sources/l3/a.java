package l3;

import g3.b;
import g3.e;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f9130b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f9131a;

    public a() {
        new CopyOnWriteArraySet();
        this.f9131a = new ConcurrentHashMap();
    }

    public static a a() {
        if (f9130b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9130b != null) goto L9;
        f9130b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9130b;
    }

    public final JSONObject b() {
        JSONObject r8 = new JSONObject();
        Iterator<Map.Entry<String, String>> r10 = this.f9131a.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<String, String> r11 = r10.next();     // Catch: JSONException -> L9
        r8.put(r11.getKey(), r11.getValue());     // Catch: JSONException -> L9
    L8:
        return r8;
    }

    public final JSONObject c(boolean r8) {
        JSONObject r10 = new JSONObject();
        Iterator<Map.Entry<String, String>> r11 = this.f9131a.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r11.hasNext() == false) goto L7;
        Map.Entry<String, String> r12 = r11.next();     // Catch: JSONException -> L11
        r10.put(r12.getKey(), r12.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r10.put("RealRefreshRate", String.valueOf(e.f7629a));     // Catch: JSONException -> L11
        r10.put("RealMaxRefreshRate", String.valueOf(e.f7629a));     // Catch: JSONException -> L11
        if (r8 == false) goto L10;
        b r13 = b.a.f7628a;     // Catch: JSONException -> L11
        r13.getClass();     // Catch: JSONException -> L11
        r13.getClass();     // Catch: JSONException -> L11
    L10:
        return r10;
    }
}
