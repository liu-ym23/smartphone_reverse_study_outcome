package com.bytedance.android.live.ktv.common.view.adapter;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements a {
    public Bitmap a;
    public boolean b;

    @Override // com.bytedance.android.live.ktv.common.view.adapter.a
    public final void a() {
        this.b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        Bitmap r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "UploadImgDataType(bitmap=" + this.a + ", isSelected=" + this.b + ")";
    }

    @Override // com.bytedance.android.live.ktv.common.view.adapter.a
    public final boolean isSelected() {
        return this.b;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L10;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public d(Bitmap r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
