package com.obric.assistant.activation.presentation.runtime.precheck;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final ObricChildListeningPrecheck.b a(ObricChildListeningPrecheck.Reason r2) {
        ObricChildListeningPrecheck.b r0 = ObricChildListeningPrecheck.b.c;
        Intrinsics.checkNotNullParameter(r2, "reason");
        return new ObricChildListeningPrecheck.b(ObricChildListeningPrecheck.Status.BLOCKED, r2);
    }
}
