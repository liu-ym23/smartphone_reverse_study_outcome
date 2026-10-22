package com.ss.android.lark.picker.base.view.binder.bridge;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/DefaultItemViewBridgeFactory;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;", "<init>", "()V", "obtain", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridge;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DefaultItemViewBridgeFactory implements IItemViewBridgeFactory {
    public DefaultItemViewBridgeFactory() {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridgeFactory
    public IItemViewBridge obtain(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if ((r2 instanceof ChatterChatViewHolder) == true) goto L7;
        return null;
    L7:
        return new DefaultItemViewBridge((ChatterChatViewHolder) r2);
    }
}
