package com.larus.drive.sdk.impl.view.preview;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.drive.sdk.impl.utils.o;
import com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import t19.s;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/drive/sdk/impl/view/preview/DrivePreviewActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "drivePreviewFragment", "Lcom/larus/drive/sdk/impl/view/preview/DrivePreviewFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "needAdaptStatusBarPadding", "", "onBackPressed", "attachLegacyPreview", "attachAiFilePreview", "requestId", "", "openLocalFilePreview", "hasLocalPreviewAccount", "failToOpenLocalPreview", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewActivity extends FlowCommonAppCompatActivity {
    public DrivePreviewFragment g;

    public static final class a {
    }

    static {
    }

    public final boolean K1() {
        return false;
    }

    public final void onBackPressed() {
        DrivePreviewFragment r0 = this.g;
        if (r0 == null) goto L21;
        DriveFloatChatContainer r1 = r0.g;
        if (r1 == null) goto L9;
        DriveFloatChatContainer.c r2 = r1.g;
        if (r2 == null) goto L9;
        g0 r3 = r2.b();
    L10:
        if (r3 == null) goto L14;
        boolean r4 = true;
        if (r3.YC() != true) goto L14;
    L15:
        if (r4 == false) goto L17;
        r3.km("drive_preview_back_pressed");
        return;
    L17:
        FragmentActivity r5 = r0.getActivity();
        if (r5 == null) goto L24;
        r5.finish();
        return;
    L24:
        return;
    L14:
        r4 = false;
    L9:
        r3 = null;
        goto L10
    L21:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DrivePreviewActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DrivePreviewActivity.class.getName()));
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
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public DrivePreviewActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N1(DrivePreviewActivity r2) {
        if (r2.isFinishing() == false) goto L5;
        return;
    L5:
        if (r2.isDestroyed() == true) goto L10;
        s r0 = s.a;
        String r1 = r2.getString(2131899914);
        r0.getClass();
        s.c(r2, r1);
        r2.finish();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean O1(DrivePreviewActivity r1) {
        String r2 = r1.getIntent().getStringExtra("preview_account_id");
        if (r2 != null) goto L5;
    L7:
        r2 = null;
    L9:
        return Intrinsics.areEqual(r2, AccountService.a.getUserId());
    L5:
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        int r0 = o.a;
        if (r13 == null) goto L15;
        Bundle r1 = r13.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r1 == null) goto L15;
        r1.remove("android:support:fragments");
    L15:
        super.onCreate(r13);
        setContentView(2131561787);
        if (getIntent().hasExtra("local_file_path") == false) goto L30;
        String r14 = getIntent().getStringExtra("local_file_path");
        if (r14 != null) goto L20;
        String r3 = "";
    L21:
        String r15 = getIntent().getStringExtra("local_file_name");
        if (r15 != null) goto L24;
        String r4 = "";
    L25:
        String r16 = getIntent().getStringExtra("local_file_provider_authority");
        if (r16 != null) goto L28;
        String r5 = "";
    L29:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DrivePreviewActivity$openLocalFilePreview$1(this, r3, r4, r5, null), 3, null);
        return;
    L28:
        r5 = r16;
        goto L29
    L24:
        r4 = r15;
        goto L25
    L20:
        r3 = r14;
        goto L21
    L30:
        String r17 = getIntent().getStringExtra("ai_file_preview_request_id");
        if (r17 != null) goto L33;
    L35:
        r17 = null;
    L37:
        if (r17 != null) goto L43;
        FLogger.a.i("DrivePreviewActivity", "attach preview, source=legacy");
        DrivePreviewFragment r18 = new DrivePreviewFragment();
        r18.setArguments(getIntent().getExtras());
        this.g = r18;
        FragmentTransaction r2 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "drive_preview_fragment", 2131373275) == true) goto L42;
        r2 = r2.replace(2131373275, r18, "drive_preview_fragment");
    L42:
        r2.commitAllowingStateLoss();
        return;
    L43:
        FLogger.a.i("DrivePreviewActivity", "attach preview, source=ai");
        int r6 = DriveOfficePreviewFragment.l;
        Intrinsics.checkNotNullParameter(r17, "requestId");
        DriveOfficePreviewFragment r7 = new DriveOfficePreviewFragment();
        Bundle r8 = new Bundle();
        r8.putString("ai_file_preview_launch_request_id", r17);
        r7.setArguments(r8);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L50
        FragmentTransaction r10 = getSupportFragmentManager().beginTransaction();     // Catch: Throwable -> L50
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "ai_file_preview_fragment", 2131373275) == true) goto L48;
        r10 = r10.replace(2131373275, r7, "ai_file_preview_fragment");     // Catch: Throwable -> L50
    L48:
        r10.commitNowAllowingStateLoss();     // Catch: Throwable -> L50
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L50
    L52:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L62;
        FLogger.a.e("DrivePreviewActivity", "attach AI file preview host failed, errorType=".concat(r12.getClass().getSimpleName()));
        DrivePreviewRequestStore.a.d(r17);
        finish();
        return;
    L62:
        return;
    L50:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L33:
        if ((!StringsKt.isBlank(r17)) == false) goto L35;
        goto L35
    }
}
