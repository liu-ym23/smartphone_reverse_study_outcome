package com.lynx.tasm.fontface;

import android.util.Pair;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final ConcurrentLinkedQueue<Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer>> a;
    public final Set<FontFace> b;

    public a() {
        this.a = new ConcurrentLinkedQueue();
        this.b = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
