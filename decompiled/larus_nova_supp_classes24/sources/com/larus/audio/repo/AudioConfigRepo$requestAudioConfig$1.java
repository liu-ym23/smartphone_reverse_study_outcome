package com.larus.audio.repo;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.y;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.repo.AudioConfigRepo$requestAudioConfig$1", f = "AudioConfigRepo.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
public final class AudioConfigRepo$requestAudioConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AudioConfigRepo$requestAudioConfig$1(Continuation<? super AudioConfigRepo$requestAudioConfig$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AudioConfigRepo$requestAudioConfig$1(r2);
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
        y r15 = (a) r14;
        if ((r15 instanceof y) == false) goto L27;
        AudioUserConfig r16 = (AudioUserConfig) ((a) r15).b;
        if (r16 != null) goto L18;
        return Unit.INSTANCE;
    L18:
        if (r16.getActive() == false) goto L20;
    L25:
        AudioConfigRepo.d.postValue(r16);
        AudioConfigRepo r2 = AudioConfigRepo.a;
        AudioConfigRepo.k(r16);
        goto L27
    L20:
        if (FeatureKitDelegate.b.w0().b() == true) goto L25;
        if (z2.a.a1() == true) goto L25;
        FLogger.a.e("AudioConfigRepo", "[requestAudioConfig] no active");
        return Unit.INSTANCE;
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        this.label = 1;
        r14 = HttpExtKt.k("Audio", AudioUserConfig.class, "/alice/user/voice_config", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}
