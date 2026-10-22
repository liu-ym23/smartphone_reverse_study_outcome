package mq8;

import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a$b implements Grouping<String, String> {
    public final /* synthetic */ Iterable a;

    public final Iterator<String> sourceIterator() {
        return this.a.iterator();
    }

    public a$b(Iterable r1) {
        this.a = r1;
    }

    public final String keyOf(String r1) {
        return r1;
    }
}
