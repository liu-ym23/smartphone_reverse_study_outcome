package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class StorageSettings {
    private Account account;
    private String fileName;
    private boolean isAnonymous;
    private boolean isLocalTest;
    private boolean needSharedStorage;
    private InstallOptions options;
    private SharedPreferences sp;
    private String suffix;

    public StorageSettings() {
        this.needSharedStorage = false;
    }

    public Account getAccount() {
        return this.account;
    }

    String getFileName() {
        return this.fileName;
    }

    public InstallOptions getOptions() {
        return this.options;
    }

    public SharedPreferences getSp() {
        return this.sp;
    }

    String getSuffix() {
        return this.suffix;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    boolean isLocalTest() {
        return this.isLocalTest;
    }

    public boolean isNeedSharedStorage() {
        return this.needSharedStorage;
    }

    public void setAccount(Account r1, String r2) {
        this.account = r1;
        this.suffix = r2;
    }

    void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public void setLocalTest(boolean r1) {
        this.isLocalTest = r1;
    }

    public void setNeedSharedStorage(boolean r1) {
        this.needSharedStorage = r1;
    }

    public void setOptions(InstallOptions r1) {
        this.options = r1;
    }

    public void setSp(SharedPreferences r3) {
        this.sp = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.class, "com.obric.memorydata.plugin");
    }
}
