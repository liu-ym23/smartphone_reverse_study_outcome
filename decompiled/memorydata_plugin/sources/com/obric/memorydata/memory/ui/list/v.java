package com.obric.memorydata.memory.ui.list;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.viewbinding.ViewBinding;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.feedback.MemoryFeedbackScene;
import com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineSource;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0004J\b\u0010-\u001a\u00020\u000eH\u0004J\u0012\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u0017H\u0004J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0004J\u0018\u00101\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0019H\u0002JP\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\u0006\u00101\u001a\u00020\u00172\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\u0016\u00109\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\b\u0010<\u001a\u00020\u0019H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010,\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListCommonViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;", "binding", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;)V", "getItemRelatedPage", "()Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "checkedChangeHandler", "Lkotlin/Function0;", "", "getCheckedChangeHandler", "()Lkotlin/jvm/functions/Function0;", "setCheckedChangeHandler", "(Lkotlin/jvm/functions/Function0;)V", "updateSelection", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "checkboxVisible", "", "selectionKeyFor", "", "onItemDelete", "onItemDislike", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "getOnItemDislike", "()Lkotlin/jvm/functions/Function1;", "setOnItemDislike", "(Lkotlin/jvm/functions/Function1;)V", "onItemFeedback", "shouldShowFeedback", "multiSelect", "oCheckBox", "Lcom/obric/oui/checkbox/OCheckBox;", "vibrate", "vibrateLongPress", "view", "Landroid/view/View;", "keepOverlayUntilMenuDismiss", "showLongPressOverlay", "clearLongPressOverlay", "force", "holdLongPressOverlayUntilMenuDismiss", "blockMemory", "memoryContent", "showPopupMenu", "anchor", "location", "", "blockMemoryContent", "onDismiss", "shouldShowBlockMemoryOption", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bind", "currentMemoryContent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class v extends MemoryListItemViewHolder<ItemMemoryListBinding> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryListItemViewHolder.Companion.ItemRelatedPage f11333b;
    private Function0<Unit> t;
    private Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> u;
    private boolean v;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/memory/ui/list/MemoryListCommonViewHolder$bind$1", "Lcom/obric/memorydata/memory/utils/EnhancedTouchListener;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "onClick", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.memorydata.memory.utils.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f11334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a f11335b;

        a(v r1, com.obric.memorydata.memory.ui.data.a r2) {
            this.f11334a = r1;
            this.f11335b = r2;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean a(View r12, int[] r13) {
            Intrinsics.checkNotNullParameter(r12, "view");
            Intrinsics.checkNotNullParameter(r13, "rawPos");
            if (this.f11334a.d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L14;
            this.f11334a.a(r12);
            Function0<Unit> r10 = this.f11334a.g();
            com.obric.memorydata.memory.ui.data.a r0 = this.f11335b;
            MemoryEntity r4 = null;
            if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L7;
            com.obric.memorydata.memory.ui.data.a.h r1 = (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin");
        L8:
            if (r1 == null) goto L10;
            r4 = r1.b();
        L10:
            if (r4 != null) goto L12;
            boolean r8 = false;
        L13:
            v r2 = this.f11334a;
            com.obric.memorydata.memory.ui.data.a r5 = this.f11335b;
            OCheckBox r6 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r2.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).memoryItemCheckbox;
            Intrinsics.checkNotNullExpressionValue(r6, "memoryItemCheckbox");
            r2.a(r12, r5, r6, r13, r8, this.f11334a.c(), r10);
            goto L14
        L12:
            r8 = com.obric.memorydata.memory.u.f10552a.a(r4.getType());
            goto L13
        L7:
            r1 = null;
        L14:
            return false;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean b(View r11, int[] r12) {
            Intrinsics.checkNotNullParameter(r11, "view");
            Intrinsics.checkNotNullParameter(r12, "rawPos");
            SelectionStateManager r13 = this.f11334a.i();
            boolean r14 = false;
            if (r13 == null) goto L9;
            kotlinx.coroutines.flow.ar<Boolean> r15 = r13.b();
            if (r15 == null) goto L9;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r15.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L9;
            r14 = true;
        L9:
            if (r14 == false) goto L11;
            this.f11334a.e().invoke();
        L26:
            return true;
        L11:
            com.obric.memorydata.memory.ui.data.a r16 = this.f11335b;
            if (ZeusTransformUtils.instanceOf(r16, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L14;
            com.obric.memorydata.memory.ui.data.a.h r17 = (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r16, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin");
        L15:
            if (r17 == null) goto L26;
            MemoryEntity r18 = r17.b();
            if (r18 == null) goto L26;
            v r10 = this.f11334a;
            r10.a((AppEntity) ZeusTransformUtils.preCheckCast(r18, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.DETAIL);
            SelectionStateManager r19 = r10.i();
            if (r19 == null) goto L25;
            int r2 = r18.getType();
            kotlinx.coroutines.flow.ae<cu> r110 = r19.a();
            if (r2 != 10105) goto L23;
            cu r9 = new cu(r18.getId(), NetError.ERR_CACHE_READ_FAILURE, r18.get_packageName(), null, 8, null);
        L24:
            r110.b(r9);
            goto L25
        L23:
            r9 = new cu(r18.getId(), NetError.ERR_INVALID_REDIRECT, r18.get_packageName(), null, 8, null);
        L25:
            x.a((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r10.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin"), r18, r10.d());
            goto L26
        L14:
            r17 = null;
            goto L15
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemoryListCommonViewHolder$updateSelection$1$1$1$1", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "onCheckedChanged", "", "buttonView", "Lcom/obric/oui/checkbox/OCheckBox;", "isChecked", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements OCheckBox.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f11336a;

        b(v r1) {
            this.f11336a = r1;
        }

        @Override // com.obric.oui.checkbox.OCheckBox.b
        public void onCheckedChanged(OCheckBox r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "buttonView");
            RunLog.INSTANCE.debug("MemoryListItemViewHolder", "binding.memoryItemCheckbox checked changed --> " + r4);
            this.f11336a.e().invoke();
        }
    }

    public v(ItemMemoryListBinding r3, final SelectionStateManager r4, MemoryListItemViewHolder.Companion.ItemRelatedPage r5) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r5, "itemRelatedPage");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"), r4);
        this.f11333b = r5;
        r3.getRoot().setClipChildren(false);
        r3.getRoot().setClipToPadding(false);
        r3.cardWrapper.setClipChildren(false);
        r3.cardWrapper.setClipToPadding(false);
        this.t = new $$Lambda$v$DKe6t5hnVyXRLLIRj9bpkuGYy3k(this, r4);
        this.u = new $$Lambda$v$X9SITdDSlCbt4vGfIS9eMaGkmi0(this);
    }

    public static final /* synthetic */ Object a(v r2, boolean r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(boolean r3, Continuation<? super Boolean> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if (r3 == true) goto L7;
        return Boxing.boxBoolean(false);
    L7:
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryListCommonViewHolder$shouldShowBlockMemoryOption$2(null), Function2.class, "com.obric.memorydata.plugin"), r2);
    }

    private static final List a(com.obric.memorydata.memory.ui.data.a r1, MemoryFeedbackScene r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "readableDesc");
        return com.obric.memorydata.memory.ui.feedback.e.f10935a.a(r1, r2, r3);
    }

    private static final Unit a(com.obric.memorydata.memory.ui.data.a r9, v r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryListItemViewHolder", "Block memory dialog delete callback", false, 4, null);
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "delete memoryItem " + r9);
        x.b((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r10.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin"), r9);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r10.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "getContext(...)");
        Activity r12 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.memorydata.utils.ba.b(r11), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, MemorySearchActivity.class) == false) goto L5;
        MemorySearchActivity r13 = (MemorySearchActivity) ZeusTransformUtils.preCheckCast(r12, MemorySearchActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r13 == null) goto L9;
        r13.removeSingleMemoryItem(r9);
    L9:
        return Unit.INSTANCE;
    L5:
        r13 = null;
        goto L6
    }

    private static final Unit a(v r1) {
        r1.v = false;
        r1.a(true);
        return Unit.INSTANCE;
    }

    private static final Unit a(v r14, SelectionStateManager r15) {
        com.obric.memorydata.memory.ui.data.a r0 = r14.a();
        if (r0 == null) goto L36;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L16;
        if (r15 == null) goto L9;
        r15.i();
    L9:
        if (((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getType() != 10105) goto L12;
        if (r15 == null) goto L22;
        cu r1 = new cu(((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId(), NetError.ERR_CACHE_READ_FAILURE, ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().get_packageName(), null, 8, null);
        String r6 = "SEMANTIC_MEMORY";
    L14:
        r15.a(r1, r6);
    L22:
        MemoryListItemViewHolder.a((MemoryListItemViewHolder) ZeusTransformUtils.preCheckCast(r14, MemoryListItemViewHolder.class, "com.obric.memorydata.plugin"), r0, false, 2, null);
        goto L36
    L12:
        if (r15 == null) goto L22;
        r1 = new cu(((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId(), NetError.ERR_INVALID_REDIRECT, ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().get_packageName(), null, 8, null);
        r6 = "MEMORY_ENTITY";
        goto L14
    L16:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L24;
        if (r15 == null) goto L19;
        r15.i();
    L19:
        if (r15 == null) goto L22;
        cu r2 = new cu(((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getEntityId(), -306, ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getPackageName(), null, 8, null);
        String r7 = r14.e(r0);
        String r8 = "EPISODIC_MEMORY";
    L21:
        r15.a(r2, r8, r7);
        goto L22
    L24:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L30;
        if (r15 == null) goto L27;
        r15.i();
    L27:
        if (r15 == null) goto L22;
        r2 = new cu(((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getEntityId(), 502, ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getPackageName(), null, 8, null);
        r7 = r14.e(r0);
        r8 = "AUDITORY_RECORDING";
        goto L21
    L30:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L36;
        if (r15 == null) goto L33;
        r15.i();
    L33:
        if (r15 == null) goto L22;
        r1 = new cu(((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getEntityId(), NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED, ((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getPackageName(), null, 8, null);
        r6 = "AUTO_MEMORY_PRO";
    L36:
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.FloatRef r5, Ref.FloatRef r6, Runnable r7, int r8, v r9, View r10, MotionEvent r11) {
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
        a(r9, false, 1, null);
        goto L18
    L7:
        if (r0 != 2) goto L9;
        float r1 = r11.getRawX() - r5.element;
        float r13 = r11.getRawY() - r6.element;
        float r14 = r8;
        if (Math.abs(r1) > r14) goto L15;
        if (Math.abs(r13) <= r14) goto L18;
    L9:
        if (r0 == 3) goto L15;
        goto L15
    }

    private final void a(final com.obric.memorydata.memory.ui.data.a r4, String r5) {
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "Menu on block memory ...");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.memorydata.utils.ba.b(r0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, FragmentActivity.class) == false) goto L5;
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(r1, FragmentActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 == null) goto L9;
        RecommendApi.INSTANCE.showBlockMemoryDialog(r5, r2, new $$Lambda$v$Al5Ck0lElppJ7TtowbqP9bqJs0s(r4, this));
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static /* synthetic */ void a(v r11, View r12, com.obric.memorydata.memory.ui.data.a r13, OCheckBox r14, int[] r15, boolean r16, String r17, Function0 r18, int r19, Object r20) {
        Function0<Unit> r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L19;
        if ((r19 & 8) == 0) goto L7;
        int[] r7 = null;
    L9:
        if ((r19 & 32) == 0) goto L11;
        String r9 = null;
    L13:
        if ((r19 & 64) == 0) goto L15;
        Function0<Unit> r10 = null;
    L16:
        r11.a(r12, r13, r14, r7, r16, r9, r10);
        return;
    L15:
        r10 = r0;
        goto L16
    L11:
        r9 = r17;
        goto L13
    L7:
        r7 = r15;
        goto L9
    L19:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPopupMenu");
    }

    public static final /* synthetic */ void a(v r0, com.obric.memorydata.memory.ui.data.a r1) {
        r0.f(r1);
    }

    public static final /* synthetic */ void a(v r0, com.obric.memorydata.memory.ui.data.a r1, String r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(v r0, OCheckBox r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: multiSelect");
    }

    public static /* synthetic */ void a(v r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.a(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearLongPressOverlay");
    }

    private final void a(OCheckBox r3, boolean r4) {
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "Menu on multi select ...");
        if (r4 == false) goto L5;
        com.obric.memorydata.memory.ui.l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
    L5:
        r3.setChecked(true ^ r3.isChecked());
    }

    private static final void b(v r0) {
        r0.f();
    }

    public static final /* synthetic */ boolean b(v r0, com.obric.memorydata.memory.ui.data.a r1) {
        return r0.h(r1);
    }

    public static final /* synthetic */ void c(v r0, com.obric.memorydata.memory.ui.data.a r1) {
        r0.g(r1);
    }

    private static final Unit d(v r10, com.obric.memorydata.memory.ui.data.a r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryItem");
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "Menu on dislike ...");
        Activity r2 = null;
        String r3 = "19700101000000";
        if (ZeusTransformUtils.instanceOf(r11, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L14;
        String r12 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getLogId();
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "logId: " + r12);
        if (r12 == null) goto L8;
        r3 = r12;
    L8:
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_copy_to_clipboard_text, TypedValues.Custom.S_STRING, "memory_copy_to_clipboard_text"));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Activity.class) == false) goto L11;
        r2 = (Activity) ZeusTransformUtils.preCheckCast(r14, Activity.class, "com.obric.memorydata.plugin");
    L11:
        String r15 = "memory_common_logId";
    L12:
        com.obric.memorydata.utils.ba.a(r3, r15, r13, r2);
    L24:
        return Unit.INSTANCE;
    L14:
        if (ZeusTransformUtils.instanceOf(r11, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L24;
        String r16 = ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getLogId();
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "logId: " + r16);
        if (r16 == null) goto L19;
        r3 = r16;
    L19:
        r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_copy_to_clipboard_text, TypedValues.Custom.S_STRING, "memory_copy_to_clipboard_text"));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Activity.class) == false) goto L22;
        r2 = (Activity) ZeusTransformUtils.preCheckCast(r17, Activity.class, "com.obric.memorydata.plugin");
    L22:
        r15 = "screen_observation_logId";
        goto L12
    }

    private final String e(com.obric.memorydata.memory.ui.data.a r4) {
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L7;
        String r5 = ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getEntityId();
        ContextAwarenessTimelineSource r0 = ContextAwarenessTimelineSource.SCREEN_CONTENT;
    L5:
        Pair r6 = TuplesKt.to(r5, r0.getStablePrefix());
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6.component1(), String.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.component2(), String.class, "com.obric.memorydata.plugin");
        if (this.f11333b == MemoryListItemViewHolder.Companion.ItemRelatedPage.CONTEXT_AWARENESS_PAGE) goto L13;
        return r1;
    L13:
        return SelectionStateManager.f11168a.a(r7, r1);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L15;
        r5 = ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getEntityId();
        r0 = ContextAwarenessTimelineSource.AMBIENT_AUDIO;
        goto L5
    L15:
        throw new IllegalStateException(("Unsupported context-awareness selection item: " + r4.getType()).toString());
    }

    private final void f(com.obric.memorydata.memory.ui.data.a r6) {
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "Menu on delete ...");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L5;
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "entityId: " + ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getEntityId() + ", name: " + ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().c());
    L5:
        x.a((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin"), r6);
    }

    private final void g(final com.obric.memorydata.memory.ui.data.a r10) {
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "getContext(...)");
        Activity r11 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.memorydata.utils.ba.b(r9), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L5;
        return;
    L5:
        final MemoryFeedbackScene r3 = MemoryFeedbackScene.Companion.a(r10);
        if (r3 != null) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L11;
    L20:
        com.obric.memorydata.memory.ui.feedback.f.a(new com.obric.memorydata.memory.ui.feedback.f(r11), r3, null, new $$Lambda$v$QKkkT2uWinCSBDAc8Apj5kX5R0c(r10, r3), new $$Lambda$v$_1QU2WOqEPHy4ns9IB1CHhBmuyw(r10), 2, null);
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.i.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.C0539a.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.e.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L22;
        com.obric.memorydata.memory.ui.automemory.memorylist.g.f10706a.a(r11, ((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b());
        return;
    }

    private final boolean h(com.obric.memorydata.memory.ui.data.a r1) {
        if (MemoryFeedbackScene.Companion.a(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final com.obric.memorydata.memory.ui.feedback.h i(com.obric.memorydata.memory.ui.data.a r1) {
        return com.obric.memorydata.memory.ui.feedback.i.f10952a.a(r1);
    }

    /* JADX INFO: renamed from: lambda$AdwO1sFz8bJZT-75PmxawsrpBrA, reason: not valid java name */
    public static /* synthetic */ Unit m949lambda$AdwO1sFz8bJZT75PmxawsrpBrA(Ref.FloatRef r0, Ref.FloatRef r1, Runnable r2, int r3, v r4, View r5, MotionEvent r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit lambda$Al5Ck0lElppJ7TtowbqP9bqJs0s(com.obric.memorydata.memory.ui.data.a r0, v r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$DKe6t5hnVyXRLLIRj9bpkuGYy3k(v r0, SelectionStateManager r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$EMX5pMSpkpYNGKNCBhYDD2jKmP8(v r0) {
        b(r0);
    }

    public static /* synthetic */ List lambda$QKkkT2uWinCSBDAc8Apj5kX5R0c(com.obric.memorydata.memory.ui.data.a r0, MemoryFeedbackScene r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$X9SITdDSlCbt4vGfIS9eMaGkmi0(v r0, com.obric.memorydata.memory.ui.data.a r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ com.obric.memorydata.memory.ui.feedback.h lambda$_1QU2WOqEPHy4ns9IB1CHhBmuyw(com.obric.memorydata.memory.ui.data.a r0) {
        return i(r0);
    }

    public static /* synthetic */ Unit lambda$d72BQ_4VYY2yGZlQvU3Ql55Ivf4(v r0) {
        return a(r0);
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        com.obric.memorydata.memory.ui.l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 2);
    }

    public final void a(View r17, com.obric.memorydata.memory.ui.data.a r18, OCheckBox r19, int[] r20, boolean r21, String r22, Function0<Unit> r23) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        Intrinsics.checkNotNullParameter(r18, "memoryItem");
        Intrinsics.checkNotNullParameter(r19, "oCheckBox");
        SelectionStateManager r0 = i();
        boolean r2 = true;
        if (r0 == null) goto L9;
        kotlinx.coroutines.flow.ar<Boolean> r1 = r0.b();
        if (r1 == null) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L18;
        View r4 = this.c;
        Intrinsics.checkNotNullExpressionValue(r4, "itemView");
        ViewParent r5 = this.c.getParent();
        if (ZeusTransformUtils.instanceOf(r5, RecyclerView.class) == false) goto L14;
        RecyclerView r7 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5, RecyclerView.class, "com.obric.memorydata.plugin");
    L15:
        boolean r8 = com.obric.memorydata.utils.bb.a(r4, r7);
        ConstraintLayout r9 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).getRoot();
        Intrinsics.checkNotNullExpressionValue(r9, "getRoot(...)");
        LifecycleCoroutineScope r10 = x.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L31;
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryListCommonViewHolder$showPopupMenu$1(this, r21, r18, r17, r20, r6, r8, r22, r19, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L31:
        return;
    L14:
        r7 = null;
        goto L15
    L18:
        SelectionStateManager r11 = i();
        if (r11 == null) goto L25;
        kotlinx.coroutines.flow.ar<Boolean> r12 = r11.b();
        if (r12 == null) goto L25;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L25;
    L26:
        if (r2 == false) goto L33;
        a(r19, false);
        if (r6 == null) goto L34;
        r6.invoke();
        return;
    L34:
        return;
    L33:
        return;
    L25:
        r2 = false;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void a(com.obric.memorydata.memory.ui.data.a r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "memoryItem");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryListItemViewHolder", "inDetailPage: " + this.f11333b, false, 4, null);
        if (this.f11333b != MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L5;
        return;
    L5:
        if (i() == null) goto L34;
        ItemMemoryListBinding r0 = h();
        ItemMemoryListBinding r1 = (ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r0, ItemMemoryListBinding.class, "com.obric.memorydata.plugin");
        OCheckBox r2 = r1.memoryItemCheckbox;
        Intrinsics.checkNotNullExpressionValue(r2, "memoryItemCheckbox");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L9;
        int r4 = 0;
    L10:
        r3.setVisibility(r4);
        r1.memoryItemCheckbox.setClickable(r11);
        r1.memoryItemCheckbox.setFocusable(r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryListItemViewHolder", "visible: " + r11 + ", isEditMode: " + ((Boolean) ZeusTransformUtils.preCheckCast(i().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false, 4, null);
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "selectionManager selectedIds: " + i().d());
        monitor-enter(r10);
        r1.memoryItemCheckbox.setOnCheckedChangeListener(null);     // Catch: Throwable -> L28
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L17;
        OCheckBox r12 = r1.memoryItemCheckbox;     // Catch: Throwable -> L28
        boolean r5 = i().a(((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId(), "SEMANTIC_MEMORY");     // Catch: Throwable -> L28
    L15:
        r12.setChecked(r5);     // Catch: Throwable -> L28
    L25:
        r1.memoryItemCheckbox.setOnCheckedChangeListener((OCheckBox.b) ZeusTransformUtils.preCheckCast(new b(this), OCheckBox.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r10);
        ItemMemoryListBinding r13 = (ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(r0, ItemMemoryListBinding.class, "com.obric.memorydata.plugin");
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L20;
        r12 = r1.memoryItemCheckbox;     // Catch: Throwable -> L28
        r5 = i().a(e(r10), "AUDITORY_RECORDING");     // Catch: Throwable -> L28
        goto L15
    L20:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L23;
        r12 = r1.memoryItemCheckbox;     // Catch: Throwable -> L28
        r5 = i().a(e(r10), "EPISODIC_MEMORY");     // Catch: Throwable -> L28
        goto L15
    L23:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L25;
        r12 = r1.memoryItemCheckbox;     // Catch: Throwable -> L28
        r5 = i().a(((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getEntityId(), "AUTO_MEMORY_PRO");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L9:
        r4 = 8;
        goto L10
    }

    public final void a(boolean r3) {
        if (r3 == false) goto L4;
    L5:
        k r4 = k.f11315a;
        ConstraintLayout r2 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).getRoot();
        Intrinsics.checkNotNullExpressionValue(r2, "getRoot(...)");
        r4.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        if (this.v == false) goto L5;
    }

    public Function1<com.obric.memorydata.memory.ui.data.a, Unit> b() {
        return this.u;
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryItem");
        super.b(r12);
        com.obric.memorydata.memory.utils.w r0 = com.obric.memorydata.memory.utils.w.f11568a;
        ConstraintLayout r1 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).cardWrapper;
        Intrinsics.checkNotNullExpressionValue(r1, "cardWrapper");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        a r3 = new a(this, r12);
        final Ref.FloatRef r5 = new Ref.FloatRef();
        final Ref.FloatRef r6 = new Ref.FloatRef();
        final int r8 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        final Runnable r7 = new $$Lambda$v$EMX5pMSpkpYNGKNCBhYDD2jKmP8(this);
        r3.a(new $$Lambda$v$AdwO1sFz8bJZT75PmxawsrpBrA(r5, r6, r7, r8, this));
        Unit r4 = Unit.INSTANCE;
        r0.a(r2, (com.obric.memorydata.memory.utils.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.utils.c.class, "com.obric.memorydata.plugin"));
        MemoryListItemViewHolder.a((MemoryListItemViewHolder) ZeusTransformUtils.preCheckCast(this, MemoryListItemViewHolder.class, "com.obric.memorydata.plugin"), r12, false, 2, null);
    }

    public String c() {
        return "";
    }

    public final MemoryListItemViewHolder.Companion.ItemRelatedPage d() {
        return this.f11333b;
    }

    public Function0<Unit> e() {
        return this.t;
    }

    public final void f() {
        k r0 = k.f11315a;
        ConstraintLayout r4 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).getRoot();
        Intrinsics.checkNotNullExpressionValue(r4, "getRoot(...)");
        r0.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(MemoryListCommonViewHolder$showLongPressOverlay$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
    }

    public final Function0<Unit> g() {
        this.v = true;
        f();
        return new $$Lambda$v$d72BQ_4VYY2yGZlQvU3Ql55Ivf4(this);
    }
}
