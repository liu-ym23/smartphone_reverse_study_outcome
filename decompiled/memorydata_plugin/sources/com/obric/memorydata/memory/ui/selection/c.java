package com.obric.memorydata.memory.ui.selection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.selection.SelectionPanelItemView;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016Jp\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001026\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00028\u00010\u001e2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010#\u001a\u00020$H\u0016J\u0080\u0001\u0010%\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001026\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00028\u00010\u001e2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010#\u001a\u00020$2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0017\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010,\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/RecyclerViewContainer;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "Lcom/obric/memorydata/memory/ui/selection/SelectionContainer;", "context", "Landroid/content/Context;", "dividerProvider", "Lcom/obric/memorydata/memory/ui/selection/DividerProvider;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/memory/ui/selection/DividerProvider;)V", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "adapter", "Lcom/obric/memorydata/memory/ui/selection/SelectionAdapter;", "itemViews", "", "getItemViews", "()Ljava/util/List;", "itemCount", "", "getItemCount", "()I", "attach", "", "parent", "Landroid/view/ViewGroup;", "setItems", "items", "itemFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "item", "onItemClick", "isMultiSelect", "", "updateItems", "newItems", "diffCallback", "Lcom/obric/memorydata/memory/ui/selection/SelectionDiffCallback;", "clearItems", "updateSelectMode", "getItemViewAt", "index", "(I)Lcom/obric/memorydata/memory/ui/selection/SelectionPanelItemView;", "setMaxHeight", "height", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c<T, V extends SelectionPanelItemView<T>> implements e<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f11390b;
    private RecyclerView c;
    private d<T, V> d;

    public c(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f11389a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.f11390b = r6;
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public List<V> a() {
        d<T, V> r0 = this.d;
        if (r0 == null) goto L7;
        List<V> r1 = r0.a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final void a(int r3) {
        RecyclerView r2 = this.c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r2 = null;
    L5:
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, r3), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        RecyclerView r0 = new RecyclerView(this.f11389a);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r0.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        com.obric.oui.orecyclerview.widget.h r1 = new com.obric.oui.orecyclerview.widget.h();
        r1.b(250);
        r1.c(200);
        r1.d(150);
        r0.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(r1, RecyclerView.e.class, "com.obric.memorydata.plugin"));
        r0.setOverScrollMode(0);
        this.c = r0;
        a r2 = this.f11390b;
        RecyclerView r3 = null;
        if (r2 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L6:
        r0.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new h(r2), RecyclerView.g.class, "com.obric.memorydata.plugin"));
    L7:
        RecyclerView r6 = this.c;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L11:
        r7.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        r3 = r6;
        goto L11
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(List<? extends T> r4, Function2<? super Context, ? super T, ? extends V> r5, Function2<? super V, ? super Integer, Unit> r6, boolean r7) {
        List<? extends T> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "items");
        Intrinsics.checkNotNullParameter(r9, "itemFactory");
        Intrinsics.checkNotNullParameter(r10, "onItemClick");
        if (this.d != null) goto L8;
        this.d = new d(this.f11389a, r9, r10, r7);
        RecyclerView r11 = this.c;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r11 = null;
    L7:
        r11.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this.d, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
    L8:
        d<T, V> r3 = this.d;
        if (r3 == null) goto L12;
        r3.a(r8);
        return;
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(List<? extends T> r3, Function2<? super Context, ? super T, ? extends V> r4, Function2<? super V, ? super Integer, Unit> r5, boolean r6, f<T> r7) {
        List<? extends T> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Function2<? super Context, ? super T, ? extends V> r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Function2<? super V, ? super Integer, Unit> r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "newItems");
        Intrinsics.checkNotNullParameter(r9, "itemFactory");
        Intrinsics.checkNotNullParameter(r10, "onItemClick");
        d<T, V> r0 = this.d;
        if (r0 != null) goto L6;
        a(r8, r9, r10, r6);
        return;
    L6:
        if (r0 == null) goto L9;
        r0.a(r8, r7);
        return;
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public void a(boolean r1) {
        d<T, V> r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.obric.memorydata.memory.ui.selection.e
    public int b() {
        d<T, V> r0 = this.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }
}
