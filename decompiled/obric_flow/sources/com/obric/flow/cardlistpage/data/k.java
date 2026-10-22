package com.obric.flow.cardlistpage.data;

import com.obric.flow.cardlistpage.base.CardType;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11497a = null;

    static {
        int[] r5 = new int[CardType.values().length];
        r5[CardType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r5[CardType.MINI_APP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r5[CardType.CUSTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f11497a = r5;
    }
}
