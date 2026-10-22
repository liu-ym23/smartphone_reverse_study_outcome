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

    void changeUriRuntimeAndReInstall(Env r1);

    void clearAndSetEnv(Env r1);

    Env getCurEnv();

    String getDid();

    boolean getHeader(JSONObject r1);

    InstallInfo getInstallInfo();

    void init(InstallOptions r1, Env r2);

    boolean isNewUserFirstLaunch();

    JSONObject loadOrGetHeader();

    void registerLifeCycleListener(Application r1);

    void resetAndReInstall(Context r1, Env r2, long r3, OnResetListener r5);

    void setAccount(Account r1);

    void setInstallInfo(InstallInfo r1);

    void start();

    void updateHeader(Context r1, Map<String, String> r2, boolean r3, boolean r4);

    void updateMemoryHeader(Context r1, Map<String, Object> r2);
}
