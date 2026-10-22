package com.bytedance.gkfs.io;

import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f4880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f4881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4882c;

    static {
        new File("");
        k r5 = k.d;
        CollectionsKt.emptyList();
    }

    public j(File r5, k r10, List r11) {
        this.f4880a = r5;
        this.f4881b = r10;
        this.f4882c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof j) == false) goto L12;
        j r10 = (j) r5;
        File r11 = r10.f4880a;
        if (Intrinsics.areEqual(this.f4880a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4881b, r10.f4881b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f4882c, r10.f4882c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        File r10 = this.f4880a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        k r13 = this.f4881b;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        List r16 = this.f4882c;
        if (r16 == null) goto L14;
        r5 = r16.hashCode();
    L14:
        return r15 + r5;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSFileMeta(majorFile=" + this.f4880a + ", header=" + this.f4881b + ", chunks=" + this.f4882c + ")";
    }
}
