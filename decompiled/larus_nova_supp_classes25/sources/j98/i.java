package j98;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.FlowDoraSubBizType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/model/SubmitDiaryFeedbackRequest;", "", "feedback", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackPayload;", "doraSubBiz", "", "<init>", "(Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackPayload;I)V", "getFeedback", "()Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackPayload;", "getDoraSubBiz", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class i {

    @SerializedName("dora_sub_biz")
    private final int doraSubBiz;

    @SerializedName("feedback")
    private final e feedback;

    public i() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.feedback, r6.feedback) == true) goto L12;
        return false;
    L12:
        if (this.doraSubBiz == r6.doraSubBiz) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        e r0 = this.feedback;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.doraSubBiz;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "SubmitDiaryFeedbackRequest(feedback=" + this.feedback + ", doraSubBiz=" + this.doraSubBiz + ')';
    }

    public i(e r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        int r4 = FlowDoraSubBizType.G1_G2.getValue();
    L9:
        this.feedback = r2;
        this.doraSubBiz = r4;
        return;
    L8:
        r4 = 0;
        goto L9
    }
}
