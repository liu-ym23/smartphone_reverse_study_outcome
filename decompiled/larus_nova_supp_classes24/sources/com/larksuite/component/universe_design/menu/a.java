package com.larksuite.component.universe_design.menu;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.menu.a$a, reason: collision with other inner class name */
    public static final class C0040a {
    }

    public static final class b {
        public int a;
        public RectF b;

        public b() {
        }

        public final void setResult(RectF r1) {
            this.b = r1;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PositionAlign.values().length];
            r0[PositionAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PositionAlign.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PositionAlign.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static RectF a(com.larksuite.component.universe_design.menu.b r16) {
        Intrinsics.checkNotNullParameter(r16, "params");
        Display r1 = r16.b.getDisplay();
        if (r1 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "display");
        DisplayMetrics r3 = new DisplayMetrics();
        r1.getMetrics(r3);
        RectF r2 = new RectF();
        r2.left = 0.0f;
        r2.top = 0.0f;
        r2.right = r3.widthPixels;
        r2.bottom = r3.heightPixels;
        View r4 = r16.a;
        Intrinsics.checkNotNullParameter(r4, "uiView");
        int r5 = h18.g.a;
        if (r4 == null) goto L8;
        r4.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r6 = r4.getMeasuredWidth();
    L9:
        float r7 = r6;
        if (r4 == null) goto L12;
        r4.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r8 = r4.getMeasuredHeight();
    L13:
        RectF r9 = new RectF();
        r9.left = 0.0f;
        r9.top = 0.0f;
        r9.right = r7;
        r9.bottom = r8;
        View r10 = r16.b;
        Intrinsics.checkNotNullParameter(r10, "anchorView");
        int[] r11 = new int[2];
        r10.getLocationInWindow(r11);
        float r12 = r10.getWidth();
        float r13 = r10.getHeight();
        RectF r14 = new RectF();
        float r15 = r11[0];
        r14.left = r15;
        float r17 = r11[1];
        r14.top = r17;
        r14.right = r15 + r12;
        r14.bottom = r17 + r13;
        RectF r19 = new RectF(r9);
        int r20 = r16.c;
        float r21 = r16.e;
        Intrinsics.checkNotNullParameter(r19, "uiViewRectF");
        Intrinsics.checkNotNullParameter(r14, "anchorViewRectF");
        RectF r110 = new RectF(r19);
        PointF r111 = new PointF();
        r111.x = r14.centerX();
        r111.y = r14.centerY();
        if (r20 == 48) goto L24;
        if (r20 != 80) goto L17;
        r111.x = r14.centerX();
        float r22 = 2;
        r111.y = r14.centerY() + (((r14.height() / r22) + r21) + (r19.height() / r22));
    L25:
        float r23 = r111.x - r19.centerX();
        float r24 = r111.y - r19.centerY();
        r110.left += r23;
        r110.right += r23;
        r110.top += r24;
        r110.bottom += r24;
        int r25 = r16.c;
        PositionAlign r26 = r16.d;
        Intrinsics.checkNotNullParameter(r110, "uiViewRectF");
        Intrinsics.checkNotNullParameter(r14, "anchorViewRectF");
        Intrinsics.checkNotNullParameter(r26, "anchorAlign");
        RectF r27 = new RectF(r110);
        if (r25 == 3) goto L39;
        if (r25 == 5) goto L39;
        if (r25 == 48) goto L31;
        if (r25 == 80) goto L31;
    L47:
        int r0 = r16.c;
        Intrinsics.checkNotNullParameter(r27, "uiViewRectF");
        Intrinsics.checkNotNullParameter(r14, "anchorViewRectF");
        Intrinsics.checkNotNullParameter(r2, "boundaryRectF");
        RectF r29 = new RectF(r27);
        if (r27.width() <= r2.width()) goto L50;
    L94:
        b r30 = new b();
        r30.a = -1;
    L96:
        if (r30.a != 0) goto L100;
        RectF r31 = r30.b;
        if (r31 == null) goto L100;
        return r31;
    L100:
        return null;
    L50:
        if (r27.height() > r2.height()) goto L94;
        if (r0 == 3) goto L75;
        if (r0 == 5) goto L75;
        if (r0 == 48) goto L57;
        if (r0 == 80) goto L57;
    L92:
        r30 = new b();
        r30.setResult(r29);
    L57:
        float r32 = r27.left;
        float r33 = r2.left;
        if (r32 < r33) goto L62;
        r32 = r27.right;
        r33 = r2.right;
        if (r32 > r33) goto L62;
        float r34 = 0.0f;
    L64:
        r29.left += r34;
        r29.right += r34;
        if (r27.top >= r2.top) goto L67;
    L68:
        float r35 = (r14.centerY() - r27.centerY()) * 2;
        float r36 = r27.top + r35;
        float r37 = r27.bottom + r35;
        if (r36 >= r2.top) goto L71;
    L74:
        r30 = new b();
        r30.a = -1;
        goto L96
    L71:
        if (r37 > r2.bottom) goto L74;
        r29.top += r35;
        r29.bottom += r35;
        goto L92
    L67:
        if (r27.bottom <= r2.bottom) goto L92;
    L62:
        r34 = r33 - r32;
    L75:
        float r38 = r27.top;
        float r39 = r2.top;
        if (r38 < r39) goto L80;
        r38 = r27.bottom;
        r39 = r2.bottom;
        if (r38 > r39) goto L80;
        float r40 = 0.0f;
    L82:
        r29.top += r40;
        r29.bottom += r40;
        if (r27.left >= r2.left) goto L85;
    L86:
        float r41 = (r14.centerX() - r27.centerX()) * 2;
        float r42 = r27.left + r41;
        float r43 = r27.right + r41;
        if (r42 >= r2.left) goto L89;
    L93:
        r30 = new b();
        r30.a = -1;
        goto L96
    L89:
        if (r43 > r2.right) goto L93;
        r29.left += r41;
        r29.right += r41;
        goto L92
    L85:
        if (r27.right <= r2.right) goto L92;
    L80:
        r40 = r39 - r38;
    L31:
        int r44 = c.a[r26.ordinal()];
        if (r44 == 1) goto L38;
        if (r44 == 2) goto L47;
        if (r44 != 3) goto L37;
        float r45 = r14.right - r110.right;
        r27.left += r45;
        r27.right += r45;
        goto L47
    L37:
        throw new NoWhenBranchMatchedException();
    L38:
        float r46 = r14.left - r110.left;
        r27.left += r46;
        r27.right += r46;
    L39:
        int r47 = c.a[r26.ordinal()];
        if (r47 == 1) goto L46;
        if (r47 == 2) goto L47;
        if (r47 != 3) goto L45;
        float r48 = r14.bottom - r110.bottom;
        r27.top += r48;
        r27.bottom += r48;
        goto L47
    L45:
        throw new NoWhenBranchMatchedException();
    L46:
        float r49 = r14.top - r110.top;
        r27.top += r49;
        r27.bottom += r49;
        goto L47
    L17:
        if (r20 != 8388611) goto L19;
        float r50 = 2;
        r111.x = r14.centerX() - (((r14.width() / r50) + r21) + (r19.width() / r50));
        r111.y = r14.centerY();
        goto L25
    L19:
        if (r20 != 8388613) goto L25;
        float r51 = 2;
        r111.x = r14.centerX() - (((r14.width() / r51) + r21) + (r19.width() / r51));
        r111.y = r14.centerY();
        goto L25
    L24:
        r111.x = r14.centerX();
        float r52 = 2;
        r111.y = r14.centerY() - (((r14.height() / r52) + r21) + (r19.height() / r52));
        goto L25
    L12:
        r8 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }
}
