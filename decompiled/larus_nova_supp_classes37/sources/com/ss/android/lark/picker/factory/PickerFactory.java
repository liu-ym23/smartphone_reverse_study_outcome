package com.ss.android.lark.picker.factory;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/factory/PickerFactory;", "", "createNavPickerHolder", "Lcom/ss/android/lark/picker/factory/PickerViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "config", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface PickerFactory {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DefaultImpls {
        public static /* synthetic */ PickerViewHolder createNavPickerHolder$default(PickerFactory r0, FragmentActivity r1, NavPickerConfig r2, PickerStatistics.Scene r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L7;
            r3 = PickerStatistics.Scene.Unknown;
        L7:
            return r0.createNavPickerHolder(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNavPickerHolder");
        }
    }

    PickerViewHolder createNavPickerHolder(FragmentActivity r1, NavPickerConfig r2, PickerStatistics.Scene r3);
}
