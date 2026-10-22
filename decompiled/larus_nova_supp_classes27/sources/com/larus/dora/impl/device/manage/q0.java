package com.larus.dora.impl.device.manage;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q0 implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final boolean e;

    public q0() {
        this(false, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r6 = (q0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraGDeviceManagementMediaAlbumItem(id=" + this.a + ", title=" + this.b + ", actionText=" + this.c + ", imageUrls=" + this.d + ", isEmptyState=" + this.e + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public q0(boolean r6, int r7) {
        List<String> r1 = null;
        if ((r7 & 1) == 0) goto L5;
        String r0 = "DoraGDeviceManagementMediaAlbumItem";
    L7:
        if ((r7 & 2) == 0) goto L9;
        int r2 = com.larus.utils.j0.a;
        String r3 = com.larus.utils.j0.d(2131902082);
    L11:
        if ((r7 & 4) == 0) goto L13;
        int r4 = com.larus.utils.j0.a;
        String r5 = com.larus.utils.j0.d(2131902657);
    L15:
        if ((r7 & 8) == 0) goto L18;
        r1 = CollectionsKt.emptyList();
    L18:
        if ((r7 & 16) == 0) goto L20;
        r6 = false;
    L20:
        Intrinsics.checkNotNullParameter(r0, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r5, "actionText");
        Intrinsics.checkNotNullParameter(r1, "imageUrls");
        this.a = r0;
        this.b = r3;
        this.c = r5;
        this.d = r1;
        this.e = r6;
        return;
    L13:
        r5 = null;
        goto L15
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
