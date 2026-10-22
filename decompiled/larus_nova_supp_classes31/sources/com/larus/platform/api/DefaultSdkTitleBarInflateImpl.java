package com.larus.platform.api;

import android.content.Context;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/platform/api/DefaultSdkTitleBarInflateImpl;", "Lcom/larus/platform/api/ISdkTitleBarInflate;", "<init>", "()V", "inflate", "Lcom/larus/platform/api/IChatTitle;", "context", "Landroid/content/Context;", "eventType", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DefaultSdkTitleBarInflateImpl implements ISdkTitleBarInflate {
    public DefaultSdkTitleBarInflateImpl() {
    }

    @Override // com.larus.platform.api.ISdkTitleBarInflate
    public final g0 a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "eventType");
        return null;
    }
}
