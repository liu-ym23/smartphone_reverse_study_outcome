package com.ss.android.lark.picker.factory;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/factory/MissingPickerFactory;", "Lcom/ss/android/lark/picker/factory/PickerFactory;", "<init>", "()V", "createNavPickerHolder", "Lcom/ss/android/lark/picker/factory/PickerViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "config", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MissingPickerFactory implements PickerFactory {
    public static final MissingPickerFactory INSTANCE = null;

    static {
        INSTANCE = new MissingPickerFactory();
    }

    private MissingPickerFactory() {
    }

    @Override // com.ss.android.lark.picker.factory.PickerFactory
    public PickerViewHolder createNavPickerHolder(final FragmentActivity r2, NavPickerConfig r3, PickerStatistics.Scene r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "scene");
        Log.e("MissingPickerFactory", "PickerFactory is not registered");
        return new AnonymousClass1(r2);
    }
}
