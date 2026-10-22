package com.larus.drive.biz.impl.view;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.databinding.LarusDriveFileListBinding;
import com.larus.drive.biz.impl.viewmodel.DriveFolderListViewModel;
import com.larus.drive.biz.impl.viewmodel.DriveMoveViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\u001a\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010 H\u0014J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010&\u001a\u00020\u0016H\u0014J\b\u0010'\u001a\u00020\u0016H\u0014J\n\u0010(\u001a\u0004\u0018\u00010 H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/drive/biz/impl/view/DriveMoveListFragment;", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "<init>", "()V", "folderViewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveFolderListViewModel;", "getFolderViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/DriveFolderListViewModel;", "folderViewModel$delegate", "Lkotlin/Lazy;", "moveViewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveMoveViewModel;", "getMoveViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/DriveMoveViewModel;", "moveViewModel$delegate", "containerIdArg", "", "folderTokenArg", "", "folderDriveTokenArg", "folderNameArg", "isDialogModeArg", "", "excludeDriveTokenArg", "getTagName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViewModel", "onViewCreated", "view", "Landroid/view/View;", "onFileClick", "file", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "itemView", "onFileLongClick", "provideIsDialogMode", "showUploadBanner", "getEmptyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMoveListFragment extends AbsDriveListFragment {
    public static final /* synthetic */ int H = 0;
    public final Lazy A;
    public int B;
    public String C;
    public String D;
    public String E;
    public boolean F;
    public String G;
    public final Lazy z;

    public static final class a {
        public static DriveMoveListFragment a(int r3, String r4, String r5, String r6, boolean r7, String r8) {
            DriveMoveListFragment r0 = new DriveMoveListFragment();
            Bundle r1 = new Bundle();
            r1.putInt("arg_container_id", r3);
            r1.putString("arg_folder_token", r4);
            r1.putString("arg_folder_drive_token", r5);
            r1.putString("arg_folder_name", r6);
            r1.putBoolean("arg_dialog_mode", r7);
            r1.putString("arg_exclude_drive_token", r8);
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final String V90() {
        return "DriveMoveListFragment";
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final boolean aa0(DriveFileItem r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "view");
        return false;
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final View T90() {
        LarusDriveFileListBinding r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void ga0() {
        DriveFolderListViewModel r0 = (DriveFolderListViewModel) this.z.getValue();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
        super.ga0();
    }

    public DriveMoveListFragment() {
        final Function0<Fragment> r0 = new DriveMoveListFragment$special$$inlined$viewModels$default$1(this);
        this.z = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DriveFolderListViewModel.class), new DriveMoveListFragment$special$$inlined$viewModels$default$2(r0), new DriveMoveListFragment$special$$inlined$viewModels$default$3(r0, this));
        this.A = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DriveMoveViewModel.class), new DriveMoveListFragment$special$$inlined$activityViewModels$default$1(this), new DriveMoveListFragment$special$$inlined$activityViewModels$default$2(this));
        this.B = -1;
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final boolean ca0() {
        return this.F;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        int r6 = r5.getInt("arg_container_id");
    L6:
        this.B = r6;
        Bundle r7 = getArguments();
        String r0 = null;
        if (r7 == null) goto L9;
        String r8 = r7.getString("arg_folder_token");
    L10:
        this.C = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L13;
        String r10 = r9.getString("arg_folder_drive_token");
    L14:
        this.D = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L17;
        String r12 = r11.getString("arg_folder_name");
    L18:
        this.E = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L21;
        boolean r14 = r13.getBoolean("arg_dialog_mode");
    L22:
        this.F = r14;
        Bundle r15 = getArguments();
        if (r15 == null) goto L25;
        r0 = r15.getString("arg_exclude_drive_token");
    L25:
        this.G = r0;
        ((DriveFolderListViewModel) this.z.getValue()).setShowOnlyFolderValue(true);
        ((DriveFolderListViewModel) this.z.getValue()).setFolder(this.C, this.E, this.D);
        ((DriveFolderListViewModel) this.z.getValue()).setExcludeDriveTokenValue(this.G);
        return;
    L21:
        r14 = false;
        goto L22
    L17:
        r12 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = -1;
        goto L6
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void Z90(DriveFileItem r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "file");
        if (r8.j == DriveFileType.FOLDER) goto L5;
        return;
    L5:
        DriveMoveListFragment r10 = a.a(this.B, r8.b, r8.c, r8.a, this.F, this.G);
        FragmentTransaction r0 = getParentFragmentManager().beginTransaction().setCustomAnimations(2130772401, 2130772399, 2130772399, 2130772412);
        int r1 = this.B;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r10, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r1) == true) goto L9;
        r0 = r0.replace(r1, r10);
    L9:
        r0.addToBackStack(r8.a).commit();
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        ba0(true);
        ((DriveMoveViewModel) this.A.getValue()).selectFolder(new i79.a(this.E, this.C, this.D));
    }
}
