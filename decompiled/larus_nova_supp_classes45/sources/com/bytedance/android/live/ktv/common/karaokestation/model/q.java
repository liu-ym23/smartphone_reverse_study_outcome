package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public q(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        mb0.d.a(LinkMonitorData.ApiPinSong, System.currentTimeMillis() - this.a, r7);
        ExceptionUtils.handleException(s1.getContext(), r7);
        this.b.invoke(r7);
    }
}
