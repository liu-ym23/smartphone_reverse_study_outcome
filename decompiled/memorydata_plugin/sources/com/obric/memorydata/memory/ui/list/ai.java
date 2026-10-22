package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \"2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002!\"B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\u0011\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0003R\u00020\u0000H\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J*\u0010\u0018\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J$\u0010\u001d\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "Lcom/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter$SourceViewHolder;", "onSourceClick", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "selectedKey", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "setSelectedKey", "key", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "position", "payloads", "", "", "onCurrentListChanged", "previousList", "currentList", "refreshItemChrome", "SourceViewHolder", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ai extends com.obric.oui.orecyclerview.widget.q<MemorySourceFilter, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11183a = null;
    private static final b f = null;
    private final Function1<MemorySourceFilter, Unit> c;
    private String d;
    private RecyclerView e;

    @Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter$Companion;", "", "<init>", "()V", "PAYLOAD_ITEM_CHROME", "", "DiffCallback", "com/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter$Companion$DiffCallback$1", "Lcom/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter$Companion$DiffCallback$1;", "cardPosition", "", "position", "itemCount", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final int a(int r1, int r2) {
            if (r2 > 1) goto L5;
            return 0;
        L5:
            if (r1 != 0) goto L8;
            return 1;
        L8:
            if (r1 != (r2 - 1)) goto L10;
            return 3;
        L10:
            return 2;
        }

        public static final /* synthetic */ int a(a r0, int r1, int r2) {
            return r0.a(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter$Companion$DiffCallback$1", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.obric.oui.orecyclerview.widget.i.e<MemorySourceFilter> {
        b() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(MemorySourceFilter r1, MemorySourceFilter r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1.getStableKey(), r2.getStableKey());
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(MemorySourceFilter r3, MemorySourceFilter r4) {
            return a2((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r3, MemorySourceFilter.class, "com.obric.memorydata.plugin"), (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r4, MemorySourceFilter.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(MemorySourceFilter r1, MemorySourceFilter r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(MemorySourceFilter r3, MemorySourceFilter r4) {
            return b2((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r3, MemorySourceFilter.class, "com.obric.memorydata.plugin"), (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r4, MemorySourceFilter.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter$SourceViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "card", "Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter;Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;)V", "tailContainer", "Landroid/widget/FrameLayout;", "countView", "Lcom/obric/oui/text/OTextView;", "selectedView", "Landroid/widget/ImageView;", "bind", "", "item", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "position", "", "itemCount", "updateItemChrome", "refreshCurrentItemChrome", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ai f11184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DeviceAdaptiveCardListItem f11185b;
        private final FrameLayout t;
        private final OTextView u;
        private final ImageView v;

        public c(ai r10, DeviceAdaptiveCardListItem r11) {
            Intrinsics.checkNotNullParameter(r11, "card");
            this.f11184a = r10;
            super((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
            this.f11185b = r11;
            FrameLayout r12 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            this.t = r12;
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r3, "getContext(...)");
            OTextView r1 = new OTextView(r3, null, 0, null, 14, null);
            r1.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, TypedValues.Custom.S_COLOR, "oui_text_3")));
            r1.setTextSize(14.0f);
            float r2 = 6;
            r1.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())));
            this.u = r1;
            ImageView r4 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            r4.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_memory_source_check, "drawable", "ic_memory_source_check"));
            this.v = r4;
            r12.addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2, 8388629), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            View r9 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
            float r5 = 24;
            r12.addView(r9, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), 8388629), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            r11.setCustomEndView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"));
        }

        private static final void a(ai r0, MemorySourceFilter r1, View r2) {
            ai.b(r0).invoke(r1);
        }

        public static /* synthetic */ void lambda$lH44s8Dm8rnuDKFMdcj7p3QZUNo(ai r0, MemorySourceFilter r1, View r2) {
            a(r0, r1, r2);
        }

        public final void a() {
            int r0 = o();
            if (r0 != (-1)) goto L5;
            return;
        L5:
            MemorySourceFilter r1 = ai.a(this.f11184a, r0);
            Intrinsics.checkNotNullExpressionValue(r1, "access$getItem(...)");
            b(r1, r0, this.f11184a.d());
        }

        public final void a(final MemorySourceFilter r20, int r21, int r22) {
            Intrinsics.checkNotNullParameter(r20, "item");
            this.f11185b.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r20.getDisplayName(), CharSequence.class, "com.obric.memorydata.plugin"));
            boolean r3 = true;
            this.f11185b.c(true);
            if (r20.isAll() == false) goto L5;
            this.f11185b.setIcon(ZeusTransformUtils.mapRes(R.drawable.ic_memory_source_all, "drawable", "ic_memory_source_all"));
        L19:
            DeviceAdaptiveCardListItem r2 = this.f11185b;
            final ai r4 = this.f11184a;
            r2.setOnContentClickListener(new $$Lambda$ai$c$lH44s8Dm8rnuDKFMdcj7p3QZUNo(r4, r20));
            b(r20, r21, r22);
            return;
        L5:
            ae r5 = ae.f11174a;
            Integer r6 = r20.getSourceProductType();
            if (r6 == null) goto L8;
            int r7 = r6.intValue();
        L9:
            af r8 = r5.a(r7, MemorySourceIconScene.LIST);
            com.obric.memorydata.utils.icon.b r9 = com.obric.memorydata.utils.icon.b.f13229a;
            Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f11185b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r10, "getContext(...)");
            ImageView r11 = this.f11185b.getIconView();
            String r12 = r20.getSourcePackageName();
            Integer r13 = null;
            if (r8 == null) goto L12;
            String r14 = r8.b();
        L13:
            if (r8 == null) goto L15;
            r13 = Integer.valueOf(r8.a());
        L15:
            Integer r15 = r13;
            if (r8 == null) goto L18;
            r3 = r8.c();
        L18:
            com.obric.memorydata.utils.icon.b.a(r9, r10, r11, r12, null, 0, null, null, r14, r15, r3, 120, null);
            goto L19
        L12:
            r14 = null;
            goto L13
        L8:
            r7 = 0;
            goto L9
        }

        public final void b(MemorySourceFilter r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r5, "item");
            this.f11185b.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r5.getDisplayName(), CharSequence.class, "com.obric.memorydata.plugin"));
            OCardListItem r0 = (OCardListItem) ZeusTransformUtils.preCheckCast(this.f11185b, OCardListItem.class, "com.obric.memorydata.plugin");
            int r8 = a.a(ai.f11183a, r6, r7);
            int r9 = 0;
            OCardListItem.a(r0, r8, false, 2, null);
            boolean r10 = Intrinsics.areEqual(r5.getStableKey(), ai.a(this.f11184a));
            ImageView r1 = this.v;
            if (r10 == false) goto L5;
            int r2 = 0;
        L6:
            r1.setVisibility(r2);
            OTextView r3 = this.u;
            if (r10 == false) goto L9;
        L11:
            r9 = 8;
        L12:
            r3.setVisibility(r9);
            this.u.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getDisplayCount(), CharSequence.class, "com.obric.memorydata.plugin"));
            return;
        L9:
            if (r5.getShowCount() == false) goto L11;
        L5:
            r2 = 8;
            goto L6
        }
    }

    static {
        f11183a = new a(null);
        f = new b();
    }

    public ai(Function1<? super MemorySourceFilter, Unit> r4) {
        Function1<MemorySourceFilter, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "onSourceClick");
        super((com.obric.oui.orecyclerview.widget.i.e) ZeusTransformUtils.preCheckCast(f, com.obric.oui.orecyclerview.widget.i.e.class, "com.obric.memorydata.plugin"));
        this.c = r5;
        this.d = MemorySourceFilter.KEY_ALL;
    }

    public static final /* synthetic */ MemorySourceFilter a(ai r1, int r2) {
        return (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r1.b(r2), MemorySourceFilter.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String a(ai r0) {
        return r0.d;
    }

    public static final /* synthetic */ Function1 b(ai r0) {
        return r0.c;
    }

    private final void b() {
        if (d() <= 0) goto L6;
        a(0, d(), "payload_item_chrome");
        return;
    }

    private static final void c(ai r0) {
        r0.b();
    }

    public static /* synthetic */ void lambda$WJBgpqI8SBQ_MdJwgQruZK4SbJw(ai r0) {
        c(r0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(c r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.a((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"));
        r3.a();
    }

    public void a(c r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        MemorySourceFilter r0 = b(r5);
        Intrinsics.checkNotNullExpressionValue(r0, "getItem(...)");
        r4.a((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r0, MemorySourceFilter.class, "com.obric.memorydata.plugin"), r5, d());
    }

    public void a(c r3, int r4, List<Object> r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.contains("payload_item_chrome") == false) goto L6;
        MemorySourceFilter r7 = b(r4);
        Intrinsics.checkNotNullExpressionValue(r7, "getItem(...)");
        r3.b((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r7, MemorySourceFilter.class, "com.obric.memorydata.plugin"), r4, d());
        return;
    L6:
        super.a((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3) {
        a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4, List r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.a(r2);
        this.e = r2;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (Intrinsics.areEqual(this.d, r2) == false) goto L5;
        return;
    L5:
        this.d = r2;
        b();
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(List<MemorySourceFilter> r3, List<MemorySourceFilter> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "previousList");
        Intrinsics.checkNotNullParameter(r6, "currentList");
        super.a(r5, r6);
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        RecyclerView r7 = this.e;
        if (r7 == null) goto L8;
        r7.post(new $$Lambda$ai$WJBgpqI8SBQ_MdJwgQruZK4SbJw(this));
        return;
    L8:
        b();
    }

    public c b(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        DeviceAdaptiveCardListItem r10 = new DeviceAdaptiveCardListItem(r1, null, 0, 6, null);
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r10.b(true);
        r10.e(true);
        r10.f(false);
        r10.setShowCardBg(true);
        return new c(this, r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (this.e != r2) goto L5;
        this.e = null;
    L5:
        super.b(r2);
    }
}
