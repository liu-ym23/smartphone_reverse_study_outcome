package com.obric.memorydata.middleware.impl.bridge;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J \u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J,\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\"2\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bridge/StorageBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IStoreBridgeAPI;", "<init>", "()V", "getInst", "saveBoolean", "", "repoName", "", "key", EventBody.KEY_VALUE, "", "saveInt", "", "saveLong", "", "saveFloat", "", "saveDouble", "", "saveString", "saveStringSet", "", "getInt", "default", "getLong", "getFloat", "getDouble", "getBoolean", "getString", "getStringSet", "clearAll", "remove", "allKeys", "", "(Ljava/lang/String;)[Ljava/lang/String;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StorageBridgeImpl implements IStoreBridgeAPI {
    public static final StorageBridgeImpl INSTANCE = null;

    static {
        INSTANCE = new StorageBridgeImpl();
    }

    private StorageBridgeImpl() {
    }

    @JvmStatic
    public static final StorageBridgeImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public String[] allKeys(String r4) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).allKeys();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void clearAll(String r4) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).clearAll();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public boolean getBoolean(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).getBoolean(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public double getDouble(String r4, String r5, double r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).getDouble(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public float getFloat(String r4, String r5, float r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).getFloat(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public int getInt(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).getInt(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public long getLong(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).getLong(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public String getString(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "default");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).getString(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public Set<String> getStringSet(String r4, String r5, Set<String> r6) {
        Set<String> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r3, "default");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).getStringSet(r5, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public boolean remove(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).remove(new String[]{r5});
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveBoolean(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).save(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveDouble(String r4, String r5, double r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).save(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveFloat(String r4, String r5, float r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).save(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveInt(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).save(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveLong(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).save(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveString(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, EventBody.KEY_VALUE);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).save(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveStringSet(String r4, String r5, Set<String> r6) {
        Set<String> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "repoName");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null).saveStringSet(r5, r3);
    }
}
