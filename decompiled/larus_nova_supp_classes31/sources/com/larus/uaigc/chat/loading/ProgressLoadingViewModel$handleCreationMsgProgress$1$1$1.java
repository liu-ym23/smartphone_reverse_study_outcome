package com.larus.uaigc.chat.loading;

import com.larus.bmhome.creative.loading.ProgressLoadingUIState;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleCreationMsgProgress$1$1$1", f = "ProgressLoadingViewModel.kt", i = {}, l = {376, 386}, m = "invokeSuspend", n = {}, s = {})
public final class ProgressLoadingViewModel$handleCreationMsgProgress$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstTime;
    final /* synthetic */ Map.Entry<String, CreationTask> $it;
    final /* synthetic */ String $loadingTaskId;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ProgressLoadingViewModel this$0;

    public ProgressLoadingViewModel$handleCreationMsgProgress$1$1$1(boolean r1, ProgressLoadingViewModel r2, Message r3, String r4, Map.Entry<String, CreationTask> r5, Continuation<? super ProgressLoadingViewModel$handleCreationMsgProgress$1$1$1> r6) {
        this.$isFirstTime = r1;
        this.this$0 = r2;
        this.$msg = r3;
        this.$loadingTaskId = r4;
        this.$it = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ProgressLoadingViewModel$handleCreationMsgProgress$1$1$1(this.$isFirstTime, this.this$0, this.$msg, this.$loadingTaskId, this.$it, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        int r2 = 1;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r17);
    L42:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L15:
        Map r3 = (Map) r1;
    L17:
        boolean r4 = false;
        if (r3 == null) goto L24;
        ProgressLoadingUIState r5 = (ProgressLoadingUIState) r3.get(this.$loadingTaskId);
        if (r5 == null) goto L24;
        Integer r6 = r5.getProgress();
        if (r6 == null) goto L24;
        int r7 = r6.intValue();
    L25:
        FLogger.a.i("ProgressLoadingViewModel", "start loading task, loadingTaskId: " + this.$loadingTaskId + ", isFirstTime: " + this.$isFirstTime + ", initProgress: " + r7);
        CreationTask r8 = this.$it.getValue();
        if (r8 == null) goto L33;
        Integer r9 = r8.loadingAssetType;
        if (r9 == null) goto L33;
        if (r9.intValue() != 7) goto L33;
        r4 = true;
    L33:
        if (r4 == false) goto L35;
        r2 = 4;
    L35:
        ProgressLoadingViewModel r10 = this.this$0;
        String r11 = this.$msg.getLocalMessageId();
        if (r11 != null) goto L38;
        r11 = "";
    L38:
        String r12 = this.$msg.getReplyId();
        String r13 = this.$it.getKey();
        Integer r15 = Boxing.boxInt(r7);
        this.label = 2;
        if (ProgressLoadingViewModel.resetProgressAndStart$default(r10, r2, r11, r12, r13, r15, 300, 0.0d, this, 64, null) != r14) goto L42;
        return r14;
    L24:
        r7 = 0;
        goto L25
    L10:
        ResultKt.throwOnFailure(r17);
        if (this.$isFirstTime == false) goto L16;
        ProgressLoadingViewModel r16 = this.this$0;
        Message r18 = this.$msg;
        this.label = 1;
        r1 = ProgressLoadingViewModel.access$initProgressCacheAtFirstTime(r16, r18, this);
        if (r1 != r14) goto L15;
        return r14;
    L16:
        r3 = null;
        goto L17
    }
}
