package com.bytedance.android.ec.core.imagex.opt;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EditableNode {
    public final Lazy a;
    public EditableNode b;
    public final String c;
    public final yl.e d;
    public final p0 e;
    public final List<com.bytedance.android.ec.core.imagex.opt.a> f;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        String r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        yl.e r12 = this.d;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        p0 r15 = this.e;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        List<com.bytedance.android.ec.core.imagex.opt.a> r18 = this.f;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "EditableNode(pathNodeName=" + this.c + ", match=" + this.d + ", nodeType=" + this.e + ", arrayMatch=" + this.f + ")";
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof EditableNode) == false) goto L14;
        EditableNode r11 = (EditableNode) r10;
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public EditableNode(String r10, yl.e r11, p0 r12, List<com.bytedance.android.ec.core.imagex.opt.a> r13) {
        Intrinsics.checkNotNullParameter(r10, "pathNodeName");
        Intrinsics.checkNotNullParameter(r12, "nodeType");
        Intrinsics.checkNotNullParameter(r13, "arrayMatch");
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new EditableNode$nodeId$2(this));
    }
}
