package com.larus.bmhome.chat.standarduikit.vlm.view;

import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Boolean a;
    public final FlowVLMContainerViewType b;
    public final List<l> c;
    public final do8.j d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowVLMContainerViewInput(enableShimmer=" + this.a + ", flowVLMContainerViewType=" + this.b + ", mediaList=" + this.c + ", uiConfig=" + this.d + ')';
    }

    public a(Boolean r2, FlowVLMContainerViewType r3, List<l> r4, do8.j r5) {
        Intrinsics.checkNotNullParameter(r3, "flowVLMContainerViewType");
        Intrinsics.checkNotNullParameter(r4, "mediaList");
        Intrinsics.checkNotNullParameter(r5, "uiConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
