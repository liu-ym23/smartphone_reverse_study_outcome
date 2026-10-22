package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.databinding.ItemPendingPersonalInfoCardBinding;
import com.obric.memorydata.memory.databinding.ItemPendingPersonalInfoPreviewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.impression.ViewImpressionObserver;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001+B\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001aJ\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001aH\u0016J\u001c\u0010$\u001a\u00020\b2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\u001aH\u0016J\u0014\u0010'\u001a\u00020\b2\n\u0010%\u001a\u00060\u0002R\u00020\u0000H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoPreviewAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoPreviewAdapter$PreviewViewHolder;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onImpression", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "", "isImpressionEnabled", "Lkotlin/Function0;", "", "clipVisibleBounds", "Landroid/graphics/Rect;", "onSeen", "", "onViewAll", "onConfirm", "onIgnore", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "item", "displayRevision", "boundHolders", "", "pendingCount", "", "submitItem", "newItem", "revision", CommonConsts.COUNT_TYPE, "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onViewRecycled", "onDetachedFromRecyclerView", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "PreviewViewHolder", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class av extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LifecycleOwner f11211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<ar, Unit> f11212b;
    private final Function0<Boolean> c;
    private final Function1<Rect, Boolean> d;
    private final Function1<Long, Unit> e;
    private final Function0<Unit> f;
    private final Function1<ar, Unit> g;
    private final Function1<ar, Unit> h;
    private ar i;
    private long j;
    private final Set<a> k;
    private int l;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoPreviewAdapter$PreviewViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemPendingPersonalInfoPreviewBinding;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoPreviewAdapter;Lcom/obric/memorydata/memory/databinding/ItemPendingPersonalInfoPreviewBinding;)V", "impressionObserver", "Lcom/obric/memorydata/ui/impression/ViewImpressionObserver;", "getImpressionObserver", "()Lcom/obric/memorydata/ui/impression/ViewImpressionObserver;", "bind", "", "item", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ av f11213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemPendingPersonalInfoPreviewBinding f11214b;
        private final ViewImpressionObserver t;

        public a(av r14, ItemPendingPersonalInfoPreviewBinding r15) {
            Intrinsics.checkNotNullParameter(r15, "binding");
            this.f11213a = r14;
            super((View) ZeusTransformUtils.preCheckCast(r15.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f11214b = r15;
            LinearLayout r16 = r15.pendingCard.getRoot();
            Intrinsics.checkNotNullExpressionValue(r16, "getRoot(...)");
            this.t = new ViewImpressionObserver((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"), av.a(r14), 0.0f, 0, av.b(r14), av.c(r14), 12, null);
        }

        private static final Unit a(av r1, long r2, ar r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            av.f(r1).invoke(Long.valueOf(r2));
            av.h(r1).invoke(r4);
            return Unit.INSTANCE;
        }

        private static final Unit a(av r0, ar r1) {
            av.j(r0).invoke(r1);
            return Unit.INSTANCE;
        }

        private static final void a(av r0, long r1, View r3) {
            av.f(r0).invoke(Long.valueOf(r1));
        }

        private static final Unit b(av r1, long r2, ar r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            av.f(r1).invoke(Long.valueOf(r2));
            av.i(r1).invoke(r4);
            return Unit.INSTANCE;
        }

        private static final void b(av r0, long r1, View r3) {
            av.f(r0).invoke(Long.valueOf(r1));
            av.g(r0).invoke();
        }

        public static /* synthetic */ void lambda$9STP5vz1g4AtwDhKwBdDoCwsXCQ(av r0, long r1, View r3) {
            a(r0, r1, r3);
        }

        public static /* synthetic */ Unit lambda$LPBTY16s9_fTe8ZPBbRoM8QJ8RI(av r0, long r1, ar r3) {
            return a(r0, r1, r3);
        }

        /* JADX INFO: renamed from: lambda$W1VF-iTT6yjg4Gh0JjNZPzNun5Y, reason: not valid java name */
        public static /* synthetic */ void m934lambda$W1VFiTT6yjg4Gh0JjNZPzNun5Y(av r0, long r1, View r3) {
            b(r0, r1, r3);
        }

        public static /* synthetic */ Unit lambda$WlQTUcnVHUvAncnxmZrAgos0lpo(av r0, long r1, ar r3) {
            return b(r0, r1, r3);
        }

        public static /* synthetic */ Unit lambda$ZYMWOWTJAaFCjfYRuAT8pRByqRk(av r0, ar r1) {
            return a(r0, r1);
        }

        public final ViewImpressionObserver a() {
            return this.t;
        }

        public final void a(final ar r11) {
            Intrinsics.checkNotNullParameter(r11, "item");
            final long r0 = av.d(this.f11213a);
            if (av.e(this.f11213a) <= 1) goto L5;
            boolean r2 = true;
        L6:
            OUIFrameLayout r5 = this.f11214b.pendingFrontShadow;
            Intrinsics.checkNotNullExpressionValue(r5, "pendingFrontShadow");
            View r6 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
            int r7 = 8;
            if (r2 == false) goto L9;
            int r8 = 0;
        L10:
            r6.setVisibility(r8);
            OUIFrameLayout r9 = this.f11214b.pendingStackMiddle;
            Intrinsics.checkNotNullExpressionValue(r9, "pendingStackMiddle");
            View r10 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin");
            if (r2 == false) goto L13;
            int r12 = 0;
        L14:
            r10.setVisibility(r12);
            View r13 = this.f11214b.pendingStackBack;
            Intrinsics.checkNotNullExpressionValue(r13, "pendingStackBack");
            if (r2 == false) goto L17;
            r7 = 0;
        L17:
            r13.setVisibility(r7);
            ConstraintLayout r14 = this.f11214b.getRoot();
            Intrinsics.checkNotNullExpressionValue(r14, "getRoot(...)");
            View r15 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin");
            if (r2 == false) goto L20;
            int r3 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        L21:
            r15.setPadding(r15.getPaddingLeft(), r15.getPaddingTop(), r15.getPaddingRight(), r3);
            this.f11214b.pendingViewAllText.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f11214b.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_pending_personal_info_view_all, TypedValues.Custom.S_STRING, "memory_pending_personal_info_view_all"), new Object[]{Integer.valueOf(av.e(this.f11213a))}), CharSequence.class, "com.obric.memorydata.plugin"));
            ConstraintLayout r4 = this.f11214b.getRoot();
            final av r16 = this.f11213a;
            r4.setOnClickListener(new $$Lambda$av$a$9STP5vz1g4AtwDhKwBdDoCwsXCQ(r16, r0));
            LinearLayout r17 = this.f11214b.pendingViewAll;
            final av r18 = this.f11213a;
            r17.setOnClickListener(new $$Lambda$av$a$W1VFiTT6yjg4Gh0JjNZPzNun5Y(r18, r0));
            aq r19 = aq.f11203a;
            ItemPendingPersonalInfoCardBinding r20 = this.f11214b.pendingCard;
            Intrinsics.checkNotNullExpressionValue(r20, "pendingCard");
            final av r21 = this.f11213a;
            Function1<? super ar, Unit> r22 = new $$Lambda$av$a$LPBTY16s9_fTe8ZPBbRoM8QJ8RI(r21, r0);
            final av r23 = this.f11213a;
            r19.a(r20, r11, r22, new $$Lambda$av$a$WlQTUcnVHUvAncnxmZrAgos0lpo(r23, r0));
            ViewImpressionObserver r1 = this.t;
            String r24 = r11.a();
            final av r110 = this.f11213a;
            r1.bind(r24, new $$Lambda$av$a$ZYMWOWTJAaFCjfYRuAT8pRByqRk(r110, r11));
            return;
        L20:
            r3 = 0;
            goto L21
        L13:
            r12 = 8;
            goto L14
        L9:
            r8 = 8;
            goto L10
        L5:
            r2 = false;
            goto L6
        }
    }

    public av(LifecycleOwner r3, Function1<? super ar, Unit> r4, Function0<Boolean> r5, Function1<? super Rect, Boolean> r6, Function1<? super Long, Unit> r7, Function0<Unit> r8, Function1<? super ar, Unit> r9, Function1<? super ar, Unit> r10) {
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function1<ar, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function1<Rect, Boolean> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function1<Long, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function1<ar, Unit> r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function1<ar, Unit> r18 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "onImpression");
        Intrinsics.checkNotNullParameter(r13, "isImpressionEnabled");
        Intrinsics.checkNotNullParameter(r14, "clipVisibleBounds");
        Intrinsics.checkNotNullParameter(r15, "onSeen");
        Intrinsics.checkNotNullParameter(r16, "onViewAll");
        Intrinsics.checkNotNullParameter(r17, "onConfirm");
        Intrinsics.checkNotNullParameter(r18, "onIgnore");
        this.f11211a = r11;
        this.f11212b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.k = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ LifecycleOwner a(av r0) {
        return r0.f11211a;
    }

    public static final /* synthetic */ Function0 b(av r0) {
        return r0.c;
    }

    public static final /* synthetic */ Function1 c(av r0) {
        return r0.d;
    }

    public static final /* synthetic */ long d(av r2) {
        return r2.j;
    }

    public static final /* synthetic */ int e(av r0) {
        return r0.l;
    }

    public static final /* synthetic */ Function1 f(av r0) {
        return r0.e;
    }

    public static final /* synthetic */ Function0 g(av r0) {
        return r0.f;
    }

    public static final /* synthetic */ Function1 h(av r0) {
        return r0.g;
    }

    public static final /* synthetic */ Function1 i(av r0) {
        return r0.h;
    }

    public static final /* synthetic */ Function1 j(av r0) {
        return r0.f11212b;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public final void a(ar r9, long r10, int r12) {
        ar r0 = this.i;
        long r1 = this.j;
        int r3 = this.l;
        this.i = r9;
        this.j = r10;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.k, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin")).a().onDataRefreshed();
        goto L4
    L6:
        this.l = r12;
        if (r0 != null) goto L10;
        if (r9 == null) goto L10;
        f(0);
        return;
    L10:
        if (r0 == null) goto L13;
        if (r9 != null) goto L13;
        g(0);
        return;
    L13:
        if (r9 != null) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r0, r9) == true) goto L17;
    L19:
        e(0);
        return;
    L17:
        if (r1 != r10) goto L19;
        if (r3 != r12) goto L19;
    }

    public void a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.a().unbind();
        this.k.remove(r3);
        super.b((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"));
    }

    public void a(a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        this.k.add(r1);
        ar r0 = this.i;
        if (r0 == null) goto L6;
        r1.a(r0);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), r4);
    }

    public a b(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        ItemPendingPersonalInfoPreviewBinding r13 = ItemPendingPersonalInfoPreviewBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r11, false);
        Intrinsics.checkNotNullExpressionValue(r13, "inflate(...)");
        ItemPendingPersonalInfoCardBinding r14 = r13.pendingCard;
        ViewGroup.MarginLayoutParams r3 = null;
        r14.getRoot().setBackground(null);
        float r5 = 8;
        r14.getRoot().setPadding(r14.getRoot().getPaddingLeft(), MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), r14.getRoot().getPaddingRight(), r14.getRoot().getPaddingBottom());
        r14.pendingContent.setMinHeight(0);
        ViewGroup.LayoutParams r1 = r14.pendingSourceContainer.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L5:
        if (r3 == null) goto L7;
        r3.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
    L7:
        OTextView r15 = r14.pendingSource;
        Intrinsics.checkNotNullExpressionValue(r15, "pendingSource");
        View r16 = (View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r2 = r16.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r4 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())));
        r16.setLayoutParams(r4);
        r13.pendingFrontShadow.setShadowStyle(ZeusTransformUtils.mapRes(R.style.OUIShadow_2, "style", "OUIShadow_2"));
        r13.pendingStackMiddle.setShadowStyle(ZeusTransformUtils.mapRes(R.style.OUIShadow_2, "style", "OUIShadow_2"));
        return new a(this, r13);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void b(RecyclerView.v r3) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r5) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.k, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).a().unbind();
        goto L4
    L6:
        this.k.clear();
        super.b(r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        if (this.i != null) goto L5;
        return 0;
    L5:
        return 1;
    }
}
