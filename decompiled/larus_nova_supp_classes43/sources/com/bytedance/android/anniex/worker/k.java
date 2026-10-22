package com.bytedance.android.anniex.worker;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k extends com.bytedance.sdk.xbridge.cn.protocol.c<ReadableMap, ReadableMap> {
    public final j b;
    public final String c;

    public k() {
        this.b = new j();
        this.c = "";
    }

    public final com.bytedance.sdk.xbridge.cn.protocol.g c() {
        return this.b;
    }

    public final Object b(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
        String r0 = this.c;
        if (Intrinsics.areEqual(r0, "webcast") == false) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        HashMap r12 = new HashMap();
        r12.put("__msg_type", "callback");
        r12.put("eventId", 0);
        r12.put("__callback_id", "0");
        r12.put("code", Integer.valueOf(r10));
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.put(MessageIndication.MESSAGE_TYPE_MSG, r11);
        Unit r14 = Unit.INSTANCE;
        r12.put("data", r13);
        return JavaOnlyMap.from(r12);
    L9:
        HashMap r15 = new HashMap();
        r15.put("code", Integer.valueOf(r10));
        r15.put(MessageIndication.MESSAGE_TYPE_MSG, r11);
        return JavaOnlyMap.from(r15);
    L5:
        r1 = Intrinsics.areEqual(r0, "host");
        goto L7
    }
}
