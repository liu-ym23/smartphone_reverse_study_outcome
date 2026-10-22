package com.obric.memorydata.middleware.api.appcontext;

import com.bytedance.news.common.service.manager.IService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/api/appcontext/IAppBuildConfig;", "Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig;", "Lcom/bytedance/news/common/service/manager/IService;", "getUpdateVersionCode", "", "isAdminMode", "", "appEnv", "", "defaultTTEnvHeader", "defaultWebEnvHeader", "getAppTrackerTag", "isHostApp", "isPureAndroid", "getBuildInfo", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppBuildConfig extends IService, IAppConfig {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static boolean a(IAppBuildConfig r2) {
            IAppBuildConfig r3 = (IAppBuildConfig) ZeusTransformUtils.wrapperContextForParams(r2, IAppBuildConfig.class, "com.obric.memorydata.plugin");
            return true;
        }
    }

    String appEnv();

    String defaultTTEnvHeader();

    String defaultWebEnvHeader();

    String getAppTrackerTag();

    String getBuildInfo();

    int getUpdateVersionCode();

    boolean isAdminMode();

    boolean isHostApp();

    boolean isPureAndroid();
}
