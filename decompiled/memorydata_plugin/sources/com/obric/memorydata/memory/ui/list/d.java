package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.memory.databinding.ItemAutoMemoryProDataBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryDetailActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0002J \u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AutoMemoryProViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListCommonViewHolder;", "stubBinding", "Lcom/obric/memorydata/memory/databinding/ItemAutoMemoryProDataBinding;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemAutoMemoryProDataBinding;Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;)V", "getStubBinding", "()Lcom/obric/memorydata/memory/databinding/ItemAutoMemoryProDataBinding;", "memoryData", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$AutoMemoryPro;", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "currentMemoryContent", "", "onCardClick", "updateHighlight", "item", "currentQuery", "", "autoMemoryPreviewContent", "entity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemAutoMemoryProDataBinding f11301b;
    private com.obric.memorydata.memory.ui.data.a.b t;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/memory/ui/list/AutoMemoryProViewHolder$bind$enhancedTouchListener$1", "Lcom/obric/memorydata/memory/utils/EnhancedTouchListener;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "onClick", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.memorydata.memory.utils.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f11302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a f11303b;

        a(d r1, com.obric.memorydata.memory.ui.data.a r2) {
            this.f11302a = r1;
            this.f11303b = r2;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean a(View r14, int[] r15) {
            Intrinsics.checkNotNullParameter(r14, "view");
            Intrinsics.checkNotNullParameter(r15, "rawPos");
            if (this.f11302a.d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L7;
            v r3 = (v) ZeusTransformUtils.preCheckCast(this.f11302a, v.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.memory.ui.data.a r5 = this.f11303b;
            OCheckBox r6 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(this.f11302a.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).memoryItemCheckbox;
            Intrinsics.checkNotNullExpressionValue(r6, "memoryItemCheckbox");
            v.a(r3, r14, r5, r6, r15, true, this.f11302a.c(), null, 64, null);
            return false;
        L7:
            return false;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean b(View r2, int[] r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "rawPos");
            d.a(this.f11302a);
            return true;
        }
    }

    public d(ItemAutoMemoryProDataBinding r2, ItemMemoryListBinding r3, SelectionStateManager r4, MemoryListItemViewHolder.Companion.ItemRelatedPage r5) {
        Intrinsics.checkNotNullParameter(r2, "stubBinding");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r5, "itemRelatedPage");
        super(r3, r4, r5);
        this.f11301b = r2;
    }

    private final void M() {
        com.obric.memorydata.memory.ui.data.a.b r0 = this.t;
        if (r0 == null) goto L23;
        SelectionStateManager r1 = i();
        boolean r2 = true;
        if (r1 == null) goto L11;
        kotlinx.coroutines.flow.ar<Boolean> r3 = r1.b();
        if (r3 == null) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L11;
    L12:
        if (r2 == false) goto L14;
        e().invoke();
        return;
    L14:
        AppEntity r4 = r0.b().convertToAppEntity();
        if (r4 == null) goto L17;
        a(r4, MemoryEventTracker.ReactionType.DETAIL);
    L17:
        AutoMemoryDetailActivity.a r5 = AutoMemoryDetailActivity.Companion;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        AutoMemoryDetailActivity.a.a(r5, r6, r0.b().getId(), false, 4, null);
        SelectionStateManager r12 = i();
        if (r12 == null) goto L25;
        kotlinx.coroutines.flow.ae<cu> r13 = r12.a();
        if (r13 == null) goto L26;
        r13.b(new cu(r0.b().getEntityId(), NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED, r0.b().getPackageName(), null, 8, null));
        return;
    L26:
        return;
    L25:
        return;
    L11:
        r2 = false;
        goto L12
    }

    private final String a(AutoMemoryProEntity r7) {
        String r6 = r7.getSubtitle();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r6 = null;
    L6:
        if (r6 == null) goto L8;
        return r6;
    L8:
        return StringsKt.replace$default(r7.getContent(), "-", "", false, 4, null);
    }

    private static final Unit a(Ref.FloatRef r5, Ref.FloatRef r6, Runnable r7, int r8, d r9, View r10, MotionEvent r11) {
        Runnable r12 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r11, "event");
        int r0 = r11.getAction();
        if (r0 != 0) goto L5;
        r5.element = r11.getRawX();
        r6.element = r11.getRawY();
        r10.postDelayed(r12, 100);
    L18:
        return Unit.INSTANCE;
    L5:
        if (r0 != 1) goto L7;
    L15:
        r10.removeCallbacks(r12);
        View r13 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r9.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).overlay;
        Intrinsics.checkNotNullExpressionValue(r13, "overlay");
        r13.setVisibility(8);
        goto L18
    L7:
        if (r0 != 2) goto L9;
        float r1 = r11.getRawX() - r5.element;
        float r14 = r11.getRawY() - r6.element;
        float r15 = r8;
        if (Math.abs(r1) > r15) goto L15;
        if (Math.abs(r14) <= r15) goto L18;
    L9:
        if (r0 == 3) goto L15;
        goto L15
    }

    public static final /* synthetic */ void a(d r0) {
        r0.M();
    }

    private static final void b(d r2) {
        View r3 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r2.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).overlay;
        Intrinsics.checkNotNullExpressionValue(r3, "overlay");
        r3.setVisibility(0);
    }

    public static /* synthetic */ void lambda$Fe5oCiX5SRhRz4SprKtucU41sjk(d r0) {
        b(r0);
    }

    public static /* synthetic */ Unit lambda$XRPeRZQZvjeMM65oipPDkmtvf6w(Ref.FloatRef r0, Ref.FloatRef r1, Runnable r2, int r3, d r4, View r5, MotionEvent r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void a(com.obric.memorydata.memory.ui.data.a r11, List<String> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "currentQuery");
        if (ZeusTransformUtils.instanceOf(r11, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.b r13 = (com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin");
    L6:
        if (r13 == null) goto L9;
        AutoMemoryProEntity r14 = r13.b();
        if (r14 == null) goto L9;
    L12:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getTitle(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r15) == false) goto L15;
        r15 = r14.getContent();
    L15:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
        TextView r2 = this.f11301b.autoMemoryTitle;
        Intrinsics.checkNotNullExpressionValue(r2, "autoMemoryTitle");
        com.obric.memorydata.utils.aq.a(r2, r3, r4, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6")), null, com.obric.memorydata.utils.al.f13166a.b(), 8, null);
        return;
    L9:
        com.obric.memorydata.memory.ui.data.a.b r16 = this.t;
        if (r16 == null) goto L17;
        r14 = r16.b();
        goto L12
    L17:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.v, com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryItem");
        super.b(r10);
        a r0 = new a(this, r10);
        final Ref.FloatRef r2 = new Ref.FloatRef();
        final Ref.FloatRef r3 = new Ref.FloatRef();
        final int r5 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        final Runnable r4 = new $$Lambda$d$Fe5oCiX5SRhRz4SprKtucU41sjk(this);
        r0.a(new $$Lambda$d$XRPeRZQZvjeMM65oipPDkmtvf6w(r2, r3, r4, r5, this));
        com.obric.memorydata.memory.utils.w r1 = com.obric.memorydata.memory.utils.w.f11568a;
        ConstraintLayout r6 = this.f11301b.getRoot();
        Intrinsics.checkNotNullExpressionValue(r6, "getRoot(...)");
        r1.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.utils.c) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.utils.c.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.b r7 = (com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 != null) goto L8;
        return;
    L8:
        this.t = r7;
        TextView r8 = this.f11301b.autoMemoryTime;
        com.obric.memorydata.memory.utils.f r9 = com.obric.memorydata.memory.utils.f.f11537a;
        long r11 = r7.b().getModifyTime();
        if (d() != MemoryListItemViewHolder.Companion.ItemRelatedPage.SEARCH_PAGE) goto L11;
    L14:
        boolean r12 = true;
    L15:
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.a(r11, r12), CharSequence.class, "com.obric.memorydata.plugin"));
        this.f11301b.autoMemoryContent.setText((CharSequence) ZeusTransformUtils.preCheckCast(a(r7.b()), CharSequence.class, "com.obric.memorydata.plugin"));
        this.f11301b.autoMemoryContent.setLineSpacing(0.0f, 1.2f);
        a(r10, r7.a());
        return;
    L11:
        if (d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L14;
        r12 = false;
        goto L15
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.v
    public String c() {
        com.obric.memorydata.memory.ui.data.a.b r0 = this.t;
        if (r0 == null) goto L7;
        AutoMemoryProEntity r1 = r0.b();
        if (r1 == null) goto L7;
        String r2 = r1.getContent();
    L8:
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
    }
}
