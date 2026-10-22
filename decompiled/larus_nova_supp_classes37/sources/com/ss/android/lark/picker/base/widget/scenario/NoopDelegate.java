package com.ss.android.lark.picker.base.widget.scenario;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/scenario/NoopDelegate;", "Lcom/ss/android/lark/picker/base/widget/scenario/ScenarioSelectionDelegate;", "<init>", "()V", "isSelected", "", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onSelectChanged", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class NoopDelegate implements ScenarioSelectionDelegate {
    public static final NoopDelegate INSTANCE = null;

    static {
        INSTANCE = new NoopDelegate();
    }

    private NoopDelegate() {
    }

    @Override // com.ss.android.lark.picker.base.widget.scenario.ScenarioSelectionDelegate
    public boolean isSelected(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        return false;
    }

    @Override // com.ss.android.lark.picker.base.widget.scenario.ScenarioSelectionDelegate
    public void onSelectChanged(SearchBaseInfo r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "info");
    }

    @Override // com.ss.android.lark.picker.base.widget.scenario.ScenarioSelectionDelegate
    public boolean canSelect(SearchBaseInfo r1) {
        return ScenarioSelectionDelegate.DefaultImpls.canSelect(this, r1);
    }
}
