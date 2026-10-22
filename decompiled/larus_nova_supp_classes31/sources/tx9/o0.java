package tx9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010>\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010?\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010)Jò\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\u0013HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\u0012\u0010)R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b+\u0010)R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\u0015\u0010)R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b,\u0010)¨\u0006H"}, d2 = {"Lcom/larus/trace/CreationPublicStatus;", "Lcom/larus/trace/MobEvent;", "mobKey", "", "currentPage", "previousPage", "creationId", "creationTaskId", "messageId", "type", "fromStatus", "toStatus", "recommendFrom", "fromTemplateId", "templateRecReqId", "templateRecExtra", "createWay", "subType", "isHasCaption", "", "captionLength", "isImageReferencePublic", "imageReferenceCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMobKey", "()Ljava/lang/String;", "getCurrentPage", "getPreviousPage", "getCreationId", "getCreationTaskId", "getMessageId", "getType", "getFromStatus", "getToStatus", "getRecommendFrom", "getFromTemplateId", "getTemplateRecReqId", "getTemplateRecExtra", "getCreateWay", "getSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCaptionLength", "getImageReferenceCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/trace/CreationPublicStatus;", "equals", "", "other", "", "hashCode", "toString", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class o0 implements e2 {
    public final transient String a;

    @SerializedName("caption_length")
    private final Integer captionLength;

    @SerializedName("create_source")
    private final String createWay;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("creation_task_id")
    private final String creationTaskId;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("from_status")
    private final String fromStatus;

    @SerializedName("from_template_id")
    private final String fromTemplateId;

    @SerializedName("image_reference_cnt")
    private final Integer imageReferenceCount;

    @SerializedName("is_has_caption")
    private final Integer isHasCaption;

    @SerializedName("is_image_reference_public")
    private final Integer isImageReferencePublic;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("recommend_from")
    private final String recommendFrom;

    @SerializedName("sub_type")
    private final String subType;

    @SerializedName("template_rec_extra")
    private final String templateRecExtra;

    @SerializedName("template_rec_req_id")
    private final String templateRecReqId;

    @SerializedName("to_status")
    private final String toStatus;

    @SerializedName("type")
    private final String type;

    public o0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r6 = (o0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentPage, r6.currentPage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creationId, r6.creationId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creationTaskId, r6.creationTaskId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fromStatus, r6.fromStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.toStatus, r6.toStatus) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.recommendFrom, r6.recommendFrom) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.fromTemplateId, r6.fromTemplateId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.templateRecReqId, r6.templateRecReqId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.templateRecExtra, r6.templateRecExtra) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.createWay, r6.createWay) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.subType, r6.subType) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.isHasCaption, r6.isHasCaption) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.captionLength, r6.captionLength) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.isImageReferencePublic, r6.isImageReferencePublic) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.imageReferenceCount, r6.imageReferenceCount) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.currentPage;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.previousPage;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.creationId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.creationTaskId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.messageId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.type;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.fromStatus;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.toStatus;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.recommendFrom;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.fromTemplateId;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.templateRecReqId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.templateRecExtra;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.createWay;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.subType;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Integer r46 = this.isHasCaption;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Integer r49 = this.captionLength;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Integer r52 = this.isImageReferencePublic;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Integer r55 = this.imageReferenceCount;
        if (r55 == null) goto L79;
        r1 = r55.hashCode();
    L79:
        return r54 + r1;
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
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

    public final String toString() {
        return "CreationPublicStatus(mobKey=" + this.a + ", currentPage=" + this.currentPage + ", previousPage=" + this.previousPage + ", creationId=" + this.creationId + ", creationTaskId=" + this.creationTaskId + ", messageId=" + this.messageId + ", type=" + this.type + ", fromStatus=" + this.fromStatus + ", toStatus=" + this.toStatus + ", recommendFrom=" + this.recommendFrom + ", fromTemplateId=" + this.fromTemplateId + ", templateRecReqId=" + this.templateRecReqId + ", templateRecExtra=" + this.templateRecExtra + ", createWay=" + this.createWay + ", subType=" + this.subType + ", isHasCaption=" + this.isHasCaption + ", captionLength=" + this.captionLength + ", isImageReferencePublic=" + this.isImageReferencePublic + ", imageReferenceCount=" + this.imageReferenceCount + ')';
    }

    @Override // tx9.e2
    public final String a() {
        return this.a;
    }

    public final String getType() {
        return this.type;
    }

    @Override // tx9.e2
    public final void b(by7.e r1, JSONObject r2) {
        e2.a.a(this, r1, r2);
    }

    public o0(String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, Integer r35, Integer r36, Integer r37, Integer r38, int r39) {
        if ((r39 & 1) == 0) goto L5;
        String r2 = "creation_public_status";
    L7:
        if ((r39 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r39 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r39 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r39 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r39 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r39 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r39 & 128) == 0) goto L33;
        String r11 = "";
    L35:
        if ((r39 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r39 & 512) == 0) goto L41;
        String r13 = "";
    L43:
        if ((r39 & 1024) == 0) goto L45;
        String r14 = "";
    L47:
        if ((r39 & 2048) == 0) goto L49;
        String r15 = "";
    L51:
        if ((r39 & 4096) == 0) goto L53;
        String r3 = "";
    L55:
        if ((r39 & 8192) == 0) goto L57;
        String r5 = null;
    L58:
        String r210 = r5;
        if ((r39 & 16384) == 0) goto L61;
        String r16 = "";
    L63:
        if ((r39 & 32768) == 0) goto L65;
        Integer r17 = null;
    L67:
        if ((r39 & 65536) == 0) goto L69;
        Integer r18 = null;
    L71:
        if ((r39 & 131072) == 0) goto L73;
        Integer r19 = null;
    L75:
        if ((r39 & 262144) == 0) goto L77;
        Integer r1 = null;
    L78:
        this.a = r2;
        this.currentPage = r4;
        this.previousPage = r6;
        this.creationId = r7;
        this.creationTaskId = r8;
        this.messageId = r9;
        this.type = r10;
        this.fromStatus = r11;
        this.toStatus = r12;
        this.recommendFrom = r13;
        this.fromTemplateId = r14;
        this.templateRecReqId = r15;
        this.templateRecExtra = r3;
        this.createWay = r210;
        this.subType = r16;
        this.isHasCaption = r17;
        this.captionLength = r18;
        this.isImageReferencePublic = r19;
        this.imageReferenceCount = r1;
        return;
    L77:
        r1 = r38;
        goto L78
    L73:
        r19 = r37;
        goto L75
    L69:
        r18 = r36;
        goto L71
    L65:
        r17 = r35;
        goto L67
    L61:
        r16 = r34;
        goto L63
    L57:
        r5 = r33;
        goto L58
    L53:
        r3 = r32;
        goto L55
    L49:
        r15 = r31;
        goto L51
    L45:
        r14 = r30;
        goto L47
    L41:
        r13 = r29;
        goto L43
    L37:
        r12 = r28;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = null;
        goto L7
    }
}
