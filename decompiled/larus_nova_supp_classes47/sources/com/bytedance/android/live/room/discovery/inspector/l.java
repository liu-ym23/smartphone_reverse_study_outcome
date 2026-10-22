package com.bytedance.android.live.room.discovery.inspector;

import android.text.Spannable;
import com.bytedance.android.live.base.model.ImageModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final boolean a;
    public final ImageModel b;
    public final int c;
    public final int d;
    public final Spannable e;
    public final Spannable f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L18;
        l r4 = (l) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        ImageModel r3 = this.b;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (((((r2 + r5) * 31) + this.c) * 31) + this.d) * 31;
        Spannable r7 = this.e;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        Spannable r10 = this.f;
        if (r10 == null) goto L17;
        r4 = r10.hashCode();
    L17:
        return r9 + r4;
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "OfficialInspectorWidgetConfig(isAnimation=" + this.a + ", actionIcon=" + this.b + ", foldDuration=" + this.c + ", displayDuration=" + this.d + ", animTitle=" + this.e + ", suffixTitle=" + this.f + ")";
    }

    public l(boolean r2, ImageModel r3, int r4, int r5, Spannable r6, Spannable r7) {
        Intrinsics.checkNotNullParameter(r6, "animTitle");
        Intrinsics.checkNotNullParameter(r7, "suffixTitle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
