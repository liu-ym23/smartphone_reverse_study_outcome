package n4a;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.loc.em;
import com.loc.es;
import com.lynx.tasm.event.LynxTouchEvent;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x1 {
    public static boolean J = true;
    public static volatile boolean K;
    public static boolean L;
    public static final AtomicBoolean M = null;
    public s4 A;
    public String B;
    public a C;
    public AMapLocationQualityReport D;
    public boolean E;
    public volatile boolean F;
    public c G;
    public String H;
    public boolean I;
    public es a;
    public final Context b;
    public AMapLocationClientOption c;
    public e d;
    public q4 e;
    public u4 f;
    public l4 g;
    public boolean h;
    public volatile boolean i;
    public ArrayList<AMapLocationListener> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public t4 o;
    public Messenger p;
    public Messenger q;
    public Intent r;
    public d s;
    public boolean t;
    public AMapLocationClientOption.AMapLocationMode u;
    public final Object v;
    public h4 w;
    public boolean x;
    public boolean y;
    public AMapLocationClientOption z;

    public class a implements ServiceConnection {
        public final /* synthetic */ x1 a;

        public a(x1 r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r2) {
            x1 r3 = this.a;
            r3.p = null;
            r3.h = false;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            x1 r4 = this.a;     // Catch: Throwable -> L4
            r4.p = new Messenger(r3);     // Catch: Throwable -> L4
            x1 r5 = this.a;     // Catch: Throwable -> L4
            r5.h = true;     // Catch: Throwable -> L4
            r5.x = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            c4.g(th, "ALManager", "onServiceConnected");
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = r0;
            r0[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class c extends Handler {
        public final /* synthetic */ x1 a;

        public c(x1 r1, Looper r2) {
            this.a = r1;
            super(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(String r14) {
            String r0 = null;
            super.handleMessage(r14);     // Catch: Throwable -> L135
            if (com.loc.h.G == false) goto L6;
            return;
        L6:
            int r1 = r14.what;     // Catch: Throwable -> L135
            if (r1 != 11) goto L10;
            Bundle r15 = r14.getData();     // Catch: Throwable -> L135
            this.a.f(r15);     // Catch: Throwable -> L135
            return;
        L10:
            if (r1 != 12) goto L12;
            x1.i(this.a, r14);     // Catch: Throwable -> L135
            return;
        L12:
            if (r1 != 16) goto L14;
            x1.k(this.a, r14);     // Catch: Throwable -> L135
            return;
        L14:
            if (r1 != 1011) goto L142;
            this.a.c(14, null);     // Catch: Throwable -> L135
            this.a.q();     // Catch: Throwable -> L135
            return;
        L142:
            switch(r1) {
                case 1002: goto L38;
                case 1003: goto L34;
                case 1004: goto L31;
                case 1005: goto L21;
                default: goto L17;
            };
        L21:
            x1 r2 = this.a;     // Catch: Throwable -> L135
            AMapLocationListener r16 = (AMapLocationListener) r14.obj;     // Catch: Throwable -> L135
            if (r2.j.isEmpty() == true) goto L27;
            if (r2.j.contains(r16) == false) goto L27;
            r2.j.remove(r16);     // Catch: Throwable -> L135
        L27:
            if (r2.j.isEmpty() == false) goto L145;
            r2.y();     // Catch: Throwable -> L135
            return;
        L145:
            return;
        L38:
            x1 r3 = this.a;     // Catch: Throwable -> L135
            AMapLocationListener r17 = (AMapLocationListener) r14.obj;     // Catch: Throwable -> L135
            if (r17 != null) goto L41;
            r3.getClass();     // Catch: Throwable -> L135
            throw new IllegalArgumentException("listener参数不能为null");     // Catch: Throwable -> L135
        L41:
            if (r3.j != null) goto L44;
            r3.j = new ArrayList();     // Catch: Throwable -> L135
        L44:
            if (r3.j.contains(r17) == true) goto L146;
            r3.j.add(r17);     // Catch: Throwable -> L135
            return;
        L146:
            return;
        L17:
            switch(r1) {
                case 1014: goto L68;
                case 1015: goto L66;
                case 1016: goto L56;
                case 1017: goto L52;
                case 1018: goto L49;
                default: goto L18;
            };
        L18:
            boolean r6 = true;
            switch(r1) {
                case 1023: goto L125;
                case 1024: goto L116;
                case 1025: goto L103;
                case 1026: goto L100;
                case 1027: goto L98;
                case 1028: goto L96;
                case 1029: goto L94;
                case 1030: goto L92;
                case 1031: goto L89;
                case 1032: goto L85;
                case 1033: goto L72;
                case 1034: goto L70;
                default: goto L153;
            };
        L70:
            Bundle r18 = r14.getData();     // Catch: Throwable -> L135
            AMapLocation r4 = r18.getParcelable("mapLoc");     // Catch: Throwable -> L135
            em r5 = (em) r18.getParcelable("entity");     // Catch: Throwable -> L135
            r18.getSerializable("ex");     // Catch: Throwable -> L135
            this.a.h(r4, r5);     // Catch: Throwable -> L135
            return;
        L85:
            this.a.f.b();     // Catch: Throwable -> L135
            this.a.a(1033);     // Catch: Throwable -> L135
            return;
        L92:
            Bundle r19 = new Bundle();     // Catch: Throwable -> L135
            r19.putString("objHash", Integer.toString(System.identityHashCode(this)));     // Catch: Throwable -> L135
            this.a.c(17, r19);     // Catch: Throwable -> L135
            return;
        L94:
            Bundle r110 = new Bundle();     // Catch: Throwable -> L135
            r110.putString("objHash", Integer.toString(System.identityHashCode(this)));     // Catch: Throwable -> L135
            this.a.c(16, r110);     // Catch: Throwable -> L135
            return;
        L96:
            this.a.r((AMapLocation) r14.obj);     // Catch: Throwable -> L135
            return;
        L98:
            this.a.g.f();     // Catch: Throwable -> L135
            return;
        L100:
            x1 r111 = this.a;     // Catch: Throwable -> L135
            r111.g.c(r111.c);     // Catch: Throwable -> L135
            return;
        L116:
            r0 = "handleMessage ACTION_DISABLE_BACKGROUND";
            x1 r7 = this.a;     // Catch: Throwable -> L135
            r7.getClass();     // Catch: Throwable -> L135
            Bundle r112 = r14.getData();     // Catch: Throwable -> L122
            if (r112 == null) goto L147;
            boolean r113 = r112.getBoolean("j", true);     // Catch: Throwable -> L122
            Intent r8 = r7.C();     // Catch: Throwable -> L122
            r8.putExtra("j", r113);     // Catch: Throwable -> L122
            r8.putExtra("g", 2);     // Catch: Throwable -> L122
            r7.e(r8, false);     // Catch: Throwable -> L122
        L148:
            return;
        L147:
            return;
        L122:
            th = move-exception;
            c4.g(th, "ALManager", "doDisableBackgroundLocation");     // Catch: Throwable -> L135
            return;
        L125:
            x1.o(this.a, r14);     // Catch: Throwable -> L135
            return;
        L153:
            return;
        L72:
            u4 r9 = this.a.f;     // Catch: Throwable -> L36
            AMapLocationClientOption r10 = r9.d;     // Catch: Throwable -> L36
            if (r10 != null) goto L75;
        L80:
            r6 = false;
        L81:
            if (r6 == false) goto L83;
            this.a.f.b();     // Catch: Throwable -> L36
            x1 r11 = this.a;     // Catch: Throwable -> L36
            r11.f.f(r11.c);     // Catch: Throwable -> L36
        L83:
            this.a.d(1033, null, 300000);     // Catch: Throwable -> L36
            return;
        L75:
            if (r10.isOnceLocation() == true) goto L80;
            if ((SystemClock.elapsedRealtime() - r9.i) <= 300000) goto L80;
        L89:
            if (this.a.c.isSysNetworkLocEnable() == false) goto L152;
            x1 r12 = this.a;     // Catch: Throwable -> L36
            r12.f.f(r12.c);     // Catch: Throwable -> L36
            this.a.d(1033, null, 300000);     // Catch: Throwable -> L36
            return;
        L152:
            return;
        L103:
            q4 r13 = this.a.e;     // Catch: Throwable -> L36
            AMapLocationClientOption r20 = r13.d;     // Catch: Throwable -> L36
            if (r20 != null) goto L106;
        L111:
            r6 = false;
        L112:
            if (r6 == false) goto L114;
            this.a.e.h();     // Catch: Throwable -> L36
            x1 r21 = this.a;     // Catch: Throwable -> L36
            r21.e.e(r21.c);     // Catch: Throwable -> L36
        L114:
            this.a.d(1025, null, 300000);     // Catch: Throwable -> L36
            return;
        L106:
            if (r20.isOnceLocation() == true) goto L111;
            if ((SystemClock.elapsedRealtime() - r13.f) <= 300000) goto L111;
        L49:
            x1 r22 = this.a;     // Catch: Throwable -> L135
            AMapLocationClientOption r114 = (AMapLocationClientOption) r14.obj;     // Catch: Throwable -> L135
            r22.c = r114;     // Catch: Throwable -> L135
            if (r114 == null) goto L149;
            x1.w(r22);     // Catch: Throwable -> L135
            return;
        L149:
            return;
        L52:
            this.a.e.h();     // Catch: Throwable -> L135
            this.a.a(1025);     // Catch: Throwable -> L135
            return;
        L68:
            x1.m(this.a, r14);     // Catch: Throwable -> L135
            return;
        L56:
            if (j4.J(this.a.b) == false) goto L60;
            x1.s(this.a);     // Catch: Throwable -> L36
            return;
        L60:
            if (this.a.e.j() == false) goto L63;
            this.a.d(1016, null, 1000);     // Catch: Throwable -> L36
            return;
        L63:
            x1.t(this.a);     // Catch: Throwable -> L36
            return;
        L66:
            x1 r23 = this.a;     // Catch: Throwable -> L36
            r23.e.e(r23.c);     // Catch: Throwable -> L36
            this.a.d(1025, null, 300000);     // Catch: Throwable -> L36
            return;
        L31:
            this.a.y();     // Catch: Throwable -> L36
            this.a.c(14, null);     // Catch: Throwable -> L36
            return;
        L34:
            this.a.v();     // Catch: Throwable -> L36
            this.a.c(13, null);     // Catch: Throwable -> L36
            return;
        L36:
            Throwable th = th;
        L137:
            if (r14 != 0) goto L139;
            r14 = "handleMessage";
        L139:
            c4.g(th, "AMapLocationManage$MHandlerr", r14);
            return;
        L135:
            th = move-exception;
            String r115 = r0;
            th = th;
            r14 = r115;
            goto L137
        }
    }

    public static class d extends PthreadHandlerThreadV2 {
        public final x1 c;

        public d(x1 r2) {
            super("amapLocManagerThread");
            this.c = null;
            this.c = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onLooperPrepared() {
            this.c.o.b();     // Catch: Throwable -> L9
            g4.a(this.c.b);     // Catch: Throwable -> L9
            this.c.B();     // Catch: Throwable -> L9
            x1 r0 = this.c;     // Catch: Throwable -> L9
            if (r0 == null) goto L7;
            Context r1 = r0.b;     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            com.loc.h.g(r1);     // Catch: Throwable -> L9
            com.loc.h.a(this.c.b);     // Catch: Throwable -> L9
        L7:
            super/*android.os.HandlerThread*/.onLooperPrepared();     // Catch: Throwable -> L9
            return;
        }

        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        }
    }

    public class e extends Handler {
        public final /* synthetic */ x1 a;

        public e(x1 r1) {
            this.a = r1;
        }

        public e(x1 r1, Looper r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r7) {
            String r0 = null;
            super.handleMessage(r7);     // Catch: Throwable -> L72
            x1 r1 = this.a;     // Catch: Throwable -> L72
            if (r1.t == false) goto L6;
            return;
        L6:
            int r2 = r7.what;     // Catch: Throwable -> L72
            if (r2 != 1) goto L10;
            Message r3 = r1.G.obtainMessage();     // Catch: Throwable -> L72
            r3.what = 11;     // Catch: Throwable -> L72
            r3.setData(r7.getData());     // Catch: Throwable -> L72
            this.a.G.sendMessage(r3);     // Catch: Throwable -> L72
            return;
        L10:
            if (r2 != 2) goto L12;
        L62:
            Message r4 = Message.obtain();     // Catch: Throwable -> L72
            r4.what = 12;     // Catch: Throwable -> L72
            r4.obj = r7.obj;     // Catch: Throwable -> L72
            this.a.G.sendMessage(r4);     // Catch: Throwable -> L72
            AMapLocationClientOption r8 = this.a.z;     // Catch: Throwable -> L72
            if (r8 != null) goto L65;
            return;
        L65:
            if (r8.getCacheCallBack() == false) goto L86;
            e r9 = this.a.d;     // Catch: Throwable -> L72
            if (r9 == null) goto L87;
            r9.removeMessages(13);     // Catch: Throwable -> L72
            return;
        L87:
            return;
        L86:
            return;
        L12:
            if (r2 != 17) goto L14;
            h4.k(null, 2131);     // Catch: Throwable -> L72
        L60:
            Message r5 = Message.obtain();     // Catch: Throwable -> L72
            r5.what = 16;     // Catch: Throwable -> L72
            r5.obj = r7.obj;     // Catch: Throwable -> L72
            this.a.G.sendMessage(r5);     // Catch: Throwable -> L72
            return;
        L14:
            if (r2 != 18) goto L16;
            Bundle r10 = r7.getData();     // Catch: Throwable -> L72
            u4 r6 = this.a.f;     // Catch: Throwable -> L72
            if (r6 == null) goto L84;
            r6.d(r10);     // Catch: Throwable -> L72
            return;
        L84:
            return;
        L16:
            switch(r2) {
                case 5: goto L53;
                case 6: goto L49;
                case 7: goto L47;
                case 8: goto L46;
                case 9: goto L45;
                case 10: goto L43;
                default: goto L17;
            };
        L17:
            switch(r2) {
                case 13: goto L37;
                case 14: goto L35;
                case 15: goto L60;
                default: goto L18;
            };
        L18:
            switch(r2) {
                case 100: goto L26;
                case 101: goto L27;
                case 102: goto L24;
                case 103: goto L20;
                default: goto L88;
            };
        L20:
            Bundle r11 = r7.getData();     // Catch: Throwable -> L72
            l4 r12 = this.a.g;     // Catch: Throwable -> L72
            if (r12 == null) goto L78;
            r12.b(r11);     // Catch: Throwable -> L72
            return;
        L78:
            return;
        L24:
            Bundle r13 = r7.getData();     // Catch: Throwable -> L72
            r13.putBundle("optBundle", c4.a(this.a.c));     // Catch: Throwable -> L72
            this.a.c(15, r13);     // Catch: Throwable -> L72
            return;
        L26:
            h4.k(null, 2155);     // Catch: Throwable -> L72
        L27:
            Message r14 = Message.obtain();     // Catch: Throwable -> L72
            r14.what = 1028;     // Catch: Throwable -> L72
            r14.obj = r7.obj;     // Catch: Throwable -> L72
            this.a.G.sendMessage(r14);     // Catch: Throwable -> L72
            AMapLocationClientOption r15 = this.a.z;     // Catch: Throwable -> L72
            if (r15 != null) goto L30;
            return;
        L30:
            if (r15.getCacheCallBack() == false) goto L80;
            e r16 = this.a.d;     // Catch: Throwable -> L72
            if (r16 == null) goto L81;
            r16.removeMessages(13);     // Catch: Throwable -> L72
            return;
        L81:
            return;
        L80:
            return;
        L88:
            return;
        L35:
            Bundle r17 = r7.getData();     // Catch: Throwable -> L72
            r17.putBundle("optBundle", c4.a(this.a.c));     // Catch: Throwable -> L72
            this.a.c(18, r17);     // Catch: Throwable -> L72
            return;
        L37:
            es r18 = r1.a;     // Catch: Throwable -> L72
            if (r18 == null) goto L41;
            x1.j(r1, r18);     // Catch: Throwable -> L72
            return;
        L41:
            AMapLocation r19 = new AMapLocation("LBS");     // Catch: Throwable -> L72
            r19.setErrorCode(33);     // Catch: Throwable -> L72
            x1.j(this.a, r19);     // Catch: Throwable -> L72
            return;
        L43:
            x1.j(r1, (AMapLocation) r7.obj);     // Catch: Throwable -> L72
            return;
        L45:
            x1.L = r7.getData().getBoolean("installMockApp");     // Catch: Throwable -> L72
            return;
        L46:
            h4.k(null, 2141);     // Catch: Throwable -> L72
            goto L62
        L47:
            Bundle r20 = r7.getData();     // Catch: Throwable -> L72
            x1 r21 = this.a;     // Catch: Throwable -> L72
            r20.getBoolean("ngpsAble");     // Catch: Throwable -> L72
            r21.getClass();     // Catch: Throwable -> L72
            return;
        L49:
            Bundle r22 = r7.getData();     // Catch: Throwable -> L72
            q4 r23 = this.a.e;     // Catch: Throwable -> L72
            if (r23 == null) goto L83;
            r23.c(r22);     // Catch: Throwable -> L72
            return;
        L83:
            return;
        L53:
            Bundle r24 = r7.getData();     // Catch: Throwable -> L72
            r24.putBundle("optBundle", c4.a(this.a.c));     // Catch: Throwable -> L72
            this.a.c(10, r24);     // Catch: Throwable -> L72
            return;
        L72:
            th = move-exception;
            if (0 != 0) goto L75;
            r0 = "handleMessage";
        L75:
            c4.g(th, "AmapLocationManager$MainHandler", r0);
        }
    }

    static {
        M = new AtomicBoolean(false);
    }

    public final void A() {
        if (this.c.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L10;
        long r2 = 1000;
        if (this.c.getInterval() < 1000) goto L8;
        r2 = this.c.getInterval();
    L8:
        d(1016, null, r2);
        return;
    }

    public final Intent C() {
        if (this.r != null) goto L14;
        this.r = new Intent(this.b, APSService.class);
    L14:
    L10:
        th = move-exception;
        c4.g(th, "ALManager", "startServiceImpl p2");
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        this.r.putExtra("a", r0);
        this.r.putExtra("b", v4.d(this.b));
        this.r.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.r;
    L6:
        if (TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) == true) goto L8;
        r0 = AMapLocationClientOption.getAPIKEY();     // Catch: Throwable -> L10
        goto L12
    L8:
        r0 = v4.g(this.b);     // Catch: Throwable -> L10
        goto L12
    }

    public final void a(int r3) {
        Object r0 = this.v;
        monitor-enter(r0);
        c r1 = this.G;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.removeMessages(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b(int r4, Notification r5) {
        if (r4 == 0) goto L17;
        if (r5 == null) goto L18;
    L12:
        th = move-exception;
        c4.g(th, "ALManager", "disableBackgroundLocation");
        return;
    L6:
        if (this.n == true) goto L8;
    L10:
        Bundle r0 = new Bundle();     // Catch: Throwable -> L12
        r0.putInt("i", r4);     // Catch: Throwable -> L12
        r0.putParcelable("h", r5);     // Catch: Throwable -> L12
        d(1023, r0, 0);     // Catch: Throwable -> L12
        return;
    L8:
        if (this.p == null) goto L10;
        Bundle r1 = new Bundle();     // Catch: Throwable -> L12
        r1.putBundle("optBundle", c4.a(this.c));     // Catch: Throwable -> L12
        c(0, r1);     // Catch: Throwable -> L12
        this.n = false;     // Catch: Throwable -> L12
        goto L10
    L18:
        return;
    }

    public final void d(int r3, Object r4, long r5) {
        Object r0 = this.v;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.G == null) goto L11;
        Message r1 = Message.obtain();     // Catch: Throwable -> L13
        r1.what = r3;     // Catch: Throwable -> L13
        if ((r4 instanceof Bundle) == false) goto L9;
        r1.setData((Bundle) r4);     // Catch: Throwable -> L13
    L10:
        this.G.sendMessageDelayed(r1, r5);     // Catch: Throwable -> L13
        goto L11
    L9:
        r1.obj = r4;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public final void l(AMapLocation r9) {
        if (r9 == null) goto L37;
        String r0 = r9.getLocationDetail();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r0) == false) goto L6;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L34
    L7:
        boolean r2 = j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");     // Catch: Throwable -> L34
        boolean r3 = j4.A(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");     // Catch: Throwable -> L34
        boolean r4 = j4.A(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");     // Catch: Throwable -> L34
        boolean r5 = j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");     // Catch: Throwable -> L34
        boolean r6 = j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");     // Catch: Throwable -> L34
        boolean r7 = j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");     // Catch: Throwable -> L34
        if (r2 == false) goto L10;
        String r8 = "#pm1";
    L11:
        r1.append(r8);     // Catch: Throwable -> L34
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
        r9.setLocationDetail(r1.toString());     // Catch: Throwable -> L34
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
        r8 = "#pm0";
        goto L11
    L6:
        r1 = new StringBuilder(r0);     // Catch: Throwable -> L34
    L38:
        return;
    }

    public final void n(AMapLocation r3) {
        Message r0 = this.d.obtainMessage();
        r0.what = 10;
        r0.obj = r3;
        this.d.sendMessage(r0);
    }

    public final void r(AMapLocation r4) {
    L12:
        th = move-exception;
        c4.g(th, "ALManager", "resultGpsLocationSuccess");
        return;
    L3:
        if (this.l == true) goto L5;
    L10:
        p(r4);     // Catch: Throwable -> L12
        return;
    L5:
        if (this.p == null) goto L10;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L12
        r0.putBundle("optBundle", c4.a(this.c));     // Catch: Throwable -> L12
        c(0, r0);     // Catch: Throwable -> L12
        if (this.i == false) goto L9;
        c(13, null);     // Catch: Throwable -> L12
    L9:
        this.l = false;     // Catch: Throwable -> L12
        goto L10
    }

    public final synchronized void v() {
        monitor-enter(this);
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L73
        if (r0 >= 29) goto L12;
        if (r0 < 23) goto L12;
        if (j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L12;
        if (j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == true) goto L12;
    L31:
        x();     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L12:
        if (r0 >= 31) goto L18;
        if (r0 < 29) goto L18;
        if (this.b.getApplicationInfo().targetSdkVersion < 29) goto L18;
        if (j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L31;
    L18:
        if (r0 >= 31) goto L26;
        if (r0 < 29) goto L26;
        if (this.b.getApplicationInfo().targetSdkVersion >= 29) goto L26;
        if (j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L26;
        if (j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L31;
    L26:
        if (r0 < 31) goto L35;
        if (j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L35;
        if (j4.A(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L31;
    L35:
        if (this.c != null) goto L38;
        this.c = new AMapLocationClientOption();     // Catch: Throwable -> L73
    L38:
        if (this.i == false) goto L42;
        monitor-exit(this);
        return;
    L42:
        this.i = true;     // Catch: Throwable -> L73
        long r2 = 0;
        d(1029, null, 0);     // Catch: Throwable -> L73
        int r1 = b.a[this.c.getLocationMode().ordinal()];     // Catch: Throwable -> L73
        if (r1 != 1) goto L45;
        d(1027, null, 0);     // Catch: Throwable -> L73
        d(1017, null, 0);     // Catch: Throwable -> L73
        d(1016, null, 0);     // Catch: Throwable -> L73
        d(1031, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L45:
        if (r1 == 2) goto L63;
        if (r1 == 3) goto L50;
    L60:
        monitor-exit(this);
        return;
    L50:
        if (j4.J(this.b) == false) goto L54;
        a(1016);     // Catch: Throwable -> L73
        d(1017, null, 0);     // Catch: Throwable -> L73
        d(1032, null, 0);     // Catch: Throwable -> L73
        d(1026, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L54:
        d(1027, null, 0);     // Catch: Throwable -> L73
        d(1015, null, 0);     // Catch: Throwable -> L73
        if (this.c.isGpsFirst() == true) goto L57;
    L59:
        d(1016, null, r2);     // Catch: Throwable -> L73
        d(1031, null, r2);     // Catch: Throwable -> L73
        goto L60
    L57:
        if (this.c.isOnceLocation() == false) goto L59;
        r2 = this.c.getGpsFirstTimeout();     // Catch: Throwable -> L73
        goto L59
    L63:
        if (j4.J(this.b) == false) goto L67;
        a(1016);     // Catch: Throwable -> L73
        d(1017, null, 0);     // Catch: Throwable -> L73
        d(1032, null, 0);     // Catch: Throwable -> L73
        d(1026, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L67:
        a(1016);     // Catch: Throwable -> L73
        d(1027, null, 0);     // Catch: Throwable -> L73
        d(1032, null, 0);     // Catch: Throwable -> L73
        d(1015, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L73:
        th = move-exception;
        throw th;
    }

    public final void x() {
        AMapLocation r0 = new AMapLocation(NameKeys.UnloadStrategy_No_Strategy);
        r0.setErrorCode(12);
        r0.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.D != null) goto L5;
        this.D = new AMapLocationQualityReport();
    L5:
        AMapLocationQualityReport r1 = new AMapLocationQualityReport();
        this.D = r1;
        r1.setGpsStatus(4);
        this.D.setGPSSatellites(0);
        this.D.setLocationMode(this.c.getLocationMode());
        this.D.setWifiAble(j4.G(this.b));
        this.D.setNetworkType(j4.H(this.b));
        this.D.setNetUseTime(0);
        r0.setLocationQualityReport(this.D);
        h4.k(null, 2121);
        n(r0);
    }

    public final void y() {
        a(1025);     // Catch: Throwable -> L14
        a(1033);     // Catch: Throwable -> L14
        q4 r0 = this.e;     // Catch: Throwable -> L14
        if (r0 == null) goto L6;
        r0.h();     // Catch: Throwable -> L14
    L6:
        u4 r1 = this.f;     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        r1.b();     // Catch: Throwable -> L14
    L9:
        l4 r2 = this.g;     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        r2.f();     // Catch: Throwable -> L14
    L12:
        a(1016);     // Catch: Throwable -> L14
        d(1030, null, 0);     // Catch: Throwable -> L14
        this.i = false;     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        c4.g(th, "ALManager", "stopLocation");
    }

    public final void B() {
        if (this.q != null) goto L5;
        this.q = new Messenger(this.d);     // Catch: Throwable -> L11
    L5:
        Intent r0 = C();     // Catch: Throwable -> L11
        this.b.bindService(r0, this.C, 1);     // Catch: Throwable -> L8
        goto L16
    L15:
        return;
    L8:
        th = move-exception;
        c4.g(th, "ALManager", "startServiceImpl");     // Catch: Throwable -> L11
        return;
    }

    public final void q() {
        c(12, null);
        this.k = true;
        this.m = true;
        this.l = true;
        this.n = true;
        this.h = false;
        this.x = false;
        y();
        h4 r2 = this.w;
        if (r2 == null) goto L5;
        r2.m(this.b);
    L5:
        g4.a(this.b).b();
        h4.b(this.b);
        a r3 = this.C;
        if (r3 == null) goto L42;
        this.b.unbindService(r3);
    L42:
        if (this.I == false) goto L13;
        this.b.stopService(C());     // Catch: Throwable -> L12
    L13:
        this.I = false;
        ArrayList<AMapLocationListener> r4 = this.j;
        if (r4 == null) goto L16;
        r4.clear();
        this.j = null;
    L16:
        this.C = null;
        Object r5 = this.v;
        monitor-enter(r5);
        c r6 = this.G;     // Catch: Throwable -> L39
        if (r6 == null) goto L21;
        r6.removeCallbacksAndMessages(null);     // Catch: Throwable -> L39
    L21:
        this.G = null;     // Catch: Throwable -> L39
        monitor-exit(r5);     // Catch: Throwable -> L39
        d r7 = this.s;
        if (r7 != null) goto L48;
    L28:
        this.s = null;
        e r8 = this.d;
        if (r8 == null) goto L31;
        r8.removeCallbacksAndMessages(null);
    L31:
        t4 r9 = this.o;
        if (r9 == null) goto L50;
        r9.d();     // Catch: Throwable -> L35
        r9.e = 0;     // Catch: Throwable -> L35
        r9.f = false;     // Catch: Throwable -> L35
        r9.c = null;     // Catch: Throwable -> L35
        r9.d = null;     // Catch: Throwable -> L35
    L37:
        this.o = null;
        return;
    L35:
        th = move-exception;
        c4.g(th, "LastLocationManager", "destroy");
        goto L37
    L50:
        return;
    L48:
        f4.b(r7, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L27
    L27:
        this.s.quit();
    L39:
        th = move-exception;
        throw th;
    }

    public final boolean u() {
        boolean r1 = false;
        int r2 = 0;
    L43:
    L23:
        th = move-exception;
        c4.g(th, "ALManager", "checkAPSManager");
    L25:
        boolean r3 = false;
    L26:
        if (r3 == true) goto L38;
        Context r6 = this.b.getApplicationContext();
        ServiceInfo r0 = r6.getPackageManager().getServiceInfo(new ComponentName(r6, "com.amap.api.location.APSService"), LynxTouchEvent.kPseudoStateFocusTransition);     // Catch: Throwable -> L30
    L31:
        if (r0 == null) goto L34;
        r1 = true;
    L34:
        if (r1 == true) goto L36;
        int r4 = 2103;
    L37:
        h4.k(null, r4);
        goto L38
    L36:
        r4 = 2101;
    L30:
        r0 = null;
    L38:
        return r3;
    L5:
        if (this.p != null) goto L9;
        Thread.sleep(100);     // Catch: Throwable -> L23
        r2 = r2 + 1;     // Catch: Throwable -> L23
        if (r2 < 50) goto L43;
    L9:
        if (this.p != null) goto L22;
        Message r5 = Message.obtain();     // Catch: Throwable -> L23
        Bundle r7 = new Bundle();     // Catch: Throwable -> L23
        AMapLocation r8 = new AMapLocation(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L23
        r8.setErrorCode(10);     // Catch: Throwable -> L23
        Context r9 = this.b.getApplicationContext();     // Catch: Throwable -> L23
        ServiceInfo r10 = r9.getPackageManager().getServiceInfo(new ComponentName(r9, "com.amap.api.location.APSService"), LynxTouchEvent.kPseudoStateFocusTransition);     // Catch: Throwable -> L13
    L14:
        if (r10 != null) goto L16;
        boolean r11 = false;
    L17:
        if (r11 == true) goto L19;
        String r12 = "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003";
    L20:
        r8.setLocationDetail(r12);     // Catch: Throwable -> L23
        r7.putParcelable("loc", r8);     // Catch: Throwable -> L23
        r5.setData(r7);     // Catch: Throwable -> L23
        r5.what = 1;     // Catch: Throwable -> L23
        this.d.sendMessage(r5);     // Catch: Throwable -> L23
        goto L25
    L19:
        r12 = "启动ApsServcie失败#1001";
        goto L20
    L16:
        r11 = true;
    L13:
        r10 = null;
        goto L14
    L22:
        r3 = true;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v54, types: [android.location.Location, com.loc.es] */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v17, types: [com.amap.api.location.AMapLocation, com.loc.es] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v4, types: [n4a.u3] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.loc.es] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.amap.api.location.AMapLocation] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [com.amap.api.location.AMapLocation, com.loc.es] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r18v0, types: [n4a.x1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void z() {
        b3 r2 = new b3(true);
        this.a = null;
        em r6 = new em();
        r6.a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L135
        String r0 = AMapLocationClientOption.getAPIKEY();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r0) == true) goto L179;
        Context r9 = this.b;     // Catch: Throwable -> L13
        int r10 = com.loc.i.a;     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r0) == true) goto L179;
        v4.d = r0;     // Catch: Throwable -> L13
        if (r9 == null) goto L179;
        k1.d.b(new v4.a(r9, r0));     // Catch: Throwable -> L13
    L179:
        String r1 = UmidtokenInfo.getUmidtoken();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r1) == true) goto L164;
        x4.d = r1;     // Catch: Throwable -> L19
    L164:
        r2.g(this.b);     // Catch: Throwable -> L23
        r2.i(this.c);     // Catch: Throwable -> L23
        r2.o(r6);     // Catch: Throwable -> L23
    L25:
        boolean r11 = com.loc.h.t;     // Catch: Throwable -> L135
    L36:
        th = move-exception;
        c4.g(th, "ALManager", "apscach");     // Catch: Throwable -> L135
    L60:
        ?? r12 = 0;
    L166:
        if (r12 == 0) goto L197;
        ?? r15 = r12;
        boolean r13 = false;
        boolean r17 = false;
    L74:
        if (r15 != 0) goto L187;
        String r3 = null;
        AMapLocation r14 = null;
    L183:
    L86:
        th = move-exception;
        c4.g(th, "ALManager", "fixLastLocation");     // Catch: Throwable -> L133
    L169:
        if (this.z.getCacheCallBack() == false) goto L181;
        e r4 = this.d;     // Catch: Throwable -> L158
        if (r4 == null) goto L181;
        r4.removeMessages(13);     // Catch: Throwable -> L158
    L181:
        Bundle r5 = new Bundle();     // Catch: Throwable -> L116
        if (r14 == null) goto L96;
        r5.putParcelable("loc", r14);     // Catch: Throwable -> L116
        r5.putString("nb", r15.V);     // Catch: Throwable -> L116
        r5.putParcelable("statics", r6);     // Catch: Throwable -> L116
    L96:
        f(r5);     // Catch: Throwable -> L116
        if (r13 == false) goto L115;
        if (r15 == 0) goto L115;
    L109:
        th = th;
        ?? r16 = r15;
    L176:
        c4.g(th, "ALManager", "apsLocation:doFirstAddCache");     // Catch: Throwable -> L113
        r12 = r16;
    L119:
        if (r17 == false) goto L162;
        if (r11 == false) goto L162;
        if (K == true) goto L162;
        K = true;     // Catch: Throwable -> L71
        r2.s();     // Catch: Throwable -> L126
        r2.i(new AMapLocationClientOption().setNeedAddress(false));     // Catch: Throwable -> L126
        r2.e(true, new em());     // Catch: Throwable -> L126
    L126:
        th = move-exception;
        c4.g(th, "ALManager", "apsLocation:doFirstNetLocate 2");     // Catch: Throwable -> L71
    L162:
        r2.t();     // Catch: Throwable -> L130
    L131:
        ?? r18 = r12;
    L142:
        if (u() == false) goto L201;
        Bundle r7 = new Bundle();
        if (r18 != 0) goto L146;
    L150:
        String r8 = "0";
    L151:
        r7.putBundle("optBundle", c4.a(this.c));
        r7.putString("isCacheLoc", r8);
        c(0, r7);
        if (this.i == false) goto L202;
        c(13, null);
        return;
    L202:
        return;
    L146:
        if (r18.getLocationType() != 2) goto L148;
    L149:
        r8 = "1";
        goto L151
    L148:
        if (r18.getLocationType() != 4) goto L150;
    L201:
        return;
    L113:
        th = th;
    L118:
        c4.g(th, "ALManager", "apsLocation:callback");     // Catch: Throwable -> L71
        r12 = r16;
        goto L119
    L100:
        if (r15.getErrorCode() != 0) goto L115;
        if (j4.m(r15) == false) goto L115;
        r16 = r15;
        r2.e.h(r2.w, r2.x, r15, r2.a, true);     // Catch: Throwable -> L107
        r12 = r16;
    L107:
        th = th;
    L115:
        r12 = r15;
    L116:
        th = th;
        r16 = r15;
    L133:
        th = th;
        r12 = r15;
    L132:
        r15 = r12;
    L185:
        c4.g(th, "ALManager", "apsLocation");     // Catch: Throwable -> L155
        r2.t();     // Catch: Throwable -> L140
        r18 = r15;
    L140:
        r18 = r15;
    L155:
        th = move-exception;
        r2.t();     // Catch: Throwable -> L159
    L157:
        throw th;
    L81:
        if (this.c.isLocationCacheEnable() == false) goto L169;
        t4 r19 = this.o;     // Catch: Throwable -> L86
        if (r19 == null) goto L169;
        r14 = r19.a(r14, r3, this.c.getLastLocationLifeCycle());     // Catch: Throwable -> L86
        goto L169
    L187:
        r3 = r15.V;     // Catch: Throwable -> L77
        r14 = r15.clone();     // Catch: Throwable -> L77
    L77:
        th = th;
        goto L185
    L197:
        r12 = r2.e(!r11, r6);     // Catch: Throwable -> L68
        if (r12.getErrorCode() != 0) goto L66;
        boolean r20 = true;
    L67:
        r15 = r12;
        r17 = true;
        r13 = r20;
        goto L74
    L66:
        r20 = false;
        goto L67
    L68:
        th = move-exception;
        c4.g(th, "ALManager", "apsLocation:doFirstNetLocate");     // Catch: Throwable -> L71
        r15 = r12;
        r13 = false;
        r17 = true;
    L71:
        th = th;
        goto L132
    L28:
        if (this.z.getCacheCallBack() == false) goto L51;
        boolean r21 = this.z.getCacheCallBack();     // Catch: Throwable -> L36
        if (this.c.isLocationCacheEnable() == true) goto L173;
    L38:
        ?? r22 = 0;
    L39:
        if (r22 == 0) goto L60;
        if (com.loc.h.e(r22.getTime()) == false) goto L44;
        ?? r23 = r22;
    L58:
        r12 = r23;
        goto L166
    L44:
        if (this.z.getCacheCallBack() == false) goto L60;
        int r110 = this.z.getCacheTimeOut();     // Catch: Throwable -> L36
        long r111 = System.currentTimeMillis() - r22.getTime();     // Catch: Throwable -> L36
        if (r111 <= 0) goto L60;
        if (r111 >= r110) goto L60;
        this.a = r22;     // Catch: Throwable -> L36
        r22.setLocationType(10);     // Catch: Throwable -> L36
        goto L60
    L173:
        r22 = r2.m(r21);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        c4.g(th, "ALManager", "doFirstCacheLoc");     // Catch: Throwable -> L36
        goto L38
    L51:
        if (this.c.isLocationCacheEnable() == true) goto L189;
    L57:
        r23 = 0;
        goto L58
    L189:
        r23 = r2.m(false);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        c4.g(th, "ALManager", "doFirstCacheLoc");     // Catch: Throwable -> L36
        goto L57
    L23:
        th = move-exception;
        c4.g(th, "ALManager", "initApsBase");     // Catch: Throwable -> L135
    L19:
        th = move-exception;
        c4.g(th, "ALManager", "apsLocation setUmidToken");     // Catch: Throwable -> L135
    L13:
        th = move-exception;
        c4.g(th, "ALManager", "apsLocation setAuthKey");     // Catch: Throwable -> L135
    L135:
        th = th;
        r15 = 0;
        goto L185
    }

    public static void s(x1 r2) {
        r2.getClass();
        new em().h = "#2001";     // Catch: Throwable -> L5
        h4.k(null, 2153);     // Catch: Throwable -> L5
        es r0 = new es();     // Catch: Throwable -> L5
        r0.setErrorCode(20);     // Catch: Throwable -> L5
        r0.setLocationDetail("模糊权限下不支持低功耗定位#2001");     // Catch: Throwable -> L5
        r2.r(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        c4.g(th, "ALManager", "apsLocation:callback");
    }

    public static void t(x1 r5) {
        r5.getClass();
    L29:
        th = move-exception;
        c4.g(th, "ALManager", "doLBSLocation");     // Catch: Throwable -> L35
        if (r5.c.isOnceLocation() == true) goto L51;
    L33:
        r5.A();     // Catch: Throwable -> L40
        return;
    L51:
        return;
    L35:
        th = move-exception;
        if (r5.c.isOnceLocation() == true) goto L39;
        r5.A();     // Catch: Throwable -> L41
    L39:
        throw th;
    L4:
        if (J == false) goto L6;
    L25:
        J = false;     // Catch: Throwable -> L29
        r5.F = true;     // Catch: Throwable -> L29
        r5.z();     // Catch: Throwable -> L29
    L27:
        if (r5.c.isOnceLocation() == false) goto L33;
        return;
    L6:
        if (r5.x == false) goto L8;
    L42:
    L18:
        th = move-exception;
        r5.E = true;     // Catch: Throwable -> L29
        c4.g(th, "ALManager", "doLBSLocation reStartService");     // Catch: Throwable -> L29
    L21:
        if (r5.u() == false) goto L27;
        r5.E = false;     // Catch: Throwable -> L29
        Bundle r1 = new Bundle();     // Catch: Throwable -> L29
        r1.putBundle("optBundle", c4.a(r5.c));     // Catch: Throwable -> L29
        r1.putString("d", UmidtokenInfo.getUmidtoken());     // Catch: Throwable -> L29
        if (r5.e.j() == true) goto L27;
        r5.c(1, r1);     // Catch: Throwable -> L29
        goto L27
    L11:
        if (r5.x == false) goto L21;
        if (r5.h == true) goto L21;
        if (r5.E == true) goto L21;
        r5.E = true;     // Catch: Throwable -> L18
        r5.B();     // Catch: Throwable -> L18
        goto L52
    L8:
        if (r5.F == true) goto L42;
    }

    public static void w(x1 r10) {
        q4 r0 = r10.e;
        AMapLocationClientOption r1 = r10.c;
        if (r1 != null) goto L5;
        r0.getClass();
        r1 = new AMapLocationClientOption();
    L5:
        r0.d = r1;
        if (r1.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L11;
        Handler r2 = r0.a;
        if (r2 == null) goto L11;
        r2.removeMessages(8);
    L11:
        if (r0.u == r0.d.getGeoLanguage()) goto L21;
        Object r3 = r0.o;
        monitor-enter(r3);
        q4.J = null;     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L21:
        r0.u = r0.d.getGeoLanguage();
        r10.g.h(r10.c);
        if (r10.i == true) goto L24;
    L26:
        r10.u = r10.c.getLocationMode();
        if (r10.w != null) goto L29;
        return;
    L29:
        if (r10.c.isOnceLocation() == false) goto L31;
        r10.w.c(r10.b, 0);
    L32:
        h4 r4 = r10.w;
        Context r5 = r10.b;
        AMapLocationClientOption r11 = r10.c;
        r4.getClass();
        int r12 = h4.a.a[r11.getLocationMode().ordinal()];     // Catch: Throwable -> L51
        if (r12 != 1) goto L36;
        int r6 = 4;
    L42:
        int r13 = r4.e;     // Catch: Throwable -> L51
        if (r13 != r6) goto L46;
        return;
    L46:
        if (r13 == (-1)) goto L49;
        if (r13 == r6) goto L49;
        long r7 = SystemClock.elapsedRealtime() - r4.f;     // Catch: Throwable -> L51
        long r8 = r4.a.get(r4.e, 0L).longValue();     // Catch: Throwable -> L51
        r4.a.append(r4.e, Long.valueOf(r7 + r8));     // Catch: Throwable -> L51
    L49:
        long r9 = i4.b(r5, "pref1", r4.d[r6], 0);     // Catch: Throwable -> L51
        r4.f = SystemClock.elapsedRealtime() - r9;     // Catch: Throwable -> L51
        r4.e = r6;     // Catch: Throwable -> L51
        return;
    L36:
        if (r12 == 2) goto L40;
        r6 = 3;
        if (r12 == 3) goto L42;
        r6 = -1;
        goto L42
    L40:
        r6 = 5;
    L51:
        th = move-exception;
        c4.g(th, "ReportUtil", "setLocationMode");
        return;
    L31:
        r10.w.c(r10.b, 1);
        goto L32
    L24:
        if (r10.c.getLocationMode().equals(r10.u) == true) goto L26;
        r10.y();
        r10.v();
        goto L26
    }

    public final void f(Bundle r7) {
        AMapLocation r1 = null;
        if (r7 != null) goto L38;
        em r8 = null;
        AMapLocation r2 = null;
    L15:
        q4 r3 = this.e;     // Catch: Throwable -> L28
        if (r3 == null) goto L19;
        r2 = r3.a(r2, this.H);     // Catch: Throwable -> L28
    L19:
        if (this.f != null) goto L21;
    L27:
        AMapLocation r5 = r2;
        th = null;
        r1 = r5;
    L31:
        if (j4.l(r1) == false) goto L34;
        this.y = false;
        h(r1, r8);
        return;
    L34:
        this.y = true;
        Bundle r0 = new Bundle();
        r0.putParcelable("mapLoc", r1);
        r0.putParcelable("entity", r8);
        r0.putSerializable("ex", th);
        d(1034, r0, AutoEndConversationTime.AFTER_10_SECONDS);
        return;
    L21:
        if (j4.l(r2) == true) goto L23;
    L26:
        r2 = this.f.a(r2, this.H);     // Catch: Throwable -> L28
    L28:
        th = th;
    L29:
        c4.g(th, "AmapLocationManager", "resultLbsLocationSuccess");
        goto L31
    L23:
        if (this.c.isNeedAddress() == false) goto L27;
        if (TextUtils.isEmpty(r2.getAdCode()) == false) goto L27;
    L38:
        r7.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L12
        r2 = r7.getParcelable("loc");     // Catch: Throwable -> L12
        r2.getLongitude();     // Catch: Throwable -> L12
        r2.getLatitude();     // Catch: Throwable -> L12
        r2.setProvider("lbs");     // Catch: Throwable -> L12
        this.H = r7.getString("nb");     // Catch: Throwable -> L12
        r8 = (em) r7.getParcelable("statics");     // Catch: Throwable -> L12
        if (r2.getErrorCode() != 0) goto L15;
        q4 r4 = this.e;     // Catch: Throwable -> L28
        if (r4 == null) goto L15;
        r4.x = 0;     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r2.getAdCode()) == true) goto L15;
        q4.J = r2;     // Catch: Throwable -> L28
        u4.B = r2;     // Catch: Throwable -> L28
    L12:
        th = th;
        r8 = null;
        goto L29
    }

    public final void g(WebView r4) {
        if (this.A != null) goto L5;
        this.A = new s4(this.b, r4);
    L5:
        s4 r5 = this.A;
        if (r5.d != null) goto L8;
        return;
    L8:
        if (r5.b != null) goto L11;
        return;
    L11:
        if (r5.g == true) goto L26;
        r5.d.getSettings().setJavaScriptEnabled(true);     // Catch: Throwable -> L21
        r5.d.addJavascriptInterface(r5, "AMapAndroidLoc");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r5.d.getUrl()) == true) goto L17;
        r5.d.reload();     // Catch: Throwable -> L21
    L17:
        if (r5.c != null) goto L19;
        AMapLocationClient r0 = new AMapLocationClient(r5.b);     // Catch: Throwable -> L21
        r5.c = r0;     // Catch: Throwable -> L21
        r0.setLocationListener(r5.h);     // Catch: Throwable -> L21
    L19:
        r5.g = true;     // Catch: Throwable -> L21
        return;
    L27:
        return;
    }

    public final synchronized void p(AMapLocation r6) {
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
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4a.x1.p(com.amap.api.location.AMapLocation):void");
    }

    public static void i(x1 r4, Message r5) {
        r4.getClass();
        AMapLocation r6 = (AMapLocation) r5.obj;     // Catch: Throwable -> L13
        r6.getLongitude();     // Catch: Throwable -> L13
        r6.getLatitude();     // Catch: Throwable -> L13
        if (r4.k == true) goto L6;
    L11:
        r4.h(r6, null);     // Catch: Throwable -> L13
        r4.a(1025);     // Catch: Throwable -> L13
        r4.d(1025, null, 300000);     // Catch: Throwable -> L13
        return;
    L6:
        if (r4.p == null) goto L11;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L13
        r0.putBundle("optBundle", c4.a(r4.c));     // Catch: Throwable -> L13
        r4.c(0, r0);     // Catch: Throwable -> L13
        if (r4.i == false) goto L10;
        r4.c(13, null);     // Catch: Throwable -> L13
    L10:
        r4.k = false;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c4.g(th, "ALManager", "resultGpsLocationSuccess");
    }

    public static void j(x1 r8, AMapLocation r9) {
        r8.getClass();
        boolean r1 = false;
        if (r9.getErrorCode() == 0) goto L7;
        r9.setLocationType(0);     // Catch: Throwable -> L49
    L7:
        if (r9.getErrorCode() != 0) goto L22;
        double r2 = r9.getLatitude();     // Catch: Throwable -> L49
        double r4 = r9.getLongitude();     // Catch: Throwable -> L49
        if (r2 != 0.0d) goto L13;
        if (r4 != 0.0d) goto L13;
    L20:
        h4.l("errorLatLng", r9.toStr());     // Catch: Throwable -> L49
        r9.setLocationType(0);     // Catch: Throwable -> L49
        r9.setErrorCode(8);     // Catch: Throwable -> L49
        r9.setLocationDetail("LatLng is error#0802");     // Catch: Throwable -> L49
    L13:
        if (r2 < (-90.0d)) goto L20;
        if (r2 > 90.0d) goto L20;
        if (r4 < (-180.0d)) goto L20;
        if (r4 > 180.0d) goto L20;
    L22:
        if ("gps".equalsIgnoreCase(r9.getProvider()) == false) goto L24;
    L32:
        r9.setAltitude(((long) (r9.getAltitude() * 100.0d)) / 100.0d);     // Catch: Throwable -> L49
        r9.setBearing((float) (((long) (((double) r9.getBearing()) * 100.0d)) / 100.0d));     // Catch: Throwable -> L49
        r9.setSpeed((float) (((long) (((double) r9.getSpeed()) * 100.0d)) / 100.0d));     // Catch: Throwable -> L49
        r8.l(r9);     // Catch: Throwable -> L49
        if (2 != r9.getLocationType()) goto L36;
    L37:
        long r0 = r9.getTime();     // Catch: Throwable -> L47
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L47
        if (r3 <= r0) goto L40;
        r9.setTime(r3);     // Catch: Throwable -> L47
        goto L40
    L36:
        if (4 == r9.getLocationType()) goto L37;
    L40:
        r9.getProvider();     // Catch: Throwable -> L49
        r9.getLongitude();     // Catch: Throwable -> L49
        r9.getLatitude();     // Catch: Throwable -> L49
        Iterator<AMapLocationListener> r10 = r8.j.iterator();     // Catch: Throwable -> L49
    L41:
        if (r10.hasNext() == false) goto L60;
        r10.next().onLocationChanged(r9);     // Catch: Throwable -> L48
        goto L41
    L60:
        return;
    L24:
        if (r8.e.j() == false) goto L32;
        if (CloudControlInf.NETWORK.equalsIgnoreCase(r9.getProvider()) == true) goto L32;
        u4 r5 = r8.f;     // Catch: Throwable -> L49
        r5.getClass();     // Catch: Throwable -> L49
        if ((SystemClock.elapsedRealtime() - r5.i) > 2800) goto L31;
        r1 = true;
    L31:
        if (r1 == false) goto L32;
        return;
    }

    public static void k(x1 r4, Message r5) {
        r4.getClass();
        AMapLocation r6 = (AMapLocation) r5.obj;     // Catch: Throwable -> L16
        r6.getLongitude();     // Catch: Throwable -> L16
        r6.getLatitude();     // Catch: Throwable -> L16
        if (r4.m == false) goto L12;
        if (r4.p == null) goto L12;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L16
        r0.putBundle("optBundle", c4.a(r4.c));     // Catch: Throwable -> L16
        r4.c(0, r0);     // Catch: Throwable -> L16
        if (r4.i == false) goto L10;
        r4.c(13, null);     // Catch: Throwable -> L16
    L10:
        r4.m = false;     // Catch: Throwable -> L16
    L12:
        if (r4.y == false) goto L14;
        r4.a(1034);     // Catch: Throwable -> L16
        r4.h(r6, null);     // Catch: Throwable -> L16
    L14:
        r4.a(1033);     // Catch: Throwable -> L16
        r4.d(1033, null, 300000);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        c4.g(th, "ALManager", "resultNetworkLocationSuccess");
    }

    public static void m(x1 r3, Message r4) {
        r3.getClass();
        Bundle r5 = r4.getData();     // Catch: Throwable -> L23
        AMapLocation r0 = r5.getParcelable("loc");     // Catch: Throwable -> L23
        String r6 = r5.getString("lastLocNb");     // Catch: Throwable -> L23
        if (r0 == null) goto L20;
        v3 r1 = t4.g;     // Catch: Throwable -> L26
        if (r1 != null) goto L17;
        t4 r2 = r3.o;     // Catch: Throwable -> L26
        AMapLocation r7 = null;
        if (r2 == null) goto L18;
        r2.e();     // Catch: Throwable -> L26
        v3 r8 = t4.g;     // Catch: Throwable -> L26
        if (r8 == null) goto L18;
        if (j4.l(r8.d) == false) goto L18;
        r7 = t4.g.d;     // Catch: Throwable -> L26
    L18:
        h4.j(r7, r0);     // Catch: Throwable -> L26
        goto L20
    L17:
        r7 = r1.d;     // Catch: Throwable -> L26
    L20:
        if (r3.o.c(r0, r6) == false) goto L31;
        r3.o.d();     // Catch: Throwable -> L23
        return;
    L31:
        return;
    L23:
        th = move-exception;
        c4.g(th, "ALManager", "doSaveLastLocation");
    }

    public static void o(x1 r4, Message r5) {
        r4.getClass();
        if (r5 == null) goto L16;
        Bundle r6 = r5.getData();     // Catch: Throwable -> L10
        if (r6 == null) goto L15;
        int r2 = r6.getInt("i", 0);     // Catch: Throwable -> L10
        Notification r7 = (Notification) r6.getParcelable("h");     // Catch: Throwable -> L10
        Intent r3 = r4.C();     // Catch: Throwable -> L10
        r3.putExtra("i", r2);     // Catch: Throwable -> L10
        r3.putExtra("h", r7);     // Catch: Throwable -> L10
        r3.putExtra("g", 1);     // Catch: Throwable -> L10
        r4.e(r3, true);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        c4.g(th, "ALManager", "doEnableBackgroundLocation");
        return;
    }

    public final void c(int r3, Bundle r4) {
        if (r4 != null) goto L5;
        r4 = new Bundle();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if ((th instanceof IllegalStateException) == true) goto L15;
    L17:
        boolean r5 = false;
    L19:
        if ((th instanceof RemoteException) == true) goto L21;
        if (r5 == true) goto L21;
    L22:
        c4.g(th, "ALManager", "sendLocMessage");
        return;
    L21:
        this.p = null;
        this.h = false;
        goto L22
    L15:
        if (th.getMessage().contains("sending message to a Handler on a dead thread") == false) goto L17;
        r5 = true;
    L5:
        if (TextUtils.isEmpty(this.B) == false) goto L7;
        Context r0 = this.b;     // Catch: Throwable -> L11
        String r1 = c4.a;     // Catch: Throwable -> L11
        this.B = b5.a(v4.f(r0));     // Catch: Throwable -> L11
    L7:
        r4.putString("c", this.B);     // Catch: Throwable -> L11
        Message r2 = Message.obtain();     // Catch: Throwable -> L11
        r2.what = r3;     // Catch: Throwable -> L11
        r2.setData(r4);     // Catch: Throwable -> L11
        r2.replyTo = this.q;     // Catch: Throwable -> L11
        Messenger r6 = this.p;     // Catch: Throwable -> L11
        if (r6 == null) goto L26;
        r6.send(r2);     // Catch: Throwable -> L11
        return;
    }

    public final void e(Intent r6, boolean r7) {
        Context r0 = this.b;
        if (r0 == null) goto L32;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 26) goto L25;
        if (r7 == false) goto L25;
        if (r1 >= 28) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L30;
    L19:
        boolean r3 = true;
    L20:
        if (r3 == true) goto L28;
        return;
    L28:
        this.b.getClass().getMethod("startForegroundService", new Class[]{Intent.class}).invoke(this.b, new Object[]{r6});     // Catch: Throwable -> L24
    L26:
        this.I = true;
        return;
    L24:
        this.b.startService(r6);
        goto L26
    L30:
        int r4 = ((Integer) f4.c(((Application) this.b.getApplicationContext()).getBaseContext(), "checkSelfPermission", new Object[]{"android.permission.FOREGROUND_SERVICE"})).intValue();     // Catch: Throwable -> L16
    L17:
        if (r4 == 0) goto L19;
        r3 = false;
    L16:
        r4 = -1;
        goto L17
    L10:
        if (r0.getApplicationInfo().targetSdkVersion < 28) goto L12;
        r2 = true;
    L25:
        r0.startService(r6);
        goto L26
    }

    public final synchronized void h(AMapLocation r9, em r10) {
        monitor-enter(this);
        if (r9 != null) goto L6;
        r9 = new AMapLocation(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L35
        r9.setErrorCode(8);     // Catch: Throwable -> L35
        r9.setLocationDetail("amapLocation is null#0801");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        c4.g(th, "ALManager", "handlerLocation part3");     // Catch: Throwable -> L59
        return;
    L59:
        th = move-exception;
        throw th;
    L6:
        if (this.D != null) goto L8;
        this.D = new AMapLocationQualityReport();     // Catch: Throwable -> L35
    L8:
        this.D.setLocationMode(this.c.getLocationMode());     // Catch: Throwable -> L35
        q4 r0 = this.e;     // Catch: Throwable -> L35
        if (r0 == null) goto L25;
        this.D.setGPSSatellites(r0.q);     // Catch: Throwable -> L35
        AMapLocationQualityReport r1 = this.D;     // Catch: Throwable -> L35
        q4 r2 = this.e;     // Catch: Throwable -> L35
        LocationManager r3 = r2.c;     // Catch: Throwable -> L35
        if (r3 != null) goto L14;
    L15:
        int r5 = 1;
    L24:
        r1.setGpsStatus(r5);     // Catch: Throwable -> L35
        goto L25
    L14:
        if (q4.g(r3) == false) goto L15;
        r5 = 0;
        int r4 = Settings.Secure.getInt(r2.b.getContentResolver(), "location_mode", 0);     // Catch: Throwable -> L35
        if (r4 != 0) goto L19;
        r5 = 2;
        goto L24
    L19:
        if (r4 != 2) goto L22;
        r5 = 3;
        goto L24
    L22:
        if (r2.v == true) goto L24;
        r5 = 4;
    L25:
        this.D.setWifiAble(j4.G(this.b));     // Catch: Throwable -> L35
        this.D.setNetworkType(j4.H(this.b));     // Catch: Throwable -> L35
        if (r9.getLocationType() != 1) goto L28;
    L29:
        this.D.setNetUseTime(0);     // Catch: Throwable -> L35
    L30:
        if (r10 == null) goto L37;
        AMapLocationQualityReport r6 = this.D;     // Catch: Throwable -> L35
        long r7 = r10.d - r10.c;     // Catch: Throwable -> L35
        if (r7 > 0) goto L34;
        r7 = 0;
    L34:
        r6.setNetUseTime(r7);     // Catch: Throwable -> L35
    L37:
        this.D.setInstallHighDangerMockApp(L);     // Catch: Throwable -> L35
        r9.setLocationQualityReport(this.D);     // Catch: Throwable -> L35
    L45:
        th = move-exception;
        c4.g(th, "ALManager", "handlerLocation part2");     // Catch: Throwable -> L35
    L48:
        if (this.t == false) goto L52;
        monitor-exit(this);
        return;
    L52:
        if (this.c.isOnceLocation() == false) goto L54;
        y();     // Catch: Throwable -> L35
        c(14, null);     // Catch: Throwable -> L35
    L54:
        monitor-exit(this);
        return;
    L39:
        if (this.i == false) goto L48;
        String r8 = this.H;     // Catch: Throwable -> L45
        Bundle r11 = new Bundle();     // Catch: Throwable -> L45
        r11.putParcelable("loc", r9);     // Catch: Throwable -> L45
        r11.putString("lastLocNb", r8);     // Catch: Throwable -> L45
        d(1014, r11, 0);     // Catch: Throwable -> L45
        if (r10 == null) goto L43;
        r10.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L45
    L43:
        h4.g(this.b, r9, r10);     // Catch: Throwable -> L45
        h4.f(this.b, r9);     // Catch: Throwable -> L45
        n(r9.clone());     // Catch: Throwable -> L45
        g4.a(this.b).c(r9);     // Catch: Throwable -> L45
        g4.a(this.b).d();     // Catch: Throwable -> L45
    L28:
        if ("gps".equalsIgnoreCase(r9.getProvider()) == false) goto L30;
        goto L29
    }

    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Thread, n4a.x1$d] */
    public x1(Context r5, Intent r6, Looper r7) {
        this.c = new AMapLocationClientOption();
        this.e = null;
        this.f = null;
        this.h = false;
        this.i = false;
        this.j = new ArrayList();
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        this.v = new Object();
        this.w = null;
        this.x = false;
        this.y = false;
        this.z = new AMapLocationClientOption();
        this.A = null;
        this.B = null;
        this.C = new a(this);
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = false;
        this.b = r5;
        this.r = r6;
        if (r7 == null) goto L5;
        this.d = new e(this, r7);     // Catch: Throwable -> L11
    L39:
        this.o = new t4(this.b);     // Catch: Throwable -> L15
    L17:
        ?? r8 = new d(this);     // Catch: Throwable -> L26
        this.s = r8;     // Catch: Throwable -> L26
        ThreadMethodProxy.setPriority(r8, 5);     // Catch: Throwable -> L26
        ThreadMethodProxy.start(this.s);     // Catch: Throwable -> L26
        Looper r9 = this.s.getLooper();     // Catch: Throwable -> L26
        Object r10 = this.v;     // Catch: Throwable -> L26
        monitor-enter(r10);     // Catch: Throwable -> L26
        c r11 = new c(this, r9);     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        this.G = r11;     // Catch: Throwable -> L26
    L42:
        this.e = new q4(this.b, this.d);     // Catch: Throwable -> L30
        this.f = new u4(this.b, this.d);     // Catch: Throwable -> L30
        this.g = new l4(this.b, this.d);     // Catch: Throwable -> L30
    L33:
        if (this.w != null) goto L35;
        this.w = new h4();
    L35:
        Context r12 = this.b;
        if (M.compareAndSet(false, true) == false) goto L46;
        k1.d.b(new w1(r12));
        return;
    L46:
        return;
    L30:
        th = move-exception;
        c4.g(th, "ALManager", "init 3");
        goto L33
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        c4.g(th, "ALManager", "init 5");
    L15:
        th = move-exception;
        c4.g(th, "ALManager", "init 2");     // Catch: Throwable -> L26
        goto L17
    L5:
        if (Looper.myLooper() != null) goto L7;
        e r13 = new e(this, r5.getMainLooper());     // Catch: Throwable -> L11
    L8:
        this.d = r13;     // Catch: Throwable -> L11
        goto L39
    L7:
        r13 = new e(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        c4.g(th, "ALManager", "init 1");
        goto L39
    }
}
