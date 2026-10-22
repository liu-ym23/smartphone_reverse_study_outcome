package com.larus.platform.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010#J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010(J¤\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lcom/larus/platform/model/MessageCollection;", "", "collectionId", "", "title", "collectionBio", "source", "coverUrl", "subCoverUrl", "collectionType", "", "collectionStatus", "schema", "notAllowedCancel", "", "collectionDetails", "", "Lcom/larus/platform/model/CollectionDetail;", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Long;)V", "getCollectionId", "()Ljava/lang/String;", "getTitle", "getCollectionBio", "getSource", "getCoverUrl", "getSubCoverUrl", "getCollectionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectionStatus", "getSchema", "getNotAllowedCancel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCollectionDetails", "()Ljava/util/List;", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Long;)Lcom/larus/platform/model/MessageCollection;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MessageCollection {

    @SerializedName("collection_bio")
    private final String collectionBio;

    @SerializedName("collection_detail_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<CollectionDetail> collectionDetails;

    @SerializedName("id")
    private final String collectionId;

    @SerializedName("status")
    private final Integer collectionStatus;

    @SerializedName("collection_type")
    private final Integer collectionType;

    @SerializedName("cover_url")
    private final String coverUrl;

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("not_allowed_cancel")
    private final Boolean notAllowedCancel;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("source")
    private final String source;

    @SerializedName("sub_cover_url")
    private final String subCoverUrl;

    @SerializedName("title")
    private final String title;

    public MessageCollection() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageCollection copy$default(MessageCollection r13, String r14, String r15, String r16, String r17, String r18, String r19, Integer r20, Integer r21, String r22, Boolean r23, List r24, Long r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.collectionId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.title;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.collectionBio;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.source;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.coverUrl;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.subCoverUrl;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Integer r8 = r13.collectionType;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Integer r9 = r13.collectionStatus;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r10 = r13.schema;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Boolean r11 = r13.notAllowedCancel;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        List r12 = r13.collectionDetails;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        Long r1 = r13.createTime;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.collectionId;
    }

    public final Boolean component10() {
        return this.notAllowedCancel;
    }

    public final List<CollectionDetail> component11() {
        return this.collectionDetails;
    }

    public final Long component12() {
        return this.createTime;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.collectionBio;
    }

    public final String component4() {
        return this.source;
    }

    public final String component5() {
        return this.coverUrl;
    }

    public final String component6() {
        return this.subCoverUrl;
    }

    public final Integer component7() {
        return this.collectionType;
    }

    public final Integer component8() {
        return this.collectionStatus;
    }

    public final String component9() {
        return this.schema;
    }

    public final MessageCollection copy(String r15, String r16, String r17, String r18, String r19, String r20, Integer r21, Integer r22, String r23, Boolean r24, List<CollectionDetail> r25, Long r26) {
        return new MessageCollection(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageCollection) == true) goto L8;
        return false;
    L8:
        MessageCollection r6 = (MessageCollection) r5;
        if (Intrinsics.areEqual(this.collectionId, r6.collectionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.collectionBio, r6.collectionBio) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.coverUrl, r6.coverUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subCoverUrl, r6.subCoverUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.collectionType, r6.collectionType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.collectionStatus, r6.collectionStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.schema, r6.schema) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.notAllowedCancel, r6.notAllowedCancel) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.collectionDetails, r6.collectionDetails) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.collectionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.collectionBio;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.source;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.coverUrl;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.subCoverUrl;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.collectionType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.collectionStatus;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.schema;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.notAllowedCancel;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        List<CollectionDetail> r31 = this.collectionDetails;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.createTime;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
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

    public String toString() {
        return "MessageCollection(collectionId=" + this.collectionId + ", title=" + this.title + ", collectionBio=" + this.collectionBio + ", source=" + this.source + ", coverUrl=" + this.coverUrl + ", subCoverUrl=" + this.subCoverUrl + ", collectionType=" + this.collectionType + ", collectionStatus=" + this.collectionStatus + ", schema=" + this.schema + ", notAllowedCancel=" + this.notAllowedCancel + ", collectionDetails=" + this.collectionDetails + ", createTime=" + this.createTime + ')';
    }

    public final String getCollectionBio() {
        return this.collectionBio;
    }

    public final List<CollectionDetail> getCollectionDetails() {
        return this.collectionDetails;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final Integer getCollectionStatus() {
        return this.collectionStatus;
    }

    public final Integer getCollectionType() {
        return this.collectionType;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Boolean getNotAllowedCancel() {
        return this.notAllowedCancel;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getSubCoverUrl() {
        return this.subCoverUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public MessageCollection(String r1, String r2, String r3, String r4, String r5, String r6, Integer r7, Integer r8, String r9, Boolean r10, List<CollectionDetail> r11, Long r12) {
        this.collectionId = r1;
        this.title = r2;
        this.collectionBio = r3;
        this.source = r4;
        this.coverUrl = r5;
        this.subCoverUrl = r6;
        this.collectionType = r7;
        this.collectionStatus = r8;
        this.schema = r9;
        this.notAllowedCancel = r10;
        this.collectionDetails = r11;
        this.createTime = r12;
    }

    public /* synthetic */ MessageCollection(String r15, String r16, String r17, String r18, String r19, String r20, Integer r21, Integer r22, String r23, Boolean r24, List r25, Long r26, int r27, DefaultConstructorMarker r28) {
        String r2 = "";
        if ((r27 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r27 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r27 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r27 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r27 & 64) == 0) goto L29;
        Integer r8 = 0;
    L31:
        if ((r27 & 128) == 0) goto L33;
        Integer r9 = 0;
    L35:
        if ((r27 & 256) != 0) goto L39;
        r2 = r23;
    L39:
        if ((r27 & 512) == 0) goto L41;
        Boolean r10 = Boolean.FALSE;
    L43:
        if ((r27 & 1024) == 0) goto L45;
        List r11 = CollectionsKt.emptyList();
    L47:
        if ((r27 & 2048) == 0) goto L49;
        Long r0 = 0L;
    L50:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2, r10, r11, r0);
        return;
    L49:
        r0 = r26;
        goto L50
    L45:
        r11 = r25;
        goto L47
    L41:
        r10 = r24;
        goto L43
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
