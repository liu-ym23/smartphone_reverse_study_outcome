package com.ss.ugc.live.sdk.msg.network;

import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class WSState implements m, lmc.h {
    public k a;
    public m b;
    public m c;
    public final StateMachine<c, a, b> d;
    public final l e;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.WSState$a$a, reason: collision with other inner class name */
        public static final class C0207a extends a {
            public static final C0207a a = null;

            static {
                a = new C0207a();
            }

            public C0207a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public final String a;

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.WSState$b$b, reason: collision with other inner class name */
        public static final class C0208b extends b {
            public static final C0208b a = null;

            static {
                a = new C0208b();
            }

            public C0208b() {
            }
        }

        public static final class c extends b {
            public final String a;

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.WSState$c$c, reason: collision with other inner class name */
        public static final class C0209c extends c {
            public static final C0209c a = null;

            static {
                a = new C0209c();
            }

            public C0209c() {
            }
        }

        public c() {
        }
    }

    @Override // lmc.h
    public final void f() {
        this.c = null;
    }

    @Override // lmc.h
    public final boolean g() {
        return false;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void a() {
        this.d.d(a.b.a);
    }

    @Override // lmc.h
    public final boolean c() {
        if (Intrinsics.areEqual(this.d.b(), c.a.a) == false) goto L9;
        k r0 = this.a;
        if (r0 == null) goto L9;
        if (r0.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public WSState(l r2) {
        Intrinsics.checkNotNullParameter(r2, "wsClient");
        this.e = r2;
        StateMachine.a r3 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r0 = new WSState$stateMachine$1(this);
        r3.getClass();
        this.d = StateMachine.a.a(r0);
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.d.d(new a.c(r3));
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void d(tlc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadItem");
        m r0 = this.b;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    @Override // lmc.h
    public final void e(tlc.f r2) {
        k r0 = this.a;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // lmc.h
    public final void h(m r1) {
        this.c = r1;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void i(tlc.f r3) {
        Intrinsics.checkNotNullParameter(r3, "payloadItem");
        if (Intrinsics.areEqual(r3.c, PayloadItemType.PAYLOAD_TYPE_UPLINK.getType()) == false) goto L8;
        m r0 = this.c;
        if (r0 == null) goto L9;
        r0.i(r3);
        return;
    L9:
        return;
    }

    public final void j(String r2, Map r3, cmc.a.b r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "onWSListener");
        this.b = r4;
        this.a = this.e.a(r2, r3, this, r5);
        this.d.d(a.C0207a.a);
    }

    public final void k(String r13, byte[] r14, List r15, long r16, long r18) {
        Intrinsics.checkNotNullParameter("none", "encodeType");
        Intrinsics.checkNotNullParameter(r13, "payloadType");
        Intrinsics.checkNotNullParameter(r14, "payload");
        Intrinsics.checkNotNullParameter(r15, "headers");
        if (c() == true) goto L5;
        return;
    L5:
        k r10 = this.a;
        if (r10 == null) goto L9;
        r10.f(new tlc.f(r13, "none", r14, r15, r16, r18));
        return;
    }
}
