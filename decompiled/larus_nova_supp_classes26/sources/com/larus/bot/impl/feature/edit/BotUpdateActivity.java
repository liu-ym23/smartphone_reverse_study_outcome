package com.larus.bot.impl.feature.edit;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Transformations;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.im.bean.bot.ModelItem;
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
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bot/impl/feature/edit/BotUpdateActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "fg", "Lcom/larus/bot/impl/feature/edit/BotUpdateFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "needAdaptNavigationBarPadding", "", "needAdaptStatusBarPadding", "finish", "getBackgroundResource", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotUpdateActivity extends FlowCommonAppCompatActivity {
    public final BotUpdateFragment g;

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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BotUpdateActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public BotUpdateActivity() {
        this.g = new BotUpdateFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772402);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(BotUpdateActivity.class.getName()));
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
        BotUpdateFragment r1 = this.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L18;
        r8 = r8.replace(2131373275, r1);
    L18:
        r8.commitAllowingStateLoss();
        return;
    L13:
        r7 = null;
        goto L14
    }

    public final void onActivityResult(int r45, int r46, Intent r47) {
        super.onActivityResult(r45, r46, r47);
        if (r47 == null) goto L75;
        Bundle r0 = r47.getExtras();
        if (r0 == null) goto L75;
        final BotUpdateFragment r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "bundle");
        BotLanguage r3 = r0.getParcelable("key_selected_language");
        String r6 = "";
        if (r3 == null) goto L37;
        FLogger.a.i("BotUpdateFragment", "user selected new language=" + r3 + ", lastSelectedLanguage=" + r2.n);
        String r8 = r3.c();
        BotLanguage r9 = r2.n;
        if (r9 == null) goto L12;
        String r10 = r9.c();
    L14:
        if (Intrinsics.areEqual(r8, r10) == true) goto L37;
        p2a.f r11 = (p2a.f) r2.J.getValue();
        if (r11 == null) goto L18;
        r11.Z();
    L18:
        r2.n = r3;
        String r12 = r3.c();
        if (r12 != null) goto L21;
        String r18 = "";
    L22:
        String r4 = r3.b();
        if (r4 != null) goto L25;
        String r15 = "";
    L26:
        SpeakerVoice r5 = new SpeakerVoice(TriggerSendLoading.NO_LOADING, null, null, null, null, r15, null, null, r18, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, 2147483358, null);
        r2.o = r5;
        BotUpdateViewModel.updateVoice$default(r2.X90(), r5, false, 2, null);
        BotLanguage r7 = r2.n;
        if (r7 == null) goto L34;
        ItemTextArrow r13 = r2.u;
        if (r13 == null) goto L34;
        String r14 = r7.b();
        if (r14 != null) goto L33;
        r14 = "";
    L33:
        int r16 = ItemTextArrow.k;
        r13.Z5(r14, null);
    L34:
        ItemTextArrow r17 = r2.t;
        if (r17 == null) goto L37;
        String r19 = (String) r2.x.getValue();
        int r20 = ItemTextArrow.k;
        r17.Z5(r19, null);
        goto L37
    L25:
        r15 = r4;
        goto L26
    L21:
        r18 = r12;
        goto L22
    L12:
        r10 = null;
    L37:
        SpeakerVoice r21 = r2.o;
        if (r21 == null) goto L40;
        String r22 = r21.getId();
    L42:
        if (z2.a.o3().a == false) goto L49;
        w2a.f r23 = w2a.h.a(r0);
        if (r23 == null) goto L56;
        ItemTextArrow r24 = r2.t;
        if (r24 == null) goto L48;
        r24.Y5();
        r24.c6();
    L48:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BotUpdateFragment$updateSpeakerResult$1$2(r2, r23, r22, null), 3, null);
    L56:
        if (r2.j == null) goto L71;
        Serializable r25 = r0.getSerializable("select_model_result");
        if ((r25 instanceof ModelItem) == false) goto L61;
        final ModelItem r26 = (ModelItem) r25;
    L62:
        if (r26 == null) goto L71;
        r2.p = r26;
        r2.X90().updateModel(r26);
        r2.X90().updateModelType(r26.getModelType());
        Transformations.map(AuthModelDelegate.b.c(), new z0()).observe(r2.getViewLifecycleOwner(), new BotUpdateFragment.b(new a1(r2, r26)));
        ItemTextArrow r27 = r2.v;
        if (r27 == null) goto L71;
        String r28 = r26.getName();
        if (r28 == null) goto L70;
        r6 = r28;
    L70:
        int r29 = ItemTextArrow.k;
        r27.Z5(r6, null);
        goto L71
    L61:
        r26 = null;
    L71:
        com.larus.bot.impl.feature.edit.feature.avatar.u r30 = r2.C;
        if (r30 == null) goto L76;
        r30.onResult(r45, r0);
        return;
    L76:
        return;
    L49:
        SpeakerVoice r31 = r0.getSerializable("select_speaker_result");
        if ((r31 instanceof SpeakerVoice) == false) goto L52;
        SpeakerVoice r32 = r31;
    L53:
        if (r32 == null) goto L56;
        BotUpdateViewModel.updateVoice$default(r2.X90(), r32, false, 2, null);
        r2.o = r32;
        r2.ba0(false);
        goto L56
    L52:
        r32 = null;
        goto L53
    L40:
        r22 = null;
    }
}
