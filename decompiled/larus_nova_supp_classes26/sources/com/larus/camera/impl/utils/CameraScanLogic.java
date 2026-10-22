package com.larus.camera.impl.utils;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.utils.a4;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.network.BoeDomainResolver;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.b2;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CameraScanLogic {
    public static final CameraScanLogic a = null;
    public static final MutableSharedFlow<Unit> b = null;
    public static final Object c = null;
    public static a d;

    public static final class a {
        public final boolean a;
        public final Function1<String, Unit> b;
        public final Function1<String, Unit> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "HostScanCodeCallback(onlyFromCamera=" + this.a + ", onResult=" + this.b + ", onFailure=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean r2, Function1<? super String, Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "onResult");
            Intrinsics.checkNotNullParameter(r4, "onFailure");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public CameraScanLogic() {
    }

    static {
        a = new CameraScanLogic();
        b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        c = new Object();
    }

    /* JADX WARN: Type inference failed for: r11v16, types: [com.larus.camera.impl.utils.o] */
    /* JADX WARN: Type inference failed for: r11v20, types: [com.larus.camera.impl.utils.n] */
    public static boolean a(String r17) {
        boolean r2 = false;
        if (r17 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        FLogger.a.e("CameraScanLogic", "empty BashScanResult");
        return false;
    L13:
        a4.a.getClass();
        a4.a(a4.b);
        String r5 = y0.k(UriProtector.parse(r17).buildUpon().appendQueryParameter("enter_from", "app_chat_list_plus").build());
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L20;
        FlowAppletServiceImpl r3 = r1.g0();
        if (r3 == null) goto L20;
        if (r3.l(r17) != true) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        return true;
    L23:
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L30;
        FlowAppletServiceImpl r7 = r6.g0();
        if (r7 == null) goto L30;
        if (r7.n(r17) != true) goto L30;
        boolean r8 = true;
    L32:
        if (r8 == false) goto L34;
        FLogger.a.i("CameraScanLogic", "try to start debug mode");
    L183:
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        JSONObject r10 = new JSONObject();
        a.getClass();
        String r11 = AppHost.a.d() + "/inapp/scan-login";
        if (r17 != null) goto L186;
    L188:
        boolean r12 = false;
    L189:
        if (r12 == false) goto L191;
        String r13 = "login";
    L201:
        r10.putOpt("result", r13);
        Unit r14 = Unit.INSTANCE;
        r9.reportEvent("scan_qr_code_result", r10);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CameraScanLogic$interceptBashScanResult$3(null), 3, null);
        FLogger.a.i("CameraScanLogic", "open url from camera scan qrcode, link_url: " + r5);
        return true;
    L191:
        if (r17 != null) goto L193;
    L195:
        if (r2 == false) goto L200;
        Uri r15 = y0.j(r17);
        if (r15 == null) goto L200;
        r13 = UriProtector.getQueryParameter(r15, "enter_method");
        if (r13 != null) goto L201;
    L200:
        r13 = "other";
        goto L201
    L193:
        if (StringsKt.contains$default(r17, "//flow/realtime_chat", false, 2, null) != true) goto L195;
        r2 = true;
        goto L195
    L186:
        if (StringsKt.startsWith$default(r17, r11, false, 2, null) != true) goto L188;
        r12 = true;
        goto L189
    L34:
        z2 r16 = z2.a;
        if (r16.larkScanCodeLoginEnabled() == false) goto L63;
        List<String> r18 = m.a;
        Intrinsics.checkNotNullParameter(r17, "scanResult");
        String r19 = AccountService.a.d(r17);
        if (r19 != null) goto L40;
    L58:
        boolean r20 = false;
    L61:
        if (r20 == false) goto L63;
        r5 = "lark_qr_login";
        goto L183
    L40:
        if (StringsKt.isBlank(r19) == false) goto L42;
        FLogger.a.w("CameraScanInfo", "LarkQrLoginScanSdk can handle result, but returned empty url");
        t19.s r21 = t19.s.a;
        Application r110 = AppHost.a.getApplication();
        r21.getClass();
        t19.s.b(r110, 2131907052, false);
    L60:
        r20 = true;
        goto L61
    L42:
        Uri r22 = y0.j(r19);
        if (r22 == null) goto L47;
        Uri r23 = y0.l(r22, "hide_nav_bar", "1");
        if (r23 == null) goto L47;
        String r24 = y0.k(r23);
    L48:
        if (r24 != null) goto L50;
    L53:
        boolean r111 = true;
    L54:
        if (r111 == false) goto L56;
        FLogger.a.w("CameraScanInfo", "LarkQrLoginScanSdk url parse failed");
        goto L58
    L56:
        String r25 = y0.k(UriProtector.parse("//flow/webview").buildUpon().appendQueryParameter("link_url", r24).build());
        if (r25 == null) goto L58;
        com.bytedance.router.i r26 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), r25);
        Bundle r112 = new Bundle();
        r112.putBoolean("bundle_need_lark_auth_cookie_sync", true);
        r26.c.putExtras(r112);
        r26.d();
        goto L60
    L50:
        if (StringsKt.isBlank(r24) == true) goto L53;
        r111 = false;
    L47:
        r24 = null;
    L63:
        FLogger r113 = FLogger.a;
        r113.d("CameraScanLogic", "parseScanToPayInAppAction url: " + r5);
        if (r16.enableScanToPayInApp() == true) goto L66;
        r113.i("CameraScanLogic", "parseScanToPayInAppAction enableScanToPayInApp is false");
    L126:
        Object r27 = null;
    L127:
        if (r27 == null) goto L147;
        AppHost.Companion r28 = AppHost.a;
        Context r29 = r28.a().getCurrentActivity();
        if (r29 != null) goto L132;
        r29 = r28.getApplication();
    L132:
        if ((r27 instanceof q) == false) goto L139;
        q r30 = (q) r27;
        final String r31 = r30.a.get("papi_id");
        final String r114 = GsonProtectorUtils.toJson(new Gson(), r30.a);
        ICommerceMembershipService r115 = (ICommerceMembershipService) ServiceManager.get().getService(ICommerceMembershipService.class);
        if (r115 == null) goto L137;
        r115.B(r31, null, "20", r114, "scan");
    L137:
        FLogger.a.i("CameraScanLogic", "routeSign called");
        com.larus.platform.service.w.a.b(r29, r30.a, new n(r31, r114));
        goto L183
    L139:
        if ((r27 instanceof p) == false) goto L145;
        p r32 = (p) r27;
        final String r33 = r32.a.get("papi_id");
        final String r34 = GsonProtectorUtils.toJson(new Gson(), r32.a);
        f0 r35 = new f0("1", "1");
        ICommerceMembershipService r116 = (ICommerceMembershipService) ServiceManager.get().getService(ICommerceMembershipService.class);
        if (r116 == null) goto L143;
        r116.B(r33, null, "20", r34, "scan");
    L143:
        FLogger.a.i("CameraScanLogic", "pay called");
        com.larus.platform.service.w.a.d(r29, r34, GsonProtectorUtils.toJson(new Gson(), r35), new o(r33, r34));
        goto L183
    L145:
        throw new NoWhenBranchMatchedException();
    L147:
        if (y0.e(r5) == false) goto L182;
        int r36 = BoeDomainResolver.a;
        if (r5 != null) goto L152;
        String r37 = null;
    L181:
        com.larus.platform.service.q.a.e(AppHost.a.getApplication(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r37)}), null);
        goto L183
    L152:
        if (AppHost.a.isOversea() == false) goto L154;
    L156:
        boolean r38 = false;
    L157:
        if (r38 == false) goto L180;
        com.larus.platform.api.i r39 = b2.a.a();
        if (r39.a.length() != 0) goto L162;
        boolean r40 = true;
    L163:
        if (r40 == true) goto L180;
        if (r39.b.length() != 0) goto L167;
        boolean r41 = true;
    L168:
        if (r41 == true) goto L180;
        Uri r42 = y0.j(r5);
        if (r42 == null) goto L180;
        if (Intrinsics.areEqual(r42.getHost(), r39.a) == false) goto L180;
        r37 = y0.k(r42.buildUpon().authority(r39.b).build());
        if (r37 != null) goto L179;
        r37 = r5;
    L179:
        FLogger.a.i("BoeDomainResolver", "adaptWebUrl: host replaced for BOE");
        goto L181
    L167:
        r41 = false;
        goto L168
    L162:
        r40 = false;
    L180:
        r37 = r5;
        goto L181
    L154:
        if (HttpExtKt.e().a == false) goto L156;
        r38 = true;
        goto L157
    L182:
        SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), r5).d();
        goto L183
    L66:
        if (r5 == null) goto L126;
        Uri r117 = y0.j(r5);
        if (r117 == null) goto L126;
        String r43 = r117.getHost();
        if (r43 != null) goto L73;
    L76:
        boolean r44 = true;
    L77:
        if (r44 == false) goto L79;
    L125:
        r113.i("CameraScanLogic", "parseScanToPayInAppAction host not in allow list, host: " + r117 + ".host");
        goto L126
    L79:
        if (CollectionsKt.contains(m.a, r117.getHost()) == false) goto L125;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L83
        Object r46 = Result.constructor-impl(UriProtector.getQueryParameter(r117, "papi_id"));     // Catch: Throwable -> L83
    L86:
        if (Result.isFailure-impl(r46) == false) goto L88;
        r46 = null;
    L88:
        String r118 = (String) r46;
        if (r118 != null) goto L91;
    L94:
        boolean r47 = true;
    L95:
        if (r47 == false) goto L205;
        FLogger.a.i("CameraScanLogic", "parseScanToPayInAppAction papiId is null");
        goto L126
    L205:
        Object r48 = Result.constructor-impl(UriProtector.getQueryParameter(r117, "scan_scene"));     // Catch: Throwable -> L99
    L102:
        if (Result.isFailure-impl(r48) == false) goto L104;
        r48 = null;
    L104:
        String r49 = (String) r48;
        if (r49 != null) goto L107;
        r49 = "";
    L107:
        FLogger.a.i("CameraScanLogic", "parseScanToPayInAppAction scanScene: ".concat(r49));
        Map r50 = MapsKt.mapOf(new Pair[]{TuplesKt.to("papi_id", r118), TuplesKt.to("scan_scene", r49), TuplesKt.to("saas_scene", "jh_saas")});
        int r119 = r49.hashCode();
        if (r119 == (-557969986)) goto L122;
        if (r119 == 110760) goto L119;
        if (r119 != 3530173) goto L126;
        if (r49.equals("sign") == false) goto L126;
        r27 = new q(r50);
        goto L127
    L119:
        if (r49.equals("pay") == false) goto L126;
    L124:
        r27 = new p(r50);
        goto L127
    L122:
        if (r49.equals("sign_and_pay") == true) goto L124;
    L99:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L102
    L91:
        if (StringsKt.isBlank(r118) == true) goto L94;
        r47 = false;
    L83:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r46 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L73:
        if (StringsKt.isBlank(r43) == true) goto L76;
        r44 = false;
    L30:
        r8 = false;
    L20:
        r4 = false;
        goto L21
    L5:
        if (StringsKt.isBlank(r17) == true) goto L8;
        r0 = false;
        goto L10
    }
}
