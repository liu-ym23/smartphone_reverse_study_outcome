package com.ss.android.lark.picker.base.widget.scenario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchPermissionGroupInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0006\u0010%\u001a\u00020\"J\u0014\u0010&\u001a\u00020\"2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010(\u001a\u00020\"H\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/scenario/PermissionGroupListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "items", "", "Lcom/ss/android/lark/search/dto/info/SearchPermissionGroupInfo;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "selectionDelegate", "Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioSelectionDelegate;", "getSelectionDelegate", "()Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioSelectionDelegate;", "setSelectionDelegate", "(Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioSelectionDelegate;)V", "adapter", "Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioListAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emptyHintView", "Landroid/widget/TextView;", "hasSubmittedItems", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "refreshSelectedState", "submitItems", "newItems", "updateEmptyState", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PermissionGroupListFragment extends BaseFragment {
    private ScenarioListAdapter<SearchPermissionGroupInfo> adapter;
    private TextView emptyHintView;
    private boolean hasSubmittedItems;
    private List<SearchPermissionGroupInfo> items;
    private RecyclerView recyclerView;
    private ScenarioSelectionDelegate selectionDelegate;

    private final void updateEmptyState() {
        int r1 = 0;
        if (this.hasSubmittedItems == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        RecyclerView r2 = this.recyclerView;
        if (r2 == null) goto L14;
        if (r0 == false) goto L12;
        int r4 = 8;
    L13:
        r2.setVisibility(r4);
        goto L14
    L12:
        r4 = 0;
    L14:
        TextView r3 = this.emptyHintView;
        if (r3 == null) goto L21;
        if (r0 == true) goto L19;
        r1 = 8;
    L19:
        r3.setVisibility(r1);
        return;
    L21:
        return;
    L5:
        if (this.items.isEmpty() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void refreshSelectedState() {
        ScenarioListAdapter<SearchPermissionGroupInfo> r0 = this.adapter;
        if (r0 == null) goto L6;
        r0.refreshSelectedState();
        return;
    }

    public PermissionGroupListFragment() {
        this.items = CollectionsKt.emptyList();
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ScenarioListAdapter<SearchPermissionGroupInfo> r0 = this.adapter;
        if (r0 == null) goto L6;
        r0.refreshSelectedState();
        return;
    }

    public final List<SearchPermissionGroupInfo> getItems() {
        return this.items;
    }

    public final ScenarioSelectionDelegate getSelectionDelegate() {
        return this.selectionDelegate;
    }

    public final void setItems(List<SearchPermissionGroupInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.items = r2;
    }

    public final void setSelectionDelegate(ScenarioSelectionDelegate r1) {
        this.selectionDelegate = r1;
    }

    public final void submitItems(List<SearchPermissionGroupInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "newItems");
        this.items = r2;
        this.hasSubmittedItems = true;
        ScenarioListAdapter<SearchPermissionGroupInfo> r0 = this.adapter;
        if (r0 == null) goto L5;
        r0.submitItems(r2);
    L5:
        updateEmptyState();
    }

    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        RecyclerView r5 = r3.findViewById(2131382281);
        this.recyclerView = r5;
        this.emptyHintView = (TextView) r3.findViewById(2131382278);
        r5.setLayoutManager(new LinearLayoutManager(r3.getContext()));
        ScenarioSelectionDelegate r6 = this.selectionDelegate;
        if (r6 != null) goto L5;
        r6 = NoopDelegate.INSTANCE;
    L5:
        ScenarioListAdapter<SearchPermissionGroupInfo> r0 = new ScenarioListAdapter(this.items, r6);
        this.adapter = r0;
        r5.setAdapter(r0);
        updateEmptyState();
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564217, r3, false);
    }
}
