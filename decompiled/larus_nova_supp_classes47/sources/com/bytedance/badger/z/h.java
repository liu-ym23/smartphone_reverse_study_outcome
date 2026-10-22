package com.bytedance.badger.z;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class h extends Lambda implements Function1 {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
        super(1);
    }

    public Object invoke(Object r4) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) r4).byteValue())}, 1));
    }
}
