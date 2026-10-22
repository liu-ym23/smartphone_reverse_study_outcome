package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemorySemanticRelevantData;", "", OaidModel.KEY_ID, "", "memoryId", "ruleId", "createTime", "sourceType", "", "<init>", "(JJJJLjava/lang/String;)V", "getId", "()J", "getMemoryId", "getRuleId", "getCreateTime", "getSourceType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8866b;
    private final long c;
    private final long d;
    private final String e;

    public ab(long r2, long r4, long r6, long r8, String r10) {
        Intrinsics.checkNotNullParameter(r10, "sourceType");
        this.f8865a = r2;
        this.f8866b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r10;
    }

    public /* synthetic */ ab(long r13, long r15, long r17, long r19, String r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r22 & 16) == 0) goto L9;
        String r11 = "screen_observation";
    L10:
        this(r3, r15, r17, r19, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r3 = r13;
        goto L7
    }

    public final long a() {
        return this.f8865a;
    }

    public final long b() {
        return this.f8866b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == true) goto L8;
        return false;
    L8:
        ab r10 = (ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin");
        if (this.f8865a == r10.f8865a) goto L12;
        return false;
    L12:
        if (this.f8866b == r10.f8866b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f8865a) * 31) + Long.hashCode(this.f8866b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "AutoMemorySemanticRelevantData(id=" + this.f8865a + ", memoryId=" + this.f8866b + ", ruleId=" + this.c + ", createTime=" + this.d + ", sourceType=" + this.e + ')';
    }
}
