package com.larus.uaigc.chat.loading;

import com.larus.bmhome.creative.loading.ProgressLoadingUIState;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$1", f = "ProgressLoadingViewModel.kt", i = {}, l = {318, 328, 338}, m = "invokeSuspend", n = {}, s = {})
public final class ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstTime;
    final /* synthetic */ CreationItem $it;
    final /* synthetic */ String $loadingTaskId;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ProgressLoadingViewModel this$0;

    public ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$1(boolean r1, ProgressLoadingViewModel r2, Message r3, String r4, CreationItem r5, Continuation<? super ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$1> r6) {
        this.$isFirstTime = r1;
        this.this$0 = r2;
        this.$msg = r3;
        this.$loadingTaskId = r4;
        this.$it = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$1(this.$isFirstTime, this.this$0, this.$msg, this.$loadingTaskId, this.$it, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        Integer r4 = null;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r16);
    L53:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L17:
        Map r2 = (Map) r1;
    L19:
        if (r2 == null) goto L23;
        ProgressLoadingUIState r3 = (ProgressLoadingUIState) r2.get(this.$loadingTaskId);
        if (r3 == null) goto L23;
        Integer r5 = r3.getProgress();
    L24:
        ConcurrentHashMap r6 = com.larus.canvas.service.b.a;
        String r7 = this.$it.id;
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        Intrinsics.checkNotNullParameter(r7, "taskId");
        String r8 = (String) com.larus.canvas.service.b.b.get(r7);
        if (r8 != null) goto L30;
        Float r9 = null;
    L31:
        if (r5 == null) goto L33;
        int r10 = r5.intValue();
    L38:
        FLogger.a.i("ProgressLoadingViewModel", "start loading task, loadingTaskId: " + this.$loadingTaskId + ", isFirstTime: " + this.$isFirstTime + ", initProgress: " + r10);
        if (r9 == null) goto L46;
        ProgressLoadingViewModel r11 = this.this$0;
        String r12 = this.$msg.getLocalMessageId();
        if (r12 != null) goto L43;
        r12 = "";
    L43:
        String r13 = this.$msg.getReplyId();
        String r15 = this.$it.id;
        Integer r17 = Boxing.boxInt(r10);
        this.label = 2;
        if (ProgressLoadingViewModel.access$resetProgressAndStart(r11, 1, r12, r13, r15, r17, 0, 3.0d, this) != r14) goto L53;
        return r14;
    L46:
        ProgressLoadingViewModel r18 = this.this$0;
        String r19 = this.$msg.getLocalMessageId();
        if (r19 != null) goto L49;
        r19 = "";
    L49:
        String r20 = this.$msg.getReplyId();
        String r21 = this.$it.id;
        Integer r22 = Boxing.boxInt(r10);
        this.label = 3;
        if (ProgressLoadingViewModel.resetProgressAndStart$default(r18, 1, r19, r20, r21, r22, 300, 0.0d, this, 64, null) != r14) goto L53;
        return r14;
    L33:
        if (r9 == null) goto L35;
        r4 = Boxing.boxInt((int) r9.floatValue());
    L35:
        if (r4 == null) goto L37;
        r10 = r4.intValue();
        goto L38
    L37:
        r10 = 0;
        goto L38
    L30:
        r9 = (Float) com.larus.canvas.service.b.a.get(r8);
    L23:
        r5 = null;
        goto L24
    L12:
        ResultKt.throwOnFailure(r16);
        if (this.$isFirstTime == false) goto L18;
        ProgressLoadingViewModel r23 = this.this$0;
        Message r24 = this.$msg;
        this.label = 1;
        r1 = ProgressLoadingViewModel.access$initProgressCacheAtFirstTime(r23, r24, this);
        if (r1 != r14) goto L17;
        return r14;
    L18:
        r2 = null;
        goto L19
    }
}
