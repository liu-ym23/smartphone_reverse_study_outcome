package com.larus.dorag.widget;

import android.R;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.home.api.main.IHomeApi;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019H\u0002¨\u0006\u001b"}, d2 = {"Lcom/larus/dorag/widget/DoraWidgetRedirectActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getBackgroundResource", "", "buildManagePageIntent", "Landroid/content/Intent;", "doraService", "Lcom/larus/dora/api/IDoraService;", "flags", "shouldInterceptDoraGRecordMinutes", "", "isRecorderAppVersionSupported", "versionCodeCompat", "", "Landroid/content/pm/PackageInfo;", "startActivities", "context", "Landroid/content/Context;", "intents", "", "Companion", "dorag_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWidgetRedirectActivity extends FlowCommonAppCompatActivity {

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131102535;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraWidgetRedirectActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraWidgetRedirectActivity.class.getName()));
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

    public DoraWidgetRedirectActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r27) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r27);
        String r0 = f.a;
        IHomeApi r1 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r1 == null) goto L14;
        FLogger.a.i("DoraWidgetCenter", "enter APP from widget, disable hot launch temporarily");
        r1.C(false);
        f.e = true;
    L14:
        setContentView(2131561787);
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        String r4 = getIntent().getStringExtra("redirect_target");
        String r5 = "";
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        if (r2 == null) goto L21;
        DeviceService r6 = r2.device();
        if (r6 == null) goto L21;
        String r7 = r6.n();
    L22:
        String r8 = getIntent().getStringExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        String r9 = getIntent().getStringExtra("widget_size");
        if (r9 != null) goto L28;
        r9 = "";
    L28:
        String r10 = getIntent().getStringExtra("diary_date");
        if (r10 != null) goto L31;
        r10 = "";
    L31:
        if (r2 == null) goto L35;
        DeviceService r11 = r2.device();
        if (r11 == null) goto L35;
        int r12 = r11.y();
    L36:
        ArrayList r13 = new ArrayList();
        FLogger r14 = FLogger.a;
        String r15 = "DoraWidgetRedirectActivity";
        r14.i("DoraWidgetRedirectActivity", "redirectTarget: ".concat(r4));
        if (AppHost.a.a().a(this, null) != null) goto L41;
        Intent r3 = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (r3 == null) goto L41;
        r3.addFlags(268468224);
        startActivity(r3);
    L41:
        IDoraAVLinkService r16 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r16 != null) goto L44;
    L46:
        boolean r17 = false;
    L47:
        if (r17 == true) goto L49;
    L58:
        boolean r18 = false;
    L59:
        r14.i("DoraWidgetRedirectActivity", "isObricNewDeviceManageAllowed=" + r18);
        if (AccountService.a.isLogin().booleanValue() == false) goto L241;
        if (r2 == null) goto L65;
        String r110 = r9;
        if (r2.j1() != true) goto L66;
        boolean r20 = true;
    L67:
        Object r111 = "note";
        if (r18 == false) goto L75;
        if (r20 == false) goto L75;
        if (Intrinsics.areEqual(r4, "diary") == false) goto L73;
    L74:
        boolean r112 = true;
    L77:
        if (r18 == true) goto L80;
        if (r20 == true) goto L80;
        i r21 = SmartRouter.buildRoute(this, "//flow/dora/device_list");
        r21.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_list_v2");
        r21.c.addFlags(603979776);
        Intent r22 = r21.b();
        Intrinsics.checkNotNull(r22);
        r13.add(r22);
        String r23 = r4;
        r5 = "";
    L243:
        if (r13.isEmpty() == false) goto L266;
        FLogger.a.i(r15, "startActivities skipped: empty intents");
    L254:
        if (Intrinsics.areEqual(r23, r111) == false) goto L261;
        int r24 = f79.a.a;
        String r25 = r5;
        String r26 = AppHost.a.getApplication().getSharedPreferences(f79.a.c(), 0).getString("noteUrl", r25);
        if (r26 != null) goto L259;
        r26 = r25;
    L259:
        if (Intrinsics.areEqual(r26, r25) == true) goto L261;
        SmartRouter.buildRoute(this, r26).d();
    L261:
        int r28 = rs9.a.a;
        Intrinsics.checkNotNullParameter(r23, "redirectTarget");
        String r30 = r110;
        Intrinsics.checkNotNullParameter(r30, "widgetSize");
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put("type", r23);
        r31.put("size", r30);
        IDoraService r32 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r32 == null) goto L264;
        r32.A0("dora_widget_click", r31);
    L264:
        finish();
        return;
    L266:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L248
        startActivities((Intent[]) r13.toArray(new Intent[0]));     // Catch: Throwable -> L248
        Object r34 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L248
    L250:
        Throwable r35 = Result.exceptionOrNull-impl(r34);
        if (r35 == null) goto L254;
        FLogger.a.e(r15, "startActivities failed", r35);
    L248:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
    L80:
        String r210 = r4;
        if (r18 == false) goto L95;
        if (r20 == false) goto L84;
        String r37 = "//flow/dora/obric_device_home";
    L85:
        i r38 = SmartRouter.buildRoute(this, r37);
        r38.c.addFlags(603979776);
        if (r112 == false) goto L93;
        r14.i("DoraWidgetRedirectActivity", "open obric device home with diary tab, date=".concat(r10));
        r38.j("obric_device_home_tab", "diary");
        if (r10.length() <= 0) goto L90;
        boolean r40 = true;
    L91:
        if (r40 == false) goto L94;
        r38.j("obric_device_home_diary_date", r10);
    L94:
        Intent r41 = r38.b();
        Intrinsics.checkNotNull(r41);
        r13.add(r41);
        r5 = "";
        FLogger r211 = r14;
        Object r212 = "diary";
        String r213 = "DoraWidgetRedirectActivity";
    L112:
        if (r112 == true) goto L239;
        String r42 = "mac";
        switch(r210.hashCode()) {
            case -1409922470: goto L238;
            case -1147999806: goto L173;
            case 3387378: goto L172;
            case 92896879: goto L166;
            case 95577027: goto L152;
            case 348618829: goto L116;
            default: goto L239;
        };
    L116:
        r23 = r210;
        if (r23.equals("diary_detail") == false) goto L240;
        String r43 = getIntent().getStringExtra("diary_id");
        if (r43 != null) goto L122;
        r43 = r5;
    L122:
        if (r18 == false) goto L130;
        r15 = r213;
        r211.i(r15, "obric has no diary detail page, open diary page, date=" + r10 + ", diaryId=" + r43);
        i r44 = SmartRouter.buildRoute(this, "//flow/dora/o/diary");
        if (r10.length() <= 0) goto L126;
        boolean r113 = true;
    L127:
        if (r113 == false) goto L129;
        r44.j("dora_o_diary_date", r10);
    L129:
        r44.c.addFlags(603979776);
        Intent r45 = r44.b();
        Intrinsics.checkNotNull(r45);
        r13.add(r45);
        goto L243
    L126:
        r113 = false;
        goto L127
    L130:
        FLogger r114 = r211;
        r15 = r213;
        IDoraAVLinkService r46 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r46 != null) goto L133;
    L142:
        boolean r47 = false;
    L143:
        if (r47 == false) goto L146;
        r114.i(r15, "diary beta enabled, opened h5 directly, date=".concat(r10));
        goto L243
    L146:
        if (r43.length() <= 0) goto L148;
        boolean r115 = true;
    L149:
        if (r115 == false) goto L151;
        i r48 = SmartRouter.buildRoute(this, "//flow/dora/env_observer_diary_detail");
        Bundle r50 = com.larus.utils.f.c(new Pair[0]);
        r50.putInt("product_id", r12);
        r48.c.putExtras(r50);
        r48.c.putExtra("mac", r7);
        r48.c.putExtra("diary_id", r43);
        r48.c.addFlags(603979776);
        Intent r51 = r48.b();
        Intrinsics.checkNotNull(r51);
        r13.add(r51);
        goto L243
    L151:
        i r52 = SmartRouter.buildRoute(this, "//flow/dora/env_observer_diary");
        Bundle r53 = com.larus.utils.f.c(new Pair[0]);
        r53.putInt("product_id", r12);
        r52.c.putExtras(r53);
        r52.c.putExtra("mac", r7);
        Intent r54 = r52.b();
        Intrinsics.checkNotNull(r54);
        r13.add(r54);
        goto L243
    L148:
        r115 = false;
        goto L149
    L133:
        if (r10.length() <= 0) goto L135;
        boolean r55 = true;
    L136:
        if (r55 == false) goto L138;
        String r56 = r10;
    L140:
        if (r46.i1(this, r56, "widget") != true) goto L142;
        r47 = true;
        goto L143
    L138:
        r56 = null;
        goto L140
    L135:
        r55 = false;
    L240:
        r15 = r213;
        goto L243
    L152:
        r23 = r210;
        FLogger r116 = r211;
        r15 = r213;
        if (r23.equals(r212) == false) goto L243;
        if (r18 == false) goto L157;
        i r57 = SmartRouter.buildRoute(this, "//flow/dora/o/diary");
        r57.c.addFlags(603979776);
        Intent r58 = r57.b();
        Intrinsics.checkNotNull(r58);
        r13.add(r58);
        goto L243
    L157:
        IDoraAVLinkService r60 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r60 != null) goto L160;
    L162:
        boolean r117 = false;
    L163:
        if (r117 == false) goto L165;
        r116.i(r15, "diary beta enabled, opened h5 directly for diary entry");
        goto L243
    L165:
        i r61 = SmartRouter.buildRoute(this, "//flow/dora/env_observer_diary");
        Bundle r62 = com.larus.utils.f.c(new Pair[0]);
        r62.putInt("product_id", r12);
        r61.c.putExtras(r62);
        r61.c.putExtra("mac", r7);
        Intent r63 = r61.b();
        Intrinsics.checkNotNull(r63);
        r13.add(r63);
        goto L243
    L160:
        if (r60.i1(this, null, "widget") != true) goto L162;
        r117 = true;
        goto L163
    L166:
        r23 = r210;
        r15 = r213;
        if (r23.equals("album") == false) goto L243;
        if (r18 == false) goto L171;
        Intent r64 = new Intent("gallery3d.intent.appintent.albumcommon").setPackage("com.android.gallery3d").putExtra("app_intent_param_album_key", "dorag").putExtra("finish_host_activity_on_exit", true).addCategory("android.intent.category.DEFAULT");
        Intrinsics.checkNotNull(r64);
        r13.add(r64);
        goto L243
    L171:
        Intent r65 = SmartRouter.buildRoute(this, "//flow/dora/media_album").b();
        Intrinsics.checkNotNull(r65);
        r13.add(r65);
        goto L243
    L172:
        r111 = r111;
        r23 = r210;
        r15 = r213;
        r23.equals(r111);
    L175:
        r111 = r111;
        goto L243
    L173:
        r111 = r111;
        r23 = r210;
        r15 = r213;
        if (r23.equals("record_minute") == false) goto L175;
        if (r2 == null) goto L182;
        DeviceService r66 = r2.device();
        if (r66 == null) goto L182;
        if (r66.M() != true) goto L182;
        boolean r67 = true;
    L183:
        boolean r68 = ObricFeatureServiceDelegate.b.b();
        IObricDoraService r70 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r70 == null) goto L189;
        if (r70.k() != true) goto L189;
        boolean r118 = true;
    L190:
        if (r67 == false) goto L194;
        if (r68 == false) goto L194;
        if (r118 == false) goto L194;
        boolean r119 = true;
    L196:
        if (r119 == true) goto L270;
        r111 = r111;
        r42 = "mac";
    L229:
        boolean r71 = false;
    L230:
        if (r119 == false) goto L233;
        if (r71 == false) goto L233;
        boolean r72 = true;
    L234:
        FLogger r73 = FLogger.a;
        r73.i(r15, "shouldInterceptDoraGRecordMinutes shouldIntercept=" + r72 + ", isDoraG=" + r67 + ", isObricOs=" + r68 + ", isDefaultAssistant=" + r118 + ", isRecorderAppVersionSupported=" + r71);
        if (r72 == false) goto L237;
        r73.i(r15, "record minutes intercept enabled");
        Intent r74 = new Intent().setPackage("com.obric.recorder").putExtra("com.obric.recorder.extra.TARGET_TAB", "wearable");
        Intrinsics.checkNotNull(r74);
        r13.add(r74);
        goto L243
    L237:
        i r75 = SmartRouter.buildRoute(this, "//flow/dora/record_minutes_list");
        r75.c.putExtra(r42, r7);
        Intent r76 = r75.b();
        Intrinsics.checkNotNull(r76);
        r13.add(r76);
    L233:
        r72 = false;
        goto L234
    L270:
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L206
        PackageInfo r78 = getPackageManager().getPackageInfo("com.obric.recorder", 0);     // Catch: Throwable -> L206
        if (Build.VERSION.SDK_INT < 28) goto L201;
        long r120 = r78.getLongVersionCode();     // Catch: Throwable -> L206
    L268:
        Object r80 = Result.constructor-impl(Long.valueOf(r120));     // Catch: Throwable -> L204
    L209:
        Throwable r81 = Result.exceptionOrNull-impl(r80);
        if (r81 == null) goto L217;
        if ((r81 instanceof PackageManager.NameNotFoundException) == false) goto L214;
        FLogger.a.i(r15, "recorder app is not installed");
        goto L217
    L214:
        FLogger.a.w(r15, "get recorder app version failed, error=" + r81.getMessage(), r81);
    L217:
        if (Result.isFailure-impl(r80) == false) goto L219;
        r80 = null;
    L219:
        Long r82 = (Long) r80;
        if (r82 != null) goto L222;
    L224:
        boolean r83 = false;
    L225:
        FLogger.a.i(r15, "isRecorderAppVersionSupported supported=" + r83 + ", recorderVersionCode=" + r82 + ", minVersionCode=1020600000");
        if (r83 == false) goto L229;
        r71 = true;
        goto L230
    L222:
        if (r82.longValue() < 1020600000) goto L224;
        r83 = true;
    L204:
        th = th;
    L208:
        Result.Companion r84 = Result.Companion;
        r80 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L209
    L201:
        r120 = r78.versionCode;     // Catch: Throwable -> L206
    L206:
        th = th;
        r42 = "mac";
    L194:
        r119 = false;
    L189:
        r118 = false;
    L182:
        r67 = false;
        goto L183
    L238:
        r23 = r210;
        r15 = r213;
        r23.equals("device_detail");
    L239:
        r23 = r210;
        goto L240
    L90:
        r40 = false;
        goto L91
    L93:
        r14.i("DoraWidgetRedirectActivity", "open obric device home with device tab");
        r38.j("obric_device_home_tab", "device");
        goto L94
    L84:
        r37 = "//flow/dora/obric_device_list";
        goto L85
    L95:
        r212 = "diary";
        r211 = r14;
        r213 = "DoraWidgetRedirectActivity";
        String r121 = "//dora_g_device_management";
        if (Intrinsics.areEqual(r7, "") == false) goto L98;
    L100:
        if (r2 == null) goto L109;
        t39.d r85 = r2.L();
        if (r85 == null) goto L109;
        if (r2.X(r85.c) == true) goto L108;
        r121 = "//dora_dynamic_list";
    L108:
        i r86 = SmartRouter.buildRoute(this, r121);
        r86.c.putExtra("product_id", r85.c);
        r86.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r85.e);
        r86.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r85.b);
        r86.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");
        r86.c.addFlags(603979776);
        Intent r87 = r86.b();
    L110:
        if (r87 == null) goto L112;
        r13.add(r87);
    L109:
        r87 = null;
        goto L110
    L98:
        if (Intrinsics.areEqual(r8, "") == true) goto L100;
        i r88 = SmartRouter.buildRoute(this, "//dora_g_device_management");
        r88.c.putExtra("product_id", r12);
        r88.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r8);
        r88.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r7);
        r88.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");
        r88.c.addFlags(603979776);
        Intent r90 = r88.b();
        Intrinsics.checkNotNull(r90);
        r13.add(r90);
        r5 = "";
        goto L112
    L73:
        if (Intrinsics.areEqual(r4, "diary_detail") == true) goto L74;
    L75:
        r112 = false;
    L66:
        r20 = false;
        goto L67
    L65:
        r110 = r9;
        goto L66
    L241:
        r23 = r4;
        r5 = "";
        r110 = r9;
        r111 = "note";
        goto L243
    L49:
        if (ObricFeatureServiceDelegate.b.b() == false) goto L58;
        IObricDoraService r91 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r91 != null) goto L53;
    L55:
        boolean r92 = false;
    L56:
        if (r92 == false) goto L58;
        r18 = true;
        goto L59
    L53:
        if (r91.h() != true) goto L55;
        r92 = true;
        goto L56
    L44:
        if (r16.P0() != true) goto L46;
        r17 = true;
    L35:
        r12 = 16;
    L21:
        r7 = "";
        goto L22
    }
}
