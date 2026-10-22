package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.config.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.o0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.p0;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ GiftMVIVerticalListViewModel a;
    public final /* synthetic */ int b;
    public final /* synthetic */ vz1.e c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ AbsPanel g;
    public final /* synthetic */ IBaseUser h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ List j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ n l;

    public h(GiftMVIVerticalListViewModel r1, int r2, vz1.e r3, int r4, int r5, String r6, AbsPanel r7, IBaseUser r8, boolean r9, List r10, boolean r11, n r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r13;
    }

    public final Object apply(Object r21) {
        com.bytedance.android.livesdk.gift.platform.business.f r1 = (com.bytedance.android.livesdk.gift.platform.business.f) r21;
        Intrinsics.checkNotNullParameter(r1, "it");
        if (this.b <= 1) goto L48;
        vz1.e r2 = this.c;
        if (r2 == null) goto L13;
        if (r2.e != true) goto L13;
        l2 r3 = this.a.P0.f(Long.valueOf(r2.b));
        if (r3 != null) goto L11;
        AbsPanel r4 = new pz1.d();
    L24:
        int r6 = this.d;
        int r7 = this.b;
        GiftMVIVerticalListViewModel r8 = this.a;
        IBaseUser r9 = r8.H2.a;
        boolean r10 = r8.p1.j();
        List<IBaseUser> r11 = this.a.p1.i();
        vz1.e r13 = this.c;
        if (r13 == null) goto L27;
        py.k r14 = r13.o;
    L28:
        if (r13 == null) goto L30;
        String r15 = r13.p;
    L31:
        n r16 = new n(r14, r15, 4);
        GiftMVIVerticalListViewModel r17 = this.a;
        o0 r18 = r17.A;
        if (r18 == null) goto L34;
        l1 r19 = r18.a;
    L35:
        p0 r110 = r17.B;
        if (r110 == null) goto L38;
        com.bytedance.android.livesdk.gift.model.n r23 = r110.a;
    L39:
        int r111 = this.e;
        String r112 = this.f;
        int r113 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        if (r13 == null) goto L42;
        long r5 = r13.b;
    L43:
        String r114 = com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r5, r17.x1, r17.E2, r17.T);
        vz1.e r20 = this.c;
        if (r20 == null) goto L46;
        com.bytedance.android.livesdk.gift.platform.core.model.a r115 = r20.z;
    L47:
        boolean r24 = com.bytedance.android.livesdk.gift.platform.business.f.a.c(r1, r4, r6, r7, r9, r10, r11, r16, r19, r23, r112, r111, r114, r115, 384);
    L70:
        return Boolean.valueOf(r24);
    L46:
        r115 = null;
        goto L47
    L42:
        r5 = 0;
        goto L43
    L38:
        r23 = null;
        goto L39
    L34:
        r19 = null;
        goto L35
    L30:
        r15 = null;
        goto L31
    L27:
        r14 = null;
        goto L28
    L11:
        r4 = ((m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class)).d(r3);
    L13:
        if (nz1.a.g() == false) goto L19;
        int r25 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        vz1.e r26 = this.c;
        if (r26 == null) goto L17;
        h1 r27 = r26.a;
    L18:
        r4 = com.bytedance.android.livesdk.gift.platform.core.utils.g.d(r27, this.a.G1.b);
        goto L24
    L17:
        r27 = null;
        goto L18
    L19:
        int r28 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        vz1.e r29 = this.c;
        if (r29 == null) goto L22;
        h1 r30 = r29.a;
    L23:
        r4 = com.bytedance.android.livesdk.gift.platform.core.utils.g.k(r30, this.a.B);
        goto L24
    L22:
        r30 = null;
        goto L23
    L48:
        AbsPanel<?> r31 = this.g;
        int r33 = this.d;
        int r34 = this.e;
        IBaseUser r35 = this.h;
        boolean r36 = this.i;
        List<? extends IBaseUser> r37 = this.j;
        boolean r116 = this.k;
        n r117 = this.l;
        GiftMVIVerticalListViewModel r118 = this.a;
        com.bytedance.android.livesdk.gift.platform.core.model.k r119 = r118.b1.g;
        vz1.e r120 = this.c;
        if (r120 == null) goto L51;
        com.bytedance.android.livesdk.gift.platform.core.model.k r121 = r120.x;
    L52:
        o0 r38 = r118.A;
        if (r38 == null) goto L55;
        l1 r122 = r38.a;
    L56:
        p0 r39 = r118.B;
        if (r39 == null) goto L59;
        com.bytedance.android.livesdk.gift.model.n r123 = r39.a;
    L60:
        String r40 = this.f;
        int r41 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        if (r120 == null) goto L63;
        long r43 = r120.b;
    L64:
        com.bytedance.android.livesdk.gift.platform.core.model.k r124 = r121;
        String r125 = com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r43, r118.x1, r118.E2, r118.T);
        vz1.e r44 = this.c;
        if (r44 == null) goto L67;
        com.bytedance.android.livesdk.gift.platform.core.model.a r126 = r44.z;
    L68:
        r24 = r1.A(r31, r33, r34, r35, r36, r37, r116, r117, r119, r124, r122, r123, r40, r125, r126);
        goto L70
    L67:
        r126 = null;
        goto L68
    L63:
        r43 = 0;
        goto L64
    L59:
        r123 = null;
        goto L60
    L55:
        r122 = null;
        goto L56
    L51:
        r121 = null;
        goto L52
    }
}
