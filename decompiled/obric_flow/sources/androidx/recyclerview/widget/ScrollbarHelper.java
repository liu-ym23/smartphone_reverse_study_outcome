package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    public static int computeScrollExtent(RecyclerView.State r5, OrientationHelper r10, View r11, View r12, RecyclerView.LayoutManager r13, boolean r14) {
        if (r13.getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (r5.getItemCount() == 0) goto L16;
        if (r11 == null) goto L17;
        if (r12 == null) goto L18;
        if (r14 == false) goto L11;
        int r15 = r10.getDecoratedEnd(r12) - r10.getDecoratedStart(r11);
        return Math.min(r10.getTotalSpace(), r15);
    L11:
        return Math.abs(r13.getPosition(r11) - r13.getPosition(r12)) + 1;
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static int computeScrollOffset(RecyclerView.State r5, OrientationHelper r10, View r11, View r12, RecyclerView.LayoutManager r13, boolean r14, boolean r15) {
        if (r13.getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r5.getItemCount() == 0) goto L17;
        if (r11 == null) goto L17;
        if (r12 == null) goto L17;
        int r16 = Math.min(r13.getPosition(r11), r13.getPosition(r12));
        int r17 = Math.max(r13.getPosition(r11), r13.getPosition(r12));
        if (r15 == false) goto L12;
        int r18 = Math.max(0, (r5.getItemCount() - r17) - 1);
    L13:
        if (r14 == true) goto L16;
        return r18;
    L16:
        return Math.round((r18 * (Math.abs(r10.getDecoratedEnd(r12) - r10.getDecoratedStart(r11)) / (Math.abs(r13.getPosition(r11) - r13.getPosition(r12)) + 1))) + (r10.getStartAfterPadding() - r10.getDecoratedStart(r11)));
    L12:
        r18 = Math.max(0, r16);
        goto L13
    }

    public static int computeScrollRange(RecyclerView.State r5, OrientationHelper r10, View r11, View r12, RecyclerView.LayoutManager r13, boolean r14) {
        if (r13.getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (r5.getItemCount() == 0) goto L16;
        if (r11 == null) goto L17;
        if (r12 == null) goto L18;
        if (r14 == true) goto L13;
        return r5.getItemCount();
    L13:
        return (int) (((r10.getDecoratedEnd(r12) - r10.getDecoratedStart(r11)) / (Math.abs(r13.getPosition(r11) - r13.getPosition(r12)) + 1)) * r5.getItemCount());
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }
}
