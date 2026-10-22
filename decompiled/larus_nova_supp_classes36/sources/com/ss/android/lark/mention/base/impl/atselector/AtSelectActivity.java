package com.ss.android.lark.mention.base.impl.atselector;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import butterknife.ButterKnife;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import com.ss.android.lark.mention.base.impl.atselector.view.AtView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fsb.f;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtSelectActivity extends BaseFragmentActivity {
    public AtPresenter a;
    public int b;
    public String c;
    public final a d;

    public class a implements AtView.e {
        public final /* synthetic */ AtSelectActivity a;

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void y() {
            this.a.finish();
        }

        public a(AtSelectActivity r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void a(AtView r2) {
            ButterKnife.bind(r2, this.a);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void b(com.ss.android.lark.mention.base.impl.atselector.bean.d r5) {
            List<? extends ChatChatter> r0 = r5.a;
            List<UserGroupEntity> r6 = r5.b;
            StringBuilder r1 = new StringBuilder("finishActivityWithSelectMembers, chatters size: ");
            int r2 = 0;
            if (r0 == null) goto L5;
            int r3 = r0.size();
        L6:
            r1.append(r3);
            r1.append(", userGroups size: ");
            if (r6 == null) goto L9;
            r2 = r6.size();
        L9:
            r1.append(r2);
            Log.i("AtSelectActivity", r1.toString());
            if (CollectionUtils.isNotEmpty(r0) == true) goto L14;
            if (CollectionUtils.isNotEmpty(r6) == true) goto L14;
        L16:
            Intent r4 = new Intent();
            r4.putExtra("chatters_info", (Serializable) r0);
            r4.putExtra("user_groups_info", (Serializable) r6);
            this.a.setResult(-1, r4);
            this.a.finish();
            return;
        L14:
            if (TextUtils.isEmpty(this.a.c) == true) goto L16;
            String r7 = com.ss.android.lark.mention.base.impl.statistics.a.a;
            com.ss.android.lark.mention.base.impl.statistics.a.b(r0.size(), this.a.c);
            goto L16
        L5:
            r3 = 0;
            goto L6
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void showToast(String r2) {
            LKUIToast.show(this.a, r2);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ AtSelectActivity a;

        /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, com.ss.android.lark.mention.base.impl.atselector.AtSelectActivity] */
        public final void a() {
            String r0 = com.ss.android.lark.mention.base.impl.statistics.a.a;
            AppreciableKit.Companion.getInstance().spanStart(com.ss.android.lark.mention.base.impl.statistics.a.a, "first_render");
            f.c("AtSelectActivity").j();
            f.b().i("setContentView");
            this.a.setContentView(2131558457);
            f.b().h("setContentView");
            AtSelectInitData r1 = (AtSelectInitData) this.a.getIntent().getSerializableExtra("extra.init.data");
            if (r1 != null) goto L6;
            Log.e("AtSelectActivity", "initData is null");
            this.a.finish();
            return;
        L6:
            this.a.c = r1.getChannelId();
            Log.i("AtSelectActivity", "AtSelectActivity onCreate, channelId: " + this.a.c);
            com.ss.android.lark.mention.base.impl.statistics.a.c(this.a.c);
            f.b().i("initPresenter");
            ?? r3 = this.a;
            AtView r2 = new AtView(r3, r3.d);
            AtSelectActivity r4 = this.a;
            r4.a = new AtPresenter(r1, r2, r4.b);
            this.a.a.create();
            f.b().h("initPresenter");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(AtSelectActivity r1) {
            this.a = r1;
        }
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

    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_UP_IN);
    }

    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_BOTTOM_OUT);
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        AtPresenter r0 = this.a;
        if (r0 == null) goto L8;
        r0.destroy();
    L8:
        boolean r1 = crb.a.a;
        Log.e("AtSelectMonitor", "clearRecordMapOnDestroy");
        crb.a.b.clear();
        super.onDestroy();
    }

    public AtSelectActivity() {
        this.d = new a(this);
    }

    public final void onResume() {
        super.onResume();
        if (com.ss.android.lark.mention.base.impl.statistics.a.b == true) goto L6;
        AppreciableKit.Companion.getInstance().spanEnd(com.ss.android.lark.mention.base.impl.statistics.a.a, "first_render");
        com.ss.android.lark.mention.base.impl.statistics.a.b = true;
        return;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        super.onCreate(r3);
        int r4 = hashCode();
        this.b = r4;
        boolean r0 = crb.a.a;
        crb.a.b(r4, SystemClock.uptimeMillis());
        qqb.c.d("AtSelectActivity onCreate", new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r1) {
        super/*android.app.Activity*/.onWindowFocusChanged(r1);
        f.b().g();
    }
}
