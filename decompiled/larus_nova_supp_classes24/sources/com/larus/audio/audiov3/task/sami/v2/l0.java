package com.larus.audio.audiov3.task.sami.v2;

import com.bytedance.flow_audio.api.business.tts.config.FlowAudioTtsStreamType;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.config.BusinessTypeEnum;
import com.larus.audio.audiov3.config.ConnectStatusEnum;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.audio.utils.g1;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l0 implements l68.a {
    public TtsTracer a;
    public volatile com.larus.audio.audiov3.task.sami.v2.flow.a b;
    public z58.a c;
    public l68.b d;
    public boolean e;
    public TtsState f;
    public boolean g;
    public ConnectStatusEnum h;
    public boolean i;
    public final ReentrantLock j;
    public String k;
    public SAMICoreCallBackEventType l;
    public int m;
    public final k68.c n;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[FlowAudioTtsStreamType.values().length];
            r0[FlowAudioTtsStreamType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r0[FlowAudioTtsStreamType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L66:
            r0[FlowAudioTtsStreamType.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L8:
            a = r0;
            int[] r1 = new int[SAMICoreCallBackEventType.values().length];
            r1[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L60:
            r1[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L70:
            r1[SAMICoreCallBackEventType.ChatEnded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L40:
            r1[SAMICoreCallBackEventType.ChatResponse.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L44:
            r1[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L52:
            r1[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L64:
            r1[SAMICoreCallBackEventType.SessionCanceled.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L48:
            r1[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L58:
            r1[SAMICoreCallBackEventType.TTSSentenceStart.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
        L62:
            r1[SAMICoreCallBackEventType.TTSResponse.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
        L42:
            r1[SAMICoreCallBackEventType.TTSSentenceEnd.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
        L54:
            r1[SAMICoreCallBackEventType.TTSEnded.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L68:
            r1[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
        L22:
            b = r1;
        }
    }

    @Override // l68.a
    public final void a(int r1) {
    }

    @Override // l68.a
    public final void release() {
        this.i = false;
        if (this.g == false) goto L6;
        z.a().e(this.b, this.h);
        return;
    L6:
        int r0 = c68.b.a;
        c68.b.a("TtsTextTask", this + " release" + b0.a(this.b));
        ((ExecutorService) g1.b.getValue()).submit(new k0(this));
    }

    @Override // l68.a
    public final void cancel() {
        ReentrantLock r0 = this.j;
        if (r0 == null) goto L6;
        r0.lock();
    L6:
        if (this.f != TtsState.TTS_STARTED) goto L15;
        TtsState r1 = TtsState.TTS_STOPPED;
        this.f = r1;
        l68.b r2 = this.d;
        if (r2 == null) goto L10;
        r2.d(r1);
    L10:
        a0 r3 = a0.a;
        z58.a r4 = this.c;
        if (r4 == null) goto L13;
        String r5 = r4.b;
    L14:
        com.larus.audio.audiov3.task.sami.v2.flow.a r6 = this.b;
        r3.getClass();
        a0.a(r5, r6);
    L16:
        ReentrantLock r7 = this.j;
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
        c68.b.a("TtsTextTask", this + " has stopped" + b0.a(this.b));
        goto L16
    }

    public final void g() {
        ReentrantLock r0 = this.j;
        if (r0 == null) goto L5;
        r0.lock();
    L5:
        f(ConnectStatusEnum.DISABLE);
        com.larus.audio.audiov3.task.sami.v2.flow.a r1 = z.a().d();
        x58.a r2 = null;
        if (r1 == null) goto L8;
        this.g = true;
        this.h = z.a().a;
        this.b = r1;
        int r3 = c68.b.a;
        c68.b.a("TtsTextTask", this + " startSession use main task" + b0.a(this.b));
    L13:
        com.larus.audio.audiov3.task.sami.v2.flow.a r4 = this.b;
        if (r4 == null) goto L16;
        r4.e();
    L16:
        com.larus.audio.audiov3.task.sami.v2.flow.a r5 = this.b;
        if (r5 == null) goto L19;
        r5.h(this.n);
    L19:
        com.larus.audio.audiov3.task.sami.v2.flow.a r6 = this.b;
        if (r6 == null) goto L22;
        r6.h(new j0(this));
    L22:
        a0 r7 = a0.a;
        BusinessTypeEnum r8 = BusinessTypeEnum.TTS_BY_TEXT;
        z58.a r9 = this.c;
        if (r9 == null) goto L25;
        r2 = r9.a;
    L25:
        a0.l(r7, r8, r2, null, r9, this.b, null);
        ReentrantLock r10 = this.j;
        if (r10 == null) goto L29;
        r10.unlock();
        return;
    L29:
        return;
    L8:
        this.g = false;
        this.b = new com.larus.audio.audiov3.task.sami.v2.flow.a();
        int r11 = c68.b.a;
        c68.b.a("TtsTextTask", this + " startSession use new task" + b0.a(this.b));
        a0 r12 = a0.a;
        z58.a r13 = this.c;
        if (r13 == null) goto L11;
        x58.a r14 = r13.a;
    L12:
        com.larus.audio.audiov3.task.sami.v2.flow.a r15 = this.b;
        r12.getClass();
        a0.f(r14, r15, null);
        goto L13
    L11:
        r14 = null;
        goto L12
    }

    @Override // l68.a
    public final void start() {
        ReentrantLock r0 = this.j;
        if (r0 == null) goto L6;
        r0.lock();
    L6:
        if (this.f != TtsState.TTS_STOPPED) goto L37;
        int r1 = c68.b.a;
        c68.b.a("TtsTextTask", this + " config " + this.c + b0.a(this.b));
        boolean r2 = true;
        this.i = true;
        g();
        com.larus.audio.audiov3.task.sami.v2.flow.a r3 = this.b;
        if (r3 != null) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == false) goto L18;
        c68.b.b("TtsTextTask", "start session failed, sami: " + b0.a(this.b));
        ReentrantLock r4 = this.j;
        if (r4 == null) goto L42;
        r4.unlock();
        return;
    L42:
        return;
    L18:
        TtsTracer r5 = this.a;
        if (r5 == null) goto L21;
        r5.updateParams(new i0(this));
    L21:
        a0 r6 = a0.a;
        z58.a r7 = this.c;
        String r8 = null;
        if (r7 == null) goto L24;
        String r9 = r7.b;
    L25:
        if (r7 == null) goto L27;
        String r10 = r7.v;
    L28:
        com.larus.audio.audiov3.task.sami.v2.flow.a r11 = this.b;
        z58.a r12 = this.c;
        r6.getClass();
        if (a0.j(r9, r10, r11, r12) != 0) goto L34;
        a0.c(this.c, this.b);
        z58.a r13 = this.c;
        if (r13 == null) goto L33;
        r8 = r13.b;
    L33:
        a0.d(r8, this.b);
    L34:
        TtsState r14 = TtsState.TTS_STARTED;
        this.f = r14;
        l68.b r15 = this.d;
        if (r15 == null) goto L38;
        r15.d(r14);
    L38:
        ReentrantLock r16 = this.j;
        if (r16 == null) goto L43;
        r16.unlock();
        return;
    L43:
        return;
    L27:
        r10 = null;
        goto L28
    L24:
        r9 = null;
        goto L25
    L10:
        if (r3.getHandle() != 0) goto L12;
    L37:
        int r17 = c68.b.a;
        c68.b.a("TtsTextTask", this + " has started" + b0.a(this.b));
        goto L38
    }

    @Override // l68.a
    public final void stop() {
        if (this.f != TtsState.TTS_STARTED) goto L7;
        TtsState r0 = TtsState.TTS_STOPPED;
        this.f = r0;
        l68.b r1 = this.d;
        if (r1 == null) goto L9;
        r1.d(r0);
        return;
    L9:
        return;
    L7:
        int r2 = c68.b.a;
        c68.b.a("TtsTextTask", this + " has stopped" + b0.a(this.b));
    }

    public l0() {
        this.e = true;
        this.f = TtsState.TTS_STOPPED;
        this.h = ConnectStatusEnum.DISABLE;
        this.i = true;
        this.j = new ReentrantLock();
        this.k = "taskId: null";
        this.n = new k68.c();
    }

    @Override // l68.a
    public final z58.a c() {
        return this.c;
    }

    @Override // l68.a
    public final l68.b getListener() {
        return this.d;
    }

    public final String toString() {
        return this.k;
    }

    @Override // l68.a
    public final void b(l68.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r0 = c68.b.a;
        c68.b.a("TtsTextTask", this + " set listener" + b0.a(this.b));
        this.d = r3;
    }

    public final void f(ConnectStatusEnum r3) {
        this.h = r3;
        if (this.b != null) goto L5;
        return;
    L5:
        int r0 = c68.b.a;
        c68.b.a("TtsTextTask", this + " connectStatusEnum: " + r3 + b0.a(this.b));
    }

    @Override // l68.a
    public final void d(FlowAudioTtsStreamType r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "ttsStreamType");
        Intrinsics.checkNotNullParameter(r13, "streamText");
        ReentrantLock r0 = this.j;
        if (r0 == null) goto L5;
        r0.lock();
    L5:
        int r1 = c68.b.a;
        StringBuilder r2 = new StringBuilder();
        r2.append(this);
        r2.append(" startStream ttsStreamType=");
        r2.append(r12);
        r2.append("} taskId=");
        z58.a r3 = this.c;
        String r4 = null;
        if (r3 == null) goto L8;
        String r5 = r3.b;
    L9:
        r2.append(r5);
        r2.append(" streamText=");
        r2.append(r13);
        c68.b.a("TtsTextTask", r2.toString());
        int r14 = a.a[r12.ordinal()];
        boolean r6 = true;
        if (r14 == 1) goto L47;
        if (r14 == 2) goto L35;
        if (r14 != 3) goto L33;
        if (this.f == TtsState.TTS_STARTED) goto L19;
        c68.b.b("TtsTextTask", this + " startStream start session failed, sami=" + b0.a(this.b));
    L66:
        ReentrantLock r15 = this.j;
        if (r15 == null) goto L71;
        r15.unlock();
        return;
    L71:
        return;
    L19:
        if (r13.length() > 0) goto L22;
        r6 = false;
    L22:
        if (r6 == false) goto L28;
        a0 r16 = a0.a;
        z58.a r7 = this.c;
        if (r7 == null) goto L26;
        String r8 = r7.b;
    L27:
        com.larus.audio.audiov3.task.sami.v2.flow.a r9 = this.b;
        z58.a r10 = this.c;
        r16.getClass();
        c68.b.a("TtsTextTask", this + " startStream sami" + b0.a(this.b) + " startPureTextTt=" + a0.j(r8, r13, r9, r10));
        goto L28
    L26:
        r8 = null;
    L28:
        a0 r17 = a0.a;
        z58.a r19 = this.c;
        com.larus.audio.audiov3.task.sami.v2.flow.a r11 = this.b;
        r17.getClass();
        a0.c(r19, r11);
        z58.a r110 = this.c;
        if (r110 == null) goto L31;
        r4 = r110.b;
    L31:
        a0.d(r4, this.b);
        goto L66
    L33:
        throw new NoWhenBranchMatchedException();
    L35:
        if (this.f == TtsState.TTS_STARTED) goto L38;
        c68.b.b("TtsTextTask", this + " startStream session state not started, sami=" + b0.a(this.b));
        goto L66
    L38:
        if (r13.length() > 0) goto L41;
        r6 = false;
    L41:
        if (r6 == false) goto L66;
        a0 r111 = a0.a;
        z58.a r20 = this.c;
        if (r20 == null) goto L45;
        r4 = r20.b;
    L45:
        com.larus.audio.audiov3.task.sami.v2.flow.a r21 = this.b;
        z58.a r22 = this.c;
        r111.getClass();
        c68.b.a("TtsTextTask", this + " startStream sami" + b0.a(this.b) + " startPureTextTt=" + a0.j(r4, r13, r21, r22));
        goto L66
    L47:
        if (this.f != TtsState.TTS_STOPPED) goto L65;
        this.i = true;
        g();
        com.larus.audio.audiov3.task.sami.v2.flow.a r112 = this.b;
        if (r112 != null) goto L51;
    L53:
        r6 = false;
    L54:
        if (r6 == false) goto L59;
        c68.b.b("TtsTextTask", this + " startStream start session failed, sami=" + b0.a(this.b));
        ReentrantLock r113 = this.j;
        if (r113 == null) goto L70;
        r113.unlock();
        return;
    L70:
        return;
    L59:
        a0 r114 = a0.a;
        z58.a r23 = this.c;
        if (r23 == null) goto L62;
        r4 = r23.b;
    L62:
        com.larus.audio.audiov3.task.sami.v2.flow.a r24 = this.b;
        z58.a r25 = this.c;
        r114.getClass();
        c68.b.a("TtsTextTask", this + " startStream sami" + b0.a(this.b) + " startPureTextTt=" + a0.j(r4, r13, r24, r25));
        TtsState r115 = TtsState.TTS_STARTED;
        this.f = r115;
        l68.b r116 = this.d;
        if (r116 == null) goto L66;
        r116.d(r115);
        goto L66
    L51:
        if (r112.getHandle() != 0) goto L53;
    L65:
        c68.b.a("TtsTextTask", this + " has started" + b0.a(this.b));
        goto L66
    L8:
        r5 = null;
        goto L9
    }

    @Override // l68.a
    public final void e(z58.a r2, TtsTracer r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.c = r2;
        String r4 = r2.b;
        if (r4 != null) goto L5;
        r4 = "null";
    L5:
        this.k = "taskId: ".concat(r4);
        this.a = r3;
        this.n.a = r3;
        if (r3 == null) goto L11;
        l68.b r5 = this.d;
        if (r5 == null) goto L12;
        r5.a(r3);
        return;
    L12:
        return;
    }
}
