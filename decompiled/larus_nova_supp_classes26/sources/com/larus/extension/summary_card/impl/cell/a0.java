package com.larus.extension.summary_card.impl.cell;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 implements xc8.g {
    public final int c() {
        return 38;
    }

    public a0() {
    }

    public final boolean a(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return m99.a.f(r3);
    }

    public final ei9.f b(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new z(r3);
    }
}
