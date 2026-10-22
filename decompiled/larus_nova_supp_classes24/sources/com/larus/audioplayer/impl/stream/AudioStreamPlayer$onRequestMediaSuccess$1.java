package com.larus.audioplayer.impl.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$onRequestMediaSuccess$1", f = "AudioStreamPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioStreamPlayer$onRequestMediaSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    final /* synthetic */ float $volumeFactor;
    int label;

    public AudioStreamPlayer$onRequestMediaSuccess$1(String r1, float r2, Continuation<? super AudioStreamPlayer$onRequestMediaSuccess$1> r3) {
        this.$url = r1;
        this.$volumeFactor = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AudioStreamPlayer$onRequestMediaSuccess$1(this.$url, this.$volumeFactor, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        com.larus.audioplayer.impl.news.a r6 = com.larus.audioplayer.impl.news.a.a;     // Catch: IOException -> L7 IllegalStateException -> L9
        com.larus.audioplayer.impl.news.a.a(new f88.e());     // Catch: IOException -> L7 IllegalStateException -> L9
        AudioStreamPlayer.b();     // Catch: IOException -> L7 IllegalStateException -> L9
        AudioStreamPlayer.a(this.$url, this.$volumeFactor);     // Catch: IOException -> L7 IllegalStateException -> L9
    L12:
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        FLogger.a.e("AudioStreamPlayer", "[onRequestMediaSuccess] error2 play stream audio what " + e);
    L9:
        e = move-exception;
        FLogger.a.e("AudioStreamPlayer", "[onRequestMediaSuccess] error1 play stream audio what " + e);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
