package com.lynx.tasm.service;

import android.content.Context;
import com.lynx.devtoolwrapper.ILynxLogBox;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxView;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxDevToolService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxDevToolService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxDevToolService r0) {
            return ILynxDevToolService.class;
        }
    }

    LynxBaseInspectorController createInspectorOwner(LynxView r1, boolean r2);

    ILynxLogBox createLogBox(LynxDevtool r1);

    void devtoolEnvInit(Context r1);

    void devtoolEnvSetDevToolLibraryLoader(INativeLibraryLoader r1);

    void enableAllSessions();

    Class<? extends LynxModule> getDevToolSetModuleClass();

    boolean getLoadQJSBridge();

    boolean getLoadV8Bridge();

    boolean getLogBoxPresetValue();

    boolean getLynxDebugPresetValue();

    Class<? extends LynxModule> getLynxTrailModule();

    Class<? extends LynxModule> getLynxWebSocketModuleClass();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    void globalDebugBridgeOnPerfMetricsEvent(String r1, JSONObject r2, int r3);

    Boolean globalDebugBridgePrepareRemoteDebug(String r1);

    void globalDebugBridgeRegisterCardListener(LynxDevtoolCardListener r1);

    void globalDebugBridgeSetAppInfo(Context r1, Map<String, String> r2);

    Boolean globalDebugBridgeShouldPrepareRemoteDebug(String r1);

    boolean isDevtoolAttached();

    void setLoadQJSBridge(boolean r1);

    void setLoadV8Bridge(boolean r1);

    void setLogBoxPresetValue(boolean r1);

    void setLynxDebugPresetValue(boolean r1);
}
