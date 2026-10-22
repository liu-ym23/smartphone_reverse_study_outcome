package com.obric.memorydata.database.legacy.backup.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/memorydata/database/legacy/backup/entity/BackUpAutoMemorySemanticRelevantDataEntityOld;", "Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;", "Lcom/obric/memorydata/database/legacy/entity/AutoMemorySemanticRelevantDataOld;", OaidModel.KEY_ID, "", "autoMemorySemanticRelevantData", "backupUserId", "", "backupDbVersion", "", "<init>", "(JLcom/obric/memorydata/database/legacy/entity/AutoMemorySemanticRelevantDataOld;Ljava/lang/String;I)V", "getId", "()J", "setId", "(J)V", "getAutoMemorySemanticRelevantData", "()Lcom/obric/memorydata/database/legacy/entity/AutoMemorySemanticRelevantDataOld;", "getBackupUserId", "()Ljava/lang/String;", "getBackupDbVersion", "()I", "convertToOriginalEntity", "convertToBackUpEntity", "originalEntity", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends com.obric.memorydata.database.backup.a.a<com.obric.memorydata.database.legacy.entity.g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9458b;
    private final com.obric.memorydata.database.legacy.entity.g c;
    private final String d;
    private final int e;

    public f(long r2, com.obric.memorydata.database.legacy.entity.g r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "autoMemorySemanticRelevantData");
        Intrinsics.checkNotNullParameter(r5, "backupUserId");
        super(r5, r6);
        this.f9458b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ f(long r7, com.obric.memorydata.database.legacy.entity.g r9, String r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        long r1 = r7;
        if ((r12 & 8) == 0) goto L8;
        r11 = 0;
    L8:
        this(r1, r9, r10, r11);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.obric.memorydata.database.backup.a.a<com.obric.memorydata.database.legacy.entity.g> a2(com.obric.memorydata.database.legacy.entity.g r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "originalEntity");
        Intrinsics.checkNotNullParameter(r10, "backupUserId");
        return (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(new f(0, r9, r10, r11, 1, null), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public /* synthetic */ com.obric.memorydata.database.backup.a.a<com.obric.memorydata.database.legacy.entity.g> a(com.obric.memorydata.database.legacy.entity.g r3, String r4, int r5) {
        return a2((com.obric.memorydata.database.legacy.entity.g) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.g.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public String a() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public void a(long r1) {
        this.f9458b = r1;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public int b() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public long c() {
        return this.f9458b;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public /* synthetic */ com.obric.memorydata.database.legacy.entity.g d() {
        return f();
    }

    public final com.obric.memorydata.database.legacy.entity.g e() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (this.f9458b == r10.f9458b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L20;
        return false;
    L20:
        return true;
    }

    public com.obric.memorydata.database.legacy.entity.g f() {
        return this.c;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f9458b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "BackUpAutoMemorySemanticRelevantDataEntityOld(id=" + this.f9458b + ", autoMemorySemanticRelevantData=" + this.c + ", backupUserId=" + this.d + ", backupDbVersion=" + this.e + ')';
    }
}
