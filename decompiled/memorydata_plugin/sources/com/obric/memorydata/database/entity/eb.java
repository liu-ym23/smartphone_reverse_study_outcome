package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/entity/OsAudioPlayEntity;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "audioType", "outputType", "", "beginTimestamp", "", "endTimestamp", "timestamp", "duration", "dataVersion", OaidModel.KEY_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;IJJJJIJ)V", "getPackageName", "()Ljava/lang/String;", "getAudioType", "getOutputType", "()I", "getBeginTimestamp", "()J", "getEndTimestamp", "getTimestamp", "getDuration", "getDataVersion", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9061b;
    private final int c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final int h;
    private final long i;

    public eb(String r2, String r3, int r4, long r5, long r7, long r9, long r11, int r13, long r14) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "audioType");
        this.f9060a = r2;
        this.f9061b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r11;
        this.h = r13;
        this.i = r14;
    }

    public /* synthetic */ eb(String r18, String r19, int r20, long r21, long r23, long r25, long r27, int r29, long r30, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 256) == 0) goto L5;
        long r15 = 0;
    L6:
        this(r18, r19, r20, r21, r23, r25, r27, r29, r15);
        return;
    L5:
        r15 = r30;
        goto L6
    }

    public final String a() {
        return this.f9060a;
    }

    public final String b() {
        return this.f9061b;
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, eb.class) == true) goto L8;
        return false;
    L8:
        eb r10 = (eb) ZeusTransformUtils.preCheckCast(r9, eb.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9060a, r10.f9060a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9061b, r10.f9061b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((this.f9060a.hashCode() * 31) + this.f9061b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Long.hashCode(this.i);
    }

    public final long i() {
        return this.i;
    }

    public String toString() {
        return "OsAudioPlayEntity(packageName=" + this.f9060a + ", audioType=" + this.f9061b + ", outputType=" + this.c + ", beginTimestamp=" + this.d + ", endTimestamp=" + this.e + ", timestamp=" + this.f + ", duration=" + this.g + ", dataVersion=" + this.h + ", id=" + this.i + ')';
    }
}
