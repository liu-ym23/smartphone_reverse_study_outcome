package com.obric.memorydata.database.util.file_utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import java.io.FilterInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/BudgetedXmlInputStream;", "Ljava/io/FilterInputStream;", "inputStream", "Ljava/io/InputStream;", "stats", "Lcom/obric/memorydata/database/util/file_utils/MutablePptxPreflightStats;", "<init>", "(Ljava/io/InputStream;Lcom/obric/memorydata/database/util/file_utils/MutablePptxPreflightStats;)V", "entryBytes", "", "read", "", "buffer", "", TypedValues.CycleType.S_WAVE_OFFSET, XSDatatype.FACET_LENGTH, "recordBytes", "", CommonConsts.COUNT_TYPE, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class e extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f9643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9644b;

    public e(InputStream r2, r r3) {
        Intrinsics.checkNotNullParameter(r2, "inputStream");
        Intrinsics.checkNotNullParameter(r3, "stats");
        super(r2);
        this.f9643a = r3;
    }

    private final void a(int r7) {
        long r0 = r7;
        if (r0 > (67108864 - this.f9644b)) goto L9;
        if (r0 > (268435456 - this.f9643a.c())) goto L9;
        this.f9644b += r0;
        r r6 = this.f9643a;
        r6.a(r6.c() + r0);
        return;
    L9:
        throw new PptxPreflightLimitException(PptxPreflightRejectReason.XML_RESOURCE_LIMIT);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = super.read();
        if (r0 < 0) goto L5;
        a(1);
    L5:
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "buffer");
        int r5 = super.read(r2, r3, r4);
        if (r5 <= 0) goto L5;
        a(r5);
    L5:
        return r5;
    }
}
