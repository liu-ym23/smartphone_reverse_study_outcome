package com.larus.voice_setting.voice;

import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$requestUgcVoiceAuthorized$1", f = "UgcVoiceLoader.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {})
final class UgcVoiceLoader$requestUgcVoiceAuthorized$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public UgcVoiceLoader$requestUgcVoiceAuthorized$1(Continuation<? super UgcVoiceLoader$requestUgcVoiceAuthorized$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new UgcVoiceLoader$requestUgcVoiceAuthorized$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        com.larus.network.http.f r15 = (com.larus.network.http.a) r14;
        if ((r15 instanceof com.larus.network.http.f) == false) goto L15;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("requestUgcVoiceAuthorized fail, error=");
        com.larus.network.http.f r16 = r15;
        r3.append(r16.d);
        r2.e("UgcVoiceLoader", r3.toString(), r16.d);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        this.label = 1;
        r14 = HttpExtKt.k("Social", Object.class, "/alice/user_voice/authorize", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}
