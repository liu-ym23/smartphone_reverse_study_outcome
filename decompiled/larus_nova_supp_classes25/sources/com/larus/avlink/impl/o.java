package com.larus.avlink.impl;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.platform.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static final Lazy a = null;
    public static final List<String> b = null;

    static {
        Lazy r0 = LazyKt.lazy(new n());
        a = r0;
        ArrayList r1 = new ArrayList();
        b = r1;
        b r2 = (b) r0.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter("key_vuiid_taskid", "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        Intrinsics.checkNotNullParameter("dora_wake_history", "repoName");
        LinkedHashMap r3 = (LinkedHashMap) r2.a;
        Object r5 = r3.get("dora_wake_history");
        if (r5 != null) goto L5;
        r5 = Keva.getRepo("dora_wake_history", 0);
        r3.put("dora_wake_history", r5);
    L5:
        List r4 = StringsKt.split$default(((Keva) r5).getString("key_vuiid_taskid", ""), new char[]{'\n'}, false, 0, 6, null);
        ArrayList r6 = new ArrayList();
        Iterator r7 = r4.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Object r8 = r7.next();
        if (((String) r8).length() <= 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == false) goto L7;
        r6.add(r8);
        goto L7
    L11:
        r9 = false;
        goto L12
    L14:
        r1.addAll(r6);
    }

    public static void a(int r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "taskId");
        if (r13.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        List<String> r3 = b;
        StringBuilder r1 = new StringBuilder();
        Intrinsics.checkNotNullParameter("yyyy-MM-dd HH:mm:ss.SSS", "pattern");
        r1.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(System.currentTimeMillis())));
        r1.append(" vuiId:");
        r1.append(r12);
        r1.append(" taskId:");
        r1.append(r13);
        ListProtector.add(r3, 0, r1.toString());
        ArrayList r14 = (ArrayList) r3;
        if (r14.size() <= 10) goto L11;
        ListProtector.remove(r3, r14.size() - 1);
    L11:
        b r15 = (b) a.getValue();
        String r16 = CollectionsKt.joinToString$default(r3, "\n", null, null, 0, null, null, 62, null);
        r15.getClass();
        Intrinsics.checkNotNullParameter("key_vuiid_taskid", "key");
        Intrinsics.checkNotNullParameter(r16, "value");
        Intrinsics.checkNotNullParameter("dora_wake_history", "repoName");
        LinkedHashMap r17 = (LinkedHashMap) r15.a;
        Object r2 = r17.get("dora_wake_history");
        if (r2 != null) goto L14;
        r2 = Keva.getRepo("dora_wake_history", 0);
        r17.put("dora_wake_history", r2);
    L14:
        ((Keva) r2).storeString("key_vuiid_taskid", r16);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
