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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u0005H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\r\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0014\u0010\u000f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u0006*"}, d2 = {"Lcom/obric/memorydata/database/entity/RawNoteRecordingTextEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", "parentEntityId", Params.CONTENT, "passageDocNodeTreeJson", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getParentEntityId", "getContent", "getPassageDocNodeTreeJson", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class gy extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9170b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private final String i;
    private final String j;
    private final String k;

    public gy(long r9, String r11, long r12, long r14, int r16, long r17, String r19, int r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r11, "entityId");
        Intrinsics.checkNotNullParameter(r19, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r21, "parentEntityId");
        Intrinsics.checkNotNullParameter(r22, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r23, "passageDocNodeTreeJson");
        super(r9, r11, r12, r14, r16, r17, r19, r20, r21, r22, r23);
        this.f9169a = r9;
        this.f9170b = r11;
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

    public /* synthetic */ gy(long r19, String r21, long r22, long r24, int r26, long r27, String r29, int r30, String r31, String r32, String r33, int r34, DefaultConstructorMarker r35) {
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
        return (i) ZeusTransformUtils.preCheckCast(new dz(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9170b;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9169a;
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

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9169a = r1;
    }

    @Override // com.obric.memorydata.database.entity.f, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }
}
