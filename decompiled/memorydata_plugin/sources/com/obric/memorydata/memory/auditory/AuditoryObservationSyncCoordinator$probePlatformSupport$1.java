package com.obric.memorydata.memory.auditory;

import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioError;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioSource;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.auditory.AuditoryObservationSyncCoordinator$probePlatformSupport$1", f = "AuditoryObservationSyncCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AuditoryObservationSyncCoordinator$probePlatformSupport$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10064a = null;

        static {
            int[] r0 = new int[AlwaysOnAudioError.values().length];
            r0[AlwaysOnAudioError.PERMISSION_DENIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AlwaysOnAudioError.PLATFORM_UNAVAILABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10064a = r0;
        }
    }

    AuditoryObservationSyncCoordinator$probePlatformSupport$1(Continuation<? super AuditoryObservationSyncCoordinator$probePlatformSupport$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new AuditoryObservationSyncCoordinator$probePlatformSupport$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AuditoryObservationSyncCoordinator$probePlatformSupport$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AuditoryObservationSyncCoordinator$probePlatformSupport$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r9);
        long r8 = System.currentTimeMillis() / 1000;
        AlwaysOnAudioError r10 = AlwaysOnAudioSource.INSTANCE.query(RangesKt.coerceAtLeast(r8 - 1, 0), r8).getError();     // Catch: RuntimeException -> L7 LinkageError -> L8 SecurityException -> L9
    L10:
        c r11 = c.f10069a;
        if (r10 != null) goto L13;
        int r12 = -1;
    L14:
        boolean r0 = true;
        if (r12 != 1) goto L17;
    L19:
        AuditoryPlatformSupport r13 = AuditoryPlatformSupport.UNSUPPORTED;
    L20:
        c.a(r13);
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("platform capability checked, supported=");
        if (c.e() == AuditoryPlatformSupport.SUPPORTED) goto L24;
        r0 = false;
    L24:
        StringBuilder r15 = r14.append(r0).append(", code=");
        if (r10 == null) goto L28;
        String r16 = r10.name();
        if (r16 == null) goto L28;
    L29:
        IRunLog.a.a(r1, "AuditorySync", r15.append(r16).toString(), false, 4, null);
        c.a(c.f10069a, "platform_capability_changed", false);
        return Unit.INSTANCE;
    L28:
        r16 = "NONE";
        goto L29
    L17:
        if (r12 == 2) goto L19;
        r13 = AuditoryPlatformSupport.SUPPORTED;
        goto L20
    L13:
        r12 = a.f10064a[r10.ordinal()];
        goto L14
    L8:
        r10 = AlwaysOnAudioError.PLATFORM_UNAVAILABLE;
    L9:
        r10 = AlwaysOnAudioError.PERMISSION_DENIED;
    L7:
        r10 = AlwaysOnAudioError.PLATFORM_CALL_FAILED;
        goto L10
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
