package androidx.core.view;

import ai.j0;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a0\u0010\u0013\u001a\u00020\u0014*\u00020\u00032!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\b\u001aE\u0010\u0019\u001a\u00020\u0014*\u00020\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u001aH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0086\u0002\u001a\r\u0010\u001d\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\r\u0010\u001e\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 *\u00020\u0003H\u0086\u0002\u001a\u0015\u0010!\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\"\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010#\u001a\u00020\u0014*\u00020$2\b\b\u0001\u0010\f\u001a\u00020\rH\u0086\b\u001a5\u0010%\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010&\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010(\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\u0086\b\u001a5\u0010*\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010+\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010,\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\t*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\r*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006-"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Landroid/view/ViewGroup;)Lkotlin/ranges/IntRange;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", OpenPageMethod.ALIGN_LEFT, "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<View>, KMutableIterator {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(ViewGroup r5) {
            this.$this_iterator = r5;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ View next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup r5 = this.$this_iterator;
            int r10 = this.index - 1;
            this.index = r10;
            r5.removeViewAt(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup r5 = this.$this_iterator;
            int r10 = this.index;
            this.index = r10 + 1;
            View r11 = r5.getChildAt(r10);
            if (r11 == null) goto L6;
            return r11;
        L6:
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(ViewGroup r5, View r10) {
        if (r5.indexOfChild(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(ViewGroup r5, Function1<? super View, Unit> r10) {
        int r11 = r5.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.invoke(r5.getChildAt(r12));
        r12 = r12 + 1;
        goto L3
    }

    public static final void forEachIndexed(ViewGroup r5, Function2<? super Integer, ? super View, Unit> r10) {
        int r11 = r5.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.mo2invoke(Integer.valueOf(r12), r5.getChildAt(r12));
        r12 = r12 + 1;
        goto L3
    }

    public static final View get(ViewGroup r5, int r10) {
        View r11 = r5.getChildAt(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        StringBuilder r12 = j0.s(r10, "Index: ", ", Size: ");
        r12.append(r5.getChildCount());
        throw new IndexOutOfBoundsException(r12.toString());
    }

    public static final Sequence<View> getChildren(final ViewGroup r5) {
        return new ViewGroupKt$children$1(r5);
    }

    public static final Sequence<View> getDescendants(final ViewGroup r5) {
        return new ViewGroupKt$special$$inlined$Sequence$1(r5);
    }

    public static final IntRange getIndices(ViewGroup r5) {
        return RangesKt.until(0, r5.getChildCount());
    }

    public static final int getSize(ViewGroup r5) {
        return r5.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup r5) {
        if (r5.getChildCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(ViewGroup r5) {
        if (r5.getChildCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<View> iterator(ViewGroup r5) {
        return new AnonymousClass1(r5);
    }

    public static final void minusAssign(ViewGroup r5, View r10) {
        r5.removeView(r10);
    }

    public static final void plusAssign(ViewGroup r5, View r10) {
        r5.addView(r10);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams r5, @Px int r10) {
        r5.setMargins(r10, r10, r10, r10);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams r5, @Px int r10, @Px int r11, @Px int r12, @Px int r13) {
        r5.setMargins(r10, r11, r12, r13);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams r5, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.leftMargin;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.topMargin;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.rightMargin;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = r5.bottomMargin;
    L14:
        r5.setMargins(r10, r11, r12, r13);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams r5, @Px int r10, @Px int r11, @Px int r12, @Px int r13) {
        r5.setMarginStart(r10);
        r5.topMargin = r11;
        r5.setMarginEnd(r12);
        r5.bottomMargin = r13;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams r5, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.getMarginStart();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.topMargin;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.getMarginEnd();
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = r5.bottomMargin;
    L14:
        r5.setMarginStart(r10);
        r5.topMargin = r11;
        r5.setMarginEnd(r12);
        r5.bottomMargin = r13;
    }
}
