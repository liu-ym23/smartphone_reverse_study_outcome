package com.ss.android.lark.flow.feed.action.markunread;

import android.content.Context;
import com.bytedance.lark.lark_biz_feed_android.FeedCardType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowErrorBiz;
import com.bytedance.lark.lark_biz_feed_android.j;
import com.bytedance.lark.lark_biz_feed_android.t;
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
@DebugMetadata(c = "com.ss.android.lark.flow.feed.action.markunread.FlowMarkUnreadActionHandler$handle$1$1", f = "FlowMarkUnreadActionHandler.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class FlowMarkUnreadActionHandler$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ aeb.a $actionStatusListener;
    final /* synthetic */ UIFeedCard $data;
    final /* synthetic */ FeedActionEvent $event;
    final /* synthetic */ LarkFeedListViewModel $vm;
    int label;
    final /* synthetic */ FlowMarkUnreadActionHandler this$0;

    public FlowMarkUnreadActionHandler$handle$1$1(LarkFeedListViewModel r1, UIFeedCard r2, aeb.a r3, FeedActionEvent r4, FlowMarkUnreadActionHandler r5, Continuation<? super FlowMarkUnreadActionHandler$handle$1$1> r6) {
        this.$vm = r1;
        this.$data = r2;
        this.$actionStatusListener = r3;
        this.$event = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowMarkUnreadActionHandler$handle$1$1(this.$vm, this.$data, this.$actionStatusListener, this.$event, this.this$0, r9);
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
        Object r12 = ((d) r11).a;
    L14:
        aeb.a r2 = this.$actionStatusListener;
        UIFeedCard r3 = this.$data;
        FeedActionEvent r4 = this.$event;
        int r5 = d.b;
        boolean r6 = r12 instanceof d.b;
        if ((!r6) == false) goto L17;
        r2.a(r3, FeedActionType.MARK_UNREAD, FeedActionStatus.SUCCESS, r4);
        com.ss.android.lark.flow.feed.utils.b.d("MarkUnreadActionHandler", "feed item mark unread success: " + r3.getId());
    L17:
        aeb.a r7 = this.$actionStatusListener;
        UIFeedCard r8 = this.$data;
        FeedActionEvent r9 = this.$event;
        FlowMarkUnreadActionHandler r10 = this.this$0;
        Throwable r13 = null;
        if (r6 == false) goto L20;
        d.b r14 = (d.b) r12;
    L21:
        if (r14 == null) goto L23;
        Object r15 = ((d.b) r12).b();
    L24:
        if (r15 == null) goto L35;
        ViewFlowErrorBiz r16 = (ViewFlowError) r15;
        r7.a(r8, FeedActionType.MARK_UNREAD, FeedActionStatus.ERROR, r9);
        com.ss.android.lark.flow.feed.utils.b.e("MarkUnreadActionHandler", "feed item mark unread failure: " + r8.getId() + ", error:" + r16);
        int r17 = com.ss.android.lark.flow.feed.utils.a.a;
        int r18 = FlowMarkUnreadActionHandler.c;
        Context r19 = r10.a.getHost().getContext();
        FeedCard.Type r20 = r8.getType();
        String r21 = r8.getId();
        if ((r16 instanceof ViewFlowErrorBiz) == false) goto L28;
        ViewFlowErrorBiz r22 = r16;
    L29:
        if (r22 == null) goto L33;
        com.bytedance.lark.lark_biz_feed_android.d r23 = r22.getInner();
        if (r23 == null) goto L33;
        Integer r24 = Boxing.boxInt(r23.a);
    L34:
        com.ss.android.lark.flow.feed.utils.a.a(r19, r20, r21, r24);
    L33:
        r24 = null;
        goto L34
    L28:
        r22 = null;
    L35:
        aeb.a r25 = this.$actionStatusListener;
        UIFeedCard r26 = this.$data;
        FeedActionEvent r27 = this.$event;
        if (r6 == false) goto L38;
        d.b r28 = (d.b) r12;
    L39:
        if (r28 == null) goto L41;
        r13 = ((d.b) r12).a();
    L41:
        if (r13 == null) goto L44;
        r25.a(r26, FeedActionType.MARK_UNREAD, FeedActionStatus.ERROR, r27);
        com.ss.android.lark.flow.feed.utils.b.e("MarkUnreadActionHandler", "feed item mark unread exception: " + r26.getId() + ", error: " + r13.getMessage());
    L44:
        return Unit.INSTANCE;
    L38:
        r28 = null;
        goto L39
    L23:
        r15 = null;
        goto L24
    L20:
        r14 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        LarkFeedListViewModel r110 = this.$vm;
        String r29 = this.$data.getId();
        if (r29 != null) goto L11;
        r29 = "";
    L11:
        FeedCardType.a r30 = FeedCardType.Companion;
        int r31 = this.$data.getType().getNumber();
        r30.getClass();
        t r32 = new t(new j(r29, FeedCardType.a.a(r31)), true);
        this.label = 1;
        r12 = r110.action-vFDjHp0(r32, this);
        if (r12 != r0) goto L14;
        return r0;
    }
}
