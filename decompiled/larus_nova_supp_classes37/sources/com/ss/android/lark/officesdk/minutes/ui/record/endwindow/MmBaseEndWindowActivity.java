package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
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
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmAppletPage;
import com.ss.android.lark.officesdk.minutes.ui.databinding.OfficeSdkMmActivityEndWindowBinding;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmBaseEndWindowActivity;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseActivity;", "<init>", "()V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/databinding/OfficeSdkMmActivityEndWindowBinding;", "dataKey", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class MmBaseEndWindowActivity extends MmBaseActivity {
    public static final /* synthetic */ int d = 0;
    public OfficeSdkMmActivityEndWindowBinding b;
    public String c;

    public static final class a {
        public static void a(Context r6, String r7, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r8) {
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r7, "activityClassName");
            Intrinsics.checkNotNullParameter(r8, "entity");
            if (LarkContext.getApplication() != null) goto L6;
            int r9 = bwb.b.a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "start", "start failed: Application not initialized", null);
            return;
        L6:
            String r0 = r8.a;
            if (StringsKt.isBlank(r0) == false) goto L10;
            int r10 = bwb.b.a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "start", "start failed: sessionId is blank", null);
            return;
        L10:
            int r3 = com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.a.b;
            Intrinsics.checkNotNullParameter(r0, "sessionId");
            MmAppletPage.a r4 = MmAppletPage.Companion;
            MmAppletPage r5 = MmAppletPage.END_WINDOW;
            r4.getClass();
            String r1 = MmAppletPage.a.a(r5, r0);
            Activity r11 = (Activity) r6;
            if (r11.isFinishing() == false) goto L13;
        L14:
            r6 = r6.getApplicationContext();
        L15:
            int r12 = bwb.b.a;
            bwb.b.g(MmUiLogScene.END_WINDOW, "start", "start with context=" + r6 + ", application=" + LarkContext.getApplication(), null, 8);
            ConcurrentHashMap<String, Object> r2 = uub.c.a;
            Intrinsics.checkNotNullParameter(r1, "dataKey");
            Intrinsics.checkNotNullParameter(r8, "data");
            uub.c.a.put(r1, r8);
            Intent r13 = new Intent().setClassName(r6, r7);
            if ((r6 instanceof Activity) == true) goto L18;
            r13.addFlags(268435456);
        L18:
            r13.putExtra("extra_data_key", r1);
            r6.startActivity(r13);
            return;
        L13:
            if (r11.isDestroyed() == false) goto L15;
            goto L14
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L6;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L6:
        if (isChangingConfigurations() == true) goto L10;
        String r0 = this.c;
        if (r0 == null) goto L10;
        ConcurrentHashMap<String, Object> r1 = uub.c.a;
        Intrinsics.checkNotNullParameter(r0, "dataKey");
        uub.c.a.remove(r0);
    L10:
        super.onDestroy();
    }

    public MmBaseEndWindowActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r6);
        boolean r2 = false;
        View r7 = getLayoutInflater().inflate(2131564068, null, false);
        if (r7 == null) goto L39;
        FrameLayout r8 = (FrameLayout) r7;
        this.b = new OfficeSdkMmActivityEndWindowBinding(r8, r8);
        setContentView(r8);
        OfficeSdkMmActivityEndWindowBinding r9 = this.b;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L15:
        FrameLayout r10 = r9.a;
        int r3 = uvb.b.a;
        uvb.a.b(r10, uvb.c.c0);
        String r11 = getIntent().getStringExtra("extra_data_key");
        if (r11 != null) goto L18;
    L19:
        r2 = true;
    L21:
        if (r2 == false) goto L23;
        int r12 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onCreate", "Data key is null or blank, finish activity", null);
        finish();
        return;
    L23:
        this.c = r11;
        if (isFinishing() == false) goto L26;
    L36:
        int r13 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onCreate", "Activity is finishing or destroyed, skip fragment transaction", null);
        return;
    L26:
        if (isDestroyed() == true) goto L36;
        FragmentTransaction r4 = getSupportFragmentManager().beginTransaction();
        OfficeSdkMmActivityEndWindowBinding r5 = this.b;
        if (r5 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L31:
        int r0 = r5.b.getId();
        int r14 = MmEndWindowFragment.D;
        MmEndWindowFragment r15 = MmEndWindowFragment.a.a(r11);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r15, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r0) == true) goto L35;
        r4 = r4.replace(r0, r15);
    L35:
        r4.commitAllowingStateLoss();
        int r16 = bwb.b.a;
        bwb.b.g(MmUiLogScene.END_WINDOW, "onCreate", "MmEndWindowFragment added", null, 8);
        return;
    L18:
        if (StringsKt.isBlank(r11) == false) goto L21;
    L39:
        throw new NullPointerException("rootView");
    }
}
