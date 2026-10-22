package com.larus.profile.impl.mine;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
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
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/profile/impl/mine/PageMineTabActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "fg", "Lcom/larus/profile/impl/mine/PageMineTabFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onEnterPage", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PageMineTabActivity extends FlowCommonAppCompatActivity {
    public final PageMineTabFragment g;

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PageMineTabActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public PageMineTabActivity() {
        this.g = new PageMineTabFragment();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(PageMineTabActivity.class.getName()));
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
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View N1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r61) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r61);
        setContentView(2131561787);
        Window r1 = getWindow();
        String r2 = null;
        if (r1 == null) goto L14;
        View r3 = N1(r1);
    L15:
        setRootView(r3);
        L1();
        this.g.setArguments(getIntent().getExtras());
        FragmentTransaction r4 = getSupportFragmentManager().beginTransaction();
        PageMineTabFragment r5 = this.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L19;
        r4 = r4.replace(2131373275, r5);
    L19:
        r4.commitAllowingStateLoss();
        Bundle r6 = getIntent().getExtras();
        if (r6 == null) goto L83;
        String r7 = r6.getString("landing_tab", null);
        if (r7 != null) goto L25;
        return;
    L25:
        switch(r7.hashCode()) {
            case -2038594998: goto L44;
            case -1770026516: goto L40;
            case -170643081: goto L36;
            case 598709804: goto L32;
            case 776739008: goto L28;
            default: goto L48;
        };
    L48:
        String r10 = "";
    L49:
        Bundle r8 = getIntent().getExtras();
        if (r8 == null) goto L55;
        String r9 = r8.getString("previous_page");
        if (r9 == null) goto L55;
        String r21 = r9;
    L56:
        Bundle r11 = getIntent().getExtras();
        if (r11 == null) goto L62;
        String r12 = r11.getString("enter_from");
        if (r12 == null) goto L62;
        String r13 = r12;
    L63:
        Bundle r14 = getIntent().getExtras();
        if (r14 == null) goto L66;
        String r15 = r14.getString("enter_method", "");
    L67:
        Bundle r16 = getIntent().getExtras();
        if (r16 == null) goto L70;
        String r22 = r16.getString("recommend_scene");
    L71:
        Bundle r17 = getIntent().getExtras();
        if (r17 == null) goto L74;
        r2 = r17.getString("recommend_request_id");
    L74:
        a1.c(null, null, null, null, null, r10, null, r13, r15, null, null, null, null, null, null, null, r21, r22, r2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -51381889, -1, 7);
        return;
    L70:
        r22 = null;
        goto L71
    L66:
        r15 = null;
    L62:
        r13 = "";
    L55:
        r21 = "";
        goto L56
    L28:
        if (r7.equals("PROFILE_CREATION_LIST_PUBLIC") == false) goto L78;
        String r18 = "creation_list";
    L47:
        r10 = r18;
        goto L49
    L78:
        r10 = "";
        goto L49
    L32:
        if (r7.equals("PROFILE_BOT_LIST") == false) goto L79;
        r18 = "self_bot_list";
        goto L47
    L79:
        r10 = "";
        goto L49
    L36:
        if (r7.equals("MY_COLLECT") == false) goto L80;
        r18 = "collection_list";
        goto L47
    L80:
        r10 = "";
        goto L49
    L40:
        if (r7.equals("PROFILE_CREATION_LIST_PRIVATE") == false) goto L81;
        r18 = "creation_private";
        goto L47
    L81:
        r10 = "";
        goto L49
    L44:
        if (r7.equals("MY_LIKE") == false) goto L82;
        r18 = "like_list";
        goto L47
    L82:
        r10 = "";
        goto L49
    L83:
        return;
    L14:
        r3 = null;
        goto L15
    }

    public final void onActivityResult(int r60, int r61, Intent r62) {
        super.onActivityResult(r60, r61, r62);
        if (r62 == null) goto L13;
        Bundle r0 = r62.getExtras();
        if (r0 == null) goto L13;
        PageMineTabFragment r2 = this.g;
        r2.getClass();
        String r20 = r0.getString("previous_page");
        if (r20 != null) goto L10;
        return;
    L10:
        if (com.larus.utils.o0.d(r20) == false) goto L14;
        a1.c(null, null, null, null, null, null, null, null, r2.Q, null, null, null, null, null, null, null, r20, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049601, -1, 7);
        return;
    L14:
        return;
    }
}
