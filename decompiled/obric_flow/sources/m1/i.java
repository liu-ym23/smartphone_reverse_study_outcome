package m1;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.bytedance.ai.bridge.core.AIBridgeMethod$UnregisteredError;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.model.m;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HandlerThread f19970i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f19971j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.b f19973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f19974c;
    public i2.c d;
    public final l2.a e;
    public final SparseArray f;
    public final n1.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19975h;

    static {
        HandlerThread r5 = new HandlerThread("ai_bridge_thread");
        r5.start();
        f19970i = r5;
        f19971j = LazyKt.lazy(new a3.f(27));
    }

    public i() {
        o1.b r5 = new o1.b(0);
        this.f19973b = r5;
        this.f19974c = CollectionsKt.mutableListOf(new o1.b[]{r5});
        this.e = new l2.a();
        this.f = new SparseArray();
        this.g = new n1.a(new f(this));
    }

    public final String a(ProtocolMessage r5) {
        StringBuilder r10 = new StringBuilder();
        j r11 = (j) this.g.b(j.class);
        if (r11 == null) goto L5;
        String r12 = r11.c();
    L6:
        r10.append(r12);
        r10.append('_');
        r10.append(r5.c());
        return r10.toString();
    L5:
        r12 = null;
        goto L6
    }

    public final o1.a b(String r10) {
        Iterator r5 = this.f19974c.iterator();
        o1.a r11 = null;
    L3:
        boolean r12 = r5.hasNext();
        n1.a r13 = this.g;
        if (r12 == false) goto L12;
        o1.b r14 = (o1.b) r5.next();
        j r15 = (j) r13.b(j.class);
        if (r15 == null) goto L9;
        ContainerType r16 = r15.d();
        if (r16 == null) goto L9;
    L10:
        r11 = r14.a(r10, r16);
        if (r11 == null) goto L3;
    L9:
        r16 = ContainerType.e;
    L12:
        if (r11 != null) goto L20;
        o1.i r17 = o1.i.f20397c;
        j r18 = (j) r13.b(j.class);
        if (r18 == null) goto L17;
        ContainerType r19 = r18.d();
        if (r19 == null) goto L17;
    L19:
        return r17.a(r10, r19);
    L17:
        r19 = ContainerType.e;
        goto L19
    L20:
        return r11;
    }

    public final void c(View r5) {
        Intrinsics.checkNotNullParameter(r5, "engineView");
        n1.a r10 = this.g;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "engineView");
        r10.f20197c = new WeakReference(r5);
    }

    public final void d(i2.c r5) {
        Intrinsics.checkNotNullParameter(r5, "port");
        this.d = r5;
        c r10 = new c(r5, 2);
        this.e.b(r10);
        c r11 = new c(this, 3);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "consumer");
        r5.b(new i2.a(r5, r11, 0));
    }

    public final void e(String r5, JsonObject r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        androidx.room.f r11 = new androidx.room.f(this, 10, r5, r10);
        ((Handler) f19971j.getValue()).post(r11);
    }

    public final void f(ym.j r5, Object r10, AtomicBoolean r11) {
        ProtocolMessage r12 = ((ProtocolMessage) r5.f23302a).b(r10);
        if (r12 != null) goto L6;
        return;
    L6:
        if (r11.compareAndSet(false, true) == false) goto L9;
        this.e.c(new j2.a(r12, new g(0, a(r12), r12)));
        return;
    L9:
        String r13 = "[AIBridge] repeat replyCall with callbackId:" + r12.c();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a1.a.f43a.e("ai_bridge", r13, null);
    }

    public final void g() {
        if (this.f19975h == true) goto L35;
        this.f19975h = true;
        this.e.a();
        i2.c r5 = this.d;
        if (r5 == null) goto L8;
        r5.a();
    L8:
        n1.a r10 = this.g;
        Iterator r11 = r10.f20196b.values().iterator();
    L10:
        if (r11.hasNext() == false) goto L18;
        n1.b r12 = (n1.b) r11.next();
        switch(r12.f20198a) {
            case 0: goto L17;
            default: goto L13;
        };
    L17:
        r12.f20199b = null;
        goto L10
    L13:
        WeakReference r13 = (WeakReference) r12.f20199b;
        if (r13 == null) goto L16;
        r13.clear();
    L16:
        r12.f20199b = null;
        goto L10
    L18:
        r10.f20196b.clear();
        j r14 = (j) r10.b(j.class);
        if (r14 == null) goto L21;
        String r15 = r14.c();
    L22:
        if (r15 != null) goto L24;
        return;
    L24:
        if (td.d.f22127b == null) goto L34;
        Intrinsics.checkNotNullParameter(r15, "containerId");
        a3.i.a(new a3.a(r15, 2));
        return;
    L34:
        return;
    L21:
        r15 = null;
        goto L22
    }

    public final void h(j2.b r23) {
        int r10 = 1;
        int r5 = 3;
        ProtocolMessage r11 = (ProtocolMessage) r23.f22372b;
        String r13 = null;
        if (r11.i() != null) goto L6;
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("receive msg with no Type", "msg");
        a1.a.f43a.e("ai_bridge", "receive msg with no Type", null);
        return;
    L6:
        String r12 = a(r11);
        ProtocolMessage.Type r14 = r11.i();
        if (r14 != null) goto L9;
        int r15 = -1;
    L10:
        n1.a r16 = this.g;
        if (r15 == 1) goto L58;
        if (r15 == 2) goto L45;
        if (r15 != 3) goto L43;
        if (r11.e() == null) goto L144;
        Lazy r17 = s1.c.f21808a;
        String r18 = r11.e();
        s1.a r19 = new s1.a(r18, r11.f(), r11.h());
        j r20 = (j) r16.b(j.class);
        if (r20 == null) goto L20;
        r13 = r20.b();
    L20:
        r19.d = r13;
        Intrinsics.checkNotNullParameter(r19, "aiBridgeEvent");
        if (r18.length() == 0) goto L137;
        long r21 = System.currentTimeMillis();
        ConcurrentSkipListSet r22 = new ConcurrentSkipListSet();
        Lazy r24 = s1.c.f21808a;
        Iterator r25 = ((CopyOnWriteArrayList) r24.getValue()).iterator();
    L25:
        if (r25.hasNext() == false) goto L29;
        s1.a r26 = (s1.a) r25.next();
        if (Math.abs(r21 - r26.f21806c) <= 10000) goto L25;
        r22.add(r26);
        goto L25
    L29:
        Iterator r27 = r22.iterator();
    L31:
        if (r27.hasNext() == false) goto L33;
        ((CopyOnWriteArrayList) r24.getValue()).remove((s1.a) r27.next());
        goto L31
    L33:
        ((CopyOnWriteArrayList) r24.getValue()).add(r19);
        CopyOnWriteArrayList r28 = (CopyOnWriteArrayList) ((ConcurrentHashMap) s1.c.f21809b.getValue()).get(r19.f21804a);
        if (r28 == null) goto L36;
        CollectionsKt.removeAll(r28, new m(20));
    L36:
        if (r28 == null) goto L41;
        Iterator r29 = r28.iterator();
    L39:
        if (r29.hasNext() == false) goto L138;
        ((s1.d) r29.next()).a(r19);
        goto L39
    L138:
        return;
    L41:
        return;
    L137:
        return;
    L144:
        return;
    L43:
        throw new NoWhenBranchMatchedException();
    L45:
        if (r11.c() == null) goto L142;
        String r30 = (String) r16.d.get(r11.c().intValue());
        if (r30 != null) goto L49;
    L51:
        SparseArray r31 = this.f;
        Consumer r32 = (Consumer) r31.get(r11.c().intValue());
        if (r32 == null) goto L55;
        r31.remove(r11.c().intValue());
        r32.accept(r11);
        return;
    L55:
        String r33 = "[AIBridge] can not find callback with id:" + r11.c();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r33, "msg");
        a1.a.f43a.e("ai_bridge", r33, null);
        return;
    L49:
        if (td.d.f22127b == null) goto L51;
        long r34 = r23.f18231c;
        Intrinsics.checkNotNullParameter(r30, "traceId");
        a3.i.a(new a3.b(r34, r30, r5));
        goto L51
    L142:
        return;
    L58:
        if (r11.e() != null) goto L61;
        return;
    L61:
        if (r11.g() != null) goto L64;
        return;
    L64:
        if (td.d.f22127b == null) goto L67;
        long r35 = r23.f18231c;
        j r110 = (j) r16.b(j.class);
        String r36 = r11.e();
        i2.c r111 = this.d;
        Intrinsics.checkNotNullParameter(r12, "traceId");
        Intrinsics.checkNotNullParameter(r36, "callName");
        a3.i.a(new a3.e(r35, r110, r36, r12, r111));
    L67:
        AtomicBoolean r37 = new AtomicBoolean(false);
        Intrinsics.checkNotNullParameter(r11.e(), "methodName");
        Intrinsics.checkNotNullParameter(r11, "protocolMessage");
        ym.j r38 = new ym.j();
        r38.f23302a = r11;
        System.currentTimeMillis();
        if (r11.g().b() != TargetEntity.Scope.f2033a) goto L106;
        if (r11.g().c() != TargetEntity.Target.f2036a) goto L106;
        b r39 = new b(this, r38, r37, 2);
        b r112 = new b(this, r38, r37, 3);
        if (r11.e() == null) goto L141;
        String r40 = a(r11);
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L85
        if (td.d.f22127b == null) goto L79;
        Intrinsics.checkNotNullParameter(r40, "traceId");     // Catch: Throwable -> L85
        a3.i.a(new a3.b(r40, System.currentTimeMillis(), 4));     // Catch: Throwable -> L85
    L79:
        o1.a r113 = b(r11.e());     // Catch: Throwable -> L85
        if (r113 != null) goto L88;
        r112.accept(new AIBridgeMethod$UnregisteredError());     // Catch: Throwable -> L85
        if (td.d.f22127b == null) goto L84;
        a3.i r42 = a3.i.f83a;     // Catch: Throwable -> L85
        Intrinsics.checkNotNullParameter(r40, "traceId");     // Catch: Throwable -> L85
        a3.i.a(new a3.a(r40, r10));     // Catch: Throwable -> L85
    L84:
        String r43 = "[AIBridge] the called method:" + r11.e() + " isn't registered";     // Catch: Throwable -> L85
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");     // Catch: Throwable -> L85
        Intrinsics.checkNotNullParameter(r43, "msg");     // Catch: Throwable -> L85
        a1.a.f43a.e("ai_bridge", r43, null);     // Catch: Throwable -> L85
        return;
    L88:
        String r44 = r40;
        String r114 = "msg";
        String r115 = "traceId";
        a r45 = new a(r40, r113, this, r11, r39, r112);     // Catch: Throwable -> L92
        if (r113.mustRunInMain() == false) goto L94;
        c1.b.b(new com.obric.oui.lisitem.a(r45, 16));     // Catch: Throwable -> L92
    L95:
        Object r46 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L98:
        Throwable r47 = Result.m127exceptionOrNullimpl(r46);
        if (r47 != null) goto L101;
        return;
    L101:
        if (td.d.f22127b == null) goto L103;
        a3.i r48 = a3.i.f83a;
        Intrinsics.checkNotNullParameter(r44, r115);
        a3.i.a(new a3.a(r44, 1));
    L103:
        String r49 = "[AIBridge] call method:" + r11.e() + " error with msg:" + r47.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r49, r114);
        a1.a.f43a.e("ai_bridge", r49, null);
        r112.accept(new AIBridgeMethod$Error(r47.getMessage(), 0));
        return;
    L94:
        r45.invoke();     // Catch: Throwable -> L92
    L92:
        th = th;
    L97:
        Result.Companion r50 = Result.Companion;
        r46 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L85:
        th = th;
        r44 = r40;
        r114 = "msg";
        r115 = "traceId";
        goto L97
    L141:
        return;
    L106:
        if (td.d.f22127b == null) goto L108;
        Intrinsics.checkNotNullParameter(r12, "traceId");
        a3.i.a(new a3.b(r12, System.currentTimeMillis(), 2));
    L108:
        ArrayList r51 = q1.c.f21464a;
        com.bytedance.ai.bridge.method.sqlite.b r52 = new com.bytedance.ai.bridge.method.sqlite.b(this, 3, r38, r37);
        Intrinsics.checkNotNullParameter(r16, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "protocolMessage");
        Intrinsics.checkNotNullParameter(r52, "resultCallback");
        Iterator r53 = q1.c.f21464a.iterator();
    L110:
        if (r53.hasNext() == false) goto L116;
        Object r54 = r53.next();
        q1.g r55 = (q1.g) r54;
        if (r55 == null) goto L110;
        if (r55.b(r11) != true) goto L110;
        Object r116 = r54;
    L117:
        q1.g r117 = (q1.g) r116;
        if (r117 == null) goto L143;
        r117.a(r16, r11, r52);
        return;
    L143:
        return;
    L116:
        r116 = null;
        goto L117
    L9:
        r15 = e.f19964a[r14.ordinal()];
        goto L10
    }
}
