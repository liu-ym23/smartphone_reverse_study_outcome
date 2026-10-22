package com.larus.bmhome.chat.deepsearch;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements xc8.g {
    public final int c() {
        return 43;
    }

    public l() {
    }

    public final boolean a(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "sourceData");
        if (com.larus.im.bean.message.a.b0(r4) == false) goto L6;
    L10:
        return false;
    L6:
        if (r4.getContentType() != 1) goto L8;
        return true;
    L8:
        if (r4.getContentType() != 800) goto L10;
        return true;
    }

    public final ei9.f b(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new dg8.l(r3);
    }
}
