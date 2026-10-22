package com.ss.android.lark.picker.doubao.view.pickercommon;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridgeFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerCommonItemViewBridgeFactory;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;", "tagEnricher", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;", "<init>", "(Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;)V", "obtain", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridge;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPickerCommonItemViewBridgeFactory implements IItemViewBridgeFactory {
    private final DoubaoChatterTagEnricher tagEnricher;

    public DoubaoPickerCommonItemViewBridgeFactory(DoubaoChatterTagEnricher r1) {
        this.tagEnricher = r1;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridgeFactory
    public IItemViewBridge obtain(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof DoubaoPickerCommonBinderViewHolder) == true) goto L7;
        return null;
    L7:
        return new DoubaoPickerCommonItemViewBridge((DoubaoPickerCommonBinderViewHolder) r3, this.tagEnricher);
    }
}
