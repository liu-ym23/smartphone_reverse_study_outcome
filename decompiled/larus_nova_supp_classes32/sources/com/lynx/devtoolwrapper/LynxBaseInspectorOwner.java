package com.lynx.devtoolwrapper;

import com.lynx.react.bridge.Callback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface LynxBaseInspectorOwner {
    void addCDPEventListener(String r1, CDPEventListener r2);

    void getConsoleObject(String r1, boolean r2, Callback r3);

    void invokeCDPFromSDK(String r1, CDPResultCallback r2);

    void registerGlobalPropsUpdatedObserver(GlobalPropsObserver r1);

    void reload(boolean r1);

    void reload(boolean r1, String r2, boolean r3, int r4);

    void removeCDPEventListener(String r1);

    void setDebugTag(String r1);

    void setLynxInspectorConsoleDelegate(Object r1);
}
