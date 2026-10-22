package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/api/model/ListStyle;", "", "symbolStrategy", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "enableListInLooseListMargin", "", "(Lcom/larus/business/markdown/api/model/ListSymbolStrategy;Z)V", "getEnableListInLooseListMargin", "()Z", "getSymbolStrategy", "()Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListStyle {
    private final boolean enableListInLooseListMargin;
    private final g symbolStrategy;

    /* JADX WARN: Multi-variable type inference failed */
    public ListStyle() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public ListStyle(g r3, boolean r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "symbolStrategy");
        this.symbolStrategy = r5;
        this.enableListInLooseListMargin = r4;
    }

    public /* synthetic */ ListStyle(g r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = (g) ZeusTransformUtils.preCheckCast(new g.a(), g.class, "com.obric.memorydata.plugin");
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r6, r3);
    }

    public static /* synthetic */ ListStyle copy$default(ListStyle r1, g r2, boolean r3, int r4, Object r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.symbolStrategy;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.enableListInLooseListMargin;
    L9:
        return r1.copy(r6, r3);
    }

    public final g component1() {
        return this.symbolStrategy;
    }

    public final boolean component2() {
        return this.enableListInLooseListMargin;
    }

    public final ListStyle copy(g r2, boolean r3) {
        g r1 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "symbolStrategy");
        return new ListStyle(r1, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ListStyle.class) == true) goto L8;
        return false;
    L8:
        ListStyle r6 = (ListStyle) ZeusTransformUtils.preCheckCast(r5, ListStyle.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.symbolStrategy, r6.symbolStrategy) == true) goto L12;
        return false;
    L12:
        if (this.enableListInLooseListMargin == r6.enableListInLooseListMargin) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean getEnableListInLooseListMargin() {
        return this.enableListInLooseListMargin;
    }

    public final g getSymbolStrategy() {
        return this.symbolStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int r0 = this.symbolStrategy.hashCode() * 31;
        boolean r1 = this.enableListInLooseListMargin;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public String toString() {
        return "ListStyle(symbolStrategy=" + this.symbolStrategy + ", enableListInLooseListMargin=" + this.enableListInLooseListMargin + ')';
    }
}
