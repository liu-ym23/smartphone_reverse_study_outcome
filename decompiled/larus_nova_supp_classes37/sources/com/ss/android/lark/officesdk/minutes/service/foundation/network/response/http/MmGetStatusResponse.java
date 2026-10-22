package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u000f¨\u0006,"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmGetStatusResponse;", "Ljava/io/Serializable;", "objectStatus", "", "reviewStatus", "canModify", "", "objectVersion", "lastEditVersion", "summaryStatus", "agendaStatus", "speakerSummaryStatus", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getObjectStatus", "()Ljava/lang/Integer;", "setObjectStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReviewStatus", "getCanModify", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getObjectVersion", "getLastEditVersion", "getSummaryStatus", "getAgendaStatus", "getSpeakerSummaryStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmGetStatusResponse;", "equals", "other", "", "hashCode", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmGetStatusResponse implements Serializable {

    @SerializedName("agenda_status")
    private final Integer agendaStatus;

    @SerializedName("can_modify")
    private final Boolean canModify;

    @SerializedName("last_edit_version")
    private final Integer lastEditVersion;

    @SerializedName("object_status")
    private Integer objectStatus;

    @SerializedName("object_version")
    private final Integer objectVersion;

    @SerializedName("review_status")
    private final Integer reviewStatus;

    @SerializedName("speaker_ai_status")
    private final Integer speakerSummaryStatus;

    @SerializedName("summary_status")
    private final Integer summaryStatus;

    public MmGetStatusResponse() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ MmGetStatusResponse copy$default(MmGetStatusResponse r9, Integer r10, Integer r11, Boolean r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Integer r2 = r9.objectStatus;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = r9.reviewStatus;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Boolean r4 = r9.canModify;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r5 = r9.objectVersion;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = r9.lastEditVersion;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = r9.summaryStatus;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = r9.agendaStatus;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.speakerSummaryStatus;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Integer component1() {
        return this.objectStatus;
    }

    public final Integer component2() {
        return this.reviewStatus;
    }

    public final Boolean component3() {
        return this.canModify;
    }

    public final Integer component4() {
        return this.objectVersion;
    }

    public final Integer component5() {
        return this.lastEditVersion;
    }

    public final Integer component6() {
        return this.summaryStatus;
    }

    public final Integer component7() {
        return this.agendaStatus;
    }

    public final Integer component8() {
        return this.speakerSummaryStatus;
    }

    public final MmGetStatusResponse copy(Integer r11, Integer r12, Boolean r13, Integer r14, Integer r15, Integer r16, Integer r17, Integer r18) {
        return new MmGetStatusResponse(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmGetStatusResponse) == true) goto L8;
        return false;
    L8:
        MmGetStatusResponse r6 = (MmGetStatusResponse) r5;
        if (Intrinsics.areEqual(this.objectStatus, r6.objectStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reviewStatus, r6.reviewStatus) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.canModify, r6.canModify) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.objectVersion, r6.objectVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lastEditVersion, r6.lastEditVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.summaryStatus, r6.summaryStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.agendaStatus, r6.agendaStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.speakerSummaryStatus, r6.speakerSummaryStatus) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.objectStatus;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.reviewStatus;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.canModify;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.objectVersion;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.lastEditVersion;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.summaryStatus;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.agendaStatus;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.speakerSummaryStatus;
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
        return "MmGetStatusResponse(objectStatus=" + this.objectStatus + ", reviewStatus=" + this.reviewStatus + ", canModify=" + this.canModify + ", objectVersion=" + this.objectVersion + ", lastEditVersion=" + this.lastEditVersion + ", summaryStatus=" + this.summaryStatus + ", agendaStatus=" + this.agendaStatus + ", speakerSummaryStatus=" + this.speakerSummaryStatus + ')';
    }

    public final Integer getAgendaStatus() {
        return this.agendaStatus;
    }

    public final Boolean getCanModify() {
        return this.canModify;
    }

    public final Integer getLastEditVersion() {
        return this.lastEditVersion;
    }

    public final Integer getObjectStatus() {
        return this.objectStatus;
    }

    public final Integer getObjectVersion() {
        return this.objectVersion;
    }

    public final Integer getReviewStatus() {
        return this.reviewStatus;
    }

    public final Integer getSpeakerSummaryStatus() {
        return this.speakerSummaryStatus;
    }

    public final Integer getSummaryStatus() {
        return this.summaryStatus;
    }

    public final void setObjectStatus(Integer r1) {
        this.objectStatus = r1;
    }

    public MmGetStatusResponse(Integer r1, Integer r2, Boolean r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8) {
        this.objectStatus = r1;
        this.reviewStatus = r2;
        this.canModify = r3;
        this.objectVersion = r4;
        this.lastEditVersion = r5;
        this.summaryStatus = r6;
        this.agendaStatus = r7;
        this.speakerSummaryStatus = r8;
    }

    public /* synthetic */ MmGetStatusResponse(Integer r10, Integer r11, Boolean r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, int r18, DefaultConstructorMarker r19) {
        Integer r2 = null;
        if ((r18 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Boolean r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
