package com.obric.cae.location;

import android.content.Context;
import android.os.ServiceManager;
import com.obric.cae.location.cloud.StarLocationCloudBinderClient;
import com.obric.cae.location.report.StarLocationReportFactory;
import com.obric.cae.location.report.StarLocationReportProto;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes.dex */
public class CaeLocationManager {
    private static final String SERVICE_NAME_STAR_LOCATION = "cae_star_location";
    private static final String TAG = "CaeLocationManager";
    private static CaeLocationManager sInstance;

    private CaeLocationManager() {
    }

    public static synchronized CaeLocationManager getInstance() {
        monitor-enter(CaeLocationManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new CaeLocationManager();     // Catch: Throwable -> L10
    L7:
        CaeLocationManager r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(CaeLocationManager.class);
        return r8;
    }

    public void initOnce(Context r8) {
        CaeLog.d(TAG, "initOnce");
        Context r10 = r8.getApplicationContext();
        new StarLocationCloudBinderClient(r10);
        StarLocationTeaReporter.init(r10);
        StarLocationReportFactory.createReportInstance(StarLocationReportProto.getInstance(r10));
        ServiceManager.addService(SERVICE_NAME_STAR_LOCATION, StarLocationService.getService().getStarLocationServiceBinder());
    }
}
