package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kuc.a;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r0 implements Function1 {
    public final /* synthetic */ Pair a;

    public /* synthetic */ r0(Pair r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        Pair r0 = this.a;
        Message r7 = (Message) r6;
        int r1 = ChatRepo.f;
        Intrinsics.checkNotNullParameter(r7, "it");
        Map r8 = r7.getBusinessExt();
        if (r8 != null) goto L5;
        r8 = new LinkedHashMap();
    L5:
        Map r9 = com.larus.utils.h.c(r8, new Pair[]{r0});
        LinkedHashMap r2 = new LinkedHashMap();
        UpdateMessageLocalOption r3 = UpdateMessageLocalOption.REPLACE_BIZ_EXT;
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        a.f(r4);
        v2 r5 = v2.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r10 = zd9.i.c(r9, a.c(r5, r5));
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        r2.put(r3, r10);
        return r2;
    }
}
