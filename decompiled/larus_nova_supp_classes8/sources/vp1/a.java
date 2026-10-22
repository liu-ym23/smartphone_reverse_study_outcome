package vp1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends g {
    public final CompositeDisposable o;

    /* JADX INFO: renamed from: vp1.a$a, reason: collision with other inner class name */
    public static final class C0423a<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ Runnable b;

        public C0423a(a r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            this.a.g(this.b);
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public b(a r1, boolean r2, boolean r3, boolean r4, IMultiCameraView.Source r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L4
            a.l(r0, this.b, this.c, this.d, r0.m.d());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public c(a r1, boolean r2, boolean r3, boolean r4, IMultiCameraView.Source r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L4
            a.l(r0, this.b, this.c, this.d, r0.m.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public d(a r1, boolean r2, boolean r3, boolean r4, IMultiCameraView.Source r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L4
            a.l(r0, this.b, this.c, this.d, r0.m.b());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public e(a r1, boolean r2, boolean r3, boolean r4, IMultiCameraView.Source r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L4
            a.l(r0, this.b, this.c, this.d, r0.m.c());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // vp1.g
    public final void a(boolean r1, boolean r2, boolean r3, IMultiCameraView.Source r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    @Override // vp1.g
    public final void c(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
    }

    @Override // vp1.g
    public final void onDestroy() {
        d();
        this.o.clear();
    }

    public final void m(z3.a r2, Runnable r3) {
        if (r2.a == true) goto L6;
        return;
    L6:
        if (((Boolean) r2.b.a).booleanValue() == false) goto L8;
        g(r3);
        return;
    L8:
        Disposable r4 = r2.b.subscribe(new C0423a(this, r3));
        this.o.add(r4);
    }

    public final boolean n(TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r2, j70.f r3) {
        if (o(r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (p(r2, r3) == true) goto L8;
        return false;
    }

    public final boolean o(TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r7, j70.f r8) {
        if (this.k != null) goto L5;
        return false;
    L5:
        Iterator<T> r9 = r7.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L26;
        LayerDescriptorList r0 = ((com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a) ((Map.Entry) r9.next()).getValue()).a;
        Object r2 = null;
        if (r0 == null) goto L23;
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L22;
        Object r3 = r1.next();
        j70.d r4 = (j70.h) r3;
        if ((r4 instanceof j70.h) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        j70.f r5 = r4.C(this.k);
    L20:
        if (Intrinsics.areEqual(r5, r8) == false) goto L12;
        r2 = r3;
        goto L22
    L18:
        r5 = null;
    L22:
        r2 = (j70.h) r2;
    L23:
        if (r2 == null) goto L7;
        return true;
    L26:
        return false;
    }

    public final boolean p(TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r7, j70.f r8) {
        if (this.k != null) goto L5;
        return false;
    L5:
        Iterator<T> r9 = r7.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L26;
        LayerDescriptorList r0 = ((com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a) ((Map.Entry) r9.next()).getValue()).b;
        Object r2 = null;
        if (r0 == null) goto L23;
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L22;
        Object r3 = r1.next();
        j70.d r4 = (j70.h) r3;
        if ((r4 instanceof j70.h) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        j70.f r5 = r4.C(this.k);
    L20:
        if (Intrinsics.areEqual(r5, r8) == false) goto L12;
        r2 = r3;
        goto L22
    L18:
        r5 = null;
    L22:
        r2 = (j70.h) r2;
    L23:
        if (r2 == null) goto L7;
        return true;
    L26:
        return false;
    }

    public final void q(boolean r5, TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r6) {
        j70.f r0 = null;
        u r1 = r.u(null, null, 3);
        if (r1 == null) goto L37;
        m<Boolean> r2 = r1.o0();
        if (r2 == null) goto L37;
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L37;
        if (this.a == null) goto L12;
        j70.f r3 = d90.d.a.V0;
    L13:
        boolean r4 = p(r6, r3);
        if (this.a == null) goto L16;
        j70.f r7 = d90.d.a.m;
    L17:
        boolean r8 = o(r6, r7);
        if (this.a == null) goto L20;
        r0 = d90.d.a.j0;
    L20:
        boolean r9 = o(r6, r0);
        if (r5 == true) goto L23;
        if (r4 == false) goto L32;
        this.l.d(mg2.e.e, this.b.g());
    L32:
        if (r8 == false) goto L34;
        this.l.d(mg2.e.c, this.b.a());
    L34:
        if (r9 == false) goto L42;
        this.l.d(mg2.e.c, this.b.k());
        return;
    L42:
        return;
    L23:
        if (this.a == null) goto L39;
        if (r4 == false) goto L26;
        this.l.a(mg2.e.e, d90.d.a.V0);
    L26:
        if (r8 == false) goto L28;
        this.l.a(mg2.e.c, d90.d.a.m);
    L28:
        if (r9 == false) goto L40;
        this.l.a(mg2.e.c, d90.d.a.j0);
        return;
    L40:
        return;
    L39:
        return;
    L16:
        r7 = null;
        goto L17
    L12:
        r3 = null;
    L37:
        ALogger.i("VSMultiCameraLayerController", "Widget will not reload/unload when change camera among groups for cameraMessageShared is not false.");
    }

    public a(d90.d r2, mg2.d r3, jm1.a.a r4) {
        Intrinsics.checkNotNullParameter(r3, "mComponentManager");
        super(r2, r3, r4);
        this.o = new CompositeDisposable();
    }

    public static final void l(a r9, boolean r10, boolean r11, boolean r12, TreeMap r13) {
        r9.getClass();
        DataCenter r1 = null;
        if (r11 == true) goto L5;
        if (r12 == true) goto L74;
        if (r10 == true) goto L48;
    L73:
        r9.q(true, r13);
        goto L74
    L48:
        if (r9.n(r13, lu2.e.b) == false) goto L56;
        r9.i(true);
        s.i().a();
        MultiTabManagerImpl r2 = MultiTabManagerImpl.e;
        d90.d r3 = r9.k;
        if (r3 == null) goto L52;
        DataCenter r4 = r3.h;
    L53:
        ou2.b r5 = r2.l(r4);
        if (r5 == null) goto L56;
        r5.sv();
        goto L56
    L52:
        r4 = null;
    L56:
        j70.f r6 = lu2.e.d;
        if (r9.p(r13, r6) == false) goto L60;
        r9.l.a(mg2.e.e, r6);
    L60:
        if (r9.a == null) goto L62;
        j70.f r7 = d90.d.a.Z;
    L64:
        if (r9.o(r13, r7) == false) goto L69;
        if (r9.a == null) goto L69;
        r9.l.a(mg2.e.c, d90.d.a.Z);
    L69:
        if (r9.o(r13, r9.b.A()) == false) goto L73;
        j70.c r8 = r9.b.A();
        if (r8 == null) goto L73;
        r9.l.a(mg2.e.c, r8);
        goto L73
    L62:
        r7 = null;
    L74:
        if (r10 == true) goto L76;
    L80:
        ALogger.i("WidgetLoadProperty", "camera hide widget done for group " + ((Double) CollectionsKt.firstOrNull(r13.keySet())));
        if (r11 == false) goto L110;
        LayerDescriptorList r14 = new LayerDescriptorList();
        LayerDescriptorList r15 = new LayerDescriptorList();
        Iterator r16 = r13.entrySet().iterator();
    L84:
        if (r16.hasNext() == false) goto L158;
        Map.Entry r0 = (Map.Entry) r16.next();
        List<j70.f> r17 = r9.j;
        ArrayList r18 = ((com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a) r0.getValue()).a;
        if ((r18 instanceof ArrayList) == true) goto L88;
        r18 = null;
    L88:
        if (r18 == null) goto L97;
        Iterator r19 = r18.iterator();
    L91:
        if (r19.hasNext() == false) goto L97;
        j70.h r20 = (j70.h) r19.next();
        d90.d r21 = r9.k;
        if (r21 == null) goto L91;
        if (r17.contains(r20.C(r21)) == true) goto L91;
        r14.add(r20);
    L97:
        ArrayList r22 = ((com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a) r0.getValue()).b;
        if ((r22 instanceof ArrayList) == true) goto L100;
        r22 = null;
    L100:
        if (r22 == null) goto L109;
        Iterator r23 = r22.iterator();
    L103:
        if (r23.hasNext() == false) goto L109;
        j70.h r24 = (j70.h) r23.next();
        d90.d r25 = r9.k;
        if (r25 == null) goto L103;
        if (r17.contains(r24.C(r25)) == true) goto L103;
        r15.add(r24);
    L109:
        r9.l.c(mg2.e.c, r14, false);
        r9.l.c(mg2.e.e, r15, false);
    L158:
        r9.i(false);
        ALogger.i("WidgetLoadProperty", "camera reload widget done for group " + ((Double) CollectionsKt.firstOrNull(r13.keySet())));
        return;
    L110:
        if (r12 == true) goto L144;
        if (r10 == false) goto L143;
        d90.d r110 = r9.k;
        if (r110 != null) goto L115;
    L123:
        d90.d r111 = r9.k;
        if (r111 == null) goto L133;
        if (jr1.a.b(r111) == true) goto L133;
        if (r9.o(r13, r9.b.A()) == false) goto L133;
        com.bytedance.android.livesdk.widgetdescriptor.template.container.d r112 = r9.b.f();
        if (r112 == null) goto L143;
        r9.l.d(mg2.e.c, r112);
    L133:
        if (r9.n(r13, lu2.e.b) == false) goto L141;
        s.i().a();
        MultiTabManagerImpl r113 = MultiTabManagerImpl.e;
        d90.d r114 = r9.k;
        if (r114 == null) goto L137;
        r1 = r114.h;
    L137:
        ou2.b r115 = r113.l(r1);
        if (r115 == null) goto L141;
        r115.pY();
    L141:
        if (r9.p(r13, lu2.e.d) == false) goto L143;
        mg2.d r116 = r9.l;
        f70.b r117 = mg2.e.e;
        s.i().c().getClass();
        r116.d(r117, new com.bytedance.android.livesdk.vscore_impl.component.tabs.d());
        goto L143
    L115:
        if (jr1.a.b(r110) == true) goto L123;
        if (r9.a == null) goto L119;
        j70.f r118 = d90.d.a.Z;
    L121:
        if (r9.o(r13, r118) == false) goto L123;
        r9.l.d(mg2.e.c, r9.b.j());
        goto L143
    L119:
        r118 = null;
    L143:
        r9.q(false, r13);
    L144:
        d90.d r119 = r9.k;
        if (r119 == null) goto L158;
        if (jr1.a.b(r119) == true) goto L158;
        if (r10 == false) goto L158;
        if (r9.p(r13, r9.e()) == false) goto L158;
        mg2.d r120 = r9.l;
        f70.b r121 = mg2.e.e;
        d90.d r122 = r9.k;
        if (r122 != null) goto L154;
    L156:
        pw2.c r123 = r9.b.c();
    L157:
        r120.d(r121, r123);
        goto L158
    L154:
        if (jr1.b.b(r122) != true) goto L156;
        r123 = r9.b.o();
        goto L157
    L76:
        if (r9.p(r13, r9.e()) == false) goto L80;
        r9.i(true);
        j70.f r26 = r9.e();
        if (r26 == null) goto L80;
        r9.l.a(mg2.e.e, r26);
        goto L80
    L5:
        if (r9.n(r13, lu2.e.b) == false) goto L13;
        r9.i(true);
        s.i().a();
        MultiTabManagerImpl r27 = MultiTabManagerImpl.e;
        d90.d r28 = r9.k;
        if (r28 == null) goto L9;
        DataCenter r29 = r28.h;
    L10:
        ou2.b r30 = r27.l(r29);
        if (r30 == null) goto L13;
        r30.sv();
        goto L13
    L9:
        r29 = null;
    L13:
        j70.f r31 = r9.e();
        if (r31 != null) goto L16;
    L18:
        Iterator r32 = r13.entrySet().iterator();
    L20:
        if (r32.hasNext() == false) goto L80;
        Map.Entry r33 = (Map.Entry) r32.next();
        List<j70.f> r34 = r9.j;
        ArrayList r35 = ((com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a) r33.getValue()).a;
        if ((r35 instanceof ArrayList) == true) goto L24;
        r35 = null;
    L24:
        if (r35 == null) goto L33;
        Iterator r36 = r35.iterator();
    L27:
        if (r36.hasNext() == false) goto L33;
        j70.h r37 = (j70.h) r36.next();
        d90.d r38 = r9.k;
        if (r38 == null) goto L27;
        j70.f r39 = r37.C(r38);
        if (r34.contains(r39) == true) goto L27;
        r9.l.a(mg2.e.c, r39);
    L33:
        ArrayList r40 = ((com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a) r33.getValue()).b;
        if ((r40 instanceof ArrayList) == true) goto L36;
        r40 = null;
    L36:
        if (r40 == null) goto L20;
        Iterator r41 = r40.iterator();
    L39:
        if (r41.hasNext() == false) goto L20;
        j70.h r42 = (j70.h) r41.next();
        d90.d r43 = r9.k;
        if (r43 == null) goto L39;
        j70.f r44 = r42.C(r43);
        if (r34.contains(r44) == true) goto L39;
        r9.l.a(mg2.e.e, r44);
        goto L39
    L16:
        if (r9.n(r13, r31) == false) goto L18;
        r9.i(true);
        goto L18
    }

    @Override // vp1.g
    public final void b(boolean r9, boolean r10, boolean r11, IMultiCameraView.Source r12, mg2.d r13) {
        Intrinsics.checkNotNullParameter(r12, "source");
        d();
        if (r13 == null) goto L52;
        j70.f r0 = null;
        if (r10 == false) goto L14;
        i(true);
        s.i().a();
        MultiTabManagerImpl r14 = MultiTabManagerImpl.e;
        d90.d r15 = this.k;
        if (r15 == null) goto L9;
        DataCenter r16 = r15.h;
    L10:
        ou2.b r17 = r14.l(r16);
        if (r17 == null) goto L13;
        r17.sv();
    L13:
        r13.q6(this.j, null);
        return;
    L9:
        r16 = null;
        goto L10
    L14:
        if (r9 == false) goto L23;
        if (r11 == true) goto L23;
        i(true);
        s.i().a();
        MultiTabManagerImpl r18 = MultiTabManagerImpl.e;
        d90.d r1 = this.k;
        if (r1 == null) goto L19;
        DataCenter r2 = r1.h;
    L20:
        ou2.b r19 = r18.l(r2);
        if (r19 == null) goto L23;
        r19.sv();
        goto L23
    L19:
        r2 = null;
    L23:
        List<j70.f> r110 = this.j;
        LinkedHashMap r3 = new LinkedHashMap();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        if (r10 == false) goto L50;
        if (r9 == false) goto L37;
        r4.add(e());
        if (r11 == true) goto L37;
        r4.add(lu2.e.d);
        if (this.a == null) goto L31;
        j70.f r20 = d90.d.a.Z;
    L32:
        r5.add(r20);
        vr1.k r21 = this.b;
        if (r21 == null) goto L35;
        j70.c r22 = r21.A();
    L36:
        r5.add(r22);
        goto L37
    L35:
        r22 = null;
        goto L36
    L31:
        r20 = null;
    L37:
        if (r11 == true) goto L50;
        if (this.a == null) goto L41;
        j70.f r23 = d90.d.a.V0;
    L42:
        r4.add(r23);
        if (this.a == null) goto L45;
        j70.f r24 = d90.d.a.m;
    L46:
        r5.add(r24);
        if (this.a == null) goto L49;
        r0 = d90.d.a.j0;
    L49:
        r5.add(r0);
        goto L50
    L45:
        r24 = null;
        goto L46
    L41:
        r23 = null;
    L50:
        r3.put(mg2.e.e, r4);
        r3.put(mg2.e.c, r5);
        r13.q6(r110, r3);
        return;
    L52:
        jm1.a.a r111 = this.m;
        if (r111 != null) goto L55;
        return;
    L55:
        z3 r112 = r111.e();
        m(r112.a, new b(this, r9, r10, r11, r12));
        m(r112.b, new c(this, r9, r10, r11, r12));
        m(r112.c, new d(this, r9, r10, r11, r12));
        m(r112.d, new e(this, r9, r10, r11, r12));
    }
}
