package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryEntityToCalendar;", "", OaidModel.KEY_ID, "", "memoryEntityId", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getMemoryEntityId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8991b;

    public cr(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "memoryEntityId");
        this.f8990a = r2;
        this.f8991b = r4;
    }

    public /* synthetic */ cr(long r1, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1, r3);
    }

    public final long a() {
        return this.f8990a;
    }

    public final String b() {
        return this.f8991b;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, cr.class) == true) goto L8;
        return false;
    L8:
        cr r10 = (cr) ZeusTransformUtils.preCheckCast(r9, cr.class, "com.obric.memorydata.plugin");
        if (this.f8990a == r10.f8990a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8991b, r10.f8991b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f8990a) * 31) + this.f8991b.hashCode();
    }

    public String toString() {
        return "MemoryEntityToCalendar(id=" + this.f8990a + ", memoryEntityId=" + this.f8991b + ')';
    }
}
