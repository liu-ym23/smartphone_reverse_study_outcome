package com.obric.cae.userAware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.libs.useraware.UserAwareAdapter;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes2.dex */
public class HarEventTestTool {
    private static final String ACTION_SET_HAR_MONITOR_PARAMS = "com.obric.cae.test.SET_HAR_MONITOR_PARAMS";
    private static final String ACTION_TEST_HAR_EVENT = "com.obric.cae.test.HAR_EVENT";
    private static final String EXTRA_ACCEL_OCCURRENCE_THRESHOLD = "accelOccurrenceThreshold";
    private static final String EXTRA_ACC_STATE_DURATION_THRESHOLD = "accStateDurationThreshold";
    private static final String EXTRA_ACC_STATE_DURATION_THRESHOLD2 = "accStateDurationThreshold2";
    private static final String EXTRA_ACC_STATE_MONITOR_WINDOW = "accStateMonitorWindow";
    private static final String EXTRA_EVENT = "event";
    private static final String EXTRA_HELP = "help";
    private static final String EXTRA_RUNNING_CONTINUOUS_THRESHOLD = "runningContinuousThreshold";
    private static final String EXTRA_RUNNING_STATE_DURATION_THRESHOLD = "runningStateDurationThreshold";
    private static final String EXTRA_RUNNING_STATE_DURATION_THRESHOLD2 = "runningStateDurationThreshold2";
    private static final String EXTRA_RUNNING_STATE_MONITOR_WINDOW = "runningStateMonitorWindow";
    private static final String EXTRA_STATE_VOTE_WINDOW_SIZE = "stateVoteWindowSize";
    private static final String EXTRA_STATIONARY_CONTINUOUS_THRESHOLD = "stationaryContinuousThreshold";
    private static final String EXTRA_STATIONARY_OCCURRENCE_THRESHOLD = "stationaryOccurrenceThreshold";
    private static final String EXTRA_TIMESTAMP = "timestamp";
    private static final String EXTRA_WALKING_CONTINUOUS_THRESHOLD = "walkingContinuousThreshold";
    private static final String EXTRA_WALKING_STATE_DURATION_THRESHOLD = "walkingStateDurationThreshold";
    private static final String EXTRA_WALKING_STATE_DURATION_THRESHOLD2 = "walkingStateDurationThreshold2";
    private static final String EXTRA_WALKING_STATE_MONITOR_WINDOW = "walkingStateMonitorWindow";
    private static final String TAG = "HarEventTestTool";
    private final Context mContext;
    private boolean mIsRegistered;
    private TestToolListener mListener;
    private final TestBroadcastReceiver mTestReceiver;

