package com.ss.android.lark.flow.feed.cell.chat;

import android.content.Context;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowErrorBiz;
import com.bytedance.lark.lark_biz_feed_android.f;
import com.bytedance.lark.lark_biz_feed_android.s;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.cell.chat.FlowChatAction$handleHideFeedItem$1$1", f = "FlowChatAction.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatAction$handleHideFeedItem$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ UIFeedCard $uiFeedCard;
    final /* synthetic */ LarkFeedListViewModel $vm;
    int label;
    final /* synthetic */ FlowChatAction this$0;

    public FlowChatAction$handleHideFeedItem$1$1(LarkFeedListViewModel r1, String r2, FlowChatAction r3, UIFeedCard r4, Continuation<? super FlowChatAction$handleHideFeedItem$1$1> r5) {
        this.$vm = r1;
        this.$chatId = r2;
        this.this$0 = r3;
        this.$uiFeedCard = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowChatAction$handleHideFeedItem$1$1(this.$vm, this.$chatId, this.this$0, this.$uiFeedCard, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((com.bytedance.lark.view_flow_wrapper.d) r11).a;
    L11:
        String r2 = this.$chatId;
        int r3 = com.bytedance.lark.view_flow_wrapper.d.b;
        boolean r4 = r12 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
        if ((!r4) == false) goto L14;
        com.ss.android.lark.flow.feed.utils.b.d("FlowChatAction", "LarkFeedListActionHideItem success, chatId: " + r2);
    L14:
        String r5 = this.$chatId;
        FlowChatAction r6 = this.this$0;
        UIFeedCard r7 = this.$uiFeedCard;
        Throwable r8 = null;
        if (r4 == false) goto L17;
        com.bytedance.lark.view_flow_wrapper.d.b r9 = (com.bytedance.lark.view_flow_wrapper.d.b) r12;
    L18:
        if (r9 == null) goto L20;
        Object r10 = ((com.bytedance.lark.view_flow_wrapper.d.b) r12).b();
    L22:
        if (r10 == null) goto L33;
        ViewFlowErrorBiz r13 = (ViewFlowError) r10;
        com.ss.android.lark.flow.feed.utils.b.e("FlowChatAction", "LarkFeedListActionHideItem failure, chatId: " + r5 + ", error:" + r13);
        int r14 = com.ss.android.lark.flow.feed.utils.a.a;
        int r15 = FlowChatAction.d;
        Context r16 = r6.a.getHost().getContext();
        FeedCard.Type r17 = r7.getType();
        String r18 = r7.getId();
        if ((r13 instanceof ViewFlowErrorBiz) == false) goto L26;
        ViewFlowErrorBiz r19 = r13;
    L27:
        if (r19 == null) goto L31;
        com.bytedance.lark.lark_biz_feed_android.d r20 = r19.getInner();
        if (r20 == null) goto L31;
        Integer r21 = Boxing.boxInt(r20.a);
    L32:
        com.ss.android.lark.flow.feed.utils.a.a(r16, r17, r18, r21);
    L31:
        r21 = null;
        goto L32
    L26:
        r19 = null;
    L33:
        String r22 = this.$chatId;
        if (r4 == false) goto L36;
        com.bytedance.lark.view_flow_wrapper.d.b r23 = (com.bytedance.lark.view_flow_wrapper.d.b) r12;
    L37:
        if (r23 == null) goto L39;
        r8 = ((com.bytedance.lark.view_flow_wrapper.d.b) r12).a();
    L39:
        if (r8 == null) goto L42;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "LarkFeedListActionHideItem exception, chatId: " + r22 + ", error:" + r8.getMessage());
    L42:
        return Unit.INSTANCE;
    L36:
        r23 = null;
        goto L37
    L20:
        r10 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        LarkFeedListViewModel r110 = this.$vm;
        s r24 = new s(new f(this.$chatId));
        this.label = 1;
        r12 = r110.action-vFDjHp0(r24, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
