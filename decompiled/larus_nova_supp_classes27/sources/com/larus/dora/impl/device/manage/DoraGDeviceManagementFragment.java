package com.larus.dora.impl.device.manage;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.dora.impl.databinding.LarusDoraGDeviceManagementPageBinding;
import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;
import com.larus.dora.impl.device.manage.widget.DoraDeviceManagementConnectFailedDialog;
import com.larus.dora.impl.device.manage.widget.DoraGDeviceManagementRefreshHeader;
import com.larus.dora.impl.device.manage.widget.DoraGDeviceManagementSwitchPopup;
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020'H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020'H\u0002J\u0010\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u0014H\u0002J\b\u00105\u001a\u00020'H\u0002J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u00020'H\u0002J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u0014H\u0002J\b\u0010:\u001a\u00020'H\u0002J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020'H\u0002J\b\u0010?\u001a\u00020'H\u0002J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020\u001fH\u0002J \u0010B\u001a\u00020'2\u0006\u0010C\u001a\u0002012\u0006\u0010D\u001a\u0002012\u0006\u0010E\u001a\u000201H\u0002J\u0010\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u000201H\u0002J\n\u0010H\u001a\u0004\u0018\u000101H\u0002J\b\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020'H\u0002J\b\u0010L\u001a\u00020'H\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010N\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010O\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010P\u001a\u00020'H\u0002J\u0010\u0010Q\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0002J\u001a\u0010R\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020'H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006W"}, d2 = {"Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGDeviceManagementPageBinding;", "viewModel", "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "deviceSelectorBalloon", "Lcom/larus/dora/impl/device/manage/widget/DoraGDeviceManagementSwitchPopup;", "listAdapter", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementAdapter;", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "isReconnecting", "", "unbindDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "connectFailedDialog", "Lcom/larus/dora/impl/device/manage/widget/DoraDeviceManagementConnectFailedDialog;", "updateTitleSettingsRedDotJob", "Lkotlinx/coroutines/Job;", "localReceiver", "com/larus/dora/impl/device/manage/DoraGDeviceManagementFragment$localReceiver$1", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementFragment$localReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onResume", "onAttach", "context", "Landroid/content/Context;", "onStop", "onDestroyView", "getCurrentPageName", "", "setupTitleBar", "updateTitleSettingsRedDotInMainThread", "hasBoundDevice", "setupDoraRedDotObserver", "setupDoraOtaFinishObserver", "setupList", "updateTitleBarState", "showInfo", "setupCollect", "openDynamicManagementPage", "device", "Lcom/bytedance/dora/device/DoraDevice;", "setupRefresh", "openAddDevicePage", "showDeviceSelector", "anchorView", "reportClickEvent", "cardType", "cardContentType", "action", "openHealthAgentWeb", "url", "diaryBetaDate", "currentProductId", "", "checkReadyForReconnect", "startReconnect", "handleUnbind", "showGUnbindDialog", "showNotGUnbindDialog", "dismissUnbindDialog", "unbindAndDisconnect", "showConnectFailedDialog", "fragment", "Landroidx/fragment/app/Fragment;", "dismissConnectFailedDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGDeviceManagementFragment extends DoraUnbindBaseFragment {
    public static final /* synthetic */ int q = 0;
    public LarusDoraGDeviceManagementPageBinding g;
    public final Lazy h;
    public DoraGDeviceManagementSwitchPopup i;
    public DoraGDeviceManagementAdapter j;
    public ActivityResultLauncher<Intent> k;
    public boolean l;
    public CommonDialog m;
    public DoraDeviceManagementConnectFailedDialog n;
    public Job o;
    public final DoraGDeviceManagementFragment$localReceiver$1 p;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "device_management";
    }

    public static void Z90() {
        g49.d.d("DoraGDeviceManagementFragment", "openAddDevicePage");
        com.bytedance.router.i r0 = SmartRouter.buildRoute(AppHost.a.getApplication(), "//flow/dora/device_list");
        r0.d = 0;
        r0.e = 2130772373;
        r0.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_list_v2");
        r0.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "device_management");
        r0.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        r0.d();
    }

    public final void X90() {
        CommonDialog r0 = this.m;
        if (r0 == null) goto L15;
        if (r0 != null) goto L13;
    L11:
        this.m = null;
        return;
    L13:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    }

    public final DoraGDeviceManagementViewModel Y90() {
        return (DoraGDeviceManagementViewModel) this.h.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device.manage.DoraGDeviceManagementFragment$localReceiver$1] */
    public DoraGDeviceManagementFragment() {
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGDeviceManagementViewModel.class), new DoraGDeviceManagementFragment$special$$inlined$activityViewModels$default$1(this), new DoraGDeviceManagementFragment$special$$inlined$activityViewModels$default$2(this));
        this.p = new DoraGDeviceManagementFragment$localReceiver$1(this);
    }

    public final int W90() {
        DoraDevice r0 = ((DoraGDeviceManagementViewModel.c) Y90().getUiState().getValue()).b;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.productId);
    L6:
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        r1 = Integer.valueOf(r3.getInt("product_id"));
    L9:
        if (r2 != null) goto L15;
        if (r1 != null) goto L16;
        return 16;
    L16:
        return r1.intValue();
    L15:
        return r2.intValue();
    L5:
        r2 = null;
        goto L6
    }

    public final void ca0() {
        String r0 = ((DoraGDeviceManagementViewModel.c) Y90().getUiState().getValue()).d;
        g49.d.d("DoraGDeviceManagementFragment", "startReconnect: currentDeviceMac=" + r0);
        boolean r1 = true;
        this.l = true;
        if (r0.length() > 0) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        Y90().handleConnectRequest(r0);
        return;
    L8:
        g49.d.d("DoraGDeviceManagementFragment", "startReconnect: no current device, reset UI");
        this.l = false;
        DoraGDeviceManagementAdapter r2 = this.j;
        if (r2 == null) goto L13;
        r2.z2();
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        g49.d.d("DoraGDeviceManagementFragment", "onDestroyView");
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).unregisterReceiver(this.p);
        Y90().setOnDeviceSwitchListener(null);
        Job r0 = this.o;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.o = null;
        DoraGDeviceManagementAdapter r1 = this.j;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.m.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        LifecycleUIComponent r3 = (LifecycleUIComponent) r2.next();
        if (r3.a() == false) goto L9;
        r3.onDestroy();
        goto L9
    L13:
        r1.m.clear();
        r1.n.clear();
    L14:
        this.j = null;
        DoraGDeviceManagementSwitchPopup r4 = this.i;
        if (r4 == null) goto L19;
        Balloon r5 = r4.d;
        if (r5 == null) goto L19;
        r5.h();
    L19:
        this.i = null;
        this.g = null;
    }

    public final void onResume() {
        super.onResume();
        g49.d.d("DoraGDeviceManagementFragment", "onResume, isReconnecting=" + this.l);
        if (this.l == true) goto L5;
        Y90().onPageResume();
    L5:
        ea0(((DoraGDeviceManagementViewModel.c) Y90().getUiState().getValue()).k);
        LarusDoraGDeviceManagementPageBinding r0 = this.g;
        if (r0 == null) goto L11;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L12;
        r1.post(new w(this));
        return;
    L12:
        return;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        g49.d.d("DoraGDeviceManagementFragment", "onStart");
        DoraGDeviceManagementAdapter r0 = this.j;
        if (r0 == null) goto L19;
        Iterator<T> r1 = r0.m.iterator();
    L6:
        if (r1.hasNext() == false) goto L29;
        LifecycleUIComponent r2 = (LifecycleUIComponent) r1.next();
        View r3 = r2.b;
        if (r3 == null) goto L12;
        boolean r4 = true;
        if (r3.isAttachedToWindow() != true) goto L12;
    L13:
        if (r4 == false) goto L6;
        if (r2.a() == false) goto L6;
        if (r2.m62getLifecycle().getCurrentState() != Lifecycle.State.CREATED) goto L6;
        r2.onStart();
    L12:
        r4 = false;
        goto L13
    L29:
        return;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
        g49.d.d("DoraGDeviceManagementFragment", "onStop");
        DoraGDeviceManagementAdapter r0 = this.j;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.m.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((LifecycleUIComponent) r1.next()).g();
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [com.larus.dora.impl.device.manage.u] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.dora.impl.device.manage.v] */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.dora.impl.device.manage.widget.f] */
    public final void ba0(View r11) {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        g49.d.d("DoraGDeviceManagementFragment", "showDeviceSelector: ctx == null, return");
        return;
    L6:
        List<String> r2 = ((DoraGDeviceManagementViewModel.c) Y90().getUiState().getValue()).f;
        if (r2.isEmpty() == false) goto L10;
        g49.d.d("DoraGDeviceManagementFragment", "showDeviceSelector emptyOptions");
        return;
    L10:
        g49.d.d("DoraGDeviceManagementFragment", "showDeviceSelector options=" + r2.size());
        if (this.i != null) goto L13;
        this.i = new DoraGDeviceManagementSwitchPopup(r0, new u(this), new v(this));
    L13:
        final DoraGDeviceManagementSwitchPopup r1 = this.i;
        if (r1 == null) goto L52;
        String r3 = ((DoraGDeviceManagementViewModel.c) Y90().getUiState().getValue()).c;
        Intrinsics.checkNotNullParameter(r11, "anchor");
        Intrinsics.checkNotNullParameter(r2, "devices");
        Intrinsics.checkNotNullParameter(r3, "currentDevice");
        if (r1.d != null) goto L24;
        View r4 = LayoutInflater.from(r1.a).inflate(2131562185, null);
        r1.f = r4.findViewById(2131384076);
        View r5 = r4.findViewById(2131364640);
        r1.e = new DoraGDeviceManagementSwitchPopup.DeviceListAdapter(r2, r3, new com.larus.dora.impl.device.manage.widget.f(r1));
        RecyclerView r6 = r1.f;
        if (r6 == null) goto L20;
        r6.setLayoutManager(new LinearLayoutManager(r1.a));
    L20:
        RecyclerView r7 = r1.f;
        if (r7 == null) goto L23;
        r7.setAdapter(r1.e);
    L23:
        r5.setOnClickListener(new com.larus.dora.impl.device.manage.widget.g(r1));
        Balloon.a r8 = new Balloon.a(r1.a);
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "layout");
        r8.I = r4;
        r8.f(0);
        r8.n(Integer.MIN_VALUE);
        r8.j(Integer.MIN_VALUE);
        r8.v = ContextCompat.getColor(r1.a, R.color.transparent);
        r8.g(BalloonAnimation.FADE);
        r8.W = null;
        r8.i();
        r1.d = r8.b();
    L28:
        if (r2.size() <= r1.g) goto L37;
        int r9 = r1.a.getResources().getDimensionPixelSize(v19.c.b(2130971502, r1.a, 2131167373));
        RecyclerView r10 = r1.f;
        if (r10 == null) goto L34;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L34;
        r12.height = r9 * r1.g;
    L34:
        RecyclerView r13 = r1.f;
        if (r13 == null) goto L45;
        r13.setOverScrollMode(1);
    L45:
        RecyclerView r14 = r1.f;
        if (r14 == null) goto L48;
        r14.requestLayout();
    L48:
        int r15 = r1.a.getResources().getDimensionPixelSize(v19.c.b(2130971163, r1.a, 2131166696));
        int r16 = r1.a.getResources().getDimensionPixelSize(v19.c.b(2130971367, r1.a, 2131167105));
        int r17 = r1.a.getResources().getDimensionPixelSize(v19.c.b(2130971163, r1.a, 2131166696));
        int r18 = r17 - r1.a.getResources().getDimensionPixelSize(v19.c.b(2130971517, r1.a, 2131167404));
        int[] r20 = new int[2];
        r11.getLocationInWindow(r20);
        int r21 = (r15 - r20[0]) - r17;
        int r22 = r16 - r18;
        Balloon r23 = r1.d;
        if (r23 == null) goto L53;
        r23.x(r11, r21, r22);
        return;
    L53:
        return;
    L37:
        RecyclerView r24 = r1.f;
        if (r24 == null) goto L42;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if (r25 == null) goto L42;
        r25.height = -2;
    L42:
        RecyclerView r26 = r1.f;
        if (r26 == null) goto L45;
        r26.setOverScrollMode(2);
        goto L45
    L24:
        DoraGDeviceManagementSwitchPopup.DeviceListAdapter r27 = r1.e;
        if (r27 == null) goto L28;
        Intrinsics.checkNotNullParameter(r2, "newItems");
        Intrinsics.checkNotNullParameter(r3, "newCurrent");
        r27.a = r2;
        r27.b = r3;
        r27.notifyDataSetChanged();
        goto L28
    }

    public final void da0(DoraDevice r8) {
        String r6 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraGDeviceManagementFragment$unbindAndDisconnect$1(r8, null), 3, null);
        Intent r0 = new Intent("action.DEVICE_UNBIND");
        Context r1 = getContext();
        if (r1 == null) goto L5;
        r6 = r1.getPackageName();
    L5:
        r0.setPackage(r6);
        if (TextUtils.isEmpty(r8.mac) == true) goto L8;
        r0.putExtra("mac", r8.mac);
    L8:
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r0);
    }

    public final void ea0(boolean r9) {
        Job r0 = this.o;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGDeviceManagementFragment$updateTitleSettingsRedDotInMainThread$1(r9, this, null), 3, null);
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        g49.d.d("DoraGDeviceManagementFragment", "onAttach");
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new t(this));
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.dora.impl.device.manage.l] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.dora.impl.device.manage.m] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.dora.impl.device.manage.n] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.dora.impl.device.manage.o] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.dora.impl.device.manage.p] */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.dora.impl.device.manage.q] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.larus.dora.impl.device.manage.i] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.dora.impl.device.manage.d0] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.dora.impl.device.manage.r] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.dora.impl.device.manage.c0] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.larus.dora.impl.device.manage.j] */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.larus.dora.impl.device.manage.k] */
    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment
    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        g49.d.d("DoraGDeviceManagementFragment", "onViewCreated");
        Y90().resetFirstEnterFlag();
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.p, new IntentFilter("action.DEVICE_UPDATE_DYNAMIC"));
        LarusDoraGDeviceManagementPageBinding r2 = this.g;
        if (r2 == null) goto L7;
        AppCompatImageView r3 = r2.d;
        if (r3 == null) goto L7;
        r3.setOnClickListener(new x(this));
    L7:
        LarusDoraGDeviceManagementPageBinding r4 = this.g;
        if (r4 == null) goto L12;
        AppCompatImageView r5 = r4.j;
        if (r5 == null) goto L12;
        r5.setOnClickListener(new y(this));
    L12:
        LarusDoraGDeviceManagementPageBinding r6 = this.g;
        if (r6 == null) goto L17;
        LinearLayout r7 = r6.i;
        if (r7 == null) goto L17;
        r7.setOnClickListener(new z(this));
    L17:
        Lifecycle.State r8 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGDeviceManagementFragment$setupDoraRedDotObserver$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGDeviceManagementFragment$setupDoraOtaFinishObserver$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r8, null, this), 3, null);
        final Context r9 = getContext();
        if (r9 != null) goto L20;
        g49.d.d("DoraGDeviceManagementFragment", "setupList context == null.");
        Lifecycle.State r22 = r8;
    L28:
        Lifecycle.State r10 = r22;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGDeviceManagementFragment$setupCollect$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGDeviceManagementFragment$setupCollect$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGDeviceManagementFragment$setupCollect$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r10, null, this), 3, null);
        Context r1 = getContext();
        if (r1 == null) goto L35;
        LarusDoraGDeviceManagementPageBinding r11 = this.g;
        if (r11 == null) goto L35;
        SuperSwipeRefreshLayout r12 = r11.c;
        if (r12 == null) goto L35;
        r12.setRefreshHeader(new DoraGDeviceManagementRefreshHeader(r1));
        r12.setOnRefreshListener(new h(this));
    L35:
        DoraGDeviceManagementViewModel r13 = Y90();
        Bundle r14 = getArguments();
        if (r14 == null) goto L38;
        String r15 = r14.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC);
    L39:
        r13.setInitialDeviceMac(r15);
        Y90().load();
        return;
    L38:
        r15 = null;
        goto L39
    L20:
        g49.d.d("DoraGDeviceManagementFragment", "setupList construct DoraGDeviceManagementAdapter.");
        r22 = r8;
        this.j = new DoraGDeviceManagementAdapter(new c0(this), new j(this), new k(this), new l(this, r9), new m(this, r9), new n(this, r9), new o(this, r9), new p(this, r9), new q(this), new r(r9, this), new d0(this, r9), new i(this));
        Y90().setOnDeviceSwitchListener(new k0(this));
        Y90().setOnConnectRequestListener(new l0(this));
        g49.d.d("DoraGDeviceManagementFragment", "setupList.setupRecyclerView, use GridLayoutManager spanCount=2");
        LarusDoraGDeviceManagementPageBinding r16 = this.g;
        if (r16 == null) goto L28;
        RecyclerView r17 = r16.b;
        if (r17 == null) goto L28;
        final GridLayoutManager r18 = new GridLayoutManager(r9, 2);
        final DoraGDeviceManagementAdapter r23 = this.j;
        if (r23 == null) goto L27;
        r18.setSpanSizeLookup(new DoraGDeviceManagementFragment$setupList$15$1(r23));
        r17.setLayoutManager(r18);
        r17.setAdapter(r23);
    L27:
        r17.addOnScrollListener(new DoraGDeviceManagementFragment$setupList$15$2(r18, this));
        goto L28
    }

    public final void aa0(String r1, String r2, String r3) {
        b.a("device_management", r2, r3);
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        View r16 = r13.inflate(2131562186, r14, false);
        int r17 = 2131384076;
        RecyclerView r2 = ViewBindings.findChildViewById(r16, 2131384076);
        if (r2 == null) goto L29;
        r17 = 2131384141;
        SuperSwipeRefreshLayout r3 = (SuperSwipeRefreshLayout) ViewBindings.findChildViewById(r16, 2131384141);
        if (r3 == null) goto L29;
        r17 = 2131388799;
        if (ViewBindings.findChildViewById(r16, 2131388799) == null) goto L29;
        r17 = 2131388801;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r16, 2131388801);
        if (r4 == null) goto L29;
        r17 = 2131388832;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131388832);
        if (r5 == null) goto L29;
        r17 = 2131388833;
        if (ViewBindings.findChildViewById(r16, 2131388833) == null) goto L29;
        r17 = 2131388834;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131388834);
        if (r6 == null) goto L29;
        r17 = 2131388843;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r16, 2131388843);
        if (r7 == null) goto L29;
        r17 = 2131388855;
        DoraTextView r8 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131388855);
        if (r8 == null) goto L29;
        r17 = 2131388901;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131388901);
        if (r9 == null) goto L29;
        r17 = 2131388902;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r16, 2131388902);
        if (r10 == null) goto L29;
        r17 = 2131388904;
        View r11 = ViewBindings.findChildViewById(r16, 2131388904);
        if (r11 == null) goto L29;
        LinearLayout r18 = (LinearLayout) r16;
        this.g = new LarusDoraGDeviceManagementPageBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
