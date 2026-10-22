package com.larus.bmhome.chat.feedback;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.MsgFeedbackType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/feedback/TriggerFeedbackTagBean;", "", "feedbackType", "", "feedbackDetailType", "feedbackDisplay", "", "<init>", "(IILjava/lang/String;)V", "getFeedbackType", "()I", "getFeedbackDetailType", "getFeedbackDisplay", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class c {

    @SerializedName("feedback_detail_type")
    private final int feedbackDetailType;

    @SerializedName("feedback_display")
    private final String feedbackDisplay;

    @SerializedName("feedback_type")
    private final int feedbackType;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.feedbackType == r6.feedbackType) goto L12;
        return false;
    L12:
        if (this.feedbackDetailType == r6.feedbackDetailType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.feedbackDisplay, r6.feedbackDisplay) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.feedbackType * 31) + this.feedbackDetailType) * 31;
        String r1 = this.feedbackDisplay;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "TriggerFeedbackTagBean(feedbackType=" + this.feedbackType + ", feedbackDetailType=" + this.feedbackDetailType + ", feedbackDisplay=" + this.feedbackDisplay + ')';
    }

    public c() {
        this(MsgFeedbackType.MsgFeedbackTypeDefault.value, 0, null);
    }

    public final int a() {
        return this.feedbackDetailType;
    }

    public final String b() {
        return this.feedbackDisplay;
    }

    public final int c() {
        return this.feedbackType;
    }

    public c(int r1, int r2, String r3) {
        this.feedbackType = r1;
        this.feedbackDetailType = r2;
        this.feedbackDisplay = r3;
    }
}
