package com.larus.drive.biz.impl.view;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.databinding.LarusDriveFileListBinding;
import com.larus.drive.biz.impl.viewmodel.DriveFolderListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/larus/drive/biz/impl/view/DriveFolderListFragment;", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "<init>", "()V", "initTime", "", "ownViewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveFolderListViewModel;", "getOwnViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/DriveFolderListViewModel;", "ownViewModel$delegate", "Lkotlin/Lazy;", "getTagName", "", "setupViewModel", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onFileClick", "file", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "itemView", "setupUploadBanner", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFolderListFragment extends AbsDriveListFragment {
    public static final /* synthetic */ int B = 0;
    public final Lazy A;
    public final long z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final String V90() {
        return "DriveFolderFragment";
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void ga0() {
        DriveFolderListViewModel r0 = (DriveFolderListViewModel) this.A.getValue();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
        Bundle r1 = getArguments();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getString("arg_folder_token");
    L6:
        Bundle r4 = getArguments();
        if (r4 == null) goto L9;
        String r5 = r4.getString("arg_folder_name");
    L10:
        Bundle r6 = getArguments();
        if (r6 == null) goto L13;
        r2 = r6.getString("arg_folder_drive_token");
    L13:
        ((DriveFolderListViewModel) this.A.getValue()).setFolder(r3, r5, r2);
        super.ga0();
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public DriveFolderListFragment() {
        this.z = SystemClock.elapsedRealtime();
        final Function0<Fragment> r0 = new DriveFolderListFragment$special$$inlined$viewModels$default$1(this);
        this.A = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DriveFolderListViewModel.class), new DriveFolderListFragment$special$$inlined$viewModels$default$2(r0), new DriveFolderListFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void fa0() {
        super.fa0();
        com.larus.drive.biz.impl.file.t.f.observe(getViewLifecycleOwner(), new b(new a0(this)));
        LarusDriveFileListBinding r0 = this.d;
        if (r0 == null) goto L7;
        ImageView r1 = r0.g;
        if (r1 == null) goto L7;
        r1.setOnClickListener(new b0());
    L7:
        LarusDriveFileListBinding r2 = this.d;
        if (r2 == null) goto L13;
        CardView r3 = r2.f;
        if (r3 == null) goto L14;
        r3.setOnClickListener(new c0(this));
        return;
    L14:
        return;
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void Z90(DriveFileItem r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "file");
        if (this.r == false) goto L7;
        super.Z90(r6, r7);
        return;
    L7:
        if (r6.j == DriveFileType.FOLDER) goto L10;
        super.Z90(r6, r7);
        return;
    L10:
        int r8 = DriveFolderFragment.k;
        DriveFolderFragment r9 = DriveFolderFragment.a.a(r6.b, r6.a, r6.c, null);
        FragmentTransaction r0 = requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(2130772401, 2130772399, 2130772399, 2130772412);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131377285) == true) goto L14;
        r0 = r0.replace(2131377285, r9);
    L14:
        r0.addToBackStack(r6.a).commit();
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ba0(true);
        com.larus.drive.biz.impl.utils.c.b.observe(getViewLifecycleOwner(), new b(new z(this)));
    }
}
