package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.appstate.AppLifeCycleListener;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.bdinstall.util.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public static void addCustomParamsWithLevel(String r1, String r2, Level r3) {
        getInstance().addCustomParamsWithLevel(r1, r2, r3);
    }

    public static void addHeaderChangeListener(boolean r2, HeaderUpdateListener r3) {
        HeaderUpdateListener r4 = (HeaderUpdateListener) ZeusTransformUtils.wrapperContextForParams(r3, HeaderUpdateListener.class, "com.obric.memorydata.plugin");
        getInstance().addHeaderChangeListener(r2, r4);
    }

    public static void addInstallListener(boolean r2, IInstallListener r3) {
        IInstallListener r4 = (IInstallListener) ZeusTransformUtils.wrapperContextForParams(r3, IInstallListener.class, "com.obric.memorydata.plugin");
        getInstance().addInstallListener(r2, r4);
    }

    public static String addNetCommonParams(Context r2, String r3, boolean r4, Level r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return getInstance().addNetCommonParams(r6, r3, r4, r5);
    }

    public static String addNetCommonParams(Context r6, StringBuilder r7, String r8, boolean r9, Level r10) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        return getInstance().addNetCommonParams(r1, r7, r8, r9, r10);
    }

    public static String addNetCommonParams(Context r6, StringBuilder r7, boolean r8, Level r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        return getInstance().addNetCommonParams(r1, r7, null, r8, r9);
    }

    public static void addOaidObserver(boolean r2, IOaidObserver r3) {
        IOaidObserver r4 = (IOaidObserver) ZeusTransformUtils.wrapperContextForParams(r3, IOaidObserver.class, "com.obric.memorydata.plugin");
        getInstance().addOaidObserver(r2, r4);
    }

    public static void addOnDataObserver(IDataObserver r2) {
        IDataObserver r3 = (IDataObserver) ZeusTransformUtils.wrapperContextForParams(r2, IDataObserver.class, "com.obric.memorydata.plugin");
        getInstance().addOnDataObserver(r3);
    }

    public static void addRegisterCustomHeader(Context r2, JSONObject r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        getInstance().addRegisterCustomHeader(r4, r3);
    }

    public static void changeUriRuntimeAndReInstall(Env r1) {
        getInstance().changeUriRuntimeAndReInstall(r1);
    }

    public static void clearAndSetEnv(Env r1) {
        getInstance().clearInstallInfoWhenSwitchChildMode(r1);
    }

    public static void clearInstallInfoWhenSwitchChildMode(Env r1) {
        getInstance().clearInstallInfoWhenSwitchChildMode(r1);
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

    public static BDInstallConfig getBDInstallConfig() {
        return getInstance().getBDInstallConfig();
    }

    public static Env getCurrentEnv() {
        return getInstance().getCurrentEnv();
    }

    public static boolean getCurrentHeader(JSONObject r1) {
        return getInstance().getCurrentHeader(r1);
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

    public static IBDInstallApi getInstance(String r0) {
        return BdInstallInstance.getInstance(r0);
    }

    public static IParamFilter getParamsFilter() {
        return getInstance().getParamsFilter();
    }

    public static Map<String, String> getRequestHeader() {
        return getInstance().getRequestHeader();
    }

    public static void getSSIDs(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        getInstance().getSSIDs(r3);
    }

    public static void init(InstallOptions r2) {
        getInstance().init(r2, Env.DEFAULT);
    }

    public static void init(InstallOptions r1, Env r2) {
        getInstance().init(r1, r2);
    }

    public static boolean isMainInstance(IBDInstallApi r2) {
        if (((IBDInstallApi) ZeusTransformUtils.wrapperContextForParams(r2, IBDInstallApi.class, "com.obric.memorydata.plugin")) != sDefaultInstance) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMainInstance(String r1) {
        if (BdInstallInstance.getInstance(r1) != sDefaultInstance) goto L5;
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
        if (ZeusTransformUtils.forName(Constants.NAME_NEW_USER_IMPL, "com.obric.memorydata.plugin") == null) goto L12;
        return true;
    L12:
        return false;
    L7:
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

    public static void putCommonParams(Context r2, Map<String, String> r3, boolean r4, Level r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        getInstance().putCommonParams(r6, r7, r4, r5);
    }

    static void registerLifeCycleListener(Application r2) {
        ((Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin")).registerActivityLifecycleCallbacks(sAppLifeCycleListener);
    }

    public static void removeCustomParamsWithLevel(String r1, Level r2) {
        getInstance().removeCustomParamsWithLevel(r1, r2);
    }

    public static void removeHeaderChangeListener(HeaderUpdateListener r2) {
        HeaderUpdateListener r3 = (HeaderUpdateListener) ZeusTransformUtils.wrapperContextForParams(r2, HeaderUpdateListener.class, "com.obric.memorydata.plugin");
        getInstance().removeHeaderChangeListener(r3);
    }

    public static void removeInstallListener(IInstallListener r2) {
        IInstallListener r3 = (IInstallListener) ZeusTransformUtils.wrapperContextForParams(r2, IInstallListener.class, "com.obric.memorydata.plugin");
        getInstance().removeInstallListener(r3);
    }

    public static void removeOaidObserver(IOaidObserver r2) {
        IOaidObserver r3 = (IOaidObserver) ZeusTransformUtils.wrapperContextForParams(r2, IOaidObserver.class, "com.obric.memorydata.plugin");
        getInstance().removeOaidObserver(r3);
    }

    public static void removeOnDataObserver(IDataObserver r2) {
        IDataObserver r3 = (IDataObserver) ZeusTransformUtils.wrapperContextForParams(r2, IDataObserver.class, "com.obric.memorydata.plugin");
        getInstance().removeOnDataObserver(r3);
    }

    public static void resetAndReInstall(Context r8, Env r9, long r10, OnResetListener r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r12, OnResetListener.class, "com.obric.memorydata.plugin");
        getInstance().resetInstallInfoWhenSwitchChildMode(r3, r9, r10, r7);
    }

    public static void resetInstallInfoWhenSwitchChildMode(Context r8, Env r9, long r10, OnResetListener r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r12, OnResetListener.class, "com.obric.memorydata.plugin");
        getInstance().resetInstallInfoWhenSwitchChildMode(r3, r9, r10, r7);
    }

    public static void setAccount(Account r1) {
        getInstance().setAccount(r1);
    }

    public static void setAdIdConfig(IAdIdConfig r2) {
        IAdIdConfig r3 = (IAdIdConfig) ZeusTransformUtils.wrapperContextForParams(r2, IAdIdConfig.class, "com.obric.memorydata.plugin");
        getInstance().setAdIdConfig(r3);
    }

    public static void setAppContext(AppContext r2) {
        AppContext r3 = (AppContext) ZeusTransformUtils.wrapperContextForParams(r2, AppContext.class, "com.obric.memorydata.plugin");
        getInstance().setAppContext(r3);
    }

    public static void setAppTrack(Context r2, JSONObject r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        getInstance().setAppTrack(r4, r3);
    }

    public static void setCommonExtraParam(IExtraParams r2) {
        IExtraParams r3 = (IExtraParams) ZeusTransformUtils.wrapperContextForParams(r2, IExtraParams.class, "com.obric.memorydata.plugin");
        getInstance().setCommonExtraParam(r3);
    }

    public static void setCustomHeader(Context r2, JSONObject r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        getInstance().setCustomHeader(r4, r3);
    }

    public static void setDebuggable(Boolean r0) {
        DrLog.DEBUG = r0.booleanValue();
    }

    public static void setExecutor(ExecutorOptions r1, String r2) {
        getInstance().setExecutor(r1, r2);
    }

    public static void setInstallInfo(InstallInfo r1) {
        getInstance().setInstallInfo(r1);
    }

    public static void setLogger(ILogger r2) {
        DrLog.setLogger((ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public static void setParamsFilter(IParamFilter r2) {
        IParamFilter r3 = (IParamFilter) ZeusTransformUtils.wrapperContextForParams(r2, IParamFilter.class, "com.obric.memorydata.plugin");
        getInstance().setParamsFilter(r3);
    }

    public static void setUserAgent(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        getInstance().setUserAgent(r4, r3);
    }

    public static void setUserUniqueId(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        getInstance().setUserUniqueId(r4, r3);
    }

    public static void start() {
        getInstance().start();
    }

    public static void stopNetCommOpt(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        getInstance().stopNetCommOpt(r3);
    }

    private static InstallInfo tryGetFallbackInstallInfo(AppContext r2) {
        AppContext r3 = (AppContext) ZeusTransformUtils.wrapperContextForParams(r2, AppContext.class, "com.obric.memorydata.plugin");
        return getInstance().tryGetFallbackInstallInfo(r3);
    }

    public static void updateLanguageAndRegion(Context r2, String r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        getInstance().updateLanguageAndRegion(r5, r3, r4);
    }

    public static InstallInfo waitingForInstallFinish(long r1) {
        return getInstance().waitingForInstallFinish(r1);
    }

    public static InstallInfo waitingForInstallFinishWithOldWay() {
        return getInstance().waitingForInstallFinishWithOldWay();
    }
}
