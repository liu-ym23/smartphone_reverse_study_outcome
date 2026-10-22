package com.ss.android.lark.passport.flow.auth_type;

import android.R;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.flow.passport.mfa.databinding.SigninSdkActivityAuthTypeBinding;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseActivity;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.core.widget.CommonTitleBar;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import uzb.f;
import uzb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010*\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u00061"}, d2 = {"Lcom/ss/android/lark/passport/flow/auth_type/AuthTypeActivity;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseActivity;", "<init>", "()V", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/BaseUiContainer;", "binding", "Lcom/ss/android/lark/flow/passport/mfa/databinding/SigninSdkActivityAuthTypeBinding;", "viewModel", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel;", "getViewModel", "()Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "pageRootView", "Landroid/view/View;", "initView", "observeViewModel", "readStepInfo", "Lcom/ss/android/lark/passport/flow/auth_type/AuthTypeStepInfo;", "showChooseView", "stepInfo", "getLoginVerifyItem", "data", "Lcom/ss/android/lark/passport/flow/core/model/ButtonInfo;", "targetTenantIcon", "", "setVerifyIcon", "itemBinding", "Lcom/ss/android/lark/flow/passport/mfa/databinding/SigninSdkItemLoginVerifyTypeBinding;", "actionType", "", "tintedDrawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "colorRes", "showBottomButton", "bottomButton", "setBIdpImageResource", "routeNextStep", "event", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$UIEvent$RouteToNext;", "finish", "onDestroy", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class AuthTypeActivity extends FlowBaseActivity {
    public static final /* synthetic */ int f = 0;
    public SigninSdkActivityAuthTypeBinding d;
    public final ViewModelLazy e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        if (f.c(this) == false) goto L5;
        f.b(this);
    L5:
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AuthTypeActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L56:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
    L51:
        goto L56
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public final AuthTypeViewModel z1() {
        return (AuthTypeViewModel) this.e.getValue();
    }

    public AuthTypeActivity() {
        Function0<ViewModelProvider.Factory> r0 = new AuthTypeActivity$special$$inlined$viewModels$default$1(this);
        final Function0 r5 = null;
        this.e = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AuthTypeViewModel.class), new AuthTypeActivity$special$$inlined$viewModels$default$2(this), r0, new AuthTypeActivity$special$$inlined$viewModels$default$3(r5, this));
    }

    public final void onDestroy() {
        y1();
        super/*androidx.fragment.app.FragmentActivity*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.fragment.app.FragmentActivity*/.onStop();
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
    public final void onCreate(Bundle r11) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r11);
        int r12 = com.ss.android.lark.flow.passport.ui.widget.common.a.c;
        Intrinsics.checkNotNullParameter(this, "activity");
        int r0 = com.ss.android.lark.flow.passport.ui.widget.layout.f.a;
        Intrinsics.checkNotNullParameter(this, "activity");
        AuthTypeStepInfo r1 = null;
        BaseContainerLayout r13 = new BaseContainerLayout(this, null, 6, 0);
        setContentView(r13, new ViewGroup.LayoutParams(-1, -1));
        r13.a(2131564873);
        View r14 = new com.ss.android.lark.flow.passport.ui.widget.common.a(this, r13).b.getChildAt(0);
        int r2 = 2131378931;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131378931);
        if (r5 == null) goto L35;
        r2 = 2131388807;
        CommonTitleBar r3 = (CommonTitleBar) ViewBindings.findChildViewById(r14, 2131388807);
        if (r3 == null) goto L35;
        r2 = 2131390238;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, 2131390238);
        if (r7 == null) goto L35;
        r2 = 2131390241;
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131390241)) == null) goto L35;
        r2 = 2131391531;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131391531);
        if (r8 == null) goto L35;
        r2 = 2131391606;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r14, 2131391606);
        if (r9 == null) goto L35;
        this.d = new SigninSdkActivityAuthTypeBinding((LinearLayout) r14, r5, r3, r7, r8, r9);
        r3.R5();
        SigninSdkActivityAuthTypeBinding r15 = this.d;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L25:
        r15.c.setTitleClickListener(new b(this));
        FlowUtilKt.b(this, z1().getViewState(), new AuthTypeActivity$observeViewModel$1(this, null));
        FlowUtilKt.b(this, z1().getEventState(), new AuthTypeActivity$observeViewModel$2(this, null));
        AuthTypeViewModel r16 = z1();
        Serializable r4 = getIntent().getSerializableExtra("auth_type_step");
        if ((r4 instanceof FlowStep) == false) goto L28;
        FlowStep r6 = (FlowStep) r4;
    L29:
        if (r6 != null) goto L31;
        PassportLog.b("AuthTypeActivity", "init auth type but step is null");
    L32:
        r16.init(r1);
        return;
    L31:
        r1 = (AuthTypeStepInfo) uzb.c.a(r6.getStepInfo(), AuthTypeStepInfo.class);
        goto L32
    L28:
        r6 = null;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable A1(int r2, int r3) {
        Drawable r4 = l.getResources(this).getDrawable(r2).mutate();
        r4.setTint(l.b(this, r3));
        return r4;
    }
}
