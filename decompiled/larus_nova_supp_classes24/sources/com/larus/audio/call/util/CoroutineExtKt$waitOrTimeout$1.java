package com.larus.audio.call.util;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.util.CoroutineExtKt", f = "CoroutineExt.kt", i = {0}, l = {47, CommandStatus.DORA_NEXT_CALL_ADD_CHAT_EXTRA}, m = "waitOrTimeout", n = {"onError"}, s = {"L$0"})
final class CoroutineExtKt$waitOrTimeout$1<R> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public CoroutineExtKt$waitOrTimeout$1(Continuation<? super CoroutineExtKt$waitOrTimeout$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        int r9 = this.label | LKBaseResponseModel.DEFAULT_ERROR_CODE;
        this.label = r9;
        Lazy r1 = c.a;
        if ((r9 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L5;
        this.label = r9 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
        CoroutineExtKt$waitOrTimeout$1<R> r10 = this;
    L6:
        Object r0 = r10.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        ResultKt.throwOnFailure(r0);
    L28:
        return r0;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Function3 r4 = (Function3) r10.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L16
    L16:
        th = th;
    L24:
        CoroutineContext.Element r5 = r10.getContext().get(Job.Key);
        r10.L$0 = null;
        r10.label = 2;
        r0 = r4.invoke(th, r5, r10);
        if (r0 != r2) goto L28;
        return r2;
    L18:
        ResultKt.throwOnFailure(r0);
        CoroutineExtKt$waitOrTimeout$2 r6 = new CoroutineExtKt$waitOrTimeout$2(null, null);     // Catch: Throwable -> L22
        r10.L$0 = null;     // Catch: Throwable -> L22
        r10.label = 1;     // Catch: Throwable -> L22
        r0 = TimeoutKt.b(0, r6, r10);     // Catch: Throwable -> L22
        if (r0 != r2) goto L28;
        return r2;
    L22:
        th = th;
        r4 = null;
        goto L24
    L5:
        r10 = new CoroutineExtKt$waitOrTimeout$1(this);
        goto L6
    }
}
