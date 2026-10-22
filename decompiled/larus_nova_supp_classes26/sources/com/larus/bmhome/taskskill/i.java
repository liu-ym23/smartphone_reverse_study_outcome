package com.larus.bmhome.taskskill;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public String a;
    public boolean b;
    public Set<String> c;

    public i(String r3) {
        Set<String> r0 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a = r3;
        this.b = false;
        this.c = r0;
    }
}
