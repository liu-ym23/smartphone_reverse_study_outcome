package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeEpisodicTopicMemoryAppEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0016J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0085\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\fHÖ\u0001J\t\u0010D\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u0014\u0010\u000e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0014\u0010\u000f\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010&¨\u0006E"}, d2 = {"Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "summary", "", "relateIds", "logId", "entityId", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getSummary", "()Ljava/lang/String;", "getRelateIds", "getLogId", "getEntityId", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/FakeEpisodicTopicMemoryAppEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bp extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8939b;
    private final String c;
    private final String d;
    private final String e;
    private final long f;
    private final long g;
    private final int h;
    private long i;
    private final String j;
    private final int k;
    private String l;

    public bp(long r23, String r25, String r26, String r27, String r28, long r29, long r31, int r33, long r34, String r36, int r37, String r38) {
        Intrinsics.checkNotNullParameter(r25, "summary");
        Intrinsics.checkNotNullParameter(r26, "relateIds");
        Intrinsics.checkNotNullParameter(r28, "entityId");
        Intrinsics.checkNotNullParameter(r36, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Integer r2 = null;
        super(r23, r28, r29, r31, r33, r34, r36, r37, r38, r2, r2, null, 3584, null);
        this.f8938a = r23;
        this.f8939b = r25;
        this.c = r26;
        this.d = r27;
        this.e = r28;
        this.f = r29;
        this.g = r31;
        this.h = r33;
        this.i = r34;
        this.j = r36;
        this.k = r37;
        this.l = r38;
    }

    public /* synthetic */ bp(long r21, String r23, String r24, String r25, String r26, long r27, long r29, int r31, long r32, String r34, int r35, String r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r37 & 256) == 0) goto L9;
        long r15 = System.currentTimeMillis();
    L11:
        if ((r37 & 2048) == 0) goto L13;
        String r19 = UUID.randomUUID().toString();
    L14:
        this(r4, r23, r24, r25, r26, r27, r29, r31, r15, r34, r35, r19);
        return;
    L13:
        r19 = r36;
        goto L14
    L9:
        r15 = r32;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }

    public final String a() {
        return this.f8939b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public /* synthetic */ AbstractFakeAppEntity convertToFakeAppEntity() {
        return (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(d(), AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new bq(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new bs(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public FakeEpisodicTopicMemoryAppEntity d() {
        return new FakeEpisodicTopicMemoryAppEntity(this);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bp.class) == true) goto L8;
        return false;
    L8:
        bp r10 = (bp) ZeusTransformUtils.preCheckCast(r9, bp.class, "com.obric.memorydata.plugin");
        if (this.f8938a == r10.f8938a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8939b, r10.f8939b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.k;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f8938a;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.l;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.f8938a) * 31) + this.f8939b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((((r0 + r3) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31;
        String r5 = this.l;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f8938a = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.i = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.l = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("EpisodicTopicMemoryEntity(id=").append(this.f8938a).append(", summary=").append(this.f8939b).append(", relateIds=").append(this.c).append(", logId=").append(this.d).append(", entityId=").append(this.e).append(", createTime=").append(this.f).append(", modifyTime=").append(this.g).append(", type=").append(this.h).append(", timestamp=").append(this.i).append(", packageName=").append(this.j).append(", hashCodeValue=").append(this.k).append(", uuid=");
        r0.append(this.l).append(')');
        return r0.toString();
    }
}
