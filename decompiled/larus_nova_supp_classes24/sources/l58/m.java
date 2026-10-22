package l58;

import android.media.AudioRecord;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.audio.asr.sami.quality.AudioRecorderStatus;
import com.larus.audio.g1;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICoreVopAudioChecker;
import com.mammon.audiosdk.enums.SAMICoreVopAudioCheckerResult;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerAudioMetricParameter;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerConfig;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m implements g1 {
    public static final m a = null;
    public static boolean b;
    public static volatile AudioRecord c;
    public static volatile p78.a d;
    public static volatile SAMICoreVopAudioChecker e;
    public static volatile SAMICoreVopAudioCheckerConfig f;
    public static final ByteArrayOutputStream g = null;
    public static volatile AudioRecorderStatus h;
    public static volatile SAMICoreVopAudioCheckerAudioMetricParameter i;
    public static final AtomicBoolean j = null;
    public static final AtomicBoolean k = null;
    public static final f2a.d l = null;
    public static final b m = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SAMICoreVopAudioCheckerResult.values().length];
            r0[SAMICoreVopAudioCheckerResult.INTERNAL_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[SAMICoreVopAudioCheckerResult.NETWORK_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[SAMICoreVopAudioCheckerResult.PASSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[SAMICoreVopAudioCheckerResult.SNR_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[SAMICoreVopAudioCheckerResult.WER_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class b extends q78.f {
        public b() {
        }

        @Override // q78.f
        public final void a(final List<q78.c> r6) {
            Intrinsics.checkNotNullParameter(r6, "configs");
            AudioRecord r0 = m.c;
            Object r1 = null;
            if (r0 == null) goto L5;
            final Integer r2 = Integer.valueOf(r0.getAudioSessionId());
        L6:
            f2a.c r3 = m.l.b("recording config changed");
            r3.e(new n(r6, r2));
            r3.c.b = CollectionsKt.listOf("VoiceCreate");
            f2a.c.c(r3, null, 15);
            if (r2 == null) goto L26;
            Iterator<T> r7 = r6.iterator();
        L10:
            if (r7.hasNext() == false) goto L17;
            Object r4 = r7.next();
            if (((q78.c) r4).b != r2.intValue()) goto L14;
            boolean r5 = true;
        L15:
            if (r5 == false) goto L10;
            r1 = r4;
            goto L17
        L14:
            r5 = false;
        L17:
            q78.c r8 = (q78.c) r1;
            if (r8 == null) goto L27;
            FLogger r9 = FLogger.a;
            m r10 = m.a;
            r9.i("VoiceQualityChecker", "[VoiceQualityChecker]onRecordingConfigChanged isClientSilenced :" + r8.d);
            m.k.set(r8.d);
            return;
        L27:
            return;
        L26:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public m() {
    }

    public final synchronized AudioRecord g() {
        monitor-enter(this);
        AudioRecord r6 = new AudioRecord(ObricAsrDelegate.b.f(), 24000, 16, 2, AudioRecord.getMinBufferSize(24000, 16, 2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        a = new m();
        g = new ByteArrayOutputStream();
        h = AudioRecorderStatus.STATE_IDLE;
        j = new AtomicBoolean(false);
        k = new AtomicBoolean(false);
        l = new f2a.d("Voice-Setting", "Voice-Quality-Checker");
        m = new b();
    }

    public static void j() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[VoiceQualityChecker]releaseAudioRecord  mAudioRecorderStatus :");
        r1.append(h);
        r1.append(" mAudioRecord is ");
        r1.append(c);
        r1.append(" mAudioRecord.state: ");
        AudioRecord r2 = c;
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.getState());
    L6:
        r1.append(r3);
        r0.i("VoiceQualityChecker", r1.toString());
        if (c != null) goto L9;
        return;
    L9:
        q78.b.c(m, "VoiceQualityChecker");
        f2a.c r4 = l.b("unregisterFlowAudioRecordingCallback");
        r4.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r4, null, 15);
        AudioRecord r5 = c;
        boolean r6 = false;
        if (r5 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L24;
        AudioRecord r8 = c;
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L24;
        r6 = true;
        goto L24
    L19:
        if (r8.getRecordingState() != 3) goto L21;
        r9 = true;
    L24:
        if (r6 == true) goto L44;
    L42:
        c = null;
        return;
    L44:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L37
        AudioRecord r11 = c;     // Catch: Throwable -> L37
        if (r11 != null) goto L28;
    L31:
        AudioRecord r12 = c;     // Catch: Throwable -> L37
        if (r12 == null) goto L34;
        d(r12);     // Catch: Throwable -> L37
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L35:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L37
    L39:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L42;
        FLogger.a.e("VoiceQualityChecker", "[VoiceQualityChecker]releaseAudioRecord  error :" + r15.getMessage(), r15);
        goto L42
    L34:
        r13 = null;
        goto L35
    L28:
        if (fna.g.d() == true) goto L30;
        f(r11);     // Catch: Throwable -> L37
        goto L31
    L30:
        f(r11);     // Catch: Throwable -> L37
        hna.a.c(r11.hashCode());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L12:
        if (r5.getState() != 1) goto L14;
        r7 = true;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.audio.g1
    public final void a() {
        FLogger.a.i("VoiceQualityChecker", "[VoiceQualityChecker]cancelQualityCheck  mAudioRecorderStatus :" + h + ' ');
        j();
        h = AudioRecorderStatus.STATE_CANCEL;
        g.reset();
        j.set(true);
        d = null;
    }

    @Override // com.larus.audio.g1
    public final void b() {
        FLogger.a.i("VoiceQualityChecker", "[VoiceQualityChecker]stopQualityCheck  mAudioRecorderStatus :" + h + ' ');
        h = AudioRecorderStatus.STATE_IDLE;
        j();
        j.set(true);
        d = null;
    }

    public final synchronized Integer i() {
        monitor-enter(this);
        e = new SAMICoreVopAudioChecker();     // Catch: Throwable -> L29
        f = new SAMICoreVopAudioCheckerConfig();     // Catch: Throwable -> L29
        SAMICoreVopAudioCheckerConfig r1 = f;     // Catch: Throwable -> L29
        if (r1 == null) goto L7;
        r1.channel = 1;     // Catch: Throwable -> L29
    L7:
        SAMICoreVopAudioCheckerConfig r2 = f;     // Catch: Throwable -> L29
        if (r2 == null) goto L10;
        r2.sampleBit = 16;     // Catch: Throwable -> L29
    L10:
        SAMICoreVopAudioCheckerConfig r3 = f;     // Catch: Throwable -> L29
        if (r3 == null) goto L13;
        r3.sampleRate = 24000;     // Catch: Throwable -> L29
    L13:
        SAMICoreVopAudioCheckerConfig r4 = f;     // Catch: Throwable -> L29
        if (r4 == null) goto L16;
        r4.maxBlockSize = 512;     // Catch: Throwable -> L29
    L16:
        SAMICoreVopAudioChecker r5 = e;     // Catch: Throwable -> L29
        if (r5 == null) goto L19;
        Integer r6 = Integer.valueOf(r5.init(f));     // Catch: Throwable -> L29
    L20:
        if (r6 != null) goto L23;
    L24:
        FLogger.a.e("VoiceQualityChecker", "[VoiceQualityChecker]initAudionCheckerConfig error ret :" + r6);     // Catch: Throwable -> L29
        SAMICoreVopAudioChecker r0 = e;     // Catch: Throwable -> L29
        if (r0 == null) goto L27;
        r0.destroyEngine();     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);
        return r6;
    L23:
        if (r6.intValue() == 0) goto L27;
    L19:
        r6 = null;
    L29:
        th = move-exception;
        throw th;
    }

    public static void d(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100403, "android/media/AudioRecord", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, true);
    }

    public static void e(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100400, "android/media/AudioRecord", "startRecording", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, false);
        return;
    L6:
        r12.startRecording();
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, true);
    }

    public static void f(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100401, "android/media/AudioRecord", "stop", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, false);
        return;
    L6:
        r12.stop();
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, true);
    }

    public final synchronized Integer h(String r8) {
        monitor-enter(this);
        boolean r2 = true;
        if (r8 != null) goto L64;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        FLogger.a.e("VoiceQualityChecker", "[VoiceQualityChecker]initAudioMetric model path is empty :" + r8);     // Catch: Throwable -> L10
    L15:
        i = new SAMICoreVopAudioCheckerAudioMetricParameter();     // Catch: Throwable -> L10
        SAMICoreVopAudioCheckerAudioMetricParameter r1 = i;     // Catch: Throwable -> L10
        if (r1 == null) goto L22;
        lq9.c r5 = z2.a.U0().b();     // Catch: Throwable -> L10
        if (r5 == null) goto L20;
        boolean r6 = r5.b();     // Catch: Throwable -> L10
    L21:
        r1.enableSNR = r6;     // Catch: Throwable -> L10
        goto L22
    L20:
        r6 = false;
    L22:
        SAMICoreVopAudioCheckerAudioMetricParameter r3 = i;     // Catch: Throwable -> L10
        if (r3 == null) goto L25;
        r3.audioMetricModelPath = r8;     // Catch: Throwable -> L10
    L25:
        z2 r9 = z2.a;     // Catch: Throwable -> L10
        lq9.c r7 = r9.U0().b();     // Catch: Throwable -> L10
        if (r7 != null) goto L28;
    L30:
        r2 = false;
    L31:
        float r10 = 0.3f;
        float r11 = 20.0f;
        if (r2 == false) goto L45;
        SAMICoreVopAudioCheckerAudioMetricParameter r12 = i;     // Catch: Throwable -> L10
        if (r12 == null) goto L39;
        lq9.c r13 = r9.U0().b();     // Catch: Throwable -> L10
        if (r13 == null) goto L38;
        r11 = r13.c();     // Catch: Throwable -> L10
    L38:
        r12.snrThreshold = r11;     // Catch: Throwable -> L10
    L39:
        SAMICoreVopAudioCheckerAudioMetricParameter r14 = i;     // Catch: Throwable -> L10
        if (r14 == null) goto L51;
        lq9.c r15 = r9.U0().b();     // Catch: Throwable -> L10
        if (r15 == null) goto L44;
        r10 = r15.a();     // Catch: Throwable -> L10
    L44:
        r14.cutoffLength = r10;     // Catch: Throwable -> L10
    L51:
        SAMICoreVopAudioChecker r16 = e;     // Catch: Throwable -> L10
        if (r16 == null) goto L54;
        Integer r17 = Integer.valueOf(r16.setAudioMetricParameter(i));     // Catch: Throwable -> L10
    L55:
        if (r17 != null) goto L58;
    L59:
        FLogger.a.e("VoiceQualityChecker", "[VoiceQualityChecker]initAudioMetric error ret :" + r17);     // Catch: Throwable -> L10
    L60:
        monitor-exit(this);
        return r17;
    L10:
        th = move-exception;
        throw th;
    L58:
        if (r17.intValue() == 0) goto L60;
    L54:
        r17 = null;
        goto L55
    L45:
        SAMICoreVopAudioCheckerAudioMetricParameter r19 = i;     // Catch: Throwable -> L10
        if (r19 == null) goto L48;
        r19.snrThreshold = 20.0f;     // Catch: Throwable -> L10
    L48:
        SAMICoreVopAudioCheckerAudioMetricParameter r20 = i;     // Catch: Throwable -> L10
        if (r20 == null) goto L51;
        r20.cutoffLength = 0.3f;     // Catch: Throwable -> L10
        goto L51
    L28:
        if (r7.b() != true) goto L30;
    L64:
        if (r8.length() == 0) goto L12;
        r4 = false;
        goto L13
    }

    @Override // com.larus.audio.g1
    public final synchronized void c(final String r3, final String r4, final String r5, final p78.a r6) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        g.reset();     // Catch: Throwable -> L6
        j.set(false);     // Catch: Throwable -> L6
        ThreadPlus.submitRunnable(new l58.a(r6, r5, r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
