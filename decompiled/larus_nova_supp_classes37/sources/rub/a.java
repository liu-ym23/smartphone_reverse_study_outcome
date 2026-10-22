package rub;

import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final View a;
    public final String b;
    public final CharSequence c;
    public final MmBubbleDirection d;
    public final boolean e;
    public final boolean f;
    public final long g;
    public final boolean h;
    public final Integer i;
    public final Integer j;
    public final Integer k;
    public final Point l;
    public final Function0<Unit> m;
    public final Function0<Unit> n;
    public final MmRecordingUILaunchMode o;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        CharSequence r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.d.hashCode()) * 31;
        int r8 = 1231;
        if (this.e == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.f == false) goto L17;
        int r11 = 1231;
    L18:
        long r12 = this.g;
        int r13 = (((r10 + r11) * 31) + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        if (this.h == true) goto L22;
        r8 = 1237;
    L22:
        int r14 = (r13 + r8) * 31;
        Integer r15 = this.i;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.j;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.k;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        Point r24 = this.l;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        Function0<Unit> r27 = this.m;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        Function0<Unit> r30 = this.n;
        if (r30 == null) goto L47;
        r2 = r30.hashCode();
    L47:
        return ((r29 + r2) * 31) + this.o.hashCode();
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmBubbleConfig(anchorView=" + this.a + ", title=" + this.b + ", detail=" + this.c + ", direction=" + this.d + ", cancelable=" + this.e + ", autoDismiss=" + this.f + ", autoDismissTime=" + this.g + ", showClose=" + this.h + ", maxWidthPx=" + this.i + ", detailMaxLines=" + this.j + ", anchorMarginDp=" + this.k + ", anchorOffsetPx=" + this.l + ", onClose=" + this.m + ", onDismiss=" + this.n + ", uiLaunchMode=" + this.o + ')';
    }

    public a(View r6, String r7, CharSequence r8, MmBubbleDirection r9, boolean r10, boolean r11, long r12, boolean r14, Integer r15, Integer r16, Integer r17, Point r18, Function0<Unit> r19, Function0<Unit> r20, MmRecordingUILaunchMode r21) {
        Intrinsics.checkNotNullParameter(r6, "anchorView");
        Intrinsics.checkNotNullParameter(r9, "direction");
        Intrinsics.checkNotNullParameter(r21, "uiLaunchMode");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
    }
}
