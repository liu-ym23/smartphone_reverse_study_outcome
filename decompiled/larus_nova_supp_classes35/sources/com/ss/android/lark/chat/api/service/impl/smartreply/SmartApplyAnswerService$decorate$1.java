package com.ss.android.lark.chat.api.service.impl.smartreply;

import com.bytedance.lark.pb.im.v1.GetSmartAIReplyRequest;
import com.bytedance.lark.pb.im.v1.GetSmartAIReplyResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.api.service.impl.smartreply.SmartApplyAnswerService$decorate$1", f = "SmartApplyAnswerService.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"messageId"}, s = {"J$0"})
public final class SmartApplyAnswerService$decorate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    long J$0;
    int label;
    final /* synthetic */ SmartApplyAnswerService this$0;

    public SmartApplyAnswerService$decorate$1(Message r1, SmartApplyAnswerService r2, Continuation<? super SmartApplyAnswerService$decorate$1> r3) {
        this.$message = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SmartApplyAnswerService$decorate$1(this.$message, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r6);
    L14:
        b r7 = (b) r6;
        r7.getClass();
        boolean r3 = r7 instanceof b.b;
        if ((!r3) == false) goto L17;
        Log.i("SmartApplyAnswerCache", "fetch message smartReply success " + r2);
    L25:
        return Unit.INSTANCE;
    L17:
        if (r3 == false) goto L25;
        StringBuilder r4 = new StringBuilder("fetch message smartReply failed ");
        r4.append(r2);
        r4.append(' ');
        ErrorResult r8 = r7.a();
        if (r8 == null) goto L22;
        String r9 = r8.getDisplayMsg();
        if (r9 == null) goto L22;
    L23:
        r4.append(r9);
        Log.e("SmartApplyAnswerCache", r4.toString());
    L22:
        r9 = "nil";
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Long r10 = StringsKt.toLongOrNull(this.$message.getId());
        if (r10 == null) goto L27;
        long r5 = r10.longValue();
        GetSmartAIReplyRequest r11 = new GetSmartAIReplyRequest.Builder().message_ids(CollectionsKt.listOf(Boxing.boxLong(r5))).build();
        SmartApplyAnswerService.b r12 = (SmartApplyAnswerService.b) this.this$0.c.getValue();
        Intrinsics.checkNotNull(r11);
        RucketJob<GetSmartAIReplyResponse> r13 = r12.getSmartAIReply(r11);
        this.J$0 = r5;
        this.label = 1;
        r6 = r13.awaitGet(this);
        if (r6 != r0) goto L13;
        return r0;
    L13:
        r2 = r5;
        goto L14
    L27:
        return Unit.INSTANCE;
    }
}
