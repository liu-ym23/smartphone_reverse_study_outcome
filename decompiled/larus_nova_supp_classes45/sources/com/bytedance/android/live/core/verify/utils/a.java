package com.bytedance.android.live.core.verify.utils;

import am2.x;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.v1;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.core.verify.monitor.RealNameFullMonitor;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostAliYunVerifyProxy;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.business.IHostOCRPreloadApiProxy;
import com.bytedance.android.livehostapi.business.depend.IHostReady;
import com.bytedance.android.livehostapi.business.depend.OnVerifyPluginPreloadListener;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.model.n;
import com.bytedance.android.livesdk.widget.e1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.verify.utils.a$a, reason: collision with other inner class name */
    public class C0174a implements e {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ w80.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ String e;
        public final /* synthetic */ g f;
        public final /* synthetic */ f g;
        public final /* synthetic */ boolean h;

        public C0174a(Activity r1, w80.a r2, String r3, Bundle r4, String r5, g r6, f r7, boolean r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    public class b implements OnVerifyPluginPreloadListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ w80.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ g h;
        public final /* synthetic */ f i;
        public final /* synthetic */ boolean j;
        public final /* synthetic */ boolean k;

        public final void finish(boolean r12) {
            a.q(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
        }

        public b(Activity r1, w80.a r2, String r3, Bundle r4, int r5, String r6, boolean r7, g r8, f r9, boolean r11, boolean r12) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r11;
            this.k = r12;
        }
    }

    public class c implements OnVerifyPluginPreloadListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;

        public final void finish(boolean r2) {
            if (r2 == false) goto L4;
            this.a.a(this.b);
            return;
        L4:
            this.a.a("zhima_app");
        }

        public c(d r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface d {
        void a(String r1);
    }

    public interface e {
    }

    public interface f {
        Observable<Response<w80.a>> a(Map<String, String> r1);
    }

    public interface g {
        void onVerify(boolean r1, Map<String, Object> r2);
    }

    public static String h(int r1) {
        if (r1 != 0) goto L5;
        return "zhifubao";
    L5:
        if (r1 != 3) goto L8;
        return "aliyun";
    L8:
        if (r1 != 2) goto L10;
        return "self";
    L10:
        return "";
    }

    public static String d() {
        ClientABTestKey<String> r0 = com.bytedance.android.live.base.abtest.a.a;
        com.bytedance.android.live.base.abtest.b.b.getClass();
        String r1 = (String) com.bytedance.android.live.base.abtest.b.a.a(r0);
        IHostReady r2 = f();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L12;
        return "zhima_app";
    L12:
        return r1;
    L5:
        if (r2.isSDKReady() == false) goto L7;
        r3 = true;
        goto L8
    }

    public static IHostReady f() {
        ClientABTestKey<String> r0 = com.bytedance.android.live.base.abtest.a.a;
        com.bytedance.android.live.base.abtest.b.b.getClass();
        String r1 = (String) com.bytedance.android.live.base.abtest.b.a.a(r0);
        if (TextUtils.equals(r1, "self") == false) goto L6;
        return k.f(IHostOCRApiProxy.class);
    L6:
        if (TextUtils.equals(r1, "ali_cloud") == false) goto L9;
        return k.f(IHostAliYunVerifyProxy.class);
    L9:
        if (TextUtils.equals(r1, "zhima") == false) goto L11;
        HashMap r2 = new HashMap();
        r2.put("face_identify", r1);
        u.l().sendLog("livesdk_zhima_sdk_wrong", r2, new Object[0]);
    L11:
        return null;
    }

    public static boolean j() {
        IHostAliYunVerifyProxy r0 = k.f(IHostAliYunVerifyProxy.class);
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isSDKReady() == false) goto L8;
        return false;
    }

    public static int g() {
        String r0 = d();
        r0.getClass();
        if (r0.equals("self") == false) goto L5;
        return 2;
    L5:
        if (r0.equals("ali_cloud") == true) goto L7;
        return 0;
    L7:
        return 3;
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static boolean i(Activity r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        PackageManager r4 = r3.getPackageManager();
        Intent r1 = new Intent("android.intent.action.VIEW");
        r1.setData(UriProtector.parse("alipays://"));
        List<ResolveInfo> r5 = r4.queryIntentActivities(r1, 64);
        if (r5 != null) goto L8;
        return true;
    L8:
        if (r5.size() == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public static Map<String, String> c(Context r4, int r5) {
        HashMap r0 = new HashMap();
        r0.put("certify_type", "0");
        r0.put("return_url", "snssdk" + k.f(IHostContext.class).appId() + "://");
        if (r5 == 2) goto L7;
        if (r5 == 3) goto L6;
        String r1 = "alipay";
    L8:
        r0.put("verify_channel", r1);
        if (r4 == null) goto L16;
        if (r5 != 3) goto L16;
        if (j() == true) goto L16;
        String r6 = k.f(IHostAliYunVerifyProxy.class).getMetaInfos(r4);
        if (r6 == null) goto L16;
    L17:
        r0.put("meta_info", r6);
        if (r5 != 0) goto L20;
    L21:
        r0.put("zhima_type", String.valueOf(r5));
    L22:
        return r0;
    L20:
        if (r5 != 1) goto L22;
    L16:
        r6 = "";
        goto L17
    L6:
        r1 = "alicloud";
        goto L8
    L7:
        r1 = "byte";
        goto L8
    }

    public static void e(Context r3, boolean r4, d r5) {
        ClientABTestKey<String> r0 = com.bytedance.android.live.base.abtest.a.a;
        com.bytedance.android.live.base.abtest.b.b.getClass();
        String r1 = (String) com.bytedance.android.live.base.abtest.b.a.a(r0);
        IHostReady r2 = f();
        if (r2 != null) goto L7;
        r5.a("zhima_app");
        return;
    L7:
        if (r2.isSDKReady() == false) goto L10;
        r5.a(r1);
        return;
    L10:
        r2.tryPreload(r3, r4, new c(r5, r1));
    }

    public static void l(String r4, Bundle r5, int r6, int r7) {
        String r8 = String.valueOf(r7);
        HashMap r0 = new HashMap();
        if (r5 == null) goto L8;
        Iterator<String> r1 = r5.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();
        r0.put(r2, r5.getString(r2, ""));
    L8:
        r0.put("enter_from", r4);
        if (TextUtils.isEmpty((CharSequence) r0.get("verify_type")) == false) goto L11;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logForVerifiedSdkStart verify_type is null ");
        r0.put("verify_type", "realname");
    L11:
        r0.put("verified_confirm_page_source", h(r6));
        r0.put("cert_type", r8);
        u.l().sendLog("livesdk_verified_sdk_start", r0, new Object[0]);
    }

    public static void m(String r5, Bundle r6, String r7, int r8, int r9) {
        HashMap r0 = new HashMap();
        String r1 = "";
        if (r6 == null) goto L8;
        Iterator<String> r2 = r6.keySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        String r3 = r2.next();
        r0.put(r3, r6.getString(r3, ""));
    L8:
        r0.put("result", r7);
        r0.put("enter_from", r5);
        if (TextUtils.isEmpty((CharSequence) r0.get("verify_type")) == false) goto L11;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logQueryResult verify_type is null ");
        r0.put("verify_type", "realname");
    L11:
        if (r8 != 0) goto L13;
        r1 = "app";
    L13:
        r0.put("zhifubao_type", r1);
        r0.put("verified_confirm_page_source", h(r8));
        r0.put("cert_type", String.valueOf(r9));
        if ("recharge".equals(r5) == false) goto L16;
        u.l().sendLog("livesdk_user_identification_result", r0, new Object[]{x.class, Room.class});
    L16:
        u.l().sendLog("livesdk_zhima_page_confirm", r0, new Object[]{x.class, Room.class});
    }

    public static void k(String r4, Bundle r5, int r6, boolean r7, int r8, String r9) {
        String r11 = String.valueOf(r6);
        HashMap r0 = new HashMap();
        if (r5 == null) goto L8;
        Iterator<String> r1 = r5.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();
        r0.put(r2, r5.getString(r2, ""));
    L8:
        r0.put("enter_from", r4);
        if (TextUtils.isEmpty((CharSequence) r0.get("verify_type")) == false) goto L12;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logForVerifiedSdkStart verify_type is null ");
        r0.put("verify_type", "realname");
    L12:
        if (TextUtils.isEmpty(r9) == true) goto L14;
        r0.put("fail_reason", r9);
    L14:
        if (r7 == false) goto L16;
        String r12 = "success";
    L17:
        r0.put("result", r12);
        r0.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, String.valueOf(r8));
        r0.put("verified_confirm_page_source", h(3));
        r0.put("cert_type", r11);
        u.l().sendLog("livesdk_verified_sdk_result", r0, new Object[0]);
        return;
    L16:
        r12 = "fail";
        goto L17
    }

    public static void n(final Activity r15, final w80.a r16, final String r17, final Bundle r18, boolean r19, int r21, final g r22, final boolean r23) {
        if (r16 == null) goto L48;
        if (r15 == null) goto L52;
        if (r21 == 0) goto L8;
    L11:
        int r0 = r16.certType;
        HashMap r1 = new HashMap();
        String r12 = "";
        if (r18 == null) goto L17;
        Iterator<String> r2 = r18.keySet().iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        String r3 = r2.next();
        r1.put(r3, r18.getString(r3, ""));
    L17:
        r1.put("enter_from", r17);
        if (TextUtils.isEmpty((CharSequence) r1.get("verify_type")) == false) goto L21;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logForStartVerify verify_type is null ");
        r1.put("verify_type", "realname");
    L21:
        if (r21 == 0) goto L25;
        if (r21 != 3) goto L26;
        r1.put("verified_confirm_page_source", "aliyun");
    L26:
        r1.put("cert_type", String.valueOf(r0));
        u.l().sendLog("livesdk_zhima_page_start_verified", r1, new Object[]{x.class, Room.class});
        if (r21 == 3) goto L29;
        l(r17, r18, 0, r16.certType);
        QueryResultForAliPayApp r11 = new QueryResultForAliPayApp(r15, r16, r17, r18, r19, r22, r23);
        Intent r4 = new Intent("android.intent.action.VIEW");
        r12 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(r16.url, "UTF-8");     // Catch: UnsupportedEncodingException -> L37
    L38:
        r4.setData(UriProtector.parse(r12));
        Activity r5 = r11.a;
        if (r5 == null) goto L41;
        r5.startActivity(r4);
    L41:
        r11.f = true;
        com.bytedance.android.tools.superkv.e r6 = r11.g;
        if (r6 == null) goto L51;
        r6.putString("is_verify_processed", GsonProtectorUtils.toJson(GsonHelper.getDefault(), r11.d));
        return;
    L51:
        return;
    L29:
        if (TextUtils.isEmpty(r16.certToken) == false) goto L31;
        return;
    L31:
        if (j() == true) goto L53;
        l(r17, r18, 3, r16.certType);
        k.f(IHostAliYunVerifyProxy.class).verify(r15, r16.certToken, false, new a90.f(r15, r16, r17, r18, r22, r23));
        return;
    L53:
        return;
    L25:
        r1.put("zhifubao_type", "app");
        goto L26
    L8:
        if (i(r15) == false) goto L11;
        HashMap r13 = new HashMap();
        r13.put("status", -1);
        r13.put("msg", "未安装支付宝");
        RealNameFullMonitor.b(r17, false, r19, -1, "未安装支付宝", 0, r16);
        b(r15, r16, r17, r18, r19, r21, r13, r22, r23);
        return;
    L52:
        return;
    }

    public static void p(Activity r14, w80.a r15, String r16, String r17, Bundle r18, g r19, f r21, boolean r22) {
        IHostOCRPreloadApiProxy r0 = k.f(IHostOCRPreloadApiProxy.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        e(r14, false, new com.bytedance.android.live.core.verify.utils.b(new C0174a(r14, r15, r16, r18, r17, r19, r21, r22)));
        return;
    L10:
        o(r14, r15, r16, r18, g(), r17, true, r19, r21, false, r22);
        return;
    L5:
        if (r0.supportTryPreload() == false) goto L7;
        r1 = true;
        goto L8
    }

    public static void b(final Activity r19, final w80.a r21, final String r22, final Bundle r23, final boolean r24, final int r25, final Map<String, Object> r26, final g r27, final boolean r28) {
        if (r21 == null) goto L40;
        if (r19 == null) goto L41;
        HashMap r0 = new HashMap();
        r0.put("zhima_token", r21.zhimaToken);
        if ("recharge".equals(r22) == false) goto L9;
        r0.put("scene", GamePromoteDataContext.GAME_TYPE_MOBILE);
    L9:
        r0.put("enter_from", r22);
        r0.put("cert_token", r21.certToken);
        if (r25 != 2) goto L12;
        String r2 = "byte";
    L16:
        r0.put("verify_channel", r2);
        r0.put("cert_type", String.valueOf(r21.certType));
        r0.put("children_cert_token", r21.childrenCertToken);
        r0.put("youth_cert_scene", String.valueOf(r21.youthCertScene));
        Map<String, String> r3 = r21.apiRequestParams;
        if (r3 == null) goto L20;
        r0.putAll(r3);
    L20:
        if ("recharge".equals(r22) == false) goto L22;
    L25:
        Observable<Response<JsonObject>> r1 = ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).queryCertificationCommonResultForString(r0);
        boolean r16 = false;
    L26:
        final com.bytedance.android.tools.superkv.e r17 = v1.a("webcast_jsb_local_data");
        if (r19.isFinishing() == false) goto L30;
        e1 r4 = null;
    L29:
        final e1 r18 = r4;
        final boolean r11 = r16;
        final boolean r7 = r16;
        r1.compose(RxUtil.rxSchedulerHelper()).subscribe(new a90.d(r26, r26, r17, r18, r22, r27, r23, r25, r21, r11, r28, r19, r24), new a90.e(r17, r22, r23, r25, r21, r24, r7, r28, r19, r18, r27, r26));
        return;
    L30:
        r4 = new e1(r19);
        r4.setCancelable(false);
        r4.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r4);
        goto L29
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L34:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        goto L29
    L22:
        if ("first_withdraw".equals(r22) == true) goto L25;
        r0.put("skip_record_verify", String.valueOf(r28));
        r0.put("transaction_id", r21.transactionId);
        r1 = ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).queryCertificationResultForString(r0);
        r16 = true;
        goto L26
    L12:
        if (r25 == 3) goto L14;
        r2 = "alipay";
        goto L16
    L14:
        r2 = "alicloud";
        goto L16
    L41:
        return;
    }

    public static void o(Activity r14, w80.a r15, String r16, Bundle r17, int r18, String r19, boolean r21, g r22, f r23, boolean r24, boolean r25) {
        IHostReady r0 = f();
        if (r0 == null) goto L5;
        r0.tryPreload(r14, false, new b(r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r25));
        return;
    L5:
        q(r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r25);
    }

    public static void q(final Activity r15, w80.a r16, final String r17, final Bundle r18, int r19, String r21, boolean r22, final g r23, f r24, final boolean r25, boolean r26) {
        w80.a r0 = r16;
        if (r15 != null) goto L5;
    L58:
        r23.onVerify(false, new HashMap());
        return;
    L5:
        if (r15.isFinishing() == true) goto L58;
        Map<String, String> r4 = null;
        int r5 = r19;
        if (r5 != 2) goto L25;
        IHostOCRApiProxy r3 = k.f(IHostOCRApiProxy.class);
        if (r3 != null) goto L12;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        r0 = null;
        boolean r7 = true;
        r5 = 0;
    L27:
        if (r5 != 3) goto L39;
        if (r26 == false) goto L39;
        if (j() == true) goto L36;
        if (r0 == null) goto L36;
        if (TextUtils.isEmpty(r0.certToken) == true) goto L36;
        boolean r8 = false;
    L37:
        if (r8 == false) goto L39;
        IHostAliYunVerifyProxy r1 = k.f(IHostAliYunVerifyProxy.class);
        w80.a r2 = null;
        final boolean r9 = true;
        final int r11 = 0;
    L40:
        if (r11 != 0) goto L54;
        if (r22 == false) goto L54;
        if (i(r15) == false) goto L54;
        AlertDialog r12 = new AlertDialog.Builder(r15).setTitle(2131923055).setMessage(2131923565).setPositiveButton("确定", null).create();
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L61;
        DialogLancet.handleBlockedDialogShow(r12);
    L49:
        if (r23 == null) goto L52;
        HashMap r13 = new HashMap();
        r13.put("status", -1);
        r13.put("msg", "未安装支付宝");
        r23.onVerify(false, r13);
    L52:
        RealNameFullMonitor.b(r17, false, r9, -1, "AliPayAppUnInstalled", 0, r2);
        return;
    L61:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L48:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
    L54:
        if (r2 != null) goto L56;
        final e1 r14 = new e1(r15);
        r14.setCancelable(false);
        r14.setCanceledOnTouchOutside(false);
        r24.a(c(r15, r11)).compose(RxUtil.rxSchedulerHelper()).subscribe(new a90.b(r14, r15, r17, r18, r9, r11, r23, r25), new a90.c(r14, r15, r17, r23));
        return;
    L56:
        n(r15, r2, r17, r18, r9, r11, r23, r25);
        return;
    L36:
        r8 = true;
    L39:
        r2 = r0;
        r11 = r5;
        r9 = r7;
        goto L40
    L20:
        boolean r27 = "recharge".equals(r17);
        if (r0 == null) goto L23;
        r4 = r0.apiRequestParams;
    L23:
        n r28 = (n) tj.a.getValue();
        v80.d.a r29 = new v80.d.a();
        r29.b = "live_cert_normal";
        r29.d = GamePromoteDataContext.GAME_TYPE_MOBILE;
        r29.c = "";
        r29.a = r15;
        r29.g = r27;
        r29.h = r17;
        r29.i = true;
        r29.k = r23;
        r28.getClass();
        r29.n = r4;
        x80.c.a(1).a.a(new v80.d(r29));
        return;
    L12:
        if (r3.isSDKReady() == false) goto L17;
        if (TextUtils.isEmpty(r21) == true) goto L17;
        r6 = false;
        goto L18
    L25:
        r7 = false;
        goto L27
    }
}
