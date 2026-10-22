package com.larksuite.framework.apiplugin.core;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.jaeger.library.StatusBarUtil;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.utils.RomUtils;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import i18.d;
import j18.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l18.g;
import o18.a;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKTransActivity extends Activity {
    public static final Map<Integer, b> c = null;
    public static final Map<Integer, LKEvent> d = null;
    public final Map<LKTransActivity, LKCallProxyActivityCallback> a;
    public boolean b;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    static {
        c = new HashMap();
        d = new HashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0112 */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
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

    @Override // android.app.Activity
    public final void onDestroy() {
        Log.i("LKTransActivity", "onDestroy");
        super.onDestroy();
        int r0 = getIntent().getIntExtra("nodeIdParams", -1);
        if (r0 == (-1)) goto L5;
        ((HashMap) c).remove(Integer.valueOf(r0));
    L5:
        Log.i("LKTransActivity", "onDestroy enableFinishCallback");
        int r1 = getIntent().getIntExtra("eventIdParams", -1);
        if (r1 == (-1)) goto L13;
        Log.i("LKTransActivity", "onDestroy enableFinishCallback with eventId: " + r1);
        LKEvent r2 = (LKEvent) ((HashMap) d).remove(Integer.valueOf(r1));
        if (r2 == null) goto L13;
        if (this.b == true) goto L13;
        LKBaseResponseModel r3 = new LKBaseResponseModel();
        r3.setApiErrNo(a.k);
        r2.b(r3);
    L13:
        if (((LKCallProxyActivityCallback) ((HashMap) this.a).remove(this)) != null) goto L15;
        return;
    L15:
        Log.i("LKTransActivity", "remove callback");
    }

    public LKTransActivity() {
        this.a = new HashMap();
        this.b = false;
    }

    @Override // android.app.Activity
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

    @Override // android.app.Activity
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        Log.i("LKTransActivity", "onCreate");
        super.onCreate(r5);
        if (RomUtils.l(true, this, getWindow()) == false) goto L13;
        StatusBarUtil.setColorNoTranslucent(this, 0);
    L13:
        Serializable r6 = getIntent().getSerializableExtra("callbackParams");
        if ((r6 instanceof LKCallProxyActivityCallback) == true) goto L16;
        Log.e("LKTransActivity", "invalid callback");
        this.b = true;
        finish();
        return;
    L16:
        Window r1 = getWindow();
        r1.setGravity(51);
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.x = 0;
        r3.y = 0;
        r3.width = 1;
        r3.height = 1;
        r3.type = 2002;
        r3.flags = 32;
        r1.setAttributes(r3);
        LKCallProxyActivityCallback r7 = (LKCallProxyActivityCallback) r6;
        ((HashMap) this.a).put(this, r7);
        r7.onCreated(this);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int r5, int r6, Intent r7) {
        Log.i("LKTransActivity", "onActivityResult");
        super.onActivityResult(r5, r6, r7);
        int r1 = getIntent().getIntExtra("nodeIdParams", -1);
        if (r1 == (-1)) goto L13;
        b r2 = (b) ((HashMap) c).remove(Integer.valueOf(r1));
        Log.i("LKTransActivity", "request code:" + r5 + " result code:" + r6);
        if ((r2 instanceof l18.a) == false) goto L13;
        g r0 = ((l18.a) r2).c;
        if (r0 == null) goto L12;
        Iterator r3 = ((ArrayList) r0.a).iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((d) r3.next()).handleActivityResult(r5, r6, r7);
    L12:
        r2.c();
    L13:
        this.b = true;
        finish();
    }
}
