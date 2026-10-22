package com.obric.aikernel.middleware.api.log;

import androidx.core.app.NotificationCompat;
import com.bytedance.news.common.service.manager.IService;
import d4.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class AIKLog implements ILog {
    public static final AIKLog INSTANCE = null;
    private final /* synthetic */ ILog $$delegate_0;

    static {
        INSTANCE = new AIKLog();
    }

    private AIKLog() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(ILog.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (ILog) r10;
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void aeeLog(int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "content");
        this.$$delegate_0.aeeLog(r10, r11, r12);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        this.$$delegate_0.d(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        this.$$delegate_0.e(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "t");
        this.$$delegate_0.e(r10, r11, r12);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public List<String> getALogFiles(long r10, long r11) {
        return this.$$delegate_0.getALogFiles(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public ILog getLogInterceptor() {
        return this.$$delegate_0.getLogInterceptor();
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        this.$$delegate_0.i(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public boolean isDebug() {
        return this.$$delegate_0.isDebug();
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void setLogInterceptor(ILog r10) {
        Intrinsics.checkNotNullParameter(r10, "interceptor");
        this.$$delegate_0.setLogInterceptor(r10);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void v(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        this.$$delegate_0.v(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void w(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        this.$$delegate_0.w(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.log.ILog
    public void w(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "t");
        this.$$delegate_0.w(r10, r11, r12);
    }
}
