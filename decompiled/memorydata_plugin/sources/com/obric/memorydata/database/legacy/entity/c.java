package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/AutoMemoryProEntityTextVectorCopilotEntityOld;", "Lcom/obric/memorydata/database/entity/AbstractTextVectorCopilotEntity;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "personalDbSplitMigrated", "", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Z)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "getText", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.database.entity.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9509b;
    private final String c;
    private final String d;
    private final boolean e;

    public c(long r2, long r4, String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "rawDbColumn");
        Intrinsics.checkNotNullParameter(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        super(r2, r4, r6, r7);
        this.f9508a = r2;
        this.f9509b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public long a() {
        return this.f9508a;
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public long b() {
        return this.f9509b;
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public String c() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.h
    public String d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
        if (this.f9508a == r10.f9508a) goto L12;
        return false;
    L12:
        if (this.f9509b == r10.f9509b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f9508a) * 31) + Long.hashCode(this.f9509b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "AutoMemoryProEntityTextVectorCopilotEntityOld(id=" + this.f9508a + ", rawDbId=" + this.f9509b + ", rawDbColumn=" + this.c + ", text=" + this.d + ", personalDbSplitMigrated=" + this.e + ')';
    }
}
