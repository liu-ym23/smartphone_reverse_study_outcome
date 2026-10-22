package com.larus.uaigc.template;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationModel;
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
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/template/ImageTemplateActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageTemplateActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int g = 0;

    public static final class a implements zp9.m {
        public a() {
        }

        @Override // zp9.m
        public final boolean a(UserCreation r1, int r2, String r3, String r4, @DoSameQuickMenuType String r5) {
            Intrinsics.checkNotNullParameter(r1, "userCreation");
            return false;
        }

        @Override // zp9.m
        public final boolean e() {
            return true;
        }

        @Override // zp9.m
        public final boolean g() {
            return false;
        }

        @Override // zp9.m
        public final boolean b(UserCreation r2) {
            Intrinsics.checkNotNullParameter(r2, "userCreation");
            return false;
        }

        @Override // zp9.m
        public final void c(TabItemInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "tabItemInfo");
        }

        @Override // zp9.m
        public final void d(UserCreation r2) {
            Intrinsics.checkNotNullParameter(r2, "userCreation");
        }

        @Override // zp9.m
        public final void i(UserCreation r2) {
            Intrinsics.checkNotNullParameter(r2, "userCreation");
        }

        @Override // zp9.m
        public final void f(UserCreationModel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "userCreationModel");
        }

        @Override // zp9.m
        public final void h(UserCreationModel r1, l0 r2, View r3) {
            zp9.m.a.b(r1, r2);
        }
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ImageTemplateActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ImageTemplateActivity.class.getName()));
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

    public ImageTemplateActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r13);
        setContentView(2131561789);
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L13;
        r14.w();
        final Fragment r15 = k1.a.m(new a(), null);
    L14:
        if (r15 == null) goto L33;
        Pair[] r1 = new Pair[11];
        e0 r2 = (e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L21;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L21;
        String r4 = r3.W();
    L22:
        r1[0] = TuplesKt.to("argBotId", r4);
        r1[1] = TuplesKt.to("key_current_page_name", "image_generate");
        r1[2] = TuplesKt.to("key_is_multi_tab", Boolean.FALSE);
        Boolean r5 = Boolean.TRUE;
        r1[3] = TuplesKt.to("key_show_user_info", r5);
        r1[4] = TuplesKt.to("key_creation_recommend_type", 2);
        r1[5] = TuplesKt.to("key_creation_use_cache", r5);
        r1[6] = TuplesKt.to("recommend_from", "schema");
        r1[7] = TuplesKt.to("action_bar_template_id", 4);
        r1[8] = TuplesKt.to("enter_from", "template_list");
        r1[9] = TuplesKt.to("key_template_list_top_padding", 0);
        r1[10] = TuplesKt.to("key_template_list_bottom_padding", 0);
        r15.setArguments(BundleKt.bundleOf(r1));
        NovaTitleBarEx r6 = new NovaTitleBarEx(this);
        NovaTitleBarEx.b6(r6, v19.c.b(2130971749, this, 2131241477), false, null, null, new i(this), 14);
        r6.setBackgroundResource(v19.c.b(2130970529, this, 2131102529));
        NovaTitleBarEx.Y5(r6, getResources().getString(2131906382), null, new j(r15), 2);
        LinearLayout r7 = (LinearLayout) findViewById(2131378837);
        if (r7 == null) goto L25;
        r7.addView(r6, 0, new LinearLayout.LayoutParams(-1, -2));
    L25:
        FragmentTransaction r8 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r15, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L29;
        r8 = r8.replace(2131373275, r15);
    L29:
        r8.commitAllowingStateLoss();
        return;
    L21:
        r4 = null;
        goto L22
    L33:
        return;
    L13:
        r15 = null;
        goto L14
    }
}
