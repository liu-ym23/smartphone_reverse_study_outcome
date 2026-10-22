package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m6<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;

    public m6(String[] r1, String r2, Function0 r3, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        IMiddlewareHostBusiness r1 = jc1.k.f(IMiddlewareHostBusiness.class);     // Catch: Exception -> L14
        if (r1 == null) goto L6;
        Integer r2 = Integer.valueOf(r1.concatVideo(this.a, this.b));     // Catch: Exception -> L14
    L7:
        if (r2 != null) goto L10;
    L12:
        this.d.invoke();     // Catch: Exception -> L14
        r5.onError(new RuntimeException("concat failed with result " + r2 + '.'));     // Catch: Exception -> L14
        return;
    L10:
        if (r2.intValue() != 0) goto L12;
        this.c.invoke();     // Catch: Exception -> L14
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
