package com.obric.audio.enroll.recorder;

import android.media.AudioRecord;
import f06.c;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$startRecording$2", f = "VoicePrintEnrollRecordingsMgr.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoicePrintEnrollRecordingsMgr$startRecording$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoicePrintEnrollRecordingsMgr this$0;

    public VoicePrintEnrollRecordingsMgr$startRecording$2(VoicePrintEnrollRecordingsMgr r1, Continuation<? super VoicePrintEnrollRecordingsMgr$startRecording$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoicePrintEnrollRecordingsMgr$startRecording$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_obric_audio_enroll_recorder_VoicePrintEnrollRecordingsMgr$startRecording$2_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(AudioRecord r1) {
        if (g.d() == true) goto L6;
        c(r1);
        return;
    L6:
        c(r1);
        if ((r1 instanceof AudioRecord) == false) goto L10;
        hna.a.c(r1.hashCode());
        return;
    }

    public static void a(AudioRecord r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100403, "android/media/AudioRecord", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, true);
    }

    public static void c(AudioRecord r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100401, "android/media/AudioRecord", "stop", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, false);
        return;
    L6:
        r12.stop();
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, true);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        VoicePrintEnrollRecordingsMgr r4 = this.this$0;
        AudioRecord r0 = r4.d;
        if (r0 == null) goto L12;
        INVOKEVIRTUAL_com_obric_audio_enroll_recorder_VoicePrintEnrollRecordingsMgr$startRecording$2_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(r0);     // Catch: IllegalStateException -> L9
        a(r0);     // Catch: IllegalStateException -> L9
        r4.d = null;     // Catch: IllegalStateException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        r4.d = null;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
