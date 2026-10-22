package com.larus.dora.impl.device_v2;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.w0;
import com.larus.dora.impl.dynamic.dsl.DslActionTrackerEvent;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.model.DoraBuryPointSource;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraDeviceBindActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "getBackgroundResource", "", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "createDefaultDeviceBindFragment", "Landroidx/fragment/app/Fragment;", "productID", "vendorID", "shouldUseObricDoraDeviceBindFragment", "shouldRouteToObricSmartDeviceBind", "openObricDoraDeviceBindActivity", "extras", "jumpToObricSmartNotificationIfAvailable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceBindActivity extends FlowCommonAppCompatActivity {

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131102535;
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean O1() {
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        g49.d.d("DoraDeviceBindActivity", "jumpToObricSmartNotification skipped: capability unavailable");
        return false;
    L12:
        boolean r2 = c59.p.a(new c59.b(DslActionType.EXTERNAL_JUMP_BY_EXPLICIT_INTENT, "obric://smartnotification", MapsKt.mapOf(new Pair[]{TuplesKt.to("package_name", "com.obric.smartnotification"), TuplesKt.to("class_name", "com.obric.smartnotification.featuresettings.impl.SmartNotificationSetting"), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "page_dora_device_management")}), new c59.c(DslActionTrackerEvent.DORA_CARD_CLICK, "const", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "quick_access"), TuplesKt.to("action_type", "normal_click"), TuplesKt.to("card_content_type", "broadcast")})), 48), this, CoroutineScopeKt.MainScope(), null);
        g49.d.d("DoraDeviceBindActivity", "jumpToObricSmartNotification result: " + r2);
        return r2;
    L5:
        if (r0.m() != true) goto L7;
        r1 = true;
        goto L9
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraDeviceBindActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraDeviceBindActivity.class.getName()));
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

    public DoraDeviceBindActivity() {
    }

    public static boolean Q1(int r4) {
        if (ObricFeatureServiceDelegate.b.b() == true) goto L5;
        return false;
    L5:
        if (w0.a() == false) goto L41;
        ProductNameType r0 = ProductNameType.getProduct(r4);
        if (r4 != ProductNameType.DORA_G.id) goto L10;
    L37:
        return true;
    L10:
        if (r4 == ProductNameType.DORA_G2.id) goto L37;
        if (r4 == ProductNameType.DORA_G_AIR.id) goto L37;
        if (r0 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == true) goto L37;
        if (r0 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == true) goto L37;
        if (r0 != null) goto L27;
    L29:
        boolean r7 = false;
    L30:
        if (r7 == true) goto L37;
        if (r0 != null) goto L33;
    L35:
        boolean r8 = false;
    L36:
        if (r8 == true) goto L37;
        return false;
    L33:
        if (r0.deviceType != 19) goto L35;
        r8 = true;
        goto L36
    L27:
        if (r0.deviceType != 18) goto L29;
        r7 = true;
        goto L30
    L21:
        if (r0.deviceType != 17) goto L23;
        r6 = true;
        goto L24
    L15:
        if (r0.deviceType != 16) goto L17;
        r5 = true;
        goto L18
    L41:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P1(Bundle r3) {
        g49.d.d("DoraDeviceBindActivity", "open ObricDoraDeviceBindActivity");
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this, "//flow/dora/obric_bind_device");
        if (r3 != null) goto L5;
        r3 = new Bundle();
    L5:
        r0.c.putExtras(r3);
        r0.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0338: MOVE (r2 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]) (LINE:16778040), block:B:166:0x0338 */
    public final void onCreate(Bundle r110) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L207
    L7:
        if (v19.f.f(this) == false) goto L9;
        v19.f.c(getTheme());     // Catch: Throwable -> L207
    L9:
        String r2 = "next_action";
        super.onCreate(r110);
        g49.d.d("DoraDeviceBindActivity", "onCreate: intent=" + getIntent() + ", data=" + getIntent().getData());
        Bundle r7 = getIntent().getExtras();     // Catch: Exception -> L167
        if (r7 == null) goto L16;
        Iterator<String> r0 = r7.keySet().iterator();     // Catch: Exception -> L167
    L14:
        if (r0.hasNext() == false) goto L17;
        String r8 = r0.next();     // Catch: Exception -> L167
        g49.d.d("DoraDeviceBindActivity", "extra: key=" + r8 + ", value=" + r7.get(r8));     // Catch: Exception -> L167
    L17:
        boolean r9 = true;
        Bundle r1 = getIntent().getExtras();     // Catch: Exception -> L28
        if (r1 == null) goto L21;
        String r3 = r1.getString("product_id");     // Catch: Exception -> L28
    L22:
        g49.d.d("DoraDeviceBindActivity", "raw productID string: " + r3);     // Catch: Exception -> L28
        if (r3 == null) goto L26;
        int r4 = CastIntegerProtector.parseInt(r3);     // Catch: Exception -> L28
    L27:
        int r10 = r4;
    L208:
        Bundle r5 = getIntent().getExtras();     // Catch: Exception -> L37
        if (r5 == null) goto L39;
        String r6 = r5.getString(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID);     // Catch: Exception -> L37
        if (r6 == null) goto L39;
        int r11 = CastIntegerProtector.parseInt(r6);     // Catch: Exception -> L37
    L40:
        g49.d.d("DoraDeviceBindActivity", "parsed: productID=" + r10 + ", vendorID=" + r11);     // Catch: Exception -> L167
        Uri r12 = getIntent().getData();     // Catch: Exception -> L167
        String r13 = getIntent().getStringExtra("bury_point_source");     // Catch: Exception -> L167
        if (o0.d(r13) == true) goto L44;
        r13 = DoraBuryPointSource.DEVICE_PAGE;
    L44:
        if (r12 == null) goto L46;
        String r14 = r12.getAuthority();     // Catch: Exception -> L167
    L212:
        if (Intrinsics.areEqual(r14, "flow") == false) goto L169;
        if (r12 == null) goto L51;
        String r15 = r12.getPath();     // Catch: Exception -> L167
    L53:
        if (Intrinsics.areEqual(r15, "/dora/smart_device") == false) goto L169;
        DoraSetting.a.getClass();     // Catch: Exception -> L167
        if (DoraSetting.l() == true) goto L57;
        g49.d.d("DoraDeviceBindActivity", "H device is not enabled");     // Catch: Exception -> L167
        finish();     // Catch: Exception -> L167
        return;
    L57:
        g49.d.d("DoraDeviceBindActivity", "smart_device scheme = " + r12);     // Catch: Exception -> L167
        String r16 = UriProtector.getQueryParameter(r12, "mac");     // Catch: Exception -> L167
        String r17 = "";
        if (r16 != null) goto L61;
        r16 = "";
    L61:
        String r18 = UriProtector.getQueryParameter(r12, "next_action");     // Catch: Exception -> L167
        if (r16.length() != 0) goto L64;
        boolean r111 = true;
    L65:
        if (r111 == false) goto L67;
        finish();     // Catch: Exception -> L167
        return;
    L67:
        List r112 = DoraAdapterExtKt.k(kj4.a.g());     // Catch: Exception -> L167
        if (r112 == null) goto L76;
        ArrayList r113 = new ArrayList();     // Catch: Exception -> L167
        Iterator r114 = r112.iterator();     // Catch: Exception -> L167
    L71:
        if (r114.hasNext() == false) goto L211;
        Object r115 = r114.next();     // Catch: Exception -> L167
        if (Intrinsics.areEqual(((DoraDevice) r115).mac, r16) == false) goto L71;
        r113.add(r115);     // Catch: Exception -> L167
    L211:
        if (r113 != null) goto L80;
    L128:
        String r20 = UriProtector.getQueryParameter(r12, "model_id");     // Catch: Exception -> L165
        if (r20 != null) goto L131;
        r20 = "";
    L131:
        String r116 = UriProtector.getQueryParameter(r12, "sub_model");     // Catch: Exception -> L165
        if (r116 != null) goto L134;
        r116 = "";
    L134:
        String r21 = UriProtector.getQueryParameter(r12, DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID);     // Catch: Exception -> L165
        if (r21 == null) goto L138;
        r17 = r21;
    L138:
        Intrinsics.areEqual(r17, "4096");     // Catch: Exception -> L165
        int r22 = ProductNameType.getProductIDByModelID(r20);     // Catch: Exception -> L165
        if (o0.d(r116) == false) goto L142;
        if (r7 == null) goto L142;
        r7.putString("extra_sku", r116);     // Catch: Exception -> L165
    L142:
        if (r7 == null) goto L144;
        r7.putString("extra_mac", r16);     // Catch: Exception -> L165
    L144:
        if (r7 == null) goto L146;
        r7.putInt("extra_vendor_id", 4096);     // Catch: Exception -> L165
    L146:
        if (r7 == null) goto L148;
        r7.putString("product_id", String.valueOf(r22));     // Catch: Exception -> L165
    L148:
        if (r7 == null) goto L150;
        r7.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");     // Catch: Exception -> L165
    L150:
        if (r18 != null) goto L152;
    L155:
        boolean r23 = true;
    L156:
        if (r23 == true) goto L159;
        if (r7 == null) goto L159;
        r7.putString("next_action", r18);     // Catch: Exception -> L165
    L159:
        r13 = DoraBuryPointSource.H_SMART_AUDIO;
        if (r22 == (-1)) goto L163;
        String r24 = "DoraDeviceBindActivity";
        r10 = r22;
        r11 = 4096;
    L171:
        if (o59.a.o(Integer.valueOf(r10)) == false) goto L176;
        if (m59.b.a(this, "//flow/dora/bind_device", r7) == false) goto L176;
        finish();     // Catch: Exception -> L187
        return;
    L176:
        if (o59.a.o(Integer.valueOf(r10)) == false) goto L180;
        int r25 = com.larus.dora.impl.util.s.a;     // Catch: Exception -> L187
        if (com.larus.dora.impl.util.s.c(Integer.valueOf(r10)) == true) goto L180;
        g49.d.d(r24, "Dora G is disabled, block G bind page");     // Catch: Exception -> L187
        finish();     // Catch: Exception -> L187
        return;
    L180:
        if (r7 == null) goto L183;
        r7.putString("bury_point_source", r13);     // Catch: Exception -> L187
    L183:
        if (r10 == (-1)) goto L185;
    L189:
        r9 = false;
    L190:
        if (r9 == false) goto L193;
        P1(r7);     // Catch: Exception -> L187
        finish();     // Catch: Exception -> L187
        return;
    L193:
        if (r11 != 4096) goto L195;
    L199:
        setContentView(2131561787);     // Catch: Exception -> L187
        DoraBaseFragment r26 = N1(r10, r11);     // Catch: Exception -> L187
        r26.setArguments(r7);     // Catch: Exception -> L187
        FragmentTransaction r27 = getSupportFragmentManager().beginTransaction();     // Catch: Exception -> L187
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r27, r26, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L203;
        r27 = r27.replace(2131373275, r26);     // Catch: Exception -> L187
    L203:
        r27.commitAllowingStateLoss();     // Catch: Exception -> L187
        return;
    L195:
        if (r10 == (-1)) goto L199;
        if (Q1(r10) == false) goto L199;
        P1(r7);     // Catch: Exception -> L187
        finish();     // Catch: Exception -> L187
        return;
    L185:
        if (w0.a() == false) goto L189;
    L163:
        g49.d.d("DoraDeviceBindActivity", "device is unsupported, navigate to doubao home. vendorID = 4096");     // Catch: Exception -> L187
        finish();     // Catch: Exception -> L187
        return;
    L152:
        if (r18.length() == 0) goto L155;
        r23 = false;
        goto L156
    L80:
        if ((!r113.isEmpty()) == false) goto L128;
        DoraDevice r28 = (DoraDevice) CollectionsKt.first(r113);     // Catch: Exception -> L167
        int r30 = n1.c(r28);     // Catch: Exception -> L167
        int r31 = com.larus.dora.impl.util.s.a;     // Catch: Exception -> L167
        boolean r32 = com.larus.dora.impl.util.s.c(Integer.valueOf(r30));     // Catch: Exception -> L167
        boolean r33 = ObricFeatureServiceDelegate.b.b();     // Catch: Exception -> L167
        if (o0.d(r18) == false) goto L91;
        if (TextUtils.equals(r18, "notification_broadcast") == false) goto L91;
        if (O1() == false) goto L91;
        finish();     // Catch: Exception -> L167
        return;
    L91:
        if (o0.d(r18) == false) goto L98;
        if (TextUtils.equals(r18, "translate") == false) goto L98;
        if (r33 == false) goto L98;
        g49.d.d("DoraDeviceBindActivity", "intercept translate next_action on obric, fallback to device management");     // Catch: Exception -> L167
    L98:
        if (o0.d(r18) == false) goto L104;
        if (TextUtils.equals(r18, "translate") == false) goto L104;
        if (r33 == true) goto L104;
        String r34 = "//flow/dora/simul_interpretat_detail";
    L118:
        if (r7 != null) goto L120;
        r7 = new Bundle();     // Catch: Exception -> L165
    L120:
        Bundle r35 = new Bundle(r7);     // Catch: Exception -> L165
        r35.putInt("product_id", r30);     // Catch: Exception -> L165
        r35.putString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r28.model);     // Catch: Exception -> L165
        r35.putString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r16);     // Catch: Exception -> L165
        r35.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");     // Catch: Exception -> L165
        if (o59.a.o(Integer.valueOf(r30)) == true) goto L123;
    L127:
        com.bytedance.router.i r36 = SmartRouter.buildRoute(AppHost.a.getApplication(), r34);     // Catch: Exception -> L165
        r36.d = 2130772401;     // Catch: Exception -> L165
        r36.e = 2130772399;     // Catch: Exception -> L165
        r36.c.putExtras(r35);     // Catch: Exception -> L165
        r36.d();     // Catch: Exception -> L165
        finish();     // Catch: Exception -> L165
        return;
    L123:
        if (SetsKt.setOf(new String[]{"//dora_g_device_management", "//flow/dora/obric_device_home", "//dora_dynamic_list"}).contains(r34) == false) goto L127;
        if (m59.b.a(this, r34, r35) == false) goto L127;
        finish();     // Catch: Exception -> L165
        return;
    L104:
        if (o0.d(r18) == true) goto L106;
    L108:
        if (r32 == true) goto L110;
    L112:
        if (r32 == true) goto L114;
    L116:
        r34 = "//dora_dynamic_list";
        goto L118
    L114:
        if (w0.a() == false) goto L116;
        r34 = "//flow/dora/obric_device_home";
        goto L118
    L110:
        if (r30 != ProductNameType.DORA_G.id) goto L112;
        r34 = "//dora_g_device_management";
        goto L118
    L106:
        if (TextUtils.equals(r18, "notification_broadcast") == false) goto L108;
        r34 = "//dora_proactive_settings";
    L165:
        e = e;
        r2 = r17;
    L205:
        finish();
        g49.d.c(r2, "onCreate error", e);
        return;
    L76:
        r113 = null;
        goto L211
    L64:
        r111 = false;
        goto L65
    L51:
        r15 = null;
    L169:
        r24 = "DoraDeviceBindActivity";
    L187:
        e = e;
        goto L205
    L46:
        r14 = null;
        goto L212
    L39:
        r11 = 1;
    L37:
        e = move-exception;
        g49.d.c("DoraDeviceBindActivity", "parse vendorID error", e);     // Catch: Exception -> L167
        goto L39
    L26:
        r4 = 1;
        goto L27
    L21:
        r3 = null;
    L28:
        e = move-exception;
        g49.d.c("DoraDeviceBindActivity", "parse productID error", e);     // Catch: Exception -> L167
        r10 = 1;
        goto L208
    L16:
        g49.d.d("DoraDeviceBindActivity", "extras is null");     // Catch: Exception -> L167
    L167:
        e = e;
        r2 = "DoraDeviceBindActivity";
        goto L205
    }

    public final void onNewIntent(Intent r8) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r8);
        boolean r1 = false;
        int r2 = 1;
        if (r8 == null) goto L20;
        Bundle r4 = r8.getExtras();
        if (r4 == null) goto L20;
        String r5 = r4.getString("product_id");
        if (r5 == null) goto L11;
        Integer r6 = StringsKt.toIntOrNull(r5);
        if (r6 == null) goto L11;
        int r7 = r6.intValue();
    L12:
        if (r7 == (-1)) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == false) goto L20;
        P1(r4);
        finish();
        return;
    L14:
        if (w0.a() == false) goto L16;
        r9 = true;
    L11:
        r7 = ProductNameType.DORA_LITE.id;
    L20:
        IObricDoraService r10 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r10 != null) goto L23;
    L25:
        Uri r11 = null;
        if (r1 == false) goto L54;
        if (r8 == null) goto L30;
        Bundle r3 = r8.getExtras();
        if (r3 == null) goto L30;
    L31:
        String r12 = r3.getString("product_id");
        if (r12 == null) goto L36;
        Integer r13 = StringsKt.toIntOrNull(r12);
        if (r13 == null) goto L36;
        int r14 = r13.intValue();
    L37:
        String r15 = r3.getString(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID);
        if (r15 == null) goto L42;
        Integer r16 = StringsKt.toIntOrNull(r15);
        if (r16 == null) goto L42;
        r2 = r16.intValue();
    L42:
        r3.putString("product_id", String.valueOf(r14));
        r3.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");
        if (r2 == 4096) goto L49;
        if (r14 == (-1)) goto L49;
        if (Q1(r14) == false) goto L49;
        P1(r3);
        finish();
        return;
    L49:
        DoraBaseFragment r0 = N1(r14, r2);
        r0.setArguments(r3);
        FragmentTransaction r17 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L53;
        r17 = r17.replace(2131373275, r0);
    L53:
        r17.commitAllowingStateLoss();
    L36:
        r14 = ProductNameType.DORA_LITE.id;
    L30:
        r3 = new Bundle();
    L54:
        StringBuilder r18 = new StringBuilder("onNewIntent: intent=");
        r18.append(r8);
        r18.append(", data=");
        if (r8 == null) goto L57;
        r11 = r8.getData();
    L57:
        r18.append(r11);
        g49.d.d("DoraDeviceBindActivity", r18.toString());
        return;
    L23:
        if (r10.t() != true) goto L25;
        r1 = true;
        goto L25
    }

    public static DoraBaseFragment N1(int r3, int r4) {
        if (r3 != (-1)) goto L5;
    L8:
        g49.d.d("DoraDeviceBindActivity", "use DoraSmartDeviceBindFragment. productID = " + r3 + ", vendorID = " + r4);
        return new DoraSmartDeviceBindFragment();
    L5:
        if (r4 == 4096) goto L8;
        g49.d.d("DoraDeviceBindActivity", "use DoraDeviceBindFragment");
        return new DoraDeviceBindFragment();
    }
}
