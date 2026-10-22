package com.larksuite.component.card.component.table;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader;
import com.larksuite.component.card.cardcontainer.c;
import com.larksuite.component.card.component.CardResourceProvider;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/component/table/TableDetailActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "mLynxContainer", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "buildContainer", "Landroid/view/View;", "globalData", "", "getDebugUrl", "onDestroy", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TableDetailActivity extends BaseFragmentActivity {
    public static WeakReference<c> b;
    public static String c;
    public ILarkLynxContainer a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(TableDetailActivity.class.getName()));
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(TableDetailActivity.class.getName()));
    L5:
        super.onDestroy();
        ILarkLynxContainer r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r0 = null;
    L8:
        r0.destroy();
        b = null;
        c = null;
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

    public TableDetailActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r8);
        setContentView(2131564929);
        String r9 = c;
        String r0 = getIntent().getStringExtra("global_props");
        com.larksuite.component.card.cardcontainer.a r1 = new com.larksuite.component.card.cardcontainer.a();
        vy7.a r2 = new vy7.a();
        LarkLynxContainerBuilder r3 = new LarkLynxContainerBuilder(this).tagForJsContext("UniversalCard").tagForCustomComponent("UniversalCard").containerContext(r1).tagForBridgeMethodDispatcher("UniversalCard");
        r3.lynxViewLifeCycle(r2);
        ILarkLynxContainer r4 = r3.setEnableUserCodeCache(true).setResourceProvider("EXTERNAL_JS_SOURCE", new CardResourceProvider()).setCodeCacheSourceUrl("local://open_card").build();
        this.a = r4;
        ILarkLynxContainer r5 = null;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r4 = null;
    L13:
        View r6 = r4.getLynxView();
        if (r0 == null) goto L19;
        ILarkLynxContainer r7 = this.a;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r7 = null;
    L18:
        r7.updateGlobalData(r0);
    L19:
        r6.setFocusable(false);
        ((ViewGroup) findViewById(2131384822)).addView(r6);
        String r10 = ty7.a.a().getDebugUrl();
        boolean r11 = DevEnvUtil.isDevelopPackage(LarkContext.getApplication());
        LinkedHashMap r12 = new LinkedHashMap();
        WeakReference<c> r13 = b;
        if (r13 == null) goto L24;
        c r14 = r13.get();
        if (r14 == null) goto L24;
        r12.put("card_share_data", r14);
    L24:
        r12.put("in_detail", Boolean.TRUE);
        if (r11 == true) goto L27;
    L34:
        UniversalCardRuntimeJsLoader.b r15 = new UniversalCardRuntimeJsLoader().a();
        if (r15 != null) goto L37;
        return;
    L37:
        if (r15.c == null) goto L43;
        ILarkLynxContainer r16 = this.a;
        if (r16 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
    L42:
        r5.render(r15.c, r9, r12);
        return;
    L41:
        r5 = r16;
        goto L42
    L43:
        Log.e(((BaseFragmentActivity) this).PARENT_TAG, "js erro");
        return;
    L27:
        if (k.b(r10) == false) goto L34;
        if (r10 == null) goto L47;
        ILarkLynxContainer r17 = this.a;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
    L33:
        r5.render(r10, r9, r12);
        return;
    L32:
        r5 = r17;
        goto L33
    }
}
