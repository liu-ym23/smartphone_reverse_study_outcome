package com.obric.assistant.view.glowui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class AudioAmplitudeProcessor {
    public static final /* synthetic */ int c = 0;
    public final int a;
    public final CopyOnWriteArrayList<Float> b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.glowui.AudioAmplitudeProcessor$update$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.glowui.AudioAmplitudeProcessor$update$2", f = "AudioAmplitudeProcessor.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ArrayList<Double> $sampleData;
        int label;
        final /* synthetic */ AudioAmplitudeProcessor this$0;

        /* JADX INFO: renamed from: com.obric.assistant.view.glowui.AudioAmplitudeProcessor$update$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.view.glowui.AudioAmplitudeProcessor$update$2$1", f = "AudioAmplitudeProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            final /* synthetic */ float $optAmplitude;
            int label;
            final /* synthetic */ AudioAmplitudeProcessor this$0;

            public AnonymousClass1(AudioAmplitudeProcessor r1, float r2, Continuation<? super AnonymousClass1> r3) {
                this.this$0 = r1;
                this.$optAmplitude = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.this$0, this.$optAmplitude, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r3);
                int r4 = this.this$0.b.size();
                AudioAmplitudeProcessor r0 = this.this$0;
                if (r4 < r0.a) goto L8;
                r0.b.remove(0);
            L8:
                return Boxing.boxBoolean(this.this$0.b.add(Boxing.boxFloat(this.$optAmplitude)));
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(ArrayList<Double> r1, AudioAmplitudeProcessor r2, Continuation<? super AnonymousClass2> r3) {
            this.$sampleData = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$sampleData, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L26:
            return r9;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            Iterator<T> r10 = this.$sampleData.iterator();
            if (r10.hasNext() == true) goto L11;
            Double r11 = null;
        L16:
            if (r11 == null) goto L18;
            double r4 = r11.doubleValue();
        L19:
            AudioAmplitudeProcessor r12 = this.this$0;
            int r2 = AudioAmplitudeProcessor.c;
            r12.getClass();
            if (r4 <= 0.5d) goto L22;
            double r5 = 1.0d;
        L23:
            float r13 = RangesKt.coerceAtMost(((float) r5) * 2.5f, 1.0f);
            MainCoroutineDispatcher r3 = Dispatchers.getMain().getImmediate();
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, r13, null);
            this.label = 1;
            r9 = BuildersKt.withContext(r3, r6, this);
            if (r9 != r0) goto L26;
            return r0;
        L22:
            r5 = Math.sin(r4 * 3.141592653589793d);
            goto L23
        L18:
            r4 = 0.0d;
            goto L19
        L11:
            double r7 = Math.abs(((Number) r10.next()).doubleValue());
        L13:
            if (r10.hasNext() == false) goto L15;
            r7 = Math.max(r7, Math.abs(((Number) r10.next()).doubleValue()));
            goto L13
        L15:
            r11 = Boxing.boxDouble(r7);
            goto L16
        }
    }

    static {
    }

    public final float a() {
        Float r0 = CollectionsKt.maxOrNull(this.b);
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
    L6:
        this.b.clear();
        return r1;
    L5:
        r1 = 0.0f;
        goto L6
    }

    public AudioAmplitudeProcessor() {
        this.a = 10;
        this.b = new CopyOnWriteArrayList();
    }

    public final Object update(ArrayList<Double> r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass2(r4, this, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
