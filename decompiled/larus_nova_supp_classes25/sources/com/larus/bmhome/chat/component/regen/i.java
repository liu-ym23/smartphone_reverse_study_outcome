package com.larus.bmhome.chat.component.regen;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static final boolean a(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContentType() != 2022) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean b(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("use_creation");
    L7:
        return Intrinsics.areEqual(r3, "1");
    L5:
        r3 = null;
        goto L7
    }
}
