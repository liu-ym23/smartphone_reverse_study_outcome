package com.larus.bmhome.chat.list.cell.test;

import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final Map<String, String> a(Map<String, String> r5, Message r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r5 == null) goto L6;
        Map<String, String> r7 = MapsKt.toMutableMap(r5);
        if (r7 == null) goto L6;
    L7:
        Map r8 = r6.getExt();
        if (r8 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        Pair r2 = null;
        if (r1 == true) goto L33;
        String r3 = (String) r8.get("suffix_active_delete_message_id_list");
        if (r3 != null) goto L20;
    L25:
        String r9 = (String) r8.get("sub_active_msg_id_list");
        if (r9 == null) goto L33;
        if ((true ^ StringsKt.isBlank(r9)) == true) goto L31;
        r9 = null;
    L31:
        if (r9 == null) goto L33;
        r2 = TuplesKt.to("sub_active_msg_id_list", r9);
        goto L33
    L20:
        if ((!StringsKt.isBlank(r3)) == true) goto L23;
        r3 = null;
    L23:
        if (r3 == null) goto L25;
        r2 = TuplesKt.to("suffix_active_delete_message_id_list", r3);
    L33:
        if (r2 == null) goto L35;
        r7.put((String) r2.component1(), (String) r2.component2());
        r7.put("crowd_test_delete_tip_anchor", "1");
    L35:
        return r7;
    L10:
        if (r8.isEmpty() == true) goto L13;
        r1 = false;
    L6:
        r7 = new LinkedHashMap();
        goto L7
    }
}
