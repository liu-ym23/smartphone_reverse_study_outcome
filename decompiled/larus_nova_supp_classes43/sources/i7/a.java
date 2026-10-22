package i7;

import android.content.Context;
import android.net.Uri;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.param.j;
import com.bytedance.android.annie.param.k;
import com.bytedance.android.annie.param.m;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.x;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import i9.d;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import p9.f;
import p9.g;
import w26.e;
import y8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a(Map r15, String r16, Context r17, String r18, boolean r19, String r20, String r21, Boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "bizKey");
        Boolean r10 = Boolean.TRUE;
        boolean r11 = false;
        Uri r13 = null;
        if (Intrinsics.areEqual(r22, r10) == false) goto L13;
        int r12 = com.bytedance.android.annie.a.a;
        Intrinsics.checkNotNullParameter(r21, "bizKey");
        k r14 = j.b.a();
        if (r14 != null) goto L7;
    L8:
        r14 = new k(null);
        ((f) Annie.getService$default(f.class, null, 2, null)).C1(r14);
        com.bytedance.android.annie.a.f(r14);
    L9:
        k r110 = r14;
        r110.c = true;
        r110.S1(AnnieConfigSettingKeys.IS_OVERSEA.a().booleanValue() ? 1 : 0);
        r110.l1(x.b());
        Pair[] r23 = new Pair[5];
        y8.a r24 = y8.a.a;
        r23[0] = TuplesKt.to("memory_rest", Double.valueOf(r24.d(r17)));
        r23[1] = TuplesKt.to("temperature", Float.valueOf(r24.a(r17)));
        r23[2] = TuplesKt.to("network_quality", r24.b());
        r23[3] = TuplesKt.to("fps", Float.valueOf(y8.a.c()));
        float r25 = ((c) Annie.getService$default(c.class, null, 2, null)).v0();
        if (r25 >= 0) goto L12;
        r25 = 60.0f;
    L12:
        r23[4] = TuplesKt.to("fpsMin", Float.valueOf(r25));
        r110.a1(MapsKt.mapOf(r23));
        ((g) Annie.getService$default(g.class, null, 2, null)).i0(r110);
        ((d) Annie.getService$default(d.class, null, 2, null)).O(r110, r17, r18, r19, r20);
    L15:
        if (Intrinsics.areEqual(r16, "webcast") == false) goto L22;
        r15.put("aid", r110.f());
        r15.put("os", r110.Z());
        r15.put("language", r110.S());
        r15.put("fake_region", r110.K());
        r15.put("osLanguage", r110.b0());
        r15.put("isAccessible", Integer.valueOf(r110.J0()));
        Map<String, String> r26 = r110.g0();
        if (r26 == null) goto L19;
        r15.put("queryItems", r26);
    L19:
        r15.put(BdpAwemeConstant.KEY_APP_NAME, r110.j());
        r15.put("appTheme", r110.l());
        r15.put("appVersion", r110.n());
        r15.put("channel", r110.s());
        r15.put("deviceScore", Float.valueOf(r110.C()));
        r15.put("fontScale", Float.valueOf(r110.L()));
        r15.put("status_bar_height", Float.valueOf(r110.u0()));
        r15.put("updateVersionCode", r110.y0());
        if (Intrinsics.areEqual(r22, r10) == true) goto L22;
        r15.put("screenWidth", Float.valueOf(r110.o0()));
        r15.put("screenHeight", Float.valueOf(r110.l0()));
        r15.put("statusBarHeight", Float.valueOf(r110.t0()));
        r15.put("orientation", Integer.valueOf(r110.Y()));
        r15.put("isTeenMode", Integer.valueOf(r110.P0()));
    L22:
        r15.put("appID", r110.h());
        r15.put("appLanguage", r110.i());
        r15.put("app_name", r110.o());
        r15.put("update_version_code", r110.z0());
        r15.put("device_brand", r110.E());
        r15.put("deviceID", r110.z());
        r15.put("device_id", r110.A());
        r15.put("device_type", r110.D());
        r15.put("device_score", r110.G());
        r15.put("os_version", r110.d0());
        if (Intrinsics.areEqual(r22, r10) == true) goto L25;
        r15.put("is_pad", Integer.valueOf(r110.O0()));
    L25:
        r15.put("systemFontScale", Float.valueOf(r110.v0()));
        r15.put("accessible", Boolean.valueOf(r110.c()));
        r15.put("screenOrientation", r110.n0());
        r15.put("ab_params", r110.a());
        String r27 = r110.P();
        if (StringsKt.isBlank(r27) == false) goto L28;
        r27 = String.valueOf(System.currentTimeMillis());
    L28:
        r15.put("initTimestamp", r27);
        String r28 = r110.t();
        if (StringsKt.isBlank(r28) == false) goto L31;
        r28 = String.valueOf(System.currentTimeMillis());
    L31:
        r15.put("containerInitTime", r28);
        r15.put("systemViewZoom", Float.valueOf(r110.w0()));
        Map<String, Object> r29 = r110.k();
        if (r29 == null) goto L34;
        r15.put("appRunTimeInfo", r29);
    L34:
        r15.put("glEsVersion", Integer.valueOf(r110.M()));
        if (r110.y() != 0) goto L37;
        long r30 = System.currentTimeMillis();
    L38:
        r15.put("currentTime", Long.valueOf(r30));
        r15.put("version_code", r110.C0());
        r15.put("webcast_sdk_version", r110.H0());
        r15.put("perf", Integer.valueOf(r110.f0()));
        r15.put("is_notch", Integer.valueOf(r110.N0()));
        r15.put("webcast_language", r110.F0());
        r15.put("ve_device_score", r110.B0());
        r15.put("pad_opt_type", Integer.valueOf(r110.e0()));
        if (Intrinsics.areEqual(r22, r10) == false) goto L41;
        r15.put("ac", NetworkUtils.getNetworkAccessType(r17));
    L42:
        r15.put("current_network_quality_info", r110.x());
        r15.put("is_android_pad", r110.K0());
        r15.put("openudid", r110.X());
        r15.put("iid", r110.O());
        r15.put("minor_status", r110.U());
        r15.put("os_api", r110.a0());
        r15.put("host_abi", r110.N());
        r15.put("cpu_support64", r110.w());
        r15.put("webcast_locale", r110.G0());
        r15.put("webcast_gps_access", r110.E0());
        r15.put("realScreenHeight", Float.valueOf(r110.h0()));
        r15.put("screenWidthPx", Integer.valueOf(r110.p0()));
        r15.put("screenHeightPx", Integer.valueOf(r110.m0()));
        r15.put("networkType", r110.V());
        r15.put("osTheme", r110.c0());
        r15.put("container_name", r110.u());
        r15.put("webcast_version", Integer.valueOf(r110.I0()));
        r15.put("bottom_bar_height", Integer.valueOf(r110.p()));
        r15.put("device_platform", r110.F());
        r15.put("devicePlatform", r110.B());
        r15.put("cdid", r110.r());
        r15.put("app_type", r110.m());
        r15.put("address_book_access", r110.e());
        r15.put("_rticket", r110.k0());
        r15.put("manifest_version_code", r110.T());
        r15.put("oaid", r110.W());
        r15.put("dpi", r110.H());
        r15.put("ts", r110.x0());
        r15.put("effect_channel", r110.J());
        r15.put("resolution", r110.i0());
        r15.put("version_name", r110.D0());
        Map<String, ? extends Object> r0 = r110.b;
        if (r0 == null) goto L45;
        r15.put("storage_data", r0);
    L45:
        Map<String, ? extends Object> r1 = r110.a;
        if (r1 == null) goto L48;
        r15.put("prefetch_data", r1);
    L48:
        Map<String, Object> r31 = r110.q();
        if (r31 == null) goto L51;
        r15.put("initialBusinessProps", r31);
    L51:
        String r32 = r110.R();
        if (r32 == null) goto L54;
        r15.put("jsbProxyAppId", r32);
    L54:
        r15.put(com.bytedance.android.ec.core.event.a.KEY_USER_ID, r110.A0());
        r15.put("sec_user_id", r110.r0());
        r15.put(com.bytedance.android.ec.core.event.a.KEY_ANCHOR_ID, r110.g());
        r15.put("sec_anchor_id", r110.q0());
        r15.put(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r110.j0());
        if (r110.s0().size() != 0) goto L57;
        Object r33 = new JSONObject();
    L58:
        r15.put("settings", r33);
        if (r110.d().size() != 0) goto L61;
        Object r34 = new JSONObject();
    L62:
        r15.put("activity_settings", r34);
        if (r110.I().size() != 0) goto L65;
        Object r35 = new JSONObject();
    L66:
        r15.put("dynamic_settings", r35);
        r15.put("inject_json", r110.Q());
        r15.put("containerVersion", r110.v());
        r15.put("containerType", "annie");
        r15.put("isDouyinSeries", Boolean.valueOf(r110.L0()));
        r15.put("isLogin", Integer.valueOf(r110.M0()));
        Map r36 = x26.a.a;
        w26.g r37 = (w26.g) x26.a.a(w26.g.class);
        if (r37 == null) goto L73;
        e r38 = (e) r37.n0(e.class);
        if (r38 == null) goto L73;
        Boolean r39 = r38.Y();
        if (r39 == null) goto L73;
        boolean r40 = r39.booleanValue();
    L74:
        if (r40 == false) goto L84;
        if (r20 != null) goto L77;
    L80:
        boolean r41 = true;
    L81:
        if (r41 == true) goto L84;
        r15.put(com.bytedance.android.ec.core.event.a.KEY_LOCATION, r20);
        goto L84
    L77:
        if (r20.length() == 0) goto L80;
        r41 = false;
    L84:
        if (Intrinsics.areEqual(r22, Boolean.FALSE) == false) goto L101;
        m r42 = (m) com.bytedance.android.annie.a.c(m.class);
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L95
        if (r18 != null) goto L89;
    L90:
        r11 = true;
    L91:
        if (r11 == true) goto L97;
        r13 = UriProtector.parse(r18);     // Catch: Throwable -> L95
    L97:
        r42.y(r15, r13);
        return;
    L89:
        if (r18.length() != 0) goto L91;
    L95:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L97
    L101:
        return;
    L73:
        r40 = true;
        goto L74
    L65:
        r35 = UtilsKt.i(r110.I());
        goto L66
    L61:
        r34 = UtilsKt.i(r110.d());
        goto L62
    L57:
        r33 = UtilsKt.i(r110.s0());
        goto L58
    L41:
        r15.put("ac", r110.b());
        goto L42
    L37:
        r30 = r110.y();
        goto L38
    L7:
        if (Intrinsics.areEqual(r14.f(), "") == false) goto L9;
    L13:
        r110 = com.bytedance.android.annie.a.a(r17, r18, r19, r20, r21);
        goto L15
    }

    public static /* synthetic */ void b(a r10, Map r11, String r12, Context r13, String r14, boolean r15, String r16, String r17) {
        Boolean r18 = Boolean.FALSE;
        r10.getClass();
        a(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
