package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.CompletableSource;
import io.reactivex.annotations.CheckReturnValue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ScopeProvider {
    @CheckReturnValue
    CompletableSource requestScope() throws Exception;
}
