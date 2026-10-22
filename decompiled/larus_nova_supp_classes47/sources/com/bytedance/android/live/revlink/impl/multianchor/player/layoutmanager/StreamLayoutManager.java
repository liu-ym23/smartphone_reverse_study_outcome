package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.player.d;
import com.bytedance.android.live.revlink.impl.player.e;
import com.bytedance.android.live.revlink.impl.player.g;
import com.bytedance.android.live.revlink.impl.player.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import k31.k;
import k31.l;
import kc0.u;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rc0.i;
import rc0.o;
import rc0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class StreamLayoutManager implements i {
    public d a;
    public g b;
    public rc0.g c;
    public final CompositeDisposable d;
    public k31.a e;
    public k f;
    public cy0.c g;
    public cy0.a h;
    public boolean i;
    public com.bytedance.android.live.revlink.impl.player.a j;
    public final b k;
    public final Function1<p, Unit> l;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ StreamLayoutManager a;

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final h c() {
            rc0.g r0 = this.a.c;
            if (r0 == null) goto L7;
            p r1 = r0.b();
            if (r1 == null) goto L7;
            return new h(r1.a, r1.b, r1.c, r1.d);
        L7:
            return null;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final void disable() {
            rc0.g r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.disable();
            return;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final boolean isEnabled() {
            rc0.g r0 = this.a.c;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isEnabled() != true) goto L7;
            return true;
        }

        public b(StreamLayoutManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final boolean O(String r2) {
            rc0.g r0 = this.a.c;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.O(r2) != true) goto L7;
            return true;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final void a(int r2) {
            rc0.g r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final h b(String r5, h r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "multiLayoutData");
            int r1 = r6.c;
            int r2 = r6.d;
            Rect r0 = new Rect(r1, r2, r6.a + r1, r6.b + r2);
            rc0.g r8 = this.a.c;
            if (r8 == null) goto L7;
            p r9 = r8.c(r5, r0, r7);
            if (r9 == null) goto L7;
            return new h(r9.a, r9.b, r9.c, r9.d);
        L7:
            return null;
        }
    }

    static {
    }

    public final void q1() {
        d r0 = this.a;
        if (r0 == null) goto L5;
        r0.q1();
    L5:
        g r1 = this.b;
        if (r1 == null) goto L8;
        r1.q1();
    L8:
        this.d.clear();
    }

    public StreamLayoutManager(Function1<? super p, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "requestLayout");
        this.l = r2;
        this.d = new CompositeDisposable();
        this.k = new b(this);
    }

    public final void E(cy0.a r4) {
        this.h = r4;
        if (r4 == null) goto L7;
        xq2.a r5 = (xq2.a) m.e.d(r4, xq2.a.class);
        if (r5 == null) goto L7;
        cy0.c r6 = r5.c0();
    L8:
        if (r6 == null) goto L11;
        this.g = r6;
        this.j = new com.bytedance.android.live.revlink.impl.player.a((ld.a) m.e.d(r6, ld.a.class));
        return;
    L11:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public final d c(o r3) {
        boolean r4 = r3.f;
        if (r4 == false) goto L7;
        g r0 = this.b;
        if (r0 == null) goto L7;
        return r0;
    L7:
        if (r4 == false) goto L9;
        g r1 = new g();
        this.b = r1;
        return r1;
    L9:
        d r2 = this.a;
        if (r2 != null) goto L20;
        cy0.a r5 = this.h;
        if (r5 == null) goto L15;
        d r6 = (d) m.e.d(r5, d.class);
    L16:
        d r7 = r6;
        this.a = r7;
        return r7;
    L15:
        r6 = null;
        goto L16
    L20:
        return r2;
    }

    public final void d(final o r14) {
        d r0 = c(r14);
        if (r0 == null) goto L87;
        Intrinsics.checkNotNullParameter(r14, "$this$getDeviceType");
        boolean r1 = r14.b;
        if (r1 == true) goto L7;
    L9:
        if (r1 == false) goto L14;
        if (r14.d == true) goto L14;
        DeviceType r2 = DeviceType.PAD_H;
    L17:
        boolean r3 = false;
        if (r2 != DeviceType.FOLD_FULL) goto L20;
        boolean r4 = true;
    L21:
        r0.k(r4);
        r0.d(r14.d);
        r0.j(r14.g);
        r0.f(r14.i);
        r0.w(r14.j);
        r0.o(r14.f);
        r0.c(r14.b);
        Intrinsics.checkNotNullParameter(r14, "$this$isLiveTypeAudio");
        IRoom r5 = r14.e;
        if (r5 == null) goto L24;
        boolean r6 = r5.isLiveTypeAudio();
    L25:
        r0.q(r6);
        Intrinsics.checkNotNullParameter(r14, "$this$isScreenRecord");
        IRoom r7 = r14.e;
        if (r7 == null) goto L28;
        LiveMode r8 = r7.getStreamType();
    L30:
        if (r8 != LiveMode.SCREEN_RECORD) goto L32;
        boolean r9 = true;
    L33:
        r0.g(r9);
        Intrinsics.checkNotNullParameter(r14, "$this$isPcVrRoom");
        IRoom r10 = r14.e;
        if (r10 != null) goto L36;
    L42:
        r0.n(r3);
        r0.s(r14.k);
        rc0.a r12 = r14.n;
        if (r12 == null) goto L77;
        com.bytedance.android.live.revlink.impl.player.a r13 = this.j;
        if (r13 == null) goto L74;
        Pair r15 = TuplesKt.to(Integer.valueOf(r14.g), Integer.valueOf(r14.h));
        h r16 = this.k.c();
        if (r16 == null) goto L51;
        Float r17 = Float.valueOf(r16.a / r16.b);
        if ((!Float.isNaN(r17.floatValue())) == false) goto L51;
    L52:
        Pair r18 = TuplesKt.to(Integer.valueOf(r12.b), Integer.valueOf(r12.c));
        int r19 = r12.a;
        Intrinsics.checkNotNullParameter(r15, "inWHInfo");
        Intrinsics.checkNotNullParameter(r18, "bottomInfo");
        d51.c r20 = d51.c.A0;
        r20.getClass();
        if (((Boolean) d51.c.s.getValue(r20, d51.c.a[17])).booleanValue() == false) goto L72;
        if (r17 == null) goto L72;
        if (r19 == 1) goto L66;
        if (r19 == 2) goto L60;
        int r22 = ((Number) r15.getSecond()).intValue();
    L73:
        Integer r23 = Integer.valueOf(r22);
    L75:
        if (r23 == null) goto L77;
        int r24 = r23.intValue();
    L85:
        r0.a(r24);
        r0.h(new StreamLayoutManager$updateLayoutCore$$inlined$run$lambda$1(this, r14));
        Unit r110 = Unit.INSTANCE;
        return;
    L60:
        float r25 = r17.floatValue();
        float r26 = ((Number) r18.getFirst()).floatValue() / ((Number) r18.getSecond()).intValue();
        float r27 = (((Number) r15.getSecond()).floatValue() * r26) / (r25 + r26);
        float r28 = r25 * r27;
        float r29 = (((Number) r15.getFirst()).floatValue() - r28) / 2.0f;
        RectF r30 = new RectF(r29, 0.0f, r29 + r28, r27);
        kc0.a r32 = new kc0.a(r29, r27, r28, r28 / r26);
        ld.a r33 = r13.a;
        if (r33 == null) goto L65;
        NextLiveData r34 = r33.Le();
        if (r34 == null) goto L65;
        r34.setValue(new u(r32, new kc0.a(r30.left, r30.top, r30.width(), r30.height())));
    L65:
        r22 = (int) r27;
        goto L73
    L66:
        float r35 = r17.floatValue();
        float r36 = ((Number) r15.getSecond()).floatValue() - ((Number) r18.getSecond()).intValue();
        float r37 = r35 * r36;
        float r38 = (((Number) r15.getFirst()).floatValue() - r37) / 2.0f;
        RectF r39 = new RectF(r38, 0.0f, r38 + r37, r36);
        kc0.a r40 = new kc0.a(r38, r36, r37, ((Number) r18.getSecond()).intValue());
        ld.a r42 = r13.a;
        if (r42 == null) goto L71;
        NextLiveData r43 = r42.Le();
        if (r43 == null) goto L71;
        r43.setValue(new u(r40, new kc0.a(r39.left, r39.top, r39.width(), r39.height())));
    L71:
        r22 = (int) r36;
    L72:
        r22 = ((Number) r15.getSecond()).intValue();
    L51:
        r17 = null;
        goto L52
    L74:
        r23 = null;
    L77:
        com.bytedance.android.live.revlink.impl.player.a r44 = this.j;
        if (r44 == null) goto L84;
        ld.a r45 = r44.a;
        if (r45 == null) goto L84;
        NextLiveData r46 = r45.Le();
        if (r46 == null) goto L84;
        r46.setValue(null);
    L84:
        r24 = r14.h;
        goto L85
    L36:
        if (r10.isThirdParty() != true) goto L42;
        if (r10.getVRType() != 1) goto L40;
    L41:
        r3 = true;
        goto L42
    L40:
        if (r10.getVRType() != 2) goto L42;
    L32:
        r9 = false;
        goto L33
    L28:
        r8 = null;
        goto L30
    L24:
        r6 = false;
        goto L25
    L20:
        r4 = false;
    L14:
        if (r14.c == false) goto L16;
        r2 = DeviceType.FOLD_FULL;
        goto L17
    L16:
        r2 = DeviceType.NORMAL_MOBILE;
        goto L17
    L7:
        if (r14.d == false) goto L9;
        r2 = DeviceType.PAD_V;
        goto L17
    }

    public final boolean a(String r6, o r7) {
        Intrinsics.checkNotNullParameter(r6, "sei");
        Intrinsics.checkNotNullParameter(r7, "layoutContextExternal");
        d r0 = c(r7);
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        r0.me(this.k);
        this.c = r7.m;
        d(r7);
        boolean r8 = r0.O(r6);
        if (this.i == true) goto L9;
        if (r8 == false) goto L9;
        this.i = true;
        PublishSubject r2 = r0.ml();
        final StreamLayoutManager$shouldDeal$1 r3 = new StreamLayoutManager$shouldDeal$1(this);
        RxUtilKt.c(r2.subscribe(new c(r3)), this.d);
    L9:
        b r4 = this.k;
        if (r8 == false) goto L12;
    L16:
        if (r1 == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L21;
        r4.disable();
    L21:
        return r8;
    L12:
        if (r4.isEnabled() == false) goto L16;
        if (r4.O(r6) == true) goto L16;
        r1 = true;
        goto L16
    }

    public final p b(String r7, o r8) {
        Intrinsics.checkNotNullParameter(r7, "sei");
        Intrinsics.checkNotNullParameter(r8, "layoutContextExternal");
        boolean r2 = true;
        if (r8.f == false) goto L14;
        boolean r0 = r8.d;
        Context r3 = r8.l;
        if (r3 != null) goto L8;
    L12:
        boolean r1 = false;
    L15:
        this.f = new k(r1, StatusBarUtil.getStatusBarHeight(r8.l));
        StringBuilder r4 = new StringBuilder("outer ");
        k r5 = this.f;
        if (r5 == null) goto L18;
        String r6 = l.b(r5);
    L19:
        r4.append(r6);
        r4.append("  context: ");
        r4.append(r8.l);
        r4.append("   ");
        r4.append(r8.f);
        jy0.b.c("xuzr", r4.toString(), null, 4);
        if (r8.f == false) goto L23;
        r8.getClass();
        this.e = null;
    L23:
        d(r8);
        d r9 = c(r8);
        if (r9 == null) goto L29;
        r9.x(this.f);
        r9.i(this.e);
        r9.me(this.k);
        h r10 = r9.handleSei(r7);
        if (r10 == null) goto L30;
        Intrinsics.checkNotNullParameter(r10, "$this$toExternal");
        return new p(r10.a, r10.b, r10.c, r10.d);
    L30:
        return null;
    L29:
        return null;
    L18:
        r6 = null;
        goto L19
    L8:
        if (rc0.b.a() == DeviceType.NORMAL_MOBILE) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L12;
        r1 = k31.p.c(r0, k31.p.b(r3), false);
        goto L15
    L14:
        r1 = k31.p.c(r8.d, k31.p.b(r8.l), true ^ r8.f);
        goto L15
    }
}
