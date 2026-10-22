package com.larus.voice_setting.voice;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader", f = "UgcVoiceLoader.kt", i = {}, l = {1001}, m = "saveUserVoice", n = {}, s = {})
final class UgcVoiceLoader$saveUserVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcVoiceLoader this$0;

    public UgcVoiceLoader$saveUserVoice$1(UgcVoiceLoader r1, Continuation<? super UgcVoiceLoader$saveUserVoice$1> r2) {
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
        UgcVoiceLoader$saveUserVoice$1 r0 = this;
    L6:
        Object r8 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 != 0) goto L9;
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("UgcVoiceLoader", "[saveUserVoice] info:null, voiceId:null, botId:null, language:null");
        JSONObject r9 = new JSONObject();
        r9.put("voice_id", NameKeys.UnloadStrategy_No_Strategy);
        r9.put("bot_id", NameKeys.UnloadStrategy_No_Strategy);
        throw null;
    L9:
        if (r2 != 1) goto L19;
        ResultKt.throwOnFailure(r8);
        final com.larus.network.http.a r10 = (com.larus.network.http.a) r8;
        if ((r10 instanceof com.larus.network.http.f) == false) goto L14;
        f2a.c r3 = com.larus.voice_setting.voice.utils.k.a.a("Request CallBack Fail");
        r3.e(new d2(r10));
        r3.c.b = CollectionsKt.listOf("VoiceChange");
        f2a.c.c(r3, null, 15);
    L17:
        return r10;
    L14:
        if ((r10 instanceof com.larus.network.http.y) == false) goto L16;
        f2a.c r4 = com.larus.voice_setting.voice.utils.k.a.b("Request CallBack Success");
        r4.c.b = CollectionsKt.listOf("VoiceChange");
        f2a.c.c(r4, null, 15);
        goto L17
    L16:
        f2a.c r5 = com.larus.voice_setting.voice.utils.k.a.b("Request CallBack Else");
        r5.c.b = CollectionsKt.listOf("VoiceChange");
        f2a.c.c(r5, null, 15);
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new UgcVoiceLoader$saveUserVoice$1(r7, this);
        goto L6
    }
}
