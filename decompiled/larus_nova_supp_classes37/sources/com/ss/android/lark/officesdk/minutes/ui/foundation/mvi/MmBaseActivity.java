package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.Lifecycle;
import com.larksuite.component.air.WindowInsetsCompatAirActivity;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.h;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0015J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0015J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0015J\b\u0010\u0016\u001a\u00020\u000fH\u0015J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u000fH\u0015J\b\u0010\u001b\u001a\u00020\u000fH\u0015J\b\u0010\u001c\u001a\u00020\u000fH\u0015J\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseActivity;", "Lcom/larksuite/component/air/WindowInsetsCompatAirActivity;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "keepScreenOn", "", "getKeepScreenOn", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPostCreate", "setupWindowInsets", "initWindowInsets", "onStart", "onResume", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onStop", "onDestroy", "clearFragmentRestore", "bundle", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class MmBaseActivity extends WindowInsetsCompatAirActivity {
    public final Lazy a;

    public boolean A1() {
        return false;
    }

    public final String B1() {
        return (String) this.a.getValue();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
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

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        int r0 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onDestroy", null, B1(), 4);
    }

    public MmBaseActivity() {
        this.a = LazyKt.lazy(new MmBaseActivity$logDetail$2(this));
    }

    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        int r0 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onPause", null, B1(), 4);
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onResume", null, B1(), 4);
    }

    public final void onStart() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStart();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onStart", null, B1(), 4);
    }

    public void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onStop", null, B1(), 4);
    }

    public final void setupWindowInsets() {
        if (LarkContext.getApplication() != null) goto L11;
        int r0 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "setupWindowInsets", "Application not initialized, skip", B1());
        return;
    L11:
        super.setupWindowInsets();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        int r2 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "setupWindowInsets", "Exception " + e.getMessage(), B1());
    }

    public static View z1(Window r3) {
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
    public void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L9
    L11:
        if (r6 != null) goto L28;
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "clearFragmentRestore", "clearFragmentRestore false", B1());
    L20:
        super.onCreate(r6);
        if (LarkContext.getApplication() != null) goto L24;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "onCreate", "Application not initialized after super, finish", B1());
        finish();
        return;
    L24:
        if (A1() == false) goto L26;
        getWindow().addFlags(128);
    L26:
        bwb.b.g(MmUiLogScene.FOUNDATION, "onCreate", null, B1(), 4);
        Window r8 = getWindow();
        r8.clearFlags(67108864);
        r8.clearFlags(134217728);
        r8.addFlags(Integer.MIN_VALUE);
        z1(r8).setSystemUiVisibility(1280);
        h r0 = WindowInsetsUtils.c(this);
        r0.b(0);
        r0.i(0);
        r0.f(false);
        r0.c(false);
        r0.o(false);
        r0.k(true);
        View r9 = z1(r8);
        OneShotPreDrawListener.add(r9, new a(r9));
        return;
    L28:
        Bundle r2 = r6.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");     // Catch: Exception -> L17
        if (r2 == null) goto L19;
        r2.remove("android:support:fragments");     // Catch: Exception -> L17
    L19:
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "clearFragmentRestore", "clearFragmentRestore true", B1());
    L17:
        e = move-exception;
        int r4 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "clearFragmentRestore", "clearFragmentRestore exception " + e.getMessage(), B1());
        goto L19
    }

    public final void onNewIntent(Intent r4) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r4);
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "onNewIntent", "intent=" + r4, B1());
    }

    public final void onPostCreate(Bundle r2) {
        super/*com.larksuite.component.air.AirActivity*/.onPostCreate(r2);
        uvb.a.c(findViewById(R.id.content), getClass().getSimpleName());
    }
}
