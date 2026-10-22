package com.bytedance.ai.applet.app;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.app.foundation.RouteAction;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.app.view.AppletActionSheetDialog;
import com.bytedance.ai.applet.app.view.AppletAppActionBar;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.applet.services.AppletSnapshotManagerService;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.AppletChatConfig;
import com.bytedance.ai.model.objects.AppletChatFeature;
import com.bytedance.ai.model.objects.AppletChatFeatures;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.JsonObject;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020%H\u0014J\u0012\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020!H\u0014J\b\u00101\u001a\u00020%H\u0014J\b\u00102\u001a\u00020%H\u0014J\b\u00103\u001a\u00020%H\u0014J\b\u00104\u001a\u00020%H\u0014J\b\u00105\u001a\u00020%H\u0014J\r\u00106\u001a\u00020%H\u0010¢\u0006\u0002\b7J\b\u00108\u001a\u00020%H\u0014J\u0010\u00109\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020%H\u0002J\b\u0010;\u001a\u00020%H\u0002J\b\u0010<\u001a\u00020%H\u0016J\b\u0010=\u001a\u00020%H\u0016J\u0010\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u001fH\u0016J\b\u0010@\u001a\u00020%H\u0016J\b\u0010A\u001a\u00020%H\u0016J\u0018\u0010B\u001a\u00020%2\u0006\u0010?\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0016J\u0010\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u001fH\u0016J\u0010\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020HH\u0016J\u0018\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u000bH\u0002J\u0017\u0010M\u001a\u00020\u000f2\b\u0010N\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020%H\u0002J\b\u0010Q\u001a\u00020%H\u0002J\b\u0010R\u001a\u00020%H\u0002J\u0010\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u0015H\u0002J\u0010\u0010U\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u0015H\u0002J\u0010\u0010V\u001a\u00020%2\u0006\u0010T\u001a\u00020\u0015H\u0002J\u0010\u0010W\u001a\u00020%2\u0006\u0010T\u001a\u00020\u0015H\u0002J\u0010\u0010X\u001a\u00020%2\u0006\u0010T\u001a\u00020\u0015H\u0002J\b\u0010Y\u001a\u00020%H\u0002J\b\u0010Z\u001a\u00020%H\u0002J\b\u0010[\u001a\u00020%H\u0002J\b\u0010\\\u001a\u00020%H\u0002J\b\u0010]\u001a\u00020%H\u0014J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020aH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletFullScreenActivity;", "Lcom/bytedance/ai/applet/app/AppletAppActivity;", "Lcom/bytedance/ai/applet/components/input/AppletChatInputController$MessageStateChangeListener;", "Lcom/bytedance/ai/applet/components/input/AppletChatInputController$ChatPanelInfoChangeListener;", "<init>", "()V", "showMode", "Lcom/bytedance/ai/applet/app/AppletShowMode;", "getShowMode$ai_sdk_release", "()Lcom/bytedance/ai/applet/app/AppletShowMode;", "actionSheetDialog", "Lcom/bytedance/ai/applet/app/view/AppletActionSheetDialog;", "pinStatusSyncJob", "Lkotlinx/coroutines/Job;", "hasOpenedActionSheet", "", "isTaskForeground", "taskStackLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "startedActivitiesInAppletTask", "", "Landroid/app/Activity;", "firstChildActivityInAppletTask", "Ljava/lang/ref/WeakReference;", "isFirstChildActivityEnterAnimationPending", "_chatInputController", "Lcom/bytedance/ai/applet/components/input/AppletChatInputController;", "chatInputController", "getChatInputController$ai_sdk_release", "()Lcom/bytedance/ai/applet/components/input/AppletChatInputController;", "currentChatInputMethod", "", "sourceTaskId", "", "Ljava/lang/Integer;", "hasTaskBeenBackgroundedSinceLaunch", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupHostContent", "onNewIntent", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onNightModeChanged", "mode", "onHostThemeChanged", "onStart", "onResume", "onStop", "onDestroy", "closeAppView", "closeAppView$ai_sdk_release", "handleRootBackPressed", "updateSourceTask", "updateActionBarTopMargin", "initNavigation", "showChatInput", "hideChatInput", "willSendMessage", "localMessageId", "onTextInputActivated", "onVoiceInputActivated", "didSendMessage", "messageId", "didReceiveReplyMessage", "responseMessageId", "onChatPanelInfoChanged", "panelInfo", "Lcom/bytedance/ai/applet/components/input/AppletChatPanelInfo;", "observePinMenuStatus", "app", "Lcom/bytedance/ai/applet/app/AppletApplication;", "dialog", "hostTaskMoveToFront", "preferredTaskId", "(Ljava/lang/Integer;)Z", "safeMoveTaskToBack", "registerTaskStackLifecycleCallbacks", "unregisterTaskStackLifecycleCallbacks", "isInAppletTask", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "isFirstChildActivity", "applyTaskActivityAnimations", "applyPendingActivityEnterAnimation", "applyActivityExitAnimation", "dispatchTaskState", "dispatchTaskForegroundIfNeeded", "dispatchTaskBackgroundIfNeeded", "updateTaskDescription", "destroyHostAuxiliaryContentNow", "getMenuButton", "Landroid/view/View;", "getMenuButtonBoundingClientRect", "Landroid/graphics/Rect;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletFullScreenActivity extends AppletAppActivity implements AppletChatInputController.g, AppletChatInputController.c {
    public static final /* synthetic */ int x = 0;
    public final AppletShowMode k;
    public AppletActionSheetDialog l;
    public Job m;
    public boolean n;
    public boolean o;
    public s p;
    public final Set<Activity> q;
    public WeakReference<Activity> r;
    public boolean s;
    public AppletChatInputController t;
    public String u;
    public Integer v;
    public boolean w;

    public static final class a {
    }

    public static final class b implements AppletChatInputController.a {
        public final /* synthetic */ AppletFullScreenActivity a;

        public b(AppletFullScreenActivity r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.a
        public final void a(AppletChatInputController.ActionBarItemLocation r10, String r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LOCATION);
            Intrinsics.checkNotNullParameter(r11, "actionBarKey");
            AppletApplication r13 = this.a.e;
            if (r13 == null) goto L18;
            v r14 = r13.h();
            if (r14 == null) goto L19;
            com.bytedance.ai.applet.app.foundation.j r15 = r14.e();
            if (r15 == null) goto L20;
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LOCATION);
            Intrinsics.checkNotNullParameter(r11, "actionBarKey");
            int r16 = com.bytedance.ai.applet.app.foundation.j.b.a[r10.ordinal()];
            if (r16 != 1) goto L11;
            String r17 = "common_venue_action_bar_click";
        L16:
            r15.i(r17, com.bytedance.ai.applet.app.foundation.j.b(r11, r12));
            return;
        L11:
            if (r16 != 2) goto L14;
            r17 = "common_venue_action_bar_detail_click";
            goto L16
        L14:
            throw new NoWhenBranchMatchedException();
        L20:
            return;
        L19:
            return;
        }

        @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.a
        public final void b(AppletChatInputController.ActionBarItemLocation r10, String r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LOCATION);
            Intrinsics.checkNotNullParameter(r11, "actionBarKey");
            AppletApplication r13 = this.a.e;
            if (r13 == null) goto L18;
            v r14 = r13.h();
            if (r14 == null) goto L19;
            com.bytedance.ai.applet.app.foundation.j r15 = r14.e();
            if (r15 == null) goto L20;
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LOCATION);
            Intrinsics.checkNotNullParameter(r11, "actionBarKey");
            int r16 = com.bytedance.ai.applet.app.foundation.j.b.a[r10.ordinal()];
            if (r16 != 1) goto L11;
            String r17 = "common_venue_action_bar_show";
        L16:
            r15.i(r17, com.bytedance.ai.applet.app.foundation.j.b(r11, r12));
            return;
        L11:
            if (r16 != 2) goto L14;
            r17 = "common_venue_action_bar_detail_show";
            goto L16
        L14:
            throw new NoWhenBranchMatchedException();
        L20:
            return;
        L19:
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void B1() {
        this.c.c("closeAppView: remove applet task, taskId=" + getTaskId());
        finishAndRemoveTask();
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void D1() {
        AppletChatInputController r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        this.c.c("destroyChatInputControllerNow");
        r0.A7(null);
        r0.r7(null);
        r0.u7(this);
        r0.s7(this);
        if (r0.getFragment().isAdded() == false) goto L8;
        getSupportFragmentManager().beginTransaction().remove(r0.getFragment()).commitNowAllowingStateLoss();
    L8:
        this.t = null;
        this.u = null;
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void N1() {
        if (this.v != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.c.c("handleRootBackPressed: sourceTaskId=" + this.v + ", hasTaskBeenBackgroundedSinceLaunch=" + this.w + ", canMoveBackToSourceTask=" + r0);
        if (r0 == false) goto L12;
        j2();
        return;
    L12:
        if (P1(this.v) == true) goto L16;
        this.c.c("handleRootBackPressed: host task unavailable, move applet task to back");
        j2();
        return;
    L16:
        return;
    L5:
        if (this.w == true) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void O1() {
        AppletChatInputController r0 = this.t;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getVisibility() == true) goto L8;
        return;
    L8:
        this.c.c("hideChatInput");
        r0.setVisibility(false);
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void T1() {
        AppletActionSheetDialog r0 = this.l;
        if (r0 == null) goto L6;
        r0.L0();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void Z1() {
        AppletChatInputController r0 = this.t;
        if (r0 != null) goto L5;
        boolean r10 = true;
    L6:
        if (r0 != null) goto L70;
        AppletApplication r1 = this.e;
        if (r1 == null) goto L14;
        Applet r11 = r1.j();
        if (r11 == null) goto L14;
        h5.f r12 = h5.f.a;
        String r13 = r11.Y;
        r12.getClass();
        AppletChatConfig r14 = (AppletChatConfig) h5.f.a(r13, AppletChatConfig.class);
        if (r14 == null) goto L14;
        AppletChatFeatures r15 = r14.getFeatures();
    L16:
        if (r15 == null) goto L22;
        AppletChatFeature r16 = r15.getCamera();
        if (r16 == null) goto L22;
        Boolean r17 = r16.getEnabled();
        if (r17 == null) goto L22;
        boolean r18 = r17.booleanValue();
    L23:
        if (r15 == null) goto L29;
        AppletChatFeature r19 = r15.getExtraActions();
        if (r19 == null) goto L29;
        Boolean r20 = r19.getEnabled();
        if (r20 == null) goto L29;
        boolean r21 = r20.booleanValue();
    L30:
        AppletApplication r22 = this.e;
        if (r22 == null) goto L37;
        v r23 = r22.h();
        if (r23 == null) goto L37;
        com.bytedance.ai.applet.app.foundation.a r24 = r23.b();
        if (r24 == null) goto L37;
        String r25 = r24.c;
    L38:
        AppletApplication r26 = this.e;
        if (r26 == null) goto L45;
        v r27 = r26.h();
        if (r27 == null) goto L45;
        com.bytedance.ai.applet.app.foundation.a r28 = r27.b();
        if (r28 == null) goto L45;
        String r29 = r28.d;
    L46:
        AppletChatInputController.d r30 = new AppletChatInputController.d(r18, r21, r25, r29);
        this.c.c("showChatInput: create controller, config=" + r30);
        g2.b r31 = this.d;
        if (r31 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("abilities");
        r31 = null;
    L50:
        r0 = r31.p(this);
        r0.y7(r30);
        r0.z7(this);
        r0.w7(this);
        AppletApplication r32 = this.e;
        if (r32 == null) goto L55;
        v r33 = r32.h();
        if (r33 == null) goto L55;
        AppletModelContextProvider r34 = (AppletModelContextProvider) r33.n.getValue();
    L56:
        r0.r7(r34);
        r0.A7(new b(this));
        this.t = r0;
        AppletApplication r35 = this.e;
        if (r35 == null) goto L65;
        v r36 = r35.h();
        if (r36 == null) goto L65;
        com.bytedance.ai.applet.app.foundation.a r37 = r36.b();
        if (r37 == null) goto L65;
        Intrinsics.checkNotNullParameter(r0, "controller");
        String r38 = r37.b;
        if (r38 == null) goto L65;
        r0.q7(r38);
    L65:
        FragmentTransaction r39 = getSupportFragmentManager().beginTransaction();
        Fragment r40 = r0.getFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r39, r40, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131365537) == true) goto L69;
        r39 = r39.replace(2131365537, r40);
    L69:
        r39.commitAllowingStateLoss();
    L55:
        r34 = null;
    L45:
        r29 = null;
    L37:
        r25 = null;
    L29:
        r21 = true;
    L22:
        r18 = true;
    L14:
        r15 = null;
    L70:
        if (r10 == false) goto L72;
    L73:
        this.c.c("showChatInput");
        r0.setVisibility(true);
        return;
    L72:
        if (r0.getVisibility() == false) goto L73;
        return;
    L5:
        r10 = false;
        goto L6
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r10 = FLogger.a;
        r10.i("ActivityLancet", "finish ".concat(AppletFullScreenActivity.class.getName()));
        long r11 = SystemClock.uptimeMillis();
        Map r12 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r12);
        Long r13 = (Long) r12.get(this);     // Catch: Throwable -> L45
        if (r13 != null) goto L10;
    L13:
        r12.put(this, Long.valueOf(r11));     // Catch: Throwable -> L45
        monitor-exit(r12);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r10.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r10.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r10.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r10.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r10.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
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
        r10.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r11 - r13.longValue()) >= 800) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j2() {
        AppletApplication r0 = this.e;
        if (r0 == null) goto L6;
        r0.v(this);
    L6:
        if (isFinishing() == false) goto L8;
        return;
    L8:
        if (isDestroyed() == false) goto L19;
        return;
    L19:
        moveTaskToBack(true);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.ai.applet.base.log.d r1 = this.c;
        String r10 = e.getMessage();
        if (r10 != null) goto L17;
        r10 = "moveTaskToBack ERROR";
    L17:
        r1.a(r10, e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletFullScreenActivity.class.getName()));
    L5:
        AppletChatInputController r0 = this.t;
        if (r0 == null) goto L8;
        r0.u7(this);
    L8:
        AppletChatInputController r1 = this.t;
        if (r1 == null) goto L11;
        r1.s7(this);
    L11:
        AppletChatInputController r10 = this.t;
        if (r10 == null) goto L14;
        r10.A7(null);
    L14:
        this.t = null;
        this.u = null;
        Job r11 = this.m;
        if (r11 == null) goto L17;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L17:
        this.m = null;
        AppCompatDialog r12 = this.l;
        if (r12 == null) goto L36;
        Handler r13 = DialogLancet.resolveDialogHandler(r12);
        if (r13 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(r12);
        r12.dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(r12);
        goto L36
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r14 == null) goto L33;
        com.bytedance.crash.d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r12);
        throw th;
    L22:
        if (Looper.myLooper() == r13.getLooper()) goto L24;
        r13.post(DialogLancet.createDismissRunnable(r12));
    L36:
        this.l = null;
        if (isFinishing() == false) goto L39;
    L41:
        LinkedList<AppletAppActivity> r15 = com.bytedance.ai.applet.services.b.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        com.bytedance.ai.applet.services.b.a.remove(this);
        com.bytedance.ai.applet.services.b.b.remove(this);
        this.c.c("unregisterTaskStackLifecycleCallbacks: taskId=" + getTaskId() + ", startedCount=" + this.q.size());
        s r16 = this.p;
        if (r16 == null) goto L50;
        Context r17 = getApplicationContext();
        if ((r17 instanceof Application) == false) goto L46;
        Application r18 = (Application) r17;
    L47:
        if (r18 == null) goto L49;
        r18.unregisterActivityLifecycleCallbacks(r16);
        goto L50
    L49:
        this.c.a("unregisterTaskStackLifecycleCallbacks: applicationContext is not Application", null);
        goto L50
    L46:
        r18 = null;
    L50:
        this.p = null;
        this.q.clear();
        this.r = null;
        this.s = false;
        super.onDestroy();
        return;
    L39:
        if (this.o == true) goto L41;
        this.c.c("onDestroy: Activity is being destroyed in background, removing task.");
        B1();
        goto L41
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.g
    public final void t() {
        this.u = "text";
        AppletApplication r1 = this.e;
        if (r1 == null) goto L10;
        v r10 = r1.h();
        if (r10 == null) goto L11;
        com.bytedance.ai.applet.app.foundation.j r11 = r10.e();
        if (r11 == null) goto L12;
        Intrinsics.checkNotNullParameter("text", "clickMethod");
        r11.i("doubao_apps_chat_box_click", MapsKt.mapOf(TuplesKt.to("click_method", "text")));
        return;
    L12:
        return;
    L11:
        return;
    }

    public AppletFullScreenActivity() {
        this.k = AppletShowMode.FULL_SCREEN;
        this.q = new LinkedHashSet();
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final View I1() {
        return findViewById(2131363132);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final Rect K1() {
        Resources r0 = getResources();
        int r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
        g2.b r10 = this.d;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("abilities");
        r10 = null;
    L6:
        int r11 = r10.getStatusBarHeight(this);
        int r12 = r1 - n2.a.a(12);
        int r13 = r12 - n2.a.a(84);
        int r14 = r11 + n2.a.a(4);
        int r15 = n2.a.a(36) + r14;
        return new Rect((int) n2.a.c(Integer.valueOf(r13)), (int) n2.a.c(Integer.valueOf(r14)), (int) n2.a.c(Integer.valueOf(r12)), (int) n2.a.c(Integer.valueOf(r15)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void Y1() {
        setContentView(2131558445);
        AppletAppActionBar r0 = (AppletAppActionBar) findViewById(2131363132);
        k2();
        r0.setOnOpenListener(new o(this));
        r0.setOnCloseListener(new p(this));
        AppletApplication r1 = this.e;
        if (r1 == null) goto L25;
        Applet r10 = r1.j();
        if (r10 == null) goto L26;
        String r11 = r10.a;
        if (r11 == null) goto L28;
        AppletApplication r12 = this.e;
        if (r12 == null) goto L14;
        Applet r13 = r12.j();
        if (r13 == null) goto L14;
        String r14 = r13.b();
    L15:
        setTaskDescription(new ActivityManager.TaskDescription(r11));
        if (r14 != null) goto L18;
    L21:
        boolean r15 = true;
    L22:
        if (r15 == true) goto L27;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletFullScreenActivity$updateTaskDescription$1(this, r14, r11, null), 3, null);
        return;
    L27:
        return;
    L18:
        if (r14.length() == 0) goto L21;
        r15 = false;
    L14:
        r14 = null;
        goto L15
    L28:
        return;
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k2() {
        AppletAppActionBar r0 = (AppletAppActionBar) findViewById(2131363132);
        if (r0 != null) goto L5;
        return;
    L5:
        g2.b r1 = this.d;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("abilities");
        r1 = null;
    L9:
        int r10 = r1.getStatusBarHeight(this);
        ViewGroup.LayoutParams r11 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        ((ViewGroup.MarginLayoutParams) r12).topMargin = r10 - n2.a.a(8);
        r0.setLayoutParams(r12);
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void onResume() {
        super.onResume();
        AppletAppActionBar r0 = (AppletAppActionBar) findViewById(2131363132);
        if (r0 == null) goto L5;
        int r1 = AppletAppActionBar.v;
        r0.a(false);
    L5:
        LinkedList<AppletAppActivity> r10 = com.bytedance.ai.applet.services.b.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        com.bytedance.ai.applet.services.b.b.remove(this);
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void onStart() {
        super.onStart();
        LinkedList<AppletAppActivity> r0 = com.bytedance.ai.applet.services.b.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        com.bytedance.ai.applet.services.b.b.remove(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void onStop() {
        super.onStop();
        LinkedList<AppletAppActivity> r0 = com.bytedance.ai.applet.services.b.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        com.bytedance.ai.applet.services.b.b.put(this, Long.valueOf(System.currentTimeMillis()));
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r1 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r10 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r10 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r10, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r1.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.g
    public final void y() {
        this.u = "voice";
        AppletApplication r1 = this.e;
        if (r1 == null) goto L10;
        v r10 = r1.h();
        if (r10 == null) goto L11;
        com.bytedance.ai.applet.app.foundation.j r11 = r10.e();
        if (r11 == null) goto L12;
        Intrinsics.checkNotNullParameter("voice", "clickMethod");
        r11.i("doubao_apps_chat_box_click", MapsKt.mapOf(TuplesKt.to("click_method", "voice")));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final AppletChatInputController H1() {
        return this.t;
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final AppletShowMode L1() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g2(AppletFullScreenActivity r10) {
        String r11 = null;
        if ((!r10.q.isEmpty()) == false) goto L21;
        if (r10.o == true) goto L33;
        r10.o = true;
        com.bytedance.ai.applet.base.log.d r0 = r10.c;
        StringBuilder r1 = new StringBuilder("dispatchTaskForeground: taskId=");
        r1.append(r10.getTaskId());
        r1.append(", appId=");
        AppletApplication r12 = r10.e;
        if (r12 == null) goto L10;
        String r13 = r12.getAppId();
    L11:
        r1.append(r13);
        r0.c(r1.toString());
        AppletApplication r14 = r10.e;
        if (r14 == null) goto L31;
        Intrinsics.checkNotNullParameter(r10, "context");
        r14.i().c("onTaskForeground");
        com.bytedance.ai.applet.app.foundation.j r15 = r14.h().e();
        r15.getClass();
        r15.g = UUID.randomUUID().toString();
        com.bytedance.ai.applet.app.foundation.j r16 = r14.h().e();
        String r17 = r16.b;
        if (r17 != null) goto L16;
        r17 = "unknown";
    L16:
        r16.i("enter_page", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD, r17)));
        r16.b = null;
        r14.m = System.currentTimeMillis();
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(r14, "app");
        Intrinsics.checkNotNullParameter(r10, "context");
        Iterator r18 = AppletAppManagerService.b.iterator();
    L18:
        if (r18.hasNext() == false) goto L35;
        ((AppLifecycleCallbacks) r18.next()).onAppTaskForeground(r14, r10);
        goto L18
    L35:
        return;
    L31:
        return;
    L10:
        r13 = null;
        goto L11
    L33:
        return;
    L21:
        if (r10.o == false) goto L34;
        r10.o = false;
        r10.w = true;
        com.bytedance.ai.applet.base.log.d r19 = r10.c;
        StringBuilder r20 = new StringBuilder("dispatchTaskBackground: taskId=");
        r20.append(r10.getTaskId());
        r20.append(", appId=");
        AppletApplication r21 = r10.e;
        if (r21 == null) goto L26;
        r11 = r21.getAppId();
    L26:
        r20.append(r11);
        r19.c(r20.toString());
        AppletApplication r22 = r10.e;
        if (r22 == null) goto L32;
        r22.C(r10);
        return;
    L32:
        return;
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.g
    public final void L(String r10) {
        Intrinsics.checkNotNullParameter(r10, "localMessageId");
        this.c.c("chatInput willSendMessage: localMessageId=" + r10);
        List r0 = getSupportFragmentManager().getFragments();
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L13;
        Object r11 = r1.previous();
        Fragment r12 = (Fragment) r11;
        if (r12.getId() == 2131363104) goto L8;
    L10:
        boolean r13 = false;
    L11:
        if (r13 == false) goto L4;
    L14:
        Fragment r14 = (Fragment) r11;
        if (r14 == null) goto L17;
        View r15 = r14.getView();
    L18:
        if (r15 != null) goto L21;
        this.c.a("willSendMessage: top page view is null, skip capture", null);
        return;
    L21:
        AppletSnapshotManagerService r16 = AppletSnapshotManagerService.a;
        AppletSnapshotManagerService.b(r15, r10);
        return;
    L17:
        r15 = null;
        goto L18
    L8:
        if (r12.isAdded() == false) goto L10;
        r13 = true;
        goto L11
    L13:
        r11 = null;
        goto L14
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.g
    public final void M0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "responseMessageId");
        this.c.c("chatInput didReceiveReplyMessage: responseMessageId=" + r10);
        String r1 = this.u;
        if (r1 != null) goto L6;
        this.c.a("didReceiveReplyMessage: currentChatInputMethod is null, skip track", null);
        return;
    L6:
        AppletApplication r11 = this.e;
        if (r11 == null) goto L14;
        v r12 = r11.h();
        if (r12 == null) goto L15;
        com.bytedance.ai.applet.app.foundation.j r13 = r12.e();
        if (r13 == null) goto L16;
        Intrinsics.checkNotNullParameter(r10, "responseMessageId");
        Intrinsics.checkNotNullParameter(r1, "sendMethod");
        r13.i("doubao_apps_chat_receive_stream", MapsKt.mapOf(new Pair[]{TuplesKt.to("chat_response_message_id", r10), TuplesKt.to("send_method", r1)}));
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.c
    public final void P0(r2.f r10) {
        Intrinsics.checkNotNullParameter(r10, "panelInfo");
        int r1 = r3.c.a;
        AppletApplication r11 = this.e;
        if (r11 == null) goto L5;
        String r12 = r11.getAppId();
    L6:
        Intrinsics.checkNotNullParameter(r10, "panelInfo");
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("ChatPanelHeightChangedEventPublisher", "publish: appletId=" + r12 + ", panelInfo=" + r10);
        if (r12 != null) goto L9;
    L12:
        boolean r13 = true;
    L13:
        if (r13 == true) goto L30;
        JsonObject r14 = new JsonObject();
        r14.addProperty("height", Integer.valueOf((int) n2.a.c(Integer.valueOf(r10.a))));
        int r15 = r3.d.a[r10.b.ordinal()];
        if (r15 != 1) goto L18;
        String r16 = "collapsed";
    L28:
        r14.addProperty("state", r16);
        l3.a r17 = new l3.a("doubao.chatPanelHeightChanged", r14, 4);
        r17.d = r12;
        l3.d.c(r17);
        return;
    L18:
        if (r15 != 2) goto L20;
        r16 = "preview";
        goto L28
    L20:
        if (r15 == 3) goto L25;
        if (r15 != 4) goto L24;
        r16 = "invisible";
        goto L28
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r16 = "expanded";
        goto L28
    L30:
        return;
    L9:
        if (r12.length() == 0) goto L12;
        r13 = false;
        goto L13
    L5:
        r12 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final boolean P1(Integer r10) {
        Object r1 = getSystemService(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Exception -> L45
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L45
        List<ActivityManager.AppTask> r11 = ((ActivityManager) r1).getAppTasks();     // Catch: Exception -> L45
        if (r10 != null) goto L6;
    L11:
        Integer r12 = null;
    L12:
        if (r12 == null) goto L25;
        int r13 = r12.intValue();     // Catch: Exception -> L45
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L45
        Iterator<T> r14 = r11.iterator();     // Catch: Exception -> L45
    L15:
        if (r14.hasNext() == false) goto L22;
        Object r15 = r14.next();     // Catch: Exception -> L45
        if (((ActivityManager.AppTask) r15).getTaskInfo().id != r13) goto L19;
        boolean r16 = true;
    L20:
        if (r16 == false) goto L15;
    L23:
        ActivityManager.AppTask r17 = (ActivityManager.AppTask) r15;     // Catch: Exception -> L45
        if (r17 == null) goto L25;
    L42:
        if (r17 != null) goto L47;
        AtomicInteger r18 = com.bytedance.ai.applet.base.log.d.d;     // Catch: Exception -> L45
        this.c.a("hostTaskMoveToFront: host task not found, preferredTaskId=" + r10, null);     // Catch: Exception -> L45
        return false;
    L47:
        this.c.c("hostTaskMoveToFront: preferredTaskId=" + r10 + ", targetTaskId=" + r17.getTaskInfo().id);     // Catch: Exception -> L45
        r17.moveToFront();     // Catch: Exception -> L45
        return true;
    L19:
        r16 = false;
        goto L20
    L22:
        r15 = null;
    L25:
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L45
        Iterator<T> r19 = r11.iterator();     // Catch: Exception -> L45
    L27:
        if (r19.hasNext() == false) goto L40;
        Object r20 = r19.next();     // Catch: Exception -> L45
        ComponentName r21 = ((ActivityManager.AppTask) r20).getTaskInfo().baseIntent.getComponent();     // Catch: Exception -> L45
        if (r21 == null) goto L31;
        String r22 = r21.getClassName();     // Catch: Exception -> L45
    L33:
        if (Intrinsics.areEqual(r22, AppletFullScreenActivity.class.getName()) == false) goto L35;
    L37:
        boolean r23 = false;
    L38:
        if (r23 == false) goto L27;
    L41:
        r17 = (ActivityManager.AppTask) r20;     // Catch: Exception -> L45
        goto L42
    L35:
        if (Intrinsics.areEqual(r22, AppletAppActivity.class.getName()) == true) goto L37;
        r23 = true;
        goto L38
    L31:
        r22 = null;
        goto L33
    L40:
        r20 = null;
        goto L41
    L6:
        if (r10.intValue() == getTaskId()) goto L8;
        boolean r24 = true;
    L9:
        if (r24 == false) goto L11;
        r12 = r10;
        goto L12
    L8:
        r24 = false;
    L45:
        e = move-exception;
        this.c.a("Failed to move host task to front", e);
        return false;
    }

    public final boolean h2(Activity r10) {
        WeakReference<Activity> r0 = this.r;
        if (r0 == null) goto L5;
        Activity r1 = r0.get();
    L6:
        if (r1 == r10) goto L8;
    L10:
        return false;
    L8:
        if (i2(r10) == false) goto L10;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i2(Activity r10) {
        if (r10.getTaskId() != getTaskId()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L16;
        int r1 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r11 = Integer.valueOf(r10.orientation);     // Catch: Throwable -> L14
        if (r11 != null) goto L9;
    L11:
        if (r1 != 3) goto L16;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:AppletFullScreenActivity portrait");     // Catch: Throwable -> L14
        goto L16
    L9:
        if (r11.intValue() != r1) goto L11;
    L16:
        k2();
        AppletAppActionBar r12 = (AppletAppActionBar) findViewById(2131363132);
        if (r12 == null) goto L22;
        int r0 = AppletAppActionBar.v;
        r12.a(false);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r10);
        if (isFinishing() == true) goto L57;
        LinkedList<AppletAppActivity> r0 = com.bytedance.ai.applet.services.b.a;
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        LinkedList<AppletAppActivity> r1 = com.bytedance.ai.applet.services.b.a;
        r1.add(this);
        if (r1.size() <= 5) goto L35;
        com.bytedance.ai.applet.base.log.a.c("AppletActivityManagerService", "onActivityCreated: activities.size > MAX_ACTIVITY_COUNT, destroy activity");
        Map<AppletAppActivity, Long> r11 = com.bytedance.ai.applet.services.b.b;
        if (r11.isEmpty() == false) goto L18;
        com.bytedance.ai.applet.base.log.a.b("AppletActivityManagerService", "findDestroyActivity: no stopped activity", null);
    L32:
        AppletAppActivity r12 = null;
    L33:
        if (r12 == null) goto L35;
        r12.B1();
        goto L35
    L18:
        List r13 = CollectionsKt.sortedWith(MapsKt.toList(r11), new com.bytedance.ai.applet.services.a());
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L29;
        r12 = (AppletAppActivity) ((Pair) r14.next()).component1();
        AppletApplication r15 = r12.e;
        if (r15 != null) goto L24;
    L26:
        boolean r16 = false;
    L27:
        if (r16 == false) goto L20;
    L24:
        if ((!r15.k.isEmpty()) == true) goto L26;
        r16 = true;
        goto L27
    L29:
        com.bytedance.ai.applet.base.log.a.c("AppletActivityManagerService", "findDestroyActivity: all activities are kept alive, destroy the earliest one");
        Pair r17 = (Pair) CollectionsKt.firstOrNull(r13);
        if (r17 == null) goto L32;
        r12 = (AppletAppActivity) r17.getFirst();
    L35:
        updateSourceTask(getIntent());
        if (r10 == null) goto L39;
        this.w = true;
    L39:
        if (this.p != null) goto L58;
        this.c.c("registerTaskStackLifecycleCallbacks: taskId=" + getTaskId());
        this.p = new s(this);
        Context r18 = getApplicationContext();
        if ((r18 instanceof Application) == false) goto L44;
        Application r19 = (Application) r18;
    L45:
        if (r19 != null) goto L47;
        this.c.a("registerTaskStackLifecycleCallbacks: applicationContext is not Application", null);
        this.p = null;
        return;
    L47:
        r19.registerActivityLifecycleCallbacks(this.p);
        return;
    L44:
        r19 = null;
        goto L45
    L58:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void onNewIntent(Intent r10) {
        super.onNewIntent(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        if (isFinishing() == true) goto L21;
        Uri r0 = r10.getData();
        String r1 = null;
        if (r0 == null) goto L10;
        String r11 = r0.toString();
    L11:
        if (r11 == null) goto L17;
        AppletApplication r12 = this.e;
        if (r12 == null) goto L16;
        r1 = r12.getAppId();
    L16:
        if (Intrinsics.areEqual(r11, r1) == true) goto L17;
        return;
    L17:
        updateSourceTask(r10);
        return;
    L10:
        r11 = null;
        goto L11
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void onNightModeChanged(int r10) {
        super.onNightModeChanged(r10);
        AppletAppActionBar r11 = (AppletAppActionBar) findViewById(2131363132);
        if (r11 == null) goto L6;
        r11.a(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateSourceTask(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.hasExtra("launch_source_task_id") == false) goto L10;
        Integer r1 = Integer.valueOf(r10.getIntExtra("launch_source_task_id", -1));
        if (r1.intValue() < 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
    L11:
        if (r1 != null) goto L13;
    L16:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (((RouteAction) r10.getParcelableExtra("route_action")) != null) goto L20;
        this.w = false;
        this.c.c("updateSourceTask: external launch");
        return;
    L20:
        this.c.c("updateSourceTask: keep sourceTaskId=" + this.v + ", launchSourceTaskId=" + r1);
        return;
    L13:
        if (r1.intValue() == getTaskId()) goto L16;
        this.v = r1;
        this.w = false;
        this.c.c("updateSourceTask: sourceTaskId=" + this.v);
        return;
    L7:
        r11 = false;
    L10:
        r1 = null;
        goto L11
    }

    public static final void c2(AppletFullScreenActivity r10, Activity r11) {
        if (r10.h2(r11) == true) goto L6;
        return;
    L6:
        if (r11.isFinishing() == true) goto L8;
        return;
    L8:
        if (r11.isChangingConfigurations() == true) goto L14;
        r11.overridePendingTransition(0, 2130772040);
        r10.c.c("applyActivityExitAnimation: activity=" + r11.getClass().getSimpleName() + ", taskId=" + r11.getTaskId());
        return;
    }

    public static final void d2(AppletFullScreenActivity r10, Activity r11) {
        if (r10.s == true) goto L5;
        return;
    L5:
        if (r10.h2(r11) == false) goto L13;
        r10.s = false;
        if (r11.isFinishing() == true) goto L14;
        r11.overridePendingTransition(2130772038, 0);
        r10.c.c("applyActivityEnterAnimation: activity=" + r11.getClass().getSimpleName() + ", taskId=" + r11.getTaskId());
        return;
    L14:
        return;
    }

    public static final void e2(AppletFullScreenActivity r10, Activity r11) {
        if (r10.h2(r11) == false) goto L7;
        r11.getWindow().setWindowAnimations(2131951703);
        r10.c.c("applyTaskActivityAnimations: activity=" + r11.getClass().getSimpleName() + ", taskId=" + r11.getTaskId());
        return;
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.g
    public final void A0(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "localMessageId");
        Intrinsics.checkNotNullParameter(r11, "messageId");
        this.c.c("chatInput didSendMessage: localMessageId=" + r10 + ", messageId=" + r11);
        AppletSnapshotManagerService r1 = AppletSnapshotManagerService.a;
        AppletSnapshotManagerService.a(r10, r11);
        String r12 = this.u;
        if (r12 != null) goto L6;
        this.c.a("didSendMessage: currentChatInputMethod is null, skip track", null);
        return;
    L6:
        AppletApplication r13 = this.e;
        if (r13 == null) goto L14;
        v r14 = r13.h();
        if (r14 == null) goto L15;
        com.bytedance.ai.applet.app.foundation.j r15 = r14.e();
        if (r15 == null) goto L16;
        Intrinsics.checkNotNullParameter(r11, "messageId");
        Intrinsics.checkNotNullParameter(r12, "sendMethod");
        r15.f = r11;
        r15.i("doubao_apps_chat_send_message", MapsKt.mapOf(TuplesKt.to("send_method", r12)));
        return;
    L16:
        return;
    L15:
        return;
    }
}
