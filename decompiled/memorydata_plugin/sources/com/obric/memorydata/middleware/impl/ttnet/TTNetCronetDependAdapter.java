package com.obric.memorydata.middleware.impl.ttnet;

import com.bytedance.applog.AppLog;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetDependManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0019\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u0001`\u001cH\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/middleware/impl/ttnet/TTNetCronetDependAdapter;", "Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;", "<init>", "()V", "inJect", "", "loggerDebug", "", "getDeviceId", "", "getUserId", "getAppId", "getAppName", "getChannel", "getVersionCode", "getVersionName", "getUpdateVersionCode", "getManifestVersionCode", "sendAppMonitorEvent", "logContent", "logType", "getRegion", "getSysRegion", "getCarrierRegion", "getStoreIdc", "getOpaqueData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TTNetCronetDependAdapter extends AbsCronetDependAdapter {
    public static final TTNetCronetDependAdapter INSTANCE = null;

    static {
        INSTANCE = new TTNetCronetDependAdapter();
    }

    private TTNetCronetDependAdapter() {
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return String.valueOf(AppContext.INSTANCE.getAid());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return UserSettings.REPO_MEMORY_DATA;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return AppContext.INSTANCE.getChannel();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        return AppContext.INSTANCE.getServerDeviceId();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return AppContext.INSTANCE.getVersionName();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return String.valueOf(AppContext.INSTANCE.getUpdateVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return AppLog.getUserID();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return String.valueOf(AppContext.INSTANCE.getVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return AppContext.INSTANCE.getVersionName();
    }

    public final void inJect() {
        CronetDependManager.inst().setAdapter((ICronetDepend) ZeusTransformUtils.preCheckCast(this, ICronetDepend.class, "com.obric.memorydata.plugin"));
        CronetAppProviderManager.inst().setAdapter(this);
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return AppContext.INSTANCE.isDebug();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r1, String r2) {
        com.bytedance.apm.a.a(r2, new JSONObject(r1));     // Catch: JSONException -> L4
        return;
    }
}
