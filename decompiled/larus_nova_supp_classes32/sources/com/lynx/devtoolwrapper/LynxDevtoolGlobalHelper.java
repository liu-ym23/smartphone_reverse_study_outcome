package com.lynx.devtoolwrapper;

import android.content.Context;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxDevToolService;
import i8a.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevtoolGlobalHelper {
    private static final String TAG = "LynxDevtoolGlobalHelper";
    private static ILynxDevToolService sDevToolService;
    private Map<String, String> mAppInfo;
    private boolean remoteDebugAvailable;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonHolder {
        private static final LynxDevtoolGlobalHelper INSTANCE = null;

        private SingletonHolder() {
        }

        static {
            INSTANCE = new LynxDevtoolGlobalHelper(null);
        }

        public static /* synthetic */ LynxDevtoolGlobalHelper access$000() {
            return INSTANCE;
        }
    }

    private LynxDevtoolGlobalHelper() {
        this.remoteDebugAvailable = false;
        HashMap r0 = new HashMap();
        this.mAppInfo = r0;
        r0.put("sdkVersion", LynxEnv.inst().getLynxVersion());
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L6;
        initRemoteDebugIfNecessary();
        sDevToolService = (ILynxDevToolService) n.c().a(ILynxDevToolService.class);
        return;
    }

    public static LynxDevtoolGlobalHelper getInstance() {
        return SingletonHolder.access$000();
    }

    private boolean initRemoteDebugIfNecessary() {
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L6;
        return false;
    L6:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L10;
        LLog.w(TAG, "liblynx.so not loaded!");
        return false;
    L10:
        if (this.remoteDebugAvailable == false) goto L12;
        return true;
    L12:
        this.remoteDebugAvailable = true;
        return true;
    }

    public boolean isRemoteDebugAvailable() {
        return this.remoteDebugAvailable;
    }

    public /* synthetic */ LynxDevtoolGlobalHelper(AnonymousClass1 r1) {
        this();
    }

    public boolean prepareRemoteDebug(String r4) {
        if (initRemoteDebugIfNecessary() == true) goto L6;
        return false;
    L6:
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L10;
        LLog.w(TAG, "Debugging not supported in this package");
        return false;
    L10:
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L13;
        LLog.w(TAG, "DevTool not enabled, turn on the switch!");
        return false;
    L13:
        ILynxDevToolService r0 = sDevToolService;
        if (r0 != null) goto L16;
        LLog.e(TAG, "failed to get DevToolService");
        return false;
    L16:
        return r0.globalDebugBridgePrepareRemoteDebug(r4).booleanValue();
    }

    public void registerCardListener(LynxDevtoolCardListener r2) {
        if (initRemoteDebugIfNecessary() == true) goto L5;
        return;
    L5:
        ILynxDevToolService r0 = sDevToolService;
        if (r0 == null) goto L8;
        r0.globalDebugBridgeRegisterCardListener(r2);
        return;
    L8:
        LLog.e(TAG, "failed to get DevToolService");
    }

    public boolean shouldPrepareRemoteDebug(String r3) {
        if (initRemoteDebugIfNecessary() == true) goto L5;
        return false;
    L5:
        ILynxDevToolService r0 = sDevToolService;
        if (r0 != null) goto L8;
        LLog.e(TAG, "failed to get DevToolService");
        return false;
    L8:
        return r0.globalDebugBridgeShouldPrepareRemoteDebug(r3).booleanValue();
    }

    public void setAppInfo(Context r2, Map<String, String> r3) {
        if (r3 == null) goto L5;
        this.mAppInfo.putAll(r3);
    L5:
        if (initRemoteDebugIfNecessary() == true) goto L7;
        return;
    L7:
        ILynxDevToolService r4 = sDevToolService;
        if (r4 == null) goto L10;
        r4.globalDebugBridgeSetAppInfo(r2, this.mAppInfo);
        return;
    L10:
        LLog.e(TAG, "failed to get DevToolService");
    }

    public void setAppInfo(String r2, String r3) {
        setAppInfo(null, r2, r3);
    }

    public void onPerfMetricsEvent(String r2, JSONObject r3, int r4) {
        if (this.remoteDebugAvailable == true) goto L5;
        return;
    L5:
        ILynxDevToolService r0 = sDevToolService;
        if (r0 == null) goto L8;
        r0.globalDebugBridgeOnPerfMetricsEvent(r2, r3, r4);
        return;
    L8:
        LLog.e(TAG, "failed to get DevToolService");
    }

    public void setAppInfo(Context r3, String r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("App", r4);
        r0.put("AppVersion", r5);
        setAppInfo(r3, r0);
    }
}
