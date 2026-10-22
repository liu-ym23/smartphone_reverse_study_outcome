package com.ss.android.lark.chameleon.pluginsystem;

import android.webkit.ValueCallback;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.pluginsystem.WebPluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseWebPlugin<T extends WebPluginHost> extends BasePlugin<T> {
    private List<String> autoUnbinds;

    public Web getWeb() {
        return getHost().getWeb();
    }

    public BaseWebPlugin() {
    }

    public void execJS(String r2) {
        execJS(r2, null);
    }

    public void loadUrl(String r2) {
        Web r0 = getWeb();
        if (r0 == null) goto L6;
        r0.loadUrl(r2);
        return;
    }

    public void unbindBridgeHandler(String r2) {
        Web r0 = getWeb();
        if (r0 == null) goto L6;
        r0.unbindJSHandler(r2);
        return;
    }

    public void bindBridgeHandler(String r2, BridgeHandler r3) {
        innerbindJSHandler(r2, r3, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r2, BridgeHandler r3) {
        innerbindJSHandler(r2, r3, true);
    }

    public void bindJSHandler(String r2, JSHandler r3) {
        innerbindJSHandler(r2, r3, false);
    }

    public void bindJSHandlerAutoUnbind(String r2, JSHandler r3) {
        innerbindJSHandler(r2, r3, true);
    }

    public void execJS(String r2, JsonObject r3) {
        execJS(r2, r3, null);
    }

    public void onDetachFromUIContainer(T r1, UIContainer r2) {
        super.onDetachFromUIContainer(r1, r2);
        List<String> r3 = this.autoUnbinds;
        if (r3 == null) goto L8;
        Iterator<String> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        unbindBridgeHandler(r4.next());
        goto L6
    L10:
        return;
    }

    public void bindBridgeHandler(String r2, BridgeHandlerV2 r3) {
        innerbindJSHandler(r2, r3, false);
    }

    public void bindBridgeHandlerAutoUnbind(String r2, BridgeHandlerV2 r3) {
        innerbindJSHandler(r2, r3, true);
    }

    public void execJS(String r2, NonProguard r3) {
        execJS(r2, r3, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, UIContainer r2) {
        onDetachFromUIContainer((WebPluginHost) r1, r2);
    }

    private void innerbindJSHandler(String r3, Object r4, boolean r5) {
        Web r0 = getWeb();
        if (r0 != null) goto L5;
    L13:
        if (r5 == true) goto L15;
        return;
    L15:
        if (this.autoUnbinds != null) goto L18;
        this.autoUnbinds = new ArrayList();
    L18:
        if (this.autoUnbinds.contains(r3) == true) goto L22;
        this.autoUnbinds.add(r3);
        return;
    L22:
        return;
    L5:
        if ((r4 instanceof BridgeHandlerV2) == false) goto L8;
        r0.bindJSHandler(r3, (BridgeHandlerV2) r4);
        goto L13
    L8:
        if ((r4 instanceof BridgeHandler) == false) goto L11;
        r0.bindJSHandler(r3, (BridgeHandler) r4);
        goto L13
    L11:
        if ((r4 instanceof JSHandler) == false) goto L13;
        r0.bindJSHandler(r3, (JSHandler) r4);
        goto L13
    }

    public void execJS(String r2, JsonObject r3, ValueCallback<String> r4) {
        Web r0 = getWeb();
        if (r0 == null) goto L6;
        r0.execJS(r2, r3, r4);
        return;
    }

    public void execJS(String r2, NonProguard r3, ValueCallback<String> r4) {
        Web r0 = getWeb();
        if (r0 == null) goto L6;
        r0.execJS(r2, r3, r4);
        return;
    }
}
