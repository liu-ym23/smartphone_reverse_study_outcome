package com.larus.dora.obric.onboarding;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.dora.impl.onboarding.DoraOnboardingActivity;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u001a\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\u000b*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\f\u0010\u0017\u001a\u00020\t*\u00020\u0010H\u0002J\f\u0010\u0018\u001a\u00020\u0013*\u00020\rH\u0002¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraOnboardingActivity;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingActivity;", "<init>", "()V", "createDelegate", "Lcom/larus/dora/impl/onboarding/IDoraOnboardingDelegate;", "device", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "shouldOpenObricOnboardingActivity", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "showDirectDiaryStateIfNeeded", "source", "", "applyDirectDiaryArguments", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingWelcomeStateFragment;", "currentObricFragment", "isDirectDailyEntry", "debugSummary", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObricDoraOnboardingActivity extends DoraOnboardingActivity {
    public static final /* synthetic */ int j = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingActivity
    public final boolean S1(DoraOnboardingDevice r1) {
        return false;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final ObricDoraGOnboardingWelcomeStateFragment U1() {
        Fragment r0 = getSupportFragmentManager().findFragmentById(2131373275);
        if ((r0 instanceof ObricDoraGOnboardingWelcomeStateFragment) == true) goto L7;
        return null;
    L7:
        return (ObricDoraGOnboardingWelcomeStateFragment) r0;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.dora.impl.onboarding.DoraOnboardingActivity
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

    public ObricDoraOnboardingActivity() {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingActivity
    public com.larus.dora.impl.onboarding.n0 N1(DoraOnboardingDevice r2) {
        return new ObricDoraGOnboardingDelegateV2(this, true);
    }

    public final String W1(Bundle r3) {
        return "size=" + r3.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.dora.impl.onboarding.DoraOnboardingActivity
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        StringBuilder r0 = new StringBuilder("onCreate before super, directDaily=");
        Intent r1 = getIntent();
        String r2 = null;
        if (r1 == null) goto L13;
        Boolean r3 = Boolean.valueOf(r1.getBooleanExtra("obric_start_daily", false));
    L14:
        r0.append(r3);
        r0.append(", extraSummary=");
        Intent r4 = getIntent();
        if (r4 == null) goto L19;
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L19;
        String r7 = W1(r5);
    L20:
        r0.append(r7);
        g49.d.d("ObricDoraOnboardingActivity", r0.toString());
        super.onCreate(r6);
        StringBuilder r8 = new StringBuilder("onCreate after super, fragment=");
        if (U1() == null) goto L23;
        r2 = "ObricDoraGOnboardingWelcomeStateFragment";
    L23:
        r8.append(r2);
        g49.d.d("ObricDoraOnboardingActivity", r8.toString());
        X1(getIntent(), "onCreate");
        return;
    L19:
        r7 = null;
        goto L20
    L13:
        r3 = null;
        goto L14
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingActivity
    public final void onNewIntent(Intent r5) {
        StringBuilder r0 = new StringBuilder("onNewIntent before super, directDaily=");
        String r1 = null;
        if (r5 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r5.getBooleanExtra("obric_start_daily", false));
    L6:
        r0.append(r2);
        r0.append(", extraSummary=");
        if (r5 == null) goto L11;
        Bundle r3 = r5.getExtras();
        if (r3 == null) goto L11;
        String r4 = W1(r3);
    L12:
        r0.append(r4);
        g49.d.d("ObricDoraOnboardingActivity", r0.toString());
        super.onNewIntent(r5);
        StringBuilder r6 = new StringBuilder("onNewIntent after super, fragment=");
        if (U1() == null) goto L15;
        String r7 = "ObricDoraGOnboardingWelcomeStateFragment";
    L16:
        r6.append(r7);
        r6.append(", fragmentArgSummary=");
        ObricDoraGOnboardingWelcomeStateFragment r8 = U1();
        if (r8 == null) goto L21;
        Bundle r9 = r8.getArguments();
        if (r9 == null) goto L21;
        r1 = W1(r9);
    L21:
        r6.append(r1);
        g49.d.d("ObricDoraOnboardingActivity", r6.toString());
        X1(r5, "onNewIntent");
        return;
    L15:
        r7 = null;
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static void T1(ObricDoraGOnboardingWelcomeStateFragment r2, Intent r3) {
        Bundle r1 = r2.getArguments();
        if (r1 != null) goto L5;
        r1 = new Bundle();
    L5:
        Bundle r0 = new Bundle(r1);
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L8;
        r0.putAll(r4);
    L8:
        r0.putBoolean("obric_start_daily", true);
        r2.setArguments(r0);
    }

    public final void X1(final Intent r6, final String r7) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L7:
        g49.d.d("ObricDoraOnboardingActivity", "showDirectDiaryStateIfNeeded, source=" + r7 + ", directDaily=" + r0);
        if (r0 == true) goto L10;
        return;
    L10:
        ObricDoraGOnboardingWelcomeStateFragment r1 = U1();
        StringBuilder r2 = new StringBuilder("showDirectDiaryStateIfNeeded, source=");
        r2.append(r7);
        r2.append(", fragment=");
        String r3 = null;
        if (r1 == null) goto L13;
        String r4 = "ObricDoraGOnboardingWelcomeStateFragment";
    L14:
        r2.append(r4);
        r2.append(", fragmentArgSummary=");
        if (r1 == null) goto L19;
        Bundle r5 = r1.getArguments();
        if (r5 == null) goto L19;
        r3 = W1(r5);
    L19:
        r2.append(r3);
        g49.d.d("ObricDoraOnboardingActivity", r2.toString());
        if (r1 != null) goto L24;
        View r8 = findViewById(2131373275);
        if (r8 == null) goto L26;
        r8.post(new y1(this, r6, r7));
        return;
    L26:
        return;
    L24:
        T1(r1, r6);
        r1.bb0();
        return;
    L13:
        r4 = null;
        goto L14
    L5:
        if (r6.getBooleanExtra("obric_start_daily", false) != true) goto L7;
        r0 = true;
        goto L7
    }
}
