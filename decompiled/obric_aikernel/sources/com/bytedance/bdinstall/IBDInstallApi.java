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

    void addCustomParamsWithLevel(String r10, String r11, Level r12);

    void addHeaderChangeListener(boolean r10, HeaderUpdateListener r11);

    void addInstallListener(boolean r10, IInstallListener r11);

    String addNetCommonParams(Context r10, String r11, boolean r12, Level r13);

    String addNetCommonParams(Context r10, StringBuilder r11, String r12, boolean r13, Level r14);

    String addNetCommonParams(Context r10, StringBuilder r11, boolean r12, Level r13);

    void addOaidObserver(boolean r10, IOaidObserver r11);

    void addOnDataObserver(IDataObserver r10);

    void changeUriRuntimeAndReInstall(Env r10);

    void clearAndSetEnv(Env r10);

    void clearInstallInfoWhenSwitchChildMode(Env r10);

    IAdIdConfig getAdIdConfig();

    AppContext getAppContext();

    Env getCurrentEnv();

    boolean getCurrentHeader(JSONObject r10);

    String getDid();

    InstallInfo getInstallInfo();

    InstallOptions getInstallOptions();

    IParamFilter getParamsFilter();

    Map<String, String> getRequestHeader();

    void getSSIDs(Map<String, String> r10);

    void init(InstallOptions r10);

    void init(InstallOptions r10, Env r11);

    boolean isNewUserFirstLaunch();

    boolean isNewUserMode();

    boolean isNewUserModeAvailable();

    JSONObject loadOrGetHeader();

    NUApi newUserMode();

    void putCommonParams(Context r10, Map<String, String> r11, boolean r12, Level r13);

    void registerLifeCycleListener(Application r10);

    void removeCustomParamsWithLevel(String r10, Level r11);

    void removeHeaderChangeListener(HeaderUpdateListener r10);

    void removeInstallListener(IInstallListener r10);

    void removeOaidObserver(IOaidObserver r10);

    void removeOnDataObserver(IDataObserver r10);

    void resetAndReInstall(Context r10, Env r11, long r12, OnResetListener r13);

    void resetInstallInfoWhenSwitchChildMode(Context r10, Env r11, long r12, OnResetListener r13);

    void setAccount(Account r10);

    void setAdIdConfig(IAdIdConfig r10);

    void setAppContext(AppContext r10);

    void setAppTrack(Context r10, JSONObject r11);

    void setCommonExtraParam(IExtraParams r10);

    void setCustomHeader(Context r10, JSONObject r11);

    void setExecutor(ExecutorOptions r10, String r11);

    void setInstallInfo(InstallInfo r10);

    void setParamsFilter(IParamFilter r10);

    void setUserAgent(Context r10, String r11);

    void setUserUniqueId(Context r10, String r11);

    void start();

    void stopNetCommOpt(Context r10);

    InstallInfo tryGetFallbackInstallInfo(AppContext r10);

    void updateLanguageAndRegion(Context r10, String r11, String r12);

    InstallInfo waitingForInstallFinish(long r10);

    InstallInfo waitingForInstallFinishWithOldWay();
}
