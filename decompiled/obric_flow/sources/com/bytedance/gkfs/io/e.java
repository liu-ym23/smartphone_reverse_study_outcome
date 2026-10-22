package com.bytedance.gkfs.io;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f4862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f4863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f4864c;

    static {
        d = new e(MapsKt.emptyMap(), MapsKt.emptyMap());
    }

    public e(Map r5, Map r10) {
        this.f4863b = r5;
        this.f4864c = r10;
        Set r11 = r10.entrySet();
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r11)), 16));
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Map.Entry) r13.next();
        Pair r15 = TuplesKt.to(r14.getKey(), Long.valueOf(((com.bytedance.gkfs.storage.e) r14.getValue()).e.f));
        r12.put(r15.getFirst(), r15.getSecond());
        goto L4
    L6:
        this.f4862a = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e) == false) goto L10;
        e r10 = (e) r5;
        Map r11 = r10.f4863b;
        if (Intrinsics.areEqual(this.f4863b, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4864c, r10.f4864c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        Map r10 = this.f4863b;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        Map r13 = this.f4864c;
        if (r13 == null) goto L10;
        r5 = r13.hashCode();
    L10:
        return r12 + r5;
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSChunkIOStatistics(timeCost=" + this.f4863b + ", storageCost=" + this.f4864c + ", indexTimeCost=" + this.f4862a + ')';
    }
}
