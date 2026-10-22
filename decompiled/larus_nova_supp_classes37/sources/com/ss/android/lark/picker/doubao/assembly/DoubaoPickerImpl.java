package com.ss.android.lark.picker.doubao.assembly;

import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.doubao.IDoubaoPickerApi;
import com.ss.android.lark.picker.doubao.api.IDoubaoPicker;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/assembly/DoubaoPickerImpl;", "Lcom/ss/android/lark/picker/doubao/api/IDoubaoPicker;", "<init>", "()V", "createDoubaoPicker", "Lcom/ss/android/lark/picker/doubao/IDoubaoPickerApi;", "config", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;", "picker-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@OfficeSDKUserScope
public final class DoubaoPickerImpl implements IDoubaoPicker {
    @Inject
    public DoubaoPickerImpl() {
    }

    @Override // com.ss.android.lark.picker.doubao.api.IDoubaoPicker
    public IDoubaoPickerApi createDoubaoPicker(DoubaoPickerConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return new DoubaoPickerWrapper(r2);
    }
}
