package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.bytedance.lark.oggopus_rust_android.OggOpusEncoderInputInfo;
import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordingRemoteAudioSetting;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingAudioProcessor {
    public static final /* synthetic */ int q = 0;
    public final MmRecordingAudioPersistent a;
    public final MmRecordingAudioService b;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a c;
    public final f d;
    public final String e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final ByteBuffer i;
    public long j;
    public long k;
    public int l;
    public final Channel<Object> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor$1", f = "MmRecordingAudioProcessor.kt", i = {2}, l = {66, 68, 72}, m = "invokeSuspend", n = {"item"}, s = {"L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmRecordingAudioProcessor this$0;

        public AnonymousClass1(MmRecordingAudioProcessor r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007a -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0084 -> B:34:0x0099). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0093 -> B:33:0x0096). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            Object r2 = this.L$1;
            ChannelIterator r5 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r14);
            ChannelIterator r15 = r5;
            AnonymousClass1 r6 = this;
        L33:
            Object r12 = r2;
            ChannelIterator r3 = r15;
            Object r16 = r12;
        L34:
            Function0<Unit> r17 = ((b) r16).a;
            if (r17 == null) goto L37;
            r17.invoke();
        L37:
            ChannelIterator r18 = r3;
            AnonymousClass1 r4 = r6;
        L14:
            r4.L$0 = r18;
            r4.L$1 = null;
            r4.label = 1;
            Object r7 = r18.hasNext(r4);
            if (r7 != r0) goto L17;
            return r0;
        L17:
            AnonymousClass1 r13 = r4;
            r3 = r18;
            r14 = r7;
            r6 = r13;
        L19:
            if (((Boolean) r14).booleanValue() == false) goto L39;
            r16 = r3.next();
            if ((r16 instanceof byte[]) == false) goto L26;
            r6.L$0 = r3;
            r6.label = 2;
            int r8 = MmRecordingAudioProcessor.q;
            if (r6.this$0.f((byte[]) r16, false, r6) != r0) goto L37;
            return r0;
        L26:
            if ((r16 instanceof b) == false) goto L37;
            MmRecordingAudioProcessor r9 = r6.this$0;
            if (r9.k <= 0) goto L34;
            r6.L$0 = r3;
            r6.L$1 = r16;
            r6.label = 3;
            if (r9.b(r6) != r0) goto L32;
            return r0;
        L32:
            ChannelIterator r19 = r3;
            r2 = r16;
            r15 = r19;
            goto L33
        L39:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ChannelIterator r10 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r14);
            r18 = r10;
        L13:
            r4 = this;
            goto L14
        L11:
            r3 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r14);
            r6 = this;
            goto L19
        L12:
            ResultKt.throwOnFailure(r14);
            r18 = this.this$0.m.iterator();
            goto L13
        }
    }

    public static final class a {
    }

    public static final class b {
        public final Function0<Unit> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Function0<Unit> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "FlushSignal(callback=" + this.a + ')';
        }

        public b(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final byte[] a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (this.i.position() != 0) goto L6;
        return null;
    L6:
        this.i.flip();     // Catch: Throwable -> L8
        byte[] r2 = new byte[this.i.limit()];     // Catch: Throwable -> L8
        this.i.get(r2);     // Catch: Throwable -> L8
        this.i.clear();     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Throwable r4 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r4 == null) goto L12;
        lvb.a.b(this.e, "drainPcmBuffer: " + r4.getMessage());
    L12:
        return null;
    }

    public final int d() {
        return ((Number) this.n.getValue()).intValue();
    }

    public final int e() {
        return ((Number) this.p.getValue()).intValue();
    }

    public final void c() {
        byte[] r0 = a();
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = this.m.trySend-JP2dKIU(r0);
        g.c r2 = g.b;
        if ((r1 instanceof g.c) == false) goto L15;
        lvb.a.b(this.e, "flushPcmBuffer: failed to send pcmData to channel, size=" + r0.length);
        qvb.a r3 = qvb.a.a;
        Throwable r4 = g.a(r1);
        if (r4 == null) goto L10;
        String r5 = r4.getClass().getSimpleName();
    L11:
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        qvb.a.b(null, "pcm_channel_send_failed", r5, null, 9);
        return;
    L10:
        r5 = null;
        goto L11
    }

    public final Object b(Continuation<? super Unit> r16) {
        if ((r16 instanceof MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1) == false) goto L7;
        MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1 r2 = (MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1) r16;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L64:
        this.k = 0;
        this.l++;
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L54:
        boolean r9 = ((Boolean) r0).booleanValue();
    L57:
        if (r9 == false) goto L64;
        MmRecordingAudioPersistent r1 = this.a;
        int r6 = this.l;
        int r7 = e();
        r2.label = 3;
        Object r8 = BuildersKt.withContext(r1.d, new MmRecordingAudioPersistent$deletePcmFile$2(r1, r6, r7, null), r2);
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        r8 = Unit.INSTANCE;
    L62:
        if (r8 != r4) goto L64;
        return r4;
    L17:
        ResultKt.throwOnFailure(r0);
    L21:
        byte[] r10 = (byte[]) r0;
        lvb.a.e(this.e, "encodeAndSaveCurrentSlice size: " + r10.length);
        r9 = false;
        if (r10.length != 0) goto L24;
        boolean r11 = true;
    L26:
        if ((!r11) == false) goto L56;
        String r12 = "";
        MmRecordingRemoteAudioSetting r13 = this.c.getSettingsService().b;
        String r14 = this.e;
        StringBuilder r15 = new StringBuilder("[audioFormat][sliceEncode] sliceIndex=");
        r15.append(this.l);
        r15.append(", pcmSize=");
        r15.append(r10.length);
        r15.append(", formatId=");
        r15.append(System.identityHashCode(this.d));
        r15.append(", sampleRate=");
        r15.append(this.d.a);
        r15.append(", channelCount=");
        r15.append(this.d.b);
        r15.append(", encodeConfigId=");
        String r17 = (String) this.o.getValue();
        if (r17 != null) goto L30;
        r17 = "default";
    L30:
        r15.append(r17);
        r15.append(", currentSampleRate=");
        r15.append(r13.getMmAudioSampleRate());
        r15.append(", currentChannelCount=");
        r15.append(r13.getMmAudioChannel());
        lvb.a.e(r14, r15.toString());
        f r18 = this.d;     // Catch: Exception -> L33 OutOfMemoryError -> L39
        byte[] r19 = Oggopus_rustKt.encodeDataToOpus(r10, new OggOpusEncoderInputInfo(r18.a, r18.b), (String) this.o.getValue());     // Catch: Exception -> L33 OutOfMemoryError -> L39
    L46:
        if (r19.length != 0) goto L48;
        boolean r20 = true;
    L50:
        if ((!r20) == false) goto L55;
        int r21 = this.l;
        int r22 = e();
        r2.label = 2;
        r0 = g(r19, r21, r22, r2);
        if (r0 != r4) goto L54;
        return r4;
    L55:
        lvb.a.b(this.e, "encodeAndSaveCurrentSlice failed, keep pcm file, sliceIndex:" + this.l);
        goto L57
    L48:
        r20 = false;
    L33:
        e = move-exception;
        lvb.a.b(this.e, "encodePcmToOgg failed: " + e);
        qvb.a r23 = qvb.a.a;
        String r24 = e.getMessage();
        if (r24 == null) goto L38;
        r12 = r24;
    L38:
        qvb.a.b(null, "encode_pcm_to_ogg_failed:".concat(r12), e.getClass().getSimpleName(), null, 9);
        r19 = new byte[0];
    L39:
        e = move-exception;
        lvb.a.b(this.e, "encodePcmToOgg oom, pcmSize:" + r10.length + ", sampleRate:" + this.d.a + ", channel:" + this.d.b);
        qvb.a r25 = qvb.a.a;
        String r26 = e.getMessage();
        if (r26 == null) goto L44;
        r12 = r26;
    L44:
        qvb.a.b(null, "encode_pcm_to_ogg_oom:".concat(r12), e.getClass().getSimpleName(), null, 9);
        r19 = new byte[0];
        goto L46
    L56:
        lvb.a.h(this.e, "encodeAndSaveCurrentSlice, pcmData is empty, sliceIndex:" + this.l);
        r9 = true;
        goto L57
    L24:
        r11 = false;
        goto L26
    L18:
        ResultKt.throwOnFailure(r0);
        MmRecordingAudioPersistent r27 = this.a;
        int r28 = this.l;
        int r29 = e();
        r2.label = 1;
        r0 = BuildersKt.withContext(r27.d, new MmRecordingAudioPersistent$readPcmFile$2(r27, r28, r29, null), r2);
        if (r0 != r4) goto L21;
        return r4;
    L7:
        r2 = new MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1(this, r16);
        goto L8
    }

    public final Object f(byte[] r17, boolean r18, Continuation<? super Unit> r19) {
        byte[] r1 = r17;
        if ((r19 instanceof MmRecordingAudioProcessor$processPcmDataChunk$1) == false) goto L7;
        MmRecordingAudioProcessor$processPcmDataChunk$1 r3 = (MmRecordingAudioProcessor$processPcmDataChunk$1) r19;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r9 = true;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        ResultKt.throwOnFailure(r2);
    L47:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r7 = r3.Z$0;
        byte[] r8 = (byte[]) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L37:
        this.k += (long) r8.length;
        lvb.a.e(this.e, "processPcmDataChunk currentSliceAccumulatedBytes: " + this.k);
        if (this.k >= (((long) e()) * ((long) d()))) goto L43;
        if (r7 == true) goto L43;
        return Unit.INSTANCE;
    L43:
        r3.L$0 = null;
        r3.label = 3;
        if (b(r3) != r5) goto L47;
        return r5;
    L17:
        boolean r10 = r3.Z$0;
        byte[] r11 = (byte[]) r3.L$0;
        ResultKt.throwOnFailure(r2);
        boolean r12 = r10;
        r1 = r11;
    L30:
        MmRecordingAudioPersistent r13 = this.a;
        int r14 = this.l;
        int r15 = e();
        r3.L$0 = r1;
        r3.Z$0 = r12;
        r3.label = 2;
        Object r16 = BuildersKt.withContext(r13.d, new MmRecordingAudioPersistent$appendPcmToFile$2(r13, r14, r15, r1, null), r3);
        if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        r16 = Unit.INSTANCE;
    L34:
        if (r16 != r5) goto L36;
        return r5;
    L36:
        boolean r110 = r12;
        r8 = r1;
        r7 = r110;
        goto L37
    L18:
        ResultKt.throwOnFailure(r2);
        MmRecordingAudioPersistent r20 = this.a;
        r3.L$0 = r1;
        r12 = r18;
        r3.Z$0 = r12;
        r3.label = 1;
        r20.getClass();
        if (r1.length == 0) goto L22;
        r9 = false;
    L22:
        if (r9 == false) goto L24;
        Object r21 = Unit.INSTANCE;
    L28:
        if (r21 != r5) goto L30;
        return r5;
    L24:
        r21 = BuildersKt.withContext(r20.d, new MmRecordingAudioPersistent$appendPcmToFullFile$2(r20, r1, null), r3);
        if (r21 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        r21 = Unit.INSTANCE;
    L7:
        r3 = new MmRecordingAudioProcessor$processPcmDataChunk$1(this, r19);
        goto L8
    }

    public MmRecordingAudioProcessor(MmRecordingAudioPersistent r7, MmRecordingAudioService r8, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r9, f r10) {
        Intrinsics.checkNotNullParameter(r7, "filePersistent");
        Intrinsics.checkNotNullParameter(r8, "audioService");
        Intrinsics.checkNotNullParameter(r9, "userComponentContext");
        Intrinsics.checkNotNullParameter(r10, "audioFormat");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = "MmRecordingAudioProcessor";
        this.f = LazyKt.lazy(MmRecordingAudioProcessor$captureScope$2.INSTANCE);
        this.g = LazyKt.lazy(MmRecordingAudioProcessor$encodeDispatcher$2.INSTANCE);
        Lazy r11 = LazyKt.lazy(new MmRecordingAudioProcessor$encodeScope$2(this));
        this.h = r11;
        this.i = ByteBuffer.allocateDirect(98304);
        this.l = 1;
        this.m = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default((CoroutineScope) r11.getValue(), null, null, new AnonymousClass1(this, null), 3, null);
        this.n = LazyKt.lazy(new MmRecordingAudioProcessor$audioBytesPerSecond$2(this));
        this.o = LazyKt.lazy(new MmRecordingAudioProcessor$encodeConfigId$2(this));
        this.p = LazyKt.lazy(new MmRecordingAudioProcessor$sliceDurationInSec$2(this));
    }

    public final Object g(byte[] r11, int r12, int r13, Continuation<? super Boolean> r14) {
        if ((r14 instanceof MmRecordingAudioProcessor$saveOggFile$1) == false) goto L7;
        MmRecordingAudioProcessor$saveOggFile$1 r0 = (MmRecordingAudioProcessor$saveOggFile$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r13 = r0.I$1;
        r12 = r0.I$0;
        r11 = (byte[]) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Object r16 = ((Result) r15).unbox-impl();
    L17:
        String r4 = "";
        if (Result.isSuccess-impl(r16) == false) goto L25;
        ovb.a r5 = (ovb.a) r16;
        Object r6 = this.b.j.trySend-JP2dKIU(r5);
        String r7 = this.e;
        StringBuilder r8 = new StringBuilder("saveOggFile success, sliceIndex:");
        r8.append(r12);
        r8.append(", durationSec:");
        r8.append(r13);
        r8.append(", oggSize:");
        r8.append(r11.length);
        r8.append(", filePath:");
        r8.append(r5.a);
        r8.append(", metaEnqueueSuccess:");
        g.c r17 = g.b;
        r8.append(!(r6 instanceof g.c));
        lvb.a.e(r7, r8.toString());
        Throwable r18 = g.a(r6);
        if (r18 == null) goto L25;
        lvb.a.b(this.e, "saveOggFile meta enqueue failed, sliceIndex:" + r12 + ", error:" + r18);
        qvb.a r19 = qvb.a.a;
        String r110 = r18.getMessage();
        if (r110 != null) goto L24;
        r110 = "";
    L24:
        qvb.a.b(null, "meta_enqueue_failed:".concat(r110), r18.getClass().getSimpleName(), null, 9);
    L25:
        Throwable r111 = Result.exceptionOrNull-impl(r16);
        if (r111 == null) goto L33;
        lvb.a.b(this.e, "saveOggFile failed, sliceIndex:" + r12 + ", error:" + r111);
        qvb.a r112 = qvb.a.a;
        String r113 = r111.getMessage();
        if (r113 == null) goto L31;
        r4 = r113;
    L31:
        qvb.a.b(null, "save_ogg_failed:".concat(r4), r111.getClass().getSimpleName(), null, 9);
    L33:
        return Boxing.boxBoolean(Result.isSuccess-impl(r16));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        MmRecordingAudioPersistent r114 = this.a;
        r0.L$0 = r11;
        r0.I$0 = r12;
        r0.I$1 = r13;
        r0.label = 1;
        r16 = r114.d(r11, r12, r13, r0);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new MmRecordingAudioProcessor$saveOggFile$1(this, r14);
        goto L8
    }
}
