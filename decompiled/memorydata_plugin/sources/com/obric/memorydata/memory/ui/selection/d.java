package com.obric.memorydata.memory.ui.selection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.selection.SelectionPanelItemView;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004Bi\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u00010\t\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\t\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J$\u0010\u001c\u001a\u00020\u000f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0014\u0010 \u001a\u00020\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J$\u0010#\u001a\u00020\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%J\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/SelectionAdapter;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/memorydata/memory/ui/selection/SelectionViewHolder;", "context", "Landroid/content/Context;", "itemFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "item", "onItemClick", "", "", "isMultiSelect", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Z)V", "items", "", "itemViewCache", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setItems", "newItems", "", "updateItems", "diffCallback", "Lcom/obric/memorydata/memory/ui/selection/SelectionDiffCallback;", "updateSelectMode", "getAllItemViews", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d<T, V extends SelectionPanelItemView<T>> extends RecyclerView.Adapter<i<T, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<Context, T, V> f11392b;
    private final Function2<V, Integer, Unit> c;
    private boolean d;
    private final List<T> e;
    private final Map<Integer, V> f;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/memory/ui/selection/SelectionAdapter$updateItems$diffResult$1", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$Callback;", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldPos", "newPos", "areContentsTheSame", "getChangePayload", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.oui.orecyclerview.widget.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<T> f11393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<T> f11394b;
        final /* synthetic */ f<T> c;

        a(List<? extends T> r3, List<? extends T> r4, f<T> r5) {
            List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f11393a = r6;
            this.f11394b = r7;
            this.c = r5;
        }

        @Override // com.obric.oui.orecyclerview.widget.i.a
        public int a() {
            return this.f11393a.size();
        }

        @Override // com.obric.oui.orecyclerview.widget.i.a
        public boolean a(int r3, int r4) {
            return this.c.a(this.f11393a.get(r3), this.f11394b.get(r4));
        }

        @Override // com.obric.oui.orecyclerview.widget.i.a
        public int b() {
            return this.f11394b.size();
        }

        @Override // com.obric.oui.orecyclerview.widget.i.a
        public boolean b(int r3, int r4) {
            return this.c.b(this.f11393a.get(r3), this.f11394b.get(r4));
        }

        @Override // com.obric.oui.orecyclerview.widget.i.a
        public Object c(int r3, int r4) {
            return this.c.c(this.f11393a.get(r3), this.f11394b.get(r4));
        }
    }

    public d(Context r3, Function2<? super Context, ? super T, ? extends V> r4, Function2<? super V, ? super Integer, Unit> r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function2<Context, T, V> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Function2<V, Integer, Unit> r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "itemFactory");
        Intrinsics.checkNotNullParameter(r9, "onItemClick");
        this.f11391a = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.f11392b = r8;
        this.c = r9;
        this.d = r6;
        this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private static final void a(d r0, i r1, View r2) {
        Function2<V, Integer, Unit> r3 = r0.c;
        SelectionPanelItemView r4 = r1.a();
        V r5 = (V) r4;
        r3.invoke(r5, Integer.valueOf(r1.o()));
    }

    public static /* synthetic */ void lambda$KjK8ztaUgWUDSF7FP2ptdlOxhhA(d r0, i r1, View r2) {
        a(r0, r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public final List<V> a() {
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.f.values(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public void a(final i<T, V> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.a(this.e.get(r4), this.d);
        Integer r5 = Integer.valueOf(r4);
        this.f.put(r5, (V) r3.a());
        r3.c.setOnClickListener(new $$Lambda$d$KjK8ztaUgWUDSF7FP2ptdlOxhhA(this, r3));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void a(List<? extends T> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "newItems");
        this.e.clear();
        this.e.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        this.f.clear();
        h();
    }

    public final void a(List<? extends T> r4, f<T> r5) {
        List<? extends T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "newItems");
        if (r5 != null) goto L6;
        a(r6);
        return;
    L6:
        com.obric.oui.orecyclerview.widget.i.d r7 = com.obric.oui.orecyclerview.widget.i.a((com.obric.oui.orecyclerview.widget.i.a) ZeusTransformUtils.preCheckCast(new a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")), r6, r5), com.obric.oui.orecyclerview.widget.i.a.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r7, "calculateDiff(...)");
        this.e.clear();
        this.e.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        this.f.clear();
        r7.a((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
    }

    public final void a(boolean r3) {
        this.d = r3;
        a(0, d(), "selectMode");
    }

    public i<T, V> b(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Function2<Context, T, V> r6 = this.f11392b;
        Context r7 = this.f11391a;
        Object r0 = CollectionsKt.firstOrNull(this.e);
        if (r0 == null) goto L5;
        SelectionPanelItemView r3 = (SelectionPanelItemView) ZeusTransformUtils.preCheckCast(r6.invoke(r7, (T) r0), SelectionPanelItemView.class, "com.obric.memorydata.plugin");
        ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return new i(r3);
    L5:
        return new i((SelectionPanelItemView) ZeusTransformUtils.preCheckCast(new FrameLayout(this.f11391a), SelectionPanelItemView.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.e.size();
    }
}
