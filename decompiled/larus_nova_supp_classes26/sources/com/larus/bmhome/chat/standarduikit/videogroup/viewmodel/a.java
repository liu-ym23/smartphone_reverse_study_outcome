package com.larus.bmhome.chat.standarduikit.videogroup.viewmodel;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zn8.l;
import zn8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final l a;
    public final List<q> b;
    public final Message c;
    public final Integer d;
    public final boolean e;

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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Message r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.d;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        if (this.e == false) goto L13;
        int r7 = 1231;
    L15:
        return r6 + r7;
    L13:
        r7 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "RelatedVideoVMData(sizeData=" + this.a + ", videoDataList=" + this.b + ", message=" + this.c + ", cardPosition=" + this.d + ", videoInfinite=" + this.e + ')';
    }

    public final String a() {
        Message r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageId();
    }

    public a(l r2, List<q> r3, Message r4, Integer r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "sizeData");
        Intrinsics.checkNotNullParameter(r3, "videoDataList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
