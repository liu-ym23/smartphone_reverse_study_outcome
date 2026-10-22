package com.ss.android.lark.picker.factory;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/factory/PickerFactoryLoader;", "", "<init>", "()V", "TAG", "", "load", "Lcom/ss/android/lark/picker/factory/PickerFactory;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerFactoryLoader {
    public static final PickerFactoryLoader INSTANCE = null;
    private static final String TAG = "PickerFactoryLoader";

    static {
        INSTANCE = new PickerFactoryLoader();
    }

    private PickerFactoryLoader() {
    }

    public final PickerFactory load() {
        PickerFactory r0 = (PickerFactory) ClaymoreServiceLoader.loadFirstOrNull(PickerFactory.class);     // Catch: Throwable -> L6
        if (r0 != null) goto L11;
        return MissingPickerFactory.INSTANCE;
    L11:
        return r0;
    L6:
        th = move-exception;
        Log.e(TAG, "load PickerFactory failed", th);
        return MissingPickerFactory.INSTANCE;
    }
}
