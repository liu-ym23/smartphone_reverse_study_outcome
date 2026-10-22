package com.larus.doc.impl.operation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/doc/impl/operation/PublishResponse;", "", "link", "", "isOpen", "", "isFirstOpen", "<init>", "(Ljava/lang/String;ZZ)V", "getLink", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("is_first_open")
    private final boolean isFirstOpen;

    @SerializedName("is_open")
    private final boolean isOpen;

    @SerializedName("url")
    private final String link;

    public p() {
        this(null, false, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.link, r6.link) == true) goto L12;
        return false;
    L12:
        if (this.isOpen == r6.isOpen) goto L15;
        return false;
    L15:
        if (this.isFirstOpen == r6.isFirstOpen) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.link;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        int r3 = 1231;
        if (this.isOpen == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.isFirstOpen == true) goto L15;
        r3 = 1237;
    L15:
        return r5 + r3;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublishResponse(link=" + this.link + ", isOpen=" + this.isOpen + ", isFirstOpen=" + this.isFirstOpen + ')';
    }

    public final String a() {
        return this.link;
    }

    public final boolean b() {
        return this.isOpen;
    }

    public p(String r2, boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this.link = r2;
        this.isOpen = r3;
        this.isFirstOpen = false;
    }
}
