package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import com.obric.memorydata.memory.databinding.ItemPendingPersonalInfoCardBinding;
import com.obric.memorydata.ui.impression.ViewImpressionObserver;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\"#B_\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u001c\u0010\u0016\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0014\u0010\u001e\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u0000H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingConfirmationAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "Lcom/obric/memorydata/memory/ui/list/PendingConfirmationAdapter$PendingViewHolder;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onImpression", "Lkotlin/Function1;", "", "clipVisibleBounds", "Landroid/graphics/Rect;", "", "onConfirm", "onIgnore", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "boundHolders", "", "onCurrentListChanged", "previousList", "", "currentList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewRecycled", "onDetachedFromRecyclerView", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "PendingViewHolder", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ao extends com.obric.oui.orecyclerview.widget.q<ar, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11194a = null;
    private static final b i = null;
    private final LifecycleOwner c;
    private final Function1<ar, Unit> d;
    private final Function1<Rect, Boolean> e;
    private final Function1<ar, Unit> f;
    private final Function1<ar, Unit> g;
    private final Set<c> h;

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingConfirmationAdapter$Companion;", "", "<init>", "()V", "DiffCallback", "com/obric/memorydata/memory/ui/list/PendingConfirmationAdapter$Companion$DiffCallback$1", "Lcom/obric/memorydata/memory/ui/list/PendingConfirmationAdapter$Companion$DiffCallback$1;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/PendingConfirmationAdapter$Companion$DiffCallback$1", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.obric.oui.orecyclerview.widget.i.e<ar> {
        b() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(ar r1, ar r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1.a(), r2.a());
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(ar r3, ar r4) {
            return a2((ar) ZeusTransformUtils.preCheckCast(r3, ar.class, "com.obric.memorydata.plugin"), (ar) ZeusTransformUtils.preCheckCast(r4, ar.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(ar r1, ar r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(ar r3, ar r4) {
            return b2((ar) ZeusTransformUtils.preCheckCast(r3, ar.class, "com.obric.memorydata.plugin"), (ar) ZeusTransformUtils.preCheckCast(r4, ar.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingConfirmationAdapter$PendingViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemPendingPersonalInfoCardBinding;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/PendingConfirmationAdapter;Lcom/obric/memorydata/memory/databinding/ItemPendingPersonalInfoCardBinding;)V", "impressionObserver", "Lcom/obric/memorydata/ui/impression/ViewImpressionObserver;", "getImpressionObserver", "()Lcom/obric/memorydata/ui/impression/ViewImpressionObserver;", "bind", "", "item", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ao f11195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemPendingPersonalInfoCardBinding f11196b;
        private final ViewImpressionObserver t;

        public c(ao r14, ItemPendingPersonalInfoCardBinding r15) {
            Intrinsics.checkNotNullParameter(r15, "binding");
            this.f11195a = r14;
            super((View) ZeusTransformUtils.preCheckCast(r15.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f11196b = r15;
            LinearLayout r16 = r15.getRoot();
            Intrinsics.checkNotNullExpressionValue(r16, "getRoot(...)");
            this.t = new ViewImpressionObserver((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"), ao.a(r14), 0.0f, 0, null, ao.b(r14), 28, null);
        }

        private static final Unit a(ao r0, ar r1) {
            ao.e(r0).invoke(r1);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$AKlyA9w9udHI3thstCCsLg9Elp0(ao r0, ar r1) {
            return a(r0, r1);
        }

        public final ViewImpressionObserver a() {
            return this.t;
        }

        public final void a(final ar r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            aq.f11203a.a(this.f11196b, r5, ao.c(this.f11195a), ao.d(this.f11195a));
            ViewImpressionObserver r0 = this.t;
            String r1 = r5.a();
            final ao r4 = this.f11195a;
            r0.bind(r1, new $$Lambda$ao$c$AKlyA9w9udHI3thstCCsLg9Elp0(r4, r5));
        }
    }

    static {
        f11194a = new a(null);
        i = new b();
    }

    public ao(LifecycleOwner r4, Function1<? super ar, Unit> r5, Function1<? super Rect, Boolean> r6, Function1<? super ar, Unit> r7, Function1<? super ar, Unit> r8) {
        LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function1<ar, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function1<Rect, Boolean> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function1<ar, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function1<ar, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "onImpression");
        Intrinsics.checkNotNullParameter(r11, "clipVisibleBounds");
        Intrinsics.checkNotNullParameter(r12, "onConfirm");
        Intrinsics.checkNotNullParameter(r13, "onIgnore");
        super((com.obric.oui.orecyclerview.widget.i.e) ZeusTransformUtils.preCheckCast(i, com.obric.oui.orecyclerview.widget.i.e.class, "com.obric.memorydata.plugin"));
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ LifecycleOwner a(ao r0) {
        return r0.c;
    }

    public static final /* synthetic */ Function1 b(ao r0) {
        return r0.e;
    }

    public static final /* synthetic */ Function1 c(ao r0) {
        return r0.f;
    }

    public static final /* synthetic */ Function1 d(ao r0) {
        return r0.g;
    }

    public static final /* synthetic */ Function1 e(ao r0) {
        return r0.d;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(c r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.a().unbind();
        this.h.remove(r3);
        super.b((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"));
    }

    public void a(c r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.h.add(r2);
        ar r1 = b(r3);
        Intrinsics.checkNotNullExpressionValue(r1, "getItem(...)");
        r2.a((ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(List<ar> r3, List<ar> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "previousList");
        Intrinsics.checkNotNullParameter(r6, "currentList");
        super.a(r5, r6);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.h, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin")).a().onDataRefreshed();
        goto L4
    }

    public c b(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ItemPendingPersonalInfoCardBinding r6 = ItemPendingPersonalInfoCardBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r4, false);
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        ViewGroup.LayoutParams r7 = r6.getRoot().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 == null) goto L9;
        r8.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
    L9:
        return new c(this, r6);
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void b(RecyclerView.v r3) {
        a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r5) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.h, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin")).a().unbind();
        goto L4
    L6:
        this.h.clear();
        super.b(r5);
    }
}
