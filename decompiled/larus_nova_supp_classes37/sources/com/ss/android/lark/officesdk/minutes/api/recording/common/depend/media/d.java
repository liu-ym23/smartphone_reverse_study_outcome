package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final c a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MmAINoteGalleryPreviewItem(image=" + this.a + ')';
    }

    public d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "image");
        this.a = r2;
    }
}
