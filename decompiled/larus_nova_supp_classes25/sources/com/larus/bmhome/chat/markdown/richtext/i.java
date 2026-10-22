package com.larus.bmhome.chat.markdown.richtext;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final String a;
    public final List<g> b;
    public final List<h> c;
    public final List<j> d;
    public final List<String> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "MessageMarkdownParseResult(displayText=" + this.a + ", linkSpans=" + this.b + ", mentionSpans=" + this.c + ", resourceSpans=" + this.d + ", previewUrls=" + this.e + ')';
    }

    public final boolean a() {
        if ((!this.b.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!this.c.isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!this.d.isEmpty()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public /* synthetic */ i(String r7, List r8, List r9, int r10) {
        if ((r10 & 2) == 0) goto L5;
        r8 = CollectionsKt.emptyList();
    L5:
        List r2 = r8;
        if ((r10 & 4) == 0) goto L8;
        List r3 = CollectionsKt.emptyList();
    L10:
        if ((r10 & 8) == 0) goto L12;
        List r4 = CollectionsKt.emptyList();
    L14:
        if ((r10 & 16) == 0) goto L16;
        r9 = CollectionsKt.emptyList();
    L16:
        this(r7, r2, r3, r4, r9);
        return;
    L12:
        r4 = null;
        goto L14
    L8:
        r3 = null;
        goto L10
    }

    public i(String r2, List<g> r3, List<h> r4, List<j> r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "displayText");
        Intrinsics.checkNotNullParameter(r3, "linkSpans");
        Intrinsics.checkNotNullParameter(r4, "mentionSpans");
        Intrinsics.checkNotNullParameter(r5, "resourceSpans");
        Intrinsics.checkNotNullParameter(r6, "previewUrls");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
