package ac0;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.j;
import gc0.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final zb0.a e;
    public final bc0.b f;
    public final d g;
    public final fc0.a h;
    public final Function1<ViewGroup, View> i;
    public final Function1<ViewGroup, View> j;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a k;
    public final ec0.a l;
    public final boolean m;

    public b() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L34;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
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
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L32;
        return false;
    L32:
        if (this.m == r4.m) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r11 = this.d;
        ?? r12 = r11;
        if (r11 == false) goto L14;
        r12 = 1;
    L14:
        int r13 = (r9 + r12) * 31;
        zb0.a r14 = this.e;
        int r15 = 0;
        if (r14 == null) goto L17;
        int r16 = r14.hashCode();
    L18:
        int r17 = (r13 + r16) * 31;
        bc0.b r18 = this.f;
        if (r18 == null) goto L21;
        int r19 = r18.hashCode();
    L22:
        int r21 = (r17 + r19) * 31;
        d r22 = this.g;
        if (r22 == null) goto L25;
        int r23 = r22.hashCode();
    L26:
        int r24 = (((r21 + r23) * 31) + 0) * 31;
        fc0.a r25 = this.h;
        if (r25 == null) goto L29;
        int r26 = r25.hashCode();
    L30:
        int r27 = (r24 + r26) * 31;
        Function1<ViewGroup, View> r28 = this.i;
        if (r28 == null) goto L33;
        int r29 = r28.hashCode();
    L34:
        int r31 = (r27 + r29) * 31;
        Function1<ViewGroup, View> r32 = this.j;
        if (r32 == null) goto L37;
        int r33 = r32.hashCode();
    L38:
        int r34 = (r31 + r33) * 31;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r35 = this.k;
        if (r35 == null) goto L41;
        int r36 = r35.hashCode();
    L42:
        int r37 = (r34 + r36) * 31;
        ec0.a r38 = this.l;
        if (r38 == null) goto L45;
        r15 = r38.hashCode();
    L45:
        int r39 = (r37 + r15) * 31;
        boolean r41 = this.m;
        if (r41 == true) goto L50;
        r1 = r41;
    L50:
        return r39 + r1;
    L41:
        r36 = 0;
        goto L42
    L37:
        r33 = 0;
        goto L38
    L33:
        r29 = 0;
        goto L34
    L29:
        r26 = 0;
        goto L30
    L25:
        r23 = 0;
        goto L26
    L21:
        r19 = 0;
        goto L22
    L17:
        r16 = 0;
        goto L18
    }

    public final String toString() {
        return "TuningPanelConfig(isShowTuningMusicControlArea=" + this.a + ", isShowTuningButtonArea=" + this.b + ", isShowTuningEffectArea=" + this.c + ", isShowTuningVolumeArea=" + this.d + ", tuningPanelOuterCallback=" + this.e + ", tuningButtonOuterCallback=" + this.f + ", tuningVolumeOuterCallback=" + this.g + ", tuningEffectOuterCallback=null, tuningMusicControlOuterCallback=" + this.h + ", createCustomEntranceView=" + this.i + ", createBottomEntranceView=" + this.j + ", tuningCore=" + this.k + ", tuningMusicControl=" + this.l + ", enableFontAdapt=" + this.m + ")";
    }

    public b(boolean r16, zb0.a r17, bc0.b r18, d r19, j r21, Function1 r22, Function1 r23, com.bytedance.android.live.ktv.common.tuningpanel.ability.a r24, ec0.a r25, boolean r26, int r27) {
        boolean r3 = false;
        boolean r4 = true;
        if ((r27 & 1) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r27 & 2) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r27 & 4) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r27 & 8) != 0) goto L18;
        r4 = false;
    L18:
        ec0.a r8 = null;
        if ((r27 & 16) == 0) goto L21;
        zb0.a r7 = null;
    L23:
        if ((r27 & 32) == 0) goto L25;
        bc0.b r9 = null;
    L27:
        if ((r27 & 64) == 0) goto L29;
        d r11 = null;
    L31:
        if ((r27 & 256) == 0) goto L33;
        j r12 = null;
    L35:
        if ((r27 & 512) == 0) goto L37;
        Function1 r13 = null;
    L39:
        if ((r27 & RomUtils.SZ) == 0) goto L41;
        Function1 r14 = null;
    L43:
        if ((r27 & 4096) != 0) goto L47;
        r8 = r25;
    L47:
        if ((r27 & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) != 0) goto L50;
        r3 = r26;
    L50:
        this.a = r2;
        this.b = r5;
        this.c = r6;
        this.d = r4;
        this.e = r7;
        this.f = r9;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r24;
        this.l = r8;
        this.m = r3;
        return;
    L41:
        r14 = r23;
        goto L43
    L37:
        r13 = r22;
        goto L39
    L33:
        r12 = r21;
        goto L35
    L29:
        r11 = r19;
        goto L31
    L25:
        r9 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }
}
