package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J!\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0096\u0001J!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0010H\u0096\u0001J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0012H\u0096\u0001J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0096\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0016H\u0096\u0001J!\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0096\u0001J-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0096\u0001J!\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\fH\u0096\u0001J!\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0010H\u0096\u0001J!\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0012H\u0096\u0001J!\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0014H\u0096\u0001J!\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0016H\u0096\u0001J!\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0096\u0001J'\u0010\"\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0096\u0001¨\u0006#"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/StoreBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IStoreBridgeAPI;", "<init>", "()V", "allKeys", "", "", "repoName", "(Ljava/lang/String;)[Ljava/lang/String;", "clearAll", "", "getBoolean", "", "key", "default", "getDouble", "", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "", "remove", "saveBoolean", EventBody.KEY_VALUE, "saveDouble", "saveFloat", "saveInt", "saveLong", "saveString", "saveStringSet", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StoreBridgeAPI implements IStoreBridgeAPI {
    public static final StoreBridgeAPI INSTANCE = null;
    private final /* synthetic */ IStoreBridgeAPI $$delegate_0;

    static {
        INSTANCE = new StoreBridgeAPI();
    }

    private StoreBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IStoreBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IStoreBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IStoreBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public String[] allKeys(String r2) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        return this.$$delegate_0.allKeys(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void clearAll(String r2) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        this.$$delegate_0.clearAll(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public boolean getBoolean(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.getBoolean(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public double getDouble(String r2, String r3, double r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.getDouble(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public float getFloat(String r2, String r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.getFloat(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public int getInt(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.getInt(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public long getLong(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.getLong(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public String getString(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "default");
        return this.$$delegate_0.getString(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public Set<String> getStringSet(String r3, String r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "repoName");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r6, "default");
        return this.$$delegate_0.getStringSet(r3, r4, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public boolean remove(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.remove(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveBoolean(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.$$delegate_0.saveBoolean(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveDouble(String r2, String r3, double r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.$$delegate_0.saveDouble(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveFloat(String r2, String r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.$$delegate_0.saveFloat(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveInt(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.$$delegate_0.saveInt(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveLong(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.$$delegate_0.saveLong(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveString(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.$$delegate_0.saveString(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IStoreBridgeAPI
    public void saveStringSet(String r3, String r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "repoName");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r6, EventBody.KEY_VALUE);
        this.$$delegate_0.saveStringSet(r3, r4, r6);
    }
}
