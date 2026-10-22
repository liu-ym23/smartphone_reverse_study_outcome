package com.larus.bmhome.social.page.datasource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a<T, Key> {
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L8;
        return false;
    L8:
        ((a) r4).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return 38347;
    }

    public final String toString() {
        return "Config(pageSize=0, startKey=null, autoRefresh=false, reusedData=null)";
    }
}
