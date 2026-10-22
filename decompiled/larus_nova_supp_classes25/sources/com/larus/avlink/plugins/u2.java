package com.larus.avlink.plugins;

import com.larus.avlink.liveai.DoraLiveAiTracer;
import com.larus.dora.api.DoraByteCastManagerDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u2 extends com.larus.avlink.plugins.c<n4> implements w4 {
    public w98.a f;
    public w98.d g;
    public boolean h;
    public IDoraService.a.a i;
    public boolean j;
    public final a k;

    public static final class a implements t39.g {
        public final /* synthetic */ u2 a;

        public final void c() {
            w98.a r0 = this.a.f;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.f != null) goto L9;
            r0.f = Long.valueOf(System.currentTimeMillis());
            this.a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onVideoCodecInfo: first codec info received.");
            return;
        }

        public a(u2 r1) {
            this.a = r1;
        }

        public final void a(t39.s r11) {
            Intrinsics.checkNotNullParameter(r11, "mirrorData");
            w98.a r0 = this.a.f;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.d = Long.valueOf(System.currentTimeMillis());
            int r8 = r11.f;
            r0.i = r8;
            r0.k = new w98.b(r11.a, r11.b, r11.c, r11.d, r11.e, r8, r11.g);
            this.a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onRecvMirrorData: mirror connected, transType: " + r11.h + ", data: " + r11);
        }

        public final void b(tf9.a r17) {
            tf9.a r0 = r17;
            Intrinsics.checkNotNullParameter(r0, "frame");
            w98.a r2 = this.a.f;
            if (r2 != null) goto L7;
            com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", "drop video frame: trace model unavailable, timestampUs=" + r0.c + ", frameType=" + r0.h + ", codec=" + r0.g + ", dataSize=" + r0.a.length);
            return;
        L7:
            if (r2.e != null) goto L9;
            r2.e = Long.valueOf(System.currentTimeMillis());
            this.a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onVideoData: first I-frame received.");
        L9:
            r2.h++;
            x4 r3 = (x4) this.a.getContext().c(Reflection.getOrCreateKotlinClass(x4.class), null);
            if (r3 != null) goto L13;
            this.a.getClass();
            com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", "drop video frame: video frame sender unavailable, timestampUs=" + r0.c + ", frameType=" + r0.h + ", codec=" + r0.g + ", dataSize=" + r0.a.length);
            return;
        L13:
            w98.d r4 = this.a.g;
            if (r4 == null) goto L42;
            long r5 = System.currentTimeMillis();
            long r6 = r0.c / ((long) 1000);
            int r8 = r0.d;
            int r9 = r0.e;
            if (r6 <= 0) goto L19;
            long r13 = r5 - r6;
        L20:
            Object r15 = r4.d;
            monitor-enter(r15);
        L44:
            th = move-exception;
            throw th;
        L23:
            if (r4.o == false) goto L26;
            monitor-exit(r15);
            goto L42
        L26:
            r4.e++;     // Catch: Throwable -> L44
            r4.f += (long) r8;     // Catch: Throwable -> L44
            r4.g += (long) r9;     // Catch: Throwable -> L44
            if (r13 < 0) goto L29;
            r4.h += r13;     // Catch: Throwable -> L44
        L29:
            if (r6 <= 0) goto L39;
            r4.n.put(Long.valueOf(r6), new w98.d.b(r5));     // Catch: Throwable -> L44
            if (r4.n.size() <= r4.c) goto L39;
            Iterator<Map.Entry<Long, w98.d.b>> r1 = r4.n.entrySet().iterator();     // Catch: Throwable -> L44
        L35:
            if (r4.n.size() <= r4.c) goto L39;
            if (r1.hasNext() == false) goto L39;
            r1.next();     // Catch: Throwable -> L44
            r1.remove();     // Catch: Throwable -> L44
        L39:
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L44
            monitor-exit(r15);
            r0 = r17;
            goto L42
        L19:
            r13 = -1;
        L42:
            r3.u1(r0);
        }

        public final void d(boolean r8, String r9, long r10) {
            Intrinsics.checkNotNullParameter(r9, "ocrText");
            this.a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onRecvOcrData: hasText=" + r8 + ", ts=" + r10);
            long r0 = System.currentTimeMillis();
            if (r8 == false) goto L25;
            w98.d r2 = this.a.g;
            if (r2 == null) goto L25;
            if (r10 <= 0) goto L9;
            long r1 = r0 - r10;
        L10:
            Object r5 = r2.d;
            monitor-enter(r5);
        L22:
            th = move-exception;
            throw th;
        L13:
            if (r2.o == false) goto L16;
            monitor-exit(r5);
            goto L25
        L16:
            r2.l++;     // Catch: Throwable -> L22
            if (r1 < 0) goto L19;
            r2.m += r1;     // Catch: Throwable -> L22
        L19:
            w98.d.b r3 = r2.n.get(Long.valueOf(r10));     // Catch: Throwable -> L22
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r5);
            goto L25
        L9:
            r1 = -1;
        L25:
            x4 r6 = (x4) this.a.getContext().c(Reflection.getOrCreateKotlinClass(x4.class), null);
            if (r6 != null) goto L29;
            this.a.getClass();
            com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", "drop OCR: video frame sender unavailable, timestamp=" + r10);
            return;
        L29:
            r6.l2(new we9.e(r8, r9, r10));
        }
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final /* synthetic */ u2 a;

        public final String getName() {
            return "DoraRtcVideoStreamPlugin";
        }

        public b(u2 r1) {
            this.a = r1;
            r1.getClass();
        }

        public final void O1(jd9.c r2, jd9.c r3) {
            Intrinsics.checkNotNullParameter(r2, "oldState");
            Intrinsics.checkNotNullParameter(r3, "newState");
            this.a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onConnectionStateChanged status=" + r3);
            if (((n4) this.a.getContext()).E() == true) goto L6;
            return;
        L6:
            if ((r3 instanceof jd9.c.a) == false) goto L8;
            this.a.k3("onConnectionStateChanged");
            return;
        L8:
            this.a.j = false;
        }
    }

    public static final class c extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ u2 b;

        public final void k() {
            u2 r0 = this.b;
            w98.a r1 = r0.f;
            if (r1 == null) goto L5;
            r1.l++;
        L5:
            r0.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onExternalVideoKeyFrameRequested");
            DoraByteCastManagerDelegate.b.requestKeyFrame();
        }

        public final String g() {
            return this.a;
        }

        public c(u2 r1) {
            this.b = r1;
            r1.getClass();
            this.a = "DoraRtcVideoStreamPlugin";
        }

        public final void l(long r2) {
            DoraByteCastManagerDelegate.b.e(r2);
        }

        public final void n(com.larus.im.service.audio.z0.a r15) {
            Intrinsics.checkNotNullParameter(r15, "event");
            if ((r15 instanceof pf9.w) == false) goto L83;
            u2 r0 = this.b;
            pf9.w r16 = (pf9.w) r15;
            w98.a r1 = r0.f;
            if (r1 == null) goto L84;
            Map r2 = r16.e;
            Long r3 = null;
            if (r2 == null) goto L10;
            String r4 = (String) r2.get("is_from_rtc");
        L12:
            if (Intrinsics.areEqual(r4, "1") == false) goto L85;
            long r5 = System.currentTimeMillis();
            boolean r8 = true;
            if (r16.a == false) goto L53;
            Map r6 = r16.e;
            if (r6 == null) goto L23;
            String r7 = (String) r6.get("pic_shooting_time_ms");
            if (r7 == null) goto L23;
            Long r9 = StringsKt.toLongOrNull(r7);
            if (r9 == null) goto L23;
            long r10 = r9.longValue();
        L24:
            w98.d r11 = r0.g;
            if (r11 == null) goto L53;
            Object r12 = r11.d;
            monitor-enter(r12);
        L49:
            th = move-exception;
            throw th;
        L29:
            if (r11.o == false) goto L32;
            monitor-exit(r12);
            goto L53
        L32:
            w98.d.b r13 = r11.n.get(Long.valueOf(r10));     // Catch: Throwable -> L49
            if (r13 != null) goto L37;
            monitor-exit(r12);
            goto L53
        L37:
            if (r13.d == false) goto L39;
        L47:
            monitor-exit(r12);
            goto L53
        L39:
            if (r13.c == true) goto L47;
            r13.b = true;     // Catch: Throwable -> L49
            r13.d = true;     // Catch: Throwable -> L49
            r11.i++;     // Catch: Throwable -> L49
            r11.k++;     // Catch: Throwable -> L49
            long r14 = r5 - r13.a;     // Catch: Throwable -> L49
            if (r14 < 0) goto L44;
            r11.j += r14;     // Catch: Throwable -> L49
        L44:
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L49
            monitor-exit(r12);
        L23:
            r10 = 0;
        L53:
            if (r1.m == true) goto L86;
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "handleFileDownlinkReceived, code: " + r16.b + ", msg: " + r16.c);
            r1.g = Long.valueOf(r5);
            r1.m = true;
            boolean r18 = DoraLiveAiTracer.b;
            int r19 = ((n4) r0.getContext()).q();
            n4 r20 = (n4) r0.getContext();
            Intrinsics.checkNotNullParameter(r1, "model");
            Intrinsics.checkNotNullParameter(r20, "context");
            LinkedHashMap r21 = new LinkedHashMap();
            Long r22 = r1.b;
            if (r22 != null) goto L58;
            r22 = r1.a;
        L58:
            r21.put("rtc_connection_time", Long.valueOf(DoraLiveAiTracer.a(r1.e, r1.a)));
            r21.put("mirror_connect_finish_time", Long.valueOf(DoraLiveAiTracer.a(r1.d, r22)));
            r21.put("mirror_to_ps_frame_time", Long.valueOf(DoraLiveAiTracer.a(r1.f, r1.d)));
            r21.put("mirror_to_video_frame_time", Long.valueOf(DoraLiveAiTracer.a(r1.e, r1.d)));
            Long r23 = r1.g;
            if (r23 == null) goto L66;
            long r24 = r23.longValue();
            r21.put("first_frame_server_parse_time", Long.valueOf(DoraLiveAiTracer.a(Long.valueOf(r24), r1.a)));
            Long r25 = Long.valueOf(r24);
            Long r26 = r1.e;
            if (r25 == null) goto L64;
            if (r26 == null) goto L64;
            long r27 = r25.longValue() - r26.longValue();
        L65:
            r21.put("first_frame_server_parse_after_idr_time", Long.valueOf(r27));
        L64:
            r27 = -1;
        L66:
            w98.b r28 = r1.k;
            if (r28 == null) goto L69;
            r21.put("bwdl_connect_time", Integer.valueOf(r28.a));
            r21.put("cast_connect_time", Integer.valueOf(r28.b));
            r21.put("cast_init_time", Integer.valueOf(r28.c));
            r21.put("cast_start_mirror_time", Integer.valueOf(r28.d));
            r21.put("mirror_height", Integer.valueOf(r28.e));
            r21.put("mirror_fps", Integer.valueOf(r28.f));
            r21.put("mirror_width", Integer.valueOf(r28.g));
        L69:
            Long r29 = r1.c;
            if (r29 != null) goto L72;
        L79:
            r21.put("trans_type", Integer.valueOf(DoraLiveAiTracer.f()));
            r21.put("mode", Integer.valueOf(r19));
            r21.put("av_session_type", Integer.valueOf(r20.params().s.getType()));
            Map<Function1<Boolean, Unit>, k4> r110 = x2.a;
            x2.e("dora_video_liveai_init", r21);
            return;
        L72:
            if (r29.longValue() >= 0) goto L75;
            r8 = false;
        L75:
            if (r8 == false) goto L77;
            r3 = r29;
        L77:
            if (r3 == null) goto L79;
            r21.put("p2p_connection_time", Long.valueOf(r3.longValue()));
            goto L79
        L86:
            return;
        L85:
            return;
        L10:
            r4 = null;
            goto L12
        L84:
            return;
        }
    }

    public final String T2() {
        return "DoraRtcVideoStreamPlugin";
    }

    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new c(this);
    }

    public final void l3() {
        w98.a r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "reportRtcVideoStreamEnd, frameCount=" + r0.h + ", requestKeyFrameCount=" + r0.l + ", hasReportedVideoInit=" + r0.m);
        boolean r1 = DoraLiveAiTracer.b;
        n4 r2 = (n4) getContext();
        Intrinsics.checkNotNullParameter(r0, "model");
        Intrinsics.checkNotNullParameter(r2, "context");
        LinkedHashMap r3 = new LinkedHashMap();
        long r4 = System.currentTimeMillis();
        Long r5 = r0.d;
        if (r5 == null) goto L8;
        long r6 = r5.longValue();
    L9:
        long r7 = r4 - r6;
        r3.put("mirror_duration", Long.valueOf(r7));
        r3.put("mirror_total_frames", Integer.valueOf(r0.h));
        r3.put("rtc_request_key_frame_count", Integer.valueOf(r0.l));
        w98.b r8 = r0.k;
        if (r8 == null) goto L12;
        r3.put("mirror_height", Integer.valueOf(r8.e));
        r3.put("mirror_fps", Integer.valueOf(r8.f));
        r3.put("mirror_width", Integer.valueOf(r8.g));
        long r9 = (r7 / 1000) * ((long) r8.f);
        r3.put("loss_frame_rate", Float.valueOf(((r9 - ((long) r0.h)) * 1.0f) / r9));
    L12:
        r3.put("trans_type", Integer.valueOf(DoraLiveAiTracer.f()));
        r3.put("mode", Integer.valueOf(r0.n));
        r3.put("av_session_type", Integer.valueOf(r2.params().s.getType()));
        Map<Function1<Boolean, Unit>, k4> r10 = x2.a;
        x2.e("dora_video_liveai_end", r3);
        w98.d r11 = this.g;
        if (r11 == null) goto L43;
        long r12 = System.currentTimeMillis();
        int r13 = w98.d.p;
        Object r14 = r11.d;
        monitor-enter(r14);
    L40:
        th = move-exception;
        throw th;
    L17:
        if (r11.o == false) goto L20;
        monitor-exit(r14);
    L39:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "reportConversationFrameInfo, received=" + r11.g() + ", upload=" + r11.h() + ", actualUpload=" + r11.a() + ", ocr=" + r11.f());
        boolean r15 = DoraLiveAiTracer.b;
        DoraLiveAiTracer.b(r11, (n4) getContext());
        goto L43
    L20:
        Iterator<T> r16 = r11.n.values().iterator();     // Catch: Throwable -> L40
    L22:
        if (r16.hasNext() == false) goto L37;
        w98.d.b r17 = (w98.d.b) r16.next();     // Catch: Throwable -> L40
        long r18 = r12 - r17.a;     // Catch: Throwable -> L40
        if (r17.b == false) goto L22;
        if (r17.d == true) goto L22;
        if (r17.c == true) goto L22;
        if (0 <= r18) goto L32;
    L34:
        boolean r19 = false;
    L35:
        if (r19 == false) goto L22;
        r17.d = true;     // Catch: Throwable -> L40
        r11.i++;     // Catch: Throwable -> L40
        goto L22
    L32:
        if (r18 > 2000) goto L34;
        r19 = true;
        goto L35
    L37:
        r11.o = true;     // Catch: Throwable -> L40
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L40
        monitor-exit(r14);
    L43:
        this.f = null;
        this.g = null;
        return;
    L8:
        r6 = System.currentTimeMillis();
        goto L9
    }

    public final void e3() {
        super.e3();
        if (((n4) getContext()).E() == false) goto L12;
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L7;
        jd9.c r1 = r0.state();
    L9:
        if ((r1 instanceof jd9.c.a) == false) goto L11;
        k3("onStart(mmt-connected)");
        return;
    L11:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onStart: MMT session, defer external capture setup until connected.");
        return;
    L7:
        r1 = null;
        goto L9
    L12:
        k3("onStart");
    }

    public final void g3() {
        super.g3();
        IDoraService.a.a r0 = this.i;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onStop");
        this.j = false;
        if (this.h == false) goto L9;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "unregisterRtcVideoStreamCallbacks.");
        DoraByteCastManagerDelegate.b.f();
        this.h = false;
    L9:
        l3();
    }

    public u2(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.k = new a(this);
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void Q0(int r3) {
        IDoraService.a.a r0 = this.i;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onConversationEnd: reason=" + r3);
        if (this.h == false) goto L9;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "unregisterRtcVideoStreamCallbacks.");
        DoraByteCastManagerDelegate.b.f();
        this.h = false;
    L9:
        l3();
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L15;
        AbilityService r5 = r4.o0();
        if (r5 == null) goto L16;
        r5.h();
        return;
    L16:
        return;
    }

    public final void k3(String r4) {
        if (this.j == false) goto L6;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", r4.concat(": external capture already configured, skip."));
        return;
    L6:
        id9.d r0 = ((n4) getContext()).j();
        if (r0 != null) goto L10;
        com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", r4.concat(": media session unavailable, external encoded capture not configured."));
        return;
    L10:
        com.larus.im.service.audio.z r1 = r0.e();
        if (r1 != null) goto L14;
        com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", r4.concat(": video service unavailable, external encoded capture not configured."));
        return;
    L14:
        r1.t(true);
        this.j = true;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", r4.concat(": external encoded video capture configured."));
    }

    @Override // com.larus.avlink.plugins.w4
    public final void S0(long r4, boolean r6) {
        w98.d r0 = this.g;
        if (r0 == null) goto L31;
        Object r1 = r0.d;
        monitor-enter(r1);
    L28:
        th = move-exception;
        throw th;
    L7:
        if (r0.o == false) goto L10;
        monitor-exit(r1);
        return;
    L10:
        w98.d.b r5 = r0.n.get(Long.valueOf(r4));     // Catch: Throwable -> L28
        if (r5 != null) goto L15;
        monitor-exit(r1);
        return;
    L15:
        if (r5.d == false) goto L17;
    L26:
        monitor-exit(r1);
        return;
    L17:
        if (r5.c == true) goto L26;
        if (r6 == false) goto L22;
        r5.b = true;     // Catch: Throwable -> L28
    L23:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r1);
        return;
    L22:
        r5.c = true;     // Catch: Throwable -> L28
        goto L23
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void i0(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "caller");
        Intrinsics.checkNotNullParameter(r10, "caller");
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L8;
        AbilityService r14 = r13.o0();
        if (r14 == null) goto L8;
        r14.g();
    L8:
        if (((n4) getContext()).A() == true) goto L11;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onConversationStart: rtc video stream disabled, skip.");
        return;
    L11:
        IDoraService.a.a r15 = this.i;
        Long r16 = null;
        if (r15 != null) goto L19;
        IDoraService r17 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r17 == null) goto L18;
        AbilityService r18 = r17.o0();
        if (r18 == null) goto L18;
        r15 = new AbilityService.VideoStreamLifecycleImpl(r18);
    L18:
        r15 = null;
    L19:
        this.i = r15;
        if (r15 == null) goto L22;
        r15.b(((n4) getContext()).q(), ((n4) getContext()).x(), ((n4) getContext()).E());
    L22:
        long r0 = System.currentTimeMillis();
        Long r3 = Long.valueOf(r0);
        Long r19 = Long.valueOf(((n4) getContext()).params().c);
        long r4 = r19.longValue();
        if (r4 > 0) goto L25;
    L29:
        boolean r2 = false;
    L30:
        if (r2 == false) goto L32;
        Long r5 = r19;
    L33:
        IDoraService r110 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r110 == null) goto L38;
        AbilityService r111 = r110.o0();
        if (r111 == null) goto L38;
        r16 = r111.e();
    L38:
        this.f = new w98.a(r3, r5, r16, ((n4) getContext()).q(), 8184);
        this.g = new w98.d(r0, ((n4) getContext()).q());
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "enter RTC video stream, mode: " + ((n4) getContext()).q() + '.');
        boolean r112 = DoraLiveAiTracer.b;
        int r113 = ((n4) getContext()).q();
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put("trans_type", Integer.valueOf(DoraLiveAiTracer.f()));
        r114.put("mode", Integer.valueOf(r113));
        Map<Function1<Boolean, Unit>, k4> r115 = x2.a;
        x2.e("dora_video_liveai_start", r114);
        if (((n4) getContext()).A() == true) goto L42;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "skip video callback registration: rtc video stream disabled.");
        return;
    L42:
        if (this.h == false) goto L44;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "skip video callback registration: callback already registered.");
        return;
    L44:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "registerRtcVideoStreamCallbacks.");
        DoraByteCastManagerDelegate.b.g(this.k);
        this.h = true;
        return;
    L32:
        r5 = null;
        goto L33
    L25:
        if (r4 > r0) goto L29;
        if (v88.a.b(Integer.valueOf(((n4) getContext()).q())) == true) goto L29;
        r2 = true;
        goto L30
    }
}
