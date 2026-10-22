package z;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f13729b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p0.a<JSONObject> f13730a;

    private a() {
        this.f13730a = new p0.a(20);
    }

    public static a b() {
        if (f13729b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13729b != null) goto L9;
        f13729b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f13729b;
    }

    public void a(JSONObject r10) {
        this.f13730a.a(r10);
    }

    public List<JSONObject> c() {
        return this.f13730a.b();
    }
}
