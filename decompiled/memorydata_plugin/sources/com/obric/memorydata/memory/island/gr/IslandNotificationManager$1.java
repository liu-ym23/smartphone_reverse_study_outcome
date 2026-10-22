package com.obric.memorydata.memory.island.gr;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandNotificationManager$1", f = "IslandNotificationManager.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
final class IslandNotificationManager$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.island.gr.IslandNotificationManager$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1<T> f10203a = null;

        static {
            f10203a = new AnonymousClass1();
        }

        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v13, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r8v22 */
        /* JADX WARN: Type inference failed for: r8v23 */
        /* JADX WARN: Type inference failed for: r8v24 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r8v5, types: [kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r8v7 */
        public final Object a(Function1<? super Continuation<? super Unit>, ? extends Object> r8, Continuation<? super Unit> r9) {
            ?? r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r11, IslandNotificationManager$1$1$emit$1.class) == false) goto L7;
            IslandNotificationManager$1$1$emit$1 r0 = (IslandNotificationManager$1$1$emit$1) ZeusTransformUtils.preCheckCast(r11, IslandNotificationManager$1$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L22;
            if (r2 == 1) goto L21;
            if (r2 != 2) goto L20;
            kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15 Exception -> L17
            r10 = r13;
        L34:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L15
            r10.b(null);
            return Unit.INSTANCE;
        L17:
            Exception e = e;
        L33:
            RunLog.INSTANCE.error("IslandNotifMgr", "Task error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
            r10 = r13;
            goto L34
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L21:
            kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
            Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$0, Function1.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.sync.a r16 = r15;
            ?? r17 = r3;
        L43:
            r0.L$0 = r16;     // Catch: Throwable -> L29 Exception -> L31
            r0.L$1 = null;     // Catch: Throwable -> L29 Exception -> L31
            r0.label = 2;     // Catch: Throwable -> L29 Exception -> L31
            if (r17.invoke(r0) != r12) goto L28;
            return r12;
        L28:
            r10 = r16;
            goto L34
        L31:
            e = move-exception;
            r13 = r16;
            e = e;
        L29:
            th = move-exception;
            r10 = r16;
            th = th;
        L37:
            r10.b(null);
            throw th;
        L22:
            ResultKt.throwOnFailure(r7);
            r16 = e.d();
            r0.L$0 = r10;
            r0.L$1 = r16;
            r0.label = 1;
            r17 = r10;
            if (r16.a(null, r0) != r12) goto L43;
            return r12;
        L15:
            th = th;
        L7:
            r0 = new IslandNotificationManager$1$1$emit$1(this, r11);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((Function1) ZeusTransformUtils.preCheckCast(r3, Function1.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    IslandNotificationManager$1(Continuation<? super IslandNotificationManager$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandNotificationManager$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandNotificationManager$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandNotificationManager$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ad r7 = e.c();
        j r2 = (j) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10203a, j.class, "com.obric.memorydata.plugin");
        Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r7.collect(r2, r3) != r0) goto L12;
        return r0;
    }
}
