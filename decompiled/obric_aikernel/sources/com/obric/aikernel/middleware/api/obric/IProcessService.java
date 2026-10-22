package com.obric.aikernel.middleware.api.obric;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface IProcessService extends IService {

    public static final class a {
        public static /* synthetic */ void a(IProcessService r10, Context r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L6;
            r11 = null;
        L6:
            r10.init(r11);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    void destroy();

    void init(Context r10);
}
