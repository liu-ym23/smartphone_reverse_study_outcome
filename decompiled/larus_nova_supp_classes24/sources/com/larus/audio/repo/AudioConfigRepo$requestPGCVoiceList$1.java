package com.larus.audio.repo;

import androidx.lifecycle.MutableLiveData;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nuc.f;
import org.json.JSONObject;
import p68.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.repo.AudioConfigRepo$requestPGCVoiceList$1", f = "AudioConfigRepo.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
public final class AudioConfigRepo$requestPGCVoiceList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $caller;
    int label;

    public AudioConfigRepo$requestPGCVoiceList$1(String r1, Continuation<? super AudioConfigRepo$requestPGCVoiceList$1> r2) {
        this.$caller = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AudioConfigRepo$requestPGCVoiceList$1(this.$caller, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r29);
        Object r2 = r29;
    L11:
        y r3 = (a) r2;
        if ((r3 instanceof y) == false) goto L35;
        d r4 = (d) ((a) r3).b;
        if (r4 == null) goto L16;
        List<SpeakerVoice> r5 = r4.a();
        if (r5 == null) goto L33;
        List r6 = CollectionsKt.filterNotNull(r5);
        if (r6 == null) goto L33;
        MutableLiveData r7 = AudioConfigRepo.d;
        AudioUserConfig r15 = (AudioUserConfig) r7.getValue();
        if (r15 == null) goto L26;
        AudioUserConfig r8 = AudioUserConfig.copy$default(r15, null, r6, null, null, false, null, null, false, null, false, 1021, null);
        if (r8 == null) goto L26;
    L27:
        r7.postValue(r8);
        wt7.c r9 = wt7.a.a;     // Catch: Exception -> L30
        f r10 = kuc.a.b(SpeakerVoice.Companion.serializer());     // Catch: Exception -> L30
        r9.getClass();     // Catch: Exception -> L30
        AudioConfigRepo.c.storeString("key_audio_pgc_voice_list", wt7.c.b(r6, r10));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        FLogger.a.e("AudioConfigRepo", "[savePGCVoiceList] error: " + e.getMessage(), e);
    L26:
        r8 = new AudioUserConfig(null, r6, null, null, false, null, null, false, null, false, 1021, null);
    L33:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r29);
        FLogger.a.i("AudioConfigRepo", "[requestPGCVoiceList]: from " + this.$caller);
        JSONObject r11 = new JSONObject();
        this.label = 1;
        r2 = HttpExtKt.k("Audio", d.class, "/alice/user_voice/pgc_voice_list", r11, null, null, false, null, null, null, this, 1008);
        if (r2 != r0) goto L11;
        return r0;
    }
}
