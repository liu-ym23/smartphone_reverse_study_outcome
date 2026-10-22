package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PreloadResourceResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "preloadResource")
public final class n1 extends e7.q<e7.p0, PreloadResourceResultModel> {
    public final m16.b a;
    public Disposable b;
    public Disposable c;

    public final void onTerminate() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.c;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public n1() {
    }

    public n1(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.p0 r12 = (e7.p0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.b();
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (StringsKt.startsWith$default(r0, "http", false, 2, null) == true) goto L8;
        PreloadResourceResultModel r13 = new PreloadResourceResultModel();
        r13.a(PreloadResourceResultModel.Code.InvalidParam);
        r13.b("url mast start with http or null");
        finishWithResult(r13);
        return;
    L8:
        if (this.a == null) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L12;
        this.c = Observable.just(1).subscribeOn(Schedulers.io()).map(new k1(r12, this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new l1(this), new m1(this));
        return;
    L12:
        this.b = Observable.just(1).subscribeOn(Schedulers.io()).map(new h1(r12, r11)).observeOn(AndroidSchedulers.mainThread()).subscribe(new i1(this), new j1(this));
    }
}
