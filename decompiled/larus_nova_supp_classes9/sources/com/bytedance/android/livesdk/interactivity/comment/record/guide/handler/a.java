package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ String b;

    public a(String[] r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        ALogger.d("HighlightBacktrackUtil", "调用合成接口");     // Catch: Exception -> L14
        IMiddlewareHostBusiness r1 = jc1.k.f(IMiddlewareHostBusiness.class);     // Catch: Exception -> L14
        if (r1 == null) goto L6;
        Integer r2 = Integer.valueOf(r1.concatVideo(this.a, this.b));     // Catch: Exception -> L14
    L7:
        if (r2 != null) goto L10;
    L12:
        r5.onError(new RuntimeException("concat failed with result " + r2 + '.'));     // Catch: Exception -> L14
        return;
    L10:
        if (r2.intValue() != 0) goto L12;
        r5.onNext(95);     // Catch: Exception -> L14
        r5.onComplete();     // Catch: Exception -> L14
        return;
    L6:
        r2 = null;
    L14:
        e = move-exception;
        r5.onError(e);
    }
}
