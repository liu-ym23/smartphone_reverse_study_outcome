package com.obric.aikernel.middleware.api.appcontext;

import android.app.Application;
import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.middleware.api.store.IStoreManager;
import com.obric.aikernel.middleware.api.store.StoreManager;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppContext extends IAppConfig, IService {

    public static final class a {
        public static t7.a a(IAppContext r10) {
            return IStoreManager.a.a(StoreManager.INSTANCE, "AIKernel_repo_key", 0, 2, null);
        }

        public static /* synthetic */ void b(IAppContext r10, String r11, String r12, long r13, int r14, int r15, Object r16) {
            if (r16 != null) goto L12;
            if ((r15 & 4) == 0) goto L6;
            r13 = 0;
        L6:
            long r17 = r13;
            if ((r15 & 8) == 0) goto L9;
            r14 = 6;
        L9:
            r10.postRestart(r11, r12, r17, r14);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postRestart");
        }
    }

    /* synthetic */ String appEnv();

    void cacheDispatchThreadTid(String r10, long r11);

    /* synthetic */ String defaultTTEnvHeader();

    /* synthetic */ String defaultWebEnvHeader();

    /* synthetic */ String getAIKBizType();

    /* synthetic */ String getAIKTargetSoC();

    /* synthetic */ int getAid();

    t7.a getAikStore();

    int getAndroidUserId();

    /* synthetic */ String getAppName();

    long getAppStartTime();

    /* synthetic */ String getAppTrackerTag();

    Application getApplication();

    /* synthetic */ String getBuildInfo();

    /* synthetic */ String getChannel();

    Context getContext();

    Map<String, Long> getDispatchThreadTidSnapshot();

    /* synthetic */ String getDistributePath();

    /* synthetic */ String getHost(IAppConfig.HOST_TYPE r10);

    String getIid();

    /* synthetic */ String getModelDistPath();

    String getPackageName();

    int getPid();

    String getServerDeviceId();

    /* synthetic */ Map<String, Object> getSlardarExtras();

    /* synthetic */ int getUpdateVersionCode();

    String getUserId();

    /* synthetic */ int getVersionCode();

    /* synthetic */ String getVersionName();

    /* synthetic */ boolean isAdminMode();

    /* synthetic */ boolean isDebug();

    boolean isFirstColdBoot();

    /* synthetic */ boolean isGlobalVersion();

    boolean isLocalTest();

    void postRestart(String r10, String r11, long r12, int r13);

    void setApplicationContext(Application r10, Context r11);

    /* synthetic */ boolean testStubApp();
}
