package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q0 implements Function1 {
    public final /* synthetic */ int a;

    public /* synthetic */ q0(int r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        int r0 = this.a;
        int r1 = ChatRepo.f;
        Intrinsics.checkNotNullParameter((Message) r3, "it");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put(UpdateMessageLocalOption.LOCAL_STATUS, String.valueOf(r0));
        return r4;
    }
}
