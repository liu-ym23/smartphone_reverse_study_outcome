package i3a;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackDetail;", NameKeys.UnloadStrategy_No_Strategy, "feedbackType", NameKeys.UnloadStrategy_No_Strategy, "feedbackDetailType", NameKeys.UnloadStrategy_No_Strategy, "feedbackDetailContent", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "getFeedbackType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackDetailType", "()Ljava/util/List;", "getFeedbackDetailContent", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackDetail;", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("feedback_detail_content")
    private final String feedbackDetailContent;

    @SerializedName("feedback_detail_type")
    private final List<Integer> feedbackDetailType;

    @SerializedName("feedback_type")
    private final Integer feedbackType;

    public a() {
        this(null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.feedbackType, r6.feedbackType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackDetailType, r6.feedbackDetailType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.feedbackDetailContent, r6.feedbackDetailContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.feedbackType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Integer> r4 = this.feedbackDetailType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.feedbackDetailContent;
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
        return "RealtimeCallFeedbackDetail(feedbackType=" + this.feedbackType + ", feedbackDetailType=" + this.feedbackDetailType + ", feedbackDetailContent=" + this.feedbackDetailContent + ')';
    }

    public /* synthetic */ a(Integer r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this(r2, null, null);
    }

    public a(Integer r1, List<Integer> r2, String r3) {
        this.feedbackType = r1;
        this.feedbackDetailType = r2;
        this.feedbackDetailContent = r3;
    }
}
