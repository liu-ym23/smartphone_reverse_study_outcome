package com.bytedance.android.live.network.impl.interceptor;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostSessionAuth;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.init.LiveInitializeSettingConfig;
import com.bytedance.android.livesdkapi.recommend.IRecommendController;
import com.bytedance.android.livesdkapi.util.LiveSDKConstUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends b {
    public c() {
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.b
    public final void b(Map<String, String> r8) {
        String r0 = LiveSDKConstUtil.getSdkVersion();
        r8.put("gamecp_sdk_version", r0);
        r8.put("webcast_sdk_version", r0);
        r8.put("webcast_language", Locale.CHINA.getLanguage());
        r8.put("webcast_locale", Resources.getSystem().getConfiguration().locale.toString());
        r8.put("webcast_gps_access", "" + com.bytedance.android.live.network.impl.utils.i.b());
        if (r8.containsKey(LiveInitializeSettingConfig.Companion.getCombindKey()) == true) goto L6;
        r8.put("current_network_quality_info", ao0.g.a().toString());
        r8.put("device_score", z0.b(false) + "");
    L6:
        if (tb1.c.a == false) goto L13;
        IHostService r1 = TTLiveSDK.hostService();
        if (r1 == null) goto L13;
        IHostUser r2 = r1.user();
        if (r2 == null) goto L13;
        r8.put("address_book_access", String.valueOf(r2.getUidContactPermissionState()));
        r8.put("user_id", r2.getCurUserId());
    L13:
        if (SettingUtil.isLocalTest() == false) goto L21;
        int r3 = ((Integer) CoreSettingKeys.TEST_FAKE_REGION.getValue()).intValue();
        if (r3 < 0) goto L19;
        String[] r4 = this.b;
        if (r3 >= r4.length) goto L19;
        String r5 = r4[r3];
    L20:
        r8.put("fake_region", r5);
    L19:
        r5 = "";
    L21:
        boolean r6 = PadConfigUtils.a();
        String r7 = "true";
        if (r6 == false) goto L24;
        String r9 = "true";
    L25:
        r8.put("is_pad", r9);
        String r10 = "1";
        if (r6 == false) goto L28;
        String r11 = "1";
    L29:
        r8.put("is_android_pad", r11);
        if (e5.n() == true) goto L33;
        r7 = "false";
    L33:
        r8.put("is_landscape", r7);
        r8.put("carrier_region", Locale.CHINA.getCountry());
        r8.put("webcast_app_id", "" + jc1.k.f(IHostContext.class).appId());
        r8.put("app_name", "" + jc1.k.f(IHostContext.class).appName());
        if (jc1.k.f(IHostCommerceServiceLive.class) != null) goto L54;
    L41:
        String r12 = jc1.k.f(IHostContext.class).ecHostAppId();
        if (mz.c.b(r12) == true) goto L44;
        r8.put("ecom_host_appid", r12);
    L44:
        IRecommendController r13 = jc1.k.f(IRecommendController.class);
        if (r13 != null) goto L47;
    L49:
        r10 = "0";
    L50:
        r8.put("openlive_personal_recommend", r10);
        if (SettingUtil.isLocalTest() == false) goto L56;
        r8.put("channel", "local_test");
        return;
    L56:
        return;
    L47:
        if (r13.getNeedPersonalRecommend() == false) goto L49;
    L54:
        String r14 = jc1.k.f(IHostCommerceServiceLive.class).getEcomSdkVersion();     // Catch: Throwable -> L39
        if (r14 == null) goto L41;
        r8.put("ecom_sdk_version", r14);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        goto L41
    L28:
        r11 = "0";
        goto L29
    L24:
        r9 = "false";
        goto L25
    }

    public final com.bytedance.android.live.network.b.a c(com.bytedance.android.live.network.b.a r11) {
        String r1 = r11.a;
        if (TextUtils.isEmpty(r1) == true) goto L48;
        StringBuilder r2 = new StringBuilder(r1);
        String r3 = r2.toString();
        if (r3.indexOf(63) >= 0) goto L7;
        r2.append("?");
    L8:
        LinkedHashMap r4 = new LinkedHashMap();
        b(r4);
        this.a.a(r3, r4);
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r7 = (Map.Entry) r6.next();
        r5.add(new Pair((String) r7.getKey(), (String) r7.getValue()));
        goto L10
    L13:
        if (((Boolean) com.bytedance.android.livesdk.b.a.getValue()).booleanValue() == false) goto L35;
        StringBuilder r8 = new StringBuilder();
        Iterator r9 = r5.iterator();
    L16:
        if (r9.hasNext() == false) goto L34;
        Pair r10 = (Pair) r9.next();
        String r12 = URLEncoder.encode((String) r10.first, "UTF-8");     // Catch: UnsupportedEncodingException -> L31
        String r13 = (String) r10.second;
        if (r13 != null) goto L126;
        String r14 = "";
    L28:
        if (r8.length() <= 0) goto L30;
        r8.append("&");
    L30:
        r8.append(r12);
        r8.append("=");
        r8.append(r14);
        goto L16
    L126:
        r14 = URLEncoder.encode(r13, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L23:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L31:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L34:
        r2.append(r8.toString());
    L47:
        r11.a = r2.toString();
        goto L48
    L35:
        StringBuilder r0 = new StringBuilder();
        Iterator r15 = r5.iterator();
    L37:
        if (r15.hasNext() == false) goto L46;
        Pair r16 = (Pair) r15.next();
        String r17 = com.bytedance.android.live.network.a.a((String) r16.first);
        String r18 = (String) r16.second;
        if (r18 == null) goto L41;
        String r19 = com.bytedance.android.live.network.a.a(r18);
    L43:
        if (r0.length() <= 0) goto L45;
        r0.append("&");
    L45:
        r0.append(r17);
        r0.append("=");
        r0.append(r19);
        goto L37
    L41:
        r19 = "";
        goto L43
    L46:
        r2.append(r0.toString());
        goto L47
    L7:
        r2.append("&");
    L48:
        String r20 = r11.a;
        if (TextUtils.isEmpty(r20) == true) goto L123;
        TextUtils.equals(r11.a(), "/webcast/room/create/");
        r11.a = new StringBuilder(r20).toString();
        IHostContext r21 = jc1.k.f(IHostContext.class);
        od1.a r22 = jc1.k.f(od1.a.class);
        if (r22 == null) goto L108;
        String r23 = r22.getAccessToken();
        if (r23 == null) goto L76;
        r11.b.add(new NameValuePair("Authorization", "Bearer ".concat(r23)));
        if (((Boolean) LiveConfigSettingKeys.ENABLE_USE_BD_ACCOUNT_TICKET_NEW.getValue()).booleanValue() == false) goto L75;
        INetworkService r24 = (INetworkService) jc1.k.f(INetworkService.class);
        if (r24 == null) goto L76;
        List r25 = r24.getBdTicketParams(r23, r11.a());
        if (r25 == null) goto L76;
        if (r25.isEmpty() == true) goto L76;
        Iterator r26 = r25.iterator();
    L67:
        if (r26.hasNext() == false) goto L76;
        Pair r27 = (Pair) r26.next();
        if (r27 == null) goto L67;
        if (TextUtils.isEmpty((CharSequence) r27.first) == true) goto L67;
        if (TextUtils.isEmpty((CharSequence) r27.second) == true) goto L67;
        r11.b.add(new NameValuePair((String) r27.first, (String) r27.second));
        goto L67
    L75:
        r11.b.add(new NameValuePair("bd-ticket-guard-target", r23));
    L76:
        String r28 = r22.getOpenId();
        if (r28 == null) goto L85;
        r11.b.add(new NameValuePair("OpenId", r28));
        IUserService r29 = jc1.k.f(IUserService.class);
        if (r29 == null) goto L85;
        String r30 = r29.user().n();
        if (r30 == null) goto L85;
        if (mz.c.a(r28, r30) == true) goto L85;
        ALogger.e("CommonParamsInterceptor", String.format("request[%s] uid[%s] openid[%s] not null and not equal", new Object[]{r11.a(), r30, r28}));
    L85:
        if (r21 == null) goto L89;
        String r31 = r21.clientKey();
        if (r31 == null) goto L89;
        r11.b.add(new NameValuePair("ClientKey", r31));
    L89:
        nn2.a r32 = nn2.a.d;
        String r33 = nn2.a.a.a().c;
        if (TextUtils.isEmpty(r33) == true) goto L92;
        r11.b.add(new NameValuePair("id-sign", r33));
    L92:
        IHostSessionAuth r34 = TTLiveSDK.hostService().sessionAuth();
        if (r34 == null) goto L108;
        Map r35 = r34.getTokenRequestHeaders(r11.a);
        if (r35 == null) goto L108;
        if (r35.isEmpty() == true) goto L108;
        Iterator r36 = r35.entrySet().iterator();
    L100:
        if (r36.hasNext() == false) goto L108;
        Map.Entry r37 = (Map.Entry) r36.next();
        if (r37 == null) goto L100;
        if (TextUtils.isEmpty((CharSequence) r37.getKey()) == true) goto L100;
        if (TextUtils.isEmpty((CharSequence) r37.getValue()) == true) goto L100;
        r11.b.add(new NameValuePair((String) r37.getKey(), (String) r37.getValue()));
    L108:
        String r38 = TTLiveSDK.hostService().user().hostUserIdentifier();
        if (mz.c.b(r38) == true) goto L112;
        r11.b.add(new NameValuePair("odin-tt", r38));
    L112:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L123;
        r11.b.add(new NameValuePair("x-app-id", "4207"));
        IMiddleWareHostContext r39 = jc1.k.f(IMiddleWareHostContext.class);
        if (r39 != null) goto L116;
    L118:
        String r40 = SystemPropertiesUtil.getPpeProp("debug.ttlive.ppe.env");
        if (r40 == null) goto L123;
        if (r40.length() <= 0) goto L123;
        r11.b.add(new NameValuePair("X-Tt-Env", r40));
        r11.b.add(new NameValuePair("X-Use-Ppe", "1"));
        goto L123
    L116:
        if (TextUtils.isEmpty(r39.getServerDeviceId()) == true) goto L118;
        r11.b.add(new NameValuePair("x-device-id", r39.getServerDeviceId()));
    L123:
        return r11;
    }
}
