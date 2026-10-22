package nn;

import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f20274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20275b;

    public c(String r5) {
        this.f20274a = false;
        this.f20275b = r5;
    }

    public final boolean a() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f20274a == false) goto L12;
        LynxLog.b(4, "LynxResourceLoader", "Illegal callback invocation from native. The loaded callback can only be invoked once! The url is " + this.f20275b);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    L12:
        this.f20274a = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    }
}
