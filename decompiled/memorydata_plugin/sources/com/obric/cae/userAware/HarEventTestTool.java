package com.obric.cae.userAware;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.libs.useraware.f;
import com.obric.cae.log.a;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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

    public class TestBroadcastReceiver extends PluginBroadcastReceiver {
        final /* synthetic */ HarEventTestTool this$0;

        private TestBroadcastReceiver(HarEventTestTool r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ TestBroadcastReceiver(HarEventTestTool r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void handleSetHarMonitorParams(Intent r4) {
            a.e(HarEventTestTool.TAG, "Received set HAR monitor params command");
            if (r4.getBooleanExtra(HarEventTestTool.EXTRA_HELP, false) == false) goto L6;
            HarEventTestTool.printHelp();
            return;
        L6:
            HarMonitorParams r0 = new HarMonitorParams();
            r0.stateVoteWindowSize = r4.getIntExtra(HarEventTestTool.EXTRA_STATE_VOTE_WINDOW_SIZE, r0.stateVoteWindowSize);
            r0.walkingContinuousThreshold = r4.getIntExtra(HarEventTestTool.EXTRA_WALKING_CONTINUOUS_THRESHOLD, r0.walkingContinuousThreshold);
            r0.runningContinuousThreshold = r4.getIntExtra(HarEventTestTool.EXTRA_RUNNING_CONTINUOUS_THRESHOLD, r0.runningContinuousThreshold);
            r0.accelOccurrenceThreshold = r4.getIntExtra(HarEventTestTool.EXTRA_ACCEL_OCCURRENCE_THRESHOLD, r0.accelOccurrenceThreshold);
            r0.stationaryOccurrenceThreshold = r4.getIntExtra(HarEventTestTool.EXTRA_STATIONARY_OCCURRENCE_THRESHOLD, r0.stationaryOccurrenceThreshold);
            r0.accStateDurationThreshold = r4.getIntExtra(HarEventTestTool.EXTRA_ACC_STATE_DURATION_THRESHOLD, r0.accStateDurationThreshold);
            r0.accStateMonitorWindow = r4.getIntExtra(HarEventTestTool.EXTRA_ACC_STATE_MONITOR_WINDOW, r0.accStateMonitorWindow);
            r0.accStateDurationThreshold2 = r4.getIntExtra(HarEventTestTool.EXTRA_ACC_STATE_DURATION_THRESHOLD2, r0.accStateDurationThreshold2);
            r0.runningStateDurationThreshold = r4.getIntExtra(HarEventTestTool.EXTRA_RUNNING_STATE_DURATION_THRESHOLD, r0.runningStateDurationThreshold);
            r0.runningStateMonitorWindow = r4.getIntExtra(HarEventTestTool.EXTRA_RUNNING_STATE_MONITOR_WINDOW, r0.runningStateMonitorWindow);
            r0.runningStateDurationThreshold2 = r4.getIntExtra(HarEventTestTool.EXTRA_RUNNING_STATE_DURATION_THRESHOLD2, r0.runningStateDurationThreshold2);
            r0.walkingStateMonitorWindow = r4.getIntExtra(HarEventTestTool.EXTRA_WALKING_STATE_MONITOR_WINDOW, r0.walkingStateMonitorWindow);
            r0.walkingStateDurationThreshold = r4.getIntExtra(HarEventTestTool.EXTRA_WALKING_STATE_DURATION_THRESHOLD, r0.walkingStateDurationThreshold);
            r0.walkingStateDurationThreshold2 = r4.getIntExtra(HarEventTestTool.EXTRA_WALKING_STATE_DURATION_THRESHOLD2, r0.walkingStateDurationThreshold2);
            this.this$0.setHarMonitorParams(r0);
        }

        private void handleTestCommand(Intent r5) {
            a.e(HarEventTestTool.TAG, "Received test command");
            if (r5.getBooleanExtra(HarEventTestTool.EXTRA_HELP, false) == false) goto L6;
            HarEventTestTool.printHelp();
            return;
        L6:
            int r1 = r5.getIntExtra("event", -1);
            if (r1 != (-1)) goto L10;
            a.i(HarEventTestTool.TAG, "Invalid event: " + r1);
            HarEventTestTool.printHelp();
            return;
        L10:
            this.this$0.sendHarEvent(r1, r5.getLongExtra("timestamp", System.currentTimeMillis()));
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (HarEventTestTool.ACTION_TEST_HAR_EVENT.equals(r4.getAction()) == false) goto L6;
            handleTestCommand(r4);
            return;
        L6:
            if (HarEventTestTool.ACTION_SET_HAR_MONITOR_PARAMS.equals(r4.getAction()) == false) goto L10;
            handleSetHarMonitorParams(r4);
            return;
        }
    }

    public interface TestToolListener {
        void onHarEventSent(HarEventData r1);
    }

    public HarEventTestTool(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mIsRegistered = false;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mTestReceiver = new TestBroadcastReceiver(this, null);
    }

    public static void printHelp() {
        a.e(TAG, "\n╔═══════════════════════════════════════════════════════════════════╗\n║                   HarEventTestTool - Command Manual                ║\n╚═══════════════════════════════════════════════════════════════════╝\n\n[Prerequisites]\n  1. Enable test tool switch:\n     adb shell settings put global cae_har_event_test_tool_enable 1\n  2. Check switch status:\n     adb shell settings get global cae_har_event_test_tool_enable\n\n[Basic Operations]\n  1. Show help message for HAR event\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ez help true\n\n  2. Show help message for HAR monitor params\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ez help true\n\n[Event Types]\n  0: SNS_OEM_HAR_LEVEL2_STATE_STATIONARY (静止)\n  1: SNS_OEM_HAR_LEVEL2_STATE_RUNNING (跑步)\n  2: SNS_OEM_HAR_LEVEL2_STATE_WALKING (走路)\n  4: SNS_OEM_HAR_LEVEL2_STATE_OTHER (其他)\n  5: SNS_OEM_HAR_LEVEL2_STATE_SUBWAY (地铁)\n  6: SNS_OEM_HAR_LEVEL2_STATE_CYCLING (骑行)\n  7: SNS_OEM_HAR_LEVEL2_STATE_ELECTRIC_BIKE (电动自行车)\n  8: SNS_OEM_HAR_LEVEL2_STATE_CAR (汽车)\n\n[HAR Event Commands]\n  1. Send HAR event (current timestamp)\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 5\n\n  2. Send HAR event with custom timestamp\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 5 --el timestamp 1234567890\n\n[HAR Monitor Params Commands]\n  1. Set HAR monitor params (using default values for unspecified params)\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ei stateVoteWindowSize 10 --ei walkingContinuousThreshold 3\n\n  2. Available params and their defaults:\n     - stateVoteWindowSize (default: 5)\n     - walkingContinuousThreshold (default: 2)\n     - runningContinuousThreshold (default: 3)\n     - stationaryContinuousThreshold (default: 3)\n     - accelOccurrenceThreshold (default: 4)\n     - stationaryOccurrenceThreshold (default: 3)\n     - accStateDurationThreshold (default: 10)\n     - accStateMonitorWindow (default: 15)\n     - accStateDurationThreshold2 (default: 12)\n     - runningStateDurationThreshold (default: 10)\n     - runningStateMonitorWindow (default: 15)\n     - runningStateDurationThreshold2 (default: 12)\n     - walkingStateMonitorWindow (default: 15)\n     - walkingStateDurationThreshold (default: 10)\n     - walkingStateDurationThreshold2 (default: 12)\n\n[Examples]\n  1. Test subway event:\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 5\n\n  2. Test walking event:\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 2\n\n  3. Test car event:\n     adb shell am broadcast -a com.obric.cae.test.HAR_EVENT --ei event 8\n\n  4. Set custom stateVoteWindowSize:\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ei stateVoteWindowSize 20\n\n  5. Set multiple params at once:\n     adb shell am broadcast -a com.obric.cae.test.SET_HAR_MONITOR_PARAMS --ei stateVoteWindowSize 10 --ei walkingContinuousThreshold 4 --ei runningContinuousThreshold 5\n\n╔═══════════════════════════════════════════════════════════════════╗\n║                   End of Command Manual                           ║\n╚═══════════════════════════════════════════════════════════════════╝\n");
    }

    public boolean isRegistered() {
        return this.mIsRegistered;
    }

    public void register() {
        if (this.mIsRegistered == false) goto L16;
        a.g(TAG, "Test tool already registered");
        return;
    L16:
        IntentFilter r0 = new IntentFilter(ACTION_TEST_HAR_EVENT);     // Catch: Exception -> L13
        r0.addAction(ACTION_SET_HAR_MONITOR_PARAMS);     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 33) goto L10;
        ZeusTransformUtils.registerReceiver(this.mContext, this.mTestReceiver, r0, 2, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
    L11:
        this.mIsRegistered = true;     // Catch: Exception -> L13
        a.e(TAG, "HarEventTestTool registered successfully");     // Catch: Exception -> L13
        return;
    L10:
        ZeusTransformUtils.registerReceiver(this.mContext, this.mTestReceiver, r0, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        a.a(TAG, "Failed to register test tool", e);
    }

    public void sendHarEvent(int r3) {
        sendHarEvent(r3, System.currentTimeMillis());
    }

    public void sendHarEvent(int r7, long r8) {
        f r0 = f.a(this.mContext);
        if (r0 != null) goto L6;
        a.i(TAG, "UserAwareAdapter is null");
        return;
    L6:
        HarEventData r2 = new HarEventData(r7, r8);
        r0.a(r2);
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$0faNABYCk_oj7ofDaj7cUpQlXVI.INSTANCE, Integer.valueOf(r7), Long.valueOf(r8));
        TestToolListener r6 = this.mListener;
        if (r6 == null) goto L9;
        r6.onHarEventSent(r2);
    L9:
        a.e(TAG, "Sent HAR event: event=" + r7 + ", timestamp=" + r8);
    }

    public void setHarMonitorParams(HarMonitorParams r3) {
        f r2 = f.a(this.mContext);
        if (r2 != null) goto L6;
        a.i(TAG, "UserAwareAdapter is null");
        return;
    L6:
        r2.a(r3);
        a.e(TAG, "Set HAR monitor params: " + r3.toString());
    }

    public void setListener(TestToolListener r3) {
        this.mListener = (TestToolListener) ZeusTransformUtils.wrapperContextForParams(r3, TestToolListener.class, "com.obric.memorydata.plugin");
    }

    public void unregister() {
        if (this.mIsRegistered == true) goto L10;
        return;
    L10:
        ZeusTransformUtils.unregisterReceiver(this.mContext, this.mTestReceiver, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        this.mIsRegistered = false;     // Catch: Exception -> L7
        a.e(TAG, "HarEventTestTool unregistered successfully");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a.g(TAG, "Failed to unregister test tool: " + e.getMessage());
    }
}
