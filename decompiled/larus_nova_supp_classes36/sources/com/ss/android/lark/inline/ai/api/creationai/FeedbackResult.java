package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B)\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackResult;", "Ljava/io/Serializable;", "feedback", "Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;", "reasonIds", "", "", "content", "<init>", "(Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;Ljava/util/List;Ljava/lang/String;)V", "getFeedback", "()Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;", "setFeedback", "(Lcom/ss/android/lark/inline/ai/api/creationai/FeedbackDataAboutAI;)V", "getReasonIds", "()Ljava/util/List;", "setReasonIds", "(Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FeedbackResult implements Serializable {
    private String content;
    private FeedbackDataAboutAI feedback;
    private List<String> reasonIds;

    public String toString() {
        return "FeedbackResult(feedback=" + this.feedback + ", reasonIds=" + this.reasonIds + ", content='" + this.content + "')";
    }

    public final String getContent() {
        return this.content;
    }

    public final FeedbackDataAboutAI getFeedback() {
        return this.feedback;
    }

    public final List<String> getReasonIds() {
        return this.reasonIds;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setFeedback(FeedbackDataAboutAI r1) {
        this.feedback = r1;
    }

    public final void setReasonIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reasonIds = r2;
    }

    public FeedbackResult(FeedbackDataAboutAI r2, List<String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "reasonIds");
        Intrinsics.checkNotNullParameter(r4, "content");
        CollectionsKt.emptyList();
        this.feedback = r2;
        this.reasonIds = r3;
        this.content = r4;
    }
}
