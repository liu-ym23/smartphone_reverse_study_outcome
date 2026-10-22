package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.InstallOptions;

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

    public void setAccount(Account r10, String r11) {
        this.account = r10;
        this.suffix = r11;
    }

    void setAnonymous(boolean r10) {
        this.isAnonymous = r10;
    }

    public void setFileName(String r10) {
        this.fileName = r10;
    }

    public void setLocalTest(boolean r10) {
        this.isLocalTest = r10;
    }

    public void setNeedSharedStorage(boolean r10) {
        this.needSharedStorage = r10;
    }

    public void setOptions(InstallOptions r10) {
        this.options = r10;
    }

    public void setSp(SharedPreferences r10) {
        this.sp = r10;
    }
}
