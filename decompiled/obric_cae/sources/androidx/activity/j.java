package androidx.activity;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.z0;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.obric.cae.cloud.CloudService;
import com.obric.cae.connectivity.CaeCollectionStrategyManager;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipAppManager;
import com.obric.cae.smartNetwork.networkHandover.HandoverParameterManager;
import com.obric.cae.smartNetwork.networkHandover.NetworkUnswitchLimiter;
import com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchPolicyML;
import com.obric.cae.smartNetwork.networkHandoverRL.feedback.WifiCellSwitchMonitor;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluate;
import com.obric.cae.smartNfc.ReverseChargingNfcController;
import j1.b0;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import o5.x;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f488b;

    public /* synthetic */ j(Object r8, int r10) {
        this.f487a = r10;
        this.f488b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r8 = true;
        androidx.appcompat.view.menu.h r10 = null;
        switch(this.f487a) {
            case 0: goto L129;
            case 1: goto L122;
            case 2: goto L120;
            case 3: goto L118;
            case 4: goto L109;
            case 5: goto L103;
            case 6: goto L101;
            case 7: goto L99;
            case 8: goto L86;
            case 9: goto L84;
            case 10: goto L45;
            case 11: goto L43;
            case 12: goto L41;
            case 13: goto L39;
            case 14: goto L31;
            case 15: goto L29;
            case 16: goto L27;
            case 17: goto L25;
            case 18: goto L23;
            case 19: goto L21;
            case 20: goto L19;
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L13;
            case 24: goto L11;
            case 25: goto L9;
            case 26: goto L7;
            case 27: goto L5;
            default: goto L133;
        };
    L5:
        CellularQoeEvaluate.a((CellularQoeEvaluate) this.f488b);
        return;
    L7:
        WifiCellSwitchMonitor.a((WifiCellSwitchMonitor) this.f488b);
        return;
    L9:
        NetworkSwitchPolicyML.a((NetworkSwitchPolicyML) this.f488b);
        return;
    L11:
        NetworkUnswitchLimiter.a((NetworkUnswitchLimiter) this.f488b);
        return;
    L13:
        HandoverParameterManager.a((HandoverParameterManager) this.f488b);
        return;
    L15:
        VipAppManager.a((VipAppManager) this.f488b);
        return;
    L17:
        LocationUtil.d((LocationUtil) this.f488b);
        return;
    L19:
        StarPoiManager.b((StarPoiManager) this.f488b);
        return;
    L21:
        CaeSoftApManager.g((CaeSoftApManager) this.f488b);
        return;
    L23:
        CaeCollectionStrategyManager.a((CaeCollectionStrategyManager) this.f488b);
        return;
    L25:
        CloudService.b((CloudService) this.f488b);
        return;
    L27:
        ((CarouselLayoutManager) this.f488b).T0();
        return;
    L29:
        Map.Entry r11 = (Map.Entry) this.f488b;
        AtomicLong r12 = w8.e.f13069a;
        ((Executor) r11.getValue()).execute((Runnable) r11.getKey());
        return;
    L31:
        x r13 = (x) this.f488b;
        LocationOption r14 = r13.f9735c;
        if (r14.getSysLocation() != null) goto L34;
        BDLocation r15 = r14.getGpsLocation();
    L35:
        if (r15 == null) goto L37;
        r13.j(r15);
        return;
    L37:
        r13.onError(new BDLocationException("ByteLocationDownGradeLocationError", LocationInfoConst.SYSTEM, BDLocationException.ERROR_DOWNGRADE_LOCATION));
        return;
    L34:
        r15 = r14.getSysLocation();
        goto L35
    L39:
        com.bytedance.bdlocation.LocationUtil.startGetDimLocation(((o5.t) this.f488b).f9718a.f9725b);
        return;
    L41:
        ((o5.w) this.f488b).b();
        Logger.i("outerBackgroundTask upload info");
        com.bytedance.bdlocation.LocationUtil.uploadDeviceStatus("bdlocation_background_switch", 0);
        return;
    L43:
        defpackage.c r16 = (defpackage.c) this.f488b;
        he.i.f(r16, "this$0");
        r16.getClass();
        return;
    L45:
        ConstraintTrackingWorker r17 = (ConstraintTrackingWorker) this.f488b;
        he.i.f(r17, "this$0");
        if ((r17.f2923n.f12216a instanceof t1.a.b) == true) goto L140;
        String r18 = r17.getInputData().d("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        androidx.work.m r19 = androidx.work.m.d();
        he.i.e(r19, "get()");
        if (r18 != null) goto L51;
    L54:
        if (r8 == false) goto L56;
        r19.b(v1.a.f12704a, "No worker to delegate to.");
    L61:
        t1.c<androidx.work.l.a> r20 = r17.f2923n;
        he.i.e(r20, "future");
        String r21 = v1.a.f12704a;
        r20.j(new androidx.work.l.a.C0025a());
        return;
    L56:
        androidx.work.l r22 = r17.getWorkerFactory().a(r17.getApplicationContext(), r18, r17.f2920a);
        r17.f2924o = r22;
        if (r22 != null) goto L59;
        r19.a(v1.a.f12704a, "No worker to delegate to.");
        goto L61
    L59:
        b0 r23 = b0.f(r17.getApplicationContext());
        he.i.e(r23, "getInstance(applicationContext)");
        r1.u r24 = r23.f8453c.f();
        String r25 = r17.getId().toString();
        he.i.e(r25, "id.toString()");
        r1.t r26 = r24.g(r25);
        if (r26 == null) goto L61;
        p.c r27 = r23.f8460j;
        he.i.e(r27, "workManagerImpl.trackers");
        n1.d r28 = new n1.d(r27, r17);
        r28.d(l6.a.k0(r26));
        String r29 = r17.getId().toString();
        he.i.e(r29, "id.toString()");
        if (r28.c(r29) == false) goto L82;
        r19.a(v1.a.f12704a, "Constraints met for delegate " + r18);
        androidx.work.l r30 = r17.f2924o;     // Catch: Throwable -> L67
        he.i.c(r30);     // Catch: Throwable -> L67
        ga.a<androidx.work.l.a> r31 = r30.startWork();     // Catch: Throwable -> L67
        he.i.e(r31, "delegate!!.startWork()");     // Catch: Throwable -> L67
        r31.a(r17.getBackgroundExecutor(), new androidx.room.k(4, r17, r31));     // Catch: Throwable -> L67
        return;
    L67:
        th = move-exception;
        String r32 = v1.a.f12704a;
        String r33 = defpackage.b.d("Delegated worker ", r18, " threw exception in startWork.");
        if (((androidx.work.m.a) r19).f2930c > 3) goto L72;
        Log.d(r32, r33, th);
    L72:
        monitor-enter(r17.f2921b);
    L79:
        th = move-exception;
        throw th;
    L74:
        if (r17.f2922m == false) goto L76;
        r19.a(r32, "Constraints were unmet, Retrying.");     // Catch: Throwable -> L79
        t1.c<androidx.work.l.a> r34 = r17.f2923n;     // Catch: Throwable -> L79
        he.i.e(r34, "future");     // Catch: Throwable -> L79
        r34.j(new androidx.work.l.a.b());     // Catch: Throwable -> L79
        return;
    L76:
        t1.c<androidx.work.l.a> r35 = r17.f2923n;     // Catch: Throwable -> L79
        he.i.e(r35, "future");     // Catch: Throwable -> L79
        r35.j(new androidx.work.l.a.C0025a());     // Catch: Throwable -> L79
        return;
    L82:
        r19.a(v1.a.f12704a, "Constraints not met for delegate " + r18 + ". Requesting retry.");
        t1.c<androidx.work.l.a> r36 = r17.f2923n;
        he.i.e(r36, "future");
        r36.j(new androidx.work.l.a.b());
        return;
    L51:
        if (r18.length() == 0) goto L54;
        r8 = false;
        goto L54
    L140:
        return;
    L84:
        androidx.work.impl.background.systemalarm.c.b((androidx.work.impl.background.systemalarm.c) this.f488b);
        return;
    L86:
        androidx.room.v r37 = (androidx.room.v) this.f488b;
        int r38 = androidx.room.v.f2701v;
        he.i.f(r37, "this$0");
        if (r37.f2100c <= 0) goto L89;
        boolean r39 = true;
    L91:
        if (r37.f2707q.compareAndSet(false, true) == false) goto L144;
        if (r39 == false) goto L145;
        boolean r40 = r37.f2704n;
        androidx.room.r r41 = r37.f2702l;
        if (r40 == false) goto L96;
        Executor r42 = r41.getTransactionExecutor();
    L97:
        r42.execute(r37.f2710t);
        return;
    L96:
        r42 = r41.getQueryExecutor();
        goto L97
    L145:
        return;
    L144:
        return;
    L89:
        r39 = false;
        goto L91
    L99:
        he.i.f((androidx.room.p) this.f488b, "this$0");
        throw null;
    L101:
        he.i.f((androidx.room.n) this.f488b, "this$0");
        throw null;
    L103:
        MultiInstanceInvalidationClient r43 = (MultiInstanceInvalidationClient) this.f488b;
        he.i.f(r43, "this$0");
        androidx.room.i.c r44 = r43.f2585f;
        if (r44 == null) goto L107;
        r43.f2581b.d(r44);
        return;
    L107:
        he.i.j("observer");
        throw null;
    L109:
        androidx.lifecycle.w r45 = (androidx.lifecycle.w) this.f488b;
        androidx.lifecycle.w r46 = androidx.lifecycle.w.f2195r;
        he.i.f(r45, "this$0");
        if (r45.f2197b != 0) goto L113;
        r45.f2198m = true;
        r45.f2201p.f(androidx.lifecycle.h.a.ON_PAUSE);
    L113:
        if (r45.f2196a == 0) goto L115;
        return;
    L115:
        if (r45.f2198m == false) goto L147;
        r45.f2201p.f(androidx.lifecycle.h.a.ON_STOP);
        r45.f2199n = true;
        return;
    L147:
        return;
    L118:
        View r47 = (View) this.f488b;
        ((InputMethodManager) r47.getContext().getSystemService("input_method")).showSoftInput(r47, 0);
        return;
    L120:
        ((z0) this.f488b).a();
        throw null;
    L122:
        Toolbar.f r48 = ((Toolbar) this.f488b).W;
        if (r48 == null) goto L126;
        r10 = r48.f1081b;
    L126:
        if (r10 == null) goto L148;
        r10.collapseActionView();
        return;
    L148:
        return;
    L129:
        ComponentActivity.f r49 = (ComponentActivity.f) this.f488b;
        Runnable r50 = r49.f445b;
        if (r50 == null) goto L149;
        r50.run();
        r49.f445b = null;
        return;
    L149:
        return;
    L133:
        ReverseChargingNfcController.c((ReverseChargingNfcController) this.f488b);
    }
}
