package com.obric.memorydata.database.util.file_utils;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/MutablePptxPreflightStats;", "", "<init>", "()V", "zipEntries", "", "getZipEntries", "()I", "setZipEntries", "(I)V", "xmlEntries", "getXmlEntries", "setXmlEntries", "xmlNameTokens", "getXmlNameTokens", "setXmlNameTokens", "estimatedExpatNameRefs", "getEstimatedExpatNameRefs", "setEstimatedExpatNameRefs", "scannedXmlBytes", "", "getScannedXmlBytes", "()J", "setScannedXmlBytes", "(J)V", "addXmlNameTokens", "", CommonConsts.COUNT_TYPE, "addEstimatedExpatNameRefs", "snapshot", "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightStats;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9664b;
    private int c;
    private int d;
    private long e;

    public r() {
    }

    public final int a() {
        return this.f9663a;
    }

    public final void a(int r1) {
        this.f9663a = r1;
    }

    public final void a(long r1) {
        this.e = r1;
    }

    public final int b() {
        return this.f9664b;
    }

    public final void b(int r1) {
        this.f9664b = r1;
    }

    public final long c() {
        return this.e;
    }

    public final void c(int r3) {
        int r0 = this.c;
        if (r3 > (1000000 - r0)) goto L7;
        this.c = r0 + r3;
        return;
    L7:
        throw new PptxPreflightLimitException(PptxPreflightRejectReason.XML_RESOURCE_LIMIT);
    }

    public final w d() {
        return new w(this.f9663a, this.f9664b, this.c, this.d, this.e);
    }

    public final void d(int r3) {
        int r0 = this.d;
        if (r3 > (40000 - r0)) goto L7;
        this.d = r0 + r3;
        return;
    L7:
        throw new PptxPreflightLimitException(PptxPreflightRejectReason.EXPAT_NAME_REFERENCE_COUNT);
    }
}
