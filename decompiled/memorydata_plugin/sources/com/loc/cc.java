package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.service.SystemBaseLocationImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class cc {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static boolean f5398J = true;
    private static boolean L = false;
    private static AtomicBoolean N = null;
    public static volatile boolean g = false;
    boolean A;
    a B;
    String C;
    boolean D;
    private Context E;
    private fl F;
    private ff G;
    private boolean H;
    private volatile boolean I;
    private boolean K;
    private boolean M;
    private AMapLocationClientOption O;
    private fj P;
    private ServiceConnection Q;
    private volatile boolean R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    es f5399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AMapLocationClientOption f5400b;
    public c c;
    fi d;
    ArrayList<com.amap.api.location.b> e;
    boolean f;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    fk l;
    Messenger m;
    Messenger n;
    Intent o;
    int p;
    b q;
    boolean r;
    AMapLocationClientOption.AMapLocationMode s;
    Object t;
    fb u;
    boolean v;
    cy w;
    String x;
    com.amap.api.location.c y;
    boolean z;

    /* JADX INFO: renamed from: com.loc.cc$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5403a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f5403a = r0;
            r0[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f5403a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f5403a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ cc f5404a;

        public a(cc r1, Looper r2) {
            this.f5404a = r1;
            super(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v8 */
        @Override // android.os.Handler
        public final void handleMessage(Message r10) {
            ?? r0 = 0;
            super.handleMessage(r10);     // Catch: Throwable -> L94
            if (eu.h == false) goto L7;
            Log.e("AMapLocationClient", "SERVICE_NOT_AVAILABLE");     // Catch: Throwable -> L94
            return;
        L7:
            int r1 = r10.what;     // Catch: Throwable -> L94
            if (r1 != 11) goto L11;
            Bundle r11 = r10.getData();     // Catch: Throwable -> L94
            cc.a(this.f5404a, r11);     // Catch: Throwable -> L94
            return;
        L11:
            if (r1 != 12) goto L13;
            cc.a(this.f5404a, r10);     // Catch: Throwable -> L94
            return;
        L13:
            if (r1 != 16) goto L15;
            cc.b(this.f5404a, r10);     // Catch: Throwable -> L94
            return;
        L15:
            if (r1 != 1011) goto L100;
            cc.a(this.f5404a, 14, null);     // Catch: Throwable -> L94
            this.f5404a.e();     // Catch: Throwable -> L94
            return;
        L100:
            switch(r1) {
                case 1002: goto L84;
                case 1003: goto L80;
                case 1004: goto L77;
                case 1005: goto L74;
                default: goto L19;
            };
        L74:
            cc.b(this.f5404a, (com.amap.api.location.b) ZeusTransformUtils.preCheckCast(r10.obj, com.amap.api.location.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L94
            return;
        L84:
            cc.a(this.f5404a, (com.amap.api.location.b) ZeusTransformUtils.preCheckCast(r10.obj, com.amap.api.location.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L94
            return;
        L19:
            switch(r1) {
                case 1014: goto L72;
                case 1015: goto L70;
                case 1016: goto L61;
                case 1017: goto L58;
                case 1018: goto L54;
                default: goto L21;
            };
        L54:
            cc r2 = this.f5404a;     // Catch: Throwable -> L94
            r2.f5400b = (AMapLocationClientOption) ZeusTransformUtils.preCheckCast(r10.obj, AMapLocationClientOption.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L94
            if (this.f5404a.f5400b == null) goto L103;
            cc.j(this.f5404a);     // Catch: Throwable -> L94
            return;
        L103:
            return;
        L58:
            this.f5404a.d.a();     // Catch: Throwable -> L94
            cc.a(this.f5404a, InputDeviceCompat.SOURCE_GAMEPAD);     // Catch: Throwable -> L94
            return;
        L70:
            this.f5404a.d.a(this.f5404a.f5400b);     // Catch: Throwable -> L94
            cc.a(this.f5404a, InputDeviceCompat.SOURCE_GAMEPAD, 300000);     // Catch: Throwable -> L94
            return;
        L72:
            cc.c(this.f5404a, r10);     // Catch: Throwable -> L94
            return;
        L21:
            switch(r1) {
                case 1023: goto L52;
                case 1024: goto L50;
                case 1025: goto L46;
                case 1026: goto L43;
                case 1027: goto L41;
                case 1028: goto L39;
                case 1029: goto L37;
                case 1030: goto L35;
                case 1031: goto L32;
                case 1032: goto L29;
                case 1033: goto L25;
                case 1034: goto L23;
                default: goto L104;
            };
        L23:
            Bundle r12 = r10.getData();     // Catch: Throwable -> L94
            AMapLocation r3 = (AMapLocation) ZeusTransformUtils.preCheckCast(r12.getParcelable("mapLoc"), AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L94
            em r4 = (em) ZeusTransformUtils.preCheckCast(r12.getParcelable("entity"), em.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L94
            r12.getSerializable("ex");     // Catch: Throwable -> L94
            cc.a(this.f5404a, r3, r4);     // Catch: Throwable -> L94
            return;
        L29:
            cc.b(this.f5404a).a();     // Catch: Throwable -> L94
            cc.a(this.f5404a, 1033);     // Catch: Throwable -> L94
            return;
        L35:
            Bundle r13 = new Bundle();     // Catch: Throwable -> L94
            r13.putString("objHash", Integer.toString(System.identityHashCode(this)));     // Catch: Throwable -> L94
            cc.a(this.f5404a, 17, r13);     // Catch: Throwable -> L94
            return;
        L37:
            Bundle r14 = new Bundle();     // Catch: Throwable -> L94
            r14.putString("objHash", Integer.toString(System.identityHashCode(this)));     // Catch: Throwable -> L94
            cc.a(this.f5404a, 16, r14);     // Catch: Throwable -> L94
            return;
        L39:
            cc.b(this.f5404a, (AMapLocation) ZeusTransformUtils.preCheckCast(r10.obj, AMapLocation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L94
            return;
        L41:
            cc.c(this.f5404a).a();     // Catch: Throwable -> L94
            return;
        L43:
            ex.b();     // Catch: Throwable -> L94
            cc.c(this.f5404a).a(this.f5404a.f5400b);     // Catch: Throwable -> L94
            return;
        L50:
            cc.e(this.f5404a, r10);     // Catch: Throwable -> L94
            return;
        L52:
            cc.d(this.f5404a, r10);     // Catch: Throwable -> L94
            return;
        L104:
            return;
        L25:
            if (cc.b(this.f5404a).b() == false) goto L27;
            cc.b(this.f5404a).a();     // Catch: Throwable -> L94
            cc.b(this.f5404a).a(this.f5404a.f5400b);     // Catch: Throwable -> L94
        L27:
            cc.a(this.f5404a, 1033, 300000);     // Catch: Throwable -> L94
            return;
        L32:
            if (this.f5404a.f5400b.isSysNetworkLocEnable() == false) goto L102;
            cc.b(this.f5404a).a(this.f5404a.f5400b);     // Catch: Throwable -> L94
            cc.a(this.f5404a, 1033, 300000);     // Catch: Throwable -> L94
            return;
        L102:
            return;
        L46:
            if (this.f5404a.d.f() == false) goto L48;
            this.f5404a.d.a();     // Catch: Throwable -> L94
            this.f5404a.d.a(this.f5404a.f5400b);     // Catch: Throwable -> L94
        L48:
            cc.a(this.f5404a, InputDeviceCompat.SOURCE_GAMEPAD, 300000);     // Catch: Throwable -> L94
            return;
        L61:
            if (fd.m((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(cc.d(this.f5404a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L65;
            Object[] r15 = new Object[1];     // Catch: Throwable -> L94
            ex.a();     // Catch: Throwable -> L94
            cc.h(this.f5404a);     // Catch: Throwable -> L94
            return;
        L65:
            if (this.f5404a.d.b() == false) goto L68;
            cc.a(this.f5404a, 1016, 1000);     // Catch: Throwable -> L94
            return;
        L68:
            cc.i(this.f5404a);     // Catch: Throwable -> L94
            return;
        L77:
            cc.g(this.f5404a);     // Catch: Throwable -> L82
            cc.a(this.f5404a, 14, null);     // Catch: Throwable -> L82
            return;
        L80:
            cc.f(this.f5404a);     // Catch: Throwable -> L82
            cc.a(this.f5404a, 13, null);     // Catch: Throwable -> L82
            return;
        L82:
            th = th;
            r0 = r10;
        L95:
            if (r0 != 0) goto L97;
            r0 = "handleMessage";
        L97:
            ev.a(th, "AMapLocationManage$MHandlerr", r0);
            return;
        L94:
            th = th;
            goto L95
        }
    }

    static class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        cc f5405a;

        public b(String r1, cc r2) {
            super(r1);
            this.f5405a = null;
            this.f5405a = r2;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            this.f5405a.l.a();     // Catch: Throwable -> L10
            fa.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(cc.d(this.f5405a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
            cc.e(this.f5405a);     // Catch: Throwable -> L10
            cc r1 = this.f5405a;     // Catch: Throwable -> L10
            if (r1 != null) goto L6;
        L8:
            super.onLooperPrepared();     // Catch: Throwable -> L10
            return;
        L6:
            if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(cc.d(r1), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L8;
            eu.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(cc.d(this.f5405a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
            eu.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(cc.d(this.f5405a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ cc f5406a;

        public c(cc r1) {
            this.f5406a = r1;
        }

        public c(cc r1, Looper r2) {
            this.f5406a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r6) {
            String r0 = null;
            super.handleMessage(r6);     // Catch: Throwable -> L72
            if (this.f5406a.r == false) goto L6;
            return;
        L6:
            int r1 = r6.what;     // Catch: Throwable -> L72
            if (r1 != 1) goto L10;
            Message r2 = this.f5406a.B.obtainMessage();     // Catch: Throwable -> L72
            r2.what = 11;     // Catch: Throwable -> L72
            r2.setData(r6.getData());     // Catch: Throwable -> L72
            this.f5406a.B.sendMessage(r2);     // Catch: Throwable -> L72
            return;
        L10:
            if (r1 != 2) goto L12;
        L62:
            Message r3 = Message.obtain();     // Catch: Throwable -> L72
            r3.what = 12;     // Catch: Throwable -> L72
            r3.obj = r6.obj;     // Catch: Throwable -> L72
            this.f5406a.B.sendMessage(r3);     // Catch: Throwable -> L72
            if (cc.a(this.f5406a) != null) goto L65;
            return;
        L65:
            if (cc.a(this.f5406a).getCacheCallBack() == true) goto L67;
            return;
        L67:
            if (this.f5406a.c == null) goto L87;
            this.f5406a.c.removeMessages(13);     // Catch: Throwable -> L72
            return;
        L87:
            return;
        L12:
            if (r1 != 17) goto L14;
            fb.a(null, 2131);     // Catch: Throwable -> L72
        L60:
            Message r4 = Message.obtain();     // Catch: Throwable -> L72
            r4.what = 16;     // Catch: Throwable -> L72
            r4.obj = r6.obj;     // Catch: Throwable -> L72
            this.f5406a.B.sendMessage(r4);     // Catch: Throwable -> L72
            return;
        L14:
            if (r1 != 18) goto L16;
            Bundle r7 = r6.getData();     // Catch: Throwable -> L72
            if (cc.b(this.f5406a) == null) goto L84;
            cc.b(this.f5406a).a(r7);     // Catch: Throwable -> L72
            return;
        L84:
            return;
        L16:
            switch(r1) {
                case 5: goto L53;
                case 6: goto L49;
                case 7: goto L47;
                case 8: goto L46;
                case 9: goto L45;
                case 10: goto L43;
                default: goto L17;
            };
        L17:
            switch(r1) {
                case 13: goto L38;
                case 14: goto L35;
                case 15: goto L60;
                default: goto L18;
            };
        L18:
            switch(r1) {
                case 100: goto L26;
                case 101: goto L27;
                case 102: goto L24;
                case 103: goto L20;
                default: goto L88;
            };
        L20:
            Bundle r8 = r6.getData();     // Catch: Throwable -> L72
            if (cc.c(this.f5406a) == null) goto L78;
            cc.c(this.f5406a).a(r8);     // Catch: Throwable -> L72
            return;
        L78:
            return;
        L24:
            Bundle r9 = r6.getData();     // Catch: Throwable -> L72
            r9.putBundle("optBundle", ev.a(this.f5406a.f5400b));     // Catch: Throwable -> L72
            cc.a(this.f5406a, 15, r9);     // Catch: Throwable -> L72
            return;
        L26:
            fb.a(null, 2155);     // Catch: Throwable -> L72
        L27:
            Message r5 = Message.obtain();     // Catch: Throwable -> L72
            r5.what = 1028;     // Catch: Throwable -> L72
            r5.obj = r6.obj;     // Catch: Throwable -> L72
            this.f5406a.B.sendMessage(r5);     // Catch: Throwable -> L72
            if (cc.a(this.f5406a) != null) goto L30;
            return;
        L30:
            if (cc.a(this.f5406a).getCacheCallBack() == true) goto L32;
            return;
        L32:
            if (this.f5406a.c == null) goto L81;
            this.f5406a.c.removeMessages(13);     // Catch: Throwable -> L72
            return;
        L81:
            return;
        L88:
            return;
        L35:
            Bundle r10 = r6.getData();     // Catch: Throwable -> L72
            r10.putBundle("optBundle", ev.a(this.f5406a.f5400b));     // Catch: Throwable -> L72
            cc.a(this.f5406a, 18, r10);     // Catch: Throwable -> L72
            return;
        L38:
            if (this.f5406a.f5399a == null) goto L41;
            cc r11 = this.f5406a;     // Catch: Throwable -> L72
            cc.a(r11, r11.f5399a);     // Catch: Throwable -> L72
            return;
        L41:
            AMapLocation r12 = new AMapLocation(SystemBaseLocationImpl.LBS_GEOCODE_NAME);     // Catch: Throwable -> L72
            r12.setErrorCode(33);     // Catch: Throwable -> L72
            cc.a(this.f5406a, r12);     // Catch: Throwable -> L72
            return;
        L43:
            AMapLocation r13 = (AMapLocation) ZeusTransformUtils.preCheckCast(r6.obj, AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L72
            cc.a(this.f5406a, r13);     // Catch: Throwable -> L72
            return;
        L45:
            cc.b(r6.getData().getBoolean("installMockApp"));     // Catch: Throwable -> L72
            return;
        L46:
            fb.a(null, 2141);     // Catch: Throwable -> L72
            goto L62
        L47:
            Bundle r14 = r6.getData();     // Catch: Throwable -> L72
            cc.b(this.f5406a, r14.getBoolean("ngpsAble"));     // Catch: Throwable -> L72
            return;
        L49:
            Bundle r15 = r6.getData();     // Catch: Throwable -> L72
            if (this.f5406a.d == null) goto L83;
            this.f5406a.d.a(r15);     // Catch: Throwable -> L72
            return;
        L83:
            return;
        L53:
            Bundle r16 = r6.getData();     // Catch: Throwable -> L72
            r16.putBundle("optBundle", ev.a(this.f5406a.f5400b));     // Catch: Throwable -> L72
            cc.a(this.f5406a, 10, r16);     // Catch: Throwable -> L72
            return;
        L72:
            th = move-exception;
            if (0 != 0) goto L75;
            r0 = "handleMessage";
        L75:
            ev.a(th, "AmapLocationManager$MainHandler", r0);
        }
    }

    static {
        N = new AtomicBoolean(false);
    }

    public cc(Context r5, Intent r6, Looper r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.f5400b = new AMapLocationClientOption();
        this.d = null;
        this.F = null;
        this.H = false;
        this.I = false;
        this.e = new ArrayList();
        this.f = false;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = true;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = 0;
        this.K = true;
        this.q = null;
        this.r = false;
        this.s = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        this.t = new Object();
        this.u = null;
        this.v = false;
        this.w = null;
        this.M = false;
        this.O = new AMapLocationClientOption();
        this.P = null;
        this.x = null;
        this.Q = new AnonymousClass2(this);
        this.y = null;
        this.z = false;
        this.A = false;
        this.R = false;
        this.B = null;
        this.C = null;
        this.D = false;
        this.E = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.o = r6;
        b(r7);
    }

    static /* synthetic */ AMapLocationClientOption a(cc r0) {
        return r0.O;
    }

    private a a(Looper r3) {
        Object r0 = this.t;
        monitor-enter(r0);
        a r1 = new a(this, r3);     // Catch: Throwable -> L7
        this.B = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private es a(dl r1, boolean r2) {
        if (this.f5400b.isLocationCacheEnable() == false) goto L12;
        return r1.b(r2);
    L6:
        th = move-exception;
        ev.a(th, "ALManager", "doFirstCacheLoc");
        return null;
    L12:
        return null;
    }

    private void a(int r2) {
        Object r0 = this.t;
        monitor-enter(r0);
        a r1 = this.B;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.removeMessages(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void a(int r3, Bundle r4) {
        if (r4 != null) goto L5;
        r4 = new Bundle();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, IllegalStateException.class) == true) goto L15;
    L17:
        boolean r5 = false;
    L19:
        if (ZeusTransformUtils.instanceOf(th, RemoteException.class) == true) goto L21;
        if (r5 == true) goto L21;
    L22:
        ev.a(th, "ALManager", "sendLocMessage");
        return;
    L21:
        this.m = null;
        this.H = false;
        goto L22
    L15:
        if (th.getMessage().contains("sending message to a Handler on a dead thread") == false) goto L17;
        r5 = true;
    L5:
        if (TextUtils.isEmpty(this.x) == false) goto L7;
        this.x = ev.b(this.E);     // Catch: Throwable -> L11
    L7:
        r4.putString("c", this.x);     // Catch: Throwable -> L11
        Message r0 = Message.obtain();     // Catch: Throwable -> L11
        r0.what = r3;     // Catch: Throwable -> L11
        r0.setData(r4);     // Catch: Throwable -> L11
        r0.replyTo = this.n;     // Catch: Throwable -> L11
        Messenger r6 = this.m;     // Catch: Throwable -> L11
        if (r6 == null) goto L26;
        r6.send(r0);     // Catch: Throwable -> L11
        return;
    }

    private void a(int r4, Object r5, long r6) {
        Object r0 = this.t;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.B == null) goto L11;
        Message r1 = Message.obtain();     // Catch: Throwable -> L13
        r1.what = r4;     // Catch: Throwable -> L13
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L9;
        r1.setData((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L10:
        this.B.sendMessageDelayed(r1, r6);     // Catch: Throwable -> L13
        goto L11
    L9:
        r1.obj = r5;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private static void a(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (N.compareAndSet(false, true) == false) goto L6;
        bp.a().b(new AnonymousClass1(r4));
        return;
    }

    private void a(Intent r4) {
        ZeusTransformUtils.bindService(this.E, r4, this.Q, 1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ALManager", "startServiceImpl");
    }

    private void a(Intent r7, boolean r8) {
        if (this.E != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L13;
        if (r8 == false) goto L13;
        if (r() == true) goto L17;
        Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
        return;
    L17:
        this.E.getClass().getMethod("startForegroundService", new Class[]{Intent.class}).invoke(this.E, new Object[]{r7});     // Catch: Throwable -> L16
    L14:
        this.D = true;
        return;
    L13:
        ZeusTransformUtils.startService(this.E, r7, "com.obric.memorydata.plugin");
        goto L14
    }

    private void a(Bundle r7) {
        AMapLocation r1 = null;
        if (r7 != null) goto L37;
        em r8 = null;
        AMapLocation r2 = null;
    L16:
        fi r0 = this.d;     // Catch: Throwable -> L29
        if (r0 == null) goto L20;
        r2 = r0.a(r2, this.C);     // Catch: Throwable -> L29
    L20:
        if (this.F != null) goto L22;
    L28:
        th = null;
        r1 = r2;
    L32:
        if (fd.a(r1) == false) goto L35;
        this.M = false;
        a(r1, r8);
        return;
    L35:
        this.M = true;
        Bundle r3 = new Bundle();
        r3.putParcelable("mapLoc", r1);
        r3.putParcelable("entity", r8);
        r3.putSerializable("ex", th);
        a(1034, r3, 10000);
        return;
    L22:
        if (fd.a(r2) == true) goto L24;
    L27:
        r2 = this.F.a(r2, this.C);     // Catch: Throwable -> L29
    L29:
        th = th;
    L30:
        ev.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
        goto L32
    L24:
        if (this.f5400b.isNeedAddress() == false) goto L28;
        if (TextUtils.isEmpty(r2.getAdCode()) == false) goto L28;
    L37:
        r7.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        r2 = (AMapLocation) ZeusTransformUtils.preCheckCast(r7.getParcelable("loc"), AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        new StringBuilder("Lbs     Longitude:").append(r2.getLongitude()).append(" Latitude:").append(r2.getLatitude());     // Catch: Throwable -> L13
        ex.c();     // Catch: Throwable -> L13
        r2.setProvider("lbs");     // Catch: Throwable -> L13
        this.C = r7.getString("nb");     // Catch: Throwable -> L13
        r8 = (em) ZeusTransformUtils.preCheckCast(r7.getParcelable("statics"), em.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r2 == null) goto L16;
        if (r2.getErrorCode() != 0) goto L16;
        fi r4 = this.d;     // Catch: Throwable -> L29
        if (r4 == null) goto L16;
        r4.c();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r2.getAdCode()) == true) goto L16;
        fi.y = r2;     // Catch: Throwable -> L29
        fl.y = r2;     // Catch: Throwable -> L29
    L13:
        th = th;
        r8 = null;
        goto L30
    }

    private void a(Message r4) {
        Bundle r5 = r4.getData();     // Catch: Throwable -> L6
        AMapLocation r0 = (AMapLocation) ZeusTransformUtils.preCheckCast(r5.getParcelable("loc"), AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        String r6 = r5.getString("lastLocNb");     // Catch: Throwable -> L6
        f(r0);     // Catch: Throwable -> L6
        if (this.l.a(r0, r6) == false) goto L11;
        this.l.d();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ev.a(th, "ALManager", "doSaveLastLocation");
    }

    private void a(AMapLocation r9) {
        if (r9.getErrorCode() == 0) goto L6;
        r9.setLocationType(0);     // Catch: Throwable -> L36
    L6:
        if (r9.getErrorCode() != 0) goto L21;
        double r2 = r9.getLatitude();     // Catch: Throwable -> L36
        double r4 = r9.getLongitude();     // Catch: Throwable -> L36
        if (r2 != 0.0d) goto L12;
        if (r4 != 0.0d) goto L12;
    L19:
        fb.a("errorLatLng", r9.toStr());     // Catch: Throwable -> L36
        r9.setLocationType(0);     // Catch: Throwable -> L36
        r9.setErrorCode(8);     // Catch: Throwable -> L36
        r9.setLocationDetail("LatLng is error#0802");     // Catch: Throwable -> L36
    L12:
        if (r2 < (-90.0d)) goto L19;
        if (r2 > 90.0d) goto L19;
        if (r4 < (-180.0d)) goto L19;
        if (r4 > 180.0d) goto L19;
    L21:
        if ("gps".equalsIgnoreCase(r9.getProvider()) == false) goto L23;
    L28:
        r9.setAltitude(fd.c(r9.getAltitude()));     // Catch: Throwable -> L36
        r9.setBearing(fd.a(r9.getBearing()));     // Catch: Throwable -> L36
        r9.setSpeed(fd.a(r9.getSpeed()));     // Catch: Throwable -> L36
        c(r9);     // Catch: Throwable -> L36
        b(r9);     // Catch: Throwable -> L36
        new StringBuilder("callBackToListener getProvider:").append(r9.getProvider()).append(" Longitude:").append(r9.getLongitude()).append(" Latitude:").append(r9.getLatitude());     // Catch: Throwable -> L36
        ex.c();     // Catch: Throwable -> L36
        Iterator<com.amap.api.location.b> r8 = this.e.iterator();     // Catch: Throwable -> L36
    L29:
        if (r8.hasNext() == false) goto L45;
        ((com.amap.api.location.b) ZeusTransformUtils.preCheckCast(r8.next(), com.amap.api.location.b.class, "com.obric.memorydata.plugin")).onLocationChanged(r9);     // Catch: Throwable -> L35
        goto L29
    L45:
        return;
    L23:
        if (this.d.b() == false) goto L28;
        if ("network".equalsIgnoreCase(r9.getProvider()) == true) goto L28;
        if (this.F.c() == false) goto L28;
        return;
    }

    private synchronized void a(AMapLocation r4, em r5) {
        monitor-enter(this);
        ex.c();     // Catch: Throwable -> L38
        if (r4 != null) goto L7;
        r4 = new AMapLocation("");     // Catch: Throwable -> L38
        r4.setErrorCode(8);     // Catch: Throwable -> L38
        r4.setLocationDetail("amapLocation is null#0801");     // Catch: Throwable -> L38
    L7:
        if (this.y != null) goto L9;
        this.y = new com.amap.api.location.c();     // Catch: Throwable -> L38
    L9:
        this.y.a(this.f5400b.getLocationMode());     // Catch: Throwable -> L38
        fi r0 = this.d;     // Catch: Throwable -> L38
        if (r0 == null) goto L12;
        this.y.b(r0.e());     // Catch: Throwable -> L38
        this.y.a(this.d.d());     // Catch: Throwable -> L38
    L12:
        boolean r1 = fd.g(this.E);     // Catch: Throwable -> L38
        this.y.a(r1);     // Catch: Throwable -> L38
        this.y.a(fd.h(this.E));     // Catch: Throwable -> L38
        if (r4.getLocationType() != 1) goto L15;
    L16:
        this.y.a(0);     // Catch: Throwable -> L38
    L17:
        if (r5 == null) goto L19;
        this.y.a(r5.a());     // Catch: Throwable -> L38
    L19:
        this.y.b(L);     // Catch: Throwable -> L38
        r4.setLocationQualityReport(this.y);     // Catch: Throwable -> L38
    L27:
        th = move-exception;
        ev.a(th, "ALManager", "handlerLocation part2");     // Catch: Throwable -> L38
    L30:
        if (this.r == false) goto L34;
        monitor-exit(this);
        return;
    L34:
        if (this.f5400b.isOnceLocation() == false) goto L36;
        j();     // Catch: Throwable -> L38
        a(14, null);     // Catch: Throwable -> L38
    L36:
        monitor-exit(this);
        return;
    L21:
        if (this.I == false) goto L30;
        a(r4, this.C);     // Catch: Throwable -> L27
        if (r5 == null) goto L25;
        r5.d(fd.b());     // Catch: Throwable -> L27
    L25:
        fb.a(this.E, r4, r5);     // Catch: Throwable -> L27
        fb.a(this.E, r4);     // Catch: Throwable -> L27
        d(r4.clone());     // Catch: Throwable -> L27
        fa.a(this.E).a(r4);     // Catch: Throwable -> L27
        fa.a(this.E).b();     // Catch: Throwable -> L27
    L15:
        if ("gps".equalsIgnoreCase(r4.getProvider()) == false) goto L17;
    L38:
        th = move-exception;
        ev.a(th, "ALManager", "handlerLocation part3");     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        throw th;
    }

    private void a(AMapLocation r4, String r5) {
        Bundle r0 = new Bundle();
        r0.putParcelable("loc", r4);
        r0.putString("lastLocNb", r5);
        a(1014, r0, 0);
    }

    static /* synthetic */ void a(cc r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(cc r1, int r2, long r3) {
        r1.a(r2, null, r3);
    }

    static /* synthetic */ void a(cc r0, int r1, Bundle r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(cc r0, Bundle r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(cc r0, Message r1) {
        r0.b(r1);
    }

    static /* synthetic */ void a(cc r0, AMapLocation r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(cc r0, AMapLocation r1, em r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(cc r2, com.amap.api.location.b r3) {
        r2.c((com.amap.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.amap.api.location.b.class, "com.obric.memorydata.plugin"));
    }

    private static void a(dl r2) {
        r2.d();     // Catch: Throwable -> L4
        r2.a(new AMapLocationClientOption().setNeedAddress(false));     // Catch: Throwable -> L4
        r2.a(true, new em());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
    }

    private void a(dl r2, em r3) {
        r2.a(this.E);     // Catch: Throwable -> L4
        r2.a(this.f5400b);     // Catch: Throwable -> L4
        r2.b(r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ALManager", "initApsBase");
    }

    private static void a(dl r1, es r2) {
        if (r2 == null) goto L12;
    L7:
        th = move-exception;
        ev.a(th, "ALManager", "apsLocation:doFirstAddCache");
        return;
    L4:
        if (r2.getErrorCode() != 0) goto L13;
        r1.b(r2);     // Catch: Throwable -> L7
        return;
    L13:
        return;
    }

    static /* synthetic */ boolean a(cc r0, boolean r1) {
        r0.H = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private es b(dl r14) {
        AMapLocation r1 = null;
        this.f5399a = null;
        em r2 = new em();
        r2.c(fd.b());     // Catch: Throwable -> L89
        String r3 = AMapLocationClientOption.getAPIKEY();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r3) == true) goto L120;
        fn.a(this.E, r3);     // Catch: Throwable -> L8
    L120:
        String r4 = com.amap.api.location.e.a();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r4) == true) goto L16;
        fp.a(r4);     // Catch: Throwable -> L14
    L16:
        a(r14, r2);     // Catch: Throwable -> L89
        boolean r5 = eu.m();     // Catch: Throwable -> L89
        boolean r6 = false;
    L34:
        th = move-exception;
        ev.a(th, "ALManager", "apscach");     // Catch: Throwable -> L89
    L36:
        es r7 = null;
    L38:
        if (r7 != null) goto L53;
        if (r5 == true) goto L41;
        boolean r8 = true;
    L117:
        r7 = r14.a(r8, r2);     // Catch: Throwable -> L48
        if (r7 == null) goto L47;
        if (r7.getErrorCode() != 0) goto L47;
        r6 = true;
    L47:
        es r9 = r7;
        boolean r10 = r6;
        r6 = true;
    L54:
        if (r9 != null) goto L115;
        String r11 = null;
    L113:
    L66:
        th = move-exception;
        ev.a(th, "ALManager", "fixLastLocation");     // Catch: Throwable -> L57
    L125:
        if (this.O.getCacheCallBack() == false) goto L103;
        c r12 = this.c;     // Catch: Throwable -> L97
        if (r12 == null) goto L103;
        r12.removeMessages(13);     // Catch: Throwable -> L97
    L103:
        Bundle r13 = new Bundle();     // Catch: Throwable -> L80
        if (r1 == null) goto L76;
        r13.putParcelable("loc", r1);     // Catch: Throwable -> L80
        r13.putString("nb", r9.k());     // Catch: Throwable -> L80
        r13.putParcelable("statics", r2);     // Catch: Throwable -> L80
    L76:
        a(r13);     // Catch: Throwable -> L80
        if (r10 == false) goto L82;
        a(r14, r9);     // Catch: Throwable -> L80
    L82:
        if (r6 == false) goto L107;
        if (r5 == false) goto L107;
        if (g == true) goto L107;
        g = true;     // Catch: Throwable -> L57
        a(r14);     // Catch: Throwable -> L57
    L107:
        r14.e();     // Catch: Throwable -> L98
        return r9;
    L128:
        return r9;
    L80:
        th = move-exception;
        ev.a(th, "ALManager", "apsLocation:callback");     // Catch: Throwable -> L57
    L57:
        th = th;
        r1 = r9;
    L109:
        ev.a(th, "ALManager", "apsLocation");     // Catch: Throwable -> L94
        r14.e();     // Catch: Throwable -> L100
    L93:
        return r1;
    L94:
        th = move-exception;
        r14.e();     // Catch: Throwable -> L99
    L96:
        throw th;
    L61:
        if (this.f5400b.isLocationCacheEnable() == false) goto L125;
        fk r15 = this.l;     // Catch: Throwable -> L66
        if (r15 == null) goto L125;
        r1 = r15.a(r1, r11, this.f5400b.getLastLocationLifeCycle());     // Catch: Throwable -> L66
    L115:
        r11 = r9.k();     // Catch: Throwable -> L57
        r1 = r9.clone();     // Catch: Throwable -> L57
    L48:
        th = move-exception;
        ev.a(th, "ALManager", "apsLocation:doFirstNetLocate");     // Catch: Throwable -> L51
    L51:
        th = th;
        r1 = r7;
        goto L109
    L41:
        r8 = false;
        goto L117
    L53:
        r9 = r7;
        r10 = false;
        goto L54
    L19:
        if (this.O.getCacheCallBack() == false) goto L32;
        r7 = a(r14, this.O.getCacheCallBack());     // Catch: Throwable -> L34
        if (r7 == null) goto L36;
        if (eu.a(r7.getTime()) == true) goto L38;
        if (this.O.getCacheCallBack() == false) goto L36;
        int r16 = this.O.getCacheTimeOut();     // Catch: Throwable -> L34
        long r17 = fd.a() - r7.getTime();     // Catch: Throwable -> L34
        if (r17 <= 0) goto L36;
        if (r17 >= r16) goto L36;
        this.f5399a = r7;     // Catch: Throwable -> L34
        r7.setLocationType(10);     // Catch: Throwable -> L34
        goto L36
    L32:
        r7 = a(r14, false);     // Catch: Throwable -> L34
    L14:
        th = move-exception;
        ev.a(th, "ALManager", "apsLocation setUmidToken");     // Catch: Throwable -> L89
    L8:
        th = move-exception;
        ev.a(th, "ALManager", "apsLocation setAuthKey");     // Catch: Throwable -> L89
    L89:
        th = th;
        goto L109
    }

    static /* synthetic */ fl b(cc r0) {
        return r0.F;
    }

    private void b(Looper r4) {
        if (r4 == null) goto L5;
        this.c = new c(this, r4);     // Catch: Throwable -> L11
    L32:
        this.l = new fk(this.E);     // Catch: Throwable -> L15
    L17:
        b r5 = new b("amapLocManagerThread", this);     // Catch: Throwable -> L19
        this.q = r5;     // Catch: Throwable -> L19
        r5.setPriority(5);     // Catch: Throwable -> L19
        this.q.start();     // Catch: Throwable -> L19
        this.B = a(this.q.getLooper());     // Catch: Throwable -> L19
    L30:
        this.d = new fi(this.E, this.c);     // Catch: Throwable -> L23
        this.F = new fl(this.E, this.c);     // Catch: Throwable -> L23
        this.G = new ff(this.E, this.c);     // Catch: Throwable -> L23
    L26:
        if (this.u != null) goto L28;
        this.u = new fb();
    L28:
        a(this.E);
        return;
    L23:
        th = move-exception;
        ev.a(th, "ALManager", "init 3");
        goto L26
    L15:
        th = move-exception;
        ev.a(th, "ALManager", "init 2");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        ev.a(th, "ALManager", "init 5");
        goto L30
    L5:
        if (Looper.myLooper() != null) goto L8;
        c r6 = new c(this, this.E.getMainLooper());     // Catch: Throwable -> L11
    L7:
        this.c = r6;     // Catch: Throwable -> L11
        goto L32
    L8:
        r6 = new c(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ev.a(th, "ALManager", "init 1");
        goto L32
    }

    private void b(Message r5) {
        AMapLocation r6 = (AMapLocation) ZeusTransformUtils.preCheckCast(r5.obj, AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        new StringBuilder("Gps     Longitude:").append(r6.getLongitude()).append(" Latitude:").append(r6.getLatitude());     // Catch: Throwable -> L12
        ex.c();     // Catch: Throwable -> L12
        if (this.h == true) goto L5;
    L10:
        a(r6, null);     // Catch: Throwable -> L12
        a(InputDeviceCompat.SOURCE_GAMEPAD);     // Catch: Throwable -> L12
        a(InputDeviceCompat.SOURCE_GAMEPAD, null, 300000);     // Catch: Throwable -> L12
        return;
    L5:
        if (this.m == null) goto L10;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L12
        r0.putBundle("optBundle", ev.a(this.f5400b));     // Catch: Throwable -> L12
        a(0, r0);     // Catch: Throwable -> L12
        if (this.I == false) goto L9;
        a(13, null);     // Catch: Throwable -> L12
    L9:
        this.h = false;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ev.a(th, "ALManager", "resultGpsLocationSuccess");
    }

    private static void b(AMapLocation r4) {
        if (r4 != null) goto L14;
        return;
    L14:
        if (2 != r4.getLocationType()) goto L8;
    L9:
        long r0 = r4.getTime();     // Catch: Throwable -> L13
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L13
        if (r2 <= r0) goto L17;
        r4.setTime(r2);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L8:
        if (4 == r4.getLocationType()) goto L9;
        return;
    }

    static /* synthetic */ void b(cc r0, Message r1) {
        r0.c(r1);
    }

    static /* synthetic */ void b(cc r0, AMapLocation r1) {
        r0.g(r1);
    }

    static /* synthetic */ void b(cc r2, com.amap.api.location.b r3) {
        r2.d((com.amap.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.amap.api.location.b.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean b(cc r0, boolean r1) {
        r0.K = r1;
        return r1;
    }

    static /* synthetic */ boolean b(boolean r0) {
        L = r0;
        return r0;
    }

    static /* synthetic */ ff c(cc r0) {
        return r0.G;
    }

    private void c(Message r5) {
        AMapLocation r6 = (AMapLocation) ZeusTransformUtils.preCheckCast(r5.obj, AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        new StringBuilder("Network Longitude:").append(r6.getLongitude()).append(" Latitude:").append(r6.getLatitude());     // Catch: Throwable -> L15
        ex.c();     // Catch: Throwable -> L15
        if (this.j == false) goto L11;
        if (this.m == null) goto L11;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L15
        r0.putBundle("optBundle", ev.a(this.f5400b));     // Catch: Throwable -> L15
        a(0, r0);     // Catch: Throwable -> L15
        if (this.I == false) goto L9;
        a(13, null);     // Catch: Throwable -> L15
    L9:
        this.j = false;     // Catch: Throwable -> L15
    L11:
        if (this.M == false) goto L13;
        a(1034);     // Catch: Throwable -> L15
        a(r6, null);     // Catch: Throwable -> L15
    L13:
        a(1033);     // Catch: Throwable -> L15
        a(1033, null, 300000);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        ev.a(th, "ALManager", "resultNetworkLocationSuccess");
    }

    private void c(AMapLocation r8) {
        if (r8 == null) goto L38;
        String r0 = r8.getLocationDetail();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r0) == false) goto L6;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L34
    L7:
        boolean r2 = fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");     // Catch: Throwable -> L34
        boolean r3 = fd.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");     // Catch: Throwable -> L34
        boolean r4 = fd.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");     // Catch: Throwable -> L34
        boolean r5 = fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");     // Catch: Throwable -> L34
        boolean r6 = fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");     // Catch: Throwable -> L34
        boolean r7 = fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");     // Catch: Throwable -> L34
        if (r2 == false) goto L10;
        String r9 = "#pm1";
    L11:
        r1.append(r9);     // Catch: Throwable -> L34
        String r10 = "1";
        if (r3 == false) goto L15;
        String r11 = "1";
    L16:
        r1.append(r11);     // Catch: Throwable -> L34
        if (r4 == false) goto L19;
        String r12 = "1";
    L20:
        r1.append(r12);     // Catch: Throwable -> L34
        if (r5 == false) goto L23;
        String r13 = "1";
    L24:
        r1.append(r13);     // Catch: Throwable -> L34
        if (r6 == false) goto L27;
        String r14 = "1";
    L28:
        r1.append(r14);     // Catch: Throwable -> L34
        if (r7 == true) goto L32;
        r10 = "0";
    L32:
        r1.append(r10);     // Catch: Throwable -> L34
        r8.setLocationDetail(r1.toString());     // Catch: Throwable -> L34
        return;
    L27:
        r14 = "0";
        goto L28
    L23:
        r13 = "0";
        goto L24
    L19:
        r12 = "0";
        goto L20
    L15:
        r11 = "0";
        goto L16
    L10:
        r9 = "#pm0";
        goto L11
    L6:
        r1 = new StringBuilder(r0);     // Catch: Throwable -> L34
    L34:
        ex.b();
        return;
    }

    private void c(com.amap.api.location.b r3) {
        com.amap.api.location.b r4 = (com.amap.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.amap.api.location.b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        if (this.e != null) goto L8;
        this.e = new ArrayList();
    L8:
        if (this.e.contains(r4) == true) goto L13;
        this.e.add(r4);
        return;
    L13:
        return;
    L12:
        throw new IllegalArgumentException("listener参数不能为null");
    }

    static /* synthetic */ void c(cc r0, Message r1) {
        r0.a(r1);
    }

    static /* synthetic */ Context d(cc r0) {
        return r0.E;
    }

    private void d(Message r6) {
        if (r6 != null) goto L13;
        return;
    L13:
        Bundle r7 = r6.getData();     // Catch: Throwable -> L10
        if (r7 != null) goto L8;
        return;
    L8:
        int r2 = r7.getInt("i", 0);     // Catch: Throwable -> L10
        Notification r8 = (Notification) ZeusTransformUtils.preCheckCast(r7.getParcelable(o.g), Notification.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Intent r3 = o();     // Catch: Throwable -> L10
        r3.putExtra("i", r2);     // Catch: Throwable -> L10
        r3.putExtra(o.g, r8);     // Catch: Throwable -> L10
        r3.putExtra(o.f, 1);     // Catch: Throwable -> L10
        a(r3, true);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        ev.a(th, "ALManager", "doEnableBackgroundLocation");
    }

    private void d(AMapLocation r3) {
        Message r0 = this.c.obtainMessage();
        r0.what = 10;
        r0.obj = r3;
        this.c.sendMessage(r0);
    }

    private void d(com.amap.api.location.b r3) {
        com.amap.api.location.b r4 = (com.amap.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.amap.api.location.b.class, "com.obric.memorydata.plugin");
        if (this.e.isEmpty() == true) goto L8;
        if (this.e.contains(r4) == false) goto L8;
        this.e.remove(r4);
    L8:
        if (this.e.isEmpty() == false) goto L11;
        j();
        return;
    }

    static /* synthetic */ void d(cc r0, Message r1) {
        r0.d(r1);
    }

    private void e(Message r3) {
        if (r3 != null) goto L13;
        return;
    L13:
        Bundle r4 = r3.getData();     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        return;
    L8:
        boolean r5 = r4.getBoolean(o.j, true);     // Catch: Throwable -> L10
        Intent r1 = o();     // Catch: Throwable -> L10
        r1.putExtra(o.j, r5);     // Catch: Throwable -> L10
        r1.putExtra(o.f, 2);     // Catch: Throwable -> L10
        a(r1, false);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        ev.a(th, "ALManager", "doDisableBackgroundLocation");
    }

    private synchronized void e(AMapLocation r4) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r3)
            if (r4 != 0) goto L14
            com.amap.api.location.AMapLocation r4 = new com.amap.api.location.AMapLocation     // Catch: java.lang.Throwable -> Lab
            java.lang.String r0 = ""
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lab
            r0 = 8
            r4.setErrorCode(r0)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r0 = "coarse amapLocation is null#2005"
            r4.setLocationDetail(r0)     // Catch: java.lang.Throwable -> Lab
        L14:
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            if (r0 != 0) goto L1f
            com.amap.api.location.c r0 = new com.amap.api.location.c     // Catch: java.lang.Throwable -> Lab
            r0.<init>()     // Catch: java.lang.Throwable -> Lab
            r3.y = r0     // Catch: java.lang.Throwable -> Lab
        L1f:
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.AMapLocationClientOption r1 = r3.f5400b     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = r1.getLocationMode()     // Catch: java.lang.Throwable -> Lab
            r0.a(r1)     // Catch: java.lang.Throwable -> Lab
            com.loc.ff r0 = r3.G     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L42
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            int r1 = r4.getSatellites()     // Catch: java.lang.Throwable -> Lab
            r0.b(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            com.loc.ff r1 = r3.G     // Catch: java.lang.Throwable -> Lab
            int r1 = r1.b()     // Catch: java.lang.Throwable -> Lab
            r0.a(r1)     // Catch: java.lang.Throwable -> Lab
        L42:
            android.content.Context r0 = r3.E     // Catch: java.lang.Throwable -> Lab
            boolean r0 = com.loc.fd.g(r0)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r1 = r3.y     // Catch: java.lang.Throwable -> Lab
            r1.a(r0)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            android.content.Context r1 = r3.E     // Catch: java.lang.Throwable -> Lab
            java.lang.String r1 = com.loc.fd.h(r1)     // Catch: java.lang.Throwable -> Lab
            r0.a(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            r1 = 0
            r0.a(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            boolean r1 = com.loc.cc.L     // Catch: java.lang.Throwable -> Lab
            r0.b(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.y     // Catch: java.lang.Throwable -> Lab
            r4.setLocationQualityReport(r0)     // Catch: java.lang.Throwable -> Lab
            boolean r0 = r3.I     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L96
            android.content.Context r0 = r3.E     // Catch: java.lang.Throwable -> L8e
            com.loc.fb.a(r0, r4)     // Catch: java.lang.Throwable -> L8e
            com.amap.api.location.AMapLocation r0 = r4.clone()     // Catch: java.lang.Throwable -> L8e
            r3.d(r0)     // Catch: java.lang.Throwable -> L8e
            android.content.Context r0 = r3.E     // Catch: java.lang.Throwable -> L8e
            com.loc.fa r0 = com.loc.fa.a(r0)     // Catch: java.lang.Throwable -> L8e
            r0.a(r4)     // Catch: java.lang.Throwable -> L8e
            android.content.Context r4 = r3.E     // Catch: java.lang.Throwable -> L8e
            com.loc.fa r4 = com.loc.fa.a(r4)     // Catch: java.lang.Throwable -> L8e
            r4.b()     // Catch: java.lang.Throwable -> L8e
            goto L96
        L8e:
            r4 = move-exception
            java.lang.String r0 = "ALManager"
            java.lang.String r1 = "handlerCoarseLocation part"
            com.loc.ev.a(r4, r0, r1)     // Catch: java.lang.Throwable -> Lab
        L96:
            boolean r4 = r3.r     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto L9c
            monitor-exit(r3)
            return
        L9c:
            com.loc.ff r4 = r3.G     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto La3
            r3.j()     // Catch: java.lang.Throwable -> Lab
        La3:
            r4 = 14
            r0 = 0
            r3.a(r4, r0)     // Catch: java.lang.Throwable -> Lab
            monitor-exit(r3)
            return
        Lab:
            r4 = move-exception
            java.lang.String r0 = "ALManager"
            java.lang.String r1 = "handlerCoarseLocation part2"
            com.loc.ev.a(r4, r0, r1)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r3)
            return
        Lb5:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cc.e(com.amap.api.location.AMapLocation):void");
    }

    static /* synthetic */ void e(cc r0) {
        r0.n();
    }

    static /* synthetic */ void e(cc r0, Message r1) {
        r0.e(r1);
    }

    private void f() {
        Object r0 = this.t;
        monitor-enter(r0);
        a r1 = this.B;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L10
    L7:
        this.B = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void f(AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        AMapLocation r0 = null;
        if (fk.f5548b != null) goto L10;
        fk r2 = this.l;     // Catch: Throwable -> L13
        if (r2 == null) goto L11;
        r0 = r2.b();     // Catch: Throwable -> L13
    L11:
        fb.a(r0, r3);     // Catch: Throwable -> L13
        return;
    L10:
        r0 = fk.f5548b.a();     // Catch: Throwable -> L13
    }

    static /* synthetic */ void f(cc r0) {
        r0.h();
    }

    private void g(AMapLocation r4) {
    L12:
        th = move-exception;
        ev.a(th, "ALManager", "resultGpsLocationSuccess");
        return;
    L3:
        if (this.i == true) goto L5;
    L10:
        e(r4);     // Catch: Throwable -> L12
        return;
    L5:
        if (this.m == null) goto L10;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L12
        r0.putBundle("optBundle", ev.a(this.f5400b));     // Catch: Throwable -> L12
        a(0, r0);     // Catch: Throwable -> L12
        if (this.I == false) goto L9;
        a(13, null);     // Catch: Throwable -> L12
    L9:
        this.i = false;     // Catch: Throwable -> L12
        goto L10
    }

    static /* synthetic */ void g(cc r0) {
        r0.j();
    }

    private boolean g() {
        boolean r1 = false;
        int r2 = 0;
    L27:
    L18:
        th = move-exception;
        ev.a(th, "ALManager", "checkAPSManager");
    L20:
        if (r1 == false) goto L22;
    L26:
        return r1;
    L22:
        if (fd.k((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.E.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L24;
        int r8 = 2103;
    L25:
        fb.a(null, r8);
        goto L26
    L24:
        r8 = 2101;
        goto L25
    L5:
        if (this.m != null) goto L9;
        Thread.sleep(100);     // Catch: Throwable -> L18
        r2 = r2 + 1;     // Catch: Throwable -> L18
        if (r2 < 50) goto L27;
    L9:
        if (this.m != null) goto L17;
        Message r3 = Message.obtain();     // Catch: Throwable -> L18
        Bundle r4 = new Bundle();     // Catch: Throwable -> L18
        AMapLocation r5 = new AMapLocation("");     // Catch: Throwable -> L18
        r5.setErrorCode(10);     // Catch: Throwable -> L18
        if (fd.k((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.E.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L14;
        String r6 = "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003";
    L13:
        r5.setLocationDetail(r6);     // Catch: Throwable -> L18
        r4.putParcelable("loc", r5);     // Catch: Throwable -> L18
        r3.setData(r4);     // Catch: Throwable -> L18
        r3.what = 1;     // Catch: Throwable -> L18
        this.c.sendMessage(r3);     // Catch: Throwable -> L18
        goto L20
    L14:
        r6 = "启动ApsServcie失败#1001";
        goto L13
    L17:
        r1 = true;
        goto L20
    }

    private synchronized void h() {
        monitor-enter(this);
    L77:
        th = move-exception;
        throw th;
    L4:
        if (Build.VERSION.SDK_INT >= 29) goto L12;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L12;
        if (fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == true) goto L12;
    L35:
        i();     // Catch: Throwable -> L77
        monitor-exit(this);
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 31) goto L20;
        if (Build.VERSION.SDK_INT < 29) goto L20;
        if (this.E.getApplicationInfo().targetSdkVersion < 29) goto L20;
        if (fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L35;
    L20:
        if (Build.VERSION.SDK_INT >= 31) goto L30;
        if (Build.VERSION.SDK_INT < 29) goto L30;
        if (this.E.getApplicationInfo().targetSdkVersion >= 29) goto L30;
        if (fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L30;
        if (fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L35;
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L39;
        if (fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L39;
        if (fd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L35;
    L39:
        if (this.f5400b != null) goto L42;
        this.f5400b = new AMapLocationClientOption();     // Catch: Throwable -> L77
    L42:
        if (this.I == false) goto L46;
        monitor-exit(this);
        return;
    L46:
        this.I = true;     // Catch: Throwable -> L77
        ex.c();     // Catch: Throwable -> L77
        long r2 = 0;
        a(1029, null, 0);     // Catch: Throwable -> L77
        int r1 = AnonymousClass3.f5403a[this.f5400b.getLocationMode().ordinal()];     // Catch: Throwable -> L77
        if (r1 != 1) goto L49;
        a(1027, null, 0);     // Catch: Throwable -> L77
        a(1017, null, 0);     // Catch: Throwable -> L77
        a(1016, null, 0);     // Catch: Throwable -> L77
        a(1031, null, 0);     // Catch: Throwable -> L77
        monitor-exit(this);
        return;
    L49:
        if (r1 == 2) goto L67;
        if (r1 == 3) goto L54;
    L64:
        monitor-exit(this);
        return;
    L54:
        if (fd.m(this.E) == false) goto L58;
        a(1016);     // Catch: Throwable -> L77
        a(1017, null, 0);     // Catch: Throwable -> L77
        a(1032, null, 0);     // Catch: Throwable -> L77
        a(1026, null, 0);     // Catch: Throwable -> L77
        monitor-exit(this);
        return;
    L58:
        a(1027, null, 0);     // Catch: Throwable -> L77
        a(1015, null, 0);     // Catch: Throwable -> L77
        if (this.f5400b.isGpsFirst() == true) goto L61;
    L63:
        a(1016, null, r2);     // Catch: Throwable -> L77
        a(1031, null, r2);     // Catch: Throwable -> L77
        goto L64
    L61:
        if (this.f5400b.isOnceLocation() == false) goto L63;
        r2 = this.f5400b.getGpsFirstTimeout();     // Catch: Throwable -> L77
        goto L63
    L67:
        if (fd.m(this.E) == false) goto L71;
        a(1016);     // Catch: Throwable -> L77
        a(1017, null, 0);     // Catch: Throwable -> L77
        a(1032, null, 0);     // Catch: Throwable -> L77
        a(1026, null, 0);     // Catch: Throwable -> L77
        monitor-exit(this);
        return;
    L71:
        a(1016);     // Catch: Throwable -> L77
        a(1027, null, 0);     // Catch: Throwable -> L77
        a(1032, null, 0);     // Catch: Throwable -> L77
        a(1015, null, 0);     // Catch: Throwable -> L77
        monitor-exit(this);
    }

    static /* synthetic */ void h(cc r0) {
        r0.p();
    }

    private void i() {
        AMapLocation r0 = new AMapLocation("");
        r0.setErrorCode(12);
        r0.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.y != null) goto L5;
        this.y = new com.amap.api.location.c();
    L5:
        com.amap.api.location.c r1 = new com.amap.api.location.c();
        this.y = r1;
        r1.a(4);
        this.y.b(0);
        this.y.a(this.f5400b.getLocationMode());
        this.y.a(fd.g(this.E));
        this.y.a(fd.h(this.E));
        this.y.a(0);
        r0.setLocationQualityReport(this.y);
        fb.a(null, 2121);
        d(r0);
    }

    static /* synthetic */ void i(cc r0) {
        r0.l();
    }

    private void j() {
        ex.c();     // Catch: Throwable -> L13
        a(InputDeviceCompat.SOURCE_GAMEPAD);     // Catch: Throwable -> L13
        a(1033);     // Catch: Throwable -> L13
        fi r0 = this.d;     // Catch: Throwable -> L13
        if (r0 == null) goto L5;
        r0.a();     // Catch: Throwable -> L13
    L5:
        fl r1 = this.F;     // Catch: Throwable -> L13
        if (r1 == null) goto L8;
        r1.a();     // Catch: Throwable -> L13
    L8:
        ff r2 = this.G;     // Catch: Throwable -> L13
        if (r2 == null) goto L11;
        r2.a();     // Catch: Throwable -> L13
    L11:
        a(1016);     // Catch: Throwable -> L13
        a(1030, null, 0);     // Catch: Throwable -> L13
        this.I = false;     // Catch: Throwable -> L13
        this.p = 0;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        ev.a(th, "ALManager", "stopLocation");
    }

    static /* synthetic */ void j(cc r0) {
        r0.q();
    }

    private void k() {
        es r0 = b(new dl(true));
        if (g() == false) goto L16;
        Bundle r1 = new Bundle();
        if (r0 != null) goto L7;
    L11:
        String r2 = "0";
    L12:
        r1.putBundle("optBundle", ev.a(this.f5400b));
        r1.putString("isCacheLoc", r2);
        a(0, r1);
        if (this.I == false) goto L17;
        a(13, null);
        return;
    L17:
        return;
    L7:
        if (r0.getLocationType() != 2) goto L9;
    L10:
        r2 = "1";
        goto L12
    L9:
        if (r0.getLocationType() != 4) goto L11;
    }

    private void l() {
    L30:
        th = move-exception;
        ev.a(th, "ALManager", "doLBSLocation");     // Catch: Throwable -> L36
        if (this.f5400b.isOnceLocation() == true) goto L57;
        m();     // Catch: Throwable -> L42
        return;
    L57:
        return;
    L58:
        return;
    L36:
        th = move-exception;
        if (this.f5400b.isOnceLocation() == true) goto L40;
        m();     // Catch: Throwable -> L43
    L40:
        throw th;
    L4:
        if (f5398J == false) goto L6;
    L25:
        f5398J = false;     // Catch: Throwable -> L30
        this.R = true;     // Catch: Throwable -> L30
        k();     // Catch: Throwable -> L30
    L48:
        if (this.f5400b.isOnceLocation() == true) goto L55;
        m();     // Catch: Throwable -> L41
        return;
    L55:
        return;
    L56:
        return;
    L6:
        if (this.v == false) goto L8;
    L44:
    L18:
        th = move-exception;
        this.A = true;     // Catch: Throwable -> L30
        ev.a(th, "ALManager", "doLBSLocation reStartService");     // Catch: Throwable -> L30
    L21:
        if (g() == false) goto L48;
        this.A = false;     // Catch: Throwable -> L30
        Bundle r1 = new Bundle();     // Catch: Throwable -> L30
        r1.putBundle("optBundle", ev.a(this.f5400b));     // Catch: Throwable -> L30
        r1.putString("d", com.amap.api.location.e.a());     // Catch: Throwable -> L30
        if (this.d.b() == true) goto L48;
        a(1, r1);     // Catch: Throwable -> L30
        goto L48
    L11:
        if (this.v == false) goto L21;
        if (a() == true) goto L21;
        if (this.A == true) goto L21;
        this.A = true;     // Catch: Throwable -> L18
        n();     // Catch: Throwable -> L18
    L8:
        if (this.R == true) goto L44;
        goto L25
    }

    private void m() {
        if (this.f5400b.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L10;
        long r4 = 1000;
        if (this.f5400b.getInterval() < 1000) goto L8;
        r4 = this.f5400b.getInterval();
    L8:
        a(1016, null, r4);
        return;
    }

    private void n() {
        if (this.n != null) goto L5;
        this.n = new Messenger(this.c);     // Catch: Throwable -> L7
    L5:
        a(o());     // Catch: Throwable -> L7
        return;
    }

    private Intent o() {
        if (this.o != null) goto L14;
        this.o = new Intent(this.E, com.amap.api.location.d.class);
    L14:
    L10:
        th = move-exception;
        ev.a(th, "ALManager", "startServiceImpl p2");
        String r0 = "";
    L12:
        this.o.putExtra("a", r0);
        this.o.putExtra("b", fm.c(this.E));
        this.o.putExtra("d", com.amap.api.location.e.a());
        return this.o;
    L6:
        if (TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) == true) goto L8;
        r0 = AMapLocationClientOption.getAPIKEY();     // Catch: Throwable -> L10
        goto L12
    L8:
        r0 = fm.f(this.E);     // Catch: Throwable -> L10
        goto L12
    }

    private void p() {
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L4
        new em().f("#2001");     // Catch: Throwable -> L4
        r0.append("模糊权限下不支持低功耗定位#2001");     // Catch: Throwable -> L4
        fb.a(null, 2153);     // Catch: Throwable -> L4
        es r1 = new es("");     // Catch: Throwable -> L4
        r1.setErrorCode(20);     // Catch: Throwable -> L4
        r1.setLocationDetail(r0.toString());     // Catch: Throwable -> L4
        g(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ALManager", "apsLocation:callback");
    }

    private void q() {
        this.d.b(this.f5400b);
        this.G.b(this.f5400b);
        if (this.I == true) goto L5;
    L7:
        this.s = this.f5400b.getLocationMode();
        if (this.u != null) goto L10;
        return;
    L10:
        if (this.f5400b.isOnceLocation() == false) goto L12;
        fb r0 = this.u;
        Context r1 = this.E;
        int r2 = 0;
    L13:
        r0.a(r1, r2);
        this.u.a(this.E, this.f5400b);
        return;
    L12:
        r0 = this.u;
        r1 = this.E;
        r2 = 1;
        goto L13
    L5:
        if (this.f5400b.getLocationMode().equals(this.s) == true) goto L7;
        j();
        h();
        goto L7
    }

    private boolean r() {
        if (fd.j(this.E) == false) goto L8;
        int r1 = -1;
        r1 = ez.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.E.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "checkSelfPermission", new Object[]{"android.permission.FOREGROUND_SERVICE"});     // Catch: Throwable -> L9
    L6:
        if (r1 == 0) goto L8;
        return false;
    L8:
        return true;
    }

    public final void a(AMapLocationClientOption r4) {
        this.O = r4.clone();     // Catch: Throwable -> L4
        a(PointerIconCompat.TYPE_ZOOM_IN, r4.clone(), 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ALManager", "setLocationOption");
    }

    public final void a(com.amap.api.location.b r4) {
        a(1002, (com.amap.api.location.b) ZeusTransformUtils.wrapperContextForParams(r4, com.amap.api.location.b.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "ALManager", "setLocationListener");
    }

    public final void a(boolean r4) {
        Bundle r0 = new Bundle();     // Catch: Throwable -> L4
        r0.putBoolean(o.j, r4);     // Catch: Throwable -> L4
        a(1024, r0, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ALManager", "disableBackgroundLocation");
    }

    public final boolean a() {
        return this.H;
    }

    public final void b() {
        if (this.O.getCacheCallBack() == false) goto L14;
        c r0 = this.c;     // Catch: Throwable -> L13
        if (r0 == null) goto L14;
        r0.sendEmptyMessageDelayed(13, this.O.getCacheCallBackTime());     // Catch: Throwable -> L13
    L14:
        a(1003, null, 0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        ev.a(th, "ALManager", "startLocation");
    }

    public final void b(com.amap.api.location.b r4) {
        a(1005, (com.amap.api.location.b) ZeusTransformUtils.wrapperContextForParams(r4, com.amap.api.location.b.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "ALManager", "unRegisterLocationListener");
    }

    public final void c() {
        a(1004, null, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "ALManager", "stopLocation");
    }

    public final void d() {
        fj r0 = this.P;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.a();     // Catch: Throwable -> L7
        this.P = null;     // Catch: Throwable -> L7
    L5:
        a(1011, null, 0);     // Catch: Throwable -> L7
        this.r = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ev.a(th, "ALManager", "onDestroy");
    }

    final void e() {
        a(12, null);
        this.h = true;
        this.j = true;
        this.i = true;
        this.k = true;
        this.H = false;
        this.v = false;
        j();
        fb r2 = this.u;
        if (r2 == null) goto L5;
        r2.b(this.E);
    L5:
        fa.a(this.E).a();
        fb.a(this.E);
        cy r3 = this.w;
        if (r3 == null) goto L8;
        r3.b().sendEmptyMessage(11);
    L33:
        if (this.D == false) goto L14;
        ZeusTransformUtils.stopService(this.E, o(), "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
    L14:
        this.D = false;
        ArrayList<com.amap.api.location.b> r4 = this.e;
        if (r4 == null) goto L17;
        r4.clear();
        this.e = null;
    L17:
        this.Q = null;
        f();
        if (this.q != null) goto L20;
    L24:
        this.q = null;
        c r0 = this.c;
        if (r0 == null) goto L27;
        r0.removeCallbacksAndMessages(null);
    L27:
        fk r1 = this.l;
        if (r1 == null) goto L37;
        r1.c();
        this.l = null;
        return;
    L37:
        return;
    L20:
        if (Build.VERSION.SDK_INT >= 18) goto L35;
    L23:
        this.q.quit();
        goto L24
    L35:
        ez.a(this.q, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L32
    L8:
        ServiceConnection r5 = this.Q;
        if (r5 == null) goto L33;
        ZeusTransformUtils.unbindService(this.E, r5, "com.obric.memorydata.plugin");
        goto L33
    }
}
