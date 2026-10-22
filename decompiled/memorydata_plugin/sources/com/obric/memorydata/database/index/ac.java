package com.obric.memorydata.database.index;

import android.database.sqlite.SQLiteException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardBacklogCollector;", "", "reader", "Lcom/obric/memorydata/database/index/BacklogOwnerReader;", "<init>", "(Lcom/obric/memorydata/database/index/BacklogOwnerReader;)V", "collect", "", "Lcom/obric/memorydata/database/index/BacklogMetric;", "snapshotAtMs", "", "supportedEntityTypes", "", "", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f9327a = null;
    private static final List<String> c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f9328b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardBacklogCollector$Companion;", "", "<init>", "()V", "OWNER_DB_TYPES", "", "", "getOWNER_DB_TYPES", "()Ljava/util/List;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9327a = new a(null);
        c = CollectionsKt.listOf(new String[]{"PUBLIC", "USER"});
    }

    public ac(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "reader");
        this.f9328b = r4;
    }

    public final List<b> a(long r6, Set<Integer> r8) {
        Set<Integer> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "supportedEntityTypes");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L9
        c r5 = this.f9328b;     // Catch: SQLiteException -> L9
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L9
        Iterator r1 = r0.iterator();     // Catch: SQLiteException -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        CollectionsKt.addAll(r2, (Iterable) ZeusTransformUtils.preCheckCast(r5.read((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: SQLiteException -> L9
        goto L5
    L7:
        List<d> r7 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L9
        return ab.f9325a.a(r6, r7, r9);
    L9:
        return null;
    }
}
