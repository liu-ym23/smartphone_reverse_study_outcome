package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
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
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader$requestDeleteVoice$1", f = "UgcVoiceLoader.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
final class UgcVoiceLoader$requestDeleteVoice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFromTts;
    final /* synthetic */ boolean $isVoiceUploadSuccess;
    final /* synthetic */ SpeakerVoice $voice;
    int label;

    public UgcVoiceLoader$requestDeleteVoice$1(SpeakerVoice r1, boolean r2, boolean r3, Continuation<? super UgcVoiceLoader$requestDeleteVoice$1> r4) {
        this.$voice = r1;
        this.$isVoiceUploadSuccess = r2;
        this.$isFromTts = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UgcVoiceLoader$requestDeleteVoice$1(this.$voice, this.$isVoiceUploadSuccess, this.$isFromTts, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L19:
        com.larus.network.http.f r2 = (com.larus.network.http.a) r1;
        boolean r3 = r2 instanceof com.larus.network.http.y;
        if (r3 == false) goto L28;
        UgcVoiceLoader r4 = UgcVoiceLoader.a;
        UgcVoiceLoader.a(this.$voice.getId());
        UgcVoiceLoader.q.postValue(new com.larus.network.http.y(new r2a.d(this.$voice.getId(), this.$voice), null, 14));
        if (this.$isFromTts == true) goto L30;
        CopyOnWriteArrayList<p2a.e> r5 = UgcVoiceLoader.F;
        SpeakerVoice r6 = this.$voice;
        Iterator<p2a.e> r7 = r5.iterator();
    L25:
        if (r7.hasNext() == false) goto L30;
        r7.next().a(r6.getId());
    L30:
        if (r3 == false) goto L32;
        long r8 = 1;
    L33:
        tx9.e0.b(Boxing.boxLong(r8));
        return Unit.INSTANCE;
    L32:
        r8 = 0;
        goto L33
    L28:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L30;
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("[requestDeleteVoice] fail, error=");
        com.larus.network.http.f r11 = r2;
        r10.append(r11.d);
        r9.e("UgcVoiceLoader", r10.toString(), r11.d);
        UgcVoiceLoader.q.postValue(new com.larus.network.http.f(r11.d, null));
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        SpeakerVoice r12 = this.$voice;
        if (r12 != null) goto L13;
        return Unit.INSTANCE;
    L13:
        if (this.$isVoiceUploadSuccess == true) goto L16;
        UgcVoiceLoader r14 = UgcVoiceLoader.a;
        UgcVoiceLoader.a(r12.getId());
        UgcVoiceLoader.q.postValue(new com.larus.network.http.y(new r2a.d(this.$voice.getId(), this.$voice), null, 14));
        return Unit.INSTANCE;
    L16:
        JSONObject r15 = new JSONObject();
        r15.put("ugc_voice_id", this.$voice.getId());
        Unit r16 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", Object.class, "/alice/user_voice/delete", r15, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L19;
        return r13;
    }
}
