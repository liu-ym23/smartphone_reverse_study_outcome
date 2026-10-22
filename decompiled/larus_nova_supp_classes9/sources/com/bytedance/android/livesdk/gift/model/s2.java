package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.livesdk.message.model.o7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s2 implements gm2.g {
    public final o7 a;

    public final o7 getGiftMessage() {
        return this.a;
    }

    public s2(o7 r2) {
        Intrinsics.checkNotNullParameter(r2, "giftMessage");
        this.a = r2;
    }
}
