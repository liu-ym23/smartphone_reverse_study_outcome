package com.larksuite.component.card.resources;

import com.larksuite.component.card.protocol.data.media.VisitInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final CardResource.ResourceType a;
    public final String b;
    public final VisitInfo c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        VisitInfo r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CardResourceParams(type=" + this.a + ", fileKey=" + this.b + ", visitInfo=" + this.c + ')';
    }

    public final CardResource.ResourceType getType() {
        return this.a;
    }

    public b(CardResource.ResourceType r2, String r3, VisitInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "fileKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
