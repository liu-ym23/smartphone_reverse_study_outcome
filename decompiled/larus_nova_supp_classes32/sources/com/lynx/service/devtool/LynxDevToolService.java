package com.lynx.service.devtool;

import android.content.Context;
import com.lynx.devtool.LynxDevtoolEnv;
import com.lynx.devtool.LynxGlobalDebugBridge;
import com.lynx.devtool.LynxInspectorOwner;
import com.lynx.devtool.logbox.LynxLogBoxWrapper;
import com.lynx.devtool.module.LynxDevToolSetModule;
import com.lynx.devtool.module.LynxTrailModule;
import com.lynx.devtool.module.LynxWebSocketModule;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.devtoolwrapper.ILynxLogBox;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.devtoolwrapper.LynxDevtoolCardListener;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.IServiceProvider;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\n\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0012\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0017J\b\u0010\u0019\u001a\u00020\bH\u0017J\b\u0010\u001a\u001a\u00020\bH\u0017J\b\u0010\u001b\u001a\u00020\bH\u0017J\u0012\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0012\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\"\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0015\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020 H\u0016¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J(\u0010+\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010-H\u0016J\u0015\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020 H\u0016¢\u0006\u0002\u0010'J\b\u00100\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\bH\u0017J\u0010\u00103\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\bH\u0017J\u0010\u00104\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\bH\u0017J\u0010\u00105\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\bH\u0017¨\u00067"}, d2 = {"Lcom/lynx/service/devtool/LynxDevToolService;", "Lcom/lynx/tasm/service/ILynxDevToolService;", "()V", "createInspectorOwner", "Lcom/lynx/devtoolwrapper/LynxBaseInspectorController;", "view", "Lcom/lynx/tasm/LynxView;", "debuggable", NameKeys.UnloadStrategy_No_Strategy, "createLogBox", "Lcom/lynx/devtoolwrapper/ILynxLogBox;", "devtool", "Lcom/lynx/devtoolwrapper/LynxDevtool;", "devtoolEnvInit", NameKeys.UnloadStrategy_No_Strategy, "ctx", "Landroid/content/Context;", "devtoolEnvSetDevToolLibraryLoader", "loader", "Lcom/lynx/tasm/INativeLibraryLoader;", "enableAllSessions", "getDevToolSetModuleClass", "Ljava/lang/Class;", "Lcom/lynx/jsbridge/LynxModule;", "getLoadQJSBridge", "getLoadV8Bridge", "getLogBoxPresetValue", "getLynxDebugPresetValue", "getLynxTrailModule", "getLynxWebSocketModuleClass", "globalDebugBridgeOnPerfMetricsEvent", "eventName", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.DATA_KEY, "Lorg/json/JSONObject;", "instanceId", NameKeys.UnloadStrategy_No_Strategy, "globalDebugBridgePrepareRemoteDebug", "scheme", "(Ljava/lang/String;)Ljava/lang/Boolean;", "globalDebugBridgeRegisterCardListener", "listener", "Lcom/lynx/devtoolwrapper/LynxDevtoolCardListener;", "globalDebugBridgeSetAppInfo", "appInfo", NameKeys.UnloadStrategy_No_Strategy, "globalDebugBridgeShouldPrepareRemoteDebug", LynxEventReporter.PROP_NAME_URL, "isDevtoolAttached", "setLoadQJSBridge", "value", "setLoadV8Bridge", "setLogBoxPresetValue", "setLynxDebugPresetValue", "Companion", "LynxDevToolService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxDevToolService implements ILynxDevToolService {
    public static final Companion Companion = null;
    private static final Lazy<LynxDevToolService> INSTANCE$delegate = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\n\u001a\u00020\u0004H\u0086\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/lynx/service/devtool/LynxDevToolService$Companion;", NameKeys.UnloadStrategy_No_Strategy, "()V", "INSTANCE", "Lcom/lynx/tasm/service/ILynxDevToolService;", "getINSTANCE$annotations", "getINSTANCE", "()Lcom/lynx/tasm/service/ILynxDevToolService;", "INSTANCE$delegate", "Lkotlin/Lazy;", "invoke", "LynxDevToolService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getINSTANCE$annotations() {
        }

        public final ILynxDevToolService getINSTANCE() {
            return (ILynxDevToolService) LynxDevToolService.access$getINSTANCE$delegate$cp().getValue();
        }

        public final ILynxDevToolService invoke() {
            return getINSTANCE();
        }
    }

    public static final ILynxDevToolService getINSTANCE() {
        return Companion.getINSTANCE();
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxDevToolService.CC.$default$getServiceClass(this);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r1) {
        IServiceProvider.CC.$default$onInitialize(this, r1);
    }

    static {
        Companion = new Companion(null);
        INSTANCE$delegate = LazyKt.lazy(LynxDevToolService$Companion$INSTANCE$2.INSTANCE);
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public void enableAllSessions() {
        LynxDevtoolEnv.inst().enableAllSessions();     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        LLog.e("LynxDevToolService", "enableAllSessions failed, " + e.getMessage());
        return;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "enableAllSessions failed, " + e.getMessage());
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public Class<? extends LynxModule> getDevToolSetModuleClass() {
        return LynxDevToolSetModule.class;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public Class<? extends LynxModule> getLynxTrailModule() {
        return LynxTrailModule.class;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public Class<? extends LynxModule> getLynxWebSocketModuleClass() {
        return LynxWebSocketModule.class;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public boolean isDevtoolAttached() {
        return LynxDevtoolEnv.inst().isAttached();
    L8:
        e = move-exception;
        LLog.e("LynxDevToolService", "isDevtoolAttached failed, " + e.getMessage());
        return false;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "isDevtoolAttached failed, " + e.getMessage());
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().shouldLoadQJSBridge() instead")
    public boolean getLoadQJSBridge() {
        return DevToolSettings.inst().bootstrap().shouldLoadQJSBridge();
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().shouldLoadV8Bridge() instead")
    public boolean getLoadV8Bridge() {
        return DevToolSettings.inst().bootstrap().shouldLoadV8Bridge();
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().isLogBoxEnabled() instead")
    public boolean getLogBoxPresetValue() {
        return DevToolSettings.inst().bootstrap().isLogBoxEnabled();
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().isLynxDebugEnabled() instead")
    public boolean getLynxDebugPresetValue() {
        return DevToolSettings.inst().bootstrap().isLynxDebugEnabled();
    }

    public LynxDevToolService() {
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$delegate$cp() {
        return INSTANCE$delegate;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public ILynxLogBox createLogBox(LynxDevtool r5) {
        Intrinsics.checkNotNullParameter(r5, "devtool");
        return new LynxLogBoxWrapper(r5);
    L8:
        e = move-exception;
        LLog.e("LynxDevToolService", "createLogBox failed, " + e.getMessage());
        return null;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "createLogBox failed, " + e.getMessage());
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public void devtoolEnvInit(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        LynxDevtoolEnv.inst().init(r4);     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        LLog.e("LynxDevToolService", "devtoolEnvInit failed, " + e.getMessage());
        return;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "devtoolEnvInit failed, " + e.getMessage());
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public void devtoolEnvSetDevToolLibraryLoader(INativeLibraryLoader r4) {
        LynxDevtoolEnv.inst().setDevToolLibraryLoader(r4);     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        LLog.e("LynxDevToolService", "devtoolEnvSetDevToolLibraryLoader failed, " + e.getMessage());
        return;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "devtoolEnvSetDevToolLibraryLoader failed, " + e.getMessage());
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public Boolean globalDebugBridgePrepareRemoteDebug(String r4) {
        Intrinsics.checkNotNullParameter(r4, "scheme");
        return Boolean.valueOf(LynxGlobalDebugBridge.getInstance().prepareRemoteDebug(r4));
    L8:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgePrepareRemoteDebug failed, " + e.getMessage());
        return Boolean.FALSE;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgePrepareRemoteDebug failed, " + e.getMessage());
        return Boolean.FALSE;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public void globalDebugBridgeRegisterCardListener(LynxDevtoolCardListener r4) {
        LynxGlobalDebugBridge.getInstance().registerCardListener(r4);     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeRegisterCardListener failed, " + e.getMessage());
        return;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeRegisterCardListener failed, " + e.getMessage());
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public Boolean globalDebugBridgeShouldPrepareRemoteDebug(String r4) {
        Intrinsics.checkNotNullParameter(r4, LynxEventReporter.PROP_NAME_URL);
        return Boolean.valueOf(LynxGlobalDebugBridge.getInstance().shouldPrepareRemoteDebug(r4));
    L8:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeShouldPrepareRemoteDebug failed, " + e.getMessage());
        return Boolean.FALSE;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeShouldPrepareRemoteDebug failed, " + e.getMessage());
        return Boolean.FALSE;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().setLoadQJSBridge(value) instead")
    public void setLoadQJSBridge(boolean r2) {
        DevToolSettings.inst().bootstrap().setLoadQJSBridge(r2);
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().setLoadV8Bridge(value) instead")
    public void setLoadV8Bridge(boolean r2) {
        DevToolSettings.inst().bootstrap().setLoadV8Bridge(r2);
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().setLogBoxEnabled(value) instead")
    public void setLogBoxPresetValue(boolean r2) {
        DevToolSettings.inst().bootstrap().setLogBoxEnabled(r2);
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    @Deprecated(message = "Use DevToolSettings.inst().bootstrap().setLynxDebugEnabled(value) instead")
    public void setLynxDebugPresetValue(boolean r2) {
        DevToolSettings.inst().bootstrap().setLynxDebugEnabled(r2);
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public LynxBaseInspectorController createInspectorOwner(LynxView r5, boolean r6) {
        return new LynxInspectorOwner(r5, r6);
    L8:
        e = move-exception;
        LLog.e("LynxDevToolService", "createInspectorOwner failed, " + e.getMessage());
        return null;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "createInspectorOwner failed, " + e.getMessage());
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public void globalDebugBridgeSetAppInfo(Context r4, Map<String, String> r5) {
        LynxGlobalDebugBridge.getInstance().setAppInfo(r4, r5);     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeSetAppInfo failed, " + e.getMessage());
        return;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeSetAppInfo failed, " + e.getMessage());
    }

    @Override // com.lynx.tasm.service.ILynxDevToolService
    public void globalDebugBridgeOnPerfMetricsEvent(String r4, JSONObject r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        LynxGlobalDebugBridge.getInstance().onPerfMetricsEvent(r4, r5, r6);     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeOnPerfMetricsEvent failed, " + e.getMessage());
        return;
    L5:
        e = move-exception;
        LLog.e("LynxDevToolService", "globalDebugBridgeOnPerfMetricsEvent failed, " + e.getMessage());
    }
}
