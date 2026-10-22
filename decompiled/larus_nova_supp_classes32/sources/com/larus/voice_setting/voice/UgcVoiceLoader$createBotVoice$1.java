package com.larus.voice_setting.voice;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader", f = "UgcVoiceLoader.kt", i = {}, l = {1049}, m = "createBotVoice", n = {}, s = {})
final class UgcVoiceLoader$createBotVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcVoiceLoader this$0;

    public UgcVoiceLoader$createBotVoice$1(UgcVoiceLoader r1, Continuation<? super UgcVoiceLoader$createBotVoice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= Integer.MIN_VALUE;
        UgcVoiceLoader r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        UgcVoiceLoader$createBotVoice$1 r0 = this;
    L6:
        Object r8 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 != 0) goto L9;
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("UgcVoiceLoader", "[createBotVoice] info:null, language:null");
        new JSONObject();
        throw null;
    L9:
        if (r2 != 1) goto L18;
        ResultKt.throwOnFailure(r8);
        com.larus.network.http.y r9 = (com.larus.network.http.a) r8;
        if ((r9 instanceof com.larus.network.http.y) == false) goto L14;
        return ((com.larus.network.http.a) r9).b;
    L14:
        if ((r9 instanceof com.larus.network.http.f) == false) goto L22;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[createBotVoice] fail, error=");
        com.larus.network.http.f r10 = (com.larus.network.http.f) r9;
        r4.append(r10.d);
        r3.e("UgcVoiceLoader", r4.toString(), r10.d);
        return null;
    L22:
        return null;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new UgcVoiceLoader$createBotVoice$1(r7, this);
        goto L6
    }
}
