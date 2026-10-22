package com.larus.bmhome.chat.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CvsApi {
    public static final Lazy<CvsApi> a = null;

    public static final class a {
    }

    public CvsApi() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new j());
    }

    public static Object a(wc9.e r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CvsApi$reportAwemeConversation$2(r3, null), r4);
    }
}
