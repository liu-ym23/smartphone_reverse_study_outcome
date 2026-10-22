package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$scheduleAutoCleanEligibilityCheck$1", f = "AppDiskManager.kt", i = {}, l = {676, 676, 676}, m = "invokeSuspend", n = {}, s = {})
public final class AppDiskManager$scheduleAutoCleanEligibilityCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.disk.impl.AppDiskManager$scheduleAutoCleanEligibilityCheck$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$scheduleAutoCleanEligibilityCheck$1$1", f = "AppDiskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (AppDiskManager.u == false) goto L8;
            AppDiskManager.a.getClass();
            AppDiskManager.M(true);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AppDiskManager$scheduleAutoCleanEligibilityCheck$1(Continuation<? super AppDiskManager$scheduleAutoCleanEligibilityCheck$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AppDiskManager$scheduleAutoCleanEligibilityCheck$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L7;
        ResultKt.throwOnFailure(r5);
    L28:
        return Unit.INSTANCE;
    L7:
        if (r1 != 3) goto L9;
        Throwable r2 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r5);
        throw r2;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Unit r3 = (Unit) this.L$0;
        ResultKt.throwOnFailure(r5);
        return r3;
    L13:
        ResultKt.throwOnFailure(r5);
    L29:
        th = move-exception;
        AppDiskManager.t.b(false);
        throw th;
    L15:
        if (com.larus.utils.q0.c(AppDiskManager.j) == true) goto L19;
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L29
        AppDiskManager.t.b(false);
        return r4;
    L19:
        AppDiskManager r6 = AppDiskManager.a;     // Catch: Throwable -> L29
        AppDiskManager.l(r6);     // Catch: Throwable -> L29
        AppDiskManager.e(r6);     // Catch: Throwable -> L29
        if (AppDiskManager.t.b(true) == false) goto L28;
        if (AppDiskManager.u == false) goto L28;
        MainCoroutineDispatcher r7 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r8 = new AnonymousClass1(null);
        this.label = 2;
        if (BuildersKt.withContext(r7, r8, this) != r0) goto L28;
        return r0;
    }
}
