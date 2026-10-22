package com.bytedance.geckox.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Deprecated
public class LocalPackageModel {
    private String accessKey;
    private String channel;
    private String channelPath;
    private long latestVersion;

    public LocalPackageModel(String r5, String r10) {
        this.accessKey = r5;
        this.channel = r10;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getChannelPath() {
        return this.channelPath;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public void setAccessKey(String r5) {
        this.accessKey = r5;
    }

    public void setChannel(String r5) {
        this.channel = r5;
    }

    public void setChannelPath(String r5) {
        this.channelPath = r5;
    }

    public void setLatestVersion(long r5) {
        this.latestVersion = r5;
    }
}
