package com.larus.audioplayer.impl.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.IAudioService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$startParseLocalFileDataToQueue$1", f = "AudioStreamPlayer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {1097, 1137}, m = "invokeSuspend", n = {"inputStream", "buffer", "id", "index", "totalReadSize", "readPosition", "inputStream", "buffer", "id", "index", "totalReadSize", "readPosition"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "J$1", "L$0", "L$1", "L$2", "I$0", "J$0", "J$1"})
final class AudioStreamPlayer$startParseLocalFileDataToQueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bufferSize;
    final /* synthetic */ File $file;
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AudioStreamPlayer$startParseLocalFileDataToQueue$1(File r1, int r2, Continuation<? super AudioStreamPlayer$startParseLocalFileDataToQueue$1> r3) {
        this.$file = r1;
        this.$bufferSize = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AudioStreamPlayer$startParseLocalFileDataToQueue$1(this.$file, this.$bufferSize, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x02f5 -> B:106:0x02f8). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r27) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        String r8 = " -->failed to close RandomAccessFile stream！";
        String r9 = "startParseLocalFileDataToQueue exec finished, reset isQueueChunking";
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        long r14 = this.J$1;
        long r6 = this.J$0;
        int r4 = this.I$0;
        String r0 = (String) this.L$2;
        byte[] r10 = (byte[]) this.L$1;
        RandomAccessFile r5 = (RandomAccessFile) this.L$0;
        ResultKt.throwOnFailure(r27);     // Catch: Throwable -> L9 CancellationException -> L152
        AudioStreamPlayer$startParseLocalFileDataToQueue$1 r7 = this;
        int r1 = 1;
    L106:
        r4 = r4 + r1;
    L163:
        Queue<v> r19 = AudioStreamPlayer.r;     // Catch: Throwable -> L118 CancellationException -> L121
        int r11 = ((ConcurrentLinkedQueue) r19).size();     // Catch: Throwable -> L118 CancellationException -> L121
        hq9.t r110 = AudioStreamPlayer.s;     // Catch: Throwable -> L118 CancellationException -> L121
        if (r11 >= r110.c()) goto L155;
        String r29 = r8;
        String r12 = r9;
    L115:
        th = th;
        r9 = r12;
    L110:
        r8 = r29;
    L120:
        int r13 = r4;
        RandomAccessFile r15 = r5;
    L166:
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L130
        r16.e("AudioStreamPlayer", "index=" + r13 + " -->parseInputStream err=" + th);     // Catch: Throwable -> L130
        AudioStreamPlayer r17 = AudioStreamPlayer.a;     // Catch: Throwable -> L130
        AudioStreamPlayer.C = new Pair(AudioStreamPlayer.j(), Boxing.boxLong(AudioStreamPlayer.i(AudioStreamPlayer.j())));     // Catch: Throwable -> L130
        AudioStreamPlayer.e = new Pair(Boxing.boxInt(2), "parse error. msg=" + th);     // Catch: Throwable -> L130
        AudioStreamPlayer.v(com.larus.audioplayer.api.stream.StreamPlayerStatus.ERROR);     // Catch: Throwable -> L130
        r16.i("AudioStreamPlayer", r9);
        AudioStreamPlayer.p = false;
        r15.close();     // Catch: IOException -> L128
    L142:
        return Unit.INSTANCE;
    L128:
        e = move-exception;
        e.printStackTrace();
        FLogger r20 = FLogger.a;
        r4 = r13;
        StringBuilder r21 = new StringBuilder("index=");
    L139:
        r21.append(r4);
    L140:
        r21.append(r8);
        r20.e("AudioStreamPlayer", r21.toString());
    L130:
        th = move-exception;
        Throwable r22 = th;
    L145:
        FLogger.a.i("AudioStreamPlayer", r9);
        AudioStreamPlayer.p = false;
        r15.close();     // Catch: IOException -> L148
        throw r22;
    L148:
        e = move-exception;
        e.printStackTrace();
        FLogger.a.e("AudioStreamPlayer", "index=" + r13 + r8);
        throw r22;
    L50:
        if (AudioStreamPlayer.h != com.larus.audioplayer.api.stream.StreamPlayerStatus.STOPPED) goto L56;
        FLogger.a.i("AudioStreamPlayer", "index=" + r4 + " --->current state is top, finish read local file to queue");     // Catch: Throwable -> L53 CancellationException -> L117
    L58:
        String r23 = r12;
    L86:
        AudioStreamPlayer.c();     // Catch: Throwable -> L112 CancellationException -> L114
        FLogger r24 = FLogger.a;     // Catch: Throwable -> L112 CancellationException -> L114
        StringBuilder r25 = new StringBuilder();     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append("index=");     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(r4);     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(" -->buffer chunk audio data from local file finished! totalReadSize=");     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(r6);     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(" totalFramesWritten=");     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(AudioStreamPlayer.o);     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(" curPlayingStatus=");     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(AudioStreamPlayer.h);     // Catch: Throwable -> L112 CancellationException -> L114
        r25.append(" url=");     // Catch: Throwable -> L112 CancellationException -> L114
        Pair<String, String> r26 = AudioStreamPlayer.c;     // Catch: Throwable -> L112 CancellationException -> L114
        if (r26 == null) goto L90;
        String r30 = (String) r26.getFirst();     // Catch: Throwable -> L77 CancellationException -> L114
    L91:
        r25.append(r30);     // Catch: Throwable -> L112 CancellationException -> L114
        r24.i("AudioStreamPlayer", r25.toString());     // Catch: Throwable -> L112 CancellationException -> L114
        r24.i("AudioStreamPlayer", r23);
        AudioStreamPlayer.p = false;
        r5.close();     // Catch: IOException -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
        r20 = FLogger.a;
        r21 = new StringBuilder("index=");
        r21.append(r4);
        r8 = r29;
        goto L140
    L112:
        th = th;
        r9 = r23;
    L114:
        r9 = r23;
    L111:
        r8 = r29;
    L77:
        th = th;
    L81:
        r8 = r29;
        r9 = r23;
        goto L120
    L90:
        r30 = null;
        goto L91
    L56:
        if (AudioStreamPlayer.v != null) goto L59;
        FLogger.a.i("AudioStreamPlayer", "index=" + r4 + " --->current audioTrack is null, finish read local file data to internal storage");     // Catch: Throwable -> L53 CancellationException -> L117
        goto L58
    L59:
        long r31 = r7.$file.length() - r14;
        if (r31 > 0) goto L161;
        r23 = r12;
        Object r210 = r2;
        if (AudioStreamPlayer.q == true) goto L97;
        FLogger.a.i("AudioStreamPlayer", "index=" + r4 + " --->finish read data to internal storage, file size is totally read and isNetFileWriting is false");     // Catch: Throwable -> L112 CancellationException -> L114
        goto L86
    L97:
        r9 = r23;
        if (r110.e() == false) goto L101;
        FLogger.a.i("AudioStreamPlayer", "index=" + r4 + " --->read all data to internal storage at this file，wait 100ms to continue");     // Catch: Throwable -> L109 CancellationException -> L151
    L101:
        r7.L$0 = r5;     // Catch: Throwable -> L109 CancellationException -> L151
        r7.L$1 = r10;     // Catch: Throwable -> L109 CancellationException -> L151
        r7.L$2 = r0;     // Catch: Throwable -> L109 CancellationException -> L151
        r7.I$0 = r4;     // Catch: Throwable -> L109 CancellationException -> L151
        r7.J$0 = r6;     // Catch: Throwable -> L109 CancellationException -> L151
        r7.J$1 = r14;     // Catch: Throwable -> L109 CancellationException -> L151
        r7.label = 2;     // Catch: Throwable -> L109 CancellationException -> L151
        r2 = r210;
        if (DelayKt.delay(100, r7) != r2) goto L105;
        return r2;
    L105:
        r8 = r29;
        r1 = 1;
        goto L106
    L109:
        th = th;
        goto L110
    L161:
        r5.seek(r14);     // Catch: Throwable -> L79 CancellationException -> L117
        r23 = r12;
        Object r211 = r2;
        int r32 = (int) Math.min(r31, r10.length);     // Catch: Throwable -> L77 CancellationException -> L114
        r5.readFully(r10, 0, r32);     // Catch: Throwable -> L77 CancellationException -> L114
        byte[] r33 = ArraysKt.copyOfRange(r10, 0, r32);     // Catch: Throwable -> L77 CancellationException -> L114
        if (r110.e() == false) goto L68;
        AudioStreamPlayer.H = ArraysKt.plus(AudioStreamPlayer.H, r33);     // Catch: Throwable -> L77 CancellationException -> L114
    L68:
        if (((ConcurrentLinkedQueue) r19).offer(new v(r33)) == true) goto L71;
        FLogger.a.e("AudioStreamPlayer", "index=" + r4 + " --->!!!!!!!!!!!!failed to insert audio data to queue !!!!!!!!!!!!");     // Catch: Throwable -> L77 CancellationException -> L114
    L71:
        if (r110.e() == false) goto L73;
        FLogger.a.i("AudioStreamPlayer", "index=" + r4 + " -->read local buffer file to queue,  size=" + r10.length + " bytesRead=" + r32 + " streamDataQueueSize=" + ((ConcurrentLinkedQueue) r19).size());     // Catch: Throwable -> L77 CancellationException -> L114
    L73:
        long r34 = r32;
        r14 = r14 + r34;     // Catch: Throwable -> L77 CancellationException -> L114
        r6 = r6 + r34;     // Catch: Throwable -> L77 CancellationException -> L114
        IAudioService r35 = (IAudioService) ServiceManager.get().getService(IAudioService.class);     // Catch: Throwable -> L77 CancellationException -> L114
        if (r35 == null) goto L76;
        r35.c0(r33, r0);     // Catch: Throwable -> L77 CancellationException -> L114
    L76:
        r4 = r4 + 1;
        r8 = r29;
        r9 = r23;
        r2 = r211;
        goto L163
    L186:
        r4 = r4 + 1;
        r8 = r29;
        r9 = r23;
        r2 = r211;
    L79:
        th = th;
        r23 = r12;
        goto L81
    L155:
        r7.L$0 = r5;     // Catch: Throwable -> L46 CancellationException -> L121
        r7.L$1 = r10;     // Catch: Throwable -> L46 CancellationException -> L121
        r7.L$2 = r0;     // Catch: Throwable -> L46 CancellationException -> L121
        r7.I$0 = r4;     // Catch: Throwable -> L46 CancellationException -> L121
        r7.J$0 = r6;     // Catch: Throwable -> L46 CancellationException -> L121
        r7.J$1 = r14;     // Catch: Throwable -> L46 CancellationException -> L121
        r7.label = 1;     // Catch: Throwable -> L46 CancellationException -> L121
        r29 = r8;
        String r36 = r9;
    L53:
        th = th;
        r8 = r29;
        r9 = r36;
    L117:
        r9 = r36;
        goto L111
    L37:
        if (DelayKt.delay(50, r7) != r2) goto L39;
        return r2;
    L39:
        r8 = r29;
        r9 = r36;
    L40:
        if (AudioStreamPlayer.s.e() == false) goto L187;
        FLogger r37 = FLogger.a;     // Catch: Throwable -> L9 CancellationException -> L152
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L9 CancellationException -> L152
        r111.append("index=");     // Catch: Throwable -> L9 CancellationException -> L152
        r111.append(r4);     // Catch: Throwable -> L9 CancellationException -> L152
        String r212 = r0;
        r111.append(" --->data queue size so long, skip once");     // Catch: Throwable -> L9 CancellationException -> L152
        r37.i("AudioStreamPlayer", r111.toString());     // Catch: Throwable -> L9 CancellationException -> L152
        r0 = r212;
        goto L163
    L187:
        r0 = r0;
        goto L163
        goto L169
    L46:
        th = th;
    L121:
        r29 = r8;
    L118:
        th = th;
    L9:
        th = th;
    L169:
        FLogger r38 = FLogger.a;     // Catch: Throwable -> L143
        r38.i("AudioStreamPlayer", "index=" + r4 + " -->the coroutines of read buffer file to queue was canceled!");     // Catch: Throwable -> L143
        r38.i("AudioStreamPlayer", r9);
        AudioStreamPlayer.p = false;
        r5.close();     // Catch: IOException -> L137
    L137:
        e = move-exception;
        e.printStackTrace();
        r20 = FLogger.a;
        r21 = new StringBuilder("index=");
    L143:
        th = move-exception;
        r22 = th;
        r13 = r4;
        r15 = r5;
        goto L145
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        long r39 = this.J$1;
        long r40 = this.J$0;
        int r41 = this.I$0;
        r0 = (String) this.L$2;
        r10 = (byte[]) this.L$1;
        RandomAccessFile r112 = (RandomAccessFile) this.L$0;
        ResultKt.throwOnFailure(r27);     // Catch: Throwable -> L16 CancellationException -> L18
        r7 = this;
        r4 = r41;
        r6 = r40;
        r5 = r112;
        r14 = r39;
        goto L40
    L18:
        r4 = r41;
        r5 = r112;
    L16:
        th = th;
        r4 = r41;
        r5 = r112;
        goto L120
    L19:
        ResultKt.throwOnFailure(r27);
        r15 = new RandomAccessFile(this.$file, "r");
        byte[] r42 = new byte[this.$bufferSize];     // Catch: Throwable -> L122 CancellationException -> L132
        StringBuilder r43 = new StringBuilder();     // Catch: Throwable -> L122 CancellationException -> L132
        AudioStreamPlayer r44 = AudioStreamPlayer.a;     // Catch: Throwable -> L122 CancellationException -> L132
        Pair<String, String> r45 = AudioStreamPlayer.c;     // Catch: Throwable -> L122 CancellationException -> L132
        if (r45 == null) goto L23;
        String r46 = (String) r45.getFirst();     // Catch: Throwable -> L122 CancellationException -> L132
    L24:
        if (r46 != null) goto L26;
        r46 = "";
    L26:
        r43.append(AudioStreamPlayer.h(r46));     // Catch: Throwable -> L122 CancellationException -> L132
        r43.append("_1");     // Catch: Throwable -> L122 CancellationException -> L132
        String r47 = r43.toString();     // Catch: Throwable -> L122 CancellationException -> L132
        FLogger r48 = FLogger.a;     // Catch: Throwable -> L122 CancellationException -> L132
        StringBuilder r49 = new StringBuilder("start exec local file buffering logic, id=");     // Catch: Throwable -> L122 CancellationException -> L132
        Pair<String, String> r50 = AudioStreamPlayer.c;     // Catch: Throwable -> L122 CancellationException -> L132
        if (r50 == null) goto L29;
        String r51 = (String) r50.getFirst();     // Catch: Throwable -> L122 CancellationException -> L132
    L30:
        r49.append(r51);     // Catch: Throwable -> L122 CancellationException -> L132
        r48.i("AudioStreamPlayer", r49.toString());     // Catch: Throwable -> L122 CancellationException -> L132
        r10 = r42;
        r0 = r47;
        r6 = 0;
        r14 = 0;
        r7 = this;
        r5 = r15;
        r4 = 0;
        goto L163
    L29:
        r51 = null;
        goto L30
    L23:
        r46 = null;
    L132:
        r5 = r15;
        r4 = 0;
    L122:
        th = th;
        r13 = 0;
        goto L166
    }
}
