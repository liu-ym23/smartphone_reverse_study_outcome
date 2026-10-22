package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/FeedbackConfig;", "Ljava/io/Serializable;", "aiMessageId", "", "scenario", "requestRawdata", "answerRawdata", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAiMessageId", "()Ljava/lang/String;", "setAiMessageId", "(Ljava/lang/String;)V", "getScenario", "setScenario", "getRequestRawdata", "setRequestRawdata", "getAnswerRawdata", "setAnswerRawdata", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FeedbackConfig implements Serializable {
    private String aiMessageId;
    private String answerRawdata;
    private String requestRawdata;
    private String scenario;

    public FeedbackConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FeedbackConfig copy$default(FeedbackConfig r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.aiMessageId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.scenario;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.requestRawdata;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.answerRawdata;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.aiMessageId;
    }

    public final String component2() {
        return this.scenario;
    }

    public final String component3() {
        return this.requestRawdata;
    }

    public final String component4() {
        return this.answerRawdata;
    }

    public final FeedbackConfig copy(String r2, String r3, String r4, String r5) {
        return new FeedbackConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeedbackConfig) == true) goto L8;
        return false;
    L8:
        FeedbackConfig r6 = (FeedbackConfig) r5;
        if (Intrinsics.areEqual(this.aiMessageId, r6.aiMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scenario, r6.scenario) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.requestRawdata, r6.requestRawdata) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.answerRawdata, r6.answerRawdata) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.aiMessageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.scenario;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.requestRawdata;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.answerRawdata;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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

    public String toString() {
        StringBuilder r0 = new StringBuilder("FeedbackConfig(aiMessageId=");
        r0.append(this.aiMessageId);
        r0.append(", scenario=");
        r0.append(this.scenario);
        r0.append(", requestRawdata=");
        r0.append(this.requestRawdata);
        r0.append(", answerRawdata.length=");
        String r1 = this.answerRawdata;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getAiMessageId() {
        return this.aiMessageId;
    }

    public final String getAnswerRawdata() {
        return this.answerRawdata;
    }

    public final String getRequestRawdata() {
        return this.requestRawdata;
    }

    public final String getScenario() {
        return this.scenario;
    }

    public final void setAiMessageId(String r1) {
        this.aiMessageId = r1;
    }

    public final void setAnswerRawdata(String r1) {
        this.answerRawdata = r1;
    }

    public final void setRequestRawdata(String r1) {
        this.requestRawdata = r1;
    }

    public final void setScenario(String r1) {
        this.scenario = r1;
    }

    public FeedbackConfig(String r1, String r2, String r3, String r4) {
        this.aiMessageId = r1;
        this.scenario = r2;
        this.requestRawdata = r3;
        this.answerRawdata = r4;
    }

    public /* synthetic */ FeedbackConfig(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
