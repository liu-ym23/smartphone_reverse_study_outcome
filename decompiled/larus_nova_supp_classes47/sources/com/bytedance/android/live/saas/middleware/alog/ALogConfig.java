package com.bytedance.android.live.saas.middleware.alog;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class ALogConfig {

    @Nullable
    private ILogProtocol aLogService;
    private boolean isDebug;
    private boolean standalone;

    @Nullable
    public ILogProtocol getALogService() {
        return this.aLogService;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void setALogService(ILogProtocol r1) {
        this.aLogService = r1;
    }

    public void setDebug(boolean r1) {
        this.isDebug = r1;
    }

    public void setStandalone(boolean r1) {
        this.standalone = r1;
    }

    public ALogConfig(@Nullable ILogProtocol r2, boolean r3) {
        this(r2, r3, false);
    }

    public ALogConfig(@Nullable ILogProtocol r1, boolean r2, boolean r3) {
        this.aLogService = r1;
        this.standalone = r2;
        this.isDebug = r3;
    }
}
