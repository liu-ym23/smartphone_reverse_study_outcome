package com.ss.android.lark.feed.molten.page;

import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.u;
import com.bytedance.lark.view_flow_wrapper.d;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$pauseDataChange$1$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
public final class FeedSidebarItemsMoltenViewModel$pauseDataChange$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

    public FeedSidebarItemsMoltenViewModel$pauseDataChange$1$1(FeedSidebarItemsMoltenViewModel r1, Continuation<? super FeedSidebarItemsMoltenViewModel$pauseDataChange$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FeedSidebarItemsMoltenViewModel$pauseDataChange$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((d) r7).a;
    L11:
        int r2 = d.b;
        boolean r3 = r8 instanceof d.b;
        if ((!r3) == false) goto L14;
        geb.c.c("FeedSidebarItemsMoltenViewModel", "LarkFeedListActionPauseDataChangeNotify success");
    L14:
        Throwable r4 = null;
        if (r3 == false) goto L17;
        d.b r5 = (d.b) r8;
    L18:
        if (r5 == null) goto L20;
        Object r6 = ((d.b) r8).b();
    L21:
        if (r6 == null) goto L23;
        geb.c.d("FeedSidebarItemsMoltenViewModel", "LarkFeedListActionPauseDataChangeNotify failure :" + ((ViewFlowError) r6).getMessage());
    L23:
        if (r3 == false) goto L25;
        d.b r9 = (d.b) r8;
    L26:
        if (r9 == null) goto L28;
        r4 = ((d.b) r8).a();
    L28:
        if (r4 == null) goto L31;
        geb.c.a("FeedSidebarItemsMoltenViewModel", "LarkFeedListActionPauseDataChangeNotify exception :" + r4.getMessage());
    L31:
        return Unit.INSTANCE;
    L25:
        r9 = null;
        goto L26
    L20:
        r6 = null;
        goto L21
    L17:
        r5 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FeedSidebarItemsMoltenViewModel r10 = this.this$0;
        u r11 = u.a;
        this.label = 1;
        r8 = r10.action-vFDjHp0(r11, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
