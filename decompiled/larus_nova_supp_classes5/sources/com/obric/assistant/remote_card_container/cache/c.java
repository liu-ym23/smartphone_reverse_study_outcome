package com.obric.assistant.remote_card_container.cache;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class c implements Function0 {
    public /* synthetic */ c() {
    }

    public final Object invoke() {
        return new Handler(((HandlerThread) CardCacheManager.b.getValue()).getLooper());
    }
}
