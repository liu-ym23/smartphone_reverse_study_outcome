package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u0006."}, d2 = {"Lcom/obric/memorydata/database/entity/PackageEventEntity;", "", "dataId", "", "dataVersion", "timestamp", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "displayName", "versionName", "versionCode", "isSystemApp", "", "event", OaidModel.KEY_ID, "<init>", "(IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;J)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getPackageName", "()Ljava/lang/String;", "getDisplayName", "getVersionName", "getVersionCode", "()Z", "getEvent", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9065b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;
    private final long g;
    private final boolean h;
    private final String i;
    private final long j;

    public ed(int r2, int r3, long r4, String r6, String r7, String r8, long r9, boolean r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r7, "displayName");
        Intrinsics.checkNotNullParameter(r8, "versionName");
        Intrinsics.checkNotNullParameter(r12, "event");
        this.f9064a = r2;
        this.f9065b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r11;
        this.i = r12;
        this.j = r13;
    }

    public /* synthetic */ ed(int r17, int r18, long r19, String r21, String r22, String r23, long r24, boolean r26, String r27, long r28, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 512) == 0) goto L5;
        long r14 = 0;
    L6:
        this(r17, r18, r19, r21, r22, r23, r24, r26, r27, r14);
        return;
    L5:
        r14 = r28;
        goto L6
    }

    public final int a() {
        return this.f9064a;
    }

    public final int b() {
        return this.f9065b;
    }

    public final long c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ed.class) == true) goto L8;
        return false;
    L8:
        ed r10 = (ed) ZeusTransformUtils.preCheckCast(r9, ed.class, "com.obric.memorydata.plugin");
        if (this.f9064a == r10.f9064a) goto L12;
        return false;
    L12:
        if (this.f9065b == r10.f9065b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.f9064a) * 31) + Integer.hashCode(this.f9065b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j);
    }

    public final String i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }

    public String toString() {
        return "PackageEventEntity(dataId=" + this.f9064a + ", dataVersion=" + this.f9065b + ", timestamp=" + this.c + ", packageName=" + this.d + ", displayName=" + this.e + ", versionName=" + this.f + ", versionCode=" + this.g + ", isSystemApp=" + this.h + ", event=" + this.i + ", id=" + this.j + ')';
    }
}
