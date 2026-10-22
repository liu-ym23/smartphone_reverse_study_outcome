package com.ss.android.lark.picker.base.widget.scenario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioEntriesFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "onPersonnelTypeClick", "Lkotlin/Function0;", "", "getOnPersonnelTypeClick", "()Lkotlin/jvm/functions/Function0;", "setOnPersonnelTypeClick", "(Lkotlin/jvm/functions/Function0;)V", "onPermissionGroupClick", "getOnPermissionGroupClick", "setOnPermissionGroupClick", "showPersonnelTypeEntry", "", "getShowPersonnelTypeEntry", "()Z", "setShowPersonnelTypeEntry", "(Z)V", "showPermissionGroupEntry", "getShowPermissionGroupEntry", "setShowPermissionGroupEntry", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ScenarioEntriesFragment extends BaseFragment {
    private Function0<Unit> onPermissionGroupClick;
    private Function0<Unit> onPersonnelTypeClick;
    private boolean showPermissionGroupEntry;
    private boolean showPersonnelTypeEntry;

    public ScenarioEntriesFragment() {
        this.showPersonnelTypeEntry = true;
        this.showPermissionGroupEntry = true;
    }

    public final Function0<Unit> getOnPermissionGroupClick() {
        return this.onPermissionGroupClick;
    }

    public final Function0<Unit> getOnPersonnelTypeClick() {
        return this.onPersonnelTypeClick;
    }

    public final boolean getShowPermissionGroupEntry() {
        return this.showPermissionGroupEntry;
    }

    public final boolean getShowPersonnelTypeEntry() {
        return this.showPersonnelTypeEntry;
    }

    public final void setOnPermissionGroupClick(Function0<Unit> r1) {
        this.onPermissionGroupClick = r1;
    }

    public final void setOnPersonnelTypeClick(Function0<Unit> r1) {
        this.onPersonnelTypeClick = r1;
    }

    public final void setShowPermissionGroupEntry(boolean r1) {
        this.showPermissionGroupEntry = r1;
    }

    public final void setShowPersonnelTypeEntry(boolean r1) {
        this.showPersonnelTypeEntry = r1;
    }

    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        ScenarioEntriesBinderKt.bindScenarioEntriesView(r4, this.showPersonnelTypeEntry, this.showPermissionGroupEntry, new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564216, r3, false);
    }
}
