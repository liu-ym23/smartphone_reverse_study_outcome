package com.ss.android.lark.passport_api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.larksuite.component.openplatform.plugins.config.LKPluginConfig;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passport.signinsdk_api.ISigninSdkApi;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.TenantInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.base.BaseStepData;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.passport.signinsdk_api.contants.ExternalSwitchReason;
import com.ss.android.lark.passport.signinsdk_api.contants.LogoutSource;
import com.ss.android.lark.passport.signinsdk_api.contants.SwitchReason;
import com.ss.android.lark.passport.signinsdk_api.country.CountryBean;
import com.ss.android.lark.passport.signinsdk_api.country.CountryFilterBean;
import com.ss.android.lark.passport.signinsdk_api.entity.DeviceId;
import com.ss.android.lark.passport.signinsdk_api.entity.DeviceSetting;
import com.ss.android.lark.passport.signinsdk_api.entity.LoginInfo;
import com.ss.android.lark.passport.signinsdk_api.entity.OpenPlatformClearDataConfig;
import com.ss.android.lark.passport.signinsdk_api.entity.SessionResult;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import com.ss.android.lark.passport.signinsdk_api.interfaces.IAccountChangeObserver;
import com.ss.android.lark.passport.signinsdk_api.interfaces.IAccountInterceptor;
import com.ss.android.lark.passport.signinsdk_api.interfaces.IDeviceManager;
import com.ss.android.lark.passport.signinsdk_api.interfaces.IDeviceService;
import com.ss.android.lark.passport.signinsdk_api.interfaces.ILoginService;
import dzb.d;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import org.json.JSONObject;
import szb.a;
import szb.c;
import szb.e;
import szb.f;
import szb.g;
import szb.h;
import szb.i;
import szb.j;
import szb.k;
import szb.l;
import vzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IPassportApi {
    @Deprecated(message = "use ILarkDeviceIdApi instead")
    void addDeviceIdChangeListener(c.a r1);

    void addLoginListener(b r1);

    void addPushDeviceNotifySettingListener(g r1);

    void addPushDeviceOnlineStatusListener(h r1);

    Boolean canOpenUrlByPassport(String r1);

    void checkGetAndShareLogFile(Activity r1);

    void checkMfaState(Context r1, String r2, String r3, String r4, IGetDataCallback<Integer> r5);

    void cleanUniversalDIDFlag();

    void dispatchFastLogin();

    Boolean enableMigrateByFirstInstallTime();

    Boolean enableOneKeyMigrateDetect();

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    int envType();

    OpenPlatformClearDataConfig fetchOpenPlatformSettings();

    void fetchVerifyStatus(k r1);

    a getAccountInterceptProcessor();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    szb.b getAccountManager();

    IAccountChangeObserver getAccountObserver();

    List<LKPluginConfig> getAllPluginConfigs();

    @Deprecated(message = "use ILarkUserListApi instead")
    List<User> getAllUserList();

    @Deprecated(message = "use ILarkUserListApi instead")
    List<User> getAllValidUserList();

    String getAppLogDomainByPackageEnv();

    Map<String, String> getAutoInitModuleConfigMap();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getAvatarKey();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getAvatarUrl();

    List<CountryBean> getCountryBeanByKeys(Context r1, List<String> r2);

    void getCountryFilterList(d<CountryFilterBean> r1);

    @Deprecated(message = "use ILarkDeviceIdApi instead")
    String getDeviceId();

    @Deprecated(message = "use ILarkDeviceIdApi instead")
    void getDeviceId(Context r1, IGetDataCallback<DeviceId> r2);

    @Deprecated(message = "use ILarkDeviceIdApi instead")
    void getDeviceId(Context r1, IGetDataCallback<DeviceId> r2, long r3);

    String getDeviceIdFromLocal();

    c getDeviceIdService();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Ugly api, only crash monitor used.")
    JSONObject getDeviceInfo(Context r1);

    IDeviceManager getDeviceManager();

    String getDevicePlatform();

    IDeviceService getDeviceService();

    String getDynamicUrlFromV3Config(String r1);

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    kzb.c getEnvService();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    TenantInfo getForegroundTenant();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    User getForegroundUser();

    int getGlobalRegisterTimeout();

    void getIdpIdentity(IGetDataCallback<String> r1);

    @Deprecated(message = "use ILarkDeviceIdApi instead")
    String getInstallId();

    rzb.a getKaIdp();

    String getLegacyDeviceIdByUnit(String r1);

    int getLocalTenantAccountUserAccount();

    String getLoginDeviceId();

    f getLoginExService();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    LoginInfo getLoginInfo();

    ILoginService getLoginService();

    @Deprecated(message = "use isLogin instead")
    int getLoginType();

    boolean getLogoutEraseAllDataFG(boolean r1);

    boolean getLogoutEraserFG(boolean r1);

    boolean getLogoutSettingDeepEraseFG(boolean r1);

    i18.b getOverSeaPluginV2();

    wzb.a getPassportInfraDebugApi();

    List<TenantInfo.PendingUser> getPendingUsers();

    String getPolicyUrl(PolicyAgreement r1);

    i getQRLoginService();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getSession();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    Map<String, SessionInfo> getSessions();

    Fragment getSettingTeamNameFrg(String r1, String r2, String r3, String r4, IGetDataCallback<String> r5);

    ISigninSdkApi getSigninApi();

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    String getTenantBrand();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getTenantCode();

    List<TenantInfo> getTenantData();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getTenantId();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    TenantInfo getTenantInfo();

    TenantInfo getTenantInfo(String r1);

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getTenantName();

    e getTenantService();

    int getTenantTag();

    e getTenantsByIdsService();

    Map<String, String> getThirdPartyModuleConfigMap();

    Map<String, String> getThirdPartyPrefixModuleConfigMap();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    User getUser();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getUserId();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    String getUserName();

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    String getUserUnit();

    void gotoDeviceIDProcess(Context r1, Intent r2);

    void gotoLoginPage(Context r1);

    void gotoLogoutAllClearRetry(Context r1);

    void gotoUniversalDIDUpgrade(Context r1, Intent r2);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Internal api, only passport assembly used.")
    void initPassportModule();

    void initProcessorDoInit(String r1);

    void interceptAccount(Context r1, IGetDataCallback<Boolean> r2);

    void interceptRustInitRequest(InitSDKRequest.Builder r1);

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    boolean isBoe();

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    boolean isChinaMainlandGeo();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    boolean isCustomer();

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    boolean isFeishuBrand();

    @Deprecated(message = "use ILarkUserListApi instead")
    boolean isLogin();

    boolean isMainProcessInitByDidUpgrade();

    boolean isNeedLogoutAllClearRetry();

    boolean isNeedUpgradeUniversalDID();

    boolean isPassportActivity(Activity r1);

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    boolean isPrimaryHost();

    @Deprecated(message = "use ILarkUserApi/ILarkUserListApi instead")
    boolean isSmallBUser();

    boolean isUniversalDID();

    @Deprecated(message = "use LarkAppContext.inst().buildConfig().isUsPackage() instead")
    boolean isUsPackage();

    void jumpToSwitchUserListActivity(Context r1);

    void logout(Context r1, LogoutReason r2, ozb.b r3, IGetDataCallback<String> r4);

    void logout(Context r1, boolean r2, LogoutReason r3, ozb.b r4, czb.a r5);

    void logoutAllUsers(IGetDataCallback<ozb.a> r1, LogoutReason r2, ozb.b r3, LogoutSource r4, boolean r5);

    void logoutAllUsers(LogoutReason r1, ozb.b r2, IGetDataCallback<ozb.a> r3, boolean r4);

    void logoutAndLogin(Context r1, ozb.b r2, IGetDataCallback<String> r3);

    dzb.c logoutUser(String r1, LogoutReason r2, ozb.b r3, IGetDataCallback<ozb.a> r4);

    dzb.c logoutUser(String r1, LogoutReason r2, ozb.b r3, boolean r4, IGetDataCallback<ozb.a> r5);

    void logoutUser(String r1, LogoutReason r2, ozb.b r3, IGetDataCallback<ozb.a> r4, LogoutSource r5);

    void monitorEvent(ncb.e r1, Map<String, Object> r2);

    boolean needCallDeviceProcessLauncher(Context r1);

    boolean needCallProcessDeviceIdActivity();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Old api")
    int oldSdkEnv();

    void onSwitchTenantUserClick(int r1);

    void openCountrySelect(Fragment r1, int r2, int r3, int r4, int r5);

    void openPassportPage(Context r1, String r2);

    void openSSOSdkAuthPage(Context r1, String r2, Bundle r3);

    void openSecurityPasswordSettingActivity(Activity r1);

    void openUrlByPassport(Context r1, Bundle r2, String r3, String r4, String r5, boolean r6);

    void passportVerifyCode(Context r1, com.alibaba.fastjson.JSONObject r2);

    @Deprecated(message = "use ILarkEnvironmentApi instead")
    IEnv provideEnv(Context r1);

    void putDeviceSetting(String r1, String r2, IGetDataCallback<DeviceSetting> r3);

    void qrAuthChangeState(String r1, String r2, String r3, gzb.a<Object> r4);

    void refreshTenantData(String r1, String r2, IGetDataCallback<TenantInfo> r3);

    void registerChangeObserver(IAccountChangeObserver.a r1);

    void registerDybridPlugin();

    void registerInterceptor(IAccountInterceptor r1);

    void registerLoginEnvChangeListener(kzb.c.a r1);

    void registerLogoutListener(ozb.c r1);

    void registerOnlinePush();

    void registerOverSeaPlugin();

    void registerPassportSessionRotatedListener(pzb.a r1);

    void registerTenantInfoListener(l r1);

    void registerUserSwitchListener(qzb.a r1);

    @Deprecated(message = "use ILarkDeviceIdApi instead")
    boolean removeDeviceIdChangeListener(c.a r1);

    void removeLoginListener(b r1);

    void removePushDeviceNotifySettingListener(g r1);

    void removePushDeviceOnlineStatusListener(h r1);

    void reportOneKeyMigrateEvent();

    void requestOpenApiPermission(hzb.a r1, IGetDataCallback<hzb.b> r2);

    void runOfflineLogoutTask();

    String rustSdkLogSubPath();

    void setAppLogUriRuntime(boolean r1);

    void setOneKeyMigrateSettingToSPAndResetClearFlag();

    void showSwitchAnimStageTwoIfNeed(Activity r1);

    void startMfaAuth(Context r1, String r2, String r3, String r4);

    void startQRCodeConfirmActivity(Context r1, String r2, dzb.b<BaseStepData> r3);

    void startSecurityVerify(Context r1, String r2, String r3, j r4);

    void switchLoginTenantUserIPC(Activity r1, String r2, IGetDataCallback<SessionResult> r3);

    void switchTenant(Context r1, TenantInfo r2);

    void switchToNextValidUser(Context r1, SwitchReason r2, IGetDataCallback<User> r3);

    void switchUser(Context r1, String r2, ExternalSwitchReason r3, IGetDataCallback<Object> r4);

    boolean syncUpdateDevice(String r1, String r2, String r3);

    boolean tryGeneralQRScan(Context r1, String r2);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Internal api, only passport assembly used.")
    void unInitPassportModule();

    void unRegisterChangeObservers(IAccountChangeObserver.a r1);

    void unRegisterCheck(Context r1, int r2, IGetDataCallback<String> r3);

    void unRegisterTenantInfoListener(l r1);

    void unregisterLogoutListener(ozb.c r1);

    void unregisterPassportSessionRotatedListener(pzb.a r1);

    void unregisterUserSwitchListener(qzb.a r1);

    void updateEnvAndDid(String r1, String r2, d<String> r3);

    void userSdkOAuth(String r1, String r2, String r3, String r4, String r5, IGetDataCallback<String> r6);
}
