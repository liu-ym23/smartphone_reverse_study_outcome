package com.ss.android.lark.chameleonv2.debug;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/debug/ChameleonDebugActivity;", "Landroid/preference/PreferenceActivity;", "<init>", "()V", "manager", "Lcom/ss/android/lark/chameleonv2/debug/CmlDebugManager;", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "setStatusBarHeight", "setupOpenUrl", "setupIpProxy", "updateIpProxySummary", "preference", "Landroid/preference/Preference;", "setDisableProxy", "setSpecificRes", "updateOfflineResSummary", "isTos", BuildConfig.FLAVOR, "setSpecificResByTos", "setDisableOfflineRes", "setDisableDebugInfoView", "setHeaderDownloadAuth", "Companion", "chameleon-debug_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonDebugActivity extends PreferenceActivity {
    public static final /* synthetic */ int b = 0;
    public final f a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ChameleonDebugActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public ChameleonDebugActivity() {
        this.a = new f();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        a(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void b(Preference r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = CmlDebugSettingUtil.a("chameleon_ip_proxy_bizname", BuildConfig.FLAVOR);
        String r1 = CmlDebugSettingUtil.a("chameleon_ip_proxy_url", BuildConfig.FLAVOR);
        boolean r3 = false;
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
    L14:
        r5.setSummary("设置bizName和调试地址");
        return;
    L10:
        if (r1.length() <= 0) goto L12;
        r3 = true;
    L12:
        if (r3 == false) goto L14;
        r5.setSummary("设置" + r0 + "\n代理地址为:" + r1);
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r10);
        if (com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a() == true) goto L13;
        finish();
        return;
    L13:
        addPreferencesFromResource(2132082693);
        int r11 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        boolean r0 = false;
        if (r11 <= 0) goto L16;
        int r12 = getResources().getDimensionPixelSize(r11);
    L17:
        ((ViewGroup) a(getWindow()).findViewById(R.id.content)).setPadding(0, r12, 0, 0);
        Preference r13 = findPreference("open_url");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.preference.EditTextPreference");
        EditTextPreference r14 = (EditTextPreference) r13;
        r14.setEnabled(true);
        r14.setOnPreferenceChangeListener(new e(this));
        final Preference r15 = findPreference("cml_debug_ip_proxy");
        b(r15);
        if (r15 == null) goto L20;
        r15.setOnPreferenceClickListener(new ChameleonDebugActivity$setupIpProxy$1(this, r15));
    L20:
        Preference r16 = findPreference("cml_debug_disable_ip_proxy");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.preference.SwitchPreference");
        SwitchPreference r17 = (SwitchPreference) r16;
        r17.setEnabled(true);
        com.ss.android.lark.storage.a r3 = CmlDebugSettingUtil.a;
        Intrinsics.checkNotNullParameter("chameleon_disable_ip_proxy", "key");
        Lazy r5 = CmlDebugSettingUtil.b;
        r17.setChecked(((KVRepo) r5.getValue()).getBoolean("chameleon_disable_ip_proxy", false));
        r17.setOnPreferenceChangeListener(new c(this));
        final Preference r4 = findPreference("cml_debug_offline_res_info");
        final Preference r7 = findPreference("cml_debug_offline_res_info_tos");
        c(r4, false);
        if (r4 == null) goto L23;
        r4.setOnPreferenceClickListener(new ChameleonDebugActivity$setSpecificRes$1(this, r4, r7));
    L23:
        final Preference r6 = findPreference("cml_debug_offline_res_info_tos");
        final Preference r18 = findPreference("cml_debug_offline_res_info");
        c(r6, true);
        if (r6 == null) goto L26;
        r6.setOnPreferenceClickListener(new ChameleonDebugActivity$setSpecificResByTos$1(this, r6, r18));
    L26:
        Preference r19 = findPreference("cml_debug_disable_offline_res");
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.preference.SwitchPreference");
        SwitchPreference r110 = (SwitchPreference) r19;
        r110.setEnabled(true);
        Intrinsics.checkNotNullParameter("chameleon_disable_offline_res", "key");
        r110.setChecked(((KVRepo) r5.getValue()).getBoolean("chameleon_disable_offline_res", false));
        r110.setOnPreferenceChangeListener(new b(this));
        Preference r111 = findPreference("cml_debug_disable_debug_info_view");
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.preference.SwitchPreference");
        SwitchPreference r112 = (SwitchPreference) r111;
        r112.setEnabled(true);
        int r2 = com.ss.android.lark.officesdk.utils.di.e.a;
        DependencyContainer r8 = DependencyContainer.a;
        ntb.f r9 = DependencyContainer.a(ntb.f.class, null);
        if (r9 == null) goto L29;
        r9.e0();
        r0 = true;
    L29:
        Intrinsics.checkNotNullParameter("chameleon_disable_debug_view", "key");
        r112.setChecked(((KVRepo) r5.getValue()).getBoolean("chameleon_disable_debug_view", !r0));
        r112.setOnPreferenceChangeListener(new com.ss.android.lark.chameleonv2.debug.a(this));
        Preference r113 = findPreference("cml_debug_header_auth");
        if (r113 == null) goto L36;
        r113.setOnPreferenceClickListener(new d(this));
        return;
    L36:
        return;
    L16:
        r12 = 0;
        goto L17
    }

    public final void c(Preference r9, boolean r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        String r0 = CmlDebugSettingUtil.a("chameleon_specific_bizname", BuildConfig.FLAVOR);
        if (r10 == false) goto L7;
        String r11 = "chameleon_specific_download_url_tos";
    L8:
        String r12 = CmlDebugSettingUtil.a(r11, BuildConfig.FLAVOR);
        String r2 = CmlDebugSettingUtil.a("chameleon_app_name", BuildConfig.FLAVOR);
        String r3 = StringsKt.trimEnd(StringsKt.removeSuffix(r9.getTitle().toString(), "（未启用）")).toString();
        boolean r6 = false;
        if (r0.length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
    L23:
        r9.setTitle(r3 + "（未启用）");
        r9.setSummary(BuildConfig.FLAVOR);
        return;
    L14:
        if (r12.length() <= 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L23;
        if (r2.length() <= 0) goto L21;
        r6 = true;
    L21:
        if (r6 == false) goto L23;
        r9.setTitle(r3);
        StringBuilder r1 = new StringBuilder("设置");
        r1.append(r0);
        r1.append("\n资源版本为:");
        this.a.getClass();
        r1.append(f.b(r12));
        r9.setSummary(r1.toString());
        return;
    L16:
        r7 = false;
        goto L17
    L11:
        r5 = false;
        goto L12
    L7:
        r11 = "chameleon_specific_download_url_scm";
        goto L8
    }
}
