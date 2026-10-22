package com.ss.android.lark.flow.feed.action.clearunread;

import android.content.Context;
import com.bytedance.lark.lark_biz_feed_android.FeedCardType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowErrorBiz;
import com.bytedance.lark.lark_biz_feed_android.j;
import com.bytedance.lark.lark_biz_feed_android.p;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.bytedance.lark.view_flow_wrapper.d;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
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
@DebugMetadata(c = "com.ss.android.lark.flow.feed.action.clearunread.FlowClearUnreadActionHandler$handle$1$1", f = "FlowClearUnreadActionHandler.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class FlowClearUnreadActionHandler$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ aeb.a $actionStatusListener;
    final /* synthetic */ UIFeedCard $data;
    final /* synthetic */ FeedActionEvent $event;
    final /* synthetic */ LarkFeedListViewModel $vm;
    int label;
    final /* synthetic */ FlowClearUnreadActionHandler this$0;

    public FlowClearUnreadActionHandler$handle$1$1(LarkFeedListViewModel r1, UIFeedCard r2, aeb.a r3, FeedActionEvent r4, FlowClearUnreadActionHandler r5, Continuation<? super FlowClearUnreadActionHandler$handle$1$1> r6) {
        this.$vm = r1;
        this.$data = r2;
        this.$actionStatusListener = r3;
        this.$event = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowClearUnreadActionHandler$handle$1$1(this.$vm, this.$data, this.$actionStatusListener, this.$event, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
        Object r13 = ((d) r12).a;
    L14:
        aeb.a r2 = this.$actionStatusListener;
        UIFeedCard r3 = this.$data;
        FeedActionEvent r4 = this.$event;
        int r5 = d.b;
        boolean r6 = r13 instanceof d.b;
        if ((!r6) == false) goto L17;
        r2.a(r3, FeedActionType.CLEAR_UNREAD, FeedActionStatus.SUCCESS, r4);
        com.ss.android.lark.flow.feed.utils.b.d("FlowClearUnreadActionHandler", "feed item clear unread success: " + r3.getId());
    L17:
        aeb.a r7 = this.$actionStatusListener;
        UIFeedCard r8 = this.$data;
        FeedActionEvent r9 = this.$event;
        FlowClearUnreadActionHandler r10 = this.this$0;
        Throwable r11 = null;
        if (r6 == false) goto L20;
        d.b r14 = (d.b) r13;
    L21:
        if (r14 == null) goto L23;
        Object r15 = ((d.b) r13).b();
    L25:
        if (r15 == null) goto L36;
        ViewFlowErrorBiz r16 = (ViewFlowError) r15;
        r7.a(r8, FeedActionType.CLEAR_UNREAD, FeedActionStatus.ERROR, r9);
        com.ss.android.lark.flow.feed.utils.b.e("FlowClearUnreadActionHandler", "feed item clear unread failure: " + r8.getId() + ", error:" + r16);
        int r17 = com.ss.android.lark.flow.feed.utils.a.a;
        Context r18 = r10.a.getHost().getContext();
        FeedCard.Type r19 = r8.getType();
        String r20 = r8.getId();
        if ((r16 instanceof ViewFlowErrorBiz) == false) goto L29;
        ViewFlowErrorBiz r21 = r16;
    L30:
        if (r21 == null) goto L34;
        com.bytedance.lark.lark_biz_feed_android.d r22 = r21.getInner();
        if (r22 == null) goto L34;
        Integer r23 = Boxing.boxInt(r22.a);
    L35:
        com.ss.android.lark.flow.feed.utils.a.a(r18, r19, r20, r23);
    L34:
        r23 = null;
        goto L35
    L29:
        r21 = null;
    L36:
        aeb.a r24 = this.$actionStatusListener;
        UIFeedCard r25 = this.$data;
        FeedActionEvent r26 = this.$event;
        if (r6 == false) goto L39;
        d.b r27 = (d.b) r13;
    L40:
        if (r27 == null) goto L42;
        r11 = ((d.b) r13).a();
    L42:
        if (r11 == null) goto L45;
        r24.a(r25, FeedActionType.CLEAR_UNREAD, FeedActionStatus.ERROR, r26);
        com.ss.android.lark.flow.feed.utils.b.b("FlowClearUnreadActionHandler", "feed item clear unread exception: " + r25.getId() + ", error:" + r11.getMessage());
    L45:
        return Unit.INSTANCE;
    L39:
        r27 = null;
        goto L40
    L23:
        r15 = null;
        goto L25
    L20:
        r14 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        LarkFeedListViewModel r110 = this.$vm;
        String r28 = this.$data.getId();
        if (r28 != null) goto L11;
        r28 = "";
    L11:
        FeedCardType.a r29 = FeedCardType.Companion;
        int r30 = this.$data.getType().getNumber();
        r29.getClass();
        p r31 = new p(new j(r28, FeedCardType.a.a(r30)));
        this.label = 1;
        r13 = r110.action-vFDjHp0(r31, this);
        if (r13 != r0) goto L14;
        return r0;
    }
}
