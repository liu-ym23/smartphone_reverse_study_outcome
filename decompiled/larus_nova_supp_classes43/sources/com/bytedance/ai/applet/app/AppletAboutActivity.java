package com.bytedance.ai.applet.app;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.base.BaseActivity;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletAboutActivity;", "Lcom/bytedance/ai/applet/app/base/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openUrl", com.bytedance.android.ec.core.event.a.KEY_URL, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletAboutActivity extends BaseActivity {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.base.BaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r10 = FLogger.a;
        r10.i("ActivityLancet", "finish ".concat(AppletAboutActivity.class.getName()));
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

    @Override // com.bytedance.ai.applet.app.base.BaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletAboutActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
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

    public AppletAboutActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1(String r10) {
        if (r10 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L29;
        return;
    L29:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r11 = Result.constructor-impl(UriProtector.parse(r10));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r11) == false) goto L17;
        r11 = null;
    L17:
        Uri r12 = (Uri) r11;
        if (r12 != null) goto L31;
        return;
    L31:
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L26
        g2.b r13 = AppletRuntimeManager.d;     // Catch: Throwable -> L26
        if (r13 == null) goto L23;
        r13.K(this, r10);     // Catch: Throwable -> L26
    L24:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
        return;
    L23:
        startActivity(new Intent("android.intent.action.VIEW", r12));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L4:
        if (StringsKt.isBlank(r10) == true) goto L7;
        r0 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.base.BaseActivity
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r12);
        setContentView(2131558444);
        final View r13 = findViewById(2131363127);
        if (r13 == null) goto L99;
        final int r0 = r13.getPaddingTop();
        ViewCompat.setOnApplyWindowInsetsListener(r13, new com.bytedance.ai.applet.app.a(r13, r0));
        View r1 = findViewById(2131363124);
        if (r1 == null) goto L16;
        r1.setOnClickListener(new b(this));
    L16:
        String r10 = getIntent().getStringExtra("extra_app_name");
        String r11 = "";
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        String r14 = getIntent().getStringExtra("extra_app_desc");
        if (r14 == null) goto L23;
        r11 = r14;
    L23:
        String r15 = getIntent().getStringExtra("extra_app_icon");
        ImageView r16 = (ImageView) findViewById(2131363124);
        if (r16 == null) goto L26;
        com.bytedance.ai.utils.l.a.getClass();
        r16.setContentDescription(com.bytedance.ai.utils.l.d(this, "larus_accessibility_icon_back", 2131894316));
    L26:
        TextView r17 = (TextView) findViewById(2131390132);
        if (r17 == null) goto L29;
        com.bytedance.ai.utils.l.a.getClass();
        r17.setText(com.bytedance.ai.utils.l.d(this, "larus_appEntry_bottomSheet_checkbox_tos", 2131894322));
    L29:
        TextView r18 = (TextView) findViewById(2131391162);
        if (r18 == null) goto L32;
        com.bytedance.ai.utils.l.a.getClass();
        r18.setText(com.bytedance.ai.utils.l.d(this, "applet_about_privacy_policy", 2131894321));
    L32:
        TextView r19 = (TextView) findViewById(2131363123);
        if (r19 == null) goto L35;
        r19.setText(r10);
    L35:
        TextView r20 = (TextView) findViewById(2131363121);
        if (r20 == null) goto L38;
        r20.setText(r11);
    L38:
        SimpleDraweeView r21 = findViewById(2131363122);
        boolean r22 = true;
        if (r21 == null) goto L49;
        if (r15 != null) goto L42;
    L45:
        boolean r23 = true;
    L46:
        if (r23 == true) goto L48;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletAboutActivity$onCreate$3$1(r15, r21, null), 3, null);
        goto L49
    L48:
        r21.setActualImageResource(2131235790);
        goto L49
    L42:
        if (StringsKt.isBlank(r15) == true) goto L45;
        r23 = false;
    L49:
        final String r24 = getIntent().getStringExtra("extra_user_agreement_url");
        final String r25 = getIntent().getStringExtra("extra_privacy_policy_url");
        if (r24 != null) goto L52;
    L55:
        boolean r26 = true;
    L57:
        if (r26 == false) goto L61;
        View r27 = findViewById(2131363131);
        if (r27 == null) goto L64;
        r27.setVisibility(8);
    L64:
        if (r25 != null) goto L66;
    L69:
        boolean r28 = true;
    L71:
        if (r28 == false) goto L75;
        View r29 = findViewById(2131363126);
        if (r29 == null) goto L78;
        r29.setVisibility(8);
    L78:
        View r30 = findViewById(2131363129);
        if (r30 == null) goto L95;
        if (r25 != null) goto L82;
    L85:
        boolean r31 = true;
    L86:
        if (r31 == false) goto L94;
        if (r24 != null) goto L89;
    L92:
        if (r22 == false) goto L94;
        r30.setVisibility(8);
        goto L95
    L89:
        if (StringsKt.isBlank(r24) == true) goto L92;
        r22 = false;
    L94:
        r30.setVisibility(0);
        goto L95
    L82:
        if (StringsKt.isBlank(r25) == true) goto L85;
        r31 = false;
    L95:
        ViewCompat.requestApplyInsets(r13);
        return;
    L75:
        View r32 = findViewById(2131363126);
        if (r32 == null) goto L78;
        r32.setVisibility(0);
        r32.setOnClickListener(new d(this, r25));
        goto L78
    L66:
        if (StringsKt.isBlank(r25) == true) goto L69;
        r28 = false;
        goto L71
    L61:
        View r33 = findViewById(2131363131);
        if (r33 == null) goto L64;
        r33.setVisibility(0);
        r33.setOnClickListener(new c(this, r24));
        goto L64
    L52:
        if (StringsKt.isBlank(r24) == true) goto L55;
        r26 = false;
        goto L57
    }
}
