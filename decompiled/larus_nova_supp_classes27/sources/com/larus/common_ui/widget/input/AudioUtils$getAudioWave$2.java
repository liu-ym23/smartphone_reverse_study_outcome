package com.larus.common_ui.widget.input;

import com.larus.platform.service.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common_ui.widget.input.AudioUtils$getAudioWave$2", f = "AudioUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioUtils$getAudioWave$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Double>>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ int $density;
    final /* synthetic */ int $recordChannel;
    int label;

    public AudioUtils$getAudioWave$2(byte[] r1, int r2, int r3, Continuation<? super AudioUtils$getAudioWave$2> r4) {
        this.$bytes = r1;
        this.$recordChannel = r2;
        this.$density = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AudioUtils$getAudioWave$2(this.$bytes, this.$recordChannel, this.$density, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ArrayList<Double>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r15);
        int r16 = a.a;
        byte[] r17 = this.$bytes;
        int r0 = this.$recordChannel;
        int r1 = this.$density;
        ArrayList r2 = new ArrayList();
        int r3 = r17.length;
        if (r0 != 12) goto L7;
        int r6 = 4;
    L8:
        int r4 = r3 / r6;
        int r7 = 0;
    L10:
        if (r7 >= r4) goto L17;
        if ((r7 % 2) != 0) goto L16;
        r2.add(new BigDecimal(r17[r7] | (r17[r7 + 1] << 8)).divide(new BigDecimal(32768), 3, RoundingMode.HALF_UP));
        if (r0 != 12) goto L16;
        r2.add(new BigDecimal((r17[r7 + 2] << 16) | (r17[r7 + 3] << 24)).divide(new BigDecimal(32768), 6, RoundingMode.HALF_UP));
    L16:
        r7 = r7 + 1;
        goto L10
    L17:
        BigDecimal r18 = new BigDecimal(0.0d);
        ArrayList r5 = new ArrayList();
        int r8 = Math.max(r2.size() / r1, 2);
        Iterator r9 = r2.iterator();
    L18:
        int r10 = 0;
    L20:
        if (r9.hasNext() == false) goto L33;
        BigDecimal r11 = (BigDecimal) r9.next();
        if (r10 >= (r8 - 1)) goto L24;
        r18 = r18.add(r11.abs());
        r10 = r10 + 1;
        goto L20
    L24:
        double r12 = r18.doubleValue();
        BigDecimal r13 = new BigDecimal(r10);     // Catch: ArithmeticException -> L29
        if (r13.compareTo(BigDecimal.ZERO) == 0) goto L31;
        r12 = r18.divide(r13, 6, RoundingMode.HALF_UP).doubleValue();     // Catch: ArithmeticException -> L29
    L31:
        r5.add(Double.valueOf(r12));
        r18 = new BigDecimal(0.0d);
        r5.size();
    L29:
        e = move-exception;
        g.a.ensureNotReachHere(e);
    L33:
        if (r5.size() >= r1) goto L35;
        r5.add(Double.valueOf(0.0d));
        goto L33
    L35:
        return r5;
    L7:
        r6 = 2;
        goto L8
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
