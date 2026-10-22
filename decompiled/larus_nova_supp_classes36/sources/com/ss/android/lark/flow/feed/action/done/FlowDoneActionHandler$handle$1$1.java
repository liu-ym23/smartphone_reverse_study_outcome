package com.ss.android.lark.flow.feed.action.done;

import android.content.Context;
import com.bytedance.lark.lark_biz_feed_android.FeedCardType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowErrorBiz;
import com.bytedance.lark.lark_biz_feed_android.a0;
import com.bytedance.lark.lark_biz_feed_android.j;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.bytedance.lark.view_flow_wrapper.d;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.action.done.FlowDoneActionHandler$handle$1$1", f = "FlowDoneActionHandler.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class FlowDoneActionHandler$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ aeb.a $actionStatusListener;
    final /* synthetic */ UIFeedCard $data;
    final /* synthetic */ FeedActionEvent $event;
    final /* synthetic */ LarkFeedListViewModel $vm;
    int label;
    final /* synthetic */ FlowDoneActionHandler this$0;

    public FlowDoneActionHandler$handle$1$1(LarkFeedListViewModel r1, UIFeedCard r2, aeb.a r3, FeedActionEvent r4, FlowDoneActionHandler r5, Continuation<? super FlowDoneActionHandler$handle$1$1> r6) {
        this.$vm = r1;
        this.$data = r2;
        this.$actionStatusListener = r3;
        this.$event = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowDoneActionHandler$handle$1$1(this.$vm, this.$data, this.$actionStatusListener, this.$event, this.this$0, r9);
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
    L11:
        ChatFeedPreview r2 = this.$data;
        aeb.a r3 = this.$actionStatusListener;
        FeedActionEvent r4 = this.$event;
        int r5 = d.b;
        boolean r6 = r13 instanceof d.b;
        if ((!r6) == false) goto L35;
        if (r2 != null) goto L16;
    L34:
        r3.a(r2, FeedActionType.DONE, FeedActionStatus.SUCCESS, r4);
        com.ss.android.lark.flow.feed.utils.b.d("Feed_Refactor_FeedItemsViewModel", "feed item set done success: " + r2.getId());
        goto L35
    L16:
        if (r2.getType() != FeedCard.Type.CHAT) goto L34;
        ChatFeedPreview r7 = r2;
        int r8 = (int) r7.getUnreadCount();
        boolean r9 = r7.isRemind();
        int r10 = qeb.a.a;
        if (r8 != 0) goto L20;
        String r11 = "none";
    L24:
        if (r7.getChatType() != Chat.Type.GROUP) goto L30;
        if (r7.isMeeting() == false) goto L28;
        String r14 = "meeting";
    L33:
        String r15 = r7.getId();
        Intrinsics.checkNotNullParameter(r11, "badge");
        Intrinsics.checkNotNullParameter(r14, "chatType");
        Statistics.sendEvent("chat_done", new JSONObject().put("badge", r11).put("chat_type", r14).put("chat_id", r15).put("source", "feeFeedide").put("calltype", "shortcutkey"));
        goto L34
    L28:
        r14 = INotificationHitPoint.ChatType.CHAT_TYPE_GROUP;
        goto L33
    L30:
        if (r7.isBotChat() == false) goto L32;
        r14 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT;
        goto L33
    L32:
        r14 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE;
        goto L33
    L20:
        if (r9 == false) goto L22;
        r11 = "number";
        goto L24
    L22:
        r11 = "dot";
    L35:
        aeb.a r16 = this.$actionStatusListener;
        UIFeedCard r17 = this.$data;
        FeedActionEvent r18 = this.$event;
        FlowDoneActionHandler r19 = this.this$0;
        Throwable r20 = null;
        if (r6 == false) goto L38;
        d.b r21 = (d.b) r13;
    L39:
        if (r21 == null) goto L41;
        Object r22 = ((d.b) r13).b();
    L43:
        if (r22 == null) goto L54;
        ViewFlowErrorBiz r23 = (ViewFlowError) r22;
        r16.a(r17, FeedActionType.DONE, FeedActionStatus.ERROR, r18);
        com.ss.android.lark.flow.feed.utils.b.e("Feed_Refactor_FeedItemsViewModel", "feed item set done failure: " + r17.getId() + ", error:" + r23);
        int r24 = com.ss.android.lark.flow.feed.utils.a.a;
        int r25 = FlowDoneActionHandler.c;
        Context r26 = r19.a.getHost().getContext();
        FeedCard.Type r27 = r17.getType();
        String r28 = r17.getId();
        if ((r23 instanceof ViewFlowErrorBiz) == false) goto L47;
        ViewFlowErrorBiz r29 = r23;
    L48:
        if (r29 == null) goto L52;
        com.bytedance.lark.lark_biz_feed_android.d r30 = r29.getInner();
        if (r30 == null) goto L52;
        Integer r31 = Boxing.boxInt(r30.a);
    L53:
        com.ss.android.lark.flow.feed.utils.a.a(r26, r27, r28, r31);
    L52:
        r31 = null;
        goto L53
    L47:
        r29 = null;
    L54:
        aeb.a r32 = this.$actionStatusListener;
        UIFeedCard r33 = this.$data;
        FeedActionEvent r34 = this.$event;
        if (r6 == false) goto L57;
        d.b r35 = (d.b) r13;
    L58:
        if (r35 == null) goto L60;
        r20 = ((d.b) r13).a();
    L60:
        if (r20 == null) goto L63;
        r32.a(r33, FeedActionType.DONE, FeedActionStatus.ERROR, r34);
        com.ss.android.lark.flow.feed.utils.b.b("Feed_Refactor_FeedItemsViewModel", "feed item set done exception: " + r33.getId() + ", error:" + r20.getMessage());
    L63:
        return Unit.INSTANCE;
    L57:
        r35 = null;
        goto L58
    L41:
        r22 = null;
        goto L43
    L38:
        r21 = null;
        goto L39
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        LarkFeedListViewModel r110 = this.$vm;
        String r36 = this.$data.getId();
        FeedCardType.a r37 = FeedCardType.Companion;
        int r38 = this.$data.getType().getNumber();
        r37.getClass();
        a0 r39 = new a0(new j(r36, FeedCardType.a.a(r38)));
        this.label = 1;
        r13 = r110.action-vFDjHp0(r39, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
