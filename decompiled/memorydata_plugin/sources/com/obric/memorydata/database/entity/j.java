package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b)\b&\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\n\u00100\u001a\u0004\u0018\u00010\u0005H&J\b\u00101\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010+R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010+R\u001a\u0010\u0012\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018¨\u00062"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractVideoFrameEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", "startTime", "endTime", "frameTime", "caption", "ocr", "photoEntityDbId", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getStartTime", "setStartTime", "getEndTime", "setEndTime", "getFrameTime", "setFrameTime", "getCaption", "setCaption", "(Ljava/lang/String;)V", "getOcr", "setOcr", "getPhotoEntityDbId", "setPhotoEntityDbId", "getFileEntityJson", "getPhotoEntityType", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9252b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private long i;
    private long j;
    private long k;
    private String l;
    private String m;
    private long n;

    /* JADX WARN: Multi-variable type inference failed */
    public j(long r20, String r22, long r23, long r25, int r27, long r28, String r30, int r31, long r32, long r34, long r36, String r38, String r39, long r40) {
        Intrinsics.checkNotNullParameter(r22, "entityId");
        Intrinsics.checkNotNullParameter(r30, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Object[] r15 = 0 == true ? 1 : 0;
        Object[] r16 = 0 == true ? 1 : 0;
        super(r20, r22, r23, r25, r27, r28, r30, r31, null, r15, r16, null, CaeNfcCardInfo.LIFE_CYCLE_INACTIVE, null);
        this.f9251a = r20;
        this.f9252b = r22;
        this.c = r23;
        this.d = r25;
        this.e = r27;
        this.f = r28;
        this.g = r30;
        this.h = r31;
        this.i = r32;
        this.j = r34;
        this.k = r36;
        this.l = r38;
        this.m = r39;
        this.n = r40;
    }

    public long a() {
        return this.i;
    }

    public void a(String r1) {
        this.l = r1;
    }

    public long b() {
        return this.j;
    }

    public void b(String r1) {
        this.m = r1;
    }

    public long c() {
        return this.k;
    }

    public String d() {
        return this.l;
    }

    public String e() {
        return this.m;
    }

    public long f() {
        return this.n;
    }

    public abstract String g();

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9252b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9251a;
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

    public abstract int h();

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9251a = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }
}
