package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.push.DraftResourceUploadPushHandler$onStart$1", f = "DraftResourceUploadPushHandler.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
final class DraftResourceUploadPushHandler$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ u this$0;

    public DraftResourceUploadPushHandler$onStart$1(u r1, Continuation<? super DraftResourceUploadPushHandler$onStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DraftResourceUploadPushHandler$onStart$1 r0 = new DraftResourceUploadPushHandler$onStart$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        u r6 = this.this$0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        int r2 = u.a;     // Catch: Throwable -> L17
        r6.getClass();     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L5:
        if (r0 != 1) goto L13;
        com.larksuite.rucket.job.extension.a r3 = (com.larksuite.rucket.job.extension.a) this.L$1;
        u r7 = (u) this.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L17
        if (((Boolean) r4).booleanValue() == true) goto L10;
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L23;
        Log.e("DraftResourceUploadPushHandler", "listen PUSH_UPLOAD_RESOURCE_STATUS failed", r9);
    L23:
        return Unit.INSTANCE;
    L10:
        com.larksuite.rucket.job.base.b r10 = r3.a();     // Catch: Throwable -> L17
        int r11 = u.a;     // Catch: Throwable -> L17
        r7.getClass();     // Catch: Throwable -> L17
        PushUploadResourceStatus r12 = (PushUploadResourceStatus) r10.b();     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
