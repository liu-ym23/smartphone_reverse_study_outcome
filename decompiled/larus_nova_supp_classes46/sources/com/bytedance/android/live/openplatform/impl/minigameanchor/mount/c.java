package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public c(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.invoke(((Response) r2).data);
    }
}
