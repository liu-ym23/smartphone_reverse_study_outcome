package com.larus.ugc.perf.impl;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface d {

    public static final class a {
        public static e a(Message r1) {
            Intrinsics.checkNotNullParameter(r1, "message");
            f r0 = f.a;
            String r2 = r1.getReplyId();
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.getClass();
            return f.b(r2);
        }
    }

    void a(e r1);

    void c(e r1);

    void d(e r1);

    void h(e r1);
}
