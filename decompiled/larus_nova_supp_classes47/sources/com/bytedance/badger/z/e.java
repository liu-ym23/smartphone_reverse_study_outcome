package com.bytedance.badger.z;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class e extends Lambda implements Function1 {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        super(1);
    }

    public Object invoke(Object r4) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) r4).byteValue())}, 1));
    }
}
