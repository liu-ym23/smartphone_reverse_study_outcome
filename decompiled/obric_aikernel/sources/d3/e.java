package d3;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.bytedance.frameworks.baselib.network.a.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile e f8468d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f8469c;

    public e(int r10) {
        super(r10);
        this.f8469c = new AtomicBoolean(false);
    }

    public static e f() {
        if (f8468d != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8468d != null) goto L9;
        f8468d = new e(30000);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f8468d;
    }

    @Override // com.bytedance.frameworks.baselib.network.a.b
    public void c() {
        this.f8469c.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.a.b
    public void d() {
        this.f8469c.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
        return;
    }

    public void g(JSONObject r10) {
        e(r10.optInt("qf_enter_background_time", 30000));
    }
}
