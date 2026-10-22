package com.bytedance.android.livesdk.chatroom.ui;

import android.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/EditIntroductionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "a", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class EditIntroductionActivity extends AppCompatActivity {

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
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

    public EditIntroductionActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (com.larus.platform.service.z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r6);
        Intent r7 = getIntent();
        if (r7 == null) goto L19;
        Bundle r8 = r7.getExtras();
        if (r8 == null) goto L19;
        String r9 = r8.getString("upload_callback_key");
        if (r9 == null) goto L19;
        Map<String, n6> r1 = com.bytedance.android.livesdk.chatroom.utils.s4.a;
        Intrinsics.checkNotNullParameter(r9, "key");
        if (((n6) ((LinkedHashMap) com.bytedance.android.livesdk.chatroom.utils.s4.a).get(r9)) != null) goto L19;
        ALogger.i("EditIntroductionActivityLog", "upload callback is null, finish edit activity");
        finish();
        Unit r10 = Unit.INSTANCE;
    L19:
        int r11 = com.bytedance.android.live.core.utils.s1.h(2131109391);
        Window r2 = getWindow();
        if (r2 == null) goto L26;
        if (r2.getStatusBarColor() == r11) goto L26;
        r2.setStatusBarColor(r11);
    L26:
        if (Build.VERSION.SDK_INT < 23) goto L41;
        Window r12 = getWindow();
        if (r12 == null) goto L41;
        View r13 = r12.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L35;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L35;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L35:
        if (r13 == null) goto L41;
        int r4 = r13.getSystemUiVisibility();
        if ((r4 & DeviceInfoAndroid.BUFFER_SIZE) == 8192) goto L41;
        r13.setSystemUiVisibility(r4 | DeviceInfoAndroid.BUFFER_SIZE);
    L41:
        setContentView(2131566219);
        EditIntroductionFragment r14 = new EditIntroductionFragment();
        Bundle r5 = new Bundle();
        Intent r15 = getIntent();
        if (r15 == null) goto L46;
        Bundle r16 = r15.getExtras();
        if (r16 == null) goto L46;
        String r17 = r16.getString("upload_callback_key");
    L47:
        r5.putString("upload_callback_key", r17);
        Intent r0 = getIntent();
        String r18 = "";
        if (r0 == null) goto L53;
        Bundle r19 = r0.getExtras();
        if (r19 == null) goto L53;
        String r20 = r19.getString("edit_content");
        if (r20 == null) goto L53;
    L54:
        r5.putString("edit_content", r20);
        Intent r21 = getIntent();
        if (r21 == null) goto L59;
        Bundle r22 = r21.getExtras();
        if (r22 == null) goto L59;
        boolean r23 = r22.getBoolean("add_image_directly");
    L60:
        r5.putBoolean("add_image_directly", r23);
        Intent r24 = getIntent();
        if (r24 == null) goto L68;
        Bundle r25 = r24.getExtras();
        if (r25 == null) goto L68;
        String r26 = r25.getString("upload_image_url_perfix_key");
        if (r26 == null) goto L68;
        r18 = r26;
    L68:
        r5.putString("upload_image_url_perfix_key", r18);
        Unit r27 = Unit.INSTANCE;
        r14.setArguments(r5);
        FragmentManager r28 = getSupportFragmentManager();
        if (r28 == null) goto L81;
        FragmentTransaction r29 = r28.beginTransaction();
        if (r29 != null) goto L73;
        return;
    L73:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r29, r14, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131371408) == true) goto L76;
        r29 = r29.add(2131371408, r14);
    L76:
        if (r29 == null) goto L83;
        r29.commit();
        return;
    L83:
        return;
    L81:
        return;
    L59:
        r23 = false;
    L53:
        r20 = "";
    L46:
        r17 = null;
        goto L47
    }
}
