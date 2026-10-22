package com.larus.bmhome.upload.instant;

import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import kotlin.jvm.internal.Intrinsics;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final l a;
    public final ResourceInstantUploadInfo b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ImageInstantUploadHit(uploadResult=" + this.a + ", registerInfo=" + this.b + ')';
    }

    public b(l r2, ResourceInstantUploadInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "uploadResult");
        Intrinsics.checkNotNullParameter(r3, "registerInfo");
        this.a = r2;
        this.b = r3;
    }
}
