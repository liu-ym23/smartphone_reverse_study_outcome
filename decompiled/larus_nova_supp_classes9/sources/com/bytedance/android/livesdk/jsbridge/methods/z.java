package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.live.browser.jsbridge.base.AppInfoResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.af0;
import com.bytedance.android.livesdk.config.f91;
import com.bytedance.android.livesdk.config.ie;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "appInfo")
public final class z extends w20.i<JSONObject, AppInfoResultModel> {
    public final WebView a;
    public f91 b;
    public TokenCert c;

    public final boolean j() {
        WebView r0 = this.a;
        if (r0 != null) goto L5;
    L24:
        return false;
    L5:
        if (r0.getUrl() == null) goto L24;
        if (this.b != null) goto L10;
        this.b = (f91) af0.a.getValue();
    L10:
        f91 r1 = this.b;
        if (r1 == null) goto L24;
        List r2 = r1.blackList;
        if (r2 == null) goto L24;
        if (r2.size() == 0) goto L24;
        String r3 = this.a.getUrl();
        Iterator r4 = this.b.blackList.iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        if (((String) r4.next()).contains(r3) == false) goto L19;
        return true;
    }

    public z(m16.b r2) {
        this.b = null;
        this.c = TokenCert.with("bpea-appInfoMethod_jsb_get_network_access");
        this.a = (WebView) r2.c(WebView.class);
    }

    public z(WebView r2) {
        this.b = null;
        this.c = TokenCert.with("bpea-appInfoMethod_jsb_get_network_access");
        this.a = r2;
    }

    public final void invoke(Object r8, CallContext r9) throws Exception {
        JSONObject r10 = (JSONObject) r8;
        AppInfoResultModel r0 = new AppInfoResultModel();
        IMiddleWareHostContext r1 = jc1.k.f(IMiddleWareHostContext.class);
        r0.c(r1.appName());
        r0.b(String.valueOf(r1.appId()));
        String r4 = r9.getContext().getPackageManager().getPackageInfo(r9.getContext().getPackageName(), 0).versionName;     // Catch: Exception -> L5
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r4 = r1.getVersionCode();
    L9:
        r0.d(r4);
        r0.u(r1.getVersionCode());
        r0.v(r4);
        String r11 = r10.optString("token", BuildConfig.FLAVOR);
        if (r11 != null) goto L12;
    L14:
        r0.j(NetworkUtils.a(r1.context(), this.c));
        String r2 = "vertical";
        if ((r9.getContext() instanceof Activity) == false) goto L34;
        Activity r13 = (Activity) r9.getContext();
        if (r13.getRequestedOrientation() != 1) goto L19;
        String r14 = "vertical";
    L20:
        ALogger.d("app info", "request orientation :" + r13.getRequestedOrientation());
        if (PadConfigUtils.c() == false) goto L28;
        if (j() == false) goto L25;
    L33:
        r2 = r14;
        goto L34
    L25:
        if (com.bytedance.android.livesdk.utils.e5.g(r13) == false) goto L34;
        r2 = "horizontal";
        goto L34
    L28:
        if (((Boolean) ie.a.getValue()).booleanValue() == false) goto L33;
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L32;
        r2 = "horizontal";
    L32:
        ALogger.d("app info", "on back up run and padconfig utils ab value : " + PadConfigUtils.c());
        goto L34
    L19:
        r14 = "horizontal";
    L34:
        r0.l(r2);
        r0.i(TTMiddlewareLiveSDK.hostMiddlewareService().appContext().getServerDeviceId());
        r0.t(jc1.k.f(IMiddlewareUserService.class).user().n());
        r0.q(jc1.k.f(IMiddlewareUserService.class).user().b().getCastSecUid());
        r0.o(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y())));
        r0.n(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.w())));
        r0.s(String.valueOf(r1.getUpdateVersionCode()));
        r0.w(String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        com.bytedance.android.livesdk.user.e r15 = jc1.k.f(IMiddlewareUserService.class).user();
        if (r15.isLogin() == false) goto L37;
        r0.k(r15.n());
    L37:
        IMiddlewareNetworkService r16 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r16 == null) goto L58;
        Map r17 = r16.getCommonParams();
        if (r17 == null) goto L58;
        Iterator r18 = r17.keySet().iterator();
    L43:
        if (r18.hasNext() == false) goto L58;
        String r3 = (String) r18.next();
        if (r3.isEmpty() == true) goto L43;
        if (r3.equals("device_platform") == true) goto L48;
        if (r3.equals("os_version") == true) goto L51;
        if (r3.equals("device_type") == true) goto L54;
        if (r3.equals("device_brand") == false) goto L43;
        r0.f((String) r17.get(r3));
        goto L43
    L54:
        r0.h((String) r17.get(r3));
        goto L43
    L51:
        r0.m((String) r17.get(r3));
        goto L43
    L48:
        r0.g((String) r17.get(r3));
    L58:
        r0.p(String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        Room r19 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r19 == null) goto L61;
        r0.r(Long.valueOf(r19.getCreateTime()));
    L61:
        r0.e(AppInfoResultModel.Code.Success);
        HashMap r20 = new HashMap();
        r20.put("orientation", r0.a());
        r20.put("pad_ab", String.valueOf(PadConfigUtils.c()));
        r20.put("black_list", String.valueOf(j()));
        r20.put(sz1.a.KEY_WIDTH, String.valueOf(com.bytedance.android.live.core.utils.s1.y()));
        r20.put(sz1.a.KEY_HEIGHT, String.valueOf(com.bytedance.android.live.core.utils.s1.w()));
        ALogger.d("AppInfoMethod", "monitorAppInfo: " + r20.toString());
        LiveSlardarMonitor.monitorStatus("ttlive_app_info_status", 0, r20);
        finishWithResult(r0);
        return;
    L12:
        if (r11.isEmpty() == true) goto L14;
        this.c = TokenCert.with(r11);
    L5:
        r4 = BuildConfig.FLAVOR;
        goto L7
    }
}
