package com.ss.android.ugc.aweme.framework.services;

import androidx.annotation.Keep;
import ei.b;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Deprecated
public interface IRetrofitService {
    @Deprecated
    IRetrofit createNewRetrofit(String r5);

    @Deprecated
    IRetrofit createNewRetrofit(String r5, List<b> r10);

    @Deprecated
    RuntimeException propagateCompatibleException(ExecutionException r5);
}
