package com.obric.aiproactive.impl.runtime;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/aiproactive/impl/runtime/AiProactiveFeatureSwitchStore;", "", "<init>", "()V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "isWakeUpEnabled", "", "setWakeUpEnabled", "", "enabled", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f6508b = null;

    static {
        f6507a = new a();
        f6508b = LazyKt.lazy($$Lambda$a$RzIebU2FpkyrqJqlepatK4_htrI.INSTANCE);
    }

    private a() {
    }

    private final IStore b() {
        return (IStore) ZeusTransformUtils.preCheckCast(f6508b.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final IStore c() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    public static /* synthetic */ IStore lambda$RzIebU2FpkyrqJqlepatK4_htrI() {
        return c();
    }

    public final void a(boolean r3) {
        b().save("ai_proactive_wake_up_user_preference", r3);
        b().save("ai_proactive_wake_up_enabled", r3);
    }

    public final boolean a() {
        return b.a(b.a(b(), "ai_proactive_wake_up_user_preference"), b.a(b(), "ai_proactive_wake_up_enabled"));
    }
}
