package cmc;

import amc.g;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.data.HeartbeatPacket;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import com.ss.ugc.live.sdk.msg.network.WSState;
import com.ss.ugc.live.sdk.msg.network.i;
import com.ss.ugc.live.sdk.msg.network.m;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.h;
import com.ss.ugc.live.sdk.msg.utils.j;
import com.ss.ugc.live.sdk.msg.utils.k;
import fmc.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tlc.f;
import vlc.n;
import vlc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.ugc.live.sdk.msg.utils.d, com.ss.ugc.live.sdk.msg.dispatch.d {
    public static String D;
    public static String E;
    public final WSState A;
    public final g B;
    public final List<bmc.a> C;
    public final i a;
    public final boolean b;
    public final bmc.b c;
    public final amc.d d;
    public final boolean e;
    public n f;
    public final c g;
    public final d h;
    public String i;
    public volatile String j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public volatile boolean s;
    public int t;
    public int u;
    public final j v;
    public final List<Long> w;
    public final AtomicLong x;
    public long y;
    public final com.ss.ugc.live.sdk.msg.c z;

    /* JADX INFO: renamed from: cmc.a$a, reason: collision with other inner class name */
    public static final class C0016a {
    }

    public final class b implements m {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: cmc.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC0017a implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0017a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                n r0 = this.a.a.f;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.a();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        /* JADX INFO: renamed from: cmc.a$b$b, reason: collision with other inner class name */
        public static final class RunnableC0018b implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ String b;

            public RunnableC0018b(b r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                n r0 = this.a.a.f;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.b(this.b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ f b;

            public c(b r1, f r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                n r0 = this.a.a.f;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.d(this.b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void i(f r2) {
            Intrinsics.checkNotNullParameter(r2, "payloadItem");
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void a() {
            com.ss.ugc.live.sdk.msg.utils.a.c(this.a.z, "on ws connected");
            ((ArrayList) this.a.w).clear();
            a r0 = this.a;
            r0.g.removeMessages(2103);
            r0.g.removeMessages(2104);
            this.a.c();
            this.a.o();
            MainTaskScheduler.a(new RunnableC0017a(this));
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "reason");
            com.ss.ugc.live.sdk.msg.utils.a.c(this.a.z, "on ws disconnected, reason: " + r4);
            a r0 = this.a;
            if (r0.g.hasMessages(2108) == false) goto L5;
            r0.g.removeMessages(2108);
        L5:
            this.a.c();
            this.a.n(0);
            MainTaskScheduler.a(new RunnableC0018b(this, r4));
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void d(f r8) {
            Intrinsics.checkNotNullParameter(r8, "payloadItem");
            if (this.a.k() == true) goto L5;
            return;
        L5:
            com.ss.ugc.live.sdk.msg.c r0 = this.a.z;
            StringBuilder r1 = new StringBuilder("on ws message received, payload type: ");
            r1.append(r8.c);
            r1.append(", log id: ");
            int r2 = com.ss.ugc.live.sdk.msg.utils.c.a;
            List<com.ss.ugc.live.sdk.msg.network.d> r3 = r8.f;
            if (r3 == null) goto L19;
            Iterator<T> r4 = r3.iterator();
        L9:
            if (r4.hasNext() == false) goto L13;
            Object r5 = r4.next();
            if (StringsKt.equals("im-logid", ((com.ss.ugc.live.sdk.msg.network.d) r5).a, true) == false) goto L9;
        L14:
            com.ss.ugc.live.sdk.msg.network.d r6 = (com.ss.ugc.live.sdk.msg.network.d) r5;
            if (r6 == null) goto L19;
            String r7 = r6.b;
            if (r7 == null) goto L19;
        L20:
            r1.append(r7);
            com.ss.ugc.live.sdk.msg.utils.a.c(r0, r1.toString());
            String r9 = r8.c;
            if (Intrinsics.areEqual(r9, PayloadItemType.PAYLOAD_TYPE_MSG.getType()) == false) goto L24;
        L25:
            a r10 = this.a;
            r10.q = System.currentTimeMillis();
            r8.i = System.currentTimeMillis();
            this.a.g.obtainMessage(2107, r8).sendToTarget();
        L32:
            MainTaskScheduler.a(new c(this, r8));
            return;
        L24:
            if (Intrinsics.areEqual(r9, PayloadItemType.PAYLOAD_TYPE_RECONNECT.getType()) == true) goto L25;
            if (Intrinsics.areEqual(r9, PayloadItemType.PAYLOAD_TYPE_CLOSE.getType()) == false) goto L30;
            this.a.f("server close");
            this.a.n(0);
            goto L32
        L30:
            if (Intrinsics.areEqual(r9, PayloadItemType.PAYLOAD_TYPE_HEARTBEAT.getType()) == false) goto L32;
            this.a.g.obtainMessage(2109, r8).sendToTarget();
            goto L32
        L13:
            r5 = null;
        L19:
            r7 = "";
            goto L20
        }
    }

    public static final class c extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r11) {
            Intrinsics.checkNotNullParameter(r11, "msg");
            a r0 = this.a;
            r0.getClass();
            long r3 = 0;
            switch(r11.what) {
                case 2103: goto L76;
                case 2104: goto L68;
                case 2105: goto L56;
                case 2106: goto L51;
                case 2107: goto L46;
                case 2108: goto L36;
                case 2109: goto L10;
                case 2110: goto L106;
                case 2111: goto L7;
                case 2112: goto L5;
                default: goto L106;
            };
        L5:
            r0.e();
            return;
        L10:
            Object r12 = r11.obj;
            if (r12 == null) goto L34;
            f r13 = (f) r12;
            long r1 = r0.y;     // Catch: Throwable -> L31
            int r5 = h.a;     // Catch: Throwable -> L31
            List<com.ss.ugc.live.sdk.msg.network.d> r14 = r13.f;     // Catch: Throwable -> L31
            if (r14 == null) goto L29;
            Iterator<T> r15 = r14.iterator();     // Catch: Throwable -> L31
        L17:
            if (r15.hasNext() == false) goto L21;
            Object r6 = r15.next();     // Catch: Throwable -> L31
            if (Intrinsics.areEqual(((com.ss.ugc.live.sdk.msg.network.d) r6).a, "server_time") == false) goto L17;
        L22:
            com.ss.ugc.live.sdk.msg.network.d r7 = (com.ss.ugc.live.sdk.msg.network.d) r6;     // Catch: Throwable -> L31
            if (r7 == null) goto L29;
            String r16 = r7.b;     // Catch: Throwable -> L31
            if (r16 == null) goto L29;
            Long r17 = StringsKt.toLongOrNull(r16);     // Catch: Throwable -> L31
            if (r17 == null) goto L29;
            r3 = r17.longValue();     // Catch: Throwable -> L31
            goto L29
        L21:
            r6 = null;
        L29:
            long r8 = System.currentTimeMillis();     // Catch: Throwable -> L31
            com.ss.ugc.live.sdk.msg.utils.a.c(r0.z, "sendPacketTime = " + r1 + ", serverTime = " + r3 + ", receivePacketTime = " + r8 + ", serverTimeGap = " + ((r3 + ((r8 - r1) / ((long) 2))) - r8));     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            th.printStackTrace();
            return;
        L34:
            throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
        L46:
            Object r18 = r11.obj;
            if (r18 == null) goto L50;
            fmc.m r2 = new fmc.m(r0.c, r0.d);
            r0.z.i.b(r2, (f) r18, r0.v);
            return;
        L50:
            throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
        L51:
            Object r19 = r11.obj;
            if (r19 == null) goto L55;
            r0.f((String) r19);
            return;
        L55:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L56:
            Object r110 = r11.obj;
            if (r110 == null) goto L66;
            SdkResponse r111 = (SdkResponse) r110;
            String r4 = r111.push_server;
            Map<String, String> r9 = r111.route_params;
            String r112 = r111.push_server_v2;
            if (r0.k() == false) goto L110;
            com.ss.ugc.live.sdk.msg.utils.a.c(r0.z, "connect ws, url: " + r4);
            HashMap r10 = new HashMap();
            if (r9 == null) goto L64;
            r10.putAll(r9);
        L64:
            r10.putAll(r0.d.a());
            r10.putAll(r0.i());
            r10.putAll(r0.B.a());
            r0.A.j(r4, r10, new b(r0), r112);
            r0.B.j();
            r0.p(5000);
            r0.q(Conf$StickerSetManagerPosition.STICKER_SET_SHOP);
            return;
        L110:
            return;
        L66:
            throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.data.SdkResponse");
        L76:
            Object r113 = r11.obj;
            if (r113 == null) goto L88;
            String r114 = (String) r113;
            if (r0.k() == true) goto L81;
            return;
        L81:
            if (r0.s == false) goto L84;
            return;
        L84:
            if (r0.A.c() == true) goto L114;
            com.ss.ugc.live.sdk.msg.utils.a.c(r0.z, "fetch message with rule " + r114 + ", cursor: " + r0.j);
            HashMap r20 = new HashMap();
            r20.putAll(r0.B.a());
            HashMap r21 = new HashMap();
            r21.put("fetch_rule", r114);
            r21.putAll(r0.i());
            com.ss.ugc.live.sdk.msg.network.f.a r115 = new com.ss.ugc.live.sdk.msg.network.f.a();
            r115.a.b = r0.j();
            com.ss.ugc.live.sdk.msg.network.f.a r116 = r115.query(r20);
            com.ss.ugc.live.sdk.msg.network.f r22 = r116.a;
            r22.h = r21;
            r22.g = "application/x-www-form-urlencoded; charset=UTF-8";
            com.ss.ugc.live.sdk.msg.network.f r117 = r116.a();
            r0.q = System.currentTimeMillis();
            r0.s = true;
            r0.z.i.b(new fmc.i(fmc.h.a, r0.a, r0.c, Intrinsics.areEqual(r0.j, "0")), r117, r0.v);
            return;
        L114:
            return;
        L88:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L106:
            return;
        L7:
            if (Intrinsics.areEqual(r0.A.d.b(), WSState.c.b.a) == false) goto L9;
            r0.f("ws connect timeout");
        L9:
            r0.n(0);
            return;
        L36:
            if (r0.k() == true) goto L39;
            return;
        L39:
            if (r0.A.c() == false) goto L109;
            long r23 = r0.x.incrementAndGet();
            r0.y = System.currentTimeMillis();
            HeartbeatPacket.Builder r118 = new HeartbeatPacket.Builder();
            Iterator<T> r24 = r0.C.iterator();
        L43:
            if (r24.hasNext() == false) goto L45;
            ((bmc.a) r24.next()).O40(r118);
            goto L43
        L45:
            HeartbeatPacket r119 = r118.m1673build();
            com.ss.ugc.live.sdk.msg.utils.a.c(r0.z, "send heartbeat packet: seqId is " + r23);
            r0.A.k("hb", HeartbeatPacket.ADAPTER.encode(r119), new ArrayList(), r23, r23);
            r0.o();
            return;
        L109:
            return;
        L68:
            if (r0.k() == true) goto L70;
            return;
        L70:
            if (r0.s == false) goto L73;
            return;
        L73:
            if (r0.A.c() == true) goto L112;
            com.ss.ugc.live.sdk.msg.utils.a.c(r0.z, "determine message fetch strategy, cursor: " + r0.j);
            HashMap r120 = new HashMap();
            r120.putAll(r0.B.a());
            HashMap r25 = new HashMap();
            r25.put("fetch_rule", Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
            r25.putAll(r0.i());
            com.ss.ugc.live.sdk.msg.network.f.a r26 = new com.ss.ugc.live.sdk.msg.network.f.a();
            r26.a.b = r0.j();
            com.ss.ugc.live.sdk.msg.network.f.a r121 = r26.query(r120);
            com.ss.ugc.live.sdk.msg.network.f r27 = r121.a;
            r27.h = r25;
            r27.g = "application/x-www-form-urlencoded; charset=UTF-8";
            com.ss.ugc.live.sdk.msg.network.f r122 = r121.a();
            r0.q = System.currentTimeMillis();
            r0.s = true;
            r0.z.i.b(new fmc.i(fmc.a.a, r0.a, r0.c, Intrinsics.areEqual(r0.j, "0")), r122, r0.v);
            return;
        }

        public c(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class d extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            a r0 = this.a;
            r0.getClass();
            int r1 = r5.what;
            if (r1 != 2101) goto L5;
            r0.o = System.currentTimeMillis();
            if (r0.b == true) goto L18;
            r0.g.obtainMessage(2103, "0").sendToTarget();
            return;
        L18:
            if (r0.e == false) goto L20;
            r0.g.obtainMessage(2112).sendToTarget();
            return;
        L20:
            r0.g.obtainMessage(2104).sendToTarget();
            return;
        L5:
            if (r1 != 2102) goto L26;
            Object r6 = r5.obj;
            if (r6 == null) goto L14;
            if (((Boolean) r6).booleanValue() == false) goto L12;
            r0.j = "0";
            r0.i = "";
        L12:
            r0.g.removeCallbacksAndMessages(null);
            Message r7 = r0.g.obtainMessage(2106, "pause");
            r0.g.sendMessage(r7);
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }

        public d(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
        D = "0";
        E = "";
    }

    public final void c() {
        if (this.g.hasMessages(2111) == false) goto L6;
        this.g.removeMessages(2111);
        return;
    }

    public final String h() {
        String r0 = this.B.g();
        o r1 = amc.a.a(this.B);
        if (r1 == null) goto L18;
        boolean r2 = true;
        if (r1.f() != true) goto L19;
        o r3 = amc.a.a(this.B);
        if (r3 == null) goto L9;
        String r4 = r3.c();
    L10:
        if (r4 != null) goto L12;
    L15:
        if (r2 == false) goto L17;
        return r0;
    L17:
        return r4;
    L12:
        if (r4.length() == 0) goto L15;
        r2 = false;
        goto L15
    L9:
        r4 = null;
        goto L10
    L19:
        return r0;
    L18:
        return r0;
    }

    public final Map<String, String> i() {
        HashMap r0 = new HashMap();
        r0.put("support_cache", Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
        r0.put("live_cursor", D);
        r0.put("wrds_preload_ext", E);
        r0.put("cursor", this.j);
        if (this.i.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L12:
        r0.put("resp_content_type", "protobuf");
        long r3 = this.p;
        if (r3 <= 0) goto L15;
        r0.put("fetch_time", String.valueOf(r3));
    L15:
        r0.put("parse_cnt", String.valueOf(this.n));
        r0.put("recv_cnt", String.valueOf(this.m));
        r0.put("last_rtt", String.valueOf(this.l));
        r0.put("support_wrds", Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
        if (((ArrayList) this.w).size() <= 0) goto L18;
        r0.put("ack_ids", TextUtils.join(",", this.w));
        ((ArrayList) this.w).clear();
    L18:
        return r0;
    L8:
        if (TextUtils.equals(this.j, "0") == true) goto L12;
        if ((!StringsKt.isBlank(this.j)) == false) goto L12;
        r0.put("internal_ext", this.i);
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public final String j() {
        String r0 = this.B.e();
        o r1 = amc.a.a(this.B);
        if (r1 == null) goto L18;
        boolean r2 = true;
        if (r1.f() != true) goto L18;
        o r3 = amc.a.a(this.B);
        if (r3 == null) goto L9;
        String r4 = r3.e();
    L10:
        if (r4 != null) goto L12;
    L15:
        if (r2 == true) goto L18;
        r0 = r4;
        goto L18
    L12:
        if (r4.length() == 0) goto L15;
        r2 = false;
        goto L15
    L9:
        r4 = null;
    L18:
        if (this.B.k() == true) goto L20;
        return r0;
    L20:
        if (Intrinsics.areEqual(this.j, "0") == true) goto L22;
        return r0;
    L22:
        return UriProtector.parse(r0).buildUpon().appendEncodedPath("first/").build().toString();
    }

    public final boolean k() {
        return this.z.isRunning();
    }

    public final void e() {
        if (k() == true) goto L5;
        return;
    L5:
        String r0 = h();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "direct connect ws, url: " + r0);
        boolean r1 = false;
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "direct ws url is empty");
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "fallback to determine message fetch strategy");
        n(0);
        return;
    L15:
        HashMap r4 = new HashMap();
        r4.putAll(this.d.a());
        r4.putAll(i());
        r4.putAll(this.B.a());
        b r5 = new b(this);
        WSState r6 = this.A;
        g r7 = this.B;
        String r8 = null;
        if ((r7 instanceof amc.h) == true) goto L18;
        r7 = null;
    L18:
        amc.h r9 = (amc.h) r7;
        if (r9 == null) goto L21;
        String r10 = r9.m();
    L22:
        o r11 = amc.a.a(this.B);
        if (r11 != null) goto L25;
    L35:
        r6.j(r0, r4, r5, r10);
        p(3000);
        return;
    L25:
        if (r11.f() != true) goto L35;
        o r12 = amc.a.a(this.B);
        if (r12 == null) goto L29;
        r8 = r12.b();
    L29:
        if (r8 != null) goto L31;
    L32:
        r1 = true;
    L33:
        if (r1 == true) goto L35;
        r10 = r8;
        goto L35
    L31:
        if (r8.length() != 0) goto L33;
    L21:
        r10 = null;
        goto L22
    L8:
        if (r0.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public final void o() {
        if (k() == true) goto L5;
        return;
    L5:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "trigger heartbeat timer");
        if (this.g.hasMessages(2108) == false) goto L8;
        this.g.removeMessages(2108);
    L8:
        Message r0 = this.g.obtainMessage(2108);
        this.g.sendMessageDelayed(r0, this.r * 1000);
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.d
    public final long a() {
        return this.q;
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.d
    public final long d() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(k r20) {
        Intrinsics.checkNotNullParameter(r20, "whatResult");
        mmc.c r2 = r20.a;
        long r4 = 1000;
        boolean r9 = true;
        if ((r2 instanceof fmc.a) == false) goto L27;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r1 = r20.b;
        ((fmc.a) r2).getClass();
        Intrinsics.checkNotNullParameter(r1, "result");
        if ((r1 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L22;
        com.ss.ugc.live.sdk.msg.data.a r3 = (com.ss.ugc.live.sdk.msg.data.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r1).b;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.z, "onDetermineMessageFetchStrategy, logId: ".concat(com.ss.ugc.live.sdk.msg.utils.c.c(r3.a)));
        this.s = false;
        this.t = 0;
        this.u = 0;
        m(r3, false);
        SdkResponse r5 = r3.d;
        Integer r6 = r5.fetch_type;
        if (r6 != null) goto L10;
    L16:
        com.ss.ugc.live.sdk.msg.utils.a.a(this.z, "onDetermineMessageFetchStrategy, use http, redetermine");
        g(r3);
        long r8 = this.k;
        if (r8 <= 0) goto L19;
        r4 = r8;
    L19:
        n(r4);
    L20:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "on messages fetch from http, determine strategy: " + r5.fetch_type + ", messages: " + com.ss.ugc.live.sdk.msg.utils.c.d(r5));
        return;
    L10:
        if (r6.intValue() != 1) goto L16;
        if (TextUtils.isEmpty(r5.push_server) == true) goto L16;
        if (this.A.c() == true) goto L16;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.z, "onDetermineMessageFetchStrategy, use ws");
        g(r3);
        this.g.obtainMessage(2105, r5).sendToTarget();
        goto L20
    L22:
        if ((r1 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L25;
        l(((com.ss.ugc.live.sdk.msg.utils.g.b) r1).b);
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    L27:
        if ((r2 instanceof fmc.h) == false) goto L47;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r7 = r20.b;
        ((fmc.h) r2).getClass();
        Intrinsics.checkNotNullParameter(r7, "result");
        if ((r7 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L42;
        com.ss.ugc.live.sdk.msg.data.a r10 = (com.ss.ugc.live.sdk.msg.data.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r7).b;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.z, "onApiSuccess, logId: ".concat(com.ss.ugc.live.sdk.msg.utils.c.c(r10.a)));
        this.s = false;
        this.t = 0;
        this.u = 0;
        m(r10, false);
        g(r10);
        if (Intrinsics.areEqual(this.A.d.b(), WSState.c.b.a) == false) goto L34;
        q(Conf$StickerSetManagerPosition.STICKER_SET_SHOP);
    L40:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "on messages fetch from http, messages: " + com.ss.ugc.live.sdk.msg.utils.c.d(r10.d));
        return;
    L34:
        if (this.b == false) goto L39;
        long r11 = this.k;
        if (r11 <= 0) goto L38;
        r4 = r11;
    L38:
        n(r4);
        goto L40
    L39:
        q("0");
        goto L40
    L42:
        if ((r7 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L45;
        l(((com.ss.ugc.live.sdk.msg.utils.g.b) r7).b);
        return;
    L45:
        throw new NoWhenBranchMatchedException();
    L47:
        if ((r2 instanceof l) == false) goto L126;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r12 = r20.b;
        ((l) r2).getClass();
        Intrinsics.checkNotNullParameter(r12, "result");
        if ((r12 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L118;
        com.ss.ugc.live.sdk.msg.data.a r13 = (com.ss.ugc.live.sdk.msg.data.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r12).b;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.z, "onWSPayloadDecoded");
        f r14 = r13.b;
        if (r14 == null) goto L53;
        String r15 = r14.c;
    L55:
        if (Intrinsics.areEqual(r15, PayloadItemType.PAYLOAD_TYPE_MSG.getType()) == false) goto L77;
        m(r13, true);
        g(r13);
        SdkResponse r16 = r13.d;
        if (r16.need_ack.booleanValue() == false) goto L75;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.z, "need send ack: " + r13.b());
        if (k() == false) goto L75;
        if (this.A.c() == false) goto L75;
        f r17 = r13.b;
        if (r17 == null) goto L75;
        String r18 = r13.b();
        if (r18 != null) goto L70;
        r18 = "";
    L70:
        r13.f.d = System.currentTimeMillis();
        com.ss.ugc.live.sdk.msg.data.c r19 = r13.f;
        g r21 = this.B;
        r19.getClass();
        ArrayList r110 = new ArrayList();
        r110.add(new com.ss.ugc.live.sdk.msg.network.d("client_recv_time", String.valueOf(r19.a)));
        r110.add(new com.ss.ugc.live.sdk.msg.network.d("client_start_pack_time", String.valueOf(r19.b)));
        r110.add(new com.ss.ugc.live.sdk.msg.network.d("client_finish_pack_time", String.valueOf(r19.c)));
        r110.add(new com.ss.ugc.live.sdk.msg.network.d("client_send_ack_time", String.valueOf(r19.d)));
        r110.add(new com.ss.ugc.live.sdk.msg.network.d("im-trace-receive_count", String.valueOf(r19.e)));
        r110.add(new com.ss.ugc.live.sdk.msg.network.d("im-trace-error_count", String.valueOf(r19.f.size())));
        LinkedHashSet<Long> r22 = r19.f;
        if (r21 == null) goto L73;
        int r23 = r21.c();
    L74:
        r110.add(new com.ss.ugc.live.sdk.msg.network.d("im-trace-error_msg_ids", TextUtils.join(",", CollectionsKt.take(r22, Math.max(0, r23)))));
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "send ack, payload type: ack, internal_ext: ".concat(r18));
        this.A.k("ack", r18.getBytes(Charsets.UTF_8), r110, r17.g, r17.h);
        goto L75
    L73:
        r23 = 15;
    L75:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "on messages fetch from ws, messages: " + com.ss.ugc.live.sdk.msg.utils.c.d(r16));
        return;
    L77:
        if (Intrinsics.areEqual(r15, PayloadItemType.PAYLOAD_TYPE_RECONNECT.getType()) == false) goto L116;
        o r24 = amc.a.a(this.B);
        SdkResponse r25 = r13.d;
        String r26 = r25.proxy_server;
        String r27 = r25.push_server;
        String r28 = r25.push_server_v2;
        if (r24 != null) goto L81;
    L107:
        f("server reconnect");
        String r29 = h();
        if (r29 != null) goto L110;
    L113:
        if (r9 == true) goto L115;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "receive reconnect command, disconnect ws then connect ws url: " + r29);
        this.g.removeMessages(2103);
        this.g.removeMessages(2104);
        e();
        return;
    L115:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "receive reconnect command, disconnect ws then redetermine");
        n(0);
        return;
    L110:
        if (r29.length() == 0) goto L113;
        r9 = false;
        goto L113
    L81:
        if (r24.f() == false) goto L107;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "receive reconnect command, process switcher url, http url: " + r26 + ", ws url: " + r27);
        if (r26 != null) goto L85;
    L88:
        boolean r30 = true;
    L89:
        if (r30 == true) goto L91;
        r24.g(r26);
    L91:
        if (r27 != null) goto L93;
    L96:
        boolean r31 = true;
    L97:
        if (r31 == true) goto L99;
        r24.d(r27);
    L99:
        if (r28 != null) goto L101;
    L104:
        boolean r32 = true;
    L105:
        if (r32 == true) goto L107;
        r24.a(r28);
        goto L107
    L101:
        if (r28.length() == 0) goto L104;
        r32 = false;
        goto L105
    L93:
        if (r27.length() == 0) goto L96;
        r31 = false;
        goto L97
    L85:
        if (r26.length() == 0) goto L88;
        r30 = false;
        goto L89
    L116:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "can not process payload type: " + r15);
        return;
    L53:
        r15 = null;
        goto L55
    L118:
        if ((r12 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L121;
        E r33 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r12).b;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "ws payload decode failed due to " + r33.getMessage());
        return;
    L121:
        throw new NoWhenBranchMatchedException();
    }

    public final void f(String r4) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "disconnect ws due to ".concat(r4));
        WSState r0 = this.A;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "reason");
        r0.b = null;
        com.ss.ugc.live.sdk.msg.network.k r2 = r0.a;
        if (r2 == null) goto L5;
        r2.disconnect();
    L5:
        r0.a = null;
        r0.d.d(new WSState.a.c(r4));
    }

    public final void g(com.ss.ugc.live.sdk.msg.data.a r5) {
        List<tlc.d> r6 = r5.e;
        List<tlc.d> r0 = r6;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r6.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        if (((tlc.d) r4).needMonitor() == false) goto L13;
        r2.add(r4);
        goto L13
    L17:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r8 = r2.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        r7.add(Long.valueOf(((tlc.d) r8.next()).getMessageId()));
        goto L19
    L21:
        ((ArrayList) this.w).addAll(r7);
        com.ss.ugc.live.sdk.msg.dispatch.e r9 = this.z.b;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("messageConsumer");
    L24:
        r9.c(r6);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void l(Throwable r7) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "onApiError: " + r7.getMessage());
        this.s = false;
        this.t = this.t + 1;
        if ((r7 instanceof HttpException) == true) goto L5;
    L11:
        this.l = -1;
        this.m = 0;
        this.n = 0;
        if (this.b == false) goto L32;
        long r2 = this.k;
        if (r2 > 0) goto L17;
        r2 = 1000;
    L17:
        int r8 = this.u;
        if (r8 <= 0) goto L27;
        long r3 = r2 * ((long) Math.pow(2.0d, r8));
        g r9 = this.B;
        if ((r9 instanceof amc.h) == true) goto L22;
        r9 = null;
    L22:
        amc.h r10 = (amc.h) r9;
        if (r10 == null) goto L25;
        long r0 = r10.n();
    L26:
        long r1 = Math.min(r3, r0);
    L31:
        n(r1);
        return;
    L25:
        r0 = 8000;
        goto L26
    L27:
        int r11 = this.t;
        if (r11 <= 3) goto L30;
        r1 = 5000;
        goto L31
    L30:
        r1 = ((long) r11) * ((long) AudioViewModel.ASR_SESSION_IDLE);
        goto L31
    L32:
        q("0");
        return;
    L5:
        if (((HttpException) r7).getCode() != 503) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L10;
        this.u++;
        JSONObject r13 = new JSONObject();
        JSONObject r4 = new JSONObject();
        r4.put("server_limit_count", this.u);
        this.z.e("message_server_limit_trigger", r13, r4, new JSONObject());
        goto L11
    L10:
        this.u = 0;
        goto L11
    L7:
        r12 = false;
        goto L8
    }

    public final void n(long r5) {
        if (k() == true) goto L6;
        return;
    L6:
        if (this.A.c() == false) goto L9;
        return;
    L9:
        if (this.g.hasMessages(2103) == false) goto L11;
        return;
    L11:
        if (this.g.hasMessages(2104) == true) goto L16;
        c();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "redetermineMessageFetchStrategy, delay: " + r5);
        this.g.sendEmptyMessageDelayed(2104, r5);
        return;
    }

    public final void p(long r5) {
        if (k() == true) goto L5;
        return;
    L5:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "trigger ws fallback timer");
        c();
        Message r0 = this.g.obtainMessage(2111);
        this.g.sendMessageDelayed(r0, Math.max(1000, r5));
    }

    public final void q(String r9) {
        if (k() == true) goto L6;
        return;
    L6:
        if (this.A.c() == false) goto L9;
        return;
    L9:
        if (this.g.hasMessages(2103) == false) goto L11;
        return;
    L11:
        if (this.g.hasMessages(2104) == true) goto L30;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.z, "start next fetch with rule ".concat(r9));
        long r2 = this.k;
        if (r2 > 0) goto L17;
        r2 = 1000;
    L17:
        int r0 = this.u;
        if (r0 <= 0) goto L27;
        long r3 = r2 * ((long) Math.pow(2.0d, r0));
        g r1 = this.B;
        if ((r1 instanceof amc.h) == true) goto L22;
        r1 = null;
    L22:
        amc.h r4 = (amc.h) r1;
        if (r4 == null) goto L25;
        long r5 = r4.n();
    L26:
        r2 = Math.min(r3, r5);
        goto L27
    L25:
        r5 = 8000;
    L27:
        this.g.sendMessageDelayed(this.g.obtainMessage(2103, r9), r2);
        return;
    }

    public final void m(com.ss.ugc.live.sdk.msg.data.a r10, boolean r11) {
        SdkResponse r0 = r10.d;
        com.ss.ugc.live.sdk.msg.network.g r1 = r10.a;
        List<com.ss.ugc.live.sdk.msg.network.d> r2 = null;
        if (r1 == null) goto L5;
        List<com.ss.ugc.live.sdk.msg.network.d> r3 = r1.c;
    L9:
        int r4 = com.ss.ugc.live.sdk.msg.utils.c.a;
        if (r3 == null) goto L21;
        Iterator<T> r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();
        if (StringsKt.equals("im-live_cursor", ((com.ss.ugc.live.sdk.msg.network.d) r6).a, true) == false) goto L13;
    L18:
        com.ss.ugc.live.sdk.msg.network.d r7 = (com.ss.ugc.live.sdk.msg.network.d) r6;
        if (r7 == null) goto L21;
        String r8 = r7.b;
    L22:
        if (r8 != null) goto L25;
        r8 = r10.d.live_cursor;
    L25:
        String r9 = "";
        if (r8 != null) goto L30;
        r8 = "";
    L30:
        if (TextUtils.isEmpty(r8) == true) goto L32;
        D = r8;
    L32:
        com.ss.ugc.live.sdk.msg.network.g r12 = r10.a;
        if (r12 == null) goto L35;
        List<com.ss.ugc.live.sdk.msg.network.d> r13 = r12.c;
    L39:
        int r14 = com.ss.ugc.live.sdk.msg.utils.c.a;
        if (r13 == null) goto L51;
        Iterator<T> r15 = r13.iterator();
    L43:
        if (r15.hasNext() == false) goto L47;
        Object r16 = r15.next();
        if (StringsKt.equals("im-wrds_preload_ext", ((com.ss.ugc.live.sdk.msg.network.d) r16).a, true) == false) goto L43;
    L48:
        com.ss.ugc.live.sdk.msg.network.d r17 = (com.ss.ugc.live.sdk.msg.network.d) r16;
        if (r17 == null) goto L51;
        String r18 = r17.b;
    L52:
        if (r18 != null) goto L56;
        r18 = "";
    L56:
        if (TextUtils.isEmpty(r18) == true) goto L58;
        E = r18;
    L58:
        String r19 = r10.a();
        if (r19 != null) goto L62;
        r19 = "";
    L62:
        this.j = r19;
        Long r20 = r0.fetch_interval;
        if (r20 == null) goto L65;
        long r21 = r20.longValue();
    L66:
        this.k = r21;
        com.ss.ugc.live.sdk.msg.network.g r22 = r10.a;
        if (r22 == null) goto L69;
        r2 = r22.c;
    L72:
        Long r23 = r10.d.now;
        if (r23 == null) goto L75;
        long r24 = r23.longValue();
    L76:
        Long r25 = com.ss.ugc.live.sdk.msg.utils.c.e(r2);
        if (r25 == null) goto L79;
        r24 = r25.longValue();
    L79:
        this.p = r24;
        String r26 = r10.b();
        if (r26 == null) goto L82;
        r9 = r26;
    L82:
        this.i = r9;
        o r27 = amc.a.a(this.B);
        if (r27 != null) goto L85;
    L95:
        long r28 = 0;
        if (r10.c == true) goto L98;
    L108:
        List<SdkMessage> r110 = r0.messages;
        if (r110 == null) goto L111;
        long r29 = r110.size();
    L112:
        this.m = r29;
        this.n = r10.e.size();
        Long r111 = r0.heartbeat_duration;
        if (r111 == null) goto L115;
        r28 = r111.longValue();
    L115:
        this.r = Math.max(10, r28);
        com.ss.ugc.live.sdk.msg.utils.a.a(this.z, "process common response, cursor: " + this.j + ", live_cursor: " + r8 + ", next use live_cursor:" + D);
        return;
    L111:
        r29 = 0;
        goto L112
    L98:
        if (this.z.j.f() == true) goto L102;
        String r30 = r10.a();
        if (r30 == null) goto L102;
        com.ss.ugc.live.sdk.msg.c r31 = this.z;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r31.c = r30;
    L102:
        Boolean r32 = r10.d.history_no_more;
        if (r32 == null) goto L106;
        this.z.d = !r32.booleanValue();
    L106:
        if (this.o <= 0) goto L108;
        long r33 = System.currentTimeMillis() - this.o;
        JSONObject r34 = new JSONObject();
        r34.put("direct_connect_ws", this.e);
        r34.put("ws_received", r11);
        JSONObject r112 = new JSONObject();
        r112.put("use_time", r33);
        this.z.e("receive_first_im_message_cost", r34, r112, new JSONObject());
        goto L108
    L85:
        if (r27.f() != true) goto L95;
        String r35 = r10.d.proxy_server;
        if (r35 != null) goto L89;
    L92:
        boolean r36 = true;
    L93:
        if (r36 == true) goto L95;
        r27.g(r35);
        goto L95
    L89:
        if (r35.length() == 0) goto L92;
        r36 = false;
        goto L93
    L75:
        r24 = System.currentTimeMillis();
        goto L76
    L69:
        f r37 = r10.b;
        if (r37 == null) goto L72;
        r2 = r37.f;
        goto L72
    L65:
        r21 = 1000;
        goto L66
    L47:
        r16 = null;
    L51:
        r18 = null;
        goto L52
    L35:
        f r38 = r10.b;
        if (r38 == null) goto L38;
        r13 = r38.f;
        goto L39
    L38:
        r13 = null;
        goto L39
    L17:
        r6 = null;
    L21:
        r8 = null;
        goto L22
    L5:
        f r39 = r10.b;
        if (r39 == null) goto L8;
        r3 = r39.f;
        goto L9
    L8:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(com.ss.ugc.live.sdk.msg.c r2, WSState r3, g r4, List<? extends bmc.a> r5) {
        Intrinsics.checkNotNullParameter(r2, "messageContext");
        Intrinsics.checkNotNullParameter(r3, "wsState");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "plugins");
        this.z = r2;
        this.A = r3;
        this.B = r4;
        this.C = r5;
        this.a = r4.d();
        this.b = r4.b();
        this.c = new bmc.b(r4.h(), r5);
        amc.d r6 = r4.l();
        if (r6 != null) goto L6;
        r6 = new com.ss.ugc.live.sdk.msg.network.c();
    L6:
        this.d = r6;
        if (r4.i() == true) goto L9;
    L11:
        boolean r7 = false;
    L12:
        this.e = r7;
        this.g = new c(this, Looper.getMainLooper());
        this.h = new d(this, Looper.getMainLooper());
        this.i = "";
        this.j = "0";
        this.k = 1000;
        this.r = 10;
        this.v = new j(this);
        this.w = new ArrayList();
        this.x = new AtomicLong(0);
        return;
    L9:
        if (TextUtils.isEmpty(r4.g()) == true) goto L11;
        r7 = true;
        goto L12
    }
}
