package com.obric.cae.smartNetwork.networkHandover;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class ScenarioMonitor {
    private static final long RESET_TO_NORMAL_DELAY_MS = 60000;
    public static final int SCENARIO_NEAR_ELEVATOR = 3;
    public static final int SCENARIO_NORMAL = 0;
    public static final int SCENARIO_OUT_COMPANY = 2;
    public static final int SCENARIO_OUT_HOME = 1;
    private static final String SETTINGS_GLOBAL_USER_LOCATION_CHANGE = "user_location_state_change";
    private static final String TAG = "ScenarioMonitor";
    private static volatile ScenarioMonitor sInstance;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private volatile int mCurrentScenario;
    private final BroadcastReceiver mElevatorReceiver;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final LocationChangeObserver mLocationChangeObserver;
    private final Runnable mResetToNormalRunnable;

    public class LocationChangeObserver extends ContentObserver {
        final /* synthetic */ ScenarioMonitor this$0;

        public LocationChangeObserver(ScenarioMonitor r8, Handler r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            super.onChange(r8, r10);
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.equals(Settings.Global.getUriFor("user_location_state_change")) == false) goto L9;
            ScenarioMonitor.access$100(this.this$0);
            return;
        }
    }

    private ScenarioMonitor(Context r10) {
        this.mCurrentScenario = 0;
        this.mResetToNormalRunnable = new AnonymousClass1(this);
        BroadcastReceiver r8 = new AnonymousClass2(this);
        this.mElevatorReceiver = r8;
        this.mContext = r10;
        ContentResolver r11 = r10.getContentResolver();
        this.mContentResolver = r11;
        HandlerThread r12 = new HandlerThread(TAG);
        this.mHandlerThread = r12;
        r12.start();
        Handler r13 = new Handler(r12.getLooper());
        this.mHandler = r13;
        LocationChangeObserver r14 = new LocationChangeObserver(this, r13);
        this.mLocationChangeObserver = r14;
        r11.registerContentObserver(Settings.Global.getUriFor("user_location_state_change"), false, r14);
        r10.registerReceiver(r8, new IntentFilter(NetworkUtil.ACTION_CAE_NEAR_ELEVATOR), NetworkUtil.ACTION_CAE_NEAR_ELEVATOR_PERMISSION, null, 4);
        CaeLog.i(TAG, "ScenarioMonitor initialized");
    }

    public static /* synthetic */ void access$000(ScenarioMonitor r8, int r10) {
        r8.updateScenario(r10);
    }

    public static /* synthetic */ void access$100(ScenarioMonitor r8) {
        r8.handleUserLocationStateChange();
    }

    public static ScenarioMonitor getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(ScenarioMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ScenarioMonitor(r8.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ScenarioMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handleUserLocationStateChange() {
        String r8 = Settings.Global.getString(this.mContentResolver, "user_location_state_change");
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "handleUserLocationStateChange: locationStateChangeValue is null");
        return;
    L6:
        CaeLog.i(TAG, "Location state changed: ".concat(r8));
        byte r10 = -1;
        switch(r8.hashCode()) {
            case -498341474: goto L22;
            case 54091568: goto L18;
            case 687039628: goto L14;
            case 771441502: goto L10;
            default: goto L25;
        };
    L25:
        switch(r10) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L29;
            default: goto L33;
        };
    L27:
        updateScenario(2);
        return;
    L28:
        updateScenario(1);
        return;
    L29:
        updateScenario(0);
        return;
    L33:
        return;
    L10:
        if (r8.equals("into_home") == false) goto L25;
        r10 = 3;
        goto L25
    L14:
        if (r8.equals("out_company") == false) goto L25;
        r10 = 2;
        goto L25
    L18:
        if (r8.equals("out_home") == false) goto L25;
        r10 = 1;
        goto L25
    L22:
        if (r8.equals("into_company") == false) goto L25;
        r10 = 0;
        goto L25
    }

    private String scenarioToString(int r8) {
        if (r8 != 1) goto L5;
        return "SCENARIO_OUT_HOME";
    L5:
        if (r8 != 2) goto L7;
        return "SCENARIO_OUT_COMPANY";
    L7:
        if (r8 == 3) goto L10;
        return "SCENARIO_NORMAL";
    L10:
        return "SCENARIO_NEAR_ELEVATOR";
    }

    private void updateScenario(int r8) {
        if (this.mCurrentScenario == r8) goto L12;
        StringBuilder r10 = new StringBuilder("Scenario changed from ");
        r10.append(scenarioToString(this.mCurrentScenario));
        r10.append(" to ");
        android.aimedia.a.r(r10, scenarioToString(r8), TAG);
        this.mHandler.removeCallbacks(this.mResetToNormalRunnable);
        this.mCurrentScenario = r8;
        if (r8 != 1) goto L7;
    L10:
        CaeLog.i(TAG, "Scheduling reset to normal in 60 seconds");
        this.mHandler.postDelayed(this.mResetToNormalRunnable, 60000);
        return;
    L7:
        if (r8 == 2) goto L10;
        if (r8 == 3) goto L10;
        return;
    }

    public boolean isAggressiveScenario() {
        if (this.mCurrentScenario != 1) goto L5;
        return true;
    L5:
        if (this.mCurrentScenario != 2) goto L7;
        return true;
    L7:
        if (this.mCurrentScenario == 3) goto L13;
        return false;
    L13:
        return true;
    }
}
