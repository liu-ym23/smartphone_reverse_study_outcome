package vp1;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.utils.w1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
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
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class g implements jm1.a {
    public static final /* synthetic */ int n = 0;
    public final d90.d.a a;
    public final vr1.k b;
    public final LayerDescriptorList c;
    public final LayerDescriptorList d;
    public final Boolean e;
    public final Boolean f;
    public final CompositeDisposable g;
    public vp1.a h;
    public final List<Runnable> i;
    public final List<j70.f> j;
    public final d90.d k;
    public final mg2.d l;
    public final jm1.a.a m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public b(g r1, boolean r2, boolean r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            this.a.g(new h(this));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ Runnable b;

        public c(g r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            this.a.g(new i(this));
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ Runnable b;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (this.a.a.l.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L9;
                this.a.b.run();     // Catch: Throwable -> L6
                return;
            }
        }

        public d(g r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.a.l.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L13;
            d90.d r0 = this.a.k;     // Catch: Throwable -> L10
            if (r0 == null) goto L7;
            DataCenter r1 = r0.h;     // Catch: Throwable -> L10
        L8:
            String r2 = c50.b.b(r1);     // Catch: Throwable -> L10
            g r3 = this.a;     // Catch: Throwable -> L10
            a r4 = new a(this);     // Catch: Throwable -> L10
            r3.getClass();     // Catch: Throwable -> L10
            Intrinsics.checkNotNullParameter(r4, "$this$bind");     // Catch: Throwable -> L10
            ((ArrayList) r3.i).add(r4);     // Catch: Throwable -> L10
            i0.e(r2, r4);     // Catch: Throwable -> L10
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public e(g r1, boolean r2, IMultiCameraView.Source r3, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            this.a.g(new j(this));
        }
    }

    static {
    }

    public final void d() {
        Iterator<T> r0 = this.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Runnable r1 = (Runnable) r0.next();
        d90.d r2 = this.k;
        if (r2 == null) goto L8;
        DataCenter r3 = r2.h;
    L9:
        i0.k(c50.b.b(r3), r1);
        goto L4
    L8:
        r3 = null;
        goto L9
    L10:
        ((ArrayList) this.i).clear();
    }

    public final j70.f e() {
        d90.d r0 = this.k;
        if (r0 == null) goto L10;
        if (jr1.b.b(r0) != true) goto L10;
        if (this.a != null) goto L14;
        return null;
    L14:
        return d90.d.a.B;
    L10:
        if (this.a != null) goto L12;
        return null;
    L12:
        return d90.d.a.z;
    }

    public void onDestroy() {
        d();
        this.g.clear();
        vp1.a r0 = this.h;
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    public void c(Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "runnable");
        jm1.a.a r0 = this.m;
        if (r0 == null) goto L13;
        z3 r1 = r0.e();
        if (r1 == null) goto L13;
        z3.a r2 = r1.d;
        if (r2 == null) goto L13;
        PropertyOwner r4 = r2.b;
        if (r4 == null) goto L13;
        if (((Boolean) r4.a).booleanValue() != true) goto L13;
        r3.run();
        return;
    L13:
        jm1.a.a r5 = this.m;
        if (r5 == null) goto L26;
        z3 r6 = r5.e();
        if (r6 == null) goto L27;
        z3.a r7 = r6.d;
        if (r7 == null) goto L28;
        PropertyOwner r8 = r7.b;
        if (r8 == null) goto L29;
        Disposable r9 = r8.subscribe(new c(this, r3));
        if (r9 == null) goto L30;
        RxUtilKt.c(r9, this.g);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void g(Runnable r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.e.booleanValue() == false) goto L11;
        d90.d r0 = this.k;
        if (r0 == null) goto L9;
        DataCenter r1 = r0.h;
    L10:
        String r2 = c50.b.b(r1);
        d r4 = new d(this, r3);
        Intrinsics.checkNotNullParameter(r4, "$this$bind");
        ((ArrayList) this.i).add(r4);
        i0.e(r2, r4);
        return;
    L9:
        r1 = null;
        goto L10
    L11:
        r3.run();
    }

    public final void i(boolean r3) {
        if (this.f.booleanValue() == false) goto L10;
        d90.d r0 = this.k;
        if (r0 == null) goto L11;
        DataCenter r1 = r0.h;
        if (r1 == null) goto L12;
        r1.put("cmd_toolbar_reload", Boolean.valueOf(r3));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(boolean r4) {
        d90.d r0 = this.k;
        if (r0 == null) goto L5;
        DataCenter r1 = r0.h;
    L6:
        u r2 = r.u(r1, null, 2);
        if (r2 == null) goto L19;
        m<Boolean> r3 = r2.o0();
        if (r3 == null) goto L19;
        if (((Boolean) r3.getValue()).booleanValue() == true) goto L19;
        if (r4 == true) goto L15;
        this.l.d(mg2.e.e, this.b.g());
        mg2.d r5 = this.l;
        f70.b r6 = mg2.e.c;
        r5.d(r6, this.b.a());
        this.l.d(r6, this.b.k());
        return;
    L15:
        if (this.a == null) goto L21;
        this.l.a(mg2.e.e, d90.d.a.V0);
        mg2.d r7 = this.l;
        f70.b r8 = mg2.e.c;
        r7.a(r8, d90.d.a.m);
        this.l.a(r8, d90.d.a.j0);
        return;
    L21:
        return;
    L19:
        ALogger.i("VSMultiCameraLayerController", "Widget will not reload/unload when change camera among groups for cameraMessageShared is not false.");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean k(boolean r2, IMultiCameraView.Source r3) {
        if (((Boolean) VSSettingKeys.LIVE_VS_USE_COMPONENT_STRATEGY_IN_PORTRAIT.getValue()).booleanValue() == false) goto L12;
        if (r2 == false) goto L12;
        d90.d r4 = this.k;
        if (r4 == null) goto L12;
        if (w1.d(r4) != true) goto L12;
        if (r3 != IMultiCameraView.Source.CameraChange) goto L12;
        return true;
    L12:
        return false;
    }

    public g(d90.d r5, mg2.d r6, jm1.a.a r7) {
        Intrinsics.checkNotNullParameter(r6, "mComponentManager");
        this.k = r5;
        this.l = r6;
        this.m = r7;
        DataCenter r8 = null;
        if (r5 == null) goto L5;
        d90.d.a r9 = r5.f;
    L6:
        this.a = r9;
        Object r0 = pm1.h.d.c(vr1.k.class);
        Intrinsics.checkNotNull(r0);
        vr1.k r1 = (vr1.k) r0;
        this.b = r1;
        if (r5 == null) goto L9;
        DataCenter r2 = r5.h;
    L10:
        LayerDescriptorList r3 = r1.y(r2);
        if (r3 == null) goto L38;
        if (r5 == null) goto L14;
        DataCenter r4 = r5.h;
    L15:
        List r10 = r1.d(r4);
        if (r10 != null) goto L19;
        r10 = CollectionsKt.emptyList();
    L19:
        r3.addAll(r10);
        if (r5 == null) goto L22;
        DataCenter r11 = r5.h;
    L23:
        List r12 = r1.n(r11);
        if (r12 != null) goto L27;
        r12 = CollectionsKt.emptyList();
    L27:
        r3.addAll(r12);
        if (r5 == null) goto L30;
        DataCenter r13 = r5.h;
    L31:
        List r14 = r1.w(r13);
        if (r14 != null) goto L35;
        r14 = CollectionsKt.emptyList();
    L35:
        r3.addAll(r14);
        LayerDescriptorList r15 = r1.s();
        if (r15 == null) goto L39;
        r3.addAll(r15);
    L39:
        this.c = r3;
        if (r5 == null) goto L42;
        DataCenter r16 = r5.h;
    L43:
        DataCenter r17 = r1.h(r16);
        if (r17 == null) goto L60;
        if (r5 == null) goto L47;
        DataCenter r18 = r5.h;
    L48:
        List r19 = r1.i(r18);
        if (r19 != null) goto L52;
        r19 = CollectionsKt.emptyList();
    L52:
        r17.addAll(r19);
        if (r5 == null) goto L55;
        r8 = r5.h;
    L55:
        List r20 = r1.x(r8);
        if (r20 != null) goto L59;
        r20 = CollectionsKt.emptyList();
    L59:
        r17.addAll(r20);
        r8 = r17;
        goto L60
    L47:
        r18 = null;
    L60:
        this.d = r8;
        this.e = (Boolean) VSSettingKeys.LIVE_CAMERA_LAYER_ACTION_USE_POST.getValue();
        this.f = (Boolean) VSSettingKeys.LIVE_FIX_CAMERA_TOOLBAR_RELOAD.getValue();
        this.g = new CompositeDisposable();
        this.i = new ArrayList();
        if (r9 == null) goto L63;
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        j70.f r21 = d90.d.a.h2;
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        j70.f r22 = d90.d.a.z2;
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        r9.getClass();
        List<j70.f> r23 = CollectionsKt.mutableListOf(new j70.f[]{d90.d.a.I2, d90.d.a.K1, d90.d.a.y2, d90.d.a.j2, d90.d.a.F, d90.d.a.T1, d90.d.a.V1, d90.d.a.i2, r21, d90.d.a.f1, d90.d.a.w0, d90.d.a.C1, d90.d.a.v2, d90.d.a.S, r22, d90.d.a.t0, r21, r22, d90.d.a.p0, d90.d.a.U});
        r23.addAll(r1.q());
    L64:
        this.j = r23;
        return;
    L63:
        r23 = CollectionsKt.emptyList();
        goto L64
    L42:
        r16 = null;
        goto L43
    L30:
        r13 = null;
        goto L31
    L22:
        r11 = null;
        goto L23
    L14:
        r4 = null;
        goto L15
    L38:
        r3 = null;
        goto L39
    L9:
        r2 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public final void f(boolean r4, boolean r5, boolean r6) {
        DataCenter r1 = null;
        if (r4 == false) goto L41;
        i(true);
        List<j70.f> r7 = this.j;
        s.i().a();
        MultiTabManagerImpl r8 = MultiTabManagerImpl.e;
        d90.d r9 = this.k;
        if (r9 == null) goto L7;
        DataCenter r10 = r9.h;
    L8:
        ou2.b r11 = r8.l(r10);
        if (r11 == null) goto L11;
        r11.sv();
    L11:
        ArrayList r12 = this.c;
        if ((r12 instanceof ArrayList) == true) goto L14;
        r12 = null;
    L14:
        if (r12 == null) goto L26;
        Iterator r13 = r12.iterator();
    L17:
        if (r13.hasNext() == false) goto L26;
        j70.h r14 = (j70.h) r13.next();
        d90.d r0 = this.k;
        if (r0 == null) goto L21;
        j70.f r15 = r14.C(r0);
    L23:
        if (CollectionsKt.contains(r7, r15) == true) goto L17;
        if (r15 == null) goto L17;
        this.l.a(mg2.e.c, r15);
        goto L17
    L21:
        r15 = null;
    L26:
        ArrayList r16 = this.d;
        if ((r16 instanceof ArrayList) == true) goto L29;
        r16 = null;
    L29:
        if (r16 == null) goto L62;
        Iterator r17 = r16.iterator();
    L32:
        if (r17.hasNext() == false) goto L62;
        j70.h r18 = (j70.h) r17.next();
        d90.d r2 = this.k;
        if (r2 == null) goto L36;
        j70.f r19 = r18.C(r2);
    L38:
        if (CollectionsKt.contains(r7, r19) == true) goto L32;
        if (r19 == null) goto L32;
        this.l.a(mg2.e.e, r19);
        goto L32
    L36:
        r19 = null;
    L62:
        ALogger.i("WidgetLoadProperty", "camera hide widget done");
        return;
    L7:
        r10 = null;
        goto L8
    L41:
        if (r5 == true) goto L58;
        if (r6 == false) goto L57;
        i(true);
        s.i().a();
        MultiTabManagerImpl r20 = MultiTabManagerImpl.e;
        d90.d r21 = this.k;
        if (r21 == null) goto L46;
        r1 = r21.h;
    L46:
        ou2.b r22 = r20.l(r1);
        if (r22 == null) goto L49;
        r22.sv();
    L49:
        this.l.a(mg2.e.e, lu2.e.d);
        if (this.a == null) goto L54;
        j70.f r23 = d90.d.a.Z;
        if (r23 == null) goto L54;
        this.l.a(mg2.e.c, r23);
    L54:
        j70.c r24 = this.b.A();
        if (r24 == null) goto L57;
        this.l.a(mg2.e.c, r24);
    L57:
        j(true);
    L58:
        if (r6 == false) goto L62;
        i(true);
        j70.f r25 = e();
        if (r25 == null) goto L62;
        this.l.a(mg2.e.e, r25);
        goto L62
    }

    public final void h(boolean r7, boolean r8, boolean r9) {
        DataCenter r1 = null;
        if (r7 == false) goto L34;
        List<j70.f> r10 = this.j;
        LayerDescriptorList r11 = new LayerDescriptorList();
        LayerDescriptorList r12 = new LayerDescriptorList();
        ArrayList r2 = this.c;
        if ((r2 instanceof ArrayList) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L18;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L18;
        j70.h r4 = (j70.h) r3.next();
        d90.d r5 = this.k;
        if (r5 == null) goto L14;
        j70.f r6 = r4.C(r5);
    L16:
        if (CollectionsKt.contains(r10, r6) == true) goto L10;
        r11.add(r4);
        goto L10
    L14:
        r6 = null;
    L18:
        ArrayList r13 = this.d;
        if ((r13 instanceof ArrayList) == true) goto L21;
        r13 = null;
    L21:
        if (r13 == null) goto L32;
        Iterator r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L32;
        j70.h r15 = (j70.h) r14.next();
        d90.d r16 = this.k;
        if (r16 == null) goto L28;
        j70.f r17 = r15.C(r16);
    L30:
        if (CollectionsKt.contains(r10, r17) == true) goto L24;
        r12.add(r15);
        goto L24
    L28:
        r17 = null;
    L32:
        this.l.c(mg2.e.c, r11, false);
        this.l.c(mg2.e.e, r12, false);
    L72:
        i(false);
        ALogger.i("WidgetLoadProperty", "camera reload widget done");
        return;
    L34:
        if (r8 == true) goto L59;
        if (r9 == false) goto L58;
        s.i().a();
        MultiTabManagerImpl r18 = MultiTabManagerImpl.e;
        d90.d r19 = this.k;
        if (r19 == null) goto L39;
        DataCenter r20 = r19.h;
    L41:
        if (r18.h(r20) == true) goto L51;
        mg2.d r21 = this.l;
        f70.b r22 = mg2.e.c;
        r21.d(r22, this.b.j());
        d90.d r23 = this.k;
        if (r23 == null) goto L58;
        z70.b r24 = ((h70.b) r23).a;
        if (r24 == null) goto L58;
        if (r24.k() != true) goto L58;
        com.bytedance.android.livesdk.widgetdescriptor.template.container.d r25 = this.b.f();
        if (r25 == null) goto L58;
        this.l.d(r22, r25);
        goto L58
    L51:
        s.i().c().getClass();
        this.l.d(mg2.e.e, new com.bytedance.android.livesdk.vscore_impl.component.tabs.d());
        s.i().a();
        d90.d r26 = this.k;
        if (r26 == null) goto L54;
        DataCenter r27 = r26.h;
    L55:
        ou2.b r28 = r18.l(r27);
        if (r28 == null) goto L58;
        r28.pY();
        goto L58
    L54:
        r27 = null;
        goto L55
    L39:
        r20 = null;
    L58:
        j(false);
    L59:
        s.i().a();
        MultiTabManagerImpl r29 = MultiTabManagerImpl.e;
        d90.d r30 = this.k;
        if (r30 == null) goto L63;
        r1 = r30.h;
    L63:
        if (r29.h(r1) == true) goto L72;
        if (r9 == false) goto L72;
        mg2.d r31 = this.l;
        f70.b r32 = mg2.e.e;
        d90.d r33 = this.k;
        if (r33 != null) goto L68;
    L70:
        pw2.c r34 = this.b.c();
    L71:
        r31.d(r32, r34);
        goto L72
    L68:
        if (jr1.b.b(r33) != true) goto L70;
        r34 = this.b.o();
        goto L71
    }

    public void a(boolean r9, boolean r10, boolean r11, IMultiCameraView.Source r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        jm1.a.a r1 = this.m;
        if (r1 == null) goto L18;
        z3 r2 = r1.e();
        if (r2 == null) goto L18;
        z3.a r3 = r2.d;
        if (r3 == null) goto L18;
        PropertyOwner r4 = r3.b;
        if (r4 == null) goto L18;
        if (((Boolean) r4.a).booleanValue() == true) goto L18;
        if (k(r9, r12) == false) goto L18;
        if (this.h == null) goto L33;
        Intrinsics.checkNotNullParameter(r12, "source");
        return;
    L33:
        return;
    L18:
        jm1.a.a r0 = this.m;
        if (r0 == null) goto L31;
        z3 r5 = r0.e();
        if (r5 == null) goto L31;
        z3.a r6 = r5.d;
        if (r6 == null) goto L31;
        PropertyOwner r7 = r6.b;
        if (r7 == null) goto L31;
        if (((Boolean) r7.a).booleanValue() == true) goto L31;
        Disposable r13 = this.m.e().d.b.subscribe(new e(this, r10, r12, r11, r9));
        if (r13 == null) goto L34;
        RxUtilKt.c(r13, this.g);
        return;
    L34:
        return;
    L31:
        h(r10, r11, r9);
    }

    public void b(boolean r11, boolean r12, boolean r13, IMultiCameraView.Source r14, mg2.d r15) {
        Intrinsics.checkNotNullParameter(r14, "source");
        d();
        jm1.a.a r0 = this.m;
        if (r0 == null) goto L5;
        z3 r1 = r0.e();
    L6:
        if (r1 == null) goto L22;
        z3.a r2 = r1.d;
        if (r2 == null) goto L22;
        PropertyOwner r3 = r2.b;
        if (r3 == null) goto L22;
        if (((Boolean) r3.a).booleanValue() == true) goto L22;
        if (k(r11, r14) == false) goto L22;
        if (this.h != null) goto L18;
        this.h = new vp1.a(this.k, this.l, this.m);
    L18:
        vp1.a r4 = this.h;
        if (r4 == null) goto L34;
        r4.b(r11, r12, r13, r14, r15);
        return;
    L34:
        return;
    L22:
        if (r1 == null) goto L32;
        z3.a r16 = r1.d;
        if (r16 == null) goto L32;
        PropertyOwner r17 = r16.b;
        if (r17 == null) goto L32;
        if (((Boolean) r17.a).booleanValue() == true) goto L32;
        Disposable r18 = r1.d.b.subscribe(new b(this, r12, r13, r11));
        if (r18 == null) goto L35;
        RxUtilKt.c(r18, this.g);
        return;
    L35:
        return;
    L32:
        f(r12, r13, r11);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
