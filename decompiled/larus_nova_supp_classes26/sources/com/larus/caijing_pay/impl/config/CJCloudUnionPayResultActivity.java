package com.larus.caijing_pay.impl.config;

import android.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.kvstore.CJKVStoreService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInCloudUnionPayService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.unionpay.i;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0014J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0014J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u001c\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\fH\u0014J\u0010\u0010%\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJCloudUnionPayResultActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "countDownTimer", "Landroid/os/CountDownTimer;", "canClickFinish", "", "isFailDialogShow", "tn", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "dealUserClick", "onResume", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "notifyResult", "result", "onPause", "reportAppInvokeEvent", "isSuccess", "errorCode", "errorMsg", "reportUnionpayFrontCallback", "hasCallbackResult", "reportEvent", "eventName", "params", "isInstalled", "onDestroy", "recordResult", "isRepeatTNAndSuccess", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJCloudUnionPayResultActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int k = 0;
    public b g;
    public boolean h;
    public boolean i;
    public String j;

    public static final class a {
    }

    public static final class b extends CountDownTimer {
        public final /* synthetic */ CJCloudUnionPayResultActivity a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            CJCloudUnionPayResultActivity r0 = this.a;
            int r1 = CJCloudUnionPayResultActivity.k;
            r0.N1("fail_timeout_countdown");
            this.a.i = true;
        }

        public b(CJCloudUnionPayResultActivity r5) {
            this.a = r5;
            super(10000, 2000);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r4) {
            if (r4 >= 5000) goto L6;
            this.a.h = true;
            return;
        }
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CJCloudUnionPayResultActivity.class.getName()));
    L5:
        super.onDestroy();
        b r0 = this.g;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        this.j = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        b r1 = this.g;
        if (r1 == null) goto L6;
        r1.cancel();
    L6:
        if (this.i == true) goto L31;
        JSONObject r2 = new JSONObject();
        int r4 = 1;
        r2.put("result", 1);     // Catch: Throwable -> L20
        ve4.a.a.getClass();     // Catch: Throwable -> L20
        PlugInCloudUnionPayService r5 = ve4.a.a(PlugInCloudUnionPayService.class);     // Catch: Throwable -> L20
        if (r5 == null) goto L11;
        boolean r6 = r5.isInstalled(this);     // Catch: Throwable -> L20
    L12:
        if (r6 == true) goto L15;
        r4 = 0;
    L15:
        r2.put("is_install", r4);     // Catch: Throwable -> L20
        r2.put("error_code", "success");     // Catch: Throwable -> L20
        r2.put("error_message", "");     // Catch: Throwable -> L20
        String r3 = this.j;     // Catch: Throwable -> L20
        if (r3 != null) goto L18;
        r3 = "";
    L18:
        r2.put("orderinfo", r3);     // Catch: Throwable -> L20
        r2.put("pop_type", "");     // Catch: Throwable -> L20
    L22:
        String r0 = r2.toString();
        ve4.a.a.getClass();
        PlugInCloudUnionPayService r7 = ve4.a.a(PlugInCloudUnionPayService.class);
        if (r7 == null) goto L25;
        Object r8 = r7.currentSession();
    L26:
        if (r7 == null) goto L32;
        r7.reportEvent(r8, "wallet_cashier_unionpay_app_invoke", r0);
        return;
    L32:
        return;
    L25:
        r8 = null;
        goto L26
    L11:
        r6 = false;
    L20:
        th = move-exception;
        FLogger.a.e("reportAppInvokeEvent", "reportAppInvokeEvent error: " + th);
        goto L22
    }

    public CJCloudUnionPayResultActivity() {
        this.j = "";
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(CJCloudUnionPayResultActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final void onResume() {
        super.onResume();
    }

    public final void N1(String r3) {
        ve4.a.a.getClass();
        PlugInCloudUnionPayService r0 = ve4.a.a(PlugInCloudUnionPayService.class);
        if (r0 == null) goto L5;
        Object r1 = r0.currentSession();
    L6:
        if (r0 == null) goto L8;
        r0.notifyResult(r1, r3);
    L8:
        finish();
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r13);
        findViewById(R.id.content).setOnTouchListener(new bx8.a(this));
        b r14 = new b(this);
        this.g = r14;
        r14.start();
        Bundle r15 = getIntent().getExtras();
        String r0 = "";
        if (r15 == null) goto L14;
        String r16 = r15.getString("payData");
        if (r16 == null) goto L14;
    L15:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = "00";
        boolean r5 = false;
        if (r16.length() <= 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L22;
        JSONObject r4 = new JSONObject(r16);
        r1.element = r4.optString("__cloud_union_pay_env", "00");
        this.j = r4.optString("tn");
    L22:
        if (this.j.length() <= 0) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L135;
        ve4.a.a.getClass();
        CJHostService r18 = ve4.a.a(CJHostService.class);
        if (((CharSequence) r1.element).length() != 0) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L32;
        r1.element = "00";
    L32:
        SharedPreferences r110 = ve4.a.d(CJKVStoreService.class).getSharedPreference("cj_cloud_union_pay_sp_name", 0);
        String r2 = r110.getString("cj_cloud_union_pay_tn_key", "");
        if (r2 != null) goto L36;
        r2 = "";
    L36:
        if (this.j.length() != 0) goto L38;
        boolean r6 = true;
    L40:
        if (r6 == false) goto L43;
    L51:
        boolean r111 = false;
    L52:
        if (r111 == false) goto L54;
        N1("success");
        return;
    L54:
        String r112 = this.j;
        String r7 = (String) r1.element;
        String r8 = com.unionpay.a.a;
        com.unionpay.a.j = new WeakReference(this);
        com.unionpay.a.k = r112;
        String r113 = null;
        com.unionpay.a.l = null;
        com.unionpay.a.m = null;
        com.unionpay.a.n = r7;
        com.unionpay.a.g = "";
        com.unionpay.a.f = "";
        if (TextUtils.isEmpty("") == false) goto L57;
        com.unionpay.a.h = TriggerSendLoading.NO_LOADING;
    L58:
        com.unionpay.a.a = null;
        com.unionpay.a.b = null;
        com.unionpay.a.c = null;
        com.unionpay.a.e = "";
        WeakReference r9 = com.unionpay.a.j;
        if (r9 != null) goto L61;
        return;
    L61:
        if (r9.get() != null) goto L64;
        return;
    L64:
        if (TextUtils.isEmpty(com.unionpay.a.f) == true) goto L66;
    L69:
        com.unionpay.a.i = true;
        if ("02".equalsIgnoreCase(com.unionpay.a.g) == false) goto L72;
        com.unionpay.a.f = "samsung_out";
    L72:
        com.unionpay.a.o = 0;
        com.unionpay.a.p = false;
        com.unionpay.a.q = false;
        com.unionpay.a.a();     // Catch: Throwable -> L75
    L77:
        String r10 = UPUtils.a(com.unionpay.a.k(), "configs" + com.unionpay.a.g);
        String r11 = UPUtils.a(com.unionpay.a.k(), "mode" + com.unionpay.a.g);
        String r12 = UPUtils.a(com.unionpay.a.k(), "or" + com.unionpay.a.g);
        if (TextUtils.isEmpty(r10) == false) goto L80;
    L142:
        if (TextUtils.isEmpty(com.unionpay.a.g) == false) goto L120;
        JSONArray r114 = new JSONArray(com.unionpay.a.t);     // Catch: Exception -> L125
    L123:
        com.unionpay.a.w = com.unionpay.a.e(r114);     // Catch: Exception -> L125
        goto L126
    L120:
        if ("04".equals(com.unionpay.a.g) == false) goto L122;
        r114 = new JSONArray(com.unionpay.a.v);     // Catch: Exception -> L125
        goto L123
    L122:
        r114 = new JSONArray(com.unionpay.a.u);     // Catch: Exception -> L125
    L126:
        com.unionpay.a.s = new Handler(com.unionpay.a.x);
        if (TextUtils.isEmpty(com.unionpay.a.g) == true) goto L134;
        HashMap r115 = com.unionpay.utils.b.a;
        r5 = "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);     // Catch: Exception -> L131
    L132:
        if (r5 == false) goto L134;
        HwOpenPayTask r116 = new HwOpenPayTask(com.unionpay.a.k());
        com.unionpay.a.s.sendEmptyMessageDelayed(1004, 1000);
        r116.supportCapacity("UNIONONLINEPAY", new i());
        return;
    L134:
        com.unionpay.a.h(TriggerSendLoading.NO_LOADING);
        return;
    L80:
        if (TextUtils.isEmpty(r11) == true) goto L142;
        if (TextUtils.isEmpty(r12) == true) goto L142;
        JSONObject r20 = new JSONObject(r10);     // Catch: Exception -> L137
        String r21 = g.b(r20, "sign");     // Catch: Exception -> L137
        int r22 = CastIntegerProtector.parseInt(r11);     // Catch: Exception -> L86
    L87:
        String r117 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r20, "configs"), 2));     // Catch: Exception -> L137
        if (r20.has("sePayConf") == false) goto L90;
        String r23 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r20, "sePayConf"), 2));     // Catch: Exception -> L137
    L92:
        if (TextUtils.isEmpty(r23) == true) goto L95;
        r0 = r23;
    L95:
        String r24 = com.unionpay.utils.b.d(UPUtils.b(r117 + r0 + r12));     // Catch: Exception -> L137
        r113 = UPUtils.c(UPUtils.forConfig(r22, r21));     // Catch: Throwable -> L98
    L101:
        if (TextUtils.isEmpty(r113) == true) goto L142;
        if (r113.equals(r24) == false) goto L142;
        if (TextUtils.isEmpty(com.unionpay.a.g) == false) goto L108;
        com.unionpay.a.t = r117;     // Catch: Exception -> L137
    L112:
        if (TextUtils.isEmpty(com.unionpay.a.e) == true) goto L142;
        String r118 = UPUtils.a(com.unionpay.a.k(), "se_configs" + com.unionpay.a.e);     // Catch: Exception -> L137
        if (TextUtils.isEmpty(r118) == true) goto L142;
        com.unionpay.a.i(r118);     // Catch: Exception -> L137
        goto L142
    L108:
        if ("04".equals(com.unionpay.a.g) == false) goto L110;
        com.unionpay.a.v = r117;     // Catch: Exception -> L137
        goto L112
    L110:
        com.unionpay.a.u = r117;     // Catch: Exception -> L137
    L98:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L137
        goto L101
    L90:
        r23 = "";
    L86:
        r22 = 0;
    L75:
        th = move-exception;
        th.printStackTrace();
        goto L77
    L66:
        if (TextUtils.isEmpty(com.unionpay.a.g) == false) goto L69;
        com.unionpay.a.i = false;
        goto L72
    L57:
        com.unionpay.a.h = "1";
        goto L58
    L43:
        if (this.j.equals(r2) == false) goto L51;
        String r119 = r110.getString("cj_cloud_union_pay_result_key", "");
        if (r119 != null) goto L49;
        r119 = "";
    L49:
        if (r119.equals("success") == false) goto L51;
        r111 = true;
        goto L52
    L38:
        r6 = false;
        goto L40
    L29:
        r19 = false;
        goto L30
    L135:
        N1("fail_tn_empty");
        return;
    L24:
        r17 = false;
        goto L25
    L18:
        r3 = false;
    L14:
        r16 = "";
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityResult(int r5, int r6, Intent r7) {
        super.onActivityResult(r5, r6, r7);
        if (r7 != null) goto L6;
        finish();
        return;
    L6:
        Bundle r8 = r7.getExtras();
        String r9 = "";
        if (r8 == null) goto L10;
        String r10 = r8.getString("pay_result");
        if (r10 == null) goto L10;
    L11:
        ve4.a r11 = ve4.a.a;
        r11.getClass();
        boolean r2 = false;
        SharedPreferences.Editor r0 = ve4.a.d(CJKVStoreService.class).getSharedPreference("cj_cloud_union_pay_sp_name", 0).edit();
        if (r0 == null) goto L18;
        String r1 = this.j;
        if (r1 == null) goto L17;
        r9 = r1;
    L17:
        r0.putString("cj_cloud_union_pay_tn_key", r9);
    L18:
        if (r0 == null) goto L20;
        r0.putString("cj_cloud_union_pay_result_key", r10);
    L20:
        if (r0 == null) goto L22;
        r0.apply();
    L22:
        JSONObject r12 = new JSONObject();
        r12.put("result", 1);     // Catch: Throwable -> L38
        r11.getClass();     // Catch: Throwable -> L38
        PlugInCloudUnionPayService r13 = ve4.a.a(PlugInCloudUnionPayService.class);     // Catch: Throwable -> L38
        if (r13 == null) goto L26;
        boolean r14 = r13.isInstalled(this);     // Catch: Throwable -> L38
    L27:
        if (r14 == false) goto L29;
        int r15 = 1;
    L30:
        r12.put("is_install", r15);     // Catch: Throwable -> L38
        if (r10.length() != 0) goto L33;
        r2 = true;
    L33:
        if (r2 == false) goto L35;
        String r3 = "no_data";
    L36:
        r12.put("error_code", r3);     // Catch: Throwable -> L38
    L40:
        String r16 = r12.toString();
        ve4.a.a.getClass();
        PlugInCloudUnionPayService r17 = ve4.a.a(PlugInCloudUnionPayService.class);
        if (r17 == null) goto L43;
        Object r4 = r17.currentSession();
    L44:
        if (r17 == null) goto L46;
        r17.reportEvent(r4, "wallet_cashier_unionpay_front_callback", r16);
    L46:
        N1(r10);
        return;
    L43:
        r4 = null;
        goto L44
    L35:
        r3 = r10;
        goto L36
    L29:
        r15 = 0;
        goto L30
    L26:
        r14 = false;
    L38:
        th = move-exception;
        FLogger.a.e("reportUnionpayFrontCallback", "reportUnionpayFrontCallback error: " + th);
    L10:
        r10 = "";
        goto L11
    }
}
