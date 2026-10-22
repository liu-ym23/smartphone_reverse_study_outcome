package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class TableValueStatistic extends TableSkeleton implements l<Table> {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: org.ehcache.shadow.org.terracotta.statistics.TableValueStatistic$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TableValueStatistic f18146a;

        private a(String... r3) {
            this.f18146a = new TableValueStatistic(r3, null);
        }

        /* synthetic */ a(String[] r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    private TableValueStatistic(String... r1) {
        super(r1);
    }

    /* synthetic */ TableValueStatistic(String[] r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static a newBuilder(String... r2) {
        return new a(r2, null);
    }

    public /* synthetic */ void lambda$value$0$TableValueStatistic(String[] r4, String r5, Table.b r6) {
        Table.b r7 = (Table.b) ZeusTransformUtils.wrapperContextForParams(r6, Table.b.class, "com.obric.memorydata.plugin");
        l<? extends Serializable>[] r3 = getStatistics(r5);
        int r8 = 0;
    L4:
        if (r8 >= r3.length) goto L6;
        r7.a(r4[r8], r3[r8].type(), r3[r8].value());
        r8 = r8 + 1;
        goto L4
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public StatisticType type() {
        return StatisticType.TABLE;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public /* bridge */ /* synthetic */ Serializable value() {
        return value();
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public Table value() {
        final String[] r0 = getStatisticNames();
        return Table.newBuilder(r0).a(getRowLabels(), new $$Lambda$TableValueStatistic$2SFTFufcW6WQCU_HKG27na5Vpss(this, r0)).a();
    }
}
