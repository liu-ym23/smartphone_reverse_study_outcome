package com.obric.assistant.chat;

import com.larus.bmhome.actionbar.model.z0;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class j0 implements Function1 {
    public /* synthetic */ j0() {
    }

    public final Object invoke(Object r2) {
        z0 r3 = (z0) r2;
        Set r0 = ObricChatUIServiceImpl.g;
        Intrinsics.checkNotNullParameter(r3, "it");
        Set r1 = ObricChatUIServiceImpl.g;
        String r4 = r3.b;
        if (r4 != null) goto L6;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return Boolean.valueOf(r1.contains(r4));
    }
}
