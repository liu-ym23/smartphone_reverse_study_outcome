package com.larus.uaigc.instruction;

import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 implements Grouping<CreationReferenceMediaType, CreationReferenceMediaType> {
    public final /* synthetic */ Iterable a;

    public final Iterator<CreationReferenceMediaType> sourceIterator() {
        return this.a.iterator();
    }

    public h0(Iterable r1) {
        this.a = r1;
    }

    public final CreationReferenceMediaType keyOf(CreationReferenceMediaType r1) {
        return r1;
    }
}
