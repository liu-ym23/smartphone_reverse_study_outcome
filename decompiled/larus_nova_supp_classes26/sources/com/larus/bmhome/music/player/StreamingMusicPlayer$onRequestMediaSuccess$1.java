package com.larus.bmhome.music.player;

import com.larus.audio.controller.GlobalAudioController;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.player.StreamingMusicPlayer$onRequestMediaSuccess$1", f = "StreamingMusicPlayerBuilder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class StreamingMusicPlayer$onRequestMediaSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentPlayingChunkUrl;
    final /* synthetic */ float $volumeFactor;
    int label;
    final /* synthetic */ StreamingMusicPlayer this$0;

    public StreamingMusicPlayer$onRequestMediaSuccess$1(StreamingMusicPlayer r1, String r2, float r3, Continuation<? super StreamingMusicPlayer$onRequestMediaSuccess$1> r4) {
        this.this$0 = r1;
        this.$currentPlayingChunkUrl = r2;
        this.$volumeFactor = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new StreamingMusicPlayer$onRequestMediaSuccess$1(this.this$0, this.$currentPlayingChunkUrl, this.$volumeFactor, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r6);
        FLogger r7 = FLogger.a;     // Catch: IOException -> L25 IllegalStateException -> L27
        r7.i("StreamingMusicPlayer", "[onRequestMediaSuccess] request media to chunk success");     // Catch: IOException -> L25 IllegalStateException -> L27
        this.this$0.g = true;     // Catch: IOException -> L25 IllegalStateException -> L27
        StringBuilder r3 = new StringBuilder("[onRequestMediaSuccess] check resume with ");     // Catch: IOException -> L25 IllegalStateException -> L27
        r3.append(this.$currentPlayingChunkUrl);     // Catch: IOException -> L25 IllegalStateException -> L27
        r3.append(" and media ");     // Catch: IOException -> L25 IllegalStateException -> L27
        j r2 = this.this$0.c;     // Catch: IOException -> L25 IllegalStateException -> L27
        Boolean r4 = null;
        if (r2 == null) goto L8;
        String r5 = r2.f();     // Catch: IOException -> L25 IllegalStateException -> L27
    L9:
        r3.append(r5);     // Catch: IOException -> L25 IllegalStateException -> L27
        r7.i("StreamingMusicPlayer", r3.toString());     // Catch: IOException -> L25 IllegalStateException -> L27
        GlobalAudioController r8 = GlobalAudioController.a;     // Catch: IOException -> L25 IllegalStateException -> L27
        StreamingMusicPlayer.b r9 = this.this$0.h;     // Catch: IOException -> L25 IllegalStateException -> L27
        r9.a = false;     // Catch: IOException -> L25 IllegalStateException -> L27
        r8.h(r9);     // Catch: IOException -> L25 IllegalStateException -> L27
        String r10 = this.$currentPlayingChunkUrl;     // Catch: IOException -> L25 IllegalStateException -> L27
        j r11 = this.this$0.c;     // Catch: IOException -> L25 IllegalStateException -> L27
        if (r11 == null) goto L12;
        String r12 = r11.f();     // Catch: IOException -> L25 IllegalStateException -> L27
    L13:
        j r13 = this.this$0.c;     // Catch: IOException -> L25 IllegalStateException -> L27
        if (r13 == null) goto L19;
        Message r14 = r13.j;     // Catch: IOException -> L25 IllegalStateException -> L27
        if (r14 == null) goto L19;
        r4 = Boxing.boxBoolean(r14.isNewBlockType());     // Catch: IOException -> L25 IllegalStateException -> L27
    L19:
        if (c0.a(r10, r12, r4) == false) goto L23;
        boolean r15 = StreamingMusicPlayer.n;     // Catch: IOException -> L25 IllegalStateException -> L27
        if (StreamingMusicPlayer.q == null) goto L23;
        StreamingMusicPlayer.m(this.this$0);     // Catch: IOException -> L25 IllegalStateException -> L27
    L30:
        return Unit.INSTANCE;
    L23:
        StreamingMusicPlayer.l(this.this$0, this.$volumeFactor);     // Catch: IOException -> L25 IllegalStateException -> L27
        goto L30
    L12:
        r12 = null;
        goto L13
    L8:
        r5 = null;
    L25:
        e = move-exception;
        StreamingMusicPlayer r16 = this.this$0;
        boolean r17 = StreamingMusicPlayer.n;
        r16.v(30024);
        FLogger.a.e("StreamingMusicPlayer", "[onRequestMediaSuccess] error play stream audio what " + e);
    L27:
        e = move-exception;
        StreamingMusicPlayer r18 = this.this$0;
        boolean r19 = StreamingMusicPlayer.n;
        r18.v(30023);
        FLogger.a.e("StreamingMusicPlayer", "[onRequestMediaSuccess] error play stream audio what " + e);
        goto L30
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
