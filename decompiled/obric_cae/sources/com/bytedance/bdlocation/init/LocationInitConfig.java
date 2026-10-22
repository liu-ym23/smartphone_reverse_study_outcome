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

        public Builder(Application r8) {
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
            if (r8 == null) goto L10;
            Context r10 = r8.getApplicationContext();
            if (r10 == null) goto L7;
            r8 = r10;
        L7:
            this.mContext = r8;
            return;
        L10:
            throw new RuntimeException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }

        public LocationInitConfig build() {
            LocationInitConfig r8 = new LocationInitConfig();
            r8.setBaseUrl(this.mBaseUrl);
            r8.setRestrictedMode(this.mRestrictedMode);
            r8.setCustomNetworkApi(this.mNetworkApi);
            r8.setDid(this.mDid);
            r8.setAppId(this.mAppId);
            r8.setChannel(this.mChannel);
            r8.setAppVersion(this.mAppVersion);
            r8.setUpdateVersionCode(this.mUpdateVersionCode);
            r8.setPackageName(this.mPackageName);
            r8.setContext(this.mContext);
            r8.setPrivacyConfirmed(this.mIsPrivacyConfirmed);
            r8.setDebug(this.mDebug);
            r8.setBpeaCerts(this.mBpeaCerts);
            r8.setWorldView(this.mWorldView);
            r8.setLocale(this.mLocale);
            r8.setALogPrinter(this.mPrinter);
            r8.setPollingUpload(this.mPollingUpload);
            r8.setBackgroundProvider(this.mBackgroundProvider);
            r8.setEventManager(this.mEventManager);
            r8.setLocateType(this.mLocateType);
            r8.setEnableHARCollect(this.mEnableHARService);
            r8.setAppBootTime(this.mAppBootTime);
            r8.setILocationInfoExtra(this.mILocationInfoExtra);
            r8.setDYHostInfoProvider(this.mDYHostInfoProvider);
            r8.setPermissionChecker(this.mPermissionChecker);
            r8.setEnableBackgroundLocation(this.mEnableBackgroundLocation);
            r8.setEnableSelfStartService(this.mEnableSelfStartService);
            return r8;
        }

        public int getLocateType() {
            return this.mLocateType;
        }

        public Builder isPrivacyConfirmed(boolean r8) {
            this.mIsPrivacyConfirmed = r8;
            return this;
        }

        public Builder setALogPrinter(Printer r8) {
            this.mPrinter = r8;
            return this;
        }

        public Builder setAppBootTime(long r8) {
            Logger.i("appBootTime:" + r8);
            this.mAppBootTime = r8;
            return this;
        }

        public Builder setAppId(String r8) {
            this.mAppId = r8;
            return this;
        }

        public Builder setAppVersion(String r8) {
            this.mAppVersion = r8;
            return this;
        }

        public Builder setBackgroundProvider(BackgroundProvider r8) {
            this.mBackgroundProvider = r8;
            return this;
        }

        public Builder setBaseUrl(String r8) {
            this.mBaseUrl = r8;
            return this;
        }

        public Builder setBpeaCerts(Map<String, Object> r8) {
            this.mBpeaCerts = r8;
            return this;
        }

        public Builder setChannel(String r8) {
            this.mChannel = r8;
            return this;
        }

        public Builder setCustomNetworkApi(ICustomNetworkApi r8) {
            this.mNetworkApi = r8;
            return this;
        }

        public Builder setDYHostInfoProvider(IDYHostInfoProvider r8) {
            this.mDYHostInfoProvider = r8;
            return this;
        }

        public Builder setDebug(boolean r8) {
            this.mDebug = r8;
            return this;
        }

        public Builder setDid(String r8) {
            this.mDid = r8;
            return this;
        }

        public Builder setEnableBackgroundLocation(boolean r8) {
            this.mEnableBackgroundLocation = r8;
            return this;
        }

        public Builder setEnableHARCollect(boolean r8) {
            this.mEnableHARService = r8;
            return this;
        }

        public Builder setEnableSelfStartService(boolean r8) {
            this.mEnableSelfStartService = r8;
            return this;
        }

        public Builder setEventManager(IEventManager r8) {
            this.mEventManager = r8;
            return this;
        }

        public Builder setILocationInfoExtra(ILocationInfoExtra r8) {
            this.mILocationInfoExtra = r8;
            return this;
        }

        public Builder setLocal(Locale r8) {
            this.mLocale = r8;
            return this;
        }

        public Builder setLocateType(int r8) {
            this.mLocateType = r8;
            return this;
        }

        public Builder setPackageName(String r8) {
            this.mPackageName = r8;
            return this;
        }

        public Builder setPermissionChecker(IPermissionChecker r8) {
            this.mPermissionChecker = r8;
            return this;
        }

        public Builder setPollingUpload(boolean r8) {
            this.mPollingUpload = r8;
            return this;
        }

        public Builder setRestrictedMode(BDRestrictedMode r8) {
            this.mRestrictedMode = r8;
            return this;
        }

        public Builder setUpdateVersionCode(String r8) {
            this.mUpdateVersionCode = r8;
            return this;
        }

        public Builder setWorldView(String r8) {
            this.mWorldView = r8;
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

    public void setALogPrinter(Printer r8) {
        this.mPrinter = r8;
    }

    public void setAppBootTime(long r8) {
        this.mAppBootTime = r8;
    }

    public void setAppId(String r8) {
        this.mAppId = r8;
    }

    public void setAppVersion(String r8) {
        this.mAppVersion = r8;
    }

    public void setBackgroundProvider(BackgroundProvider r8) {
        this.mBackgroundProvider = r8;
    }

    public void setBaseUrl(String r8) {
        this.mBaseUrl = r8;
    }

    public void setBpeaCerts(Map<String, Object> r8) {
        this.mBpeaCerts = r8;
    }

    public void setChannel(String r8) {
        this.mChannel = r8;
    }

    public void setContext(Context r8) {
        this.mContext = r8;
    }

    public void setCustomNetworkApi(ICustomNetworkApi r8) {
        this.mNetworkApi = r8;
    }

    public void setDYHostInfoProvider(IDYHostInfoProvider r8) {
        this.mDYHostInfoProvider = r8;
    }

    public void setDebug(boolean r8) {
        this.mDebug = r8;
    }

    public void setDid(String r8) {
        this.mDid = r8;
    }

    public void setEnableBackgroundLocation(boolean r8) {
        this.mEnableBackgroundLocation = r8;
    }

    public void setEnableHARCollect(boolean r8) {
        this.mEnableHARCollect = r8;
    }

    public void setEnableSelfStartService(boolean r8) {
        this.mEnableSelfStartService = r8;
    }

    public void setEventManager(IEventManager r8) {
        this.mEventManager = r8;
    }

    public void setILocationInfoExtra(ILocationInfoExtra r8) {
        this.mILocationInfoExtra = r8;
    }

    public void setLocale(Locale r8) {
        this.mLocale = r8;
    }

    public void setLocateType(int r8) {
        this.mLocateType = r8;
    }

    public void setPackageName(String r8) {
        this.mPackageName = r8;
    }

    public void setPermissionChecker(IPermissionChecker r8) {
        this.mPermissionChecker = r8;
    }

    public void setPollingUpload(boolean r8) {
        this.mPollingUpload = r8;
    }

    public void setPrivacyConfirmed(boolean r8) {
        this.isPrivacyConfirmed = r8;
    }

    public void setRestrictedMode(BDRestrictedMode r8) {
        this.mRestrictedMode = r8;
    }

    public void setUpdateVersionCode(String r8) {
        this.mUpdateVersionCode = r8;
    }

    public void setWorldView(String r8) {
        this.mWorldView = r8;
    }
}
