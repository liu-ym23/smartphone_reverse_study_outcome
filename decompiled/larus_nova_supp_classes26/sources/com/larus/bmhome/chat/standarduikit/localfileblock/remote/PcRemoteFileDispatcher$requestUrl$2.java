package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileDispatcher$requestUrl$2", f = "PcRemoteFileDispatcher.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
public final class PcRemoteFileDispatcher$requestUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $commandId;
    final /* synthetic */ DispatchCommandPayload $payload;
    final /* synthetic */ g $request;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public static final class a implements IIMCallback<OmniDispatchCommandResponse> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ i<String> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ g d;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == false) goto L14;
            FLogger.a.e("PcRemoteFilePreview", "stage=url_request_failed command_id=" + this.c + " code=" + r4.getCode());
            i<String> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            if (r4.getCode() <= 0) goto L10;
            PcRemoteFileError r2 = PcRemoteFileError.SERVER_ERROR;
        L11:
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(new PcRemoteFileException(r2, Integer.valueOf(r4.getCode())))));
            return;
        L10:
            r2 = PcRemoteFileError.NETWORK_ERROR;
            goto L11
        }

        public final void onSuccess(Object r6) {
            OmniDispatchCommandResponse r7 = (OmniDispatchCommandResponse) r6;
            Intrinsics.checkNotNullParameter(r7, "result");
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == false) goto L15;
            PcRemoteFileDispatcher r2 = PcRemoteFileDispatcher.a;     // Catch: PcRemoteFileException -> L9
            String r8 = PcRemoteFileDispatcher.a(r7, this.c, this.d.c);     // Catch: PcRemoteFileException -> L9
            FLogger.a.i("PcRemoteFilePreview", "stage=url_received command_id=" + this.c);     // Catch: PcRemoteFileException -> L9
            this.b.resumeWith(Result.constructor-impl(r8));     // Catch: PcRemoteFileException -> L9
            return;
        L9:
            e = move-exception;
            FLogger.a.e("PcRemoteFilePreview", "stage=url_rejected command_id=" + this.c + " reason=" + e.getKind() + " code=" + e.getCode());
            i<String> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
            return;
        }

        public a(AtomicBoolean r1, j r2, String r3, g r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public PcRemoteFileDispatcher$requestUrl$2(g r1, DispatchCommandPayload r2, String r3, Continuation<? super PcRemoteFileDispatcher$requestUrl$2> r4) {
        this.$request = r1;
        this.$payload = r2;
        this.$commandId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PcRemoteFileDispatcher$requestUrl$2(this.$request, this.$payload, this.$commandId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$2;
        DispatchCommandPayload r3 = (DispatchCommandPayload) this.L$1;
        g r4 = (g) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        g r11 = this.$request;
        DispatchCommandPayload r5 = this.$payload;
        String r6 = this.$commandId;
        this.L$0 = r11;
        this.L$1 = r5;
        this.L$2 = r6;
        this.label = 1;
        j r7 = new j(IntrinsicsKt.intercepted(this), 1);
        r7.C();
        AtomicBoolean r8 = new AtomicBoolean(false);
        com.larus.im.d.b().sendDispatchCommand(new OmniDispatchCommandRequest(r11.a, r11.b, r5), new a(r8, r7, r6, r11));
        r10 = r7.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r10 != r0) goto L13;
        return r0;
    }
}
