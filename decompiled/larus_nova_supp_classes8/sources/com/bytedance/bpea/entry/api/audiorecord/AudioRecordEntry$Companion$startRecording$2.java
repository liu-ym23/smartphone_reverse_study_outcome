package com.bytedance.bpea.entry.api.audiorecord;

import android.media.AudioRecord;
import android.media.MediaSyncEvent;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import f06.b;
import f06.c;
import fna.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class AudioRecordEntry$Companion$startRecording$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MediaSyncEvent $syncEvent;
    final /* synthetic */ AudioRecord $this_startRecording;

    public AudioRecordEntry$Companion$startRecording$2(AudioRecord r1, MediaSyncEvent r2) {
        this.$this_startRecording = r1;
        this.$syncEvent = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1556invoke() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_audiorecord_AudioRecordEntry$Companion$startRecording$2_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(this.$this_startRecording, this.$syncEvent);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1556invoke();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_audiorecord_AudioRecordEntry$Companion$startRecording$2_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r1, MediaSyncEvent r2) {
        if (g.d() == true) goto L6;
        a(r1, r2);
        return;
    L6:
        a(r1, r2);
        if ((r1 instanceof AudioRecord) == false) goto L10;
        hna.a.b(r1.hashCode());
        return;
    }

    public static void a(AudioRecord r11, MediaSyncEvent r12) {
        c r8 = new c();
        Object[] r9 = {r12};
        b r10 = new b();
        if (r8.b(100400, "android/media/AudioRecord", "startRecording", r11, r9, "void", r10).a == false) goto L6;
        r8.a(100400, "android/media/AudioRecord", "startRecording", r11, r9, null, r10, false);
        return;
    L6:
        r11.startRecording(r12);
        r8.a(100400, "android/media/AudioRecord", "startRecording", r11, r9, null, r10, true);
    }
}
