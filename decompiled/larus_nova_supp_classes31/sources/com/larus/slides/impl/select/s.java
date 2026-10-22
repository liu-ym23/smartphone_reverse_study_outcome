package com.larus.slides.impl.select;

import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface s<UIState, UIEvent, UIAction> {
    void dispatchUIAction(UIAction r1);

    d1<UIEvent> getUiEvent();

    i1<UIState> getUiState();
}
