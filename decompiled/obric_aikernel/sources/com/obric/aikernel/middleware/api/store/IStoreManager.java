package com.obric.aikernel.middleware.api.store;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface IStoreManager extends IService {

    public static final class a {
        public static /* synthetic */ t7.a a(IStoreManager r10, String r11, int r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 2) == 0) goto L7;
            r12 = 1;
        L7:
            return r10.getStore(r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStore");
        }
    }

    t7.a getStore(String r10, int r11);

    boolean hasInit();

    void init(Context r10);
}
