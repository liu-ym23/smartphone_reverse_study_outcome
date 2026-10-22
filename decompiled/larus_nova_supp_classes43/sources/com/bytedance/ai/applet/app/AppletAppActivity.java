package com.bytedance.ai.applet.app;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.BaseActivity;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.RouteAction;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceOutcome;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001b\b&\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0087\u0001\u0088\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H$J\b\u0010'\u001a\u00020&H$J\b\u0010(\u001a\u00020&H\u0014J\b\u0010)\u001a\u00020&H\u0014J\u0015\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b-J\u0012\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u0017H\u0002J\u0012\u00103\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\u0013H\u0014J\b\u0010;\u001a\u00020&H\u0002J\u0012\u0010<\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u000105H\u0002J'\u0010=\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B¢\u0006\u0004\bC\u0010DJ\b\u0010E\u001a\u00020&H\u0014J\b\u0010F\u001a\u00020&H\u0014J\b\u0010G\u001a\u00020&H\u0014J\u0010\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u000200H\u0014J\b\u0010J\u001a\u00020&H\u0014J\b\u0010K\u001a\u00020&H\u0016J\r\u0010L\u001a\u00020&H\u0010¢\u0006\u0002\bMJ\b\u0010N\u001a\u00020&H\u0016J\b\u0010O\u001a\u00020&H\u0016J\u0011\u0010P\u001a\u0004\u0018\u00010QH\u0000¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\bUJ\u0012\u0010V\u001a\u00020&2\b\u0010W\u001a\u0004\u0018\u00010\u0017H\u0002J\u0019\u0010X\u001a\u00020\u00152\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010ZJ!\u0010[\u001a\b\u0012\u0004\u0012\u00020&0>2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\b^\u0010_J)\u0010`\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\ba\u0010bJ)\u0010c\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bd\u0010bJ)\u0010e\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bf\u0010bJ1\u0010g\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010:\u001a\u00020h2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bi\u0010jJ\u001a\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u0015H\u0002J/\u0010n\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010o\u001a\u00020l2\u0006\u0010W\u001a\u00020\u00172\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bp\u0010qJ\b\u0010r\u001a\u00020&H\u0002J\u001d\u0010s\u001a\u00020&2\u0006\u0010t\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\buJ\u0018\u0010v\u001a\u00020&2\u0006\u0010t\u001a\u00020\u00192\u0006\u0010w\u001a\u00020\u0015H\u0002J\u0010\u0010x\u001a\u00020&2\u0006\u00102\u001a\u00020\u0017H\u0002J\u001b\u0010y\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010z\u001a\u00020\u0013¢\u0006\u0004\b{\u0010|J\u001a\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170~0>¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\f\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0084.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X \u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006\u0089\u0001"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletAppActivity;", "Lcom/bytedance/ai/applet/app/base/BaseActivity;", "<init>", "()V", "logger", "Lcom/bytedance/ai/applet/base/log/InstanceLogger;", "getLogger", "()Lcom/bytedance/ai/applet/base/log/InstanceLogger;", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Lcom/bytedance/ai/api/model/ability/IAIAbilities;", "abilities", "getAbilities", "()Lcom/bytedance/ai/api/model/ability/IAIAbilities;", "_application", "Lcom/bytedance/ai/applet/app/AppletApplication;", "application", "getApplication", "()Lcom/bytedance/ai/applet/app/AppletApplication;", "appliedNightMode", "", "hasRootPage", "", "currentPagePathSnapshot", "", "initialPageStateSource", "Landroidx/fragment/app/Fragment;", "rootBackPressedCallback", "com/bytedance/ai/applet/app/AppletAppActivity$rootBackPressedCallback$1", "Lcom/bytedance/ai/applet/app/AppletAppActivity$rootBackPressedCallback$1;", "chatInputController", "Lcom/bytedance/ai/applet/components/input/AppletChatInputController;", "getChatInputController$ai_sdk_release", "()Lcom/bytedance/ai/applet/components/input/AppletChatInputController;", "showMode", "Lcom/bytedance/ai/applet/app/AppletShowMode;", "getShowMode$ai_sdk_release", "()Lcom/bytedance/ai/applet/app/AppletShowMode;", "handleRootBackPressed", "", "setupHostContent", "onHostThemeChanged", "destroyHostAuxiliaryContentNow", "onCurrentPageContentStateChanged", "state", "Lcom/bytedance/ai/applet/app/AppletPageContentState;", "onCurrentPageContentStateChanged$ai_sdk_release", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "failHostCreation", com.bytedance.android.ec.core.event.a.KEY_MSG, "onNewIntent", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onNightModeChanged", "mode", "checkThemChanged", "handleIntent", "performRouteAction", "Lkotlin/Result;", "action", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "receiver", "Landroid/os/ResultReceiver;", "performRouteAction-gIAlu-s", "(Lcom/bytedance/ai/applet/app/foundation/RouteAction;Landroid/os/ResultReceiver;)Ljava/lang/Object;", "onStart", "onResume", "onStop", "onSaveInstanceState", "outState", "onDestroy", "finish", "closeAppView", "closeAppView$ai_sdk_release", "showChatInput", "hideChatInput", "currentPageTraceId", "", "currentPageTraceId$ai_sdk_release", "()Ljava/lang/Long;", "currentPagePath", "currentPagePath$ai_sdk_release", "updateCurrentPagePath", com.bytedance.android.ec.core.event.a.KEY_URL, "hostTaskMoveToFront", "preferredTaskId", "(Ljava/lang/Integer;)Z", "launch", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "launch-IoAF18A", "(Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "navigateTo", "navigateTo-gIAlu-s", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "redirectTo", "redirectTo-gIAlu-s", "reLaunch", "reLaunch-gIAlu-s", "openPage", "Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "openPage-0E7RQCE", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "findReusablePage", "Lcom/bytedance/ai/applet/app/AppletAppActivity$ReusablePage;", "topOnly", "reusePage", "reusablePage", "reusePage-0E7RQCE", "(Lcom/bytedance/ai/applet/app/AppletAppActivity$ReusablePage;Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "destroyAllPageFragmentsNow", "updatePageContentState", "fragment", "updatePageContentState$ai_sdk_release", "markInitialPageLoadingIfNeeded", "isInitialPage", "showInitialPageCreationErrorIfNeeded", "navigateBack", "delta", "navigateBack-IoAF18A", "(I)Ljava/lang/Object;", "getCurrentPageRoutes", "", "getCurrentPageRoutes-d1pmJ48", "()Ljava/lang/Object;", "reLaunchApp", "Lkotlinx/coroutines/Job;", "getMenuButton", "Landroid/view/View;", "getMenuButtonBoundingClientRect", "Landroid/graphics/Rect;", "Companion", "ReusablePage", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppletAppActivity extends BaseActivity {
    public static final /* synthetic */ int j = 0;
    public final com.bytedance.ai.applet.base.log.d c;
    public g2.b d;
    public AppletApplication e;
    public int f;
    public boolean g;
    public volatile String h;
    public Fragment i;

    public static final class a {
    }

    public static final class b {
        public final Fragment a;
        public final int b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "ReusablePage(fragment=" + this.a + ", pagesAbove=" + this.b + ')';
        }

        public b(Fragment r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "fragment");
            this.a = r10;
            this.b = r11;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ApplicationRouter.OpenPageMode.values().length];
            r0[ApplicationRouter.OpenPageMode.PUSH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ApplicationRouter.OpenPageMode.REPLACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ApplicationRouter.OpenPageMode.NAVIGATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ApplicationRouter.OpenPageMode.POP_TO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public void D1() {
    }

    public AppletChatInputController H1() {
        return null;
    }

    public View I1() {
        return null;
    }

    public abstract AppletShowMode L1();

    public abstract void N1();

    public void S1(t r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
    }

    public void T1() {
    }

    public abstract void Y1();

    public void B1() {
        this.c.c("closeAppView:");
        finish();
    }

    public Rect K1() {
        return new Rect();
    }

    public void O1() {
        com.bytedance.ai.applet.base.log.d.d(this.c, "hideChatInput: unsupported by ".concat(getClass().getSimpleName()));
    }

    public void Z1() {
        com.bytedance.ai.applet.base.log.d.d(this.c, "showChatInput: unsupported by ".concat(getClass().getSimpleName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.base.BaseActivity
    public void finish() {
        this.c.c("finish:");
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r10 = FLogger.a;
        r10.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r10.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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
    @Override // com.bytedance.ai.applet.app.base.BaseActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        this.c.c("onDestroy:");
        this.i = null;
        this.h = null;
        AppletApplication r0 = this.e;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(this, "context");
        r0.i().c("onActivityDestroy");
        r0.u(this);
        if (r0.j == false) goto L11;
        r0.i().c("onActivityDestroy, terminating, need uninstall");
        r0.g();
        goto L13
    L11:
        if (r0.e() == false) goto L13;
        r0.i().c("onActivityDestroy, canDestroy is true, schedule destruction");
        r0.H();
    L13:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        this.c.c("onResume:");
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        A1();
        AppletApplication r0 = this.e;
        if (r0 == null) goto L6;
        r0.y(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStop() {
        this.c.c("onStop:");
        super.onStop();
        AppletApplication r0 = this.e;
        if (r0 == null) goto L6;
        r0.B(this);
        return;
    }

    public AppletAppActivity() {
        this.c = new com.bytedance.ai.applet.base.log.d("AppletAppActivity", null);
        OnBackPressedCallback r0 = new AppletAppActivity$rootBackPressedCallback$1(this);
        getOnBackPressedDispatcher().addCallback(r0);
    }

    public final void A1() {
        int r0 = getResources().getConfiguration().uiMode & 48;
        if (r0 != this.f) goto L5;
        return;
    L5:
        this.c.c("checkThemChanged: mode = " + r0);
        this.f = r0;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r1 = AppletRuntimeManager.d;
        if (r1 != null) goto L8;
    L12:
        T1();
        return;
    L8:
        if (r0 != 32) goto L10;
        boolean r10 = true;
    L11:
        r1.b(r10);
        goto L12
    L10:
        r10 = false;
        goto L11
    }

    public final Long C1() {
        List r0 = getSupportFragmentManager().getFragments();
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L13;
        Object r10 = r1.previous();
        Fragment r11 = (Fragment) r10;
        if (r11.getId() == 2131363104) goto L8;
    L10:
        boolean r12 = false;
    L11:
        if (r12 == false) goto L4;
    L14:
        Fragment r13 = (Fragment) r10;
        if (r13 != null) goto L17;
        return null;
    L17:
        return t2.b.b(r13);
    L8:
        if (r11.isAdded() == false) goto L10;
        r12 = true;
        goto L11
    L13:
        r10 = null;
        goto L14
    }

    public void onStart() {
        super.onStart();
        A1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F1(String r10) {
        AtomicInteger r11 = com.bytedance.ai.applet.base.log.d.d;
        this.c.a("onCreate: " + r10, null);
        Intent r0 = getIntent();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        ResultReceiver r1 = (ResultReceiver) r0.getParcelableExtra("route_result_receiver");
        if (r1 == null) goto L5;
        com.bytedance.ai.applet.app.foundation.i.a(r1, r10);
    L5:
        B1();
    }

    public final void M1(Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RouteAction r1 = (RouteAction) r10.getParcelableExtra("route_action");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ResultReceiver r11 = (ResultReceiver) r10.getParcelableExtra("route_result_receiver");
        if (r1 == null) goto L7;
        Result.box-impl(U1(r1, r11));
        return;
    L7:
        this.c.c("handleIntent: action is null");
    }

    public boolean P1(Integer r10) {
        com.bytedance.ai.applet.base.log.d.d(this.c, "hostTaskMoveToFront: unsupported by ".concat(getClass().getSimpleName()));
        return false;
    }

    public final Object Q1(int r10) {
        String r0 = null;
        if (r10 > 0) goto L6;
        AtomicInteger r11 = com.bytedance.ai.applet.base.log.d.d;
        this.c.a("navigateBack: delta must be a positive number, but was " + r10, null);
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("delta must be a positive number.")));
    L6:
        int r1 = getSupportFragmentManager().getBackStackEntryCount();
        if (r1 != 0) goto L10;
        this.c.c("navigateBack: back stack is empty, handle root back press");
        N1();
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L10:
        int r14 = getSupportFragmentManager().getBackStackEntryAt(r1 - Math.min(r10, r1)).getId();
        if (getSupportFragmentManager().popBackStackImmediate(r14, 1) == false) goto L28;
        List r15 = getSupportFragmentManager().getFragments();
        ListIterator r16 = r15.listIterator(r15.size());
    L14:
        if (r16.hasPrevious() == false) goto L23;
        Object r17 = r16.previous();
        Fragment r18 = (Fragment) r17;
        if (r18.getId() == 2131363104) goto L18;
    L20:
        boolean r19 = false;
    L21:
        if (r19 == false) goto L14;
    L24:
        Fragment r20 = (Fragment) r17;
        if (r20 == null) goto L27;
        r0 = t2.b.c(r20);
    L27:
        b2(r0);
        Result.Companion r21 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L18:
        if (r18.isAdded() == false) goto L20;
        r19 = true;
        goto L21
    L23:
        r17 = null;
        goto L24
    L28:
        AtomicInteger r22 = com.bytedance.ai.applet.base.log.d.d;
        this.c.a("navigateBack: popBackStackImmediate failed for entryId " + r14, null);
        Result.Companion r23 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Failed to navigate back.")));
    }

    public final void a2(String r10) {
        if (this.g == false) goto L5;
        return;
    L5:
        if (this.i != null) goto L9;
        S1(new t.b(r10));
        return;
    }

    public final void b2(String r10) {
        String r0 = null;
        if (r10 == null) goto L12;
        String r11 = t2.c.a(r10);
        if (r11 == null) goto L12;
        if (r11.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        r0 = r11;
        goto L12
    L9:
        r1 = false;
    L12:
        this.h = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.base.BaseActivity
    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L16;
        int r11 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r12 = Integer.valueOf(r10.orientation);     // Catch: Throwable -> L14
        if (r12 != null) goto L9;
    L11:
        if (r11 != 3) goto L16;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L14
        goto L16
    L9:
        if (r12.intValue() != r11) goto L11;
    L16:
        this.c.c("onConfigurationChanged: uiMode = " + r10.uiMode);
        A1();
        return;
    L14:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.base.BaseActivity
    public void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        this.c.c("onCreate:");
        super.onCreate(null);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r1 = AppletRuntimeManager.d;
        if (r1 != null) goto L13;
        F1("aiAbility is null");
        return;
    L13:
        this.d = r1;
        Uri r11 = getIntent().getData();
        if (r11 == null) goto L16;
        String r12 = r11.toString();
    L17:
        if (r12 != null) goto L19;
    L22:
        boolean r13 = true;
    L23:
        if (r13 == false) goto L25;
        F1("appId is empty");
        return;
    L25:
        this.c.c("onCreate: appId = " + r12);
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r14 = AppletAppManagerService.a(r12);
        if (r14 != null) goto L28;
        F1("appId not found: ".concat(r12));
        return;
    L28:
        this.e = r14;
        r14.r(this);
        Y1();
        if (r10 == null) goto L31;
        String r15 = r10.getString("restored_launch_url");
    L32:
        if (r15 == null) goto L34;
        this.c.c("onCreate: restoring launch url = ".concat(r15));
        Result.box-impl(R1(r15, null));
        return;
    L34:
        M1(getIntent());
        return;
    L31:
        r15 = null;
        goto L32
    L19:
        if (r12.length() == 0) goto L22;
        r13 = false;
        goto L23
    L16:
        r12 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent r10) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r10);
        if (r10 == null) goto L7;
        Uri r1 = r10.getData();
        if (r1 == null) goto L7;
        String r11 = r1.toString();
    L8:
        AppletApplication r12 = this.e;
        if (r12 == null) goto L11;
        String r13 = r12.getAppId();
    L12:
        if (r11 != null) goto L14;
    L19:
        M1(r10);
        return;
    L14:
        if (Intrinsics.areEqual(r11, r13) == true) goto L19;
        String r14 = "onNewIntent: appId mismatch, currentAppId=" + r13 + ", incomingAppId=" + r11 + ", taskId=" + getTaskId();
        com.bytedance.ai.applet.base.log.d r15 = this.c;
        AtomicInteger r16 = com.bytedance.ai.applet.base.log.d.d;
        r15.a(r14, null);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ResultReceiver r17 = (ResultReceiver) r10.getParcelableExtra("route_result_receiver");
        if (r17 == null) goto L21;
        com.bytedance.ai.applet.app.foundation.i.a(r17, r14);
        return;
    L21:
        return;
    L11:
        r13 = null;
    L7:
        r11 = null;
        goto L8
    }

    public void onNightModeChanged(int r10) {
        super.onNightModeChanged(r10);
        this.c.c("onNightModeChanged: mode = " + r10);
        A1();
    }

    public final void onSaveInstanceState(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outState");
        Iterator r0 = getSupportFragmentManager().getFragments().iterator();
    L3:
        String r11 = null;
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        Fragment r12 = (Fragment) r1;
        if (r12.getId() == 2131363104) goto L8;
    L10:
        boolean r13 = false;
    L11:
        if (r13 == false) goto L3;
    L14:
        Fragment r14 = (Fragment) r1;
        if (r14 == null) goto L17;
        r11 = t2.b.c(r14);
    L17:
        if (r11 == null) goto L19;
        this.c.c("onSaveInstanceState: launchUrl=".concat(r11));
        r10.putString("restored_launch_url", r11);
    L19:
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r10);
        return;
    L8:
        if (r12.isAdded() == false) goto L10;
        r13 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.ai.applet.app.e] */
    public final b G1(String r11, boolean r12) {
        final AppletApplication r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        final Page r13 = r0.j().q(r11);
        if (r13 != null) goto L8;
        return null;
    L8:
        List r10 = getSupportFragmentManager().getFragments();
        ArrayList r14 = new ArrayList();
        Iterator r15 = r10.iterator();
    L9:
        boolean r16 = false;
        if (r15.hasNext() == false) goto L18;
        Object r17 = r15.next();
        Fragment r18 = (Fragment) r17;
        if (r18.getId() == 2131363104) goto L14;
    L16:
        if (r16 == false) goto L9;
        r14.add(r17);
        goto L9
    L14:
        if (r18.isAdded() == false) goto L16;
        r16 = true;
        goto L16
    L18:
        ?? r19 = new e(r0, r13);
        if (r12 == false) goto L27;
        Integer r110 = Integer.valueOf(CollectionsKt.getLastIndex(r14));
        int r111 = r110.intValue();
        if (r111 >= 0) goto L23;
    L25:
        if (r16 == true) goto L40;
    L39:
        r110 = null;
    L40:
        if (r110 == null) goto L43;
        int r112 = r110.intValue();
        return new b((Fragment) ListProtector.get(r14, r112), CollectionsKt.getLastIndex(r14) - r112);
    L43:
        return null;
    L23:
        if (((Boolean) r19.invoke(ListProtector.get(r14, r111))).booleanValue() == false) goto L25;
        r16 = true;
        goto L25
    L27:
        ListIterator r113 = r14.listIterator(r14.size());
    L29:
        if (r113.hasPrevious() == false) goto L33;
        if (((Boolean) r19.invoke(r113.previous())).booleanValue() == false) goto L29;
        int r114 = r113.nextIndex();
    L34:
        r110 = Integer.valueOf(r114);
        if (r110.intValue() < 0) goto L37;
        r16 = true;
    L37:
        if (r16 == false) goto L39;
    L33:
        r114 = -1;
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object R1(String r10, RouteOptions r11) {
        AppletApplication r0 = this.e;
        if (r0 == null) goto L5;
        Fragment r12 = r0.t(this, r10, r11);
    L6:
        if (r12 != null) goto L9;
        String r13 = "Failed to create page for url: " + r10;
        AtomicInteger r14 = com.bytedance.ai.applet.base.log.d.d;
        this.c.a("navigateTo: fragment is null, openPath = " + r10, null);
        a2(r13);
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r13)));
    L9:
        t2.b.d(r12, r10);
        boolean r1 = !this.g;
        if (r1 == true) goto L12;
    L15:
        FragmentTransaction r16 = getSupportFragmentManager().beginTransaction();
        if (r1 == true) goto L19;
        r16.setCustomAnimations(2130772038, 2130772039, 2130772037, 2130772040);
    L19:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131363104) == true) goto L22;
        r16.add(2131363104, r12);
    L22:
        if (r1 == true) goto L24;
        r16.addToBackStack(null);
    L24:
        r16.commitAllowingStateLoss();
        this.g = true;
        b2(r10);
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L12:
        if (this.i != null) goto L15;
        this.i = r12;
        S1(t.c.a);
        goto L15
    L5:
        r12 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object U1(RouteAction r18, ResultReceiver r19) {
        Intrinsics.checkNotNullParameter(r18, "action");
        this.c.c("performRouteAction: performing action: " + r18);
        RouteOptions r10 = r18.a();
        if (r10 == null) goto L13;
        Long r11 = r10.b;
        if (r11 == null) goto L13;
        long r12 = r11.longValue();
        AppletApplication r13 = this.e;
        if (r13 == null) goto L13;
        v r14 = r13.h();
        if (r14 == null) goto L13;
        com.bytedance.ai.applet.app.foundation.performance.c r15 = r14.c();
        if (r15 == null) goto L13;
        com.bytedance.ai.applet.app.foundation.performance.r r16 = r15.f(r12);
    L14:
        if (r16 == null) goto L16;
        r16.t();
    L16:
        boolean r17 = true;
        if ((r18 instanceof RouteAction.Launch) == false) goto L41;
        RouteOptions r20 = ((RouteAction.Launch) r18).a;
        if (this.g == false) goto L33;
        if (r20 == null) goto L32;
        Long r21 = r20.b;
        if (r21 == null) goto L32;
        long r22 = r21.longValue();
        AppletApplication r23 = this.e;
        if (r23 == null) goto L32;
        v r24 = r23.h();
        if (r24 == null) goto L32;
        com.bytedance.ai.applet.app.foundation.performance.c r25 = r24.c();
        if (r25 == null) goto L32;
        com.bytedance.ai.applet.app.foundation.performance.r r110 = r25.f(r22);
        if (r110 == null) goto L32;
        AtomicLong r26 = com.bytedance.ai.applet.app.foundation.performance.k.g;
        com.bytedance.ai.applet.app.foundation.performance.k.d(r110, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "cancelled", 2);
    L32:
        Result.Companion r27 = Result.Companion;
        Object r28 = Result.constructor-impl(Unit.INSTANCE);
    L91:
        if (Result.isSuccess-impl(r28) == false) goto L115;
        Unit r29 = (Unit) r28;
        this.c.c("performRouteAction: action " + r18 + " performed successfully");
        RouteOptions r30 = r18.a();
        if (r30 == null) goto L95;
        String r31 = r30.a;
    L96:
        if (r31 != null) goto L98;
    L101:
        if (r17 == true) goto L113;
        this.c.c("performRouteAction: conversationId = " + r31);
        AppletApplication r32 = this.e;
        if (r32 == null) goto L113;
        v r33 = r32.h();
        if (r33 == null) goto L113;
        com.bytedance.ai.applet.app.foundation.a r34 = r33.b();
        if (r34 == null) goto L113;
        Intrinsics.checkNotNullParameter(r31, "conversationId");
        r34.b = r31;
        AppletAppActivity r35 = r34.a.d;
        if (r35 == null) goto L113;
        AppletChatInputController r36 = r35.H1();
        if (r36 == null) goto L113;
        r36.q7(r31);
    L113:
        if (r19 == null) goto L115;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        r19.send(0, null);
        goto L115
    L98:
        if (r31.length() == 0) goto L101;
        r17 = false;
        goto L101
    L95:
        r31 = null;
    L115:
        Throwable r37 = Result.exceptionOrNull-impl(r28);
        if (r37 == null) goto L125;
        this.c.a("performRouteAction: action " + r18 + " performed with error: " + r37.getMessage(), null);
        if (r16 == null) goto L123;
        AppletPerformanceErrorCode r1 = AppletPerformanceErrorCode.ROUTE_ERROR;
        String r38 = r37.getMessage();
        if (r38 != null) goto L122;
        r38 = r37.getClass().getSimpleName();
    L122:
        r16.c(r1, r38);
    L123:
        if (r19 == null) goto L125;
        com.bytedance.ai.applet.app.foundation.i.a(r19, r37.getMessage());
    L125:
        return r28;
    L33:
        AppletApplication r39 = this.e;
        if (r39 != null) goto L36;
        com.bytedance.ai.applet.base.log.d r40 = this.c;
        AtomicInteger r41 = com.bytedance.ai.applet.base.log.d.d;
        r40.a("launch: application is null", null);
        Result.Companion r42 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("application is null")));
        goto L91
    L36:
        String r43 = r39.j().O;
        if (StringsKt.isBlank(r43) == false) goto L39;
        r43 = "index";
    L39:
        r28 = R1(r43, r20);
        goto L91
    L41:
        if ((r18 instanceof RouteAction.NavigateTo) == false) goto L44;
        RouteAction.NavigateTo r44 = (RouteAction.NavigateTo) r18;
        r28 = R1(r44.a, r44.b);
        goto L91
    L44:
        if ((r18 instanceof RouteAction.RedirectTo) == false) goto L47;
        RouteAction.RedirectTo r45 = (RouteAction.RedirectTo) r18;
        r28 = W1(r45.a, r45.b);
        goto L91
    L47:
        if ((r18 instanceof RouteAction.ReLaunch) == false) goto L66;
        RouteAction.ReLaunch r46 = (RouteAction.ReLaunch) r18;
        String r47 = r46.a;
        RouteOptions r48 = r46.b;
        AppletApplication r49 = this.e;
        if (r49 == null) goto L51;
        Fragment r50 = r49.t(this, r47, r48);
    L52:
        if (r50 != null) goto L54;
        String r51 = "Failed to create page for url: " + r47;
        this.c.a("reLaunch: fragment is null, openPath = " + r47, null);
        a2(r51);
        Result.Companion r52 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r51)));
        goto L91
    L54:
        t2.b.d(r50, r47);
        if ((!this.g) == true) goto L57;
    L60:
        getSupportFragmentManager().popBackStackImmediate(null, 1);
        FragmentTransaction r53 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r53, r50, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131363104) == true) goto L64;
        r53 = r53.replace(2131363104, r50);
    L64:
        r53.commitAllowingStateLoss();
        this.g = true;
        b2(r47);
        Result.Companion r54 = Result.Companion;
        r28 = Result.constructor-impl(Unit.INSTANCE);
        goto L91
    L57:
        if (this.i != null) goto L60;
        this.i = r50;
        S1(t.c.a);
        goto L60
    L51:
        r50 = null;
        goto L52
    L66:
        if ((r18 instanceof RouteAction.OpenPage) == false) goto L127;
        RouteAction.OpenPage r55 = (RouteAction.OpenPage) r18;
        String r56 = r55.a;
        ApplicationRouter.OpenPageMode r57 = r55.b;
        RouteOptions r58 = r55.c;
        int r111 = c.a[r57.ordinal()];
        if (r111 != 1) goto L70;
        r28 = R1(r56, r58);
        goto L91
    L70:
        if (r111 != 2) goto L72;
        b r59 = G1(r56, true);
        if (r59 == null) goto L88;
        r28 = X1(r59, r56, r58);
        goto L91
    L88:
        r28 = W1(r56, r58);
        goto L91
    L72:
        if (r111 != 3) goto L74;
    L78:
        b r112 = G1(r56, false);
        if (r112 == null) goto L82;
        r28 = X1(r112, r56, r58);
        goto L91
    L82:
        if (r57 != ApplicationRouter.OpenPageMode.NAVIGATE) goto L84;
        r28 = R1(r56, r58);
        goto L91
    L84:
        r28 = W1(r56, r58);
        goto L91
    L74:
        if (r111 == 4) goto L78;
        throw new NoWhenBranchMatchedException();
    L127:
        throw new NoWhenBranchMatchedException();
    L13:
        r16 = null;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object W1(String r10, RouteOptions r11) {
        AppletApplication r0 = this.e;
        if (r0 == null) goto L5;
        Fragment r12 = r0.t(this, r10, r11);
    L6:
        if (r12 != null) goto L9;
        String r13 = "Failed to create page for url: " + r10;
        AtomicInteger r14 = com.bytedance.ai.applet.base.log.d.d;
        this.c.a("redirectTo: fragment is null, openPath = " + r10, null);
        a2(r13);
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r13)));
    L9:
        t2.b.d(r12, r10);
        if ((!this.g) == false) goto L16;
        if (this.i != null) goto L16;
        this.i = r12;
        S1(t.c.a);
    L16:
        if (getSupportFragmentManager().getBackStackEntryCount() <= 0) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == false) goto L21;
        getSupportFragmentManager().popBackStackImmediate();
    L21:
        FragmentTransaction r16 = getSupportFragmentManager().beginTransaction();
        r16.setCustomAnimations(0, 0, 0, 2130772040);
        if (r1 == false) goto L29;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131363104) == true) goto L27;
        r16.add(2131363104, r12);
    L27:
        r16.addToBackStack(null);
    L32:
        r16.commitAllowingStateLoss();
        this.g = true;
        b2(r10);
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L29:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131363104) == true) goto L32;
        r16.replace(2131363104, r12);
        goto L32
    L18:
        r1 = false;
        goto L19
    L5:
        r12 = null;
        goto L6
    }

    public final Object X1(b r10, String r11, RouteOptions r12) {
        AppletApplication r0 = this.e;
        if (r0 != null) goto L6;
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("AppletApplication is null")));
    L6:
        Throwable r1 = Result.exceptionOrNull-impl(r0.D(r10.a, r11));
        if (r1 != null) goto L9;
        t2.b.d(r10.a, r11);
        int r14 = r10.b;
        if (r14 <= 0) goto L13;
        Object r15 = Q1(r14);
    L15:
        if (Result.isSuccess-impl(r15) == false) goto L23;
        Unit r16 = (Unit) r15;
        b2(r11);
        if (r12 == null) goto L23;
        Long r17 = r12.b;
        if (r17 == null) goto L23;
        long r18 = r17.longValue();
        com.bytedance.ai.applet.app.foundation.performance.r r19 = r0.h().c().f(r18);
        if (r19 == null) goto L23;
        AtomicLong r110 = com.bytedance.ai.applet.app.foundation.performance.k.g;
        com.bytedance.ai.applet.app.foundation.performance.k.d(r19, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "cancelled", 2);
    L23:
        return r15;
    L13:
        r15 = Result.constructor-impl(Unit.INSTANCE);
        goto L15
    L9:
        return Result.constructor-impl(ResultKt.createFailure(r1));
    }
}
