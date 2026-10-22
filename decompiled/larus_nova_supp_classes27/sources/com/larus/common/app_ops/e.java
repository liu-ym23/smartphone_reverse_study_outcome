package com.larus.common.app_ops;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.common.app_ops.trasmitter.AsyncContext;
import com.larus.common.app_ops.trasmitter.AsyncContextLegacy;
import d09.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    static {
    }

    public static List a() {
        LinkedList r1 = new LinkedList(CollectionsKt.emptyList());
        AsyncContext r0 = b.a.getContext();
        Integer r3 = null;
        if ((r0 instanceof AsyncContextLegacy) == false) goto L5;
        AsyncContextLegacy r2 = (AsyncContextLegacy) r0;
    L6:
        StringBuilder r4 = new StringBuilder();
        if (r2 == null) goto L16;
        int r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r6 = r2.getData("stack_index");
        if (r6 != null) goto L12;
    L14:
        if (r3 == null) goto L16;
        int r7 = r3.intValue();
    L17:
        r4.append(r7);
        r4.append(':');
        r4.append(System.currentTimeMillis());
        r1.addLast(new Throwable(r4.toString()));
        return r1;
    L12:
        if ((r6 instanceof Integer) == false) goto L14;
        r3 = (Integer) r6;
    L16:
        r7 = 0;
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final String b(List<? extends Throwable> r11) {
        StringBuilder r0 = new StringBuilder();
        int r1 = a.a;
        List r12 = CollectionsKt.reversed(r11);
        if (r12 == null) goto L26;
        Iterator r13 = r12.iterator();
        int r2 = -1;
    L6:
        if (r13.hasNext() == false) goto L26;
        Throwable r3 = (Throwable) r13.next();
        String r4 = r3.getMessage();
        String r10 = null;
        if (r4 == null) goto L10;
        List r5 = StringsKt.split$default(r4, new String[]{":"}, false, 0, 6, null);
    L11:
        int r6 = 0;
        if (r5 == null) goto L16;
        String r7 = (String) ListProtector.get(r5, 0);
        if (r7 == null) goto L16;
        Integer r8 = Integer.valueOf(CastIntegerProtector.parseInt(r7));
    L18:
        if (r2 != (-1)) goto L22;
        if (r8 == null) goto L21;
        r6 = r8.intValue();
    L21:
        r2 = r6 + 1;
    L22:
        if (r5 == null) goto L24;
        r10 = (String) ListProtector.get(r5, 1);
    L24:
        r0.append("max_stack_count:" + r2 + ", cur_index:" + r8 + ", timestamp:" + r10);
        r0.append(jh7.a.a(r3));
        StringsKt.appendln(r0);
    L16:
        r8 = null;
        goto L18
    L10:
        r5 = null;
    L26:
        return r0.toString();
    }
}
