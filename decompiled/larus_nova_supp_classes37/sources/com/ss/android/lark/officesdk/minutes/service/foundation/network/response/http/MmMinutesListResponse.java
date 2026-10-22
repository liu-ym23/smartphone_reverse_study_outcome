package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\\\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesListResponse;", "Ljava/io/Serializable;", "total", "", "offset", "timestamp", "", "size", "hasMore", "", "list", "", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "getTimestamp", "()Ljava/lang/String;", "getSize", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesListResponse;", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmMinutesListResponse implements Serializable {

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("list")
    private final List<MmMinutesItem> list;

    @SerializedName("offset")
    private final Integer offset;

    @SerializedName("size")
    private final Integer size;

    @SerializedName("timestamp")
    private final String timestamp;

    @SerializedName("total")
    private final Integer total;

    public MmMinutesListResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmMinutesListResponse copy$default(MmMinutesListResponse r4, Integer r5, Integer r6, String r7, Integer r8, Boolean r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.total;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.offset;
    L8:
        Integer r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.timestamp;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.size;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.hasMore;
    L17:
        Boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.list;
    L20:
        Integer r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Integer component1() {
        return this.total;
    }

    public final Integer component2() {
        return this.offset;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final Integer component4() {
        return this.size;
    }

    public final Boolean component5() {
        return this.hasMore;
    }

    public final List<MmMinutesItem> component6() {
        return this.list;
    }

    public final MmMinutesListResponse copy(Integer r9, Integer r10, String r11, Integer r12, Boolean r13, List<MmMinutesItem> r14) {
        return new MmMinutesListResponse(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmMinutesListResponse) == true) goto L8;
        return false;
    L8:
        MmMinutesListResponse r6 = (MmMinutesListResponse) r5;
        if (Intrinsics.areEqual(this.total, r6.total) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.offset, r6.offset) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timestamp, r6.timestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hasMore, r6.hasMore) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.list, r6.list) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.total;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.offset;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.timestamp;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.size;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.hasMore;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<MmMinutesItem> r16 = this.list;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MmMinutesListResponse(total=" + this.total + ", offset=" + this.offset + ", timestamp=" + this.timestamp + ", size=" + this.size + ", hasMore=" + this.hasMore + ", list=" + this.list + ')';
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final List<MmMinutesItem> getList() {
        return this.list;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public MmMinutesListResponse(Integer r1, Integer r2, String r3, Integer r4, Boolean r5, List<MmMinutesItem> r6) {
        this.total = r1;
        this.offset = r2;
        this.timestamp = r3;
        this.size = r4;
        this.hasMore = r5;
        this.list = r6;
    }

    public /* synthetic */ MmMinutesListResponse(Integer r6, Integer r7, String r8, Integer r9, Boolean r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Integer r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        Integer r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        Boolean r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        List r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
