package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Integer r0 = com.larus.im.bean.message.a.H(r2);
        ConcurrentHashMap r1 = com.larus.bmhome.utils.w2.a;
        int r3 = com.larus.bmhome.utils.w2.a(r2.getMessageId());
        if (r0 == null) goto L5;
        r3 = r0.intValue();
    L5:
        List r4 = r2.getSubListGroup();
        if (r4 != null) goto L10;
        return null;
    L10:
        return (List) CollectionsKt.getOrNull(r4, r3);
    }
}
