package com.ss.android.lark.flow.feed.action.delete;

import com.bytedance.lark.lark_biz_feed_android.FeedCardType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.j;
import com.bytedance.lark.lark_biz_feed_android.r;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.bytedance.lark.view_flow_wrapper.d;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.flow.feed.utils.b;
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
@DebugMetadata(c = "com.ss.android.lark.flow.feed.action.delete.FlowDeleteActionFactory$performDelete$1$1", f = "FlowDeleteActionFactory.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
final class FlowDeleteActionFactory$performDelete$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ aeb.a $actionStatusListener;
    final /* synthetic */ UIFeedCard $data;
    final /* synthetic */ FeedActionEvent $event;
    final /* synthetic */ LarkFeedListViewModel $vm;
    int label;
    final /* synthetic */ a this$0;

    public FlowDeleteActionFactory$performDelete$1$1(LarkFeedListViewModel r1, UIFeedCard r2, aeb.a r3, FeedActionEvent r4, a r5, Continuation<? super FlowDeleteActionFactory$performDelete$1$1> r6) {
        this.$vm = r1;
        this.$data = r2;
        this.$actionStatusListener = r3;
        this.$event = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowDeleteActionFactory$performDelete$1$1(this.$vm, this.$data, this.$actionStatusListener, this.$event, null, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((d) r8).a;
    L14:
        aeb.a r2 = this.$actionStatusListener;
        UIFeedCard r3 = this.$data;
        FeedActionEvent r4 = this.$event;
        int r5 = d.b;
        boolean r6 = r9 instanceof d.b;
        if ((!r6) == false) goto L17;
        r2.a(r3, FeedActionType.DELETE, FeedActionStatus.SUCCESS, r4);
        b.d("FlowDeleteActionFactory", "feed item delete success: " + r3.getId());
    L17:
        aeb.a r7 = this.$actionStatusListener;
        UIFeedCard r10 = this.$data;
        FeedActionEvent r11 = this.$event;
        Throwable r12 = null;
        if (r6 == false) goto L20;
        d.b r13 = (d.b) r9;
    L21:
        if (r13 == null) goto L23;
        Object r14 = ((d.b) r9).b();
    L24:
        if (r14 != null) goto L35;
        aeb.a r15 = this.$actionStatusListener;
        UIFeedCard r16 = this.$data;
        FeedActionEvent r17 = this.$event;
        if (r6 == false) goto L28;
        d.b r18 = (d.b) r9;
    L29:
        if (r18 == null) goto L31;
        r12 = ((d.b) r9).a();
    L31:
        if (r12 == null) goto L34;
        r15.a(r16, FeedActionType.DELETE, FeedActionStatus.ERROR, r17);
        b.b("FlowDeleteActionFactory", "feed item delete exception: " + r12.getMessage() + ", feedId:" + r16.getId());
    L34:
        return Unit.INSTANCE;
    L28:
        r18 = null;
        goto L29
    L35:
        r7.a(r10, FeedActionType.DELETE, FeedActionStatus.ERROR, r11);
        b.e("FlowDeleteActionFactory", "feed item delete failure: " + r10.getId() + ", error:" + ((ViewFlowError) r14));
        int r19 = com.ss.android.lark.flow.feed.utils.a.a;
        throw null;
    L23:
        r14 = null;
        goto L24
    L20:
        r13 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        LarkFeedListViewModel r20 = this.$vm;
        String r21 = this.$data.getId();
        if (r21 != null) goto L11;
        r21 = "";
    L11:
        FeedCardType.a r22 = FeedCardType.Companion;
        int r23 = this.$data.getType().getNumber();
        r22.getClass();
        r r24 = new r(new j(r21, FeedCardType.a.a(r23)));
        this.label = 1;
        r9 = r20.action-vFDjHp0(r24, this);
        if (r9 != r0) goto L14;
        return r0;
    }
}
