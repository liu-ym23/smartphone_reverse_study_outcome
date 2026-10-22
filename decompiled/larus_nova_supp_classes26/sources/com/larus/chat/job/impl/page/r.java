package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r implements Grouping<AIJob, Integer> {
    public final /* synthetic */ Iterable a;

    public final Iterator<AIJob> sourceIterator() {
        return this.a.iterator();
    }

    public r(Iterable r1) {
        this.a = r1;
    }

    public final Integer keyOf(AIJob r1) {
        return Integer.valueOf(r1.getStatus());
    }
}
