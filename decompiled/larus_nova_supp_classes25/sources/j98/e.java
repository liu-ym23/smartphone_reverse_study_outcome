package j98;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackPayload;", "", "targetId", "", "targetType", "", "actionType", "reasons", "content", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getTargetId", "()Ljava/lang/String;", "getTargetType", "()I", "getActionType", "getReasons", "getContent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class e {

    @SerializedName("action_type")
    private final int actionType;

    @SerializedName("content")
    private final String content;

    @SerializedName("reasons")
    private final String reasons;

    @SerializedName("target_id")
    private final String targetId;

    @SerializedName("target_type")
    private final int targetType;

    public e() {
        this(null, 0, null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.targetId, r6.targetId) == true) goto L12;
        return false;
    L12:
        if (this.targetType == r6.targetType) goto L15;
        return false;
    L15:
        if (this.actionType == r6.actionType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reasons, r6.reasons) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.targetId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.targetType) * 31) + this.actionType) * 31;
        String r4 = this.reasons;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.content;
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

    public final String toString() {
        return "DiaryFeedbackPayload(targetId=" + this.targetId + ", targetType=" + this.targetType + ", actionType=" + this.actionType + ", reasons=" + this.reasons + ", content=" + this.content + ')';
    }

    public e(String r5, int r6, String r7, String r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r9 & 2) == 0) goto L8;
        int r0 = 1;
    L10:
        if ((r9 & 4) == 0) goto L13;
        r6 = 0;
    L13:
        if ((r9 & 8) == 0) goto L16;
        r7 = null;
    L16:
        if ((r9 & 16) == 0) goto L18;
        r8 = null;
    L18:
        this.targetId = r5;
        this.targetType = r0;
        this.actionType = r6;
        this.reasons = r7;
        this.content = r8;
        return;
    L8:
        r0 = 0;
        goto L10
    }
}
