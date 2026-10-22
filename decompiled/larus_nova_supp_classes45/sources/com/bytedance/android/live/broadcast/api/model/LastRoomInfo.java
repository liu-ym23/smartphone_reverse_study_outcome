package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0015J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/LastRoomInfo;", "Ljava/io/Serializable;", "roomId", "", "roomIdStr", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getRoomId", "()Ljava/lang/Integer;", "setRoomId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRoomIdStr", "()Ljava/lang/String;", "setRoomIdStr", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/live/broadcast/api/model/LastRoomInfo;", "equals", "", "other", "", "hashCode", "isEmpty", "toString", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LastRoomInfo implements Serializable {

    @SerializedName("last_room_id")
    private Integer roomId;

    @SerializedName("last_room_id_str")
    private String roomIdStr;

    /* JADX WARN: Multi-variable type inference failed */
    public LastRoomInfo() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LastRoomInfo copy$default(LastRoomInfo r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.roomId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.roomIdStr;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.roomIdStr;
    }

    public final LastRoomInfo copy(Integer r2, String r3) {
        return new LastRoomInfo(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LastRoomInfo) == false) goto L10;
        LastRoomInfo r4 = (LastRoomInfo) r3;
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomIdStr, r4.roomIdStr) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.roomId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.roomIdStr;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LastRoomInfo(roomId=" + this.roomId + ", roomIdStr=" + this.roomIdStr + ")";
    }

    public final boolean isEmpty() {
        Integer r0 = this.roomId;
        if (r0 == null) goto L19;
        if (r0 != null) goto L7;
    L8:
        String r1 = this.roomIdStr;
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L21;
        return false;
    L21:
        return true;
    L11:
        if (r1.length() == 0) goto L14;
        r2 = false;
        goto L15
    L7:
        if (r0.intValue() != 0) goto L8;
        return true;
    L19:
        return true;
    }

    public final Integer getRoomId() {
        return this.roomId;
    }

    public final String getRoomIdStr() {
        return this.roomIdStr;
    }

    public final void setRoomId(Integer r1) {
        this.roomId = r1;
    }

    public final void setRoomIdStr(String r1) {
        this.roomIdStr = r1;
    }

    public LastRoomInfo(Integer r1, String r2) {
        this.roomId = r1;
        this.roomIdStr = r2;
    }

    public /* synthetic */ LastRoomInfo(Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
