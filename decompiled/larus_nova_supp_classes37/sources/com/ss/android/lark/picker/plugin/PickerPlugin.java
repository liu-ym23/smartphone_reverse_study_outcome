package com.ss.android.lark.picker.plugin;

import com.ss.android.lark.picker.PickerViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.PickerExtra;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/picker/plugin/PickerPlugin;", "", "apply", "", "picker", "Lcom/ss/android/lark/picker/base/widget/BasePicker;", "viewModel", "Lcom/ss/android/lark/picker/PickerViewModel;", "extra", "Lcom/ss/android/lark/picker/config/PickerExtra;", "recommendEmptyIconResId", "", "recommendEmptyHintText", "", "(Lcom/ss/android/lark/picker/base/widget/BasePicker;Lcom/ss/android/lark/picker/PickerViewModel;Lcom/ss/android/lark/picker/config/PickerExtra;Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface PickerPlugin {
    void apply(BasePicker<?, ?> r1, PickerViewModel r2, PickerExtra r3, Integer r4, CharSequence r5);
}
