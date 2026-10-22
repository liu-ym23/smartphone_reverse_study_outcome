package com.larus.bmhome.chat.standarduikit.search.vm;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.SearchVideoItem;
import java.util.List;
import kc8.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final List<SearchVideoItem> a;
    public final ExpandCardViewMode b;
    public final j0 c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final Message g;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        j0 r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.d == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e) * 31;
        if (this.f == true) goto L14;
        r5 = 1237;
    L14:
        int r8 = (r7 + r5) * 31;
        Message r9 = this.g;
        if (r9 == null) goto L19;
        r2 = r9.hashCode();
    L19:
        return r8 + r2;
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PureVideoVMData(videoList=" + this.a + ", videoCardMode=" + this.b + ", columnGridDecorationConfig=" + this.c + ", isOversea=" + this.d + ", columnSize=" + this.e + ", videoInfinite=" + this.f + ", message=" + this.g + ')';
    }

    public a(List r2, ExpandCardViewMode r3, j0 r4, boolean r5, boolean r6, Message r7) {
        Intrinsics.checkNotNullParameter(r2, "videoList");
        Intrinsics.checkNotNullParameter(r3, "videoCardMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = 2;
        this.f = r6;
        this.g = r7;
    }
}
