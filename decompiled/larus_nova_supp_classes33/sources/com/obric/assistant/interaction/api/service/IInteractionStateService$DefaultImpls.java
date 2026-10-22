package com.obric.assistant.interaction.api.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class IInteractionStateService$DefaultImpls {
    public static /* synthetic */ void clearCustomBarActions$default(IInteractionStateService r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.clearCustomBarActions(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearCustomBarActions");
    }
}
