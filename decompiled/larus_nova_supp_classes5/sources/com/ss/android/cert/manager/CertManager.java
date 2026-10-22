package com.ss.android.cert.manager;

import android.app.Activity;
import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import com.ss.android.cert.manager.ablity.ICertMonitorConfig;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IExceptionCallback;
import com.ss.android.cert.manager.ablity.INetWork;
import com.ss.android.cert.manager.ablity.IRequestExtraInterceptor;
import com.ss.android.cert.manager.ablity.RequestPermissionListener;
import com.ss.android.cert.manager.api.IAliyunCert;
import com.ss.android.cert.manager.api.IByteUserIdentity;
import com.ss.android.cert.manager.api.IBytedCert;
import com.ss.android.cert.manager.bpea.DefaultCertCompliance;
import com.ss.android.cert.manager.callback.CertCallback;
import com.ss.android.cert.manager.callback.CertResultCallback;
import com.ss.android.cert.manager.callback.UserIdentityResultCallback;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.model.ByteUserIdentityResult;
import com.ss.android.cert.manager.model.CertResult;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.net.CertRequestUtils;
import com.ss.android.cert.manager.utils.net.CertResponse;
import dta.d;
import dta.e;
import el9.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class CertManager {
    private static final String COMPLIANCE_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.bpea.CertComplianceAdapter";
    private static final String MONITOR_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.monitor.CertMonitorAdapter";
    private static final String NETWORK_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.network.NetWorkAdapter";
    private static volatile CertManager instance;
    private IAliyunCert aliyunCert;
    private IByteUserIdentity byteUserIdentity;
    public IBytedCert bytedCert;
    private ICertCompliance certCompliance;
    private final Map<Class<?>, IEventParamsInterceptor> eventParamsInterceptors;
    private ICertMonitorConfig mCertMonitorConfig;
    private IExceptionCallback mExceptionCallback;
    private INetWork mNetWork;
    private RequestPermissionListener mRequestPermissionListener;
    private final Map<Class<?>, IRequestExtraInterceptor> requestExtraInterceptors;

    public static /* synthetic */ void a(CertManager r0, CertCallback r1, CertResponse r2) {
        r0.lambda$authDecision$1(r1, r2);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ void b(CertManager r0, CertCallback r1, CertResponse r2) {
        r0.lambda$greyStrategy$0(r1, r2);
    }

    public static CertManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CertManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CertManager();     // Catch: Throwable -> L11
        EventLogUtils.eventSdkSessionLaunch();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CertManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void injectAdapter() {
        Object r0 = INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(MONITOR_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L6
        if ((r0 instanceof ICertMonitorConfig) == false) goto L15;
        this.mCertMonitorConfig = (ICertMonitorConfig) r0;     // Catch: Exception -> L6
    L15:
        Object r1 = INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(NETWORK_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L12
        if ((r1 instanceof INetWork) == false) goto L19;
        this.mNetWork = (INetWork) r1;     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    private boolean isAliyunReady() {
        if (this.aliyunCert == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Collection<IEventParamsInterceptor> getEventParamsInterceptors() {
        return this.eventParamsInterceptors.values();
    }

    public Collection<IRequestExtraInterceptor> getRequestExtraInterceptors() {
        return this.requestExtraInterceptors.values();
    }

    public boolean isByteUserIdentityReady() {
        if (this.byteUserIdentity == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBytedCertReady() {
        if (this.bytedCert == null) goto L5;
        return true;
    L5:
        return false;
    }

    private CertManager() {
        this.requestExtraInterceptors = new HashMap();
        this.eventParamsInterceptors = new HashMap();
        injectAdapter();
        injectComplianceAdapter(false);
    }

    public ICertCompliance getCertCompliance() {
        return this.certCompliance;
    }

    public IExceptionCallback getExceptionCallback() {
        return this.mExceptionCallback;
    }

    public ICertMonitorConfig getMonitor() {
        return this.mCertMonitorConfig;
    }

    public INetWork getNetWork() {
        return this.mNetWork;
    }

    public RequestPermissionListener getRequestPermissionListener() {
        return this.mRequestPermissionListener;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public String getAliyunMetaInfos(Context r2) {
        if (isAliyunReady() == true) goto L5;
        return null;
    L5:
        return this.aliyunCert.getMetaInfos(r2);
    }

    public void injectComplianceAdapter(boolean r2) {
        if (r2 == false) goto L14;
        ICertCompliance r3 = this.certCompliance;
        if (r3 != null) goto L6;
    L17:
        Object r4 = INVOKESTATIC_com_ss_android_cert_manager_CertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(COMPLIANCE_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L11
        if ((r4 instanceof ICertCompliance) == false) goto L20;
        this.certCompliance = (ICertCompliance) r4;     // Catch: Exception -> L11
        return;
    L20:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if ((r3 instanceof DefaultCertCompliance) == true) goto L17;
        return;
    L14:
        if ((this.certCompliance instanceof DefaultCertCompliance) == true) goto L22;
        this.certCompliance = new DefaultCertCompliance();
        return;
    }

    public void registerAliyunCert(IAliyunCert r1) {
        this.aliyunCert = r1;
    }

    public void registerByteUserIdentity(IByteUserIdentity r1) {
        this.byteUserIdentity = r1;
    }

    public void registerBytedCert(IBytedCert r4) {
        this.bytedCert = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getExtraInterceptor() == null) goto L8;
        this.requestExtraInterceptors.put(IBytedCert.class, r4.getExtraInterceptor());
    L8:
        if (r4.getEventParamsInterceptor() == null) goto L12;
        this.eventParamsInterceptors.put(IBytedCert.class, r4.getEventParamsInterceptor());
        return;
    }

    public void setCompliance(ICertCompliance r1) {
        this.certCompliance = r1;
    }

    public void setExceptionCallback(IExceptionCallback r1) {
        this.mExceptionCallback = r1;
    }

    public void setMonitor(ICertMonitorConfig r1) {
        this.mCertMonitorConfig = r1;
    }

    public void setNetWork(INetWork r1) {
        this.mNetWork = r1;
    }

    public void setRequestPermissionListener(RequestPermissionListener r1) {
        this.mRequestPermissionListener = r1;
    }

    private /* synthetic */ void lambda$authDecision$1(CertCallback r3, CertResponse r4) {
    L11:
        r3.callback(new CertResponse(ErrorConstant.Client.ERROR_GREY_STRATEGY_BLOCK));
        return;
    L3:
        if (r4.success == true) goto L5;
    L9:
        r3.callback(new CertResponse(ErrorConstant.Client.ERROR_GREY_STRATEGY_BLOCK));     // Catch: JSONException -> L11
    L13:
        return;
    L5:
        if (r4.jsonData == null) goto L9;
        if (isBytedCertReady() == false) goto L9;
        r3.callback(new CertResponse(true, new JSONObject(r4.jsonData.optString("decision_result"))));     // Catch: JSONException -> L11
        goto L13
    }

    private /* synthetic */ void lambda$greyStrategy$0(CertCallback r3, CertResponse r4) {
        if (r4.success == false) goto L11;
        JSONObject r0 = r4.jsonData;
        if (r0 == null) goto L11;
        if (r0.optInt("strategy") != 1) goto L11;
        if (isBytedCertReady() == false) goto L11;
        r3.callback(new CertResponse(true, r4.jsonData));
        return;
    L11:
        r3.callback(new CertResponse(ErrorConstant.Client.ERROR_GREY_STRATEGY_BLOCK));
    }

    public void authDecision(Map<String, String> r2, CertCallback r3) {
        CertRequestUtils.authDecision(r2, new e(this, r3));
    }

    public void greyStrategy(String r3, CertCallback r4) {
        HashMap r0 = new HashMap();
        r0.put("enter_from", r3);
        CertRequestUtils.getGreyStrategy(r0, new d(this, r4));
    }

    public boolean openAliyunFaceLive(Context r2, Map<String, String> r3, CertCallback r4) {
        if (isAliyunReady() == false) goto L6;
        this.aliyunCert.doFaceLiveness(r2, r3, r4);
        return true;
    L6:
        r4.callback(new CertResponse(ErrorConstant.Client.ERROR_CERT_UNREGISTER));
        return false;
    }

    public void startCertFlow(Activity r2, Map<String, String> r3, CertResultCallback r4) {
        if (isBytedCertReady() == false) goto L5;
        this.bytedCert.startCertFlow(r2, r3, r4);
        return;
    L5:
        r4.onCertResult(new CertResult(ErrorConstant.Client.ERROR_CERT_UNREGISTER));
    }

    public void startFaceLiveness(Activity r2, Map<String, String> r3, CertResultCallback r4) {
        if (isBytedCertReady() == false) goto L5;
        this.bytedCert.startFaceLiveness(r2, r3, r4);
        return;
    L5:
        r4.onCertResult(new CertResult(ErrorConstant.Client.ERROR_CERT_UNREGISTER));
    }

    public void startUserIdentityFlow(Activity r2, Map<String, String> r3, UserIdentityResultCallback r4) {
        if (isByteUserIdentityReady() == false) goto L5;
        this.byteUserIdentity.startFlow(r2, r3, r4);
        return;
    L5:
        r4.onResult(new ByteUserIdentityResult(((Integer) ErrorConstant.Client.ERROR_CERT_UNREGISTER.first).intValue(), (String) ErrorConstant.Client.ERROR_CERT_UNREGISTER.second));
    }
}
