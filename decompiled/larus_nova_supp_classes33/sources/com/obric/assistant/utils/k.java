package com.obric.assistant.utils;

import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k {
    public static final String a(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("o_reference_msg_id");
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public static final String b(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("o_omni_task_id");
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public static final boolean c(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (o0.d(b(r1)) == true) goto L12;
        Map r2 = r1.getExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("o_is_omni_agent");
    L9:
        if (Intrinsics.areEqual(r3, "1") == true) goto L12;
        return false;
    L7:
        r3 = null;
    L12:
        return true;
    }
}
