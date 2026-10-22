package com.larus.dora.impl.dynamic;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/dynamic/NavBar;", "", "centerItem", "Lcom/larus/dora/impl/dynamic/NavItem;", "rightItem", "Lcom/larus/dora/impl/dynamic/ActionImageLink;", "<init>", "(Lcom/larus/dora/impl/dynamic/NavItem;Lcom/larus/dora/impl/dynamic/ActionImageLink;)V", "getCenterItem", "()Lcom/larus/dora/impl/dynamic/NavItem;", "setCenterItem", "(Lcom/larus/dora/impl/dynamic/NavItem;)V", "getRightItem", "()Lcom/larus/dora/impl/dynamic/ActionImageLink;", "setRightItem", "(Lcom/larus/dora/impl/dynamic/ActionImageLink;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w1 {

    @SerializedName("center_item")
    private x1 centerItem;

    @SerializedName("right_item")
    private a rightItem;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w1) == true) goto L8;
        return false;
    L8:
        w1 r6 = (w1) r5;
        if (Intrinsics.areEqual(this.centerItem, r6.centerItem) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightItem, r6.rightItem) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        x1 r0 = this.centerItem;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        a r4 = this.rightItem;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavBar(centerItem=" + this.centerItem + ", rightItem=" + this.rightItem + ')';
    }

    public w1() {
        this.centerItem = null;
        this.rightItem = null;
    }
}
