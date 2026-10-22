package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.ai.applet.domain.AppletDomainPolicyManager;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.net.download.AppletDownloadFileManager$DownloadTask$validateDomain$1", f = "AppletDownloadFileManager.kt", i = {}, l = {775}, m = "invokeSuspend", n = {}, s = {})
final class AppletDownloadFileManager$DownloadTask$validateDomain$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a.b this$0;
    final /* synthetic */ a this$1;

    public AppletDownloadFileManager$DownloadTask$validateDomain$1(a.b r1, a r10, Continuation<? super AppletDownloadFileManager$DownloadTask$validateDomain$1> r11) {
        this.this$0 = r1;
        this.this$1 = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletDownloadFileManager$DownloadTask$validateDomain$1 r0 = new AppletDownloadFileManager$DownloadTask$validateDomain$1(this.this$0, this.this$1, r11);
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
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r11 = Result.constructor-impl((com.bytedance.ai.applet.domain.e) r10);     // Catch: Throwable -> L15
    L17:
        a.b r12 = this.this$0;
        a r13 = this.this$1;
        if (Result.isSuccess-impl(r11) == false) goto L23;
        com.bytedance.ai.applet.domain.e r14 = (com.bytedance.ai.applet.domain.e) r11;
        if (r14.a == false) goto L22;
        r12.d(a.d.n.a);
        goto L23
    L22:
        r12.d(new a.d.o(a.e(r13, r14.b)));
    L23:
        a.b r15 = this.this$0;
        a r16 = this.this$1;
        Throwable r17 = Result.exceptionOrNull-impl(r11);
        if (r17 == null) goto L27;
        r15.d(new a.d.o(a.e(r16, r17.getMessage())));
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        a.b r19 = this.this$0;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L15
        AppletDomainPolicyManager r21 = AppletDomainPolicyManager.a;     // Catch: Throwable -> L15
        String r22 = r19.b.a;     // Catch: Throwable -> L15
        String r23 = r19.f;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r10 = r21.c(r22, r23, this);     // Catch: Throwable -> L15
        if (r10 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
