package com.larus.bmhome.taskskill.network;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final List<TaskSkill> a;
    public final long b;
    public final String c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "LocalPcPrefetchCacheEntry(skills=" + this.a + ", updateElapsedMs=" + this.b + ", diskKey=" + this.c + ')';
    }

    public e(List<TaskSkill> r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "skills");
        Intrinsics.checkNotNullParameter(r5, "diskKey");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
