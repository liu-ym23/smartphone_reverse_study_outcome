package com.ss.android.lark.flow.feed.cell.thread;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import com.ss.android.lark.flow.feed.action.FlowFeedActionMode;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.cell.thread.FlowThreadAction$onItemClick$1$1", f = "FlowThreadAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowThreadAction$onItemClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ UIFeedCard $uiFeedCard;
    int label;
    final /* synthetic */ FlowThreadAction this$0;

    public FlowThreadAction$onItemClick$1$1(UIFeedCard r1, FlowThreadAction r2, Fragment r3, Continuation<? super FlowThreadAction$onItemClick$1$1> r4) {
        this.$uiFeedCard = r1;
        this.this$0 = r2;
        this.$fragment = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowThreadAction$onItemClick$1$1(this.$uiFeedCard, this.this$0, this.$fragment, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r11);
        ThreadFeedPreview r12 = this.$uiFeedCard;
        if ((r12 instanceof ThreadFeedPreview) == false) goto L7;
        ThreadFeedPreview r0 = r12;
    L8:
        if (r0 != null) goto L11;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "onItemClick: unsupported id=" + this.$uiFeedCard.getId() + ", card=" + this.$uiFeedCard.getClass().getSimpleName());
        return Unit.INSTANCE;
    L11:
        boolean r2 = false;
        if (r12.getType() != FeedCard.Type.THREAD) goto L18;
        FlowThreadAction r13 = this.this$0;
        Context r1 = this.$fragment.requireContext();
        String r4 = r0.getId();
        int r3 = r0.getType().getNumber();
        if (this.this$0.d != FlowFeedActionMode.SIDEBAR) goto L16;
        r2 = true;
    L16:
        r13.getClass();
        heb.a.a.getChatDependency().b(r1, r4, r3, r2);
    L29:
        return Unit.INSTANCE;
    L18:
        if (ForsetiConfig.a(this.$fragment.requireActivity()) == false) goto L24;
        FlowThreadAction r14 = this.this$0;
        Context r5 = this.$fragment.requireContext();
        Fragment r6 = this.$fragment;
        String r7 = r0.getId();
        int r8 = r0.getType().getNumber();
        if (this.this$0.d != FlowFeedActionMode.SIDEBAR) goto L22;
        boolean r9 = true;
    L23:
        r14.getClass();
        heb.a.a.getChatDependency().c(r5, r6, r7, r8, r9);
        goto L29
    L22:
        r9 = false;
        goto L23
    L24:
        FlowThreadAction r15 = this.this$0;
        Context r10 = this.$fragment.requireContext();
        String r16 = r0.getId();
        int r17 = r0.getType().getNumber();
        if (this.this$0.d != FlowFeedActionMode.SIDEBAR) goto L27;
        r2 = true;
    L27:
        r15.getClass();
        heb.a.a.getChatDependency().a(r10, r16, r17, r2);
        goto L29
    L7:
        r0 = null;
        goto L8
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
