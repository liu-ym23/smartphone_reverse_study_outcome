package com.bytedance.bdinstall.service;

import android.accounts.Account;

/* JADX INFO: loaded from: classes.dex */
public interface IInstallParameters {
    public static final String FAKE_ANDROID_ID = "9774d56d682e549c";

    void clearAll();

    String getClientUDID();

    String getDeviceId();

    String getOpenUdid(boolean r10);

    void setAccount(Account r10);

    void updateDeviceId(String r10);
}
