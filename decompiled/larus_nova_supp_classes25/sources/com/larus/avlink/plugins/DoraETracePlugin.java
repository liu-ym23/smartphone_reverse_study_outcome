package com.larus.avlink.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.annoatation.DoraImageMode;
import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.DoraImageManager;
import com.larus.avlink.e.l;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.DoraTraceParam;
import com.larus.voicecall.api.bean.VisionIntentionItem;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraETracePlugin extends com.larus.audio.call.arch.a<n4> implements q4, o4 {
    public static DoraETracePlugin p;
    public volatile a5 f;
    public a5 g;
    public Boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final Lazy l;
    public d m;
    public final Lazy n;
    public final b o;

    public static final class a {
        public static int a() {
            DoraETracePlugin r0 = DoraETracePlugin.p;
            if (r0 == null) goto L11;
            n4 r1 = (n4) r0.getContext();
            if (r1 == null) goto L11;
            RealtimeCallParam r2 = r1.params();
            if (r2 == null) goto L11;
            AudioSessionType r3 = r2.s;
            if (r3 == null) goto L11;
        L13:
            return r3.getType();
        L11:
            r3 = AudioSessionType.SAMI;
            goto L13
        }

        public static boolean b(Integer r3) {
            DoraETracePlugin r0 = DoraETracePlugin.p;
            if (r0 == null) goto L18;
            if (r3 == null) goto L18;
            r3.intValue();
            if (r3.intValue() != 130) goto L9;
        L17:
            return true;
        L9:
            if (r3.intValue() == 5) goto L17;
            if (r3.intValue() != 4) goto L18;
            if (r0.j == false) goto L18;
            if (r0.k == false) goto L17;
        L18:
            return false;
        }
    }

    public static final class b implements com.larus.avlink.e.s {
        public final /* synthetic */ DoraETracePlugin a;

        @Override // com.larus.avlink.e.s
        public final boolean D0(int r1, int r2, int r3, int r4, int r5) {
            return false;
        }

        @Override // com.larus.avlink.e.s
        public final void j(boolean r1, int r2, byte r3) {
        }

        @Override // com.larus.avlink.e.s
        public final void M() {
            a5 r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.x = Long.valueOf(System.currentTimeMillis());
        L5:
            this.a.k3("reportTakePicture");
        }

        public b(DoraETracePlugin r1) {
            this.a = r1;
        }

        @Override // com.larus.avlink.e.s
        public final void w(b49.k r5) {
            Intrinsics.checkNotNullParameter(r5, "info");
            DoraETracePlugin r0 = this.a;
            a5 r1 = r0.f;
            if (r1 == null) goto L6;
            r1.Z = System.currentTimeMillis();
            r1.a0 = r5.a;
            r1.b0 = r5.b;
            r1.c0 = r5.c;
            r0.j3(0, false);
            return;
        }

        @Override // com.larus.avlink.e.s
        public final void p1(com.larus.avlink.model.a r1, DoraImageEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }
    }

    public static final class c implements com.larus.im.service.audio.v {
        public final /* synthetic */ DoraETracePlugin a;

        public final String getName() {
            this.a.getClass();
            return "DoraETracePlugin";
        }

        public c(DoraETracePlugin r1) {
            this.a = r1;
        }

        public final void O1(jd9.c r2, jd9.c r3) {
            Intrinsics.checkNotNullParameter(r2, "oldState");
            Intrinsics.checkNotNullParameter(r3, "newState");
            if ((r3 instanceof jd9.c.a) == false) goto L5;
            return;
        L5:
            if ((r3 instanceof jd9.c.d) == false) goto L9;
            this.a.f = null;
            this.a.m3();
            return;
        }
    }

    public static final class d extends com.larus.audio.call.play.e {
        public final /* synthetic */ DoraETracePlugin a;

        public final void c() {
            this.a.getClass();
            com.larus.avlink.n1.d("DoraETracePlugin", "onPlayFirstFrame.");
            a5 r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.m = Long.valueOf(System.currentTimeMillis());
        L5:
            this.a.j3(0, false);
        }

        public d(DoraETracePlugin r1) {
            this.a = r1;
        }

        public final void b(Map<String, String> r3) {
            this.a.getClass();
            com.larus.avlink.n1.d("DoraETracePlugin", "onTTSStart.");
            a5 r4 = this.a.f;
            if (r4 == null) goto L6;
            r4.l = Long.valueOf(System.currentTimeMillis());
            return;
        }
    }

    static {
    }

    public final String T2() {
        return "DoraETracePlugin";
    }

    public final com.larus.im.service.audio.v R2() {
        return new c(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new DoraETracePlugin$createSessionListener$1(this);
    }

    public final a5 l3() {
        if (this.f != null) goto L16;
        KClass r0 = Reflection.getOrCreateKotlinClass(DoraETracePlugin.class);
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f != null) goto L9;
        this.f = new a5(((n4) getContext()).x(), ((n4) getContext()).E(), ((n4) getContext()).params().s.getType(), ((n4) getContext()).A(), ((n4) getContext()).q());     // Catch: Throwable -> L12
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    L16:
        return this.f;
    }

    public final void e3() {
        super.e3();
        p = this;
        d r0 = new d(this);
        this.m = r0;
        l4 r1 = (l4) this.n.getValue();
        if (r1 == null) goto L7;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L7;
        r2.i(r0);
    L7:
        l r3 = l.a;
        b r4 = this.o;
        if (r4 == null) goto L12;
        l.c.add(r4);
        return;
    }

    public final void g3() {
        super.g3();
        m3();
        d r0 = this.m;
        if (r0 == null) goto L9;
        l4 r1 = (l4) this.n.getValue();
        if (r1 == null) goto L9;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L9;
        r2.j(r0);
    L9:
        this.f = null;
        p = null;
        l r3 = l.a;
        b r4 = this.o;
        if (r4 == null) goto L14;
        l.c.remove(r4);
        return;
    }

    public final void m3() {
        long r0 = System.currentTimeMillis();
        a5 r2 = this.f;
        if (r2 == null) goto L7;
        Long r3 = r2.i;
        if (r3 == null) goto L7;
        long r4 = r3.longValue();
    L9:
        if ((r0 - r4) < 30000) goto L11;
        j3(1, true);
        return;
    L11:
        j3(2, true);
        return;
    L7:
        r4 = r0;
        goto L9
    }

    public DoraETracePlugin(final n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.i = true;
        this.l = LazyKt.lazy(new e0(r2));
        this.n = LazyKt.lazy(new f0(r2));
        this.o = new b(this);
    }

    @Override // com.larus.avlink.plugins.q4
    public final void P1(c0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "command");
        c0.b r6 = r5.b();
        if (r6 == null) goto L5;
        int r7 = r6.b();
    L6:
        a5 r0 = this.f;
        if (r0 == null) goto L9;
        r0.H = System.currentTimeMillis();
    L9:
        k3("asrIntent");
        long r1 = System.currentTimeMillis();
        a5 r2 = this.f;
        if (r2 == null) goto L14;
        Long r3 = r2.k;
        if (r3 == null) goto L14;
        long r4 = r3.longValue();
    L15:
        long r8 = r1 - r4;
        Pair<String, Boolean> r9 = DoraETracer.a;
        DoraETracer.e((String) this.l.getValue(), r7, r8);
        return;
    L14:
        r4 = r1;
        goto L15
    L5:
        r7 = -1;
        goto L6
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r1) {
        this.h = null;
    }

    @Override // com.larus.avlink.plugins.q4
    public final void U0(VisionIntentionItem r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        boolean r1 = true;
        String r2 = null;
        if (r6.getHighQuality() == false) goto L9;
        a5 r0 = this.f;
        if (r0 == null) goto L7;
        r0.r = 1;
    L7:
        this.g = this.f;
        this.f = null;
    L9:
        if (this.f != null) goto L11;
        this.f = l3();
    L11:
        a5 r3 = this.f;
        if (r3 == null) goto L14;
        r3.H = System.currentTimeMillis();
    L14:
        a5 r4 = this.f;
        if (r4 == null) goto L17;
        r2 = r4.f;
    L17:
        if (r2 != null) goto L19;
    L22:
        if (r1 == false) goto L26;
        a5 r5 = this.f;
        if (r5 == null) goto L26;
        Intrinsics.checkNotNullParameter("trigger_llm_hd", "<set-?>");
        r5.f = "trigger_llm_hd";
    L26:
        k3("llm");
        long r7 = System.currentTimeMillis();
        a5 r8 = this.f;
        if (r8 == null) goto L31;
        Long r9 = r8.i;
        if (r9 == null) goto L31;
        long r10 = r9.longValue();
    L32:
        long r11 = r7 - r10;
        Pair<String, Boolean> r12 = DoraETracer.a;
        String r13 = (String) this.l.getValue();
        Integer r14 = r6.getSource();
        if (r14 == null) goto L35;
        int r15 = r14.intValue();
    L36:
        DoraETracer.e(r13, r15, r11);
        return;
    L35:
        r15 = -1;
    L31:
        r10 = r7;
        goto L32
    L19:
        if (r2.length() == 0) goto L22;
        r1 = false;
        goto L22
    }

    public final void k3(String r12) {
        StringBuilder r0 = new StringBuilder("try reportVisionQueryStart from ");
        r0.append(r12);
        r0.append(' ');
        a5 r13 = this.f;
        Integer r1 = null;
        if (r13 == null) goto L5;
        Integer r14 = Integer.valueOf(r13.hashCode());
    L6:
        r0.append(r14);
        com.larus.avlink.n1.a("DoraETracePlugin", r0.toString());
        a5 r15 = this.f;
        int r2 = -1;
        boolean r4 = false;
        long r5 = 0;
        if (r15 == null) goto L44;
        com.larus.avlink.model.a r7 = r15.b();
        Long r8 = r15.i;
        if (r8 == null) goto L11;
        long r9 = r8.longValue();
    L13:
        if (r9 > 0) goto L16;
        int r16 = -1;
    L43:
        Integer r17 = Integer.valueOf(r16);
    L45:
        com.larus.avlink.n1.d("DoraETracePlugin", "query start valid: " + r17);
        if (r17 != null) goto L49;
    L88:
        com.larus.avlink.n1.a("DoraETracePlugin", "reportVisionQueryStart: invalid traceModel: " + r17);
        return;
    L49:
        if (r17.intValue() != 0) goto L88;
        a5 r10 = this.f;
        if (r10 != null) goto L53;
    L55:
        boolean r11 = false;
    L56:
        if (r11 == true) goto L88;
        Pair<String, Boolean> r18 = DoraETracer.a;
        a5 r19 = this.f;
        LinkedHashMap r3 = new LinkedHashMap();
        if (r19 == null) goto L60;
        r1 = Integer.valueOf(r19.e);
    L60:
        if (r19 == null) goto L66;
        com.larus.avlink.model.a r20 = r19.b();
        if (r20 == null) goto L66;
        Integer r21 = r20.a;
        if (r21 == null) goto L66;
        r2 = r21.intValue();
    L66:
        if (r19 == null) goto L69;
        String r22 = r19.f;
        if (r22 == null) goto L69;
    L70:
        if (r19 == null) goto L72;
        r5 = r19.a();
    L72:
        com.larus.avlink.n1.a("DoraETracer", "reportVisionQueryStart picId: " + r2 + ", wakeModel: " + r1);
        if (r19 != null) goto L75;
    L77:
        if (r4 == true) goto L82;
        Map<String, com.larus.avlink.model.a> r6 = DoraImageManager.a;
        com.larus.avlink.model.a r23 = DoraImageManager.a(Integer.valueOf(r2));
        com.larus.avlink.n1.a("DoraETracer", "reportVisionQueryStart picId: " + r2 + ", picModel: " + r23);
        if (r23 == null) goto L85;
        DoraETracer.a(r3, r23);
    L85:
        a5 r110 = this.f;
        if (r110 == null) goto L90;
        r110.n = true;
        return;
    L90:
        return;
    L82:
        r3.put("message_id", r22);
        r3.put("query_duration", Long.valueOf(r5));
        DoraETracer.b(r3, r19);
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L85;
        r111.A0("flow_dora_vision_query_start", r3);
        goto L85
    L75:
        if (r19.d != true) goto L77;
        r4 = true;
    L69:
        r22 = "";
        goto L70
    L53:
        if (r10.n != true) goto L55;
        r11 = true;
        goto L56
    L16:
        if (v88.a.a(Integer.valueOf(r15.e)) == false) goto L18;
    L42:
        r16 = 0;
        goto L43
    L18:
        if (r15.d == true) goto L42;
        if (r7 != null) goto L21;
        r16 = -2;
        goto L43
    L21:
        DoraImageMode.a r112 = DoraImageMode.Companion;
        Integer r24 = Integer.valueOf(r7.m);
        r112.getClass();
        if (r24 == null) goto L36;
        r24.intValue();
        if (r24.intValue() != 1) goto L26;
    L35:
        boolean r113 = true;
    L37:
        if (r113 == true) goto L40;
        r16 = -3;
        goto L43
    L40:
        if (r7.n != null) goto L42;
        r16 = -4;
        goto L43
    L26:
        if (r24.intValue() == 6) goto L35;
        if (r24.intValue() == 7) goto L35;
        if (r24.intValue() == 10) goto L35;
        if (r24.intValue() == 2) goto L35;
        if (r24.intValue() == 17) goto L35;
    L36:
        r113 = false;
        goto L37
    L11:
        r9 = 0;
        goto L13
    L44:
        r17 = null;
        goto L45
    L5:
        r14 = null;
        goto L6
    }

    public final void j3(int r60, boolean r61) {
        a5 r2 = this.f;
        a5 r3 = this.g;
        if (r3 == null) goto L6;
        this.g = null;
        r2 = r3;
    L6:
        if (r2 == null) goto L44;
        Integer r9 = Integer.valueOf(r60);
        l4 r10 = (l4) this.n.getValue();
        if (r10 != null) goto L10;
    L12:
        boolean r11 = false;
    L13:
        Long r12 = r2.i;
        if (r12 == null) goto L16;
        long r13 = r12.longValue();
    L18:
        if (r13 > 0) goto L20;
        int r14 = -1;
    L43:
        Integer r15 = Integer.valueOf(r14);
    L45:
        com.larus.avlink.n1.d("DoraETracePlugin", "query end valid: " + r15 + ", force: " + r61 + ", status: " + r60);
        if (r61 == true) goto L51;
        if (r15 != null) goto L50;
        return;
    L50:
        if (r15.intValue() == 0) goto L51;
        return;
    L51:
        if (r2 != null) goto L53;
    L55:
        boolean r1 = false;
    L56:
        if (r1 == false) goto L402;
        long r16 = System.currentTimeMillis();
        if (r2 == null) goto L60;
        Long r4 = r2.s;
    L61:
        if (r2 == null) goto L63;
        Long r17 = r2.i;
    L64:
        com.larus.avlink.model.a r18 = r2.b();
        if (r18 == null) goto L69;
        Long r19 = r18.b(DoraImageEvent.IMAGE_UPLOAD_FINISH);
        if (r19 == null) goto L69;
        long r110 = r19.longValue();
    L70:
        Pair<String, Boolean> r111 = DoraETracer.a;
        if (r18 == null) goto L75;
        Integer r112 = r18.a;
        if (r112 == null) goto L75;
        int r113 = r112.intValue();
    L76:
        String r5 = r2.h;
        Long r6 = r2.l;
        if (r6 == null) goto L79;
        long r114 = r6.longValue();
    L80:
        if (r17 == null) goto L82;
        long r115 = r17.longValue();
    L83:
        long r116 = r114 - r115;
        long r20 = r16 - r110;
        long r117 = r2.a();
        Long r7 = r2.o;
        Long r8 = r2.p;
        Long r21 = r2.q;
        Long r22 = r2.j;
        if (r22 == null) goto L86;
        long r23 = r22.longValue();
    L87:
        if (r4 == null) goto L89;
        long r24 = r4.longValue();
    L90:
        Long r25 = Long.valueOf(r23 - r24);
        Long r26 = r2.j;
        if (r26 == null) goto L93;
        long r27 = r26.longValue();
    L94:
        Long r28 = Long.valueOf(r27);
        int r29 = r2.r;
        String r118 = r2.t;
        String r119 = r2.u;
        String r120 = r2.v;
        Boolean r121 = r2.w;
        Long r30 = r2.x;
        if (r30 == null) goto L97;
        long r210 = r30.longValue();
    L98:
        if (r17 == null) goto L100;
        long r211 = r17.longValue();
    L101:
        Long r31 = Long.valueOf(RangesKt.coerceAtLeast(r210 - r211, 0));
        Long r32 = r2.m;
        if (r32 != null) goto L104;
    L118:
        long r122 = 0;
    L119:
        Long r33 = Long.valueOf(r122);
        Long r123 = r2.y;
        Long r124 = r2.z;
        Long r125 = r2.K;
        Long r126 = r2.L;
        Long r127 = r2.M;
        Long r128 = r2.N;
        Long r129 = r2.O;
        Long r130 = r2.P;
        Long r131 = r2.R;
        Long r132 = r2.S;
        Long r133 = r2.T;
        Long r134 = r2.U;
        Long r135 = r2.V;
        Long r136 = r2.W;
        String r137 = r2.X;
        int r41 = ((n4) getContext()).q();
        l4 r138 = (l4) this.n.getValue();
        if (r138 == null) goto L122;
        Boolean r139 = Boolean.valueOf(r138.d1());
    L123:
        Intrinsics.checkNotNullParameter(r2, "model");
        Boolean r43 = r139;
        com.larus.avlink.n1.a("DoraETracer", "reportVisionQueryEnd picId: " + r113);
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2.d == true) goto L209;
        Map<String, com.larus.avlink.model.a> r140 = DoraImageManager.a;
        com.larus.avlink.model.a r141 = DoraImageManager.a(Integer.valueOf(r113));
        com.larus.avlink.n1.a("DoraETracer", "reportVisionQueryEnd picId: " + r113 + ", picModel: " + r141);
        if (r141 == null) goto L399;
        Map<DoraImageEvent, z98.d> r34 = r141.M;
        DoraImageEvent r142 = DoraImageEvent.IMAGE_UPLOAD_FINISH;
        z98.d r35 = r34.get(r142);
        if (r35 != null) goto L131;
    L133:
        boolean r36 = false;
    L134:
        if (r36 == false) goto L136;
        int r37 = 0;
    L153:
        r0.put("pic_status", Integer.valueOf(r37));
        DoraETracer.a(r0, r141);
        if (r141.p == false) goto L164;
        Long r38 = r141.w;
        if (r38 == null) goto L158;
        long r47 = r38.longValue();
    L159:
        Long r39 = r141.b(r142);
        if (r39 == null) goto L162;
        long r49 = r39.longValue();
    L163:
        r0.put("ocr_duration", Long.valueOf(r47 - r49));
        goto L164
    L162:
        r49 = System.currentTimeMillis();
        goto L163
    L158:
        r47 = System.currentTimeMillis();
    L164:
        r0.put("camera_output_strategy", Integer.valueOf(r141.E));
        r0.put("ocr_text_lines", Integer.valueOf(r141.F));
        DoraImageMode.a r40 = DoraImageMode.Companion;
        Integer r143 = r141.n;
        r40.getClass();
        if (r143 == null) goto L171;
        r143.intValue();
        Long r48 = r21;
        if (r143.intValue() != 7) goto L169;
    L170:
        boolean r42 = true;
    L173:
        if (r42 == false) goto L177;
        r0.put("query_identify_intention_duration", Long.valueOf(r2.H - j0.a(r2.k)));
        r0.put("pic_identify_intention_duration", Long.valueOf(r2.H - r2.G));
    L177:
        if (r141.m != 10) goto L207;
        IDoraService r44 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r44 == null) goto L185;
        VisionService r45 = r44.V();
        if (r45 == null) goto L185;
        if (r45.n() != true) goto L185;
        int r46 = 1;
    L186:
        r0.put("pre_capture_upload_switch", Integer.valueOf(r46));
        long r50 = j0.a(r141.b(DoraImageEvent.TAKE_PHOTO_CMD_SEND));
        long r144 = j0.a(r141.b(r142));
        if (r46 == 0) goto L189;
        long r51 = r144 - r50;
    L190:
        long r145 = r2.H - r50;
        long r52 = RangesKt.coerceAtMost(r145, r51);
        long r53 = r144 - j0.a(r2.i);
        Long r54 = r25;
        FLogger r55 = FLogger.a;
        r55.i("DoraETracer", "receiveIntentionTime: " + r2.H + ", imageCMDSyncTime: " + r50 + ", picUploadFinishTime: " + r144);
        r55.i("DoraETracer", "intentArrivedToPrecaptureCMDSync: " + r145 + ", imageUploadFinishToAsrEnd: " + r53 + ", precaptureMaxTime: " + r51 + ", intentArrivedToPrecaptureCMDSyncMax: " + r52);
        if (r53 <= 0) goto L193;
    L196:
        int r146 = 1;
    L197:
        LinkedHashMap r56 = r0;
        r56.put("precapture_valid", Integer.valueOf(r146));
        if (r146 == 0) goto L205;
        if (r53 <= 0) goto L202;
        long r57 = r52;
    L206:
        r56.put("precapture_time", Long.valueOf(r57));
    L208:
        r56.put("duration_from_imgUpload", Long.valueOf(r20));
    L210:
        Boolean r58 = Boolean.TRUE;
        Boolean r59 = r121;
        if (Intrinsics.areEqual(r59, r58) == false) goto L214;
        if (r54 == null) goto L216;
        long r62 = r54.longValue();
    L218:
        if (r5 != null) goto L220;
        String r63 = "";
    L221:
        r56.put("reply_id", r63);
        r56.put("status", Integer.valueOf(r60));
        if (r28 == null) goto L224;
        long r64 = r28.longValue();
    L225:
        r56.put("duration", Long.valueOf(r116 + r64));
        r56.put("query_duration", Long.valueOf(r117));
        if (r7 == null) goto L228;
        long r65 = r7.longValue();
    L229:
        r56.put("inference_duration", Long.valueOf(r65));
        if (r8 == null) goto L232;
        long r66 = r8.longValue();
    L233:
        r56.put("vui_engine_duration", Long.valueOf(r66));
        if (r48 == null) goto L236;
        long r67 = r48.longValue();
    L237:
        r56.put("pic_load_duration_ms", Long.valueOf(r67));
        r56.put("is_fix_reply", Integer.valueOf(r29));
        if (r59 != null) goto L241;
        int r147 = -1;
    L244:
        r56.put("hit_prequery", Integer.valueOf(r147));
        if (r28 == null) goto L247;
        long r68 = r28.longValue();
    L248:
        r56.put("hard_vad_duration", Long.valueOf(r68));
        if (r54 == null) goto L251;
        long r69 = r54.longValue();
    L252:
        r56.put("soft_vad_duration", Long.valueOf(r69));
        if (r31 == null) goto L255;
        long r70 = r31.longValue();
    L257:
        if (Intrinsics.areEqual(r59, r58) == false) goto L265;
        if (r28 == null) goto L260;
        long r148 = r28.longValue();
    L261:
        if (r54 == null) goto L263;
        long r149 = r54.longValue();
    L264:
        long r150 = r148 - r149;
    L266:
        r56.put("llm_trigger_bot_duration", Long.valueOf(r70 + r150));
        r56.put("vad_duration", Long.valueOf(r62));
        Long r71 = r2.l;
        if (r71 == null) goto L269;
        long r72 = r71.longValue();
    L270:
        long r73 = r72 - r2.J;
        r56.put("app_ete_duration", Long.valueOf(r73));
        if (r73 <= 0) goto L277;
        if (r136 == null) goto L277;
        if (r136.longValue() <= 0) goto L277;
        r56.put("network_trans_duration", Long.valueOf((r73 - r136.longValue()) / ((long) 2)));
    L277:
        Object r74 = r56.get("app_ete_duration");
        Intrinsics.checkNotNull(r74, "null cannot be cast to non-null type kotlin.Long");
        long r75 = ((Long) r74).longValue();
        Object r76 = r56.get("duration");
        Intrinsics.checkNotNull(r76, "null cannot be cast to non-null type kotlin.Long");
        r56.put("duration_diff", Long.valueOf(r75 - ((Long) r76).longValue()));
        if (r118 == null) goto L280;
        r56.put("intention", r118);
        Unit r77 = Unit.INSTANCE;
    L280:
        if (r119 == null) goto L282;
        r56.put("llm_intention", r119);
        Unit r78 = Unit.INSTANCE;
    L282:
        if (r120 == null) goto L284;
        r56.put("llm_intention_detail", r120);
        Unit r79 = Unit.INSTANCE;
    L284:
        if (r33 == null) goto L286;
        long r80 = r33.longValue();
    L287:
        r56.put("first_frame_play_duration", Long.valueOf(r80));
        if (r123 == null) goto L290;
        long r81 = r123.longValue();
    L291:
        r56.put("tts_sentence_duration", Long.valueOf(r81));
        if (r124 == null) goto L294;
        long r82 = r124.longValue();
    L295:
        if (r123 == null) goto L297;
        long r83 = r123.longValue();
    L298:
        r56.put("tts_synthesis_duration", Long.valueOf(RangesKt.coerceAtLeast(r82 - r83, 0)));
        if (r124 == null) goto L301;
        long r151 = r124.longValue();
    L302:
        r56.put("tts_duration", Long.valueOf(r151));
        if (r125 == null) goto L305;
        long r152 = r125.longValue();
    L306:
        r56.put("vui_uplink_duration_ms", Long.valueOf(r152));
        if (r126 == null) goto L309;
        long r153 = r126.longValue();
    L310:
        r56.put("vui_downlink_duration_ms", Long.valueOf(r153));
        if (r127 == null) goto L313;
        long r154 = r127.longValue();
    L314:
        r56.put("chat_uplink_duration_ms", Long.valueOf(r154));
        if (r128 == null) goto L317;
        long r155 = r128.longValue();
    L318:
        r56.put("chat_downlink_duration_ms", Long.valueOf(r155));
        if (r129 == null) goto L321;
        long r156 = r129.longValue();
    L322:
        r56.put("agent_uplink_duration_ms", Long.valueOf(r156));
        if (r130 == null) goto L325;
        long r157 = r130.longValue();
    L326:
        r56.put("agent_downlink_duration_ms", Long.valueOf(r157));
        r56.put("round_id", Long.valueOf(r2.C));
        r56.put("is_first_round", Integer.valueOf(r2.g ? 1 : 0));
        r56.put("duration_until_start_session", Long.valueOf(r2.D));
        if (r131 == null) goto L329;
        long r158 = r131.longValue();
    L330:
        r56.put("voice_down_to_asr_text", Long.valueOf(r158));
        if (r132 == null) goto L333;
        long r159 = r132.longValue();
    L334:
        r56.put("asr_text_to_reply_intervention", Long.valueOf(r159));
        if (r133 == null) goto L337;
        long r160 = r133.longValue();
    L338:
        r56.put("asr_text_to_first_tts_audio", Long.valueOf(r160));
        if (r134 == null) goto L341;
        long r161 = r134.longValue();
    L342:
        r56.put("voice_down_to_answer_text", Long.valueOf(r161));
        if (r135 == null) goto L345;
        long r162 = r135.longValue();
    L346:
        r56.put("answer_text_to_first_tts_audio", Long.valueOf(r162));
        if (r136 == null) goto L349;
        long r163 = r136.longValue();
    L350:
        r56.put("voice_down_to_tts_audio_sent", Long.valueOf(r163));
        if (r137 != null) goto L353;
        String r164 = "";
    L354:
        r56.put("signal_type", r164);
        r56.put("rtos_query_pre_capture_latency", Integer.valueOf(r2.b0));
        r56.put("rtos_query_sound_latency", Integer.valueOf(r2.c0));
        r56.put("hardware_ete_duration", Long.valueOf(r2.a0 - r2.I));
        long r84 = r2.Z;
        Long r85 = r2.l;
        if (r85 == null) goto L357;
        long r165 = r85.longValue();
    L358:
        r56.put("app_to_hardware_down_delay", Long.valueOf(r84 - r165));
        if (r2.d == false) goto L361;
    L366:
        r56.put("query_client_duration", Long.valueOf(r2.B - r2.A));
        r56.put("av_offset", Long.valueOf(r2.B - r2.E));
        long r86 = r2.E;
        if (r86 != 0) goto L369;
    L377:
        int r87 = -1;
    L378:
        r56.put("av_sync", Integer.valueOf(r87));
        IDoraService r88 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r88 == null) goto L385;
        AbilityService r89 = r88.o0();
        if (r89 == null) goto L385;
        if (r89.k() != true) goto L385;
        boolean r90 = true;
    L386:
        if (r90 == false) goto L388;
        int r91 = 2;
    L389:
        r56.put("trans_type", Integer.valueOf(r91));
    L390:
        r56.put("is_rtos_player", Integer.valueOf(Intrinsics.areEqual(r43, r58) ? 1 : 0));
        DoraTraceParam.b r92 = r2.Q;
        if (r92 == null) goto L393;
        r56.put("has_vision_intent", Integer.valueOf(Intrinsics.areEqual(r92.j(), r58) ? 1 : 0));
        r56.put("use_vision_info", Integer.valueOf(Intrinsics.areEqual(r92.q(), r58) ? 1 : 0));
        Unit r93 = Unit.INSTANCE;
    L393:
        String r94 = r2.F;
        if (r94 == null) goto L396;
        r56.put("trace_log_id", r94);
        Unit r95 = Unit.INSTANCE;
    L396:
        r56.put("vs2t_flag", Integer.valueOf(r2.Y));
        DoraETracer.b(r56, r2);
        IDoraService r96 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r96 == null) goto L399;
        r96.A0("flow_dora_vision_query_response", r56);
        Unit r97 = Unit.INSTANCE;
        goto L399
    L388:
        r91 = 0;
    L385:
        r90 = false;
        goto L386
    L369:
        if (r2.B == 0) goto L377;
        long r99 = r2.A;
        if (r99 == 0) goto L377;
        if (r86 <= r99) goto L376;
        r87 = 1;
        goto L378
    L376:
        r87 = 0;
        goto L378
    L361:
        if (v88.a.c(Integer.valueOf(r41)) == true) goto L366;
        if (v88.a.b(Integer.valueOf(r41)) == false) goto L390;
    L357:
        r165 = 0;
        goto L358
    L353:
        r164 = r137;
        goto L354
    L349:
        r163 = 0;
        goto L350
    L345:
        r162 = 0;
        goto L346
    L341:
        r161 = 0;
        goto L342
    L337:
        r160 = 0;
        goto L338
    L333:
        r159 = 0;
        goto L334
    L329:
        r158 = 0;
        goto L330
    L325:
        r157 = 0;
        goto L326
    L321:
        r156 = 0;
        goto L322
    L317:
        r155 = 0;
        goto L318
    L313:
        r154 = 0;
        goto L314
    L309:
        r153 = 0;
        goto L310
    L305:
        r152 = 0;
        goto L306
    L301:
        r151 = 0;
        goto L302
    L297:
        r83 = 0;
        goto L298
    L294:
        r82 = 0;
        goto L295
    L290:
        r81 = 0;
        goto L291
    L286:
        r80 = 0;
        goto L287
    L269:
        r72 = 0;
        goto L270
    L263:
        r149 = 0;
        goto L264
    L260:
        r148 = 0;
        goto L261
    L265:
        r150 = 0;
        goto L266
    L255:
        r70 = 0;
        goto L257
    L251:
        r69 = 0;
        goto L252
    L247:
        r68 = 0;
        goto L248
    L241:
        if (r59.booleanValue() == false) goto L243;
        r147 = 1;
        goto L244
    L243:
        r147 = 0;
        goto L244
    L236:
        r67 = 0;
        goto L237
    L232:
        r66 = 0;
        goto L233
    L228:
        r65 = 0;
        goto L229
    L224:
        r64 = 0;
        goto L225
    L220:
        r63 = r5;
    L216:
        r62 = 0;
        goto L218
    L214:
        if (r28 == null) goto L216;
        r62 = r28.longValue();
        goto L218
    L202:
        r57 = r53 + r52;
        if (r57 >= 0) goto L206;
    L205:
        r57 = 0;
        goto L206
    L193:
        if ((r53 + r52) >= 0) goto L196;
        r146 = 0;
        goto L197
    L189:
        r51 = j0.a(r141.b(DoraImageEvent.IMAGE_TRANS_FINISH)) - r50;
    L185:
        r46 = 0;
        goto L186
    L207:
        r56 = r0;
        r54 = r25;
        goto L208
    L169:
        if (r143.intValue() == 1) goto L170;
    L172:
        r42 = false;
        goto L173
    L171:
        r48 = r21;
        goto L172
    L136:
        z98.d r100 = r141.M.get(DoraImageEvent.IMAGE_TRANS_FINISH);
        if (r100 != null) goto L139;
    L141:
        boolean r101 = false;
    L142:
        if (r101 == false) goto L144;
        r37 = 1;
        goto L153
    L144:
        z98.d r102 = r141.M.get(r142);
        if (r102 != null) goto L147;
    L149:
        boolean r103 = false;
    L150:
        if (r103 == false) goto L152;
        r37 = 2;
        goto L153
    L152:
        r37 = -1;
        goto L153
    L147:
        if (r102.a == true) goto L149;
        r103 = true;
        goto L150
    L139:
        if (r100.a == true) goto L141;
        r101 = true;
        goto L142
    L131:
        if (r35.a != true) goto L133;
        r36 = true;
    L399:
        r2.n = false;
        this.f = null;
        return;
    L209:
        r54 = r25;
        r5 = r5;
        r7 = r7;
        r28 = r28;
        r8 = r8;
        r121 = r121;
        r48 = r21;
        r56 = r0;
        goto L210
    L122:
        r139 = null;
        goto L123
    L104:
        if (r32.longValue() != 0) goto L106;
        boolean r104 = true;
    L107:
        if (r104 == true) goto L118;
        Long r105 = r2.m;
        if (r105 == null) goto L112;
        long r166 = r105.longValue();
    L113:
        Long r106 = r2.l;
        if (r106 == null) goto L116;
        long r212 = r106.longValue();
    L117:
        r122 = r166 - r212;
        goto L119
    L116:
        r212 = 0;
        goto L117
    L112:
        r166 = 0;
        goto L113
    L106:
        r104 = false;
        goto L107
    L100:
        r211 = 0;
        goto L101
    L97:
        r210 = 0;
        goto L98
    L93:
        r27 = 0;
        goto L94
    L89:
        r24 = 0;
        goto L90
    L86:
        r23 = 0;
        goto L87
    L82:
        r115 = 0;
        goto L83
    L79:
        r114 = 0;
    L75:
        r113 = -1;
    L69:
        r110 = r16;
        goto L70
    L63:
        r17 = null;
        goto L64
    L60:
        r4 = null;
        goto L61
    L402:
        return;
    L53:
        if (r2.n != true) goto L55;
        r1 = true;
        goto L56
    L20:
        com.larus.avlink.model.a r167 = r2.b();
        if (v88.a.a(Integer.valueOf(r2.e)) == false) goto L23;
    L29:
        if (r9 != null) goto L32;
    L38:
        if (r11 == false) goto L40;
    L42:
        r14 = 0;
        goto L43
    L40:
        if (r2.a0 >= 0) goto L42;
        r14 = -6;
        goto L43
    L32:
        if (r9.intValue() != 0) goto L38;
        if (r2.w != null) goto L36;
    L37:
        r14 = -5;
        goto L43
    L36:
        if (r2.m != null) goto L38;
    L23:
        if (r2.d == true) goto L29;
        if (r167 != null) goto L27;
        com.larus.avlink.n1.b("QueryTraceModel", "[IMAGE_ERROR] imageModel is null when query response!");
        r14 = -2;
        goto L43
    L27:
        if (r167.n != null) goto L29;
        r14 = -4;
        goto L43
    L16:
        r13 = 0;
        goto L18
    L10:
        if (r10.d1() != true) goto L12;
        r11 = true;
        goto L13
    L44:
        r15 = null;
        goto L45
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
    }
}
