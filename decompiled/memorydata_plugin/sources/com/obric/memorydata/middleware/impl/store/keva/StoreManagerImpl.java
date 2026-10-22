package com.obric.memorydata.middleware.impl.store.keva;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0000H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/store/keva/StoreManagerImpl;", "Lcom/obric/memorydata/middleware/api/store/IStoreManager;", "<init>", "()V", "PERSONAL_KV_LOGIC_NAME", "", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "repoMap", "", "Lcom/obric/memorydata/middleware/api/store/IStore;", "cachedPersonalUserId", "getCachedPersonalUserId", "()Ljava/lang/String;", "cachedPersonalUserId$delegate", "Lkotlin/Lazy;", "getInst", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "hasInit", "", "getStore", ActivityLifecycle.NAME, "storeMode", "", "getPersonalStore", "resolvePersonalUserIdOrNull", "getMode", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StoreManagerImpl implements IStoreManager {
    public static final StoreManagerImpl INSTANCE = null;
    private static final String PERSONAL_KV_LOGIC_NAME = "memorydata_personal_kv";
    private static final Lazy cachedPersonalUserId$delegate = null;
    private static final AtomicBoolean isInit = null;
    private static final Map<String, IStore> repoMap = null;

    static {
        INSTANCE = new StoreManagerImpl();
        isInit = new AtomicBoolean(false);
        repoMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        cachedPersonalUserId$delegate = LazyKt.lazy($$Lambda$StoreManagerImpl$Uv1Iq9um1M3nW_HcsZZOoZaYHAw.INSTANCE);
    }

    private StoreManagerImpl() {
    }

    private static final String cachedPersonalUserId_delegate$lambda$0() {
        return INSTANCE.resolvePersonalUserIdOrNull();
    }

    private final String getCachedPersonalUserId() {
        return (String) ZeusTransformUtils.preCheckCast(cachedPersonalUserId$delegate.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final StoreManagerImpl getInst() {
        return INSTANCE;
    }

    private final int getMode(int r1) {
        if (r1 == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static /* synthetic */ String lambda$Uv1Iq9um1M3nW_HcsZZOoZaYHAw() {
        return cachedPersonalUserId_delegate$lambda$0();
    }

    private final String resolvePersonalUserIdOrNull() {
        String r4 = AppContext.INSTANCE.getUserId();
        Long r0 = StringsKt.toLongOrNull(r4);
        if (AppContext.INSTANCE.isLogin() == false) goto L8;
        if (r0 == null) goto L8;
        if (r0.longValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        Ensure.ensureNotReachHere("getPersonalStore() called with invalid personal userId (rawUserId=" + r4 + ", isLogin=" + AppContext.INSTANCE.isLogin() + ')');
        return null;
    L12:
        return r4;
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public IStore getPersonalStore() {
        String r0 = getCachedPersonalUserId();
        if (r0 != null) goto L7;
        return null;
    L7:
        return getStore("memorydata_personal_kv_" + r0, 0);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public IStore getStore(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        if (hasInit() == true) goto L5;
        init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L5:
        Map<String, IStore> r0 = repoMap;
        if (r0.containsKey(r4) == false) goto L10;
        IStore r3 = r0.get(r4);
        Intrinsics.checkNotNull(r3);
        Object r6 = ZeusTransformUtils.preCheckCast(r3, IStore.class, "com.obric.memorydata.plugin");
    L9:
        return (IStore) r6;
    L10:
        a r2 = new a(r4, getMode(r5));
        r0.put(r4, r2);
        r6 = ZeusTransformUtils.preCheckCast(r2, IStore.class, "com.obric.memorydata.plugin");
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public boolean hasInit() {
        return isInit.get();
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public void init(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (isInit.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        KevaBuilder.getInstance().setContext(r3).setMonitor((KevaMonitor) ZeusTransformUtils.preCheckCast(new b(), KevaMonitor.class, "com.obric.memorydata.plugin"));
    }
}
