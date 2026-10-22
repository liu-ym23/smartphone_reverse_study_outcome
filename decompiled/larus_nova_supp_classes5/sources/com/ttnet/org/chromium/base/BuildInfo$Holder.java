package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BuildInfo$Holder {
    private static BuildInfo sInstance;

    private BuildInfo$Holder() {
    }

    static {
        sInstance = new BuildInfo();
    }

    public static /* synthetic */ BuildInfo access$000() {
        return sInstance;
    }
}
