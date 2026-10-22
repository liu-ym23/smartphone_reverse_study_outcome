package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.core.verify.responbean.CertificationQuery;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class ZhimaOpenMethod extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> implements LifecycleObserver {
    public final com.bytedance.android.tools.superkv.e a;
    public w80.a b;
    public final CompositeDisposable c;
    public String d;
    public boolean e;

    public final synchronized void j() {
        monitor-enter(this);
        com.bytedance.android.tools.superkv.e r0 = this.a;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.putString("is_verify_processed", BuildConfig.FLAVOR);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void onTerminate() {
        this.c.clear();
        j();
    }

    public ZhimaOpenMethod(WeakReference<Context> r6) {
        CompositeDisposable r0 = new CompositeDisposable();
        this.c = r0;
        com.bytedance.android.tools.superkv.e r1 = com.bytedance.android.live.core.utils.v1.a("webcast_jsb_local_data");
        this.a = r1;
        String r2 = r1.getString("is_verify_processed");
        Logger.d("ZhimaOpenMethod", "ZhimaOpenMethod->" + r2);
        if (TextUtils.isEmpty(r2) == true) goto L17;
        this.b = (w80.a) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r2, w80.a.class);
        Logger.d("ZhimaOpenMethod", "checkZhimaVerifyStatus");
        HashMap r3 = new HashMap();
        r3.put("zhima_token", this.b.zhimaToken);
        r3.put("transaction_id", this.b.transactionId);
        r3.put("children_cert_token", this.b.childrenCertToken);
        r3.put("youth_cert_scene", String.valueOf(this.b.youthCertScene));
        Map r4 = this.b.apiRequestParams;
        if (r4 == null) goto L8;
        r3.putAll(r4);
    L8:
        if ("recharge".equals(this.d) == false) goto L10;
        r3.put("scene", "1");
        Observable r5 = ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).queryCertificationCommonResult(r3);
    L11:
        Observable r7 = r5.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        if ((r6.get() instanceof AppCompatActivity) == false) goto L14;
        AppCompatActivity r8 = r6.get();
    L15:
        r0.add(((ObservableSubscribeProxy) r7.as(AutoDispose.bind(r8))).subscribe(new m5(this), new n5(this)));
        return;
    L14:
        r8 = null;
        goto L15
    L10:
        r3.put("skip_record_verify", String.valueOf(this.e));
        r5 = ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).queryCertificationResult(r3);
        goto L11
    }

    public final void invoke(Object r13, CallContext r14) throws Exception {
        final JSONObject r15 = (JSONObject) r13;
        Activity r0 = ContextUtil.contextToActivity(r14.getContext());
        if (r0 == null) goto L40;
        ALogger.d("ZhimaOpenMethod", "invoke params: " + r15);
        com.bytedance.android.tools.superkv.e r16 = this.a;
        if (r16 == null) goto L20;
        String r17 = r16.getString("verify_status_result");
        this.a.putString("verify_status_result", BuildConfig.FLAVOR);
        Logger.d("ZhimaOpenMethod", "invoke verifyResult->" + r17);
        if (TextUtils.isEmpty(r17) == true) goto L20;
        Response r18 = (Response) GsonProtectorUtils.fromJson(GsonHelper.get(), r17, new o5().getType());
        StringBuilder r5 = new StringBuilder("response is null ->");
        if (r18 != null) goto L12;
        boolean r6 = true;
    L13:
        r5.append(r6);
        Logger.d("ZhimaOpenMethod", r5.toString());
        if (r18 == null) goto L20;
        Object r7 = ((BaseResponse) r18).data;
        if (r7 == null) goto L20;
        if (((CertificationQuery) r7).getPassed() == false) goto L20;
        finishWithResult(r18);
        return;
    L12:
        r6 = false;
    L20:
        Bundle r19 = new Bundle();
        w80.a r8 = new w80.a();
        this.b = r8;
        r8.transactionId = r15.optString("transactionId", BuildConfig.FLAVOR);
        this.b.url = r15.optString("url", BuildConfig.FLAVOR);
        this.b.zhimaToken = r15.optString("zhimaToken", BuildConfig.FLAVOR);
        this.b.certType = r15.optInt("cert_type");
        this.b.childrenCertToken = r15.optString("children_cert_token", BuildConfig.FLAVOR);
        this.b.youthCertScene = r15.optInt("youth_cert_scene");
        this.b.ageLargerFourteen = r15.optInt("age_larger_14", 1);
        this.b.verifiedPageSource = r15.optString("verified_page_source", BuildConfig.FLAVOR);
        JSONObject r9 = r15.optJSONObject("api_request_params");
        if (r9 == null) goto L23;
        this.b.apiRequestParams = JsonUtil.jsonObjectToMap(r9);
    L23:
        int r10 = r15.optInt("is_simplified", 0);
        ALogger.e("ZhimaOpenMethod", "invoke isSimplified->" + r10);
        if (r10 != 1) goto L26;
        String r1 = "simplified_realname";
    L27:
        r19.putString("verify_type", r1);
        r19.putString("verified_page_source", r15.optString("verified_page_source", BuildConfig.FLAVOR));
        r19.putString("age_larger_14", String.valueOf(r15.optInt("age_larger_14", 1)));
        r19.putString("conversation_id", r15.optString("conversation_id", BuildConfig.FLAVOR));
        if (TextUtils.isEmpty(this.b.url) == false) goto L30;
    L36:
        finishWithFailure();
        return;
    L30:
        if (TextUtils.isEmpty(this.b.zhimaToken) == true) goto L36;
        int r4 = r15.optInt("zhima_type", 0);
        if (r4 == 0) goto L35;
        HashMap r3 = new HashMap();
        r3.put("zhima_type", String.valueOf(r4));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_zhima_sdk_wrong", r3, new Object[0]);
    L35:
        this.d = r15.optString("enter_from");
        boolean r11 = r15.optBoolean("skip_record_verify");
        this.e = r11;
        com.bytedance.android.live.core.verify.utils.a.o(r0, this.b, this.d, r19, r4, null, false, new k5(this), new l5(this, r15), r11, true);
        return;
    L26:
        r1 = "realname";
        goto L27
    }
}
