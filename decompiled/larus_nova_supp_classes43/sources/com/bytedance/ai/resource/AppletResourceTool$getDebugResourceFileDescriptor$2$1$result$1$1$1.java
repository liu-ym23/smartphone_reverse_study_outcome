package com.bytedance.ai.resource;

import android.os.ParcelFileDescriptor;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1", f = "AppletResourceTool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ ParcelFileDescriptor $capturedWriteEnd;
    private /* synthetic */ Object L$0;
    int label;

    public AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1(ParcelFileDescriptor r1, byte[] r10, Continuation<? super AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1> r11) {
        this.$capturedWriteEnd = r1;
        this.$bytes = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1 r0 = new AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1(this.$capturedWriteEnd, this.$bytes, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ParcelFileDescriptor r12 = this.$capturedWriteEnd;
        byte[] r0 = this.$bytes;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        PolarisFileOutputStreamWrapper r13 = new PolarisFileOutputStreamWrapper(r12.getFileDescriptor());     // Catch: Throwable -> L15
        r13.write(r0);     // Catch: Throwable -> L10
        r13.flush();     // Catch: Throwable -> L10
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L15
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L34;
        com.bytedance.ai.utils.g.a.e("AppletResourceLoader", "getDebugResourceFileDescriptor: pipe write failed: " + r16.getMessage());
    L34:
        this.$capturedWriteEnd.close();     // Catch: Throwable -> L23
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        return Unit.INSTANCE;
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
