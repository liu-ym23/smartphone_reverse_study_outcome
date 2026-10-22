package com.larus.bmhome.social.userchat.model;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x {
    public final List<Message> a;
    public final Map<String, String> b;

    public x(String r2, List<Message> r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "convId");
        Intrinsics.checkNotNullParameter(r3, "msgList");
        Intrinsics.checkNotNullParameter(r4, "ext");
        this.a = r3;
        this.b = r4;
    }
}
