package com.bytedance.android.live.revlink.impl.pk.transfer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiFeedUtils;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.StrictMeasureData;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import cy0.c;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import oq2.e;
import rc0.f;
import rc0.j;
import rc0.n;
import rc0.o;
import rc0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements f {
    public c a;
    public final StreamLayoutManager b;
    public boolean c;
    public String d;
    public j e;
    public AbsLivePlayerView f;
    public p g;
    public p h;
    public IRoom i;
    public final CompositeDisposable j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public final Lazy o;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.transfer.a$a, reason: collision with other inner class name */
    public static final class C0176a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            sh6.b r9 = (sh6.b) r8;
            a r10 = this.a;
            if (r10.c == false) goto L47;
            ld.a r0 = r10.j();
            if (r0 == null) goto L48;
            AbsLivePlayerView r1 = r10.f;
            if (r1 == null) goto L49;
            oq2.b r2 = (oq2.b) r0.zn().getValue();
            String r3 = null;
            if (r2 == null) goto L14;
            Boolean r4 = Boolean.valueOf(r2.d);
        L15:
            if (r2 == null) goto L17;
            Boolean r5 = Boolean.valueOf(r2.c);
        L18:
            if (r2 == null) goto L20;
            String r6 = r2.a;
        L21:
            if (r2 == null) goto L24;
            r3 = r2.b;
        L24:
            if (Intrinsics.areEqual(r4, Boolean.valueOf(r10.m)) == true) goto L26;
        L32:
            r10.k(r1, true, true, r10.h);
            boolean r7 = false;
            if (r4 == null) goto L35;
            boolean r12 = r4.booleanValue();
        L36:
            r10.m = r12;
            if (r5 == null) goto L39;
            r7 = r5.booleanValue();
        L39:
            r10.n = r7;
            if (r6 != null) goto L42;
            r6 = d51.c.A0.k();
        L42:
            r10.k = r6;
            if (r3 != null) goto L45;
            r3 = d51.c.A0.j();
        L45:
            r10.l = r3;
            return;
        L35:
            r12 = false;
            goto L36
        L26:
            if (Intrinsics.areEqual(r5, Boolean.valueOf(r10.n)) == false) goto L32;
            if (Intrinsics.areEqual(r6, r10.k) == false) goto L32;
            if (Intrinsics.areEqual(r3, r10.l) == false) goto L32;
            return;
        L20:
            r6 = null;
            goto L21
        L17:
            r5 = null;
            goto L18
        L14:
            r4 = null;
            goto L15
        L49:
            return;
        L48:
            return;
        }
    }

    static {
    }

    public final void d() {
        this.j.clear();
    }

    public final Pair<Integer, Integer> h() {
        String r0 = this.d;
        if (r0 != null) goto L5;
        return null;
    L5:
        RevSeiFrame r1 = RevSeiFrame.a.a(RevSeiFrame.G, r0, false, 6);
        if (((Boolean) r1.o.getValue()).booleanValue() == false) goto L12;
        n0 r2 = r1.g();
        if (r2 != null) goto L11;
        return null;
    L11:
        return TuplesKt.to(Integer.valueOf(r2.f()), Integer.valueOf(r2.e()));
    L12:
        return null;
    }

    public final ld.a j() {
        c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ld.a) m.e.d(r0, ld.a.class);
    }

    public a() {
        this.b = new StreamLayoutManager(new PkPlayerProxy$layoutMgr$1(this));
        TuplesKt.to(0, 0);
        this.j = new CompositeDisposable();
        d51.c r0 = d51.c.A0;
        this.k = r0.k();
        this.l = r0.j();
        this.o = LazyKt.lazy(PkPlayerProxy$isEnterOpt$2.INSTANCE);
    }

    public final void e() {
        ld.a r0 = j();
        if (r0 != null) goto L5;
        return;
    L5:
        RxUtilKt.c(ld.c.a(r0.zn()).subscribe(new b(this)), this.j);
    }

    public final boolean c() {
        return this.c;
    }

    public final void E(cy0.a r3) {
        if (r3 == null) goto L6;
        xq2.a r0 = (xq2.a) m.e.d(r3, xq2.a.class);
        if (r0 == null) goto L6;
        c r1 = r0.c0();
    L7:
        if (r1 == null) goto L9;
        this.a = r1;
    L9:
        this.b.E(r3);
        return;
    L6:
        r1 = null;
        goto L7
    }

    public final void a(AbsLivePlayerView r4) {
        Intrinsics.checkNotNullParameter(r4, "playerView");
        this.b.q1();
        this.h = null;
        this.g = null;
        k(r4, false, false, null);
        this.f = null;
        this.c = false;
        this.d = null;
        this.e = null;
        TuplesKt.to(0, 0);
    }

    public final void b(AbsLivePlayerView r2) {
        Intrinsics.checkNotNullParameter(r2, "playerView");
        if ((r2 instanceof AbsLivePlayerView) == true) goto L5;
        return;
    L5:
        int r0 = MultiFeedUtils.a;
        MultiFeedUtils.b(r2);
        this.b.q1();
    }

    public final void l(AbsLivePlayerView r6, p r7) {
        ViewGroup.LayoutParams r0 = r6.getRenderView().getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r7, this.g) == false) goto L11;
        return;
    L11:
        jy0.b.c("PkPlayerProxy", "do updateLayout " + r7, null, 4);
        r6.getRenderView().setScaleType(4);
        r6.getRenderView().setStrictMeasureData(new StrictMeasureData(r7.a, r7.b));
        r1.width = r7.a;
        r1.height = r7.b;
        r1.gravity = 51;
        r1.topMargin = r7.d;
        r1.leftMargin = r7.c;
        r6.getRenderView().setLayoutParams(r1);
        this.g = r7;
    }

    public final void g(j r4, IRoom r5, Pair<Integer, Integer> r6) {
        Intrinsics.checkNotNullParameter(r4, "param");
        Intrinsics.checkNotNullParameter(r6, "videoSize");
        o r7 = i(r4.getContext(), r4.a, r4.c, r5, r6);
        View r0 = r4.b;
        if ((r0 instanceof AbsLivePlayerView) == true) goto L5;
        r0 = null;
    L5:
        AbsLivePlayerView r1 = (AbsLivePlayerView) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        p r8 = this.b.b(r4.d, r7);
        if (r8 != null) goto L11;
        return;
    L11:
        l(r1, r8);
        this.c = true;
        this.d = r4.d;
        this.e = r4;
        this.i = r5;
        this.f = r1;
    }

    public final void k(View r10, boolean r12, boolean r13, p r14) {
        if ((r10 instanceof AbsLivePlayerView) == true) goto L5;
        return;
    L5:
        if (r12 == true) goto L7;
    L26:
        int r15 = MultiFeedUtils.a;
        MultiFeedUtils.b((FrameLayout) r10);
        return;
    L7:
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L26;
        ld.a r16 = j();
        if (r14 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(this.h, r14) == false) goto L15;
        return;
    L15:
        if (PadConfigUtils.c() == false) goto L24;
        if (r16 == null) goto L24;
        NextLiveData r17 = r16.Rm();
        if (r17 == null) goto L24;
        e r18 = (e) r17.getValue();
        if (r18 == null) goto L24;
        if (r18.d == true) goto L24;
        int r19 = MultiFeedUtils.a;
        int r110 = r14.c;
        MultiFeedUtils.f((FrameLayout) r10, r110, r14.a + r110, MultiFeedUtils.ViewIndex.INDEX_FRONT);
    L25:
        this.h = r14;
        return;
    L24:
        int r111 = MultiFeedUtils.a;
        int r1 = r14.d;
        MultiFeedUtils.d((FrameLayout) r10, r1, r1 + r14.b, MultiFeedUtils.ViewIndex.INDEX_FRONT, this.k, this.l, r13, this.n, this.m);
        goto L25
    }

    public static o i(Context r16, boolean r17, LiveMode r18, IRoom r19, Pair r20) {
        DeviceType r0 = rc0.b.a();
        int r1 = s1.y();
        int r3 = k31.p.a(r16, r17, true);
        boolean r5 = false;
        if (r3 <= r1) goto L5;
        boolean r6 = true;
    L6:
        if (r17 == r6) goto L8;
        int r8 = r1;
        int r7 = r3;
    L9:
        boolean r4 = n.a(r0);
        Intrinsics.checkNotNullParameter(r0, "$this$isFoldFull");
        if (r0 != DeviceType.FOLD_FULL) goto L12;
        r5 = true;
    L12:
        boolean r9 = r5;
        return new o(null, r4, r9, r17, r19, false, r7, r8, ((Number) r20.getFirst()).intValue(), ((Number) r20.getSecond()).intValue(), r18, r16, null, 24576);
    L8:
        r7 = r1;
        r8 = r3;
        goto L9
    L5:
        r6 = false;
        goto L6
    }

    public final boolean f(Context r2, String r3, LiveMode r4, boolean r5, IRoom r6, Pair<Integer, Integer> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sei");
        Intrinsics.checkNotNullParameter(r4, "liveMode");
        Intrinsics.checkNotNullParameter(r7, "videoSize");
        o r8 = i(r2, r5, r4, r6, r7);
        return this.b.a(r3, r8);
    }
}
