package com.bytedance.android.live.openplatform.impl.minigamecommon.utils;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniGameLiveJsBridgeUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap b(SubscriberJsEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "jsEvent");
        HashMap r0 = new HashMap();
        Map r4 = r3.getParams();
        if (r4 == null) goto L8;
        Iterator r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r5.next();
        r0.put(r1.getKey(), String.valueOf(r1.getValue()));
    L8:
        return r0;
    }

    public static Disposable a(final String r2, final Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "executable");
        return RxUtilKt.n(k.n(IBrowserService.class).registerJsEventSubscriber(r2).observeOn(AndroidSchedulers.mainThread()), new MiniGameLiveJsBridgeUtils$addPublishEventJsbListener$1(r2, r3));
    }
}
