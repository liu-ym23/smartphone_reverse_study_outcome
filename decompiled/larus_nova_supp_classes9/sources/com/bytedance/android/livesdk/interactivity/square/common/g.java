package com.bytedance.android.livesdk.interactivity.square.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[IModelListDataManager.ModelChangeType.values().length];
        a = r0;
        r0[IModelListDataManager.ModelChangeType.INIT_LIST.ordinal()] = 1;
        r0[IModelListDataManager.ModelChangeType.INSERT_BOTTOM.ordinal()] = 2;
        r0[IModelListDataManager.ModelChangeType.INSERT_ITEM.ordinal()] = 3;
        r0[IModelListDataManager.ModelChangeType.RELOAD_ALL.ordinal()] = 4;
        r0[IModelListDataManager.ModelChangeType.REMOVE_RANGE.ordinal()] = 5;
    }
}
