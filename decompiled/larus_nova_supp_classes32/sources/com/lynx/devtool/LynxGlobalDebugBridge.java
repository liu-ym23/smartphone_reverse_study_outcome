package com.lynx.devtool;

import android.content.Context;
import com.lynx.debugrouter.ConnectionState;
import com.lynx.debugrouter.ConnectionType;
import com.lynx.debugrouter.DebugRouter;
import com.lynx.debugrouter.DebugRouterGlobalHandler;
import com.lynx.debugrouter.StateListener;
import com.lynx.devtoolwrapper.DevToolLifecycle;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.eventreport.ILynxEventReportObserver;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxGlobalDebugBridge implements DebugRouterGlobalHandler, StateListener, ILynxEventReportObserver {
    private static final String CUSTOM_FOR_GET_GLOBAL_SWITCH = "GetGlobalSwitch";
    private static final String CUSTOM_FOR_SET_GLOBAL_SWITCH = "SetGlobalSwitch";
    private static final String TAG = "LynxGlobalDebugBridge";
    private DevToolAgentDispatcher mAgentDispatcher;
    private Set<LynxDevtoolCardListener> mCardListeners;
    private Boolean mIsPerfMetricsEnabled;

    /* JADX INFO: renamed from: com.lynx.devtool.LynxGlobalDebugBridge$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DevToolAgentDispatcher extends LynxInspectorOwner {
        public DevToolAgentDispatcher() {
            super(null, true);
        }
    }

    public static class SingletonHolder {
        private static final LynxGlobalDebugBridge INSTANCE = null;

        private SingletonHolder() {
        }

        static {
            INSTANCE = new LynxGlobalDebugBridge(null);
        }

        public static /* synthetic */ LynxGlobalDebugBridge access$000() {
            return INSTANCE;
        }
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onMessage(String r1) {
    }

    private LynxGlobalDebugBridge() {
        this.mIsPerfMetricsEnabled = null;
        this.mCardListeners = new HashSet();
        this.mAgentDispatcher = new DevToolAgentDispatcher();
        DebugRouter.getInstance().addGlobalHandler(this);
        DebugRouter.getInstance().addStateListener(this);
        LynxEventReporter.addObserver(this);
        if (LynxEnv.inst().isLaunchRecordEnabled() == false) goto L6;
        startRecord();
        return;
    }

    public static LynxGlobalDebugBridge getInstance() {
        return SingletonHolder.access$000();
    }

    public boolean isEnabled() {
        if (DebugRouter.getInstance().getConnectionState() != ConnectionState.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    public void startRecord() {
        RecorderController.nativeStartRecord();
    }

    public /* synthetic */ LynxGlobalDebugBridge(AnonymousClass1 r1) {
        this();
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onError(String r3) {
        LLog.i(TAG, "Connection closed. Error: " + r3);
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onOpen(ConnectionType r3) {
        LLog.i(TAG, "Connection opened. Type: " + r3);
        DevToolLifecycle.getInstance().onConnected();
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void openCard(String r5) {
        Iterator<LynxDevtoolCardListener> r0 = this.mCardListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LynxDevtoolCardListener r1 = r0.next();
        LLog.i(TAG, "openCard: " + r5 + ", handled by " + r1.getClass().getName());
        r1.open(r5);
        goto L4
    }

    public boolean prepareRemoteDebug(String r2) {
        if (shouldPrepareRemoteDebug(r2) == true) goto L7;
        return false;
    L7:
        return DebugRouter.getInstance().handleSchema(r2);
    }

    public void registerCardListener(LynxDevtoolCardListener r2) {
        if (r2 == null) goto L5;
        this.mCardListeners.add(r2);
        return;
    }

    public boolean shouldPrepareRemoteDebug(String r2) {
        return DebugRouter.getInstance().isValidSchema(r2);
    }

    @Override // com.lynx.debugrouter.StateListener
    public void onClose(int r3, String r4) {
        LLog.i(TAG, "Connection closed. Code: " + r3 + ". Reason: " + r4);
    }

    public void setAppInfo(Context r3, Map<String, String> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r4.put("sdkVersion", LynxEnv.inst().getLynxVersion());
        DebugRouter.getInstance().setAppInfo(r3, r4);
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void onMessage(String r3, int r4, String r5) {
        if (r3 == null) goto L12;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r3.equals(CUSTOM_FOR_SET_GLOBAL_SWITCH) == false) goto L9;
        Object r6 = this.mAgentDispatcher.setGlobalSwitch(r5);
        DebugRouter.getInstance().sendDataAsync(CUSTOM_FOR_SET_GLOBAL_SWITCH, -1, String.valueOf(r6));
        return;
    L9:
        if (r3.equals(CUSTOM_FOR_GET_GLOBAL_SWITCH) == false) goto L14;
        Object r7 = this.mAgentDispatcher.getGlobalSwitch(r5);
        DebugRouter.getInstance().sendDataAsync(CUSTOM_FOR_GET_GLOBAL_SWITCH, -1, String.valueOf(r7));
        return;
    L14:
        return;
    }

    public void onPerfMetricsEvent(String r2, JSONObject r3, int r4) {
        if (this.mIsPerfMetricsEnabled != null) goto L6;
        this.mIsPerfMetricsEnabled = Boolean.valueOf(LynxDevtoolEnv.inst().isPerfMetricsEnabled());
    L6:
        if (this.mIsPerfMetricsEnabled.booleanValue() == true) goto L8;
        return;
    L8:
        if (this.mAgentDispatcher == null) goto L17;
        r3.put("instanceId", r4);     // Catch: JSONException -> L11
        this.mAgentDispatcher.onPerfMetricsEvent(r2, r3);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        LLog.e(TAG, e.toString());
        return;
    }

    @Override // com.lynx.tasm.eventreport.ILynxEventReportObserver
    public void onReportEvent(String r1, int r2, Map<String, ?> r3, Map<String, ?> r4) {
        if (this.mIsPerfMetricsEnabled != null) goto L6;
        this.mIsPerfMetricsEnabled = Boolean.valueOf(LynxDevtoolEnv.inst().isPerfMetricsEnabled());
    L6:
        if (this.mIsPerfMetricsEnabled.booleanValue() == true) goto L8;
        return;
    L8:
        onPerfMetricsEvent(r1, new JSONObject(r3), r2);
    }
}
