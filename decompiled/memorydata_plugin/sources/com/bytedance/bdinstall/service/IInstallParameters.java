package com.bytedance.bdinstall.service;

import android.accounts.Account;

/* JADX INFO: loaded from: classes.dex */
public interface IInstallParameters {
    public static final String FAKE_ANDROID_ID = "9774d56d682e549c";

    void clearAll();

    String getClientUDID();

    String getDeviceId();

    String getOpenUdid(boolean r1);

    void setAccount(Account r1);

    void updateDeviceId(String r1);
}
