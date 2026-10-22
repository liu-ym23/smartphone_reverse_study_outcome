package com.ss.android.lark.keyboard.biz.p000float.inject;

import com.bytedance.lark.pb.im.v1.CloseDoubaoSmartReplyRequest;
import com.bytedance.lark.pb.im.v1.CloseDoubaoSmartReplyResponse;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.keyboard.viewmodel.a;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.float.inject.FloatExpandPlugin$floatExpandActionHandler$1$closeFloatExpand$1", f = "FloatExpandPlugin.kt", i = {}, l = {506}, m = "invokeSuspend", n = {}, s = {})
public final class FloatExpandPlugin$floatExpandActionHandler$1$closeFloatExpand$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $replyMsgId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FloatExpandPlugin this$0;

    public FloatExpandPlugin$floatExpandActionHandler$1$closeFloatExpand$1(long r1, FloatExpandPlugin r3, Continuation<? super FloatExpandPlugin$floatExpandActionHandler$1$closeFloatExpand$1> r4) {
        this.$replyMsgId = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        FloatExpandPlugin$floatExpandActionHandler$1$closeFloatExpand$1 r0 = new FloatExpandPlugin$floatExpandActionHandler$1$closeFloatExpand$1(this.$replyMsgId, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl((b) r7);     // Catch: Throwable -> L15
    L17:
        long r2 = this.$replyMsgId;
        Throwable r3 = Result.exceptionOrNull-impl(r8);
        if (r3 == null) goto L20;
        Log.e("FloatExpandPlugin", "closeFloatExpand failed: replyMsgId=" + r2, r3);
    L20:
        long r4 = this.$replyMsgId;
        if (Result.isSuccess-impl(r8) == false) goto L27;
        b r9 = (b) r8;
        r9.getClass();
        if ((r9 instanceof b.b) == false) goto L25;
        Log.e("FloatExpandPlugin", "closeFloatExpand resp failed: replyMsgId=" + r4 + ", " + r9.a());
        goto L27
    L25:
        Log.i("FloatExpandPlugin", "closeFloatExpand success: replyMsgId=" + r4);
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        CloseDoubaoSmartReplyRequest r11 = new CloseDoubaoSmartReplyRequest.Builder().reply_lark_msg_id(Boxing.boxLong(this.$replyMsgId)).build();
        FloatExpandPlugin r5 = this.this$0;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        KeyboardModel r12 = (KeyboardModel) r5.b.getValue();     // Catch: Throwable -> L15
        a r13 = (a) b38.b.a.create(a.class);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L15
        RucketJob<CloseDoubaoSmartReplyResponse> r14 = r13.closeDoubaoSmartReply(r11);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r7 = r14.awaitGet(this);     // Catch: Throwable -> L15
        if (r7 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
