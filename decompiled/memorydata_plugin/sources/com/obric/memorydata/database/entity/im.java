package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/entity/SettingsChangedEntity;", "", "dataId", "", "dataVersion", "timestamp", "", ActivityLifecycle.NAME, "", EventBody.KEY_VALUE, OaidModel.KEY_ID, "<init>", "(IIJLjava/lang/String;IJ)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getName", "()Ljava/lang/String;", "getValue", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class im {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9226b;
    private final long c;
    private final String d;
    private final int e;
    private final long f;

    public im(int r2, int r3, long r4, String r6, int r7, long r8) {
        Intrinsics.checkNotNullParameter(r6, ActivityLifecycle.NAME);
        this.f9225a = r2;
        this.f9226b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    public /* synthetic */ im(int r12, int r13, long r14, String r16, int r17, long r18, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 32) == 0) goto L5;
        long r9 = 0;
    L6:
        this(r12, r13, r14, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final int a() {
        return this.f9225a;
    }

    public final int b() {
        return this.f9226b;
    }

    public final long c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, im.class) == true) goto L8;
        return false;
    L8:
        im r10 = (im) ZeusTransformUtils.preCheckCast(r9, im.class, "com.obric.memorydata.plugin");
        if (this.f9225a == r10.f9225a) goto L12;
        return false;
    L12:
        if (this.f9226b == r10.f9226b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f9225a) * 31) + Integer.hashCode(this.f9226b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "SettingsChangedEntity(dataId=" + this.f9225a + ", dataVersion=" + this.f9226b + ", timestamp=" + this.c + ", name=" + this.d + ", value=" + this.e + ", id=" + this.f + ')';
    }
}
