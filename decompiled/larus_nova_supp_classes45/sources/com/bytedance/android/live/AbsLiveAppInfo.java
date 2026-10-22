package com.bytedance.android.live;

import com.bytedance.android.live.saas.middleware.IAppInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class AbsLiveAppInfo implements IAppInfo {
    public AbsLiveAppInfo() {
    }

    public String apiHost() {
        return "webcast-open.douyin.com";
    }

    public String boeLane() {
        return "";
    }

    public String hostAppId() {
        return "";
    }

    public boolean isBoe() {
        return false;
    }

    public abstract boolean isFreeFlow();

    public boolean isPPE() {
        return false;
    }

    public String ppeLane() {
        return "";
    }

    public int hostAid() {
        return appId();
    }

    public int sdkVersion() {
        return com.bytedance.android.livesdk.paas.c.b();
    }

    public int webcastId() {
        return appId();
    }
}
