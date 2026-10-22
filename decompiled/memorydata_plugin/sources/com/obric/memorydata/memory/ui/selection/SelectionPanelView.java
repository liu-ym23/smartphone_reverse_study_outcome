package com.obric.memorydata.memory.ui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.loc.o;
import com.obric.memorydata.memory.ui.selection.SelectionPanelItemView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005:\u0002cdB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\u000bJ\u0018\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH\u0014J(\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0014J\u000e\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u0015J\u0010\u0010:\u001a\u00020-2\u0006\u00109\u001a\u00020\u0015H\u0002J\b\u0010;\u001a\u00020-H\u0002J\u0014\u0010<\u001a\u00020-2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJL\u0010>\u001a\u00020-2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000@26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00010\u0017J\u0014\u0010A\u001a\u00020-2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000@J\u001d\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00028\u00012\u0006\u0010E\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020-H\u0002J8\u0010H\u001a\u00020-2\b\b\u0002\u0010I\u001a\u00020\u001e2\b\b\u0002\u0010J\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010K\u001a\u00020\u000b2\b\b\u0002\u0010L\u001a\u00020\u000bJ\b\u0010M\u001a\u00020\u001eH\u0016J\b\u0010N\u001a\u00020\u000bH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016J\u0014\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0QH\u0016J\u0014\u0010R\u001a\u00020-2\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fJ\u0014\u0010T\u001a\u00020-2\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011J\r\u0010U\u001a\u0004\u0018\u00010-¢\u0006\u0002\u0010VJ\u000e\u0010W\u001a\u00020-2\u0006\u0010E\u001a\u00020\u000bJ\u0014\u0010W\u001a\u00020-2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0@J\u0006\u0010Y\u001a\u00020-J\u000e\u0010Z\u001a\u00020-2\u0006\u0010E\u001a\u00020\u000bJ\u0014\u0010Z\u001a\u00020-2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0@J\u0006\u0010[\u001a\u00020-J\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0@J\f\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000@J\f\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00010@J\u000e\u0010b\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000bR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0011\u0010_\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "Landroid/widget/LinearLayout;", "Lcom/obric/memorydata/memory/ui/selection/DividerProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectionChangedListener", "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView$SelectionChangedListener;", "itemClickListener", "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView$ItemClickListener;", "container", "Lcom/obric/memorydata/memory/ui/selection/SelectionContainer;", "currentMode", "Lcom/obric/memorydata/memory/ui/selection/ContainerMode;", "itemFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "item", "diffCallback", "Lcom/obric/memorydata/memory/ui/selection/SelectionDiffCallback;", "_showDivider", "", "_dividerColor", "_dividerHeight", "_dividerMarginStart", "_dividerMarginEnd", "maxHeight", EventBody.KEY_VALUE, "isMultiSelect", "()Z", "setMultiSelect", "(Z)V", "showDivider", "getShowDivider", "setShowDivider", "setMaxHeight", "", "height", "getMaxHeight", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", o.g, "oldw", "oldh", "setContainerMode", "mode", "setupContainer", "applyMaxHeightToContainer", "setDiffCallback", "callback", "setItems", "items", "", "updateItems", "newItems", "handleItemClick", "clickedView", "index", "(Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;I)V", "notifySelectionChanged", "configureDivider", "show", TypedValues.Custom.S_COLOR, "marginStart", "marginEnd", "shouldShowDivider", "getDividerColor", "getDividerHeight", "getDividerMargins", "Lkotlin/Pair;", "setSelectionChangedListener", "listener", "setItemClickListener", "clearItems", "()Lkotlin/Unit;", "select", "indices", "selectAll", "deselect", "deselectAll", "getSelectedIndexes", "getSelectedData", "getItemViews", "itemCount", "getItemCount", "()I", "setScrollViewHeight", "SelectionChangedListener", "ItemClickListener", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class SelectionPanelView<T, V extends SelectionPanelItemView<T>> extends LinearLayout implements com.obric.memorydata.memory.ui.selection.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b<V> f11384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a<V> f11385b;
    private e<T, V> c;
    private ContainerMode d;
    private Function2<? super Context, ? super T, ? extends V> e;
    private f<T> f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView$ItemClickListener;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "onItemClick", "", "item", "index", "", "(Ljava/lang/Object;I)V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a<V> {
        void a(V r1, int r2);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00020\u00070\u0006H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView$SelectionChangedListener;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "onSelectionChanged", "", "selectedItems", "", "Lkotlin/Pair;", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b<V> {
        void a(List<? extends Pair<Integer, ? extends V>> r1);
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11386a = null;

        static {
            int[] r0 = new int[ContainerMode.values().length];
            r0[ContainerMode.NESTED_SCROLL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerMode.RECYCLER_VIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11386a = r0;
        }
    }

    public SelectionPanelView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public SelectionPanelView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public SelectionPanelView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.d = ContainerMode.NESTED_SCROLL;
        this.h = -2039584;
        this.i = 1;
        this.l = -1;
        setOrientation(1);
        setupContainer(ContainerMode.NESTED_SCROLL);
    }

    public /* synthetic */ SelectionPanelView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a(V r5, int r6) {
        if (this.m == false) goto L6;
        r5.setItemSelected(!r5.a());
    L15:
        a<V> r0 = this.f11385b;
        if (r0 == null) goto L18;
        r0.a(r5, r6);
    L18:
        d();
        return;
    L6:
        if (r5.a() == true) goto L15;
        e<T, V> r1 = this.c;
        if (r1 == null) goto L15;
        List<V> r2 = r1.a();
        if (r2 == null) goto L15;
        Iterator<T> r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        SelectionPanelItemView r4 = (SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3.next(), SelectionPanelItemView.class, "com.obric.memorydata.plugin");
        r4.setItemSelected(Intrinsics.areEqual(r4, r5));
        goto L13
    }

    public static final /* synthetic */ void a(SelectionPanelView r0, SelectionPanelItemView r1, int r2) {
        r0.a(r1, r2);
    }

    private final void c() {
        if (this.l <= 0) goto L23;
        e<T, V> r0 = this.c;
        if (r0 == null) goto L24;
        ContainerMode r1 = this.d;
        int r2 = c.f11386a[r1.ordinal()];
        com.obric.memorydata.memory.ui.selection.b r4 = null;
        com.obric.memorydata.memory.ui.selection.c r5 = null;
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L16;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.selection.c.class) == false) goto L13;
        r5 = (com.obric.memorydata.memory.ui.selection.c) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.selection.c.class, "com.obric.memorydata.plugin");
    L13:
        if (r5 == null) goto L25;
        r5.a(this.l);
        return;
    L25:
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L18:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.selection.b.class) == false) goto L20;
        r4 = (com.obric.memorydata.memory.ui.selection.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.selection.b.class, "com.obric.memorydata.plugin");
    L20:
        if (r4 == null) goto L27;
        r4.a(this.l);
        return;
    L27:
        return;
    L24:
        return;
    }

    private final void d() {
        e<T, V> r0 = this.c;
        if (r0 == null) goto L20;
        List<V> r1 = r0.a();
        if (r1 == null) goto L20;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        Iterator<T> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L19;
        T r6 = r5.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        SelectionPanelItemView r8 = (SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r6, SelectionPanelItemView.class, "com.obric.memorydata.plugin");
        if (r8.a() == false) goto L15;
        Pair r9 = new Pair(Integer.valueOf(r4), r8);
    L16:
        if (r9 == null) goto L18;
        r3.add(r9);
    L18:
        r4 = r7;
        goto L8
    L15:
        r9 = null;
        goto L16
    L19:
        List<? extends Pair<Integer, ? extends V>> r10 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L21:
        b<V> r11 = this.f11384a;
        if (r11 == null) goto L28;
        r11.a(r10);
        return;
    L28:
        return;
    L20:
        r10 = CollectionsKt.emptyList();
        goto L21
    }

    private final void setupContainer(ContainerMode r5) {
        int r6 = c.f11386a[r5.ordinal()];
        if (r6 != 1) goto L5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
        Object r7 = new com.obric.memorydata.memory.ui.selection.b(r0, (com.obric.memorydata.memory.ui.selection.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.memory.ui.selection.a.class, "com.obric.memorydata.plugin"));
    L10:
        e<T, V> r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
        this.c = r8;
        if (r8 == null) goto L13;
        r8.a((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
    L13:
        c();
        return;
    L5:
        if (r6 != 2) goto L8;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        r7 = new com.obric.memorydata.memory.ui.selection.c(r1, (com.obric.memorydata.memory.ui.selection.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.memory.ui.selection.a.class, "com.obric.memorydata.plugin"));
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(List<? extends T> r9) {
        List<? extends T> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "newItems");
        Function2<? super Context, ? super T, ? extends V> r4 = this.e;
        if (r4 != null) goto L5;
        return;
    L5:
        e<T, V> r2 = this.c;
        if (r2 == null) goto L9;
        r2.a(r3, r4, (Function2) ZeusTransformUtils.preCheckCast(new SelectionPanelView$updateItems$1(this), Function2.class, "com.obric.memorydata.plugin"), this.m, this.f);
        return;
    }

    public final void a(List<? extends T> r5, Function2<? super Context, ? super T, ? extends V> r6) {
        List<? extends T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function2<? super Context, ? super T, ? extends V> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "items");
        Intrinsics.checkNotNullParameter(r8, "itemFactory");
        this.e = r8;
        e<T, V> r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r7, r8, (Function2) ZeusTransformUtils.preCheckCast(new SelectionPanelView$setItems$1(this), Function2.class, "com.obric.memorydata.plugin"), this.m);
        return;
    }

    public final void a(boolean r1, int r2, int r3, int r4, int r5) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
    }

    @Override // com.obric.memorydata.memory.ui.selection.a
    public boolean a() {
        return this.g;
    }

    public final void b() {
        if (this.m == true) goto L5;
        return;
    L5:
        e<T, V> r0 = this.c;
        if (r0 == null) goto L13;
        List<V> r1 = r0.a();
        if (r1 == null) goto L13;
        Iterator<T> r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r2.next(), SelectionPanelItemView.class, "com.obric.memorydata.plugin")).setItemSelected(true);
    L13:
        d();
    }

    @Override // com.obric.memorydata.memory.ui.selection.a
    public int getDividerColor() {
        return this.h;
    }

    @Override // com.obric.memorydata.memory.ui.selection.a
    public int getDividerHeight() {
        return this.i;
    }

    @Override // com.obric.memorydata.memory.ui.selection.a
    public Pair<Integer, Integer> getDividerMargins() {
        return new Pair(Integer.valueOf(this.j), Integer.valueOf(this.k));
    }

    public final int getItemCount() {
        e<T, V> r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    }

    public final List<V> getItemViews() {
        e<T, V> r0 = this.c;
        if (r0 == null) goto L7;
        List<V> r1 = r0.a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final int getMaxHeight() {
        return this.l;
    }

    public final List<T> getSelectedData() {
        e<T, V> r4 = this.c;
        if (r4 == null) goto L20;
        List<V> r5 = r4.a();
        if (r5 == null) goto L20;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        T r2 = r7.next();
        if (((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r2, SelectionPanelItemView.class, "com.obric.memorydata.plugin")).a() == false) goto L8;
        r0.add(r2);
        goto L8
    L12:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L31;
        Object r3 = ((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r9.next(), SelectionPanelItemView.class, "com.obric.memorydata.plugin")).getData();
        if (r3 == null) goto L14;
        r1.add(r3);
        goto L14
    L31:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L20:
        return CollectionsKt.emptyList();
    }

    public final List<Integer> getSelectedIndexes() {
        e<T, V> r6 = this.c;
        if (r6 == null) goto L21;
        List<V> r7 = r6.a();
        if (r7 == null) goto L21;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L25;
        T r3 = r9.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        if (((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3, SelectionPanelItemView.class, "com.obric.memorydata.plugin")).a() == false) goto L15;
        Integer r5 = Integer.valueOf(r2);
    L16:
        if (r5 == null) goto L18;
        r0.add(r5);
    L18:
        r2 = r4;
        goto L8
    L15:
        r5 = null;
        goto L16
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L21:
        return CollectionsKt.emptyList();
    }

    public final boolean getShowDivider() {
        return this.g;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        if (this.l <= 0) goto L16;
        int r0 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getSize(r5);
        if (r0 == Integer.MIN_VALUE) goto L14;
        if (r0 != 0) goto L8;
        int r6 = this.l;
    L15:
        r5 = View.MeasureSpec.makeMeasureSpec(r6, Integer.MIN_VALUE);
        goto L16
    L8:
        if (r0 != 1073741824) goto L16;
        int r2 = this.l;
        if (r1 <= r2) goto L16;
        r5 = View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
        goto L16
    L14:
        r6 = Math.min(r1, this.l);
    L16:
        super.onMeasure(r4, r5);
        if (this.l > 0) goto L19;
        return;
    L19:
        if (getMeasuredHeight() <= this.l) goto L23;
        setMeasuredDimension(getMeasuredWidth(), this.l);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        int r5 = this.l;
        if (r5 <= 0) goto L7;
        if (r2 <= r5) goto L8;
        ViewGroup.LayoutParams r6 = getLayoutParams();
        r6.height = this.l;
        setLayoutParams(r6);
        return;
    L8:
        return;
    }

    public final void setContainerMode(ContainerMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        if (this.d == r2) goto L5;
    L7:
        this.d = r2;
        removeAllViews();
        setupContainer(r2);
        return;
    L5:
        if (this.c == null) goto L7;
    }

    public final void setDiffCallback(f<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.f = r2;
    }

    public final void setItemClickListener(a<V> r3) {
        a<V> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f11385b = r4;
    }

    public final void setMaxHeight(int r2) {
        if (this.l == r2) goto L6;
        this.l = r2;
        requestLayout();
        return;
    }

    public final void setMultiSelect(boolean r2) {
        if (this.m == r2) goto L8;
        this.m = r2;
        e<T, V> r1 = this.c;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    L9:
        return;
    }

    public final void setScrollViewHeight(int r5) {
        e<T, V> r0 = this.c;
        com.obric.memorydata.memory.ui.selection.c r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.selection.b.class) == false) goto L5;
        com.obric.memorydata.memory.ui.selection.b r1 = (com.obric.memorydata.memory.ui.selection.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.selection.b.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        r1.a(r5);
    L8:
        e<T, V> r4 = this.c;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.selection.c.class) == false) goto L11;
        r3 = (com.obric.memorydata.memory.ui.selection.c) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.selection.c.class, "com.obric.memorydata.plugin");
    L11:
        if (r3 == null) goto L14;
        r3.a(r5);
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setSelectionChangedListener(b<V> r3) {
        b<V> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f11384a = r4;
    }

    public final void setShowDivider(boolean r2) {
        if (this.g == r2) goto L9;
        this.g = r2;
        e<T, V> r1 = this.c;
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.memory.ui.selection.c.class) == false) goto L8;
        com.obric.memorydata.memory.ui.selection.c r3 = (com.obric.memorydata.memory.ui.selection.c) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.selection.c.class, "com.obric.memorydata.plugin");
        return;
    L8:
        return;
    }
}
