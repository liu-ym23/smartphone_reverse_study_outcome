package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.e4;
import io.reactivex.functions.Consumer;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r6) {
        ExtraResponse r7 = (ExtraResponse) r6;
        int r0 = ((e4) r7.data).getCount();
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = l51.a.E;
        KProperty[] r2 = l51.a.a;
        r1.setValue(null, r2[30], Integer.valueOf(r0));
        int r8 = ((e4) r7.data).getTotalCount();
        l51.a.F.setValue(null, r2[31], Integer.valueOf(r8));
    }
}
