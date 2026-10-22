package com.ss.ugc.live.sdk.msg.unify;

import com.ss.ugc.live.sdk.msg.unify.business.UnifyLiveMessageDispatcher;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState;
import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vlc.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements imc.a {
    public final CopyOnWriteArraySet<imc.c> a;
    public n b;
    public final StateMachine<d, a, AbstractC0220c> c;
    public final long d;
    public final UnifyWSState e;
    public final imc.d f;
    public final com.ss.ugc.live.sdk.msg.unify.b g;
    public final b h;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$a$a, reason: collision with other inner class name */
        public static final class C0218a extends a {
            public static final C0218a a = null;

            static {
                a = new C0218a();
            }

            public C0218a() {
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

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$a$c, reason: collision with other inner class name */
        public static final class C0219c extends a {
            public final long a;

            public C0219c(long r1) {
                this.a = r1;
            }
        }

        public static final class d extends a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {
            public final long a;

            public e(long r1) {
                this.a = r1;
            }
        }

        public static final class f extends a {
            public final long a;

            public f(long r1) {
                this.a = r1;
            }
        }

        public a() {
        }
    }

    public interface b {
        void a(c r1);
    }

    /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0220c {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$c$a */
        public static final class a extends AbstractC0220c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public AbstractC0220c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$d$c, reason: collision with other inner class name */
        public static final class C0221c extends d {
            public static final C0221c a = null;

            static {
                a = new C0221c();
            }

            public C0221c() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$d$d, reason: collision with other inner class name */
        public static final class C0222d extends d {
            public static final C0222d a = null;

            static {
                a = new C0222d();
            }

            public C0222d() {
            }
        }

        public static final class e extends d {
            public final long a;

            public e(long r1) {
                this.a = r1;
            }
        }

        public static final class f extends d {
            public static final f a = null;

            static {
                a = new f();
            }

            public f() {
            }
        }

        public d() {
        }
    }

    public final String a() {
        return "[service: " + g() + ", method: " + e() + ", token: " + this.d + ']';
    }

    public final List<UMGWCustomData> b() {
        Map<String, String> r0 = this.f.d();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, String> r3 = r2.next();
        r1.add(new UMGWCustomData(r3.getKey(), r3.getValue()));
        goto L4
    L6:
        return r1;
    }

    @Override // vlc.f
    public final boolean c() {
        return this.e.e();
    }

    public final int e() {
        return this.f.b().b;
    }

    public final List<UMGWCustomData> f() {
        Map<String, String> r0 = this.f.b().c;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, String> r3 = r2.next();
        r1.add(new UMGWCustomData(r3.getKey(), r3.getValue()));
        goto L4
    L6:
        return r1;
    }

    public final int g() {
        return this.f.b().a;
    }

    public final d h() {
        return this.c.b();
    }

    @Override // imc.a
    public final void unregister() {
        this.c.d(a.d.a);
    }

    @Override // imc.a
    public final void A(UnifyLiveMessageDispatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.add(r2);
    }

    @Override // vlc.f
    public final void p(n r1) {
        this.b = r1;
    }

    @Override // vlc.f
    public final boolean w(tlc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadItem");
        if (c() == false) goto L5;
        this.e.f(r2);
        return true;
    L5:
        return false;
    }

    public c(long r2, UnifyWSState r4, imc.d r5, com.ss.ugc.live.sdk.msg.unify.b r6, com.ss.ugc.live.sdk.msg.unify.d.a r7) {
        Intrinsics.checkNotNullParameter(r4, "wsState");
        Intrinsics.checkNotNullParameter(r5, "unifyBusinessConfig");
        Intrinsics.checkNotNullParameter(r6, "unifyLinkManager");
        Intrinsics.checkNotNullParameter(r7, "onBridgeStateListener");
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.a = new CopyOnWriteArraySet();
        StateMachine.a r3 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<d, a, AbstractC0220c>, Unit> r8 = new UnifyMessageBridge$stateMachine$1(this);
        r3.getClass();
        this.c = StateMachine.a.a(r8);
    }
}
