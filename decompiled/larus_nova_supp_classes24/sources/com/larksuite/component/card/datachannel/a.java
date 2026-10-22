package com.larksuite.component.card.datachannel;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final UniversalCardEntity a;
    public final boolean b;

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
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "GetCardEntityResponse(universalCardEntity=" + this.a + ", isFromCache=" + this.b + ')';
    }

    public a(UniversalCardEntity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "universalCardEntity");
        this.a = r2;
        this.b = r3;
    }
}
