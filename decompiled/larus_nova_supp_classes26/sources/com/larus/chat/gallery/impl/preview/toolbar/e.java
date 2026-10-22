package com.larus.chat.gallery.impl.preview.toolbar;

import com.larus.bmhome.share.panel.ShareChannel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final List<String> a;
    public final List<String> b;
    public final List<String> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "PreviewToolbarItems(ordered=" + this.a + ", more=" + this.b + ", emphasized=" + this.c + ')';
    }

    public e(List<String> r2, List<String> r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "ordered");
        Intrinsics.checkNotNullParameter(r3, ShareChannel.MORE);
        Intrinsics.checkNotNullParameter(r4, "emphasized");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
