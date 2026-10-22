package com.bytedance.badger.collect.impl.manager;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.interfaces.ICommonConfig;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.monitor.MonitorManager;
import com.bytedance.badger.collect.impl.network.NetworkManager;
import com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeResult;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeSignResult;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeTokenResult;
import com.bytedance.badger.collect.impl.utils.CommonUtils;
import com.bytedance.badger.collect.impl.utils.ExecutorManager;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.badger.collect.impl.utils.NetworkTypeSwitchHelper;
import com.bytedance.badger.collect.impl.utils.NetworkTypeUtils;
import com.bytedance.badger.collect.impl.utils.SimUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class PseudoCodeManager {
    private static volatile PseudoCodeManager instance;

    private PseudoCodeSignResult fetchMobileSign() {
        KLog.d(Constants.TAGS.PSEUDO, "---start request sign--- " + ThreadMethodProxy.currentThread().getName());
        MonitorManager.getInstance().getMobileGetSignMonitor().setStartTime();
        String r1 = BadgerCollectApi.getMobileChannelId();
        int r3 = BadgerCollectApi.getAppId();
        if (TextUtils.isEmpty(r1) == true) goto L21;
        if (r3 == 0) goto L21;
        TreeMap r4 = new TreeMap();
        r4.put("channelId", r1);
        r4.put("msgId", UUID.randomUUID().toString());
        r4.put("userId", "");
        r4.put("openType", DataType.TRUE);
        r4.put("message", "");
        r4.put("expandParams", "");
        TreeMap r2 = new TreeMap();
        r2.put("content", URLEncoder.encode(CommonUtils.map2QueryString(r4)));
        r2.put("aid", String.valueOf(r3));
        ICommonConfig r5 = BadgerCollectApi.commonConfig;
        if (r5 == null) goto L10;
        r2.put("device_id", r5.getDeviceId());
    L10:
        if (KLog.isDebug() == false) goto L12;
        KLog.d(Constants.TAGS.PSEUDO, "移动伪码Sign请求的参数=https://i.snssdk.com/activity/carrier_flow/mobile/get_sign_post/\n" + r2);
    L12:
        PseudoCodeSignResult r6 = new PseudoCodeSignResult();
        r6.setRequestMap(r4);
        TTResponse r7 = NetworkManager.getInstance().fetchMobilePseudoCodeSign("https://i.snssdk.com/activity/carrier_flow/mobile/get_sign_post/", r4, NetworkMethodEnum.POST, r2);     // Catch: Exception -> L17
        handlePseudoCodeSign(r6, r7, null);     // Catch: Exception -> L17
        if (r7 == null) goto L19;
        KLog.i(Constants.TAGS.PSEUDO, "Sign请求成功=" + r7.getBody());     // Catch: Exception -> L17
    L19:
        MonitorManager.getInstance().getMobileGetSignMonitor().setFinishTime();
        MonitorManager.getInstance().getMobileGetSignMonitor().report();
        return r6;
    L17:
        e = move-exception;
        handlePseudoCodeSign(r6, null, e);
    L21:
        PseudoCodeSignResult r0 = new PseudoCodeSignResult();
        r0.setCode(Constants.StatusCode.FAILED);
        r0.setException(new IllegalStateException("pseudo_init_invalid"));
        MonitorManager.getInstance().getMobileGetSignMonitor().setFinishTime();
        MonitorManager.getInstance().getMobileGetSignMonitor().setResult(false);
        MonitorManager.getInstance().getMobileGetSignMonitor().setErrorMsg("pseudo_init_invalid");
        MonitorManager.getInstance().getMobileGetSignMonitor().report();
        return r0;
    }

    public static PseudoCodeManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(PseudoCodeManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new PseudoCodeManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoCodeManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private PseudoCodeManager() {
    }

    private void execute(final IMobileResultCallback<PseudoCodeResult> r7) throws Exception {
        if (BadgerCollectApi.isInitialized() == false) goto L20;
        if (r7 == null) goto L20;
        KLog.i(Constants.TAGS.PSEUDO, "...start...");
        Context r0 = BadgerCollectApi.getAppContext();
        int r2 = SimUtils.getSimType(r0);
        String r3 = NetworkTypeUtils.getNetworkStatus(r0);
        if (r2 != 1) goto L17;
        MonitorManager.getInstance().getMobileInitMonitor().setOperatorName(SimUtils.getSimOperatorName(r0));
        MonitorManager.getInstance().getMobileInitMonitor().setNetworkType(r3);
        MonitorManager.getInstance().getMobileInitMonitor().report();
        IMobileResultCallback<PseudoCodeTokenResult> r1 = new AnonymousClass2(this, r7);
        PseudoCodeSignResult r4 = fetchMobileSign();
        if (Objects.equals(r4.getCode(), Constants.StatusCode.SUCCESS) == false) goto L16;
        r3.getClass();
        if (r3.equals(Constants.NetworkOperator.NETWORK_TYPE_MOBILE) == false) goto L12;
        fetchMobileToken(false, r4, r1);
        return;
    L12:
        if (r3.equals(Constants.NetworkOperator.NETWORK_TYPE_WIFI_AND_MOBILE) == true) goto L14;
        r7.onComplete(PseudoCodeResult.failed("network status error:".concat(r3), true));
        return;
    L14:
        fetchMobileToken(true, r4, r1);
        return;
    L16:
        r7.onComplete(PseudoCodeResult.failed("get sign error:" + r3));
        return;
    L17:
        KLog.w(Constants.TAGS.PSEUDO, "运营商类型异常，回调Worker并开启监听当前运营商=" + r2);
        r7.onComplete(PseudoCodeResult.failed("carrier type error, enable listen:" + r3 + "," + r2, true));
        return;
    L20:
        throw new IllegalArgumentException("BadgerCollectApi not init");
    }

    public void executeMobilePseudoCode(final IMobileResultCallback<PseudoCodeResult> r3) throws Exception {
        ExecutorManager.getInstance().runOnNetExecutor(new AnonymousClass1(this, r3));
    }

    public static /* synthetic */ void access$000(PseudoCodeManager r0, IMobileResultCallback r1) throws Exception {
        r0.execute(r1);
    }

    private void fetchMobileToken(boolean r9, PseudoCodeSignResult r10, final IMobileResultCallback<PseudoCodeTokenResult> r12) {
        KLog.d(Constants.TAGS.PSEUDO, "---start request token--- " + ThreadMethodProxy.currentThread().getName());
        MonitorManager.getInstance().getMobileGetTokenMonitor().setStartTime();
        final Map<String, String> r7 = r10.getRequestMap();
        r7.put("sign", r10.getSign());
        if (KLog.isDebug() == false) goto L5;
        KLog.d(Constants.TAGS.PSEUDO, "移动伪码Token请求的参数=http://wap.cmpassport.com/openapi/wabpGetUseInfo?\n" + r7);
    L5:
        final PseudoCodeTokenResult r13 = new PseudoCodeTokenResult();
        if (r9 == false) goto L14;
        NetworkTypeSwitchHelper.wifiSwitchCellAndRequest(BadgerCollectApi.getAppContext(), new AnonymousClass3(this, r7, r13, r12));
        return;
    L14:
        handlePseudoCodeToken(r13, NetworkManager.getInstance().fetchMobilePseudoCodeToken(null, Constants.PATHS.URL_GET_MOBILE_TOKEN, r7, NetworkMethodEnum.GET, r7), null, r12);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        handlePseudoCodeToken(r13, null, e, r12);
    }

    private void handlePseudoCodeSign(PseudoCodeSignResult r4, TTResponse r5, Exception r6) {
        if (r4 != null) goto L20;
        return;
    L20:
        if (r5 == null) goto L13;
        String r7 = new JSONObject(r5.getBody()).optString("sign");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r7) == true) goto L10;
        r4.setSign(r7);     // Catch: Exception -> L11
        r4.setCode(Constants.StatusCode.SUCCESS);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setResult(true);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setData(r7);     // Catch: Exception -> L11
    L19:
        return;
    L10:
        r4.setResponse(r5.getBody());     // Catch: Exception -> L11
        r4.setCode(Constants.StatusCode.FAILED);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setResult(false);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setErrorMsg("签名为空,response=" + r5.getBody());     // Catch: Exception -> L11
        goto L19
    L13:
        if (r6 == null) goto L15;
        r4.setException(r6);     // Catch: Exception -> L11
        r4.setCode(Constants.StatusCode.FAILED);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setResult(false);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setErrorMsg("获取签名抛出异常=" + r6.getMessage());     // Catch: Exception -> L11
        goto L19
    L15:
        r4.setCode(Constants.StatusCode.FAILED);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setResult(false);     // Catch: Exception -> L11
        MonitorManager.getInstance().getMobileGetSignMonitor().setErrorMsg("获取签名抛出异常=response and exception is null");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        r4.setException(e);
        r4.setCode(Constants.StatusCode.FAILED);
        MonitorManager.getInstance().getMobileGetSignMonitor().setResult(false);
        MonitorManager.getInstance().getMobileGetSignMonitor().setErrorMsg("解析签名抛出异常=" + e.getMessage());
    }

    private void handlePseudoCodeToken(PseudoCodeTokenResult r5, TTResponse r6, Exception r7, IMobileResultCallback<PseudoCodeTokenResult> r8) {
        if (r5 != null) goto L26;
        r8.onComplete(new PseudoCodeTokenResult());
        return;
    L26:
        if (r6 == null) goto L16;
        String r9 = new JSONObject(r6.getBody()).optString("pcId");     // Catch: Throwable -> L12 Exception -> L14
        r5.setResponse(r6.getBody());     // Catch: Throwable -> L12 Exception -> L14
        if (TextUtils.isEmpty(r9) == true) goto L11;
        r5.setPcId(r9);     // Catch: Throwable -> L12 Exception -> L14
        r5.setCode(Constants.StatusCode.SUCCESS);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setData(r9);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setResult(true);     // Catch: Throwable -> L12 Exception -> L14
    L25:
    L19:
        MonitorManager.getInstance().getMobileGetTokenMonitor().setFinishTime();
        MonitorManager.getInstance().getMobileGetTokenMonitor().report();
        r8.onComplete(r5);
        return;
    L11:
        r5.setCode(Constants.StatusCode.FAILED);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setResult(false);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setErrorMsg("token为空,response=" + r6.getBody());     // Catch: Throwable -> L12 Exception -> L14
        goto L25
    L16:
        if (r7 == null) goto L18;
        r5.setException(r7);     // Catch: Throwable -> L12 Exception -> L14
        r5.setCode(Constants.StatusCode.FAILED);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setResult(false);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setErrorMsg("获取token抛出异常=" + r7.getMessage());     // Catch: Throwable -> L12 Exception -> L14
        goto L25
    L18:
        r5.setCode(Constants.StatusCode.FAILED);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setResult(false);     // Catch: Throwable -> L12 Exception -> L14
        MonitorManager.getInstance().getMobileGetTokenMonitor().setErrorMsg("获取token抛出异常=response and exception is null");     // Catch: Throwable -> L12 Exception -> L14
    L14:
        e = move-exception;
        r5.setException(e);     // Catch: Throwable -> L12
        r5.setCode(Constants.StatusCode.FAILED);     // Catch: Throwable -> L12
        MonitorManager.getInstance().getMobileGetTokenMonitor().setResult(false);     // Catch: Throwable -> L12
        MonitorManager.getInstance().getMobileGetTokenMonitor().setErrorMsg("解析token抛出异常=" + e.getMessage());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        MonitorManager.getInstance().getMobileGetTokenMonitor().setFinishTime();
        MonitorManager.getInstance().getMobileGetTokenMonitor().report();
        r8.onComplete(r5);
        throw th;
    }

    public static /* synthetic */ void access$100(PseudoCodeManager r0, PseudoCodeTokenResult r1, TTResponse r2, Exception r3, IMobileResultCallback r4) {
        r0.handlePseudoCodeToken(r1, r2, r3, r4);
    }
}
