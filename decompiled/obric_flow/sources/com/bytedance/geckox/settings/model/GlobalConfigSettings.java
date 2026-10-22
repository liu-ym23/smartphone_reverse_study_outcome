package com.bytedance.geckox.settings.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class GlobalConfigSettings {

    @SerializedName("req_meta")
    private ReqMeta reqMeta;

    @SerializedName("resource_meta")
    private ResourceMeta resourceMeta;

    @SerializedName("settings_config")
    private SettingsConfig settingsConfig;

    @SerializedName("version")
    private String version;

    @Keep
    public static class AccessKeyMetaInfo {

        @SerializedName("channels")
        private Map<String, ChannelMetaInfo> channels;

        @SerializedName("config")
        private CurrentLevelConfig config;

        public AccessKeyMetaInfo() {
        }

        public Map<String, ChannelMetaInfo> getChannels() {
            return this.channels;
        }

        public CurrentLevelConfig getConfig() {
            return this.config;
        }
    }

    @Keep
    public static class CDNFallBackConfig {

        @SerializedName("domains")
        private List<String> domains;

        @SerializedName("max_attempts")
        private int maxAttempts;

        @SerializedName("shuffle")
        private int shuffle;

        public CDNFallBackConfig() {
        }

        public List<String> getDomains() {
            return this.domains;
        }

        public int getMaxAttempts() {
            return this.maxAttempts;
        }

        public int getShuffle() {
            return this.shuffle;
        }
    }

    @Keep
    public static class CDNMultiVersion {

        @SerializedName("domains")
        private List<String> domains;

        public CDNMultiVersion() {
        }

        public List<String> getDomains() {
            return this.domains;
        }
    }

    @Keep
    public static class ChannelMetaInfo {

        @SerializedName("config")
        private CurrentLevelConfig config;

        public ChannelMetaInfo() {
        }

        public CurrentLevelConfig getConfig() {
            return this.config;
        }
    }

    @Keep
    public static class CurrentLevelConfig {

        @SerializedName("cdn_fallback")
        private CDNFallBackConfig cdnFallback;

        @SerializedName("cdn_multi_version")
        private CDNMultiVersion cdnMultiVersion;

        @SerializedName("pipeline")
        private List<PipelineStep> pipeline;

        @SerializedName("prefix_2_ak")
        private Map<String, String> prefix2AccessKey;

        public CurrentLevelConfig() {
        }

        public CDNMultiVersion getCDNMultiVersion() {
            return this.cdnMultiVersion;
        }

        public CDNFallBackConfig getCdnFallback() {
            return this.cdnFallback;
        }

        public List<PipelineStep> getPipeline() {
            return this.pipeline;
        }

        public Map<String, String> getPrefix2AccessKey() {
            return this.prefix2AccessKey;
        }
    }

    @Keep
    public static class PipelineStep {

        @SerializedName("no_cache")
        private int noCache;

        @SerializedName("type")
        private int type;

        @SerializedName("update")
        private int update;

        public PipelineStep() {
        }

        public int getNoCache() {
            return this.noCache;
        }

        public int getType() {
            return this.type;
        }

        public int getUpdate() {
            return this.update;
        }
    }

    @Keep
    public static class ReqMeta {

        @SerializedName("aks")
        private List<String> aks;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("polling_interval")
        private int pollingInterval;

        public ReqMeta() {
        }

        public List<String> getAks() {
            return this.aks;
        }

        public boolean getEnable() {
            return this.enable;
        }

        public int getPollingInterval() {
            return this.pollingInterval;
        }
    }

    @Keep
    public static class ResourceMeta {

        @SerializedName("access_keys")
        private Map<String, AccessKeyMetaInfo> accessKeys;

        @SerializedName("config")
        private CurrentLevelConfig config;

        public ResourceMeta() {
        }

        public Map<String, AccessKeyMetaInfo> getAccessKeys() {
            return this.accessKeys;
        }

        public CurrentLevelConfig getConfig() {
            return this.config;
        }

        public void setAccessKeys(Map<String, AccessKeyMetaInfo> r5) {
            this.accessKeys = r5;
        }
    }

    @Keep
    public static class SettingsConfig {

        @SerializedName("polling_interval")
        private long polling_interval;

        public SettingsConfig() {
        }

        public long getPollingInterval() {
            return this.polling_interval;
        }
    }

    public GlobalConfigSettings() {
    }

    public ReqMeta getReqMeta() {
        return this.reqMeta;
    }

    public ResourceMeta getResourceMeta() {
        return this.resourceMeta;
    }

    public SettingsConfig getSettingsConfig() {
        return this.settingsConfig;
    }

    public String getVersion() {
        return this.version;
    }

    public void setReqMeta(ReqMeta r5) {
        this.reqMeta = r5;
    }
}
