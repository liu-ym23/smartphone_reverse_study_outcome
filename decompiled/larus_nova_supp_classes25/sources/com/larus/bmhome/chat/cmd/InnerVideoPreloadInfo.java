package com.larus.bmhome.chat.cmd;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JF\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/cmd/InnerVideoPreloadInfo;", "Ljava/io/Serializable;", "reqId", "", "cacheTime", "", "itemIds", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)V", "getReqId", "()Ljava/lang/String;", "setReqId", "(Ljava/lang/String;)V", "getCacheTime", "()Ljava/lang/Long;", "setCacheTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getItemIds", "()Ljava/util/List;", "setItemIds", "(Ljava/util/List;)V", "getMessageId", "setMessageId", "toString", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)Lcom/larus/bmhome/chat/cmd/InnerVideoPreloadInfo;", "equals", "", "other", "", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class InnerVideoPreloadInfo implements Serializable {

    @SerializedName("cache_time")
    private Long cacheTime;

    @SerializedName("item_ids")
    private List<String> itemIds;

    @SerializedName("message_id")
    private String messageId;

    @SerializedName("req_id")
    private String reqId;

    public InnerVideoPreloadInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InnerVideoPreloadInfo copy$default(InnerVideoPreloadInfo r0, String r1, Long r2, List r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.reqId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.cacheTime;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.itemIds;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.messageId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.reqId;
    }

    public final Long component2() {
        return this.cacheTime;
    }

    public final List<String> component3() {
        return this.itemIds;
    }

    public final String component4() {
        return this.messageId;
    }

    public final InnerVideoPreloadInfo copy(String r2, Long r3, List<String> r4, String r5) {
        return new InnerVideoPreloadInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InnerVideoPreloadInfo) == true) goto L8;
        return false;
    L8:
        InnerVideoPreloadInfo r6 = (InnerVideoPreloadInfo) r5;
        if (Intrinsics.areEqual(this.reqId, r6.reqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cacheTime, r6.cacheTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.itemIds, r6.itemIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.reqId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.cacheTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.itemIds;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.messageId;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final Long getCacheTime() {
        return this.cacheTime;
    }

    public final List<String> getItemIds() {
        return this.itemIds;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final void setCacheTime(Long r1) {
        this.cacheTime = r1;
    }

    public final void setItemIds(List<String> r1) {
        this.itemIds = r1;
    }

    public final void setMessageId(String r1) {
        this.messageId = r1;
    }

    public final void setReqId(String r1) {
        this.reqId = r1;
    }

    public InnerVideoPreloadInfo(String r1, Long r2, List<String> r3, String r4) {
        this.reqId = r1;
        this.cacheTime = r2;
        this.itemIds = r3;
        this.messageId = r4;
    }

    public /* synthetic */ InnerVideoPreloadInfo(String r2, Long r3, List r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
