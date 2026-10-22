package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTSamplingSettingProvider$TTSlaSamplingRule {
    public boolean mEnableApiAllUpload;
    public boolean mEnableBaseApiAll;
    public String[] mHostPatternWhiteList;
    public String[] mPathContainWhiteList;
    public String[] mPathEqualWhiteList;
    public String[] mPathPrefixWhiteList;
    public String[] mPathRegexWhiteList;
    public String[] mUrlRegexBlackList;
    public String[] mUrlRegexWhiteList;

    public TTSamplingSettingProvider$TTSlaSamplingRule() {
    }

    public String[] getHostPatternWhiteList() {
        return this.mHostPatternWhiteList;
    }

    public String[] getPathContainWhiteList() {
        return this.mPathContainWhiteList;
    }

    public String[] getPathEqualWhiteList() {
        return this.mPathEqualWhiteList;
    }

    public String[] getPathPrefixWhiteList() {
        return this.mPathPrefixWhiteList;
    }

    public String[] getPathRegexWhiteList() {
        return this.mPathRegexWhiteList;
    }

    public String[] getUrlRegexBlackList() {
        return this.mUrlRegexBlackList;
    }

    public String[] getUrlRegexWhiteList() {
        return this.mUrlRegexWhiteList;
    }

    public boolean isEnableApiAllUpload() {
        return this.mEnableApiAllUpload;
    }

    public boolean isEnableBaseApiAll() {
        return this.mEnableBaseApiAll;
    }
}
