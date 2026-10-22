package com.obric.assistant.settings;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class q0 {
    public q0() {
    }

    public boolean a(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        return Intrinsics.areEqual(this, r2);
    }
}
