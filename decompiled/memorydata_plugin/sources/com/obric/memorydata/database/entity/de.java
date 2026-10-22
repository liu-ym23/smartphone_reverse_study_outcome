package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/entity/MemorySourceSemanticImageRelationEntity;", "", OaidModel.KEY_ID, "", "sourceImageHash", "", "productType", "", "semanticId", "rememberedTime", "<init>", "(JLjava/lang/String;ILjava/lang/String;J)V", "getId", "()J", "getSourceImageHash", "()Ljava/lang/String;", "getProductType", "()I", "getSemanticId", "getRememberedTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9017b;
    private final int c;
    private final String d;
    private final long e;

    public de(long r2, String r4, int r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r4, "sourceImageHash");
        this.f9016a = r2;
        this.f9017b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }

    public /* synthetic */ de(long r11, String r13, int r14, String r15, long r16, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r18 & 4) == 0) goto L9;
        int r6 = 0;
    L11:
        if ((r18 & 16) == 0) goto L13;
        long r8 = System.currentTimeMillis();
    L14:
        this(r3, r13, r6, r15, r8);
        return;
    L13:
        r8 = r16;
        goto L14
    L9:
        r6 = r14;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final long a() {
        return this.f9016a;
    }

    public final String b() {
        return this.f9017b;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, de.class) == true) goto L8;
        return false;
    L8:
        de r10 = (de) ZeusTransformUtils.preCheckCast(r9, de.class, "com.obric.memorydata.plugin");
        if (this.f9016a == r10.f9016a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9017b, r10.f9017b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
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
        int r0 = ((((Long.hashCode(this.f9016a) * 31) + this.f9017b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        String r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.e);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MemorySourceSemanticImageRelationEntity(id=" + this.f9016a + ", sourceImageHash=" + this.f9017b + ", productType=" + this.c + ", semanticId=" + this.d + ", rememberedTime=" + this.e + ')';
    }
}
