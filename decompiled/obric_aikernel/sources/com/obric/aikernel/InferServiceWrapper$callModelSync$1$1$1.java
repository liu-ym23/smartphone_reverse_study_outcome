package com.obric.aikernel;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
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
@DebugMetadata(c = "com.obric.aikernel.InferServiceWrapper$callModelSync$1$1$1", f = "InferServiceWrapper.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class InferServiceWrapper$callModelSync$1$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ AssetFileDescriptor $fd;
    final /* synthetic */ String $uri;
    int label;

    InferServiceWrapper$callModelSync$1$1$1(AssetFileDescriptor r10, String r11, Bundle r12, Continuation<? super InferServiceWrapper$callModelSync$1$1$1> r13) {
        this.$fd = r10;
        this.$uri = r11;
        this.$args = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InferServiceWrapper$callModelSync$1$1$1(this.$fd, this.$uri, this.$args, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InferServiceWrapper$callModelSync$1$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        AIKLog.INSTANCE.v("InferServiceWrapper", "release fd " + this.$fd + ' ' + this.$fd.getLength() + " to " + this.$uri);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIKLog.INSTANCE.v("InferServiceWrapper", "start hold fd " + this.$fd + ' ' + this.$fd.getLength() + " to " + this.$uri);
        long r13 = this.$args.getLong(IdlKeys.Args_Timeout, 3600000);
        this.label = 1;
        if (DelayKt.b(r13, this) != r11) goto L11;
        return r11;
    }
}
