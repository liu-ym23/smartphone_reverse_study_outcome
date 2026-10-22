package com.obric.assistant.utils;

import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final String a(DMTaskInfo r1) {
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("o_last_reply_message_id");
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }
}
