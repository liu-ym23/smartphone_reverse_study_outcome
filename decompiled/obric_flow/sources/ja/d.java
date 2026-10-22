package ja;

import android.content.Context;
import android.os.FileObserver;
import android.view.View;
import android.widget.PopupWindow;
import cj.j;
import com.bumptech.glide.load.engine.d0;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.x;
import com.bumptech.glide.load.engine.y;
import com.bytedance.android.monitorV2.k;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements j {
    public static d e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f18301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f18303c;
    public Object d;

    public /* synthetic */ d(Object r5, Object r10, Object r11, Object r12) {
        this.f18301a = r5;
        this.f18302b = r10;
        this.f18303c = r11;
        this.d = r12;
    }

    public static final void e(d r5, boolean r10) {
        jp.b r11 = (jp.b) r5.f18302b;
        WeakReference r12 = r11.d;
        if (r12 == null) goto L5;
        View r13 = (View) r12.get();
    L6:
        Iterator r14 = r11.f18406c.iterator();
    L8:
        if (r14.hasNext() == false) goto L17;
        fp.a r15 = (fp.a) r14.next();
        if (r13 == null) goto L16;
        String r16 = r15.e;
        if (r10 == false) goto L14;
        Float r17 = r15.g;
    L15:
        a.a.D(r17, r16, r13);
        goto L16
    L14:
        r17 = r15.f;
    L16:
        r15.b(true, r10, true);
        goto L8
    L17:
        r11.e = 0;
        r11.f18407h = 0;
        r11.f = -1;
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // cj.j
    public void a(HashMap r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Object r5 = r10.get("code");
        String r11 = null;
        if ((r5 instanceof Integer) == false) goto L5;
        Integer r12 = (Integer) r5;
    L6:
        boolean r13 = true;
        if (r12 == null) goto L9;
        int r14 = r12.intValue();
    L10:
        bj.a r15 = (bj.a) this.f18301a;
        r15.f938k = r14;
        Object r16 = r10.get("msg");
        if ((r16 instanceof String) == false) goto L13;
        String r17 = (String) r16;
    L14:
        if (r17 != null) goto L21;
        Object r18 = r10.get("message");
        if ((r18 instanceof String) == false) goto L18;
        r11 = (String) r18;
    L18:
        if (r11 != null) goto L20;
        r17 = "unknown error 1";
        goto L21
    L20:
        r17 = r11;
    L21:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r15.f939l = r17;
        if (r14 == 1) goto L25;
        r13 = false;
    L25:
        r15.f940m = r13;
        ((com.bytedance.sdk.xbridge.cn.protocol.e) this.f18302b).c(((com.bytedance.sdk.xbridge.cn.protocol.d) this.f18303c).a().a(r10, ((IDLXBridgeMethod) this.d).getClass(), r15));
        return;
    L13:
        r17 = null;
        goto L14
    L9:
        r14 = 1;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public void b() {
        if (((AtomicBoolean) this.f18303c).get() == false) goto L5;
        return;
    L5:
        int r5 = ((i4.a) this.f18301a).a();
        lh.c r10 = (lh.c) this.f18302b;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (r5 >= ((i4.a) this.f18301a).a()) goto L13;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L13:
        int r11 = ((lh.c) this.f18302b).available();     // Catch: Throwable -> L11
        if (r11 >= 2) goto L16;
        r11 = 1024;
    L16:
        int r12 = Math.min(r11, 1024);     // Catch: Throwable -> L11
        byte[] r13 = new byte[r12];     // Catch: Throwable -> L11
    L17:
        int r14 = ((lh.c) this.f18302b).read(r13);     // Catch: Throwable -> L11
        if (r14 == (-1)) goto L19;
        i4.a r15 = (i4.a) this.f18301a;     // Catch: Throwable -> L11
        r15.getClass();     // Catch: Throwable -> L11
        if (r14 < 0) goto L36;
        if (r14 > r12) goto L36;
        if (r12 == 0) goto L32;
        if (r14 == 0) goto L32;
        ReentrantReadWriteLock.WriteLock r16 = (ReentrantReadWriteLock.WriteLock) r15.f17502b;     // Catch: Throwable -> L11
        r16.lock();     // Catch: Throwable -> L11
        ((com.airbnb.lottie.parser.moshi.c) r15.d).b(r13, r14);     // Catch: Throwable -> L29
        r16.unlock();     // Catch: Throwable -> L11
        goto L32
    L29:
        th = move-exception;
        r16.unlock();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L32:
        if (r14 == 0) goto L17;
    L33:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L36:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L19:
        ((AtomicBoolean) this.f18303c).set(true);     // Catch: Throwable -> L11
        goto L33
    }

    public void c(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        String r10 = r5.f5939l;
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        if (r10.length() != 0) goto L8;
        return;
    L8:
        ((ConcurrentHashMap) this.f18301a).remove(r10);
        k r11 = (k) this.f18303c;
        if (r11 == null) goto L11;
        byte[] r12 = (byte[]) r11.remove(r10);
    L11:
        k r13 = (k) this.f18302b;
        if (r13 == null) goto L14;
        byte[] r14 = (byte[]) r13.remove(r10);
    L14:
        ((ConcurrentHashMap) this.d).remove(r10);
    }

    public void d(String r5, a0 r10) {
        Intrinsics.checkNotNullParameter(r5, "cacheKey");
        Intrinsics.checkNotNullParameter(r10, "resInfo");
        if (r5.length() == 0) goto L24;
        String r11 = r10.f5933b;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.length() == 0) goto L25;
        ec.b r12 = new ec.b(this, r10, r10.f5933b);     // Catch: Throwable -> L15
        ((ConcurrentHashMap) this.f18301a).put(r5, r10);     // Catch: Throwable -> L15
        ConcurrentHashMap r13 = (ConcurrentHashMap) this.d;
        FileObserver r14 = (FileObserver) r13.get(r5);     // Catch: Throwable -> L15
        if (r14 == null) goto L17;
        r14.stopWatching();     // Catch: Throwable -> L15
    L17:
        r12.startWatching();     // Catch: Throwable -> L15
        r13.put(r5, r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L25:
        return;
    }

    public synchronized void f(x r5, y r10) {
        monitor-enter(this);
        com.bumptech.glide.load.engine.b r11 = new com.bumptech.glide.load.engine.b(r5, r10, (ReferenceQueue) this.f18303c);     // Catch: Throwable -> L8
        com.bumptech.glide.load.engine.b r12 = (com.bumptech.glide.load.engine.b) ((HashMap) this.f18302b).put(r5, r11);     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        r12.f1442c = null;     // Catch: Throwable -> L8
        r12.clear();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void g(com.bumptech.glide.load.engine.b r10) {
        monitor-enter(this);
        ((HashMap) this.f18302b).remove(r10.f1440a);     // Catch: Throwable -> L11
        if (r10.f1441b == false) goto L13;
        d0 r5 = r10.f1442c;     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        y r11 = new y(r5, true, false, r10.f1440a, (s) this.d);
        ((s) this.d).e(r10.f1440a, r11);
        return;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.Lambda] */
    public boolean h(String r23, long r24, fp.a r26, long r27, boolean r29) {
        jp.b r10 = (jp.b) this.f18302b;
        long r14 = (long) (r24 * r10.g);
        r26.getClass();
        Class r5 = Float.TYPE;
        KClass r11 = Reflection.getOrCreateKotlinClass(r5);
        KClass r13 = r26.f16969j;
        boolean r12 = Intrinsics.areEqual(r13, r11);
        gp.b r16 = gp.b.f17119c;
        gp.b r17 = gp.b.f17118b;
        if (r12 == false) goto L6;
        gp.b r15 = r17;
    L8:
        Float r18 = r26.f;
        Float r19 = r26.g;
        Float r20 = r26.f16968i;
        float r110 = 0.0f;
        if (r20 == null) goto L11;
        float r111 = r20.floatValue();
    L12:
        com.obric.common.oea.foundation.animation.spec.spring.b r21 = r26.f16967h;
        Object r112 = r15.b(r14, r18, r19, r111, r21);
        WeakReference r22 = r10.d;
        if (r22 == null) goto L15;
        View r25 = (View) r22.get();
    L17:
        if (r26.f16965b != (-1)) goto L19;
        r26.f16965b = r27;
    L19:
        boolean r113 = r26.a(r14);
        String r114 = r26.e;
        if (r25 == null) goto L25;
        if (r113 == false) goto L23;
        Object r28 = r26.g;
    L24:
        a.a.D(r28, r114, r25);
        goto L25
    L23:
        r28 = r112;
    L25:
        r26.f16966c = r27;
        r26.d = !r113;
        if (Intrinsics.areEqual(r13, Reflection.getOrCreateKotlinClass(r5)) == false) goto L29;
        gp.b r30 = r17;
    L31:
        Float r115 = r26.f;
        Float r31 = r26.g;
        Float r32 = r26.f16968i;
        if (r32 == null) goto L34;
        r110 = r32.floatValue();
    L34:
        float r33 = r30.c(r14, r115, r31, r110, r21);
        r26.f16970k = r33;
        if (r113 == true) goto L37;
        ?? r34 = (Lambda) this.f18303c;
        if (r34 == 0) goto L50;
        Unit r35 = (Unit) r34.invoke(r114, r112, Float.valueOf(r33));
    L50:
        return r113;
    L37:
        if (r29 == false) goto L44;
        StringBuilder r36 = androidx.constraintlayout.motion.widget.a.y("executeAnimation, ", r23, ", return case 1, property: ", r114, ", targetValue: ");
        r36.append(r26.g);
        String r37 = r36.toString();
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter(r37, "msg");
        if (rp.b.f21793a == null) goto L41;
        rp.a.b("AnimatableRunner", r37);
    L41:
        Function2 r38 = (Function2) this.d;
        if (r38 == null) goto L50;
        Unit r39 = (Unit) r38.mo2invoke(Boolean.TRUE, null);
        goto L50
    L44:
        StringBuilder r40 = androidx.constraintlayout.motion.widget.a.y("executeAnimation, ", r23, ", return case 2, property: ", r114, ", targetValue: ");
        r40.append(r26.g);
        String r41 = r40.toString();
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter(r41, "msg");
        if (rp.b.f21793a == null) goto L50;
        rp.a.b("AnimatableRunner", r41);
        goto L50
    L29:
        if (Intrinsics.areEqual(r13, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L52;
        r30 = r16;
        goto L31
    L52:
        throw new IllegalArgumentException("Unsupported type " + r13);
    L15:
        r25 = null;
        goto L17
    L11:
        r111 = 0.0f;
        goto L12
    L6:
        if (Intrinsics.areEqual(r13, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L54;
        r15 = r16;
        goto L8
    L54:
        throw new IllegalArgumentException("Unsupported type " + r13);
    }

    public void i() {
        PopupWindow r5 = (PopupWindow) this.f18301a;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isShowing() != true) goto L11;
        if (r5 == null) goto L13;
        r5.dismiss();
        return;
    L13:
        return;
    }

    public boolean j() {
        PopupWindow r5 = (PopupWindow) this.f18301a;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isShowing() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public void k(String r5) {
        String r10 = "releaseCallbacks, scene: ".concat(r5);
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (rp.b.f21793a == null) goto L5;
        androidx.constraintlayout.motion.widget.a.B(androidx.constraintlayout.motion.widget.a.D("AnimatableRunner", "tag", r10, "msg", "AnimatableRunner->"), r10, "OEA_SDK");
    L5:
        this.f18303c = null;
        this.d = null;
    }

    public d(int r5) {
        switch(r5) {
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        ExecutorService r10 = Executors.newSingleThreadExecutor(new com.bumptech.glide.load.engine.a(0));
        this.f18302b = new HashMap();
        this.f18303c = new ReferenceQueue();
        this.f18301a = r10;
        r10.execute(new a6.a(this, 5));
        return;
    L5:
        this.f18301a = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public d(Context r5) {
        AtomicBoolean r10 = new AtomicBoolean(false);
        this.f18303c = r10;
        LinkedList r11 = new LinkedList();
        this.d = r11;
        Context r12 = r5.getApplicationContext();
        this.f18301a = new ConcurrentHashMap();
        f r13 = new f(r12, this, r11, r10);
        this.f18302b = r13;
        r13.start();
    }
}
