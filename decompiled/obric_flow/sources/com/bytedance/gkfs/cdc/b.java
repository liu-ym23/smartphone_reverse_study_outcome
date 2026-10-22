package com.bytedance.gkfs.cdc;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f4822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cb.a f4824c;
    public final c d;

    public b(File r5, List r10, cb.a r11, c r12) {
        this.f4822a = r5;
        this.f4823b = r10;
        this.f4824c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.f4822a, r11.f4822a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4823b, r11.f4823b) == true) goto L14;
        return false;
    L14:
        cb.a r5 = this.f4824c;
        r5.getClass();
        cb.a r12 = r11.f4824c;
        if (r5 == r12) goto L27;
        if (r5.f1168c != r12.f1168c) goto L24;
        LinkedList r13 = r5.f1167b;
        int r14 = r13.size();
        int r15 = 0;
    L21:
        if (r15 >= r14) goto L27;
        if (Arrays.equals((byte[]) r13.get(r15), (byte[]) r12.f1167b.get(r15)) == false) goto L24;
        r15 = r15 + 1;
    L24:
        return false;
    L27:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f4822a.hashCode() * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.f(this.f4823b, r5, 31);
        int r11 = (this.f4824c.f1167b.hashCode() + r10) * 31;
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        return "GkFSCDCInfo(file=" + this.f4822a + ", chunks=" + this.f4823b + ", tailBytes=" + this.f4824c + ", statistics=" + this.d + ")";
    }
}
