package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class InvalidationLiveDataContainer {
    private final RoomDatabase database;
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        this.database = r10;
        Set<LiveData<?>> r11 = Collections.newSetFromMap(new IdentityHashMap());
        Intrinsics.checkNotNullExpressionValue(r11, "newSetFromMap(IdentityHashMap())");
        this.liveDataSet = r11;
    }

    public final <T> LiveData<T> create(String[] r10, boolean r11, Callable<T> r12) {
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        Intrinsics.checkNotNullParameter(r12, "computeFunction");
        return new RoomTrackingLiveData(this.database, this, r11, r12, r10);
    }

    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(LiveData<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "liveData");
        this.liveDataSet.add(r10);
    }

    public final void onInactive(LiveData<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "liveData");
        this.liveDataSet.remove(r10);
    }
}
