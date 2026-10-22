package com.larus.platform.service;

import android.content.Context;
import com.larus.platform.api.ISdkTitleBarInflate;
import com.larus.platform.api.g0;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/service/TitleBarInflateService;", "Lcom/larus/platform/api/ISdkTitleBarInflate;", "<init>", "()V", "service", "getService", "()Lcom/larus/platform/api/ISdkTitleBarInflate;", "service$delegate", "Lkotlin/Lazy;", "inflate", "Lcom/larus/platform/api/IChatTitle;", "context", "Landroid/content/Context;", "eventType", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TitleBarInflateService implements ISdkTitleBarInflate {
    public static final TitleBarInflateService a = null;
    public static final Lazy b = null;

    private TitleBarInflateService() {
    }

    static {
        a = new TitleBarInflateService();
        b = LazyKt.lazy(new g3());
    }

    @Override // com.larus.platform.api.ISdkTitleBarInflate
    public final g0 a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "eventType");
        ISdkTitleBarInflate r0 = (ISdkTitleBarInflate) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2, r3);
    }
}
