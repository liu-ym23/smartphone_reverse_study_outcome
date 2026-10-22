package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasMsgInfo;", "Ljava/io/Serializable;", "sendMsgId", "", "replyMsgId", "taskId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasMsgInfo implements Serializable {

    @SerializedName("reply_msg_id")
    public final String replyMsgId;

    @SerializedName("send_msg_id")
    public final String sendMsgId;

    @SerializedName("task_id")
    public final String taskId;

    public CanvasMsgInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CanvasMsgInfo copy$default(CanvasMsgInfo r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.sendMsgId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.replyMsgId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.taskId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.sendMsgId;
    }

    public final String component2() {
        return this.replyMsgId;
    }

    public final String component3() {
        return this.taskId;
    }

    public final CanvasMsgInfo copy(String r2, String r3, String r4) {
        return new CanvasMsgInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CanvasMsgInfo) == true) goto L8;
        return false;
    L8:
        CanvasMsgInfo r6 = (CanvasMsgInfo) r5;
        if (Intrinsics.areEqual(this.sendMsgId, r6.sendMsgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyMsgId, r6.replyMsgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.sendMsgId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.replyMsgId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.taskId;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CanvasMsgInfo(sendMsgId=" + this.sendMsgId + ", replyMsgId=" + this.replyMsgId + ", taskId=" + this.taskId + ')';
    }

    public CanvasMsgInfo(String r1, String r2, String r3) {
        this.sendMsgId = r1;
        this.replyMsgId = r2;
        this.taskId = r3;
    }

    public /* synthetic */ CanvasMsgInfo(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
