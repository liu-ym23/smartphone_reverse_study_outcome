package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/state/annieStatic/IllegalKeyException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "message", "", "(Ljava/lang/String;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class IllegalKeyException extends IllegalArgumentException {
    public IllegalKeyException(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
    }
}
