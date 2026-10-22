package com.ss.android.lark.conditional.access.nopermission.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.conditional.access.databinding.ScsActivityNoPermissionBinding;
import com.ss.android.lark.conditional.access.databinding.ScsActivityNoPermissionDoubaoBinding;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentCustomNoPermissionBinding;
import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomDisplayPageUiMode;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomNoPermissionFragment;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.h0;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001$\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004Z[\\]B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020'J\u0012\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010-\u001a\u00020'H\u0014J\u0012\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020'H\u0016J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020!H\u0002J\u001a\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u000107H\u0002J,\u00108\u001a\u00020'2\u0006\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u001dH\u0002J\b\u0010<\u001a\u00020'H\u0002J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020'2\u0006\u0010A\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010A\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020'2\u000e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0IH\u0016J\u0018\u0010K\u001a\u00020'2\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0IH\u0016J\"\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u00172\b\u0010P\u001a\u0004\u0018\u000100H\u0014J\b\u0010Q\u001a\u00020'H\u0002J\u0006\u0010R\u001a\u00020'J\u0006\u0010S\u001a\u00020'J\u000e\u0010T\u001a\u00020'2\u0006\u00103\u001a\u00020!J\b\u0010U\u001a\u00020'H\u0002J\u0010\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020\u0017H\u0002J\b\u0010X\u001a\u00020YH\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006^"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/OnUserSwitchListener;", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/OnUserListChangeListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "dependency", "Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;", "getDependency", "()Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;", "setDependency", "(Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;)V", "noPermissionModuleManager", "Lcom/ss/android/lark/conditional/access/nopermission/manager/NoPermissionModuleManager;", "getNoPermissionModuleManager", "()Lcom/ss/android/lark/conditional/access/nopermission/manager/NoPermissionModuleManager;", "setNoPermissionModuleManager", "(Lcom/ss/android/lark/conditional/access/nopermission/manager/NoPermissionModuleManager;)V", "viewBinding", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity$NoPermissionPageViews;", "mNoPermissionType", BuildConfig.FLAVOR, "extraBundle", "Landroid/os/Bundle;", "tvSwitchUser", "Landroid/widget/TextView;", "inSwitchProgress", BuildConfig.FLAVOR, "originalNavigationBarColor", "originalSystemUiVisibility", "currentPageUiMode", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "killSelf", "observer", "com/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity$observer$1", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity$observer$1;", "onConfigurationChanged", BuildConfig.FLAVOR, "newConfig", "Landroid/content/res/Configuration;", "updateInnerViewSize", "onCreate", "savedInstanceState", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onBackPressed", "bindPageLayout", "mode", "resolvePageUiMode", "unauthorizedType", "actionExtra", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "setupFragment", "traceId", BuildConfig.FLAVOR, "forceReplace", "showSwitchActionPanel", "onClick", "v", "Landroid/view/View;", "onUserSwitchBegin", "context", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/UserSwitchBeginContext;", "onUserSwitchFailed", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/UserSwitchFailedContext;", "onUserSwitchSuccess", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/UserSwitchSuccessContext;", "onUserListRemoved", "removedUserList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "onUserListChanged", "userList", "onActivityResult", "requestCode", "resultCode", Keys.API_RETURN_KEY_DATA, "killSelfAndRelaunch", "adaptFullScreenWebView", "applyCustomDisplayDefaultUiMode", "applyPageUiMode", "restoreNavigationBar", "updateOuterScrollPaddingBottom", "paddingBottom", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "NoPermissionPageViews", "LarkPageViews", "DoubaoPageViews", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoPermissionActivity extends Hilt_NoPermissionActivity implements View.OnClickListener, qzb.a, mzb.a, d0c.c {
    public static final /* synthetic */ int n = 0;

    @Inject
    public k8b.c b;

    @Inject
    public NoPermissionModuleManager c;
    public d d;
    public int e;
    public Bundle f;
    public TextView g;
    public boolean h;
    public int i;
    public int j;
    public CustomDisplayPageUiMode k;
    public boolean l;
    public final g m;

    public static final class a {
    }

    public static final class b implements d {
        public final View a;
        public final FrameLayout b;
        public final NestedScrollView c;
        public final LinearLayout d;
        public final FrameLayout e;
        public final Space f;
        public final TextView g;

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final TextView a() {
            return this.g;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout b() {
            return this.b;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final NestedScrollView c() {
            return this.c;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final LinearLayout d() {
            return this.d;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final Space e() {
            return this.f;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout getContainer() {
            return this.e;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final View getRoot() {
            return this.a;
        }

        public b(ScsActivityNoPermissionDoubaoBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.f;
            this.d = r2.e;
            this.e = r2.c;
            this.f = r2.g;
            this.g = r2.h;
        }
    }

    public static final class c implements d {
        public final View a;
        public final FrameLayout b;
        public final NestedScrollView c;
        public final LinearLayout d;
        public final FrameLayout e;
        public final Space f;
        public final TextView g;

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final TextView a() {
            return this.g;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout b() {
            return this.b;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final NestedScrollView c() {
            return this.c;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final LinearLayout d() {
            return this.d;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final Space e() {
            return this.f;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout getContainer() {
            return this.e;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final View getRoot() {
            return this.a;
        }

        public c(ScsActivityNoPermissionBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.e;
            this.d = r2.d;
            this.e = r2.c;
            this.f = r2.f;
            this.g = r2.g;
        }
    }

    public interface d {
        TextView a();

        FrameLayout b();

        NestedScrollView c();

        LinearLayout d();

        Space e();

        FrameLayout getContainer();

        View getRoot();
    }

    public static final class e implements Runnable {
        public final /* synthetic */ NoPermissionActivity a;

        public e(NoPermissionActivity r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.H1();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnLayoutChangeListener {
        public final /* synthetic */ NoPermissionActivity a;

        public f(NoPermissionActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
            d r0 = this.a.d;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r0 = null;
        L6:
            if (Intrinsics.areEqual(r0.c(), r2) == true) goto L8;
            return;
        L8:
            if ((r5 - r3) == (r9 - r7)) goto L10;
        L11:
            this.a.H1();
            return;
        L10:
            if ((r6 - r4) != (r10 - r8)) goto L11;
        }
    }

    public static final class g extends com.ss.android.lark.appcontext.applifecycle.a {
        public final /* synthetic */ NoPermissionActivity a;

        public g(NoPermissionActivity r1) {
            this.a = r1;
        }

        public final void onActivityStarted(Activity r7) {
            Intrinsics.checkNotNullParameter(r7, "activity");
            boolean r0 = r7.getIntent().getBooleanExtra("can_be_covered", true);
            boolean r1 = this.a.C1().getPassportDependency().d(r7);
            boolean r3 = this.a.C1().n(r7);
            this.a.C1().i(r7);
            int r4 = ScsLogger.a;
            ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onActivityStarted, activity: " + r7 + ", cover: " + r0 + ", isPassportActivity: " + r1);
            NoPermissionActivity r8 = this.a;
            if (r8.h == false) goto L5;
            return;
        L5:
            if (r0 == false) goto L10;
            if (r1 == true) goto L11;
            if (r3 == true) goto L12;
            ScsLogger.d("SecurityPolicy_NoPermissionActivity", "killSelfAndRelaunch");
            r8.l = true;
            r8.finish();
            r8.D1().g();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ NoPermissionActivity a;

        public h(NoPermissionActivity r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.H1();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final k8b.c C1() {
        k8b.c r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
        return null;
    }

    public final NoPermissionModuleManager D1() {
        NoPermissionModuleManager r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("noPermissionModuleManager");
        return null;
    }

    public final void H1() {
        int r0 = ScsLogger.a;
        StringBuilder r1 = new StringBuilder("updateInnerViewSize, outerScrollView height: ");
        d r2 = this.d;
        ScsFragmentCustomNoPermissionBinding r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L5:
        r1.append(r2.c().getHeight());
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r1.toString());
        Resources r4 = getResources();
        float r5 = TypedValue.applyDimension(1, 400.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
        d r6 = this.d;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L8:
        FrameLayout r7 = r6.getContainer();
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L108;
        d r9 = this.d;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L14:
        if (r9.d().getMeasuredWidth() <= r5) goto L16;
        int r10 = (int) r5;
    L17:
        r8.width = r10;
        r7.setLayoutParams(r8);
        d r11 = this.d;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L20:
        int r12 = r11.c().getHeight();
        d r13 = this.d;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L23:
        int r14 = r13.getContainer().getHeight();
        if (r12 >= r14) goto L61;
        CustomNoPermissionFragment r15 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.e));
        if ((r15 instanceof CustomNoPermissionFragment) == false) goto L61;
        CustomNoPermissionFragment r16 = r15;
        int r17 = r14 - r12;
        ScsFragmentCustomNoPermissionBinding r18 = r16.h;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L30:
        r18.g.requestLayout();
        ScsFragmentCustomNoPermissionBinding r19 = r16.h;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r19 = null;
    L34:
        if (r19.c.getVisibility() == 8) goto L61;
        if (r16.o == CustomDisplayPageUiMode.LARK) goto L39;
        r16.da0();
        goto L61
    L39:
        ScsFragmentCustomNoPermissionBinding r20 = r16.h;
        if (r20 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r20 = null;
    L43:
        if ((r20.g.getHeight() - r17) < UIUtils.dp2px(r16.requireContext(), 110.0f)) goto L54;
        ScsFragmentCustomNoPermissionBinding r21 = r16.h;
        if (r21 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r21 = null;
    L47:
        NestedScrollView r22 = r21.g;
        ScsFragmentCustomNoPermissionBinding r23 = r16.h;
        if (r23 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r23 = null;
    L50:
        ViewGroup.LayoutParams r24 = r23.g.getLayoutParams();
        ScsFragmentCustomNoPermissionBinding r25 = r16.h;
        if (r25 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r25 = null;
    L53:
        r24.height = r25.g.getHeight() - r17;
        r22.setLayoutParams(r24);
        goto L61
    L54:
        ScsFragmentCustomNoPermissionBinding r26 = r16.h;
        if (r26 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r26 = null;
    L57:
        NestedScrollView r27 = r26.g;
        ScsFragmentCustomNoPermissionBinding r28 = r16.h;
        if (r28 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r28 = null;
    L60:
        ViewGroup.LayoutParams r29 = r28.g.getLayoutParams();
        r29.height = UIUtils.dp2px(r16.requireContext(), 110.0f);
        r27.setLayoutParams(r29);
    L61:
        if (r12 <= r14) goto L109;
        CustomNoPermissionFragment r30 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.e));
        if ((r30 instanceof CustomNoPermissionFragment) == false) goto L110;
        CustomNoPermissionFragment r31 = r30;
        int r32 = r12 - r14;
        ScsFragmentCustomNoPermissionBinding r33 = r31.h;
        if (r33 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r33 = null;
    L67:
        r33.g.requestLayout();
        ScsFragmentCustomNoPermissionBinding r34 = r31.h;
        if (r34 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r34 = null;
    L71:
        if (r34.c.getVisibility() != 8) goto L74;
        return;
    L74:
        if (r31.o == CustomDisplayPageUiMode.LARK) goto L76;
        r31.da0();
        return;
    L76:
        ScsFragmentCustomNoPermissionBinding r35 = r31.h;
        if (r35 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r35 = null;
    L79:
        int r36 = r35.g.getHeight() + r32;
        ScsFragmentCustomNoPermissionBinding r37 = r31.h;
        if (r37 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r37 = null;
    L83:
        if (r36 >= r37.c.getHeight()) goto L95;
        ScsFragmentCustomNoPermissionBinding r38 = r31.h;
        if (r38 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r38 = null;
    L87:
        NestedScrollView r39 = r38.g;
        ScsFragmentCustomNoPermissionBinding r40 = r31.h;
        if (r40 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r40 = null;
    L90:
        ViewGroup.LayoutParams r41 = r40.g.getLayoutParams();
        ScsFragmentCustomNoPermissionBinding r42 = r31.h;
        if (r42 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L94:
        r41.height = r3.g.getHeight() + r32;
        r39.setLayoutParams(r41);
        return;
    L93:
        r3 = r42;
        goto L94
    L95:
        ScsFragmentCustomNoPermissionBinding r43 = r31.h;
        if (r43 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r43 = null;
    L98:
        NestedScrollView r44 = r43.g;
        ScsFragmentCustomNoPermissionBinding r45 = r31.h;
        if (r45 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r45 = null;
    L101:
        ViewGroup.LayoutParams r46 = r45.g.getLayoutParams();
        ScsFragmentCustomNoPermissionBinding r47 = r31.h;
        if (r47 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L105:
        r46.height = r3.c.getHeight();
        r44.setLayoutParams(r46);
        return;
    L104:
        r3 = r47;
        goto L105
    L110:
        return;
    L109:
        return;
    L16:
        r10 = -1;
        goto L17
    L108:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void I1() {
        d r0 = this.d;
        d r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L6:
        if (r0.c().getPaddingBottom() != 0) goto L8;
        return;
    L8:
        d r2 = this.d;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L11:
        NestedScrollView r3 = r2.c();
        d r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L14:
        int r5 = r4.c().getPaddingLeft();
        d r6 = this.d;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L17:
        int r7 = r6.c().getPaddingTop();
        d r8 = this.d;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L20:
        r3.setPadding(r5, r7, r8.c().getPaddingRight(), 0);
        d r9 = this.d;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L24:
        r1.c().setClipToPadding(true);
        return;
    L23:
        r1 = r9;
        goto L24
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.conditional.access.nopermission.ui.Hilt_NoPermissionActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(NoPermissionActivity.class.getName()));
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
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L42
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

    public final void onBackPressed() {
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "back button pressed");
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.Hilt_NoPermissionActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(NoPermissionActivity.class.getName()));
    L5:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onDestroy");
        if (this.l == false) goto L8;
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "kill by self, not release");
    L9:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "unregisterUserSwitchListener");
        C1().getPassportDependency().k(this);
        C1().getPassportDependency().j(this);
        AppLifecycle.a.a.j(this.m);
        super.onDestroy();
        return;
    L8:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "not kill by self, need release");
        D1().i();
        goto L9
    }

    public NoPermissionActivity() {
        this.k = CustomDisplayPageUiMode.LARK;
        this.m = new g(this);
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m976provideComponent() {
        return provideComponent();
    }

    public static View z1(Window r3) {
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
    public final void A1(CustomDisplayPageUiMode r7) {
        Intrinsics.checkNotNullParameter(r7, "mode");
        this.k = r7;
        d r0 = this.d;
        d r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        boolean r3 = true;
        r0.b().setFitsSystemWindows(true);
        d r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L8:
        t4c.b.b(r2.e());
        if (r7 != CustomDisplayPageUiMode.LARK) goto L22;
        I1();
        getWindow().setNavigationBarColor(this.i);
        z1(getWindow()).setSystemUiVisibility(this.j);
        d r8 = this.d;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L13:
        r8.a().setTextAppearance(this, 2131953915);
        d r9 = this.d;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L16:
        r9.a().setTextColor(getResources().getColor(2131105548));
        d r10 = this.d;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L20:
        r1.b().setBackgroundResource(2131247522);
        return;
    L19:
        r1 = r10;
        goto L20
    L22:
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, 2131101382));
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L26;
        r3 = false;
    L26:
        int r11 = this.j;
        int r4 = Build.VERSION.SDK_INT;
        if (r4 < 23) goto L32;
        if (r3 == false) goto L30;
        r11 = r11 & (-8193);
        goto L32
    L30:
        r11 = r11 | 8192;
    L32:
        if (r4 < 26) goto L36;
        if (r3 == false) goto L35;
        r11 = r11 & (-17);
        goto L36
    L35:
        r11 = r11 | 16;
    L36:
        z1(getWindow()).setSystemUiVisibility(r11);
        d r12 = this.d;
        if (r12 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r12 = null;
    L39:
        r12.b().setBackgroundColor(ContextCompat.getColor(this, 2131101382));
        d r13 = this.d;
        if (r13 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L42:
        r13.a().setTextAppearance(this, 2131953910);
        d r14 = this.d;
        if (r14 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r14 = null;
    L45:
        h0.a(r14.a(), ChameleonWebViewClient.DEFAULT_SAFE_TIME);
        d r15 = this.d;
        if (r15 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L48:
        r15.a().setTextSize(14.0f);
        d r16 = this.d;
        if (r16 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L51:
        r16.a().setTextColor(ContextCompat.getColor(this, 2131101392));
        d r17 = this.d;
        if (r17 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L55:
        r1.c().post(new e(this));
        return;
    L54:
        r1 = r17;
        goto L55
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(CustomDisplayPageUiMode r22) {
        this.k = r22;
        int r3 = 2131391538;
        d r11 = null;
        if (r22 != CustomDisplayPageUiMode.DOUBAO) goto L27;
        View r10 = getLayoutInflater().inflate(2131564431, null, false);
        FrameLayout r14 = (FrameLayout) r10;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131367728);
        if (r15 == null) goto L24;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131373142);
        if (r16 == null) goto L23;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131381748);
        if (r17 == null) goto L22;
        NestedScrollView r18 = ViewBindings.findChildViewById(r10, 2131381749);
        if (r18 != null) goto L13;
        r3 = 2131381749;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r3)));
    L13:
        if (((Space) ViewBindings.findChildViewById(r10, 2131387024)) == null) goto L20;
        Space r19 = (Space) ViewBindings.findChildViewById(r10, 2131387027);
        if (r19 == null) goto L19;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r10, 2131391538);
        if (r20 == null) goto L26;
        d r2 = new b(new ScsActivityNoPermissionDoubaoBinding(r14, r14, r15, r16, r17, r18, r19, r20));
    L40:
        this.d = r2;
        setContentView(r2.getRoot());
        d r4 = this.d;
        if (r4 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L43:
        TextView r5 = r4.a();
        this.g = r5;
        if (r5 == null) goto L46;
        r5.setOnClickListener(this);
    L46:
        d r6 = this.d;
        if (r6 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L50:
        r11.c().addOnLayoutChangeListener(new f(this));
        A1(r22);
        return;
    L49:
        r11 = r6;
        goto L50
    L19:
        r3 = 2131387027;
        goto L26
    L20:
        r3 = 2131387024;
        goto L26
    L22:
        r3 = 2131381748;
        goto L26
    L23:
        r3 = 2131373142;
        goto L26
    L24:
        r3 = 2131367728;
        goto L26
    L27:
        View r12 = getLayoutInflater().inflate(2131564430, null, false);
        FrameLayout r110 = (FrameLayout) r12;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131367728);
        if (r111 == null) goto L56;
        LinearLayout r112 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131381748);
        if (r112 == null) goto L55;
        NestedScrollView r113 = ViewBindings.findChildViewById(r12, 2131381749);
        if (r113 != null) goto L34;
        r3 = 2131381749;
    L58:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r3)));
    L34:
        if (((Space) ViewBindings.findChildViewById(r12, 2131387024)) == null) goto L53;
        Space r114 = (Space) ViewBindings.findChildViewById(r12, 2131387027);
        if (r114 == null) goto L52;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r12, 2131391538);
        if (r115 == null) goto L58;
        r2 = new c(new ScsActivityNoPermissionBinding(r110, r110, r111, r112, r113, r114, r115));
        goto L40
    L52:
        r3 = 2131387027;
        goto L58
    L53:
        r3 = 2131387024;
        goto L58
    L55:
        r3 = 2131381748;
        goto L58
    L56:
        r3 = 2131367728;
        goto L58
    }

    public final void l0(List<? extends User> r4) {
        Intrinsics.checkNotNullParameter(r4, "removedUserList");
        int r0 = ScsLogger.a;
        StringBuilder r1 = new StringBuilder("onUserListRemoved, removed: ");
        List<? extends User> r5 = r4;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        User r3 = (User) r6.next();
        if (r3 == null) goto L8;
        String r7 = r3.userId;
    L9:
        r2.add(r7);
        goto L4
    L8:
        r7 = null;
        goto L9
    L10:
        r1.append(r2);
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r1.toString());
        this.h = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (Intrinsics.areEqual(r4, this.g) == false) goto L6;
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "tvSwitchUser onClick");
        new UDActionPanelBuilder(this).title(getString(2131890458)).items(CollectionsKt.listOf(new String[]{getString(2131890541), getString(2131890532)})).itemClickListener(new u(this)).addActionButton(2131391775, getString(2131890466), null).show();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r6) {
        Intrinsics.checkNotNullParameter(r6, "newConfig");
        super.onConfigurationChanged(r6);
        d r1 = null;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r6 == null) goto L8;
        Integer r7 = Integer.valueOf(r6.orientation);     // Catch: Throwable -> L17
    L9:
        if (r7 != null) goto L12;
    L14:
        if (r2 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:NoPermissionActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r7.intValue() == r2) goto L19;
    L8:
        r7 = null;
    L19:
        d r8 = this.d;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L23:
        r1.getContainer().post(new h(this));
        return;
    L22:
        r1 = r8;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L30
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L30
    L8:
        super.onCreate(r10);
        this.e = getIntent().getIntExtra("unauthorized_type", 0);
        Bundle r11 = getIntent().getBundleExtra("biz_extra");
        Context r2 = BadParcelableCrashOptimizer.getContext();
        if (r11 == null) goto L12;
        if (r2 == null) goto L12;
        r11.setClassLoader(r2.getClassLoader());
    L12:
        this.f = r11;
        if (r11 == null) goto L15;
        InternalSecurityAction r12 = (InternalSecurityAction) r11.getParcelable("param_action");
    L16:
        Bundle r4 = this.f;
        String r5 = BuildConfig.FLAVOR;
        if (r4 == null) goto L20;
        String r6 = r4.getString("param_trace_id");
        if (r6 == null) goto L20;
    L31:
        r5 = qqb.a.d();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r6, "traceId");     // Catch: Throwable -> L27
        qqb.a.g(r6);     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onCreate");     // Catch: Throwable -> L27
        UIUtils.setStatusBarTransparent(this);     // Catch: Throwable -> L27
        this.i = getWindow().getNavigationBarColor();     // Catch: Throwable -> L27
        this.j = z1(getWindow()).getSystemUiVisibility();     // Catch: Throwable -> L27
        this.h = false;     // Catch: Throwable -> L27
        NoPermissionModuleManager r7 = D1();     // Catch: Throwable -> L27
        r7.getClass();     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "release timer");     // Catch: Throwable -> L27
        Handler r8 = r7.p;     // Catch: Throwable -> L27
        if (r8 == null) goto L24;
        r8.removeCallbacks(r7.q);     // Catch: Throwable -> L27
    L24:
        r7.p = null;     // Catch: Throwable -> L27
        r7.k.postValue(Boolean.FALSE);     // Catch: Throwable -> L27
        r7.g = true;     // Catch: Throwable -> L27
        B1(F1(this.e, r12));     // Catch: Throwable -> L27
        overridePendingTransition(0, 0);     // Catch: Throwable -> L27
        G1(this.e, r12, r6, false);     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "registerUserSwitchListener");     // Catch: Throwable -> L27
        C1().getPassportDependency().h(this);     // Catch: Throwable -> L27
        C1().getPassportDependency().g(this);     // Catch: Throwable -> L27
        AppLifecycle.a.a.b(this.m);     // Catch: Throwable -> L27
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r5, "traceId");
        qqb.a.g(r5);
        return;
    L27:
        th = move-exception;
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r5, "traceId");
        qqb.a.g(r5);
        throw th;
    L20:
        r6 = BuildConfig.FLAVOR;
        goto L31
    L15:
        r12 = null;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r6) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r6);
        boolean r0 = false;
        this.h = false;
        setIntent(r6);
        NoPermissionModuleManager r1 = D1();
        r1.getClass();
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "release timer");
        Handler r2 = r1.p;
        if (r2 == null) goto L5;
        r2.removeCallbacks(r1.q);
    L5:
        InternalSecurityAction r3 = null;
        r1.p = null;
        r1.k.postValue(Boolean.FALSE);
        r1.g = true;
        if (r6 == null) goto L8;
        int r4 = r6.getIntExtra("unauthorized_type", 0);
    L9:
        this.e = r4;
        if (r6 == null) goto L15;
        Bundle r7 = r6.getBundleExtra("biz_extra");
        Context r5 = BadParcelableCrashOptimizer.getContext();
        if (r7 == null) goto L16;
        if (r5 == null) goto L16;
        r7.setClassLoader(r5.getClassLoader());
    L16:
        this.f = r7;
        if (r7 == null) goto L19;
        r3 = (InternalSecurityAction) r7.getParcelable("param_action");
    L19:
        Bundle r8 = this.f;
        if (r8 == null) goto L23;
        String r9 = r8.getString("param_trace_id");
        if (r9 == null) goto L23;
    L24:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onNewIntent, type: " + this.e + ", extra: " + r3);
        CustomDisplayPageUiMode r10 = F1(this.e, r3);
        if (r10 == this.k) goto L27;
        r0 = true;
    L27:
        if (r0 == false) goto L29;
        B1(r10);
    L30:
        G1(this.e, r3, r9, r0);
        return;
    L29:
        A1(r10);
    L23:
        r9 = BuildConfig.FLAVOR;
        goto L24
    L15:
        r7 = null;
        goto L16
    L8:
        r4 = 0;
        goto L9
    }

    public final void p0(List<? extends User> r9) {
        Intrinsics.checkNotNullParameter(r9, "userList");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(PassportcConvention.c(this).b);     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        String r2 = (String) r1;
        List<? extends User> r10 = r9;
        boolean r3 = true;
        if ((r10 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r4 = r10.iterator();
    L17:
        if (r4.hasNext() == false) goto L25;
        User r5 = (User) r4.next();
        if (r5 == null) goto L21;
        String r6 = r5.userId;
    L23:
        if (Intrinsics.areEqual(r6, r2) == false) goto L17;
        boolean r7 = true;
    L26:
        int r8 = ScsLogger.a;
        StringBuilder r11 = new StringBuilder("onUserListChanged, myUserId: ");
        r11.append(r2);
        r11.append(", stillPresent: ");
        r11.append(r7);
        r11.append(", list: ");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L28:
        if (r13.hasNext() == false) goto L34;
        User r14 = (User) r13.next();
        if (r14 == null) goto L32;
        String r15 = r14.userId;
    L33:
        r12.add(r15);
        goto L28
    L32:
        r15 = null;
        goto L33
    L34:
        r11.append(r12);
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r11.toString());
        if (r2 != null) goto L37;
    L40:
        if (r3 == true) goto L53;
        if (r7 == true) goto L54;
        this.h = false;
        AppLifecycle.a.a.j(this.m);
        D1().i();
        finish();
        return;
    L54:
        return;
    L53:
        return;
    L37:
        if (r2.length() == 0) goto L40;
        r3 = false;
        goto L40
    L21:
        r6 = null;
    L25:
        r7 = false;
        goto L26
    L13:
        if (r10.isEmpty() == false) goto L15;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static CustomDisplayPageUiMode F1(int r6, InternalSecurityAction r7) {
        NoPermissionType[] r0 = NoPermissionType.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        NoPermissionType r4 = r0[r3];
        if (r4.getValue() != r6) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L12;
        r3 = r3 + 1;
    L12:
        if (r4 != null) goto L15;
        r4 = NoPermissionType.UNKNOWN;
    L15:
        return com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a(r4, r7);
    L7:
        r5 = false;
        goto L8
    L11:
        r4 = null;
        goto L12
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r3, r4, r5);
        int r6 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onActivityResult: " + r3 + ", " + r4);
        if (r3 != 9999) goto L10;
        NoPermissionFragment r7 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.e));
        if (r7 == null) goto L10;
        if ((r7 instanceof NoPermissionFragment) == false) goto L10;
        r7.W90("device_apply_view_back");
    L10:
        if (r3 == 10000) goto L12;
        return;
    L12:
        if (r4 != (-1)) goto L24;
        Fragment r8 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.e));
        if (r8 != null) goto L16;
    L18:
        if (r8 != null) goto L20;
        return;
    L20:
        if ((r8 instanceof CustomNoPermissionFragment) == false) goto L26;
        ((CustomNoPermissionFragment) r8).aa0("device_apply_view_back");
        return;
    L26:
        return;
    L16:
        if ((r8 instanceof DeviceOwnerNoPermissionV2Fragment) == false) goto L18;
        ((DeviceOwnerNoPermissionV2Fragment) r8).W90("device_apply_view_back");
        goto L18
    }

    public final void G1(int r7, InternalSecurityAction r8, String r9, boolean r10) {
        int r0 = ScsLogger.a;
        StringBuilder r1 = new StringBuilder("[end show page], setupFragment, type: ");
        r1.append(r7);
        r1.append(", [traceId:");
        Fragment r2 = null;
        if (r8 == null) goto L5;
        String r3 = r8.getTraceId();
    L6:
        r1.append(r3);
        r1.append(']');
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r1.toString());
        y r4 = getSupportFragmentManager().findFragmentByTag(String.valueOf(r7));
        if (r10 == true) goto L20;
        if (r4 == null) goto L20;
        if ((r4 instanceof y) == false) goto L20;
        Bundle r11 = r4.getArguments();
        if (r11 == null) goto L14;
        r11.putParcelable("param_action", r8);
    L14:
        Bundle r12 = r4.getArguments();
        if (r12 == null) goto L17;
        r12.putString("param_trace_id", r9);
    L17:
        r4.onPageUpdate();
        return;
    L20:
        if (r7 != NoPermissionType.DEVICE_OWNER.getValue()) goto L23;
        r2 = new DeviceOwnerNoPermissionFragment();
    L55:
        if (r2 == null) goto L66;
        int r13 = p8b.a.a;
        JSONObject r14 = new JSONObject();
        r14.put("reason", p8b.a.c(r7));     // Catch: Exception -> L59
    L61:
        p8b.a.d("scs_no_access_view", r14);
        Bundle r15 = new Bundle();
        r15.putParcelable("param_action", r8);
        r15.putString("param_trace_id", r9);
        PassportcConvention.h(r15, PassportcConvention.c(this));
        r2.setArguments(r15);
        FragmentTransaction r16 = getSupportFragmentManager().beginTransaction();
        String r17 = String.valueOf(r7);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r17, 2131367728) == true) goto L65;
        r16 = r16.replace(2131367728, r2, r17);
    L65:
        r16.commitNowAllowingStateLoss();
        return;
    L59:
        e = move-exception;
        int r5 = ScsLogger.a;
        ScsLogger.c("scs-tracker", "tracker exception:" + e.getMessage());
        goto L61
    L66:
        ScsLogger.e("SecurityPolicy_NoPermissionActivity", "Unknown No Permission Type !!");
        finish();
        return;
    L23:
        if (r7 != NoPermissionType.DEVICE_STATE.getValue()) goto L26;
        r2 = new DeviceStateNoPermissionFragment();
        goto L55
    L26:
        if (r7 != NoPermissionType.MFA.getValue()) goto L29;
        r2 = new MFANoPermissionFragment();
        goto L55
    L29:
        if (r7 != NoPermissionType.NETWORK.getValue()) goto L32;
        r2 = new NetworkNoPermissionFragment();
        goto L55
    L32:
        if (r7 != NoPermissionType.DEVICE_OWNER_V2.getValue()) goto L35;
        r2 = new DeviceOwnerNoPermissionV2Fragment();
        goto L55
    L35:
        if (r7 != NoPermissionType.DEVICE_CREDIBILITY.getValue()) goto L38;
        r2 = new DeviceCredibilityNoPermissionFragment();
        goto L55
    L38:
        if (r7 != NoPermissionType.DEVICE_OS.getValue()) goto L41;
        r2 = new DeviceOSNoPermissionFragment();
        goto L55
    L41:
        if (r7 != NoPermissionType.DEVICE_TERMINAL.getValue()) goto L44;
        r2 = new DeviceTerminalNoPermissionFragment();
        goto L55
    L44:
        if (r7 != NoPermissionType.DEVICE_AUTHENTICATION.getValue()) goto L46;
        r2 = new DeviceAuthenticationNoPermissionFragment();
        goto L55
    L46:
        NoPermissionType r18 = NoPermissionType.CUSTOM_DISPLAY;
        if (r7 != r18.getValue()) goto L50;
        r2 = new CustomNoPermissionFragment(r18);
        goto L55
    L50:
        if (r7 != NoPermissionType.OAUTH_REAUTHORIZATION.getValue()) goto L53;
        r2 = new OfficeSDKOAuthReauthorizationFragment();
        goto L55
    L53:
        if (r7 != NoPermissionType.UNKNOWN.getValue()) goto L55;
        r2 = new UnknownNoPermissionFragment();
        goto L55
    L5:
        r3 = null;
        goto L6
    }
}
