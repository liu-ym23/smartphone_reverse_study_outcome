package com.obric.assistant.oauto;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Message r1) {
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

    public static boolean b(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map r0 = r3.getExt();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("o_task_type");
    L7:
        if (Intrinsics.areEqual(r2, "complex_task") == false) goto L14;
        Map r4 = r3.getExt();
        if (r4 == null) goto L12;
        r1 = (String) r4.get("o_complex_task_message_type");
    L12:
        if (Intrinsics.areEqual(r1, "clarify") == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public static boolean c(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map r0 = r3.getExt();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("o_task_type");
    L7:
        if (Intrinsics.areEqual(r2, "complex_task") == false) goto L14;
        Map r4 = r3.getExt();
        if (r4 == null) goto L12;
        r1 = (String) r4.get("o_complex_task_message_type");
    L12:
        if (Intrinsics.areEqual(r1, "summary") == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }
}
