package com.bytedance.android.live.browser.schema.impl.gecko;

import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdk.v0;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.live.browser.schema.core.d> r7) {
        Intrinsics.checkNotNullParameter(r7, "emitter");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L6;
        LiveCall r1 = k.n(IMiddlewareNetworkService.class).get(d.a(this.a), CollectionsKt.emptyList(), Boolean.valueOf(this.a.b));     // Catch: Throwable -> L9
    L7:
        HttpResponse r2 = (HttpResponse) r1.execute();     // Catch: Throwable -> L9
        String r3 = r2.header("x-gecko-proxy-pkgid");     // Catch: Throwable -> L9
        r7.onNext(new com.bytedance.android.live.browser.schema.core.d(new JSONObject(new String(r2.getBody(), Charsets.UTF_8)), r3));     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L14;
        r7.onError(r5);
    L14:
        r7.onComplete();
        return;
    L6:
        r1 = k.n(IMiddlewareNetworkService.class).get(d.a(this.a), CollectionsKt.emptyList(), Boolean.valueOf(this.a.b));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
