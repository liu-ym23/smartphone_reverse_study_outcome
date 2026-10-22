package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class QueryChatPageStateFunctionality implements a {
    static {
    }

    public QueryChatPageStateFunctionality() {
    }

    public Bundle call(String r2, Bundle r3) {
        return (Bundle) BuildersKt.runBlocking$default(null, new call.1(null), 1, null);
    }
}
