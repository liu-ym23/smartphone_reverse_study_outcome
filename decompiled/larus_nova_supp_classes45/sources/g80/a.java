package g80;

import android.media.AudioRecord;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    static {
    }

    public static void a(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r11 = new f06.b();
        if (r8.b(100400, "android/media/AudioRecord", "startRecording", r12, r9, "void", r11).a == false) goto L6;
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r11, false);
        return;
    L6:
        r12.startRecording();
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r11, true);
    }

    public static void b(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r11 = new f06.b();
        if (r8.b(100401, "android/media/AudioRecord", NewBroadcastMonitor.STAGE.STOP, r12, r9, "void", r11).a == false) goto L6;
        r8.a(100401, "android/media/AudioRecord", NewBroadcastMonitor.STAGE.STOP, r12, r9, null, r11, false);
        return;
    L6:
        r12.stop();
        r8.a(100401, "android/media/AudioRecord", NewBroadcastMonitor.STAGE.STOP, r12, r9, null, r11, true);
    }

    @JvmStatic
    public static final void c(AudioRecord r11, TokenCert r12) throws BPEAException {
        Intrinsics.checkNotNullParameter(r11, "audioRecord");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L5;
        com.bytedance.bpea.entry.api.audiorecord.a.a.getClass();
        com.bytedance.bpea.entry.api.audiorecord.a.a.b(r11, r12);
        return;
    L5:
        f06.c r13 = new f06.c();
        Object[] r0 = new Object[0];
        f06.b r9 = new f06.b();
        if (r13.b(100403, "android/media/AudioRecord", "release", r11, r0, "void", r9).a == false) goto L8;
        r13.a(100403, "android/media/AudioRecord", "release", r11, r0, null, r9, false);
        return;
    L8:
        r11.release();
        r13.a(100403, "android/media/AudioRecord", "release", r11, r0, null, r9, true);
    }

    @JvmStatic
    public static final void d(AudioRecord r1, TokenCert r2) throws BPEAException, IllegalStateException {
        Intrinsics.checkNotNullParameter(r1, "audioRecord");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        com.bytedance.bpea.entry.api.audiorecord.a.a.getClass();
        com.bytedance.bpea.entry.api.audiorecord.a.a.c(r1, r2);
        return;
    L6:
        if (fna.g.d() == true) goto L8;
        a(r1);
        return;
    L8:
        a(r1);
        hna.a.b(r1.hashCode());
    }

    @JvmStatic
    public static final void e(AudioRecord r1, TokenCert r2) throws BPEAException, IllegalStateException {
        Intrinsics.checkNotNullParameter(r1, "audioRecord");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        com.bytedance.bpea.entry.api.audiorecord.a.a.getClass();
        com.bytedance.bpea.entry.api.audiorecord.a.a.d(r1, r2);
        return;
    L6:
        if (fna.g.d() == true) goto L8;
        b(r1);
        return;
    L8:
        b(r1);
        hna.a.c(r1.hashCode());
    }
}
