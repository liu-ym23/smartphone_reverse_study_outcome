package ai;

import android.os.SystemClock;
import com.bytedance.retrofit2.SsHttpCall;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SsHttpCall f285c;

    public n0(SsHttpCall r5, h.a r10, m0 r11) {
        this.f285c = r5;
        this.f283a = r10;
        this.f284b = r11;
    }

    @Override // ai.r0
    public final int m() {
        return 0;
    }

    @Override // ai.r0
    public final int n() {
        return SsHttpCall.access$300(this.f285c).e;
    }

    @Override // ai.r0
    public final boolean q() {
        return SsHttpCall.access$300(this.f285c).f268h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SsHttpCall r5 = this.f285c;
    L7:
        th = move-exception;
        SsHttpCall.access$002(r5, th);
    L9:
        m0 r10 = this.f284b;
        this.f283a.execute(r10);
        return;
    L4:
        if (SsHttpCall.access$100(r5) != null) goto L9;
        i0 r11 = SsHttpCall.access$300(r5).f279t;     // Catch: Throwable -> L7
        r11.f229q = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        SsHttpCall.access$102(r5, SsHttpCall.access$300(r5).b(SsHttpCall.access$200(r5)));     // Catch: Throwable -> L7
        r11.f230r = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        goto L9
    }
}
