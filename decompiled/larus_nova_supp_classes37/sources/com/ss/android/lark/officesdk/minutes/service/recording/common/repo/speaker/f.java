package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final boolean a;
    public final Map<String, c> b;
    public final Set<String> c;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingSpeakerEntity(isSpeakerMarkingEnabled=" + this.a + ", markedSpeakerMap=" + this.b + ", noMappingClusterIds=" + this.c + ')';
    }

    public /* synthetic */ f(int r3) {
        this(false, MapsKt.emptyMap(), SetsKt.emptySet());
    }

    public f(boolean r2, Map<String, c> r3, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "markedSpeakerMap");
        Intrinsics.checkNotNullParameter(r4, "noMappingClusterIds");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static f a(f r1, boolean r2, Map r3, Set r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = r1.c;
    L11:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "markedSpeakerMap");
        Intrinsics.checkNotNullParameter(r4, "noMappingClusterIds");
        return new f(r2, r3, r4);
    }
}
