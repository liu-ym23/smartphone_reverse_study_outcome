package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$requestEditVoiceName$1", f = "UgcVoiceLoader.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
final class UgcVoiceLoader$requestEditVoiceName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isVoiceUploadSuccess;
    final /* synthetic */ SpeakerVoice $voice;
    final /* synthetic */ String $voiceName;
    int label;

    public UgcVoiceLoader$requestEditVoiceName$1(SpeakerVoice r1, boolean r2, String r3, Continuation<? super UgcVoiceLoader$requestEditVoiceName$1> r4) {
        this.$voice = r1;
        this.$isVoiceUploadSuccess = r2;
        this.$voiceName = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UgcVoiceLoader$requestEditVoiceName$1(this.$voice, this.$isVoiceUploadSuccess, this.$voiceName, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r49) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r49);
        Object r1 = r49;
    L19:
        com.larus.network.http.f r2 = (com.larus.network.http.a) r1;
        boolean r3 = r2 instanceof com.larus.network.http.y;
        if (r3 == false) goto L23;
        UgcVoiceLoader r4 = UgcVoiceLoader.a;
        UgcVoiceLoader.b(this.$voice.getId(), this.$voiceName);
    L25:
        if (r3 == false) goto L27;
        long r5 = 1;
    L28:
        tx9.e0.c(Boxing.boxLong(r5));
        UgcVoiceLoader.s.postValue(r2);
        return Unit.INSTANCE;
    L27:
        r5 = 0;
        goto L28
    L23:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L25;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[requestEditVoiceName] fail, error=");
        com.larus.network.http.f r8 = r2;
        r7.append(r8.d);
        r6.e("UgcVoiceLoader", r7.toString(), r8.d);
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r49);
        SpeakerVoice r9 = this.$voice;
        if (r9 != null) goto L13;
        return Unit.INSTANCE;
    L13:
        if (this.$isVoiceUploadSuccess == true) goto L16;
        UgcVoiceLoader r10 = UgcVoiceLoader.a;
        UgcVoiceLoader.b(r9.getId(), this.$voiceName);
        UgcVoiceLoader.s.postValue(new com.larus.network.http.y(SpeakerVoice.copy$default(this.$voice, null, null, this.$voiceName, null, null, null, null, null, null, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, 2147483643, null), null, 14));
        return Unit.INSTANCE;
    L16:
        JSONObject r11 = new JSONObject();
        SpeakerVoice r12 = this.$voice;
        String r14 = this.$voiceName;
        r11.put("ugc_voice_id", r12.getId());
        r11.put(EasyGoDbTable.Server.NAME, r14);
        Unit r15 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", SpeakerVoice.class, "/alice/user_voice/update", r11, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L19;
        return r13;
    }
}
