package com.obric.assistant.live.api;

import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final boolean a(ObricState r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getExt().get("is_from_continuous_intents"), "1");
    }
}
