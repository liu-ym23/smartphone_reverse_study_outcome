package com.larus.dora.impl.noti_v3.social_message.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3SocialMessageBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.noti_v3.social_message.dialog.NotificationBroadcastV3MessageModeBottomSheetDialogFragment;
import com.larus.dora.impl.noti_v3.social_message.model.MessageModeSheetSource;
import com.larus.dora.impl.noti_v3.social_message.viewmodel.NotificationBroadcastV3SocialMessageViewModel;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0018H\u0002J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010&\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/dora/impl/noti_v3/social_message/ui/NotificationBroadcastV3SocialMessageFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageNotiV3SocialMessageBinding;", "viewModel", "Lcom/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "currentSingleMessageMode", "", "currentGroupMessageMode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "getPageMaskView", "setupTitle", "Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "setupClicks", "()Lkotlin/Unit;", "observeSocialMessageSettings", "showModeBottomSheet", "source", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "selectedMode", "setupMessageModeResultListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3SocialMessageFragment extends DoraBaseFragment {
    public static final /* synthetic */ int j = 0;
    public LarusDoraPageNotiV3SocialMessageBinding f;
    public final Lazy g;
    public String h;
    public String i;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageModeSheetSource.values().length];
            r0[MessageModeSheetSource.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MessageModeSheetSource.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_social_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageNotiV3SocialMessageBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final NotificationBroadcastV3SocialMessageViewModel W90() {
        return (NotificationBroadcastV3SocialMessageViewModel) this.g.getValue();
    }

    public NotificationBroadcastV3SocialMessageFragment() {
        final Function0<Fragment> r0 = new NotificationBroadcastV3SocialMessageFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3SocialMessageViewModel.class), new NotificationBroadcastV3SocialMessageFragment$special$$inlined$viewModels$default$2(r0), new NotificationBroadcastV3SocialMessageFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public final void X90(MessageModeSheetSource r3, String r4) {
        if (getChildFragmentManager().findFragmentByTag("notification_broadcast_v3_message_mode_sheet") == null) goto L5;
        return;
    L5:
        int r0 = NotificationBroadcastV3MessageModeBottomSheetDialogFragment.f;
        NotificationBroadcastV3MessageModeBottomSheetDialogFragment r5 = NotificationBroadcastV3MessageModeBottomSheetDialogFragment.a.a(r3, r4);
        FragmentManager r6 = getChildFragmentManager();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, "notification_broadcast_v3_message_mode_sheet", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r5, r1) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r5.show(r6, "notification_broadcast_v3_message_mode_sheet");
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        LarusDoraPageNotiV3SocialMessageBinding r9 = this.f;
        if (r9 == null) goto L5;
        DoraNovaTitleBarEx r10 = r9.f;
        int r11 = j0.a;
        DoraNovaTitleBarEx.S5(r10, j0.d(2131902296));
        DoraNovaTitleBarEx.T5(r10, new com.larus.dora.impl.noti_v3.social_message.ui.a(this));
    L5:
        LarusDoraPageNotiV3SocialMessageBinding r12 = this.f;
        if (r12 == null) goto L8;
        e1.d(r12.d, new c(this));
        e1.d(r12.c, new d(this));
        e1.d(r12.b, new e(this));
        Unit r13 = Unit.INSTANCE;
    L8:
        getChildFragmentManager().setFragmentResultListener("request_key_message_mode_result", getViewLifecycleOwner(), new com.larus.dora.impl.noti_v3.social_message.ui.b(this));
        Lifecycle.State r14 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3SocialMessageFragment$observeSocialMessageSettings$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r14, null, this), 3, null);
        W90().syncSettings();
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562277, r9, false);
        int r12 = 2131369756;
        if (ViewBindings.findChildViewById(r11, 2131369756) == null) goto L19;
        r12 = 2131369757;
        ItemTextArrow r2 = ViewBindings.findChildViewById(r11, 2131369757);
        if (r2 == null) goto L19;
        r12 = 2131369758;
        ItemTextArrow r3 = ViewBindings.findChildViewById(r11, 2131369758);
        if (r3 == null) goto L19;
        r12 = 2131369759;
        ItemTextArrow r4 = ViewBindings.findChildViewById(r11, 2131369759);
        if (r4 == null) goto L19;
        r12 = 2131369962;
        View r5 = ViewBindings.findChildViewById(r11, 2131369962);
        if (r5 == null) goto L19;
        r12 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r11, 2131385238)) == null) goto L19;
        r12 = 2131388772;
        DoraNovaTitleBarEx r6 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r11, 2131388772);
        if (r6 == null) goto L19;
        ConstraintLayout r13 = r11;
        this.f = new LarusDoraPageNotiV3SocialMessageBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
