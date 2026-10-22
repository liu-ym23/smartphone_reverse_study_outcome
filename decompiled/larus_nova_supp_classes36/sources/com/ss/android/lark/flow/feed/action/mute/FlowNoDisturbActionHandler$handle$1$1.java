package com.ss.android.lark.flow.feed.action.mute;

import android.content.Context;
import com.bytedance.lark.lark_biz_feed_android.FeedCardType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowErrorBiz;
import com.bytedance.lark.lark_biz_feed_android.b0;
import com.bytedance.lark.lark_biz_feed_android.j;
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
@DebugMetadata(c = "com.ss.android.lark.flow.feed.action.mute.FlowNoDisturbActionHandler$handle$1$1", f = "FlowNoDisturbActionHandler.kt", i = {0}, l = {44}, m = "invokeSuspend", n = {"isRemind"}, s = {"I$0"})
public final class FlowNoDisturbActionHandler$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ aeb.a $actionStatusListener;
    final /* synthetic */ UIFeedCard $data;
    final /* synthetic */ FeedActionEvent $event;
    final /* synthetic */ LarkFeedListViewModel $vm;
    int I$0;
    int label;
    final /* synthetic */ FlowNoDisturbActionHandler this$0;

    public FlowNoDisturbActionHandler$handle$1$1(UIFeedCard r1, LarkFeedListViewModel r2, aeb.a r3, FeedActionEvent r4, FlowNoDisturbActionHandler r5, Continuation<? super FlowNoDisturbActionHandler$handle$1$1> r6) {
        this.$data = r1;
        this.$vm = r2;
        this.$actionStatusListener = r3;
        this.$event = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowNoDisturbActionHandler$handle$1$1(this.$data, this.$vm, this.$actionStatusListener, this.$event, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r17);
        Object r4 = ((d) r17).a;
    L15:
        aeb.a r5 = this.$actionStatusListener;
        UIFeedCard r6 = this.$data;
        FeedActionEvent r7 = this.$event;
        int r8 = d.b;
        boolean r9 = r4 instanceof d.b;
        if ((!r9) == false) goto L22;
        r5.a(r6, FeedActionType.NO_DISTURB, FeedActionStatus.SUCCESS, r7);
        StringBuilder r10 = new StringBuilder("feed item no disturb success: ");
        r10.append(r6.getId());
        r10.append(", isRemind:");
        if (r3 == 0) goto L20;
        boolean r11 = true;
    L21:
        r10.append(r11);
        com.ss.android.lark.flow.feed.utils.b.d("FlowNoDisturbActionHandler", r10.toString());
        goto L22
    L20:
        r11 = false;
    L22:
        aeb.a r12 = this.$actionStatusListener;
        UIFeedCard r13 = this.$data;
        FeedActionEvent r14 = this.$event;
        FlowNoDisturbActionHandler r15 = this.this$0;
        Throwable r16 = null;
        if (r9 == false) goto L25;
        d.b r18 = (d.b) r4;
    L26:
        if (r18 == null) goto L28;
        Object r19 = ((d.b) r4).b();
    L30:
        if (r19 == null) goto L45;
        ViewFlowErrorBiz r110 = (ViewFlowError) r19;
        r12.a(r13, FeedActionType.NO_DISTURB, FeedActionStatus.ERROR, r14);
        StringBuilder r20 = new StringBuilder("feed item no disturb failure: ");
        r20.append(r13.getId());
        r20.append(", isRemind:");
        if (r3 == 0) goto L34;
        boolean r21 = true;
    L35:
        r20.append(r21);
        r20.append(", error:");
        r20.append(r110);
        com.ss.android.lark.flow.feed.utils.b.e("FlowNoDisturbActionHandler", r20.toString());
        int r22 = com.ss.android.lark.flow.feed.utils.a.a;
        Context r23 = r15.c.getHost().getContext();
        FeedCard.Type r24 = r13.getType();
        String r25 = r13.getId();
        if ((r110 instanceof ViewFlowErrorBiz) == false) goto L38;
        ViewFlowErrorBiz r111 = r110;
    L39:
        if (r111 == null) goto L43;
        com.bytedance.lark.lark_biz_feed_android.d r26 = r111.getInner();
        if (r26 == null) goto L43;
        Integer r27 = Boxing.boxInt(r26.a);
    L44:
        com.ss.android.lark.flow.feed.utils.a.a(r23, r24, r25, r27);
    L43:
        r27 = null;
        goto L44
    L38:
        r111 = null;
        goto L39
    L34:
        r21 = false;
    L45:
        aeb.a r28 = this.$actionStatusListener;
        UIFeedCard r29 = this.$data;
        FeedActionEvent r30 = this.$event;
        if (r9 == false) goto L48;
        d.b r31 = (d.b) r4;
    L49:
        if (r31 == null) goto L51;
        r16 = ((d.b) r4).a();
    L51:
        if (r16 == null) goto L58;
        r28.a(r29, FeedActionType.NO_DISTURB, FeedActionStatus.ERROR, r30);
        StringBuilder r32 = new StringBuilder("feed item no disturb exception: ");
        r32.append(r29.getId());
        r32.append(", isRemind:");
        if (r3 == 0) goto L55;
        boolean r33 = true;
    L56:
        r32.append(r33);
        r32.append(", error:");
        r32.append(r16.getMessage());
        com.ss.android.lark.flow.feed.utils.b.b("FlowNoDisturbActionHandler", r32.toString());
        goto L58
    L55:
        r33 = false;
    L58:
        return Unit.INSTANCE;
    L48:
        r31 = null;
        goto L49
    L28:
        r19 = null;
        goto L30
    L25:
        r18 = null;
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        boolean r34 = !this.$data.isRemind();
        LarkFeedListViewModel r35 = this.$vm;
        String r36 = this.$data.getId();
        if (r36 != null) goto L11;
        r36 = "";
    L11:
        FeedCardType.a r37 = FeedCardType.Companion;
        int r38 = this.$data.getType().getNumber();
        r37.getClass();
        b0 r39 = new b0(new j(r36, FeedCardType.a.a(r38)), r34);
        this.I$0 = r34 ? 1 : 0;
        this.label = 1;
        Object r40 = r35.action-vFDjHp0(r39, this);
        if (r40 != r1) goto L14;
        return r1;
    L14:
        r3 = r34 ? 1 : 0;
        r4 = r40;
        goto L15
    }
}
