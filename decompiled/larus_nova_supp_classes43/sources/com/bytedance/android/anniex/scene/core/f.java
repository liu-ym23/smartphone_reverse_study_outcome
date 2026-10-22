package com.bytedance.android.anniex.scene.core;

import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements Grouping<k, String> {
    public final /* synthetic */ Iterable a;

    public final Iterator<k> sourceIterator() {
        return this.a.iterator();
    }

    public f(Iterable r1) {
        this.a = r1;
    }

    public final String keyOf(k r1) {
        return r1.a;
    }
}
