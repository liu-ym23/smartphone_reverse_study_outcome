package l7a;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class c {
    public volatile boolean a;
    public final String b;

    public final boolean a() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.a == false) goto L10;
        LLog.e("LynxResourceLoader", "Illegal callback invocation from native. The loaded callback can only be invoked once! The url is " + this.b);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return false;
    L10:
        this.a = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return true;
    }

    public c(String r2) {
        this.a = false;
        this.b = r2;
    }
}
