package com.ss.android.lark.picker.base.widget.scenario;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.view.AvatarItemViewWithMask;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.binder.BinderRepo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchPermissionGroupInfo;
import com.ss.android.lark.search.dto.info.SearchPersonnelTypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0006\u0010\u0019\u001a\u00020\u0014J\u0014\u0010\u001a\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioListAdapter;", "T", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "items", "", "delegate", "Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioSelectionDelegate;", "<init>", "(Ljava/util/List;Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioSelectionDelegate;)V", "", "binderRepo", "Lcom/ss/android/lark/picker/base/view/binder/BinderRepo;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "ensureBinderRepo", "", "getItemCount", "onBindViewHolder", "holder", "position", "refreshSelectedState", "submitItems", "newItems", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ScenarioListAdapter<T extends SearchBaseInfo> extends RecyclerView.Adapter<ChatterChatViewHolder> {
    private BinderRepo binderRepo;
    private final ScenarioSelectionDelegate delegate;
    private final List<T> items;

    public int getItemCount() {
        return this.items.size();
    }

    public final void refreshSelectedState() {
        notifyDataSetChanged();
    }

    public static final /* synthetic */ ScenarioSelectionDelegate access$getDelegate$p(ScenarioListAdapter r0) {
        return r0.delegate;
    }

    private final void ensureBinderRepo(ViewGroup r9) {
        if (this.binderRepo == null) goto L5;
        return;
    L5:
        BinderRepo r0 = new BinderRepo(r9.getContext(), new AnonymousClass1(this), null, null, 12, null);
        r0.switchMultiple(true);
        r0.getPersonnelTypeBinder().switchMultiple(true);
        r0.getPermissionGroupBinder().switchMultiple(true);
        r0.setOnBusinessConsumeItem(new ScenarioListAdapter$ensureBinderRepo$2$1(this));
        this.binderRepo = r0;
    }

    public final void submitItems(List<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "newItems");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public ScenarioListAdapter(List<? extends T> r2, ScenarioSelectionDelegate r3) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.delegate = r3;
        this.items = CollectionsKt.toMutableList(r2);
    }

    public void onBindViewHolder(ChatterChatViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        SearchPermissionGroupInfo r0 = (SearchBaseInfo) ListProtector.get(this.items, r6);
        r0.selected(this.delegate.isSelected(r0));
        BinderRepo r2 = null;
        if ((r0 instanceof SearchPersonnelTypeInfo) == false) goto L10;
        BinderRepo r1 = this.binderRepo;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binderRepo");
    L8:
        r2.getPersonnelTypeBinder().bind(r6, (SearchPersonnelTypeInfo) r0, r5);
        return;
    L7:
        r2 = r1;
        goto L8
    L10:
        if ((r0 instanceof SearchPermissionGroupInfo) == false) goto L16;
        BinderRepo r3 = this.binderRepo;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binderRepo");
    L15:
        r2.getPermissionGroupBinder().bind(r6, r0, r5);
        return;
    L14:
        r2 = r3;
        goto L15
    L16:
        BinderRepo r4 = this.binderRepo;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binderRepo");
    L20:
        r2.getCommonBinder().bind(r6, r0, r5);
        return;
    L19:
        r2 = r4;
        goto L20
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public ChatterChatViewHolder m3372onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        ensureBinderRepo(r7);
        AvatarItemViewWithMask r9 = new AvatarItemViewWithMask(r7.getContext(), null, 0, 6, null);
        r9.showDivider(true);
        return new ChatterChatViewHolder(r9, 4);
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ChatterChatViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m3372onCreateViewHolder(r1, r2);
    }
}
