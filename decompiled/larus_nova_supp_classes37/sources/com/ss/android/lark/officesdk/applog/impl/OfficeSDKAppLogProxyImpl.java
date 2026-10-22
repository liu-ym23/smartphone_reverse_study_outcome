package com.ss.android.lark.officesdk.applog.impl;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uva.c;
import uva.d;
import uva.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(sva.a.class)
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 w2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0017\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016J0\u0010\u001d\u001a\u00020\u000b2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 \u0018\u00010\u001fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 \u0018\u0001`!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\u0012\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010+\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u000202H\u0016J(\u00103\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\r2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u000106H\u0016J\b\u00107\u001a\u00020\u000bH\u0016J\u0012\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J$\u0010;\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u00104\u001a\u0004\u0018\u00010\r2\u0006\u0010<\u001a\u00020\u0016H\u0016J&\u0010=\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001062\u0006\u0010<\u001a\u00020\u0016H\u0016J\u001c\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\r2\b\u0010@\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010A\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J0\u0010C\u001a\u00020\u000b2&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001`!H\u0016J\u0012\u0010D\u001a\u00020\u000b2\b\u0010E\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010F\u001a\u00020\rH\u0016J<\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\r2\u0006\u0010@\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020OH\u0016J\u0012\u0010Q\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010RH\u0016J\b\u0010T\u001a\u00020\rH\u0016J\"\u0010U\u001a\u00020\u000b2\b\u0010V\u001a\u0004\u0018\u00010\r2\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u0016H\u0016J\u001f\u0010Y\u001a\u00020\u000b2\u0010\u0010Z\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010[H\u0016¢\u0006\u0002\u0010\\J\u0017\u0010]\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0017\u0010^\u001a\u00020\u000b2\b\u0010_\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0017\u0010`\u001a\u00020\u000b2\b\u0010a\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0017\u0010b\u001a\u00020\u000b2\b\u0010c\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u001e\u0010d\u001a\u00020\u000b2\u0014\u0010e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u000106H\u0016J\u0012\u0010f\u001a\u00020\u000b2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010i\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010jH\u0016J\u0017\u0010k\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010jH\u0016¢\u0006\u0002\u0010lJ\u0012\u0010m\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010nH\u0016J\u0017\u0010o\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010nH\u0016¢\u0006\u0002\u0010pJ\n\u0010q\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u0016H\u0016J\b\u0010t\u001a\u00020\u0016H\u0016J\n\u0010u\u001a\u0004\u0018\u00010vH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006x"}, d2 = {"Lcom/ss/android/lark/officesdk/applog/impl/OfficeSDKAppLogProxyImpl;", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy;", "<init>", "()V", "officeSDKAppLog", "Lcom/ss/android/lark/officesdk/applog/api/IOfficeSDKAppLog;", "getOfficeSDKAppLog", "()Lcom/ss/android/lark/officesdk/applog/api/IOfficeSDKAppLog;", "officeSDKAppLog$delegate", "Lkotlin/Lazy;", "onEventV3", "", "event", "", "params", "Lorg/json/JSONObject;", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "setEventReportEnable", "enable", "", "(Ljava/lang/Boolean;)V", "getSessionId", "getDid", "getUserUniqueID", "setUserUniqueID", "id", "setHeaderInfo", "custom", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeader", "setAppLanguageAndRegion", "language", "region", "flush", "onResume", "context", "Landroid/content/Context;", "onPause", "init", "originConfig", "Lcom/ss/android/lark/applogbridgeapi/model/AppLogInitConfig;", "getNetConfig", "Lcom/ss/android/lark/applogbridgeapi/network/IAppLogNetworkClient;", "addDataObserver", "listener", "Lcom/ss/android/lark/applogbridgeapi/listener/IAppLogDataObserver;", "methodGetUseNetConfig", "url", "requestHeaders", "", "addSessionHook", "setUidChangedListener", "runnable", "Ljava/lang/Runnable;", "addNetCommonParams", "isApi", "putCommonParams", "setCustomNetParams", "key", "value", "isMigrate", "setEnableMigrateByFirstInstallTime", "setExtraParams", "setAbSdkVersion", AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION, "getAid", "onEvent", "category", "tag", "label", "", "extValue", "addEventObserver", "observer", "Lcom/ss/android/lark/applogbridgeapi/listener/IAppLogEventObserver;", "removeEventObserver", "addEventListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IEventListener;", "removeEventListener", "getIid", "setRegisterUriRuntime", "registerUri", "isNeedAutoUpgrade", "isNeedUnitUpgraded", "setSendLogUrisRuntime", "sendUris", "", "([Ljava/lang/String;)V", "setETVerifyEnable", "setAutoActiveState", "isAutoActive", "setAutoABConfig", "isAutoABConfig", "silenceInBackground", "isSilenceInBackground", "getSsidGroup", "map", "setResetAbVersionCallback", "callback", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy$IResetAbVersionCallback;", "addDeviceIdListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IDeviceIdListener;", "removeDeviceIdListener", "(Lcom/ss/android/lark/applogbridgeapi/listener/IDeviceIdListener;)Ljava/lang/Boolean;", "addConfigChangeListener", "Lcom/ss/android/lark/applogbridgeapi/listener/IConfigChangeListener;", "removeConfigChangeListener", "(Lcom/ss/android/lark/applogbridgeapi/listener/IConfigChangeListener;)Ljava/lang/Boolean;", "getDataObserver", "setHttpUrlPrefix", "isHttp", "getEncryptAndCompress", "getEncryptor", "Lcom/ss/android/lark/applogbridgeapi/encryptor/IAppLogEncryptor;", "Companion", "applog-officesdk-impl_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKAppLogProxyImpl implements sva.a {
    public static final a Companion = null;
    private static final String TAG = "OfficeSDKAppLog";
    private final Lazy officeSDKAppLog$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void setHttpUrlPrefix(boolean r1) {
    }

    private final gtb.a getOfficeSDKAppLog() {
        return (gtb.a) this.officeSDKAppLog$delegate.getValue();
    }

    public void addSessionHook() {
        Log.w(TAG, "addSessionHook() is not supported in OfficeSDK");
    }

    public String getAid() {
        Log.w(TAG, "getAid() is not supported in OfficeSDK");
        return "";
    }

    public uva.a getDataObserver() {
        Log.w(TAG, "getDataObserver() is not supported in OfficeSDK");
        return null;
    }

    public String getDid() {
        Log.w(TAG, "getDid() is not supported in OfficeSDK");
        return "";
    }

    public boolean getEncryptAndCompress() {
        Log.w(TAG, "getEncryptAndCompress() is not supported in OfficeSDK");
        return false;
    }

    public tva.a getEncryptor() {
        Log.w(TAG, "getEncryptor() is not supported in OfficeSDK");
        return null;
    }

    public JSONObject getHeader() {
        Log.w(TAG, "getHeader() is not supported in OfficeSDK");
        return null;
    }

    public String getIid() {
        Log.w(TAG, "getIid() is not supported in OfficeSDK");
        return "";
    }

    public wva.a getNetConfig() {
        Log.w(TAG, "getNetConfig() is not supported in OfficeSDK");
        return null;
    }

    public String getSessionId() {
        Log.w(TAG, "getSessionId() is not supported in OfficeSDK");
        return "";
    }

    public String getUserUniqueID() {
        Log.w(TAG, "getUserUniqueID() is not supported in OfficeSDK");
        return "";
    }

    public OfficeSDKAppLogProxyImpl() {
        this.officeSDKAppLog$delegate = LazyKt.lazy(OfficeSDKAppLogProxyImpl$officeSDKAppLog$2.INSTANCE);
    }

    public void flush() {
        gtb.a r0 = getOfficeSDKAppLog();
        if (r0 == null) goto L6;
        r0.flush();
        return;
    }

    public void addConfigChangeListener(c r2) {
        Log.w(TAG, "addConfigChangeListener() is not supported in OfficeSDK");
    }

    public void addDataObserver(uva.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Log.w(TAG, "addDataObserver() is not supported in OfficeSDK");
    }

    public void addDeviceIdListener(d r2) {
        Log.w(TAG, "addDeviceIdListener() is not supported in OfficeSDK");
    }

    public void addEventListener(e r2) {
        Log.w(TAG, "addEventListener() is not supported in OfficeSDK");
    }

    public void addEventObserver(uva.b r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Log.w(TAG, "addEventObserver() is not supported in OfficeSDK");
    }

    public void getSsidGroup(Map<String, String> r2) {
        Log.w(TAG, "getSsidGroup() is not supported in OfficeSDK");
    }

    public boolean isMigrate(Context r2) {
        Log.w(TAG, "isMigrate() is not supported in OfficeSDK");
        return false;
    }

    public void onPause(Context r2) {
        Log.w(TAG, "onPause() is not supported in OfficeSDK");
    }

    public void onResume(Context r2) {
        Log.w(TAG, "onResume() is not supported in OfficeSDK");
    }

    public Boolean removeConfigChangeListener(c r2) {
        Log.w(TAG, "removeConfigChangeListener() is not supported in OfficeSDK");
        return Boolean.FALSE;
    }

    public Boolean removeDeviceIdListener(d r2) {
        Log.w(TAG, "removeDeviceIdListener() is not supported in OfficeSDK");
        return Boolean.FALSE;
    }

    public void removeEventListener(e r2) {
        Log.w(TAG, "removeEventListener() is not supported in OfficeSDK");
    }

    public void removeEventObserver(uva.b r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Log.w(TAG, "removeEventObserver() is not supported in OfficeSDK");
    }

    public void setAbSdkVersion(String r2) {
        Log.w(TAG, "setAbSdkVersion() is not supported in OfficeSDK");
    }

    public void setAutoABConfig(Boolean r2) {
        Log.w(TAG, "setAutoABConfig() is not supported in OfficeSDK");
    }

    public void setAutoActiveState(Boolean r2) {
        Log.w(TAG, "setAutoActiveState() is not supported in OfficeSDK");
    }

    public void setETVerifyEnable(Boolean r2) {
        Log.w(TAG, "setETVerifyEnable() is not supported in OfficeSDK");
    }

    public /* bridge */ /* synthetic */ void setEnableMigrateByFirstInstallTime(Boolean r1) {
        setEnableMigrateByFirstInstallTime(r1.booleanValue());
    }

    public void setEventReportEnable(Boolean r2) {
        Log.w(TAG, "setEventReportEnable() is not supported in OfficeSDK");
    }

    public void setExtraParams(HashMap<String, String> r2) {
        Log.w(TAG, "setExtraParams() is not supported in OfficeSDK");
    }

    public void setHeaderInfo(HashMap<String, Object> r2) {
        Log.w(TAG, "setHeaderInfo() is not supported in OfficeSDK");
    }

    public void setResetAbVersionCallback(sva.a.a r2) {
        Log.w(TAG, "setResetAbVersionCallback() is not supported in OfficeSDK");
    }

    public void setSendLogUrisRuntime(String[] r2) {
        Log.w(TAG, "setSendLogUrisRuntime() is not supported in OfficeSDK");
    }

    public void setUidChangedListener(Runnable r2) {
        Log.w(TAG, "setUidChangedListener() is not supported in OfficeSDK");
    }

    public void setUserUniqueID(String r2) {
        Log.w(TAG, "setUserUniqueID() is not supported in OfficeSDK");
    }

    public void silenceInBackground(Boolean r2) {
        Log.w(TAG, "silenceInBackground() is not supported in OfficeSDK");
    }

    public void setEnableMigrateByFirstInstallTime(boolean r2) {
        Log.w(TAG, "setEnableMigrateByFirstInstallTime() is not supported in OfficeSDK");
    }

    public void init(Context r1, vva.a r2) {
        Log.w(TAG, "init() is not supported in OfficeSDK");
    }

    public String methodGetUseNetConfig(String r1, Map<String, String> r2) {
        Log.w(TAG, "methodGetUseNetConfig() is not supported in OfficeSDK");
        return "";
    }

    public void onEventV3(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        gtb.a r0 = getOfficeSDKAppLog();
        if (r0 == null) goto L6;
        r0.onEventV3(r2, r3);
        return;
    }

    public void onMiscEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "logType");
        Intrinsics.checkNotNullParameter(r3, "obj");
        gtb.a r0 = getOfficeSDKAppLog();
        if (r0 == null) goto L6;
        r0.onMiscEvent(r2, r3);
        return;
    }

    public void putCommonParams(Map<String, String> r1, boolean r2) {
        Log.w(TAG, "putCommonParams() is not supported in OfficeSDK");
    }

    public void setAppLanguageAndRegion(String r1, String r2) {
        Log.w(TAG, "setAppLanguageAndRegion() is not supported in OfficeSDK");
    }

    public void setCustomNetParams(String r1, String r2) {
        Log.w(TAG, "setCustomNetParams() is not supported in OfficeSDK");
    }

    public void onEventV3(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        gtb.a r0 = getOfficeSDKAppLog();
        if (r0 == null) goto L6;
        r0.onEventV3(r2, r3);
        return;
    }

    public String addNetCommonParams(Context r1, String r2, boolean r3) {
        Log.w(TAG, "addNetCommonParams() is not supported in OfficeSDK");
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public void setRegisterUriRuntime(String r1, boolean r2, boolean r3) {
        Log.w(TAG, "setRegisterUriRuntime() is not supported in OfficeSDK");
    }

    public void onEvent(String r1, String r2, String r3, long r4, long r6, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r1, "category");
        Intrinsics.checkNotNullParameter(r2, "tag");
        Log.w(TAG, "onEvent() is not supported in OfficeSDK");
    }

    public /* bridge */ /* synthetic */ void onEvent(String r10, String r11, String r12, Long r13, Long r14, JSONObject r15) {
        onEvent(r10, r11, r12, r13.longValue(), r14.longValue(), r15);
    }
}
