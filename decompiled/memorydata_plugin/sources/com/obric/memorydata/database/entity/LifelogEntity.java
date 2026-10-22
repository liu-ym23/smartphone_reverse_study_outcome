package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.LifeLogEntity;
import com.obric.lifelog.data.Lifelog;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeLifelogAppEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0016J\u0012\u00105\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u000fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J{\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\tHÖ\u0001J\t\u0010K\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u0007\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001e\u0010\f\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001a¨\u0006L"}, d2 = {"Lcom/obric/memorydata/database/entity/LifelogEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "lifelog", "Lcom/obric/lifelog/data/Lifelog;", "fullContent", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Lcom/obric/lifelog/data/Lifelog;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getCreateTime", "setCreateTime", "getModifyTime", "setModifyTime", "getType", "()I", "setType", "(I)V", "getTimestamp", "setTimestamp", "getPackageName", "setPackageName", "getHashCodeValue", "setHashCodeValue", "getUuid", "setUuid", "getLifelog", "()Lcom/obric/lifelog/data/Lifelog;", "getFullContent", "setFullContent", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/FakeLifelogAppEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifelogEntity extends d {
    private long createTime;
    private String entityId;
    private String fullContent;
    private int hashCodeValue;
    private long id;
    private final Lifelog lifelog;
    private long modifyTime;
    private String packageName;
    private long timestamp;
    private int type;
    private String uuid;

    public LifelogEntity(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, Lifelog r36, String r37) {
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
    }

    public /* synthetic */ LifelogEntity(long r21, String r23, long r24, long r26, int r28, long r29, String r31, int r32, String r33, Lifelog r34, String r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r36 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r36 & 8) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r36 & 16) == 0) goto L21;
        int r12 = 1401;
    L23:
        if ((r36 & 32) == 0) goto L25;
        long r13 = System.currentTimeMillis();
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r15 = AppContext.INSTANCE.getPackageName();
    L31:
        if ((r36 & 128) == 0) goto L33;
        int r16 = 0;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r17 = UUID.randomUUID().toString();
    L39:
        if ((r36 & 1024) == 0) goto L41;
        String r19 = null;
    L42:
        this(r5, r7, r8, r10, r12, r13, r15, r16, r17, r34, r19);
        return;
    L41:
        r19 = r35;
        goto L42
    L37:
        r17 = r33;
        goto L39
    L33:
        r16 = r32;
        goto L35
    L29:
        r15 = r31;
        goto L31
    L25:
        r13 = r29;
        goto L27
    L21:
        r12 = r28;
        goto L23
    L17:
        r10 = r26;
        goto L19
    L13:
        r8 = r24;
        goto L15
    L9:
        r7 = r23;
        goto L11
    L5:
        r5 = r21;
        goto L7
    }

    public static /* synthetic */ LifelogEntity copy$default(LifelogEntity r16, long r17, String r19, long r20, long r22, int r24, long r25, String r27, int r28, String r29, Lifelog r30, String r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r4 = r16.entityId;
    L11:
        if ((r32 & 4) == 0) goto L13;
        long r5 = r16.createTime;
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r7 = r16.modifyTime;
    L19:
        if ((r32 & 16) == 0) goto L21;
        int r9 = r16.type;
    L23:
        if ((r32 & 32) == 0) goto L25;
        long r10 = r16.timestamp;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r12 = r16.packageName;
    L31:
        if ((r32 & 128) == 0) goto L33;
        int r13 = r16.hashCodeValue;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r14 = r16.uuid;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Lifelog r15 = r16.lifelog;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r1 = r16.fullContent;
    L47:
        return r16.copy(r2, r4, r5, r7, r9, r10, r12, r13, r14, r15, r1);
    L45:
        r1 = r31;
        goto L47
    L41:
        r15 = r30;
        goto L43
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
        return (AppEntity) ZeusTransformUtils.preCheckCast(new LifeLogEntity(getEntityId(), getCreateTime(), getModifyTime(), this.lifelog.getTitle(), this.lifelog.getFinalContent()), AppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public /* synthetic */ AbstractFakeAppEntity convertToFakeAppEntity() {
        return (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(convertToFakeAppEntity(), AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public FakeLifelogAppEntity convertToFakeAppEntity() {
        return new FakeLifelogAppEntity(this);
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new ch(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new cf(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final LifelogEntity copy(long r18, String r20, long r21, long r23, int r25, long r26, String r28, int r29, String r30, Lifelog r31, String r32) {
        Intrinsics.checkNotNullParameter(r20, "entityId");
        Intrinsics.checkNotNullParameter(r28, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r31, "lifelog");
        return new LifelogEntity(r18, r20, r21, r23, r25, r26, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, LifelogEntity.class) == true) goto L8;
        return false;
    L8:
        LifelogEntity r10 = (LifelogEntity) ZeusTransformUtils.preCheckCast(r9, LifelogEntity.class, "com.obric.memorydata.plugin");
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
        if (Intrinsics.areEqual(this.fullContent, r10.fullContent) == true) goto L41;
        return false;
    L41:
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
        return r4 + r2;
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
        r0.append("LifelogEntity(id=").append(this.id).append(", entityId=").append(this.entityId).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", type=").append(this.type).append(", timestamp=").append(this.timestamp).append(", packageName=").append(this.packageName).append(", hashCodeValue=").append(this.hashCodeValue).append(", uuid=").append(this.uuid).append(", lifelog=").append(this.lifelog).append(", fullContent=").append(this.fullContent).append(')');
        return r0.toString();
    }
}
