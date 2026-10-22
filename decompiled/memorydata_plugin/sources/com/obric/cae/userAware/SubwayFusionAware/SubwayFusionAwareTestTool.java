package com.obric.cae.userAware.SubwayFusionAware;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.obric.cae.log.a;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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

    public class TestBroadcastReceiver extends PluginBroadcastReceiver {
        final /* synthetic */ SubwayFusionAwareTestTool this$0;

        private TestBroadcastReceiver(SubwayFusionAwareTestTool r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ TestBroadcastReceiver(SubwayFusionAwareTestTool r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void handleTestCommand(Intent r11) {
            a.e(SubwayFusionAwareTestTool.TAG, "Received test command");
            String r1 = r11.getStringExtra("state");
            boolean r2 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_TRIGGER_ENTER, false);
            boolean r4 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_TRIGGER_EXIT, false);
            boolean r5 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_RESET, false);
            boolean r6 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_GET_STATE, false);
            boolean r7 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_HELP, false);
            int r8 = r11.getIntExtra(SubwayFusionAwareTestTool.EXTRA_INDOOR_OUTDOOR_STATUS, -1);
            boolean r12 = r11.getBooleanExtra(SubwayFusionAwareTestTool.EXTRA_TRIGGER_INDOOR_CHECK, false);
            if (r7 == false) goto L6;
            SubwayFusionAwareTestTool.printHelp();
            return;
        L6:
            if (r5 == false) goto L9;
            this.this$0.reset();
            return;
        L9:
            if (r6 == false) goto L12;
            a.e(SubwayFusionAwareTestTool.TAG, "Current state: " + this.this$0.getCurrentState());
            return;
        L12:
            if (r8 < 0) goto L14;
            this.this$0.forceSetIndoorOutdoorStatus(r8);
        L14:
            if (r12 == false) goto L16;
            this.this$0.forceTriggerIndoorOutdoorCheck();
        L16:
            if (r1 != null) goto L26;
        L21:
            if (r2 == false) goto L23;
            this.this$0.forceReportSubwayEvent(true);
        L23:
            if (r4 == false) goto L28;
            this.this$0.forceReportSubwayEvent(false);
            return;
        L28:
            return;
        L26:
            this.this$0.forceTransitionToState(SubwayState.valueOf(r1));     // Catch: IllegalArgumentException -> L19
        L19:
            e = move-exception;
            a.a(SubwayFusionAwareTestTool.TAG, "Invalid state: ".concat(r1), e);
            goto L21
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (SubwayFusionAwareTestTool.ACTION_TEST_SUBWAY_STATE.equals(r4.getAction()) == false) goto L6;
            handleTestCommand(r4);
            return;
        }
    }

    public interface TestToolListener {
        void onStateTransition(SubwayState r1, SubwayState r2);

        void onSubwayEvent(boolean r1);
    }

    public SubwayFusionAwareTestTool(Context r3, SubwayFusionAware r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mIsRegistered = false;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mSubwayFusionAware = r4;
        this.mTestReceiver = new TestBroadcastReceiver(this, null);
    }

    public static void printHelp() {
        a.e(TAG, "\n╔═══════════════════════════════════════════════════════════════════╗\n║           SubwayFusionAware Test Tool - Complete Command Manual     ║\n╚═══════════════════════════════════════════════════════════════════╝\n\n[Prerequisites]\n  1. Enable test tool switch:\n     adb shell settings put global cae_subway_test_tool_enable 1\n  2. Check switch status:\n     adb shell settings get global cae_subway_test_tool_enable\n\n[Basic Operations]\n  1. Show help message\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez help true\n\n  2. Get current state\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez get_state true\n\n  3. Reset SubwayFusionAware\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez reset true\n\n[Indoor/Outdoor Detection]\n  4. Force set indoor/outdoor status\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ei indoor_outdoor_status 0\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ei indoor_outdoor_status 1\n     (0=outdoor, 1=indoor)\n\n  5. Trigger indoor/outdoor check\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez trigger_indoor_check true\n\n[State Machine Control]\n  Available states:\n  - STATE_IDLE\n  - STATE_ENTER_PRE_FILTER\n  - STATE_ENTER_CONFIDENCE_SCORING\n  - STATE_EXIT_CONFIDENCE_SCORING\n\n  6. Force transition to specific state\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_IDLE\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_ENTER_PRE_FILTER\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_ENTER_CONFIDENCE_SCORING\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_EXIT_CONFIDENCE_SCORING\n\n[Event Triggering]\n  7. Trigger subway enter event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez trigger_enter true\n\n  8. Trigger subway exit event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --ez trigger_exit true\n\n[Combined Command Examples]\n  9. Transition state and trigger event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_ENTER_CONFIDENCE_SCORING --ez trigger_enter true\n\n  10. Transition state and trigger exit event\n     adb shell am broadcast -a com.obric.cae.test.SUBWAY_STATE --es state STATE_EXIT_CONFIDENCE_SCORING --ez trigger_exit true\n\n[Parameter Reference]\n  --es state <state_name>               : Force transition to specific state\n  --ez trigger_enter true               : Trigger subway enter event\n  --ez trigger_exit true                : Trigger subway exit event\n  --ez reset true                        : Reset SubwayFusionAware\n  --ez get_state true                    : Get current state\n  --ez help true                         : Show help message\n  --ei indoor_outdoor_status <0/1>      : Force set indoor/outdoor status (0=outdoor, 1=indoor)\n  --ez trigger_indoor_check true         : Trigger indoor/outdoor check\n\n╔═══════════════════════════════════════════════════════════════════╗\n║                        End of Command Manual                         ║\n╚═══════════════════════════════════════════════════════════════════╝\n");
    }

    public void forceReportSubwayEvent(boolean r4) {
        SubwayFusionAware r1 = this.mSubwayFusionAware;
        if (r1 != null) goto L16;
        a.i(TAG, "SubwayFusionAware is null");
        return;
    L16:
        SubwayStateManager r2 = r1.getStateManager();     // Catch: Exception -> L13
        if (r2 == null) goto L18;
        r2.reportSubwayEvent(r4);     // Catch: Exception -> L13
        TestToolListener r3 = this.mListener;     // Catch: Exception -> L13
        if (r3 == null) goto L11;
        r3.onSubwayEvent(r4);     // Catch: Exception -> L13
    L11:
        a.e(TAG, "Force report subway event: isEnter=" + r4);     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        a.a(TAG, "Failed to force report subway event", e);
    }

    public void forceSetIndoorOutdoorStatus(int r3) {
        SubwayFusionAware r2 = this.mSubwayFusionAware;
        if (r2 != null) goto L13;
        a.i(TAG, "SubwayFusionAware is null");
        return;
    L13:
        SubwayEventProcessor r4 = r2.getEventProcessor();     // Catch: Exception -> L10
        if (r4 == null) goto L15;
        r4.processIndoorOutdoorStatus(r3);     // Catch: Exception -> L10
        a.e(TAG, "Force set indoor/outdoor status: " + r3 + " (0=outdoor, 1=indoor)");     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        a.a(TAG, "Failed to force set indoor/outdoor status", e);
    }

    public void forceTransitionToState(SubwayState r5) {
        SubwayFusionAware r1 = this.mSubwayFusionAware;
        if (r1 != null) goto L16;
        a.i(TAG, "SubwayFusionAware is null");
        return;
    L16:
        SubwayStateManager r2 = r1.getStateManager();     // Catch: Exception -> L13
        if (r2 == null) goto L18;
        SubwayState r3 = r2.getCurrentState();     // Catch: Exception -> L13
        r2.transitionToState(r5);     // Catch: Exception -> L13
        TestToolListener r4 = this.mListener;     // Catch: Exception -> L13
        if (r4 == null) goto L11;
        r4.onStateTransition(r3, r5);     // Catch: Exception -> L13
    L11:
        a.e(TAG, "Force transition: " + r3 + " -> " + r5);     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        a.a(TAG, "Failed to force transition to state: " + r5, e);
    }

    public void forceTriggerIndoorOutdoorCheck() {
        SubwayFusionAware r2 = this.mSubwayFusionAware;
        if (r2 != null) goto L11;
        a.i(TAG, "SubwayFusionAware is null");
        return;
    L11:
        r2.forceTriggerIndoorOutdoorCheck();     // Catch: Exception -> L8
        a.e(TAG, "Force trigger indoor/outdoor check");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a.a(TAG, "Failed to force trigger indoor/outdoor check", e);
    }

    public SubwayState getCurrentState() {
        SubwayFusionAware r3 = this.mSubwayFusionAware;
        if (r3 != null) goto L13;
        a.i(TAG, "SubwayFusionAware is null");
        return null;
    L13:
        SubwayStateManager r4 = r3.getStateManager();     // Catch: Exception -> L10
        if (r4 == null) goto L12;
        return r4.getCurrentState();
    L12:
        return null;
    L10:
        e = move-exception;
        a.a(TAG, "Failed to get current state", e);
        goto L12
    }

    public boolean isRegistered() {
        return this.mIsRegistered;
    }

    public void register() {
        if (this.mIsRegistered == false) goto L16;
        a.g(TAG, "Test tool already registered");
        return;
    L16:
        IntentFilter r0 = new IntentFilter(ACTION_TEST_SUBWAY_STATE);     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 33) goto L10;
        ZeusTransformUtils.registerReceiver(this.mContext, this.mTestReceiver, r0, 2, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
    L11:
        this.mIsRegistered = true;     // Catch: Exception -> L13
        a.e(TAG, "Test tool registered successfully");     // Catch: Exception -> L13
        return;
    L10:
        ZeusTransformUtils.registerReceiver(this.mContext, this.mTestReceiver, r0, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        a.a(TAG, "Failed to register test tool", e);
    }

    public void reset() {
        SubwayFusionAware r0 = this.mSubwayFusionAware;
        if (r0 != null) goto L11;
        a.i(TAG, "SubwayFusionAware is null");
        return;
    L11:
        r0.release();     // Catch: Exception -> L8
        this.mSubwayFusionAware.init();     // Catch: Exception -> L8
        a.e(TAG, "SubwayFusionAware reset successfully");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a.a(TAG, "Failed to reset SubwayFusionAware", e);
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
        a.e(TAG, "Test tool unregistered successfully");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a.g(TAG, "Failed to unregister test tool: " + e.getMessage());
    }
}
