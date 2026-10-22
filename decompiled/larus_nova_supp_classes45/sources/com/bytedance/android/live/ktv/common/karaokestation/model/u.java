package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u {
    public final Function0<Unit> a;
    public final Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;
    public final Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> e;
    public final Function3<Integer, HSImageView, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> f;
    public final Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> g;
    public final Integer h;
    public final Integer i;
    public final boolean j;
    public final Function1<FrameLayout, Unit> k;
    public final Function3<TabLayout, FrameLayout, FrameLayout, Unit> l;
    public final Function0<Boolean> m;
    public final Function0<Boolean> n;
    public final Function0<Boolean> o;
    public final Function0<Unit> p;

    public u() {
        this(null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 65535);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L38;
        u r4 = (u) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v56 */
    public final int hashCode() {
        Function0<Unit> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function0<Unit> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Function0<Unit> r11 = this.d;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Function3<Integer, HSImageView, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r21 = this.g;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        Integer r24 = this.h;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.i;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        boolean r31 = this.j;
        ?? r32 = r31;
        if (r31 == false) goto L41;
        r32 = 1;
    L41:
        int r33 = (r29 + r32) * 31;
        Function1<FrameLayout, Unit> r34 = this.k;
        if (r34 == null) goto L44;
        int r35 = r34.hashCode();
    L45:
        int r36 = (r33 + r35) * 31;
        Function3<TabLayout, FrameLayout, FrameLayout, Unit> r37 = this.l;
        if (r37 == null) goto L48;
        int r38 = r37.hashCode();
    L49:
        int r39 = (r36 + r38) * 31;
        Function0<Boolean> r41 = this.m;
        if (r41 == null) goto L52;
        int r42 = r41.hashCode();
    L53:
        int r43 = (r39 + r42) * 31;
        Function0<Boolean> r44 = this.n;
        if (r44 == null) goto L56;
        int r45 = r44.hashCode();
    L57:
        int r46 = (r43 + r45) * 31;
        Function0<Boolean> r47 = this.o;
        if (r47 == null) goto L60;
        int r48 = r47.hashCode();
    L61:
        int r49 = (r46 + r48) * 31;
        Function0<Unit> r51 = this.p;
        if (r51 == null) goto L65;
        r1 = r51.hashCode();
    L65:
        return r49 + r1;
    L60:
        r48 = 0;
        goto L61
    L56:
        r45 = 0;
        goto L57
    L52:
        r42 = 0;
        goto L53
    L48:
        r38 = 0;
        goto L49
    L44:
        r35 = 0;
        goto L45
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongOptionalConfig(postFillCustomTabAction=" + this.a + ", setCartAnimAction=" + this.b + ", selectDefaultFirstLevelTabAction=" + this.c + ", syncOrderedSongListAction=" + this.d + ", firstLevelTabPageSelectedAction=" + this.e + ", showBusinessEntryIfNeedAction=" + this.f + ", initBusinessEntryAction=" + this.g + ", dialogLayoutId=" + this.h + ", dialogHeight=" + this.i + ", shouldInitTopControlBar=" + this.j + ", initTopControlBarAction=" + this.k + ", updateOrderSongDialogTopAreaAction=" + this.l + ", needBackBtn=" + this.m + ", needDividerLine=" + this.n + ", needTabIndicator=" + this.o + ", clickBackAction=" + this.p + ")";
    }

    public u(Function0 r18, Function3 r19, Function0 r21, Function0 r22, Function3 r23, Function3 r24, Function5 r25, Integer r26, boolean r27, Function1 r28, Function3 r29, Function0 r210, Function0 r31, Function0 r32, Function0 r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        Function0 r2 = OrderSongOptionalConfig$1.INSTANCE;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Function3 r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Function0 r5 = OrderSongOptionalConfig$2.INSTANCE;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Function0 r6 = OrderSongOptionalConfig$3.INSTANCE;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Function3 r7 = OrderSongOptionalConfig$4.INSTANCE;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Function3 r8 = OrderSongOptionalConfig$5.INSTANCE;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Function5 r9 = OrderSongOptionalConfig$6.INSTANCE;
    L31:
        if ((r34 & 256) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r34 & 512) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r34 & RomUtils.SZ) == 0) goto L41;
        Function1 r13 = null;
    L43:
        if ((r34 & 2048) == 0) goto L45;
        Function3 r14 = null;
    L47:
        if ((r34 & 4096) == 0) goto L49;
        Function0 r15 = OrderSongOptionalConfig$7.INSTANCE;
    L51:
        if ((r34 & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) goto L53;
        Function0 r16 = OrderSongOptionalConfig$8.INSTANCE;
    L55:
        if ((r34 & 16384) == 0) goto L57;
        Function0 r4 = OrderSongOptionalConfig$9.INSTANCE;
    L59:
        if ((r34 & 32768) == 0) goto L61;
        Function0 r1 = OrderSongOptionalConfig$10.INSTANCE;
    L62:
        Intrinsics.checkNotNullParameter(r2, "postFillCustomTabAction");
        Intrinsics.checkNotNullParameter(r5, "selectDefaultFirstLevelTabAction");
        Intrinsics.checkNotNullParameter(r6, "syncOrderedSongListAction");
        Intrinsics.checkNotNullParameter(r7, "firstLevelTabPageSelectedAction");
        Intrinsics.checkNotNullParameter(r8, "showBusinessEntryIfNeedAction");
        Intrinsics.checkNotNullParameter(r9, "initBusinessEntryAction");
        Intrinsics.checkNotNullParameter(r15, "needBackBtn");
        Intrinsics.checkNotNullParameter(r16, "needDividerLine");
        Intrinsics.checkNotNullParameter(r4, "needTabIndicator");
        Intrinsics.checkNotNullParameter(r1, "clickBackAction");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = null;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r4;
        this.p = r1;
        return;
    L61:
        r1 = r33;
        goto L62
    L57:
        r4 = r32;
        goto L59
    L53:
        r16 = r31;
        goto L55
    L49:
        r15 = r210;
        goto L51
    L45:
        r14 = r29;
        goto L47
    L41:
        r13 = r28;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
