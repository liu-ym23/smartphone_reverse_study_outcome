package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.NUApi;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IBDInstallApi {
    boolean activeManually();

    void addCustomParamsWithLevel(String r1, String r2, Level r3);

    void addHeaderChangeListener(boolean r1, HeaderUpdateListener r2);

    void addInstallListener(boolean r1, IInstallListener r2);

    String addNetCommonParams(Context r1, String r2, boolean r3, Level r4);

    String addNetCommonParams(Context r1, StringBuilder r2, String r3, boolean r4, Level r5);

    String addNetCommonParams(Context r1, StringBuilder r2, boolean r3, Level r4);

    void addOaidObserver(boolean r1, IOaidObserver r2);

    void addOnDataObserver(IDataObserver r1);

    void addRegisterCustomHeader(Context r1, JSONObject r2);

    void changeUriRuntimeAndReInstall(Env r1);

    void clearAndSetEnv(Env r1);

    void clearInstallInfoWhenSwitchChildMode(Env r1);

    IAdIdConfig getAdIdConfig();

    AppContext getAppContext();

    BDInstallConfig getBDInstallConfig();

    Env getCurrentEnv();

    boolean getCurrentHeader(JSONObject r1);

    String getDid();

    InstallInfo getInstallInfo();

    InstallOptions getInstallOptions();

    IParamFilter getParamsFilter();

    Map<String, String> getRequestHeader();

    void getSSIDs(Map<String, String> r1);

    void init(InstallOptions r1);

    void init(InstallOptions r1, Env r2);

    boolean isNewUserFirstLaunch();

    boolean isNewUserMode();

    boolean isNewUserModeAvailable();

    JSONObject loadOrGetHeader();

    NUApi newUserMode();

    void putCommonParams(Context r1, Map<String, String> r2, boolean r3, Level r4);

    void registerLifeCycleListener(Application r1);

    void removeCustomParamsWithLevel(String r1, Level r2);

    void removeHeaderChangeListener(HeaderUpdateListener r1);

    void removeInstallListener(IInstallListener r1);

    void removeOaidObserver(IOaidObserver r1);

    void removeOnDataObserver(IDataObserver r1);

    void resetAndReInstall(Context r1, Env r2, long r3, OnResetListener r5);

    void resetInstallInfoWhenSwitchChildMode(Context r1, Env r2, long r3, OnResetListener r5);

    void setAccount(Account r1);

    void setAdIdConfig(IAdIdConfig r1);

    void setAppContext(AppContext r1);

    void setAppTrack(Context r1, JSONObject r2);

    void setCommonExtraParam(IExtraParams r1);

    void setCustomHeader(Context r1, JSONObject r2);

    void setExecutor(ExecutorOptions r1, String r2);

    void setInstallInfo(InstallInfo r1);

    void setParamsFilter(IParamFilter r1);

    void setUserAgent(Context r1, String r2);

    void setUserUniqueId(Context r1, String r2);

    void start();

    void stopNetCommOpt(Context r1);

    InstallInfo tryGetFallbackInstallInfo(AppContext r1);

    void updateLanguageAndRegion(Context r1, String r2, String r3);

    InstallInfo waitingForInstallFinish(long r1);

    InstallInfo waitingForInstallFinishWithOldWay();
}
