package com.bytedance.android.live.revlink.link.core.layoutstatus;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Comparator {
    public final /* synthetic */ AnchorPositionSnapShot a;
    public final /* synthetic */ o51.e b;

    public a(AnchorPositionSnapShot r1, o51.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.Comparator
    public final int compare(Object r2, Object r3) {
        String r4 = (String) r2;
        String r5 = (String) r3;
        if (Intrinsics.areEqual(r4, o51.g.b(this.b)) == false) goto L6;
    L10:
        return -1;
    L6:
        if (Intrinsics.areEqual(r5, o51.g.b(this.b)) == false) goto L9;
    L13:
        return 1;
    L9:
        if (Intrinsics.areEqual(r4, this.a.g.d.k) == true) goto L10;
        if (Intrinsics.areEqual(r5, this.a.g.d.k) == true) goto L13;
        return 0;
    }
}
