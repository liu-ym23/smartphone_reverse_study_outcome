package com.obric.update.impl.v2.handler;

import android.content.Context;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016¨\u0006\u0019"}, d2 = {"com/obric/update/impl/v2/handler/ObricInitHandler$createAppCommonContext$1", "Lcom/bytedance/services/app/common/context/api/AppCommonContext;", "getContext", "Landroid/content/Context;", "getStringAppName", "", "getAppName", "getVersion", "getFeedbackAppKey", "getChannel", "getTweakedChannel", "getVersionCode", "", "getDeviceId", "getUpdateVersionCode", "getManifestVersionCode", "getManifestVersion", "getAid", "getSdkAppId", "getAbClient", "getAbFlag", "", "getAbVersion", "getAbGroup", "getAbFeature", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInitHandler$createAppCommonContext$1 implements AppCommonContext {
    public ObricInitHandler$createAppCommonContext$1() {
    }

    public String getAbClient() {
        return "";
    }

    public String getAbFeature() {
        return "";
    }

    public long getAbFlag() {
        return 0;
    }

    public String getAbGroup() {
        return "";
    }

    public String getAbVersion() {
        return "";
    }

    public String getFeedbackAppKey() {
        return "";
    }

    public int getAid() {
        return AppHost.a.getAppId();
    }

    public String getAppName() {
        return AppHost.a.getAppName();
    }

    public String getChannel() {
        return AppHost.a.getBuildChannel();
    }

    public Context getContext() {
        return AppHost.a.getApplication();
    }

    public String getDeviceId() {
        return IApplog.a.getDeviceId();
    }

    public String getManifestVersion() {
        return AppHost.a.getManifestVersionName();
    }

    public int getManifestVersionCode() {
        return AppHost.a.getManifestVersionCode();
    }

    public String getSdkAppId() {
        return String.valueOf(AppHost.a.getAppId());
    }

    public String getStringAppName() {
        return AppHost.a.getAppStringName();
    }

    public String getTweakedChannel() {
        return AppHost.a.getBuildChannel();
    }

    public int getUpdateVersionCode() {
        return AppHost.a.getUpdateVersionCode();
    }

    public String getVersion() {
        return AppHost.a.getVersionName();
    }

    public int getVersionCode() {
        return AppHost.a.getVersionCode();
    }
}
