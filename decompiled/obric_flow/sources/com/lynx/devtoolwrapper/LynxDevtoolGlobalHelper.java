package com.lynx.devtoolwrapper;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.service.ILynxDevToolService;
import java.util.HashMap;
import java.util.Map;
import ko.r;
import mm.e;
import mm.f;
import mm.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxDevtoolGlobalHelper {
    private static final String TAG = "LynxDevtoolGlobalHelper";
    private static ILynxDevToolService sDevToolService;
    private Map<String, String> mAppInfo;
    private Context mContext;
    private boolean remoteDebugAvailable;

    public /* synthetic */ LynxDevtoolGlobalHelper(f r5) {
        this();
    }

    public static LynxDevtoolGlobalHelper getInstance() {
        return g.f20113a;
    }

    private boolean initRemoteDebugIfNecessary() {
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L6;
        return false;
    L6:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L13;
        Context r5 = this.mContext;
        if (r5 == null) goto L10;
        Toast.makeText(r5, "Lynx initialization not finished!", 0).show();
    L10:
        LynxLog.b(3, TAG, "liblynx.so not loaded!");
        return false;
    L13:
        if (this.remoteDebugAvailable == false) goto L16;
        return true;
    L16:
        if (LynxEnv.inst().isLaunchRecordEnabled() == false) goto L22;
        ILynxDevToolService r10 = sDevToolService;
        if (r10 == null) goto L20;
        r10.globalDebugBridgeStartRecord();
        goto L22
    L20:
        LynxLog.b(4, TAG, "failed to get DevToolService");
        return this.remoteDebugAvailable;
    L22:
        this.remoteDebugAvailable = true;
        return true;
    }

    public boolean isRemoteDebugAvailable() {
        return this.remoteDebugAvailable;
    }

    public void onPerfMetricsEvent(String r5, @NonNull JSONObject r10, int r11) {
        if (this.remoteDebugAvailable == true) goto L5;
        return;
    L5:
        ILynxDevToolService r12 = sDevToolService;
        if (r12 == null) goto L9;
        r12.globalDebugBridgeOnPerfMetricsEvent(r5, r10, r11);
        return;
    L9:
        LynxLog.b(4, TAG, "failed to get DevToolService");
    }

    public boolean prepareRemoteDebug(String r5) {
        if (initRemoteDebugIfNecessary() == true) goto L6;
        return false;
    L6:
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L13;
        Context r10 = this.mContext;
        if (r10 == null) goto L10;
        Toast.makeText(r10, "Debugging not supported in this package", 0).show();
    L10:
        LynxLog.b(3, TAG, "Debugging not supported in this package");
        return false;
    L13:
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L19;
        Context r11 = this.mContext;
        if (r11 == null) goto L17;
        Toast.makeText(r11, "DevTool not enabled, turn on the switch!", 0).show();
    L17:
        LynxLog.b(3, TAG, "DevTool not enabled, turn on the switch!");
        return false;
    L19:
        setAppInfo(this.mContext, null);
        ILynxDevToolService r12 = sDevToolService;
        if (r12 != null) goto L22;
        LynxLog.b(4, TAG, "failed to get DevToolService");
        return false;
    L22:
        return r12.globalDebugBridgePrepareRemoteDebug(r5).booleanValue();
    }

    public void registerCardListener(e r5) {
        if (initRemoteDebugIfNecessary() == true) goto L5;
        return;
    L5:
        ILynxDevToolService r10 = sDevToolService;
        if (r10 == null) goto L9;
        r10.globalDebugBridgeRegisterCardListener(r5);
        return;
    L9:
        LynxLog.b(4, TAG, "failed to get DevToolService");
    }

    public void setAppInfo(Context r5, Map<String, String> r10) {
        if (r10 == null) goto L5;
        this.mAppInfo.putAll(r10);
    L5:
        if (initRemoteDebugIfNecessary() == true) goto L7;
        return;
    L7:
        ILynxDevToolService r11 = sDevToolService;
        if (r11 == null) goto L11;
        r11.globalDebugBridgeSetAppInfo(r5, this.mAppInfo);
        return;
    L11:
        LynxLog.b(4, TAG, "failed to get DevToolService");
    }

    public void setContext(Context r5) {
        this.mContext = r5;
        if (initRemoteDebugIfNecessary() == true) goto L5;
        return;
    L5:
        ILynxDevToolService r10 = sDevToolService;
        if (r10 == null) goto L9;
        r10.globalDebugBridgeSetContext(r5);
        return;
    L9:
        LynxLog.b(4, TAG, "failed to get DevToolService");
    }

    public boolean shouldPrepareRemoteDebug(String r5) {
        if (initRemoteDebugIfNecessary() == true) goto L5;
        return false;
    L5:
        ILynxDevToolService r10 = sDevToolService;
        if (r10 != null) goto L8;
        LynxLog.b(4, TAG, "failed to get DevToolService");
        return false;
    L8:
        return r10.globalDebugBridgeShouldPrepareRemoteDebug(r5).booleanValue();
    }

    @Deprecated
    public void showDebugView(ViewGroup r5) {
    }

    private LynxDevtoolGlobalHelper() {
        this.remoteDebugAvailable = false;
        HashMap r5 = new HashMap();
        this.mAppInfo = r5;
        r5.put("sdkVersion", LynxEnv.inst().getLynxVersion());
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L6;
        initRemoteDebugIfNecessary();
        sDevToolService = (ILynxDevToolService) r.g().e(ILynxDevToolService.class);
        return;
    }

    public void setAppInfo(Context r5, String r10, String r11) {
        HashMap r12 = new HashMap();
        r12.put("App", r10);
        r12.put("AppVersion", r11);
        setAppInfo(r5, r12);
    }

    @Deprecated
    public void setAppInfo(String r5, String r10) {
        setAppInfo(null, r5, r10);
    }
}
