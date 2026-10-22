package com.obric.memorydata.address;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/address/HomeCompanyAddressLearningGate;", "", "<init>", "()V", "isAutoLearnEnabled", "", "hasRequiredLocationPermission", "canCollectLocationForLearning", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8427a = null;

    static {
        f8427a = new a();
    }

    private a() {
    }

    public final boolean a() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("auto_learn_common_address", false);
    }

    public final boolean b() {
        return com.obric.memorydata.b.a.f8796a.b();
    }

    public final boolean c() {
        if (a() == true) goto L5;
    L7:
        return false;
    L5:
        if (b() == false) goto L7;
        return true;
    }
}
