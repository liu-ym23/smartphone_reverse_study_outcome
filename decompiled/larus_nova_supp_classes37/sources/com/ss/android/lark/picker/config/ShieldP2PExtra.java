package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/config/ShieldP2PExtra;", "Lcom/ss/android/lark/picker/config/Extra;", "<init>", "()V", "isReturnRelationTag", "", "()Z", "setReturnRelationTag", "(Z)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ShieldP2PExtra implements Extra {
    private boolean isReturnRelationTag;

    public ShieldP2PExtra() {
        this.isReturnRelationTag = true;
    }

    public final boolean isReturnRelationTag() {
        return this.isReturnRelationTag;
    }

    public final void setReturnRelationTag(boolean r1) {
        this.isReturnRelationTag = r1;
    }
}
