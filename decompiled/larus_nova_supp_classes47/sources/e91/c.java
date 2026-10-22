package e91;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;
import yt1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements m {
    public final /* synthetic */ d a;
    public final /* synthetic */ n b;
    public final /* synthetic */ ViewGroup c;

    public final void onFetchSuccess() {
    }

    public c(d r1, n r2, ViewGroup r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(com.bytedance.android.livesdk.dslservice.a r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "loadFrom");
        Intrinsics.checkNotNullParameter(r7, "loadFrom");
        if (this.a.m == false) goto L5;
        return;
    L5:
        ALogger.i("DslLabelController", "加载成功");
        if (r5 == null) goto L30;
        View r8 = r5.getView();
        if (r8 == null) goto L30;
        ALogger.i("DslLabelController", "measureWidth:" + r8.getMeasuredWidth() + " width:" + r8.getWidth());
        int r9 = r8.getWidth();
        d r0 = this.a;
        if (r9 <= r0.c) goto L12;
        int r10 = r8.getWidth();
    L13:
        int r1 = r8.getHeight();
        d r2 = this.a;
        if (r1 <= r2.d) goto L16;
        int r12 = r8.getHeight();
    L17:
        ViewGroup r3 = this.c;
        if (r3 == null) goto L20;
        a1.k(r3, r12);
    L20:
        ViewGroup r13 = this.c;
        if (r13 == null) goto L23;
        a1.p(r13, r10);
    L23:
        aa1.a r14 = this.a.n.b();
        if (r14 == null) goto L30;
        ElementMiddleVM r15 = r14.getMiddleVm();
        if (r15 == null) goto L30;
        com.bytedance.live.datacontext.m<Integer> r16 = r15.getDslLabelWidth();
        if (r16 == null) goto L30;
        r16.setValue(Integer.valueOf(r10));
        goto L30
    L16:
        r12 = r2.f;
        goto L17
    L12:
        r10 = r0.e;
    L30:
        d r17 = this.a;
        String r18 = "startTime:" + this.a.k + ", costDuration:" + (System.currentTimeMillis() - this.a.k);
        r17.getClass();
        if (v.a() == false) goto L34;
        ALogger.i("DslLabelController", r18);
        return;
    }

    public final void b(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "reason");
        m.a.a(r1, r2);
    }
}
