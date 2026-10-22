package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d1 implements com.bytedance.android.scope.o, f {
    public final CompositeDisposable a;
    public final l20.e b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        final Function1<SubscriberJsEvent, Unit> r0 = new XplayPublishEventService$initEvent$1(this);
        final String r2 = "xplay_video_upload_result";
        Intrinsics.checkNotNullParameter("xplay_video_upload_result", "eventName");
        Intrinsics.checkNotNullParameter(r0, "executable");
        RxUtilKt.c(RxUtilKt.n(((IBrowserService) jc1.k.n(IBrowserService.class)).registerJsEventSubscriber("xplay_video_upload_result").observeOn(AndroidSchedulers.mainThread()), new XplayPublishEventService$addPublishEventJsbListener$1(r2, r0)), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public d1(l20.e r2) {
        Intrinsics.checkNotNullParameter(r2, "xplayMessageService");
        this.b = r2;
        this.a = new CompositeDisposable();
    }
}
