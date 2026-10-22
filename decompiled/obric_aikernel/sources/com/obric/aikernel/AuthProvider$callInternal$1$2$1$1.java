package com.obric.aikernel;

import android.os.ParcelFileDescriptor;
import com.bytedance.crash.anr.AnrManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.AuthProvider$callInternal$1$2$1$1", f = "AuthProvider.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AuthProvider$callInternal$1$2$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<ParcelFileDescriptor> $fds;
    private /* synthetic */ Object L$0;
    int label;

    AuthProvider$callInternal$1$2$1$1(ArrayList<ParcelFileDescriptor> r10, Continuation<? super AuthProvider$callInternal$1$2$1$1> r11) {
        this.$fds = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AuthProvider$callInternal$1$2$1$1 r12 = new AuthProvider$callInternal$1$2$1$1(this.$fds, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AuthProvider$callInternal$1$2$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        l0 r13 = (l0) this.L$0;
        ResultKt.throwOnFailure(r10);
    L11:
        Iterator<T> r14 = this.$fds.iterator();
    L13:
        if (r14.hasNext() == false) goto L20;
        ParcelFileDescriptor r15 = (ParcelFileDescriptor) r14.next();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L17
        r15.close();     // Catch: Throwable -> L17
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L13
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.L$0 = (l0) this.L$0;
        this.label = 1;
        if (DelayKt.b(AnrManager.ANR_MIN_INTERVAL, this) != r11) goto L11;
        return r11;
    }
}
