package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/bean/UpdateWcbSuggestsRequest;", "", "userId", "", "messageId", "suggests", "isFirstMet", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getMessageId", "setMessageId", "getSuggests", "setSuggests", "()Ljava/lang/Boolean;", "setFirstMet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/bean/UpdateWcbSuggestsRequest;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class UpdateWcbSuggestsRequest {

    @SerializedName("is_first_met")
    private Boolean isFirstMet;

    @SerializedName("message_id")
    private String messageId;

    @SerializedName("new_suggests")
    private String suggests;

    @SerializedName("user_id")
    private String userId;

    public UpdateWcbSuggestsRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ UpdateWcbSuggestsRequest copy$default(UpdateWcbSuggestsRequest r0, String r1, String r2, String r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.userId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.messageId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.suggests;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isFirstMet;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.suggests;
    }

    public final Boolean component4() {
        return this.isFirstMet;
    }

    public final UpdateWcbSuggestsRequest copy(String r2, String r3, String r4, Boolean r5) {
        return new UpdateWcbSuggestsRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UpdateWcbSuggestsRequest) == true) goto L8;
        return false;
    L8:
        UpdateWcbSuggestsRequest r6 = (UpdateWcbSuggestsRequest) r5;
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.suggests, r6.suggests) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isFirstMet, r6.isFirstMet) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.userId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.messageId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.suggests;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isFirstMet;
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
        return "UpdateWcbSuggestsRequest(userId=" + this.userId + ", messageId=" + this.messageId + ", suggests=" + this.suggests + ", isFirstMet=" + this.isFirstMet + ')';
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getSuggests() {
        return this.suggests;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isFirstMet() {
        return this.isFirstMet;
    }

    public final void setFirstMet(Boolean r1) {
        this.isFirstMet = r1;
    }

    public final void setMessageId(String r1) {
        this.messageId = r1;
    }

    public final void setSuggests(String r1) {
        this.suggests = r1;
    }

    public final void setUserId(String r1) {
        this.userId = r1;
    }

    public UpdateWcbSuggestsRequest(String r1, String r2, String r3, Boolean r4) {
        this.userId = r1;
        this.messageId = r2;
        this.suggests = r3;
        this.isFirstMet = r4;
    }

    public /* synthetic */ UpdateWcbSuggestsRequest(String r2, String r3, String r4, Boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = Boolean.TRUE;
    L14:
        this(r2, r3, r4, r5);
    }
}
