package com.obric.cae.smartBluetooth.deviceIdentification.bdim;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.BluetoothDeviceInfoExt;

/* JADX INFO: loaded from: classes.dex */
public final class BdimFeatureController {
    public static final String SETTINGS_GLOBAL_BDIM_FEATURE_ENABLED = "cae_bdim_feature_enabled";
    private static final String TAG = "BdimFeatureController";
    private static volatile BdimFeatureController sInstance;
    private final Context mContext;
    private boolean mFeatureEnabled;
    private final Object mLock;
    private final ContentObserver mSettingsObserver;
    private boolean mStarted;

    private BdimFeatureController(Context r8) {
        this.mLock = new Object();
        this.mContext = r8.getApplicationContext();
        final Handler r10 = new Handler(Looper.getMainLooper());
        this.mSettingsObserver = new AnonymousClass1(this, r10);
    }

    public static /* synthetic */ void access$000(BdimFeatureController r8) {
        r8.onFeatureSwitchChanged();
    }

    public static BdimFeatureController getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(BdimFeatureController.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BdimFeatureController(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BdimFeatureController.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void onFeatureSwitchChanged() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        boolean r10 = readFeatureEnabled();     // Catch: Throwable -> L15
        if (this.mFeatureEnabled != r10) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L8:
        this.mFeatureEnabled = r10;     // Catch: Throwable -> L15
        CaeLog.i(TAG, "feature switch changed: " + r10);     // Catch: Throwable -> L15
        BluetoothDeviceIdentificationModel r11 = BluetoothDeviceInfoExt.getInstance(this.mContext).getBdimModel();     // Catch: Throwable -> L15
        if (r11 == null) goto L13;
        if (r10 == false) goto L12;
        r11.initialize(this.mContext, "device_classification_dnn.tflite");     // Catch: Throwable -> L15
        goto L13
    L12:
        r11.close();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private boolean readFeatureEnabled() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_BDIM_FEATURE_ENABLED, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void registerSettingsObserverLocked() {
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SETTINGS_GLOBAL_BDIM_FEATURE_ENABLED), false, this.mSettingsObserver);     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.w(TAG, "register settings observer failed: " + e);
    }

    private void unregisterSettingsObserverLocked() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mSettingsObserver);     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.w(TAG, "unregister settings observer failed: " + e);
    }

    public void initPropertyIfNeeded() {
        if (this.mContext.getResources().getBoolean(R.bool.cae_supported_bt_identification_ml) == true) goto L7;
        CaeLog.d(TAG, "cae_supported_bt_Identification_ml is false, disabling ML feature");
        ContentResolver r8 = this.mContext.getContentResolver();
        int r10 = 0;
    L5:
        Settings.Global.putInt(r8, SETTINGS_GLOBAL_BDIM_FEATURE_ENABLED, r10);
        syncFeatureState();
        return;
    L7:
        if (Settings.Global.getString(this.mContext.getContentResolver(), SETTINGS_GLOBAL_BDIM_FEATURE_ENABLED) != null) goto L10;
        CaeLog.d(TAG, "Initializing cae_bdim_feature_enabled property");
        r8 = this.mContext.getContentResolver();
        r10 = 1;
        goto L5
    }

    public boolean isFeatureEnabled() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        boolean r10 = this.mFeatureEnabled;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public void start() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        this.mStarted = true;     // Catch: Throwable -> L11
        registerSettingsObserverLocked();     // Catch: Throwable -> L11
        this.mFeatureEnabled = readFeatureEnabled();     // Catch: Throwable -> L11
        CaeLog.i(TAG, "start, feature enabled=" + this.mFeatureEnabled);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }

    public void stop() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        this.mStarted = false;     // Catch: Throwable -> L11
        unregisterSettingsObserverLocked();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }

    public void syncFeatureState() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mFeatureEnabled = readFeatureEnabled();     // Catch: Throwable -> L7
        CaeLog.i(TAG, "syncFeatureState manually, feature enabled=" + this.mFeatureEnabled);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
