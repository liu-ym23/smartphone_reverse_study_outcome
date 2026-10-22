package com.ss.android.lark.diskmanage.clean.settings;

import com.ss.android.lark.diskmanage.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DeleteConfig implements NonProguard {
    private DeleteConfigItem deleteConfig;
    private ExpiredConfigItem expiredConfig;
    private RustConfigItem mainRustConfig;

    public String toString() {
        return "DeleteConfig{deleteConfig=" + this.deleteConfig + ", expiredConfig=" + this.expiredConfig + ", mainRustConfig=" + this.mainRustConfig + '}';
    }

    public DeleteConfig() {
        this.deleteConfig = new DeleteConfigItem();
        this.expiredConfig = new ExpiredConfigItem();
        this.mainRustConfig = new RustConfigItem();
    }

    public DeleteConfigItem getDeleteConfig() {
        return this.deleteConfig;
    }

    public ExpiredConfigItem getExpiredConfig() {
        return this.expiredConfig;
    }

    public RustConfigItem getMainRustConfig() {
        return this.mainRustConfig;
    }

    public void setDeleteConfig(DeleteConfigItem r1) {
        this.deleteConfig = r1;
    }

    public void setExpiredConfig(ExpiredConfigItem r1) {
        this.expiredConfig = r1;
    }

    public void setMainRustConfig(RustConfigItem r1) {
        this.mainRustConfig = r1;
    }
}
