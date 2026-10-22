package com.bytedance.ai.uiu;

import com.bytedance.ai.model.objects.PageType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2830a = null;

    static {
        int[] r5 = new int[PageType.values().length];
        r5[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r5[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f2830a = r5;
    }
}
