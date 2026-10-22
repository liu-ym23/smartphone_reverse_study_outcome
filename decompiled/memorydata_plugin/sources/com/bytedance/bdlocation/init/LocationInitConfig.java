package com.bytedance.bdlocation.init;

import android.app.Application;
import android.content.Context;
import com.bytedance.bdlocation.callback.BDRestrictedMode;
import com.bytedance.bdlocation.callback.IDYHostInfoProvider;
import com.bytedance.bdlocation.callback.ILocationInfoExtra;
import com.bytedance.bdlocation.callback.IPermissionChecker;
import com.bytedance.bdlocation.event.IEventManager;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.log.Printer;
import com.bytedance.bdlocation.network.ICustomNetworkApi;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LocationInitConfig {
    private boolean isPrivacyConfirmed;
    private long mAppBootTime;
    private String mAppId;
    private String mAppVersion;
    private BackgroundProvider mBackgroundProvider;
    private String mBaseUrl;
    private Map<String, Object> mBpeaCerts;
    private String mChannel;
    private Context mContext;
    private IDYHostInfoProvider mDYHostInfoProvider;
    private boolean mDebug;
    private String mDid;
    private boolean mEnableBackgroundLocation;
    private boolean mEnableHARCollect;
    private boolean mEnableSelfStartService;
    private IEventManager mEventManager;
    private ILocationInfoExtra mILocationInfoExtra;
    private Locale mLocale;
    private int mLocateType;
    private ICustomNetworkApi mNetworkApi;
    private String mPackageName;
    private IPermissionChecker mPermissionChecker;
    private boolean mPollingUpload;
    private Printer mPrinter;
    private BDRestrictedMode mRestrictedMode;
    private String mUpdateVersionCode;
    private String mWorldView;

    public static class Builder {
        private long mAppBootTime;
        private String mAppId;
        private String mAppVersion;
        private BackgroundProvider mBackgroundProvider;
        private String mBaseUrl;
        private Map<String, Object> mBpeaCerts;
        private String mChannel;
        private Context mContext;
        private IDYHostInfoProvider mDYHostInfoProvider;
        private boolean mDebug;
        private String mDid;
        private boolean mEnableBackgroundLocation;
        private boolean mEnableHARService;
        private boolean mEnableSelfStartService;
        private IEventManager mEventManager;
        private ILocationInfoExtra mILocationInfoExtra;
        private boolean mIsPrivacyConfirmed;
        private Locale mLocale;
        private int mLocateType;
        private ICustomNetworkApi mNetworkApi;
        private String mPackageName;
        private IPermissionChecker mPermissionChecker;
        private boolean mPollingUpload;
        private Printer mPrinter;
        private BDRestrictedMode mRestrictedMode;
        private String mUpdateVersionCode;
        private String mWorldView;

        public Builder(Application r4) {
            Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
            this.mBaseUrl = "";
            this.mDid = "";
            this.mAppId = "";
            this.mChannel = "";
            this.mAppVersion = "";
            this.mUpdateVersionCode = "";
            this.mPackageName = "";
            this.mIsPrivacyConfirmed = false;
            this.mDebug = false;
            this.mPollingUpload = false;
            this.mLocateType = 3;
            this.mEnableHARService = false;
            this.mEnableBackgroundLocation = false;
            this.mEnableSelfStartService = true;
            if (r5 == null) goto L10;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Context r6 = r5;
            if (r0 == null) goto L7;
            r6 = r0;
        L7:
            this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            return;
        L10:
            throw new RuntimeException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }

        public LocationInitConfig build() {
            LocationInitConfig r0 = new LocationInitConfig();
            r0.setBaseUrl(this.mBaseUrl);
            r0.setRestrictedMode(this.mRestrictedMode);
            r0.setCustomNetworkApi(this.mNetworkApi);
            r0.setDid(this.mDid);
            r0.setAppId(this.mAppId);
            r0.setChannel(this.mChannel);
            r0.setAppVersion(this.mAppVersion);
            r0.setUpdateVersionCode(this.mUpdateVersionCode);
            r0.setPackageName(this.mPackageName);
            r0.setContext(this.mContext);
            r0.setPrivacyConfirmed(this.mIsPrivacyConfirmed);
            r0.setDebug(this.mDebug);
            r0.setBpeaCerts(this.mBpeaCerts);
            r0.setWorldView(this.mWorldView);
            r0.setLocale(this.mLocale);
            r0.setALogPrinter(this.mPrinter);
            r0.setPollingUpload(this.mPollingUpload);
            r0.setBackgroundProvider(this.mBackgroundProvider);
            r0.setEventManager(this.mEventManager);
            r0.setLocateType(this.mLocateType);
            r0.setEnableHARCollect(this.mEnableHARService);
            r0.setAppBootTime(this.mAppBootTime);
            r0.setILocationInfoExtra(this.mILocationInfoExtra);
            r0.setDYHostInfoProvider(this.mDYHostInfoProvider);
            r0.setPermissionChecker(this.mPermissionChecker);
            r0.setEnableBackgroundLocation(this.mEnableBackgroundLocation);
            r0.setEnableSelfStartService(this.mEnableSelfStartService);
            return r0;
        }

        public int getLocateType() {
            return this.mLocateType;
        }

        public Builder isPrivacyConfirmed(boolean r1) {
            this.mIsPrivacyConfirmed = r1;
            return this;
        }

        public Builder setALogPrinter(Printer r3) {
            this.mPrinter = (Printer) ZeusTransformUtils.wrapperContextForParams(r3, Printer.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setAppBootTime(long r3) {
            Logger.i("appBootTime:" + r3);
            this.mAppBootTime = r3;
            return this;
        }

        public Builder setAppId(String r1) {
            this.mAppId = r1;
            return this;
        }

        public Builder setAppVersion(String r1) {
            this.mAppVersion = r1;
            return this;
        }

        public Builder setBackgroundProvider(BackgroundProvider r1) {
            this.mBackgroundProvider = r1;
            return this;
        }

        public Builder setBaseUrl(String r1) {
            this.mBaseUrl = r1;
            return this;
        }

        public Builder setBpeaCerts(Map<String, Object> r3) {
            this.mBpeaCerts = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setChannel(String r1) {
            this.mChannel = r1;
            return this;
        }

        public Builder setCustomNetworkApi(ICustomNetworkApi r3) {
            this.mNetworkApi = (ICustomNetworkApi) ZeusTransformUtils.wrapperContextForParams(r3, ICustomNetworkApi.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setDYHostInfoProvider(IDYHostInfoProvider r3) {
            this.mDYHostInfoProvider = (IDYHostInfoProvider) ZeusTransformUtils.wrapperContextForParams(r3, IDYHostInfoProvider.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setDebug(boolean r1) {
            this.mDebug = r1;
            return this;
        }

        public Builder setDid(String r1) {
            this.mDid = r1;
            return this;
        }

        public Builder setEnableBackgroundLocation(boolean r1) {
            this.mEnableBackgroundLocation = r1;
            return this;
        }

        public Builder setEnableHARCollect(boolean r1) {
            this.mEnableHARService = r1;
            return this;
        }

        public Builder setEnableSelfStartService(boolean r1) {
            this.mEnableSelfStartService = r1;
            return this;
        }

        public Builder setEventManager(IEventManager r3) {
            this.mEventManager = (IEventManager) ZeusTransformUtils.wrapperContextForParams(r3, IEventManager.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setILocationInfoExtra(ILocationInfoExtra r3) {
            this.mILocationInfoExtra = (ILocationInfoExtra) ZeusTransformUtils.wrapperContextForParams(r3, ILocationInfoExtra.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setLocal(Locale r1) {
            this.mLocale = r1;
            return this;
        }

        public Builder setLocateType(int r1) {
            this.mLocateType = r1;
            return this;
        }

        public Builder setPackageName(String r1) {
            this.mPackageName = r1;
            return this;
        }

        public Builder setPermissionChecker(IPermissionChecker r3) {
            this.mPermissionChecker = (IPermissionChecker) ZeusTransformUtils.wrapperContextForParams(r3, IPermissionChecker.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setPollingUpload(boolean r1) {
            this.mPollingUpload = r1;
            return this;
        }

        public Builder setRestrictedMode(BDRestrictedMode r3) {
            this.mRestrictedMode = (BDRestrictedMode) ZeusTransformUtils.wrapperContextForParams(r3, BDRestrictedMode.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setUpdateVersionCode(String r1) {
            this.mUpdateVersionCode = r1;
            return this;
        }

        public Builder setWorldView(String r1) {
            this.mWorldView = r1;
            return this;
        }
    }

    public LocationInitConfig() {
        this.mDid = "";
        this.mAppId = "";
        this.mChannel = "";
        this.mAppVersion = "";
        this.mUpdateVersionCode = "";
        this.mPackageName = "";
        this.mBaseUrl = "";
        this.mDebug = false;
        this.mPollingUpload = false;
        this.mLocateType = 3;
        this.isPrivacyConfirmed = false;
        this.mEnableHARCollect = false;
        this.mEnableBackgroundLocation = false;
        this.mEnableSelfStartService = true;
    }

    public boolean enableBackgroundLocation() {
        return this.mEnableBackgroundLocation;
    }

    public boolean enableSelfStartService() {
        return this.mEnableSelfStartService;
    }

    public Printer getALogPrinter() {
        return this.mPrinter;
    }

    public long getAppBootTime() {
        return this.mAppBootTime;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public BackgroundProvider getBackgroundProvider() {
        return this.mBackgroundProvider;
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public Map<String, Object> getBpeaCerts() {
        return this.mBpeaCerts;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ICustomNetworkApi getCustomNetworkApi() {
        return this.mNetworkApi;
    }

    public IDYHostInfoProvider getDYHostInfoProvider() {
        return this.mDYHostInfoProvider;
    }

    public boolean getDebug() {
        return this.mDebug;
    }

    public String getDid() {
        return this.mDid;
    }

    public IEventManager getEventManager() {
        return this.mEventManager;
    }

    public ILocationInfoExtra getILocationInfoExtra() {
        return this.mILocationInfoExtra;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public IPermissionChecker getPermissionChecker() {
        return this.mPermissionChecker;
    }

    public BDRestrictedMode getRestrictedMode() {
        return this.mRestrictedMode;
    }

    public String getUpdateVersionCode() {
        return this.mUpdateVersionCode;
    }

    public String getWorldView() {
        return this.mWorldView;
    }

    public boolean isEnableHARCollect() {
        return this.mEnableHARCollect;
    }

    public boolean isPollingUpload() {
        return this.mPollingUpload;
    }

    public boolean isPrivacyConfirmed() {
        return this.isPrivacyConfirmed;
    }

    public void setALogPrinter(Printer r3) {
        this.mPrinter = (Printer) ZeusTransformUtils.wrapperContextForParams(r3, Printer.class, "com.obric.memorydata.plugin");
    }

    public void setAppBootTime(long r1) {
        this.mAppBootTime = r1;
    }

    public void setAppId(String r1) {
        this.mAppId = r1;
    }

    public void setAppVersion(String r1) {
        this.mAppVersion = r1;
    }

    public void setBackgroundProvider(BackgroundProvider r1) {
        this.mBackgroundProvider = r1;
    }

    public void setBaseUrl(String r1) {
        this.mBaseUrl = r1;
    }

    public void setBpeaCerts(Map<String, Object> r3) {
        this.mBpeaCerts = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void setChannel(String r1) {
        this.mChannel = r1;
    }

    public void setContext(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public void setCustomNetworkApi(ICustomNetworkApi r3) {
        this.mNetworkApi = (ICustomNetworkApi) ZeusTransformUtils.wrapperContextForParams(r3, ICustomNetworkApi.class, "com.obric.memorydata.plugin");
    }

    public void setDYHostInfoProvider(IDYHostInfoProvider r3) {
        this.mDYHostInfoProvider = (IDYHostInfoProvider) ZeusTransformUtils.wrapperContextForParams(r3, IDYHostInfoProvider.class, "com.obric.memorydata.plugin");
    }

    public void setDebug(boolean r1) {
        this.mDebug = r1;
    }

    public void setDid(String r1) {
        this.mDid = r1;
    }

    public void setEnableBackgroundLocation(boolean r1) {
        this.mEnableBackgroundLocation = r1;
    }

    public void setEnableHARCollect(boolean r1) {
        this.mEnableHARCollect = r1;
    }

    public void setEnableSelfStartService(boolean r1) {
        this.mEnableSelfStartService = r1;
    }

    public void setEventManager(IEventManager r3) {
        this.mEventManager = (IEventManager) ZeusTransformUtils.wrapperContextForParams(r3, IEventManager.class, "com.obric.memorydata.plugin");
    }

    public void setILocationInfoExtra(ILocationInfoExtra r3) {
        this.mILocationInfoExtra = (ILocationInfoExtra) ZeusTransformUtils.wrapperContextForParams(r3, ILocationInfoExtra.class, "com.obric.memorydata.plugin");
    }

    public void setLocale(Locale r1) {
        this.mLocale = r1;
    }

    public void setLocateType(int r1) {
        this.mLocateType = r1;
    }

    public void setPackageName(String r1) {
        this.mPackageName = r1;
    }

    public void setPermissionChecker(IPermissionChecker r3) {
        this.mPermissionChecker = (IPermissionChecker) ZeusTransformUtils.wrapperContextForParams(r3, IPermissionChecker.class, "com.obric.memorydata.plugin");
    }

    public void setPollingUpload(boolean r1) {
        this.mPollingUpload = r1;
    }

    public void setPrivacyConfirmed(boolean r1) {
        this.isPrivacyConfirmed = r1;
    }

    public void setRestrictedMode(BDRestrictedMode r3) {
        this.mRestrictedMode = (BDRestrictedMode) ZeusTransformUtils.wrapperContextForParams(r3, BDRestrictedMode.class, "com.obric.memorydata.plugin");
    }

    public void setUpdateVersionCode(String r1) {
        this.mUpdateVersionCode = r1;
    }

    public void setWorldView(String r1) {
        this.mWorldView = r1;
    }
}
