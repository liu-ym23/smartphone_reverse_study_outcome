package com.bytedance.android.live.revlink.impl.player;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.live.revlink.impl.player.layout.DynamicLayoutCalculate;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements d, c {
    public static final /* synthetic */ int m = 0;
    public final Lazy a;
    public boolean b;
    public boolean c;
    public RevSeiFrame d;
    public final CompositeDisposable e;
    public final DynamicLayoutCalculate f;
    public Disposable g;
    public final PublishSubject<h> h;
    public e i;
    public final cy0.c j;
    public final ld.a k;
    public final i l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void a(int r2) {
        this.l.a(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void c(boolean r2) {
        this.l.c(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void d(boolean r2) {
        this.l.d(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void f(int r2) {
        this.l.f(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void g(boolean r2) {
        this.l.g(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void i(k31.a r2) {
        this.l.i(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void j(int r2) {
        this.l.j(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void k(boolean r2) {
        this.l.k(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void n(boolean r2) {
        this.l.n(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void o(boolean r2) {
        this.l.o(r2);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void q(boolean r2) {
        this.l.q(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void s(LiveMode r2) {
        this.l.s(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void w(int r2) {
        this.l.w(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void x(k31.k r2) {
        this.l.x(r2);
    }

    public final wq2.f E() {
        cy0.c r0 = this.j;
        if (r0 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        return (wq2.f) com.bytedance.android.scope.m.b(r0).b(wq2.f.class);
    L5:
        return null;
    }

    public final void F() {
        ld.a r0 = this.k;
        StringBuilder r1 = new StringBuilder("onMultiAnchorEventChange with event: ");
        k31.a r2 = null;
        if (r0 == null) goto L5;
        NextLiveData r3 = r0.ho();
    L6:
        r1.append(r3);
        jy0.b.c("RevenueLayoutCore", r1.toString(), null, 4);
        if (r0 == null) goto L18;
        NextLiveData r4 = r0.ho();
        if (r4 == null) goto L19;
        gt1.b r5 = (gt1.b) r4.getValue();
        if (r5 == null) goto L20;
        i r6 = this.l;
        if (r5.c() != 1) goto L16;
        r2 = new k31.a(new k31.g(r5.d(), Integer.valueOf(r5.e())), new k31.n(r5.b(), r5.a()));
    L16:
        r6.i(r2);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final void q1() {
        if (this.b == true) goto L5;
        return;
    L5:
        ld.a r0 = this.k;
        if (this.c == false) goto L24;
        this.c = false;
        if (r0 == null) goto L12;
        NextLiveData r1 = r0.O1();
        if (r1 == null) goto L12;
        r1.setValue(Boolean.FALSE);
    L12:
        if (r0 == null) goto L17;
        NextLiveData r2 = r0.a2();
        if (r2 == null) goto L17;
        r2.setValue(0);
    L17:
        if (this.l.i == true) goto L24;
        wq2.f r3 = E();
        if (r3 == null) goto L21;
        r3.Zn(false);
    L21:
        wq2.f r4 = E();
        if (r4 == null) goto L24;
        r4.nj(0);
    L24:
        this.b = false;
        if (r0 == null) goto L29;
        NextLiveData r5 = r0.Rm();
        if (r5 == null) goto L29;
        r5.setValue(null);
    L29:
        Disposable r6 = this.g;
        if (r6 == null) goto L32;
        r6.dispose();
    L32:
        this.g = null;
        this.l.b = true;
        RevSeiFrame.G.getClass();
        this.d = (RevSeiFrame) RevSeiFrame.D.getValue();
        e r7 = this.i;
        if (r7 == null) goto L36;
        r7.a(0);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final PublishSubject ml() {
        return this.h;
    }

    public final h A(String r18) {
        RevSeiFrame r1 = RevSeiFrame.a.a(RevSeiFrame.G, r18, this.l.h, 2);
        this.d = r1;
        jy0.b.c("RevenueLayoutCore", "onLayoutContextChange start with context: " + this.l, null, 4);
        if (this.b == true) goto L25;
        this.b = true;
        jy0.b.c("RevenueLayoutCore", "onBizStart", null, 4);
        com.bytedance.android.live.revlink.impl.settings.live.c r2 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r2.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.k.getValue(r2, com.bytedance.android.live.revlink.impl.settings.live.c.a[9])).booleanValue() == true) goto L16;
        ld.a r3 = this.k;
        if (r3 == null) goto L15;
        NextLiveData r4 = r3.ho();
        if (r4 == null) goto L15;
        Observable r5 = ld.c.a(r4);
        if (r5 == null) goto L15;
        Disposable r6 = r5.subscribe(new l(this));
        if (r6 == null) goto L15;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6, this.e);
    L15:
        F();
    L16:
        ld.a r7 = this.k;
        if (r7 == null) goto L25;
        NextLiveData r8 = r7.Y8();
        if (r8 == null) goto L25;
        Observable r9 = ld.c.a(r8);
        if (r9 == null) goto L25;
        Disposable r10 = r9.subscribe(new m(this));
        if (r10 == null) goto L25;
        com.bytedance.revenue.platform.api.core.rx.f.a(r10, this.e);
    L25:
        Boolean r12 = r1.o();
        Boolean r13 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r12, r13)) == false) goto L34;
        e r14 = this.i;
        if (r14 == null) goto L34;
        if (r14.isEnabled() != true) goto L34;
        e r15 = this.i;
        if (r15 == null) goto L34;
        r15.disable();
    L34:
        i r16 = this.l;
        int r17 = 0;
        if (r16.f == false) goto L37;
    L46:
        i r19 = this.l;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r1, "seiFrame");
        if (r19.o != LiveMode.SCREEN_RECORD) goto L49;
        boolean r20 = true;
    L50:
        o51.f r22 = r1.t(r20, r19.h);
        Integer r110 = r1.n();
        if (r110 == null) goto L58;
        if (r110.intValue() != 6) goto L58;
        if (r22.a() == false) goto L58;
    L59:
        int r23 = r19.k;
    L66:
        r19.l = r23;
        if (r1.p() == false) goto L84;
        int r24 = this.l.l;
        b03.a r25 = b03.a.a;
        float r26 = s1.w();
        int r27 = s1.y();
        int r28 = (r24 * 9) / 16;
        int r29 = (r27 - r28) / 2;
        RectF r30 = new RectF(0.0f, 0.0f, r27, r26);
        ld.a r32 = this.k;
        if (r32 == null) goto L73;
        NextLiveData r33 = r32.Rm();
        if (r33 == null) goto L73;
        r33.setValue(new oq2.e(r30, false, this.d.n(), this.l.h));
    L73:
        ld.a r34 = this.k;
        if (r34 == null) goto L82;
        NextLiveData r35 = r34.s9();
        if (r35 == null) goto L82;
        Matrix r111 = new Matrix();
        RevSeiFrame r112 = this.d;
        String r113 = r112.C;
        Integer r114 = r112.m();
        if (r114 == null) goto L80;
        int r115 = r114.intValue();
    L81:
        r35.setValue(new g90.a(r111, r30, r113, r115));
        goto L82
    L80:
        r115 = 0;
    L82:
        jy0.b.c("RevenueLayoutCore", "onLayoutContextChange doLayoutInnerForPartner " + r28 + ' ' + r24 + "  " + r24 + ' ' + r27, null, 4);
        return new h(r28, r24, r29, 0);
    L84:
        this.f.a(r1, this.l);
        if (Intrinsics.areEqual(r1.o(), r13) == false) goto L124;
        com.bytedance.live.layout.d r36 = this.f.c.b;
        if (r36 == null) goto L90;
        Matrix r37 = r36.c;
        if (r37 == null) goto L90;
    L91:
        com.bytedance.live.layout.d r38 = this.f.c.b;
        if (r38 == null) goto L94;
        RectF r39 = r38.a;
    L95:
        RevSeiFrame r40 = this.d;
        if (r39 != null) goto L99;
    L103:
        e r42 = this.i;
        if (r42 != null) goto L106;
        return null;
    L106:
        if (r42.O(this.d.C) == true) goto L109;
        r42 = null;
    L109:
        if (r42 != null) goto L111;
        return null;
    L111:
        if (r39 == null) goto L113;
        int r43 = (int) r39.width();
    L114:
        if (r39 == null) goto L116;
        int r44 = (int) r39.height();
    L117:
        if (r39 == null) goto L119;
        int r45 = (int) r39.left;
    L120:
        if (r39 == null) goto L123;
        r17 = (int) r39.top;
    L123:
        return r42.b(this.d.C, new h(r43, r44, r45, r17), null);
    L119:
        r45 = 0;
        goto L120
    L116:
        r44 = 0;
        goto L117
    L113:
        r43 = 0;
        goto L114
    L99:
        if (this.l.i == false) goto L101;
        Function3 r46 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$1(this);
    L102:
        r46.invoke(r37, r40, r39);
        goto L103
    L101:
        r46 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$2(this);
        goto L102
    L94:
        r39 = null;
    L90:
        r37 = new Matrix();
        goto L91
    L124:
        StringBuilder r47 = new StringBuilder("onLayoutContextChange finished with visibleArea: ");
        com.bytedance.live.layout.d r48 = this.f.c.b;
        if (r48 == null) goto L127;
        RectF r49 = r48.a;
    L128:
        r47.append(r49);
        r47.append(" and player: ");
        com.bytedance.live.layout.d r50 = this.f.c.b;
        if (r50 == null) goto L131;
        RectF r52 = r50.b;
    L132:
        r47.append(r52);
        jy0.b.c("RevenueLayoutCore", r47.toString(), null, 4);
        com.bytedance.live.layout.d r53 = this.f.c.b;
        if (r53 == null) goto L136;
        Matrix r54 = r53.c;
        if (r54 == null) goto L136;
    L137:
        RevSeiFrame r55 = this.d;
        com.bytedance.live.layout.d r56 = this.f.c.b;
        if (r56 == null) goto L140;
        RectF r57 = r56.a;
    L141:
        if (r57 != null) goto L144;
    L148:
        com.bytedance.live.layout.d r58 = this.f.c.b;
        if (r58 == null) goto L151;
        RectF r59 = r58.b;
    L152:
        if (r59 == null) goto L158;
        jy0.b.c("RevenueLayoutCore", "updated playerPosition by bizUpdate: " + r59, null, 4);
        return new h((int) r59.width(), (int) r59.height(), (int) r59.left, (int) r59.top);
    L158:
        return null;
    L151:
        r59 = null;
        goto L152
    L144:
        if (this.l.i == false) goto L146;
        Function3 r60 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$1(this);
    L147:
        r60.invoke(r54, r55, r57);
        goto L148
    L146:
        r60 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$2(this);
        goto L147
    L140:
        r57 = null;
    L136:
        r54 = new Matrix();
        goto L137
    L131:
        r52 = null;
        goto L132
    L127:
        r49 = null;
    L58:
        if (r1.p() == true) goto L59;
        k31.k r62 = r19.r;
        if (r62 != null) goto L63;
    L65:
        r23 = r19.k;
        goto L66
    L63:
        if (r62.a != true) goto L65;
        r23 = r19.k - k31.l.a(r62, true);
        goto L66
    L49:
        r20 = false;
        goto L50
    L37:
        if (r16.h == true) goto L46;
        if ((!Intrinsics.areEqual(r1.o(), r13)) == false) goto L46;
        Disposable r63 = this.g;
        if (r63 != null) goto L43;
    L45:
        int r64 = ToastUtil.a;
        int r65 = w11.a.a;
        ToastUtil.a(2131917688, 0);
        com.bytedance.revenue.platform.api.core.rx.l r66 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r67 = p.a;
        this.g = Observable.just(1).delay(2000, TimeUnit.MILLISECONDS, Schedulers.computation(), false).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this));
        goto L46
    L43:
        if (r63.isDisposed() == true) goto L45;
        goto L45
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final boolean O(String r6) {
        Intrinsics.checkNotNullParameter(r6, "sei");
        Integer r7 = RevSeiFrame.a.a(RevSeiFrame.G, r6, false, 6).n();
        if (r7 != null) goto L6;
    L7:
        if (r7 != null) goto L10;
    L11:
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L44;
        LiveMode r9 = this.l.o;
        if (r9 == null) goto L31;
        int r10 = k.a[r9.ordinal()];
        if (r10 == 1) goto L32;
        if (r10 == 2) goto L32;
        if (r10 == 3) goto L32;
        if (r10 == 4) goto L32;
        if (r10 != 5) goto L31;
    L32:
        boolean r12 = true;
    L33:
        if (r12 == true) goto L35;
        return false;
    L35:
        if (rc0.n.a((DeviceType) this.a.getValue()) == false) goto L40;
        b03.a r13 = b03.a.a;
        if (b03.a.b() == true) goto L40;
        boolean r14 = false;
    L41:
        if (r14 == false) goto L46;
        return true;
    L46:
        return false;
    L40:
        r14 = true;
    L31:
        r12 = false;
        goto L33
    L44:
        return false;
    L14:
        if (r7.intValue() != 19) goto L16;
    L17:
        r8 = true;
        goto L18
    L10:
        if (r7.intValue() == 6) goto L17;
    L6:
        if (r7.intValue() == 2) goto L17;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void h(Function1<? super b, Unit> r2) {
        this.l.p = r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final h handleSei(String r12) {
        Intrinsics.checkNotNullParameter(r12, "sei");
        RevSeiFrame r0 = RevSeiFrame.a.a(RevSeiFrame.G, r12, this.l.h, 2);
        com.bytedance.android.live.revlink.impl.settings.live.c r1 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r1.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.j.getValue(r1, com.bytedance.android.live.revlink.impl.settings.live.c.a[8])).booleanValue() == false) goto L52;
        RevSeiFrame r2 = this.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "frame");
        if (Intrinsics.areEqual((String) r2.f.getValue(), (String) r0.f.getValue()) == true) goto L25;
        y41.f r3 = y41.f.N;
        r3.getClass();
        if (((Boolean) y41.f.G.getValue(r3, y41.f.a[31])).booleanValue() == false) goto L27;
        if (r2.e() == null) goto L27;
        if (r0.e() == null) goto L27;
        Long r4 = r2.e();
        if (r4 != null) goto L17;
    L18:
        Long r5 = r0.e();
        if (r5 == null) goto L24;
        if (r5.longValue() == 0) goto L27;
    L24:
        if (Intrinsics.areEqual(r2.e(), r0.e()) == false) goto L27;
    L17:
        if (r4.longValue() != 0) goto L18;
    L27:
        if (((Boolean) ay0.a.c.getValue(null, ay0.a.a[1])).booleanValue() == true) goto L29;
        boolean r6 = false;
    L30:
        if (r6 == false) goto L52;
        if (this.l.b == true) goto L52;
        if (this.b == false) goto L52;
        if (this.d.p() == true) goto L52;
        jy0.b.d("RevenueLayoutCore", "block update by same content check");
        e r13 = this.i;
        if (r13 != null) goto L40;
    L44:
        com.bytedance.live.layout.d r14 = this.f.c.b;
        if (r14 == null) goto L47;
        RectF r15 = r14.b;
    L48:
        if (r15 != null) goto L51;
        return null;
    L51:
        return new h((int) r15.width(), (int) r15.height(), (int) r15.left, (int) r15.top);
    L47:
        r15 = null;
        goto L48
    L40:
        if (r13.isEnabled() != true) goto L44;
        e r16 = this.i;
        if (r16 != null) goto L55;
        return null;
    L55:
        return r16.c();
    L29:
        r6 = Intrinsics.areEqual((String) r2.g.getValue(), (String) r0.g.getValue());
    L25:
        r6 = true;
    L52:
        h r17 = A(r12);
        this.l.b = false;
        return r17;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final void me(StreamLayoutManager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        if (this.i != null) goto L6;
        this.i = r2;
        return;
    }

    public j(cy0.c r3, ld.a r4) {
        i r0 = new i();
        Intrinsics.checkNotNullParameter(r0, "context");
        this.j = r3;
        this.k = r4;
        this.l = r0;
        this.a = LazyKt.lazy(RevenueLayoutCore$deviceType$2.INSTANCE);
        r0.a = new RevenueLayoutCore$1(this);
        RevSeiFrame.G.getClass();
        this.d = (RevSeiFrame) RevSeiFrame.D.getValue();
        this.e = new CompositeDisposable();
        this.f = new DynamicLayoutCalculate();
        int r5 = o.a;
        this.h = PublishSubject.create();
    }

    public static final void y(j r1, RevSeiFrame r2) {
        r1.getClass();
        if (r2 == null) goto L5;
        String r3 = r2.C;
    L6:
        if (r3 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L19;
        h r4 = r1.A(r3);
        if (r4 == null) goto L18;
        r1.h.onNext(r4);
        return;
    L18:
        return;
    L19:
        return;
    L8:
        if (r3.length() == 0) goto L11;
        r0 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
