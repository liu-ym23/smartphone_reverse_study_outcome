package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/entity/FileEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractTextVectorCopilotEntity;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "<init>", "(JJLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bv extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8949b;
    private final String c;
    private final String d;

    public bv(long r2, long r4, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "rawDbColumn");
        Intrinsics.checkNotNullParameter(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        super(r2, r4, r6, r7);
        this.f8948a = r2;
        this.f8949b = r4;
        this.c = r6;
        this.d = r7;
    }

    public /* synthetic */ bv(long r8, long r10, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = 0;
    L5:
        this(r8, r10, r12, r13);
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public long a() {
        return this.f8948a;
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public long b() {
        return this.f8949b;
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public String c() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.h
    public String d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bv.class) == true) goto L8;
        return false;
    L8:
        bv r10 = (bv) ZeusTransformUtils.preCheckCast(r9, bv.class, "com.obric.memorydata.plugin");
        if (this.f8948a == r10.f8948a) goto L12;
        return false;
    L12:
        if (this.f8949b == r10.f8949b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f8948a) * 31) + Long.hashCode(this.f8949b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "FileEntityTextVectorCopilotEntity(id=" + this.f8948a + ", rawDbId=" + this.f8949b + ", rawDbColumn=" + this.c + ", text=" + this.d + ')';
    }
}
