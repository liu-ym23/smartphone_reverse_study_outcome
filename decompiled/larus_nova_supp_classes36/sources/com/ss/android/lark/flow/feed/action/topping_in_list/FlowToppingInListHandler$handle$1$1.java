package com.ss.android.lark.flow.feed.action.topping_in_list;

import android.content.Context;
import com.bytedance.lark.lark_biz_feed_android.FeedCardType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowErrorBiz;
import com.bytedance.lark.lark_biz_feed_android.c0;
import com.bytedance.lark.lark_biz_feed_android.j;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.bytedance.lark.view_flow_wrapper.d;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
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
@DebugMetadata(c = "com.ss.android.lark.flow.feed.action.topping_in_list.FlowToppingInListHandler$handle$1$1", f = "FlowToppingInListHandler.kt", i = {0}, l = {51}, m = "invokeSuspend", n = {"isTopping"}, s = {"I$0"})
public final class FlowToppingInListHandler$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ aeb.a $actionStatusListener;
    final /* synthetic */ UIFeedCard $data;
    final /* synthetic */ FeedActionEvent $event;
    final /* synthetic */ LarkFeedListViewModel $vm;
    int I$0;
    int label;
    final /* synthetic */ FlowToppingInListHandler this$0;

    public FlowToppingInListHandler$handle$1$1(UIFeedCard r1, LarkFeedListViewModel r2, aeb.a r3, FeedActionEvent r4, FlowToppingInListHandler r5, Continuation<? super FlowToppingInListHandler$handle$1$1> r6) {
        this.$data = r1;
        this.$vm = r2;
        this.$actionStatusListener = r3;
        this.$event = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowToppingInListHandler$handle$1$1(this.$data, this.$vm, this.$actionStatusListener, this.$event, this.this$0, r9);
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
        r5.a(r6, FeedActionType.TOPPING_IN_LIST, FeedActionStatus.SUCCESS, r7);
        StringBuilder r10 = new StringBuilder("feed item shortcut success: ");
        r10.append(r6.getId());
        r10.append(", isTopping:");
        if (r3 == 0) goto L20;
        boolean r11 = true;
    L21:
        r10.append(r11);
        com.ss.android.lark.flow.feed.utils.b.d("ToppingHandler", r10.toString());
        goto L22
    L20:
        r11 = false;
    L22:
        aeb.a r12 = this.$actionStatusListener;
        UIFeedCard r13 = this.$data;
        FeedActionEvent r14 = this.$event;
        FlowToppingInListHandler r15 = this.this$0;
        Throwable r16 = null;
        if (r9 == false) goto L25;
        d.b r18 = (d.b) r4;
    L26:
        if (r18 == null) goto L28;
        Object r19 = ((d.b) r4).b();
    L30:
        if (r19 == null) goto L45;
        ViewFlowErrorBiz r110 = (ViewFlowError) r19;
        r12.a(r13, FeedActionType.TOPPING_IN_LIST, FeedActionStatus.ERROR, r14);
        StringBuilder r20 = new StringBuilder("feed item shortcut failure: ");
        r20.append(r13.getId());
        r20.append(", isTopping:");
        if (r3 == 0) goto L34;
        boolean r21 = true;
    L35:
        r20.append(r21);
        r20.append(", error:");
        r20.append(r110);
        com.ss.android.lark.flow.feed.utils.b.e("ToppingHandler", r20.toString());
        int r22 = com.ss.android.lark.flow.feed.utils.a.a;
        int r23 = FlowToppingInListHandler.c;
        Context r24 = r15.a.getHost().getContext();
        FeedCard.Type r25 = r13.getType();
        String r26 = r13.getId();
        if ((r110 instanceof ViewFlowErrorBiz) == false) goto L38;
        ViewFlowErrorBiz r111 = r110;
    L39:
        if (r111 == null) goto L43;
        com.bytedance.lark.lark_biz_feed_android.d r27 = r111.getInner();
        if (r27 == null) goto L43;
        Integer r28 = Boxing.boxInt(r27.a);
    L44:
        com.ss.android.lark.flow.feed.utils.a.a(r24, r25, r26, r28);
    L43:
        r28 = null;
        goto L44
    L38:
        r111 = null;
        goto L39
    L34:
        r21 = false;
    L45:
        aeb.a r29 = this.$actionStatusListener;
        UIFeedCard r30 = this.$data;
        FeedActionEvent r31 = this.$event;
        if (r9 == false) goto L48;
        d.b r32 = (d.b) r4;
    L49:
        if (r32 == null) goto L51;
        r16 = ((d.b) r4).a();
    L51:
        if (r16 == null) goto L58;
        r29.a(r30, FeedActionType.TOPPING_IN_LIST, FeedActionStatus.ERROR, r31);
        StringBuilder r33 = new StringBuilder("feed item shortcut exception: ");
        r33.append(r30.getId());
        r33.append(", isTopping:");
        if (r3 == 0) goto L55;
        boolean r34 = true;
    L56:
        r33.append(r34);
        r33.append(", error:");
        r33.append(r16.getMessage());
        com.ss.android.lark.flow.feed.utils.b.b("ToppingHandler", r33.toString());
        goto L58
    L55:
        r34 = false;
    L58:
        return Unit.INSTANCE;
    L48:
        r32 = null;
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
        boolean r35 = !UIFeedCardExtraKt.isOnTop(this.$data);
        LarkFeedListViewModel r36 = this.$vm;
        String r37 = this.$data.getId();
        if (r37 != null) goto L11;
        r37 = "";
    L11:
        FeedCardType.a r38 = FeedCardType.Companion;
        int r39 = this.$data.getType().getNumber();
        r38.getClass();
        c0 r40 = new c0(new j(r37, FeedCardType.a.a(r39)), r35);
        this.I$0 = r35 ? 1 : 0;
        this.label = 1;
        Object r41 = r36.action-vFDjHp0(r40, this);
        if (r41 != r1) goto L14;
        return r1;
    L14:
        r3 = r35 ? 1 : 0;
        r4 = r41;
        goto L15
    }
}
