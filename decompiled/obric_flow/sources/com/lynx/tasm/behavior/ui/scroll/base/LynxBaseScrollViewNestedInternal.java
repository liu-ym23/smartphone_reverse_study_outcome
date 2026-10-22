package com.lynx.tasm.behavior.ui.scroll.base;

import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingParent2;
import hn.e;

/* JADX INFO: loaded from: classes2.dex */
public interface LynxBaseScrollViewNestedInternal extends e, NestedScrollingParent2, NestedScrollingChild2 {
    int getBackwardNestedScrollMode();

    int getForwardNestedScrollMode();
}
