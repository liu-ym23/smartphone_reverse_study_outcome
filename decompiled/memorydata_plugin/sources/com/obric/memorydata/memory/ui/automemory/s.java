package com.obric.memorydata.memory.ui.automemory;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskGuideStore;", "", "<init>", "()V", "KEY_GUIDE_SHOWN", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "hasShown", "", "markShown", "", "reset", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f10718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f10719b = null;

    static {
        f10718a = new s();
        f10719b = LazyKt.lazy($$Lambda$s$ldI8SvXaO4Q5PKdSHivgQIWftg.INSTANCE);
    }

    private s() {
    }

    private final IStore c() {
        return (IStore) ZeusTransformUtils.preCheckCast(f10719b.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final IStore d() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    /* JADX INFO: renamed from: lambda$ldI8SvXaO4Q5PKdS-HivgQIWftg, reason: not valid java name */
    public static /* synthetic */ IStore m818lambda$ldI8SvXaO4Q5PKdSHivgQIWftg() {
        return d();
    }

    public final boolean a() {
        return c().getBoolean("auto_memory_task_guide_shown", false);
    }

    public final void b() {
        c().save("auto_memory_task_guide_shown", true);
    }
}
