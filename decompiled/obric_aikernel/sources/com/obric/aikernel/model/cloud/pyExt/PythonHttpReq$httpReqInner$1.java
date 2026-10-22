package com.obric.aikernel.model.cloud.pyExt;

import com.obric.aikernel.middleware.api.log.AIKLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.pyExt.PythonHttpReq$httpReqInner$1", f = "PythonHttpReq.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PythonHttpReq$httpReqInner$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, File> $localFiles;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    PythonHttpReq$httpReqInner$1(Map<String, ? extends File> r10, Continuation<? super PythonHttpReq$httpReqInner$1> r11) {
        this.$localFiles = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PythonHttpReq$httpReqInner$1(this.$localFiles, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PythonHttpReq$httpReqInner$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        Iterator<Map.Entry<String, File>> r11 = this.$localFiles.entrySet().iterator();     // Catch: Exception -> L12
    L7:
        if (r11.hasNext() == false) goto L15;
        File r12 = r11.next().getValue();     // Catch: Exception -> L12
        if (r12 == null) goto L7;
        Boxing.boxBoolean(r12.delete());     // Catch: Exception -> L12
    L15:
        return Unit.INSTANCE;
    L12:
        e = move-exception;
        AIKLog.INSTANCE.e("PythonHttpReq", "delete file failed", e);
        goto L15
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
