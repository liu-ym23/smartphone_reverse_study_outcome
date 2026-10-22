package com.ss.android.lark.officesdk.minutes.ui.record.recording;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingEntity;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationSlotsProvider;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import uvb.c;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/MmBaseRecordingActivity;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseActivity;", "<init>", "()V", "keepScreenOn", "", "getKeepScreenOn", "()Z", "recordingIdForUiControl", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class MmBaseRecordingActivity extends MmBaseActivity {
    public static final /* synthetic */ int d = 0;
    public final boolean b;
    public String c;

    public static final class a {
        @JvmStatic
        public static void a(Context r5, String r6, MmRecordingEntity r7, UserSession r8) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "activityClassName");
            Intrinsics.checkNotNullParameter(r7, "entity");
            Intrinsics.checkNotNullParameter(r8, "userSession");
            if (LarkContext.getApplication() != null) goto L6;
            int r9 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "start", "start failed: Application not initialized", null);
            return;
        L6:
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "activityClassName");
            Intrinsics.checkNotNullParameter(r7, "entity");
            Intrinsics.checkNotNullParameter(r8, "userSession");
            Intent r10 = new Intent().setClassName(r5, r6);
            if ((r5 instanceof Activity) == true) goto L9;
            r10.addFlags(268435456);
        L9:
            r10.putExtra("MM_RECORDING_ENTITY_EXTRA", r7);
            r10.putExtra("MM_USER_SESSION_EXTRA", r8);
            r5.startActivity(r10);
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity
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

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        final String r0 = this.c;
        if (r0 == null) goto L8;
        Handler r1 = b.a;
        Intrinsics.checkNotNullParameter(r0, "recordingId");
        Intrinsics.checkNotNullParameter(this, "activity");
        b.a(new MmRecordingUiController$unregisterRecordingPage$1(r0, this));
    L8:
        this.c = null;
        super.onDestroy();
    }

    public MmBaseRecordingActivity() {
        this.b = true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity
    public final boolean A1() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity
    public final void onCreate(Bundle r8) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r8);
        setContentView(2131564069);
        View r0 = findViewById(2131367728);
        int r1 = uvb.b.a;
        uvb.a.b(r0, c.a);
        Serializable r2 = getIntent().getSerializableExtra("MM_RECORDING_ENTITY_EXTRA");
        if ((r2 instanceof MmRecordingEntity) == false) goto L13;
        MmRecordingEntity r3 = (MmRecordingEntity) r2;
    L14:
        UserSession r4 = (UserSession) getIntent().getParcelableExtra("MM_USER_SESSION_EXTRA");
        if (r3 != null) goto L18;
        int r9 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "entity is null", null);
        finish();
        return;
    L18:
        if (r3.getUiLaunchMode().shouldHandleUI() == true) goto L20;
        int r10 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "uiLaunchMode is invalid, ui=" + r3.getUiLaunchMode(), null);
        finish();
        return;
    L20:
        e r5 = e.a;
        MmRecordingUILaunchMode r6 = r3.getUiLaunchMode();
        r5.getClass();
        if (e.c(r6) != null) goto L23;
        int r11 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "ui provider is missing, ui=" + r3.getUiLaunchMode(), null);
        finish();
        return;
    L23:
        if (r4 != null) goto L26;
        int r12 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "userSession is null", null);
        finish();
        return;
    L26:
        if (isFinishing() == false) goto L28;
    L43:
        int r13 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "Activity is finishing or destroyed, skip fragment transaction", null);
        return;
    L28:
        if (isDestroyed() == true) goto L43;
        this.c = r3.getRecordingId();
        Handler r7 = b.a;
        final String r14 = r3.getRecordingId();
        Intrinsics.checkNotNullParameter(r14, "recordingId");
        Intrinsics.checkNotNullParameter(this, "activity");
        b.a(new MmRecordingUiController$registerRecordingPage$1(r14, this));
        int r15 = bwb.b.a;
        bwb.b.g(MmUiLogScene.RECORDING, "onCreate", "start fragment transaction uiLaunchMode=" + r3.getUiLaunchMode(), null, 8);
        int r16 = MmRecordingFragment.J;
        MmRecordingFragment r17 = MmRecordingFragment.a.a(r3, r4);
        MmRecordingSource r18 = r3.getSource();
        if (r18 == null) goto L35;
        boolean r19 = true;
        if (r18.isStandaloneAIInterpretationSource() != true) goto L35;
    L36:
        if (r19 == false) goto L38;
        int r20 = MmStandaloneAIInterpretationSlotsProvider.a;
        r17.la0(MmStandaloneAIInterpretationSlotsProvider.b(r3.getUiLaunchMode()));
    L38:
        FragmentTransaction r21 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r21, r17, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131367728) == true) goto L42;
        r21 = r21.replace(2131367728, r17);
    L42:
        r21.commitAllowingStateLoss();
        return;
    L35:
        r19 = false;
        goto L36
    L13:
        r3 = null;
        goto L14
    }
}
