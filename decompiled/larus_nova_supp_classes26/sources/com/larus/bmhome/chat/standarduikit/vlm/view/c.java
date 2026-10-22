package com.larus.bmhome.chat.standarduikit.vlm.view;

import com.larus.im.bean.message.MixerMedia;
import com.larus.im.bean.message.VLMImage;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final VLMImage a;
    public final MixerMedia b;
    public final int c;
    public final List<Integer> d;

    public c() {
        this(null, null, 0, null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        VLMImage r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        MixerMedia r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.c) * 31) + this.d.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "OriginalMediaData(image=" + this.a + ", mixedMedia=" + this.b + ", indexInOriginList=" + this.c + ", moreImageIndexListInOriginList=" + this.d + ')';
    }

    public c(VLMImage r3, MixerMedia r4, int r5, List r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = CollectionsKt.emptyList();
    L14:
        Intrinsics.checkNotNullParameter(r6, "moreImageIndexListInOriginList");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
