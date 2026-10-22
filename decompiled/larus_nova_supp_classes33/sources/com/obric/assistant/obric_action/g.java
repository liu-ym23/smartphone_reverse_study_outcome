package com.obric.assistant.obric_action;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public static final String a(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) r2.get("o_obric_action_key");
    }
}
