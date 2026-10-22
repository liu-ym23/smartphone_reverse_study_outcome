package com.larus.asr;

import android.os.SystemClock;
import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.voiceInput.FlowVoiceInputStatus;
import com.bytedance.flow_audio.impl.business.asr.viewModel.VoiceInputViewModel;
import com.larus.audio.asr.c0;
import com.larus.audio.i0;
import com.larus.audio.report.IAsrTracerFactory;
import com.larus.audio.report.h;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gw5.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class KmpAsrSessionAdapter {
    public final Lazy a;
    public lw5.e b;
    public final Map<String, y5> c;

    public interface a {
        void b(String r1);

        void c(com.larus.audio.b r1);

        void d(String r1, byte[] r2);

        void e(String r1, String r2, long r3, int r5);

        void f(String r1);
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowAsrErrorType.values().length];
            r0[FlowAsrErrorType.SOURCE_START_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FlowAsrErrorType.SOURCE_STOP_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FlowAsrErrorType.SOURCE_RELEASE_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FlowAsrErrorType.SOURCE_PREPARE_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final void c() {
        if (this.c.isEmpty() == false) goto L5;
        return;
    L5:
        FLogger.a.i("KmpAsrSessionAdapter", "[cleanupActiveVoiceInput][" + hashCode() + "] start clean up left num=" + this.c.size() + " [" + CollectionsKt.joinToString$default(((LinkedHashMap) this.c).keySet(), ",", null, null, 0, null, null, 62, null) + "] AsrSession when chat page stops or is destroyed");
        Map r0 = MapsKt.toMap(this.c);
        ((LinkedHashMap) this.c).clear();
        Iterator r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L30;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r6 = (String) r2.getKey();
        y5 r4 = (y5) r2.getValue();
        FlowFileProtectionService r5 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r5 == null) goto L13;
        boolean r7 = true;
        if (r5.I0() != true) goto L13;
    L14:
        if (r7 == false) goto L16;
        r4.a.C2();
    L16:
        n4 r8 = r4.h;
        if (r8 == null) goto L19;
        r8.e();
    L19:
        a r9 = ((y5) r2.getValue()).c;
        qw5.a r10 = r4.b;
        if (r10 == null) goto L26;
        i r11 = r10.j;
        if (r11 == null) goto L26;
        gw5.g r12 = r11.f;
        if (r12 == null) goto L26;
        String r13 = r12.a;
    L27:
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        r9.e(r6, r13, ((y5) r2.getValue()).i, -9998);
    L26:
        r13 = null;
    L13:
        r7 = false;
        goto L14
    L30:
        FLogger.a.i("KmpAsrSessionAdapter", "[cleanupActiveVoiceInput][" + hashCode() + "] end clean up");
    }

    public KmpAsrSessionAdapter() {
        this.a = LazyKt.lazy(new g2());
        this.c = new LinkedHashMap();
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        FLogger.a.i("KmpAsrSessionAdapter", "[cancel][" + r4 + ']');
        lw5.e r5 = this.b;
        if (r5 == null) goto L6;
        r5.C2();
        return;
    }

    public final boolean f(final String r12) {
        Intrinsics.checkNotNullParameter(r12, "taskId");
        FLogger r1 = FLogger.a;
        r1.i("KmpAsrSessionAdapter", "[stop][" + r12 + ']');
        y5 r2 = (y5) ((LinkedHashMap) this.c).get(r12);
        if (r2 == null) goto L7;
        long r5 = SystemClock.elapsedRealtime() - r2.d;
        y5 r3 = (y5) ((LinkedHashMap) this.c).get(r12);
        if (r3 == null) goto L7;
        r3.i = r5;
    L7:
        y5 r4 = (y5) ((LinkedHashMap) this.c).get(r12);
        n4 r6 = null;
        if (r4 == null) goto L19;
        h r7 = r4.e;
        if (r7 == null) goto L12;
        r7.s();
    L12:
        final z2 r8 = r4.f;
        qw5.a r9 = r4.b;
        if (r9 == null) goto L15;
        final String r10 = r9.b;
    L16:
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r12, "taskId");
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        com.larus.utils.t0.c(new y2(r8, r12, r10));
        goto L19
    L15:
        r10 = null;
    L19:
        if (r4 == null) goto L27;
        qw5.a r0 = r4.b;
        if (r0 == null) goto L27;
        i r11 = r0.j;
        if (r11 == null) goto L27;
        gw5.g r13 = r11.f;
        if (r13 == null) goto L27;
        long r14 = r13.b;
    L28:
        boolean r15 = true;
        if (r4 != null) goto L31;
    L34:
        if (r4 == null) goto L38;
        lw5.e r16 = r4.a;
        if (r16 == null) goto L38;
        FlowVoiceInputStatus r17 = r16.getVoiceInputStatus();
    L40:
        if (r17 != FlowVoiceInputStatus.Starting) goto L43;
        r1.i("KmpAsrSessionAdapter", "[stop][" + r12 + "] cancel while waiting for async audio scene activation");
        b(r12, r4);
        return true;
    L43:
        if (r4 == null) goto L46;
        r6 = r4.h;
    L46:
        if (r4 == null) goto L57;
        if (r6 == null) goto L57;
        if (r4.j == true) goto L57;
        r1.i("KmpAsrSessionAdapter", "[stop][" + r12 + "] SAMI was not ready at start, wait for PCM save success before file retry");
        if (r6.a() == true) goto L53;
        r6.d("request retry ignored: coordinator inactive");
        r15 = false;
    L54:
        if (r15 == false) goto L57;
        r4.a.z1();
        return false;
    L53:
        r6.f = true;
        r6.d("retry requested; wait for recording file");
    L57:
        lw5.e r19 = this.b;
        if (r19 == null) goto L60;
        r19.z1();
    L60:
        return false;
    L38:
        r17 = null;
        goto L40
    L31:
        if (r4.i >= r14) goto L34;
        r1.i("KmpAsrSessionAdapter", "[stop][" + r12 + "] cancel short recording: duration=" + r4.i + " minDuration=" + r14);
        b(r12, r4);
        return true;
    L27:
        r14 = 0;
        goto L28
    }

    public final void b(final String r4, y5 r5) {
        this.c.remove(r4);
        n4 r0 = r5.h;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        final z2 r1 = r5.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "taskId");
        com.larus.utils.t0.c(new x2(r1, r4));
        h r2 = r5.e;
        if (r2 == null) goto L8;
        r2.o(false);
    L8:
        r5.a.C2();
        FlowFileProtectionService r3 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r3 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L27;
        qw5.a r7 = r5.b;
        if (r7 == null) goto L22;
        i r8 = r7.j;
        if (r8 == null) goto L22;
        gw5.g r9 = r8.f;
        if (r9 == null) goto L22;
        String r10 = r9.a;
    L23:
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        d(r4, r10, true, false);
        return;
    L22:
        r10 = null;
        goto L23
    L27:
        return;
    L11:
        if (r3.I0() != true) goto L13;
        r6 = true;
        goto L14
    }

    public final void d(final String r11, final String r12, final boolean r13, boolean r14) {
        if (r12.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        final FlowFileProtectionService r9 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r9 != null) goto L11;
    L13:
        final boolean r5 = false;
    L14:
        if (r5 == true) goto L18;
        if (r13 == true) goto L18;
        if (r14 == true) goto L18;
        return;
    L18:
        com.larus.utils.t0.a(new h2(r12, r5, this, r11, r13, r9));
        return;
    L11:
        if (r9.I0() != true) goto L13;
        r5 = true;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v41, types: [com.larus.asr.n2] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.asr.j2] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.asr.k2] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.asr.l2] */
    public final boolean e(boolean r22, String r23, String r24, String r25, String r26, long r27, long r29, final c0 r31, b2 r32, d.a r33, a r34) {
        Intrinsics.checkNotNullParameter(r23, "conversationId");
        Intrinsics.checkNotNullParameter(r24, "botId");
        Intrinsics.checkNotNullParameter(r25, "currentTaskId");
        Intrinsics.checkNotNullParameter(r26, "asrContextExtra");
        Intrinsics.checkNotNullParameter(r31, "traceInfo");
        Intrinsics.checkNotNullParameter(r34, "callback");
        int r0 = c68.b.a;
        c68.b.d("KmpAsrSessionAdapter", "start kmp asr taskId=" + r25 + " conversationId=" + r23 + " botId=" + r24 + " traceId=" + r31.a + " withRunningTask=" + this.c.size());
        i0.a.getClass();
        t r1 = m58.h.m;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        boolean r19 = false;
    L22:
        String r3 = new SimpleDateFormat("yyyyMMddhhmmss", Locale.getDefault()).format(new Date());
        b68.b r8 = b68.b.a;
        Intrinsics.checkNotNull(r3);
        r8.getClass();
        String r4 = b68.b.c("/record/asr/pcm/", r3);
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        String r110 = r4;
        RepoDispatcherDelegate r5 = RepoDispatcherDelegate.b;
        String r12 = r5.c().S0();
        qw5.a r6 = i0.a(r22, r23, r24, r25, r26, r27, r110, r12, r5.c().Z(r12));
        FlowFileProtectionService r9 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r9 != null) goto L28;
    L30:
        boolean r13 = false;
    L32:
        if (r13 == false) goto L38;
        i r10 = r6.j;
        if (r10 == null) goto L36;
        boolean r14 = false;
        i r11 = i.a(r10, null, gw5.g.a(r10.f, null, true, 3), gw5.c.a(r10.g, 0), 415);
    L37:
        r6 = qw5.a.a(r6, null, null, r11, 7679);
    L39:
        qw5.a r15 = r6;
        ww5.a r16 = (ww5.a) this.a.getValue();
        if (r16 == null) goto L42;
        final String r17 = r25;
        VoiceInputViewModel r111 = r16.h0(new w2(r25, r15, r19, this, r34, r110), new n2(r17));
    L43:
        if (r111 != null) goto L46;
        c68.b.b("KmpAsrSessionAdapter", "start kmp asr failed: IFlowAudioService is null taskId=".concat(r17));
        return r14;
    L46:
        IAsrTracerFactory r7 = (IAsrTracerFactory) ServiceManager.get().getService(IAsrTracerFactory.class);
        if (r7 == null) goto L49;
        final k78.b r20 = r7.a(r29, r25, r23, r24, new i2(r31));
    L50:
        if (r20 == null) goto L52;
        r20.b(r14);
    L52:
        if (r19 == false) goto L54;
        n4 r112 = new n4(r25, r15, new j2(this), new k2(this, r17), new l2(r20));
    L55:
        VoiceInputViewModel r21 = r111;
        String r30 = r17;
        this.c.put(r30, new y5(r111, r15, r34, SystemClock.elapsedRealtime(), r20, new z2(r32), new f2(r33), r112));
        this.b = r21;
        r21.V2(true, true);
        return r21.m3();
    L54:
        r112 = null;
        goto L55
    L49:
        r20 = null;
        goto L50
    L42:
        r17 = r25;
        r111 = null;
        goto L43
    L36:
        r14 = false;
        r11 = null;
        goto L37
    L38:
        r14 = false;
        goto L39
    L28:
        if (r9.I0() != true) goto L30;
        r13 = true;
        goto L32
    L10:
        boolean r35 = Intrinsics.areEqual(m58.h.p.getValue(), Boolean.TRUE);
        if (m58.h.a == null) goto L13;
        boolean r36 = true;
    L14:
        if (r35 == false) goto L18;
        if (r36 == false) goto L18;
        boolean r37 = false;
    L19:
        if (r37 == false) goto L21;
        c68.b.e("FlowAudioSessionConfigFactory", "KMP ASR starts before SAMI is ready: hasInit=" + r35 + ", hasCommonConfig=" + r36);
    L21:
        r19 = r37;
    L18:
        r37 = true;
        goto L19
    L13:
        r36 = false;
        goto L14
    L5:
        if (r1.enableOptAsrSamiNotReady() != true) goto L7;
        r2 = true;
        goto L8
    }
}
