package com.larus.audio.audiov3.task.sami.v2;

import com.bytedance.flow_audio.api.business.tts.config.FlowAudioTtsStreamType;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.config.BusinessTypeEnum;
import com.larus.audio.audiov3.config.ConnectStatusEnum;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.audio.flow.client.mob.FlowAudioAsrAndTTSCostMobHelper;
import com.larus.audio.utils.g1;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h0 implements l68.a {
    public volatile com.larus.audio.audiov3.task.sami.v2.flow.a a;
    public z58.a b;
    public l68.b c;
    public boolean d;
    public TtsState e;
    public boolean f;
    public ConnectStatusEnum g;
    public boolean h;
    public final ReentrantLock i;
    public String j;
    public SAMICoreCallBackEventType k;
    public int l;
    public final k68.c m;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SAMICoreCallBackEventType.values().length];
            r0[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r0[SAMICoreCallBackEventType.ChatEnded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r0[SAMICoreCallBackEventType.ChatResponse.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r0[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r0[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[SAMICoreCallBackEventType.SessionCanceled.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[SAMICoreCallBackEventType.TTSSentenceStart.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r0[SAMICoreCallBackEventType.TTSResponse.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[SAMICoreCallBackEventType.TTSSentenceEnd.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[SAMICoreCallBackEventType.TTSEnded.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            a = r0;
        }
    }

    @Override // l68.a
    public final void a(int r1) {
    }

    @Override // l68.a
    public final void d(FlowAudioTtsStreamType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "ttsStreamType");
        Intrinsics.checkNotNullParameter(r3, "streamText");
    }

    @Override // l68.a
    public final void release() {
        this.h = false;
        if (this.f == false) goto L6;
        z.a().e(this.a, this.g);
        return;
    L6:
        int r0 = c68.b.a;
        c68.b.a("TtsTask", this + " release" + b0.a(this.a));
        ((ExecutorService) g1.b.getValue()).submit(new f0(this));
    }

    @Override // l68.a
    public final void cancel() {
        ReentrantLock r0 = this.i;
        if (r0 == null) goto L6;
        r0.lock();
    L6:
        if (this.e != TtsState.TTS_STARTED) goto L15;
        TtsState r1 = TtsState.TTS_STOPPED;
        this.e = r1;
        l68.b r2 = this.c;
        if (r2 == null) goto L10;
        r2.d(r1);
    L10:
        a0 r3 = a0.a;
        z58.a r4 = this.b;
        if (r4 == null) goto L13;
        String r5 = r4.b;
    L14:
        com.larus.audio.audiov3.task.sami.v2.flow.a r6 = this.a;
        r3.getClass();
        a0.a(r5, r6);
    L16:
        ReentrantLock r7 = this.i;
        if (r7 == null) goto L20;
        r7.unlock();
        return;
    L20:
        return;
    L13:
        r5 = null;
        goto L14
    L15:
        int r8 = c68.b.a;
        c68.b.a("TtsTask", this + " has stopped" + b0.a(this.a));
        goto L16
    }

    @Override // l68.a
    public final void start() {
        ReentrantLock r0 = this.i;
        if (r0 == null) goto L6;
        r0.lock();
    L6:
        if (this.e != TtsState.TTS_STOPPED) goto L70;
        int r1 = c68.b.a;
        c68.b.a("TtsTask", this + " config " + this.b + b0.a(this.a));
        this.h = true;
        ReentrantLock r2 = this.i;
        if (r2 == null) goto L10;
        r2.lock();
    L10:
        f(ConnectStatusEnum.DISABLE);
        com.larus.audio.audiov3.task.sami.v2.flow.a r3 = z.a().d();
        z58.a r4 = this.b;
        x58.a r5 = null;
        if (r4 == null) goto L15;
        Map<String, String> r6 = r4.m;
        if (r6 == null) goto L15;
        final String r7 = r6.get("question_id");
    L17:
        if (r3 == null) goto L26;
        this.f = true;
        this.g = z.a().a;
        this.a = r3;
        m58.u r8 = m58.h.l;
        if (r8 == null) goto L25;
        z58.a r9 = this.b;
        if (r9 == null) goto L23;
        String r10 = r9.c;
    L24:
        r8.c(r10, r7, new c0(this));
        goto L25
    L23:
        r10 = null;
    L25:
        c68.b.a("TtsTask", this + " startSession use main task" + b0.a(this.a));
    L31:
        com.larus.audio.audiov3.task.sami.v2.flow.a r11 = this.a;
        if (r11 == null) goto L34;
        r11.e();
    L34:
        com.larus.audio.audiov3.task.sami.v2.flow.a r12 = this.a;
        if (r12 == null) goto L37;
        r12.h(this.m);
    L37:
        com.larus.audio.audiov3.task.sami.v2.flow.a r13 = this.a;
        if (r13 == null) goto L40;
        r13.h(new g0(this));
    L40:
        m58.u r14 = m58.h.l;
        if (r14 == null) goto L47;
        z58.a r15 = this.b;
        if (r15 == null) goto L45;
        String r16 = r15.c;
    L46:
        String r17 = r14.a(r16);
    L48:
        a0 r19 = a0.a;
        BusinessTypeEnum r20 = BusinessTypeEnum.TTS_BY_MSG_ID;
        z58.a r110 = this.b;
        if (r110 == null) goto L51;
        r5 = r110.a;
    L51:
        a0.l(r19, r20, r5, null, r110, this.a, r17);
        ReentrantLock r21 = this.i;
        if (r21 == null) goto L54;
        r21.unlock();
    L54:
        z58.a r22 = this.b;
        com.larus.audio.audiov3.task.sami.v2.flow.a r23 = this.a;
        if (r22 == null) goto L66;
        if (r23 == null) goto L66;
        if (r23.getHandle() == 0) goto L66;
        StringBuilder r24 = new StringBuilder("startTts taskId: ");
        String r25 = r22.b;
        if (r25 != null) goto L63;
        r25 = "null";
    L63:
        r24.append(r25);
        r24.append(b0.a(r23));
        c68.b.a("TaskGenerator", r24.toString());
        SAMICoreVoiceAssistantPropertyParameter r26 = new SAMICoreVoiceAssistantPropertyParameter();
        r26.taskId = r22.b;
        r26.chat = a0.e(r22).toString();
        Lazy r27 = FlowAudioAsrAndTTSCostMobHelper.a;
        FlowAudioAsrAndTTSCostMobHelper.b(r22.c);
        SAMICoreProperty r29 = new SAMICoreProperty();
        r29.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Tts;
        r29.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r29.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r26};
        r29.dataArrayLen = 1;
        int r30 = r23.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r29);
        if (r30 == 0) goto L67;
        c68.b.b("TaskGenerator", "startTts failed ret: " + r30 + b0.a(r23));
    L67:
        TtsState r31 = TtsState.TTS_STARTED;
        this.e = r31;
        l68.b r32 = this.c;
        if (r32 == null) goto L71;
        r32.d(r31);
    L71:
        ReentrantLock r33 = this.i;
        if (r33 == null) goto L75;
        r33.unlock();
        return;
    L75:
        return;
    L66:
        c68.b.b("TaskGenerator", "startTts failed, ttsData: " + r22 + ", samiCore: " + b0.a(r23));
        goto L67
    L45:
        r16 = null;
        goto L46
    L47:
        r17 = null;
        goto L48
    L26:
        this.f = false;
        this.a = new com.larus.audio.audiov3.task.sami.v2.flow.a();
        c68.b.a("TtsTask", this + " startSession use new task" + b0.a(this.a));
        a0 r34 = a0.a;
        z58.a r35 = this.b;
        if (r35 == null) goto L29;
        x58.a r36 = r35.a;
    L30:
        com.larus.audio.audiov3.task.sami.v2.flow.a r37 = this.a;
        Function0 r38 = new d0(this, r7);
        r34.getClass();
        a0.f(r36, r37, r38);
        goto L31
    L29:
        r36 = null;
    L15:
        r7 = null;
        goto L17
    L70:
        int r39 = c68.b.a;
        c68.b.a("TtsTask", this + " has started" + b0.a(this.a));
        goto L71
    }

    @Override // l68.a
    public final void stop() {
        if (this.e != TtsState.TTS_STARTED) goto L7;
        TtsState r0 = TtsState.TTS_STOPPED;
        this.e = r0;
        l68.b r1 = this.c;
        if (r1 == null) goto L9;
        r1.d(r0);
        return;
    L9:
        return;
    L7:
        int r2 = c68.b.a;
        c68.b.a("TtsTask", this + " has stopped" + b0.a(this.a));
    }

    public h0() {
        this.d = true;
        this.e = TtsState.TTS_STOPPED;
        this.g = ConnectStatusEnum.DISABLE;
        this.h = true;
        this.i = new ReentrantLock();
        this.j = "taskId: null";
        this.m = new k68.c();
    }

    @Override // l68.a
    public final z58.a c() {
        return this.b;
    }

    @Override // l68.a
    public final l68.b getListener() {
        return this.c;
    }

    public final String toString() {
        return this.j;
    }

    @Override // l68.a
    public final void b(l68.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void f(ConnectStatusEnum r3) {
        this.g = r3;
        if (this.a != null) goto L5;
        return;
    L5:
        int r0 = c68.b.a;
        c68.b.a("TtsTask", this + " connectStatusEnum: " + r3 + b0.a(this.a));
    }

    public final void g(String r9) {
        f(ConnectStatusEnum.DISABLE);
        TtsEventEnum r2 = TtsEventEnum.TTS_NETWORK_FAILED;
        String r3 = r2.getMassage() + ' ' + r9;
        l68.b r1 = this.c;
        if (r1 == null) goto L5;
        l68.b.a.a(r1, r2, r3, 0, null, null, 28);
    L5:
        release();
    }

    @Override // l68.a
    public final void e(z58.a r2, TtsTracer r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.b = r2;
        String r4 = r2.b;
        if (r4 != null) goto L5;
        r4 = "null";
    L5:
        this.j = "taskId: ".concat(r4);
        this.m.a = r3;
        if (r3 == null) goto L11;
        l68.b r5 = this.c;
        if (r5 == null) goto L12;
        r5.a(r3);
        return;
    L12:
        return;
    }

    public static void h(String r2, Integer r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        m58.u r0 = m58.h.l;
        if (r0 == null) goto L8;
        r0.j(r2, "tts_subscribe_cmd_to_session_finish", r3, r4);
        return;
    }
}
