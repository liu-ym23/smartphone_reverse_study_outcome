package com.lynx.devtoolwrapper;

import android.view.InputEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.behavior.LynxUIOwner;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface LynxBaseInspectorController {
    void attach(LynxView r1);

    void attachLynxUIOwnerToAgent(LynxUIOwner r1);

    void attachToDebugBridge(String r1);

    void continueCasting();

    void destroy();

    void endTestbench(String r1);

    String getDebugInfoUrl(String r1);

    long onBackgroundRuntimeCreated(String r1);

    void onGlobalPropsUpdated(TemplateData r1);

    void onMTSRuntimeCreated(long r1);

    void onPageUpdate();

    void onPerfMetricsEvent(String r1, JSONObject r2);

    void onReceiveMessageEvent(ReadableMap r1);

    void onRootViewInputEvent(InputEvent r1);

    void onTemplateAssemblerCreated(long r1);

    void onTemplateDataReset(TemplateData r1);

    void onTemplateDataUpdated(TemplateData r1);

    void pauseCasting();

    void reload(boolean r1, String r2, boolean r3, int r4, String r5);

    void setDebugInfoInterceptor(h6a.a r1);

    void setDevToolDelegate(IDevToolDelegate r1);

    void setReloadHelper(PageReloadHelper r1);

    void showErrorMessageOnConsole(LynxError r1);

    void showMessageOnConsole(String r1, int r2);

    void updateScreenMetrics(int r1, int r2, float r3);
}