    /* JADX INFO: renamed from: com.obric.cae.userAware.HarEventTestTool$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class TestBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ HarEventTestTool this$0;

        private TestBroadcastReceiver(HarEventTestTool r8) {
            this.this$0 = r8;
        }

        private void handleSetHarMonitorParams(Intent r8) {
            CommSenseLog.i(HarEventTestTool.TAG, "Received set HAR monitor params command");
            if (r8.getBooleanExtra(HarEventTestTool.EXTRA_HELP, false) == false) goto L6;
            HarEventTestTool.printHelp();
            return;
        L6:
            HarMonitorParams r10 = new HarMonitorParams();
            r10.stateVoteWindowSize = r8.getIntExtra(HarEventTestTool.EXTRA_STATE_VOTE_WINDOW_SIZE, r10.stateVoteWindowSize);
            r10.walkingContinuousThreshold = r8.getIntExtra(HarEventTestTool.EXTRA_WALKING_CONTINUOUS_THRESHOLD, r10.walkingContinuousThreshold);
            r10.runningContinuousThreshold = r8.getIntExtra(HarEventTestTool.EXTRA_RUNNING_CONTINUOUS_THRESHOLD, r10.runningContinuousThreshold);
            r10.accelOccurrenceThreshold = r8.getIntExtra(HarEventTestTool.EXTRA_ACCEL_OCCURRENCE_THRESHOLD, r10.accelOccurrenceThreshold);
            r10.stationaryOccurrenceThreshold = r8.getIntExtra(HarEventTestTool.EXTRA_STATIONARY_OCCURRENCE_THRESHOLD, r10.stationaryOccurrenceThreshold);
            r10.accStateDurationThreshold = r8.getIntExtra(HarEventTestTool.EXTRA_ACC_STATE_DURATION_THRESHOLD, r10.accStateDurationThreshold);
            r10.accStateMonitorWindow = r8.getIntExtra(HarEventTestTool.EXTRA_ACC_STATE_MONITOR_WINDOW, r10.accStateMonitorWindow);
            r10.accStateDurationThreshold2 = r8.getIntExtra(HarEventTestTool.EXTRA_ACC_STATE_DURATION_THRESHOLD2, r10.accStateDurationThreshold2);
            r10.runningStateDurationThreshold = r8.getIntExtra(HarEventTestTool.EXTRA_RUNNING_STATE_DURATION_THRESHOLD, r10.runningStateDurationThreshold);
            r10.runningStateMonitorWindow = r8.getIntExtra(HarEventTestTool.EXTRA_RUNNING_STATE_MONITOR_WINDOW, r10.runningStateMonitorWindow);
            r10.runningStateDurationThreshold2 = r8.getIntExtra(HarEventTestTool.EXTRA_RUNNING_STATE_DURATION_THRESHOLD2, r10.runningStateDurationThreshold2);
            r10.walkingStateMonitorWindow = r8.getIntExtra(HarEventTestTool.EXTRA_WALKING_STATE_MONITOR_WINDOW, r10.walkingStateMonitorWindow);
            r10.walkingStateDurationThreshold = r8.getIntExtra(HarEventTestTool.EXTRA_WALKING_STATE_DURATION_THRESHOLD, r10.walkingStateDurationThreshold);
            r10.walkingStateDurationThreshold2 = r8.getIntExtra(HarEventTestTool.EXTRA_WALKING_STATE_DURATION_THRESHOLD2, r10.walkingStateDurationThreshold2);
            this.this$0.setHarMonitorParams(r10);
        }

        private void handleTestCommand(Intent r8) {
            CommSenseLog.i(HarEventTestTool.TAG, "Received test command");
            if (r8.getBooleanExtra(HarEventTestTool.EXTRA_HELP, false) == false) goto L6;
            HarEventTestTool.printHelp();
            return;
        L6:
            int r10 = r8.getIntExtra(HarEventTestTool.EXTRA_EVENT, -1);
            if (r10 != (-1)) goto L10;
            CommSenseLog.e(HarEventTestTool.TAG, "Invalid event: " + r10);
            HarEventTestTool.printHelp();
            return;
        L10:
            this.this$0.sendHarEvent(r10, r8.getLongExtra("timestamp", System.currentTimeMillis()));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (HarEventTestTool.ACTION_TEST_HAR_EVENT.equals(r10.getAction()) == false) goto L6;
            handleTestCommand(r10);
            return;
        L6:
            if (HarEventTestTool.ACTION_SET_HAR_MONITOR_PARAMS.equals(r10.getAction()) == false) goto L10;
            handleSetHarMonitorParams(r10);
            return;
        }

        public /* synthetic */ TestBroadcastReceiver(HarEventTestTool r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public interface TestToolListener {
        void onHarEventSent(HarEventData r8);
    }

    public HarEventTestTool(Context r8) {
        this.mIsRegistered = false;
        this.mContext = r8.getApplicationContext();
        this.mTestReceiver = new TestBroadcastReceiver(this, null);
    }

    public static void printHelp() {
        CommSenseLog.i(TAG, "\n╔═══════════════════════════════════════════════════════════════════╗\n║                   HarEventTestTool - Command Manual                ║\n╚═══════════════════════════════════════════════════════════════════╝\n\n[Prerequisites]\n  1. Enable test tool switch:\n     adb shell settings put global cae_har_event_test_tool_enable 1\n  2. Check switch status:\n     adb shell settings get global cae_har_event_test_tool_enable\n\n[Basic Operations]\n  1. Show help message for HAR event\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ez help true\n\n  2. Show help message for HAR monitor params\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ez help true\n\n[Event Types]\n  0: SNS_OEM_HAR_LEVEL2_STATE_STATIONARY (静止)\n  1: SNS_OEM_HAR_LEVEL2_STATE_RUNNING (跑步)\n  2: SNS_OEM_HAR_LEVEL2_STATE_WALKING (走路)\n  4: SNS_OEM_HAR_LEVEL2_STATE_OTHER (其他)\n  5: SNS_OEM_HAR_LEVEL2_STATE_SUBWAY (地铁)\n  6: SNS_OEM_HAR_LEVEL2_STATE_CYCLING (骑行)\n  7: SNS_OEM_HAR_LEVEL2_STATE_ELECTRIC_BIKE (电动自行车)\n  8: SNS_OEM_HAR_LEVEL2_STATE_CAR (汽车)\n\n[HAR Event Commands]\n  1. Send HAR event (current timestamp)\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 5\n\n  2. Send HAR event with custom timestamp\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 5 --el timestamp 1234567890\n\n[HAR Monitor Params Commands]\n  1. Set HAR monitor params (using default values for unspecified params)\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ei stateVoteWindowSize 10 --ei walkingContinuousThreshold 3\n\n  2. Available params and their defaults:\n     - stateVoteWindowSize (default: 5)\n     - walkingContinuousThreshold (default: 2)\n     - runningContinuousThreshold (default: 3)\n     - stationaryContinuousThreshold (default: 3)\n     - accelOccurrenceThreshold (default: 4)\n     - stationaryOccurrenceThreshold (default: 3)\n     - accStateDurationThreshold (default: 10)\n     - accStateMonitorWindow (default: 15)\n     - accStateDurationThreshold2 (default: 12)\n     - runningStateDurationThreshold (default: 10)\n     - runningStateMonitorWindow (default: 15)\n     - runningStateDurationThreshold2 (default: 12)\n     - walkingStateMonitorWindow (default: 15)\n     - walkingStateDurationThreshold (default: 10)\n     - walkingStateDurationThreshold2 (default: 12)\n\n[Examples]\n  1. Test subway event:\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 5\n\n  2. Test walking event:\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 2\n\n  3. Test car event:\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 8\n\n  4. Set custom stateVoteWindowSize:\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ei stateVoteWindowSize 20\n\n  5. Set multiple params at once:\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ei stateVoteWindowSize 10 --ei walkingContinuousThreshold 4 --ei runningContinuousThreshold 5\n\n╔═══════════════════════════════════════════════════════════════════╗\n║                   End of Command Manual                           ║\n╚═══════════════════════════════════════════════════════════════════╝\n");
    }

    public boolean isRegistered() {
        return this.mIsRegistered;
    }

    public void register() {
        if (this.mIsRegistered == false) goto L15;
        CommSenseLog.w(TAG, "Test tool already registered");
        return;
    L15:
        IntentFilter r8 = new IntentFilter(ACTION_TEST_HAR_EVENT);     // Catch: Exception -> L12
        r8.addAction(ACTION_SET_HAR_MONITOR_PARAMS);     // Catch: Exception -> L12
        if (Build.VERSION.SDK_INT < 33) goto L9;
        this.mContext.registerReceiver(this.mTestReceiver, r8, 2);     // Catch: Exception -> L12
    L10:
        this.mIsRegistered = true;     // Catch: Exception -> L12
        CommSenseLog.i(TAG, "HarEventTestTool registered successfully");     // Catch: Exception -> L12
        return;
    L9:
        this.mContext.registerReceiver(this.mTestReceiver, r8);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to register test tool", e);
    }

    public void sendHarEvent(int r8) {
        sendHarEvent(r8, System.currentTimeMillis());
    }

    public void setHarMonitorParams(HarMonitorParams r8) {
        UserAwareAdapter r10 = UserAwareAdapter.getInstance(this.mContext);
        if (r10 != null) goto L6;
        CommSenseLog.e(TAG, "UserAwareAdapter is null");
        return;
    L6:
        r10.setHarMonitorParams(r8);
        CommSenseLog.i(TAG, "Set HAR monitor params: " + r8.toString());
    }

    public void setListener(TestToolListener r8) {
        this.mListener = r8;
    }

    public void unregister() {
        if (this.mIsRegistered == true) goto L10;
        return;
    L10:
        this.mContext.unregisterReceiver(this.mTestReceiver);     // Catch: Exception -> L7
        this.mIsRegistered = false;     // Catch: Exception -> L7
        CommSenseLog.i(TAG, "HarEventTestTool unregistered successfully");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CommSenseLog.w(TAG, "Failed to unregister test tool: " + e.getMessage());
    }

    public void sendHarEvent(int r8, long r10) {
        UserAwareAdapter r11 = UserAwareAdapter.getInstance(this.mContext);
        if (r11 != null) goto L6;
        CommSenseLog.e(TAG, "UserAwareAdapter is null");
        return;
    L6:
        HarEventData r12 = new HarEventData(r8, r10);
        r11.notifyHarEvent(r12);
        UserAwareManager.getInstance().notifyInnerCallbacks(new o5.o(5), Integer.valueOf(r8), Long.valueOf(r10));
        TestToolListener r13 = this.mListener;
        if (r13 == null) goto L9;
        r13.onHarEventSent(r12);
    L9:
        CommSenseLog.i(TAG, "Sent HAR event: event=" + r8 + ", timestamp=" + r10);
    }
}
