package com.larus.audioplayer.impl.stream;

import android.media.AudioTrack;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.IAudioService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$writePcmToAudioTrack$1", f = "AudioStreamPlayer.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {1247, 1255}, m = "invokeSuspend", n = {"exportId", "tmpAudioTrack", "totalReadSize", "index", "exportId", "tmpAudioTrack", "targetData", "totalReadSize", "index"}, s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0", "I$0"})
final class AudioStreamPlayer$writePcmToAudioTrack$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bufferSize;
    final /* synthetic */ a0 $wavHeader;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AudioStreamPlayer$writePcmToAudioTrack$1(int r1, a0 r2, Continuation<? super AudioStreamPlayer$writePcmToAudioTrack$1> r3) {
        this.$bufferSize = r1;
        this.$wavHeader = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AudioStreamPlayer$writePcmToAudioTrack$1(this.$bufferSize, this.$wavHeader, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x014a -> B:52:0x014e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0184 -> B:17:0x0084). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 2;
        byte[] r4 = null;
        int r6 = 1;
        int r8 = 0;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r5 = this.I$0;
        long r9 = this.J$0;
        byte[] r11 = (byte[]) this.L$2;
        AudioTrack r12 = (AudioTrack) this.L$1;
        String r13 = (String) this.L$0;
        ResultKt.throwOnFailure(r24);
        AudioStreamPlayer$writePcmToAudioTrack$1 r7 = this;
    L52:
        AudioStreamPlayer.J = r11;
        if (AudioStreamPlayer.s.e() == false) goto L55;
        FLogger.a.i("AudioStreamPlayer", "index=" + r5 + " -->  queue is empty，so sleep 50ms and continue");
    L55:
        AudioTrack r14 = r12;
        String r15 = r13;
        r4 = null;
        r6 = 1;
        AudioStreamPlayer$writePcmToAudioTrack$1 r16 = r7;
        r3 = 2;
    L18:
        if (AudioStreamPlayer.h != com.larus.audioplayer.api.stream.StreamPlayerStatus.PLAYING) goto L20;
    L21:
        if (r14 != null) goto L24;
        ((ConcurrentLinkedQueue) AudioStreamPlayer.r).clear();
        FLogger.a.i("AudioStreamPlayer", "finish write data to AudioTrack, because of audioTrack=null");
    L30:
        FLogger.a.i("AudioStreamPlayer", "finish write data to AudioTrack  totalFramesWritten=" + AudioStreamPlayer.o + " curPlayingStatus=" + AudioStreamPlayer.h + " streamDataQueue=" + ((ConcurrentLinkedQueue) AudioStreamPlayer.r).size());
        a0 r10 = r16.$wavHeader;
        AudioStreamPlayer.o = (long) (((float) r9) / (((float) r10.g) * (((float) r10.k) / 8.0f)));
        return Unit.INSTANCE;
    L24:
        if (AudioStreamPlayer.p == false) goto L26;
    L32:
        CompletableDeferred<Boolean> r17 = AudioStreamPlayer.x;
        if (r17 == null) goto L38;
        r16.L$0 = r15;
        r16.L$1 = r14;
        r16.L$2 = r4;
        r16.J$0 = r9;
        r16.I$0 = r5;
        r16.label = r6;
        Object r19 = r17.await(r16);
        if (r19 != r1) goto L37;
        return r1;
    L37:
        Boolean r110 = (Boolean) r19;
    L38:
        byte[] r111 = AudioStreamPlayer.J;
        if (r111 == null) goto L41;
        int r112 = r111.length;
    L42:
        if (r111 != null) goto L44;
        r111 = new byte[r8];
    L44:
        AudioStreamPlayer.J = r4;
        if (r111.length >= r16.$bufferSize) goto L58;
        v r20 = (v) ((ConcurrentLinkedQueue) AudioStreamPlayer.r).poll();
        if (r20 != null) goto L56;
        r16.L$0 = r15;
        r16.L$1 = r14;
        r16.L$2 = r111;
        r16.J$0 = r9;
        r16.I$0 = r5;
        r16.label = r3;
        if (DelayKt.delay(50, r16) != r1) goto L51;
        return r1;
    L51:
        r7 = r16;
        r13 = r15;
        r12 = r14;
        r11 = r111;
        goto L52
    L56:
        r111 = ArraysKt.plus(r111, r20.a);
    L58:
        if (r111.length != 0) goto L60;
        boolean r21 = true;
    L61:
        if (r21 == false) goto L63;
        FLogger.a.e("AudioStreamPlayer", "writePcmToAudioTrack targetData is empty. continue directly");
        r3 = 2;
        r4 = null;
        r6 = 1;
        goto L18
    L63:
        int r22 = r111.length;
        if (r14.getPlayState() == 3) goto L66;
        int r23 = 0;
    L67:
        if (r23 > 0) goto L69;
        byte[] r25 = new byte[r8];
    L70:
        if (r23 >= 0) goto L72;
        AudioStreamPlayer.J = r111;
        Object r113 = r1;
    L81:
        if (r23 > 0) goto L83;
        FLogger.a.e("AudioStreamPlayer", "index=" + r5 + " -->  ！！！！！！！！！！！！！！write to audio track fail！！！！！！！！！！！！！！！");
    L83:
        byte[] r0 = AudioStreamPlayer.I;
        byte[] r26 = AudioStreamPlayer.H;
        int r27 = Math.min(r0.length, r26.length);
        int r114 = 0;
    L84:
        if (r114 >= r27) goto L89;
        byte[] r115 = r0;
        if (r0[r114] != r26[r114]) goto L91;
        r114 = r114 + 1;
        r0 = r115;
    L91:
        if (r114 < 0) goto L97;
        if (AudioStreamPlayer.s.e() == false) goto L97;
        FLogger.a.e("AudioStreamPlayer", "index=" + r5 + " --> write data error。。。。。。。。。xxIndex=" + r114 + " playData.size=" + AudioStreamPlayer.I.length + " netData.size=" + AudioStreamPlayer.H.length + " totalReadSize=" + r9);
    L97:
        if (r22 != r23) goto L99;
    L101:
        int r29 = r5;
        String r116 = r15;
        if (AudioStreamPlayer.s.e() == false) goto L105;
        FLogger.a.i("AudioStreamPlayer", "index=" + r29 + " --> AudioTrack was written data size size=" + r22 + " playData.size=" + AudioStreamPlayer.I.length + " bufferSize=" + r16.$bufferSize + " remainDataSize=" + r112 + " playData.size=" + AudioStreamPlayer.I.length + " streamDataQueueSize=" + ((ConcurrentLinkedQueue) AudioStreamPlayer.r).size() + ' ');
        r5 = r29 + 1;
        r1 = r113;
        r14 = r14;
        r15 = r116;
        r3 = 2;
        r4 = null;
        r6 = 1;
        r8 = 0;
    L105:
        r5 = r29 + 1;
        r1 = r113;
        r14 = r14;
        r15 = r116;
        r3 = 2;
        r4 = null;
        r6 = 1;
        r8 = 0;
        goto L18
    L99:
        if (AudioStreamPlayer.s.e() == false) goto L101;
        FLogger r30 = FLogger.a;
        r116 = r15;
        StringBuilder r117 = new StringBuilder("index=");
        r117.append(r5);
        r29 = r5;
        r117.append(" --> want to write to AudioTrack data size=");
        r117.append(r22);
        r117.append(", but in fact  write data size=");
        r117.append(r23);
        r117.append(" playData.size=");
        r117.append(AudioStreamPlayer.I.length);
        r117.append(" remainDataSize=");
        r117.append(r112);
        r117.append(" playData.size=");
        r117.append(AudioStreamPlayer.I.length);
        r117.append(" bufferSize=");
        r117.append(r16.$bufferSize);
        r117.append(" totalReadSize=");
        r117.append(r9);
        r117.append(" streamDataQueueSize=");
        r117.append(((ConcurrentLinkedQueue) AudioStreamPlayer.r).size());
        r117.append(' ');
        r30.e("AudioStreamPlayer", r117.toString());
        goto L105
    L89:
        r114 = -1;
        goto L91
    L72:
        r113 = r1;
        if (r22 < r23) goto L81;
        r9 = r9 + ((long) r23);
        if (AudioStreamPlayer.s.e() == false) goto L77;
        AudioStreamPlayer.I = ArraysKt.plus(AudioStreamPlayer.I, r25);
    L77:
        IAudioService r31 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r31 == null) goto L80;
        r31.c0(r25, r15);
    L80:
        AudioStreamPlayer.J = CollectionsKt.toByteArray(ArraysKt.takeLast(r111, r22 - r23));
        goto L81
    L69:
        r25 = ArraysKt.copyOfRange(r111, r8, r23);
        goto L70
    L66:
        r23 = r14.write(r111, r8, r22);
        goto L67
    L60:
        r21 = false;
        goto L61
    L41:
        r112 = 0;
        goto L42
    L26:
        if (((ConcurrentLinkedQueue) AudioStreamPlayer.r).isEmpty() == false) goto L32;
        if (AudioStreamPlayer.J != null) goto L32;
        FLogger.a.i("AudioStreamPlayer", "finish write data to AudioTrack, because isQueueChunking=false, queue is empty and remainData is null ");
        goto L30
    L20:
        if (AudioStreamPlayer.h != com.larus.audioplayer.api.stream.StreamPlayerStatus.PAUSED) goto L30;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r5 = this.I$0;
        r9 = this.J$0;
        r14 = (AudioTrack) this.L$1;
        r15 = (String) this.L$0;
        ResultKt.throwOnFailure(r24);
        r19 = r24;
        r16 = this;
        goto L37
    L10:
        ResultKt.throwOnFailure(r24);
        AudioStreamPlayer.I = new byte[0];
        AudioStreamPlayer.J = null;
        StringBuilder r32 = new StringBuilder();
        AudioStreamPlayer r33 = AudioStreamPlayer.a;
        Pair<String, String> r34 = AudioStreamPlayer.c;
        if (r34 == null) goto L13;
        String r35 = (String) r34.getFirst();
    L14:
        if (r35 != null) goto L16;
        r35 = "";
    L16:
        r32.append(AudioStreamPlayer.h(r35));
        r32.append("_track");
        r16 = this;
        r15 = r32.toString();
        r5 = 0;
        r14 = AudioStreamPlayer.v;
        r9 = 0;
        goto L18
    L13:
        r35 = null;
        goto L14
    }
}
