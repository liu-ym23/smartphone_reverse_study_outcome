package d3;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w implements b0 {
    public static final PthreadHandlerThreadV2 k = null;
    public static final Lazy<Handler> l = null;
    public int a;
    public final f3.c b;
    public final List<f3.l> c;
    public final i3.c d;
    public final Lazy e;
    public m4.c f;
    public final s4.c<n4.c> g;
    public final SparseArray<Consumer<ProtocolMessage>> h;
    public final e3.a i;
    public boolean j;

    public static final class a {
        public final List<f3.l> a;

        /* JADX INFO: renamed from: d3.w$a$a, reason: collision with other inner class name */
        public static final class C0149a {
        }

        static {
        }

        public a() {
            throw null;
        }

        public a(List r10) {
            Intrinsics.checkNotNullParameter(r10, "methodSeekers");
            this.a = r10;
        }

        public final AIBridgeMethod a(String r10, e3.a r11) {
            Intrinsics.checkNotNullParameter(r10, "methodName");
            Intrinsics.checkNotNullParameter(r11, "bridgeContext");
            a0 r12 = r11.getContainerContext();
            if (r12 == null) goto L6;
            ContainerType r13 = r12.getContainerType();
            if (r13 == null) goto L6;
        L7:
            AIBridgeMethod r0 = f3.k.b.a(r10, r13);
            if (r0 == null) goto L10;
            return r0;
        L10:
            Iterator<f3.l> r1 = this.a.iterator();
        L12:
            if (r1.hasNext() == false) goto L16;
            AIBridgeMethod r14 = r1.next().a(r10, r13);
            if (r14 == null) goto L12;
            return r14;
        L16:
            return null;
        L6:
            r13 = ContainerType.NONE;
            goto L7
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProtocolMessage.Type.values().length];
            r0[ProtocolMessage.Type.Call.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ProtocolMessage.Type.Callback.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ProtocolMessage.Type.Event.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class d implements e3.g {
        public final /* synthetic */ w a;

        public d(w r1) {
            this.a = r1;
        }

        @Override // e3.g
        public final void b(String r10, JsonObject r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.a.a(r10, r11);
        }
    }

    public static final class e extends n4.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ ProtocolMessage b;

        @Override // n4.b
        public final void a() {
            j4.a.a.getClass();
            j4.a r0 = j4.a.C0167a.a();
            if (r0 == null) goto L6;
            r0.b(this.a, this.b);
            return;
        }

        @Override // n4.b
        public final void b() {
            j4.a.a.getClass();
            j4.a r0 = j4.a.C0167a.a();
            if (r0 == null) goto L6;
            r0.c(this.a);
            return;
        }

        public e(String r1, ProtocolMessage r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class f extends n4.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ w b;

        @Override // n4.b
        public final void a() {
            String r0 = this.a;
            if (r0 == null) goto L13;
            w r1 = this.b;
            j4.a.a.getClass();
            j4.a r10 = j4.a.C0167a.a();
            if (r10 == null) goto L14;
            a0 r11 = r1.i.getContainerContext();
            if (r11 == null) goto L10;
            ContainerType r12 = r11.getContainerType();
            if (r12 == null) goto L10;
        L11:
            r10.k(r0, r12);
            return;
        L10:
            r12 = ContainerType.NONE;
            goto L11
        L14:
            return;
        }

        @Override // n4.b
        public final void b() {
            String r0 = this.a;
            if (r0 == null) goto L8;
            w r1 = this.b;
            j4.a.a.getClass();
            j4.a r10 = j4.a.C0167a.a();
            if (r10 == null) goto L9;
            r10.l(r0, r1.f);
            return;
        L9:
            return;
        }

        public f(String r1, w r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class g extends n4.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ w b;
        public final /* synthetic */ String c;

        @Override // n4.b
        public final void a() {
            j4.a.a.getClass();
            j4.a r0 = j4.a.C0167a.a();
            if (r0 == null) goto L6;
            r0.f(this.a, this.b.i.getContainerContext(), this.c);
            return;
        }

        @Override // n4.b
        public final void b() {
            j4.a.a.getClass();
            j4.a r0 = j4.a.C0167a.a();
            if (r0 == null) goto L6;
            r0.i(this.a, this.b.f);
            return;
        }

        public g(String r1, w r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    static {
        new b();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("ai_bridge_thread");
        ThreadMethodProxy.start(r0);
        k = r0;
        l = LazyKt.lazy(new d3.g());
    }

    public final void g() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        this.g.a();
        this.h.clear();
        m4.c r0 = this.f;
        if (r0 == null) goto L8;
        r0.close();
    L8:
        String r1 = null;
        this.f = null;
        e3.a r10 = this.i;
        Iterator r11 = ((ConcurrentHashMap) r10.b).values().iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        ((e3.f) r11.next()).release();
        goto L10
    L12:
        ((ConcurrentHashMap) r10.b).clear();
        a0 r12 = this.i.getContainerContext();
        if (r12 == null) goto L15;
        r1 = r12.getContainerId();
    L15:
        if (r1 == null) goto L21;
        j4.a.a.getClass();
        j4.a r13 = j4.a.C0167a.a();
        if (r13 == null) goto L22;
        r13.a(r1);
        return;
    L22:
        return;
    }

    public w() {
        f3.c r0 = new f3.c();
        this.b = r0;
        this.c = CollectionsKt.mutableListOf(new f3.l[]{r0});
        this.d = new i3.c();
        this.e = LazyKt.lazy(new j(this));
        this.g = new s4.c();
        this.h = new SparseArray();
        this.i = new e3.a(new d(this));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [d3.p] */
    @Override // d3.b0
    public final com.bytedance.ai.bridge.core.a<JsonObject> b(JsonObject r13) {
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_MSG);
        int r0 = ProtocolMessage.a;
        ProtocolMessage r14 = ProtocolMessage.b.a(r13);
        if (r14 != null) goto L7;
        int r15 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "invalid protocol message");
    L7:
        if (r14.getType() == ProtocolMessage.Type.Call) goto L11;
        int r1 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "sync only supports Call type, got: " + r14.getType());
    L11:
        if (r14.e() != null) goto L14;
        int r16 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "method name is null");
    L14:
        TargetEntity r10 = r14.g();
        if (r10 != null) goto L17;
    L66:
        int r17 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "sync call only supports system.bridge target, got: " + r10);
    L17:
        if (r10.b() != TargetEntity.Scope.System) goto L66;
        if (r10.c() != TargetEntity.Target.Bridge) goto L66;
        final String r11 = r14.e();
        if (r11 != null) goto L24;
        int r18 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "method name is null");
    L24:
        String r12 = e(r14);
        j4.a.a.getClass();
        j4.a r19 = j4.a.C0167a.a();
        if (r19 == null) goto L27;
        r19.g(r12, System.currentTimeMillis(), this.i.getContainerContext(), r11, this.f);
    L27:
        AIBridgeMethod.Error r20 = this.d.a(new i3.a(r11, r14.f(), this.i));
        if (r20 == null) goto L33;
        int r21 = r20.getCode();
        String r22 = r20.getMsg();
        if (r22 != null) goto L69;
        r22 = "";
    L69:
        return new com.bytedance.ai.bridge.core.a.b(r21, r22, r20.getData(), r20.getErrNo(), 16);
    L33:
        j4.a r23 = j4.a.C0167a.a();
        if (r23 == null) goto L36;
        r23.d(r12);
    L36:
        j4.a r24 = j4.a.C0167a.a();
        if (r24 == null) goto L39;
        r24.h(r12);
    L39:
        a r25 = (a) this.e.getValue();
        final e3.a r26 = this.i;
        final JsonObject r110 = r14.f();
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "methodName");
        AIBridgeMethod r27 = r25.a(r11, r26);
        if (r27 != null) goto L43;
        int r111 = com.bytedance.ai.bridge.core.a.a;
        com.bytedance.ai.bridge.core.a<JsonObject> r112 = com.bytedance.ai.bridge.core.a.C0020a.a(-2, "method not found: ".concat(r11));
    L60:
        if ((r112 instanceof com.bytedance.ai.bridge.core.a.b) == false) goto L70;
        j4.a r28 = j4.a.C0167a.a();
        if (r28 == null) goto L64;
        r28.markError(r12);
    L64:
        com.bytedance.ai.applet.base.log.b r29 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r30 = new StringBuilder("[AIBridge] sync call method:");
        r30.append(r11);
        r30.append(" error with code:");
        com.bytedance.ai.bridge.core.a.b r31 = (com.bytedance.ai.bridge.core.a.b) r112;
        r30.append(r31.b);
        r30.append(", msg:");
        r30.append(r31.c);
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", r30.toString(), null);
        return r112;
    L70:
        return r112;
    L43:
        if (r27.getSupportSyncCall() == true) goto L46;
        int r113 = com.bytedance.ai.bridge.core.a.a;
        r112 = com.bytedance.ai.bridge.core.a.C0020a.a(-2, "method does not support sync: ".concat(r11));
        goto L60
    L46:
        if ((r27 instanceof CoreAIBridgeMethod) == true) goto L48;
        int r114 = com.bytedance.ai.bridge.core.a.a;
        r112 = com.bytedance.ai.bridge.core.a.C0020a.a(0, "method does not extend CoreAIBridgeMethod");
        goto L60
    L48:
        final CoreAIBridgeMethod r32 = (CoreAIBridgeMethod) r27;
        final ?? r33 = new p(r32, r26, r110, r11);
        if (r32.mustRunInMain() == true) goto L51;
    L58:
        r112 = (com.bytedance.ai.bridge.core.a) r33.invoke();
        goto L60
    L51:
        if (p2.c.b() == true) goto L58;
        final Ref.ObjectRef r115 = new Ref.ObjectRef();
        final CountDownLatch r34 = new CountDownLatch(1);
        p2.c.d(new q(r115, r33, r34));
        if (r34.await(3000, TimeUnit.MILLISECONDS) == true) goto L55;
        r112 = new com.bytedance.ai.bridge.core.a.b(0, "sync call timeout", null, null, 28);
        goto L60
    L55:
        r112 = (com.bytedance.ai.bridge.core.a) r115.element;
        if (r112 != null) goto L60;
        r112 = new com.bytedance.ai.bridge.core.a.b(0, "null result", null, null, 28);
        goto L60
    }

    public final void d(i3.b r10) {
        Intrinsics.checkNotNullParameter(r10, "interceptor");
        i3.c r0 = this.d;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r10, "interceptor");     // Catch: Throwable -> L20
        Iterator<i3.b> r1 = r0.a.iterator();     // Catch: Throwable -> L20
        int r11 = 0;
    L6:
        if (r1.hasNext() == false) goto L14;
        if (r1.next().getPriority() <= r10.getPriority()) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L15;
        r11 = r11 + 1;     // Catch: Throwable -> L20
    L15:
        if (r11 >= 0) goto L17;
        r0.a.add(r10);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);
        return;
    L17:
        r0.a.add(r11, r10);     // Catch: Throwable -> L20
        goto L18
    L10:
        r12 = false;
        goto L11
    L14:
        r11 = -1;
    L20:
        th = move-exception;
        throw th;
    }

    public final String e(ProtocolMessage r10) {
        StringBuilder r0 = new StringBuilder();
        a0 r1 = this.i.getContainerContext();
        if (r1 == null) goto L5;
        String r11 = r1.getContainerId();
    L6:
        r0.append(r11);
        r0.append('_');
        r0.append(r10.c());
        return r0.toString();
    L5:
        r11 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [d3.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14, types: [d3.s] */
    /* JADX WARN: Type inference failed for: r3v4, types: [d3.n] */
    /* JADX WARN: Type inference failed for: r3v5, types: [d3.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [d3.o] */
    /* JADX WARN: Type inference failed for: r4v6, types: [d3.r] */
    public final void f(n4.d r21) {
        final ProtocolMessage r10 = r21.a;
        Object r11 = null;
        String r12 = null;
        if (r10.getType() != null) goto L6;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "receive msg with no Type", null);
        return;
    L6:
        String r13 = e(r10);
        ProtocolMessage.Type r14 = r10.getType();
        if (r14 != null) goto L9;
        int r15 = -1;
    L11:
        if (r15 == 1) goto L38;
        if (r15 != 2) goto L15;
        Integer r16 = r10.c();
        if (r16 == null) goto L36;
        r16.intValue();
        String r17 = this.i.c(r10.c().intValue());
        if (r17 == null) goto L32;
        j4.a.a.getClass();
        j4.a r18 = j4.a.C0167a.a();
        if (r18 == null) goto L32;
        r18.e(r17, r21.b);
    L32:
        Consumer<ProtocolMessage> r1 = this.h.get(r10.c().intValue());
        if (r1 == null) goto L35;
        this.h.remove(r10.c().intValue());
        r1.accept(r10);
        return;
    L35:
        com.bytedance.ai.applet.base.log.b r19 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[AIBridge] can not find callback with id:" + r10.c(), null);
        return;
    L36:
        return;
    L15:
        if (r15 != 3) goto L24;
        if (r10.e() != null) goto L19;
        return;
    L19:
        Lazy r20 = l3.d.a;
        l3.a r22 = new l3.a(r10.e(), r10.f(), r10.h());
        a0 r23 = this.i.getContainerContext();
        if (r23 == null) goto L22;
        r12 = r23.getAppletId();
    L22:
        r22.d = r12;
        l3.d.c(r22);
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    L38:
        if (r10.e() != null) goto L41;
        return;
    L41:
        if (r10.g() != null) goto L43;
        return;
    L43:
        j4.a.a.getClass();
        j4.a r24 = j4.a.C0167a.a();
        if (r24 == null) goto L46;
        r24.g(r13, r21.b, this.i.getContainerContext(), r10.e(), this.f);
    L46:
        final AtomicBoolean r25 = new AtomicBoolean(false);
        final x r26 = new x(r10.e(), r10);
        if (r10.g().b() == TargetEntity.Scope.System) goto L49;
    L69:
        j4.a r27 = j4.a.C0167a.a();
        if (r27 == null) goto L72;
        r27.j(r13);
    L72:
        List<h3.f> r28 = h3.b.a;
        e3.a r29 = this.i;
        d3.b r30 = new d3.b(this, r26, r25);
        Intrinsics.checkNotNullParameter(r29, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "protocolMessage");
        Intrinsics.checkNotNullParameter(r30, "resultCallback");
        Iterator r31 = ((ArrayList) h3.b.a).iterator();
    L74:
        if (r31.hasNext() == false) goto L83;
        Object r32 = r31.next();
        h3.f r33 = (h3.f) r32;
        if (r33 != null) goto L78;
    L80:
        boolean r34 = false;
    L81:
        if (r34 == false) goto L74;
        r11 = r32;
        goto L83
    L78:
        if (r33.a(r10) != true) goto L80;
        r34 = true;
    L83:
        h3.f r35 = (h3.f) r11;
        if (r35 == null) goto L99;
        r35.b(r29, r10, r30);
        return;
    L99:
        return;
    L49:
        if (r10.g().c() != TargetEntity.Target.Bridge) goto L69;
        final ?? r36 = new n(this, r26, r25);
        final ?? r37 = new o(this, r26, r25);
        String r38 = r10.e();
        if (r38 == null) goto L100;
        final String r39 = e(r10);
        AIBridgeMethod.Error r40 = this.d.a(new i3.a(r38, r10.f(), this.i));
        if (r40 == null) goto L56;
        r37.accept(r40);
        return;
    L56:
        j4.a r41 = j4.a.C0167a.a();
        if (r41 == null) goto L59;
        r41.d(r39);
    L59:
        j4.a r42 = j4.a.C0167a.a();
        if (r42 == null) goto L62;
        r42.h(r39);
    L62:
        final a r43 = (a) this.e.getValue();
        final e3.a r44 = this.i;
        final String r45 = r10.e();
        final JsonObject r110 = r10.f();
        final ?? r111 = new d3.e(r36);
        final ?? r46 = new d3.f(r39, r10, r37);
        r43.getClass();
        Intrinsics.checkNotNullParameter(r44, "bridgeContext");
        Intrinsics.checkNotNullParameter(r45, "methodName");
        Intrinsics.checkNotNullParameter(r111, "resolve");
        Intrinsics.checkNotNullParameter(r46, "reject");
        final AIBridgeMethod r47 = r43.a(r45, r44);
        if (r47 != null) goto L65;
        r46.accept(new AIBridgeMethod.UnregisteredError(null, 1, null));
        return;
    L65:
        final ?? r48 = new r(r43, r45, r111, r46);
        final ?? r49 = new s(r47, r44, r110, r45, r48);
        if (r47.mustRunInMain() == false) goto L68;
        p2.c.d(new t(r49));
        return;
    L68:
        r49.invoke();
        return;
    L100:
        return;
    L9:
        r15 = c.a[r14.ordinal()];
        goto L11
    }

    public final void j(View r10) {
        Intrinsics.checkNotNullParameter(r10, "engineView");
        e3.a r1 = this.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "engineView");
        r1.c = new WeakReference(r10);
    }

    public final void k(final m4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "port");
        this.f = r10;
        r10.setBridge$applet_bridge_release(this);
        this.g.d(new h(r10));
        r10.setOnMessageCallback$applet_bridge_release(new i(this));
    }

    @Override // d3.b0
    public final void a(final String r10, final JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Runnable r0 = new k(this, r10, r11);
        ((Handler) l.getValue()).post(r0);
    }

    public final <T> void h(x r10, T r11, AtomicBoolean r12) {
        ProtocolMessage r13 = r10.a.b(r11);
        if (r13 != null) goto L6;
        return;
    L6:
        if (r12.compareAndSet(false, true) == false) goto L8;
        this.g.b(new n4.c(r13, new e(e(r13), r13)));
        return;
    L8:
        com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[AIBridge] repeat replyCall with callbackId:" + r13.c(), null);
    }

    @Override // d3.b0
    public final void c(final ProtocolMessage r10, final Consumer<JsonObject> r11, final Consumer<AIBridgeMethod.Error> r12, final String r13) {
        Intrinsics.checkNotNullParameter(r10, "protocolMessage");
        Runnable r0 = new d3.a(r11, r12, this, r13, r10);
        ((Handler) l.getValue()).post(r0);
    }

    public final void i(String r10, JsonObject r11, Consumer<JsonObject> r12, Consumer<AIBridgeMethod.Error> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        c(new ProtocolMessage(r10, r11, null, null, ProtocolMessage.Type.Call, 44), r12, r13, null);
    }
}
