package com.bytedance.pia.nsr;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f7200a = null;

    static {
        f7200a = new k();
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        return Intrinsics.compare(((Number) ((Pair) r5).getFirst()).longValue(), ((Number) ((Pair) r10).getFirst()).longValue());
    }
}
