package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "", "categories", "", "Lcom/obric/memorydata/datatransport/manager/ExportCategoryProgress;", "<init>", "(Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "rows", "section", "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsSection;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9792a = null;
    private static final q c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<k> f9793b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "getEMPTY", "()Lcom/obric/memorydata/datatransport/manager/ExportProgressStatistics;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final q a() {
            return q.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f9792a = new a(null);
        Object[] r1 = 0 == true ? 1 : 0;
        c = new q(r1, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public q(List<k> r3) {
        List<k> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "categories");
        this.f9793b = r4;
    }

    public /* synthetic */ q(List r13, int r14, DefaultConstructorMarker r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L9;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(ExportStatisticsCategory.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L6:
        if (r19.hasNext() == false) goto L8;
        r18.add(new k((ExportStatisticsCategory) ZeusTransformUtils.preCheckCast(r19.next(), ExportStatisticsCategory.class, "com.obric.memorydata.plugin"), 0, 0, 0, null, 30, null));
        goto L6
    L8:
        r16 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
    L9:
        this(r16);
    }

    public static final /* synthetic */ q b() {
        return c;
    }

    public final List<k> a() {
        return this.f9793b;
    }

    public final List<k> a(ExportStatisticsSection r5) {
        Intrinsics.checkNotNullParameter(r5, "section");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f9793b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r2 = r6.next();
        if (((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.memorydata.plugin")).a().getSection() != r5) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9793b, r6.f9793b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f9793b.hashCode();
    }

    public String toString() {
        return "ExportProgressStatistics(categories=" + this.f9793b + ')';
    }
}
