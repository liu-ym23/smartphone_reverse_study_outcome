package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {
    public final CompositeDisposable a;
    public String b;

    public static final class a {

        @SerializedName("age_larger_14")
        public int ageLargerFourteen;

        @SerializedName("api_request_params")
        public Map<String, String> apiRequestParams;

        @SerializedName("cert_type")
        public int certType;

        @SerializedName("cert_token")
        public String certoken;

        @SerializedName("children_cert_token")
        public String childrenCertToken;

        @SerializedName("conversation_id")
        public String conversationId;

        @SerializedName("enter_from")
        public String enterFrom;

        @SerializedName("identity_code")
        public String identityCode;

        @SerializedName("identity_name")
        public String identityName;

        @SerializedName("is_simplified")
        public int isSimplified;

        @SerializedName("skip_record_verify")
        public boolean isSkipRecordVerify;

        @SerializedName("transaction_id")
        public String transactionId;

        @SerializedName("url")
        public String url;

        @SerializedName("verified_page_source")
        public String verifiedPageSource;

        @SerializedName("youth_cert_scene")
        public int youthCertScene;

        public a() {
        }
    }

    public final void onTerminate() {
        this.a.clear();
    }

    public y() {
        this.a = new CompositeDisposable();
    }

    public final void invoke(Object r13, CallContext r14) throws Exception {
        final a r15 = (a) r13;
        Activity r0 = ContextUtil.contextToActivity(r14.getContext());
        if (r0 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.core.verify.utils.a.j() == false) goto L8;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "aliyun service proxy is unavaliable"));
        return;
    L8:
        w80.a r1 = new w80.a();
        r1.transactionId = r15.transactionId;
        r1.url = r15.url;
        r1.certToken = r15.certoken;
        r1.certType = r15.certType;
        r1.childrenCertToken = r15.childrenCertToken;
        r1.youthCertScene = r15.youthCertScene;
        r1.ageLargerFourteen = r15.ageLargerFourteen;
        r1.verifiedPageSource = r15.verifiedPageSource;
        r1.apiRequestParams = r15.apiRequestParams;
        this.b = r15.enterFrom;
        Bundle r3 = new Bundle();
        ALogger.e("AliYunVerifyMethod", "doAliYunVerify isSimplified->" + r15.isSimplified);
        if (r15.isSimplified != 1) goto L11;
        String r16 = "simplified_realname";
    L12:
        r3.putString("verify_type", r16);
        if (TextUtils.isEmpty(r15.verifiedPageSource) == false) goto L15;
        String r17 = BuildConfig.FLAVOR;
    L16:
        r3.putString("verified_page_source", r17);
        r3.putString("age_larger_14", String.valueOf(r15.ageLargerFourteen));
        r3.putString("conversation_id", r15.conversationId);
        com.bytedance.android.live.core.verify.utils.a.o(r0, r1, this.b, r3, 3, null, false, new w(this), new x(this, r15), r15.isSkipRecordVerify, true);
        return;
    L15:
        r17 = r15.verifiedPageSource;
        goto L16
    L11:
        r16 = "realname";
        goto L12
    }
}
