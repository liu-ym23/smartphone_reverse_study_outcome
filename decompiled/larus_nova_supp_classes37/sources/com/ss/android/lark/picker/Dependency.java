package com.ss.android.lark.picker;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.PickerMaker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/Dependency;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/FragmentManager;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class Dependency {
    private final FragmentActivity activity;
    private final FragmentManager fragmentManager;

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public Dependency(FragmentActivity r2, FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        this.activity = r2;
        this.fragmentManager = r3;
    }
}
