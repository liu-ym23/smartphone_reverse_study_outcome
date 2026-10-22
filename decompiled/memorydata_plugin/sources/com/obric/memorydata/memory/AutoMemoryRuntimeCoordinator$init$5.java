package com.obric.memorydata.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.AutoMemoryRuntimeCoordinator$init$5", f = "AutoMemoryRuntimeCoordinator.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryRuntimeCoordinator$init$5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.AutoMemoryRuntimeCoordinator$init$5$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "<unused var>", "", "", "", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityUtil$AccessibilityState;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.AutoMemoryRuntimeCoordinator$init$5$1", f = "AutoMemoryRuntimeCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function6<Boolean, Set<? extends String>, com.obric.memorydata.screencapture.accessibility.c.a, Long, Boolean, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(6, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.jvm.functions.Function6
        public /* synthetic */ Object invoke(Boolean r11, Set<? extends String> r12, com.obric.memorydata.screencapture.accessibility.c.a r13, Long r14, Boolean r15, Continuation<? super Unit> r16) {
            return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Set) ZeusTransformUtils.preCheckCast(r12, Set.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.screencapture.accessibility.c.a) ZeusTransformUtils.preCheckCast(r13, com.obric.memorydata.screencapture.accessibility.c.a.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r16, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(boolean r1, Set<String> r2, com.obric.memorydata.screencapture.accessibility.c.a r3, long r4, boolean r6, Continuation<? super Unit> r7) {
            Set r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
            return new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    AutoMemoryRuntimeCoordinator$init$5(Continuation<? super AutoMemoryRuntimeCoordinator$init$5> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryRuntimeCoordinator$init$5((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AutoMemoryRuntimeCoordinator$init$5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryRuntimeCoordinator$init$5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        kotlinx.coroutines.flow.i r12 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().i(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.screencapture.accessibility.c.f12773a.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(b.d(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.inapprule.b.f10150a.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function6) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function6.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(AnonymousClass2.f10042a, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r12.collect(r2, r3) != r0) goto L12;
        return r0;
    }
}
