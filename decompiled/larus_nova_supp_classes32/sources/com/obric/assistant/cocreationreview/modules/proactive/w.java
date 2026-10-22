package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.g5;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w {
    public final AtomicLong a;

    public w() {
        this.a = new AtomicLong(0);
    }

    public final boolean a(x r6, g5 r7) {
        Intrinsics.checkNotNullParameter(r6, "ticket");
        Intrinsics.checkNotNullParameter(r7, "activeRequest");
        if (r6.a == this.a.get()) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r6.b, r7) == false) goto L7;
        return true;
    }
}
