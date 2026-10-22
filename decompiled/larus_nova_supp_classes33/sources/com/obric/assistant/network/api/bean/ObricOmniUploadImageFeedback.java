package com.obric.assistant.network.api.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageFeedback;", "", "content", "", "tags", "", "type", "score", "amount", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getTags", "()Ljava/util/List;", "getType", "getScore", "getAmount", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOmniUploadImageFeedback {

    @SerializedName("amount")
    private final int amount;

    @SerializedName("content")
    private final String content;

    @SerializedName("score")
    private final String score;

    @SerializedName("tags")
    private final List<String> tags;

    @SerializedName("type")
    private final String type;

    public ObricOmniUploadImageFeedback() {
        this(null, null, null, null, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricOmniUploadImageFeedback copy$default(ObricOmniUploadImageFeedback r3, String r4, List r5, String r6, String r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.content;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.tags;
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.type;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.score;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.amount;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.content;
    }

    public final List<String> component2() {
        return this.tags;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.score;
    }

    public final int component5() {
        return this.amount;
    }

    public final ObricOmniUploadImageFeedback copy(String r8, List<String> r9, String r10, String r11, int r12) {
        return new ObricOmniUploadImageFeedback(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricOmniUploadImageFeedback) == true) goto L8;
        return false;
    L8:
        ObricOmniUploadImageFeedback r6 = (ObricOmniUploadImageFeedback) r5;
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tags, r6.tags) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.score, r6.score) == true) goto L21;
        return false;
    L21:
        if (this.amount == r6.amount) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.tags;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.type;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.score;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return ((r9 + r1) * 31) + this.amount;
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
        return "ObricOmniUploadImageFeedback(content=" + this.content + ", tags=" + this.tags + ", type=" + this.type + ", score=" + this.score + ", amount=" + this.amount + ')';
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getScore() {
        return this.score;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getType() {
        return this.type;
    }

    public ObricOmniUploadImageFeedback(String r1, List<String> r2, String r3, String r4, int r5) {
        this.content = r1;
        this.tags = r2;
        this.type = r3;
        this.score = r4;
        this.amount = r5;
    }

    public /* synthetic */ ObricOmniUploadImageFeedback(String r4, List r5, String r6, String r7, int r8, int r9, DefaultConstructorMarker r10) {
        String r0 = null;
        if ((r9 & 1) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r9 & 2) == 0) goto L9;
        List r1 = null;
    L11:
        if ((r9 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r9 & 8) != 0) goto L19;
        r0 = r7;
    L19:
        if ((r9 & 16) == 0) goto L21;
        int r12 = -1;
    L22:
        this(r11, r1, r2, r0, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L13:
        r2 = r6;
        goto L15
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
