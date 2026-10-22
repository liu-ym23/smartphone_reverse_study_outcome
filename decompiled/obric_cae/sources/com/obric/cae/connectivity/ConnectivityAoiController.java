package com.obric.cae.connectivity;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.obric.cae.smartNetwork.CloudConfigParseAndSave;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;

/* JADX INFO: loaded from: classes.dex */
public class ConnectivityAoiController {
    private static final String TAG = "ConnAoiCtrl";
    private static ConnectivityAoiController sInstance;
    private final InnerAwareInfoCallback mAoiCallback;
    private Context mContext;
    private boolean mIsRegistered;

    public ConnectivityAoiController() {
        this.mIsRegistered = false;
        this.mAoiCallback = new AnonymousClass1(this);
    }

    public static /* synthetic */ Context access$000(ConnectivityAoiController r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void access$100(ConnectivityAoiController r8, String r10) {
        r8.handleEnterAoi(r10);
    }

    public static ConnectivityAoiController getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new ConnectivityAoiController();
    L6:
        return sInstance;
    }

    private void handleEnterAoi(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        AoiCollectQuotaManager r10 = AoiCollectQuotaManager.getInstance(this.mContext);
        int r11 = Settings.Global.getInt(this.mContext.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_DAILY_MAX_AOI_COUNT, 2);
        if (r10.getAoiEnterCount(r8) == 0) goto L7;
    L10:
        int r12 = Settings.Global.getInt(this.mContext.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_AOI_COLLECT_MAX_ENTER_COUNT_PER_AOI, 1);
        if (r10.getAoiEnterCount(r8) < r12) goto L14;
        Log.i(TAG, "Already entered AOI (" + r8 + ") today limit reached (" + r12 + "). Skip collection.");
        return;
    L14:
        r10.incrementAoiEnterCount(r8);
        CaeCollectionStrategyManager.getInstance().onEnterAoi(this.mContext, r8);
        return;
    L7:
        if (r10.getDailyEnteredAoiCount() < r11) goto L10;
        Log.i(TAG, "Daily max AOI count limit reached (" + r11 + "). Skip collection for new AOI: " + r8);
    }

    public void init(Context r8) {
        if (this.mIsRegistered == true) goto L8;
        if (r8 == null) goto L9;
        this.mContext = r8.getApplicationContext();
        CaeWifiScanInfoReport.getInstance().init(this.mContext);
        CaeBleScanInfoReport.getInstance().init(this.mContext);
        CaeCellularInfoReport.getInstance().init(this.mContext);
        CaeGnssInfoReport.getInstance().init(this.mContext);
        UserAwareManager.getInstance().registerInnerCallback(this.mAoiCallback);
        this.mIsRegistered = true;
        Log.i(TAG, "ConnectivityAoiController registered as AOI listener.");
        return;
    L9:
        return;
    }
}
