package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u0001FB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000bH\u0002J5\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0018\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0004H\u0017J\u001a\u00101\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u00102\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020'2\u0006\u00100\u001a\u00020\u0003H\u0002J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u000fH\u0002J\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b072\u0006\u00108\u001a\u000209H\u0002J\u000e\u0010:\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0003J\"\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=070<2\u0006\u0010>\u001a\u00020\u000bH\u0002J,\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=070<2\u0006\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010@\u001a\u00020\u000fH\u0002J\u0014\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0BH\u0002J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u000bH\u0002J\u001a\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=070<H\u0002R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/vlm/view/VLMContainerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/FlowVLMContainerViewInput;", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/FlowVLMContainerViewOutput;", "Lcom/larus/business/markdown/api/view/IMarkdownMarginFreeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableNewStyle", "", "getEnableNewStyle", "()Z", "enableNewStyle$delegate", "Lkotlin/Lazy;", "IMAGE_BETWEEN_MARGIN", "getIMAGE_BETWEEN_MARGIN", "()I", "IMAGE_BETWEEN_MARGIN$delegate", "IMAGE_CONTINAER_MARGIN", "WIDGET_EXTRA_HEIGHT", "spanSize", "Landroid/util/Size;", "haveInit", "vlmImageAdapter", "Lcom/larus/bmhome/chat/standarduikit/vlm/view/VlmImageAdapter;", "output", "isExtraHeightForbidden", "reduceMarginStart", "isVideoGroup", "reducedMarginStart", "updateReducedMarginStart", "newValue", "onMarkdownMarginChanged", "", "left", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getWidgetExtraHeight", "getImageContainerMargin", "bindData", "input", "sizeThatFits", "preferredMaxWidth", "tryInitRecyclerView", "setupRecyclerViewItemDecoration", "isSingleImage", "calPaddingValues", "Lkotlin/Pair;", "uiConfig", "Lcom/larus/bmhome/chat/standarduikit/vlm/viewmodel/VLMContainerUIConfig;", "getWidgetHeight", "dynamicGetRestoreView", "", "Landroid/view/View;", "indexInImageList", "doDynamicGetRestoreView", "enableScroll", "generateImageIndexToViewHolderIndex", "", "onUserScrollImage", "userScrollPos", "generateImageViews", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VLMContainerView extends RecyclerView implements nw8.a {
    public static final /* synthetic */ int k = 0;
    public final Lazy a;
    public final Lazy b;
    public final int c;
    public final int d;
    public volatile boolean e;
    public VlmImageAdapter f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowVLMContainerViewType.values().length];
            r0[FlowVLMContainerViewType.SingleItem.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FlowVLMContainerViewType.MultipleItem.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public VLMContainerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VLMContainerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final boolean getEnableNewStyle() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    private final int getIMAGE_BETWEEN_MARGIN() {
        return ((Number) this.b.getValue()).intValue();
    }

    private final int getWidgetExtraHeight() {
        if (this.g == false) goto L6;
        return 0;
    L6:
        return this.d;
    }

    public final Map<Integer, Integer> y() {
        LinkedHashMap r0 = new LinkedHashMap();
        VlmImageAdapter r1 = this.f;
        if (r1 == null) goto L19;
        List<l> r2 = r1.a;
        if (r2 == null) goto L19;
        Iterator<T> r3 = r2.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L19;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        l r7 = (l) r5;
        if (r7.h != RenderType.Picture) goto L18;
        Integer r8 = Integer.valueOf(r4);
        r0.put(Integer.valueOf(r7.i.c), r8);
        Iterator<T> r9 = r7.i.d.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r0.put(Integer.valueOf(((Number) r9.next()).intValue()), Integer.valueOf(r4));
    L18:
        r4 = r6;
    L19:
        return r0;
    }

    public final List<Pair<Integer, View>> z() {
        LinearLayoutManager r0 = getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.findFirstVisibleItemPosition();
        int r3 = r1.findLastVisibleItemPosition();
        ArrayList r4 = new ArrayList();
        if (r2 > r3) goto L30;
    L11:
        RecyclerView.ViewHolder r5 = findViewHolderForAdapterPosition(r2);
        if (r5 == null) goto L29;
        View r6 = r5.itemView;
        if (r6 == null) goto L29;
        VlmImageAdapter r7 = this.f;
        if (r7 == null) goto L27;
        l r8 = (l) CollectionsKt.getOrNull(r7.a, r2);
        if (r8 == null) goto L27;
        if (r8.h != RenderType.Picture) goto L24;
        r4.add(new Pair(Integer.valueOf(r8.i.c), r6));
    L24:
        if (r2 == r3) goto L30;
        r2 = r2 + 1;
    L27:
        return CollectionsKt.emptyList();
    L29:
        return CollectionsKt.emptyList();
    L30:
        return r4;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    private final int getImageContainerMargin() {
        return this.c;
    }

    public static int r(VLMContainerView r1) {
        if (r1.getEnableNewStyle() == false) goto L5;
    L8:
        int r2 = 4;
    L10:
        return c7.b(Integer.valueOf(r2));
    L5:
        if (r1.i == true) goto L8;
        r2 = 8;
        goto L10
    }

    private final void setupRecyclerViewItemDecoration(final boolean r2) {
        addItemDecoration(new AnonymousClass1(r2, this));
    }

    public static final /* synthetic */ int t(VLMContainerView r0) {
        return r0.getIMAGE_BETWEEN_MARGIN();
    }

    public static final /* synthetic */ int u(VLMContainerView r0) {
        return r0.getImageContainerMargin();
    }

    public static Pair w(do8.j r1) {
        if (r1.b == true) goto L6;
        return TuplesKt.to(0, 0);
    L6:
        if (r1.c == false) goto L9;
        return TuplesKt.to(Integer.valueOf(i5.Y()), Integer.valueOf(i5.q()));
    L9:
        if (r1.d == false) goto L12;
        return TuplesKt.to(Integer.valueOf(i5.q()), Integer.valueOf(i5.Y()));
    L12:
        return TuplesKt.to(Integer.valueOf(i5.q()), Integer.valueOf(i5.r0()));
    }

    public final int A(com.larus.bmhome.chat.standarduikit.vlm.view.a r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        FlowVLMContainerViewType r0 = r4.b;
        int r1 = b.a[r0.ordinal()];
        int r2 = 0;
        if (r1 != 1) goto L5;
    L7:
        l r5 = (l) CollectionsKt.firstOrNull(r4.c);
        if (r5 == null) goto L13;
        Size r6 = r5.c;
        if (r6 == null) goto L13;
        r2 = r6.getHeight();
    L13:
        return r2 + getWidgetExtraHeight();
    L5:
        if (r1 == 2) goto L7;
        return 0;
    }

    public final Size B(com.larus.bmhome.chat.standarduikit.vlm.view.a r5, int r6) {
        int r0 = 0;
        if (r5 == null) goto L5;
        Function0<Integer> r1 = r5.d.f;
        if (r1 == null) goto L9;
        r6 = Math.min(r6, ((Number) r1.invoke()).intValue());
    L9:
        Pair r2 = w(r5.d);
        FlowVLMContainerViewType r3 = r5.b;
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L12;
    L14:
        l r7 = (l) CollectionsKt.getOrNull(r5.c, 0);
        if (r7 == null) goto L20;
        Size r8 = r7.c;
        if (r8 == null) goto L20;
        r0 = r8.getHeight();
    L20:
        return new Size(r6, ((r0 + getWidgetExtraHeight()) + ((Number) r2.getFirst()).intValue()) + ((Number) r2.getSecond()).intValue());
    L12:
        if (r4 == 2) goto L14;
        return new Size(0, 0);
    L5:
        return new Size(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(com.larus.bmhome.chat.standarduikit.vlm.view.a r5, final com.larus.bmhome.chat.standarduikit.vlm.view.b r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        do8.j r0 = r5.d;
        this.i = r0.e;
        this.g = r0.b;
        this.h = r0.a;
        Pair r1 = w(r0);
        int r2 = ((Number) r1.getFirst()).intValue();
        int r3 = ((Number) r1.getSecond()).intValue();
        setPaddingRelative(getPaddingStart(), r2, getPaddingEnd(), r3);
        if (this.e == true) goto L8;
        VlmImageAdapter r4 = new VlmImageAdapter();
        this.f = r4;
        setAdapter(r4);
        boolean r7 = false;
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ExposeXTrackerExtKt.c(this);
        if (r5.b != FlowVLMContainerViewType.SingleItem) goto L7;
        r7 = true;
    L7:
        setupRecyclerViewItemDecoration(r7);
        this.e = true;
    L8:
        invalidateItemDecorations();
        VlmImageAdapter r8 = this.f;
        if (r8 == null) goto L11;
        List<l> r9 = r5.c;
        Intrinsics.checkNotNullParameter(r9, "vlmVlmRenderInfoList");
        r8.a = r9;
    L11:
        VlmImageAdapter r10 = this.f;
        if (r10 == null) goto L14;
        r10.e = r5.a;
    L14:
        if (r10 == null) goto L16;
        r10.b = new g(this, r6);
    L16:
        if (r10 == null) goto L18;
        r10.c = new h(r6);
    L18:
        if (r10 == null) goto L20;
        r10.d = new i(r6);
    L20:
        if (r10 == null) goto L23;
        r10.notifyDataSetChanged();
        return;
    }

    public final List<Pair<Integer, View>> x(int r5, boolean r6) {
        LinearLayoutManager r0 = getLayoutManager();
        Integer r2 = null;
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
    L6:
        Map<Integer, Integer> r3 = y();
        if (r1 == null) goto L9;
        Integer r4 = Integer.valueOf(r1.findFirstCompletelyVisibleItemPosition());
    L10:
        if (r1 == null) goto L12;
        r2 = Integer.valueOf(r1.findLastCompletelyVisibleItemPosition());
    L12:
        if (r4 == null) goto L30;
        if (r2 == null) goto L30;
        Integer r7 = (Integer) ((LinkedHashMap) r3).get(Integer.valueOf(r5));
        if (r7 == null) goto L28;
        int r8 = r7.intValue();
        if (r8 >= r4.intValue()) goto L20;
    L23:
        if (r6 == false) goto L26;
        scrollToPosition(r8);
    L26:
        return z();
    L20:
        if (r8 > r2.intValue()) goto L23;
        return z();
    L28:
        return CollectionsKt.emptyList();
    L30:
        return CollectionsKt.emptyList();
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public VLMContainerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new d());
        this.b = LazyKt.lazy(new e(this));
        this.c = c7.b(16);
        this.d = c7.b(12);
        new Size(0, 0);
    }

    public /* synthetic */ VLMContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nw8.a
    public final void k(Integer r8, Integer r9, Integer r10, Integer r11) {
        ViewGroup.LayoutParams r12 = getLayoutParams();
        Integer r0 = null;
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
    L6:
        boolean r2 = true;
        if (getLayoutDirection() != 0) goto L28;
        if (r8 == null) goto L28;
        if (r8.intValue() <= 0) goto L28;
        if (this.h == false) goto L20;
        int r14 = r8.intValue();
        if (this.h == false) goto L28;
        int r15 = Math.max(r14 - this.c, 0);
        if (this.j == r15) goto L28;
        FLogger.a.i("VLMContainerView", "updateReducedMarginStart, margin[" + r14 + "] -> reducedMargin[" + r15 + ']');
        this.j = r15;
        post(new k(this));
        boolean r16 = true;
    L29:
        boolean r17 = false;
    L30:
        if (r9 == null) goto L38;
        if (r13 == null) goto L34;
        r0 = Integer.valueOf(r13.topMargin);
    L34:
        if (Intrinsics.areEqual(r9, r0) == true) goto L38;
        if (r13 == null) goto L37;
        r13.topMargin = r9.intValue();
    L37:
        FLogger.a.i("VLMContainerView", "onMarkdownMarginChanged: top = " + r9);
        r16 = true;
        r17 = true;
    L38:
        if (r17 == false) goto L41;
        requestLayout();
    L41:
        if (r16 == false) goto L44;
        setVisibility(4);
        post(new j(this));
        return;
    L44:
        if (getVisibility() == 4) goto L47;
        r2 = false;
    L47:
        if (r2 == false) goto L51;
        setVisibility(0);
        return;
    L51:
        return;
    L20:
        if (r13 == null) goto L22;
        Integer r18 = Integer.valueOf(r13.leftMargin);
    L24:
        if (Intrinsics.areEqual(r8, r18) == true) goto L28;
        if (r13 == null) goto L27;
        r13.leftMargin = r8.intValue();
    L27:
        FLogger.a.i("VLMContainerView", "onMarkdownMarginChanged: left = " + r8);
        r16 = true;
        r17 = true;
        goto L30
    L22:
        r18 = null;
    L28:
        r16 = false;
        goto L29
    L5:
        r13 = null;
        goto L6
    }
}
