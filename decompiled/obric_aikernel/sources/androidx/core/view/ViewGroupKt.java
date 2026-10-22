package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<View>, KMutableIterator {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        AnonymousClass1(ViewGroup r10) {
            this.$this_iterator = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup r10 = this.$this_iterator;
            int r11 = this.index;
            this.index = r11 + 1;
            View r12 = r10.getChildAt(r11);
            if (r12 == null) goto L6;
            return r12;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ View next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup r10 = this.$this_iterator;
            int r11 = this.index - 1;
            this.index = r11;
            r10.removeViewAt(r11);
        }
    }

    public static final boolean contains(ViewGroup r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "view");
        if (r10.indexOfChild(r11) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(ViewGroup r10, Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        View r14 = r10.getChildAt(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "getChildAt(index)");
        r11.invoke(r14);
        r13 = r13 + 1;
        goto L3
    }

    public static final void forEachIndexed(ViewGroup r10, Function2<? super Integer, ? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Integer r14 = Integer.valueOf(r13);
        View r15 = r10.getChildAt(r13);
        Intrinsics.checkNotNullExpressionValue(r15, "getChildAt(index)");
        r11.invoke(r14, r15);
        r13 = r13 + 1;
        goto L3
    }

    public static final View get(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        View r12 = r10.getChildAt(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IndexOutOfBoundsException("Index: " + r11 + ", Size: " + r10.getChildCount());
    }

    public static final Sequence<View> getChildren(final ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ViewGroupKt$children$1(r10);
    }

    public static final Sequence<View> getDescendants(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.sequence(new ViewGroupKt$descendants$1(r10, null));
    }

    public static final IntRange getIndices(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return RangesKt.until(0, r10.getChildCount());
    }

    public static final int getSize(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getChildCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getChildCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<View> iterator(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final void minusAssign(ViewGroup r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "view");
        r10.removeView(r11);
    }

    public static final void plusAssign(ViewGroup r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "view");
        r10.addView(r11);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams r10, @Px int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setMargins(r11, r11, r11, r11);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams r10, @Px int r11, @Px int r12, @Px int r13, @Px int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setMargins(r11, r12, r13, r14);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams r10, int r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.leftMargin;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.topMargin;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.rightMargin;
    L12:
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.bottomMargin;
    L14:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setMargins(r11, r12, r13, r14);
    }

    @RequiresApi(17)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams r10, @Px int r11, @Px int r12, @Px int r13, @Px int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setMarginStart(r11);
        r10.topMargin = r12;
        r10.setMarginEnd(r13);
        r10.bottomMargin = r14;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams r10, int r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.getMarginStart();
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.topMargin;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.getMarginEnd();
    L12:
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.bottomMargin;
    L14:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setMarginStart(r11);
        r10.topMargin = r12;
        r10.setMarginEnd(r13);
        r10.bottomMargin = r14;
    }
}
