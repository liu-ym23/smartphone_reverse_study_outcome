package com.larus.audio.audiov3.task.sami.v2;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.audio.audiov3.config.BusinessTypeEnum;
import com.larus.audio.audiov3.config.ConnectStatusEnum;
import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore;
import com.larus.audio.audiov3.task.sami.v2.flow.MockEventType;
import com.larus.audio.utils.g1;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m58.u$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x implements h68.e {
    public final String a;
    public final String b;
    public final Gson c;
    public boolean d;
    public boolean e;
    public volatile com.larus.audio.audiov3.task.sami.v2.flow.a f;
    public y58.a g;
    public h68.d h;
    public j i;
    public volatile boolean j;
    public String k;
    public AsrState l;
    public final ReentrantLock m;
    public ConnectStatusEnum n;
    public volatile int o;
    public String p;
    public long q;
    public long r;
    public volatile boolean s;
    public volatile boolean t;
    public volatile String u;
    public volatile String v;
    public volatile String w;
    public volatile boolean x;
    public String y;
    public com.larus.audio.report.h z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SAMICoreCallBackEventType.values().length];
            r0[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[SAMICoreCallBackEventType.SessionCanceled.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[SAMICoreCallBackEventType.ASRResponse.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[SAMICoreCallBackEventType.ASREnded.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[SAMICoreCallBackEventType.AudioUploadEnded.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    static {
    }

    @Override // h68.e
    public final void cancel() {
        this.e = true;
        String r2 = "";
        String r4 = null;
        if (this.l == AsrState.ASR_STARTED) goto L22;
        m58.k r0 = c68.a.d("cancel AsrTask Failed because it has not been started");
        if (r0 == null) goto L49;
        com.larus.audio.utils.b r1 = (com.larus.audio.utils.b) r0;
        r1.c(i(new p(this)));
        r1.d("AsrTask.cancel");
        y58.a r3 = this.g;
        if (r3 == null) goto L11;
        y58.d r5 = r3.z;
        if (r5 == null) goto L11;
        String r6 = r5.a;
    L12:
        if (r6 == null) goto L15;
        r2 = r6;
    L15:
        r1.b(CollectionsKt.listOf(r2));
        y58.a r7 = this.g;
        if (r7 == null) goto L20;
        y58.d r8 = r7.z;
        if (r8 == null) goto L20;
        r4 = r8.b;
    L20:
        r1.e(r4);
        m58.k.a.a(r1);
        return;
    L11:
        r6 = null;
        goto L12
    L49:
        return;
    L22:
        ReentrantLock r9 = this.m;
        if (r9 == null) goto L25;
        r9.lock();
    L25:
        a0 r10 = a0.a;
        String r11 = this.a;
        com.larus.audio.audiov3.task.sami.v2.flow.a r12 = this.f;
        r10.getClass();
        final int r13 = a0.a(r11, r12);
        m58.k r14 = c68.a.c("cancel AsrTask");
        if (r14 == null) goto L42;
        com.larus.audio.utils.b r15 = (com.larus.audio.utils.b) r14;
        r15.c(i(new q(this, r13)));
        r15.d("AsrTask.cancel");
        y58.a r16 = this.g;
        if (r16 == null) goto L32;
        y58.d r17 = r16.z;
        if (r17 == null) goto L32;
        String r19 = r17.a;
    L33:
        if (r19 == null) goto L36;
        r2 = r19;
    L36:
        r15.b(CollectionsKt.listOf(r2));
        y58.a r20 = this.g;
        if (r20 == null) goto L41;
        y58.d r21 = r20.z;
        if (r21 == null) goto L41;
        r4 = r21.b;
    L41:
        r15.e(r4);
        m58.k.a.a(r15);
    L32:
        r19 = null;
    L42:
        ReentrantLock r22 = this.m;
        if (r22 == null) goto L45;
        r22.unlock();
    L45:
        AsrState r23 = AsrState.ASR_STOP;
        this.l = r23;
        h68.d r24 = this.h;
        if (r24 == null) goto L50;
        r24.e(r23);
        return;
    }

    @Override // h68.e
    public final void release() {
        this.j = false;
        m58.k r0 = c68.a.c("release sami session");
        if (r0 == null) goto L20;
        com.larus.audio.utils.b r1 = (com.larus.audio.utils.b) r0;
        r1.c(i(new com.larus.audio.audiov3.task.sami.v2.a(this)));
        r1.d("AsrTask.startSession");
        y58.a r2 = this.g;
        if (r2 == null) goto L9;
        y58.d r3 = r2.z;
        if (r3 == null) goto L9;
        String r4 = r3.a;
    L10:
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r1.b(CollectionsKt.listOf(r4));
        y58.a r5 = this.g;
        if (r5 == null) goto L17;
        y58.d r6 = r5.z;
        if (r6 == null) goto L17;
        String r7 = r6.b;
    L18:
        r1.e(r7);
        m58.k.a.a(r1);
    L17:
        r7 = null;
    L9:
        r4 = null;
    L20:
        if (this.d == false) goto L23;
        z.a().e(this.f, this.n);
        return;
    L23:
        final com.larus.audio.audiov3.task.sami.v2.flow.a r8 = this.f;
        this.f = null;
        ((ExecutorService) g1.b.getValue()).submit(new l(this, r8));
    }

    @Override // h68.e
    public final synchronized void stop() {
        monitor-enter(this);
        String r2 = null;
        if (this.l == AsrState.ASR_STARTED) goto L23;
        m58.k r0 = c68.a.d("stop AsrTask Failed because it has not been started");     // Catch: Throwable -> L53
        if (r0 == null) goto L21;
        com.larus.audio.utils.b r1 = (com.larus.audio.utils.b) r0;     // Catch: Throwable -> L53
        r1.c(i(new r(this)));     // Catch: Throwable -> L53
        r1.d("AsrTask.stop");     // Catch: Throwable -> L53
        y58.a r3 = this.g;     // Catch: Throwable -> L53
        if (r3 == null) goto L12;
        y58.d r4 = r3.z;     // Catch: Throwable -> L53
        if (r4 == null) goto L12;
        String r5 = r4.a;     // Catch: Throwable -> L53
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r1.b(CollectionsKt.listOf(r5));     // Catch: Throwable -> L53
        y58.a r6 = this.g;     // Catch: Throwable -> L53
        if (r6 == null) goto L20;
        y58.d r7 = r6.z;     // Catch: Throwable -> L53
        if (r7 == null) goto L20;
        r2 = r7.b;     // Catch: Throwable -> L53
    L20:
        r1.e(r2);     // Catch: Throwable -> L53
        m58.k.a.a(r1);     // Catch: Throwable -> L53
    L12:
        r5 = null;
    L21:
        monitor-exit(this);
        return;
    L23:
        ReentrantLock r8 = this.m;     // Catch: Throwable -> L53
        if (r8 == null) goto L26;
        r8.lock();     // Catch: Throwable -> L53
    L26:
        a0 r9 = a0.a;     // Catch: Throwable -> L53
        String r10 = this.a;     // Catch: Throwable -> L53
        com.larus.audio.audiov3.task.sami.v2.flow.a r11 = this.f;     // Catch: Throwable -> L53
        r9.getClass();     // Catch: Throwable -> L53
        final int r12 = a0.b(r10, r11);     // Catch: Throwable -> L53
        m58.k r13 = c68.a.c("stop AsrTask");     // Catch: Throwable -> L53
        if (r13 == null) goto L42;
        com.larus.audio.utils.b r14 = (com.larus.audio.utils.b) r13;     // Catch: Throwable -> L53
        r14.c(i(new s(this, r12)));     // Catch: Throwable -> L53
        r14.d("AsrTask.stop");     // Catch: Throwable -> L53
        y58.a r15 = this.g;     // Catch: Throwable -> L53
        if (r15 == null) goto L33;
        y58.d r16 = r15.z;     // Catch: Throwable -> L53
        if (r16 == null) goto L33;
        String r17 = r16.a;     // Catch: Throwable -> L53
    L34:
        if (r17 != null) goto L36;
        r17 = "";
    L36:
        r14.b(CollectionsKt.listOf(r17));     // Catch: Throwable -> L53
        y58.a r19 = this.g;     // Catch: Throwable -> L53
        if (r19 == null) goto L41;
        y58.d r20 = r19.z;     // Catch: Throwable -> L53
        if (r20 == null) goto L41;
        r2 = r20.b;     // Catch: Throwable -> L53
    L41:
        r14.e(r2);     // Catch: Throwable -> L53
        m58.k.a.a(r14);     // Catch: Throwable -> L53
    L33:
        r17 = null;
    L42:
        m58.u r21 = m58.h.l;     // Catch: Throwable -> L53
        if (r21 == null) goto L45;
        u$a.b(r21, this.a, "asr_touch_up_to_send_end_asr", null, null, null, 28);     // Catch: Throwable -> L53
    L45:
        ReentrantLock r22 = this.m;     // Catch: Throwable -> L53
        if (r22 == null) goto L48;
        r22.unlock();     // Catch: Throwable -> L53
    L48:
        AsrState r23 = AsrState.ASR_STOP;     // Catch: Throwable -> L53
        this.l = r23;     // Catch: Throwable -> L53
        h68.d r24 = this.h;     // Catch: Throwable -> L53
        if (r24 == null) goto L51;
        r24.e(r23);     // Catch: Throwable -> L53
    L51:
        monitor-exit(this);
        return;
    L53:
        th = move-exception;
        throw th;
    }

    public final void l() {
        int r0 = c68.b.a;
        c68.b.b(this.b, h(this + " handleAsrCancel" + b0.a(this.f)));
        String r6 = this.k;
        y58.a r1 = this.g;
        if (r1 == null) goto L7;
        Long r2 = r1.j;
        if (r2 == null) goto L7;
        long r3 = r2.longValue();
    L8:
        long r8 = r3;
        h68.d r4 = this.h;
        if (r4 == null) goto L18;
        y58.a r5 = this.g;
        if (r5 == null) goto L13;
        String r7 = r5.b;
    L14:
        if (r7 != null) goto L16;
        String r9 = "";
    L17:
        r4.a(new y58.b(r9, null, "asr_cancel", r6, this.p, r8, AsrResultState.SUCCESS, AsrEventEnum.ASR_CANCEL, null, 256));
        goto L18
    L16:
        r9 = r7;
        goto L17
    L13:
        r7 = null;
    L18:
        this.k = "";
        return;
    L7:
        r3 = this.r;
        goto L8
    }

    public final void n() {
        y58.a r1 = this.g;
        if (r1 == null) goto L7;
        Long r2 = r1.j;
        if (r2 == null) goto L7;
        long r3 = r2.longValue();
    L8:
        long r9 = r3;
        h68.d r4 = this.h;
        if (r4 == null) goto L18;
        y58.a r5 = this.g;
        if (r5 == null) goto L13;
        String r6 = r5.b;
    L14:
        if (r6 != null) goto L16;
        String r7 = "";
    L17:
        r4.a(new y58.b(r7, 0, "", this.k, this.p, r9, AsrResultState.SUCCESS, AsrEventEnum.ASR_SUCCESS, new y58.c(this.u, this.v, this.w)));
        String r8 = "";
    L19:
        this.p = r8;
        this.k = r8;
        ReentrantLock r10 = this.m;
        if (r10 == null) goto L22;
        r10.lock();
    L22:
        a0 r11 = a0.a;
        y58.a r12 = this.g;
        if (r12 == null) goto L25;
        String r13 = r12.b;
    L26:
        com.larus.audio.audiov3.task.sami.v2.flow.a r14 = this.f;
        r11.getClass();
        a0.d(r13, r14);
        ReentrantLock r15 = this.m;
        if (r15 == null) goto L30;
        r15.unlock();
        return;
    L30:
        return;
    L25:
        r13 = null;
        goto L26
    L16:
        r7 = r6;
        goto L17
    L13:
        r6 = null;
        goto L14
    L18:
        r8 = "";
    L7:
        r3 = this.r;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [com.larus.audio.audiov3.task.sami.v2.j] */
    @Override // h68.e
    public final void start() {
        String r2 = "";
        String r3 = null;
        if (this.l != AsrState.ASR_STARTED) goto L22;
        m58.k r0 = c68.a.d("start AsrTask Failed because it has been started");
        if (r0 == null) goto L221;
        com.larus.audio.utils.b r1 = (com.larus.audio.utils.b) r0;
        r1.c(i(new t(this)));
        r1.d("AsrTask.start");
        y58.a r4 = this.g;
        if (r4 == null) goto L11;
        y58.d r5 = r4.z;
        if (r5 == null) goto L11;
        String r6 = r5.a;
    L12:
        if (r6 == null) goto L15;
        r2 = r6;
    L15:
        r1.b(CollectionsKt.listOf(r2));
        y58.a r7 = this.g;
        if (r7 == null) goto L20;
        y58.d r8 = r7.z;
        if (r8 == null) goto L20;
        r3 = r8.b;
    L20:
        r1.e(r3);
        m58.k.a.a(r1);
        return;
    L11:
        r6 = null;
        goto L12
    L221:
        return;
    L22:
        this.j = true;
        this.q = SystemClock.elapsedRealtime();
        this.w = "";
        this.s = false;
        ReentrantLock r9 = this.m;
        if (r9 == null) goto L25;
        r9.lock();
    L25:
        j(ConnectStatusEnum.DISABLE);
        m58.k r10 = c68.a.c("before start sami session");
        if (r10 == null) goto L42;
        com.larus.audio.utils.b r11 = (com.larus.audio.utils.b) r10;
        r11.c(i(new com.larus.audio.audiov3.task.sami.v2.b(this)));
        r11.d("AsrTask.startSession");
        y58.a r12 = this.g;
        if (r12 == null) goto L32;
        y58.d r13 = r12.z;
        if (r13 == null) goto L32;
        String r14 = r13.a;
    L33:
        if (r14 != null) goto L35;
        r14 = "";
    L35:
        r11.b(CollectionsKt.listOf(r14));
        y58.a r15 = this.g;
        if (r15 == null) goto L40;
        y58.d r16 = r15.z;
        if (r16 == null) goto L40;
        String r17 = r16.b;
    L41:
        r11.e(r17);
        m58.k.a.a(r11);
    L40:
        r17 = null;
    L32:
        r14 = null;
    L42:
        y58.a r19 = this.g;
        if (r19 != null) goto L45;
    L47:
        boolean r20 = false;
    L48:
        if (r20 == true) goto L69;
        if (r19 != null) goto L51;
    L53:
        boolean r21 = false;
    L54:
        if (r21 == true) goto L69;
        if (r19 != null) goto L57;
    L59:
        boolean r22 = false;
    L60:
        if (r22 == true) goto L69;
        if (r19 != null) goto L63;
    L65:
        boolean r23 = false;
    L66:
        if (r23 == true) goto L69;
        boolean r24 = false;
    L70:
        if (r24 == false) goto L72;
        com.larus.audio.audiov3.task.sami.v2.flow.a r25 = null;
    L73:
        m58.q r26 = m58.h.d;
        if (r26 == null) goto L78;
        ASRModule r27 = r26.c();
        if (r27 == null) goto L78;
        int r29 = r27.b();
    L79:
        m58.q r30 = m58.h.d;
        if (r30 == null) goto L86;
        ASRModule r31 = r30.c();
        if (r31 == null) goto L86;
        if (r31.m() != true) goto L86;
        boolean r32 = true;
    L87:
        if (r32 == true) goto L89;
    L139:
        if (r25 == null) goto L160;
        this.d = true;
        this.n = z.a().a;
        this.f = r25;
        m58.u r33 = m58.h.l;
        if (r33 == null) goto L143;
        r33.i(this.a, new d(this));
    L143:
        m58.k r34 = c68.a.c("start sami connect use cached SAMICore");
        if (r34 == null) goto L181;
        com.larus.audio.utils.b r35 = (com.larus.audio.utils.b) r34;
        r35.c(i(new e(this)));
        r35.d("AsrTask.startSession");
        y58.a r36 = this.g;
        if (r36 == null) goto L150;
        y58.d r37 = r36.z;
        if (r37 == null) goto L150;
        String r38 = r37.a;
    L151:
        if (r38 != null) goto L153;
        r38 = "";
    L153:
        r35.b(CollectionsKt.listOf(r38));
        y58.a r39 = this.g;
        if (r39 == null) goto L158;
        y58.d r40 = r39.z;
        if (r40 == null) goto L158;
        String r41 = r40.b;
    L159:
        r35.e(r41);
        m58.k.a.a(r35);
    L158:
        r41 = null;
    L150:
        r38 = null;
    L181:
        this.i = new j(this);
        com.larus.audio.audiov3.task.sami.v2.flow.a r42 = this.f;
        if (r42 == null) goto L184;
        r42.setListener(this.i);
    L184:
        m58.u r43 = m58.h.l;
        if (r43 == null) goto L187;
        String r110 = r43.l(this.a);
    L188:
        a0 r44 = a0.a;
        BusinessTypeEnum r45 = BusinessTypeEnum.ASR;
        y58.a r46 = this.g;
        if (r46 == null) goto L191;
        x58.a r47 = r46.C;
    L192:
        final int r48 = a0.l(r44, r45, r47, r46, null, this.f, r110);
        m58.k r49 = c68.a.c("after start sami session");
        if (r49 == null) goto L209;
        com.larus.audio.utils.b r50 = (com.larus.audio.utils.b) r49;
        r50.c(i(new h(this, r48)));
        r50.d("AsrTask.startSession");
        y58.a r51 = this.g;
        if (r51 == null) goto L199;
        y58.d r52 = r51.z;
        if (r52 == null) goto L199;
        String r53 = r52.a;
    L200:
        if (r53 == null) goto L203;
        r2 = r53;
    L203:
        r50.b(CollectionsKt.listOf(r2));
        y58.a r54 = this.g;
        if (r54 == null) goto L208;
        y58.d r55 = r54.z;
        if (r55 == null) goto L208;
        r3 = r55.b;
    L208:
        r50.e(r3);
        m58.k.a.a(r50);
    L199:
        r53 = null;
    L209:
        ReentrantLock r56 = this.m;
        if (r56 == null) goto L212;
        r56.unlock();
    L212:
        AsrState r57 = AsrState.ASR_STARTED;
        this.l = r57;
        h68.d r59 = this.h;
        if (r59 == null) goto L222;
        r59.e(r57);
        return;
    L222:
        return;
    L191:
        r47 = null;
        goto L192
    L187:
        r110 = null;
        goto L188
    L160:
        this.d = false;
        this.f = new com.larus.audio.audiov3.task.sami.v2.flow.a();
        a0 r60 = a0.a;
        y58.a r61 = this.g;
        if (r61 == null) goto L163;
        x58.a r62 = r61.C;
    L164:
        com.larus.audio.audiov3.task.sami.v2.flow.a r63 = this.f;
        Function0 r64 = new f(this);
        r60.getClass();
        final int r65 = a0.f(r62, r63, r64);
        m58.k r66 = c68.a.c("start sami connect use new SAMICore");
        if (r66 == null) goto L181;
        com.larus.audio.utils.b r67 = (com.larus.audio.utils.b) r66;
        r67.c(i(new g(this, r65)));
        r67.d("AsrTask.startSession");
        y58.a r68 = this.g;
        if (r68 == null) goto L171;
        y58.d r69 = r68.z;
        if (r69 == null) goto L171;
        String r70 = r69.a;
    L172:
        if (r70 != null) goto L174;
        r70 = "";
    L174:
        r67.b(CollectionsKt.listOf(r70));
        y58.a r71 = this.g;
        if (r71 == null) goto L179;
        y58.d r72 = r71.z;
        if (r72 == null) goto L179;
        String r73 = r72.b;
    L180:
        r67.e(r73);
        m58.k.a.a(r67);
    L179:
        r73 = null;
    L171:
        r70 = null;
        goto L172
    L163:
        r62 = null;
        goto L164
    L89:
        if (r29 > 0) goto L91;
        if (r29 != (-1)) goto L139;
    L91:
        this.d = false;
        m58.q r74 = m58.h.d;
        if (r74 == null) goto L96;
        ASRModule r75 = r74.c();
        if (r75 == null) goto L96;
        final long r76 = r75.f();
    L97:
        m58.q r77 = m58.h.d;
        if (r77 == null) goto L102;
        ASRModule r79 = r77.c();
        if (r79 == null) goto L102;
        final int r80 = r79.g();
    L103:
        if (r29 == (-1)) goto L109;
        m58.q r81 = m58.h.d;
        if (r81 == null) goto L109;
        ASRModule r82 = r81.c();
        if (r82 == null) goto L109;
        r82.a(r29 - 1);
    L109:
        FlowMockSamiCore r83 = new FlowMockSamiCore();
        r83.d = r76;
        MockEventType.Companion.getClass();
        Iterator r84 = MockEventType.getEntries().iterator();
    L111:
        if (r84.hasNext() == false) goto L118;
        Object r111 = r84.next();
        if (((MockEventType) r111).getType() != r80) goto L115;
        boolean r112 = true;
    L116:
        if (r112 == false) goto L111;
    L119:
        MockEventType r113 = (MockEventType) r111;
        if (r113 != null) goto L122;
        r113 = MockEventType.NONE;
    L122:
        r83.c = r113;
        this.f = r83;
        m58.k r85 = c68.a.c("start sami connect use mock sami core");
        if (r85 == null) goto L181;
        com.larus.audio.utils.b r86 = (com.larus.audio.utils.b) r85;
        r86.c(i(new c(this, r76, r80)));
        r86.d("AsrTask.startSession");
        y58.a r87 = this.g;
        if (r87 == null) goto L129;
        y58.d r88 = r87.z;
        if (r88 == null) goto L129;
        String r89 = r88.a;
    L130:
        if (r89 != null) goto L132;
        r89 = "";
    L132:
        r86.b(CollectionsKt.listOf(r89));
        y58.a r90 = this.g;
        if (r90 == null) goto L137;
        y58.d r91 = r90.z;
        if (r91 == null) goto L137;
        String r92 = r91.b;
    L138:
        r86.e(r92);
        m58.k.a.a(r86);
    L137:
        r92 = null;
    L129:
        r89 = null;
        goto L130
    L115:
        r112 = false;
        goto L116
    L118:
        r111 = null;
    L102:
        r80 = 0;
    L96:
        r76 = 0;
    L86:
        r32 = false;
    L78:
        r29 = 0;
        goto L79
    L72:
        r25 = z.a().d();
        goto L73
    L63:
        if (r19.t != true) goto L65;
        r23 = true;
        goto L66
    L57:
        if (r19.l != 4) goto L59;
        r22 = true;
        goto L60
    L51:
        if (r19.l != 3) goto L53;
        r21 = true;
    L69:
        r24 = true;
        goto L70
    L45:
        if (r19.l != 2) goto L47;
        r20 = true;
        goto L48
    }

    @Override // h68.e
    public final long e() {
        long r0 = SystemClock.elapsedRealtime() - this.q;
        this.r = r0;
        return r0;
    }

    @Override // h68.e
    public final boolean b() {
        return this.t;
    }

    @Override // h68.e
    public final AsrState d() {
        return this.l;
    }

    @Override // h68.e
    public final y58.a getConfig() {
        return this.g;
    }

    @Override // h68.e
    public final String getTaskId() {
        return this.a;
    }

    public final String toString() {
        return this.y;
    }

    public x(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        this.a = r3;
        this.b = "AsrTask";
        this.c = new Gson();
        this.j = true;
        this.k = "";
        this.l = AsrState.ASR_IDLE;
        this.m = new ReentrantLock();
        this.n = ConnectStatusEnum.DISABLE;
        this.p = "";
        this.r = -1;
        this.u = "";
        this.v = "";
        this.w = "";
        this.y = "taskId: null";
    }

    @Override // h68.e
    public final void f(h68.d r1) {
        this.h = r1;
    }

    @Override // h68.e
    public final void g(com.larus.audio.report.h r1) {
        this.z = r1;
    }

    public final String h(String r4) {
        String r0 = this.w;
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L11;
        String r1 = r4 + " asr_log_id=" + r0;
        if (r1 != null) goto L10;
        return r4;
    L10:
        return r1;
    L11:
        return r4;
    }

    public final Map<String, String> i(Function1<? super Map<String, String>, Unit> r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        r3.invoke(r0);
        String r4 = this.w;
        if ((!StringsKt.isBlank(r4)) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L8;
        r0.put("asr_log_id", r4);
    L8:
        return r0;
    }

    public final void j(ConnectStatusEnum r4) {
        this.n = r4;
        if (this.f != null) goto L5;
        return;
    L5:
        int r0 = c68.b.a;
        c68.b.a(this.b, h(this + " connectStatusEnum:" + r4 + b0.a(this.f)));
    }

    public final void k(Object r2) {
        if ((r2 instanceof y58.a) == false) goto L10;
        y58.a r3 = (y58.a) r2;
        this.g = r3;
        if (r3 == null) goto L8;
        String r4 = r3.b;
        if (r4 == null) goto L8;
    L9:
        this.y = "taskId: ".concat(r4);
        return;
    L8:
        r4 = "null";
        goto L9
    L10:
        int r5 = c68.b.a;
        c68.b.b(this.b, h("#config current asrData is invalidate !!!"));
    }

    public final void m(y58.b r2) {
        if (r2.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        h68.d r1 = this.h;
        if (r1 == null) goto L12;
        r1.a(r2);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // h68.e
    public final synchronized int a(byte[] r8, int r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "buffer");     // Catch: Throwable -> L91
        ReentrantLock r0 = this.m;     // Catch: Throwable -> L91
        if (r0 == null) goto L6;
        r0.lock();     // Catch: Throwable -> L91
    L6:
        String r1 = null;
        if (this.j == true) goto L9;
    L69:
        ReentrantLock r10 = this.m;     // Catch: Throwable -> L91
        if (r10 == null) goto L72;
        r10.unlock();     // Catch: Throwable -> L91
    L72:
        m58.k r11 = c68.a.d("write AsrTask Failed because it has not been started");     // Catch: Throwable -> L91
        if (r11 == null) goto L88;
        com.larus.audio.utils.b r12 = (com.larus.audio.utils.b) r11;     // Catch: Throwable -> L91
        r12.c(i(new u(this)));     // Catch: Throwable -> L91
        r12.d("AsrTask.write");     // Catch: Throwable -> L91
        y58.a r13 = this.g;     // Catch: Throwable -> L91
        if (r13 == null) goto L79;
        y58.d r14 = r13.z;     // Catch: Throwable -> L91
        if (r14 == null) goto L79;
        String r15 = r14.a;     // Catch: Throwable -> L91
    L80:
        if (r15 != null) goto L82;
        r15 = "";
    L82:
        r12.b(CollectionsKt.listOf(r15));     // Catch: Throwable -> L91
        y58.a r16 = this.g;     // Catch: Throwable -> L91
        if (r16 == null) goto L87;
        y58.d r17 = r16.z;     // Catch: Throwable -> L91
        if (r17 == null) goto L87;
        r1 = r17.b;     // Catch: Throwable -> L91
    L87:
        r12.e(r1);     // Catch: Throwable -> L91
        m58.k.a.a(r12);     // Catch: Throwable -> L91
    L79:
        r15 = null;
    L88:
        monitor-exit(this);
        return -1;
    L9:
        if (this.l != AsrState.ASR_STARTED) goto L69;
        if (this.s == true) goto L69;
        com.larus.audio.audiov3.task.sami.v2.flow.a r2 = this.f;     // Catch: Throwable -> L91
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L69;
        if (this.s == false) goto L43;
        m58.k r19 = c68.a.d("write AsrTask Failed because sessionFinished");     // Catch: Throwable -> L91
        if (r19 == null) goto L38;
        com.larus.audio.utils.b r20 = (com.larus.audio.utils.b) r19;     // Catch: Throwable -> L91
        r20.c(i(new v(this)));     // Catch: Throwable -> L91
        r20.d("AsrTask.write");     // Catch: Throwable -> L91
        y58.a r21 = this.g;     // Catch: Throwable -> L91
        if (r21 == null) goto L29;
        y58.d r22 = r21.z;     // Catch: Throwable -> L91
        if (r22 == null) goto L29;
        String r23 = r22.a;     // Catch: Throwable -> L91
    L30:
        if (r23 != null) goto L32;
        r23 = "";
    L32:
        r20.b(CollectionsKt.listOf(r23));     // Catch: Throwable -> L91
        y58.a r24 = this.g;     // Catch: Throwable -> L91
        if (r24 == null) goto L37;
        y58.d r25 = r24.z;     // Catch: Throwable -> L91
        if (r25 == null) goto L37;
        r1 = r25.b;     // Catch: Throwable -> L91
    L37:
        r20.e(r1);     // Catch: Throwable -> L91
        m58.k.a.a(r20);     // Catch: Throwable -> L91
    L29:
        r23 = null;
    L38:
        ReentrantLock r26 = this.m;     // Catch: Throwable -> L91
        if (r26 == null) goto L41;
        r26.unlock();     // Catch: Throwable -> L91
    L41:
        monitor-exit(this);
        return 0;
    L43:
        a0 r4 = a0.a;     // Catch: Throwable -> L91
        String r5 = this.a;     // Catch: Throwable -> L91
        com.larus.audio.audiov3.task.sami.v2.flow.a r6 = this.f;     // Catch: Throwable -> L91
        r4.getClass();     // Catch: Throwable -> L91
        final int r27 = a0.n(r5, r8, r9, r6);     // Catch: Throwable -> L91
        if (r27 != 0) goto L48;
        com.larus.audio.report.h r29 = this.z;     // Catch: Throwable -> L91
        if (r29 == null) goto L64;
        r29.p(0);     // Catch: Throwable -> L91
    L64:
        ReentrantLock r30 = this.m;     // Catch: Throwable -> L91
        if (r30 == null) goto L67;
        r30.unlock();     // Catch: Throwable -> L91
    L67:
        monitor-exit(this);
        return r27;
    L48:
        m58.k r31 = c68.a.d("write AsrTask Failed");     // Catch: Throwable -> L91
        if (r31 == null) goto L64;
        com.larus.audio.utils.b r32 = (com.larus.audio.utils.b) r31;     // Catch: Throwable -> L91
        r32.c(i(new w(this, r27)));     // Catch: Throwable -> L91
        r32.d("AsrTask.write");     // Catch: Throwable -> L91
        y58.a r7 = this.g;     // Catch: Throwable -> L91
        if (r7 == null) goto L55;
        y58.d r33 = r7.z;     // Catch: Throwable -> L91
        if (r33 == null) goto L55;
        String r34 = r33.a;     // Catch: Throwable -> L91
    L56:
        if (r34 != null) goto L58;
        r34 = "";
    L58:
        r32.b(CollectionsKt.listOf(r34));     // Catch: Throwable -> L91
        y58.a r35 = this.g;     // Catch: Throwable -> L91
        if (r35 == null) goto L63;
        y58.d r36 = r35.z;     // Catch: Throwable -> L91
        if (r36 == null) goto L63;
        r1 = r36.b;     // Catch: Throwable -> L91
    L63:
        r32.e(r1);     // Catch: Throwable -> L91
        m58.k.a.a(r32);     // Catch: Throwable -> L91
    L55:
        r34 = null;
        goto L56
    L15:
        if (r2.getHandle() != 0) goto L17;
        r3 = true;
    L91:
        th = move-exception;
        throw th;
    }

    @Override // h68.e
    public final void c(String r8, Object r9, Object r10, Object r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if ((r9 instanceof SAMICorePropertyId) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof SAMICoreDataType) == true) goto L7;
        return;
    L7:
        if ((r11 instanceof SAMICoreVoiceAssistantPropertyParameter) == false) goto L24;
        a0 r1 = a0.a;
        y58.a r2 = this.g;
        if (r2 == null) goto L11;
        String r3 = r2.b;
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        SAMICorePropertyId r12 = (SAMICorePropertyId) r9;
        SAMICoreDataType r13 = (SAMICoreDataType) r10;
        SAMICoreVoiceAssistantPropertyParameter r14 = (SAMICoreVoiceAssistantPropertyParameter) r11;
        com.larus.audio.audiov3.task.sami.v2.flow.a r4 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "param");
        if (r4 != null) goto L17;
    L20:
        int r15 = c68.b.a;
        c68.b.b("TaskGenerator", "updateScreenshotForAsr failed, context: " + r8 + ", samiCore: " + b0.a(r4));
        return;
    L17:
        if (r4.getHandle() == 0) goto L20;
        int r5 = c68.b.a;
        c68.b.a("TaskGenerator", "updateScreenshotForAsr context: ".concat(r8));
        a0.h(r12, r13, r14, r4);
        return;
    L11:
        r3 = null;
        goto L12
    }
}
