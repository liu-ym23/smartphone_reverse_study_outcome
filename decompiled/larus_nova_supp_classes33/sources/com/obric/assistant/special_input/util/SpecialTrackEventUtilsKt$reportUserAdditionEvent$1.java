package com.obric.assistant.special_input.util;

import com.larus.applog.api.IApplog;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.util.SpecialTrackEventUtilsKt$reportUserAdditionEvent$1", f = "SpecialTrackEventUtils.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class SpecialTrackEventUtilsKt$reportUserAdditionEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DMTaskState $relatedTask;
    final /* synthetic */ StateInfo $stateInfo;
    int label;

    public SpecialTrackEventUtilsKt$reportUserAdditionEvent$1(StateInfo r1, DMTaskState r2, Continuation<? super SpecialTrackEventUtilsKt$reportUserAdditionEvent$1> r3) {
        this.$stateInfo = r1;
        this.$relatedTask = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpecialTrackEventUtilsKt$reportUserAdditionEvent$1(this.$stateInfo, this.$relatedTask, r4);
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
        Map r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L29:
        Message r7 = (Message) r6;
    L31:
        if (r7 == null) goto L33;
        String r2 = r7.getMessageId();
    L34:
        StateInfo r4 = this.$stateInfo;
        if (r4 == null) goto L43;
        Map r5 = r4.getExt();
        if (r5 == null) goto L43;
        if (r7 == null) goto L41;
        Map r8 = r7.getExt();
        if (r8 == null) goto L41;
    L42:
        Map r9 = MapsKt.plus(r5, r8);
    L44:
        JSONObject r10 = SpecialTrackEventUtilsKt.a(r2, null, r9);
    L54:
        String r11 = r10.optString("instruction_id");
        String r12 = r10.optString("doubao_message_id");
        FLogger.a.i("SpecialTrackEventUtils", "reportUserAdditionEvent: instructionId=" + r11 + ", doubaoMessageId=" + r12 + ", params=" + r10);
        IApplog.a.reportEvent("obric_omni_user_addition_start", r10);
        return Unit.INSTANCE;
    L41:
        r8 = MapsKt.emptyMap();
    L43:
        r9 = null;
        goto L44
    L33:
        r2 = null;
        goto L34
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        StateInfo r13 = this.$stateInfo;
        if (r13 == null) goto L12;
        String r14 = r13.getRefMessageId();
        if (r14 == null) goto L12;
    L20:
        DMTaskState r15 = this.$relatedTask;
        if (r15 != null) goto L45;
        StateInfo r16 = this.$stateInfo;
        if (r16 == null) goto L30;
        String r17 = r16.getRefMessageId();
        if (r17 == null) goto L30;
        IChatRepoService r18 = RepoDispatcherDelegate.b.e();
        this.label = 1;
        r6 = r18.E1(r17, this);
        if (r6 != r0) goto L29;
        return r0;
    L30:
        r7 = null;
        goto L31
    L45:
        Map r19 = r15.getExtra();
        DMTaskInfo r20 = this.$relatedTask.getTaskInfo();
        if (r20 == null) goto L49;
        Map r21 = r20.getExt();
        if (r21 == null) goto L49;
    L50:
        Map r22 = MapsKt.plus(r19, r21);
        StateInfo r23 = this.$stateInfo;
        if (r23 == null) goto L53;
        r3 = r23.getExt();
    L53:
        r10 = SpecialTrackEventUtilsKt.a(r14, r22, r3);
    L49:
        r21 = MapsKt.emptyMap();
    L12:
        DMTaskState r24 = this.$relatedTask;
        if (r24 == null) goto L19;
        DMTaskInfo r25 = r24.getTaskInfo();
        if (r25 == null) goto L19;
        IMMessage r26 = r25.getMessage();
        if (r26 == null) goto L19;
        r14 = r26.getMessageId();
    L19:
        r14 = null;
        goto L20
    }
}
