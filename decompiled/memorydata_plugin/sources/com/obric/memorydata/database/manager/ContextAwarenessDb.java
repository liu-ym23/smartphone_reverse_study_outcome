package com.obric.memorydata.database.manager;

import androidx.room.RoomDatabase;
import com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/manager/ContextAwarenessDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "subscriptionDao", "Lcom/obric/memorydata/database/dao/ContextAwarenessSubscriptionDao;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ContextAwarenessDb extends RoomDatabase {
    public ContextAwarenessDb() {
    }

    public abstract ContextAwarenessSubscriptionDao subscriptionDao();
}
