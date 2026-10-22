package com.larus.bmhome.instruction.handler;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public final com.larus.bmhome.instruction.p a;
    public final Map<String, m> b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public l(final Fragment r2, com.larus.bmhome.instruction.p r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "instructionCoreAbility");
        this.a = r3;
        this.b = new LinkedHashMap();
        this.c = LazyKt.lazy(new j(r2));
        this.d = LazyKt.lazy(new k(r2));
    }
}
