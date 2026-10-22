package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/entity/ProactiveMemoryProcessInfoEntity;", "", OaidModel.KEY_ID, "", "timestamp", "type", "", Params.CONTENT, "", "<init>", "(JJILjava/lang/String;)V", "getId", "()J", "getTimestamp", "getType", "()I", "getContent", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class eu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9097b;
    private final int c;
    private final String d;

    public eu(long r2, long r4, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, Params.CONTENT);
        this.f9096a = r2;
        this.f9097b = r4;
        this.c = r6;
        this.d = r7;
    }

    public final long a() {
        return this.f9096a;
    }

    public final long b() {
        return this.f9097b;
    }

    public final String c() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, eu.class) == true) goto L8;
        return false;
    L8:
        eu r10 = (eu) ZeusTransformUtils.preCheckCast(r9, eu.class, "com.obric.memorydata.plugin");
        if (this.f9096a == r10.f9096a) goto L12;
        return false;
    L12:
        if (this.f9097b == r10.f9097b) goto L15;
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
        return this.c;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f9096a) * 31) + Long.hashCode(this.f9097b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ProactiveMemoryProcessInfoEntity(id=" + this.f9096a + ", timestamp=" + this.f9097b + ", type=" + this.c + ", content=" + this.d + ')';
    }
}
