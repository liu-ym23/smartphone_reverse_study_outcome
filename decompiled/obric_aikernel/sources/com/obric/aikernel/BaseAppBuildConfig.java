package com.obric.aikernel;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig;
import com.obric.aikernel.middleware.api.appcontext.IAppConfig;
import com.obric.aikernel.runtime.utils.ModelCenterConfigs;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface BaseAppBuildConfig extends IAppBuildConfig {

    public static final class a {
        public static String a(BaseAppBuildConfig r10) {
            return "";
        }

        public static String b(BaseAppBuildConfig r10) {
            return "";
        }

        public static String c(BaseAppBuildConfig r10) {
            return "";
        }

        public static String d(BaseAppBuildConfig r10) {
            return "obric";
        }

        public static String e(BaseAppBuildConfig r10) {
            return "qcom";
        }

        public static int f(BaseAppBuildConfig r10) {
            return 570851;
        }

        public static String g(BaseAppBuildConfig r10) {
            return "aikernel";
        }

        public static String h(BaseAppBuildConfig r10) {
            return AppContext.INSTANCE.getPackageName();
        }

        public static String i(BaseAppBuildConfig r10) {
            return "HEAD 5f362ad18e20260910-15:02:11";
        }

        public static String j(BaseAppBuildConfig r10) {
            return com.obric.aikernel.api.b.f4431a.a().c("update");
        }

        private static String k(BaseAppBuildConfig r10) {
            return AppContext.INSTANCE.getChannel();
        }

        public static String l(BaseAppBuildConfig r10) {
            return "/api/v1/" + ModelCenterConfigs.f5396a.a() + "/distribute";
        }

        public static String m(BaseAppBuildConfig r10, IAppConfig.HOST_TYPE r11) {
            Intrinsics.checkNotNullParameter(r11, "hostType");
            return ModelCenterConfigs.f5396a.c();
        }

        public static String n(BaseAppBuildConfig r10) {
            return "/api/v1/" + ModelCenterConfigs.f5396a.a() + "/aikernel_distribute";
        }

        public static Map<String, Object> o(BaseAppBuildConfig r10) {
            LinkedHashMap r11 = new LinkedHashMap();
            r11.put("device_tag", k(r10));
            return r11;
        }

        public static int p(BaseAppBuildConfig r10) {
            return 500010400;
        }

        public static int q(BaseAppBuildConfig r10) {
            return 500010400;
        }

        public static String r(BaseAppBuildConfig r10) {
            return "5.0.1.4.0";
        }

        public static boolean s(BaseAppBuildConfig r10) {
            return false;
        }

        public static boolean t(BaseAppBuildConfig r10) {
            return false;
        }

        public static boolean u(BaseAppBuildConfig r10) {
            return false;
        }

        public static boolean v(BaseAppBuildConfig r10) {
            return false;
        }
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String appEnv();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String defaultTTEnvHeader();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String defaultWebEnvHeader();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getAIKBizType();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getAIKTargetSoC();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    int getAid();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getAppName();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getAppTrackerTag();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getBuildInfo();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getChannel();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getDistributePath();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getHost(IAppConfig.HOST_TYPE r10);

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getModelDistPath();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    Map<String, Object> getSlardarExtras();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    int getUpdateVersionCode();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    int getVersionCode();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    String getVersionName();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    boolean isAdminMode();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    boolean isDebug();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    boolean isGlobalVersion();

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    boolean testStubApp();
}
