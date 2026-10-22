package com.obric.assistant.state.impl.v2.utils;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wa8.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final boolean a(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("o_task_type");
    L7:
        return Intrinsics.areEqual(r3, "complex_task");
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getContentType() != 70) goto L5;
    L8:
        return true;
    L5:
        if (r2.getContentType() == 72) goto L8;
        return false;
    }

    public static final boolean c(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (com.larus.bmhome.chat.bean.d.G0(r4) == false) goto L16;
        Map r0 = r4.getExt();
        String r2 = null;
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("need_deep_think");
    L8:
        ModelItemIdentity r3 = t0.a;
        if (Intrinsics.areEqual(r1, t0.c.toString()) == true) goto L15;
        Map r5 = r4.getExt();
        if (r5 == null) goto L14;
        r2 = (String) r5.get("need_deep_think");
    L14:
        if (Intrinsics.areEqual(r2, t0.b.toString()) == false) goto L16;
    L15:
        return true;
    L7:
        r1 = null;
    L16:
        return false;
    }
}
