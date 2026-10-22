package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ VideoFriendPairDialog a;
    public final /* synthetic */ h0 b;

    public d0(VideoFriendPairDialog r1, h0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "throwable");
        ExceptionUtils.handleException(this.a.getContext(), r3);
    }
}
