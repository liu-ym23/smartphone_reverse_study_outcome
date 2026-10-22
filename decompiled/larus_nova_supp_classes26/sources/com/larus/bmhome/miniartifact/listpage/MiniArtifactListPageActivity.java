package com.larus.bmhome.miniartifact.listpage;

import android.R;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.mainbot.api.miniartifact.MiniArtifactListPageParams;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/MiniArtifactListPageActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "miniArtifactListPageParams", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactListPageParams;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "parseProductParams", "intent", "Landroid/content/Intent;", "parseMiniArtifactTemplateParamsFromSchema", "parseArtifactFromShare", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactListPageActivity extends FlowCommonAppCompatActivity {
    public MiniArtifactListPageParams g;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(MiniArtifactListPageActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(MiniArtifactListPageActivity.class.getName()));
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
    public final void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        MiniArtifactListPageParams r0 = this.g;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.getPushFromBottom(), Boolean.TRUE);
    L6:
        if (r1 == false) goto L9;
        overridePendingTransition(0, 2130772402);
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
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

    public MiniArtifactListPageActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r12);
        Bundle r13 = getIntent().getExtras();
        z0 r1 = null;
        if (r13 == null) goto L13;
        Serializable r14 = r13.getSerializable("mini_artifact_list_page_navigation_params");
    L15:
        if ((r14 instanceof MiniArtifactListPageParams) == false) goto L17;
        MiniArtifactListPageParams r15 = (MiniArtifactListPageParams) r14;
    L19:
        if (r15 != null) goto L62;
        Intent r16 = getIntent();
        if (r16 == null) goto L23;
        Uri r17 = r16.getData();
    L25:
        if (r17 == null) goto L27;
        String r4 = UriProtector.getQueryParameter(r17, "push_from_bottom");
    L28:
        boolean r5 = Intrinsics.areEqual(r4, "1");
        if (r17 == null) goto L31;
        String r7 = UriProtector.getQueryParameter(r17, "enter_method");
    L32:
        FLogger.a.d("MiniArtifactListPageActivity", "parseMiniArtifactTemplateParamsFromSchema, uri = " + r17);
        if (r17 == null) goto L45;
        String r18 = UriProtector.getQueryParameter(r17, "track_params");
        if (r18 == null) goto L45;
        Object r19 = new Gson().fromJson(r18, new com.larus.bmhome.miniartifact.listpage.a().getType());     // Catch: Exception -> L44
        if (r7 == null) goto L43;
        HashMap r8 = (HashMap) r19;
        if (r8 == null) goto L43;
        r8.put("enter_method", r7);
    L43:
        r15 = new MiniArtifactListPageParams(Boolean.valueOf(r5), (Map) r19);
    L46:
        if (r15 != null) goto L62;
        Intent r110 = getIntent();
        if (r110 == null) goto L50;
        Uri r111 = r110.getData();
    L51:
        if (r111 == null) goto L53;
        String r6 = UriProtector.getQueryParameter(r111, "enter_method");
    L55:
        if (r111 == null) goto L57;
        String r9 = UriProtector.getQueryParameter(r111, "previous_page");
    L58:
        if (r111 == null) goto L60;
        String r112 = UriProtector.getQueryParameter(r111, "push_from_bottom");
    L61:
        r15 = new MiniArtifactListPageParams(Boolean.valueOf(Intrinsics.areEqual(r112, "1")), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enter_method", r6), TuplesKt.to("previous_page", r9)}));
        goto L62
    L60:
        r112 = null;
        goto L61
    L57:
        r9 = null;
        goto L58
    L53:
        r6 = null;
        goto L55
    L50:
        r111 = null;
    L45:
        r15 = null;
        goto L46
    L31:
        r7 = null;
        goto L32
    L27:
        r4 = null;
        goto L28
    L23:
        r17 = null;
    L62:
        this.g = r15;
        IActionBarService r3 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r3 == null) goto L65;
        r1 = r3.e(31);
    L65:
        if (r1 != null) goto L67;
        FLogger.a.i("MiniArtifactListPageActivity", "actionBarItem is null");
        t19.s r113 = t19.s.a;
        Application r0 = AppHost.a.getApplication();
        r113.getClass();
        t19.s.s(r0, 2131900411);
        finish();
        return;
    L67:
        setContentView(2131561787);
        if (getSupportFragmentManager().findFragmentByTag("MiniArtifactListPageFragment") != null) goto L80;
        MiniArtifactListPageFragment r2 = new MiniArtifactListPageFragment();
        Bundle r10 = new Bundle();
        r10.putSerializable("mini_artifact_list_page_navigation_params", r15);
        r2.setArguments(r10);
        FragmentTransaction r114 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r114, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "MiniArtifactListPageFragment", 2131373275) == true) goto L73;
        r114.replace(2131373275, r2, "MiniArtifactListPageFragment");
    L73:
        r114.commit();
        return;
    L80:
        return;
    L17:
        r15 = null;
        goto L19
    L13:
        r14 = null;
        goto L15
    }
}
