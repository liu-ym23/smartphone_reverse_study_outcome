package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface c1 extends Map {
    Object forcePut(Object r5, Object r10);

    c1 inverse();

    @Override // java.util.Map, com.google.common.collect.c1
    Set values();
}
