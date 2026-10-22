package com.larus.bmhome.miniartifact.product;

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
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.mainbot.api.miniartifact.MiniArtifactBizInfo;
import com.larus.mainbot.api.miniartifact.MiniArtifactInputContent;
import com.larus.mainbot.api.miniartifact.MiniArtifactProductParams;
import com.larus.mainbot.api.miniartifact.MiniArtifactResource;
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
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/miniartifact/product/MiniArtifactProductActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "miniArtifactProductParams", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactProductParams;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseProductParams", "intent", "Landroid/content/Intent;", "parseMiniArtifactSchemaWithUserInfo", "uri", "Landroid/net/Uri;", "parseMiniArtifactSchemaWithArtifact", "parseMiniArtifactSchema", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactProductActivity extends FlowCommonAppCompatActivity {
    public MiniArtifactProductParams g;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(MiniArtifactProductActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(MiniArtifactProductActivity.class.getName()));
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

    public MiniArtifactProductActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r32) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r32);
        setContentView(2131561787);
        Bundle r0 = getIntent().getExtras();
        String r3 = "mini_artifact_product_page_navigation_params";
        if (r0 == null) goto L14;
        Serializable r1 = r0.getSerializable("mini_artifact_product_page_navigation_params");
    L16:
        if ((r1 instanceof MiniArtifactProductParams) == false) goto L18;
        MiniArtifactProductParams r2 = (MiniArtifactProductParams) r1;
    L19:
        if (r2 != null) goto L153;
        Intent r4 = getIntent();
        if (r4 == null) goto L23;
        Uri r5 = r4.getData();
    L24:
        FLogger.a.i("MiniArtifactProductActivity", "parseMiniArtifactTemplateParamsFromSchema, uri = " + r5);
        if (r5 == null) goto L27;
        String r6 = UriProtector.getQueryParameter(r5, "mini_artifact_url");
    L29:
        if (o0.d(r6) == false) goto L64;
        if (r5 == null) goto L32;
        String r15 = UriProtector.getQueryParameter(r5, "mini_artifact_url");
    L33:
        if (r5 == null) goto L35;
        String r17 = UriProtector.getQueryParameter(r5, "mini_artifact_title");
    L36:
        if (r5 == null) goto L38;
        String r7 = UriProtector.getQueryParameter(r5, "mini_artifact_finished");
    L39:
        boolean r8 = Intrinsics.areEqual(r7, "1");
        if (r5 == null) goto L42;
        String r19 = UriProtector.getQueryParameter(r5, "mini_artifact_id");
    L43:
        if (r5 == null) goto L45;
        String r9 = UriProtector.getQueryParameter(r5, "track_params");
    L46:
        if (r5 == null) goto L48;
        String r11 = UriProtector.getQueryParameter(r5, "push_from_bottom");
    L49:
        boolean r12 = Intrinsics.areEqual(r11, "1");
        if (r5 == null) goto L52;
        String r13 = UriProtector.getQueryParameter(r5, "enter_method");
    L167:
        Object r10 = new Gson().fromJson(r9, new com.larus.bmhome.miniartifact.product.a().getType());     // Catch: Exception -> L56
    L58:
        if (r13 == null) goto L62;
        HashMap r14 = (HashMap) r10;
        if (r14 == null) goto L62;
        r14.put("enter_method", r13);
    L62:
        r2 = new MiniArtifactProductParams(r15, "", r17, Boolean.valueOf(r8), r19, (Map) r10, null, Boolean.valueOf(r12), 64, null);
    L56:
        e = move-exception;
        FLogger.a.e("MiniArtifactTemplateActivity", "parseMiniArtifactTemplateParamsFromSchema, templateEventMapString = " + r9 + ", e = " + e);
        r10 = null;
        goto L58
    L52:
        r13 = null;
        goto L167
    L48:
        r11 = null;
        goto L49
    L45:
        r9 = null;
        goto L46
    L42:
        r19 = null;
        goto L43
    L38:
        r7 = null;
        goto L39
    L35:
        r17 = null;
        goto L36
    L32:
        r15 = null;
        goto L33
    L64:
        if (r5 == null) goto L66;
        String r16 = UriProtector.getQueryParameter(r5, "template_id");
    L67:
        if (r5 == null) goto L69;
        String r18 = UriProtector.getQueryParameter(r5, "template_image_url");
    L70:
        if (r5 == null) goto L72;
        String r110 = UriProtector.getQueryParameter(r5, "template_title");
    L73:
        if (r5 == null) goto L75;
        String r21 = UriProtector.getQueryParameter(r5, "template_prompt");
    L76:
        if (r5 == null) goto L78;
        UriProtector.getQueryParameter(r5, "template_url");
    L78:
        if (r5 == null) goto L80;
        String r111 = UriProtector.getQueryParameter(r5, "template_enable_config");
    L81:
        boolean r27 = Intrinsics.areEqual(r111, "1");
        if (r5 == null) goto L84;
        String r20 = UriProtector.getQueryParameter(r5, "template_version");
    L85:
        if (r5 == null) goto L87;
        String r112 = UriProtector.getQueryParameter(r5, "template_image_uri");
    L88:
        if (r5 == null) goto L90;
        String r22 = UriProtector.getQueryParameter(r5, "input_preview_url");
    L91:
        if (r5 == null) goto L93;
        String r113 = UriProtector.getQueryParameter(r5, "track_params");
    L94:
        if (r5 == null) goto L96;
        String r114 = UriProtector.getQueryParameter(r5, "push_from_bottom");
    L97:
        boolean r115 = Intrinsics.areEqual(r114, "1");
        if (r5 == null) goto L100;
        String r116 = UriProtector.getQueryParameter(r5, "enter_method");
    L102:
        if (r5 == null) goto L104;
        String r23 = UriProtector.getQueryParameter(r5, "prompt_from");
    L165:
        String r29 = r22;
        Object r24 = new Gson().fromJson(r113, new b().getType());     // Catch: Exception -> L110
    L115:
        if (r116 == null) goto L119;
        HashMap r25 = (HashMap) r24;
        if (r25 == null) goto L119;
        r25.put("enter_method", r116);
    L119:
        if (r23 == null) goto L123;
        HashMap r26 = (HashMap) r24;
        if (r26 == null) goto L123;
        r26.put("prompt_from", r23);
    L123:
        HashMap r28 = (HashMap) r24;
        if (r28 == null) goto L146;
        r28.put("template_id", r16);
        r28.put("template_version", r20);
        r28.put("template_name", r110);
        IActionBarService r30 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r30 == null) goto L146;
        z0 r31 = r30.e(31);
        if (r31 == null) goto L146;
        r28.put("action_bar_key", r31.b);
        r28.put("action_bar_template_id", 31);
        boolean r33 = false;
        if (r112 == null) goto L139;
        if (r112.length() <= 0) goto L134;
        boolean r34 = true;
    L136:
        if (r34 != true) goto L139;
        r33 = true;
        goto L139
    L134:
        r34 = false;
    L139:
        if (r33 == false) goto L141;
        String r35 = "chat_album_preview_click";
    L142:
        r28.put("content_source_entrance", r35);
        r28.put("scene", ar8.b.c(r28));
        r28.put("is_action_bar", Integer.valueOf(Intrinsics.areEqual(r116, "chat_action_bar") ? 1 : 0));
        if (o0.d(r16) == false) goto L145;
        r28.put("original_content_source", "use_template");
        goto L146
    L145:
        r28.put("original_content_source", "");
        goto L146
    L141:
        r35 = "";
    L146:
        String r36 = UUID.randomUUID().toString();
        if (o0.d(r112) == true) goto L149;
    L151:
        List r210 = null;
    L152:
        Map r37 = (Map) r24;
        MiniArtifactInputContent r38 = new MiniArtifactInputContent(null, r21, r210, new MiniArtifactBizInfo(r16, r20), r37, 1, null);
        Lazy r39 = br8.l.a;
        Intrinsics.checkNotNullParameter(r36, "inputContentId");
        ((Map) br8.l.a.getValue()).put(r36, r38);
        MiniArtifactProductParams r40 = new MiniArtifactProductParams(r29, r36, r110, Boolean.FALSE, "", r37, Boolean.valueOf(r27), Boolean.valueOf(r115));
    L154:
        this.g = r40;
        if (getSupportFragmentManager().findFragmentByTag("MiniArtifactProductFragment") != null) goto L173;
        MiniArtifactProductFragment r41 = new MiniArtifactProductFragment();
        Bundle r42 = getIntent().getExtras();
        if (r42 != null) goto L159;
        r42 = new Bundle();
    L159:
        r42.putSerializable(r3, this.g);
        r41.setArguments(r42);
        FragmentTransaction r43 = getSupportFragmentManager().beginTransaction();
        r43.setReorderingAllowed(true);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r43, r41, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "MiniArtifactProductFragment", 2131373275) == true) goto L163;
        r43.replace(2131373275, r41, "MiniArtifactProductFragment");
    L163:
        r43.commit();
        return;
    L173:
        return;
    L149:
        if (o0.d(r18) == false) goto L151;
        r210 = CollectionsKt.listOf(new MiniArtifactResource(null, r112, r18, 1, null));
    L110:
        e = e;
    L114:
        FLogger.a.e("MiniArtifactTemplateActivity", "parseMiniArtifactTemplateParamsFromSchema, templateEventMapString = " + r113 + ", e = " + e);
        r24 = null;
    L112:
        e = e;
        r29 = r22;
        goto L114
    L104:
        r23 = null;
        goto L165
    L100:
        r116 = null;
        goto L102
    L96:
        r114 = null;
        goto L97
    L93:
        r113 = null;
        goto L94
    L90:
        r22 = null;
        goto L91
    L87:
        r112 = null;
        goto L88
    L84:
        r20 = null;
        goto L85
    L80:
        r111 = null;
        goto L81
    L75:
        r21 = null;
        goto L76
    L72:
        r110 = null;
        goto L73
    L69:
        r18 = null;
        goto L70
    L66:
        r16 = null;
        goto L67
    L27:
        r6 = null;
        goto L29
    L23:
        r5 = null;
    L153:
        r3 = "mini_artifact_product_page_navigation_params";
        r40 = r2;
        goto L154
    L18:
        r2 = null;
        goto L19
    L14:
        r1 = null;
        goto L16
    }
}
