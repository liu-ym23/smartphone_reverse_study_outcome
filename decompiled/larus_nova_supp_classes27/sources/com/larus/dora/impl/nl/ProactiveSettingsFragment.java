package com.larus.dora.impl.nl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.e1;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\u0018\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0002J\u0018\u00103\u001a\u00020$2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020$H\u0002J\u0017\u00105\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u0007H\u0002¢\u0006\u0002\u00107J\u0017\u00108\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u0007H\u0002¢\u0006\u0002\u00107J\u0017\u00109\u001a\u0004\u0018\u00010$2\u0006\u0010:\u001a\u00020;H\u0002¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020$H\u0002J\u0010\u0010?\u001a\u00020$2\u0006\u00106\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020$2\u0006\u00106\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020$H\u0002J\b\u0010C\u001a\u00020$H\u0002J\u0010\u0010D\u001a\u00020$2\u0006\u00106\u001a\u00020\u0007H\u0002J\u0016\u0010E\u001a\u00020$2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020$0GH\u0002J\b\u0010H\u001a\u00020$H\u0002J\u0010\u0010I\u001a\u00020$2\u0006\u00106\u001a\u00020\u0007H\u0002J\u0017\u0010J\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u0007H\u0002¢\u0006\u0002\u00107J\u0017\u0010K\u001a\u0004\u0018\u00010\u00072\u0006\u0010L\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010MJ\u0017\u0010N\u001a\u0004\u0018\u00010$2\u0006\u0010:\u001a\u00020;H\u0002¢\u0006\u0002\u0010<R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/larus/dora/impl/nl/ProactiveSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageProactiveBinding;", "firstResume", "", "settings", "Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "getSettings", "()Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "settings$delegate", "Lkotlin/Lazy;", "mainHandle", "Landroid/os/Handler;", "viewModel", "Lcom/larus/dora/impl/nl/ProactiveSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/ProactiveSettingsViewModel;", "viewModel$delegate", "headControlLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getCurrentPageName", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onAttach", "context", "Landroid/content/Context;", "onResume", "onDestroyView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupBackCallback", "handleBack", "checkPermissionOnFirstResume", "checkPermissionOnOther", "isProactiveNotificationEnabled", "isProactiveChatEnabled", "checkPermissionOnHonor", "setupProactiveNotification", "updateProactivePriorityState", "enabled", "(Z)Lkotlin/Unit;", "updateProactiveNotificationState", "updateProactiveNotificationFreq", "freq", "", "(I)Lkotlin/Unit;", "showProactiveNotificationPrivacyDialog", "checkPermissionAndEnableNotification", "handleProactiveNotificationSwitchClick", "handleProactiveNotificationPriorityClick", "setupProactiveChat", "setupWearingRemind", "updateHeadGestureControl", "updateHeadGestureControlState", "showHeadControlDisableDialog", "onConfirm", "Lkotlin/Function0;", "checkPermissionAndEnableProactiveChat", "handleProactiveChatSwitchClick", "updateProactiveChatState", "updateProactiveChatMethodState", "method", "(Ljava/lang/String;)Ljava/lang/Boolean;", "updateProactiveChatFreq", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraPageProactiveBinding f;
    public boolean g;
    public final Lazy h;
    public final Handler i;
    public final Lazy j;
    public final ActivityResultLauncher<Intent> k;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.ProactiveSettingsFragment$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.ProactiveSettingsFragment$onAttach$1", f = "ProactiveSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            DoraUserSettingsManager.a.h("enterProactiveSetting");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final String k() {
        return "proactive_notice";
    }

    public final void W90() {
        if (DoraAVLinkDelegate.b.y() == false) goto L5;
        List r0 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
    L6:
        g49.d.d("ProactiveSettingsFragment", "checkPermissionAndEnableNotification: start " + r0);
        int r1 = p59.b.a;
        p59.b.c(this, r0, CategoryWhenNotGranted.INTERRUPT, new k0());
        return;
    L5:
        r0 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
        goto L6
    }

    public ProactiveSettingsFragment() {
        this.g = true;
        this.h = LazyKt.lazy(new x());
        this.i = new Handler(Looper.getMainLooper());
        final Function0<Fragment> r0 = new ProactiveSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProactiveSettingsViewModel.class), new ProactiveSettingsFragment$special$$inlined$viewModels$default$2(r0), new ProactiveSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new y(this));
    }

    public final void X90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        boolean r1 = r0.getBoolean("from_onboarding");
    L6:
        if (r1 == false) goto L15;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L12;
        com.larus.home.impl.sdk.s r3 = r2.s0();
        if (r3 == null) goto L12;
        r3.N(this);
    L12:
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L19;
        r4.finish();
        return;
    L19:
        return;
    L15:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L21;
        r5.finish();
        return;
    L21:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        LarusDoraPageProactiveBinding r0 = this.f;
        if (r0 == null) goto L8;
        DoraMovieView r1 = r0.r;
        if (r1 == null) goto L9;
        r1.g();
        r1.f();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super.onResume();
        if (this.g == false) goto L29;
        this.g = false;
        if (((DoraPushSummaryConfig) this.h.getValue()).getNotificationSummary() == true) goto L7;
    L9:
        final boolean r1 = false;
    L11:
        if (((DoraPushSummaryConfig) this.h.getValue()).getProactiveMessage() == true) goto L13;
    L15:
        final boolean r3 = false;
    L17:
        if (r3 == true) goto L21;
        if (r1 == true) goto L21;
        g49.d.d("ProactiveSettingsFragment", "checkPermissionOnFirstResume: notification and proactive chat are both disabled");
        return;
    L21:
        if (DoraAVLinkDelegate.b.y() == false) goto L23;
        this.i.postDelayed(new l0(this, r1, r3), 50);
        return;
    L23:
        g49.d.d("ProactiveSettingsFragment", "checkPermissionOnOther: isProactiveNotificationEnabled=" + r1 + ", isProactiveChatEnabled=" + r3);
        if (r3 == true) goto L26;
        List r0 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
    L27:
        int r2 = p59.b.a;
        p59.b.c(this, r0, CategoryWhenNotGranted.NEXT, new w(r3, r1));
        return;
    L26:
        r0 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
        goto L27
    L13:
        if (((Boolean) DoraUserSettingsManager.o.getValue()).booleanValue() == false) goto L15;
        r3 = true;
        goto L17
    L7:
        if (((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue() == false) goto L9;
        r1 = true;
        goto L11
    }

    public final void Y90(boolean r5) {
        LarusDoraPageProactiveBinding r0 = this.f;
        if (r0 == null) goto L9;
        DoraItemTextToggleSubTitle r1 = r0.d;
        if (r1 == null) goto L9;
        CustomSwitchCompat r2 = r1.getToggleView();
        if (r2 == null) goto L9;
        r2.setChecked(r5);
    L9:
        com.larus.dora.impl.util.b0.a.getClass();
        com.larus.dora.impl.util.b0.K(r5);
        DoraBuryPointManager r3 = DoraBuryPointManager.a;
        r3.getClass();
        g49.d.d(DoraBuryPointManager.b, "reportHeadActionSwitch: state=" + r5);
        if (r5 == false) goto L12;
        String r4 = "on";
    L13:
        r3.L("dm_broadcast_head_action_switch", MapsKt.mapOf(TuplesKt.to("switch_status", r4)));
        g49.d.d("ProactiveSettingsFragment", "updateHeadGestureControlState: enabled=" + r5);
        return;
    L12:
        r4 = "off";
        goto L13
    }

    public final void onAttach(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r8);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void onViewCreated(View r110, Bundle r20) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r110, r20);
        LarusDoraPageProactiveBinding r1 = this.f;
        if (r1 == null) goto L5;
        NovaTitleBarEx r3 = r1.x;
        NovaTitleBarEx.Y5(r3, getString(2131904110), null, null, 6);
        NovaTitleBarEx.b6(r3, 2131240517, false, null, null, new i0(this), 14);
    L5:
        Bundle r2 = getArguments();
        boolean r4 = false;
        if (r2 == null) goto L8;
        boolean r5 = r2.getBoolean("from_onboarding");
    L9:
        if (r5 == false) goto L16;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L16;
        OnBackPressedDispatcher r7 = r6.getOnBackPressedDispatcher();
        if (r7 == null) goto L16;
        r7.addCallback(getViewLifecycleOwner(), new ProactiveSettingsFragment$setupBackCallback$1(this));
    L16:
        if (((DoraPushSummaryConfig) this.h.getValue()).getNotificationSummary() == false) goto L21;
        LarusDoraPageProactiveBinding r8 = this.f;
        if (r8 == null) goto L20;
        UrlSpanTextView r9 = r8.m;
        StringBuilder r10 = new StringBuilder();
        int r11 = com.larus.utils.j0.a;
        r10.append(com.larus.utils.j0.d(2131902182));
        r10.append(' ');
        r9.setUrlSpannedText(r10.toString());
        r8.m.setOnClickListener(new q0(r8));
        r8.l.getToggleView().a = true;
        e1.d(r8.l, new q(this));
        r8.k.getToggleView().a = true;
        e1.d(r8.k, new r(this));
        e1.d(r8.i, new s(this));
        e1.d(r8.h, new t(this));
        e1.d(r8.b, new u(this));
    L20:
        Lifecycle.State r12 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupProactiveNotification$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupProactiveNotification$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r12, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupProactiveNotification$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r12, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupProactiveNotification$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r12, null, this), 3, null);
    L25:
        if (((DoraPushSummaryConfig) this.h.getValue()).getProactiveMessage() == false) goto L30;
        final LarusDoraPageProactiveBinding r13 = this.f;
        if (r13 == null) goto L29;
        r13.g.getToggleView().a = true;
        e1.d(r13.g, new p(this));
        r13.p.setEnabled(true);
        e1.d(r13.p, new a0());
        r13.s.setEnabled(true);
        e1.d(r13.s, new d0());
        r13.w.setOnSeekBarChangeListener(new m0());
        final DoraMovieView r14 = r13.r;
        r14.setLooping(Boolean.TRUE);
        r14.setPauseInFirst(true);
        r14.setMediaPlayerStartListener(new e0(r13));
        e1.d(r14, new f0(r14, r13));
    L29:
        Lifecycle.State r15 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupProactiveChat$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupProactiveChat$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupProactiveChat$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r15, null, this), 3, null);
    L35:
        IObricDoraService r16 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r16 != null) goto L38;
    L40:
        if (r4 == false) goto L44;
        LarusDoraPageProactiveBinding r17 = this.f;
        if (r17 == null) goto L48;
        e1.o(r17.u);
        e1.o(r17.v);
        return;
    L48:
        return;
    L44:
        final LarusDoraPageProactiveBinding r18 = this.f;
        if (r18 == null) goto L50;
        r18.t.getToggleView().a = true;
        e1.d(r18.t, new j0(r18));
        Lifecycle.State r21 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ProactiveSettingsFragment$setupWearingRemind$lambda$39$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r21, null, r18), 3, null);
        return;
    L50:
        return;
    L38:
        if (r16.t() != true) goto L40;
        r4 = true;
        goto L40
    L30:
        LarusDoraPageProactiveBinding r22 = this.f;
        if (r22 == null) goto L35;
        ItemGroup r23 = r22.f;
        if (r23 == null) goto L35;
        e1.o(r23);
        goto L35
    L21:
        LarusDoraPageProactiveBinding r24 = this.f;
        if (r24 == null) goto L25;
        e1.o(r24.j);
        e1.o(r24.m);
        goto L25
    L8:
        r5 = false;
        goto L9
    }

    public final View onCreateView(LayoutInflater r210, ViewGroup r30, Bundle r31) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        ConstraintLayout r0 = r210.inflate(2131562287, r30, false);
        int r1 = 2131369448;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r0, 2131369448);
        if (r5 == null) goto L53;
        r1 = 2131369449;
        ItemGroup r6 = ViewBindings.findChildViewById(r0, 2131369449);
        if (r6 == null) goto L53;
        r1 = 2131369634;
        DoraItemTextToggleSubTitle r7 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r0, 2131369634);
        if (r7 == null) goto L53;
        r1 = 2131369962;
        View r8 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r8 == null) goto L53;
        r1 = 2131369970;
        ItemGroup r9 = ViewBindings.findChildViewById(r0, 2131369970);
        if (r9 == null) goto L53;
        r1 = 2131369971;
        DoraItemTextToggleSubTitle r10 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r0, 2131369971);
        if (r10 == null) goto L53;
        r1 = 2131369973;
        ItemTextArrow r11 = ViewBindings.findChildViewById(r0, 2131369973);
        if (r11 == null) goto L53;
        r1 = 2131369974;
        ItemTextArrow r12 = ViewBindings.findChildViewById(r0, 2131369974);
        if (r12 == null) goto L53;
        r1 = 2131369975;
        ItemGroup r13 = ViewBindings.findChildViewById(r0, 2131369975);
        if (r13 == null) goto L53;
        r1 = 2131369976;
        DoraItemTextToggleSubTitle r14 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r0, 2131369976);
        if (r14 == null) goto L53;
        r1 = 2131369977;
        DoraItemTextToggleSubTitle r15 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r0, 2131369977);
        if (r15 == null) goto L53;
        r1 = 2131369978;
        UrlSpanTextView r16 = (UrlSpanTextView) ViewBindings.findChildViewById(r0, 2131369978);
        if (r16 == null) goto L53;
        r1 = 2131369980;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131369980);
        if (r17 == null) goto L53;
        r1 = 2131369981;
        ItemGroup r18 = ViewBindings.findChildViewById(r0, 2131369981);
        if (r18 == null) goto L53;
        r1 = 2131369982;
        ItemTextSelector r110 = ViewBindings.findChildViewById(r0, 2131369982);
        if (r110 == null) goto L53;
        r1 = 2131369983;
        ImageView r20 = (ImageView) ViewBindings.findChildViewById(r0, 2131369983);
        if (r20 == null) goto L53;
        r1 = 2131369984;
        DoraMovieView r21 = (DoraMovieView) ViewBindings.findChildViewById(r0, 2131369984);
        if (r21 == null) goto L53;
        r1 = 2131369985;
        ItemTextSelector r22 = ViewBindings.findChildViewById(r0, 2131369985);
        if (r22 == null) goto L53;
        r1 = 2131370047;
        ItemTextToggle r23 = ViewBindings.findChildViewById(r0, 2131370047);
        if (r23 == null) goto L53;
        r1 = 2131370048;
        ItemGroup r24 = ViewBindings.findChildViewById(r0, 2131370048);
        if (r24 == null) goto L53;
        r1 = 2131370049;
        DoraTextView r25 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131370049);
        if (r25 == null) goto L53;
        r1 = 2131383088;
        SeekBar r26 = (SeekBar) ViewBindings.findChildViewById(r0, 2131383088);
        if (r26 == null) goto L53;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L53;
        r1 = 2131388772;
        NovaTitleBarEx r27 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r27 == null) goto L53;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageProactiveBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27);
        return r2;
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
