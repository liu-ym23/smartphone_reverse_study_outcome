package com.larus.bmhome.social.userchat.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 {
    public static final String a(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Integer r1 = c(r4);
        if (r1 != null) goto L6;
    L7:
        return null;
    L6:
        if (r1.intValue() != 3) goto L7;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r5 = r4.getBusinessExt();
        if (r5 == null) goto L11;
        String r6 = (String) r5.get("original_message_id");
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        if (StringsKt.endsWith$default(r6, "-clear-context", false, 2, null) == true) goto L17;
        r6 = null;
    L17:
        if (r6 != null) goto L19;
        return null;
    L19:
        return StringsKt.removeSuffix(r6, "-clear-context");
    L11:
        r6 = null;
        goto L12
    }

    public static final int b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (StringsKt.contains$default(r8, ":", false, 2, null) == false) goto L7;
        Integer r9 = StringsKt.toIntOrNull((String) CollectionsKt.last(StringsKt.split$default(r8, new String[]{":"}, false, 0, 6, null)));
        if (r9 == null) goto L7;
        return r9.intValue();
    L7:
        return -1;
    }

    public static final Integer c(Message r1) {
        if (r1 == null) goto L8;
        Map r2 = r1.getBusinessExt();
        if (r2 == null) goto L8;
        String r3 = (String) r2.get("fake_message_type");
        if (r3 == null) goto L8;
        return StringsKt.toIntOrNull(r3);
    L8:
        return null;
    }

    public static final String d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (StringsKt.contains$default(r10, ":", false, 2, null) == true) goto L5;
        return r10;
    L5:
        return (String) ListProtector.get(StringsKt.split$default(r10, new String[]{":"}, false, 0, 6, null), 0);
    }

    public static final boolean e(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getLocalMessageId();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (b(r3) != 8) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean f(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Map r2 = r1.getBusinessExt();     // Catch: NullPointerException -> L9
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("ui_message_type");     // Catch: NullPointerException -> L9
    L7:
        return Intrinsics.areEqual(r3, "fake_message");
    L6:
        r3 = null;
    L9:
        return false;
    }

    public static final boolean g(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getLocalMessageId();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (b(r3) != 9) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean h(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getBusinessExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("is_mock_receiving");
    L7:
        return Intrinsics.areEqual(r3, "1");
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean i(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getBusinessExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("send_loading");
    L6:
        if (r3 != null) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(r3, TriggerSendLoading.NO_LOADING) == true) goto L10;
        return true;
    L5:
        r3 = null;
        goto L6
    }

    public static final Message j(Message r47, int r48) {
        Intrinsics.checkNotNullParameter(r47, "<this>");
        if (r48 == 0) goto L6;
        if (r48 == 1) goto L6;
        long r3 = r47.getLocalIndex();
    L7:
        long r19 = r3;
        String r4 = r47.getMessageId();
        String r5 = "";
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        String r18 = k(r4, r48);
        String r6 = r47.getLocalMessageId();
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        String r17 = k(r6, r48);
        Map r7 = r47.getBusinessExt();
        if (r7 != null) goto L16;
        r7 = new LinkedHashMap();
    L16:
        Pair[] r8 = new Pair[4];
        r8[0] = TuplesKt.to("ui_message_type", "fake_message");
        r8[1] = TuplesKt.to("fake_message_type", String.valueOf(r48));
        String r0 = r47.getMessageId();
        if (r0 != null) goto L19;
        r0 = "";
    L19:
        r8[2] = TuplesKt.to("original_message_id", r0);
        String r1 = r47.getLocalMessageId();
        if (r1 == null) goto L23;
        r5 = r1;
    L23:
        r8[3] = TuplesKt.to("original_local_message_id", r5);
        return Message.copy$default(r47, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r17, r18, r19, 0, false, null, null, null, com.larus.utils.h.c(r7, r8), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4308993, 31, null);
    L6:
        r3 = r47.getLocalIndex() + 1;
        goto L7
    }

    public static final String k(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1 + ":fake_message:" + r2;
    }
}
