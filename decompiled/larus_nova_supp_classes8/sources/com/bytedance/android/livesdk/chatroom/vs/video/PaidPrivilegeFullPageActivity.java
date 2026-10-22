package com.bytedance.android.livesdk.chatroom.vs.video;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.by0;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
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
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/PaidPrivilegeFullPageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidPrivilegeFullPageActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;
    public PaidPrivilegeItem a;
    public MultiVideoFragment b;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(PaidPrivilegeFullPageActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onBackPressed() {
        MultiVideoFragment r0 = this.b;
        if (r0 == null) goto L5;
        int r1 = d.a;
        d.a(r0.q);
    L5:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PaidPrivilegeFullPageActivity.class.getName()));
    L5:
        super.onDestroy();
        this.b = null;
        Window r0 = getWindow();
        if (r0 == null) goto L9;
        r0.clearFlags(DeviceInfoAndroid.BUFFER_SIZE);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
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

    public PaidPrivilegeFullPageActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r6);
        t8.b(getWindow());
        t8.e(this);
        setContentView(2131567123);
        Intent r7 = getIntent();
        if (r7 == null) goto L16;
        Bundle r8 = r7.getBundleExtra("paid_privilege_arguments");
        Context r1 = BadParcelableCrashOptimizer.getContext();
        if (r8 == null) goto L17;
        if (r1 == null) goto L17;
        r8.setClassLoader(r1.getClassLoader());
    L17:
        if (r8 == null) goto L19;
        Serializable r9 = r8.getSerializable("paid_privilege_item");
    L21:
        if ((r9 instanceof PaidPrivilegeItem) == true) goto L23;
        r9 = null;
    L23:
        PaidPrivilegeItem r10 = (PaidPrivilegeItem) r9;
        this.a = r10;
        if (r10 != null) goto L26;
    L34:
        PaidPrivilegeItem r11 = this.a;
        if (r11 == null) goto L58;
        Integer r2 = r11.getType();
        if (r2 != null) goto L40;
    L46:
        if (r2 != null) goto L49;
        return;
    L49:
        if (r2.intValue() != 6) goto L60;
        int r3 = MultiVideoFragment.z;
        Intrinsics.checkNotNullParameter(r11, "data");
        MultiVideoFragment r4 = new MultiVideoFragment();
        r4.d = r11;
        FragmentTransaction r12 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L54;
        r12 = r12.add(2131373275, r4);
    L54:
        r12.commitAllowingStateLoss();
        Unit r13 = Unit.INSTANCE;
        this.b = r4;
        return;
    L60:
        return;
    L40:
        if (r2.intValue() != 5) goto L46;
        int r5 = FullHybridViewFragment.h;
        String r14 = r11.getHybridSchema();
        FullHybridViewFragment r15 = new FullHybridViewFragment();
        r15.d = r14;
        FragmentTransaction r16 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r15, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L45;
        r16 = r16.add(2131373275, r15);
    L45:
        r16.commitAllowingStateLoss();
        return;
    L58:
        return;
    L26:
        if (r10.getNeedBanRecord4Paid() != true) goto L34;
        if (v.a() == true) goto L30;
    L31:
        Window r17 = getWindow();
        if (r17 == null) goto L34;
        r17.setFlags(DeviceInfoAndroid.BUFFER_SIZE, DeviceInfoAndroid.BUFFER_SIZE);
        goto L34
    L30:
        if (by0.a.getValue().booleanValue() == false) goto L34;
    L19:
        r9 = null;
        goto L21
    L16:
        r8 = null;
        goto L17
    }
}
