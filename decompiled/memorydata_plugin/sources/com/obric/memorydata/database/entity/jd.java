package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/entity/UserKeywordRefEntity;", "", OaidModel.KEY_ID, "", "keywordId", "semanticEntityId", "", "<init>", "(JJLjava/lang/String;)V", "getId", "()J", "getKeywordId", "getSemanticEntityId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9260b;
    private final String c;

    public jd(long r2, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "semanticEntityId");
        this.f9259a = r2;
        this.f9260b = r4;
        this.c = r6;
    }

    public /* synthetic */ jd(long r7, long r9, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        this(r7, r9, r11);
    }

    public final long a() {
        return this.f9259a;
    }

    public final long b() {
        return this.f9260b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, jd.class) == true) goto L8;
        return false;
    L8:
        jd r10 = (jd) ZeusTransformUtils.preCheckCast(r9, jd.class, "com.obric.memorydata.plugin");
        if (this.f9259a == r10.f9259a) goto L12;
        return false;
    L12:
        if (this.f9260b == r10.f9260b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9259a) * 31) + Long.hashCode(this.f9260b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "UserKeywordRefEntity(id=" + this.f9259a + ", keywordId=" + this.f9260b + ", semanticEntityId=" + this.c + ')';
    }
}
