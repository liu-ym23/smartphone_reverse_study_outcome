package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/entity/GlassesEpisodicRelevantData;", "", OaidModel.KEY_ID, "", "episodicId", "", "speakerSummary", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getEpisodicId", "()Ljava/lang/String;", "getSpeakerSummary", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8955b;
    private final String c;

    public by(long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "episodicId");
        Intrinsics.checkNotNullParameter(r5, "speakerSummary");
        this.f8954a = r2;
        this.f8955b = r4;
        this.c = r5;
    }

    public /* synthetic */ by(long r1, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1, r3, r4);
    }

    public static /* synthetic */ by a(by r0, long r1, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f8954a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.f8955b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.c;
    L12:
        return r0.a(r1, r3, r4);
    }

    public final long a() {
        return this.f8954a;
    }

    public final by a(long r1, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "episodicId");
        Intrinsics.checkNotNullParameter(r4, "speakerSummary");
        return new by(r1, r3, r4);
    }

    public final String b() {
        return this.f8955b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, by.class) == true) goto L8;
        return false;
    L8:
        by r10 = (by) ZeusTransformUtils.preCheckCast(r9, by.class, "com.obric.memorydata.plugin");
        if (this.f8954a == r10.f8954a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8955b, r10.f8955b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f8954a) * 31) + this.f8955b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "GlassesEpisodicRelevantData(id=" + this.f8954a + ", episodicId=" + this.f8955b + ", speakerSummary=" + this.c + ')';
    }
}
