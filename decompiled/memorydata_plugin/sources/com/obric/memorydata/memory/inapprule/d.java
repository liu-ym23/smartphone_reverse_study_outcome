package com.obric.memorydata.memory.inapprule;

import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.t;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.da;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/inapprule/InAppRuleSync;", "", "<init>", "()V", "PACKAGE", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "triggers", "Lkotlinx/coroutines/channels/Channel;", "", "requestSync", "synchronize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f10155b = null;
    private static final i<Unit> c = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/inapprule/InAppRuleSync$synchronize$request$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w<Boolean> f10156a;

        a(w<Boolean> r3) {
            this.f10156a = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "taskInfo");
            if (r2.c().isFinished() == false) goto L10;
            w<Boolean> r1 = this.f10156a;
            if (r2.c() != TaskInfo.State.SUCCEEDED) goto L7;
            boolean r3 = true;
        L8:
            r1.a(Boolean.valueOf(r3));
            return;
        L7:
            r3 = false;
            goto L8
        }
    }

    static {
        f10154a = new d();
        al r5 = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        f10155b = r5;
        c = l.a(-1, null, null, 6, null);
        kotlinx.coroutines.i.a(r5, null, null, (Function2) ZeusTransformUtils.preCheckCast(new InAppRuleSync$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Boolean> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, InAppRuleSync$synchronize$1.class) == false) goto L7;
        InAppRuleSync$synchronize$1 r0 = (InAppRuleSync$synchronize$1) ZeusTransformUtils.preCheckCast(r15, InAppRuleSync$synchronize$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        final boolean r3 = true;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        TaskRequest r17 = (TaskRequest) ZeusTransformUtils.preCheckCast(r0.L$1, TaskRequest.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
    L27:
        Boolean r18 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r18 == null) goto L30;
        boolean r19 = r18.booleanValue();     // Catch: Throwable -> L14
    L31:
        if (r19 == true) goto L33;
        r17.cancel();     // Catch: Throwable -> L14
    L33:
        if (r19 == false) goto L35;
        b.f10150a.c();     // Catch: Throwable -> L14
    L35:
        o r4 = (o) ZeusTransformUtils.preCheckCast(t.f11635a, o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r19 == true) goto L39;
        r3 = false;
    L39:
        o.a(r4, "InApp 规则同步完成", "rule_sync_completed", null, new $$Lambda$d$UAMfsE3enU8slDc5W0QeOf5TS0(r3), null, 20, null);     // Catch: Throwable -> L14
        c.f10152a.a(r1);
        return Boxing.boxBoolean(r19);
    L30:
        r19 = false;
    L14:
        Throwable th = th;
    L44:
        c.f10152a.a(r1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        if (com.obric.aiagent.product.a.a.b() == false) goto L21;
        String r110 = c.f10152a.a();
        w r5 = y.a(null, 1, null);
        TaskRequest.Builder r6 = new TaskRequest.Builder("in_app_scene");
        JSONObject r7 = new JSONObject().put("runId", r110).put("schemaVersion", 1);
        Intrinsics.checkNotNullExpressionValue(r7, "put(...)");
        TaskRequest r8 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r6.setInputParam(r7), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new a(r5), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        r8.enqueue();     // Catch: Throwable -> L42
        Function2 r9 = (Function2) ZeusTransformUtils.preCheckCast(new InAppRuleSync$synchronize$success$1(r5, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        r0.L$0 = r110;     // Catch: Throwable -> L42
        r0.L$1 = r8;     // Catch: Throwable -> L42
        r0.label = 1;     // Catch: Throwable -> L42
        Object r10 = da.b(120000, r9, r0);     // Catch: Throwable -> L42
        if (r10 != r16) goto L26;
        return r16;
    L26:
        r17 = r8;
        r1 = r110;
        r13 = r10;
    L42:
        th = move-exception;
        r1 = r110;
        th = th;
        goto L44
    L21:
        return Boxing.boxBoolean(true);
    L7:
        r0 = new InAppRuleSync$synchronize$1(this, r15);
        goto L8
    }

    private static final Unit a(boolean r1, g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a("success", Boolean.valueOf(r1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ i b() {
        return c;
    }

    /* JADX INFO: renamed from: lambda$UAMfsE3e-nU8slDc5W0QeOf5TS0, reason: not valid java name */
    public static /* synthetic */ Unit m703lambda$UAMfsE3enU8slDc5W0QeOf5TS0(boolean r0, g r1) {
        return a(r0, r1);
    }

    public final void a() {
        c.f10152a.b();
        c.mo54trySendJP2dKIU(Unit.INSTANCE);
    }
}
