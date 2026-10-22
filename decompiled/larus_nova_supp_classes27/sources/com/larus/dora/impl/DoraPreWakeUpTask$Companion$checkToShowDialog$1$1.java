package com.larus.dora.impl;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraUserManager;
import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraPreWakeUpTask$Companion$checkToShowDialog$1$1", f = "DoraPreWakeUpTask.kt", i = {}, l = {1249, 1252, 1253, 1256, 1257}, m = "invokeSuspend", n = {}, s = {})
public final class DoraPreWakeUpTask$Companion$checkToShowDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.DoraPreWakeUpTask$Companion$checkToShowDialog$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.DoraPreWakeUpTask$Companion$checkToShowDialog$1$1$1", f = "DoraPreWakeUpTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            t19.s r4 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            int r1 = com.larus.utils.j0.a;
            String r2 = com.larus.utils.j0.d(2131902575);
            r4.getClass();
            t19.s.p(r0, r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraPreWakeUpTask$Companion$checkToShowDialog$1$1(Continuation<? super DoraPreWakeUpTask$Companion$checkToShowDialog$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraPreWakeUpTask$Companion$checkToShowDialog$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L12;
        if (r1 != 5) goto L11;
        ResultKt.throwOnFailure(r10);
    L34:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
    L30:
        DoraUserManager r11 = DoraUserManager.a;
        this.label = 5;
        if (r11.c(this) != r0) goto L34;
        return r0;
    L13:
        ResultKt.throwOnFailure(r10);
    L27:
        this.label = 4;
        if (DelayKt.delay(1805000, this) != r0) goto L30;
        return r0;
    L14:
        ResultKt.throwOnFailure(r10);
    L24:
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(null);
        this.label = 3;
        if (BuildersKt.withContext(r12, r2, this) != r0) goto L27;
        return r0;
    L15:
        ResultKt.throwOnFailure(r10);
    L19:
        boolean r13 = ((Boolean) r10).booleanValue();
        d.d("DoraPreWakeUpTask", "updateMultiUserModeState result " + r13);
        if (r13 == false) goto L34;
        MutableSharedFlow r14 = DoraPreWakeUpTask.m;
        Boolean r3 = Boxing.boxBoolean(true);
        this.label = 2;
        if (r14.emit(r3, this) != r0) goto L24;
        return r0;
    L16:
        ResultKt.throwOnFailure(r10);
        DoraUserManager r15 = DoraUserManager.a;
        this.label = 1;
        r10 = r15.d(true, 1800, this);
        if (r10 != r0) goto L19;
        return r0;
    }
}
