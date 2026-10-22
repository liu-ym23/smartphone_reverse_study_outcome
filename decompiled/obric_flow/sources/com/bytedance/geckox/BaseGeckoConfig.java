package com.bytedance.geckox;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.geckox.logger.GeckoLogger;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BaseGeckoConfig {
    protected Long mAppId;
    protected String mAppVersion;
    private final Context mContext;
    protected String mDeviceId;
    protected String mHost;
    protected ta.b mNetWork;
    private final ya.a mStatisticMonitor;
    private final boolean mUseMMap;

    @Keep
    public static class BaseGeckoConfigBuilder<T extends BaseGeckoConfigBuilder> {
        private Long appId;
        private String appVersion;
        private Context context;
        private String deviceId;
        private String host;
        private ta.b netWork;
        private ya.a statisticMonitor;
        private boolean useMMap;

        public BaseGeckoConfigBuilder(Context r5) {
            this.useMMap = true;
            this.context = r5;
        }

        public static /* synthetic */ Context access$000(BaseGeckoConfigBuilder r5) {
            return r5.context;
        }

        public static /* synthetic */ Long access$100(BaseGeckoConfigBuilder r5) {
            return r5.appId;
        }

        public static /* synthetic */ String access$200(BaseGeckoConfigBuilder r5) {
            return r5.appVersion;
        }

        public static /* synthetic */ String access$300(BaseGeckoConfigBuilder r5) {
            return r5.deviceId;
        }

        public static /* synthetic */ String access$400(BaseGeckoConfigBuilder r5) {
            return r5.host;
        }

        public static /* synthetic */ ta.b access$500(BaseGeckoConfigBuilder r5) {
            return r5.netWork;
        }

        public static /* synthetic */ boolean access$600(BaseGeckoConfigBuilder r5) {
            return r5.useMMap;
        }

        public static /* synthetic */ ya.a access$700(BaseGeckoConfigBuilder r5) {
            return r5.statisticMonitor;
        }

        public T appId(long r5) {
            this.appId = Long.valueOf(r5);
            return this;
        }

        public T appVersion(String r5) {
            this.appVersion = r5;
            return this;
        }

        @Deprecated
        public T checkUpdateExecutor(Executor r5) {
            return this;
        }

        public T deviceId(String r5) {
            this.deviceId = r5;
            return this;
        }

        public T host(String r5) {
            this.host = r5;
            return this;
        }

        public T netStack(ta.b r5) {
            this.netWork = r5;
            return this;
        }

        @Deprecated
        public T region(String r5) {
            return this;
        }

        public T statisticMonitor(ya.a r5) {
            this.statisticMonitor = r5;
            return this;
        }

        @Deprecated
        public T updateExecutor(Executor r5) {
            return this;
        }

        public T useMMap(boolean r5) {
            this.useMMap = r5;
            return this;
        }
    }

    public BaseGeckoConfig(BaseGeckoConfigBuilder r5) {
        Context r10 = BaseGeckoConfigBuilder.access$000(r5);
        this.mContext = r10;
        if (r10 == null) goto L31;
        this.mAppId = BaseGeckoConfigBuilder.access$100(r5);
        if (TextUtils.isEmpty(BaseGeckoConfigBuilder.access$200(r5)) == true) goto L32;
        this.mAppVersion = BaseGeckoConfigBuilder.access$200(r5);
    L12:
        this.mDeviceId = BaseGeckoConfigBuilder.access$300(r5);
        String r11 = BaseGeckoConfigBuilder.access$400(r5);
        this.mHost = r11;
        if (TextUtils.isEmpty(r11) == true) goto L29;
        if (this.mAppId == null) goto L27;
        if (TextUtils.isEmpty(this.mDeviceId) == true) goto L25;
        if (BaseGeckoConfigBuilder.access$500(r5) != null) goto L21;
        this.mNetWork = new ai.p(16);
    L22:
        this.mUseMMap = BaseGeckoConfigBuilder.access$600(r5);
        this.mStatisticMonitor = BaseGeckoConfigBuilder.access$700(r5);
        return;
    L21:
        this.mNetWork = BaseGeckoConfigBuilder.access$500(r5);
        goto L22
    L25:
        throw new IllegalArgumentException("deviceId key empty");
    L27:
        throw new IllegalArgumentException("appId is null");
    L29:
        throw new IllegalArgumentException("host is null");
    L32:
        String r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionName;     // Catch: Exception -> L8
    L10:
        this.mAppVersion = r12;
    L8:
        e = move-exception;
        GeckoLogger.a("getVersion:", e);
        r12 = "null";
        goto L10
    L31:
        throw new IllegalArgumentException("context == null");
    }

    public long getAppId() {
        return this.mAppId.longValue();
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getHost() {
        return this.mHost;
    }

    public ta.b getNetWork() {
        return this.mNetWork;
    }

    @Deprecated
    public String getRegion() {
        return "";
    }

    public ya.a getStatisticMonitor() {
        return this.mStatisticMonitor;
    }

    public boolean isUseMMap() {
        return this.mUseMMap;
    }

    public void setAppId(long r5) {
        this.mAppId = Long.valueOf(r5);
    }

    public void setDeviceId(String r5) {
        this.mDeviceId = r5;
    }

    public void setHost(String r5) {
        this.mHost = r5;
    }

    public void setNetWork(ta.b r5) {
        this.mNetWork = r5;
    }
}
