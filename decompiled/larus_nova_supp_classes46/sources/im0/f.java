package im0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends a {
    public final com.bytedance.android.live.messagewindow.framework.process.a e;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.live.messagewindow.framework.process.a r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "action");
        r0.a = this;
    }

    public f(com.bytedance.android.live.messagewindow.framework.process.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(j71.a.f.b);
        this.e = r2;
    }
}
