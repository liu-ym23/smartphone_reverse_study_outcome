package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.noti_v3.special_contacts.viewmodel.NotificationBroadcastV3SpecialContactsViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002J\u0016\u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020+H\u0002J\f\u00101\u001a\u00020\u001a*\u00020)H\u0002J\f\u00102\u001a\u00020\u001a*\u00020)H\u0002J\f\u00103\u001a\u00020\u001a*\u00020)H\u0002J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u001aH\u0002J\u0012\u00106\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010'H\u0002J\u0010\u00107\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020'H\u0002J\u0010\u00108\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020'H\u0002J\f\u00109\u001a\u00020+*\u00020+H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsSpecialContactsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/noti_v3/special_contacts/viewmodel/NotificationBroadcastV3SpecialContactsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/special_contacts/viewmodel/NotificationBroadcastV3SpecialContactsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "page", "Lcom/larus/dora/obric/device_management/setting/earbuds/ui/DoraObricEarbudsOuiPage;", "listCard", "Landroid/widget/LinearLayout;", "emptyView", "Landroid/view/View;", "listDesc", "Landroid/widget/TextView;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildListCard", "buildSectionSupportiveText", "text", "observeContacts", "renderList", "contacts", "", "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "buildAddButtonItem", "Lcom/obric/oui/lisitem/OCardListItem;", "position", "", "buildContactCard", "contact", "resolveCardPosition", "index", "size", "applyCardStyle", "centerTitleInCard", "resetCardContainerMargins", "buildEmptyView", "setupResultListener", "showAddOrEditDialog", "showEditDeleteDialog", "showDeleteConfirmDialog", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsSpecialContactsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy f;
    public b79.d g;
    public LinearLayout h;
    public View i;
    public TextView j;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_special_contacts_settings";
    }

    public final void onDestroyView() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        b79.d r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final NotificationBroadcastV3SpecialContactsViewModel Y90() {
        return (NotificationBroadcastV3SpecialContactsViewModel) this.f.getValue();
    }

    public DoraObricEarbudsSpecialContactsFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsSpecialContactsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3SpecialContactsViewModel.class), new DoraObricEarbudsSpecialContactsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsSpecialContactsFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void W90(OCardListItem r4) {
        ViewGroup.LayoutParams r0 = r4.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r4.getCardContainer().setLayoutParams(r1);
    L9:
        r4.getContentContainer().setPadding(0, 0, X90(4), 0);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void Z90(y59.a r6) {
        int r0 = DoraObricEarbudsAddSpecialContactSheet.h;
        String r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.d();
    L6:
        if (r6 == null) goto L8;
        String r3 = r6.b();
    L9:
        if (r6 == null) goto L11;
        r1 = r6.c();
    L11:
        DoraObricEarbudsAddSpecialContactSheet r7 = new DoraObricEarbudsAddSpecialContactSheet();
        r7.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("key_contact_id", r2), TuplesKt.to("key_app_name", r3), TuplesKt.to("key_chat_name", r1)}));
        FragmentManager r4 = getChildFragmentManager();
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "DoraObricEarbudsAddSpecialContactSheet", r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r7, r5) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r7.show(r4, "DoraObricEarbudsAddSpecialContactSheet");
        return;
    L20:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        getChildFragmentManager().setFragmentResultListener("request_key_add_contact", getViewLifecycleOwner(), new g3(this));
        Lifecycle.State r9 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsSpecialContactsFragment$observeContacts$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r9, null, this), 3, null);
        Y90().syncSettings();
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Context r13 = requireContext();
        int r14 = com.larus.utils.j0.a;
        b79.d r15 = new b79.d(r13, com.larus.utils.j0.d(2131902314), new f3(this));
        this.g = r15;
        Context r16 = requireContext();
        LinearLayout r17 = new LinearLayout(r16);
        r17.setOrientation(1);
        r17.setGravity(1);
        r17.setPadding(0, X90(48), 0, 0);
        ImageView r1 = new ImageView(r16);
        r1.setImageResource(2131240523);
        r17.addView(r1, new LinearLayout.LayoutParams(X90(64), X90(64)));
        TextView r2 = new TextView(r16);
        r2.setText(getString(2131902307));
        r2.setGravity(17);
        r2.setTextColor(v19.c.a(2130972079, r16, 2131103136));
        r2.setTextSize(2, 16.0f);
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        r5.topMargin = X90(16);
        Unit r8 = Unit.INSTANCE;
        r17.addView(r2, r5);
        TextView r3 = new TextView(r16);
        r3.setText(getString(2131902308));
        r3.setGravity(17);
        r3.setTextColor(v19.c.a(2130972081, r16, 2131103143));
        r3.setTextSize(2, 13.0f);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        r18.topMargin = X90(4);
        r17.addView(r3, r18);
        r15.a(r17, 0);
        this.i = r17;
        LinearLayout r110 = new LinearLayout(requireContext());
        r110.setOrientation(1);
        r110.setClipChildren(false);
        r110.setClipToPadding(false);
        r15.a(r110, 16);
        this.h = r110;
        String r111 = getString(2131902311);
        TextView r112 = new TextView(requireContext());
        r112.setText(r111);
        r112.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r112.setTextSize(2, 12.0f);
        r112.setPadding(X90(20), 0, X90(20), 0);
        r15.a(r112, 8);
        this.j = r112;
        return r15.f;
    }
}
