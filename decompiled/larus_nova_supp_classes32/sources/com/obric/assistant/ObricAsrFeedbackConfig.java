package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/ObricAsrFeedbackConfig;", NameKeys.UnloadStrategy_No_Strategy, "enableAsrFeedback", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/Boolean;)V", "getEnableAsrFeedback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/assistant/ObricAsrFeedbackConfig;", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAsrFeedbackConfig {

    @SerializedName("asr_feedback")
    private final Boolean enableAsrFeedback;

    public ObricAsrFeedbackConfig() {
        Boolean r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ ObricAsrFeedbackConfig copy$default(ObricAsrFeedbackConfig r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.enableAsrFeedback;
    L6:
        return r0.copy(r1);
    }

    public final Boolean component1() {
        return this.enableAsrFeedback;
    }

    public final ObricAsrFeedbackConfig copy(Boolean r2) {
        return new ObricAsrFeedbackConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ObricAsrFeedbackConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.enableAsrFeedback, ((ObricAsrFeedbackConfig) r4).enableAsrFeedback) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.enableAsrFeedback;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ObricAsrFeedbackConfig(enableAsrFeedback=" + this.enableAsrFeedback + ')';
    }

    public final Boolean getEnableAsrFeedback() {
        return this.enableAsrFeedback;
    }

    public ObricAsrFeedbackConfig(Boolean r1) {
        this.enableAsrFeedback = r1;
    }

    public /* synthetic */ ObricAsrFeedbackConfig(Boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
