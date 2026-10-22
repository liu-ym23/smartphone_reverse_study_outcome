package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.gson.TimeTransformAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/resp/ChatLimit;", "", "isLimit", "", "limitTime", "", "limitTips", "", "<init>", "(ZJLjava/lang/String;)V", "()Z", "getLimitTime", "()J", "getLimitTips", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatLimit {

    @SerializedName("is_limit")
    private final boolean isLimit;

    @SerializedName("limit_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private final long limitTime;

    @SerializedName("limit_tips")
    private final String limitTips;

    public ChatLimit() {
        this(false, 0, null, 7, null);
    }

    public static /* synthetic */ ChatLimit copy$default(ChatLimit r0, boolean r1, long r2, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.isLimit;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.limitTime;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.limitTips;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final boolean component1() {
        return this.isLimit;
    }

    public final long component2() {
        return this.limitTime;
    }

    public final String component3() {
        return this.limitTips;
    }

    public final ChatLimit copy(boolean r2, long r3, String r5) {
        return new ChatLimit(r2, r3, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatLimit) == true) goto L8;
        return false;
    L8:
        ChatLimit r9 = (ChatLimit) r8;
        if (this.isLimit == r9.isLimit) goto L12;
        return false;
    L12:
        if (this.limitTime == r9.limitTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.limitTips, r9.limitTips) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.isLimit == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.limitTime;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.limitTips;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ChatLimit(isLimit=" + this.isLimit + ", limitTime=" + this.limitTime + ", limitTips=" + this.limitTips + ')';
    }

    public final long getLimitTime() {
        return this.limitTime;
    }

    public final String getLimitTips() {
        return this.limitTips;
    }

    public final boolean isLimit() {
        return this.isLimit;
    }

    public ChatLimit(boolean r1, long r2, String r4) {
        this.isLimit = r1;
        this.limitTime = r2;
        this.limitTips = r4;
    }

    public /* synthetic */ ChatLimit(boolean r1, long r2, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 60000;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "LIMITING";
    L11:
        this(r1, r2, r4);
    }
}
