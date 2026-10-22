package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.webkit.GeolocationPermissions;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements IJsBridgeManager {
    public final /* synthetic */ y6.c a;

    public final ILiveHybridContainer getContainer() {
        return null;
    }

    public final void onGeolocationPermissionsHidePrompt() {
    }

    public final void onGeolocationPermissionsShowPrompt(String r1, GeolocationPermissions.Callback r2) {
    }

    public final void registerFromFactory(BaseJsBridgeMethodFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
    }

    public final void unregisterFromFactory(BaseJsBridgeMethodFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
    }

    public Activity getActivity() {
        return this.a.getActivity();
    }

    public final IJsBridgeMethodFactory getExposedMethodFactory() {
        return new l();
    }

    public final com.bytedance.ies.web.jsbridge2.d0 getJsBridge2() {
        return this.a.d();
    }

    public final List<String> getMethodNameList() {
        return new ArrayList();
    }

    public final com.bytedance.ies.web.jsbridge2.f0 getSupportJsBridge() {
        return this.a.a();
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> registerDefaultStatefulMethods() {
        return new LinkedHashMap();
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> registerDefaultStatelessMethods() {
        return new LinkedHashMap();
    }

    public final void release() {
        this.a.release();
    }

    public j(y6.c r1) {
        this.a = r1;
    }

    public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.a.registerMethod(r2, r3);
    }

    public final <T> void sendJsEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a.sendJSEvent(r2, r3);
    }

    public final <P, R> void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.g<P, R> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.a.registerMethod(r2, r3);
    }

    public final void registerMethod(String r2, n56.c r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.a.registerMethod(r2, r3);
    }
}
