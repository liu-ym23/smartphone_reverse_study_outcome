package lmc;

import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.data.SdkUplinkPacket;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import com.ss.ugc.live.sdk.msg.network.m;
import com.ss.ugc.live.sdk.msg.uplink.UplinkException;
import com.ss.ugc.live.sdk.msg.uplink.UplinkStrategy;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPOutputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements m, i.a {
    public static final int m = 0;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public UplinkStrategy a;
    public lmc.c b;
    public i c;
    public i d;
    public i e;
    public final lmc.e f;
    public final c g;
    public final amc.i h;
    public final h i;
    public final com.ss.ugc.live.sdk.msg.network.i j;
    public final vlc.g k;
    public final vlc.c l;

    /* JADX INFO: renamed from: lmc.a$a, reason: collision with other inner class name */
    public static final class C0294a {
    }

    public final class b implements Runnable {
        public final long a;
        public final /* synthetic */ a b;

        public final void a() {
            lmc.d r0 = this.b.f.a(this.a);
            if (r0 == null) goto L6;
            com.ss.ugc.live.sdk.msg.utils.a.c(this.b.l, "ws uplink timeout, serviceId: " + r0.l + ", uniqueId: " + r0.k);
            r0.c(new UplinkException(-2, "ws timeout", null, null, 12, null), UplinkStrategy.WS, this.b.i.c());
            this.b.e(r0);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r1, long r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class c {
        public final AtomicLong a;

        public c() {
            this.a = new AtomicLong(Random.Default.nextLong(0, 10000));
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ lmc.d a;
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.utils.g b;

        public d(lmc.d r1, com.ss.ugc.live.sdk.msg.utils.g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.o.a(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements com.ss.ugc.live.sdk.msg.network.e {
        public final /* synthetic */ a a;
        public final /* synthetic */ lmc.d b;

        @Override // com.ss.ugc.live.sdk.msg.network.e
        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            lmc.d r0 = this.b;
            r0.c = r3;
            i r4 = this.a.d;
            if (r4 == null) goto L8;
            int r1 = a.m;
            Message r5 = r4.obtainMessage(a.o, r0);
            if (r5 == null) goto L9;
            r5.sendToTarget();
            return;
        L9:
            return;
        }

        public e(a r1, lmc.d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f implements com.ss.ugc.live.sdk.msg.network.e {
        public final /* synthetic */ a a;
        public final /* synthetic */ lmc.d b;

        @Override // com.ss.ugc.live.sdk.msg.network.e
        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            lmc.d r0 = this.b;
            r0.c = r3;
            i r4 = this.a.d;
            if (r4 == null) goto L8;
            int r1 = a.m;
            Message r5 = r4.obtainMessage(a.o, r0);
            if (r5 == null) goto L9;
            r5.sendToTarget();
            return;
        L9:
            return;
        }

        public f(a r1, lmc.d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements com.ss.ugc.live.sdk.msg.network.e {
        public final /* synthetic */ a a;
        public final /* synthetic */ lmc.d b;

        @Override // com.ss.ugc.live.sdk.msg.network.e
        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            lmc.d r0 = this.b;
            r0.b = r3;
            i r4 = this.a.d;
            if (r4 == null) goto L8;
            int r1 = a.m;
            Message r5 = r4.obtainMessage(a.n, r0);
            if (r5 == null) goto L9;
            r5.sendToTarget();
            return;
        L9:
            return;
        }

        public g(a r1, lmc.d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void a() {
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void d(tlc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadItem");
    }

    static {
        m = 12346;
        n = 12347;
        o = 12348;
        p = 12349;
        q = 12350;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        lmc.c r3 = this.b;
        if (r3 == null) goto L5;
        Looper r4 = r3.getLooper();
    L6:
        if (r4 == null) goto L11;
        i r5 = this.e;
        if (r5 == null) goto L12;
        r5.sendEmptyMessage(q);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void e(lmc.d r13) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "uplink request finished, serviceId: " + r13.l + ", uniqueId: " + r13.k);
        lmc.e r0 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, "requestItem");
        r0.a.remove(Long.valueOf(r13.k));
        Runnable r1 = r13.i;
        if (r1 == null) goto L7;
        i r2 = this.c;
        if (r2 == null) goto L7;
        r2.removeCallbacks(r1);
    L7:
        lmc.f r3 = r13.h;
        vlc.g r7 = this.k;
        vlc.c r8 = this.l;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "monitor");
        Intrinsics.checkNotNullParameter(r8, "logger");
        if (r3.f <= r3.e) goto L29;
        JSONObject r9 = new JSONObject();
        r9.put("service_id", r3.l);
        r9.put("status_code", r3.h);
        r9.put("expect_strategy", r3.a);
        r9.put("actual_strategy", r3.b);
        r9.put("ws_connected_on_send", r3.c);
        r9.put("ws_connected_on_finish", r3.d);
        r9.put("success", r3.g);
        long r4 = r3.f - r3.e;
        JSONObject r10 = new JSONObject();
        r10.put("use_time", r4);
        JSONObject r11 = new JSONObject();
        r11.put("unique_id", r3.k);
        r11.put("status_message", r3.i);
        r11.put("send_time", r3.e);
        r11.put("finish_time", r3.f);
        String r5 = r3.j;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        r11.put("log_id", r3.j);
    L19:
        r7.d(r4, r9, r10, r11);
        if (r3.g == true) goto L22;
        r7.e("uplink_status_error", r9, r10, r11);
    L22:
        JSONObject r12 = new JSONObject();
        r12.put("category", r9);
        r12.put("metric", r10);
        r12.put("extra", r11);
        com.ss.ugc.live.sdk.msg.utils.a.c(r8, "uplink stat: " + r12);
        goto L29
    L13:
        if (r5.length() == 0) goto L16;
        r6 = false;
    L29:
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> r14 = r13.a();     // Catch: Exception -> L25
    L27:
        MainTaskScheduler.a(new d(r13, r14));
        return;
    L25:
        e = move-exception;
        int r15 = com.ss.ugc.live.sdk.msg.utils.g.a;
        r14 = com.ss.ugc.live.sdk.msg.utils.g.a.a(e);
        goto L27
    }

    public final void g(lmc.d r5) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "send uplink packet by origin http, serviceId: " + r5.l + ", uniqueId: " + r5.k);
        HttpMethod r0 = r5.n.a;
        if (r0 != null) goto L6;
        r0 = HttpMethod.POST;
    L6:
        int r1 = lmc.b.a[r0.ordinal()];
        if (r1 != 1) goto L9;
        this.j.b(r5.n, new e(this, r5));
        return;
    L9:
        if (r1 != 2) goto L15;
        this.j.c(r5.n, new f(this, r5));
        return;
    }

    public final void h(lmc.d r5) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "send uplink packet by uplink http, serviceId: " + r5.l + ", uniqueId: " + r5.k);
        String r0 = this.h.e();
        Intrinsics.checkNotNullParameter(r0, "uplinkHttpUrl");
        SdkUplinkPacket r1 = r5.b();
        com.ss.ugc.live.sdk.msg.network.f r2 = new com.ss.ugc.live.sdk.msg.network.f();
        r2.g = "application/protobuf";
        r2.b = r0;
        r2.e = r1.encode();
        if (r2.h != null) goto L5;
        r2.h = Collections.emptyMap();
    L5:
        this.j.b(r2, new g(this, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.i.a
    public final void handleMsg(Message r17) {
        if (r17 == null) goto L162;
        int r1 = r17.what;
        if (r1 != 12345) goto L38;
        Object r0 = r17.obj;
        if (r0 == null) goto L37;
        lmc.d r2 = (lmc.d) r0;
        lmc.e r3 = this.f;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "requestItem");
        r3.a.put(Long.valueOf(r2.k), r2);
        String r4 = this.a.getStrategy(this.i.c());
        boolean r5 = this.i.c();
        Intrinsics.checkNotNullParameter(r4, "expectUplinkStrategy");
        lmc.f r6 = r2.h;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "uplinkStrategy");
        r6.e = System.currentTimeMillis();
        r6.a = r4;
        r6.c = r5;
        UplinkStrategy r7 = this.a;
        UplinkStrategy r8 = UplinkStrategy.WS_MSG_ORIGIN;
        if (r7 == r8) goto L13;
        if (r7 == UplinkStrategy.WS_ORIGIN) goto L13;
    L19:
        if (this.a != r8) goto L21;
    L169:
        h(r2);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        r2.c(e, UplinkStrategy.UPLINK_HTTP, this.i.c());
        e(r2);
        c(r2.l, UplinkStrategy.UPLINK_HTTP, this.i.c(), e);
        return;
    L21:
        if (r2.f() == false) goto L169;
        if (r2.n.l == true) goto L26;
    L31:
        UplinkException r9 = new UplinkException(-6, "not support origin http", null, null, 12, null);
        r2.c(r9, UplinkStrategy.WS, this.i.c());
        e(r2);
        c(r2.l, UplinkStrategy.WS, this.i.c(), r9);
        return;
    L26:
        if (r2.f() == false) goto L31;
        g(r2);     // Catch: Exception -> L29
        return;
    L29:
        e = move-exception;
        r2.c(e, UplinkStrategy.ORIGIN_HTTP, this.i.c());
        e(r2);
        c(r2.l, UplinkStrategy.ORIGIN_HTTP, this.i.c(), e);
        return;
    L13:
        if (this.i.c() == false) goto L19;
        j(r2);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        r2.c(e, UplinkStrategy.WS, true);
        e(r2);
        c(r2.l, UplinkStrategy.WS, this.i.c(), e);
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.uplink.UplinkRequestItem");
    L38:
        String r12 = "server error";
        if (r1 != m) goto L79;
        Object r10 = r17.obj;
        if (r10 == null) goto L77;
        tlc.f r11 = (tlc.f) r10;
        byte[] r13 = r11.e;     // Catch: Exception -> L70
        if (Intrinsics.areEqual(com.ss.ugc.live.sdk.msg.utils.h.a(r11), "gzip") == false) goto L46;
        r13 = com.ss.ugc.live.sdk.msg.utils.b.a(r13);     // Catch: Exception -> L70
    L46:
        SdkUplinkPacket r14 = (SdkUplinkPacket) SdkUplinkPacket.ADAPTER.decode(r13);     // Catch: Exception -> L70
        String r15 = com.ss.ugc.live.sdk.msg.utils.h.b(r14);     // Catch: Exception -> L70
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "receive uplink packet by ws, logId: ".concat(r15));     // Catch: Exception -> L70
        lmc.d r16 = this.f.a(r14.uniqueID.longValue());     // Catch: Exception -> L70
        if (r16 != null) goto L49;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "no request item found");     // Catch: Exception -> L70
        return;
    L49:
        UplinkStrategy.a r18 = UplinkStrategy.Companion;     // Catch: Exception -> L70
        int r19 = r14.uplinkStrategy.intValue();     // Catch: Exception -> L70
        r18.getClass();     // Catch: Exception -> L70
        if (r19 == 0) goto L57;
        if (r19 == 1) goto L56;
        if (r19 == 2) goto L55;
        if (r19 == 3) goto L57;
        UplinkStrategy r20 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L70
    L58:
        this.a = r20;     // Catch: Exception -> L70
        Integer r21 = r14.statusCode;     // Catch: Exception -> L70
        if (r21 != null) goto L62;
    L64:
        int r22 = r14.statusCode.intValue();     // Catch: Exception -> L70
        String r23 = r14.statusMessage;     // Catch: Exception -> L70
        if (r23 == null) goto L67;
        r12 = r23;
    L67:
        r16.c(new UplinkException(r22, r12, null, r15), UplinkStrategy.WS, this.i.c());     // Catch: Exception -> L70
    L68:
        e(r16);     // Catch: Exception -> L70
        return;
    L62:
        if (r21.intValue() != 0) goto L64;
        r16.e(r14, UplinkStrategy.WS, this.i.c(), true);     // Catch: Exception -> L70
        goto L68
    L55:
        r20 = UplinkStrategy.ORIGIN;     // Catch: Exception -> L70
        goto L58
    L56:
        r20 = UplinkStrategy.WS_ORIGIN;     // Catch: Exception -> L70
    L57:
        r20 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L70
    L70:
        e = move-exception;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "receive uplink packet by ws error");
        JSONObject r24 = new JSONObject();
        JSONObject r25 = new JSONObject();
        String r26 = e.getMessage();
        if (r26 != null) goto L75;
        r26 = "Unknown exception";
    L75:
        JSONObject r27 = new JSONObject();
        r27.put("error", r26);
        r27.put("log_id", r11.g);
        this.k.e("uplink_receive_ws_packet_error", r24, r25, r27);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "receive ws uplink packet error: ".concat(r26));
        return;
    L77:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
    L79:
        if (r1 != n) goto L119;
        Object r28 = r17.obj;
        if (r28 == null) goto L117;
        lmc.d r29 = this.f.a(((lmc.d) r28).k);
        if (r29 != null) goto L173;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "receive uplink packet by uplink http but no request item found");
        return;
    L173:
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r30 = r29.b;     // Catch: Exception -> L113
        if (r30 != null) goto L88;
    L115:
        e(r29);
        return;
    L88:
        if ((r30 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L109;
        com.ss.ugc.live.sdk.msg.network.g r31 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r30).b;     // Catch: Exception -> L113
        SdkUplinkPacket r32 = (SdkUplinkPacket) SdkUplinkPacket.ADAPTER.decode(r31.d);     // Catch: Exception -> L113
        String r33 = com.ss.ugc.live.sdk.msg.utils.h.b(r32);     // Catch: Exception -> L113
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "receive uplink packet by uplink http, logId: ".concat(r33));     // Catch: Exception -> L113
        UplinkStrategy.a r34 = UplinkStrategy.Companion;     // Catch: Exception -> L113
        int r35 = r32.uplinkStrategy.intValue();     // Catch: Exception -> L113
        r34.getClass();     // Catch: Exception -> L113
        if (r35 == 0) goto L97;
        if (r35 == 1) goto L96;
        if (r35 == 2) goto L95;
        if (r35 == 3) goto L97;
        UplinkStrategy r36 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L113
    L98:
        this.a = r36;     // Catch: Exception -> L113
        Integer r37 = r32.statusCode;     // Catch: Exception -> L113
        if (r37 != null) goto L102;
    L104:
        int r38 = r32.statusCode.intValue();     // Catch: Exception -> L113
        String r39 = r32.statusMessage;     // Catch: Exception -> L113
        if (r39 == null) goto L107;
        r12 = r39;
    L107:
        r29.c(new UplinkException(r38, r12, null, r33), UplinkStrategy.UPLINK_HTTP, this.i.c());     // Catch: Exception -> L113
        goto L115
    L102:
        if (r37.intValue() != 0) goto L104;
        r29.e(r32, UplinkStrategy.UPLINK_HTTP, this.i.c(), false);     // Catch: Exception -> L113
        goto L115
    L95:
        r36 = UplinkStrategy.ORIGIN;     // Catch: Exception -> L113
        goto L98
    L96:
        r36 = UplinkStrategy.WS_ORIGIN;     // Catch: Exception -> L113
    L97:
        r36 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L113
        goto L98
    L109:
        if ((r30 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L112;
        Exception r40 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r30).b;     // Catch: Exception -> L113
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "receive uplink packet by uplink http error");     // Catch: Exception -> L113
        r29.c(r40, UplinkStrategy.UPLINK_HTTP, this.i.c());     // Catch: Exception -> L113
        goto L115
    L112:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L113
    L113:
        e = move-exception;
        r29.c(e, UplinkStrategy.UPLINK_HTTP, this.i.c());
        goto L115
    L117:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.uplink.UplinkRequestItem");
    L119:
        if (r1 != o) goto L141;
        Object r41 = r17.obj;
        if (r41 == null) goto L139;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "receive uplink packet by origin http");
        lmc.d r42 = this.f.a(((lmc.d) r41).k);
        if (r42 != null) goto L166;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "no request item found");
        return;
    L166:
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r43 = r42.c;     // Catch: Exception -> L135
        if (r43 != null) goto L128;
    L137:
        e(r42);
        return;
    L128:
        if ((r43 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L131;
        r42.d((com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r43).b, this.i.c());     // Catch: Exception -> L135
        goto L137
    L131:
        if ((r43 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L134;
        r42.c((Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r43).b, UplinkStrategy.ORIGIN_HTTP, this.i.c());     // Catch: Exception -> L135
        goto L137
    L134:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L135
    L135:
        e = move-exception;
        r42.c(e, UplinkStrategy.ORIGIN_HTTP, this.i.c());
        goto L137
    L139:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.uplink.UplinkRequestItem");
    L141:
        if (r1 != p) goto L151;
        Iterator<Map.Entry<Long, lmc.d>> r44 = this.f.a.entrySet().iterator();     // Catch: Throwable -> L163
    L144:
        if (r44.hasNext() == false) goto L146;
        Map.Entry<Long, lmc.d> r45 = r44.next();     // Catch: Throwable -> L163
        r45.getValue().c(new UplinkException(-4, "released", null, null, 12, null), this.a.getStrategy(this.i.c()), this.i.c());     // Catch: Throwable -> L163
        e(r45.getValue());     // Catch: Throwable -> L163
        goto L144
    L146:
        this.f.a.clear();     // Catch: Throwable -> L163
        lmc.c r46 = this.b;     // Catch: Throwable -> L163
        if (r46 == null) goto L192;
        r46.quit();     // Catch: Throwable -> L163
        return;
    L192:
        return;
    L199:
        return;
    L151:
        if (r1 != q) goto L193;
        LinkedHashMap<Long, lmc.d> r47 = this.f.a;
        LinkedHashMap r48 = new LinkedHashMap();
        Iterator<Map.Entry<Long, lmc.d>> r49 = r47.entrySet().iterator();
    L154:
        if (r49.hasNext() == false) goto L158;
        Map.Entry<Long, lmc.d> r50 = r49.next();
        if (r50.getValue().j == false) goto L154;
        r48.put(r50.getKey(), r50.getValue());
        goto L154
    L158:
        Iterator r51 = r48.entrySet().iterator();
    L160:
        if (r51.hasNext() == false) goto L200;
        Map.Entry r52 = (Map.Entry) r51.next();
        ((lmc.d) r52.getValue()).c(new UplinkException(-5, "ws disconnect", null, null, 12, null), UplinkStrategy.WS, this.i.c());
        e((lmc.d) r52.getValue());
        goto L160
    L200:
        return;
    L193:
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void i(tlc.f r3) {
        Intrinsics.checkNotNullParameter(r3, "payloadItem");
        i r0 = this.d;
        if (r0 == null) goto L8;
        Message r4 = r0.obtainMessage(m, r3);
        if (r4 == null) goto L9;
        r4.sendToTarget();
        return;
    L9:
        return;
    }

    public final void j(lmc.d r15) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "send uplink packet by ws, serviceId: " + r15.l + ", uniqueId: " + r15.k);
        SdkUplinkPacket r0 = r15.b();
        b r1 = new b(this, r15.k);
        r15.i = r1;
        r15.j = true;
        byte[] r3 = r0.encode();
        ArrayList r8 = new ArrayList();
        if (this.i.g() == false) goto L9;
        r8.add(new com.ss.ugc.live.sdk.msg.network.d("compress_type", "gzip"));
        ByteArrayInputStream r4 = new ByteArrayInputStream(r3);
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();
        GZIPOutputStream r6 = new GZIPOutputStream(r5);
        byte[] r7 = new byte[4096];
    L5:
        int r9 = r4.read(r7, 0, 4096);
        if (r9 == (-1)) goto L8;
        r6.write(r7, 0, r9);
        goto L5
    L8:
        r6.finish();
        r6.flush();
        r6.close();
        byte[] r10 = r5.toByteArray();
        r5.flush();
        r5.close();
        r4.close();
        byte[] r11 = r10;
    L10:
        r8.add(new com.ss.ugc.live.sdk.msg.network.d("im_uplink_service_id", String.valueOf(r15.l)));
        if (r15.a == false) goto L13;
        r8.add(new com.ss.ugc.live.sdk.msg.network.d("BYTELINK-DISABLE-RESPONSE", "true"));
    L13:
        this.i.e(new tlc.f(PayloadItemType.PAYLOAD_TYPE_UPLINK.getType(), "pb", r11, r8, r0.uniqueID.longValue(), r0.uniqueID.longValue()));
        if (r15.a == false) goto L16;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.l, "disable bytelink response，direct success");
        boolean r2 = this.i.c();
        Intrinsics.checkNotNullParameter(UplinkStrategy.WS, "uplinkStrategy");
        lmc.f r12 = r15.h;
        r12.getClass();
        Intrinsics.checkNotNullParameter(UplinkStrategy.WS, "uplinkStrategy");
        r12.f = System.currentTimeMillis();
        r12.b = UplinkStrategy.WS;
        r12.d = r2;
        r12.g = true;
        r12.h = 0;
        r12.i = "disable_response";
        e(r15);
        return;
    L16:
        com.ss.ugc.live.sdk.msg.utils.a.a(this.l, "post ws timeout task, timeout: " + r15.m);
        i r13 = this.c;
        if (r13 == null) goto L22;
        r13.postDelayed(r1, r15.m);
        return;
    L22:
        return;
    L9:
        r11 = r3;
        goto L10
    }

    public final void f(long r11, com.ss.ugc.live.sdk.msg.network.f r13, com.ss.ugc.live.sdk.msg.network.e r14) {
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "callback");
        long r2 = this.g.a.incrementAndGet();
        long r0 = r13.i;
        if (r0 > 0) goto L6;
        r0 = this.h.a();
    L6:
        lmc.d r1 = new lmc.d(r2, r11, r0, r13, r14);
        i r12 = this.c;
        if (r12 == null) goto L12;
        Message r15 = r12.obtainMessage(12345, r1);
        if (r15 == null) goto L13;
        r15.sendToTarget();
        return;
    L13:
        return;
    }

    public final void c(long r4, String r6, boolean r7, Exception r8) {
        JSONObject r0 = new JSONObject();
        r0.put("service_id", r4);
        r0.put("send_uplink_strategy", r6);
        r0.put("ws_connected", r7);
        JSONObject r5 = new JSONObject();
        String r9 = r8.getMessage();
        if (r9 != null) goto L6;
        r9 = "Unknown exception";
    L6:
        JSONObject r10 = new JSONObject();
        r10.put("error", r9);
        this.k.e("uplink_send_error", r0, r5, r10);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.l, "uplink send error, use strategy: " + r6 + ", ws connect: " + r7 + ", error: " + r9);
    }

    public a(amc.i r2, h r3, com.ss.ugc.live.sdk.msg.network.i r4, vlc.g r5, vlc.c r6) {
        Intrinsics.checkNotNullParameter(r2, "uplinkConfig");
        Intrinsics.checkNotNullParameter(r3, "wsState");
        Intrinsics.checkNotNullParameter(r4, "httpClient");
        Intrinsics.checkNotNullParameter(r5, "monitor");
        Intrinsics.checkNotNullParameter(r6, "logger");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        if (r2.b() == false) goto L8;
        if (r2.d() == false) goto L8;
        UplinkStrategy r7 = UplinkStrategy.WS_MSG_ORIGIN;
    L11:
        this.a = r7;
        this.f = new lmc.e();
        this.g = new c();
        return;
    L8:
        if (r2.b() == false) goto L10;
        r7 = UplinkStrategy.WS_ORIGIN;
        goto L11
    L10:
        r7 = UplinkStrategy.ORIGIN;
        goto L11
    }
}
