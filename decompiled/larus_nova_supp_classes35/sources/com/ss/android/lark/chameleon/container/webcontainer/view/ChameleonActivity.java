package com.ss.android.lark.chameleon.container.webcontainer.view;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.util.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    private static final String EXTRA_URL = "url";
    public static final String TAG = "CML_TAG_ChameleonActivity";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonActivity$Companion;", BuildConfig.FLAVOR, "()V", "EXTRA_URL", BuildConfig.FLAVOR, "TAG", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__finish$___twin___() {
        super.finish();
    }

    public void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ChameleonActivity() {
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ChameleonActivity r1) {
        r1.com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ChameleonActivity r11) {
        r11.com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ChameleonActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(ChameleonActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__onCreate$___twin___(Bundle r5) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r5);
        StatusBarUtil.setTransparent(this);
        FrameLayout r6 = new FrameLayout(this);
        r6.setId(2131361820);
        setContentView(r6);
        String r7 = getIntent().getStringExtra("url");
        String r1 = getIntent().getStringExtra("session_id");
        Fragment r8 = ChameleonFragment.Companion.newInstance(this, r7, r1, new Bundle());
        INVOKEVIRTUAL_com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(getSupportFragmentManager().beginTransaction(), 2131361820, r8).commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ChameleonActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity__onCreate$___twin___(r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_chameleon_container_webcontainer_view_ChameleonActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
