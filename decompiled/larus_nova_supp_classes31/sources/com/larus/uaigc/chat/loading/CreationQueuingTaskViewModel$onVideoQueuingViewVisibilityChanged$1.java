package com.larus.uaigc.chat.loading;

import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import dp8.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1", f = "CreationQueuingTaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $taskId;
    final /* synthetic */ boolean $visible;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationQueuingTaskViewModel this$0;

    public CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1(Message r1, String r2, boolean r3, CreationQueuingTaskViewModel r4, Continuation<? super CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1> r5) {
        this.$msg = r1;
        this.$taskId = r2;
        this.$visible = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1 r6 = new CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1(this.$msg, this.$taskId, this.$visible, this.this$0, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        Message r0 = this.$msg;
        if (r0 != null) goto L9;
        return Unit.INSTANCE;
    L9:
        if (this.$taskId == null) goto L11;
        String r8 = DataConverterKt.a(r0.getLocalMessageId(), this.$taskId);
        CreationMsgContentData r1 = e.c(this.$msg);
        if (r1 == null) goto L19;
        CreationInfo r2 = r1.creationInfo;
        if (r2 == null) goto L19;
        Map r3 = r2.taskInfo;
        if (r3 == null) goto L19;
        CreationTask r5 = (CreationTask) r3.get(this.$taskId);
    L20:
        boolean r4 = this.$visible;
        CreationQueuingTaskViewModel r6 = this.this$0;
        Message r7 = this.$msg;
        monitor-enter(r14);
        if (r4 == false) goto L45;
        if (r5 == null) goto L31;
        Integer r9 = r5.status;     // Catch: Throwable -> L52
        if (r9 == null) goto L31;
        if (r9.intValue() != 3) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == false) goto L41;
        Integer r11 = r5.loadingAssetType;     // Catch: Throwable -> L52
        if (r11 == null) goto L41;
        if (r11.intValue() != 7) goto L41;
        if (r6.b.get(r8) != null) goto L49;
        r6.b.put(r8, BuildersKt.launch$default(r14, null, null, new CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1$1$1(r6, r7, r5, r8, null), 3, null));     // Catch: Throwable -> L52
    L49:
        monitor-exit(r14);
        return Unit.INSTANCE;
    L41:
        Job r12 = r6.b.get(r8);     // Catch: Throwable -> L52
        if (r12 == null) goto L44;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);     // Catch: Throwable -> L52
    L44:
        r6.b.remove(r8);     // Catch: Throwable -> L52
        StateFlowImpl r15 = r6.c;     // Catch: Throwable -> L52
        CreationQueuingTaskUIState r16 = (CreationQueuingTaskUIState) r6.d.getValue();     // Catch: Throwable -> L52
        Map r17 = MapsKt.toMutableMap(r16.taskQueuingUIStateMap);     // Catch: Throwable -> L52
        r17.remove(r8);     // Catch: Throwable -> L52
        r15.setValue(r16.copy(r17));     // Catch: Throwable -> L52
    L31:
        r10 = false;
        goto L32
    L45:
        Job r18 = r6.b.get(r8);     // Catch: Throwable -> L52
        if (r18 == null) goto L48;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);     // Catch: Throwable -> L52
    L48:
        r6.b.remove(r8);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    L19:
        r5 = null;
        goto L20
    L11:
        return Unit.INSTANCE;
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
