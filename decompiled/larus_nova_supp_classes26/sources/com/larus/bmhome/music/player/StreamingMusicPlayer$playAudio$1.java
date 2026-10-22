package com.larus.bmhome.music.player;

import com.larus.im.bean.message.Message;
import com.larus.media.MediaLevel;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.player.StreamingMusicPlayer$playAudio$1", f = "StreamingMusicPlayerBuilder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StreamingMusicPlayer$playAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentPlayingChunkUrl;
    int label;
    final /* synthetic */ StreamingMusicPlayer this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.music.player.StreamingMusicPlayer$playAudio$1$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass3(Object r8) {
            super(1, r8, StreamingMusicPlayer.class, "onRequestMediaFailure", "onRequestMediaFailure(Ljava/lang/String;)V", 0);
        }

        public final void invoke(String r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            StreamingMusicPlayer r4 = (StreamingMusicPlayer) ((CallableReference) this).receiver;
            r4.g = false;
            r4.y(true);
            r4.v(30025);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    public StreamingMusicPlayer$playAudio$1(StreamingMusicPlayer r1, String r2, Continuation<? super StreamingMusicPlayer$playAudio$1> r3) {
        this.this$0 = r1;
        this.$currentPlayingChunkUrl = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new StreamingMusicPlayer$playAudio$1(this.this$0, this.$currentPlayingChunkUrl, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r23);
        j r1 = this.this$0.c;
        if (r1 == null) goto L12;
        ad9.b r2 = r1.g;
        if (r2 == null) goto L12;
        b.a r3 = b.a;
        String r4 = r1.j();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r3.getClass();
        b.a.a(r2, r4);
    L12:
        FLogger r5 = FLogger.a;
        r5.i("StreamingMusicPlayer", "[playAudio] request media to play chunk, before mediaApplicant: " + this.this$0.m + ", mediaScene = " + this.this$0.r());
        StreamingMusicPlayer r6 = this.this$0;
        if (Intrinsics.areEqual(r6.m.b, r6.r()) == true) goto L15;
    L16:
        StringBuilder r7 = new StringBuilder("[playAudio] chunkUrl: ");
        j r8 = this.this$0.c;
        String r9 = null;
        if (r8 == null) goto L19;
        String r10 = r8.f();
    L20:
        r7.append(r10);
        r5.i("StreamingMusicPlayer", r7.toString());
        StreamingMusicPlayer r11 = this.this$0;
        j r12 = r11.c;
        if (r12 == null) goto L23;
        r9 = r12.f();
    L23:
        String r13 = r9;
        String r14 = this.this$0.r();
        j r15 = this.this$0.c;
        if (r15 == null) goto L30;
        Message r16 = r15.j;
        if (r16 == null) goto L30;
        boolean r17 = true;
        if (com.larus.im.bean.message.a.V(r16) != true) goto L30;
    L31:
        if (r17 == false) goto L33;
        MediaLevel r18 = MediaLevel.PLAY_HIGH;
    L34:
        r11.m = new com.larus.media.model.a(r13, r14, false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), r18.getValue(), false, this.this$0.l, 1196);
    L35:
        r5.i("StreamingMusicPlayer", "[playAudio] request media to play chunk, after mediaApplicant: " + this.this$0.m + ", mediaScene = " + this.this$0.r());
        final StreamingMusicPlayer r19 = this.this$0;
        com.larus.media.model.a r20 = r19.m;
        if (r20.a != null) goto L39;
        r5.i("StreamingMusicPlayer", "[playAudio] key is null: can not requestMedia");
        return Unit.INSTANCE;
    L39:
        Lazy r21 = MediaResourceManager.a;
        final String r22 = this.$currentPlayingChunkUrl;
        MediaResourceManager.m(r20, new a0(r19, r22), new AnonymousClass3(this.this$0), 0, 8);
        return Unit.INSTANCE;
    L33:
        r18 = MediaLevel.PLAY_DEFAULT;
    L30:
        r17 = false;
        goto L31
    L19:
        r10 = null;
        goto L20
    L15:
        if (this.this$0.m.a != null) goto L35;
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
