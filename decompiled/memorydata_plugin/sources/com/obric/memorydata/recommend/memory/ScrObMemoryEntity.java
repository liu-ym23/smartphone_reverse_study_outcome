package com.obric.memorydata.recommend.memory;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b(\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\u0010HÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003J\t\u00104\u001a\u00020\u0012HÆ\u0003J\u0091\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001J\u0013\u00106\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0012HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&¨\u0006:"}, d2 = {"Lcom/obric/memorydata/recommend/memory/ScrObMemoryEntity;", "", "createTimestamp", "", "modifyTimestamp", "startTimestamp", "endTimestamp", "observation", "", "title", Params.CONTENT, "entityId", WsConstants.KEY_EXTRA, "Lcom/obric/memorydata/recommend/memory/ScrObMemoryExtra;", "logId", "useLocation", "", EventBody.KEY_CATEGORY, "", "productType", "<init>", "(JJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/recommend/memory/ScrObMemoryExtra;Ljava/lang/String;ZII)V", "getCreateTimestamp", "()J", "getModifyTimestamp", "getStartTimestamp", "getEndTimestamp", "getObservation", "()Ljava/lang/String;", "getTitle", "getContent", "getEntityId", "getExtra", "()Lcom/obric/memorydata/recommend/memory/ScrObMemoryExtra;", "getLogId", "getUseLocation", "()Z", "getCategory", "()I", "getProductType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrObMemoryEntity {
    private final int category;
    private final String content;

    @SerializedName("create_timestamp")
    private final long createTimestamp;

    @SerializedName("end_timestamp")
    private final long endTimestamp;
    private final String entityId;
    private final ScrObMemoryExtra extra;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("modify_timestamp")
    private final long modifyTimestamp;
    private final String observation;
    private final int productType;

    @SerializedName("start_timestamp")
    private final long startTimestamp;
    private final String title;

    @SerializedName("use_location")
    private final boolean useLocation;

    public ScrObMemoryEntity(long r7, long r9, long r11, long r13, String r15, String r16, String r17, String r18, ScrObMemoryExtra r19, String r20, boolean r21, int r22, int r23) {
        Intrinsics.checkNotNullParameter(r15, "observation");
        Intrinsics.checkNotNullParameter(r17, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r20, "logId");
        this.createTimestamp = r7;
        this.modifyTimestamp = r9;
        this.startTimestamp = r11;
        this.endTimestamp = r13;
        this.observation = r15;
        this.title = r16;
        this.content = r17;
        this.entityId = r18;
        this.extra = r19;
        this.logId = r20;
        this.useLocation = r21;
        this.category = r22;
        this.productType = r23;
    }

    public /* synthetic */ ScrObMemoryEntity(long r21, long r23, long r25, long r27, String r29, String r30, String r31, String r32, ScrObMemoryExtra r33, String r34, boolean r35, int r36, int r37, int r38, DefaultConstructorMarker r39) {
        if ((r38 & 32) == 0) goto L5;
        String r12 = "";
    L7:
        if ((r38 & 128) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r38 & 256) == 0) goto L13;
        ScrObMemoryExtra r15 = null;
    L15:
        if ((r38 & 1024) == 0) goto L17;
        boolean r17 = false;
    L19:
        if ((r38 & 4096) == 0) goto L21;
        int r19 = 1001;
    L22:
        this(r21, r23, r25, r27, r29, r12, r31, r14, r15, r34, r17, r36, r19);
        return;
    L21:
        r19 = r37;
        goto L22
    L17:
        r17 = r35;
        goto L19
    L13:
        r15 = r33;
        goto L15
    L9:
        r14 = r32;
        goto L11
    L5:
        r12 = r30;
        goto L7
    }

    public static /* synthetic */ ScrObMemoryEntity copy$default(ScrObMemoryEntity r16, long r17, long r19, long r21, long r23, String r25, String r26, String r27, String r28, ScrObMemoryExtra r29, String r30, boolean r31, int r32, int r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        long r2 = r16.createTimestamp;
    L7:
        if ((r34 & 2) == 0) goto L9;
        long r4 = r16.modifyTimestamp;
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r6 = r16.startTimestamp;
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r8 = r16.endTimestamp;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r10 = r16.observation;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r11 = r16.title;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r12 = r16.content;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r13 = r16.entityId;
    L35:
        if ((r34 & 256) == 0) goto L37;
        ScrObMemoryExtra r14 = r16.extra;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r15 = r16.logId;
    L42:
        String r36 = r15;
        if ((r34 & 1024) == 0) goto L45;
        boolean r18 = r16.useLocation;
    L46:
        boolean r37 = r18;
        if ((r34 & 2048) == 0) goto L49;
        int r110 = r16.category;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        int r1 = r16.productType;
    L55:
        return r16.copy(r2, r4, r6, r8, r10, r11, r12, r13, r14, r36, r37, r110, r1);
    L53:
        r1 = r33;
        goto L55
    L49:
        r110 = r32;
        goto L51
    L45:
        r18 = r31;
        goto L46
    L41:
        r15 = r30;
        goto L42
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.createTimestamp;
    }

    public final String component10() {
        return this.logId;
    }

    public final boolean component11() {
        return this.useLocation;
    }

    public final int component12() {
        return this.category;
    }

    public final int component13() {
        return this.productType;
    }

    public final long component2() {
        return this.modifyTimestamp;
    }

    public final long component3() {
        return this.startTimestamp;
    }

    public final long component4() {
        return this.endTimestamp;
    }

    public final String component5() {
        return this.observation;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.content;
    }

    public final String component8() {
        return this.entityId;
    }

    public final ScrObMemoryExtra component9() {
        return this.extra;
    }

    public final ScrObMemoryEntity copy(long r20, long r22, long r24, long r26, String r28, String r29, String r30, String r31, ScrObMemoryExtra r32, String r33, boolean r34, int r35, int r36) {
        Intrinsics.checkNotNullParameter(r28, "observation");
        Intrinsics.checkNotNullParameter(r30, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r33, "logId");
        return new ScrObMemoryEntity(r20, r22, r24, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ScrObMemoryEntity.class) == true) goto L8;
        return false;
    L8:
        ScrObMemoryEntity r10 = (ScrObMemoryEntity) ZeusTransformUtils.preCheckCast(r9, ScrObMemoryEntity.class, "com.obric.memorydata.plugin");
        if (this.createTimestamp == r10.createTimestamp) goto L12;
        return false;
    L12:
        if (this.modifyTimestamp == r10.modifyTimestamp) goto L15;
        return false;
    L15:
        if (this.startTimestamp == r10.startTimestamp) goto L18;
        return false;
    L18:
        if (this.endTimestamp == r10.endTimestamp) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.observation, r10.observation) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r10.extra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L39;
        return false;
    L39:
        if (this.useLocation == r10.useLocation) goto L42;
        return false;
    L42:
        if (this.category == r10.category) goto L45;
        return false;
    L45:
        if (this.productType == r10.productType) goto L47;
        return false;
    L47:
        return true;
    }

    public final int getCategory() {
        return this.category;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTimestamp() {
        return this.createTimestamp;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final ScrObMemoryExtra getExtra() {
        return this.extra;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final long getModifyTimestamp() {
        return this.modifyTimestamp;
    }

    public final String getObservation() {
        return this.observation;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getUseLocation() {
        return this.useLocation;
    }

    public int hashCode() {
        int r0 = ((((((((Long.hashCode(this.createTimestamp) * 31) + Long.hashCode(this.modifyTimestamp)) * 31) + Long.hashCode(this.startTimestamp)) * 31) + Long.hashCode(this.endTimestamp)) * 31) + this.observation.hashCode()) * 31;
        String r1 = this.title;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.content.hashCode()) * 31;
        String r5 = this.entityId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        ScrObMemoryExtra r8 = this.extra;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((((r7 + r2) * 31) + this.logId.hashCode()) * 31) + Boolean.hashCode(this.useLocation)) * 31) + Integer.hashCode(this.category)) * 31) + Integer.hashCode(this.productType);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ScrObMemoryEntity(createTimestamp=").append(this.createTimestamp).append(", modifyTimestamp=").append(this.modifyTimestamp).append(", startTimestamp=").append(this.startTimestamp).append(", endTimestamp=").append(this.endTimestamp).append(", observation=").append(this.observation).append(", title=").append(this.title).append(", content=").append(this.content).append(", entityId=").append(this.entityId).append(", extra=").append(this.extra).append(", logId=").append(this.logId).append(", useLocation=").append(this.useLocation).append(", category=");
        r0.append(this.category).append(", productType=").append(this.productType).append(')');
        return r0.toString();
    }
}
