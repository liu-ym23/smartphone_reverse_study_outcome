package com.bytedance.ai.core.manager;

import android.content.Context;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.utils.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/AppletRuntime;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager$runAppletWorker$2$2", f = "WorkerRuntimeManager.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
public final class WorkerRuntimeManager$runAppletWorker$2$2 extends SuspendLambda implements Function1<Continuation<? super AppletRuntime>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ Context $application;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $replyFor;
    final /* synthetic */ Ref.ObjectRef<AppletRuntime> $runtime;
    final /* synthetic */ SessionType $sessionType;
    final /* synthetic */ Map<String, Object> $traceInfo;
    Object L$0;
    int label;
    final /* synthetic */ WorkerRuntimeManager this$0;

    public WorkerRuntimeManager$runAppletWorker$2$2(String r1, Ref.ObjectRef<AppletRuntime> r10, WorkerRuntimeManager r11, Context r12, String r13, String r14, String r15, String r16, SessionType r17, Map<String, Object> r18, Continuation<? super WorkerRuntimeManager$runAppletWorker$2$2> r19) {
        this.$appletId = r1;
        this.$runtime = r10;
        this.this$0 = r11;
        this.$application = r12;
        this.$conversationId = r13;
        this.$botId = r14;
        this.$msgId = r15;
        this.$replyFor = r16;
        this.$sessionType = r17;
        this.$traceInfo = r18;
        super(1, r19);
    }

    public final Continuation<Unit> create(Continuation<?> r14) {
        return new WorkerRuntimeManager$runAppletWorker$2$2(this.$appletId, this.$runtime, this.this$0, this.$application, this.$conversationId, this.$botId, this.$msgId, this.$replyFor, this.$sessionType, this.$traceInfo, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super AppletRuntime> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef<AppletRuntime> r10 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r14);
    L12:
        r10.element = r14;
        return this.$runtime.element;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        g.a.i("WorkerRuntimeManager", "runApplet " + this.$appletId + " Inner");
        Ref.ObjectRef<AppletRuntime> r15 = this.$runtime;
        WorkerRuntimeManager r11 = this.this$0;
        String r12 = this.$appletId;
        Context r13 = this.$application;
        String r16 = this.$conversationId;
        String r17 = this.$botId;
        String r18 = this.$msgId;
        String r19 = this.$replyFor;
        SessionType r110 = this.$sessionType;
        Map<String, Object> r111 = this.$traceInfo;
        this.L$0 = r15;
        this.label = 1;
        Object r20 = WorkerRuntimeManager.a(r11, r12, r13, r16, r17, r18, r19, r110, r111, this);
        if (r20 != r0) goto L11;
        return r0;
    L11:
        r10 = r15;
        r14 = r20;
        goto L12
    }
}
