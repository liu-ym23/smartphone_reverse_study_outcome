package com.larus.bmhome.chat.standarduikit.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import hn8.f;
import hn8.g;
import hn8.h;
import hn8.i;
import hn8.k;
import hn8.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kc8.j0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001>B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0004H\u0017J(\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0014J\u0018\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014J\u001a\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\n2\b\b\u0002\u0010/\u001a\u00020\u001fH\u0002J\u0010\u00100\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u00101\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0002J\b\u00102\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0002J\u0014\u00105\u001a\u00020\"2\n\b\u0002\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002J\u0018\u0010:\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020<H\u0002R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/search/view/PureVideoView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/search/view/SearchListContainerInput;", "Lcom/larus/bmhome/chat/standarduikit/search/view/SearchListContainerOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "columnSize", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "videoCardAdapter", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardAdapter;", "getVideoCardAdapter", "()Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardAdapter;", "videoCardAdapter$delegate", "Lkotlin/Lazy;", "gridColumnSize", "gridMarginStart", "gridSpaceHorizontal", "gridSpaceVertical", "gridMarginEnd", "gridMarginTop", "gridMarginBottom", "shareSelectReservedWidth", "columnGridItemDecoration", "Lcom/larus/bmhome/chat/standarduikit/search/view/ColumnGridItemDecoration;", "currentShareMode", "", "lastContainerWidth", "bindData", "", "input", "output", "onSizeChanged", "w", "h", "oldw", "oldh", "onMeasure", "widthSpec", "heightSpec", "updateAdaptiveItemWidth", "recyclerWidth", "requestRelayout", "calculateAdaptiveItemWidth", "resolveWidthMeasureSpec", "resolveMeasuredRecyclerWidth", "resolveRecyclerWidth", "containerWidth", "updateColumnGridDecoration", "config", "Lcom/larus/bmhome/chat/block/base/config/PureVideoColumnGridDecorationConfig;", "calculateWrapContentHeight", "itemWidth", "calculateAdaptiveItemHeight", "mode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "isShareMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PureVideoView extends RecyclerView {
    public static final /* synthetic */ int m = 0;
    public final Lazy a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final int i;
    public ColumnGridItemDecoration j;
    public boolean k;
    public int l;

    public static final class a {
    }

    static {
    }

    public PureVideoView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public PureVideoView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public PureVideoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    private final VideoCardAdapter getVideoCardAdapter() {
        return (VideoCardAdapter) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int t(int r5) {
        if (r5 > 0) goto L5;
        return 0;
    L5:
        int r0 = ((getPaddingLeft() + getPaddingRight()) + this.c) + this.f;
        int r1 = this.d;
        int r2 = this.b;
        return (r5 - (r0 + (r1 * (r2 - 1)))) / RangesKt.coerceAtLeast(r2, 1);
    }

    public final void v(j0 r9) {
        if (r9 == null) goto L6;
        Integer r0 = r9.a;
        if (r0 == null) goto L6;
        int r1 = r0.intValue();
    L7:
        if (r9 == null) goto L11;
        Integer r2 = r9.b;
        if (r2 == null) goto L11;
        int r3 = r2.intValue();
    L12:
        if (r9 == null) goto L16;
        Integer r4 = r9.c;
        if (r4 == null) goto L16;
        int r5 = r4.intValue();
    L17:
        if (r9 == null) goto L21;
        Integer r6 = r9.d;
        if (r6 == null) goto L21;
        int r7 = r6.intValue();
    L22:
        boolean r8 = false;
        if (r9 == null) goto L27;
        Integer r10 = r9.e;
        if (r10 == null) goto L27;
        int r11 = r10.intValue();
    L28:
        if (r9 == null) goto L32;
        Integer r12 = r9.f;
        if (r12 == null) goto L32;
        int r13 = r12.intValue();
    L34:
        if (r1 == this.c) goto L36;
    L47:
        r8 = true;
    L48:
        if (r8 == true) goto L50;
        return;
    L50:
        this.c = r1;
        this.d = r3;
        this.e = r5;
        this.g = r11;
        this.f = r7;
        this.h = r13;
        ColumnGridItemDecoration r14 = this.j;
        if (r14 == null) goto L53;
        removeItemDecoration(r14);
    L53:
        ColumnGridItemDecoration r15 = new ColumnGridItemDecoration(this.b, this.c, this.d, this.e, this.g, this.f, this.h);
        this.j = r15;
        addItemDecoration(r15);
        invalidateItemDecorations();
        return;
    L36:
        if (r3 != this.d) goto L47;
        if (r5 != this.e) goto L47;
        if (r11 != this.g) goto L47;
        if (r7 != this.f) goto L47;
        if (r13 != this.h) goto L47;
        if (this.j != null) goto L48;
    L32:
        r13 = 0;
    L27:
        r11 = 0;
    L21:
        r7 = i5.h();
    L16:
        r5 = i5.r0();
    L11:
        r3 = i5.r0();
    L6:
        r1 = i5.h();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r11, int r12) {
        int r0 = View.MeasureSpec.getSize(r11);
        if (r0 <= 0) goto L6;
        this.l = r0;
    L6:
        if (r0 > 0) goto L9;
    L11:
        int r2 = r0;
    L13:
        if (r2 <= 0) goto L17;
        if (r2 == r0) goto L17;
        r11 = View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
    L17:
        u(View.MeasureSpec.getSize(r11), false);
        super.onMeasure(r11, r12);
        if (View.MeasureSpec.getMode(r12) != 1073741824) goto L20;
        return;
    L20:
        Integer r1 = Integer.valueOf(getMeasuredWidth());
        if (r1.intValue() <= 0) goto L23;
        boolean r3 = true;
    L24:
        if (r3 == true) goto L27;
        r1 = null;
    L27:
        if (r1 == null) goto L29;
        int r13 = r1.intValue();
    L30:
        int r14 = t(r13);
        if (r14 > 0) goto L33;
        return;
    L33:
        List r4 = getVideoCardAdapter().getCurrentList();
        if (r4.isEmpty() == false) goto L36;
        int r15 = getPaddingTop();
        int r5 = getPaddingBottom();
    L51:
        setMeasuredDimension(getMeasuredWidth(), ViewGroup.resolveSize(r15 + r5, r12));
        return;
    L36:
        int r6 = RangesKt.coerceAtLeast(this.b, 1);
        int r7 = ((r4.size() + r6) - 1) / r6;
        Iterator r8 = CollectionsKt.chunked(r4, r6).iterator();
        int r9 = 0;
    L38:
        if (r8.hasNext() == false) goto L50;
        Iterator r10 = ((List) r8.next()).iterator();
        if (r10.hasNext() == false) goto L49;
        ExpandCardViewMode r16 = ((l) r10.next()).b;
        int r17 = PureVideoItemView.g;
        PureVideoItemView.a r18 = PureVideoItemView.b.a(r16);
        int r19 = r18.a;
        float r20 = r14;
        int r21 = RangesKt.coerceAtLeast(MathKt.roundToInt(r18.b * (r20 / r19)), 1);
    L43:
        if (r10.hasNext() == false) goto L47;
        ExpandCardViewMode r22 = ((l) r10.next()).b;
        int r23 = PureVideoItemView.g;
        PureVideoItemView.a r24 = PureVideoItemView.b.a(r22);
        int r25 = r24.a;
        int r26 = RangesKt.coerceAtLeast(MathKt.roundToInt(r24.b * (r20 / r25)), 1);
        if (r21 >= r26) goto L43;
        r21 = r26;
        goto L43
    L47:
        r9 = r9 + r21;
        goto L38
    L49:
        throw new NoSuchElementException();
    L50:
        r15 = (((getPaddingTop() + getPaddingBottom()) + r9) + (this.e * RangesKt.coerceAtLeast(r7 - 1, 0))) + this.g;
        r5 = this.h;
        goto L51
    L29:
        r13 = View.MeasureSpec.getSize(r11);
        goto L30
    L23:
        r3 = false;
        goto L24
    L9:
        if (this.k == false) goto L11;
        r2 = RangesKt.coerceAtLeast(r0 - this.i, 0);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(h r6, i r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "output");
        List<l> r0 = r6.a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L19;
        ExpandCardViewMode r2 = ((l) r1.next()).b;
        if (r2 != ExpandCardViewMode.NORMAL_SHARE) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L9;
        boolean r4 = true;
    L21:
        if (this.k == r4) goto L23;
        boolean r5 = true;
    L24:
        this.k = r4;
        v(r6.b);
        Integer r8 = Integer.valueOf(this.l);
        if (r8.intValue() <= 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L33;
        int r10 = r8.intValue();
    L34:
        if (r10 > 0) goto L37;
    L39:
        u(r10, true);
        VideoCardAdapter r11 = getVideoCardAdapter();
        k r12 = r7.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "videoCardViewCallback");
        r11.a = r12;
        getVideoCardAdapter().submitList(r6.a, new g(this));
        if (r5 == false) goto L48;
        requestLayout();
        return;
    L48:
        return;
    L37:
        if (this.k == false) goto L39;
        r10 = RangesKt.coerceAtLeast(r10 - this.i, 0);
        goto L39
    L33:
        r10 = getWidth();
        goto L34
    L27:
        r9 = false;
        goto L28
    L23:
        r5 = false;
        goto L24
    L13:
        if (r2 == ExpandCardViewMode.EXPAND_SHARE) goto L16;
        r3 = false;
    L19:
        r4 = false;
        goto L21
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final void u(int r3, boolean r4) {
        int r5 = t(r3);
        if (r5 <= 0) goto L14;
        VideoCardAdapter r0 = getVideoCardAdapter();
        if (r5 > 0) goto L7;
        r0.getClass();
    L11:
        if (r4 == false) goto L15;
        requestLayout();
        return;
    L15:
        return;
    L7:
        if (r0.b == r5) goto L11;
        r0.b = r5;
        r0.notifyItemRangeChanged(0, r0.getItemCount());
        goto L11
    }

    public PureVideoView(Context r4, AttributeSet r5, int r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        int r8 = 2;
    L12:
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = LazyKt.lazy(new f());
        this.b = r8;
        this.c = i5.h();
        this.d = i5.r0();
        this.e = i5.r0();
        this.f = i5.h();
        this.i = i5.Q();
        setAdapter(getVideoCardAdapter());
        setLayoutManager(new GridLayoutManager(r4, r8, 1, false));
        v(null);
        return;
    L11:
        r8 = 0;
        goto L12
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        u(r1, true);
    }
}
