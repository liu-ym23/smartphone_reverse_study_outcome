package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.retrofit2.Call;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.net.download.AppletDownloadFileManager$DownloadTask$startTransport$1", f = "AppletDownloadFileManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletDownloadFileManager$DownloadTask$startTransport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a.b this$0;
    final /* synthetic */ a this$1;

    public AppletDownloadFileManager$DownloadTask$startTransport$1(a.b r1, a r10, Continuation<? super AppletDownloadFileManager$DownloadTask$startTransport$1> r11) {
        this.this$0 = r1;
        this.this$1 = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletDownloadFileManager$DownloadTask$startTransport$1 r0 = new AppletDownloadFileManager$DownloadTask$startTransport$1(this.this$0, this.this$1, r11);
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
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        a r0 = this.this$1;
        a.b r12 = this.this$0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r13 = Result.constructor-impl(a.b(r0, r12.f, r12.g, r12.h, r12.j));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r13) == false) goto L12;
        r13 = null;
    L12:
        Call r14 = (Call) r13;
        if (r14 != null) goto L15;
        this.this$0.d(new a.d.l(new a.e("downloadFile:fail create download task failed", null, null), null));
    L17:
        return Unit.INSTANCE;
    L15:
        this.this$0.d(new a.d.m(r14));
    L7:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
