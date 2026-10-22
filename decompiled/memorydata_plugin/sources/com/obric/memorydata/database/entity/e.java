package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010!R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractRawFileDbEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "docNodeJson", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getDocNodeJson", "setDocNodeJson", "relevantTextContent", "", "getRelevantTextContent", "()Ljava/util/List;", "setRelevantTextContent", "(Ljava/util/List;)V", "createFileTextEntity", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", "passageMaterial", "Lcom/obric/memorydata/database/util/file_utils/PassageGenerator$PassageMaterial;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9057b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private String i;
    private String j;
    private transient List<String> k;

    public e(long r21, String r23, long r24, long r26, int r28, long r29, String r31, int r32, String r33, String r34) {
        Intrinsics.checkNotNullParameter(r23, "entityId");
        Intrinsics.checkNotNullParameter(r31, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Integer r0 = null;
        super(r21, r23, r24, r26, r28, r29, r31, r32, r33, r0, r0, null, 3584, null);
        this.f9056a = r21;
        this.f9057b = r23;
        this.c = r24;
        this.d = r26;
        this.e = r28;
        this.f = r29;
        this.g = r31;
        this.h = r32;
        this.i = r33;
        this.j = r34;
    }

    public /* synthetic */ e(long r19, String r21, long r22, long r24, int r26, long r27, String r29, int r30, String r31, String r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r33 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r33 & 256) == 0) goto L13;
        String r16 = null;
    L15:
        if ((r33 & 512) == 0) goto L17;
        String r17 = null;
    L18:
        this(r4, r21, r22, r24, r26, r12, r29, r30, r16, r17);
        return;
    L17:
        r17 = r32;
        goto L18
    L13:
        r16 = r31;
        goto L15
    L9:
        r12 = r27;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public abstract f a(com.obric.memorydata.database.util.file_utils.s.a r1);

    public String a() {
        return this.j;
    }

    public void a(String r1) {
        this.j = r1;
    }

    public void a(List<String> r3) {
        this.k = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public List<String> b() {
        return this.k;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9057b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9056a;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9056a = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.i = r1;
    }
}
