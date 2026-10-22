package com.obric.memorydata.middleware.api.store;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH&¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/api/store/IStoreManager;", "Lcom/bytedance/news/common/service/manager/IService;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "hasInit", "", "getStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", ActivityLifecycle.NAME, "", "storeMode", "", "getPersonalStore", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IStoreManager extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ IStore getStore$default(IStoreManager r2, String r3, int r4, int r5, Object r6) {
            IStoreManager r7 = (IStoreManager) ZeusTransformUtils.wrapperContextForParams(r2, IStoreManager.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r4 = 0;
        L8:
            return r7.getStore(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStore");
        }
    }

    IStore getPersonalStore();

    IStore getStore(String r1, int r2);

    boolean hasInit();

    void init(Context r1);
}
