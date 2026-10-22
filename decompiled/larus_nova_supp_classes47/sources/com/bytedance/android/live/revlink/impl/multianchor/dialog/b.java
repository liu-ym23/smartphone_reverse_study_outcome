package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.kmp.util.e;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public Disposable a;
    public final CompositeDisposable b;
    public final NextLiveData<Long> c;
    public PkBaseStateMachine.c d;
    public q11.b e;
    public final MultiLinkTimeRecorder$pkStateObserver$1 f;
    public final MultiLinkTimeRecorder$multiPkStateObserver$1 g;
    public final com.bytedance.android.live.revlink.impl.global.c h;
    public final x11.a i;
    public final int j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.b$b, reason: collision with other inner class name */
    public static final class C0137b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0137b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            Long r7 = (Long) this.a.c.getValue();
            if (r7 != null) goto L5;
            r7 = 0L;
        L5:
            long r0 = r7.longValue();
            this.a.c.setValue(Long.valueOf(r0 + 1));
        }
    }

    static {
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reqSrc");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.h;
        if (r0 == null) goto L5;
        ProfitInteractionDataContext r1 = r0.vj();
    L7:
        if (r1 != null) goto L9;
    L32:
        jy0.b.c("ttlive_anchor_link_timer", "intercept startTimeRecord " + r8 + ", interactionDataContext not initialized", null, 4);
        return;
    L9:
        if (r1.hasDataInitialized() != true) goto L32;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.h;
        if (r2 == null) goto L14;
        f r3 = r2.getLinkPlayHelper();
    L15:
        if (r3 != null) goto L17;
    L18:
        com.bytedance.android.live.revlink.impl.global.c r4 = this.h;
        if (r4 == null) goto L21;
        f r5 = r4.getLinkPlayHelper();
    L22:
        if (r5 != null) goto L24;
    L27:
        jy0.b.f("ttlive_anchor_link_timer", "startTimeRecord time=" + ((Long) this.c.getValue()) + "s " + r8 + "  serverTime=" + e.b(), null, 4);
        Disposable r9 = this.a;
        if (r9 == null) goto L30;
        r9.dispose();
    L30:
        l r10 = l.a;
        int r12 = p.a;
        this.a = Observable.interval(1000, 1000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0137b(this));
        return;
    L24:
        if (r5.e() != true) goto L27;
    L25:
        jy0.b.c("ttlive_anchor_link_timer", "intercept startTimeRecord " + r8 + ", in pk state", null, 4);
        return;
    L21:
        r5 = null;
        goto L22
    L17:
        if (r3.g() == true) goto L25;
    L14:
        r3 = null;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqSrc");
        jy0.b.f("ttlive_anchor_link_timer", "stopTimeRecord: " + r4 + " time=INVALID_TIME serverTime=" + e.b(), null, 4);
        this.c.setValue(-1L);
        Disposable r5 = this.a;
        if (r5 == null) goto L6;
        r5.dispose();
        return;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.android.live.revlink.impl.multianchor.dialog.MultiLinkTimeRecorder$pkStateObserver$1] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.android.live.revlink.impl.multianchor.dialog.MultiLinkTimeRecorder$multiPkStateObserver$1] */
    public b(d r1, x11.a r2, int r3) {
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.b = new CompositeDisposable();
        this.c = new NextLiveData();
        q11.b r4 = null;
        if (r1 == null) goto L5;
        b0 r5 = r1.Tj();
    L6:
        if (r5 == null) goto L8;
        PkBaseStateMachine.c r6 = r5.e();
    L9:
        this.d = r6;
        if (r1 == null) goto L12;
        q r7 = r1.getPkUtils();
    L13:
        if (r7 == null) goto L15;
        r4 = r7.a();
    L15:
        this.e = r4;
        this.f = new MultiLinkTimeRecorder$pkStateObserver$1(this);
        this.g = new MultiLinkTimeRecorder$multiPkStateObserver$1(this);
        return;
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }
}
