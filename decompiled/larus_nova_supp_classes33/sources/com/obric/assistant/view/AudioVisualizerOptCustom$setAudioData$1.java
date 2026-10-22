package com.obric.assistant.view;

import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.view.AudioVisualizerOptCustom$setAudioData$1", f = "AudioVisualizerOptCustom.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, s = {})
final class AudioVisualizerOptCustom$setAudioData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean $onLongPress;
    final /* synthetic */ ArrayList<Double> $sampleData;
    int label;
    final /* synthetic */ AudioVisualizerOptCustom this$0;

    /* JADX INFO: renamed from: com.obric.assistant.view.AudioVisualizerOptCustom$setAudioData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.AudioVisualizerOptCustom$setAudioData$1$1", f = "AudioVisualizerOptCustom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $maxAmplitude;
        int label;
        final /* synthetic */ AudioVisualizerOptCustom this$0;

        public AnonymousClass1(AudioVisualizerOptCustom r1, double r2, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$maxAmplitude = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$maxAmplitude, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r6);
            AudioVisualizerOptCustom r7 = this.this$0;
            double r0 = this.$maxAmplitude;
            int r2 = AudioVisualizerOptCustom.p;
            r7.getClass();
            if (r0 <= 0.5d) goto L7;
            double r1 = 1.0d;
        L9:
            if (ObricFeatureServiceDelegate.b.a() == false) goto L11;
            float r3 = 10.0f;
        L12:
            AudioVisualizerOptCustom.b(r7, RangesKt.coerceAtMost(((float) r1) * r3, 1.0f));
            return Unit.INSTANCE;
        L11:
            r3 = 2.5f;
            goto L12
        L7:
            r1 = Math.sin(r0 * 3.141592653589793d);
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AudioVisualizerOptCustom$setAudioData$1(AudioVisualizerOptCustom r1, Boolean r2, ArrayList<Double> r3, Continuation<? super AudioVisualizerOptCustom$setAudioData$1> r4) {
        this.this$0 = r1;
        this.$onLongPress = r2;
        this.$sampleData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AudioVisualizerOptCustom$setAudioData$1(this.this$0, this.$onLongPress, this.$sampleData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        AudioVisualizerOptCustom r10 = this.this$0;
        Boolean r2 = this.$onLongPress;
        if (r2 == null) goto L11;
        boolean r3 = r2.booleanValue();
    L12:
        r10.o = r3;
        Iterator<T> r11 = this.$sampleData.iterator();
        if (r11.hasNext() == true) goto L15;
        Double r12 = null;
    L20:
        if (r12 == null) goto L22;
        double r4 = r12.doubleValue();
    L23:
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r5 = new AnonymousClass1(this.this$0, r4, null);
        this.label = 1;
        if (BuildersKt.withContext(r13, r5, this) != r0) goto L27;
        return r0;
    L22:
        r4 = 0.0d;
        goto L23
    L15:
        double r6 = Math.abs(((Number) r11.next()).doubleValue());
    L17:
        if (r11.hasNext() == false) goto L19;
        r6 = Math.max(r6, Math.abs(((Number) r11.next()).doubleValue()));
        goto L17
    L19:
        r12 = Boxing.boxDouble(r6);
        goto L20
    L11:
        r3 = r10.o;
        goto L12
    }
}
