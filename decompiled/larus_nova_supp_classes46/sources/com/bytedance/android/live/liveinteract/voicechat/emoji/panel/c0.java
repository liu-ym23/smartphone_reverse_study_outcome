package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public c0(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        BaseResponse r3 = (BaseResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a.invoke(r3.data);
    }
}
