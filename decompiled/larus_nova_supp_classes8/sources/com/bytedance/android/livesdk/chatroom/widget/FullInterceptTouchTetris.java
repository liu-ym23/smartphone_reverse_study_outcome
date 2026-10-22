package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/FullInterceptTouchTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullInterceptTouchTetris extends LiveTetris<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final Lazy o;

    public FullInterceptTouchTetris() {
        this.o = LazyKt.lazy(new FullInterceptTouchTetris$touchListener$2(this));
    }

    public final void O() {
        L().setOnTouchListener((View.OnTouchListener) this.o.getValue());
        T(zg1.i1.class, new FullInterceptTouchTetris$onViewCreated$1(this));
    }

    public final View G(t70.k r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.a(View.class);
    }
}
