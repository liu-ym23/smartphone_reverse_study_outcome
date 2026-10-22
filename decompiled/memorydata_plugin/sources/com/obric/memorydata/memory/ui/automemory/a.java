package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u001a\u001b\u001c\u001dBQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "tab", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "onCardClick", "Lkotlin/Function1;", "", "onAddClick", "onMoreClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getItemViewType", "", "position", "getItemId", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "RecommendCardViewHolder", "MyCardViewHolder", "DiffCallback", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends com.obric.oui.orecyclerview.widget.q<com.obric.memorydata.memory.ui.automemory.d, RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0532a f10608a = null;
    private final AutoMemoryTab c;
    private final Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> d;
    private final Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> e;
    private final Function2<com.obric.memorydata.memory.ui.automemory.d, View, Unit> f;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_HEADER", "", "VIEW_TYPE_CARD_RECOMMEND", "VIEW_TYPE_CARD_MY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0532a {
        private C0532a() {
        }

        public /* synthetic */ C0532a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionAdapter$DiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b extends com.obric.oui.orecyclerview.widget.i.e<com.obric.memorydata.memory.ui.automemory.d> {
        public b() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(com.obric.memorydata.memory.ui.automemory.d r3, com.obric.memorydata.memory.ui.automemory.d r4) {
            Intrinsics.checkNotNullParameter(r3, "oldItem");
            Intrinsics.checkNotNullParameter(r4, "newItem");
            if (com.obric.memorydata.memory.ui.automemory.b.a(r3.a()) != com.obric.memorydata.memory.ui.automemory.b.a(r4.a())) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(com.obric.memorydata.memory.ui.automemory.d r3, com.obric.memorydata.memory.ui.automemory.d r4) {
            return a2((com.obric.memorydata.memory.ui.automemory.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.automemory.d.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.automemory.d) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.automemory.d.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(com.obric.memorydata.memory.ui.automemory.d r1, com.obric.memorydata.memory.ui.automemory.d r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(com.obric.memorydata.memory.ui.automemory.d r3, com.obric.memorydata.memory.ui.automemory.d r4) {
            return b2((com.obric.memorydata.memory.ui.automemory.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.automemory.d.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.automemory.d) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.automemory.d.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionAdapter$MyCardViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardView", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryMyCollectionCardView;", "onCardClick", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "", "onMoreClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryMyCollectionCardView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f10609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> f10610b;
        private final Function2<com.obric.memorydata.memory.ui.automemory.d, View, Unit> t;

        public c(o r3, Function1<? super com.obric.memorydata.memory.ui.automemory.d, Unit> r4, Function2<? super com.obric.memorydata.memory.ui.automemory.d, ? super View, Unit> r5) {
            Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Function2<com.obric.memorydata.memory.ui.automemory.d, View, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "cardView");
            Intrinsics.checkNotNullParameter(r6, "onCardClick");
            Intrinsics.checkNotNullParameter(r7, "onMoreClick");
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f10609a = r3;
            this.f10610b = r6;
            this.t = r7;
        }

        private static final void a(c r0, com.obric.memorydata.memory.ui.automemory.d r1, View r2) {
            r0.f10610b.invoke(r1);
        }

        private static final boolean b(c r0, com.obric.memorydata.memory.ui.automemory.d r1, View r2) {
            r0.t.invoke(r1, r0.f10609a);
            return true;
        }

        public static /* synthetic */ void lambda$T7rjz75mDfgf_cs3ujiV36DgzTs(c r0, com.obric.memorydata.memory.ui.automemory.d r1, View r2) {
            a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$Y2F7I8-TYyeQv_Km0JRbouB7-Ts, reason: not valid java name */
        public static /* synthetic */ boolean m787lambda$Y2F7I8TYyeQv_Km0JRbouB7Ts(c r0, com.obric.memorydata.memory.ui.automemory.d r1, View r2) {
            return b(r0, r1, r2);
        }

        public final void a(final com.obric.memorydata.memory.ui.automemory.d r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.f10609a.a(r3);
            this.f10609a.setOnClickListener(new $$Lambda$a$c$T7rjz75mDfgf_cs3ujiV36DgzTs(this, r3));
            this.f10609a.setOnLongClickListener(new $$Lambda$a$c$Y2F7I8TYyeQv_Km0JRbouB7Ts(this, r3));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionAdapter$RecommendCardViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardView", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryRecommendCollectionCardView;", "onAddClick", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "", "<init>", "(Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryRecommendCollectionCardView;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f10611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> f10612b;

        public d(q r3, Function1<? super com.obric.memorydata.memory.ui.automemory.d, Unit> r4) {
            Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "cardView");
            Intrinsics.checkNotNullParameter(r5, "onAddClick");
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f10611a = r3;
            this.f10612b = r5;
        }

        private static final Unit a(d r0, com.obric.memorydata.memory.ui.automemory.d r1) {
            r0.f10612b.invoke(r1);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$H4f2AYeIzcCZsIq0tz0NWEBsZsM(d r0, com.obric.memorydata.memory.ui.automemory.d r1) {
            return a(r0, r1);
        }

        public final void a(final com.obric.memorydata.memory.ui.automemory.d r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.f10611a.a(r3);
            this.f10611a.a(new $$Lambda$a$d$H4f2AYeIzcCZsIq0tz0NWEBsZsM(this, r3));
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10613a = null;

        static {
            int[] r0 = new int[AutoMemoryTab.values().length];
            r0[AutoMemoryTab.AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AutoMemoryTab.DISCOVER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10613a = r0;
        }
    }

    static {
        f10608a = new C0532a(null);
    }

    public a(AutoMemoryTab r4, Function1<? super com.obric.memorydata.memory.ui.automemory.d, Unit> r5, Function1<? super com.obric.memorydata.memory.ui.automemory.d, Unit> r6, Function2<? super com.obric.memorydata.memory.ui.automemory.d, ? super View, Unit> r7) {
        Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.memory.ui.automemory.d, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function2<com.obric.memorydata.memory.ui.automemory.d, View, Unit> r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "tab");
        Intrinsics.checkNotNullParameter(r8, "onCardClick");
        Intrinsics.checkNotNullParameter(r9, "onAddClick");
        Intrinsics.checkNotNullParameter(r10, "onMoreClick");
        super((com.obric.oui.orecyclerview.widget.i.e) ZeusTransformUtils.preCheckCast(new b(), com.obric.oui.orecyclerview.widget.i.e.class, "com.obric.memorydata.plugin"));
        this.c = r4;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        b_(true);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        AutoMemoryTab r1 = this.c;
        int r3 = e.f10613a[r1.ordinal()];
        if (r3 == 1) goto L8;
        if (r3 != 2) goto L7;
        return 2;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        return 3;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 2) goto L5;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "getContext(...)");
        Object r8 = new d(new q(r7), this.e);
    L11:
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r8, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L5:
        if (r6 != 3) goto L8;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "getContext(...)");
        r8 = new c(new o(r9), this.d, this.f);
        goto L11
    L8:
        throw new IllegalArgumentException("Invalid viewType: " + r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        com.obric.memorydata.memory.ui.automemory.d r1 = (com.obric.memorydata.memory.ui.automemory.d) ZeusTransformUtils.preCheckCast(b(r3), com.obric.memorydata.memory.ui.automemory.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L6;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        r4.a(r1);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L10;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        r5.a(r1);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r2) {
        return com.obric.memorydata.memory.ui.automemory.b.a(((com.obric.memorydata.memory.ui.automemory.d) ZeusTransformUtils.preCheckCast(b(r2), com.obric.memorydata.memory.ui.automemory.d.class, "com.obric.memorydata.plugin")).a());
    }
}
