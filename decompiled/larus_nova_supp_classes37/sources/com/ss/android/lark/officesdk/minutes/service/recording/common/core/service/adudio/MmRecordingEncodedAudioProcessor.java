package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingEncodedAudioProcessor {
    public final MmRecordingAudioService a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public final Lazy d;
    public final Lazy e;
    public final Channel<Object> f;
    public int g;
    public long h;
    public long i;
    public final Lazy j;
    public final Lazy k;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingEncodedAudioProcessor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingEncodedAudioProcessor$1", f = "MmRecordingEncodedAudioProcessor.kt", i = {2}, l = {BaseField.FIELD_TYPE_C_DESCRIPTION, 53, 56}, m = "invokeSuspend", n = {"item"}, s = {"L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmRecordingEncodedAudioProcessor this$0;

        public AnonymousClass1(MmRecordingEncodedAudioProcessor r1, Continuation<? super AnonymousClass1> r2) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0073 -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0078 -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:34:0x0099). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0091 -> B:33:0x0095). Please report as a decompilation issue!!! */
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
            AnonymousClass1 r15 = this;
        L33:
            Object r12 = r0;
            AnonymousClass1 r3 = r15;
            Object r16 = r2;
            Object r4 = r12;
        L34:
            Function0<Unit> r17 = ((a) r16).a;
            if (r17 == null) goto L37;
            r17.invoke();
        L37:
            AnonymousClass1 r18 = r3;
            r0 = r4;
            ChannelIterator r6 = r5;
        L14:
            r18.L$0 = r6;
            r18.L$1 = null;
            r18.label = 1;
            Object r7 = r6.hasNext(r18);
            if (r7 != r0) goto L17;
            return r0;
        L17:
            Object r13 = r0;
            r3 = r18;
            r14 = r7;
            r5 = r6;
            r4 = r13;
        L19:
            if (((Boolean) r14).booleanValue() == false) goto L39;
            r16 = r5.next();
            if ((r16 instanceof sub.a) == false) goto L26;
            r3.L$0 = r5;
            r3.label = 2;
            if (MmRecordingEncodedAudioProcessor.a(r3.this$0, (sub.a) r16, r3) != r4) goto L37;
            return r4;
        L26:
            if ((r16 instanceof a) == false) goto L37;
            MmRecordingEncodedAudioProcessor r8 = r3.this$0;
            if (r8.h <= 0) goto L34;
            r3.L$0 = r5;
            r3.L$1 = r16;
            r3.label = 3;
            if (r8.b(r3) != r4) goto L32;
            return r4;
        L32:
            Object r19 = r4;
            r2 = r16;
            r15 = r3;
            r0 = r19;
            goto L33
        L39:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r6 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r14);
        L13:
            r18 = this;
            goto L14
        L11:
            ChannelIterator r9 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r14);
            r5 = r9;
            r4 = r0;
            r3 = this;
            goto L19
        L12:
            ResultKt.throwOnFailure(r14);
            r6 = this.this$0.f.iterator();
            goto L13
        }
    }

    public static final class a {
        public final Function0<Unit> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
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

        public a(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public final Unit b(Continuation r17) {
        if ((r17 instanceof MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1) == false) goto L7;
        MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1 r2 = (MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1) r17;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L30;
        if (r4 != 1) goto L29;
        long r9 = r2.J$0;
        int r5 = r2.I$0;
        ResultKt.throwOnFailure(r1);
        Object r6 = ((Result) r1).unbox-impl();
        String r11 = "";
        if (Result.isSuccess-impl(r6) == false) goto L19;
        ovb.a r7 = (ovb.a) r6;
        Object r13 = this.a.j.trySend-JP2dKIU(r7);
        String r14 = this.c;
        StringBuilder r15 = new StringBuilder("muxAndSaveCurrentSlice success, sliceIndex:");
        r15.append(r5);
        r15.append(", durationMs:");
        r15.append(r9);
        r15.append(", filePath:");
        r15.append(r7.a);
        r15.append(", metaEnqueueSuccess:");
        g.c r8 = g.b;
        r15.append(!(r13 instanceof g.c));
        lvb.a.e(r14, r15.toString());
        Throwable r10 = g.a(r13);
        if (r10 == null) goto L19;
        lvb.a.b(this.c, "muxAndSaveCurrentSlice meta enqueue failed, sliceIndex:" + r5 + ", error:" + r10);
        qvb.a r12 = qvb.a.a;
        String r16 = r10.getMessage();
        if (r16 != null) goto L18;
        r16 = "";
    L18:
        qvb.a.b(null, "encoded_meta_enqueue_failed:".concat(r16), r10.getClass().getSimpleName(), null, 9);
    L19:
        Throwable r18 = Result.exceptionOrNull-impl(r6);
        if (r18 == null) goto L26;
        lvb.a.b(this.c, "muxAndSaveCurrentSlice failed, sliceIndex:" + r5 + ", error:" + r18);
        qvb.a r19 = qvb.a.a;
        String r20 = r18.getMessage();
        if (r20 == null) goto L25;
        r11 = r20;
    L25:
        qvb.a.b(null, "encoded_ogg_mux_failed:".concat(r11), r18.getClass().getSimpleName(), null, 9);
    L26:
        this.h = 0;
        this.g++;
        return Unit.INSTANCE;
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L30:
        ResultKt.throwOnFailure(r1);
        int r21 = this.g;
        lvb.a.b(this.c, "muxAndSaveCurrentSlice failed, raw opus options is null, sliceIndex:" + r21);
        qvb.a.b(null, "encoded_ogg_mux_failed:raw_opus_options_null", "IllegalStateException", null, 9);
        this.h = 0;
        this.g++;
        return Unit.INSTANCE;
    L7:
        r2 = new MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1(this, r17);
        goto L8
    }

    public MmRecordingEncodedAudioProcessor(MmRecordingAudioPersistent r7, MmRecordingAudioService r8, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r9) {
        Intrinsics.checkNotNullParameter(r7, "filePersistent");
        Intrinsics.checkNotNullParameter(r8, "audioService");
        Intrinsics.checkNotNullParameter(r9, "userComponentContext");
        this.a = r8;
        this.b = r9;
        this.c = "MmRecordingEncodedAudioProcessor";
        this.d = LazyKt.lazy(MmRecordingEncodedAudioProcessor$encodeDispatcher$2.INSTANCE);
        Lazy r10 = LazyKt.lazy(new MmRecordingEncodedAudioProcessor$encodeScope$2(this));
        this.e = r10;
        this.f = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.g = 1;
        this.j = LazyKt.lazy(new MmRecordingEncodedAudioProcessor$sliceDurationInSec$2(this));
        this.k = LazyKt.lazy(new MmRecordingEncodedAudioProcessor$targetSliceDurationMs$2(this));
        BuildersKt.launch$default((CoroutineScope) r10.getValue(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final Object a(MmRecordingEncodedAudioProcessor r8, sub.a r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof MmRecordingEncodedAudioProcessor$processEncodedFrame$1) == false) goto L7;
        MmRecordingEncodedAudioProcessor$processEncodedFrame$1 r0 = (MmRecordingEncodedAudioProcessor$processEncodedFrame$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 != 0) goto L11;
        ResultKt.throwOnFailure(r11);
        r9.getClass();
        RangesKt.coerceAtLeast(0, 1);
        throw null;
    L11:
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        ResultKt.throwOnFailure(r11);
    L22:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        sub.a r4 = (sub.a) r0.L$0;
        ResultKt.throwOnFailure(r11);
        long r6 = r8.h;
        r4.getClass();
        long r7 = r6 + ((long) RangesKt.coerceAtLeast(0, 1));
        r8.h = r7;
        if (r7 < ((Number) r8.k.getValue()).longValue()) goto L22;
        r0.L$0 = null;
        r0.label = 2;
        if (r8.b(r0) != r2) goto L22;
        return r2;
    L7:
        r0 = new MmRecordingEncodedAudioProcessor$processEncodedFrame$1(r8, r10);
        goto L8
    }
}
