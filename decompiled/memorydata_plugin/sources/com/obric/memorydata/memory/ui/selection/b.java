package com.obric.memorydata.memory.ui.selection;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.selection.SelectionPanelItemView;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016Jp\u0010\u001e\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001226\u0010 \u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00010!2\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b0!2\u0006\u0010&\u001a\u00020'H\u0016J\u0080\u0001\u0010(\u001a\u00020\u001b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u001226\u0010 \u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00010!2\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b0!2\u0006\u0010&\u001a\u00020'2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010+H\u0016J2\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0002Jx\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020-2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u001226\u0010 \u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00010!2\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b0!2\u0006\u0010&\u001a\u00020'H\u0002J\u007f\u00103\u001a\u00020\u001b2\u0006\u0010$\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u001726\u0010 \u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00010!2\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b0!2\u0006\u0010&\u001a\u00020'2\u0006\u00105\u001a\u00020'H\u0002¢\u0006\u0002\u00106J\u0015\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020\u001bH\u0002J\u0010\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>H\u0002J\u001e\u0010?\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001b0AH\u0002J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010C\u001a\u00020\u001bH\u0016J\u0010\u0010D\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0016J\u0017\u0010E\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010FJ\u000e\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006I"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/NestedScrollContainer;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "Lcom/obric/memorydata/memory/ui/selection/SelectionContainer;", "context", "Landroid/content/Context;", "dividerProvider", "Lcom/obric/memorydata/memory/ui/selection/DividerProvider;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/memory/ui/selection/DividerProvider;)V", "scrollView", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "itemContainer", "Landroid/widget/LinearLayout;", "_itemViews", "", "currentItems", "", "itemViews", "getItemViews", "()Ljava/util/List;", "itemCount", "", "getItemCount", "()I", "attach", "", "parent", "Landroid/view/ViewGroup;", "setItems", "items", "itemFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "item", "onItemClick", "isMultiSelect", "", "updateItems", "newItems", "diffCallback", "Lcom/obric/memorydata/memory/ui/selection/SelectionDiffCallback;", "calculateDiff", "Lcom/obric/memorydata/memory/ui/selection/SelectionDiffResult;", "oldList", "newList", "callback", "applyDiffResult", "diffResult", "addItemView", "index", "animate", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZ)V", "createItemWrapper", "itemView", "(Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;)Landroid/widget/LinearLayout;", "removeItemViewAt", "updateDividers", "animateInsert", "view", "Landroid/view/View;", "animateRemove", "onEnd", "Lkotlin/Function0;", "animateUpdate", "clearItems", "updateSelectMode", "getItemViewAt", "(I)Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "setScrollViewHeight", "height", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b<T, V extends SelectionPanelItemView<T>> implements e<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f11388b;
    private ONestedScrollView c;
    private LinearLayout d;
    private final List<V> e;
    private List<? extends T> f;

    public b(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f11387a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.f11388b = r6;
        this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f = CollectionsKt.emptyList();
    }

    private final LinearLayout a(V r7) {
        LinearLayout r0 = new LinearLayout(this.f11387a);
        r0.setOrientation(1);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r0.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
        View r8 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, 1);
        a r1 = this.f11388b;
        if (r1 == null) goto L7;
        Pair<Integer, Integer> r3 = r1.getDividerMargins();
        if (r3 == null) goto L7;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r3.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        r2.setMarginStart(r4);
        r2.setMarginEnd(r5);
    L7:
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        a r6 = this.f11388b;
        if (r6 == null) goto L10;
        int r9 = r6.getDividerColor();
    L11:
        r8.setBackgroundColor(r9);
        r8.setVisibility(8);
        r8.setTag("divider");
        r0.addView(r8);
        return r0;
    L10:
        r9 = -2039584;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final g a(List<? extends T> r12, List<? extends T> r13, f<T> r14) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        g r16 = new g();
        int r0 = r11.size();
        int r1 = r15.size();
        boolean[] r2 = new boolean[r0];
        boolean[] r3 = new boolean[r1];
        int r4 = Math.min(r0, r1);
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r6 >= r4) goto L11;
        if (r14.a(r11.get(r6), r15.get(r6)) == false) goto L10;
        r2[r6] = true;
        r3[r6] = true;
        if (r14.b(r11.get(r6), r15.get(r6)) == true) goto L10;
        r16.c().add(Integer.valueOf(r6));
    L10:
        r6 = r6 + 1;
        goto L4
    L11:
        int r7 = r0 - 1;
    L13:
        if ((-1) >= r7) goto L31;
        if (r2[r7] == true) goto L30;
        int r8 = 0;
    L17:
        if (r8 >= r1) goto L27;
        if (r3[r8] == true) goto L26;
        if (r14.a(r11.get(r7), r15.get(r8)) == false) goto L26;
        r3[r8] = true;
        r2[r7] = true;
        r16.d().add(new Pair(Integer.valueOf(r7), Integer.valueOf(r8)));
        if (r14.b(r11.get(r7), r15.get(r8)) == true) goto L25;
        r16.c().add(Integer.valueOf(r8));
    L25:
        boolean r9 = true;
    L28:
        if (r9 == true) goto L30;
        r16.a().add(Integer.valueOf(r7));
    L26:
        r8 = r8 + 1;
        goto L17
    L27:
        r9 = false;
    L30:
        r7 = r7 - 1;
    L31:
        if (r5 >= r1) goto L36;
        if (r3[r5] == true) goto L35;
        r16.b().add(Integer.valueOf(r5));
    L35:
        r5 = r5 + 1;
        goto L31
    L36:
        return r16;
    }

    private static final Unit a(b r0, View r1) {
        LinearLayout r2 = r0.d;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
        r2 = null;
    L5:
        r2.removeView(r1);
        return Unit.INSTANCE;
    }

    private final void a(int r5, boolean r6) {
        boolean r0 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        LinearLayout r1 = this.d;
        LinearLayout r2 = null;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
        r1 = null;
    L12:
        final View r3 = r1.getChildAt(r5);
        this.e.remove(r5);
        if (r6 == false) goto L16;
        if (r3 == null) goto L16;
        a(r3, new $$Lambda$b$dTwSo6PDy94Wyy0V1HtoblFg7Y(this, r3));
        return;
    L16:
        LinearLayout r4 = this.d;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
    L20:
        r2.removeViewAt(r5);
        return;
    L19:
        r2 = r4;
        goto L20
    L5:
        if (r5 >= ((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r0 = true;
        goto L7
    }

    private final void a(View r3) {
        r3.setAlpha(0.0f);
        r3.setTranslationY(-RangesKt.coerceAtLeast(r3.getHeight(), 50.0f));
        r3.animate().alpha(1.0f).translationY(0.0f).setDuration(250).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).start();
    }

    private final void a(View r4, Function0<Unit> r5) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        r4.animate().alpha(0.0f).translationX(r4.getWidth()).setDuration(200).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$b$9RzhBIvVMKDaoOICOAblnTxjhQI(r3)).start();
    }

    private static final void a(b r1, SelectionPanelItemView r2, Function2 r3, View r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        int r6 = r1.e.indexOf(r2);
        if (r6 < 0) goto L6;
        r5.invoke(r2, Integer.valueOf(r6));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(g r10, List<? extends T> r11, Function2<? super Context, ? super T, ? extends V> r12, Function2<? super V, ? super Integer, Unit> r13, boolean r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Function2 r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        Function2 r17 = (Function2) ZeusTransformUtils.wrapperContextForParams(r13, Function2.class, "com.obric.memorydata.plugin");
        Iterator<T> r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedDescending((Iterable) ZeusTransformUtils.preCheckCast(r10.a(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a(((Number) ZeusTransformUtils.preCheckCast(r0.next(), Number.class, "com.obric.memorydata.plugin")).intValue(), true);
        goto L4
    L6:
        Iterator<T> r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 >= this.e.size()) goto L8;
        ((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(this.e.get(r2), SelectionPanelItemView.class, "com.obric.memorydata.plugin")).b(r15.get(r2));
        b((View) ZeusTransformUtils.preCheckCast(this.e.get(r2), View.class, "com.obric.memorydata.plugin"));
        goto L8
    L12:
        Iterator<T> r18 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r10.b(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r18.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        a(r15.get(r4), r4, r16, r17, r14, true);
        goto L14
    }

    private final void a(T r4, int r5, Function2<? super Context, ? super T, ? extends V> r6, Function2<? super V, ? super Integer, Unit> r7, boolean r8, boolean r9) {
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        final Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Object r12 = r10.invoke(this.f11387a, r4);
        SelectionPanelItemView r0 = (SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r12, SelectionPanelItemView.class, "com.obric.memorydata.plugin");
        r0.b(r4);
        r0.setSelectMode(r8);
        ((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        final SelectionPanelItemView r13 = (SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r12, SelectionPanelItemView.class, "com.obric.memorydata.plugin");
        LinearLayout r14 = a(r13);
        r14.setOnClickListener(new $$Lambda$b$jFROPpGjMAP5bf2ozO4Kse9SEeA(this, r13, r11));
        LinearLayout r15 = null;
        if (r5 < this.e.size()) goto L9;
        this.e.add((V) r13);
        LinearLayout r16 = this.d;
        if (r16 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
    L8:
        r15.addView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
    L14:
        if (r9 == false) goto L17;
        a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
        return;
    L17:
        return;
    L7:
        r15 = r16;
        goto L8
    L9:
        this.e.add(r5, (V) r13);
        LinearLayout r17 = this.d;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
    L13:
        r15.addView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"), r5);
        goto L14
    L12:
        r15 = r17;
        goto L13
    }

    private static final void a(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private final void b(final View r3) {
        r3.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).withEndAction(new $$Lambda$b$UHqWWUVJZqfdnXpZyQ9_rmXcNZw(r3)).start();
    }

    private static final void c(View r2) {
        r2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
    }

    private final void d() {
        a r0 = this.f11388b;
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        LinearLayout r2 = this.d;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
        r2 = null;
    L9:
        int r3 = r2.getChildCount();
        int r5 = 0;
    L10:
        if (r5 >= r3) goto L32;
        LinearLayout r6 = this.d;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
        r6 = null;
    L14:
        View r7 = r6.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L17;
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin");
    L18:
        if (r8 == null) goto L31;
        View r9 = r8.findViewWithTag("divider");
        if (r9 == null) goto L31;
        if (r1 == false) goto L29;
        LinearLayout r10 = this.d;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
        r10 = null;
    L27:
        if (r5 >= (r10.getChildCount() - 1)) goto L29;
        int r11 = 0;
    L30:
        r9.setVisibility(r11);
    L29:
        r11 = 8;
    L31:
        r5 = r5 + 1;
        goto L10
    L17:
        r8 = null;
        goto L18
    L32:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void lambda$9RzhBIvVMKDaoOICOAblnTxjhQI(Function0 r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$UHqWWUVJZqfdnXpZyQ9_rmXcNZw(View r0) {
        c(r0);
    }

    /* JADX INFO: renamed from: lambda$dTwSo6PDy94Wyy0-V1HtoblFg7Y, reason: not valid java name */
    public static /* synthetic */ Unit m965lambda$dTwSo6PDy94Wyy0V1HtoblFg7Y(b r0, View r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$jFROPpGjMAP5bf2ozO4Kse9SEeA(b r0, SelectionPanelItemView r1, Function2 r2, View r3) {
        a(r0, r1, r2, r3);
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public List<V> a() {
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(int r3) {
        ONestedScrollView r2 = this.c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        r2 = null;
    L5:
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, r3), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        ONestedScrollView r0 = new ONestedScrollView(this.f11387a, null, 0, 6, null);
        r0.setOverScrollMode(0);
        r0.setVerticalScrollBarEnabled(false);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.c = r0;
        LinearLayout r1 = new LinearLayout(this.f11387a);
        r1.setOrientation(1);
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.d = r1;
        ONestedScrollView r2 = this.c;
        ONestedScrollView r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        r2 = null;
    L5:
        LinearLayout r4 = this.d;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
        r4 = null;
    L8:
        r2.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        ONestedScrollView r7 = this.c;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
    L12:
        r8.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r3 = r7;
        goto L12
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(List<? extends T> r10, Function2<? super Context, ? super T, ? extends V> r11, Function2<? super V, ? super Integer, Unit> r12, boolean r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Function2<? super Context, ? super T, ? extends V> r15 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Function2<? super V, ? super Integer, Unit> r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "items");
        Intrinsics.checkNotNullParameter(r15, "itemFactory");
        Intrinsics.checkNotNullParameter(r16, "onItemClick");
        c();
        this.f = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
        Iterator<T> r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L3:
        int r4 = r0;
        if (r17.hasNext() == false) goto L9;
        T r3 = r17.next();
        r0 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a(r3, r4, r15, r16, r13, false);
        goto L3
    L9:
        d();
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(List<? extends T> r9, Function2<? super Context, ? super T, ? extends V> r10, Function2<? super V, ? super Integer, Unit> r11, boolean r12, f<T> r13) {
        List<? extends T> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Function2<? super Context, ? super T, ? extends V> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Function2<? super V, ? super Integer, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "newItems");
        Intrinsics.checkNotNullParameter(r5, "itemFactory");
        Intrinsics.checkNotNullParameter(r6, "onItemClick");
        if (r13 != null) goto L6;
        a(r14, r5, r6, r12);
        return;
    L6:
        a(a(this.f, r14, r13), r14, r5, r6, r12);
        this.f = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
        d();
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(boolean r4) {
        Iterator<T> r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3.next(), SelectionPanelItemView.class, "com.obric.memorydata.plugin")).setSelectMode(r4);
        goto L4
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public int b() {
        return this.e.size();
    }

    public void c() {
        LinearLayout r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("itemContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        this.e.clear();
        this.f = CollectionsKt.emptyList();
    }
}
