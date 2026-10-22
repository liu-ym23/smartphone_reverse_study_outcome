package com.larus.voicecall.impl.component.feedback;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new t());
    }

    public static Keva a() {
        return (Keva) a.getValue();
    }
}
