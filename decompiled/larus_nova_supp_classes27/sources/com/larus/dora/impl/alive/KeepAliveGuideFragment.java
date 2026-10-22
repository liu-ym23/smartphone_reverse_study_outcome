package com.larus.dora.impl.alive;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl;
import com.larus.dora.impl.databinding.LarusDoraPageKeepAliveBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.widget.HorizontalSpaceItemDecoration;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import com.larus.dora.impl.view.DoraItemTitleTextView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0016J\b\u00100\u001a\u00020!H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020!H\u0002J\u0012\u00104\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u00105\u001a\u00020!2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000202H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u00106\u001a\u000207H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR6\u0010:\u001a*\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u0002020<0;j\u0014\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u0002020<`=X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/dora/impl/alive/KeepAliveGuideFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageKeepAliveBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/alive/DoraKeepAliveViewModel;", "getModel", "()Lcom/larus/dora/impl/alive/DoraKeepAliveViewModel;", "model$delegate", "Lkotlin/Lazy;", "ignoreBatteryOptimizationsResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "containerWidth", "", "getContainerWidth", "()I", "containerWidth$delegate", "flowCompanionDeviceManager", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "getFlowCompanionDeviceManager", "()Lcom/larus/cdm/IFlowCompanionDeviceManager;", "flowCompanionDeviceManager$delegate", "companionDeviceAssociator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "getDevice", "()Lcom/bytedance/dora/device/DoraDevice;", "device$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initDoraKeepAliveCdm", "onStart", "onDetach", "getCurrentPageName", "", "initListeners", "startToAutoStartSetting", "updateCdmEnableDeviceDesc", "enable", "", "deviceName", "updateCdmRejectText", "hashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeepAliveGuideFragment extends DoraBaseFragment {
    public static final /* synthetic */ int n = 0;
    public LarusDoraPageKeepAliveBinding f;
    public final Lazy g;
    public ActivityResultLauncher<Intent> h;
    public final Lazy i;
    public final Lazy j;
    public oy8.e k;
    public final Lazy l;
    public final HashMap<String, List<String>> m;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ LarusDoraPageKeepAliveBinding a;

        public b(LarusDoraPageKeepAliveBinding r1) {
            this.a = r1;
        }

        public final void onFailure(String r3, Throwable r4) {
            super.onFailure(r3, r4);
            g49.d.c("KeepAliveGuideFragment", "onFailure: " + r3, r4);
            e1.o(this.a.e);
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            g49.d.d("KeepAliveGuideFragment", "onFinalImageSet: " + r2 + ", " + ((ImageInfo) r3));
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ KeepAliveGuideFragment a;

        public c(KeepAliveGuideFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            LarusDoraPageKeepAliveBinding r4 = this.a.f;
            if (r4 == null) goto L13;
            ItemTextArrow r5 = r4.h;
            if (r5 == null) goto L13;
            TextView r6 = r5.getSubTextView();
            if (r6 == null) goto L13;
            if (r3 == false) goto L10;
            int r7 = 2131903299;
        L11:
            r6.setText(r7);
            goto L13
        L10:
            r7 = 2131903298;
        L13:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "keep_active_teaching";
    }

    public KeepAliveGuideFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraKeepAliveViewModel.class), new KeepAliveGuideFragment$special$$inlined$activityViewModels$default$1(this), new KeepAliveGuideFragment$special$$inlined$activityViewModels$default$2(this));
        this.i = LazyKt.lazy(new n());
        this.j = LazyKt.lazy(new o());
        this.l = LazyKt.lazy(new p());
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
        this.m = r1;
    }

    public final DoraDevice W90() {
        return (DoraDevice) this.l.getValue();
    }

    public final DoraKeepAliveViewModel X90() {
        return (DoraKeepAliveViewModel) this.g.getValue();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        ActivityResultLauncher<Intent> r0 = this.h;
        if (r0 == null) goto L5;
        r0.unregister();
    L5:
        t39.c r1 = j49.b.a;
        j49.b.a.b("keep_alive_page");
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        X90().loadIgnoreBatteryOptimization();
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new t(this));
        IFlowCompanionDeviceManager r3 = (IFlowCompanionDeviceManager) this.j.getValue();
        if (r3 == null) goto L5;
        FlowCompanionDeviceAssociatorImpl r4 = r3.j(this);
    L6:
        this.k = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        boolean r1 = true;
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r15 = true;
    L6:
        boolean r0 = ObricFeatureServiceDelegate.b.b();
        LarusDoraPageKeepAliveBinding r3 = this.f;
        if (r3 == null) goto L12;
        if (r15 == false) goto L11;
        if (r0 == true) goto L11;
        e1.x(r3.i);
        e1.x(r3.j);
    L11:
        e1.o(r3.i);
        e1.o(r3.j);
    L12:
        LarusDoraPageKeepAliveBinding r16 = this.f;
        if (r16 == null) goto L15;
        ItemTextArrow r17 = r16.h;
    L16:
        e1.d(r17, new v(this));
        LarusDoraPageKeepAliveBinding r18 = this.f;
        if (r18 == null) goto L19;
        ConstraintLayout r110 = r18.b;
    L20:
        e1.d(r110, new w(this));
        final LarusDoraPageKeepAliveBinding r111 = this.f;
        if (r111 == null) goto L101;
        NovaTitleBarEx r4 = r111.r;
        NovaTitleBarEx.Y5(r4, getString(2131903316), null, null, 6);
        NovaTitleBarEx.b6(r4, 2131240517, false, null, null, new q(this), 14);
        if (com.larus.dora.impl.alive.a.a((IFlowCompanionDeviceManager) this.j.getValue()) == false) goto L44;
        r111.k.setVisibility(0);
        r111.m.setVisibility(0);
        LarusDoraPageKeepAliveBinding r5 = this.f;
        if (r5 == null) goto L27;
        r5.l.getToggleView().a = true;
        e1.d(r5.l, new u(this));
    L27:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new KeepAliveGuideFragment$initDoraKeepAliveCdm$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        if (W90() == null) goto L46;
        DoraKeepAliveViewModel r6 = X90();
        IFlowCompanionDeviceManager r7 = (IFlowCompanionDeviceManager) this.j.getValue();
        oy8.e r8 = this.k;
        DoraDevice r9 = W90();
        if (r9 == null) goto L32;
        String r10 = r9.mac;
    L33:
        String r11 = "";
        if (r10 != null) goto L36;
        r10 = "";
    L36:
        DoraDevice r12 = W90();
        if (r12 == null) goto L39;
        String r20 = r12.sn;
    L40:
        if (r20 == null) goto L43;
        r11 = r20;
    L43:
        r6.loadCdmState(r7, r8, r10, r11);
        goto L46
    L39:
        r20 = null;
        goto L40
    L32:
        r10 = null;
    L46:
        if (z2.a.getDoraKeepAliveMethodsConfig() == true) goto L48;
    L50:
        r111.o.setVisibility(0);
        r111.c.setVisibility(0);
    L51:
        r111.n.getToggleView().setChecked(X90().isOngoingNotificationEnabled());
        r111.n.getToggleView().setOnCheckedChangeListener(new r(this));
        i r21 = l.a();
        int r22 = ((Number) i5.n1.getValue()).intValue();
        int r23 = (int) (((((Number) this.i.getValue()).intValue() - r22) / 2.0f) - MarkdownDimensExtKt.c());
        RecyclerView r24 = r111.p;
        r24.setLayoutManager(new LinearLayoutManager(r13.getContext(), 0, false));
        if (r21.b.size() != 1) goto L54;
        int r112 = r23;
    L55:
        int r25 = MarkdownDimensExtKt.c();
        if (r21.b.size() == 1) goto L59;
        r23 = 0;
    L59:
        r24.setPaddingRelative(r112, r25, r23, i5.E());
        if (r21.b.size() != 1) goto L62;
        r24.setOverScrollMode(2);
    L62:
        r24.addItemDecoration(new HorizontalSpaceItemDecoration(MarkdownDimensExtKt.c()));
        r24.setAdapter(new DoraKeepAliveAdapter(r21.b, r22));
        if (r21.c.size() != 1) goto L100;
        e1.o(r111.f);
        final j r113 = (j) CollectionsKt.first(r21.c);
        String r26 = r113.b;
        if (r26 != null) goto L67;
    L70:
        boolean r27 = true;
    L71:
        if (r27 == false) goto L81;
        String r28 = r113.a;
        if (r28 != null) goto L75;
    L78:
        boolean r30 = true;
    L79:
        if (r30 == false) goto L81;
        e1.o(r111.d);
        r111.b.setBackgroundResource(2131239210);
        goto L101
    L75:
        if (r28.length() == 0) goto L78;
        r30 = false;
    L81:
        e1.x(r111.d);
        r111.b.setBackgroundResource(2131239212);
        String r31 = r113.b;
        if (r31 != null) goto L84;
    L87:
        boolean r32 = true;
    L88:
        if (r32 == false) goto L90;
        e1.o(r111.g);
    L91:
        String r33 = r113.a;
        if (r33 != null) goto L94;
    L97:
        if (r1 == false) goto L99;
        e1.o(r111.e);
        goto L101
    L99:
        e1.x(r111.e);
        ImageLoaderKt.y(r111.e, r113.a, "dora_keep_alive_auto_start_image", new s(r113, r111), 4);
        goto L101
    L94:
        if (r33.length() == 0) goto L97;
        r1 = false;
        goto L97
    L90:
        e1.x(r111.g);
        r111.g.setText(r113.b);
        goto L91
    L84:
        if (r31.length() == 0) goto L87;
        r32 = false;
        goto L88
    L67:
        if (r26.length() == 0) goto L70;
        r27 = false;
        goto L71
    L100:
        e1.o(r111.d);
        e1.x(r111.f);
        RecyclerView r114 = r111.f;
        r114.setLayoutManager(new LinearLayoutManager(r111.a.getContext(), 0, false));
        r114.setPaddingRelative(0, MarkdownDimensExtKt.c(), 0, i5.E());
        r114.addItemDecoration(new HorizontalSpaceItemDecoration(MarkdownDimensExtKt.c()));
        r114.setAdapter(new DoraKeepAliveAdapter(r21.c, r22));
        goto L101
    L54:
        r112 = 0;
        goto L55
    L48:
        if (com.larus.dora.impl.alive.a.a((IFlowCompanionDeviceManager) this.j.getValue()) == false) goto L50;
        r111.o.setVisibility(8);
        r111.c.setVisibility(8);
        goto L51
    L44:
        r111.k.setVisibility(8);
        r111.m.setVisibility(8);
    L101:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new KeepAliveGuideFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        b0.a.getClass();
        b0.A();
        return;
    L19:
        r110 = null;
        goto L20
    L15:
        r17 = null;
        goto L16
    L5:
        r15 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r23, ViewGroup r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        View r0 = r23.inflate(2131562272, r24, false);
        int r1 = 2131369637;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131369637)) == null) goto L53;
        r1 = 2131369638;
        ConstraintLayout r5 = ViewBindings.findChildViewById(r0, 2131369638);
        if (r5 == null) goto L53;
        r1 = 2131369639;
        ItemGroup r6 = ViewBindings.findChildViewById(r0, 2131369639);
        if (r6 == null) goto L53;
        r1 = 2131369640;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131369640);
        if (r7 == null) goto L53;
        r1 = 2131369641;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r0, 2131369641);
        if (r8 == null) goto L53;
        r1 = 2131369642;
        RecyclerView r9 = ViewBindings.findChildViewById(r0, 2131369642);
        if (r9 == null) goto L53;
        r1 = 2131369643;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r0, 2131369643);
        if (r10 == null) goto L53;
        r1 = 2131369644;
        if (((DoraTextView) ViewBindings.findChildViewById(r0, 2131369644)) == null) goto L53;
        r1 = 2131369645;
        if (((DoraTextView) ViewBindings.findChildViewById(r0, 2131369645)) == null) goto L53;
        r1 = 2131369649;
        ItemTextArrow r11 = ViewBindings.findChildViewById(r0, 2131369649);
        if (r11 == null) goto L53;
        r1 = 2131369650;
        ItemGroup r12 = ViewBindings.findChildViewById(r0, 2131369650);
        if (r12 == null) goto L53;
        r1 = 2131369651;
        AppCompatTextView r13 = ViewBindings.findChildViewById(r0, 2131369651);
        if (r13 == null) goto L53;
        r1 = 2131369652;
        ItemGroup r14 = ViewBindings.findChildViewById(r0, 2131369652);
        if (r14 == null) goto L53;
        r1 = 2131369653;
        DoraItemTextToggleSubTitle r15 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r0, 2131369653);
        if (r15 == null) goto L53;
        r1 = 2131369654;
        AppCompatTextView r16 = ViewBindings.findChildViewById(r0, 2131369654);
        if (r16 == null) goto L53;
        r1 = 2131369660;
        if (ViewBindings.findChildViewById(r0, 2131369660) == null) goto L53;
        r1 = 2131369661;
        ItemTextToggle r17 = ViewBindings.findChildViewById(r0, 2131369661);
        if (r17 == null) goto L53;
        r1 = 2131369662;
        if (ViewBindings.findChildViewById(r0, 2131369662) == null) goto L53;
        r1 = 2131379162;
        ConstraintLayout r18 = ViewBindings.findChildViewById(r0, 2131379162);
        if (r18 == null) goto L53;
        r1 = 2131379163;
        if (((DoraTextView) ViewBindings.findChildViewById(r0, 2131379163)) == null) goto L53;
        r1 = 2131379164;
        if (((DoraItemTitleTextView) ViewBindings.findChildViewById(r0, 2131379164)) == null) goto L53;
        r1 = 2131379165;
        RecyclerView r110 = ViewBindings.findChildViewById(r0, 2131379165);
        if (r110 == null) goto L53;
        r1 = 2131385238;
        NestedScrollView r20 = ViewBindings.findChildViewById(r0, 2131385238);
        if (r20 == null) goto L53;
        r1 = 2131388772;
        NovaTitleBarEx r21 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r21 == null) goto L53;
        LinearLayout r2 = (LinearLayout) r0;
        this.f = new LarusDoraPageKeepAliveBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21);
        return r2;
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
