package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.appstate.AppLifeCycleListener;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.bdinstall.util.Constants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class BDInstall {
    private static final AppLifeCycleListener sAppLifeCycleListener = null;
    private static IBDInstallApi sDefaultInstance;

    static {
        sAppLifeCycleListener = new AppLifeCycleListener();
        sDefaultInstance = new BdInstallInstance();
    }

    public BDInstall() {
    }

    public static boolean activeManually() {
        return getInstance().activeManually();
    }

    public static void addCustomParamsWithLevel(String r10, String r11, Level r12) {
        getInstance().addCustomParamsWithLevel(r10, r11, r12);
    }

    public static void addHeaderChangeListener(boolean r10, HeaderUpdateListener r11) {
        getInstance().addHeaderChangeListener(r10, r11);
    }

    public static void addInstallListener(boolean r10, IInstallListener r11) {
        getInstance().addInstallListener(r10, r11);
    }

    public static String addNetCommonParams(Context r10, String r11, boolean r12, Level r13) {
        return getInstance().addNetCommonParams(r10, r11, r12, r13);
    }

    public static String addNetCommonParams(Context r10, StringBuilder r11, String r12, boolean r13, Level r14) {
        return getInstance().addNetCommonParams(r10, r11, r12, r13, r14);
    }

    public static String addNetCommonParams(Context r10, StringBuilder r11, boolean r12, Level r13) {
        return getInstance().addNetCommonParams(r10, r11, null, r12, r13);
    }

    public static void addOaidObserver(boolean r10, IOaidObserver r11) {
        getInstance().addOaidObserver(r10, r11);
    }

    public static void addOnDataObserver(IDataObserver r10) {
        getInstance().addOnDataObserver(r10);
    }

    public static void changeUriRuntimeAndReInstall(Env r10) {
        getInstance().changeUriRuntimeAndReInstall(r10);
    }

    public static void clearAndSetEnv(Env r10) {
        getInstance().clearInstallInfoWhenSwitchChildMode(r10);
    }

    public static void clearInstallInfoWhenSwitchChildMode(Env r10) {
        getInstance().clearInstallInfoWhenSwitchChildMode(r10);
    }

    public static IAdIdConfig getAdIdConfig() {
        return getInstance().getAdIdConfig();
    }

    public static AppContext getAppContext() {
        return getInstance().getAppContext();
    }

    public static AppLifeCycleListener getAppLifeCycleListener() {
        return sAppLifeCycleListener;
    }

    public static Env getCurrentEnv() {
        return getInstance().getCurrentEnv();
    }

    public static boolean getCurrentHeader(JSONObject r10) {
        return getInstance().getCurrentHeader(r10);
    }

    public static String getDid() {
        return getInstance().getDid();
    }

    public static InstallInfo getInstallInfo() {
        return getInstance().getInstallInfo();
    }

    static InstallOptions getInstallOptions() {
        return getInstance().getInstallOptions();
    }

    public static IBDInstallApi getInstance() {
        return sDefaultInstance;
    }

    public static IBDInstallApi getInstance(String r10) {
        return BdInstallInstance.getInstance(r10);
    }

    public static IParamFilter getParamsFilter() {
        return getInstance().getParamsFilter();
    }

    public static Map<String, String> getRequestHeader() {
        return getInstance().getRequestHeader();
    }

    public static void getSSIDs(Map<String, String> r10) {
        getInstance().getSSIDs(r10);
    }

    public static void init(InstallOptions r10) {
        getInstance().init(r10, Env.DEFAULT);
    }

    public static void init(InstallOptions r10, Env r11) {
        getInstance().init(r10, r11);
    }

    public static boolean isMainInstance(IBDInstallApi r10) {
        if (r10 != sDefaultInstance) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMainInstance(String r10) {
        if (BdInstallInstance.getInstance(r10) != sDefaultInstance) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public static boolean isNewUserFirstLaunch() {
        return getInstance().isNewUserFirstLaunch();
    }

    public static boolean isNewUserMode() {
        return getInstance().isNewUserMode();
    }

    public static boolean isNewUserModeAvailable() {
        Class.forName(Constants.NAME_NEW_USER_IMPL);     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static final boolean isSupportMultiInstance() {
        return true;
    }

    public static JSONObject loadOrGetHeader() {
        return getInstance().loadOrGetHeader();
    }

    public static IBDInstallApi newInstance() {
        return new BdInstallInstance();
    }

    public static NUApi newUserMode() {
        return getInstance().newUserMode();
    }

    public static void putCommonParams(Context r10, Map<String, String> r11, boolean r12, Level r13) {
        getInstance().putCommonParams(r10, r11, r12, r13);
    }

    static void registerLifeCycleListener(Application r10) {
        r10.registerActivityLifecycleCallbacks(sAppLifeCycleListener);
    }

    public static void removeCustomParamsWithLevel(String r10, Level r11) {
        getInstance().removeCustomParamsWithLevel(r10, r11);
    }

    public static void removeHeaderChangeListener(HeaderUpdateListener r10) {
        getInstance().removeHeaderChangeListener(r10);
    }

    public static void removeInstallListener(IInstallListener r10) {
        getInstance().removeInstallListener(r10);
    }

    public static void removeOaidObserver(IOaidObserver r10) {
        getInstance().removeOaidObserver(r10);
    }

    public static void removeOnDataObserver(IDataObserver r10) {
        getInstance().removeOnDataObserver(r10);
    }

    public static void resetAndReInstall(Context r10, Env r11, long r12, OnResetListener r13) {
        getInstance().resetInstallInfoWhenSwitchChildMode(r10, r11, r12, r13);
    }

    public static void resetInstallInfoWhenSwitchChildMode(Context r10, Env r11, long r12, OnResetListener r13) {
        getInstance().resetInstallInfoWhenSwitchChildMode(r10, r11, r12, r13);
    }

    public static void setAccount(Account r10) {
        getInstance().setAccount(r10);
    }

    public static void setAdIdConfig(IAdIdConfig r10) {
        getInstance().setAdIdConfig(r10);
    }

    public static void setAppContext(AppContext r10) {
        getInstance().setAppContext(r10);
    }

    public static void setAppTrack(Context r10, JSONObject r11) {
        getInstance().setAppTrack(r10, r11);
    }

    public static void setCommonExtraParam(IExtraParams r10) {
        getInstance().setCommonExtraParam(r10);
    }

    public static void setCustomHeader(Context r10, JSONObject r11) {
        getInstance().setCustomHeader(r10, r11);
    }

    public static void setDebuggable(Boolean r10) {
        DrLog.DEBUG = r10.booleanValue();
    }

    public static void setExecutor(ExecutorOptions r10, String r11) {
        getInstance().setExecutor(r10, r11);
    }

    public static void setInstallInfo(InstallInfo r10) {
        getInstance().setInstallInfo(r10);
    }

    public static void setLogger(ILogger r10) {
        DrLog.setLogger(r10);
    }

    @Deprecated
    public static void setParamsFilter(IParamFilter r10) {
        getInstance().setParamsFilter(r10);
    }

    public static void setUserAgent(Context r10, String r11) {
        getInstance().setUserAgent(r10, r11);
    }

    public static void setUserUniqueId(Context r10, String r11) {
        getInstance().setUserUniqueId(r10, r11);
    }

    public static void start() {
        getInstance().start();
    }

    public static void stopNetCommOpt(Context r10) {
        getInstance().stopNetCommOpt(r10);
    }

    private static InstallInfo tryGetFallbackInstallInfo(AppContext r10) {
        return getInstance().tryGetFallbackInstallInfo(r10);
    }

    public static void updateLanguageAndRegion(Context r10, String r11, String r12) {
        getInstance().updateLanguageAndRegion(r10, r11, r12);
    }

    public static InstallInfo waitingForInstallFinish(long r10) {
        return getInstance().waitingForInstallFinish(r10);
    }

    public static InstallInfo waitingForInstallFinishWithOldWay() {
        return getInstance().waitingForInstallFinishWithOldWay();
    }
}
