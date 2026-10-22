package com.obric.memorydata.database.index;

import androidx.room.RoomDatabase;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/index/OwnerStore;", "", "database", "Landroidx/room/RoomDatabase;", "pendingDao", "Lcom/obric/memorydata/database/dao/IndexPendingDao;", "lifecycleDao", "Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "<init>", "(Landroidx/room/RoomDatabase;Lcom/obric/memorydata/database/dao/IndexPendingDao;Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;)V", "getDatabase", "()Landroidx/room/RoomDatabase;", "getPendingDao", "()Lcom/obric/memorydata/database/dao/IndexPendingDao;", "getLifecycleDao", "()Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f9388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IndexPendingDao f9389b;
    private final EntityIndexLifecycleDao c;

    public av(RoomDatabase r3, IndexPendingDao r4, EntityIndexLifecycleDao r5) {
        IndexPendingDao r6 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r4, IndexPendingDao.class, "com.obric.memorydata.plugin");
        EntityIndexLifecycleDao r7 = (EntityIndexLifecycleDao) ZeusTransformUtils.wrapperContextForParams(r5, EntityIndexLifecycleDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "database");
        Intrinsics.checkNotNullParameter(r6, "pendingDao");
        Intrinsics.checkNotNullParameter(r7, "lifecycleDao");
        this.f9388a = r3;
        this.f9389b = r6;
        this.c = r7;
    }

    public final RoomDatabase a() {
        return this.f9388a;
    }

    public final IndexPendingDao b() {
        return this.f9389b;
    }

    public final EntityIndexLifecycleDao c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, av.class) == true) goto L8;
        return false;
    L8:
        av r6 = (av) ZeusTransformUtils.preCheckCast(r5, av.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9388a, r6.f9388a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9389b, r6.f9389b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f9388a.hashCode() * 31) + this.f9389b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "OwnerStore(database=" + this.f9388a + ", pendingDao=" + this.f9389b + ", lifecycleDao=" + this.c + ')';
    }
}
