package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.lifelog.data.Lifelog;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\n\u00103\u001a\u0004\u0018\u000104H\u0014J\u001a\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0016J\u0012\u00109\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0005H\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u000fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0012HÆ\u0003J\u0085\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010G\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\tHÖ\u0001J\t\u0010K\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\u0007\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001e\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006L"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/LifelogEntityOld;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "lifelog", "Lcom/obric/lifelog/data/Lifelog;", "fullContent", "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Lcom/obric/lifelog/data/Lifelog;Ljava/lang/String;Z)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getCreateTime", "setCreateTime", "getModifyTime", "setModifyTime", "getType", "()I", "setType", "(I)V", "getTimestamp", "setTimestamp", "getPackageName", "setPackageName", "getHashCodeValue", "setHashCodeValue", "getUuid", "setUuid", "getLifelog", "()Lcom/obric/lifelog/data/Lifelog;", "getFullContent", "setFullContent", "getPersonalDbSplitMigrated", "()Z", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifelogEntityOld extends com.obric.memorydata.database.entity.d {
    private long createTime;
    private String entityId;
    private String fullContent;
    private int hashCodeValue;
    private long id;
    private final Lifelog lifelog;
    private long modifyTime;
    private String packageName;
    private final boolean personalDbSplitMigrated;
    private long timestamp;
    private int type;
    private String uuid;

    public LifelogEntityOld(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, Lifelog r36, String r37, boolean r38) {
        Intrinsics.checkNotNullParameter(r25, "entityId");
        Intrinsics.checkNotNullParameter(r33, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r36, "lifelog");
        Integer r1 = null;
        super(r23, r25, r26, r28, r30, r31, r33, r34, r35, r1, r1, null, 3584, null);
        this.id = r23;
        this.entityId = r25;
        this.createTime = r26;
        this.modifyTime = r28;
        this.type = r30;
        this.timestamp = r31;
        this.packageName = r33;
        this.hashCodeValue = r34;
        this.uuid = r35;
        this.lifelog = r36;
        this.fullContent = r37;
        this.personalDbSplitMigrated = r38;
    }

    public /* synthetic */ LifelogEntityOld(long r22, String r24, long r25, long r27, int r29, long r30, String r32, int r33, String r34, Lifelog r35, String r36, boolean r37, int r38, DefaultConstructorMarker r39) {
        if ((r38 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r38 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r38 & 8) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r38 & 16) == 0) goto L21;
        int r12 = 1401;
    L23:
        if ((r38 & 32) == 0) goto L25;
        long r13 = System.currentTimeMillis();
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r15 = AppContext.INSTANCE.getPackageName();
    L31:
        if ((r38 & 128) == 0) goto L33;
        int r16 = 0;
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r17 = UUID.randomUUID().toString();
    L39:
        if ((r38 & 1024) == 0) goto L41;
        String r19 = null;
    L43:
        if ((r38 & 2048) == 0) goto L45;
        boolean r20 = false;
    L46:
        this(r5, r7, r8, r10, r12, r13, r15, r16, r17, r35, r19, r20);
        return;
    L45:
        r20 = r37;
        goto L46
    L41:
        r19 = r36;
        goto L43
    L37:
        r17 = r34;
        goto L39
    L33:
        r16 = r33;
        goto L35
    L29:
        r15 = r32;
        goto L31
    L25:
        r13 = r30;
        goto L27
    L21:
        r12 = r29;
        goto L23
    L17:
        r10 = r27;
        goto L19
    L13:
        r8 = r25;
        goto L15
    L9:
        r7 = r24;
        goto L11
    L5:
        r5 = r22;
        goto L7
    }

    public static /* synthetic */ LifelogEntityOld copy$default(LifelogEntityOld r16, long r17, String r19, long r20, long r22, int r24, long r25, String r27, int r28, String r29, Lifelog r30, String r31, boolean r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r4 = r16.entityId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r5 = r16.createTime;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r7 = r16.modifyTime;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r9 = r16.type;
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r10 = r16.timestamp;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r12 = r16.packageName;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r13 = r16.hashCodeValue;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r14 = r16.uuid;
    L39:
        if ((r33 & 512) == 0) goto L41;
        Lifelog r15 = r16.lifelog;
    L42:
        Lifelog r35 = r15;
        if ((r33 & 1024) == 0) goto L45;
        String r18 = r16.fullContent;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        boolean r1 = r16.personalDbSplitMigrated;
    L51:
        return r16.copy(r2, r4, r5, r7, r9, r10, r12, r13, r14, r35, r18, r1);
    L49:
        r1 = r32;
        goto L51
    L45:
        r18 = r31;
        goto L47
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
        r10 = r25;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final Lifelog component10() {
        return this.lifelog;
    }

    public final String component11() {
        return this.fullContent;
    }

    public final boolean component12() {
        return this.personalDbSplitMigrated;
    }

    public final String component2() {
        return this.entityId;
    }

    public final long component3() {
        return this.createTime;
    }

    public final long component4() {
        return this.modifyTime;
    }

    public final int component5() {
        return this.type;
    }

    public final long component6() {
        return this.timestamp;
    }

    public final String component7() {
        return this.packageName;
    }

    public final int component8() {
        return this.hashCodeValue;
    }

    public final String component9() {
        return this.uuid;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.i convertToTextVectorCopilotEntity(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "column");
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return null;
    }

    public final LifelogEntityOld copy(long r19, String r21, long r22, long r24, int r26, long r27, String r29, int r30, String r31, Lifelog r32, String r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r21, "entityId");
        Intrinsics.checkNotNullParameter(r29, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r32, "lifelog");
        return new LifelogEntityOld(r19, r21, r22, r24, r26, r27, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, LifelogEntityOld.class) == true) goto L8;
        return false;
    L8:
        LifelogEntityOld r10 = (LifelogEntityOld) ZeusTransformUtils.preCheckCast(r9, LifelogEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L15;
        return false;
    L15:
        if (this.createTime == r10.createTime) goto L18;
        return false;
    L18:
        if (this.modifyTime == r10.modifyTime) goto L21;
        return false;
    L21:
        if (this.type == r10.type) goto L24;
        return false;
    L24:
        if (this.timestamp == r10.timestamp) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L30;
        return false;
    L30:
        if (this.hashCodeValue == r10.hashCodeValue) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.uuid, r10.uuid) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lifelog, r10.lifelog) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.fullContent, r10.fullContent) == true) goto L42;
        return false;
    L42:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L44;
        return false;
    L44:
        return true;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.entityId;
    }

    public final String getFullContent() {
        return this.fullContent;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.hashCodeValue;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.id;
    }

    public final Lifelog getLifelog() {
        return this.lifelog;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.packageName;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.type;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.id) * 31) + this.entityId.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.modifyTime)) * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.packageName.hashCode()) * 31) + Integer.hashCode(this.hashCodeValue)) * 31;
        String r1 = this.uuid;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.lifelog.hashCode()) * 31;
        String r5 = this.fullContent;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setFullContent(String r1) {
        this.fullContent = r1;
    }

    public void setHashCodeValue(int r1) {
        this.hashCodeValue = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.id = r1;
    }

    public void setModifyTime(long r1) {
        this.modifyTime = r1;
    }

    public void setPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageName = r2;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.uuid = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("LifelogEntityOld(id=").append(this.id).append(", entityId=").append(this.entityId).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", type=").append(this.type).append(", timestamp=").append(this.timestamp).append(", packageName=").append(this.packageName).append(", hashCodeValue=").append(this.hashCodeValue).append(", uuid=").append(this.uuid).append(", lifelog=").append(this.lifelog).append(", fullContent=").append(this.fullContent).append(", personalDbSplitMigrated=");
        r0.append(this.personalDbSplitMigrated).append(')');
        return r0.toString();
    }
}
