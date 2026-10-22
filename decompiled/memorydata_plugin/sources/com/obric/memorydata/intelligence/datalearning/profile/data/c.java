package com.obric.memorydata.intelligence.datalearning.profile.data;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b\u001a\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000b\u001a\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0013\u001a\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b\u001a\u0006\u0010\u0018\u001a\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"KEY_TASK_LAST", "", "KEY_TASK_LAST_TIMESTAMP", "KEY_PRE_UP_TASK_START_TIMESTAMP", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "getPreUpTaskStartTimestamp", "", "setPreUpTaskStartTimestamp", "", "timestamp", "queryJobLastModifyTime", "jobName", "setJobLastModifyTime", "getLastTaskIndex", "", "setLastTaskIndex", "index", "getLastTaskTimestamp", "setLastTaskTimestamp", "removeProfileKeys", "intelligence_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f9963a = null;

    static {
        f9963a = LazyKt.lazy($$Lambda$c$rlnoTghNNHrMDvPrhtYSIwo_7E.INSTANCE);
    }

    public static final long a() {
        return IStore.a.a(e(), "pre_up_task_start_timestamp", 0, 2, null);
    }

    public static final long a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "jobName");
        return IStore.a.a(e(), r7, 0, 2, null);
    }

    public static final void a(int r2) {
        e().save("last_task_index", r2);
    }

    public static final void a(long r2) {
        e().save("pre_up_task_start_timestamp", r2);
    }

    public static final void a(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "jobName");
        e().save(r1, r2);
    }

    public static final int b() {
        return e().getInt("last_task_index");
    }

    public static final void b(long r2) {
        e().save("last_task_timestamp", r2);
    }

    public static final long c() {
        return IStore.a.a(e(), "last_task_timestamp", 0, 2, null);
    }

    public static final void d() {
        e().remove(new String[]{"last_task_index"});
        e().remove(new String[]{"last_task_timestamp"});
    }

    private static final IStore e() {
        return (IStore) ZeusTransformUtils.preCheckCast(f9963a.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final IStore f() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    /* JADX INFO: renamed from: lambda$rln-oTghNNHrMDvPrhtYSIwo_7E, reason: not valid java name */
    public static /* synthetic */ IStore m673lambda$rlnoTghNNHrMDvPrhtYSIwo_7E() {
        return f();
    }
}
