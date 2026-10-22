package com.larus.dora.impl.noti_v3.overview.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel;
import com.larus.dora.impl.noti_v3.social_message.dialog.NotificationBroadcastV3MessageModeBottomSheetDialogFragment;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.view.DoraItemTextArrowSubTitle;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020\u001aH\u0016J\b\u0010-\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020*H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0002J\u000f\u00102\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u001aH\u0002J\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\b\u00108\u001a\u00020\u001aH\u0002J\u0017\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010;J\u0017\u0010<\u001a\u0004\u0018\u00010\u001a2\u0006\u0010=\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010;J\u001f\u0010>\u001a\u0004\u0018\u00010\u001a2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0007H\u0002J\b\u0010B\u001a\u00020\u001aH\u0002J\b\u0010C\u001a\u00020\u001aH\u0002J\b\u0010D\u001a\u00020\u001aH\u0002J\u0018\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0002J\u0018\u0010H\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020\u001aH\u0002J\u0010\u0010J\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0016\u0010K\u001a\u00020\u001a2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001a0MH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/larus/dora/impl/noti_v3/overview/ui/NotificationBroadcastV3Fragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageNotiV3Binding;", "firstResume", "", "viewModel", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mainHandle", "Landroid/os/Handler;", "settings", "Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "getSettings", "()Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "settings$delegate", "headControlLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "observeFragmentResult", "handleConflictSelected", "mode", "", "handleRhythmSelected", "onResume", "onDestroyView", "getCurrentPageName", "getPageMaskView", "setupTitle", "Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "setupActions", "()Lkotlin/Unit;", "openInvalidHelpPage", "observeNotificationState", "observeNotificationPrivacyState", "observeWearingRemindState", "observeUiState", "updateNotificationSectionState", "enabled", "(Z)Lkotlin/Unit;", "updateMoreGroupBackground", "showWearingRemind", "updateMoreSectionState", "showInvalidHelp", "(ZZ)Lkotlin/Unit;", "handleNotificationSwitchClick", "showNotificationPrivacyDialog", "checkPermissionAndEnableNotification", "checkPermissionOnFirstResume", "checkPermissionOnOther", "isProactiveNotificationEnabled", "isProactiveChatEnabled", "checkPermissionOnHonor", "updateHeadGestureControl", "updateHeadGestureControlState", "showHeadControlDisableDialog", "onConfirm", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3Fragment extends DoraBaseFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraPageNotiV3Binding f;
    public boolean g;
    public final Lazy h;
    public final Handler i;
    public final Lazy j;
    public final ActivityResultLauncher<Intent> k;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.overview.ui.NotificationBroadcastV3Fragment$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.noti_v3.overview.ui.NotificationBroadcastV3Fragment$onAttach$1", f = "NotificationBroadcastV3Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            DoraUserSettingsManager.a.h("enterNotificationBroadcastV3");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageNotiV3Binding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.v;
    }

    public final void X90() {
        if (DoraAVLinkDelegate.b.y() == false) goto L5;
        List r0 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
    L6:
        int r1 = p59.b.a;
        p59.b.c(this, r0, CategoryWhenNotGranted.INTERRUPT, new g(this));
        return;
    L5:
        r0 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
        goto L6
    }

    public final NotificationBroadcastV3ViewModel Y90() {
        return (NotificationBroadcastV3ViewModel) this.h.getValue();
    }

    public NotificationBroadcastV3Fragment() {
        this.g = true;
        final Function0<Fragment> r0 = new NotificationBroadcastV3Fragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3ViewModel.class), new NotificationBroadcastV3Fragment$special$$inlined$viewModels$default$2(r0), new NotificationBroadcastV3Fragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = new Handler(Looper.getMainLooper());
        this.j = LazyKt.lazy(new m());
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new n(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public final void onResume() {
        super.onResume();
        if (this.g == false) goto L29;
        this.g = false;
        if (((DoraPushSummaryConfig) this.j.getValue()).getNotificationSummary() == true) goto L7;
    L9:
        final boolean r1 = false;
    L11:
        if (((DoraPushSummaryConfig) this.j.getValue()).getProactiveMessage() == true) goto L13;
    L15:
        final boolean r3 = false;
    L17:
        if (r3 == true) goto L21;
        if (r1 == true) goto L21;
        g49.d.d("NotificationBroadcastV3Fragment", "checkPermissionOnFirstResume: notification and proactive chat are both disabled");
    L21:
        if (DoraAVLinkDelegate.b.y() == false) goto L23;
        this.i.postDelayed(new u(this, r1, r3), 50);
        goto L29
    L23:
        g49.d.d("NotificationBroadcastV3Fragment", "checkPermissionOnOther: isProactiveNotificationEnabled=" + r1 + ", isProactiveChatEnabled=" + r3);
        if (r3 == true) goto L26;
        List r0 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
    L27:
        int r2 = p59.b.a;
        p59.b.c(this, r0, CategoryWhenNotGranted.NEXT, new com.larus.dora.impl.noti_v3.overview.ui.a(r3, r1));
        goto L29
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
    L29:
        if (((DoraPushSummaryConfig) this.j.getValue()).getNotificationSummary() == false) goto L32;
        Y90().syncSettings();
        return;
    }

    public final void Z90(boolean r2) {
        LarusDoraPageNotiV3Binding r0 = this.f;
        if (r0 == null) goto L9;
        DoraItemTextToggleSubTitle r1 = r0.h;
        if (r1 == null) goto L9;
        CustomSwitchCompat r3 = r1.getToggleView();
        if (r3 == null) goto L9;
        r3.setChecked(r2);
    L9:
        com.larus.dora.impl.util.b0.a.getClass();
        com.larus.dora.impl.util.b0.K(r2);
    }

    public final Unit aa0(boolean r2) {
        if (this.f != null) goto L7;
        return null;
    L7:
        return ba0(r2, ((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue());
    }

    public final void onAttach(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r8);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public static void W90(NotificationBroadcastV3MessageModeBottomSheetDialogFragment r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "NotificationBroadcastV3MessageModeBottomSheetDialogFragment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "NotificationBroadcastV3MessageModeBottomSheetDialogFragment");
    }

    public final Unit ba0(boolean r3, boolean r4) {
        LarusDoraPageNotiV3Binding r0 = this.f;
        if (r0 == null) goto L19;
        if (r3 == true) goto L8;
        if (r4 == true) goto L8;
        boolean r1 = false;
    L9:
        if (r3 == false) goto L11;
        e1.x(r0.u);
    L12:
        if (r4 == false) goto L14;
        e1.x(r0.j);
    L15:
        if (r1 == false) goto L17;
        e1.x(r0.l);
        e1.x(r0.m);
    L18:
        r0.l.c();
        return Unit.INSTANCE;
    L17:
        e1.o(r0.l);
        e1.o(r0.m);
        goto L18
    L14:
        e1.o(r0.j);
        goto L15
    L11:
        e1.o(r0.u);
    L8:
        r1 = true;
        goto L9
    L19:
        return null;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraPageNotiV3Binding r10 = this.f;
        if (r10 == null) goto L5;
        DoraNovaTitleBarEx r11 = r10.w;
        int r12 = j0.a;
        DoraNovaTitleBarEx.S5(r11, j0.d(2131904110));
        DoraNovaTitleBarEx.T5(r11, new o(this));
    L5:
        final LarusDoraPageNotiV3Binding r13 = this.f;
        boolean r14 = true;
        if (r13 == null) goto L8;
        UrlSpanTextView r0 = r13.q;
        StringBuilder r1 = new StringBuilder();
        int r2 = j0.a;
        r1.append(j0.d(2131902182));
        r1.append(' ');
        r0.setUrlSpannedText(r1.toString());
        r13.q.setOnClickListener(new z(r13));
        r13.p.getToggleView().a = true;
        e1.d(r13.p, new p(this));
        e1.d(r13.t, new q(this));
        e1.d(r13.r, new r(this));
        e1.d(r13.o, new s(this));
        e1.d(r13.s, new t(this));
        e1.d(r13.n, new b(this));
        e1.d(r13.g, new c(this));
        r13.u.getToggleView().a = true;
        e1.d(r13.u, new d(r13));
        e1.d(r13.i, new e(this));
        Unit r15 = Unit.INSTANCE;
    L8:
        IObricDoraService r16 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r16 != null) goto L11;
    L13:
        r14 = false;
    L15:
        if (r14 == false) goto L22;
        LarusDoraPageNotiV3Binding r17 = this.f;
        if (r17 == null) goto L21;
        ItemTextView r18 = r17.u;
        if (r18 == null) goto L21;
        e1.o(r18);
    L21:
        aa0(false);
    L24:
        if (((DoraPushSummaryConfig) this.j.getValue()).getNotificationSummary() == false) goto L26;
        Lifecycle.State r20 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeNotificationState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r20, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeNotificationPrivacyState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r20, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r20, null, this), 3, null);
        getParentFragmentManager().setFragmentResultListener("request_key_message_mode_result", getViewLifecycleOwner(), new h(this));
        Y90().syncSettings();
        return;
    L26:
        LarusDoraPageNotiV3Binding r21 = this.f;
        if (r21 == null) goto L34;
        e1.o(r21.k);
        e1.o(r21.f);
        e1.o(r21.e);
        e1.o(r21.b);
        e1.o(r21.d);
        e1.o(r21.c);
        AppCompatTextView r22 = r21.m;
        ViewGroup.LayoutParams r3 = r22.getLayoutParams();
        if (r3 == null) goto L32;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        int r5 = j0.a;
        r4.topMargin = j0.b(v19.c.b(2130971163, null, 2131166696));
        r22.setLayoutParams(r4);
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        return;
    L22:
        Lifecycle.State r23 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeWearingRemindState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r23, null, this), 3, null);
        goto L24
    L11:
        if (r16.t() != true) goto L13;
        goto L13
    }

    public final View onCreateView(LayoutInflater r28, ViewGroup r210, Bundle r30) {
        Intrinsics.checkNotNullParameter(r28, "inflater");
        ConstraintLayout r0 = r28.inflate(2131562275, r210, false);
        int r1 = 2131369712;
        ItemGroup r5 = ViewBindings.findChildViewById(r0, 2131369712);
        if (r5 == null) goto L51;
        r1 = 2131369713;
        ItemGroup r6 = ViewBindings.findChildViewById(r0, 2131369713);
        if (r6 == null) goto L51;
        r1 = 2131369714;
        DoraTextView r7 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369714);
        if (r7 == null) goto L51;
        r1 = 2131369715;
        ItemGroup r8 = ViewBindings.findChildViewById(r0, 2131369715);
        if (r8 == null) goto L51;
        r1 = 2131369716;
        DoraTextView r9 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369716);
        if (r9 == null) goto L51;
        r1 = 2131369717;
        ItemTextArrow r10 = ViewBindings.findChildViewById(r0, 2131369717);
        if (r10 == null) goto L51;
        r1 = 2131369718;
        DoraItemTextToggleSubTitle r11 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r0, 2131369718);
        if (r11 == null) goto L51;
        r1 = 2131369719;
        DoraItemTextArrowSubTitle r12 = (DoraItemTextArrowSubTitle) ViewBindings.findChildViewById(r0, 2131369719);
        if (r12 == null) goto L51;
        r1 = 2131369720;
        ItemGroup r13 = ViewBindings.findChildViewById(r0, 2131369720);
        if (r13 == null) goto L51;
        r1 = 2131369721;
        ItemGroup r14 = ViewBindings.findChildViewById(r0, 2131369721);
        if (r14 == null) goto L51;
        r1 = 2131369739;
        ItemGroup r15 = ViewBindings.findChildViewById(r0, 2131369739);
        if (r15 == null) goto L51;
        r1 = 2131369740;
        DoraTextView r16 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369740);
        if (r16 == null) goto L51;
        r1 = 2131369741;
        ItemTextArrow r17 = ViewBindings.findChildViewById(r0, 2131369741);
        if (r17 == null) goto L51;
        r1 = 2131369742;
        ItemTextArrow r18 = ViewBindings.findChildViewById(r0, 2131369742);
        if (r18 == null) goto L51;
        r1 = 2131369743;
        ItemTextToggle r110 = ViewBindings.findChildViewById(r0, 2131369743);
        if (r110 == null) goto L51;
        r1 = 2131369744;
        UrlSpanTextView r20 = (UrlSpanTextView) ViewBindings.findChildViewById(r0, 2131369744);
        if (r20 == null) goto L51;
        r1 = 2131369745;
        ItemTextArrow r21 = ViewBindings.findChildViewById(r0, 2131369745);
        if (r21 == null) goto L51;
        r1 = 2131369752;
        ItemTextArrow r22 = ViewBindings.findChildViewById(r0, 2131369752);
        if (r22 == null) goto L51;
        r1 = 2131369755;
        ItemTextArrow r23 = ViewBindings.findChildViewById(r0, 2131369755);
        if (r23 == null) goto L51;
        r1 = 2131369760;
        DoraItemTextToggleSubTitle r24 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r0, 2131369760);
        if (r24 == null) goto L51;
        r1 = 2131369962;
        View r25 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r25 == null) goto L51;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L51;
        r1 = 2131388772;
        DoraNovaTitleBarEx r26 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r0, 2131388772);
        if (r26 == null) goto L51;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageNotiV3Binding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26);
        return r2;
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
