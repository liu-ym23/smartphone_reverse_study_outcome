package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.SelectMediaResultModel;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.t5;
import w20.wd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "selectMedia")
public final class e extends t5<wd, SelectMediaResultModel> {
    public Disposable a;

    public static final class a {
    }

    static {
    }

    public e() {
        this.a = Disposables.disposed();
    }

    public final void onDestroy() {
        super/*com.bytedance.ies.web.jsbridge2.f*/.onDestroy();
        this.a.dispose();
    }

    public final void invoke(Object r11, CallContext r13) {
        wd r14 = (wd) r11;
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "context");
        Context r15 = r13.getContext();
        if ((r15 instanceof Activity) == true) goto L5;
        r15 = null;
    L5:
        Activity r1 = (Activity) r15;
        if (r1 != null) goto L8;
        finishWithFailure(new Throwable("activity error"));
        return;
    L8:
        IHostAction r0 = jc1.k.n(IHostAction.class);
        String r2 = r14.e();
        Integer r16 = r14.c();
        if (r16 == null) goto L11;
        int r17 = r16.intValue();
    L12:
        Integer r4 = r14.d();
        if (r4 == null) goto L15;
        int r5 = r4.intValue();
    L16:
        Integer r6 = r14.a();
        if (r6 == null) goto L19;
        int r7 = r6.intValue();
    L20:
        String r8 = r14.b();
        Integer r9 = r14.g();
        if (r9 == null) goto L23;
        int r10 = r9.intValue();
    L24:
        List r3 = r14.f();
        if (r3 == null) goto L28;
        ArrayList r18 = (ArrayList) CollectionsKt.toCollection(r3, new ArrayList());
        if (r18 == null) goto L28;
    L29:
        ArrayList r19 = r18;
        boolean r20 = Intrinsics.areEqual(r14.i(), Boolean.TRUE);
        Single r110 = r0.selectMedia(r1, r2, r17, r5, r7, r8, r10, r19, r20);
        if (r110 != null) goto L32;
        finishWithFailure(new Throwable("activity is not FragmentActivity"));
        return;
    L32:
        this.a = r110.observeOn(Schedulers.computation()).map(new f(r14)).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this), new h(this));
        return;
    L28:
        r18 = new ArrayList();
        goto L29
    L23:
        r10 = 1;
        goto L24
    L19:
        r7 = 60000;
        goto L20
    L15:
        r5 = 10240;
        goto L16
    L11:
        r17 = 1;
        goto L12
    }
}
