package ai;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.retrofit2.SsHttpCall;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SsHttpCall f282b;

    public m0(SsHttpCall r5, i0 r10) {
        this.f282b = r5;
        this.f281a = r10;
    }

    @Override // ai.r0
    public final int m() {
        int r5 = 0;
        if (SsHttpCall.access$600() == null) goto L24;
        boolean r10 = SsHttpCall.access$600().a();
        SsHttpCall r11 = this.f282b;
        if (r10 == false) goto L12;
        if (SsHttpCall.access$100(r11) == null) goto L24;
        if (TextUtils.isEmpty(SsHttpCall.access$100(r11).getPath()) == true) goto L24;
        r5 = SsHttpCall.access$600().e(SsHttpCall.access$100(r11).getPath());
        goto L24
    L12:
        if (SsHttpCall.access$600().d() == false) goto L24;
        if (SsHttpCall.access$100(r11) == null) goto L24;
        List<bi.c> r12 = SsHttpCall.access$100(r11).headers("x-tt-request-tag");
        if (r12 != null) goto L18;
    L22:
        String r13 = "";
    L23:
        r5 = SsHttpCall.access$600().c(SsHttpCall.access$100(r11).getUrl(), r13);
        goto L24
    L18:
        if (r12.size() < 1) goto L22;
        if (TextUtils.isEmpty(r12.get(0).f916b) == true) goto L22;
        r13 = r12.get(0).f916b;
    L24:
        this.f281a.f227o = r5;
        return r5;
    }

    @Override // ai.r0
    public final int n() {
        return SsHttpCall.access$300(this.f282b).e;
    }

    @Override // ai.r0
    public final boolean q() {
        return SsHttpCall.access$300(this.f282b).f268h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 r5 = this.f281a;
        SsHttpCall r10 = this.f282b;
    L15:
        throw null;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (SsHttpCall.access$000(r10) != null) goto L14;
        if (SsHttpCall.access$100(r10) != null) goto L8;
        r5.f229q = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        SsHttpCall.access$102(r10, SsHttpCall.access$300(r10).b(SsHttpCall.access$200(r10)));     // Catch: Throwable -> L15
        r5.f230r = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
    L8:
        r10.getResponseWithInterceptorChain();     // Catch: Throwable -> L15
        SsHttpCall.access$400();     // Catch: Throwable -> L15
        throw null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L14:
        throw SsHttpCall.access$000(r10);     // Catch: Throwable -> L15
    }
}
