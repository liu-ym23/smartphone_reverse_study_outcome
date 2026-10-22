package com.larus.bmhome.chat.model;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n1 implements Function1 {
    public /* synthetic */ n1() {
    }

    public final Object invoke(Object r6) {
        Message r7 = (Message) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        Map r8 = r7.getBusinessExt();
        if (r8 == null) goto L5;
        String r0 = (String) r8.put("send_loading", "0");
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        UpdateMessageLocalOption r2 = UpdateMessageLocalOption.REPLACE_BIZ_EXT;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        kuc.a.f(r3);
        v2 r4 = v2.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r9 = zd9.i.c(r8, kuc.a.c(r4, r4));
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        r1.put(r2, r9);
        return r1;
    }
}
