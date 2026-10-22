package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0083\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\nJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J \u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020)2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0005HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0016\u0010\u0011\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0016\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"¨\u0006B"}, d2 = {"Lcom/obric/memorydata/union/build/storage/RuleEpisodicMemoryPayload;", "", "entityId", "", "productType", "", "eventName", "eventData", "rawTableName", "rawDbId", "", "title", Params.CONTENT, "createTime", "modifyTime", "timestamp", "actionTimestamp", "startTimestamp", "endTimestamp", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JJJJJJ)V", "getEntityId", "()Ljava/lang/String;", "getProductType", "()I", "getEventName", "getEventData", "getRawTableName", "getRawDbId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "getContent", "getCreateTime", "()J", "getModifyTime", "getTimestamp", "getActionTimestamp", "getStartTimestamp", "getEndTimestamp", "isValid", "", "toEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "old", "now", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JJJJJJ)Lcom/obric/memorydata/union/build/storage/RuleEpisodicMemoryPayload;", "equals", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RuleEpisodicMemoryPayload {

    @SerializedName("actionTimestamp")
    private final long actionTimestamp;

    @SerializedName(Params.CONTENT)
    private final String content;

    @SerializedName("createTime")
    private final long createTime;

    @SerializedName("endTimestamp")
    private final long endTimestamp;

    @SerializedName("entityId")
    private final String entityId;

    @SerializedName("eventData")
    private final String eventData;

    @SerializedName("eventName")
    private final String eventName;

    @SerializedName("modifyTime")
    private final long modifyTime;

    @SerializedName("productType")
    private final int productType;

    @SerializedName("rawDbId")
    private final Long rawDbId;

    @SerializedName("rawTableName")
    private final String rawTableName;

    @SerializedName("startTimestamp")
    private final long startTimestamp;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("title")
    private final String title;

    public RuleEpisodicMemoryPayload() {
        this(null, 0, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 16383, null);
    }

    public RuleEpisodicMemoryPayload(String r7, int r8, String r9, String r10, String r11, Long r12, String r13, String r14, long r15, long r17, long r19, long r21, long r23, long r25) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "eventData");
        Intrinsics.checkNotNullParameter(r13, "title");
        Intrinsics.checkNotNullParameter(r14, Params.CONTENT);
        this.entityId = r7;
        this.productType = r8;
        this.eventName = r9;
        this.eventData = r10;
        this.rawTableName = r11;
        this.rawDbId = r12;
        this.title = r13;
        this.content = r14;
        this.createTime = r15;
        this.modifyTime = r17;
        this.timestamp = r19;
        this.actionTimestamp = r21;
        this.startTimestamp = r23;
        this.endTimestamp = r25;
    }

    public /* synthetic */ RuleEpisodicMemoryPayload(String r23, int r24, String r25, String r26, String r27, Long r28, String r29, String r30, long r31, long r33, long r35, long r37, long r39, long r41, int r43, DefaultConstructorMarker r44) {
        Long r2 = null;
        if ((r43 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r43 & 2) == 0) goto L9;
        int r3 = 0;
    L10:
        String r5 = "";
        if ((r43 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r43 & 8) == 0) goto L17;
        String r6 = "{}";
    L19:
        if ((r43 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r43 & 32) != 0) goto L27;
        r2 = r28;
    L27:
        if ((r43 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r43 & 128) != 0) goto L34;
        r5 = r30;
    L34:
        long r10 = 0;
        if ((r43 & 256) == 0) goto L37;
        long r12 = 0;
    L39:
        if ((r43 & 512) == 0) goto L41;
        long r14 = 0;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        long r16 = 0;
    L47:
        if ((r43 & 2048) == 0) goto L49;
        long r18 = 0;
    L51:
        if ((r43 & 4096) == 0) goto L53;
        long r20 = 0;
    L55:
        if ((r43 & 8192) != 0) goto L58;
        r10 = r41;
    L58:
        this(r1, r3, r4, r6, r7, r2, r8, r5, r12, r14, r16, r18, r20, r10);
        return;
    L53:
        r20 = r39;
        goto L55
    L49:
        r18 = r37;
        goto L51
    L45:
        r16 = r35;
        goto L47
    L41:
        r14 = r33;
        goto L43
    L37:
        r12 = r31;
        goto L39
    L29:
        r8 = r29;
        goto L31
    L21:
        r7 = r27;
        goto L23
    L17:
        r6 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L10
    L5:
        r1 = r23;
        goto L7
    }

    public static /* synthetic */ RuleEpisodicMemoryPayload copy$default(RuleEpisodicMemoryPayload r16, String r17, int r18, String r19, String r20, String r21, Long r22, String r23, String r24, long r25, long r27, long r29, long r31, long r33, long r35, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        String r2 = r16.entityId;
    L7:
        if ((r37 & 2) == 0) goto L9;
        int r3 = r16.productType;
    L11:
        if ((r37 & 4) == 0) goto L13;
        String r4 = r16.eventName;
    L15:
        if ((r37 & 8) == 0) goto L17;
        String r5 = r16.eventData;
    L19:
        if ((r37 & 16) == 0) goto L21;
        String r6 = r16.rawTableName;
    L23:
        if ((r37 & 32) == 0) goto L25;
        Long r7 = r16.rawDbId;
    L27:
        if ((r37 & 64) == 0) goto L29;
        String r8 = r16.title;
    L31:
        if ((r37 & 128) == 0) goto L33;
        String r9 = r16.content;
    L35:
        if ((r37 & 256) == 0) goto L37;
        long r10 = r16.createTime;
    L39:
        if ((r37 & 512) == 0) goto L41;
        long r12 = r16.modifyTime;
    L43:
        if ((r37 & 1024) == 0) goto L45;
        long r14 = r16.timestamp;
    L46:
        long r210 = r14;
        if ((r37 & 2048) == 0) goto L49;
        long r15 = r16.actionTimestamp;
    L50:
        long r32 = r15;
        if ((r37 & 4096) == 0) goto L53;
        long r110 = r16.startTimestamp;
    L54:
        long r34 = r110;
        if ((r37 & 8192) == 0) goto L57;
        long r111 = r16.endTimestamp;
    L59:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r210, r32, r34, r111);
    L57:
        r111 = r35;
        goto L59
    L53:
        r110 = r33;
        goto L54
    L49:
        r15 = r31;
        goto L50
    L45:
        r14 = r29;
        goto L46
    L41:
        r12 = r27;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final String component1() {
        return this.entityId;
    }

    public final long component10() {
        return this.modifyTime;
    }

    public final long component11() {
        return this.timestamp;
    }

    public final long component12() {
        return this.actionTimestamp;
    }

    public final long component13() {
        return this.startTimestamp;
    }

    public final long component14() {
        return this.endTimestamp;
    }

    public final int component2() {
        return this.productType;
    }

    public final String component3() {
        return this.eventName;
    }

    public final String component4() {
        return this.eventData;
    }

    public final String component5() {
        return this.rawTableName;
    }

    public final Long component6() {
        return this.rawDbId;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.content;
    }

    public final long component9() {
        return this.createTime;
    }

    public final RuleEpisodicMemoryPayload copy(String r23, int r24, String r25, String r26, String r27, Long r28, String r29, String r30, long r31, long r33, long r35, long r37, long r39, long r41) {
        Intrinsics.checkNotNullParameter(r25, "eventName");
        Intrinsics.checkNotNullParameter(r26, "eventData");
        Intrinsics.checkNotNullParameter(r29, "title");
        Intrinsics.checkNotNullParameter(r30, Params.CONTENT);
        return new RuleEpisodicMemoryPayload(r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r35, r37, r39, r41);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, RuleEpisodicMemoryPayload.class) == true) goto L8;
        return false;
    L8:
        RuleEpisodicMemoryPayload r10 = (RuleEpisodicMemoryPayload) ZeusTransformUtils.preCheckCast(r9, RuleEpisodicMemoryPayload.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L12;
        return false;
    L12:
        if (this.productType == r10.productType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.eventName, r10.eventName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventData, r10.eventData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rawTableName, r10.rawTableName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.rawDbId, r10.rawDbId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L33;
        return false;
    L33:
        if (this.createTime == r10.createTime) goto L36;
        return false;
    L36:
        if (this.modifyTime == r10.modifyTime) goto L39;
        return false;
    L39:
        if (this.timestamp == r10.timestamp) goto L42;
        return false;
    L42:
        if (this.actionTimestamp == r10.actionTimestamp) goto L45;
        return false;
    L45:
        if (this.startTimestamp == r10.startTimestamp) goto L48;
        return false;
    L48:
        if (this.endTimestamp == r10.endTimestamp) goto L50;
        return false;
    L50:
        return true;
    }

    public final long getActionTimestamp() {
        return this.actionTimestamp;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getEventData() {
        return this.eventData;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final long getModifyTime() {
        return this.modifyTime;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final Long getRawDbId() {
        return this.rawDbId;
    }

    public final String getRawTableName() {
        return this.rawTableName;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String r0 = this.entityId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + Integer.hashCode(this.productType)) * 31) + this.eventName.hashCode()) * 31) + this.eventData.hashCode()) * 31;
        String r4 = this.rawTableName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.rawDbId;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((((((((((((((((r6 + r1) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.modifyTime)) * 31) + Long.hashCode(this.timestamp)) * 31) + Long.hashCode(this.actionTimestamp)) * 31) + Long.hashCode(this.startTimestamp)) * 31) + Long.hashCode(this.endTimestamp);
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final boolean isValid() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.entityId, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L23;
        int r2 = this.productType;
        if (1021 <= r2) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L18;
        return false;
    L18:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.eventName, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L20;
        return false;
    L20:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.content, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L22;
        return false;
    L22:
        return true;
    L13:
        if (r2 >= 1025) goto L15;
        r3 = true;
        goto L16
    L23:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final EpisodicMemoryEntity toEntity(EpisodicMemoryEntity r55, long r56) {
        if (r55 == null) goto L6;
        String r1 = r55.getEntityId();
        if (r1 == null) goto L6;
    L8:
        String r29 = r1;
        if (r55 == null) goto L11;
        long r3 = r55.getId();
    L12:
        Long r5 = Long.valueOf(this.actionTimestamp);
        boolean r8 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L15;
        boolean r6 = true;
    L16:
        Long r10 = null;
        if (r6 == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L22;
        long r7 = r5.longValue();
    L23:
        String r12 = this.title;
        String r13 = this.content;
        Long r11 = Long.valueOf(this.startTimestamp);
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == true) goto L30;
        r11 = null;
    L30:
        if (r11 == null) goto L32;
        long r24 = r11.longValue();
    L33:
        Long r15 = Long.valueOf(this.endTimestamp);
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L36;
        boolean r16 = true;
    L37:
        if (r16 == true) goto L40;
        r15 = null;
    L40:
        if (r15 == null) goto L42;
    L41:
        long r26 = r15.longValue();
    L52:
        Long r17 = Long.valueOf(this.createTime);
        if (((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L55;
        boolean r18 = true;
    L56:
        if (r18 == true) goto L59;
        r17 = null;
    L59:
        if (r17 == null) goto L61;
        long r30 = r17.longValue();
    L62:
        Long r19 = Long.valueOf(this.modifyTime);
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L65;
        boolean r110 = true;
    L66:
        if (r110 == true) goto L69;
        r19 = null;
    L69:
        if (r19 == null) goto L71;
        long r32 = r19.longValue();
    L72:
        Long r111 = Long.valueOf(this.timestamp);
        if (((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L76;
        r8 = false;
    L76:
        if (r8 == false) goto L78;
        r10 = r111;
    L78:
        if (r10 == null) goto L80;
        long r35 = r10.longValue();
    L81:
        if (r55 == null) goto L84;
        String r2 = r55.getUuid();
        if (r2 == null) goto L84;
    L86:
        return new EpisodicMemoryEntity(r3, r7, 0, r12, r13, null, r13, "", null, null, null, null, null, null, null, null, null, false, r24, r26, null, r29, r30, r32, -306, r35, BuildConfig.LIBRARY_PACKAGE_NAME, 0, r2, null, this.productType, null, null, null, null, this.eventName, this.rawTableName, this.rawDbId, this.eventData, -1475084508, 7, null);
    L84:
        r2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        goto L86
    L80:
        r35 = r56;
        goto L81
    L71:
        r32 = r56;
        goto L72
    L65:
        r110 = false;
        goto L66
    L61:
        r30 = r56;
        goto L62
    L55:
        r18 = false;
        goto L56
    L42:
        r15 = Long.valueOf(this.startTimestamp);
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L45;
        boolean r112 = true;
    L46:
        if (r112 == true) goto L49;
        r15 = null;
    L49:
        if (r15 != null) goto L41;
        r26 = r56;
        goto L52
    L45:
        r112 = false;
        goto L46
    L36:
        r16 = false;
        goto L37
    L32:
        r24 = r56;
        goto L33
    L26:
        r14 = false;
        goto L27
    L22:
        r7 = r56;
        goto L23
    L15:
        r6 = false;
        goto L16
    L11:
        r3 = 0;
    L6:
        r1 = this.entityId;
        if (r1 != null) goto L8;
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RuleEpisodicMemoryPayload(entityId=").append(this.entityId).append(", productType=").append(this.productType).append(", eventName=").append(this.eventName).append(", eventData=").append(this.eventData).append(", rawTableName=").append(this.rawTableName).append(", rawDbId=").append(this.rawDbId).append(", title=").append(this.title).append(", content=").append(this.content).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", timestamp=").append(this.timestamp).append(", actionTimestamp=");
        r0.append(this.actionTimestamp).append(", startTimestamp=").append(this.startTimestamp).append(", endTimestamp=").append(this.endTimestamp).append(')');
        return r0.toString();
    }
}
