package com.obric.assistant.guide.ui;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.guide.adapter.UserGuideAdapterForAiAndFingerPages;
import com.obric.assistant.guide.adapter.UserGuideAdapterForAiAndVoicePages;
import com.obric.assistant.guide.adapter.UserGuideAdapterForAiPage;
import com.obric.assistant.guide.adapter.UserGuideAdapterForAllPages;
import com.obric.assistant.impl.databinding.ObricActivityUserGuideBinding;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.p1;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.t1;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f*\u0001\u001b\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0014J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001eH\u0014J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020&J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010)\u001a\u00020&J(\u0010+\u001a\u00020\u00192\u0006\u0010)\u001a\u00020&2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010H\u0002J\u000e\u0010/\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0019J\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u001eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u00065"}, d2 = {"Lcom/obric/assistant/guide/ui/UserGuideActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/obric/assistant/guide/IUserGuide;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricActivityUserGuideBinding;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "setViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "service", "Lcom/obric/assistant/guide/IObricUserGuide;", "hasFingerPrintOriginally", "", "getHasFingerPrintOriginally", "()Z", "setHasFingerPrintOriginally", "(Z)V", "hasVoicePrintOriginally", "getHasVoicePrintOriginally", "setHasVoicePrintOriginally", "lastPageName", "", "pageChangeCallback", "com/obric/assistant/guide/ui/UserGuideActivity$pageChangeCallback$1", "Lcom/obric/assistant/guide/ui/UserGuideActivity$pageChangeCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "adaptNavigationBarPadding", "needAdaptNavigationBarPadding", "needAdaptStatusBarPadding", "getBackgroundResource", "", "onDestroy", "handlePageSelected", "position", "getPageNameByPosition", "getOptionalPageName", "firstOptionalPosition", "isLocalDataSearchEnabled", "isImproveVoiceWakeupEnabled", "setLastPageName", "setUserGuideTipsShownWithLog", WindowEvent.Params.REASON, "getViewPagerState", "finish", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserGuideActivity extends FlowCommonAppCompatActivity implements cea.a {
    public static final /* synthetic */ int n = 0;
    public ObricActivityUserGuideBinding g;
    public ViewPager2 h;
    public final IObricUserGuide i;
    public boolean j;
    public boolean k;
    public String l;
    public final UserGuideActivity$pageChangeCallback$1 m;

    public static final class a {
    }

    static {
    }

    public static String O1(int r0, int r1, boolean r2, boolean r3) {
        if (r2 == true) goto L7;
        if (r0 != r1) goto L6;
        return "obric_onboarding_local_search";
    L6:
        r1 = r1 + 1;
    L7:
        if (r3 == true) goto L11;
        if (r0 != r1) goto L13;
        return "obric_onboarding_user_experience_plan";
    L13:
        return "unknown";
    L11:
        return "unknown";
    }

    public final int C1() {
        return 2131103788;
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final ViewPager2 Q1() {
        ViewPager2 r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    public final String R1() {
        if (this.h != null) goto L6;
        return "viewPager=uninitialized";
    L6:
        RecyclerView.Adapter r0 = Q1().getAdapter();
        StringBuilder r1 = new StringBuilder("viewPagerCurrent=");
        r1.append(Q1().getCurrentItem());
        r1.append(", viewPagerTotal=");
        if (r0 == null) goto L9;
        int r2 = r0.getItemCount();
    L10:
        r1.append(r2);
        r1.append(", adapter=");
        if (r0 == null) goto L13;
        String r3 = r0.getClass().getSimpleName();
    L14:
        r1.append(r3);
        return r1.toString();
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = 0;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(UserGuideActivity.class.getName()));
    L5:
        super.onDestroy();
        FLogger r0 = FLogger.a;
        r0.i("UserGuideActivity", "onDestroy start, isFinishing=" + isFinishing() + ", isChangingConfigurations=" + isChangingConfigurations() + ", userGuideTipsShown=" + t1.a.m0() + ", " + R1());
        if (this.h == null) goto L8;
        Q1().unregisterOnPageChangeCallback(this.m);
        r0.i("UserGuideActivity", "onDestroy pageChangeCallback unregistered");
    L9:
        com.obric.assistant.h.a.postValue(Boolean.TRUE);
        p1.b r1 = p1.a;
        r0.i("ObricPermissionManager", "unregisterActivityLifecycle");
        AppHost.Companion r2 = AppHost.a;
        r2.a().f(p1.b);
        r2.a().c(p1.a);
        r0.i("UserGuideActivity", "onDestroy end, guideDismissed posted");
        return;
    L8:
        r0.w("UserGuideActivity", "onDestroy skipped unregister pageChangeCallback, viewPager not initialized");
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.assistant.guide.ui.UserGuideActivity$pageChangeCallback$1] */
    public UserGuideActivity() {
        this.i = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        this.l = "obric_onboarding_privacy";
        this.m = new UserGuideActivity$pageChangeCallback$1(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0124 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        FLogger r2 = FLogger.a;
        r2.i("UserGuideActivity", "finish, " + R1());
        super.finish();
        overridePendingTransition(0, 2130772527);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        r2.i("ActivityLancet", "finish ".concat(UserGuideActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(this);     // Catch: Throwable -> L45
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
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L42
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

    public final void onResume() {
        super.onResume();
        FLogger.a.i("UserGuideActivity", "onResume, " + R1());
        ObricActivityUserGuideBinding r0 = this.g;
        ObricActivityUserGuideBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.b.post(new h0(this));
        ObricActivityUserGuideBinding r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        ViewCompat.setOnApplyWindowInsetsListener(r1.b, new i0());
        return;
    L8:
        r1 = r2;
        goto L9
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

    public final String P1(int r7) {
        RecyclerView.Adapter r0 = Q1().getAdapter();
        if (r0 != null) goto L5;
        return "unknown";
    L5:
        boolean r3 = false;
        if ((r0 instanceof UserGuideAdapterForAllPages) == false) goto L17;
        if (r7 == 0) goto L38;
        if (r7 == 1) goto L11;
        if (r7 == 2) goto L26;
        UserGuideAdapterForAllPages r1 = (UserGuideAdapterForAllPages) r0;
        return O1(r7, 3, r1.a, r1.b);
    L26:
        return EnrollViewModel.GUIDE_PAGE;
    L11:
        IObricUserGuide r8 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r8 == null) goto L14;
        r3 = r8.b();
    L14:
        if (r3 == false) goto L36;
    L37:
        return "obric_onboarding_ai_fingerprint_done";
    L36:
        return "obric_onboarding_ai_fingerprint";
    L38:
        return "obric_onboarding_ai_button_introduction";
    L17:
        if ((r0 instanceof UserGuideAdapterForAiPage) == false) goto L22;
        if (r7 == 0) goto L38;
        UserGuideAdapterForAiPage r2 = (UserGuideAdapterForAiPage) r0;
        return O1(r7, 1, r2.a, r2.b);
    L22:
        if ((r0 instanceof UserGuideAdapterForAiAndVoicePages) == false) goto L28;
        if (r7 == 0) goto L38;
        if (r7 == 1) goto L26;
        UserGuideAdapterForAiAndVoicePages r4 = (UserGuideAdapterForAiAndVoicePages) r0;
        return O1(r7, 2, r4.a, r4.b);
    L28:
        if ((r0 instanceof UserGuideAdapterForAiAndFingerPages) == false) goto L44;
        if (r7 == 0) goto L38;
        if (r7 == 1) goto L32;
        UserGuideAdapterForAiAndFingerPages r5 = (UserGuideAdapterForAiAndFingerPages) r0;
        return O1(r7, 2, r5.a, r5.b);
    L32:
        IObricUserGuide r9 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r9 == null) goto L35;
        r3 = r9.b();
    L35:
        if (r3 == true) goto L37;
    L44:
        return "unknown";
    }

    public final void S1(String r6) {
        Intrinsics.checkNotNullParameter(r6, WindowEvent.Params.REASON);
        t1 r0 = t1.a;
        boolean r1 = r0.m0();
        FLogger r2 = FLogger.a;
        r2.i("UserGuideActivity", "setUserGuideTipsShown start, reason=" + r6 + ", before=" + r1 + ", lastPageName=" + this.l + ", " + R1());
        r0.a1();
        boolean r3 = r0.m0();
        StringBuilder r4 = new StringBuilder("setUserGuideTipsShown end, reason=");
        r4.append(r6);
        r4.append(", after=");
        r4.append(r3);
        r2.i("UserGuideActivity", r4.toString());
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
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onCreate start, savedInstanceState=");
        if (r13 == null) goto L13;
        boolean r14 = true;
    L14:
        r1.append(r14);
        r1.append(", action=");
        Intent r15 = getIntent();
        ObricActivityUserGuideBinding r4 = null;
        if (r15 == null) goto L17;
        String r16 = r15.getAction();
    L18:
        r1.append(r16);
        r1.append(", data=");
        Intent r17 = getIntent();
        if (r17 == null) goto L21;
        Uri r18 = r17.getData();
    L22:
        r1.append(r18);
        r1.append(", extras=");
        Intent r19 = getIntent();
        if (r19 == null) goto L27;
        Bundle r110 = r19.getExtras();
        if (r110 == null) goto L27;
        Set<String> r111 = r110.keySet();
    L28:
        r1.append(r111);
        r0.i("UserGuideActivity", r1.toString());
        overridePendingTransition(2130772526, 0);
        Window r112 = getWindow();
        if (r112 == null) goto L31;
        View r113 = N1(r112);
    L32:
        setRootView(r113);
        View r114 = ((FlowCommonAppCompatActivity) this).b;
        if (r114 == null) goto L35;
        r114.setBackgroundColor(getResources().getColor(R.color.transparent));
    L35:
        Window r115 = getWindow();
        if (r115 == null) goto L38;
        r115.setBackgroundDrawableResource(R.color.transparent);
    L38:
        ConstraintLayout r116 = getLayoutInflater().inflate(2131563927, null, false);
        ConstraintLayout r5 = r116;
        ViewPager2 r7 = ViewBindings.findChildViewById(r116, 2131381274);
        if (r7 == null) goto L123;
        this.g = new ObricActivityUserGuideBinding(r5, r5, r7);
        setContentView(r5);
        boolean r117 = t9a.b.a().b();
        IObricUserGuide r6 = this.i;
        if (r6 != null) goto L43;
    L45:
        boolean r8 = false;
    L46:
        boolean r9 = ega.a.a();
        if (r117 == false) goto L54;
        IObricUserGuide r10 = this.i;
        if (r10 != null) goto L51;
    L53:
        boolean r11 = false;
    L55:
        this.j = r11;
        IObricUserGuide r12 = this.i;
        if (r12 != null) goto L58;
    L60:
        boolean r20 = false;
    L61:
        this.k = r20;
        boolean r21 = ObricPersonalContextSettingApiDelegate.b.q();
        t1 r22 = t1.a;
        boolean r23 = r22.x0();
        StringBuilder r118 = new StringBuilder("onCreate guide state, serviceAvailable=");
        if (this.i == null) goto L64;
        boolean r119 = true;
    L65:
        r118.append(r119);
        r118.append(", isObricOs=");
        r118.append(r117);
        r118.append(", useSystemDrawable=");
        r118.append(r8);
        r118.append(", isMainUser=");
        r118.append(r9);
        r118.append(", hasVoicePrintOriginally=");
        r118.append(this.k);
        r118.append(", hasFingerPrintOriginally=");
        r118.append(this.j);
        r118.append(", isLocalDataSearchEnabled=");
        r118.append(r21);
        r118.append(", isImproveVoiceWakeupEnabled=");
        r118.append(r23);
        r118.append(", userGuideTipsShown=");
        r118.append(r22.m0());
        r0.i("UserGuideActivity", r118.toString());
        if (r8 == true) goto L68;
    L80:
        if (r8 == false) goto L82;
    L83:
        if (r8 == true) goto L85;
    L92:
        if (r8 == false) goto L94;
    L95:
        if (r8 == true) goto L97;
    L109:
        ObricActivityUserGuideBinding r24 = this.g;
        if (r24 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L112:
        r24.c.setAdapter(new UserGuideAdapterForAiAndFingerPages(this, r21, r23));
    L113:
        ObricActivityUserGuideBinding r25 = this.g;
        if (r25 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L116:
        r25.c.setUserInputEnabled(false);
        ObricActivityUserGuideBinding r2 = this.g;
        if (r2 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L120:
        ViewPager2 r120 = r4.c;
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        this.h = r120;
        r0.i("UserGuideActivity", "onCreate adapter selected, " + R1());
        Q1().registerOnPageChangeCallback(this.m);
        r0.i("UserGuideActivity", "onCreate pageChangeCallback registered");
        getOnBackPressedDispatcher().addCallback(this, new AnonymousClass2(this));
        final PathInterpolator r121 = new PathInterpolator(0.18f, 0.85f, 0.4f, 1.0f);
        Q1().setPageTransformer(new g0(r121));
        p1.b r122 = p1.a;
        r0.i("ObricPermissionManager", "registerActivityLifecycle");
        AppHost.Companion r123 = AppHost.a;
        r123.a().e(p1.b);
        r123.a().j(p1.a);
        com.larus.utils.i0.a.getClass();
        com.larus.utils.i0.d(true);
        com.larus.utils.i0.i(new WeakReference(this));
        r0.i("UserGuideActivity", "onCreate end, " + R1());
        return;
    L119:
        r4 = r2;
        goto L120
    L97:
        if (this.k == true) goto L109;
        if (this.j == false) goto L109;
    L100:
        if (r9 == false) goto L105;
        ObricActivityUserGuideBinding r26 = this.g;
        if (r26 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L104:
        r26.c.setAdapter(new UserGuideAdapterForAiAndVoicePages(this, r21, r23));
        goto L113
    L105:
        ObricActivityUserGuideBinding r27 = this.g;
        if (r27 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L108:
        r27.c.setAdapter(new UserGuideAdapterForAiPage(this, r21, r23));
        goto L113
    L94:
        if (this.k == false) goto L100;
    L85:
        if (this.k == false) goto L92;
        if (this.j == false) goto L92;
    L88:
        ObricActivityUserGuideBinding r28 = this.g;
        if (r28 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L91:
        r28.c.setAdapter(new UserGuideAdapterForAiPage(this, r21, r23));
        goto L113
    L82:
        if (this.k == true) goto L88;
    L68:
        if (this.k == true) goto L80;
        if (this.j == true) goto L80;
        if (r9 == false) goto L76;
        ObricActivityUserGuideBinding r29 = this.g;
        if (r29 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L75:
        r29.c.setAdapter(new UserGuideAdapterForAllPages(this, r21, r23));
        goto L113
    L76:
        ObricActivityUserGuideBinding r30 = this.g;
        if (r30 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L79:
        r30.c.setAdapter(new UserGuideAdapterForAiAndFingerPages(this, r21, r23));
        goto L113
    L64:
        r119 = false;
        goto L65
    L58:
        if (r12.j() != true) goto L60;
        r20 = true;
        goto L61
    L51:
        if (r10.b() != true) goto L53;
    L54:
        r11 = true;
        goto L55
    L43:
        if (r6.h() != true) goto L45;
        r8 = true;
        goto L46
    L123:
        throw new NullPointerException("Missing required view with ID: ".concat(r116.getResources().getResourceName(2131381274)));
    L31:
        r113 = null;
    L27:
        r111 = null;
        goto L28
    L21:
        r18 = null;
        goto L22
    L17:
        r16 = null;
        goto L18
    L13:
        r14 = false;
        goto L14
    }
}
