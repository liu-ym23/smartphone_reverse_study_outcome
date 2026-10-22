package com.larus.bot.impl.feature.edit;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bot.impl.bean.ContentType;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.im.bean.bot.SpeakerVoice;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/feature/edit/BotCreateActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "fg", "Lcom/larus/bot/impl/feature/edit/BotCreateFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "getBackgroundResource", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateActivity extends FlowCommonAppCompatActivity {
    public final BotCreateFragment g;

    public final int C1() {
        return 2131102535;
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BotCreateActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public BotCreateActivity() {
        this.g = new BotCreateFragment();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(BotCreateActivity.class.getName()));
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
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        setContentView(2131561787);
        Window r6 = getWindow();
        if (r6 == null) goto L13;
        View r7 = N1(r6);
    L14:
        setRootView(r7);
        L1();
        this.g.setArguments(getIntent().getExtras());
        FragmentTransaction r8 = getSupportFragmentManager().beginTransaction();
        BotCreateFragment r1 = this.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L18;
        r8 = r8.replace(2131373275, r1);
    L18:
        r8.commitAllowingStateLoss();
        return;
    L13:
        r7 = null;
        goto L14
    }

    public final void onActivityResult(int r44, int r45, Intent r46) {
        super.onActivityResult(r44, r45, r46);
        if (r46 == null) goto L52;
        Bundle r0 = r46.getExtras();
        if (r0 == null) goto L52;
        BotCreateFragment r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "bundle");
        BotLanguage r3 = (BotLanguage) r0.getParcelable("key_selected_language");
        SpeakerVoice r4 = null;
        if (r3 == null) goto L35;
        FLogger.a.i("BotCreateFragment", "user selected new language=" + r3 + ", lastSelectedLanguage=" + r2.s);
        String r6 = r3.c();
        BotLanguage r7 = r2.s;
        if (r7 == null) goto L12;
        String r8 = r7.c();
    L14:
        if (Intrinsics.areEqual(r6, r8) == true) goto L35;
        p2a.f r9 = (p2a.f) r2.I.getValue();
        if (r9 == null) goto L18;
        r9.Z();
    L18:
        r2.s = r3;
        String r10 = r3.c();
        if (r10 != null) goto L21;
        String r16 = "";
    L22:
        SpeakerVoice r11 = new SpeakerVoice(TriggerSendLoading.NO_LOADING, null, null, null, null, null, null, null, r16, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, 2147483390, null);
        r2.u = r11;
        BotCreateViewModel.updateVoice$default(r2.V90(), r11, false, 2, null);
        BotCreateViewModel.onBotInfoChanged$default(r2.V90(), ContentType.VOICE_ID, false, 2, null);
        BotLanguage r12 = r2.s;
        if (r12 == null) goto L30;
        ItemTextArrow r13 = r2.z;
        if (r13 == null) goto L30;
        String r14 = r12.b();
        if (r14 != null) goto L29;
        r14 = "";
    L29:
        int r15 = ItemTextArrow.k;
        r13.Z5(r14, null);
    L30:
        ItemTextArrow r17 = r2.y;
        if (r17 == null) goto L33;
        String r18 = (String) r2.o.getValue();
        int r19 = ItemTextArrow.k;
        r17.Z5(r18, null);
    L33:
        r2.V90().updateLanguage(r3);
        BotCreateViewModel.onBotInfoChanged$default(r2.V90(), ContentType.LANGUAGE, false, 2, null);
        goto L35
    L21:
        r16 = r10;
        goto L22
    L12:
        r8 = null;
    L35:
        if (z2.a.o3().a == false) goto L43;
        w2a.f r5 = w2a.h.a(r0);
        if (r5 == null) goto L48;
        SpeakerVoice r20 = r2.u;
        if (r20 == null) goto L41;
        String r21 = r20.getId();
    L42:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), null, null, new BotCreateFragment$updateSpeakerResult$1$1(r2, r5, r21, null), 3, null);
        goto L48
    L41:
        r21 = null;
    L48:
        com.larus.bot.impl.feature.edit.feature.avatar.u r22 = r2.w;
        if (r22 == null) goto L53;
        r22.onResult(r44, r0);
        return;
    L53:
        return;
    L43:
        r2.Y90();
        Serializable r23 = r0.getSerializable("select_speaker_result");
        if ((r23 instanceof SpeakerVoice) == false) goto L46;
        r4 = (SpeakerVoice) r23;
    L46:
        if (r4 == null) goto L48;
        r2.V90().updateVoice(r4, true);
        r2.u = r4;
        r2.ca0();
        FLogger.a.i("BotCreateFragment", "user selected new voice=" + r2.u + ", lastSelectedVoice=" + r2.u);
    }
}
