package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/TopicGetParamsMethodWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopicGetParamsMethodWidget extends LiveWidget {
    public final CompositeDisposable a;
    public final Lazy b;

    public TopicGetParamsMethodWidget() {
        this.a = new CompositeDisposable();
        this.b = LazyKt.lazy(new TopicGetParamsMethodWidget$methodFactory$2(this));
    }

    public final void onCreate() {
        super.onCreate();
        BaseJsBridgeMethodFactory r0 = (BaseJsBridgeMethodFactory) this.b.getValue();
        if (r0 == null) goto L12;
        IBrowserService r1 = jc1.k.f(IBrowserService.class);
        if (r1 == null) goto L13;
        Observable r2 = r1.registerExternalMethodFactory(r0);
        if (r2 == null) goto L14;
        Disposable r3 = r2.subscribe();
        if (r3 == null) goto L15;
        RxUtilKt.c(r3, this.a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a.clear();
    }
}
