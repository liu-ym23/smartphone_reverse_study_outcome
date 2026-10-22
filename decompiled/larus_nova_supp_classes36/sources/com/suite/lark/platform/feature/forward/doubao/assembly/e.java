package com.suite.lark.platform.feature.forward.doubao.assembly;

import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Grouping<npc.c, Integer> {
    public final /* synthetic */ Iterable a;

    public final Iterator<npc.c> sourceIterator() {
        return this.a.iterator();
    }

    public e(Iterable r1) {
        this.a = r1;
    }

    public final Integer keyOf(npc.c r1) {
        return Integer.valueOf(r1.e);
    }
}
