package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/hybrid/api/shareview/ShareViewLoadError;", "Ljava/lang/Error;", "Lkotlin/Error;", Constants.OperatorKey.CODE, "Lcom/bytedance/android/live/revenue/platform/hybrid/api/shareview/LoadFailCode;", "message", "", "(Lcom/bytedance/android/live/revenue/platform/hybrid/api/shareview/LoadFailCode;Ljava/lang/String;)V", "getCode", "()Lcom/bytedance/android/live/revenue/platform/hybrid/api/shareview/LoadFailCode;", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ShareViewLoadError extends Error {
    private final LoadFailCode code;

    public final LoadFailCode getCode() {
        return this.code;
    }

    public ShareViewLoadError(LoadFailCode r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.CODE);
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r3);
        this.code = r2;
    }
}
