package com.obric.aikernel.phx.sdk.api;

import androidx.annotation.Keep;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.c;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IBaseModel extends AutoCloseable {

    public static final class a {
        public static void a(IBaseModel r10) {
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    Object infer(RequestParams r10, Continuation<? super f8.a<Object>> r11);

    Object inferAsFlow(RequestParams r10, Continuation<? super c<f8.a<Object>>> r11);
}
