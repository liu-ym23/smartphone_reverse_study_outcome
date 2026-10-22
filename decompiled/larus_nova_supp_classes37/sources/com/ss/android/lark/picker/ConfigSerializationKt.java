package com.ss.android.lark.picker;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.config.SearcherConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\b\u001a\f\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\t\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "serialize", "", "Lcom/ss/android/lark/picker/config/PickerConfig;", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "picker_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ConfigSerializationKt {
    private static final Lazy gson$delegate = null;

    static {
        gson$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ConfigSerializationKt$gson$2.INSTANCE);
    }

    private static final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }

    public static final /* synthetic */ Gson access$getGson() {
        return getGson();
    }

    public static final String serialize(PickerConfig r1) {
        if (r1 != null) goto L6;
        return "null";
    L6:
        return GsonProtectorUtils.toJson(getGson(), r1);
    }

    public static final String serialize(SearcherConfig r1) {
        if (r1 != null) goto L6;
        return "null";
    L6:
        return GsonProtectorUtils.toJson(getGson(), r1);
    }
}
