package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.larksuite.component.universe_design.menu.PositionAlign;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements PopupPositionProvider {
    public final UDMenuGravity a;
    public final PositionAlign b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[UDMenuGravity.values().length];
            r0[UDMenuGravity.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[UDMenuGravity.Start.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r0[UDMenuGravity.End.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r0[UDMenuGravity.Bottom.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            a = r0;
            int[] r1 = new int[PositionAlign.values().length];
            r1[PositionAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r1[PositionAlign.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[PositionAlign.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            b = r1;
        }
    }

    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public final long m306calculatePositionllwVHH4(IntRect r17, long r19, LayoutDirection r20, long r21) {
        Intrinsics.checkNotNullParameter(r17, "anchorBounds");
        Intrinsics.checkNotNullParameter(r20, "layoutDirection");
        int r4 = RangesKt.coerceAtLeast((((int) (r21 >> 32)) - this.d) - this.f, 0);
        int r7 = RangesKt.coerceAtLeast((((int) (r21 & 4294967295L)) - this.e) - this.g, 0);
        long r8 = IntSize.constructor-impl((((long) r4) << 32) | (((long) r7) & 4294967295L));
        UDMenuGravity r5 = this.a;
        int[] r9 = a.a;
        int r6 = r9[r5.ordinal()];
        if (r6 == 1) goto L12;
        if (r6 == 2) goto L11;
        if (r6 == 3) goto L10;
        if (r6 != 4) goto L9;
        int r10 = r17.getLeft() + ((r17.getWidth() - ((int) (r8 >> 32))) / 2);
        long r11 = ((long) (r17.getBottom() + this.c)) & 4294967295L;
        long r12 = IntOffset.constructor-impl(r11 | (((long) r10) << 32));
    L13:
        int r13 = IntOffset.getX-impl(r12);
        int r14 = IntOffset.getY-impl(r12);
        int r15 = r9[this.a.ordinal()];
        if (r15 != 1) goto L16;
    L38:
        PositionAlign r16 = this.b;
        int r22 = a.b[r16.ordinal()];
        if (r22 == 1) goto L46;
        if (r22 != 2) goto L42;
    L47:
        r13 = RangesKt.coerceIn(r13, 0, ((int) (r19 >> 32)) - ((int) (r8 >> 32)));
        if (r14 < 0) goto L52;
        if ((((int) (r8 & 4294967295L)) + r14) > ((int) (r19 & 4294967295L))) goto L52;
    L59:
        long r2 = IntOffset.constructor-impl((((long) r13) << 32) | (((long) r14) & 4294967295L));
        int r23 = IntOffset.getX-impl(r2) - this.d;
        int r3 = IntOffset.getY-impl(r2) - this.e;
        long r1 = ((long) r3) & 4294967295L;
        return IntOffset.constructor-impl(r1 | (((long) r23) << 32));
    L52:
        if (this.a != UDMenuGravity.Bottom) goto L54;
        int r24 = (r17.getTop() - this.c) - ((int) (r8 & 4294967295L));
    L55:
        if (r24 < 0) goto L59;
        if ((((int) (r8 & 4294967295L)) + r24) > ((int) (r19 & 4294967295L))) goto L59;
        r14 = r24;
        goto L59
    L54:
        r24 = r17.getBottom() + this.c;
        goto L55
    L42:
        if (r22 != 3) goto L45;
        r13 = r17.getRight() - ((int) (r8 >> 32));
        goto L47
    L45:
        throw new NoWhenBranchMatchedException();
    L46:
        r13 = r17.getLeft();
        goto L47
    L16:
        if (r15 == 4) goto L38;
        PositionAlign r25 = this.b;
        int r26 = a.b[r25.ordinal()];
        if (r26 == 1) goto L25;
        if (r26 != 2) goto L21;
    L26:
        r14 = RangesKt.coerceIn(r14, 0, ((int) (r19 & 4294967295L)) - ((int) (r8 & 4294967295L)));
        if (r13 < 0) goto L31;
        if ((((int) (r8 >> 32)) + r13) <= ((int) (r19 >> 32))) goto L59;
    L31:
        if (this.a != UDMenuGravity.End) goto L33;
        int r27 = (r17.getLeft() - this.c) - ((int) (r8 >> 32));
    L34:
        if (r27 < 0) goto L59;
        if ((((int) (r8 >> 32)) + r27) > ((int) (r19 >> 32))) goto L59;
        r13 = r27;
        goto L59
    L33:
        r27 = r17.getRight() + this.c;
        goto L34
    L21:
        if (r26 != 3) goto L24;
        r14 = r17.getBottom() - ((int) (r8 & 4294967295L));
        goto L26
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r14 = r17.getTop();
        goto L26
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        int r29 = r17.getRight() + this.c;
        int r110 = r17.getTop() + ((r17.getHeight() - ((int) (r8 & 4294967295L))) / 2);
        long r111 = ((long) r110) & 4294967295L;
        r12 = IntOffset.constructor-impl(r111 | (((long) r29) << 32));
        goto L13
    L11:
        int r30 = (r17.getLeft() - this.c) - ((int) (r8 >> 32));
        int r112 = r17.getTop() + ((r17.getHeight() - ((int) (r8 & 4294967295L))) / 2);
        long r113 = ((long) r112) & 4294967295L;
        r12 = IntOffset.constructor-impl(r113 | (((long) r30) << 32));
        goto L13
    L12:
        int r31 = r17.getLeft() + ((r17.getWidth() - ((int) (r8 >> 32))) / 2);
        int r114 = (r17.getTop() - this.c) - ((int) (r8 & 4294967295L));
        long r115 = ((long) r114) & 4294967295L;
        r12 = IntOffset.constructor-impl(r115 | (((long) r31) << 32));
        goto L13
    }

    public d(UDMenuGravity r2, PositionAlign r3, int r4, int r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "gravity");
        Intrinsics.checkNotNullParameter(r3, "align");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
