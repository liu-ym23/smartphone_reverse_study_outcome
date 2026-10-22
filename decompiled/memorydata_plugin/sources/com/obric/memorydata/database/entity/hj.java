package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u0005H\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003Jw\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\tHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\r\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0014\u0010\u000f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u0006<"}, d2 = {"Lcom/obric/memorydata/database/entity/RawRecordingTextEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", "parentEntityId", Params.CONTENT, "passageDocNodeTreeJson", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getParentEntityId", "getContent", "getPassageDocNodeTreeJson", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hj extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9184b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private final String i;
    private final String j;
    private final String k;

    public hj(long r9, String r11, long r12, long r14, int r16, long r17, String r19, int r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r11, "entityId");
        Intrinsics.checkNotNullParameter(r19, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r21, "parentEntityId");
        Intrinsics.checkNotNullParameter(r22, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r23, "passageDocNodeTreeJson");
        super(r9, r11, r12, r14, r16, r17, r19, r20, r21, r22, r23);
        this.f9183a = r9;
        this.f9184b = r11;
        this.c = r12;
        this.d = r14;
        this.e = r16;
        this.f = r17;
        this.g = r19;
        this.h = r20;
        this.i = r21;
        this.j = r22;
        this.k = r23;
    }

    public /* synthetic */ hj(long r19, String r21, long r22, long r24, int r26, long r27, String r29, int r30, String r31, String r32, String r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r34 & 32) == 0) goto L9;
        long r11 = System.currentTimeMillis();
    L10:
        this(r3, r21, r22, r24, r26, r11, r29, r30, r31, r32, r33);
        return;
    L9:
        r11 = r27;
        goto L10
    L5:
        r3 = r19;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.f
    public String a() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.f
    public String b() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.f
    public String c() {
        return this.k;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new hy(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, hj.class) == true) goto L8;
        return false;
    L8:
        hj r10 = (hj) ZeusTransformUtils.preCheckCast(r9, hj.class, "com.obric.memorydata.plugin");
        if (this.f9183a == r10.f9183a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9184b, r10.f9184b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9184b;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9183a;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    public int hashCode() {
        return (((((((((((((((((((Long.hashCode(this.f9183a) * 31) + this.f9184b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9183a = r1;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawRecordingTextEntity(id=").append(this.f9183a).append(", entityId=").append(this.f9184b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", parentEntityId=").append(this.i).append(", content=").append(this.j).append(", passageDocNodeTreeJson=").append(this.k).append(')');
        return r0.toString();
    }
}
