package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;", "", "enableScroll", "", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "codeTextColor", "", "(ZLio/noties/markwon/scrollable/HorizontalScrollable;Lio/noties/markwon/scrollable/ScrollBarTheme;I)V", "getCodeTextColor", "()I", "getEnableScroll", "()Z", "getScrollBarTheme", "()Lio/noties/markwon/scrollable/ScrollBarTheme;", "getScrollable", "()Lio/noties/markwon/scrollable/HorizontalScrollable;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final io.noties.markwon.scrollable.b f5203b;
    private final io.noties.markwon.scrollable.e c;
    private final int d;

    public b(boolean r2, io.noties.markwon.scrollable.b r3, io.noties.markwon.scrollable.e r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "scrollBarTheme");
        this.f5202a = r2;
        this.f5203b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final boolean a() {
        return this.f5202a;
    }

    public final io.noties.markwon.scrollable.b b() {
        return this.f5203b;
    }

    public final io.noties.markwon.scrollable.e c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f5202a == r6.f5202a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5203b, r6.f5203b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean r0 = this.f5202a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        io.noties.markwon.scrollable.b r3 = this.f5203b;
        if (r3 != null) goto L8;
        int r4 = 0;
    L10:
        return ((((r2 + r4) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d);
    L8:
        r4 = r3.hashCode();
        goto L10
    }

    public String toString() {
        return "CodeBlockScrollableInfo(enableScroll=" + this.f5202a + ", scrollable=" + this.f5203b + ", scrollBarTheme=" + this.c + ", codeTextColor=" + this.d + ')';
    }
}
