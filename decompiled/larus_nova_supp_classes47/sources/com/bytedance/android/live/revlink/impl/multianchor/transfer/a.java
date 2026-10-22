package com.bytedance.android.live.revlink.impl.multianchor.transfer;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        xs2.b.a().post(new HorizontalPlayEvent(1));
    }
}
