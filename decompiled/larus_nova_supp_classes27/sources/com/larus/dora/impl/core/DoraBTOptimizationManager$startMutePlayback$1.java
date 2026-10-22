package com.larus.dora.impl.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import fna.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraBTOptimizationManager$startMutePlayback$1", f = "DoraBTOptimizationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraBTOptimizationManager$startMutePlayback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoraBTOptimizationManager$startMutePlayback$1(Continuation<? super DoraBTOptimizationManager$startMutePlayback$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraBTOptimizationManager$startMutePlayback$1 r0 = new DoraBTOptimizationManager$startMutePlayback$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_core_DoraBTOptimizationManager$startMutePlayback$1_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r1) {
        if (g.d() == true) goto L6;
        r1.play();
        return;
    L6:
        r1.play();
        gna.a.c(r1.hashCode());
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_core_DoraBTOptimizationManager$startMutePlayback$1_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(AudioTrack r1) {
        if (g.d() == true) goto L6;
        r1.stop();
        return;
    L6:
        r1.stop();
        gna.a.a(r1.hashCode());
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L50;
        ResultKt.throwOnFailure(r18);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        AudioTrack r7 = null;
        int r15 = AudioTrack.getMinBufferSize(44100, 4, 2);     // Catch: Throwable -> L25
        if (r15 > 0) goto L11;
        g49.d.b("DoraBTOptimizationManager", "startMutePlayback: invalid minBufferSize=" + r15);     // Catch: Throwable -> L25
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L25
        g49.d.d("DoraBTOptimizationManager", "release local AudioTrack");
        return r0;
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r7 = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setAudioFormat(new AudioFormat.Builder().setSampleRate(44100).setEncoding(2).setChannelMask(4).build()).setBufferSizeInBytes(r15).setTransferMode(1).build();     // Catch: Throwable -> L25
    L14:
        INVOKEVIRTUAL_com_larus_dora_impl_core_DoraBTOptimizationManager$startMutePlayback$1_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(r7);     // Catch: Throwable -> L25
        g49.d.d("DoraBTOptimizationManager", "MuteAudioTrack started");     // Catch: Throwable -> L25
        DoraBTOptimizationManager r1 = DoraBTOptimizationManager.a;     // Catch: Throwable -> L25
        DoraBTOptimizationManager.j();     // Catch: Throwable -> L25
        byte[] r2 = new byte[r15];     // Catch: Throwable -> L25
    L16:
        if (CoroutineScopeKt.isActive(r5) == false) goto L19;
        r7.write(r2, 0, r15);     // Catch: Throwable -> L25
        goto L16
    L19:
        g49.d.d("DoraBTOptimizationManager", "release local AudioTrack");
        if (r7 == null) goto L22;
        INVOKEVIRTUAL_com_larus_dora_impl_core_DoraBTOptimizationManager$startMutePlayback$1_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(r7);     // Catch: Exception -> L31
    L22:
        if (r7 == null) goto L37;
    L23:
        r7.release();     // Catch: Exception -> L31
    L37:
        return Unit.INSTANCE;
    L13:
        r7 = new AudioTrack(3, 44100, 4, 2, r15, 1);     // Catch: Throwable -> L25
    L31:
        e = move-exception;
        g49.d.c("DoraBTOptimizationManager", "release local AudioTrack error", e);
    L25:
        th = move-exception;
        g49.d.c("DoraBTOptimizationManager", "startMutePlayback error", th);     // Catch: Throwable -> L38
        g49.d.d("DoraBTOptimizationManager", "release local AudioTrack");
        if (0 == 0) goto L33;
        INVOKEVIRTUAL_com_larus_dora_impl_core_DoraBTOptimizationManager$startMutePlayback$1_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(null);     // Catch: Exception -> L31
    L33:
        if (0 == 0) goto L37;
    L38:
        th = move-exception;
        g49.d.d("DoraBTOptimizationManager", "release local AudioTrack");
        if (0 != 0) goto L54;
    L44:
        if (0 == 0) goto L57;
        r7.release();     // Catch: Exception -> L42
        throw th;
    L42:
        e = move-exception;
        g49.d.c("DoraBTOptimizationManager", "release local AudioTrack error", e);
        throw th;
    L57:
        throw th;
    L54:
        INVOKEVIRTUAL_com_larus_dora_impl_core_DoraBTOptimizationManager$startMutePlayback$1_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(null);     // Catch: Exception -> L42
        goto L44
    L50:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
