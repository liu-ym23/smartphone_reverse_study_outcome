package com.obric.aikernel.init.tasks.cleanup;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.utils.f;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class CleanUpInitTask extends d {

    /* JADX INFO: renamed from: com.obric.aikernel.init.tasks.cleanup.CleanUpInitTask$run$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.init.tasks.cleanup.CleanUpInitTask$run$1", f = "CleanUpInitTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r10);
            File r11 = new File(AppContext.INSTANCE.getContext().getCacheDir(), "uploads");     // Catch: Exception -> L7
            f.f5592a.a(r11);     // Catch: Exception -> L7
        L10:
            return Unit.INSTANCE;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CleanUpInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(null), 3, null);
    }
}
