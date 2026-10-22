package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.RichMediaItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 {
    public final Message a;
    public final String b;
    public final int c;
    public final List<RichMediaItem> d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((r0 + r2) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L11:
        return ((((((r3 + r4) * 31) + this.f) * 31) + this.g) * 31) + this.h;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "RichMediaLayoutVMData(message=" + this.a + ", richMediaBlockId=" + this.b + ", cardPosition=" + this.c + ", sourceItems=" + this.d + ", enableCreationLayoutFallback=" + this.e + ", maxWidth=" + this.f + ", contentPaddingStart=" + this.g + ", contentPaddingEnd=" + this.h + ')';
    }

    public e0(Message r2, String r3, int r4, List<RichMediaItem> r5, boolean r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "sourceItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
