package com.obric.aikernel.middleware.api.log;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface ILog extends IService {

    public static final class a {
        public static void a(ILog r10, int r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r12, "tag");
            Intrinsics.checkNotNullParameter(r13, "content");
            String r14 = "Aee-" + r12;
            if (r11 != 2) goto L5;
            r10.v(r14, r13);
            return;
        L5:
            if (r11 != 3) goto L7;
        L16:
            r10.d(r14, r13);
            return;
        L7:
            if (r11 != 4) goto L9;
            r10.i(r14, r13);
            return;
        L9:
            if (r11 != 5) goto L11;
            r10.w(r14, r13);
            return;
        L11:
            if (r11 != 6) goto L16;
            r10.e(r14, r13);
        }
    }

    void aeeLog(int r10, String r11, String r12);

    void d(String r10, String r11);

    void e(String r10, String r11);

    void e(String r10, String r11, Throwable r12);

    List<String> getALogFiles(long r10, long r11);

    ILog getLogInterceptor();

    void i(String r10, String r11);

    boolean isDebug();

    void setLogInterceptor(ILog r10);

    void v(String r10, String r11);

    void w(String r10, String r11);

    void w(String r10, String r11, Throwable r12);
}
