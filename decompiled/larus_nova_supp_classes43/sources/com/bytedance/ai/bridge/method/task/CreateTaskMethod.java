package com.bytedance.ai.bridge.method.task;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.doubao.task.AbsCreateTaskMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import p4.j;
import p4.k;
import p4.l;
import p4.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/task/CreateTaskMethod;", "Lcom/bytedance/ai/bridge/doubao/task/AbsCreateTaskMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/task/AbsCreateTaskMethodIDL$CreateTaskRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/doubao/task/AbsCreateTaskMethodIDL$CreateTaskResponseModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateTaskMethod extends AbsCreateTaskMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.task.CreateTaskMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.task.CreateTaskMethod$handle$1", f = "CreateTaskMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appKey;
        final /* synthetic */ h<AbsCreateTaskMethodIDL.b> $callback;
        final /* synthetic */ AbsCreateTaskMethodIDL.a $params;
        int label;

        public AnonymousClass1(String r1, AbsCreateTaskMethodIDL.a r10, h<AbsCreateTaskMethodIDL.b> r11, Continuation<? super AnonymousClass1> r12) {
            this.$appKey = r1;
            this.$params = r10;
            this.$callback = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appKey, this.$params, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L46;
            ResultKt.throwOnFailure(r10);
            k r11 = new k(this.$appKey, this.$params.getOutTaskId(), this.$params.getTaskTemplate(), this.$params.getTaskDetail());
            UserAuthService r0 = UserAuthService.a;
            Intrinsics.checkNotNullParameter(r11, "request");
            Integer r12 = null;
            SsResponse r13 = UserAuthService.d.createRemoteTask(r11).execute();     // Catch: Exception -> L15
            if (r13.isSuccessful() == true) goto L8;
        L13:
            g.a.e("UserAuthService", "createRemoteTask: Http Error, code = " + r13.code());     // Catch: Exception -> L15
        L47:
        L17:
            l r14 = null;
        L19:
            if (r14 != null) goto L22;
            g r15 = g.a;
            StringBuilder r16 = new StringBuilder("call failed, errNo=");
            f3.a r1 = f3.a.f;
            r16.append(r1.a);
            r16.append(", msg=failed to create remote task");
            r15.e("AISDK_JSB_CreateTaskMethod", r16.toString());
            h.a.a(this.$callback, "failed to create remote task", r1, null, 10);
            return Unit.INSTANCE;
        L22:
            j r17 = r14.e();
            if (r17 != null) goto L26;
            g r18 = g.a;
            StringBuilder r19 = new StringBuilder("call failed, errNo=");
            f3.a r20 = f3.a.m;
            r19.append(r20.a);
            r19.append(", msg=task data is empty");
            r18.e("AISDK_JSB_CreateTaskMethod", r19.toString());
            h.a.a(this.$callback, "task data is empty", r20, null, 10);
            return Unit.INSTANCE;
        L26:
            String r21 = r17.b();
            if (r21 != null) goto L29;
        L32:
            boolean r22 = true;
        L33:
            if (r22 == false) goto L36;
            g r23 = g.a;
            StringBuilder r24 = new StringBuilder("call failed, errNo=");
            f3.a r25 = f3.a.m;
            r24.append(r25.a);
            r24.append(", msg=taskId is empty");
            r23.e("AISDK_JSB_CreateTaskMethod", r24.toString());
            h.a.a(this.$callback, "taskId is empty", r25, null, 10);
            return Unit.INSTANCE;
        L36:
            g.a.i("AISDK_JSB_CreateTaskMethod", "call success");
            h<AbsCreateTaskMethodIDL.b> r26 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsCreateTaskMethodIDL.b.class, "<this>");
            BaseModel r27 = c.a(AbsCreateTaskMethodIDL.b.class);
            AbsCreateTaskMethodIDL.b r28 = (AbsCreateTaskMethodIDL.b) r27;
            r28.setTaskId(r21);
            r r29 = r17.a();
            if (r29 == null) goto L39;
            String r30 = r29.b();
        L40:
            r28.setToken(r30);
            r r31 = r17.a();
            if (r31 == null) goto L43;
            r12 = r31.a();
        L43:
            r28.setExpiresIn(r12);
            h.a.b(r26, (ResultModel) r27);
            return Unit.INSTANCE;
        L39:
            r30 = null;
            goto L40
        L29:
            if (r21.length() == 0) goto L32;
            r22 = false;
            goto L33
        L8:
            if (r13.body() == null) goto L13;
            r14 = (l) r13.body();     // Catch: Exception -> L15
            if (r14.d() == true) goto L19;
            g.a.e("UserAuthService", "createRemoteTask: Server Error: " + r14);     // Catch: Exception -> L15
        L15:
            e = move-exception;
            g.a.e("UserAuthService", "createRemoteTask ERROR: " + e.getMessage(), e);
            goto L17
        L46:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public CreateTaskMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r11, ParamModel r12, h r13) {
        AbsCreateTaskMethodIDL.a r14 = (AbsCreateTaskMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, taskType=");
        r1.append(r14.getTaskType());
        r1.append(", appletId=");
        a0 r10 = r11.getContainerContext();
        if (r10 == null) goto L5;
        String r15 = r10.getAppletId();
    L6:
        r1.append(r15);
        r0.i("AISDK_JSB_CreateTaskMethod", r1.toString());
        if (r14.getTaskType() == AbsCreateTaskMethodIDL.TaskType.REMOTE) goto L9;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.h;
        r16.append(r17.a);
        r16.append(", msg=createTask only supports remote task");
        r0.e("AISDK_JSB_CreateTaskMethod", r16.toString());
        h.a.a(r13, "createTask only supports remote task", r17, null, 10);
        return;
    L9:
        a0 r18 = r11.getContainerContext();
        if (r18 == null) goto L12;
        String r19 = r18.getAppletId();
    L13:
        if (r19 != null) goto L15;
    L18:
        boolean r20 = true;
    L19:
        if (r20 == false) goto L21;
        StringBuilder r110 = new StringBuilder("call failed, errNo=");
        f3.a r111 = f3.a.f;
        r110.append(r111.a);
        r110.append(", msg=appletId is empty");
        r0.e("AISDK_JSB_CreateTaskMethod", r110.toString());
        h.a.a(r13, "appletId is empty", r111, null, 10);
        return;
    L21:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r19, r14, r13, null), 3, null);
        return;
    L15:
        if (r19.length() == 0) goto L18;
        r20 = false;
        goto L19
    L12:
        r19 = null;
        goto L13
    L5:
        r15 = null;
        goto L6
    }
}
