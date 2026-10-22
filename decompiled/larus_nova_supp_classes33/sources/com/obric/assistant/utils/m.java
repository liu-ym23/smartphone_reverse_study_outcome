package com.obric.assistant.utils;

import com.obric.aiagent.assistant.idl.bean.StateInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public static final String a(StateInfo r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getExt();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("o_complex_source_type");
    L7:
        if (r3 != null) goto L10;
        return "";
    L10:
        return r3;
    L6:
        r3 = null;
        goto L7
    }

    public static final String b(StateInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return "StateInfo(requestType: " + r2.getRequestType() + ", refMessageId: " + r2.getRefMessageId() + ", taskType = " + r2.getTaskType() + ", isInIsland = " + r2.isInIsland() + ')';
    }
}
