package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.memory.databinding.ItemAudioMemoryDataBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0017J\b\u0010!\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AudioMemoryViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListCommonViewHolder;", "stubBinding", "Lcom/obric/memorydata/memory/databinding/ItemAudioMemoryDataBinding;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemAudioMemoryDataBinding;Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;)V", "onItemDislike", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "memoryItem", "", "getOnItemDislike", "()Lkotlin/jvm/functions/Function1;", "setOnItemDislike", "(Lkotlin/jvm/functions/Function1;)V", "getAudioMemoryTitle", "", "entity", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "updateHighlight", "item", "currentQuery", "", "getTimeStringText", "bind", "currentMemoryContent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemAudioMemoryDataBinding f11248b;
    private Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> t;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/memory/ui/list/AudioMemoryViewHolder$bind$1$1", "Lcom/obric/memorydata/memory/utils/EnhancedTouchListener;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "onClick", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.memorydata.memory.utils.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f11249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a f11250b;
        final /* synthetic */ fj c;

        a(c r1, com.obric.memorydata.memory.ui.data.a r2, fj r3) {
            this.f11249a = r1;
            this.f11250b = r2;
            this.c = r3;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean a(View r14, int[] r15) {
            Intrinsics.checkNotNullParameter(r14, "view");
            Intrinsics.checkNotNullParameter(r15, "rawPos");
            if (this.f11249a.d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L7;
            this.f11249a.a(r14);
            v r3 = (v) ZeusTransformUtils.preCheckCast(this.f11249a, v.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.memory.ui.data.a r5 = this.f11250b;
            OCheckBox r6 = ((ItemMemoryListBinding) ZeusTransformUtils.preCheckCast(this.f11249a.h(), ItemMemoryListBinding.class, "com.obric.memorydata.plugin")).memoryItemCheckbox;
            Intrinsics.checkNotNullExpressionValue(r6, "memoryItemCheckbox");
            v.a(r3, r14, r5, r6, r15, false, null, this.f11249a.g(), 32, null);
            return false;
        L7:
            return false;
        }

        @Override // com.obric.memorydata.memory.utils.c
        public boolean b(View r12, int[] r13) {
            Intrinsics.checkNotNullParameter(r12, "view");
            Intrinsics.checkNotNullParameter(r13, "rawPos");
            SelectionStateManager r14 = this.f11249a.i();
            boolean r0 = false;
            if (r14 == null) goto L9;
            kotlinx.coroutines.flow.ar<Boolean> r15 = r14.b();
            if (r15 == null) goto L9;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r15.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L9;
            r0 = true;
        L9:
            if (r0 == false) goto L11;
            this.f11249a.e().invoke();
        L18:
            return true;
        L11:
            AppEntity r3 = this.c.convertToAppEntity();
            if (r3 != null) goto L14;
            return true;
        L14:
            SelectionStateManager r16 = this.f11249a.i();
            if (r16 == null) goto L17;
            fj r1 = this.c;
            r16.a().b(new cu(r1.getEntityId(), 502, r1.getPackageName(), null, 8, null));
        L17:
            this.f11249a.a(r3, MemoryEventTracker.ReactionType.DETAIL);
            com.obric.memorydata.memory.utils.f.f11537a.b(r3);
            com.obric.memorydata.memory.ui.data.c.a((com.obric.memorydata.memory.ui.data.c) ZeusTransformUtils.preCheckCast(this.f11249a, com.obric.memorydata.memory.ui.data.c.class, "com.obric.memorydata.plugin"), r3, MemoryEventTracker.MemoryPage.MEMORY_LIST.getValue(), null, 4, null);
            goto L18
        }
    }

    public c(ItemAudioMemoryDataBinding r2, ItemMemoryListBinding r3, SelectionStateManager r4, MemoryListItemViewHolder.Companion.ItemRelatedPage r5) {
        Intrinsics.checkNotNullParameter(r2, "stubBinding");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r5, "itemRelatedPage");
        super(r3, r4, r5);
        this.f11248b = r2;
    }

    private final String a(fj r2) {
        return b.f11220a.a(r2.h(), r2.c());
    }

    private static final Unit a(Ref.FloatRef r6, Ref.FloatRef r7, Runnable r8, int r9, c r10, View r11, MotionEvent r12) {
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

    private static final void a(c r0) {
        r0.f();
    }

    private final String b(fj r7) {
        if (r7 != null) goto L6;
        return "";
    L6:
        if (r7.d() == 0) goto L8;
        com.obric.memorydata.memory.utils.f r0 = com.obric.memorydata.memory.utils.f.f11537a;
        long r1 = r7.getCreateTime();
        long r3 = r7.o();
        if (d() != MemoryListItemViewHolder.Companion.ItemRelatedPage.SEARCH_PAGE) goto L12;
    L15:
        boolean r6 = true;
    L17:
        return r0.a(r1, r3, r6);
    L12:
        if (d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L15;
        r6 = false;
        goto L17
    L8:
        return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.audio_memory_editing_tips, TypedValues.Custom.S_STRING, "audio_memory_editing_tips"));
    }

    public static /* synthetic */ void lambda$7LZacp3jSK4pC97rNY12yJtEdIE(c r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$x4u0wqSS1o-TH7KKOiwg5Ojq2h8, reason: not valid java name */
    public static /* synthetic */ Unit m938lambda$x4u0wqSS1oTH7KKOiwg5Ojq2h8(Ref.FloatRef r0, Ref.FloatRef r1, Runnable r2, int r3, c r4, View r5, MotionEvent r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void a(com.obric.memorydata.memory.ui.data.a r11, List<String> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "currentQuery");
        if (r11 != null) goto L5;
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryListItemViewHolder", "item == null || item !is MemoryItem.AudioEntity", null, 4, null);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r11, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L9;
        TextView r2 = this.f11248b.audioMemoryTitle;
        Intrinsics.checkNotNullExpressionValue(r2, "audioMemoryTitle");
        int r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"));
        com.obric.memorydata.utils.aq.a(r2, a(((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b()), r4, r5, null, com.obric.memorydata.utils.al.f13166a.b(), 8, null);
    }

    @Override // com.obric.memorydata.memory.ui.list.v
    public Function1<com.obric.memorydata.memory.ui.data.a, Unit> b() {
        return this.t;
    }

    @Override // com.obric.memorydata.memory.ui.list.v, com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r12) {
        Intrinsics.checkNotNullParameter(r12, "memoryItem");
        super.b(r12);
        if (ZeusTransformUtils.instanceOf(r12, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.C0539a r0 = (com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L11;
        fj r1 = r0.b();
        if (r1 == null) goto L12;
        a(r12, ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).a());
        this.f11248b.audioMemoryTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(b(r1), CharSequence.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.utils.w r2 = com.obric.memorydata.memory.utils.w.f11568a;
        ConstraintLayout r3 = this.f11248b.getRoot();
        Intrinsics.checkNotNullExpressionValue(r3, "getRoot(...)");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        a r5 = new a(this, r12, r1);
        final Ref.FloatRef r6 = new Ref.FloatRef();
        final Ref.FloatRef r7 = new Ref.FloatRef();
        final int r9 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        final Runnable r8 = new $$Lambda$c$7LZacp3jSK4pC97rNY12yJtEdIE(this);
        r5.a(new $$Lambda$c$x4u0wqSS1oTH7KKOiwg5Ojq2h8(r6, r7, r8, r9, this));
        Unit r11 = Unit.INSTANCE;
        r2.a(r4, (com.obric.memorydata.memory.utils.c) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.utils.c.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.v
    public String c() {
        return this.f11248b.audioMemoryTitle.getText().toString();
    }
}
