package com.larus.dora.obric.device_management.setting.earbuds.keep_alive;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl;
import com.larus.dora.impl.alive.DoraKeepAliveAdapter;
import com.larus.dora.impl.alive.DoraKeepAliveViewModel;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.widget.HorizontalSpaceItemDecoration;
import com.larus.dora.impl.util.b0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 x2\u00020\u0001:\u0001xB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J$\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001a\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020\u001f2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010F\u001a\u00020:H\u0002J\b\u0010G\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020:H\u0016J\b\u0010I\u001a\u00020:H\u0016J\b\u0010J\u001a\u00020:H\u0016J\b\u0010K\u001a\u00020LH\u0016J\n\u0010M\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010N\u001a\u00020:H\u0002J\u0012\u0010O\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0018\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020LH\u0002J\u0010\u0010S\u001a\u00020:2\u0006\u0010Q\u001a\u00020-H\u0002J\b\u0010T\u001a\u00020\u001fH\u0002J\b\u0010U\u001a\u00020\u001fH\u0002J\b\u0010V\u001a\u00020\u001fH\u0002J\b\u0010W\u001a\u00020\u001fH\u0002J\b\u0010X\u001a\u00020\u001fH\u0002J\u0010\u0010Y\u001a\u00020:2\u0006\u0010Z\u001a\u00020-H\u0002J\u0014\u0010[\u001a\u00020'2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010LH\u0002J,\u0010]\u001a\u00020+2\u0006\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u00020\u000e2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020:0aH\u0002J\u0018\u0010b\u001a\u00020+2\u0006\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u00020\u000eH\u0002J\u0012\u0010c\u001a\u00020d2\b\b\u0002\u0010e\u001a\u00020-H\u0002J\f\u0010f\u001a\u00020:*\u00020+H\u0002J\u0010\u0010g\u001a\u00020:2\u0006\u0010E\u001a\u00020hH\u0002J\b\u0010i\u001a\u00020\u000eH\u0002J\b\u0010j\u001a\u00020\u000eH\u0002J\b\u0010k\u001a\u00020\u000eH\u0002J\b\u0010l\u001a\u00020\u000eH\u0002J\b\u0010m\u001a\u00020\u000eH\u0002J\f\u0010n\u001a\u00020:*\u00020'H\u0002J\u0010\u0010o\u001a\u00020:2\u0006\u0010p\u001a\u00020\u001fH\u0002J\f\u0010q\u001a\u00020\u000e*\u00020\u000eH\u0002J\f\u0010r\u001a\u00020\u000e*\u00020sH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010t\u001a*\u0012\u0004\u0012\u00020L\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0v0uj\u0014\u0012\u0004\u0012\u00020L\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0v`wX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/keep_alive/DoraObricEarbudsKeepAliveFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/alive/DoraKeepAliveViewModel;", "getModel", "()Lcom/larus/dora/impl/alive/DoraKeepAliveViewModel;", "model$delegate", "Lkotlin/Lazy;", "ignoreBatteryOptimizationsResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "containerWidth", "", "getContainerWidth", "()I", "containerWidth$delegate", "flowCompanionDeviceManager", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "getFlowCompanionDeviceManager", "()Lcom/larus/cdm/IFlowCompanionDeviceManager;", "flowCompanionDeviceManager$delegate", "companionDeviceAssociator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "getDevice", "()Lcom/bytedance/dora/device/DoraDevice;", "device$delegate", "pageMaskView", "Landroid/view/View;", "contentContainer", "Landroid/widget/LinearLayout;", "lockAppOptContainer", "lockAppRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cdmGroup", "cdmTips", "Landroid/widget/TextView;", "cdmSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "cdmSwitchCard", "Lcom/obric/oui/lisitem/OCardListItem;", "confirmedCdmEnabled", "", "autoStartGroup", "autoStartBtn", "autoStartHintGroup", "autoStartStepHint", "autoStartImgView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "autoStartRecyclerView", "batteryOptimizationGroup", "batteryOptimizationItem", "batteryOptimizationTips", "notificationSwitch", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initDoraKeepAliveCdm", "bindCdmSwitchListener", "onStart", "onDetach", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "initListeners", "startToAutoStartSetting", "updateCdmEnableDeviceDesc", "enable", "deviceName", "updateCdmRejectText", "buildContentView", "buildTitleBar", "buildScrollContent", "buildLockAppSection", "buildAutoStartSection", "applyAutoStartBtnBackground", "single", "buildTips", "text", "buildSwitchCard", "title", "position", "onSwitchCreated", "Lkotlin/Function1;", "buildArrowCard", "buildCardBackground", "Landroid/graphics/drawable/GradientDrawable;", "topOnly", "applyCardStyle", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolveTertiaryTextColor", "resolveCardBackgroundColor", "applyTitleBarTextStyle", "relaxClipForShadow", "target", "dp", "sp", "", "hashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsKeepAliveFragment extends DoraBaseFragment {
    public static final /* synthetic */ int F = 0;
    public View A;
    public OCardListItem B;
    public TextView C;
    public OSwitch D;
    public final HashMap<String, List<String>> E;
    public final Lazy f;
    public ActivityResultLauncher<Intent> g;
    public final Lazy h;
    public final Lazy i;
    public oy8.e j;
    public final Lazy k;
    public View l;
    public LinearLayout m;
    public View n;
    public RecyclerView o;
    public View p;
    public TextView q;
    public OSwitch r;
    public OCardListItem s;
    public boolean t;
    public View u;
    public View v;
    public View w;
    public TextView x;
    public SimpleDraweeView y;
    public RecyclerView z;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ DoraObricEarbudsKeepAliveFragment a;

        public b(DoraObricEarbudsKeepAliveFragment r1) {
            this.a = r1;
        }

        public final void onFailure(String r3, Throwable r4) {
            super.onFailure(r3, r4);
            g49.d.c("DoraObricEarbudsKeepAliveFragment", "onFailure: " + r3, r4);
            SimpleDraweeView r5 = this.a.y;
            if (r5 == null) goto L6;
            e1.o(r5);
            return;
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            g49.d.d("DoraObricEarbudsKeepAliveFragment", "onFinalImageSet: " + r2 + ", " + ((ImageInfo) r3));
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsKeepAliveFragment a;

        public c(DoraObricEarbudsKeepAliveFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            boolean r5 = ((Boolean) r3).booleanValue();
            DoraObricEarbudsKeepAliveFragment r6 = this.a;
            OCardListItem r0 = r6.B;
            if (r0 == null) goto L8;
            if (r5 == false) goto L6;
            int r7 = 2131903299;
        L7:
            r0.k(r6.getString(r7), this.a.aa0(120));
            goto L8
        L6:
            r7 = 2131903298;
        L8:
            OCardListItem r8 = this.a.B;
            if (r8 == null) goto L14;
            OTextView r9 = r8.getEndDetail();
            if (r9 == null) goto L14;
            DoraObricEarbudsKeepAliveFragment r10 = this.a;
            r9.setTextColor(r10.ea0());
            r9.setTextSize(2, 14.0f);
            Resources r11 = r10.getResources();
            TextViewCompat.setLineHeight(r9, (int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())));
        L14:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "keep_active_teaching";
    }

    public final void onDestroyView() {
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricEarbudsKeepAliveFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraKeepAliveViewModel.class), new DoraObricEarbudsKeepAliveFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsKeepAliveFragment$special$$inlined$activityViewModels$default$2(this));
        this.h = LazyKt.lazy(new g());
        this.i = LazyKt.lazy(new h());
        this.k = LazyKt.lazy(new i());
        HashMap<String, List<String>> r1 = new HashMap();
        r1.put("XIAOMI", CollectionsKt.listOf(new String[]{"com.miui.securitycenter/com.miui.permcenter.autostart.AutoStartManagementActivity", "com.miui.securitycenter"}));
        r1.put("SAMSUNG", Arrays.asList(new String[]{"com.samsung.android.sm_cn/com.samsung.android.sm.ui.ram.AutoRunActivity", "com.samsung.android.sm_cn/com.samsung.android.sm.ui.appmanagement.AppManagementActivity", "com.samsung.android.sm_cn/com.samsung.android.sm.ui.cstyleboard.SmartManagerDashBoardActivity", "com.samsung.android.sm_cn/.ui.ram.RamActivity", "com.samsung.android.sm_cn/.app.dashboard.SmartManagerDashBoardActivity", "com.samsung.android.sm/com.samsung.android.sm.ui.ram.AutoRunActivity", "com.samsung.android.sm/com.samsung.android.sm.ui.appmanagement.AppManagementActivity", "com.samsung.android.sm/com.samsung.android.sm.ui.cstyleboard.SmartManagerDashBoardActivity", "com.samsung.android.sm/.ui.ram.RamActivity", "com.samsung.android.sm/.app.dashboard.SmartManagerDashBoardActivity", "com.samsung.android.lool/com.samsung.android.sm.ui.battery.BatteryActivity", "com.samsung.android.sm_cn", "com.samsung.android.sm"}));
        r1.put("HUAWEI", Arrays.asList(new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity", "com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity", "com.huawei.systemmanager/.optimize.process.ProtectActivity", "com.huawei.systemmanager/.optimize.bootstart.BootStartActivity"}));
        r1.put("VIVO", Arrays.asList(new String[]{"com.iqoo.secure/.ui.phoneoptimize.BgStartUpManager", "com.iqoo.secure/.safeguard.PurviewTabActivity", "com.vivo.permissionmanager/.activity.BgStartUpManagerActivity", "com.iqoo.secure", "com.vivo.permissionmanager"}));
        r1.put("MEIZU", Arrays.asList(new String[]{"com.meizu.safe/.permission.SmartBGActivity", "com.meizu.safe/.permission.PermissionMainActivity", "com.meizu.safe"}));
        r1.put("OPPO", Arrays.asList(new String[]{"com.coloros.safecenter/.startupapp.StartupAppListActivity", "com.coloros.safecenter/.permission.startup.StartupAppListActivity", "com.oppo.safe/.permission.startup.StartupAppListActivity", "com.coloros.oppoguardelf/com.coloros.powermanager.fuelgaue.PowerUsageModelActivity", "com.coloros.safecenter/com.coloros.privacypermissionsentry.PermissionTopActivity", "com.coloros.safecenter", "com.oppo.safe", "com.coloros.oppoguardelf"}));
        r1.put("ONEPLUS", Arrays.asList(new String[]{"com.oneplus.security/.chainlaunch.view.ChainLaunchAppListActivity", "com.oneplus.security"}));
        r1.put("LETV", Arrays.asList(new String[]{"com.letv.android.letvsafe/.AutobootManageActivity", "com.letv.android.letvsafe/.BackgroundAppManageActivity", "com.letv.android.letvsafe"}));
        r1.put("ZTE", Arrays.asList(new String[]{"com.zte.heartyservice/.autorun.AppAutoRunManager", "com.zte.heartyservice"}));
        r1.put("F", Arrays.asList(new String[]{"com.gionee.softmanager/.MainActivity", "com.gionee.softmanager"}));
        r1.put("SMARTISANOS", Arrays.asList(new String[]{"com.smartisanos.security/.invokeHistory.InvokeHistoryActivity", "com.smartisanos.security"}));
        r1.put("360", Arrays.asList(new String[]{"com.yulong.android.coolsafe/.ui.activity.autorun.AutoRunListActivity", "com.yulong.android.coolsafe"}));
        r1.put("ULONG", Arrays.asList(new String[]{"com.yulong.android.coolsafe/.ui.activity.autorun.AutoRunListActivity", "com.yulong.android.coolsafe"}));
        r1.put("COOLPAD", Arrays.asList(new String[]{"com.yulong.android.security/com.yulong.android.seccenter.tabbarmain", "com.yulong.android.security"}));
        r1.put("LENOVO", Arrays.asList(new String[]{"com.lenovo.security/.purebackground.PureBackgroundActivity", "com.lenovo.security"}));
        r1.put("HTC", Arrays.asList(new String[]{"com.htc.pitroad/.landingpage.activity.LandingPageActivity", "com.htc.pitroad"}));
        r1.put("ASUS", Arrays.asList(new String[]{"com.asus.mobilemanager/.MainActivity", "com.asus.mobilemanager"}));
        r1.put("YULONG", Arrays.asList(new String[]{"com.yulong.android.softmanager/.SpeedupActivity", "com.yulong.android.security/com.yulong.android.seccenter.tabbarmain", "com.yulong.android.security"}));
        r1.put("HONOR", Arrays.asList(new String[]{"com.hihonor.systemmanager/com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity", "com.hihonor.systemmanager"}));
        this.E = r1;
    }

    public final DoraDevice ba0() {
        return (DoraDevice) this.k.getValue();
    }

    public final DoraKeepAliveViewModel ca0() {
        return (DoraKeepAliveViewModel) this.f.getValue();
    }

    public final int da0() {
        return v19.c.a(2130972079, requireContext(), 2131103136);
    }

    public final int ea0() {
        return v19.c.a(2130972081, requireContext(), 2131103143);
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        ActivityResultLauncher<Intent> r0 = this.g;
        if (r0 == null) goto L5;
        r0.unregister();
    L5:
        t39.c r1 = j49.b.a;
        j49.b.a.b("keep_alive_page");
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        ca0().loadIgnoreBatteryOptimization();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.l;
    }

    public final void W90(OCardListItem r7) {
        ViewGroup.LayoutParams r0 = r7.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r7.getCardContainer().setLayoutParams(r1);
    L9:
        r7.getContentContainer().setPadding(0, 0, aa0(4), 0);
        r7.getTitleContainer().setGravity(16);
        r7.getTitleContainer().setPadding(aa0(12), aa0(8), aa0(8), aa0(8));
        OTextView r2 = r7.getTitleView();
        r2.setGravity(8388611);
        r2.setMaxLines(1);
        r2.setTextColor(da0());
        r2.setTextSize(2, 16.0f);
        Resources r3 = getResources();
        TextViewCompat.setLineHeight(r2, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r7.o(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final GradientDrawable X90(boolean r12) {
        float r0 = aa0(20);
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setColor(v19.c.a(2130970532, requireContext(), 2131102539));
        if (r12 == false) goto L5;
        float[] r13 = {r0, r0, r0, r0, 0.0f, 0.0f, 0.0f, 0.0f};
    L6:
        r1.setCornerRadii(r13);
        return r1;
    L5:
        r13 = new float[]{r0, r0, r0, r0, r0, r0, r0, r0};
        goto L6
    }

    public final TextView Z90(String r4) {
        TextView r0 = new TextView(requireContext());
        if (r4 != null) goto L6;
        r4 = getString(2131903312);
    L6:
        r0.setText(r4);
        r0.setTextAlignment(5);
        r0.setTextColor(ea0());
        r0.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, -2);
        r5.setMarginStart(aa0(20));
        r5.setMarginEnd(aa0(20));
        r5.topMargin = aa0(8);
        r0.setLayoutParams(r5);
        return r0;
    }

    public final int aa0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
        IFlowCompanionDeviceManager r3 = (IFlowCompanionDeviceManager) this.i.getValue();
        if (r3 == null) goto L5;
        FlowCompanionDeviceAssociatorImpl r4 = r3.j(this);
    L6:
        this.j = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final OCardListItem Y90(String r6, Function1 r7) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, 0);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(1);
        r0.m(true);
        r0.r(false);
        OSwitch r8 = r0.getEndSwitch();
        if (r8 == null) goto L5;
        r7.invoke(r8);
    L5:
        r0.setOnContentClickListener(new e(r0));
        W90(r0);
        return r0;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        boolean r1 = true;
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r14 = true;
    L6:
        boolean r0 = ObricFeatureServiceDelegate.b.b();
        if (r14 == false) goto L15;
        if (r0 == true) goto L15;
        View r15 = this.A;
        if (r15 == null) goto L12;
        e1.x(r15);
    L12:
        TextView r16 = this.C;
        if (r16 == null) goto L21;
        e1.x(r16);
    L21:
        OCardListItem r17 = this.B;
        if (r17 == null) goto L24;
        r17.setOnContentClickListener(new com.larus.dora.obric.device_management.setting.earbuds.keep_alive.c(this));
    L24:
        View r18 = this.v;
        if (r18 == null) goto L28;
        e1.d(r18, new d(this));
    L28:
        if (com.larus.dora.impl.alive.a.a((IFlowCompanionDeviceManager) this.i.getValue()) == false) goto L57;
        View r110 = this.p;
        if (r110 == null) goto L32;
        r110.setVisibility(0);
    L32:
        TextView r111 = this.q;
        if (r111 == null) goto L35;
        r111.setVisibility(0);
    L35:
        OSwitch r112 = this.r;
        if (r112 == null) goto L40;
        r112.setOnCheckedChangeListener(null);
        OSwitch r113 = this.r;
        if (r113 == null) goto L40;
        r113.setOnCheckedChangeListener(new j(this));
    L40:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsKeepAliveFragment$initDoraKeepAliveCdm$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        if (ba0() == null) goto L64;
        DoraKeepAliveViewModel r114 = ca0();
        IFlowCompanionDeviceManager r4 = (IFlowCompanionDeviceManager) this.i.getValue();
        oy8.e r5 = this.j;
        DoraDevice r6 = ba0();
        if (r6 == null) goto L45;
        String r7 = r6.mac;
    L46:
        String r8 = "";
        if (r7 != null) goto L49;
        r7 = "";
    L49:
        DoraDevice r9 = ba0();
        if (r9 == null) goto L52;
        String r10 = r9.sn;
    L53:
        if (r10 == null) goto L56;
        r8 = r10;
    L56:
        r114.loadCdmState(r4, r5, r7, r8);
        goto L64
    L52:
        r10 = null;
        goto L53
    L45:
        r7 = null;
    L64:
        if (z2.a.getDoraKeepAliveMethodsConfig() == true) goto L66;
    L73:
        View r115 = this.n;
        if (r115 == null) goto L76;
        r115.setVisibility(0);
    L76:
        View r116 = this.u;
        if (r116 == null) goto L79;
        r116.setVisibility(0);
    L79:
        OSwitch r117 = this.D;
        if (r117 == null) goto L82;
        r117.setOnCheckedChangeListener(null);
        r117.setChecked(ca0().isOngoingNotificationEnabled());
        r117.setOnCheckedChangeListener(new com.larus.dora.obric.device_management.setting.earbuds.keep_alive.a(this));
    L82:
        com.larus.dora.impl.alive.i r118 = com.larus.dora.impl.alive.l.a();
        int r3 = aa0(198);
        int r11 = (int) (((((Number) this.h.getValue()).intValue() - r3) / 2.0f) - MarkdownDimensExtKt.c());
        RecyclerView r20 = this.o;
        if (r20 == null) goto L96;
        final Context r119 = r12.getContext();
        r20.setLayoutManager(new DoraObricEarbudsKeepAliveFragment$onViewCreated$2$1(r119));
        if (r118.b.size() != 1) goto L87;
        int r120 = r11;
    L88:
        int r21 = MarkdownDimensExtKt.c();
        if (r118.b.size() == 1) goto L92;
        r11 = 0;
    L92:
        r20.setPaddingRelative(r120, r21, r11, i5.E());
        if (r118.b.size() != 1) goto L95;
        r20.setOverScrollMode(2);
    L95:
        r20.addItemDecoration(new HorizontalSpaceItemDecoration(MarkdownDimensExtKt.c()));
        r20.setAdapter(new DoraKeepAliveAdapter(r118.b, r3));
        goto L96
    L87:
        r120 = 0;
    L96:
        int r121 = ((Number) i5.n1.getValue()).intValue();
        if (r118.c.size() != 1) goto L162;
        RecyclerView r122 = this.z;
        if (r122 == null) goto L101;
        e1.o(r122);
    L101:
        final com.larus.dora.impl.alive.j r123 = (com.larus.dora.impl.alive.j) CollectionsKt.first(r118.c);
        String r124 = r123.b;
        if (r124 != null) goto L104;
    L107:
        boolean r125 = true;
    L108:
        if (r125 == false) goto L123;
        String r126 = r123.a;
        if (r126 != null) goto L112;
    L115:
        boolean r127 = true;
    L116:
        if (r127 == false) goto L123;
        View r128 = this.w;
        if (r128 == null) goto L120;
        e1.o(r128);
    L120:
        View r129 = this.v;
        if (r129 == null) goto L171;
        r129.setBackground(X90(false));
    L171:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsKeepAliveFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        b0.a.getClass();
        b0.A();
        return;
    L112:
        if (r126.length() == 0) goto L115;
        r127 = false;
    L123:
        View r130 = this.w;
        if (r130 == null) goto L126;
        e1.x(r130);
    L126:
        View r131 = this.v;
        if (r131 == null) goto L129;
        r131.setBackground(X90(true));
    L129:
        String r132 = r123.b;
        if (r132 != null) goto L132;
    L135:
        boolean r133 = true;
    L136:
        if (r133 == false) goto L140;
        TextView r134 = this.x;
        if (r134 == null) goto L146;
        e1.o(r134);
    L146:
        String r135 = r123.a;
        if (r135 != null) goto L149;
    L152:
        if (r1 == false) goto L156;
        SimpleDraweeView r136 = this.y;
        if (r136 == null) goto L171;
        e1.o(r136);
        goto L171
    L156:
        SimpleDraweeView r137 = this.y;
        if (r137 == null) goto L159;
        e1.x(r137);
    L159:
        SimpleDraweeView r138 = this.y;
        if (r138 == null) goto L171;
        ImageLoaderKt.y(r138, r123.a, "dora_keep_alive_auto_start_image", new f(r123, this), 4);
        goto L171
    L149:
        if (r135.length() == 0) goto L152;
        r1 = false;
        goto L152
    L140:
        TextView r139 = this.x;
        if (r139 == null) goto L143;
        e1.x(r139);
    L143:
        TextView r140 = this.x;
        if (r140 == null) goto L146;
        r140.setText(r123.b);
        goto L146
    L132:
        if (r132.length() == 0) goto L135;
        r133 = false;
        goto L136
    L104:
        if (r124.length() == 0) goto L107;
        r125 = false;
        goto L108
    L162:
        View r2 = this.w;
        if (r2 == null) goto L165;
        e1.o(r2);
    L165:
        RecyclerView r22 = this.z;
        if (r22 == null) goto L168;
        e1.x(r22);
    L168:
        RecyclerView r23 = this.z;
        if (r23 == null) goto L171;
        r23.setLayoutManager(new LinearLayoutManager(r23.getContext(), 0, false));
        r23.setPaddingRelative(0, MarkdownDimensExtKt.c(), 0, i5.E());
        r23.addItemDecoration(new HorizontalSpaceItemDecoration(MarkdownDimensExtKt.c()));
        r23.setAdapter(new DoraKeepAliveAdapter(r118.c, r121));
        goto L171
    L66:
        if (com.larus.dora.impl.alive.a.a((IFlowCompanionDeviceManager) this.i.getValue()) == false) goto L73;
        View r141 = this.n;
        if (r141 == null) goto L70;
        r141.setVisibility(8);
    L70:
        View r142 = this.u;
        if (r142 == null) goto L79;
        r142.setVisibility(8);
        goto L79
    L57:
        View r143 = this.p;
        if (r143 == null) goto L60;
        r143.setVisibility(8);
    L60:
        TextView r144 = this.q;
        if (r144 == null) goto L64;
        r144.setVisibility(8);
    L15:
        View r145 = this.A;
        if (r145 == null) goto L18;
        e1.o(r145);
    L18:
        TextView r146 = this.C;
        if (r146 == null) goto L21;
        e1.o(r146);
        goto L21
    L5:
        r14 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        LinearLayout r2 = new LinearLayout(r1);
        r2.setOrientation(1);
        r2.setClipChildren(true);
        r2.setClipToPadding(true);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        OFloatingTitleBar r4 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r4);
        r4.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r4.setCenterTitle(getString(2131903316));
        r4.setCenterTitleColor(da0());
        TextView r7 = (TextView) r4.findViewById(2131365427);
        if (r7 == null) goto L5;
        r7.setTextColor(da0());
        r7.setTextSize(2, 16.0f);
        Resources r14 = getResources();
        TextViewCompat.setLineHeight(r7, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics())));
        r7.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r4.R(false);
        final View r8 = OFloatingTitleBar.k(r4, null, 6);
        r8.setOnClickListener(new n(this));
        r4.post(new com.larus.dora.obric.device_management.setting.earbuds.keep_alive.b(this, r8));
        r2.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        Context r5 = requireContext();
        LinearLayout r9 = new LinearLayout(r5);
        r9.setOrientation(1);
        r9.setClipChildren(false);
        r9.setClipToPadding(false);
        r9.setPadding(aa0(12), 0, aa0(12), aa0(56));
        Context r6 = requireContext();
        LinearLayout r10 = new LinearLayout(r6);
        r10.setOrientation(1);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r10.setBackground(X90(false));
        r10.setPadding(aa0(16), aa0(16), aa0(16), 0);
        TextView r3 = new TextView(r6);
        r3.setText(getString(2131903300));
        r3.setTextColor(da0());
        r3.setTextSize(2, 16.0f);
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r10.addView(r3);
        TextView r11 = new TextView(r6);
        r11.setText(getString(2131903309));
        r11.setTextColor(ea0());
        r11.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, -2);
        r15.topMargin = aa0(4);
        Unit r12 = Unit.INSTANCE;
        r10.addView(r11, r15);
        RecyclerView r13 = new RecyclerView(r6);
        r13.setClipToPadding(false);
        r13.setClipChildren(false);
        r10.addView(r13, new LinearLayout.LayoutParams(-1, aa0(436)));
        this.o = r13;
        r9.addView(r10);
        this.n = r10;
        this.s = Y90(getString(2131903313), new l(this));
        LinearLayout r16 = new LinearLayout(r5);
        r16.setOrientation(1);
        r16.setClipChildren(false);
        r16.setClipToPadding(false);
        ViewGroup.LayoutParams r20 = r16.getLayoutParams();
        if ((r20 instanceof LinearLayout.LayoutParams) == false) goto L8;
        LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) r20;
    L10:
        if (r21 == null) goto L12;
        r21.topMargin = aa0(24);
    L12:
        r16.addView(this.s);
        ViewGroup.LayoutParams r22 = r16.getLayoutParams();
        if ((r22 instanceof LinearLayout.LayoutParams) == false) goto L15;
        LinearLayout.LayoutParams r23 = (LinearLayout.LayoutParams) r22;
    L16:
        if (r23 == null) goto L18;
        r23.topMargin = aa0(24);
    L18:
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-1, -2);
        r24.topMargin = aa0(24);
        r9.addView(r16, r24);
        this.p = r16;
        TextView r25 = Z90(null);
        r9.addView(r25);
        this.q = r25;
        Context r26 = requireContext();
        LinearLayout r27 = new LinearLayout(r26);
        r27.setOrientation(1);
        r27.setBackground(X90(false));
        r27.setClipChildren(false);
        r27.setClipToPadding(false);
        FrameLayout r28 = new FrameLayout(r26);
        r28.setMinimumHeight(aa0(56));
        r28.setPadding(aa0(16), aa0(12), aa0(16), aa0(12));
        LinearLayout r30 = new LinearLayout(r26);
        r30.setOrientation(1);
        TextView r111 = new TextView(r26);
        r111.setText(getString(2131903266));
        r111.setMaxLines(2);
        r111.setTextColor(da0());
        r111.setTextSize(2, 17.0f);
        r111.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r30.addView(r111);
        TextView r112 = new TextView(r26);
        r112.setText(getString(2131903283));
        r112.setMaxLines(2);
        r112.setTextColor(ea0());
        r112.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-1, -2);
        r113.topMargin = aa0(2);
        r30.addView(r112, r113);
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-1, -2, 16);
        r114.setMarginEnd(aa0(24));
        r28.addView(r30, r114);
        ImageView r31 = new ImageView(r26);
        r31.setImageResource(2131240848);
        r28.addView(r31, new FrameLayout.LayoutParams(-2, -2, 8388629));
        r27.addView(r28);
        this.v = r28;
        LinearLayout r32 = new LinearLayout(r26);
        r32.setOrientation(1);
        TextView r33 = new TextView(r26);
        r33.setText(getString(2131903282));
        r33.setTextColor(v19.c.a(2130972082, requireContext(), 2131103146));
        r33.setTextSize(2, 15.0f);
        r33.setPadding(aa0(16), 0, aa0(16), 0);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-1, -2);
        r115.topMargin = MarkdownDimensExtKt.c();
        r32.addView(r33, r115);
        this.x = r33;
        View r34 = new SimpleDraweeView(r26);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-1, aa0(460));
        r116.gravity = 1;
        r116.topMargin = aa0(20);
        r32.addView(r34, r116);
        this.y = r34;
        r32.addView(new Space(r26), new LinearLayout.LayoutParams(1, MarkdownDimensExtKt.c()));
        r27.addView(r32);
        this.w = r32;
        View r35 = new RecyclerView(r26);
        r35.setClipToPadding(false);
        r27.addView(r35, new LinearLayout.LayoutParams(-1, -2));
        this.z = r35;
        ViewGroup.LayoutParams r36 = r27.getLayoutParams();
        if ((r36 instanceof LinearLayout.LayoutParams) == false) goto L21;
        LinearLayout.LayoutParams r37 = (LinearLayout.LayoutParams) r36;
    L22:
        if (r37 == null) goto L24;
        r37.topMargin = aa0(16);
    L24:
        LinearLayout.LayoutParams r38 = new LinearLayout.LayoutParams(-1, -2);
        r38.topMargin = aa0(16);
        r9.addView(r27, r38);
        this.u = r27;
        String r40 = getString(2131903296);
        OCardListItem r41 = new OCardListItem(requireContext(), null, 6, 0);
        r41.setCardType(0);
        OCardListItem.h(r41, 0);
        r41.setShowCardBg(true);
        r41.p(false);
        r41.setTitle(r40);
        r41.s(true);
        r41.q(false);
        r41.setDefaultCustomEndView(3);
        r41.m(true);
        r41.k("", aa0(120));
        OTextView r42 = r41.getEndDetail();
        if (r42 == null) goto L27;
        r42.setTextColor(ea0());
        r42.setTextSize(2, 14.0f);
        Resources r43 = getResources();
        TextViewCompat.setLineHeight(r42, (int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r43, r43.getDisplayMetrics())));
    L27:
        r41.setDefaultTailIcon(0);
        r41.r(true);
        W90(r41);
        this.B = r41;
        LinearLayout r44 = new LinearLayout(r5);
        r44.setOrientation(1);
        r44.setClipChildren(false);
        r44.setClipToPadding(false);
        r44.addView(this.B);
        LinearLayout.LayoutParams r45 = new LinearLayout.LayoutParams(-1, -2);
        r45.topMargin = aa0(16);
        r9.addView(r44, r45);
        this.A = r44;
        TextView r46 = Z90(getString(2131903297));
        r9.addView(r46);
        this.C = r46;
        View r47 = Y90(getString(2131903315), new m(this));
        LinearLayout.LayoutParams r48 = new LinearLayout.LayoutParams(-1, -2);
        r48.topMargin = aa0(24);
        r9.addView(r47, r48);
        r9.addView(Z90(getString(2131903314)));
        this.m = r9;
        NestedScrollView r50 = new NestedScrollView(r5);
        r50.setClipChildren(false);
        r50.setClipToPadding(false);
        r50.setOverScrollMode(2);
        r50.setFillViewport(true);
        r50.setPadding(0, aa0(8), 0, 0);
        r50.addView(this.m, new ViewGroup.LayoutParams(-1, -2));
        r2.addView(r50, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r51 = new FrameLayout(r1);
        r51.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r51.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        View r52 = new View(r1);
        r52.setBackgroundColor(ContextCompat.getColor(r1, 2131103066));
        r52.setClickable(true);
        r52.setFocusable(true);
        r51.addView(r52, new FrameLayout.LayoutParams(-1, -1));
        this.l = r52;
        return r51;
    L21:
        r37 = null;
        goto L22
    L15:
        r23 = null;
        goto L16
    L8:
        r21 = null;
        goto L10
    }
}
