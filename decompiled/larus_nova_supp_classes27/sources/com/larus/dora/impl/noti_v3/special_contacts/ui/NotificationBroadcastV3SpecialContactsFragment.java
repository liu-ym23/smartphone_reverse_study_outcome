package com.larus.dora.impl.noti_v3.special_contacts.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3SpecialContactsEmptyBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.noti_v3.special_contacts.adapter.NotificationBroadcastV3SpecialContactsAdapter;
import com.larus.dora.impl.noti_v3.special_contacts.dialog.NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment;
import com.larus.dora.impl.noti_v3.special_contacts.viewmodel.NotificationBroadcastV3SpecialContactsViewModel;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0014\u0010\u0017\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010#R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/ui/NotificationBroadcastV3SpecialContactsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageNotiV3SpecialContactsEmptyBinding;", "viewModel", "Lcom/larus/dora/impl/noti_v3/special_contacts/viewmodel/NotificationBroadcastV3SpecialContactsViewModel;", "adapter", "Lcom/larus/dora/impl/noti_v3/special_contacts/adapter/NotificationBroadcastV3SpecialContactsAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initData", "setupFragmentResultListener", "showAddOrEditDialog", "contact", "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "showDeleteConfirmDialog", "showLongClickMenu", "anchor", "onDestroyView", "getCurrentPageName", "", "setupTitle", "Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "setupClicks", "()Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3SpecialContactsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageNotiV3SpecialContactsEmptyBinding f;
    public NotificationBroadcastV3SpecialContactsViewModel g;
    public NotificationBroadcastV3SpecialContactsAdapter h;

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ NotificationBroadcastV3SpecialContactsFragment a;
        public final /* synthetic */ y59.a b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            NotificationBroadcastV3SpecialContactsViewModel r0 = this.a.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            r0.deleteContact(this.b);
        }

        public b(NotificationBroadcastV3SpecialContactsFragment r1, y59.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements u {
        public c() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_special_contacts_settings";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public NotificationBroadcastV3SpecialContactsFragment() {
    }

    public final void W90(y59.a r6) {
        int r0 = NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment.g;
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
        NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment r7 = new NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment();
        Bundle r4 = new Bundle();
        r4.putString("key_contact_id", r2);
        r4.putString("key_app_name", r3);
        r4.putString("key_chat_name", r1);
        r7.setArguments(r4);
        FragmentManager r5 = getChildFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "add_special_contact", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r7, r8) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r7.show(r5, "add_special_contact");
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

    public final void X90(y59.a r6) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(r0.getString(2131902218));
        r1.g(r0.getString(2131902217));
        CommonDialog.a.f(r1, new b(this, r6), r0.getString(2131902216), false, 12);
        CommonDialog.a.e(r1, new c(), r0.getString(2131902213), 4);
        CommonDialog r7 = r1.a();
        FragmentManager r2 = getChildFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "DeleteSpecialContactDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r7, r3) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r7.show(r2, "DeleteSpecialContactDialog");
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.dora.impl.noti_v3.special_contacts.ui.c] */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.larus.dora.impl.noti_v3.special_contacts.ui.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.dora.impl.noti_v3.special_contacts.ui.d] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.dora.impl.noti_v3.special_contacts.ui.e] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusDoraPageNotiV3SpecialContactsEmptyBinding r13 = this.f;
        if (r13 == null) goto L7;
        Group r14 = r13.c;
        if (r14 == null) goto L7;
        r14.setReferencedIds(new int[]{2131376209, 2131390564, 2131390558});
    L7:
        this.g = (NotificationBroadcastV3SpecialContactsViewModel) new ViewModelProvider(this).get(NotificationBroadcastV3SpecialContactsViewModel.class);
        this.h = new NotificationBroadcastV3SpecialContactsAdapter(new com.larus.dora.impl.noti_v3.special_contacts.ui.b(this), new com.larus.dora.impl.noti_v3.special_contacts.ui.c(this), new d(this), new e(this));
        LarusDoraPageNotiV3SpecialContactsEmptyBinding r15 = this.f;
        if (r15 == null) goto L15;
        RecyclerView r16 = r15.d;
        if (r16 == null) goto L15;
        r16.setLayoutManager(new LinearLayoutManager(r16.getContext()));
        NotificationBroadcastV3SpecialContactsAdapter r0 = this.h;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L14:
        r16.setAdapter(r0);
        r16.addOnScrollListener(new NotificationBroadcastV3SpecialContactsFragment$initData$5$1(this));
    L15:
        Lifecycle.State r17 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3SpecialContactsFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r17, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3SpecialContactsFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r17, null, this), 3, null);
        LarusDoraPageNotiV3SpecialContactsEmptyBinding r18 = this.f;
        if (r18 == null) goto L18;
        DoraNovaTitleBarEx r110 = r18.e;
        int r111 = j0.a;
        DoraNovaTitleBarEx.S5(r110, j0.d(2131902314));
        DoraNovaTitleBarEx.T5(r110, new g(this));
    L18:
        LarusDoraPageNotiV3SpecialContactsEmptyBinding r112 = this.f;
        if (r112 == null) goto L21;
        e1.d(r112.b, new f(this));
        Unit r113 = Unit.INSTANCE;
    L21:
        getChildFragmentManager().setFragmentResultListener("request_key_add_contact", getViewLifecycleOwner(), new com.larus.dora.impl.noti_v3.special_contacts.ui.a(this));
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562278, r9, false);
        int r12 = 2131364638;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131364638);
        if (r2 == null) goto L21;
        r12 = 2131373955;
        Group r3 = ViewBindings.findChildViewById(r11, 2131373955);
        if (r3 == null) goto L21;
        r12 = 2131376209;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131376209)) == null) goto L21;
        r12 = 2131385013;
        RecyclerView r4 = ViewBindings.findChildViewById(r11, 2131385013);
        if (r4 == null) goto L21;
        r12 = 2131388807;
        DoraNovaTitleBarEx r5 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r11, 2131388807);
        if (r5 == null) goto L21;
        r12 = 2131390558;
        if (((DoraTextView) ViewBindings.findChildViewById(r11, 2131390558)) == null) goto L21;
        r12 = 2131390564;
        if (((DoraTextView) ViewBindings.findChildViewById(r11, 2131390564)) == null) goto L21;
        r12 = 2131390884;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r11, 2131390884);
        if (r6 == null) goto L21;
        ConstraintLayout r13 = r11;
        this.f = new LarusDoraPageNotiV3SpecialContactsEmptyBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
