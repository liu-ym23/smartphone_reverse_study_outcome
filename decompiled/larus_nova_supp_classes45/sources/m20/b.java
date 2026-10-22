package m20;

import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ XplayPerfPanelView a;

    public b(XplayPerfPanelView r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<XplayPerfPanelView.c> r12) {
        Intrinsics.checkNotNullParameter(r12, "it");
        XplayPerfPanelView r0 = this.a;
        r0.f += r0.n.b();
        XplayPerfPanelView r1 = this.a;
        r1.g += r1.n.c();
        XplayPerfPanelView r2 = this.a;
        float r3 = r2.h;
        r2.n.getClass();
        IHostPerformanceMonitor r4 = (IHostPerformanceMonitor) OpenPlatformPerfDog.f.getValue();
        if (r4 == null) goto L5;
        float r5 = (float) r4.getGpuUsage();
    L6:
        r2.h = r3 + r5;
        XplayPerfPanelView r6 = this.a;
        r6.i += r6.n.a();
        XplayPerfPanelView r7 = this.a;
        r7.j += r7.n.getUIStallRate();
        XplayPerfPanelView r8 = this.a;
        r8.k = Math.max(r8.k, r8.n.d());
        XplayPerfPanelView r9 = this.a;
        int r11 = r9.l + 1;
        r9.l = r11;
        String r13 = XplayPerfPanelView.a(r9, r9.g, r11);
        XplayPerfPanelView r14 = this.a;
        String r15 = XplayPerfPanelView.a(r14, r14.h, r14.l);
        XplayPerfPanelView r16 = this.a;
        String r17 = XplayPerfPanelView.a(r16, r16.i, r16.l);
        XplayPerfPanelView r18 = this.a;
        String r19 = XplayPerfPanelView.a(r18, r18.j, r18.l);
        XplayPerfPanelView r21 = this.a;
        String r22 = XplayPerfPanelView.a(r21, r21.f, r21.l);
        XplayPerfPanelView r23 = this.a;
        r12.onNext(new XplayPerfPanelView.c(r13, r15, r17, r19, r22, XplayPerfPanelView.a(r23, r23.k, 1)));
        r12.onComplete();
        return;
    L5:
        r5 = -1.0f;
        goto L6
    }
}
