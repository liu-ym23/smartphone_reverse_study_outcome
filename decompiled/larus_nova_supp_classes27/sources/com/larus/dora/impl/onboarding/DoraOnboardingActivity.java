package com.larus.dora.impl.onboarding;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.android.anniex.container.AnnieXHostActivity;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.router.SmartRouter;
import com.larus.avatar.impl.scan.ScanCameraActivity;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.impl.device.w0;
import com.larus.dora.impl.nl.permission.NLPermissionSettingResultActivity;
import com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingDelegateV2;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingDelegate;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingDelegate;
import com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001\u0007\b\u0017\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0004J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0014J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0014J\b\u0010%\u001a\u00020\u0015H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "currentFragment", "Landroidx/fragment/app/Fragment;", "activityListener", "com/larus/dora/impl/onboarding/DoraOnboardingActivity$activityListener$1", "Lcom/larus/dora/impl/onboarding/DoraOnboardingActivity$activityListener$1;", "getBackgroundResource", "", "needAdaptNavigationBarPadding", "", "needAdaptStatusBarPadding", "getOnboardingDeviceOrNull", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "sourceIntent", "Landroid/content/Intent;", "delegate", "Lcom/larus/dora/impl/onboarding/IDoraOnboardingDelegate;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createDelegate", "device", "shouldOpenObricOnboardingActivity", "isObricGOnboardingDevice", "isDoraGOnboardingDevice", "openObricDoraOnboardingActivity", "extras", "onNewIntent", "intent", "onBackPressed", "onStart", "onEnterAnimationComplete", "onStop", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraOnboardingActivity extends FlowCommonAppCompatActivity {
    public Fragment g;
    public final b h;
    public n0 i;

    public static final class a {
    }

    public static final class b implements f09.a.a {
        public b() {
        }

        public final void onPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onPreDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onResumed(Activity r7) {
            Intrinsics.checkNotNullParameter(r7, "activity");
            Intrinsics.checkNotNullParameter(r7, "activity");
            AppHost.Companion r0 = AppHost.a;
            Activity r1 = r0.a().getCurrentActivity();
            if (r1 == null) goto L5;
            String r2 = r1.getClass().getName();
        L6:
            g49.d.d("DoraOnboardingActivity", "onResumed: ".concat(r2));
            if (r1 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r1.getPackageName(), r7.getPackageName()) == true) goto L11;
            return;
        L11:
            if ((r1 instanceof DoraOnboardingActivity) == false) goto L13;
            return;
        L13:
            if ((r1 instanceof DoraWifiScanListActivity) == false) goto L15;
            return;
        L15:
            if ((r1 instanceof NLPermissionSettingResultActivity) == false) goto L17;
            return;
        L17:
            if (StringsKt.contains$default(r2, "VoicePrintEnrollActivity", false, 2, null) == true) goto L38;
            Iterator r8 = r0.a().g().iterator();
        L20:
            if (r8.hasNext() == false) goto L39;
            FlowCommonAppCompatActivity r3 = (Activity) r8.next();
            if ((r3 instanceof DoraOnboardingActivity) == false) goto L20;
            if (((DoraOnboardingActivity) r3).isFinishing() == true) goto L20;
            g49.d.d("DoraOnboardingActivity", "onResumed: finish dora onboarding activity");
            r3.finish();
            goto L20
        L39:
            return;
        L38:
            return;
        L5:
            r2 = "";
            goto L6
        }

        public final void onStart(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onCreate(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }
    }

    static {
    }

    public final void onBackPressed() {
    }

    public final int C1() {
        n0 r0 = this.i;
        if (r0 == null) goto L6;
        return r0.b();
    L6:
        return super.C1();
    }

    public final boolean H1() {
        n0 r0 = this.i;
        if (r0 == null) goto L6;
        return r0.e();
    L6:
        return !(this instanceof AnnieXHostActivity);
    }

    public final boolean K1() {
        n0 r0 = this.i;
        if (r0 == null) goto L6;
        return r0.d();
    L6:
        return !(this instanceof ScanCameraActivity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        d.d = 0;
        AppHost.a.a().f(this.h);
        Intent r0 = new Intent("action.ONBOARDING_ACTIVITY_DESTROY");
        r0.setPackage(getPackageName());
        LocalBroadcastManager.getInstance(this).sendBroadcast(r0);
    }

    public DoraOnboardingActivity() {
        this.h = new b();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    public final void onEnterAnimationComplete() {
        super/*android.app.Activity*/.onEnterAnimationComplete();
        g49.d.d("DoraOnboardingActivity", "enterAnimationComplete: activity=".concat(getClass().getSimpleName()));
    }

    public final void onStart() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStart();
        n0 r0 = this.i;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        n0 r0 = this.i;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public static DoraOnboardingDevice O1(Intent r4) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        DoraOnboardingDevice r5 = (DoraOnboardingDevice) r4.getParcelableExtra("key_dora_onboarding_device");     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L11:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 == null) goto L15;
        g49.d.c("DoraOnboardingActivity", "getOnboardingDeviceOrNull: ERROR, should has DoraOnboardingDevice", r2);
    L15:
        if (Result.isFailure-impl(r6) == true) goto L19;
        r0 = r6;
    L19:
        return (DoraOnboardingDevice) r0;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static boolean P1(DoraOnboardingDevice r5) {
        if (r5 == null) goto L4;
        int r0 = r5.h;
    L5:
        ProductNameType r1 = ProductNameType.getProduct(r0);
        if (r1 == null) goto L8;
        Integer r2 = Integer.valueOf(r1.deviceType);
    L10:
        if (r5 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
    L22:
        return true;
    L17:
        if (Q1(r5) == true) goto L22;
        if (r2 != null) goto L21;
        return false;
    L21:
        if (r2.intValue() == 16) goto L22;
        return false;
    L12:
        if (r5.getType() != 16) goto L14;
        r4 = true;
        goto L15
    L8:
        r2 = null;
        goto L10
    L4:
        r0 = -1;
        goto L5
    }

    public static boolean Q1(DoraOnboardingDevice r6) {
        if (r6 == null) goto L4;
        int r0 = r6.h;
    L5:
        ProductNameType r1 = ProductNameType.getProduct(r0);
        if (r1 == null) goto L8;
        Integer r2 = Integer.valueOf(r1.deviceType);
    L10:
        if (r6 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
    L42:
        return true;
    L17:
        if (r6 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == true) goto L42;
        if (r6 != null) goto L26;
    L28:
        boolean r7 = false;
    L29:
        if (r7 == true) goto L42;
        if (r2 != null) goto L33;
    L34:
        if (r2 != null) goto L37;
    L38:
        if (r2 != null) goto L41;
        return false;
    L41:
        if (r2.intValue() == 19) goto L42;
        return false;
    L37:
        if (r2.intValue() == 18) goto L42;
    L33:
        if (r2.intValue() == 17) goto L42;
    L26:
        if (r6.getType() != 19) goto L28;
        r7 = true;
        goto L29
    L19:
        if (r6.getType() != 18) goto L21;
        r5 = true;
        goto L22
    L12:
        if (r6.getType() != 17) goto L14;
        r4 = true;
        goto L15
    L8:
        r2 = null;
        goto L10
    L4:
        r0 = -1;
        goto L5
    }

    public n0 N1(DoraOnboardingDevice r3) {
        int r0 = w.a;
        Intrinsics.checkNotNullParameter(this, "activity");
        if (r3 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L60;
        if (r3 == null) goto L12;
        Integer r4 = Integer.valueOf(r3.getType());
    L13:
        if (r4 != null) goto L16;
    L17:
        if (r4 != null) goto L20;
    L21:
        if (r4 != null) goto L24;
    L25:
        if (r4 != null) goto L28;
    L30:
        int r2 = ProductNameType.H_FREE_CLIP_2.deviceType;
        if (r4 != null) goto L34;
    L35:
        int r5 = ProductNameType.H_FREE_BUDS_PRO_5.deviceType;
        if (r4 != null) goto L39;
    L40:
        int r6 = ProductNameType.H_FREE_CLIP_2_HE.deviceType;
        if (r4 != null) goto L44;
    L45:
        int r7 = ProductNameType.H_GUITAR.deviceType;
        if (r4 != null) goto L49;
    L50:
        int r8 = ProductNameType.H_DOLPHIN.deviceType;
        if (r4 == null) goto L61;
        if (r4.intValue() != r8) goto L61;
    L62:
        return new DoraExternalOnboardingDelegate(this);
    L61:
        return new DoraLiteOnboardingDelegate(this);
    L49:
        if (r4.intValue() == r7) goto L62;
    L44:
        if (r4.intValue() == r6) goto L62;
    L39:
        if (r4.intValue() == r5) goto L62;
    L34:
        if (r4.intValue() == r2) goto L62;
    L28:
        if (r4.intValue() != 19) goto L30;
    L59:
        return new DoraGOnboardingDelegateV2(this);
    L24:
        if (r4.intValue() == 18) goto L59;
    L20:
        if (r4.intValue() == 17) goto L59;
    L16:
        if (r4.intValue() == 16) goto L59;
    L12:
        r4 = null;
        goto L13
    L60:
        return new DoraExternalOnboardingDelegate(this);
    L5:
        if (r3.i != 4096) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R1(Bundle r3) {
        g49.d.d("DoraOnboardingActivity", "open ObricDoraOnboardingActivity");
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this, "//flow/dora/obric_onboarding");
        if (r3 != null) goto L5;
        r3 = new Bundle();
    L5:
        r0.c.putExtras(r3);
        r0.d();
    }

    public boolean S1(DoraOnboardingDevice r2) {
        if (w0.a() == true) goto L7;
        return false;
    L7:
        return Q1(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        DoraOnboardingDevice r0 = O1(getIntent());
        int r1 = m59.b.a;
        if (m59.b.a(this, "//dora_onboarding_v2", getIntent().getExtras()) == false) goto L13;
        super.onCreate(r6);
        finish();
        return;
    L13:
        Integer r2 = null;
        if (P1(r0) == false) goto L26;
        int r3 = com.larus.dora.impl.util.s.a;
        if (r0 == null) goto L18;
        Integer r4 = Integer.valueOf(r0.h);
    L20:
        if (com.larus.dora.impl.util.s.c(r4) == true) goto L26;
        super.onCreate(r6);
        StringBuilder r7 = new StringBuilder("Dora G product=");
        if (r0 == null) goto L24;
        r2 = Integer.valueOf(r0.h);
    L24:
        r7.append(r2);
        r7.append(" is disabled, block G onboarding activity");
        g49.d.d("DoraOnboardingActivity", r7.toString());
        finish();
        return;
    L18:
        r4 = null;
    L26:
        if (S1(r0) == false) goto L28;
        super.onCreate(r6);
        R1(getIntent().getExtras());
        finish();
        return;
    L28:
        n0 r5 = N1(r0);
        super.onCreate(r6);
        AppHost.a.a().e(this.h);
        Intent r8 = new Intent("action.ONBOARDING_ACTIVITY_CREATE");
        r8.setPackage(getPackageName());
        LocalBroadcastManager.getInstance(this).sendBroadcast(r8);
        setContentView(r5.c());
        r5.f().setDoraOnboardingDevice(r0);
        if (r6 != null) goto L35;
        Fragment r9 = r5.a();
        r9.setArguments(getIntent().getExtras());
        FragmentTransaction r10 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L34;
        r10 = r10.replace(2131373275, r9);
    L34:
        r10.commitAllowingStateLoss();
        this.g = r9;
    L36:
        this.i = r5;
        return;
    L35:
        this.g = (Fragment) CollectionsKt.firstOrNull(getSupportFragmentManager().getFragments());
        goto L36
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent r4) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r4);
        if (r4 == null) goto L5;
        setIntent(r4);
    L5:
        int r0 = m59.b.a;
        Bundle r1 = null;
        Integer r2 = null;
        if (r4 == null) goto L8;
        Bundle r3 = r4.getExtras();
    L10:
        if (m59.b.a(this, "//dora_onboarding_v2", r3) == false) goto L13;
        finish();
        return;
    L13:
        DoraOnboardingDevice r5 = O1(r4);
        if (P1(r5) == false) goto L27;
        int r6 = com.larus.dora.impl.util.s.a;
        if (r5 == null) goto L18;
        Integer r7 = Integer.valueOf(r5.h);
    L20:
        if (com.larus.dora.impl.util.s.c(r7) == true) goto L27;
        StringBuilder r8 = new StringBuilder("Dora G product=");
        if (r5 == null) goto L24;
        r2 = Integer.valueOf(r5.h);
    L24:
        r8.append(r2);
        r8.append(" is disabled, finish G onboarding activity");
        g49.d.d("DoraOnboardingActivity", r8.toString());
        finish();
        return;
    L18:
        r7 = null;
    L27:
        if (S1(r5) == false) goto L32;
        if (r4 == null) goto L30;
        r1 = r4.getExtras();
    L30:
        R1(r1);
        finish();
        return;
    L32:
        n0 r9 = this.i;
        if (r9 == null) goto L37;
        DoraOnboardingBaseViewModel r10 = r9.f();
        if (r10 == null) goto L37;
        r10.setDoraOnboardingDevice(r5);
    L37:
        if (r4 == null) goto L42;
        Fragment r11 = this.g;
        if (r11 == null) goto L43;
        r11.setArguments(r4.getExtras());
        return;
    L43:
        return;
    L42:
        return;
    L8:
        r3 = null;
        goto L10
    }
}
