package q99;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0003Jh\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "", "feedbackScene", "", "feedbackId", "", "feedbackType", "selectDislikeKeys", "", "dislikeContent", "extraParams", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/util/Map;)V", "getFeedbackScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackId", "()Ljava/lang/String;", "getFeedbackType", "()I", "getSelectDislikeKeys", "()Ljava/util/List;", "getDislikeContent", "getExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("dislike_content")
    private final String dislikeContent;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("feedback_id")
    private final String feedbackId;

    @SerializedName("feedback_scene")
    private final Integer feedbackScene;

    @SerializedName("feedback_type")
    private final int feedbackType;

    @SerializedName("select_dislike_keys")
    private final List<Integer> selectDislikeKeys;

    public k() {
        this(null, null, 0, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.feedbackScene, r6.feedbackScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackId, r6.feedbackId) == true) goto L15;
        return false;
    L15:
        if (this.feedbackType == r6.feedbackType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectDislikeKeys, r6.selectDislikeKeys) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dislikeContent, r6.dislikeContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extraParams, r6.extraParams) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.feedbackScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.feedbackId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.feedbackType) * 31;
        List<Integer> r7 = this.selectDislikeKeys;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.dislikeContent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.extraParams;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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

    public final String toString() {
        return "FlowFeedbackSubmitRequest(feedbackScene=" + this.feedbackScene + ", feedbackId=" + this.feedbackId + ", feedbackType=" + this.feedbackType + ", selectDislikeKeys=" + this.selectDislikeKeys + ", dislikeContent=" + this.dislikeContent + ", extraParams=" + this.extraParams + ')';
    }

    public final String a() {
        return this.feedbackId;
    }

    public final Integer b() {
        return this.feedbackScene;
    }

    public final int c() {
        return this.feedbackType;
    }

    public /* synthetic */ k(Integer r10, String r11, int r12, Map r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r14 & 32) == 0) goto L17;
        Map r8 = null;
    L18:
        this(r3, r4, r5, null, null, r8);
        return;
    L17:
        r8 = r13;
        goto L18
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public k(Integer r1, String r2, int r3, List<Integer> r4, String r5, Map<String, String> r6) {
        this.feedbackScene = r1;
        this.feedbackId = r2;
        this.feedbackType = r3;
        this.selectDislikeKeys = r4;
        this.dislikeContent = r5;
        this.extraParams = r6;
    }
}
