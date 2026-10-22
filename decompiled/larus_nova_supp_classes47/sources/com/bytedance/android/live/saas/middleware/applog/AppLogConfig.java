package com.bytedance.android.live.saas.middleware.applog;

import javax.annotation.Nullable;
import ry.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class AppLogConfig {

    @Nullable
    private String appLogId;

    @Nullable
    private e hostPermission;

    @Nullable
    private IAppLog impl;
    private boolean isToBVersion;
    private boolean standalone;

    public AppLogConfig() {
        this.impl = null;
        this.standalone = false;
        this.isToBVersion = false;
        this.appLogId = null;
        this.hostPermission = null;
    }

    @Nullable
    public String getAppLogId() {
        return this.appLogId;
    }

    @Nullable
    public e getHostPermission() {
        return this.hostPermission;
    }

    @Nullable
    public IAppLog getImpl() {
        return this.impl;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isToBVersion() {
        return this.isToBVersion;
    }

    public void setAppLogId(@Nullable String r1) {
        this.appLogId = r1;
    }

    public void setHostPermission(@Nullable e r1) {
        this.hostPermission = r1;
    }

    public void setImpl(@Nullable IAppLog r1) {
        this.impl = r1;
    }

    public void setStandalone(boolean r1) {
        this.standalone = r1;
    }

    public void setToBVersion(boolean r1) {
        this.isToBVersion = r1;
    }

    public AppLogConfig(IAppLog r2, boolean r3) {
        this(r2, r3, false);
    }

    public AppLogConfig(IAppLog r2, boolean r3, boolean r4) {
        this(r2, r3, r4, null);
    }

    public AppLogConfig(IAppLog r7, boolean r8, boolean r9, @Nullable String r10) {
        this(r7, r8, r9, r10, null);
    }

    public AppLogConfig(IAppLog r1, boolean r2, boolean r3, @Nullable String r4, @Nullable e r5) {
        this.impl = r1;
        this.standalone = r2;
        this.isToBVersion = r3;
        this.appLogId = r4;
        this.hostPermission = r5;
    }
}
