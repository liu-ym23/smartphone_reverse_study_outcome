package com.bytedance.android.live.profile.ui.component;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public m(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        this.a.invoke(Boolean.TRUE);
    }
}
