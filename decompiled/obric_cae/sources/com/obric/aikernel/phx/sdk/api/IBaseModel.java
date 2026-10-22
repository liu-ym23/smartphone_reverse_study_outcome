package com.obric.aikernel.phx.sdk.api;

import ae.d;
import androidx.annotation.Keep;
import com.obric.aikernel.sdk.config.RequestParams;
import se.c;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface IBaseModel extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    Object infer(RequestParams r8, d<? super xa.a<Object>> r10);

    Object inferAsFlow(RequestParams r8, d<? super c<xa.a<Object>>> r10);
}
