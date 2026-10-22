package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p0 implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ p0(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        String r0 = this.a;
        int r1 = ChatRepo.f;
        Intrinsics.checkNotNullParameter((Message) r3, "it");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put(UpdateMessageLocalOption.CONTENT, r0);
        return r4;
    }
}
