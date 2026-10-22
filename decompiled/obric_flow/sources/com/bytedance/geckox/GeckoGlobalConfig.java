package com.bytedance.geckox;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class GeckoGlobalConfig extends BaseGeckoConfig {
    private final String mAppChannel;
    private final long mAppColdStartTime;
    private final ENVType mEnv;
    private final IMonitorConfig mMonitorConfig;
    private final IRequestTagHeaderProvider mRequestTagHeaderProvider;

    @Keep
    public static class Builder extends BaseGeckoConfig.BaseGeckoConfigBuilder<Builder> {
        private String appChannel;
        private long appColdStartTime;
        private ENVType env;
        private IMonitorConfig monitorConfig;
        private IRequestTagHeaderProvider requestTagHeaderProvider;

        public Builder(Context r5) {
            super(r5.getApplicationContext());
        }

        public static /* synthetic */ ENVType access$000(Builder r5) {
            return r5.env;
        }

        public static /* synthetic */ IRequestTagHeaderProvider access$100(Builder r5) {
            return r5.requestTagHeaderProvider;
        }

        public static /* synthetic */ IMonitorConfig access$200(Builder r5) {
            return r5.monitorConfig;
        }

        public static /* synthetic */ String access$300(Builder r5) {
            return r5.appChannel;
        }

        public static /* synthetic */ long access$400(Builder r5) {
            return r5.appColdStartTime;
        }

        public Builder appChannel(String r5) {
            this.appChannel = r5;
            return this;
        }

        public Builder appColdStartTime(long r5) {
            this.appColdStartTime = r5;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder appId(long r5) {
            return appId(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder appVersion(String r5) {
            return appVersion(r5);
        }

        public GeckoGlobalConfig build() {
            return new GeckoGlobalConfig(this, null);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder checkUpdateExecutor(Executor r5) {
            return checkUpdateExecutor(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder deviceId(String r5) {
            return deviceId(r5);
        }

        public Builder env(ENVType r5) {
            this.env = r5;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder host(String r5) {
            return host(r5);
        }

        public Builder monitorConfig(IMonitorConfig r5) {
            this.monitorConfig = r5;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder netStack(ta.b r5) {
            return netStack(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder region(String r5) {
            return region(r5);
        }

        public Builder requestTagHeaderProvider(IRequestTagHeaderProvider r5) {
            this.requestTagHeaderProvider = r5;
            return this;
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder statisticMonitor(ya.a r5) {
            return statisticMonitor(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder updateExecutor(Executor r5) {
            return updateExecutor(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public /* bridge */ /* synthetic */ BaseGeckoConfig.BaseGeckoConfigBuilder useMMap(boolean r5) {
            return useMMap(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appId(long r5) {
            return (Builder) super.appId(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder appVersion(String r5) {
            return (Builder) super.appVersion(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder checkUpdateExecutor(Executor r5) {
            return (Builder) super.checkUpdateExecutor(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder deviceId(String r5) {
            return (Builder) super.deviceId(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder host(String r5) {
            return (Builder) super.host(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder netStack(ta.b r5) {
            return (Builder) super.netStack(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder region(String r5) {
            return (Builder) super.region(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder statisticMonitor(ya.a r5) {
            return (Builder) super.statisticMonitor(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder updateExecutor(Executor r5) {
            return (Builder) super.updateExecutor(r5);
        }

        @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
        public Builder useMMap(boolean r5) {
            return (Builder) super.useMMap(r5);
        }
    }

    @Keep
    public static final enum ENVType extends Enum<ENVType> {
        private static final /* synthetic */ ENVType[] $VALUES = null;
        public static final ENVType BOE = null;
        public static final ENVType DEV = null;
        public static final ENVType PROD = null;
        private int val;

        static {
            ENVType r5 = new ENVType("BOE", 0, 1);
            BOE = r5;
            ENVType r10 = new ENVType("DEV", 1, 1);
            DEV = r10;
            ENVType r11 = new ENVType("PROD", 2, 2);
            PROD = r11;
            $VALUES = new ENVType[]{r5, r10, r11};
        }

        private ENVType(String r5, int r10, int r11) {
            super(r5, r10);
            this.val = r11;
        }

        public static ENVType valueOf(String r5) {
            return (ENVType) Enum.valueOf(ENVType.class, r5);
        }

        public static ENVType[] values() {
            return (ENVType[]) $VALUES.clone();
        }

        public int getVal() {
            return this.val;
        }
    }

    @Keep
    public interface IMonitorConfig {
        String getChannel();

        Map<String, String> getCommonParams();

        String getMonitorHost();

        String getPackageId();

        String getUpdateVersionCode();

        boolean isOversea();
    }

    @Keep
    public interface IRequestTagHeaderProvider {
        Pair<String, String> getRequestTagHeader(boolean r5);
    }

    public /* synthetic */ GeckoGlobalConfig(Builder r5, k r10) {
        this(r5);
    }

    public String getAppChannel() {
        return this.mAppChannel;
    }

    public long getAppColdStartTime() {
        return this.mAppColdStartTime;
    }

    public ENVType getEnv() {
        return this.mEnv;
    }

    public IMonitorConfig getMonitorConfig() {
        return this.mMonitorConfig;
    }

    public IRequestTagHeaderProvider getRequestTagHeaderProvider() {
        return this.mRequestTagHeaderProvider;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig
    public void setDeviceId(String r5) {
        this.mDeviceId = r5;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig
    public void setHost(String r5) {
        this.mHost = r5;
    }

    private GeckoGlobalConfig(Builder r5) {
        super(r5);
        ENVType r10 = Builder.access$000(r5);
        this.mEnv = r10;
        if (r10 == null) goto L11;
        this.mRequestTagHeaderProvider = Builder.access$100(r5);
        this.mMonitorConfig = Builder.access$200(r5);
        this.mAppChannel = Builder.access$300(r5);
        if (Builder.access$400(r5) != 0) goto L8;
        this.mAppColdStartTime = System.currentTimeMillis();
        return;
    L8:
        this.mAppColdStartTime = Builder.access$400(r5);
        return;
    L11:
        throw new IllegalArgumentException("env is required");
    }
}
