package com.obric.memorydata.datatransport.manager;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/PersistedExportResult;", "", Params.FILE_PATH, "", "statistics", "", "Lcom/obric/memorydata/datatransport/manager/PersistedExportStatistic;", "attachmentSuccessCount", "", "attachmentFailureCount", "warnings", "Lcom/obric/memorydata/datatransport/manager/PersistedExportWarning;", "progressStatistics", "Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "<init>", "(Ljava/lang/String;Ljava/util/List;IILjava/util/List;Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;)V", "getFilePath", "()Ljava/lang/String;", "getStatistics", "()Ljava/util/List;", "getAttachmentSuccessCount", "()I", "getAttachmentFailureCount", "getWarnings", "getProgressStatistics", "()Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "toExportResult", "Lcom/obric/memorydata/datatransport/manager/ExportResult;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9804a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9805b;
    private final List<x> c;
    private final int d;
    private final int e;
    private final List<y> f;
    private final q g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/PersistedExportResult$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/datatransport/manager/PersistedExportResult;", "result", "Lcom/obric/memorydata/datatransport/manager/ExportResult;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final w a(s r10) {
            Intrinsics.checkNotNullParameter(r10, "result");
            String r1 = r10.a().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(r1, "getAbsolutePath(...)");
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r10.b(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r9.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            t r4 = (t) ZeusTransformUtils.preCheckCast(r11.next(), t.class, "com.obric.memorydata.plugin");
            r0.add(new x(r4.a(), r4.b()));
            goto L4
        L6:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
            int r5 = r10.c();
            int r6 = r10.d();
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r10.e(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r2.iterator();
        L8:
            if (r7.hasNext() == false) goto L11;
            v r8 = (v) ZeusTransformUtils.preCheckCast(r7.next(), v.class, "com.obric.memorydata.plugin");
            r3.add(new y(r8.a(), r8.b()));
            goto L8
        L11:
            return new w(r1, r12, r5, r6, (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), r10.f());
        }
    }

    static {
        f9804a = new a(null);
    }

    public w(String r3, List<x> r4, int r5, int r6, List<y> r7, q r8) {
        List<x> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<y> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, Params.FILE_PATH);
        Intrinsics.checkNotNullParameter(r9, "statistics");
        Intrinsics.checkNotNullParameter(r10, "warnings");
        Intrinsics.checkNotNullParameter(r8, "progressStatistics");
        this.f9805b = r3;
        this.c = r9;
        this.d = r5;
        this.e = r6;
        this.f = r10;
        this.g = r8;
    }

    public final String a() {
        return this.f9805b;
    }

    public final s b() {
        File r1 = new File(this.f9805b);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        x r5 = (x) ZeusTransformUtils.preCheckCast(r3.next(), x.class, "com.obric.memorydata.plugin");
        r2.add(new t(r5.a(), r5.b()));
        goto L4
    L6:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        int r6 = this.d;
        int r7 = this.e;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        y r11 = (y) ZeusTransformUtils.preCheckCast(r10.next(), y.class, "com.obric.memorydata.plugin");
        r9.add(new v(r11.a(), r11.b()));
        goto L8
    L10:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L13
        w r14 = (w) ZeusTransformUtils.preCheckCast(this, w.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r14.g.a();     // Catch: Throwable -> L13
        Object r15 = Result.m1421constructorimpl(r14.g);     // Catch: Throwable -> L13
    L15:
        q r16 = q.f9792a.a();
        if (Result.m1427isFailureimpl(r15) == false) goto L19;
        r15 = r16;
    L19:
        return new s(r1, r4, r6, r7, r12, (q) ZeusTransformUtils.preCheckCast(r15, q.class, "com.obric.memorydata.plugin"));
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, w.class) == true) goto L8;
        return false;
    L8:
        w r6 = (w) ZeusTransformUtils.preCheckCast(r5, w.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9805b, r6.f9805b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (this.d == r6.d) goto L18;
        return false;
    L18:
        if (this.e == r6.e) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f9805b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "PersistedExportResult(filePath=" + this.f9805b + ", statistics=" + this.c + ", attachmentSuccessCount=" + this.d + ", attachmentFailureCount=" + this.e + ", warnings=" + this.f + ", progressStatistics=" + this.g + ')';
    }
}
