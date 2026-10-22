package com.obric.memorydata.database.legacy.backup.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.SlmAutoMemoryProTempResultEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/memorydata/database/legacy/backup/entity/BackUpSlmAutoMemoryProTempResultEntityOld;", "Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;", "Lcom/obric/memorydata/database/legacy/entity/SlmAutoMemoryProTempResultEntityOld;", OaidModel.KEY_ID, "", "raw", "backupUserId", "", "backupDbVersion", "", "<init>", "(JLcom/obric/memorydata/database/legacy/entity/SlmAutoMemoryProTempResultEntityOld;Ljava/lang/String;I)V", "getId", "()J", "setId", "(J)V", "getRaw", "()Lcom/obric/memorydata/database/legacy/entity/SlmAutoMemoryProTempResultEntityOld;", "getBackupUserId", "()Ljava/lang/String;", "getBackupDbVersion", "()I", "convertToOriginalEntity", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "convertToBackUpEntity", "originalEntity", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t extends com.obric.memorydata.database.backup.a.a<SlmAutoMemoryProTempResultEntityOld> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9472b;
    private final SlmAutoMemoryProTempResultEntityOld c;
    private final String d;
    private final int e;

    public t(long r2, SlmAutoMemoryProTempResultEntityOld r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "raw");
        Intrinsics.checkNotNullParameter(r5, "backupUserId");
        super(r5, r6);
        this.f9472b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ t(long r7, SlmAutoMemoryProTempResultEntityOld r9, String r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        long r1 = r7;
        if ((r12 & 8) == 0) goto L8;
        r11 = 0;
    L8:
        this(r1, r9, r10, r11);
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public /* synthetic */ com.obric.memorydata.database.backup.a.a<SlmAutoMemoryProTempResultEntityOld> a(SlmAutoMemoryProTempResultEntityOld r3, String r4, int r5) {
        return (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(a2((SlmAutoMemoryProTempResultEntityOld) ZeusTransformUtils.preCheckCast(r3, SlmAutoMemoryProTempResultEntityOld.class, "com.obric.memorydata.plugin"), r4, r5), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public t a2(SlmAutoMemoryProTempResultEntityOld r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "originalEntity");
        Intrinsics.checkNotNullParameter(r10, "backupUserId");
        return new t(0, r9, r10, r11, 1, null);
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public String a() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public void a(long r1) {
        this.f9472b = r1;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public int b() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public long c() {
        return this.f9472b;
    }

    @Override // com.obric.memorydata.database.backup.a.a
    public /* synthetic */ SlmAutoMemoryProTempResultEntityOld d() {
        return f();
    }

    public final SlmAutoMemoryProTempResultEntityOld e() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, t.class) == true) goto L8;
        return false;
    L8:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r9, t.class, "com.obric.memorydata.plugin");
        if (this.f9472b == r10.f9472b) goto L12;
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

    public SlmAutoMemoryProTempResultEntityOld f() {
        return this.c;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f9472b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "BackUpSlmAutoMemoryProTempResultEntityOld(id=" + this.f9472b + ", raw=" + this.c + ", backupUserId=" + this.d + ", backupDbVersion=" + this.e + ')';
    }
}
