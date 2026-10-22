package com.larus.audio.utils;

import android.os.SystemClock;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.SoundsSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.utils.SoundsMobHelper$reportVolumeChange$1", f = "SoundsMobHelper.kt", i = {0, 0, 0, 0, 0, 0}, l = {302}, m = "invokeSuspend", n = {"readingSceneLast", "readingIdLast", "curPlayingScene", "curPlayingId", "botId", "duration"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
final class SoundsMobHelper$reportVolumeChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $isFirstPlay;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public SoundsMobHelper$reportVolumeChange$1(int r1, Continuation<? super SoundsMobHelper$reportVolumeChange$1> r2) {
        this.$isFirstPlay = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SoundsMobHelper$reportVolumeChange$1(this.$isFirstPlay, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        long r3 = this.J$0;
        String r4 = (String) this.L$4;
        String r5 = (String) this.L$3;
        String r6 = (String) this.L$2;
        String r7 = (String) this.L$1;
        SoundsSource r8 = (SoundsSource) this.L$0;
        ResultKt.throwOnFailure(r22);
        long r19 = r3;
        String r20 = r4;
        String r17 = r5;
        String r16 = r6;
        String r14 = r7;
        SoundsSource r13 = r8;
    L16:
        int r11 = SoundsMobHelper.i();
        int r10 = SoundsMobHelper.l;
        if (r10 <= 0) goto L19;
        SoundsMobHelper.j(r10, r11, "adjust_the_volume_general", r13, r14, this.$isFirstPlay, r16, r17, r19, r20);
    L19:
        SoundsMobHelper.n = null;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        SoundsSource r9 = SoundsMobHelper.i;
        String r12 = SoundsMobHelper.j;
        String r15 = SoundsMobHelper.h.getKeyStr();
        String r21 = SoundsMobHelper.k;
        if (SoundsMobHelper.s <= 0) goto L11;
        long r23 = SystemClock.elapsedRealtime() - SoundsMobHelper.s;
    L12:
        SoundsMobHelper r24 = SoundsMobHelper.a;
        String r25 = SoundsMobHelper.m();
        this.L$0 = r9;
        this.L$1 = r12;
        this.L$2 = r15;
        this.L$3 = r21;
        this.L$4 = r25;
        this.J$0 = r23;
        this.label = 1;
        if (DelayKt.delay(5000, this) != r1) goto L15;
        return r1;
    L15:
        r20 = r25;
        r17 = r21;
        r16 = r15;
        r14 = r12;
        r13 = r9;
        r19 = r23;
        goto L16
    L11:
        r23 = -1;
        goto L12
    }
}
