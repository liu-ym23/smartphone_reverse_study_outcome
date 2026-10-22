package com.obric.assistant.special_input;

import com.obric.aiagent.assistant.idl.bean.OSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s0 {
    public final List<OSkill> a;
    public final boolean b;
    public final boolean c;
    public final long d;

    public s0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r9 = (s0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L10;
        r2 = 1237;
    L10:
        long r4 = this.d;
        return ((r3 + r2) * 31) + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SkillCacheSnapshot(skills=" + this.a + ", hasLoaded=" + this.b + ", lastLoadSucceeded=" + this.c + ", version=" + this.d + ')';
    }

    public /* synthetic */ s0(int r7) {
        this(CollectionsKt.emptyList(), false, false, 0);
    }

    public s0(List<OSkill> r2, boolean r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "skills");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
