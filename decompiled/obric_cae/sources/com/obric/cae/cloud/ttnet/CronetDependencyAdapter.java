package com.obric.cae.cloud.ttnet;

import c2.e;
import com.obric.cae.cloud.applog.ByteIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.c;
import org.chromium.d;
import org.chromium.f;
import org.json.JSONException;
import org.json.JSONObject;
import y8.a;

/* JADX INFO: loaded from: classes.dex */
public class CronetDependencyAdapter extends a {
    public static CronetDependencyAdapter INSTANCE = null;
    private static final String TAG = "CronetDependencyAdapter";

    static {
        INSTANCE = new CronetDependencyAdapter();
    }

    public CronetDependencyAdapter() {
    }

    public static void inject() {
        d r8 = d.a();
        r8.f9798a = INSTANCE;
        c r10 = c.c();
        CronetDependencyAdapter r11 = INSTANCE;
        r10.getClass();
        if (r11 == null) goto L27;
        ArrayList r12 = f.b(r11.getClass());     // Catch: Throwable -> L19
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.isEmpty() == true) goto L29;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L19
    L11:
        if (r13.hasNext() == false) goto L31;
        if ("com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider".equals(((Class) r13.next()).getName()) == false) goto L11;
        if (d.a().loggerDebug() == false) goto L17;
        d.a().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L19
    L17:
        r10.f9796a = r11;     // Catch: Throwable -> L19
        return;
    L31:
        return;
    L29:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return ByteIOUtils.APP_ID;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return ByteIOUtils.APP_NAME;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return ByteIOUtils.APP_CHANNEL;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        return ByteIOUtils.getGlobalDid();
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return AppConstants.MANIFEST_VERSION_CODE;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return AppConstants.UPDATE_VERSION_CODE;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return "";
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return AppConstants.VERSION_CODE;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return AppConstants.VERSION_NAME;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return false;
    }

    @Override // y8.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r8, String r10) {
        e.b(r10, new JSONObject(r8));     // Catch: JSONException -> L4
        return;
    }
}
