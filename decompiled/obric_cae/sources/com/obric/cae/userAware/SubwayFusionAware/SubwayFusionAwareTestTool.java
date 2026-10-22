package com.obric.cae.userAware.SubwayFusionAware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayFusionAwareTestTool {
    private static final String ACTION_TEST_SUBWAY_STATE = "com.obric.cae.test.SUBWAY_STATE";
    private static final String EXTRA_GET_STATE = "get_state";
    private static final String EXTRA_HELP = "help";
    private static final String EXTRA_INDOOR_OUTDOOR_STATUS = "indoor_outdoor_status";
    private static final String EXTRA_RESET = "reset";
    private static final String EXTRA_STATE = "state";
    private static final String EXTRA_TRIGGER_ENTER = "trigger_enter";
    private static final String EXTRA_TRIGGER_EXIT = "trigger_exit";
    private static final String EXTRA_TRIGGER_INDOOR_CHECK = "trigger_indoor_check";
    private static final String TAG = "SubwayFusionAwareTestTool";
    private final Context mContext;
    private boolean mIsRegistered;
    private TestToolListener mListener;
    private final SubwayFusionAware mSubwayFusionAware;
    private final TestBroadcastReceiver mTestReceiver;

    /* JADX INFO: renamed from: com.obric.cae.userAware.SubwayFusionAware.SubwayFusionAwareTestTool$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class TestBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ SubwayFusionAwareTestTool this$0;

        private TestBroadcastReceiver(SubwayFusionAwareTestTool r8) {
            this.this$0 = r8;
        }

        private void handleTestCommand(Intent r11) {
            CommSenseLog.i(SubwayFusionAwareTestTool.TAG, "Received test command");
            String r8 = r11.getStringExtra("state");
            boolean r10 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_TRIGGER_ENTER, false);
            boolean r12 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_TRIGGER_EXIT, false);
            boolean r13 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_RESET, false);
            boolean r14 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_GET_STATE, false);
            boolean r15 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_HELP, false);
            int r16 = r11.getIntExtra(SubwayFusionAwareTestTool.EXTRA_INDOOR_OUTDOOR_STATUS, -1);
            boolean r17 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_TRIGGER_INDOOR_CHECK, false);
            if (r15 == false) goto L6;
            SubwayFusionAwareTestTool.printHelp();
            return;
        L6:
            if (r13 == false) goto L9;
            this.this$0.reset();
            return;
        L9:
            if (r14 == false) goto L12;
            CommSenseLog.i(SubwayFusionAwareTestTool.TAG, "Current state: " + this.this$0.getCurrentState());
            return;
        L12:
            if (r16 < 0) goto L14;
            this.this$0.forceSetIndoorOutdoorStatus(r16);
        L14:
            if (r17 == false) goto L16;
            this.this$0.forceTriggerIndoorOutdoorCheck();
        L16:
            if (r8 != null) goto L26;
        L21:
            if (r10 == false) goto L23;
            this.this$0.forceReportSubwayEvent(true);
        L23:
            if (r12 == false) goto L28;
            this.this$0.forceReportSubwayEvent(false);
            return;
        L28:
            return;
        L26:
            this.this$0.forceTransitionToState(SubwayState.valueOf(r8));     // Catch: IllegalArgumentException -> L19
        L19:
            e = move-exception;
            CommSenseLog.e(SubwayFusionAwareTestTool.TAG, "Invalid state: ".concat(r8), e);
            goto L21
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (SubwayFusionAwareTestTool.ACTION_TEST_SUBWAY_STATE.equals(r10.getAction()) == false) goto L6;
            handleTestCommand(r10);
            return;
        }

        public /* synthetic */ TestBroadcastReceiver(SubwayFusionAwareTestTool r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public interface TestToolListener {
        void onStateTransition(SubwayState r8, SubwayState r10);

        void onSubwayEvent(boolean r8);
    }

    public SubwayFusionAwareTestTool(Context r8, SubwayFusionAware r10) {
        this.mIsRegistered = false;
        this.mContext = r8.getApplicationContext();
        this.mSubwayFusionAware = r10;
        this.mTestReceiver = new TestBroadcastReceiver(this, null);
    }

    public static void printHelp() {
        CommSenseLog.i(TAG, "\n╔═══════════════════════════════════════════════════════════════════╗\n║           SubwayFusionAware Test Tool - Complete Command Manual     ║\n╚═══════════════════════════════════════════════════════════════════╝\n\n[Prerequisites]\n  1. Enable test tool switch:\n     adb shell settings put global cae_subway_test_tool_enable 1\n  2. Check switch status:\n     adb shell settings get global cae_subway_test_tool_enable\n\n[Basic Operations]\n  1. Show help message\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez help true\n\n  2. Get current state\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez get_state true\n\n  3. Reset SubwayFusionAware\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez reset true\n\n[Indoor/Outdoor Detection]\n  4. Force set indoor/outdoor status\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ei indoor_outdoor_status 0\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ei indoor_outdoor_status 1\n     (0=outdoor, 1=indoor)\n\n  5. Trigger indoor/outdoor check\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez trigger_indoor_check true\n\n[State Machine Control]\n  Available states:\n  - STATE_IDLE\n  - STATE_ENTER_PRE_FILTER\n  - STATE_ENTER_CONFIDENCE_SCORING\n  - STATE_EXIT_CONFIDENCE_SCORING\n\n  6. Force transition to specific state\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_IDLE\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_ENTER_PRE_FILTER\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_ENTER_CONFIDENCE_SCORING\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_EXIT_CONFIDENCE_SCORING\n\n[Event Triggering]\n  7. Trigger subway enter event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez trigger_enter true\n\n  8. Trigger subway exit event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez trigger_exit true\n\n[Combined Command Examples]\n  9. Transition state and trigger event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_ENTER_CONFIDENCE_SCORING --ez trigger_enter true\n\n  10. Transition state and trigger exit event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_EXIT_CONFIDENCE_SCORING --ez trigger_exit true\n\n[Parameter Reference]\n  --es state <state_name>               : Force transition to specific state\n  --ez trigger_enter true               : Trigger subway enter event\n  --ez trigger_exit true                : Trigger subway exit event\n  --ez reset true                        : Reset SubwayFusionAware\n  --ez get_state true                    : Get current state\n  --ez help true                         : Show help message\n  --ei indoor_outdoor_status <0/1>      : Force set indoor/outdoor status (0=outdoor, 1=indoor)\n  --ez trigger_indoor_check true         : Trigger indoor/outdoor check\n\n╔═══════════════════════════════════════════════════════════════════╗\n║                        End of Command Manual                         ║\n╚═══════════════════════════════════════════════════════════════════╝\n");
    }

    public void forceReportSubwayEvent(boolean r8) {
        SubwayFusionAware r10 = this.mSubwayFusionAware;
        if (r10 != null) goto L16;
        CommSenseLog.e(TAG, "SubwayFusionAware is null");
        return;
    L16:
        SubwayStateManager r11 = r10.getStateManager();     // Catch: Exception -> L13
        if (r11 == null) goto L18;
        r11.reportSubwayEvent(r8);     // Catch: Exception -> L13
        TestToolListener r12 = this.mListener;     // Catch: Exception -> L13
        if (r12 == null) goto L11;
        r12.onSubwayEvent(r8);     // Catch: Exception -> L13
    L11:
        CommSenseLog.i(TAG, "Force report subway event: isEnter=" + r8);     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to force report subway event", e);
    }

    public void forceSetIndoorOutdoorStatus(int r8) {
        SubwayFusionAware r10 = this.mSubwayFusionAware;
        if (r10 != null) goto L13;
        CommSenseLog.e(TAG, "SubwayFusionAware is null");
        return;
    L13:
        SubwayEventProcessor r11 = r10.getEventProcessor();     // Catch: Exception -> L10
        if (r11 == null) goto L15;
        r11.processIndoorOutdoorStatus(r8);     // Catch: Exception -> L10
        CommSenseLog.i(TAG, "Force set indoor/outdoor status: " + r8 + " (0=outdoor, 1=indoor)");     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to force set indoor/outdoor status", e);
    }

    public void forceTransitionToState(SubwayState r8) {
        SubwayFusionAware r10 = this.mSubwayFusionAware;
        if (r10 != null) goto L16;
        CommSenseLog.e(TAG, "SubwayFusionAware is null");
        return;
    L16:
        SubwayStateManager r11 = r10.getStateManager();     // Catch: Exception -> L13
        if (r11 == null) goto L18;
        SubwayState r12 = r11.getCurrentState();     // Catch: Exception -> L13
        r11.transitionToState(r8);     // Catch: Exception -> L13
        TestToolListener r13 = this.mListener;     // Catch: Exception -> L13
        if (r13 == null) goto L11;
        r13.onStateTransition(r12, r8);     // Catch: Exception -> L13
    L11:
        CommSenseLog.i(TAG, "Force transition: " + r12 + " -> " + r8);     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to force transition to state: " + r8, e);
    }

    public void forceTriggerIndoorOutdoorCheck() {
        SubwayFusionAware r8 = this.mSubwayFusionAware;
        if (r8 != null) goto L11;
        CommSenseLog.e(TAG, "SubwayFusionAware is null");
        return;
    L11:
        r8.forceTriggerIndoorOutdoorCheck();     // Catch: Exception -> L8
        CommSenseLog.i(TAG, "Force trigger indoor/outdoor check");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to force trigger indoor/outdoor check", e);
    }

    public SubwayState getCurrentState() {
        SubwayFusionAware r8 = this.mSubwayFusionAware;
        if (r8 != null) goto L13;
        CommSenseLog.e(TAG, "SubwayFusionAware is null");
        return null;
    L13:
        SubwayStateManager r10 = r8.getStateManager();     // Catch: Exception -> L10
        if (r10 == null) goto L12;
        return r10.getCurrentState();
    L12:
        return null;
    L10:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to get current state", e);
        goto L12
    }

    public boolean isRegistered() {
        return this.mIsRegistered;
    }

    public void register() {
        if (this.mIsRegistered == false) goto L15;
        CommSenseLog.w(TAG, "Test tool already registered");
        return;
    L15:
        IntentFilter r8 = new IntentFilter(ACTION_TEST_SUBWAY_STATE);     // Catch: Exception -> L12
        if (Build.VERSION.SDK_INT < 33) goto L9;
        this.mContext.registerReceiver(this.mTestReceiver, r8, 2);     // Catch: Exception -> L12
    L10:
        this.mIsRegistered = true;     // Catch: Exception -> L12
        CommSenseLog.i(TAG, "Test tool registered successfully");     // Catch: Exception -> L12
        return;
    L9:
        this.mContext.registerReceiver(this.mTestReceiver, r8);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to register test tool", e);
    }

    public void reset() {
        SubwayFusionAware r8 = this.mSubwayFusionAware;
        if (r8 != null) goto L11;
        CommSenseLog.e(TAG, "SubwayFusionAware is null");
        return;
    L11:
        r8.release();     // Catch: Exception -> L8
        this.mSubwayFusionAware.init();     // Catch: Exception -> L8
        CommSenseLog.i(TAG, "SubwayFusionAware reset successfully");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to reset SubwayFusionAware", e);
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
        CommSenseLog.i(TAG, "Test tool unregistered successfully");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CommSenseLog.w(TAG, "Failed to unregister test tool: " + e.getMessage());
    }
}
