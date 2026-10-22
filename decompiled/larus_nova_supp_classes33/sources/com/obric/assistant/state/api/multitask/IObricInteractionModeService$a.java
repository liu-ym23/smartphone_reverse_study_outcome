package com.obric.assistant.state.api.multitask;

import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricInteractionModeService$a {
    public static /* synthetic */ void a(ObricInteractionModeServiceDelegate r1, String r2, ModeEndReason r3) {
        r1.b(r2, r3, MapsKt.emptyMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String b(ObricInteractionModeServiceDelegate r6, String r7, String r8, ObricInteractionType r9, Map r10, int r11) {
        if ((r11 & 16) == 0) goto L6;
        r10 = MapsKt.emptyMap();
    L6:
        return r6.d(r7, r8, r9, null, r10);
    }
}
