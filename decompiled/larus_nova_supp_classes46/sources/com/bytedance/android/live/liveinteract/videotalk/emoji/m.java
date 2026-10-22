package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T, R> implements Function {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final Object apply(Object r2) {
        com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return LinkWRDSHelper.d(r3);
    }
}
