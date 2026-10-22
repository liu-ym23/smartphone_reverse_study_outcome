package com.larksuite.component.card.component.chart;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.air.AirActivity;
import com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader;
import com.larksuite.component.card.component.CardResourceProvider;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0014J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larksuite/component/card/component/chart/CardElementActivity;", "Lcom/larksuite/component/air/AirActivity;", "<init>", "()V", "mLynxContainer", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "hasCalledSaveInstance", "", "originOrientation", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "buildContainer", "Landroid/view/View;", "globalData", "", "getDebugUrl", "onDestroy", "finish", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardElementActivity extends AirActivity {
    public static String d;
    public ILarkLynxContainer a;
    public boolean b;
    public int c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CardElementActivity a;

        public b(CardElementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.finish();
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x010f */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.air.AirActivity
    public final void finish() {
        if (Build.VERSION.SDK_INT <= 34) goto L5;
        setRequestedOrientation(this.c);
    L5:
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(CardElementActivity.class.getName()));
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
    L51:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
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

    @Override // com.larksuite.component.air.AirActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CardElementActivity.class.getName()));
    L5:
        super.onDestroy();
        ILarkLynxContainer r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r0 = null;
    L8:
        r0.destroy();
        if (this.b == true) goto L12;
        d = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public CardElementActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.air.AirActivity
    public final void onCreate(Bundle r11) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r11);
        this.c = getRequestedOrientation();
        if (getRequestedOrientation() == 0) goto L13;
        setRequestedOrientation(0);
    L13:
        setContentView(2131558456);
        StatusBarUtil.hideStatusBar(this);
        Resources r12 = getResources();
        int r1 = r12.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r1 == 0) goto L26;
        boolean r13 = r12.getBoolean(r1);
        Method r2 = com.larksuite.component.card.utils.a.a().getDeclaredMethod("get", new Class[]{String.class});     // Catch: Throwable -> L18
        r2.setAccessible(true);     // Catch: Throwable -> L18
        String r3 = (String) r2.invoke(null, new Object[]{"qemu.hw.mainkeys"});     // Catch: Throwable -> L18
    L21:
        if (TextUtils.equals("1", r3) == false) goto L24;
        r13 = false;
    L27:
        if (r13 == false) goto L35;
        View r14 = getWindow().getDecorView();
        if (c.e == false) goto L34;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == c.a) goto L34;
        c.a(r4, "getDecorView");
    L34:
        r14.setSystemUiVisibility(7942);
        getWindow().addFlags(134217728);
    L35:
        int r15 = vy7.c.a;
        View r16 = findViewById(2131384813);
        Window r5 = getWindow();
        View r6 = findViewById(2131384822);
        Intrinsics.checkNotNullParameter(r6, "cardContainer");
        r6.setPadding(r6.getPaddingLeft(), UIHelper.dp2px(4.0f), UIHelper.dp2px(57.0f), r6.getPaddingBottom());
        if (r16 == null) goto L41;
        if (r5 == null) goto L41;
        if (Build.VERSION.SDK_INT < 28) goto L41;
        WindowManager.LayoutParams r7 = r5.getAttributes();
        r7.layoutInDisplayCutoutMode = 1;
        r5.setAttributes(r7);
        ViewCompat.setOnApplyWindowInsetsListener(r16, vy7.b.a);
    L41:
        String r17 = d;
        String r8 = getIntent().getStringExtra("global_props");
        com.larksuite.component.card.cardcontainer.a r9 = new com.larksuite.component.card.cardcontainer.a();
        vy7.a r10 = new vy7.a();
        LarkLynxContainerBuilder r19 = new LarkLynxContainerBuilder(this).tagForJsContext("UniversalCard").tagForCustomComponent("UniversalCard").containerContext(r9).tagForBridgeMethodDispatcher("UniversalCard");
        r19.lynxViewLifeCycle(r10);
        ILarkLynxContainer r20 = r19.setEnableUserCodeCache(true).setResourceProvider("EXTERNAL_JS_SOURCE", new CardResourceProvider()).setCodeCacheSourceUrl("local://open_card").build();
        this.a = r20;
        if (r20 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r20 = null;
    L44:
        View r21 = r20.getLynxView();
        if (r8 == null) goto L50;
        ILarkLynxContainer r22 = this.a;
        if (r22 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r22 = null;
    L49:
        r22.updateGlobalData(r8);
    L50:
        r21.setFocusable(false);
        ((ViewGroup) findViewById(2131384822)).addView(r21);
        String r0 = ty7.a.a().getDebugUrl();
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == true) goto L53;
    L59:
        UniversalCardRuntimeJsLoader.b r23 = new UniversalCardRuntimeJsLoader().a();
        if (r23 != null) goto L62;
    L68:
        findViewById(2131366997).setOnClickListener(new b(this));
        return;
    L62:
        if (r23.c == null) goto L67;
        ILarkLynxContainer r24 = this.a;
        if (r24 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r24 = null;
    L66:
        r24.render(r23.c, r17, null);
        goto L68
    L67:
        Log.e("CardElementActivity", "js erro");
        goto L68
    L53:
        if (k.b(r0) == false) goto L59;
        if (r0 == null) goto L68;
        ILarkLynxContainer r25 = this.a;
        if (r25 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r25 = null;
    L58:
        r25.render(r0, r17, null);
        goto L68
    L24:
        if (TextUtils.equals("0", r3) == false) goto L27;
        r13 = true;
    L18:
        th = move-exception;
        Log.e("BaseNavBarUtils", "getNavBarOverride e: " + th);
        r3 = null;
        goto L21
    L26:
        r13 = !ViewConfiguration.get(this).hasPermanentMenuKey();
        goto L27
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r2);
        this.b = true;
    }
}
