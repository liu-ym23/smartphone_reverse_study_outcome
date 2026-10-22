package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.tips.GuideTipType;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/BotEditAvatarPreviewActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "fg", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/BotEditAvatarPreviewFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "getBackgroundResource", "finish", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEditAvatarPreviewActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int h = 0;
    public final BotEditAvatarPreviewFragment g;

    public static final class a {
        public a() {
        }

        public static void a(Context r5, BotAvatarIconData r6, BgImage r7, String r8, String r9, String r10, String r11, Boolean r12, BotModel r13, Boolean r14, String r15, String r16, String r17, Boolean r18, String r19, String r20, String r21, Boolean r22, String r23, Boolean r24, String r25, by7.e r26) {
            int r3 = BotEditAvatarPreviewActivity.h;
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "avatarInfo");
            Intrinsics.checkNotNullParameter(r26, "trackNode");
            com.bytedance.router.i r0 = SmartRouter.buildRoute(r5, "//flow/bot_edit_avatar_preview");
            Bundle r1 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("avatar_info", r6), TuplesKt.to("bg_image", r7), TuplesKt.to("bot_name", r8), TuplesKt.to("bot_description", r9), TuplesKt.to("user_bot_gender", r10), TuplesKt.to("user_bot_type", r11), TuplesKt.to("need_update_bot_info", r12), TuplesKt.to("bot_update_bot_argument", r13), TuplesKt.to("is_in_ai_gen_process", r14), TuplesKt.to("if_base_image", r18), TuplesKt.to("visual_style_status", r19), TuplesKt.to("description_status", r20), TuplesKt.to("original_user_image_uri_local", r21), TuplesKt.to("need_review_bot_info", r22), TuplesKt.to("original_avatar_image_uri", r23), TuplesKt.to("original_background_image_uri", r25)});
            by7.h.k(r1, r26);
            r0.c.putExtras(r1);
            r0.c.putExtra("click_from", r17);
            r0.c.putExtra("creation_id", r15);
            r0.c.putExtra("create_way", r16);
            r0.c.putExtra("has_origin_avatar", r24);
            r0.d = 2130772401;
            r0.e = 2130772399;
            r0.e(GuideTipType.OTHER);
        }
    }

    static {
        new a();
    }

    public final int C1() {
        return 2131102529;
    }

    public final boolean H1() {
        return true;
    }

    public final boolean K1() {
        return true;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BotEditAvatarPreviewActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public BotEditAvatarPreviewActivity() {
        this.g = new BotEditAvatarPreviewFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772412);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(BotEditAvatarPreviewActivity.class.getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        int r6 = v.a;
        com.larus.ugc.perf.impl.c.g("bot_edit_preview_page", "perf_bot_edit_preview_page_launch");
        setContentView(2131561787);
        this.g.setArguments(getIntent().getExtras());
        FragmentTransaction r7 = getSupportFragmentManager().beginTransaction();
        BotEditAvatarPreviewFragment r0 = this.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L14;
        r7 = r7.replace(2131373275, r0);
    L14:
        r7.commitAllowingStateLoss();
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r3 == null) goto L8;
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L9;
        this.g.getClass();
        Intrinsics.checkNotNullParameter(r4, "bundle");
        return;
    L9:
        return;
    }
}
