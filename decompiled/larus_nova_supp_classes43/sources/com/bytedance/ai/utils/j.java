package com.bytedance.ai.utils;

import androidx.collection.LruCache;
import com.bytedance.ai.event.MessageIndication;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final LruCache<Long, a> a = null;
    public static final LruCache<String, a> b = null;

    public static final class a {
        public final Long a;
        public final Long b;
        public final String c;
        public final String d;
        public String e;
        public final long f;
        public Map<String, Object> g;
        public int h;
        public b i;
        public final c j;
        public final c k;
        public final c l;
        public final c m;
        public final c n;
        public final c o;
        public final c p;
        public final c q;
        public final c r;
        public final c s;
        public final c t;
        public final c u;
        public final c v;
        public final List<c> w;

        public a() {
            this(null, null, null, null, 63);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            Long r12 = this.b;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.c;
            if (r15 != null) goto L13;
            int r16 = 0;
        L14:
            int r17 = (r14 + r16) * 31;
            String r18 = this.d;
            if (r18 != null) goto L17;
            int r19 = 0;
        L18:
            int r20 = (r17 + r19) * 31;
            String r21 = this.e;
            if (r21 == null) goto L22;
            r1 = r21.hashCode();
        L22:
            int r22 = (r20 + r1) * 31;
            long r23 = this.f;
            return r22 + ((int) (r23 ^ (r23 >>> 32)));
        L17:
            r19 = r18.hashCode();
            goto L18
        L13:
            r16 = r15.hashCode();
            goto L14
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Context(messageId=" + this.a + ", questionId=" + this.b + ", apiName=" + this.c + ", appletId=" + this.d + ", callbackId=" + this.e + ", received=" + this.f + ')';
        }

        public final void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            this.i = new b.c(r10);
        }

        public final synchronized void b(Pair<String, ? extends Object>... r10) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r10, "params");     // Catch: Throwable -> L12
            Map r0 = this.g;     // Catch: Throwable -> L12
            int r1 = 0;
            if (r0 != null) goto L6;
            r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("runtime_type", "client_tool")});     // Catch: Throwable -> L12
            this.g = r0;     // Catch: Throwable -> L12
        L6:
            int r11 = r10.length;     // Catch: Throwable -> L12
        L7:
            if (r1 >= r11) goto L10;
            Pair<String, ? extends Object> r12 = r10[r1];     // Catch: Throwable -> L12
            r0.put(r12.getFirst(), r12.getSecond());     // Catch: Throwable -> L12
            r1 = r1 + 1;
            goto L7
        L10:
            monitor-exit(this);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public a(Long r17, Long r18, String r19, String r20, int r21) {
            if ((r21 & 1) == 0) goto L5;
            Long r1 = null;
        L7:
            if ((r21 & 2) == 0) goto L9;
            Long r10 = null;
        L11:
            if ((r21 & 4) == 0) goto L13;
            String r11 = null;
        L15:
            if ((r21 & 8) == 0) goto L17;
            String r12 = null;
        L19:
            if ((r21 & 32) == 0) goto L21;
            long r13 = System.currentTimeMillis();
        L22:
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = null;
            this.f = r13;
            this.h = 1;
            this.i = b.d.c;
            c r14 = new c("appActionListenerBegin", "listener_begin", "app action listener begin");
            this.j = r14;
            c r15 = new c("appletRuntimeManagerBegin", "manager_begin", "applet runtime manager begin");
            this.k = r15;
            c r16 = new c("appletRuntimeManagerBeforeRunApplet", "run_applet_begin", "applet runtime manager before run applet");
            this.l = r16;
            c r22 = new c("appletRuntimeBegin", "runtime_begin", "applet runtime begin");
            this.m = r22;
            c r23 = new c("appletRuntimeSendMessage", "send_message", "applet runtime send message");
            this.n = r23;
            c r24 = new c("appletRuntimeProcessMessage", "process_message", "applet runtime process message");
            this.o = r24;
            c r25 = new c("appletRuntimeProcessMessageEnd", "process_message_end", "applet runtime process message end");
            this.p = r25;
            c r26 = new c("createWidget", "create_widget", "create widget");
            c r110 = new c("createText", "create_text", "create text");
            c r111 = new c("replyLocalPlugin", "reply_local_plugin", "reply local plugin");
            this.q = r111;
            c r112 = new c("replyLocalPluginProcessInMain", "reply_local_plugin_in_main", "reply local plugin in main");
            this.r = r112;
            c r113 = new c("reportAck", "report_ack", "report ack");
            this.s = r113;
            c r27 = new c("sendAckBegin", "send_ack_begin", "send ack begin");
            this.t = r27;
            c r114 = new c("sendAckEnd", "send_ack_end", "send ack end");
            this.u = r114;
            c r28 = new c("sendAckRealFinished", "send_ack_real_finished", "send ack real finished");
            this.v = r28;
            this.w = CollectionsKt.listOf(new c[]{r14, r15, r16, r22, r23, r24, r25, r26, r110, r111, r112, r113, r27, r28, r114});
            return;
        L21:
            r13 = 0;
            goto L22
        L17:
            r12 = r20;
            goto L19
        L13:
            r11 = r19;
            goto L15
        L9:
            r10 = r18;
            goto L11
        L5:
            r1 = r17;
            goto L7
        }
    }

    public static abstract class b {
        public final int a;
        public final String b;

        public static final class a {
        }

        /* JADX INFO: renamed from: com.bytedance.ai.utils.j$b$b, reason: collision with other inner class name */
        public static final class C0051b extends b {
            public final String c;

            @Override // com.bytedance.ai.utils.j.b
            public final String a() {
                return this.c;
            }

            public C0051b(String r10) {
                Intrinsics.checkNotNullParameter(r10, "errorMsg");
                super(103, r10);
                this.c = r10;
            }
        }

        public static final class c extends b {
            public final String c;

            @Override // com.bytedance.ai.utils.j.b
            public final String a() {
                return this.c;
            }

            public c(String r10) {
                Intrinsics.checkNotNullParameter(r10, "errorMsg");
                super(102, r10);
                this.c = r10;
            }
        }

        public static final class d extends b {
            public static final d c = null;

            static {
                c = new d();
            }

            public d() {
                super(0, "Succeed");
            }
        }

        public static final class e extends b {
            public final String c;

            public e() {
                Intrinsics.checkNotNullParameter("Local Plugin Timeout", "errorMsg");
                super(101, "Local Plugin Timeout");
                this.c = "Local Plugin Timeout";
            }

            @Override // com.bytedance.ai.utils.j.b
            public final String a() {
                return this.c;
            }
        }

        static {
        }

        public String a() {
            return this.b;
        }

        public b(int r1, String r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public Long d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "LocalPluginMonitorInfo(tag=" + this.a + ", monitorKey=" + this.b + ", des=" + this.c + ')';
        }

        public final void a() {
            this.d = Long.valueOf(System.currentTimeMillis());
            g.a.d("LocalPluginPerformanceManager", "timeline " + this.a + " start");
        }

        public c(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
            Intrinsics.checkNotNullParameter(r11, "monitorKey");
            Intrinsics.checkNotNullParameter(r12, "des");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    static {
        a = new LruCache(10);
        b = new LruCache(10);
    }

    public static a b(Long r1) {
        if (r1 == null) goto L5;
        r1.longValue();
        return (a) a.get(r1);
    L5:
        return null;
    }

    public static long a(Long r10, Long r11) {
        if (r10 == null) goto L8;
        long r0 = r10.longValue();
        if (r11 == null) goto L6;
        long r12 = r11.longValue();
    L10:
        return r0 - r12;
    L6:
        r12 = r0;
        goto L10
    L8:
        return 0;
    }

    public static String c(String r10, long r11, long r12) {
        return r10 + " cost: " + r11 + " ms " + ((r11 * 100.0d) / r12) + '%';
    }
}
