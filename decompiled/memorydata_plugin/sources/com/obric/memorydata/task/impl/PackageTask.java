package com.obric.memorydata.task.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.game.GameCrash;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv;
import com.obric.memorydata.aikernelcore.WebSocketManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.model.BaseResponse;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.task.AbsTask;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlinx.coroutines.al;
import kotlinx.coroutines.da;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/task/impl/PackageTask;", "Lcom/obric/memorydata/task/AbsTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "recordRuntime", "", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "runPackageTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildNextTask", "", "Lcom/obric/memorydata/task/impl/TaskRequest;", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "handleError", "code", "", "error", "", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PackageTask extends AbsTask {
    public static final Companion Companion = null;
    private static final long DEFAULT_PAPAYA_INIT_TIMEOUT = 20000;
    public static final String ERROR_TYPING_NOT_FOUND = "ModuleNotFoundError: No module named 'typing'";
    private static final String KEY_PACKAGE_ERROR_COUNT_PREFIX = "key_package_error_count_";
    public static final String TAG = "PackageTask";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/task/impl/PackageTask$Companion;", "", "<init>", "()V", "TAG", "", "ERROR_TYPING_NOT_FOUND", "KEY_PACKAGE_ERROR_COUNT_PREFIX", "DEFAULT_PAPAYA_INIT_TIMEOUT", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class a implements Function1<Bundle, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PackageTask f12924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<TaskResult> f12925b;

        a(PackageTask r3, Continuation<? super TaskResult> r4) {
            Continuation<TaskResult> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f12924a = r3;
            this.f12925b = r5;
        }

        public final void a(Bundle r13) {
            Intrinsics.checkNotNullParameter(r13, "ret");
            boolean r1 = false;
            int r0 = r13.getInt(IdlKeys.ErrorCode, 0);
            String r2 = r13.getString(IdlKeys.ErrorInfo, "");
            String r14 = r13.getString("task_result");
            if (r14 != null) goto L5;
            r14 = "{}";
        L5:
            JSONObject r3 = new JSONObject(r14);
            if (r0 != 0) goto L8;
            r1 = true;
        L8:
            TaskResult r15 = new TaskResult(-1, null, null, null, 14, null);
            if (r1 == true) goto L11;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PackageTask.TAG, "run package " + this.f12924a.getTaskParameter().getName() + " success failed, " + r0 + ':' + r2, null, 4, null);
            com.obric.memorydata.aikernelcore.h.f8481a.e(this.f12924a.getTaskParameter().getName());
            PackageTask.access$handleError(this.f12924a, r0, r2);
            r15.setCode(r0);
            Intrinsics.checkNotNull(r2);
            r15.setMsg(r2);
        L17:
            Continuation<TaskResult> r12 = this.f12925b;
            Result.Companion r4 = Result.Companion;
            r12.resumeWith(Result.m1421constructorimpl(r15));
            return;
        L11:
            r15.setCode(y.a(r3, "code"));
            r15.setMsg(y.b(r3, NotificationCompat.CATEGORY_MESSAGE));
            Object r5 = r3.opt("data");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PackageTask.TAG, "run package " + this.f12924a.getTaskParameter().getName() + " finished, code = " + r15.getCode() + ", msg = " + r15.getMsg(), false, 4, null);
            if (r5 != null) goto L14;
        L16:
            r15.setNextTaskRequestList(PackageTask.access$buildNextTask(this.f12924a, r3));
            goto L17
        L14:
            if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L16;
            r15.setOutput((JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin"));
            RunLog.INSTANCE.debugLocalTest(PackageTask.TAG, "run package " + this.f12924a.getTaskParameter().getName() + " success, output", r5);
            goto L16
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Bundle r3) {
            a((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.task.impl.PackageTask$handleError$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.task.impl.PackageTask$handleError$1", f = "PackageTask.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $error;
        int label;
        final /* synthetic */ PackageTask this$0;

        AnonymousClass1(PackageTask r3, String r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$error = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$error, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
            GameCrash.reportError("算法包 " + this.this$0.getTaskParameter().getName() + " 异常", r7, this.$error + '\n' + r7);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MemoryScriptEngineEnv r8 = MemoryScriptEngineEnv.INSTANCE;
            String r2 = this.this$0.getTaskParameter().getName();
            Continuation<? super String> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r6 = r8.getPackageConfigDesc(r2, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.task.impl.PackageTask$run$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.task.impl.PackageTask$run$1", f = "PackageTask.kt", i = {}, l = {69, 89, 94, 123}, m = "invokeSuspend", n = {}, s = {})
    static final class C12291 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<TaskResult> $taskResult;
        Object L$0;
        int label;
        final /* synthetic */ PackageTask this$0;

        C12291(PackageTask r3, Ref.ObjectRef<TaskResult> r4, Continuation<? super C12291> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$taskResult = r4;
            super(2, r6);
        }

        private static final Unit invokeSuspend$lambda$1(PackageTask r3, boolean r4) {
            RunLog.INSTANCE.debug(PackageTask.TAG, "package " + r3.getTaskParameter().getName() + " all models load success " + r4);
            if (r4 == false) goto L8;
            if (r3.isTaskInvalid() == true) goto L8;
            new TaskRequest(r3.getTaskParameter()).enqueue();
        L8:
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$OxVRmvOSOPIrfLANvoBKnF-wsOI, reason: not valid java name */
        public static /* synthetic */ Unit m1192lambda$OxVRmvOSOPIrfLANvoBKnFwsOI(PackageTask r0, boolean r1) {
            return invokeSuspend$lambda$1(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12291(this.this$0, this.$taskResult, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12291) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12291.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r26) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L13;
            if (r2 == 1) goto L12;
            if (r2 == 2) goto L11;
            if (r2 == 3) goto L11;
            if (r2 != 4) goto L10;
            Ref.ObjectRef<TaskResult> r0 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r26);
            Ref.ObjectRef<TaskResult> r3 = r0;
            T r4 = r26;
        L45:
            r3.element = r4;
        L20:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r26);
            Object r5 = r26;
        L29:
            BaseResponse r6 = (BaseResponse) ZeusTransformUtils.preCheckCast(r5, BaseResponse.class, "com.obric.memorydata.plugin");
            ((TaskResult) ZeusTransformUtils.preCheckCast(this.$taskResult.element, TaskResult.class, "com.obric.memorydata.plugin")).setCode(r6.getCode());
            ((TaskResult) ZeusTransformUtils.preCheckCast(this.$taskResult.element, TaskResult.class, "com.obric.memorydata.plugin")).setMsg(r6.getMsg());
            if (this.this$0.isTaskInvalid() == false) goto L37;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PackageTask.TAG, "package task stops because state is invalid " + com.obric.memorydata.task.utils.d.a(this.this$0.getTaskRequest()), false, 4, null);
            goto L20
        L37:
            if (((TaskResult) ZeusTransformUtils.preCheckCast(this.$taskResult.element, TaskResult.class, "com.obric.memorydata.plugin")).getCode() != 0) goto L39;
            boolean r7 = true;
        L40:
            if (r7 == true) goto L42;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PackageTask.TAG, "check package ready failed " + com.obric.memorydata.task.utils.d.a(this.this$0.getTaskRequest()) + ", msg=" + ((TaskResult) ZeusTransformUtils.preCheckCast(this.$taskResult.element, TaskResult.class, "com.obric.memorydata.plugin")).getMsg() + ", code=" + ((TaskResult) ZeusTransformUtils.preCheckCast(this.$taskResult.element, TaskResult.class, "com.obric.memorydata.plugin")).getCode(), null, 4, null);
            goto L20
        L42:
            r3 = this.$taskResult;
            PackageTask r8 = this.this$0;
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r3;
            this.label = 4;
            Object r10 = PackageTask.access$runPackageTask(r8, r9);
            r4 = r10;
            if (r10 != r1) goto L45;
            return r1;
        L39:
            r7 = false;
            goto L40
        L12:
            ResultKt.throwOnFailure(r26);
            Object r11 = r26;
        L17:
            if (Intrinsics.areEqual((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin"), Boxing.boxBoolean(true)) == true) goto L21;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PackageTask.TAG, "papaya init timeout " + com.obric.memorydata.task.utils.d.a(this.this$0.getTaskRequest()), null, 4, null);
            ((TaskResult) ZeusTransformUtils.preCheckCast(this.$taskResult.element, TaskResult.class, "com.obric.memorydata.plugin")).setCode(3);
            ((TaskResult) ZeusTransformUtils.preCheckCast(this.$taskResult.element, TaskResult.class, "com.obric.memorydata.plugin")).setMsg("papaya init timeout");
            goto L20
        L21:
            com.obric.memorydata.task.scheduler.c r12 = this.this$0.getTaskParameter().getOnTaskInfoCallBack();
            if (r12 == null) goto L24;
            UUID r13 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(r13, "randomUUID(...)");
            JSONObject r14 = new JSONObject();
            r14.put("task_execute", System.currentTimeMillis());
            Unit r15 = Unit.INSTANCE;
            r12.a(new TaskInfo(r13, "queryAndDownloadStart", null, r14, null, false, 0, 0, 0, 0, 1012, null));
        L24:
            boolean r16 = this.this$0.getTaskParameter().getExecuteImmediately();
            com.obric.memorydata.aikernelcore.h r17 = com.obric.memorydata.aikernelcore.h.f8481a;
            if (r16 == false) goto L30;
            String r18 = this.this$0.getTaskParameter().getName();
            Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            r5 = com.obric.memorydata.aikernelcore.h.a(r17, r18, false, null, r19, 6, null);
            if (r5 != r1) goto L29;
            return r1;
        L30:
            String r20 = this.this$0.getTaskParameter().getName();
            final PackageTask r21 = this.this$0;
            Function1 r110 = new $$Lambda$PackageTask$run$1$OxVRmvOSOPIrfLANvoBKnFwsOI(r21);
            Continuation r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 3;
            r5 = com.obric.memorydata.aikernelcore.h.a(r17, r20, false, r110, r111, 2, null);
            if (r5 != r1) goto L29;
            return r1;
        L13:
            ResultKt.throwOnFailure(r26);
            Function2 r22 = (Function2) ZeusTransformUtils.preCheckCast(new PackageTask$run$1$papayaInitResult$1(null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r112 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r11 = da.b(20000, r22, r112);
            if (r11 != r1) goto L17;
            return r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PackageTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    public static final /* synthetic */ List access$buildNextTask(PackageTask r0, JSONObject r1) {
        return r0.buildNextTask(r1);
    }

    public static final /* synthetic */ void access$handleError(PackageTask r0, int r1, String r2) {
        r0.handleError(r1, r2);
    }

    public static final /* synthetic */ Object access$runPackageTask(PackageTask r2, Continuation r3) {
        return r2.runPackageTask((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final List<TaskRequest> buildNextTask(JSONObject r6) {
        ArrayList r5 = new ArrayList();
        JSONArray r7 = r6.optJSONArray("next_task_requests");
        if (r7 == null) goto L5;
        int r1 = 0;
        int r2 = r7.length();
    L7:
        if (r1 >= r2) goto L5;
        JSONObject r3 = r7.getJSONObject(r1);
        TaskRequest.a r4 = TaskRequest.Companion;
        Intrinsics.checkNotNull(r3);
        r5.add(r4.a(r3));
        r1 = r1 + 1;
    L5:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    }

    private final void handleError(int r9, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        WebSocketManager.a(WebSocketManager.f8445a, 6, "service-" + getTaskParameter().getName() + "@1", r10, null, null, 24, null);
        if (new Regex(".+ download models for .+ failed.+").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        if (com.obric.memorydata.utils.g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "download model failed without wifi " + com.obric.memorydata.task.utils.d.a(getTaskRequest()), false, 4, null);
        return;
    L11:
        if (r9 != 500) goto L14;
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    }

    private final void recordRuntime() {
        if (Intrinsics.areEqual(getTaskParameter().getInputParams().optString("trigger_source"), CommonConsts.TIMER_TYPE) == false) goto L6;
        RunLog.INSTANCE.debug(TAG, "papaya " + getTaskParameter().getName() + " triggered by timer");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "papaya_last_runtime", 0, 2, null).save(getTaskParameter().getName(), System.currentTimeMillis());
        return;
    }

    private final Object runPackageTask(Continuation<? super TaskResult> r23) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r2 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "begin PapayaManager.runTask " + com.obric.memorydata.task.utils.d.a(getTaskRequest()), false, 4, null);
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(getTaskParameter().getForegroundCallerPkg(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == true) goto L12;
        getTaskParameter().getInputParams().put(IdlKeys.Args_SourcePackageName, getTaskParameter().getForegroundCallerPkg());
        getTaskParameter().getInputParams().put(IdlKeys.Args_Priority, 1);
    L13:
        getTaskParameter().getInputParams().put("task_id", getTaskParameter().getUuid().toString());
        com.obric.memorydata.task.scheduler.c r6 = getTaskParameter().getOnTaskInfoCallBack();
        if (r6 == null) goto L16;
        UUID r7 = getTaskParameter().getUuid();
        JSONObject r10 = new JSONObject();
        r10.put("task_execute", System.currentTimeMillis());
        Unit r8 = Unit.INSTANCE;
        r6.a(new TaskInfo(r7, "queryAndDownloadFinish", null, r10, null, false, 0, 0, 0, 0, 1012, null));
    L16:
        com.obric.memorydata.aikernelcore.h.f8481a.a(getTaskParameter().getName(), getTaskParameter().getInputParams(), (Function1) ZeusTransformUtils.preCheckCast(new a(this, r3), Function1.class, "com.obric.memorydata.plugin"));
        Object r1 = r2.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L19:
        return r1;
    L12:
        getTaskParameter().getInputParams().put(IdlKeys.Args_SourcePackageName, AppContext.INSTANCE.getPackageName());
        getTaskParameter().getInputParams().put(IdlKeys.Args_Priority, 0);
        goto L13
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [T, com.obric.memorydata.task.impl.TaskResult] */
    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = new TaskResult(-1, null, null, null, 14, null);
        if (isCancelled() == false) goto L7;
        ((TaskResult) ZeusTransformUtils.preCheckCast(r0.element, TaskResult.class, "com.obric.memorydata.plugin")).setCode(2);
    L6:
        return (TaskResult) ZeusTransformUtils.preCheckCast(r0.element, TaskResult.class, "com.obric.memorydata.plugin");
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "package task start " + com.obric.memorydata.task.utils.d.a(getTaskRequest()), false, 4, null);
        com.obric.memorydata.aikernelcore.h.f8481a.b(getTaskParameter().getName());
        PersonalContextAPI.INSTANCE.onPackageTaskStart(getTaskParameter().getName());
        recordRuntime();
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C12291(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        com.obric.memorydata.aikernelcore.h.f8481a.c(getTaskParameter().getName());
        PersonalContextAPI.INSTANCE.onPackageTaskFinish(getTaskParameter().getName());
        goto L6
    }
}
