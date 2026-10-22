package com.bytedance.android.livesdk.interactivity.square.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[BaseModelListScrollManager.ScrollState.values().length];
        a = r0;
        r0[BaseModelListScrollManager.ScrollState.AutoScroll.ordinal()] = 1;
        r0[BaseModelListScrollManager.ScrollState.Focus.ordinal()] = 2;
        int[] r1 = new int[IModelListDataManager.ModelChangeType.values().length];
        b = r1;
        r1[IModelListDataManager.ModelChangeType.INSERT_ITEM.ordinal()] = 1;
        r1[IModelListDataManager.ModelChangeType.REMOVE_RANGE.ordinal()] = 2;
    }
}
