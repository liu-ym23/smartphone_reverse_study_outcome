package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T, R> implements Function {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r2) {
        com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return LinkWRDSHelper.e(r3);
    }
}
