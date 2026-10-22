package com.bytedance.bdinstall.service;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.OnResetListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IInstallService {
    boolean activeManually();

    void changeUriRuntimeAndReInstall(Env r10);

    void clearAndSetEnv(Env r10);

    Env getCurEnv();

    String getDid();

    boolean getHeader(JSONObject r10);

    InstallInfo getInstallInfo();

    void init(InstallOptions r10, Env r11);

    boolean isNewUserFirstLaunch();

    JSONObject loadOrGetHeader();

    void registerLifeCycleListener(Application r10);

    void resetAndReInstall(Context r10, Env r11, long r12, OnResetListener r13);

    void setAccount(Account r10);

    void setInstallInfo(InstallInfo r10);

    void start();

    void updateHeader(Context r10, Map<String, String> r11, boolean r12, boolean r13);

    void updateMemoryHeader(Context r10, Map<String, Object> r11);
}
