package com.larksuite.common_selection;

import android.graphics.Path;
import android.graphics.Point;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u implements s {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SelectionGranularity.values().length];
            r0[SelectionGranularity.CHARACTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SelectionGranularity.WORD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SelectionGranularity.PARAGRAPH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SelectionGranularity.ALL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public u() {
    }

    @Override // com.larksuite.common_selection.s
    public final boolean i(View r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return true;
    }

    @Override // com.larksuite.common_selection.s
    public final int a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if ((r2 instanceof TextView) == true) goto L7;
        return 1;
    L7:
        return ((TextView) r2).getText().length();
    }

    @Override // com.larksuite.common_selection.s
    public final boolean h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return r2 instanceof TextView;
    }

    @Override // com.larksuite.common_selection.s
    public final float j(o r2) {
        Intrinsics.checkNotNullParameter(r2, "point");
        return 0.0f;
    }

    @Override // com.larksuite.common_selection.s
    public final Point d(o r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "point");
        View r0 = r7.a;
        if ((r0 instanceof TextView) == false) goto L5;
        TextView r1 = (TextView) r0;
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.getLeft();
        int r3 = r1.getTop();
        Point r4 = new Point();
        int r5 = 0;
        if (r1.getLayout() != null) goto L15;
        if (r8 == false) goto L13;
        r5 = r1.getWidth();
    L13:
        r4.x = r2 + r5;
        r4.y = r3 + r1.getHeight();
        return r4;
    L15:
        Layout r9 = r1.getLayout();
        int r10 = RangesKt.coerceIn(r7.b, 0, r1.getText().length());
        int r6 = r9.getLineForOffset(r10);
        float r11 = r9.getPrimaryHorizontal(r10);
        int r12 = r9.getLineBottom(r6);
        r4.x = (r2 + r1.getPaddingLeft()) + ((int) r11);
        r4.y = (r3 + r1.getPaddingTop()) + r12;
        return r4;
    L8:
        return new Point();
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larksuite.common_selection.s
    public final p b(View r20, o r21, SelectionGranularity r22) {
        Intrinsics.checkNotNullParameter(r20, "view");
        Intrinsics.checkNotNullParameter(r21, "point");
        Intrinsics.checkNotNullParameter(r22, "granularity");
        if ((r20 instanceof TextView) == true) goto L5;
        return null;
    L5:
        int r8 = r21.b;
        int r1 = a.a[r22.ordinal()];
        if (r1 != 1) goto L8;
        TextView r2 = (TextView) r20;
        Intrinsics.checkNotNullParameter(r2, "view");
        IntRange r3 = new IntRange(r8, RangesKt.coerceIn(r8 + 1, 0, r2.getText().length()));
    L51:
        if (r3 != null) goto L53;
        return null;
    L53:
        return new p(new o(r20, r3.getFirst()), new o(r20, r3.getLast()));
    L8:
        if (r1 != 2) goto L10;
        CharSequence r4 = ((TextView) r20).getText();
        Intrinsics.checkNotNullParameter(r4, "text");
        if (r8 >= 0) goto L27;
    L49:
        r3 = null;
        goto L51
    L27:
        if (r8 > r4.length()) goto L49;
        if (r8 != r4.length()) goto L32;
    L33:
        if (r8 <= 0) goto L36;
        r8 = r8 - 1;
    L36:
        if (Character.isLetterOrDigit(r4.charAt(r8)) == false) goto L49;
        int r5 = r8;
    L39:
        if (r5 <= 0) goto L44;
        int r6 = r5 - 1;
        if (Character.isLetterOrDigit(r4.charAt(r6)) == false) goto L44;
        r5 = r6;
    L44:
        if (r8 >= (r4.length() - 1)) goto L48;
        int r7 = r8 + 1;
        if (Character.isLetterOrDigit(r4.charAt(r7)) == false) goto L48;
        r8 = r7;
    L48:
        r3 = new IntRange(r5, r8 + 1);
        goto L51
    L32:
        if (Character.isLetterOrDigit(r4.charAt(r8)) == true) goto L36;
    L10:
        if (r1 != 3) goto L12;
        CharSequence r9 = ((TextView) r20).getText();
        if (r8 < 0) goto L49;
        if (r8 > r9.length()) goto L49;
        String r10 = r9.toString();
        int r11 = StringsKt.lastIndexOf$default(r10, '\n', r8 - 1, false, 4, null) + 1;
        int r12 = StringsKt.indexOf$default(r10, '\n', r8, false, 4, null);
        if (r12 != (-1)) goto L23;
        r12 = r9.length();
    L23:
        r3 = new IntRange(r11, r12);
        goto L51
    L12:
        if (r1 != 4) goto L49;
        r3 = new IntRange(0, ((TextView) r20).getText().length());
        goto L51
    }

    @Override // com.larksuite.common_selection.s
    public final e c(View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if ((r3 instanceof TextView) == true) goto L5;
        return null;
    L5:
        CharSequence r6 = ((TextView) r3).getText();
        if (r4 >= 0) goto L8;
    L13:
        return null;
    L8:
        if (r5 > r6.length()) goto L13;
        if (r4 > r5) goto L13;
        return new e(r6.subSequence(r4, r5));
    }

    @Override // com.larksuite.common_selection.s
    public final o g(View r9, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r9, "view");
        int r2 = 0;
        if ((r9 instanceof TextView) == false) goto L22;
        TextView r0 = (TextView) r9;
        if (r0.getLayout() == null) goto L22;
        Layout r1 = r0.getLayout();
        int r12 = r1.getLineForVertical(RangesKt.coerceIn((int) r11, 0, r1.getHeight() - 1));
        int r4 = r1.getOffsetForHorizontal(r12, r10);
        if (r4 >= (r1.getText().length() - 1)) goto L20;
        Intrinsics.checkNotNull(r1);
        int r5 = r4 + 1;
        if (r5 > 0) goto L13;
    L15:
        if (r2 == 0) goto L20;
        float r3 = r1.getPrimaryHorizontal(r4);
        float r13 = r1.getLineRight(r12);
        if (r10 <= (r13 - ((r13 - r3) / 2))) goto L20;
        r4 = r5;
        goto L20
    L13:
        if (r1.getLineForOffset(r5) <= r1.getLineForOffset(r5 - 1)) goto L15;
        r2 = 1;
    L20:
        return new o(r9, r4);
    L22:
        if (r10 < (r9.getWidth() / 2)) goto L26;
        r2 = 1;
    L26:
        return new o(r9, r2);
    }

    @Override // com.larksuite.common_selection.s
    public final void e(View r10, int r11, int r12, Path r13) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r13, "outPath");
        if ((r10 instanceof TextView) == false) goto L16;
        TextView r0 = (TextView) r10;
        if (r0.getLayout() == null) goto L16;
        Layout r14 = r0.getLayout();
        int r15 = RangesKt.coerceIn(r11, 0, r14.getText().length());
        int r16 = RangesKt.coerceIn(r12, 0, r14.getText().length());
        r13.reset();
        if (r15 >= r16) goto L18;
        r14.getSelectionPath(r15, r16, r13);
        int r1 = r14.getLineForOffset(r16 - 1);
        float r7 = r14.getLineBottom(r1);
        int r17 = RangesKt.coerceAtLeast(r14.getLineStart(r1), r15);
        int r19 = RangesKt.coerceAtMost(r14.getLineEnd(r1), r16);
        float r4 = r14.getPrimaryHorizontal(r17);
        float r6 = r14.getPrimaryHorizontal(r19);
        float r5 = r14.getLineTop(r1) + r14.getLineDescent(r1);
        if (r7 > r5) goto L12;
    L14:
        r13.offset(r0.getPaddingLeft(), r0.getPaddingTop());
        return;
    L12:
        if (r6 <= r4) goto L14;
        r13.addRect(r4, r5, r6, r7, Path.Direction.CW);
        goto L14
    L18:
        return;
    L16:
        r13.reset();
        r13.addRect(0.0f, 0.0f, r10.getWidth(), r10.getHeight(), Path.Direction.CW);
    }

    @Override // com.larksuite.common_selection.s
    public final float f(View r3, float r4, float r5, o r6) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r6, "point");
        if ((r3 instanceof TextView) == false) goto L16;
        TextView r7 = (TextView) r3;
        if (r7.getLayout() == null) goto L18;
        Layout r8 = r7.getLayout();
        int r9 = r6.b;
        float r0 = r8.getPrimaryHorizontal(r9);
        int r10 = r8.getLineForOffset(r9);
        float r1 = r8.getLineTop(r10);
        float r11 = r8.getLineBottom(r10);
        if (r5 >= r1) goto L11;
        float r2 = r1 - r5;
    L14:
        float r12 = r4 - r0;
        return (r12 * r12) + (r2 * r2);
    L11:
        if (r5 <= r11) goto L13;
        r2 = r5 - r11;
        goto L14
    L13:
        r2 = 0.0f;
        goto L14
    L18:
        return Float.MAX_VALUE;
    L16:
        return Float.MAX_VALUE;
    }
}
