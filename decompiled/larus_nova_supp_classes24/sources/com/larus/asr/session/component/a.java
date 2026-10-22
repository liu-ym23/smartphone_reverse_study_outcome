package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final Message b;

    public a(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.a = r2;
        this.b = r3;
    }
}
