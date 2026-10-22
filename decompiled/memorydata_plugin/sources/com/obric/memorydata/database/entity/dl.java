package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/entity/MetaFullContentKeywordCopilotEntity;", "", OaidModel.KEY_ID, "", "type", "", "rawDbId", "uid", "", "<init>", "(JIJLjava/lang/String;)V", "getId", "()J", "getType", "()I", "getRawDbId", "getUid", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9031b;
    private final long c;
    private final String d;

    public dl(long r2, int r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "uid");
        this.f9030a = r2;
        this.f9031b = r4;
        this.c = r5;
        this.d = r7;
    }

    public /* synthetic */ dl(long r8, int r10, long r11, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = 0;
    L5:
        long r1 = r8;
        if ((r14 & 8) == 0) goto L8;
        r13 = "";
    L8:
        this(r1, r10, r11, r13);
    }

    public final long a() {
        return this.f9030a;
    }

    public final long b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, dl.class) == true) goto L8;
        return false;
    L8:
        dl r10 = (dl) ZeusTransformUtils.preCheckCast(r9, dl.class, "com.obric.memorydata.plugin");
        if (this.f9030a == r10.f9030a) goto L12;
        return false;
    L12:
        if (this.f9031b == r10.f9031b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getType() {
        return this.f9031b;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f9030a) * 31) + Integer.hashCode(this.f9031b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "MetaFullContentKeywordCopilotEntity(id=" + this.f9030a + ", type=" + this.f9031b + ", rawDbId=" + this.c + ", uid=" + this.d + ')';
    }
}
