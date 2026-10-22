package com.obric.assistant.utils;

import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l {
    public static final Set<String> a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DMConstData.DMComplexTaskState.values().length];
            r0[DMConstData.DMComplexTaskState.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DMConstData.DMComplexTaskState.Queueing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DMConstData.DMComplexTaskState.Terminated.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"o_omni_task_id", "o_complex_source_type", "clarify_message_content", "message_id_for_clarify"});
    }

    public static final String a(DMTaskState r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getExtra();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("message_id_for_clarify");
    L7:
        if (r3 != null) goto L10;
        return "";
    L10:
        return r3;
    L6:
        r3 = null;
        goto L7
    }

    public static final String b(DMTaskState r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getExtra();
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

    public static final String c(DMTaskInfo r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getExt();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("o_omni_task_id");
    L7:
        if (r3 != null) goto L10;
        return "";
    L10:
        return r3;
    L6:
        r3 = null;
        goto L7
    }

    public static final String d(DMTaskState r0) {
        if (r0 == null) goto L6;
        DMTaskInfo r1 = r0.getTaskInfo();
        if (r1 == null) goto L6;
        String r2 = c(r1);
    L7:
        if (r2 != null) goto L10;
        return "";
    L10:
        return r2;
    L6:
        r2 = null;
        goto L7
    }

    public static final boolean e(DMTaskState r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (h(r2.getState()) != DMConstData.DMComplexTaskState.Clarify) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean f(DMTaskState r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        DMConstData.DMComplexTaskState r4 = h(r3.getState());
        int r5 = a.a[r4.ordinal()];
        if (r5 != 1) goto L8;
        return false;
    L8:
        if (r5 != 2) goto L10;
        return false;
    L10:
        if (r5 == 3) goto L15;
        return true;
    L15:
        return false;
    }

    public static final String g(DMTaskState r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringBuilder r0 = new StringBuilder("DMTaskState(taskId: ");
        r0.append(r5.getTaskId());
        r0.append(", omniTaskId: ");
        r0.append(d(r5));
        r0.append(", state: ");
        r0.append(h(r5.getState()));
        r0.append(", ");
        r0.append(r5.getState());
        r0.append(", keyExtra: ");
        Map r6 = r5.getExtra();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r7.next();
        if (a.contains(r2.getKey()) == false) goto L4;
        r1.put(r2.getKey(), r2.getValue());
        goto L4
    L8:
        r0.append(r1);
        r0.append(')');
        return r0.toString();
    }

    public static final DMConstData.DMComplexTaskState h(int r3) {
        Iterator r0 = DMConstData.DMComplexTaskState.getEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        DMConstData.DMComplexTaskState r1 = (DMConstData.DMComplexTaskState) r0.next();
        if (r1.ordinal() != r3) goto L4;
        return r1;
    L9:
        return DMConstData.DMComplexTaskState.Idle;
    }
}
