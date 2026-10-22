package com.larus.bmhome.miniartifact.template;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.utils.c;
import com.larus.mainbot.api.miniartifact.MiniArtifactBizInfo;
import com.larus.mainbot.api.miniartifact.MiniArtifactInputContent;
import com.larus.mainbot.api.miniartifact.MiniArtifactResource;
import com.larus.mainbot.api.miniartifact.MiniArtifactTemplateParams;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gr8.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/miniartifact/template/MiniArtifactTemplateActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "miniArtifactTemplateParams", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactTemplateParams;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseTemplateParams", "intent", "Landroid/content/Intent;", "parseMiniArtifactTemplateParamsFromSchema", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactTemplateActivity extends FlowCommonAppCompatActivity {
    public MiniArtifactTemplateParams g;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(MiniArtifactTemplateActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(MiniArtifactTemplateActivity.class.getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
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

    public MiniArtifactTemplateActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r28) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r28);
        Bundle r0 = getIntent().getExtras();
        if (r0 == null) goto L14;
        Serializable r1 = r0.getSerializable("mini_artifact_template_page_navigation_params");
    L16:
        if ((r1 instanceof MiniArtifactTemplateParams) == false) goto L18;
        MiniArtifactTemplateParams r2 = (MiniArtifactTemplateParams) r1;
    L19:
        if (r2 != null) goto L92;
        Intent r3 = getIntent();
        if (r3 == null) goto L23;
        Uri r4 = r3.getData();
    L24:
        FLogger.a.d("MiniArtifactTemplateActivity", "parseMiniArtifactTemplateParamsFromSchema, uri = " + r4);
        if (r4 == null) goto L27;
        String r5 = UriProtector.getQueryParameter(r4, "template_id");
    L28:
        if (r4 == null) goto L30;
        String r10 = UriProtector.getQueryParameter(r4, "template_image_url");
    L31:
        if (r4 == null) goto L33;
        String r14 = UriProtector.getQueryParameter(r4, "template_title");
    L34:
        if (r4 == null) goto L36;
        String r17 = UriProtector.getQueryParameter(r4, "template_prompt");
    L37:
        if (r4 == null) goto L39;
        String r13 = UriProtector.getQueryParameter(r4, "template_url");
    L40:
        if (r4 == null) goto L42;
        String r6 = UriProtector.getQueryParameter(r4, "template_enable_config");
    L43:
        boolean r7 = Intrinsics.areEqual(r6, "1");
        if (r4 == null) goto L46;
        String r8 = UriProtector.getQueryParameter(r4, "track_params");
    L47:
        if (r4 == null) goto L49;
        String r15 = UriProtector.getQueryParameter(r4, "template_version");
    L50:
        if (r4 == null) goto L52;
        String r9 = UriProtector.getQueryParameter(r4, "template_image_uri");
    L53:
        if (r4 == null) goto L55;
        String r23 = UriProtector.getQueryParameter(r4, "input_preview_url");
    L56:
        if (r4 == null) goto L58;
        String r11 = UriProtector.getQueryParameter(r4, "push_from_bottom");
    L59:
        boolean r24 = Intrinsics.areEqual(r11, "1");
        if (r4 == null) goto L62;
        String r12 = UriProtector.getQueryParameter(r4, "enter_method");
    L64:
        if (r4 == null) goto L66;
        String r16 = UriProtector.getQueryParameter(r4, "prompt_from");
    L104:
        String r25 = "mini_artifact_template_page_navigation_params";
        Object r18 = new Gson().fromJson(r8, new b().getType());     // Catch: Exception -> L72
    L77:
        if (r12 == null) goto L81;
        HashMap r19 = (HashMap) r18;
        if (r19 == null) goto L81;
        r19.put("enter_method", r12);
    L81:
        if (r16 == null) goto L86;
        HashMap r20 = (HashMap) r18;
        if (r20 == null) goto L86;
        r20.put("prompt_from", r16);
    L86:
        if (o0.d(r9) == true) goto L88;
    L90:
        List r110 = null;
    L91:
        r2 = new MiniArtifactTemplateParams(new MiniArtifactInputContent(null, r17, r110, new MiniArtifactBizInfo(r5, r15), (Map) r18, 1, null), r13, r14, Boolean.valueOf(r7), r23, Boolean.valueOf(r24));
    L93:
        this.g = r2;
        setContentView(2131561787);
        if (getSupportFragmentManager().findFragmentByTag("MiniArtifactTemplateFragment") != null) goto L110;
        MiniArtifactTemplateFragment r21 = new MiniArtifactTemplateFragment();
        Bundle r22 = getIntent().getExtras();
        if (r22 != null) goto L98;
        r22 = new Bundle();
    L98:
        r22.putSerializable(r25, this.g);
        r21.setArguments(r22);
        FragmentTransaction r26 = getSupportFragmentManager().beginTransaction();
        r26.setReorderingAllowed(true);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r26, r21, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "MiniArtifactTemplateFragment", 2131373275) == true) goto L102;
        r26.replace(2131373275, r21, "MiniArtifactTemplateFragment");
    L102:
        r26.commit();
        return;
    L110:
        return;
    L88:
        if (o0.d(r10) == false) goto L90;
        r110 = CollectionsKt.listOf(new MiniArtifactResource(null, r9, r10, 1, null));
    L72:
        e = e;
    L76:
        FLogger.a.e("MiniArtifactTemplateActivity", "parseMiniArtifactTemplateParamsFromSchema, templateEventMapString = " + r8 + ", e = " + e);
        r18 = null;
    L74:
        e = e;
        r25 = "mini_artifact_template_page_navigation_params";
        goto L76
    L66:
        r16 = null;
        goto L104
    L62:
        r12 = null;
        goto L64
    L58:
        r11 = null;
        goto L59
    L55:
        r23 = null;
        goto L56
    L52:
        r9 = null;
        goto L53
    L49:
        r15 = null;
        goto L50
    L46:
        r8 = null;
        goto L47
    L42:
        r6 = null;
        goto L43
    L39:
        r13 = null;
        goto L40
    L36:
        r17 = null;
        goto L37
    L33:
        r14 = null;
        goto L34
    L30:
        r10 = null;
        goto L31
    L27:
        r5 = null;
        goto L28
    L23:
        r4 = null;
        goto L24
    L92:
        r25 = "mini_artifact_template_page_navigation_params";
        goto L93
    L18:
        r2 = null;
        goto L19
    L14:
        r1 = null;
        goto L16
    }
}
