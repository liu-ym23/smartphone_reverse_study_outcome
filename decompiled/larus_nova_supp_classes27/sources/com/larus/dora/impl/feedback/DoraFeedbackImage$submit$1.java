package com.larus.dora.impl.feedback;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImage$submit$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {714, 722, 723}, m = "invokeSuspend", n = {}, s = {})
final class DoraFeedbackImage$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public DoraFeedbackImage$submit$1(g r1, Continuation<? super DoraFeedbackImage$submit$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraFeedbackImage$submit$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L11;
        if (r1 != 3) goto L10;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L50
    L43:
        if (this.this$0.g.length() == 0) goto L46;
        r4 = false;
    L46:
        if (r4 == true) goto L53;
    L47:
        this.this$0.d.setValue(ImageState.READY);     // Catch: Exception -> L50
        i r7 = this.this$0.c.a.getImageSubmitCallback();     // Catch: Exception -> L50
        if (r7 == null) goto L63;
        r7.e(this.this$0.b);     // Catch: Exception -> L50
    L63:
        String r8 = this.this$0.i;
        if (r8 == null) goto L67;
        new PolarisFileWrapper(r8).delete();
    L67:
        return Unit.INSTANCE;
    L53:
        throw new IllegalStateException("Upload failed: Empty server token");     // Catch: Exception -> L50
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L50
    L39:
        g r9 = this.this$0;     // Catch: Exception -> L50
        this.label = 3;     // Catch: Exception -> L50
        if (g.b(r9, this) != r0) goto L43;
        return r0;
    L13:
        g r2 = (g) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L50
    L26:
        r2.i = (String) r6;     // Catch: Exception -> L50
        this.this$0.d.setValue(ImageState.COMPRESS_DONE);     // Catch: Exception -> L50
        i r10 = this.this$0.c.a.getImageSubmitCallback();     // Catch: Exception -> L50
        if (r10 == null) goto L30;
        r10.d(this.this$0.b);     // Catch: Exception -> L50
    L30:
        if (this.this$0.d.getValue() != ImageState.COMPRESS_DONE) goto L32;
    L33:
        this.this$0.d.setValue(ImageState.ON_UPLOAD);     // Catch: Exception -> L50
        g r11 = this.this$0;     // Catch: Exception -> L50
        this.L$0 = null;     // Catch: Exception -> L50
        this.label = 2;     // Catch: Exception -> L50
        Object r12 = r11.c.a.requestToken(this);     // Catch: Exception -> L50
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        r12 = Unit.INSTANCE;     // Catch: Exception -> L50
    L37:
        if (r12 != r0) goto L39;
        return r0;
    L32:
        if (this.this$0.d.getValue() != ImageState.FAILED) goto L47;
    L16:
        ResultKt.throwOnFailure(r6);
        if (this.this$0.d.getValue() != ImageState.IDLE) goto L20;
    L21:
        this.this$0.d.setValue(ImageState.ON_COMPRESS);     // Catch: Exception -> L50
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L55;
        r2 = this.this$0;     // Catch: Exception -> L50
        this.L$0 = r2;     // Catch: Exception -> L50
        this.label = 1;     // Catch: Exception -> L50
        r6 = g.c(r2, this);     // Catch: Exception -> L50
        if (r6 != r0) goto L26;
        return r0;
    L55:
        throw new IOException("Network not available");     // Catch: Exception -> L50
    L20:
        if (this.this$0.d.getValue() != ImageState.FAILED) goto L30;
    L50:
        e = move-exception;
        this.this$0.d.setValue(ImageState.FAILED);
        if ((e instanceof CancellationException) == false) goto L59;
        pk4.j.d("DoraGFeedbackViewModel", "Image processing cancelled for image [" + this.this$0.a + ']');
        goto L63
    L59:
        i r3 = this.this$0.c.a.getImageSubmitCallback();
        if (r3 == null) goto L62;
        r3.a(this.this$0.b);
    L62:
        pk4.j.c("DoraGFeedbackViewModel", "Image processing failed at state " + this.this$0.d.getValue(), e);
        goto L63
    }
}
