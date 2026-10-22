package com.ss.android.lark.chameleon.pluginsystem;

import android.content.Context;
import android.webkit.ValueCallback;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseWebService implements WebService {
    private static final String TAG = "BaseWebService";
    private Set<String> autoUnbinds;
    private boolean visibleToUser;

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    private Web f7web;

    public Web getWeb() {
        if (this.f7web != null) goto L6;
        Log.e(TAG, new IllegalStateException("Web not attached or detached !").toString());
    L6:
        return this.f7web;
    }

    public BaseWebService() {
        this.autoUnbinds = new HashSet();
    }

    public Context getContext() {
        Web r0 = getWeb();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getContext();
    }

    public boolean isVisibleToUser() {
        return this.visibleToUser;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onAttachToWeb(Web r1) {
        this.f7web = r1;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onDetachFromWeb(Web r2) {
        Iterator<String> r3 = this.autoUnbinds.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        unbindBridgeHandler(r3.next());
        goto L4
    L6:
        this.autoUnbinds.clear();
        this.f7web = null;
    }

    public void unbindBridgeHandler(String r2) {
        Web r0 = getWeb();
        if (r0 == null) goto L5;
        r0.unbindJSHandler(r2);
        return;
    L5:
        Log.e(TAG, "unbindBridgeHandler while web null");
    }

    public boolean bindBridgeHandler(String r2, BridgeHandlerV2 r3) {
        Web r0 = getWeb();
        if (r0 == null) goto L6;
        r0.bindJSHandler(r2, r3);
        return true;
    L6:
        Log.e(TAG, "bindBridgeHandler while web null");
        return false;
    }

    public void bindBridgeHandlerAutoUnbind(String r1, BridgeHandlerV2 r2) {
        if (bindBridgeHandler(r1, r2) == false) goto L6;
        this.autoUnbinds.add(r1);
        return;
    }

    public void execJS(String r2, JsonObject r3) {
        execJS(r2, r3, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onUserVisibleChanged(Web r1, boolean r2) {
        this.visibleToUser = r2;
    }

    public void execJS(String r2, NonProguard r3) {
        execJS(r2, r3, null);
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
