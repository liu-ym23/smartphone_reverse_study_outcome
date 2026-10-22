package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/entity/UserKeywordEntity;", "", OaidModel.KEY_ID, "", ActivityLifecycle.NAME, "", "summary", "sources", "", "", "userEdit", "", "createTime", "updateTime", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZJJ)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getSummary", "getSources", "()Ljava/util/List;", "getUserEdit", "()Z", "getCreateTime", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class jc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9258b;
    private final String c;
    private final List<Integer> d;
    private final boolean e;
    private final long f;
    private final long g;

    public jc(long r3, String r5, String r6, List<Integer> r7, boolean r8, long r9, long r11) {
        List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "summary");
        Intrinsics.checkNotNullParameter(r10, "sources");
        this.f9257a = r3;
        this.f9258b = r5;
        this.c = r6;
        this.d = r10;
        this.e = r8;
        this.f = r9;
        this.g = r11;
    }

    public /* synthetic */ jc(long r13, String r15, String r16, List r17, boolean r18, long r19, long r21, int r23, DefaultConstructorMarker r24) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        if ((r23 & 1) == 0) goto L5;
        long r2 = 0;
    L7:
        if ((r23 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r23 & 32) == 0) goto L13;
        long r8 = System.currentTimeMillis();
    L15:
        if ((r23 & 64) == 0) goto L17;
        long r10 = System.currentTimeMillis();
    L18:
        this(r2, r15, r16, r6, r7, r8, r10);
        return;
    L17:
        r10 = r21;
        goto L18
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final long a() {
        return this.f9257a;
    }

    public final String b() {
        return this.f9258b;
    }

    public final String c() {
        return this.c;
    }

    public final List<Integer> d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, jc.class) == true) goto L8;
        return false;
    L8:
        jc r10 = (jc) ZeusTransformUtils.preCheckCast(r9, jc.class, "com.obric.memorydata.plugin");
        if (this.f9257a == r10.f9257a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9258b, r10.f9258b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.f9257a) * 31) + this.f9258b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g);
    }

    public String toString() {
        return "UserKeywordEntity(id=" + this.f9257a + ", name=" + this.f9258b + ", summary=" + this.c + ", sources=" + this.d + ", userEdit=" + this.e + ", createTime=" + this.f + ", updateTime=" + this.g + ')';
    }
}
