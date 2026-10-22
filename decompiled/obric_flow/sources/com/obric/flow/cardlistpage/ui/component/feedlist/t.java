package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.CardType;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11618a = null;

    static {
        int[] r5 = new int[CardType.values().length];
        r5[CardType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r5[CardType.MINI_APP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f11618a = r5;
    }
}
