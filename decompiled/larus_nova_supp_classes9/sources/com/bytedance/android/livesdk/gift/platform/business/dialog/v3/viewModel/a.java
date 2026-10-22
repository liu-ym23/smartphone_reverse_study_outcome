package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.o0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.p0;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T, R> implements Function {
    public final /* synthetic */ GiftMVISearchViewModel a;
    public final /* synthetic */ int b;
    public final /* synthetic */ vz1.e c;
    public final /* synthetic */ int d;
    public final /* synthetic */ AbsPanel e;
    public final /* synthetic */ IBaseUser f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ List h;
    public final /* synthetic */ n i;

    public a(GiftMVISearchViewModel r1, int r2, vz1.e r3, int r4, AbsPanel r5, IBaseUser r6, boolean r7, List r8, n r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final Object apply(Object r21) {
        com.bytedance.android.livesdk.gift.platform.business.f r1 = (com.bytedance.android.livesdk.gift.platform.business.f) r21;
        Intrinsics.checkNotNullParameter(r1, "it");
        long r3 = 0;
        if (this.b > 1) goto L5;
        AbsPanel r2 = this.e;
        int r5 = this.d;
        IBaseUser r6 = this.f;
        boolean r7 = this.g;
        List r8 = this.h;
        n r9 = this.i;
        GiftMVISearchViewModel r10 = this.a;
        com.bytedance.android.livesdk.gift.platform.core.model.k r11 = r10.R.g;
        vz1.e r13 = this.c;
        if (r13 == null) goto L42;
        com.bytedance.android.livesdk.gift.platform.core.model.k r14 = r13.x;
    L43:
        o0 r15 = r10.y;
        if (r15 == null) goto L46;
        l1 r16 = r15.a;
    L47:
        p0 r17 = r10.z;
        if (r17 == null) goto L50;
        com.bytedance.android.livesdk.gift.model.n r18 = r17.a;
    L51:
        int r19 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        if (r13 == null) goto L54;
        r3 = r13.b;
    L54:
        com.bytedance.android.livesdk.gift.model.n r110 = r18;
        String r111 = com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r3, r10.H, r10.Z, r10.B);
        vz1.e r4 = this.c;
        if (r4 == null) goto L57;
        com.bytedance.android.livesdk.gift.platform.core.model.a r112 = r4.z;
    L58:
        boolean r20 = com.bytedance.android.livesdk.gift.platform.business.f.a.b(r1, r2, r5, r6, r7, r8, r9, r11, r14, r16, r110, r111, r112, 4096);
    L60:
        return Boolean.valueOf(r20);
    L57:
        r112 = null;
        goto L58
    L50:
        r18 = null;
        goto L51
    L46:
        r16 = null;
        goto L47
    L42:
        r14 = null;
        goto L43
    L5:
        if (nz1.a.g() == false) goto L11;
        int r23 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        vz1.e r24 = this.c;
        if (r24 == null) goto L9;
        h1 r25 = r24.a;
    L10:
        AbsPanel r26 = com.bytedance.android.livesdk.gift.platform.core.utils.g.d(r25, this.a.X.b);
    L16:
        int r27 = this.d;
        int r28 = this.b;
        GiftMVISearchViewModel r29 = this.a;
        IBaseUser r30 = r29.G.a;
        boolean r31 = r29.S.j();
        List<IBaseUser> r113 = this.a.S.i();
        vz1.e r114 = this.c;
        if (r114 == null) goto L19;
        py.k r115 = r114.o;
    L20:
        if (r114 == null) goto L22;
        String r116 = r114.p;
    L23:
        n r117 = new n(r115, r116, 4);
        GiftMVISearchViewModel r118 = this.a;
        o0 r119 = r118.y;
        if (r119 == null) goto L26;
        l1 r120 = r119.a;
    L27:
        p0 r121 = r118.z;
        if (r121 == null) goto L30;
        com.bytedance.android.livesdk.gift.model.n r122 = r121.a;
    L31:
        int r123 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        if (r114 == null) goto L34;
        r3 = r114.b;
    L34:
        String r124 = com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r3, r118.H, r118.Z, r118.B);
        vz1.e r33 = this.c;
        if (r33 == null) goto L37;
        com.bytedance.android.livesdk.gift.platform.core.model.a r125 = r33.z;
    L38:
        r20 = com.bytedance.android.livesdk.gift.platform.business.f.a.c(r1, r26, r27, r28, r30, r31, r113, r117, r120, r122, null, 0, r124, r125, 6528);
        goto L60
    L37:
        r125 = null;
        goto L38
    L30:
        r122 = null;
        goto L31
    L26:
        r120 = null;
        goto L27
    L22:
        r116 = null;
        goto L23
    L19:
        r115 = null;
        goto L20
    L9:
        r25 = null;
        goto L10
    L11:
        int r34 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        vz1.e r35 = this.c;
        if (r35 == null) goto L14;
        h1 r36 = r35.a;
    L15:
        r26 = com.bytedance.android.livesdk.gift.platform.core.utils.g.k(r36, this.a.z);
        goto L16
    L14:
        r36 = null;
        goto L15
    }
}
