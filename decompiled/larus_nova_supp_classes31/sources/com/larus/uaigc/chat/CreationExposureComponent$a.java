package com.larus.uaigc.chat;

import com.larus.bmhome.chat.component.creation.CreationExposureMediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationExposureComponent$a {
    public final CreationExposureMediaType a;
    public final String b;
    public final String c;
    public final float d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationExposureComponent$a) == true) goto L8;
        return false;
    L8:
        CreationExposureComponent$a r6 = (CreationExposureComponent$a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d);
    }

    public final String toString() {
        return "ExposureKey(mediaType=" + this.a + ", messageId=" + this.b + ", creationItemId=" + this.c + ", percentage=" + this.d + ')';
    }

    public CreationExposureComponent$a(CreationExposureMediaType r2, String r3, String r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "mediaType");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "creationItemId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
