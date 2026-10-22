package com.larus.audioplayer.impl.stream;

import android.util.Base64;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "chunkData", "Lcom/larus/audioplayer/impl/stream/StreamChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$startSseChunk$2$1", f = "AudioStreamPlayer.kt", i = {0}, l = {831}, m = "invokeSuspend", n = {"chunkData"}, s = {"L$0"})
public final class AudioStreamPlayer$startSseChunk$2$1 extends SuspendLambda implements Function2<w, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $bufferSize;
    final /* synthetic */ Ref.IntRef $curIndex;
    final /* synthetic */ boolean $hasWavHeader;
    final /* synthetic */ BufferedReader $it;
    final /* synthetic */ int $loopIndex;
    final /* synthetic */ Ref.ObjectRef<byte[]> $musicPlayData;
    final /* synthetic */ Function1<byte[], Integer> $onHeaderParsed;
    final /* synthetic */ Function3<Integer, byte[], Continuation<? super Unit>, Object> $onMusicDataParsed;
    final /* synthetic */ Ref.ObjectRef<byte[]> $wavHeader;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioStreamPlayer$startSseChunk$2$1(int r1, BufferedReader r2, Ref.IntRef r3, boolean r4, Ref.IntRef r5, Ref.ObjectRef<byte[]> r6, Function1<? super byte[], Integer> r7, Ref.ObjectRef<byte[]> r8, Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r9, Continuation<? super AudioStreamPlayer$startSseChunk$2$1> r10) {
        this.$loopIndex = r1;
        this.$it = r2;
        this.$curIndex = r3;
        this.$hasWavHeader = r4;
        this.$bufferSize = r5;
        this.$wavHeader = r6;
        this.$onHeaderParsed = r7;
        this.$musicPlayData = r8;
        this.$onMusicDataParsed = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        AudioStreamPlayer$startSseChunk$2$1 r11 = new AudioStreamPlayer$startSseChunk$2$1(this.$loopIndex, this.$it, this.$curIndex, this.$hasWavHeader, this.$bufferSize, this.$wavHeader, this.$onHeaderParsed, this.$musicPlayData, this.$onMusicDataParsed, r14);
        r11.L$0 = r13;
        return r11;
    }

    public final Object invoke(w r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((w) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        w r2 = (w) this.L$0;
        ResultKt.throwOnFailure(r14);
    L53:
        this.$curIndex.element = r2.a;
        AudioStreamPlayer r15 = AudioStreamPlayer.a;
        if (AudioStreamPlayer.s.e() == false) goto L57;
        FLogger.a.i("AudioStreamPlayer", "the chunk music data： seq_id=" + r2.a + "  size=" + r2.b + " isJson=" + Intrinsics.areEqual(r2.b, "json"));
    L57:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        w r16 = (w) this.L$0;
        AudioStreamPlayer r3 = AudioStreamPlayer.a;
        int r4 = this.$loopIndex;
        BufferedReader r5 = this.$it;
        if (r4 != AudioStreamPlayer.s.b()) goto L11;
        FLogger.a.e("AudioStreamPlayer", "sse auto retry is on limit。finish the auto retry index=" + r4);
    L18:
        byte[] r6 = Base64.decode(r16.c, 2);
        if (r16.a > this.$curIndex.element) goto L22;
        FLogger.a.e("AudioStreamPlayer", "The current audio package is being sent out of order, curIndex=" + this.$curIndex.element + " newIndex=" + r16.a + " chunk pkg type=" + r16.b);
        return Unit.INSTANCE;
    L22:
        boolean r7 = false;
        if (this.$hasWavHeader == true) goto L25;
    L42:
        Ref.ObjectRef<byte[]> r8 = this.$musicPlayData;
        Intrinsics.checkNotNull(r6);
        r8.element = r6;
    L44:
        if (((byte[]) this.$musicPlayData.element).length != 0) goto L46;
        r7 = true;
    L46:
        if (r7 == false) goto L49;
        FLogger.a.w("AudioStreamPlayer", "id=" + r16.a + " event=" + r16.b + " chunk pkg data is empty, exec next task directly!");
        return Unit.INSTANCE;
    L49:
        Function3<Integer, byte[], Continuation<? super Unit>, Object> r9 = this.$onMusicDataParsed;
        Integer r10 = Boxing.boxInt(r16.a);
        Object r11 = this.$musicPlayData.element;
        this.L$0 = r16;
        this.label = 1;
        if (r9.invoke(r10, r11, this) != r0) goto L52;
        return r0;
    L52:
        r2 = r16;
        goto L53
    L25:
        if (this.$bufferSize.element > 0) goto L42;
        Ref.ObjectRef<byte[]> r12 = this.$wavHeader;
        byte[] r13 = (byte[]) r12.element;
        Intrinsics.checkNotNull(r6);
        r12.element = ArraysKt.plus(r13, r6);
        Object r17 = this.$wavHeader.element;
        if (((byte[]) r17).length <= 44) goto L35;
        Function1<byte[], Integer> r19 = this.$onHeaderParsed;
        if (r19 == null) goto L33;
        Ref.IntRef r20 = this.$bufferSize;
        int r21 = ((Number) r19.invoke(ArraysKt.copyOfRange((byte[]) r17, 0, 44))).intValue();
        r20.element = r21;
        if (r21 >= 0) goto L33;
        r20.element = 2000;
        FLogger.a.e("AudioStreamPlayer", "bufferSize too little，so use default 2k");
    L33:
        Ref.ObjectRef<byte[]> r22 = this.$musicPlayData;
        Object r23 = this.$wavHeader.element;
        r22.element = ArraysKt.copyOfRange((byte[]) r23, 44, ((byte[]) r23).length);
        goto L44
    L35:
        if (((byte[]) r17).length != 44) goto L41;
        Function1<byte[], Integer> r24 = this.$onHeaderParsed;
        if (r24 == null) goto L44;
        Ref.IntRef r25 = this.$bufferSize;
        int r26 = ((Number) r24.invoke(ArraysKt.copyOfRange((byte[]) r17, 0, 44))).intValue();
        r25.element = r26;
        if (r26 >= 0) goto L44;
        r25.element = 2000;
        FLogger.a.e("AudioStreamPlayer", "bufferSize is Illegal，so use default 2k");
        goto L44
    L41:
        FLogger.a.i("AudioStreamPlayer", "current data size is little than wav header, wait for next time");
        goto L44
    L11:
        Job r27 = AudioStreamPlayer.A;
        if (r27 == null) goto L14;
        Job.DefaultImpls.cancel$default(r27, null, 1, null);
    L14:
        Job r29 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AudioStreamPlayer$startSseTimeoutTask$1(r4, r5, null), 2, null);
        Job r30 = AudioStreamPlayer.A;
        if (r30 == null) goto L17;
        Job.DefaultImpls.cancel$default(r30, null, 1, null);
    L17:
        AudioStreamPlayer.A = r29;
        goto L18
    }
}
