package vz1;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.ImageType;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public final ImageType a;
    public final k b;
    public final k c;
    public final Bitmap d;

    public i() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L14;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ImageType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        k r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        k r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Bitmap r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShowImageInfo(type=" + this.a + ", model=" + this.b + ", dynamicImageModel=" + this.c + ", bitMap=" + this.d + ")";
    }

    public final ImageType getType() {
        return this.a;
    }

    public i(ImageType r3, k r4, k r5, Bitmap r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = ImageType.ImageModel;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
