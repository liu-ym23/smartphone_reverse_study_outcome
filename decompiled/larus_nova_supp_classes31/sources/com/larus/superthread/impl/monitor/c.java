package com.larus.superthread.impl.monitor;

import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements Grouping<Thread, String> {
    public final /* synthetic */ Iterable a;

    public final Iterator<Thread> sourceIterator() {
        return this.a.iterator();
    }

    public c(Iterable r1) {
        this.a = r1;
    }

    public final String keyOf(Thread r1) {
        return r1.getName();
    }
}
