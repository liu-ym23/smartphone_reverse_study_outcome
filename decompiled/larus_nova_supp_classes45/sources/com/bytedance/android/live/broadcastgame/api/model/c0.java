package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "", "", "gameId", "Ljava/lang/String;", "gameName", "gameIcon", "gameType", "taskId", "taskName", "", "taskStatus", "Ljava/lang/Integer;", "schema", "", "hasTask", "Ljava/lang/Boolean;", "taskChange", "originTaskId", "taskPrice", "bidMetaTag", "cpsRatio", "bidType", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {
    public String a;
    public boolean b;

    @SerializedName("bid_meta_tag")
    public String bidMetaTag;

    @SerializedName("bid_type")
    public Integer bidType;

    @SerializedName("cps_ratio")
    public Integer cpsRatio;

    @SerializedName("game_icon")
    public String gameIcon;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("game_name")
    public String gameName;

    @SerializedName("game_type")
    public String gameType;

    @SerializedName("is_has_task")
    public Boolean hasTask;

    @SerializedName("origin_task_id")
    public String originTaskId;

    @SerializedName("schema")
    public String schema;

    @SerializedName("is_change_task")
    public Boolean taskChange;

    @SerializedName("task_id")
    public String taskId;

    @SerializedName("task_name")
    public String taskName;

    @SerializedName("task_price")
    public Integer taskPrice;

    @SerializedName("task_status")
    public Integer taskStatus;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c0) == false) goto L36;
        c0 r4 = (c0) r3;
        if (Intrinsics.areEqual(this.gameId, r4.gameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gameName, r4.gameName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.gameIcon, r4.gameIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.gameType, r4.gameType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.taskId, r4.taskId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.taskName, r4.taskName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskStatus, r4.taskStatus) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.hasTask, r4.hasTask) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskChange, r4.taskChange) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.originTaskId, r4.originTaskId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.taskPrice, r4.taskPrice) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bidMetaTag, r4.bidMetaTag) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.cpsRatio, r4.cpsRatio) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.bidType, r4.bidType) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        String r0 = this.gameId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.gameName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.gameIcon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.gameType;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.taskId;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.taskName;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r21 = this.taskStatus;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        String r24 = this.schema;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        Boolean r27 = this.hasTask;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        Boolean r31 = this.taskChange;
        if (r31 == null) goto L41;
        int r32 = r31.hashCode();
    L42:
        int r33 = (r29 + r32) * 31;
        String r34 = this.originTaskId;
        if (r34 == null) goto L45;
        int r35 = r34.hashCode();
    L46:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.taskPrice;
        if (r37 == null) goto L49;
        int r38 = r37.hashCode();
    L50:
        int r39 = (r36 + r38) * 31;
        String r41 = this.bidMetaTag;
        if (r41 == null) goto L53;
        int r42 = r41.hashCode();
    L54:
        int r43 = (r39 + r42) * 31;
        Integer r44 = this.cpsRatio;
        if (r44 == null) goto L57;
        int r45 = r44.hashCode();
    L58:
        int r46 = (r43 + r45) * 31;
        Integer r47 = this.bidType;
        if (r47 == null) goto L62;
        r1 = r47.hashCode();
    L62:
        return r46 + r1;
    L57:
        r45 = 0;
        goto L58
    L53:
        r42 = 0;
        goto L54
    L49:
        r38 = 0;
        goto L50
    L45:
        r35 = 0;
        goto L46
    L41:
        r32 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MicroGameInfo(gameId=" + this.gameId + ", gameName=" + this.gameName + ", gameIcon=" + this.gameIcon + ", gameType=" + this.gameType + ", taskId=" + this.taskId + ", taskName=" + this.taskName + ", taskStatus=" + this.taskStatus + ", schema=" + this.schema + ", hasTask=" + this.hasTask + ", taskChange=" + this.taskChange + ", originTaskId=" + this.originTaskId + ", taskPrice=" + this.taskPrice + ", bidMetaTag=" + this.bidMetaTag + ", cpsRatio=" + this.cpsRatio + ", bidType=" + this.bidType + ")";
    }

    public c0(int r6) {
        Boolean r0 = Boolean.TRUE;
        Boolean r1 = Boolean.FALSE;
        this.gameId = "";
        this.gameName = "";
        this.gameIcon = "";
        this.gameType = "";
        this.taskId = "";
        this.taskName = "";
        this.taskStatus = -1;
        this.schema = null;
        this.hasTask = r0;
        this.taskChange = r1;
        this.originTaskId = "";
        this.taskPrice = 1;
        this.bidMetaTag = "";
        this.cpsRatio = 0;
        this.bidType = null;
        this.a = "";
    }
}
