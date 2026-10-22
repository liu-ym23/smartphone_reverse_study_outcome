package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ Message a;

    public /* synthetic */ r(Message r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        Message r0 = this.a;
        int r1 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter((Map) r4, "it");
        Map r5 = r0.getBusinessExt();
        if (r5 != null) goto L6;
        r5 = new LinkedHashMap();
    L6:
        return com.larus.utils.h.c(r5, new Pair[]{TuplesKt.to("send_loading", "2")});
    }
}
