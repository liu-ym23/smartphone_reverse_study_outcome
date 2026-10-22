package com.tencent.tauth;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AuthActivity extends Activity {
    public static final String ACTION_SHARE_PRIZE = "sharePrize";
    private static int a;
    private Map<String, ActionHandler> b;

    public interface ActionHandler {
        void handleAction(Activity r1, Bundle r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_tencent_tauth_AuthActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        com_tencent_tauth_AuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r1) {
        com_tencent_tauth_AuthActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_tencent_tauth_AuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private void a() {
        this.b.put("action_common_channel", new AnonymousClass1(this));
    }

    public AuthActivity() {
        this.b = new HashMap();
    }

    public void com_tencent_tauth_AuthActivity__finish$___twin___() {
        super.finish();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SLog.e("openSDK_LOG.AuthActivity", "activity finish exception: ", e);
    }

    public static View INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private void a(Uri r10) {
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (r10 != null) goto L5;
    L77:
        SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
        return;
    L5:
        if (r10.toString() == null) goto L77;
        String r1 = r10.toString();
        String r3 = BuildConfig.FLAVOR;
        if (r1.equals(BuildConfig.FLAVOR) == true) goto L77;
        String r11 = r10.toString();
        Bundle r12 = m.a(r11.substring(r11.indexOf("#") + 1));
        if (r12 != null) goto L13;
        SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
        finish();
        return;
    L13:
        String r2 = r12.getString(Keys.API_PARAM_KEY_ACTION);
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + r2);
        if (r2 != null) goto L17;
        finish();
        return;
    L17:
        if (r2.equals("shareToQQ") == true) goto L66;
        if (r2.equals("shareToQzone") == true) goto L66;
        if (r2.equals("sendToMyComputer") == true) goto L66;
        if (r2.equals("shareToTroopBar") == true) goto L66;
        if (r2.equals("addToQQFavorites") == false) goto L32;
        Intent r0 = getIntent();
        r0.putExtras(r12);
        r0.putExtra("key_action", "action_share");
        IUiListener r13 = UIListenerManager.getInstance().getListnerWithAction(r2);
        if (r13 == null) goto L30;
        UIListenerManager.getInstance().handleDataToListener(r0, r13);
    L30:
        finish();
        return;
    L32:
        if (r2.equals(ACTION_SHARE_PRIZE) == false) goto L43;
        Intent r4 = getPackageManager().getLaunchIntentForPackage(getPackageName());
        r3 = JSONObjectProtectorUtils.getString(m.d(r12.getString("response")), "activityid");     // Catch: Exception -> L36
    L39:
        if (TextUtils.isEmpty(r3) == true) goto L41;
        r4.putExtra(ACTION_SHARE_PRIZE, true);
        Bundle r14 = new Bundle();
        r14.putString("activityid", r3);
        r4.putExtras(r14);
    L41:
        startActivity(r4);
        finish();
        return;
    L36:
        e = move-exception;
        SLog.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e);
        goto L39
    L43:
        if (r2.equals("sdkSetAvatar") == false) goto L46;
        boolean r5 = getIntent().getBooleanExtra("stay_back_stack", false);
        Intent r6 = new Intent(this, AssistActivity.class);
        r6.putExtra("key_request_code", 10108);
        r6.putExtra("stay_back_stack", r5);
        r6.putExtras(r12);
        r6.setFlags(603979776);
        startActivity(r6);
        finish();
        return;
    L46:
        if ("sdkSetDynamicAvatar".equals(r2) == false) goto L49;
        boolean r7 = getIntent().getBooleanExtra("stay_back_stack", false);
        Intent r8 = new Intent(this, AssistActivity.class);
        r8.putExtra("key_request_code", 10110);
        r8.putExtra("stay_back_stack", r7);
        r8.putExtras(r12);
        r8.setFlags(603979776);
        startActivity(r8);
        finish();
        return;
    L49:
        if (r2.equals("sdkSetEmotion") == false) goto L52;
        boolean r9 = getIntent().getBooleanExtra("stay_back_stack", false);
        Intent r15 = new Intent(this, AssistActivity.class);
        r15.putExtra("key_request_code", 10109);
        r15.putExtra("stay_back_stack", r9);
        r15.putExtras(r12);
        r15.setFlags(603979776);
        startActivity(r15);
        finish();
        return;
    L52:
        if (r2.equals("bindGroup") == false) goto L55;
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
        boolean r16 = getIntent().getBooleanExtra("stay_back_stack", false);
        Intent r17 = new Intent(this, AssistActivity.class);
        r17.putExtra("key_request_code", 10112);
        r17.putExtra("stay_back_stack", r16);
        r17.putExtras(r12);
        r17.setFlags(603979776);
        startActivity(r17);
        finish();
        return;
    L55:
        if (r2.equals("joinGroup") == false) goto L58;
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
        boolean r18 = getIntent().getBooleanExtra("stay_back_stack", false);
        Intent r19 = new Intent(this, AssistActivity.class);
        r19.putExtra("key_request_code", 10111);
        r19.putExtra("stay_back_stack", r18);
        r19.putExtras(r12);
        r19.setFlags(603979776);
        startActivity(r19);
        finish();
        return;
    L58:
        if ("guildOpen".equals(r2) == false) goto L60;
        Intent r20 = new Intent(this, AssistActivity.class);
        r20.putExtras(r12);
        r20.putExtra("key_request_code", 10113);
        r20.setFlags(603979776);
        startActivity(r20);
        finish();
        return;
    L60:
        ActionHandler r21 = this.b.get(r2);
        if (r21 == null) goto L64;
        r21.handleAction(this, r12);
        return;
    L64:
        finish();
        return;
    L66:
        if (r2.equals("shareToQzone") == true) goto L68;
    L75:
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
        Intent r22 = new Intent(this, AssistActivity.class);
        r22.putExtras(r12);
        r22.setFlags(603979776);
        startActivity(r22);
        finish();
        return;
    L68:
        if (k.a(this, "com.tencent.mobileqq") == null) goto L75;
        if (k.c(this, "5.2.0") >= 0) goto L75;
        int r23 = a + 1;
        a = r23;
        if (r23 != 2) goto L75;
        a = 0;
        finish();
    }

    public static void com_tencent_tauth_AuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AuthActivity r1) {
        r1.com_tencent_tauth_AuthActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_tencent_tauth_AuthActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_tencent_tauth_AuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(AuthActivity r11) {
        r11.com_tencent_tauth_AuthActivity__finish$___twin___();
        if ((r11 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L53
        if (r6 != null) goto L13;
    L16:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L53
        monitor-exit(r5);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r11).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r11).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r11.isFinishing() == true) goto L27;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L31;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L35;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L39;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L50
        if (r1 != null) goto L44;
        return;
    L44:
        r1.addFlags(268435456);     // Catch: Throwable -> L50
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L50
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L50
        r11.startActivity(r1);     // Catch: Throwable -> L47
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    public void com_tencent_tauth_AuthActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        if (getIntent() != null) goto L16;
        SLog.w("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
        finish();
        return;
    L16:
        Uri r6 = getIntent().getData();     // Catch: Exception -> L8
    L10:
        SLog.v("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + r6);
        a();
        a(r6);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        SLog.e("openSDK_LOG.AuthActivity", "onCreate exception: ", e);
        finish();
        return;
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.AuthActivity", "onCreate exception: ", e);
        r6 = null;
        goto L10
    }

    public static void com_tencent_tauth_AuthActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(AuthActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_tencent_tauth_AuthActivity__onCreate$___twin___(r2);
    }
}
