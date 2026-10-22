package com.bytedance.android.live.browser.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.gson.ILiveGsonService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.se;
import com.bytedance.android.livesdk.l6;
import com.bytedance.android.livesdk.n1;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ss.android.common.applog.AppLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.AbstractMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/browser/utils/c$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Object>> {
        public a() {
        }
    }

    @JvmStatic
    public static final IRoom f() {
        com.bytedance.live.datacontext.m r0 = o3.f().getRoom();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (IRoom) r0.getValue();
    }

    static {
    }

    @JvmStatic
    public static final void a(b r2) {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L15;
        r2.d(String.valueOf(r0.hostAppId()));
        r2.v(r0.ecHostAppId());
        r2.y(r0.getFEParamExtra());
        r2.g(r0.appName());
        r2.l(r0.getChannel());
        r2.k0(r0.getVersionCode());
        r2.h0(String.valueOf(r0.getUpdateVersionCode()));
        r2.f0(r0.isNeedProtectUnderage() ? 1 : 0);
        if (fm3.d.b() == true) goto L12;
        Boolean r1 = r0.isDarkMode();
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L11;
    L13:
        String r3 = "dark";
    L14:
        r2.h(r3);
        goto L15
    L11:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L13;
    L12:
        r3 = "light";
    L15:
        r2.p0(String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
    }

    public static JsonElement e(Object r2) {
        Gson r0 = ((ILiveGsonService) jc1.k.n(ILiveGsonService.class)).getDefault();
        if ((r2 instanceof JSONObject) == false) goto L6;
        return GsonProtectorUtils.toJsonTree(r0, GsonProtectorUtils.fromJson(r0, r2.toString(), Object.class));
    L6:
        if ((r2 instanceof JSONArray) == false) goto L9;
        return GsonProtectorUtils.toJsonTree(r0, GsonProtectorUtils.fromJson(r0, r2.toString(), new a().getType()));
    L9:
        return GsonProtectorUtils.toJsonTree(r0, r2);
    }

    @JvmStatic
    public static final void d(b r1, Map<String, String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        String r0 = r2.get("device_brand");
        if (r0 == null) goto L7;
        r1.p(r0);
    L7:
        String r3 = r2.get("iid");
        if (r3 == null) goto L10;
        r1.A(r3);
    L10:
        String r4 = r2.get("minor_status");
        if (r4 == null) goto L13;
        r1.H(r4);
    L13:
        String r5 = r2.get("os_api");
        if (r5 == null) goto L16;
        r1.N(r5);
    L16:
        String r6 = r2.get("fake_region");
        if (r6 == null) goto L19;
        r1.x(r6);
    L19:
        String r7 = r2.get("host_abi");
        if (r7 == null) goto L22;
        r1.z(r7);
    L22:
        String r8 = r2.get("cpu_support64");
        if (r8 == null) goto L25;
        r1.n(r8);
    L25:
        String r9 = r2.get("resolution");
        if (r9 == null) goto L28;
        r1.S(r9);
    L28:
        String r11 = r2.get("ts");
        if (r11 == null) goto L31;
        r1.g0(r11);
    L31:
        String r12 = r2.get("manifest_version_code");
        if (r12 == null) goto L34;
        r1.G(r12);
    L34:
        String r13 = r2.get("oaid");
        if (r13 == null) goto L37;
        r1.J(r13);
    L37:
        String r14 = r2.get("cdid");
        if (r14 == null) goto L40;
        r1.k(r14);
    L40:
        String r15 = r2.get("app_type");
        if (r15 == null) goto L43;
        r1.i(r15);
    L43:
        String r16 = r2.get("dpi");
        if (r16 == null) goto L46;
        r1.t(r16);
    L46:
        String r17 = r2.get("effect_channel");
        if (r17 == null) goto L49;
        r1.w(r17);
    L49:
        String r18 = r2.get("version_name");
        if (r18 == null) goto L52;
        r1.l0(r18);
    L52:
        String r19 = r2.get("address_book_access");
        if (r19 == null) goto L55;
        r1.c(r19);
    L55:
        String r21 = r2.get("_rticket");
        if (r21 == null) goto L59;
        r1.U(r21);
        return;
    }

    @JvmStatic
    public static final void b(b r12, String r13, String r14) {
        com.bytedance.live.datacontext.m r1 = o3.f().getRoom();
        if (r1 == null) goto L5;
        IRoom r2 = (IRoom) r1.getValue();
    L6:
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L16;
        String r5 = r4.n();
        if (r5 == null) goto L13;
        r12.i0(r5);
    L13:
        String r6 = o.a(r4.b());
        if (r6 == null) goto L16;
        r12.b0(r6);
    L16:
        if (r2 == null) goto L28;
        String r7 = r2.getIdStr();
        if (r7 == null) goto L20;
        r12.T(r7);
    L20:
        String r8 = r2.getOwnerUserIdString();
        if (r8 == null) goto L23;
        r12.e(r8);
    L23:
        IBaseUser r9 = r2.getOwner();
        if (r9 == null) goto L28;
        Intrinsics.checkNotNullParameter(r9, "$this$secUidExt");
        String r11 = r9.getCastSecUid();
        if (r11 == null) goto L28;
        r12.a0(r11);
    L28:
        JsonObject r15 = new JsonObject();
        if (TextUtils.isEmpty(r13) == true) goto L53;
        Uri r16 = UriProtector.parse(r13);
        if (r16 == null) goto L34;
        String r17 = UriProtector.getQueryParameter(r16, "settings_keys");
    L35:
        if (r17 == null) goto L53;
        List r18 = StringsKt.split$default(r17, new String[]{","}, false, 0, 6, null);
        if (r18 == null) goto L53;
        ArrayList r19 = new ArrayList();
        Iterator r21 = r18.iterator();
    L40:
        if (r21.hasNext() == false) goto L47;
        Object r22 = r21.next();
        if (((String) r22).length() <= 0) goto L44;
        boolean r23 = true;
    L45:
        if (r23 == false) goto L40;
        r19.add(r22);
        goto L40
    L44:
        r23 = false;
        goto L45
    L47:
        Iterator r24 = r19.iterator();
    L49:
        if (r24.hasNext() == false) goto L53;
        String r25 = (String) r24.next();
        Object r26 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r25);
        if (r26 == null) goto L49;
        r15.add(r25, GsonProtectorUtils.toJsonTree(new Gson(), r26));
        goto L49
    L34:
        r17 = null;
    L53:
        r12.c0(r15);
        JsonObject r27 = new JsonObject();
    L82:
        e = move-exception;
        ALogger.e("HybridParamUtil", e);
    L84:
        r12.b(r27);
        JsonObject r28 = new JsonObject();
    L111:
        e = move-exception;
        ALogger.e("HybridParamUtil", e);
    L113:
        r12.u(r28);
        if (r13 == null) goto L125;
        JsonObject r29 = new JsonObject();
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L122
        Uri r32 = UriProtector.parse(r13);     // Catch: Throwable -> L122
        Iterator r33 = UriProtector.getQueryParameterNames(r32).iterator();     // Catch: Throwable -> L122
    L118:
        if (r33.hasNext() == false) goto L120;
        String r34 = (String) r33.next();     // Catch: Throwable -> L122
        r29.addProperty(r34, UriProtector.getQueryParameter(r32, r34));     // Catch: Throwable -> L122
        goto L118
    L120:
        Result.constructor-impl(r32);     // Catch: Throwable -> L122
    L124:
        r12.R(r29);
    L122:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L125:
        if (r13 == null) goto L127;
        Uri r110 = UriProtector.parse(r13);
    L128:
        ArrayList r36 = new ArrayList();
        r36.add(new ja1.a.c(r14));
        r36.add(new ja1.a.b(r110));
        r36.add(new ja1.a.a(null));
        Object r111 = "";
        if (r36.isEmpty() == true) goto L137;
        Iterator r112 = r36.iterator();
    L133:
        if (r112.hasNext() == false) goto L137;
        ja1.b r37 = (ja1.b) r112.next();
        if (r37.a("inject_json_url") == false) goto L133;
        r111 = r37.b("inject_json_url", "");
    L137:
        String r113 = (String) r111;
        if (r113 != null) goto L140;
        AbstractMap r114 = new HashMap();
    L151:
        r12.C(r114);
        r12.V(String.valueOf(jc1.k.n(IMiddleWareHostContext.class).appId()));
        return;
    L140:
        WebResourceResponse r115 = com.bytedance.android.livesdk.gecko.n.b.c(r113);
        if (r115 != null) goto L143;
        r114 = new HashMap();
        goto L151
    L143:
        BufferedReader r116 = new BufferedReader(new InputStreamReader(r115.getData()));
        StringBuilder r117 = new StringBuilder();
    L144:
        String r38 = r116.readLine();
        if (r38 == null) goto L147;
        r117.append(Intrinsics.stringPlus(r38, "\n"));
        goto L144
    L147:
        ALogger.i("HybridParamUtil", "inject_json = " + r117);
        r114 = UtilsKt.g(new JSONObject(r117.toString()));     // Catch: JSONException -> L150
    L150:
        ALogger.e("HybridParamUtil", "inject_json parse error");
        r114 = new HashMap();
        goto L151
    L127:
        r110 = null;
        goto L128
    L86:
        if (TextUtils.isEmpty(r13) == true) goto L113;
        Uri r39 = UriProtector.parse(r13);     // Catch: Exception -> L111
        if (r39 == null) goto L91;
        String r41 = UriProtector.getQueryParameter(r39, "dynamic_settings");     // Catch: Exception -> L111
    L92:
        if (r41 == null) goto L113;
        JSONArray r42 = new JSONArray(r41);     // Catch: Exception -> L111
        int r43 = r42.length();     // Catch: Exception -> L111
        int r44 = 0;
    L94:
        if (r44 >= r43) goto L113;
        Object r45 = r42.get(r44);     // Catch: Exception -> L111
        if (r45 == null) goto L110;
        if (r45.toString().length() <= 0) goto L100;
        boolean r46 = true;
    L101:
        if (r46 == true) goto L104;
        r45 = null;
    L104:
        if (r45 == null) goto L110;
        Object r47 = jc1.k.n(IMiddleWareHostContext.class).getUgSettingsByKey(1, "data." + r45.toString());     // Catch: Exception -> L111
        if (r47 == null) goto L110;
        JsonElement r48 = e(r47);     // Catch: Exception -> L111
        if (r48 == null) goto L110;
        r28.add(r42.get(r44).toString(), r48);     // Catch: Exception -> L111
        goto L110
    L100:
        r46 = false;
    L110:
        r44 = r44 + 1;
        goto L94
    L91:
        r41 = null;
        goto L92
    L55:
        if (TextUtils.isEmpty(r13) == true) goto L84;
        Uri r49 = UriProtector.parse(r13);     // Catch: Exception -> L82
        if (r49 == null) goto L60;
        String r51 = UriProtector.getQueryParameter(r49, "activity_settings");     // Catch: Exception -> L82
    L61:
        if (r51 == null) goto L84;
        JSONArray r52 = new JSONArray(r51);     // Catch: Exception -> L82
        int r53 = r52.length();     // Catch: Exception -> L82
        if (r53 < 0) goto L84;
        int r54 = 0;
    L65:
        Object r55 = r52.get(r54);     // Catch: Exception -> L82
        if (r55 != null) goto L68;
    L80:
        if (r54 == r53) goto L84;
        r54 = r54 + 1;
        goto L65
    L68:
        if (r55.toString().length() <= 0) goto L70;
        boolean r118 = true;
    L71:
        if (r118 == true) goto L74;
        r55 = null;
    L74:
        if (r55 == null) goto L80;
        Object r56 = jc1.k.n(IMiddleWareHostContext.class).getUgSettingsByKey(0, "data.common_info.extra." + r55.toString());     // Catch: Exception -> L82
        if (r56 == null) goto L80;
        JsonElement r57 = e(r56);     // Catch: Exception -> L82
        if (r57 == null) goto L80;
        r27.add(r52.get(r54).toString(), r57);     // Catch: Exception -> L82
        goto L80
    L70:
        r118 = false;
        goto L71
    L60:
        r51 = null;
        goto L61
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(b r4, Context r5, Map<String, String> r6) {
        r4.q(AppLog.v());
        r4.Y(s1.G(s1.y()));
        r4.W(s1.G(s1.q(r5).heightPixels - x1.j(r5)));
        r4.Z(s1.y());
        r4.X(s1.w());
        r4.d0(s1.G(s1.A()));
        r4.P(RomUtils.isTablet(r5) ? 1 : 0);
        r4.I(DigHoleScreenUtil.isDigHole(r5) ? 1 : 0);
        r4.M(e5.j((Activity) r5) ? 1 : 0);
        r4.o0(Resources.getSystem().getConfiguration().locale.toString());
        r4.n0(Locale.CHINA.getLanguage());
        r4.m0(String.valueOf(com.bytedance.android.live.network.impl.utils.i.b()));
        r4.j(x1.j(r5));
        r4.Q(((Integer) l6.a.getValue()).intValue());
        se r1 = se.a;
        r4.r(String.format("%.2f", Arrays.copyOf(new Object[]{(Float) r1.getValue()}, 1)));
        r4.j0(String.format("%.2f", Arrays.copyOf(new Object[]{(Float) r1.getValue()}, 1)));
        r4.e0(s1.n());
        if (r6 != null) goto L5;
        return;
    L5:
        String r0 = r6.get("is_android_pad");
        if (r0 != null) goto L8;
    L11:
        String r7 = r6.get("device_type");
        if (r7 == null) goto L14;
        r4.s(r7);
    L14:
        String r8 = r6.get("os_version");
        if (r8 == null) goto L17;
        r4.O(r8);
    L17:
        String r9 = r6.get("language");
        if (r9 == null) goto L21;
        r4.D(r9);
    L21:
        if (((Boolean) n1.a.getValue()).booleanValue() == false) goto L25;
        String r11 = r6.get("openudid");
        if (r11 == null) goto L25;
        r4.L(r11);
    L25:
        String r12 = r6.get("ac");
        if (r12 == null) goto L28;
        r4.a(r12);
    L28:
        String r13 = r6.get("current_network_quality_info");
        if (r13 == null) goto L32;
        r4.o(r13);
        return;
    L32:
        return;
    L8:
        if ((true ^ StringsKt.isBlank(r0)) == false) goto L10;
        r4.P(CastIntegerProtector.parseInt(r0));
    L10:
        r4.f(r0);
        goto L11
    }
}
