package com.obric.memorydata.memory.ui.list;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.memory.databinding.ItemRecommendMemoryDataBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0015H\u0002J \u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListCommonViewHolder;", "stubBinding", "Lcom/obric/memorydata/memory/databinding/ItemRecommendMemoryDataBinding;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemRecommendMemoryDataBinding;Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;)V", "getStubBinding", "()Lcom/obric/memorydata/memory/databinding/ItemRecommendMemoryDataBinding;", "memoryData", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "currentMemoryContent", "", "onCardClick", "logInfo", "getTitle", "updateHighlight", "item", "currentQuery", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bf extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemRecommendMemoryDataBinding f11231b;
    private com.obric.memorydata.memory.ui.data.a.i t;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/memory/ui/list/ScreenObservationViewHolder$bind$enhancedTouchListener$1", "Lcom/obric/memorydata/memory/utils/EnhancedTouchListener;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "onClick", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.memorydata.memory.utils.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bf f11232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a f11233b;

        a(bf r1, com.obric.memorydata.memory.ui.data.a r2) {
            this.f11232a = r1;
            this.f11233b = r2;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean a(View r10, int[] r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, "rawPos");
            if (this.f11232a.d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L7;
            this.f11232a.a(r10);
            Function0<Unit> r8 = this.f11232a.g();
            String r7 = this.f11232a.c();
            bf r1 = this.f11232a;
            com.obric.memorydata.memory.ui.data.a r3 = this.f11233b;
            OCheckBox r4 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r1.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).memoryItemCheckbox;
            Intrinsics.checkNotNullExpressionValue(r4, "memoryItemCheckbox");
            r1.a(r10, r3, r4, r11, true, r7, r8);
            return false;
        L7:
            return false;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean b(View r2, int[] r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "rawPos");
            this.f11232a.a("observation onclick");
            return true;
        }
    }

    public bf(ItemRecommendMemoryDataBinding r2, ItemMemoryListBinding r3, SelectionStateManager r4, MemoryListItemViewHolder.Companion.ItemRelatedPage r5) {
        Intrinsics.checkNotNullParameter(r2, "stubBinding");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r5, "itemRelatedPage");
        super(r3, r4, r5);
        this.f11231b = r2;
    }

    private final String M() {
        com.obric.memorydata.memory.ui.data.a.i r0 = this.t;
        boolean r2 = true;
        if (r0 == null) goto L14;
        EpisodicMemoryEntity r1 = r0.b();
        if (r1 == null) goto L14;
        String r3 = r1.getTitle();
        if (r3 == null) goto L14;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 != true) goto L14;
    L15:
        String r5 = "";
        com.obric.memorydata.memory.ui.data.a.i r10 = this.t;
        if (r2 == false) goto L25;
        if (r10 == null) goto L36;
        EpisodicMemoryEntity r11 = r10.b();
        if (r11 == null) goto L37;
        String r12 = r11.getTitle();
        if (r12 != null) goto L24;
        return "";
    L24:
        return r12;
    L37:
        return "";
    L36:
        return "";
    L25:
        if (r10 == null) goto L32;
        EpisodicMemoryEntity r13 = r10.b();
        if (r13 == null) goto L32;
        String r14 = r13.getContent();
        if (r14 == null) goto L32;
        r5 = r14;
    L32:
        int r15 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), "\n- ", 0, false, 6, null);
        if (r15 == (-1)) goto L39;
        String r6 = r5.substring(0, r15);
        Intrinsics.checkNotNullExpressionValue(r6, "substring(...)");
        return r6;
    L39:
        return r5;
    L11:
        r4 = false;
    L14:
        r2 = false;
        goto L15
    }

    private static final Unit a(Ref.FloatRef r6, Ref.FloatRef r7, Runnable r8, int r9, bf r10, View r11, MotionEvent r12) {
        Runnable r13 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r12, "event");
        int r0 = r12.getAction();
        if (r0 != 0) goto L5;
        r6.element = r12.getRawX();
        r7.element = r12.getRawY();
        r11.postDelayed(r13, 100);
    L18:
        return Unit.INSTANCE;
    L5:
        if (r0 != 1) goto L7;
    L15:
        r11.removeCallbacks(r13);
        v.a((v) ZeusTransformUtils.preCheckCast(r10, v.class, "com.obric.memorydata.plugin"), false, 1, null);
        goto L18
    L7:
        if (r0 != 2) goto L9;
        float r1 = r12.getRawX() - r6.element;
        float r14 = r12.getRawY() - r7.element;
        float r15 = r9;
        if (Math.abs(r1) > r15) goto L15;
        if (Math.abs(r14) <= r15) goto L18;
    L9:
        if (r0 == 3) goto L15;
        goto L15
    }

    private static final void a(bf r0) {
        r0.f();
    }

    public static /* synthetic */ void lambda$6MM86XzWHrUy2qBJTBQG1llbD4A(bf r0) {
        a(r0);
    }

    public static /* synthetic */ Unit lambda$vRQq2H8Z94X5k_c53Rmv2dBHJOw(Ref.FloatRef r0, Ref.FloatRef r1, Runnable r2, int r3, bf r4, View r5, MotionEvent r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void a(com.obric.memorydata.memory.ui.data.a r10, List<String> r11) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "currentQuery");
        TextView r1 = this.f11231b.shortMemoryTitle;
        Intrinsics.checkNotNullExpressionValue(r1, "shortMemoryTitle");
        int r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"));
        com.obric.memorydata.utils.aq.a(r1, M(), r3, r4, null, com.obric.memorydata.utils.al.f13166a.b(), 8, null);
    }

    public final void a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "logInfo");
        com.obric.memorydata.memory.ui.data.a.i r0 = this.t;
        if (r0 == null) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryListItemViewHolder", r13, false, 4, null);
        SelectionStateManager r14 = i();
        boolean r1 = true;
        if (r14 == null) goto L11;
        kotlinx.coroutines.flow.ar<Boolean> r15 = r14.b();
        if (r15 == null) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L11;
    L12:
        if (r1 == false) goto L14;
        e().invoke();
        return;
    L14:
        MemoryEventTracker r16 = MemoryEventTracker.f10515a;
        String r5 = r0.b().getUuid();
        Integer r6 = Integer.valueOf(r0.b().getProductType());
        String r7 = null;
        int r8 = MemoryEventTracker.ReactionType.DETAIL.getValue();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.memorydata.utils.ba.b(r2), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BaseMemoryActivity.class) == false) goto L17;
        BaseMemoryActivity r4 = (BaseMemoryActivity) ZeusTransformUtils.preCheckCast(r3, BaseMemoryActivity.class, "com.obric.memorydata.plugin");
    L18:
        if (r4 == null) goto L21;
        String r9 = r4.getEnterFrom();
        if (r9 == null) goto L21;
    L22:
        r16.a((MemoryEventTracker.Params) ZeusTransformUtils.preCheckCast(new MemoryEventTracker.ClickCardItemParams(r5, r6, r7, r8, r9, 4, null), MemoryEventTracker.Params.class, "com.obric.memorydata.plugin"));
        x.a((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin"), r0.b(), d());
        SelectionStateManager r12 = i();
        if (r12 == null) goto L28;
        r12.a().b(new cu(r0.b().getEntityId(), -306, r0.b().getPackageName(), null, 8, null));
        return;
    L28:
        return;
    L21:
        r9 = "";
        goto L22
    L17:
        r4 = null;
    L11:
        r1 = false;
        goto L12
    }

    @Override // com.obric.memorydata.memory.ui.list.v, com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r18) {
        Intrinsics.checkNotNullParameter(r18, "memoryItem");
        super.b(r18);
        a r8 = new a(this, r18);
        final Ref.FloatRef r1 = new Ref.FloatRef();
        final Ref.FloatRef r2 = new Ref.FloatRef();
        final int r4 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        final Runnable r3 = new $$Lambda$bf$6MM86XzWHrUy2qBJTBQG1llbD4A(this);
        r8.a(new $$Lambda$bf$vRQq2H8Z94X5k_c53Rmv2dBHJOw(r1, r2, r3, r4, this));
        com.obric.memorydata.memory.utils.w r0 = com.obric.memorydata.memory.utils.w.f11568a;
        ConstraintLayout r5 = this.f11231b.getRoot();
        Intrinsics.checkNotNullExpressionValue(r5, "getRoot(...)");
        r0.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.utils.c) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.utils.c.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r18, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.i r6 = (com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r18, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        this.t = r6;
        com.obric.memorydata.memory.ui.h r7 = com.obric.memorydata.memory.ui.i.f10968a.a(r6.b().getProductType());
        this.f11231b.memorySourceIcon.setImageResource(r7.b());
        this.f11231b.memorySourceText.setText(r7.a());
        TextView r9 = this.f11231b.newAuditoryDebugBadge;
        Intrinsics.checkNotNullExpressionValue(r9, "newAuditoryDebugBadge");
        View r10 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.i r11 = com.obric.memorydata.memory.ui.i.f10968a;
        int r12 = r6.b().getProductType();
        if (d() != MemoryListItemViewHolder.Companion.ItemRelatedPage.CONTEXT_AWARENESS_PAGE) goto L11;
        boolean r13 = true;
    L13:
        if (r11.a(r12, r13, AppContext.INSTANCE.isDebug()) == false) goto L15;
        int r14 = 0;
    L16:
        r10.setVisibility(r14);
        TextView r15 = this.f11231b.screenMemoryTime;
        com.obric.memorydata.memory.utils.f r16 = com.obric.memorydata.memory.utils.f.f11537a;
        long r17 = r6.b().getStartTimestamp();
        long r19 = r6.b().getEndTimestamp();
        if (d() != MemoryListItemViewHolder.Companion.ItemRelatedPage.SEARCH_PAGE) goto L19;
    L22:
        boolean r110 = true;
    L23:
        r15.setText((CharSequence) ZeusTransformUtils.preCheckCast(r16.a(r17, r19, r110), CharSequence.class, "com.obric.memorydata.plugin"));
        a(r18, r6.a());
        return;
    L19:
        if (d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L22;
        r110 = false;
        goto L23
    L15:
        r14 = 8;
        goto L16
    L11:
        r13 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.v
    public String c() {
        com.obric.memorydata.memory.ui.data.a.i r0 = this.t;
        if (r0 == null) goto L8;
        EpisodicMemoryEntity r1 = r0.b();
        if (r1 == null) goto L8;
        String r2 = r1.getContent();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }
}
