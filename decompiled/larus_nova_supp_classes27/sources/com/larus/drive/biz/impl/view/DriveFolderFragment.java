package com.larus.drive.biz.impl.view;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.drive.biz.impl.databinding.LarusFragmentDriveFolderBinding;
import com.larus.drive.biz.impl.view.fileselect.DriveSelectActionType;
import com.larus.drive.biz.impl.view.fileselect.DriveSelectPanelDialog;
import com.larus.drive.biz.impl.viewmodel.DriveFolderViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020 H\u0016J\u0012\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020 H\u0016J\u0016\u0010*\u001a\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u001e\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u0002002\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u0016\u00101\u001a\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\b\u00102\u001a\u00020 H\u0002J\u0010\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/drive/biz/impl/view/DriveFolderFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/drive/biz/impl/view/fileselect/IDrivePageSelectMode;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusFragmentDriveFolderBinding;", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveFolderViewModel;", "getViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/DriveFolderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "listFragment", "Lcom/larus/drive/biz/impl/view/DriveFolderListFragment;", "eventParams", "Lorg/json/JSONObject;", "isSelectMode", "", "selectOwner", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "selectModeBackCallback", "Landroidx/activity/OnBackPressedCallback;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "setupTitleBar", "folderName", "", "enterSelectMode", "owner", "exitSelectMode", "updateSelectedFiles", "selectedFiles", "", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "onSelectPanelActionClick", "actionType", "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectActionType;", "showSelectPanelDialog", "dismissSelectPanelDialog", "showMoreActionMenu", "anchor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFolderFragment extends Fragment implements o79.g {
    public static final /* synthetic */ int k = 0;
    public LarusFragmentDriveFolderBinding d;
    public final Lazy e;
    public DriveFolderListFragment f;
    public JSONObject g;
    public boolean h;
    public AbsDriveListFragment i;
    public AnonymousClass1 j;

    public static final class a {
        public static DriveFolderFragment a(String r3, String r4, String r5, String r6) {
            DriveFolderFragment r0 = new DriveFolderFragment();
            Bundle r1 = new Bundle();
            r1.putString("arg_folder_token", r3);
            r1.putString("arg_folder_name", r4);
            r1.putString("arg_folder_drive_token", r5);
            r1.putString("arg_event_params", r6);
            r0.setArguments(r1);
            return r0;
        }
    }

    public static final class b implements q79.a {
        public final /* synthetic */ DriveFolderFragment a;

        @Override // q79.a
        public final void a() {
        }

        @Override // q79.a
        public final void refresh() {
            DriveFolderListFragment r0 = this.a.f;
            if (r0 == null) goto L6;
            AbsDriveListFragment.da0(r0, true, 1);
            return;
        }

        public b(DriveFolderFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void onDestroyView() {
        this.d = null;
        super.onDestroyView();
    }

    public final DriveFolderViewModel S90() {
        return (DriveFolderViewModel) this.e.getValue();
    }

    @Override // o79.g
    public final void j() {
        if (this.h == true) goto L5;
        return;
    L5:
        this.h = false;
        AnonymousClass1 r1 = this.j;
        if (r1 == null) goto L8;
        r1.setEnabled(false);
    L8:
        DriveSelectPanelDialog r0 = getChildFragmentManager().findFragmentByTag("DriveSelectPanelDialog");
        String r2 = null;
        if ((r0 instanceof DriveSelectPanelDialog) == false) goto L11;
        DriveSelectPanelDialog r3 = r0;
    L12:
        if (r3 != null) goto L27;
    L19:
        AbsDriveListFragment r4 = this.i;
        this.i = null;
        if (r4 == null) goto L22;
        r4.j();
    L22:
        Bundle r5 = getArguments();
        if (r5 == null) goto L25;
        r2 = r5.getString("arg_folder_name");
    L25:
        T90(r2);
        return;
    L27:
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L19;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L19
    L11:
        r3 = null;
        goto L12
    }

    public DriveFolderFragment() {
        final Function0<Fragment> r0 = new DriveFolderFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DriveFolderViewModel.class), new DriveFolderFragment$special$$inlined$viewModels$default$2(r0), new DriveFolderFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onResume() {
        super.onResume();
        S90().onResume();
    }

    @Override // o79.g
    public final void F70(List<DriveFileItem> r6) {
        Intrinsics.checkNotNullParameter(r6, "selectedFiles");
        if (r6.isEmpty() == false) goto L6;
        j();
        return;
    L6:
        FragmentManager r1 = getChildFragmentManager();
        DriveSelectPanelDialog r3 = r1.findFragmentByTag("DriveSelectPanelDialog");
        if ((r3 instanceof DriveSelectPanelDialog) == false) goto L9;
        DriveSelectPanelDialog r4 = r3;
    L10:
        if (r4 == null) goto L12;
        Intrinsics.checkNotNullParameter(r6, "selectedFiles");
        r4.f = r6;
        r4.S90();
        return;
    L12:
        DriveSelectPanelDialog r5 = new DriveSelectPanelDialog();
        r5.setArguments(new Bundle());
        Intrinsics.checkNotNullParameter(r6, "selectedFiles");
        r5.f = r6;
        r5.S90();
        if (r1.isStateSaved() == false) goto L19;
        FragmentTransaction r7 = r1.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "DriveSelectPanelDialog", 0) == true) goto L18;
        r7 = r7.add(r5, "DriveSelectPanelDialog");
    L18:
        r7.commitAllowingStateLoss();
        return;
    L19:
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, "DriveSelectPanelDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r5, r8) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        r5.show(r1, "DriveSelectPanelDialog");
        return;
    L30:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public final void T90(String r9) {
        LarusFragmentDriveFolderBinding r0 = this.d;
        if (r0 == null) goto L10;
        final NovaTitleBarEx r1 = r0.c;
        if (r1 == null) goto L11;
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        NovaTitleBarEx.Y5(r1, r9, null, null, 6);
        int r10 = com.larus.utils.m0.a;
        r1.setTitleMaxWidth(com.larus.utils.m0.b(getActivity()) - i5.B());
        NovaTitleBarEx.b6(r1, 2131241246, false, ImageView.ScaleType.CENTER_INSIDE, null, new v(this), 10);
        NovaTitleBarEx.k6(r1, 2131241255, 0.0f, null, null, new w(this), 30);
        NovaTitleBarEx.i6(r1, 2131241254, null, null, new x(this, r1), 14);
        return;
    L11:
        return;
    }

    @Override // o79.g
    public final void pg(AbsDriveListFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        this.i = r4;
        AnonymousClass1 r5 = this.j;
        if (r5 == null) goto L8;
        r5.setEnabled(true);
    L8:
        LarusFragmentDriveFolderBinding r6 = this.d;
        if (r6 == null) goto L14;
        NovaTitleBarEx r7 = r6.c;
        if (r7 == null) goto L15;
        String r0 = getString(R.string.cancel);
        View.OnClickListener r1 = new u(this);
        int r2 = NovaTitleBarEx.d;
        r7.c6(r0, null, r1);
        NovaTitleBarEx.Y5(r7, getString(2131900819), null, null, 6);
        r7.R5();
        e1.o(r7.getBinding().g);
        e1.o(r7.getBinding().h);
        return;
    L15:
        return;
    }

    @Override // o79.g
    public final void SC(DriveSelectActionType r2, List<DriveFileItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "selectedFiles");
        AbsDriveListFragment r4 = this.i;
        if (r4 == null) goto L6;
        r4.X90(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [androidx.activity.OnBackPressedCallback, com.larus.drive.biz.impl.view.DriveFolderFragment$onViewCreated$1] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        if (this.j != null) goto L5;
        ?? r12 = new AnonymousClass1(this);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), r12);
        this.j = r12;
    L5:
        Bundle r13 = getArguments();
        if (r13 == null) goto L8;
        String r14 = r13.getString("arg_folder_token");
    L9:
        Bundle r2 = getArguments();
        if (r2 == null) goto L12;
        String r3 = r2.getString("arg_folder_name");
    L13:
        Bundle r4 = getArguments();
        if (r4 == null) goto L16;
        String r5 = r4.getString("arg_folder_drive_token");
    L17:
        Bundle r6 = getArguments();
        if (r6 == null) goto L24;
        String r7 = r6.getString("arg_event_params");
        if (r7 == null) goto L24;
        JSONObject r8 = new JSONObject(r7);     // Catch: JSONException -> L23
    L25:
        this.g = r8;
        DriveFolderViewModel r9 = S90();
        JSONObject r15 = this.g;
        if (r15 == null) goto L29;
        String r16 = r15.toString();
        if (r16 == null) goto L29;
    L30:
        r9.setEventParams(new JSONObject(r16));
        S90().setCurrentFolderTokenValue(r14);
        S90().setCurrentFolderDriveTokenValue(r5);
        S90().setHostCallback(new b(this));
        T90(r3);
        if (r11 != null) goto L40;
        DriveFolderListFragment r17 = new DriveFolderListFragment();
        Bundle r18 = new Bundle();
        r18.putString("arg_folder_token", r14);
        r18.putString("arg_folder_name", r3);
        r18.putString("arg_folder_drive_token", r5);
        r17.setArguments(r18);
        this.f = r17;
        FragmentTransaction r110 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r17, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131377283) == true) goto L36;
        r110.replace(2131377283, r17);
    L36:
        r110.commit();
        return;
    L40:
        return;
    L29:
        r16 = new JSONObject().toString();
    L24:
        r8 = null;
        goto L25
    L16:
        r5 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L8:
        r14 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562382, r3, false);
        int r6 = 2131377283;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131377283);
        if (r7 == null) goto L9;
        r6 = 2131377284;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r5, 2131377284);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.d = new LarusFragmentDriveFolderBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
