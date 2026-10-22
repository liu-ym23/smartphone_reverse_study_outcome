package com.obric.memorydata.init.tasks;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.u;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/init/tasks/PreloadPackageTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "checkPackageModelReady", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PreloadPackageTask extends NativeTask {
    public static final a Companion = null;
    private static boolean HAS_REGISTERED = false;
    public static final String NAME = "PreloadPackageTask";
    private static final String TAG = "PreloadPackageTask";
    private static final f abilityParams = null;
    private static final Set<String> preloadPackageSets = null;
    private static final b receiver = null;

    @Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/init/tasks/PreloadPackageTask$Companion;", "", "<init>", "()V", "TAG", "", "NAME", "preloadPackageSets", "", "HAS_REGISTERED", "", "receiver", "com/obric/memorydata/init/tasks/PreloadPackageTask$Companion$receiver$1", "Lcom/obric/memorydata/init/tasks/PreloadPackageTask$Companion$receiver$1;", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/PreloadPackageTask$Companion$receiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {
        b() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r5) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "data");
            RunLog.INSTANCE.debug("PreloadPackageTask", "onDataReceive isWifiData: " + ZeusTransformUtils.instanceOf(r4, u.class));
            if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L8;
            RunLog.INSTANCE.debug("PreloadPackageTask", "onDataReceive : " + ((u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.memorydata.plugin")).a());
            if (((u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.memorydata.plugin")).a() != 3) goto L9;
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("PreloadPackageTask").setDelay((g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.f(3), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
            return;
        L9:
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.init.tasks.PreloadPackageTask$checkPackageModelReady$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.init.tasks.PreloadPackageTask$checkPackageModelReady$1", f = "PreloadPackageTask.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$0, Iterator.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r12);
        L10:
            if (r2.hasNext() == false) goto L14;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.aikernelcore.h r4 = com.obric.memorydata.aikernelcore.h.f8481a;
            this.L$0 = r2;
            this.label = 1;
            if (com.obric.memorydata.aikernelcore.h.a(r4, r5, false, null, this, 4, null) != r0) goto L10;
            return r0;
        L14:
            new com.obric.memorydata.ability.d().b(PreloadPackageTask.access$getAbilityParams$cp(), (k) ZeusTransformUtils.preCheckCast(PreloadPackageTask.access$getReceiver$cp(), k.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            r2 = ((Iterable) ZeusTransformUtils.preCheckCast(PreloadPackageTask.access$getPreloadPackageSets$cp(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            goto L10
        }
    }

    static {
        Companion = new a(null);
        preloadPackageSets = SetsKt.setOf(new String[]{"auto_memory_build", "active_memory_build"});
        receiver = new b();
        abilityParams = new f(100000002, MapsKt.mapOf(TuplesKt.to("action", 3)));
    }

    public PreloadPackageTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    public static final /* synthetic */ f access$getAbilityParams$cp() {
        return abilityParams;
    }

    public static final /* synthetic */ Set access$getPreloadPackageSets$cp() {
        return preloadPackageSets;
    }

    public static final /* synthetic */ b access$getReceiver$cp() {
        return receiver;
    }

    private final void checkPackageModelReady() {
        RunLog.INSTANCE.debug("PreloadPackageTask", "checkPackageModelReady");
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        checkPackageModelReady();
    L7:
        if (HAS_REGISTERED == true) goto L10;
        new com.obric.memorydata.ability.d().a(abilityParams, (k) ZeusTransformUtils.preCheckCast(receiver, k.class, "com.obric.memorydata.plugin"));
        HAS_REGISTERED = true;
    L10:
        return new TaskResult(0, null, null, null, 14, null);
    L5:
        RunLog.INSTANCE.debug("PreloadPackageTask", "checkPackageModelReady isNetworkAvailable not available");
        goto L7
    }
}
