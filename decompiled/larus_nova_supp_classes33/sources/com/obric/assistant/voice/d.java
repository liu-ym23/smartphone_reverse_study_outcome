package com.obric.assistant.voice;

import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface d {
    void a(ObricListeningViewState r1);

    boolean b();

    void confirmListeningStarted();

    void finish();

    boolean isActive();
}
