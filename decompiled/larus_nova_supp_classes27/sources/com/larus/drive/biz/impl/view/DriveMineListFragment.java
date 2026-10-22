package com.larus.drive.biz.impl.view;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.larus.drive.biz.impl.viewmodel.DriveMineListViewModel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/drive/biz/impl/view/DriveMineListFragment;", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "<init>", "()V", "initTime", "", "getTagName", "", "ownViewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveMineListViewModel;", "getOwnViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/DriveMineListViewModel;", "ownViewModel$delegate", "Lkotlin/Lazy;", "setupViewModel", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMineListFragment extends AbsDriveListFragment {
    public static final /* synthetic */ int B = 0;
    public final Lazy A;
    public final long z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(q0 r2) {
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
        return "DriveMineListFragment";
    }

    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void ga0() {
        DriveMineListViewModel r0 = (DriveMineListViewModel) this.A.getValue();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
        super.ga0();
    }

    public DriveMineListFragment() {
        this.z = SystemClock.elapsedRealtime();
        final Function0<Fragment> r0 = new DriveMineListFragment$special$$inlined$viewModels$default$1(this);
        this.A = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DriveMineListViewModel.class), new DriveMineListFragment$special$$inlined$viewModels$default$2(r0), new DriveMineListFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.drive.biz.impl.view.q0] */
    @Override // com.larus.drive.biz.impl.view.AbsDriveListFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        W90().loadLocalInitialData();
        com.larus.drive.biz.impl.utils.c.b.observe(getViewLifecycleOwner(), new b(new q0(this)));
    }
}
