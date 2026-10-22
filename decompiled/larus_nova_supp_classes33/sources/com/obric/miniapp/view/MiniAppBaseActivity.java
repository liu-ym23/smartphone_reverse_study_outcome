package com.obric.miniapp.view;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.ai.api.AppletService;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonObject;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.home.impl.MainActivity;
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
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.miniapp.utils.MiniAppUtils;
import com.obric.miniapp.utils.g1;
import com.obric.miniapp.utils.k1;
import com.obric.miniapp.utils.m0;
import com.obric.miniapp.utils.p0;
import com.obric.miniapp.utils.v0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0017\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u001bJ\b\u0010#\u001a\u00020\u001bH\u0014J\b\u0010$\u001a\u00020\u001bH\u0014J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u001bH\u0014J\b\u00102\u001a\u00020\u001bH\u0014J\b\u00103\u001a\u00020\u001bH\u0014J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000207H\u0016J\"\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010'H\u0014J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0007H\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J\u0006\u0010A\u001a\u00020\u001bJ\b\u0010B\u001a\u00020\fH\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J\b\u0010D\u001a\u00020\u000eH\u0016J\b\u0010E\u001a\u00020\u000eH\u0016J\u0012\u0010F\u001a\u00020\u001b2\b\b\u0002\u0010G\u001a\u00020\u000eH\u0002J\b\u0010G\u001a\u00020\u001bH\u0002J\u000e\u0010H\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u001bH\u0002J\b\u0010K\u001a\u00020\u001bH\u0003R\"\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/miniapp/view/MiniAppBaseActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/ivykit/xbridge/choosemedia/IActivityResult;", "<init>", "()V", "mActivityResultListeners", "Ljava/util/ArrayList;", "Lcom/larus/ivykit/xbridge/choosemedia/ActivityResultListener;", "Lkotlin/collections/ArrayList;", "fg", "Landroidx/fragment/app/Fragment;", MemorySourceLinkType.URL, "", "fullScreen", "", "hasContent", "appletId", "pageTransition", "Lcom/obric/miniapp/utils/IPageTransition;", "uninstallReceiver", "Landroid/content/BroadcastReceiver;", "hasSetTaskDescription", "mStatusBarTransparent", "mNavigationBarTransparent", "launchFromLauncher", "stopByBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initAISDK", "jumpToMainActivity", "checkEnvReady", "checkLauncherIsForMiniApp", "setLayout", "interceptIntent", "onStart", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "refreshLayout", "statusBarTransparent", "navigationBarTransparent", "handleIntent", "finish", "setupExitTransition", "parseArguments", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "onResume", "onPause", "onDestroy", "onSaveInstanceState", "outState", "outPersistentState", "Landroid/os/PersistableBundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "setActivityResultListener", "listener", "unsetActivityResultListener", "onBackPressed", "processBackPressed", "getAppletId", "isStatusBarTransparent", "isNavigationBarTransparent", "isHideTitleBar", "launchApplet", "checkUpdate", "showUpdateDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMiniAppUserGuide", "registerUninstallReceiver", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MiniAppBaseActivity extends FlowCommonAppCompatActivity implements ug9.b {
    public static final /* synthetic */ int r = 0;
    public final ArrayList<ug9.a> g;
    public boolean h;
    public boolean i;
    public String j;
    public p0 k;
    public MiniAppBaseActivity$registerUninstallReceiver$1 l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;

    public static final class a {
    }

    static {
    }

    public void Q1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean N1() {
        AppletService r0 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (ILoginService.a.getAccountInfo().a == true) goto L12;
        MiniAppUtils r2 = MiniAppUtils.a;
        MiniAppUtils.b = P1();
        MiniAppUtils.c = getIntent().getStringExtra("pageData");
        T1();
        finish();
        return false;
    L12:
        if (r1 == false) goto L14;
        return true;
    L14:
        AppletService r3 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r3 == null) goto L17;
        AppHost.Companion r4 = AppHost.a;
        r3.h(r4.getApplication(), com.larus.ivykit.c.a(), r4.isDebug(), pg9.b.a);
    L17:
        AppletService r5 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L25;
        return true;
    L25:
        MiniAppUtils r7 = MiniAppUtils.a;
        MiniAppUtils.b = P1();
        MiniAppUtils.c = getIntent().getStringExtra("pageData");
        T1();
        finish();
        return false;
    L20:
        if (r5.isInitialized() != true) goto L22;
        r6 = true;
        goto L23
    L5:
        if (r0.isInitialized() != true) goto L7;
        r1 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean O1() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return true;
    L5:
        if (getIntent().hasCategory("android.intent.category.LAUNCHER") == true) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(getIntent().getAction(), "com.obric.miniapp.calendar.SUGGESTION_CLICKED") == false) goto L9;
        return true;
    L9:
        if (getReferrer() != null) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(String.valueOf(getReferrer()), "android-app://com.android.launcher3") == true) goto L23;
        IObricLaunchService r0 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r0 != null) goto L15;
        T1();
    L16:
        finish();
        return false;
    L15:
        r0.resumeOrLaunchNewTask(false);
        goto L16
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T1() {
        String r0 = HomeServiceV2.a.a();
        Intent r1 = new Intent();
        r1.setClassName(getApplication().getPackageName(), r0);
        r1.setFlags(268435456);
        startActivity(r1);     // Catch: ActivityNotFoundException -> L5
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleIntent() {
        Q1();
        Long r1 = Long.valueOf(getIntent().getLongExtra("mini_app_transition", 0));
        boolean r2 = false;
        if (r1.longValue() == 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L19;
        long r8 = r1.longValue();
        m0.a.getClass();
        m0.a.b.getClass();
        if (r8 != 1) goto L16;
        p0 r4 = v0.a;
    L20:
        this.k = r4;
        Bundle r5 = getIntent().getExtras();
        if (r5 != null) goto L23;
    L25:
        boolean r6 = false;
    L27:
        if (r6 == true) goto L55;
        Bundle r7 = getIntent().getExtras();
        if (r7 != null) goto L31;
    L33:
        boolean r9 = false;
    L34:
        this.p = r9;
        String r10 = getIntent().getStringExtra("pageId");
        String r11 = getIntent().getStringExtra("launchFrom");
        if (this.i == true) goto L37;
    L40:
        boolean r12 = true;
    L41:
        String r13 = getIntent().getStringExtra(MemorySourceLinkType.URL);
        if (r13 == null) goto L44;
        Uri r14 = UriProtector.parse(r13);
        this.n = r14.getBooleanQueryParameter("transStatusBar", true);
        this.o = r14.getBooleanQueryParameter("transNavigationBar", true);
    L44:
        if (r12 == false) goto L51;
        if (r11 != null) goto L47;
    L48:
        r2 = true;
    L49:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MiniAppBaseActivity$launchApplet$1(P1(), this, r2, null), 3, null);
        this.i = true;
        goto L51
    L47:
        if (r11.length() != 0) goto L49;
    L51:
        if (Intrinsics.areEqual(P1(), "com.flow.music.auth") == false) goto L165;
        Lazy r15 = l3.d.a;
        JsonObject r16 = new JsonObject();
        r16.addProperty("value", Boolean.TRUE);
        r16.addProperty("appletId", P1());
        Unit r17 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.fromLauncher", r16, 4));
        return;
    L165:
        return;
    L37:
        if (o0.d(r10) == true) goto L40;
        r12 = false;
        goto L41
    L31:
        if (r7.getBoolean("fromLauncher", false) != true) goto L33;
        r9 = true;
        goto L34
    L55:
        if (Intrinsics.areEqual(getIntent().getAction(), "com.obric.miniapp.showAbout") == false) goto L57;
        Fragment r18 = new MiniAppAboutFragment();
    L120:
        boolean r19 = false;
        boolean r20 = false;
    L121:
        r18.setArguments(getIntent().getExtras());
        if (r19 == false) goto L144;
        this.p = !r20;
        getSupportFragmentManager().executePendingTransactions();
        int r21 = getSupportFragmentManager().getBackStackEntryCount();
        int r22 = 0;
    L124:
        if (r22 >= r21) goto L126;
        getSupportFragmentManager().popBackStack();
        r22 = r22 + 1;
        goto L124
    L126:
        getSupportFragmentManager().executePendingTransactions();
        if (r20 == false) goto L144;
        if (Intrinsics.areEqual(P1(), "com.flow.calendar") == false) goto L144;
        yka.a r23 = yka.a.b;
        Application r24 = AppHost.a.getApplication();
        Intrinsics.checkNotNullParameter(r24, "context");
        if (yka.a.c.e.b(r24) == true) goto L144;
        MiniAppUtils r25 = MiniAppUtils.a;
        boolean r26 = MiniAppUtils.e(getApplication(), P1());
        Application r27 = getApplication();
        String r28 = P1();
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "appletId");
        int r29 = r27.getSharedPreferences("com.obric.miniapp.sp", 0).getInt("enter_count_" + r28, -1);
        if (r26 == true) goto L142;
        if (r29 == (-1)) goto L138;
        if (r29 == 4) goto L138;
    L139:
        if (r29 == (-1)) goto L144;
        if (r29 > 4) goto L144;
        MiniAppUtils.g(getApplication(), P1());
    L138:
        com.bytedance.router.i r30 = SmartRouter.buildRoute(this, "//flow/applet/user_guide");
        r30.c.putExtra("appletId", P1());
        r30.d();
        goto L139
    L142:
        if (r29 == (-1)) goto L144;
        MiniAppUtils.d(getApplication(), P1());
    L144:
        FragmentTransaction r31 = getSupportFragmentManager().beginTransaction();
        Fragment r32 = getSupportFragmentManager().findFragmentById(2131380134);
        String r33 = r18.toString();
        if ((!getSupportFragmentManager().getFragments().isEmpty()) == false) goto L154;
        p0 r34 = this.k;
        if (r34 != null) goto L149;
    L151:
        if (r2 == true) goto L154;
        r31.setCustomAnimations(2130772472, 2130772473, 2130772470, 2130772471);
        goto L154
    L149:
        if (r34.a() != 1) goto L151;
        r2 = true;
    L154:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r31, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r33, 2131380134) == true) goto L157;
        r31.add(2131380134, r18, r33);
    L157:
        r31.addToBackStack(r33);
        if (r32 == null) goto L160;
        r31.hide(r32);
    L160:
        r31.commitAllowingStateLoss();
        this.i = true;
        if (this.m == true) goto L166;
        MiniAppUtils r35 = MiniAppUtils.a;
        MiniAppUtils.i(this, this.j);
        return;
    L166:
        return;
    L57:
        Bundle r36 = getIntent().getExtras();
        if (r36 != null) goto L60;
    L61:
        Bundle r37 = getIntent().getExtras();
        if (r37 == null) goto L64;
        r37.getString("link_url");
    L64:
        Bundle r38 = getIntent().getExtras();
        if (r38 == null) goto L67;
        boolean r39 = r38.getBoolean("fullScreen", true);
    L68:
        this.h = r39;
        Bundle r40 = getIntent().getExtras();
        if (r40 == null) goto L71;
        String r41 = r40.getString("pageId");
    L72:
        if (r41 == null) goto L76;
        AppletRuntimeManager.INSTANCE.getClass();
        if (AppletRuntimeManager.e(r41) == null) goto L76;
        Unit r42 = Unit.INSTANCE;
        boolean r43 = true;
    L77:
        if (r43 == true) goto L87;
        if (r41 != null) goto L80;
    L81:
        r2 = true;
    L82:
        if (r2 == false) goto L85;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MiniAppBaseActivity$launchApplet$1(P1(), this, true, null), 3, null);
        this.i = true;
        return;
    L85:
        finish();
        return;
    L80:
        if (r41.length() != 0) goto L82;
    L87:
        r18 = new MiniAppFragment();
        String r44 = getIntent().getStringExtra(MemorySourceLinkType.URL);
        if (r44 == null) goto L120;
        Uri r45 = UriProtector.parse(r44);
        Uri.Builder r46 = r45.buildUpon();
        String r47 = "0";
        if (UriProtector.getQueryParameter(r45, "closeActivity") != null) goto L92;
        r46.appendQueryParameter("closeActivity", "0");
        boolean r48 = true;
    L94:
        if (UriProtector.getQueryParameter(r45, "hideTitleBar") != null) goto L97;
        r46.appendQueryParameter("hideTitleBar", "1");
        r48 = true;
    L97:
        if (UriProtector.getQueryParameter(r45, "transStatusBar") != null) goto L104;
        if (S1() == false) goto L101;
        String r49 = "1";
    L102:
        r46.appendQueryParameter("transStatusBar", r49);
        r48 = true;
        goto L104
    L101:
        r49 = "0";
    L104:
        if (UriProtector.getQueryParameter(r45, "transNavigationBar") == null) goto L106;
    L109:
        if (r48 == false) goto L111;
        getIntent().putExtra(MemorySourceLinkType.URL, r46.build().toString());
    L111:
        r20 = Intrinsics.areEqual(UriProtector.getQueryParameter(r45, "launchFrom"), "doubao_widget");
        if (r20 == false) goto L114;
    L119:
        r19 = true;
        goto L121
    L114:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r45, "launchFrom"), "system_clock") == true) goto L119;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r45, "launchFrom"), "system_search") == true) goto L119;
        r19 = false;
        goto L121
    L106:
        if (R1() == false) goto L108;
        r47 = "1";
    L108:
        r46.appendQueryParameter("transNavigationBar", r47);
        r48 = true;
        goto L109
    L92:
        r48 = false;
    L76:
        r43 = false;
        goto L77
    L71:
        r41 = null;
        goto L72
    L67:
        r39 = true;
        goto L68
    L60:
        if (r36.getString(MemorySourceLinkType.URL) != null) goto L64;
    L23:
        if (r5.getBoolean("fromLauncher", true) == true) goto L25;
        r6 = true;
        goto L27
    L16:
        if (r8 != 4) goto L18;
        r4 = k1.a;
        goto L20
    L18:
        r4 = com.obric.miniapp.utils.d.a;
        goto L20
    L19:
        r4 = null;
        goto L20
    L5:
        r3 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        MiniAppBaseActivity$registerUninstallReceiver$1 r0 = this.l;
        if (r0 == null) goto L19;
        ReceiverRegisterLancet.loge(r0, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L17;
        unregisterReceiver(r0);
        return;
    L17:
    L13:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r0.toString());
        e.printStackTrace();
        return;
    L10:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, this) == false) goto L20;
        unregisterReceiver(r0);     // Catch: Exception -> L13
        return;
    L20:
        return;
    }

    public MiniAppBaseActivity() {
        this.g = new ArrayList();
        this.h = true;
        this.j = "";
        this.n = true;
        this.o = true;
    }

    public final boolean H1() {
        return !R1();
    }

    public final boolean K1() {
        if (S1() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.h == false) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U1() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) goto L5;
        getSupportFragmentManager().popBackStackImmediate();
        return;
    L5:
        Object r0 = CollectionsKt.firstOrNull(getSupportFragmentManager().getFragments());
        if ((r0 instanceof MiniAppFragment) == false) goto L8;
        MiniAppFragment r1 = (MiniAppFragment) r0;
    L9:
        boolean r2 = false;
        if (r1 == null) goto L19;
        com.bytedance.ai.model.widgets.c r3 = r1.k;
        if (r3 == null) goto L16;
        FLogger.a.d("MiniAppFragment", "appletEntry: " + r3.getAppletRuntime().h.O + ", pageName: " + r3.getPageInfo().getPageName());
        if (Intrinsics.areEqual(r3.getAppletRuntime().h.O, r3.getPageInfo().getPageName()) != true) goto L16;
        boolean r4 = true;
    L17:
        if (r4 != true) goto L19;
        r2 = true;
    L16:
        r4 = false;
    L19:
        if (r2 == true) goto L21;
    L23:
        finish();
        return;
    L21:
        if (this.p == false) goto L23;
        moveTaskToBack(true);
        this.q = true;
        return;
    L8:
        r1 = null;
        goto L9
    }

    /* JADX INFO: Removed unreachable split cross block B:58:0x0119 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        p0 r2 = this.k;
        if (r2 == null) goto L8;
        g1 r3 = r2.c();
        if (r3 == null) goto L8;
        overridePendingTransition(r3.a, r3.b);
    L8:
        if ((this instanceof ChatWindowActivity) == true) goto L49;
        FLogger r4 = FLogger.a;
        r4.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r5 = SystemClock.uptimeMillis();
        Map<Activity, Long> r6 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r6);
        Long r7 = r6.get(this);     // Catch: Throwable -> L50
        if (r7 != null) goto L15;
    L18:
        r6.put(this, Long.valueOf(r5));     // Catch: Throwable -> L50
        monitor-exit(r6);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L55:
        return;
    L21:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L24;
        r4.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        goto L55
    L24:
        if (isFinishing() == true) goto L27;
        r4.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        goto L55
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L30;
        r4.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        goto L55
    L30:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L33;
        r4.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        goto L55
    L33:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L36;
        r4.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        goto L55
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        goto L55
    L38:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L47
        if (r1 == null) goto L55;
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L47
        r4.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L47
        startActivity(r1);     // Catch: Throwable -> L44
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        goto L55
    L15:
        if ((r5 - r7.longValue()) >= 800) goto L18;
        monitor-exit(r6);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    }

    public final void onResume() {
        super.onResume();
        N1();
    }

    public final void onStart() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStart();
        if (this.q == false) goto L6;
        this.q = false;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MiniAppBaseActivity$checkUpdate$1(this, null), 3, null);
        return;
    }

    public String P1() {
        return this.j;
    }

    public boolean R1() {
        return this.o;
    }

    public boolean S1() {
        return this.n;
    }

    public final void onBackPressed() {
        U1();
    }

    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
    }

    public final void I0(ug9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.add(r2);
    }

    public final void S(com.larus.bmhome.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.remove(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v7, types: [com.obric.miniapp.view.MiniAppBaseActivity$registerUninstallReceiver$1] */
    public void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r13);
        FLogger r14 = FLogger.a;
        r14.e("CalendarSearchRecentSuggestionsProvider", "MiniAppBaseActivity onCreate");
        com.larus.utils.u.g(this, true);
        if (O1() == false) goto L117;
        MiniAppUtils r1 = MiniAppUtils.a;
        MiniAppUtils.b = "";
        MiniAppUtils.c = null;
        String r2 = getIntent().getStringExtra("appletId");
        if (r2 != null) goto L21;
        Uri r3 = getIntent().getData();
        if (r3 == null) goto L18;
        r2 = r3.toString();
    L19:
        if (r2 != null) goto L21;
        r2 = P1();
        goto L21
    L18:
        r2 = null;
    L21:
        this.j = r2;
        if (o0.d(r2) == false) goto L26;
        AppletExtService r4 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r4 == null) goto L26;
        r4.b(this.j);
    L26:
        this.m = MiniAppUtils.i(this, this.j);
        setContentView(2131563655);
        Window r5 = getWindow();
        if (r5 == null) goto L33;
        View r6 = r5.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L34;
        r14.i("DecorViewLancet", "getDecorView");
        Thread r15 = ThreadMethodProxy.currentThread();
        if (r15 == com.larus.home.impl.utils.c.a) goto L34;
        com.larus.home.impl.utils.c.a(r15, "getDecorView");
    L34:
        setRootView(r6);
        L1();
        if (N1() == false) goto L118;
        handleIntent();
        Bundle r16 = getIntent().getExtras();
        if (r16 != null) goto L40;
    L42:
        boolean r17 = false;
    L43:
        if (r17 == true) goto L114;
        this.l = new MiniAppBaseActivity$registerUninstallReceiver$1(this);
        IntentFilter r18 = new IntentFilter("com.obric.miniapp.UNINSTALLED");
        if (Build.VERSION.SDK_INT < 33) goto L75;
        MiniAppBaseActivity$registerUninstallReceiver$1 r11 = this.l;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L106;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L106:
    L70:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L74;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r18, 2);
        return;
    L74:
        throw e;
    L50:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L61;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r18) == false) goto L61;
        int r7 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r18, 2, null, null, 3, this).result;     // Catch: Exception -> L70
        if (r7 == 1) goto L59;
        if (r7 == 2) goto L58;
        if (r7 == 3) goto L105;
        registerReceiver(r11, r18, 2);     // Catch: Exception -> L70
    L105:
        return;
    L58:
        new Intent();     // Catch: Exception -> L70
        goto L105
    L59:
        registerReceiver(r11, r18, 2);     // Catch: Exception -> L70
    L61:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L64;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L70
        registerReceiver(r11, r18, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L70
        goto L105
    L64:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L66;
    L68:
        registerReceiver(r11, r18, 2);     // Catch: Exception -> L70
        goto L105
    L66:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r18) == false) goto L68;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L70
        ContextCompat.registerReceiver(this, r11, r18, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L70
        goto L105
    L75:
        MiniAppBaseActivity$registerUninstallReceiver$1 r12 = this.l;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L109;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L109:
    L99:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L103;
        ReceiverRegisterCrashOptimizer.registerReceiver(r12, r18);
        return;
    L103:
        throw e;
    L79:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L90;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r18) == false) goto L90;
        int r8 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r12, r18, 0, null, null, 2, this).result;     // Catch: Exception -> L99
        if (r8 == 1) goto L88;
        if (r8 == 2) goto L87;
        if (r8 == 3) goto L108;
        registerReceiver(r12, r18);     // Catch: Exception -> L99
    L108:
        return;
    L87:
        new Intent();     // Catch: Exception -> L99
        goto L108
    L88:
        registerReceiver(r12, r18);     // Catch: Exception -> L99
    L90:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L93;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L99
        registerReceiver(r12, r18, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L99
        goto L108
    L93:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L95;
    L97:
        registerReceiver(r12, r18);     // Catch: Exception -> L99
        goto L108
    L95:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r18) == false) goto L97;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L99
        ContextCompat.registerReceiver(this, r12, r18, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L99
        goto L108
    L114:
        return;
    L40:
        if (r16.getBoolean("fromLauncher", true) == true) goto L42;
        r17 = true;
        goto L43
    L118:
        return;
    L33:
        r6 = null;
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r1) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r1);
        setIntent(r1);
        if (O1() == true) goto L5;
        return;
    L5:
        handleIntent();
    }

    public void W1(boolean r9, boolean r10) {
        final int r2 = 0;
        if (this.n == r9) goto L5;
        this.n = r9;
        boolean r11 = true;
    L7:
        if (this.o == r10) goto L9;
        this.o = r10;
        r11 = true;
    L9:
        if (r11 == true) goto L12;
        return;
    L12:
        if (K1() == false) goto L14;
        int r12 = com.larus.utils.u.c(this);
    L16:
        if (H1() == false) goto L18;
        r2 = com.larus.utils.u.b(this);
    L18:
        View r13 = ((FlowCommonAppCompatActivity) this).b;
        if (r13 == null) goto L22;
        int r0 = r13.getPaddingStart();
        int r3 = r13.getPaddingEnd();
        int r4 = r13.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r13.getClass().getSimpleName() + ",source:,start:" + r0 + ",top:" + r12 + ",end:" + r3 + ",bottom:" + r4);
        r13.setPaddingRelative(r0, r12, r3, r4);
    L22:
        if ((!(this instanceof MainActivity)) == false) goto L27;
        final View r14 = ((FlowCommonAppCompatActivity) this).b;
        if (r14 == null) goto L28;
        ViewCompat.setOnApplyWindowInsetsListener(r14, new l(r14, r2));
        return;
    L28:
        return;
    L27:
        return;
    L14:
        r12 = 0;
        goto L16
    L5:
        r11 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle r2, PersistableBundle r3) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        Intrinsics.checkNotNullParameter(r3, "outPersistentState");
        super/*android.app.Activity*/.onSaveInstanceState(r2, r3);
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        Iterator<ug9.a> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ug9.a r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onActivityResult(r3, r4, r5);
        goto L4
    }
}
