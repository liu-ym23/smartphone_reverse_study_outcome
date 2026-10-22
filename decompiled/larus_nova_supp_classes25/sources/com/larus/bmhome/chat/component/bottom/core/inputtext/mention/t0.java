package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JS\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionQueryDomain;", "", "domainKey", "", "domainType", "", "items", "", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionQueryItem;", "hasMore", "", "nextCursor", "errCode", "", "<init>", "(Ljava/lang/String;ILjava/util/List;ZLjava/lang/String;J)V", "getDomainKey", "()Ljava/lang/String;", "getDomainType", "()I", "getItems", "()Ljava/util/List;", "getHasMore", "()Z", "getNextCursor", "getErrCode", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final class t0 {

    @SerializedName("domain_key")
    private final String domainKey;

    @SerializedName("domain_type")
    private final int domainType;

    @SerializedName("err_code")
    private final long errCode;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("items")
    private final List<u0> items;

    @SerializedName("next_cursor")
    private final String nextCursor;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r9 = (t0) r8;
        if (Intrinsics.areEqual(this.domainKey, r9.domainKey) == true) goto L12;
        return false;
    L12:
        if (this.domainType == r9.domainType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.items, r9.items) == true) goto L18;
        return false;
    L18:
        if (this.hasMore == r9.hasMore) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nextCursor, r9.nextCursor) == true) goto L24;
        return false;
    L24:
        if (this.errCode == r9.errCode) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.domainKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.domainType) * 31;
        List<u0> r4 = this.items;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.hasMore == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        String r9 = this.nextCursor;
        if (r9 == null) goto L18;
        r1 = r9.hashCode();
    L18:
        int r10 = (r8 + r1) * 31;
        long r11 = this.errCode;
        return r10 + ((int) (r11 ^ (r11 >>> 32)));
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionQueryDomain(domainKey=" + this.domainKey + ", domainType=" + this.domainType + ", items=" + this.items + ", hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ", errCode=" + this.errCode + ')';
    }

    public t0() {
        List<u0> r0 = CollectionsKt.emptyList();
        this.domainKey = null;
        this.domainType = 0;
        this.items = r0;
        this.hasMore = false;
        this.nextCursor = null;
        this.errCode = 0;
    }

    public final String a() {
        return this.domainKey;
    }

    public final int b() {
        return this.domainType;
    }

    public final long c() {
        return this.errCode;
    }

    public final boolean d() {
        return this.hasMore;
    }

    public final List<u0> e() {
        return this.items;
    }

    public final String f() {
        return this.nextCursor;
    }
}
