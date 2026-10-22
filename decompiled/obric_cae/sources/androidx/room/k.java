package androidx.room;

import android.content.Context;
import android.os.Parcelable;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.scan.wifi.WifiInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation_impl.shake.BDShakeCollectService;
import com.bytedance.bdlocation_impl.shake.ShakeUploadCallback;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.libs.softap.CaeSoftApStatus;
import com.obric.cae.libs.softap.CaeSoftApStatusResultCallback;
import com.obric.cae.libs.softap.ICaeSoftApCallback;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.userAware.SplitWifiScanner;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.wifi.CaeWifiDatabaseService;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2651b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2652m;

    public /* synthetic */ k(int r8, Object r10, Object r11) {
        this.f2650a = r8;
        this.f2651b = r10;
        this.f2652m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f2650a) {
            case 0: goto L71;
            case 1: goto L69;
            case 2: goto L62;
            case 3: goto L57;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L23;
            case 9: goto L21;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L15;
            case 13: goto L13;
            case 14: goto L11;
            case 15: goto L9;
            case 16: goto L7;
            case 17: goto L5;
            default: goto L85;
        };
    L5:
        CaeWifiDatabaseService.e((CaeWifiDatabaseService) this.f2651b, (List) this.f2652m);
        return;
    L7:
        UserAwareManager.k((UserAwareManager) this.f2651b, (Parcelable) this.f2652m);
        return;
    L9:
        SplitWifiScanner.a((SplitWifiScanner) this.f2651b, (Set) this.f2652m);
        return;
    L11:
        StarLocationService.d((Runnable) this.f2651b, (String) this.f2652m);
        return;
    L13:
        CaeSoftApManager.r((CaeSoftApManager) this.f2651b, (ICaeSoftApCallback) this.f2652m);
        return;
    L15:
        CaeSoftApManager.a((CaeSoftApStatusResultCallback) this.f2651b, (CaeSoftApStatus) this.f2652m);
        return;
    L17:
        BDShakeCollectService.d((ShakeUploadCallback) this.f2651b, (BDLocationException) this.f2652m);
        return;
    L19:
        o5.x r8 = (o5.x) this.f2651b;
        r8.f9733a.onError((BDLocationException) this.f2652m);
        return;
    L21:
        ((BDLocationCallback) this.f2651b).onLocationChanged((BDLocation) this.f2652m);
        return;
    L23:
        o5.w r10 = (o5.w) this.f2651b;
        Context r11 = (Context) this.f2652m;
        r10.getClass();
        LocationUtil.startGetDimLocation(r11);
        Logger.d("boot upload Location:" + BDLocationConfig.isReportLocationAtStart());
        if ("1".equals(LocationUtil.allowUseLocation(true)) == false) goto L32;
        LocInfoRspData r12 = LocationUtil.uploadDeviceStatus("bdlocation_boot_upload_device_info", 0);
        if (r12 != null) goto L28;
    L33:
        Logger.i("init extra service enable traceroute:" + BDLocationConfig.enableTraceroute());
        if (BDLocationConfig.enableTraceroute() == true) goto L36;
        return;
    L36:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L100;
        BDLocationExtrasService.getTraceRouteManager().init();
        return;
    L100:
        return;
    L28:
        if (r12.isLocate == false) goto L33;
        LocationOption r13 = new LocationOption();
        r13.setUploadSource("bdlocation_boot_upload_location_info");
        r13.setMaxCacheTime(BDLocationConfig.getUploadInterval());
        r13.setTriggerType(0);
        r13.setUpload(true);
        r13.setLocationTimeOutMs(30000);
        r13.setLocateType(BDLocationConfig.getLocateType());
        r13.setBpeaCert(BDLocationConfig.getBpeaCert(LocationInfoConst.COLDSTART_CERT));
        r13.setBpeaAction("getLocation");
        r13.setMode(BDLocationConfig.getLocationMode());
        BDLocation r14 = o5.g.j().n(r13, null);
        o5.g.j().getClass();
        if (o5.g.e(r14, r13, null, true) == true) goto L33;
        defpackage.c.K(r13);
        goto L33
    L32:
        LocationUtil.uploadDeviceStatus("bdlocation_boot_upload_device_info", 0);
        goto L33
    L39:
        WifiInfoManager.f((WifiInfoManager) this.f2651b, (Context) this.f2652m);
        return;
    L41:
        LocationUtil.c((LocationUploadExtra) this.f2651b, (LocationUploadCallback) this.f2652m);
        return;
    L43:
        ((a2.a) this.f2651b).b((BDLocationException) this.f2652m);
        return;
    L45:
        ConstraintTrackingWorker r15 = (ConstraintTrackingWorker) this.f2651b;
        ga.a<? extends androidx.work.l.a> r16 = (ga.a) this.f2652m;
        he.i.f(r15, "this$0");
        he.i.f(r16, "$innerFuture");
        Object r17 = r15.f2921b;
        monitor-enter(r17);
    L54:
        th = move-exception;
        throw th;
    L48:
        if (r15.f2922m == false) goto L50;
        t1.c<androidx.work.l.a> r18 = r15.f2923n;     // Catch: Throwable -> L54
        he.i.e(r18, "future");     // Catch: Throwable -> L54
        String r19 = v1.a.f12704a;     // Catch: Throwable -> L54
        r18.j(new androidx.work.l.a.b());     // Catch: Throwable -> L54
    L51:
        xd.j r20 = xd.j.f13877a;     // Catch: Throwable -> L54
        monitor-exit(r17);
        return;
    L50:
        r15.f2923n.i(r16);     // Catch: Throwable -> L54
        goto L51
    L57:
        List r21 = (List) this.f2651b;
        p1.h r22 = (p1.h) this.f2652m;
        he.i.f(r21, "$listenersList");
        he.i.f(r22, "this$0");
        Iterator r23 = r21.iterator();
    L59:
        if (r23.hasNext() == false) goto L61;
        ((n1.a) r23.next()).a(r22.f9926e);
        goto L59
    L61:
        return;
    L62:
        Runnable r24 = (Runnable) this.f2651b;
        y r25 = (y) this.f2652m;
        he.i.f(r24, "$command");
        he.i.f(r25, "this$0");
        r24.run();     // Catch: Throwable -> L66
        r25.a();
        return;
    L66:
        th = move-exception;
        r25.a();
        throw th;
    L69:
        n r26 = (n) this.f2651b;
        String r27 = (String) this.f2652m;
        he.i.f(r26, "this$0");
        he.i.f(r27, "$query");
        throw null;
    L71:
        MultiInstanceInvalidationClient r28 = (MultiInstanceInvalidationClient) this.f2651b;
        String[] r29 = (String[]) this.f2652m;
        int r30 = MultiInstanceInvalidationClient$callback$1.f2594b;
        he.i.f(r28, "this$0");
        he.i.f(r29, "$tables");
        i r31 = r28.f2581b;
        String[] r32 = (String[]) Arrays.copyOf(r29, r29.length);
        r31.getClass();
        he.i.f(r32, "tables");
        j.b<i.c, i.d> r33 = r31.f2633k;
        monitor-enter(r33);
        Iterator<Map.Entry<i.c, i.d>> r34 = r31.f2633k.iterator();     // Catch: Throwable -> L82
    L74:
        j.b.e r35 = (j.b.e) r34;     // Catch: Throwable -> L82
        if (r35.hasNext() == false) goto L79;
        Map.Entry r36 = (Map.Entry) r35.next();     // Catch: Throwable -> L82
        he.i.e(r36, "(observer, wrapper)");     // Catch: Throwable -> L82
        i.c r37 = (i.c) r36.getKey();     // Catch: Throwable -> L82
        i.d r38 = (i.d) r36.getValue();     // Catch: Throwable -> L82
        r37.getClass();     // Catch: Throwable -> L82
        if ((r37 instanceof MultiInstanceInvalidationClient.a) == true) goto L74;
        r38.b(r32);     // Catch: Throwable -> L82
        goto L74
    L79:
        xd.j r39 = xd.j.f13877a;     // Catch: Throwable -> L82
        monitor-exit(r33);
        return;
    L82:
        th = move-exception;
        throw th;
    L85:
        AsyncTask.b((AsyncTask) this.f2651b, this.f2652m);
    }
}
