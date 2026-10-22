package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;", "", "zipEntries", "", "xmlEntries", "xmlNameTokens", "estimatedExpatNameRefs", "scannedXmlBytes", "", "<init>", "(IIIIJ)V", "getZipEntries", "()I", "getXmlEntries", "getXmlNameTokens", "getEstimatedExpatNameRefs", "getScannedXmlBytes", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9672b;
    private final int c;
    private final int d;
    private final long e;

    public w(int r1, int r2, int r3, int r4, long r5) {
        this.f9671a = r1;
        this.f9672b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, w.class) == true) goto L8;
        return false;
    L8:
        w r8 = (w) ZeusTransformUtils.preCheckCast(r7, w.class, "com.obric.memorydata.plugin");
        if (this.f9671a == r8.f9671a) goto L12;
        return false;
    L12:
        if (this.f9672b == r8.f9672b) goto L15;
        return false;
    L15:
        if (this.c == r8.c) goto L18;
        return false;
    L18:
        if (this.d == r8.d) goto L21;
        return false;
    L21:
        if (this.e == r8.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f9671a) * 31) + Integer.hashCode(this.f9672b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "PptxPreflightStats(zipEntries=" + this.f9671a + ", xmlEntries=" + this.f9672b + ", xmlNameTokens=" + this.c + ", estimatedExpatNameRefs=" + this.d + ", scannedXmlBytes=" + this.e + ')';
    }
}
