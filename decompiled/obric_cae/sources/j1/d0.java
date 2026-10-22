package j1;

import android.os.Looper;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.libs.softap.CaeSoftApRequestCallback;
import com.obric.cae.libs.softap.CaeSoftApStatusResultCallback;
import com.obric.cae.libs.softap.ICaeSoftApManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8464b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f8465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f8466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f8467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f8468p;

    public /* synthetic */ d0(Object r8, Object r10, Object r11, Object r12, Object r13, int r14) {
        this.f8463a = r14;
        this.f8464b = r8;
        this.f8465m = r10;
        this.f8466n = r11;
        this.f8467o = r12;
        this.f8468p = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f8463a;
        Object r10 = this.f8468p;
        Object r11 = this.f8467o;
        Object r12 = this.f8466n;
        Object r13 = this.f8465m;
        Object r14 = this.f8464b;
        switch(r8) {
            case 0: goto L27;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L54;
        };
    L5:
        CaeSoftApManager.k((CaeSoftApManager) r14, (String) r13, (ICaeSoftApManager) r12, (CaeSoftApManager.e) r11, (CaeSoftApStatusResultCallback) r10);
        return;
    L7:
        LocationOption r15 = (LocationOption) r12;
        List r16 = (List) r11;
        o5.x r17 = (o5.x) r10;
        Looper r18 = o5.g.f9674l;
        ((o5.g) r14).getClass();
        LocationMonitor.lbsLightLocationTraceMetricEnd((LBSLightLocationTraceLogger) r13, LBSLightLocationTraceLogger.SWITCH_THREAD_SECOND_TIME);
        Logger.i("performLBSLightSubmitV2 executed.");
        LBSLightLocationTraceLogger r19 = r15.getLBSLightLocationTraceLogger();
        LocInfoRspData r20 = ServerApi.doLightLocationSubmitV2(r15.startLocationTimestampInMillis, r15.getUploadSource(), r15.getTriggerType(), BDLocationConfig.isEnableLocationOptEncrypt(), r19, r16, r15.getLocateId());     // Catch: Throwable -> L18
        if (r20 == null) goto L60;
        BDLocation r21 = LocationUtil.locationResultToBDLocation(new BDLocation("network", LocationInfoConst.LIGHT), r20.location);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r20.submitLogId) == true) goto L14;
        if (r21 == null) goto L14;
        r21.setSubmitLogId(r20.submitLogId);     // Catch: Throwable -> L18
    L14:
        r15.setLightLocation(r21);     // Catch: Throwable -> L18
        Logger.i("location-trace-core enablePreLocationCallback: " + BDLocationConfig.enablePreLocationCallback());     // Catch: Throwable -> L18
        if (BDLocationConfig.enablePreLocationCallback() == false) goto L61;
        r17.a(r21);     // Catch: Throwable -> L18
        return;
    L61:
        return;
    L60:
        return;
    L18:
        th = move-exception;
        Logger.i("doLightLocationSubmitV2 failed: " + th);
        if (r19 != null) goto L22;
        return;
    L22:
        if (th.getMessage() != null) goto L24;
        String r22 = "empty";
    L25:
        r19.reportLBSLightLocationFailed(BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED, r22);
        return;
    L24:
        r22 = th.getMessage();
        goto L25
    L27:
        b0 r23 = (b0) r14;
        String r24 = (String) r13;
        m r25 = (m) r12;
        ge.a r26 = (ge.a) r11;
        androidx.work.w r27 = (androidx.work.w) r10;
        he.i.f(r23, "$this_enqueueUniquelyNamedPeriodic");
        he.i.f(r24, "$name");
        he.i.f(r25, "$operation");
        he.i.f(r26, "$enqueueNew");
        he.i.f(r27, "$workRequest");
        r1.u r28 = r23.f8453c.f();
        ArrayList r29 = r28.l(r24);
        if (r29.size() <= 1) goto L31;
        String r30 = "Can't apply UPDATE policy to the chains of work.";
    L43:
        r25.a(new androidx.work.p.a.C0026a(new UnsupportedOperationException(r30)));
        return;
    L31:
        if (r29.isEmpty() == false) goto L33;
        Object r31 = null;
    L34:
        r1.t.a r32 = (r1.t.a) r31;
        if (r32 == null) goto L47;
        String r33 = r32.f11359a;
        r1.t r34 = r28.g(r33);
        if (r34 != null) goto L41;
        r25.a(new androidx.work.p.a.C0026a(new IllegalStateException("WorkSpec with " + r33 + ", that matches a name \"" + r24 + "\", wasn't found")));
        return;
    L41:
        if (r34.f() == true) goto L45;
        r30 = "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.";
        goto L43
    L45:
        if (r32.f11360b != androidx.work.u.a.f2957p) goto L48;
        r28.delete(r33);
        goto L47
    L48:
        r1.t r210 = r1.t.b(r27.f2961b, r32.f11359a, null, null, null, 0, 0, 0, 1048574);
        p r35 = r23.f8456f;     // Catch: Throwable -> L51
        he.i.e(r35, "processor");     // Catch: Throwable -> L51
        WorkDatabase r36 = r23.f8453c;     // Catch: Throwable -> L51
        he.i.e(r36, "workDatabase");     // Catch: Throwable -> L51
        androidx.work.c r37 = r23.f8452b;     // Catch: Throwable -> L51
        he.i.e(r37, "configuration");     // Catch: Throwable -> L51
        List<r> r38 = r23.f8455e;     // Catch: Throwable -> L51
        he.i.e(r38, "schedulers");     // Catch: Throwable -> L51
        t2.b.b0(r35, r36, r37, r38, r210, r27.f2962c);     // Catch: Throwable -> L51
        r25.a(androidx.work.p.f2939a);     // Catch: Throwable -> L51
        return;
    L51:
        th = move-exception;
        r25.a(new androidx.work.p.a.C0026a(th));
        return;
    L47:
        r26.f();
        return;
    L33:
        r31 = r29.get(0);
        goto L34
    L54:
        CaeSoftApManager.d((CaeSoftApManager) r14, (String) r13, (ICaeSoftApManager) r12, (CaeSoftApManager.e) r11, (CaeSoftApRequestCallback) r10);
    }
}
