package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/entity/CommonPhotoEntityImageVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", "<init>", "(JJLjava/lang/String;)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class am extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8886b;
    private final String c;

    public am(long r2, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "rawDbColumn");
        super(r2, r4, r6);
        this.f8885a = r2;
        this.f8886b = r4;
        this.c = r6;
    }

    public /* synthetic */ am(long r7, long r9, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        this(r7, r9, r11);
    }

    @Override // com.obric.memorydata.database.entity.i
    public long a() {
        return this.f8885a;
    }

    @Override // com.obric.memorydata.database.entity.i
    public long b() {
        return this.f8886b;
    }

    @Override // com.obric.memorydata.database.entity.i
    public String c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, am.class) == true) goto L8;
        return false;
    L8:
        am r10 = (am) ZeusTransformUtils.preCheckCast(r9, am.class, "com.obric.memorydata.plugin");
        if (this.f8885a == r10.f8885a) goto L12;
        return false;
    L12:
        if (this.f8886b == r10.f8886b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f8885a) * 31) + Long.hashCode(this.f8886b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CommonPhotoEntityImageVectorCopilotEntity(id=" + this.f8885a + ", rawDbId=" + this.f8886b + ", rawDbColumn=" + this.c + ')';
    }
}
