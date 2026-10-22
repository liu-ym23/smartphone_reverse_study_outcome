package com.lynx.tasm.service;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.h;
import java.util.Map;
import java.util.Set;
import mm.a;
import mm.c;
import mm.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxDevToolService extends IServiceProvider {
    c createInspectorOwner(@Nullable LynxView r5, boolean r10);

    a createLogBox(@NonNull LynxDevtool r5);

    void devtoolEnvInit(Context r5);

    void devtoolEnvSetDevToolLibraryLoader(h r5);

    Class<? extends LynxModule> getDevToolSetModuleClass();

    Class<? extends LynxModule> getDevToolWebSocketModuleClass();

    boolean getDevtoolBooleanEnv(String r5, Boolean r10);

    Set<String> getDevtoolGroupEnv(String r5);

    Integer getDevtoolIntEnv(String r5, Integer r10);

    boolean getLoadJsBridge();

    boolean getLogBoxPresetValue();

    boolean getLynxDebugPresetValue();

    Class<? extends LynxModule> getLynxTrailModule();

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxDevToolService.class;
    }

    void globalDebugBridgeOnPerfMetricsEvent(String r5, @NonNull JSONObject r10, int r11);

    Boolean globalDebugBridgePrepareRemoteDebug(String r5);

    void globalDebugBridgeRegisterCardListener(e r5);

    void globalDebugBridgeSetAppInfo(Context r5, Map<String, String> r10);

    void globalDebugBridgeSetContext(Context r5);

    Boolean globalDebugBridgeShouldPrepareRemoteDebug(String r5);

    void globalDebugBridgeStartRecord();

    boolean isDevtoolAttached();

    void setDevtoolEnv(String r5, Object r10);

    void setDevtoolGroupEnv(String r5, Set<String> r10);

    void setLoadJsBridge(boolean r5);

    void setLogBoxPresetValue(boolean r5);

    void setLynxDebugPresetValue(boolean r5);
}
