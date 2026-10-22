package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z {
    public static final ObricListeningViewState a(ObricListeningVisualMode r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        if (r3 != ObricListeningVisualMode.CLICK_TALK) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r3 == ObricListeningVisualMode.HIDDEN) goto L17;
        if (r0 == false) goto L15;
        if (r4 == false) goto L17;
    L15:
        return new ObricListeningViewState(r3, true, 0.0f);
    L17:
        return ObricListeningViewState.d;
    L5:
        if (r3 == ObricListeningVisualMode.PRESS_TALK) goto L8;
        r0 = false;
        goto L10
    }
}
