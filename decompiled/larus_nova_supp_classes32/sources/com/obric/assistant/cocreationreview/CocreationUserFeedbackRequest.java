package com.obric.assistant.cocreationreview;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0080\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;", NameKeys.UnloadStrategy_No_Strategy, "uniqId", NameKeys.UnloadStrategy_No_Strategy, "source", "module", NameKeys.UnloadStrategy_No_Strategy, "tags", NameKeys.UnloadStrategy_No_Strategy, "feedbackType", LynxAccessibilityModule.MSG_CONTENT, "logId", "attachment", "extra", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getUniqId", "()Ljava/lang/String;", "getSource", "getModule", "()I", "getTags", "()Ljava/util/List;", "getFeedbackType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContent", "getLogId", "getAttachment", "getExtra", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationUserFeedbackRequest {

    @SerializedName("attachment")
    private final String attachment;

    @SerializedName(LynxAccessibilityModule.MSG_CONTENT)
    private final String content;

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("feedback_type")
    private final Integer feedbackType;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("module")
    private final int module;

    @SerializedName("source")
    private final String source;

    @SerializedName("tags")
    private final List<String> tags;

    @SerializedName("uniq_id")
    private final String uniqId;

    public CocreationUserFeedbackRequest() {
        this(null, null, 0, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CocreationUserFeedbackRequest copy$default(CocreationUserFeedbackRequest r10, String r11, String r12, int r13, List r14, Integer r15, String r16, String r17, String r18, JsonObject r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.uniqId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.source;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.module;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = r10.tags;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Integer r6 = r10.feedbackType;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.content;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.logId;
    L31:
        if ((r20 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r9 = r10.attachment;
    L35:
        if ((r20 & 256) == 0) goto L37;
        JsonObject r1 = r10.extra;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.uniqId;
    }

    public final String component2() {
        return this.source;
    }

    public final int component3() {
        return this.module;
    }

    public final List<String> component4() {
        return this.tags;
    }

    public final Integer component5() {
        return this.feedbackType;
    }

    public final String component6() {
        return this.content;
    }

    public final String component7() {
        return this.logId;
    }

    public final String component8() {
        return this.attachment;
    }

    public final JsonObject component9() {
        return this.extra;
    }

    public final CocreationUserFeedbackRequest copy(String r12, String r13, int r14, List<String> r15, Integer r16, String r17, String r18, String r19, JsonObject r20) {
        return new CocreationUserFeedbackRequest(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CocreationUserFeedbackRequest) == true) goto L8;
        return false;
    L8:
        CocreationUserFeedbackRequest r6 = (CocreationUserFeedbackRequest) r5;
        if (Intrinsics.areEqual(this.uniqId, r6.uniqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L15;
        return false;
    L15:
        if (this.module == r6.module) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tags, r6.tags) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.feedbackType, r6.feedbackType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.attachment, r6.attachment) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.uniqId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.source;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.module) * 31;
        List<String> r7 = this.tags;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.feedbackType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.content;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.logId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.attachment;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        JsonObject r22 = this.extra;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
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

    public String toString() {
        return "CocreationUserFeedbackRequest(uniqId=" + this.uniqId + ", source=" + this.source + ", module=" + this.module + ", tags=" + this.tags + ", feedbackType=" + this.feedbackType + ", content=" + this.content + ", logId=" + this.logId + ", attachment=" + this.attachment + ", extra=" + this.extra + ')';
    }

    public final String getAttachment() {
        return this.attachment;
    }

    public final String getContent() {
        return this.content;
    }

    public final JsonObject getExtra() {
        return this.extra;
    }

    public final Integer getFeedbackType() {
        return this.feedbackType;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getModule() {
        return this.module;
    }

    public final String getSource() {
        return this.source;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public CocreationUserFeedbackRequest(String r1, String r2, int r3, List<String> r4, Integer r5, String r6, String r7, String r8, JsonObject r9) {
        this.uniqId = r1;
        this.source = r2;
        this.module = r3;
        this.tags = r4;
        this.feedbackType = r5;
        this.content = r6;
        this.logId = r7;
        this.attachment = r8;
        this.extra = r9;
    }

    public /* synthetic */ CocreationUserFeedbackRequest(String r11, String r12, int r13, List r14, Integer r15, String r16, String r17, String r18, JsonObject r19, int r20, DefaultConstructorMarker r21) {
        JsonObject r2 = null;
        if ((r20 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
