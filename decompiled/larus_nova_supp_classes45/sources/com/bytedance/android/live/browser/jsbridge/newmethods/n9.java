package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openHostVerify")
public final class n9 extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {
    public Disposable a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CallContext a;

        public a(CallContext r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            CallContext r0 = this.a;
            JSONObject r1 = new JSONObject();
            ((b30.s) r4).getClass();
            r1.put("code", 0);
            Unit r5 = Unit.INSTANCE;
            r0.b("H5_signStatus", r1);
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public n9() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        Activity r4 = ContextUtil.contextToActivity(r3.getContext());
        if (r4 != null) goto L6;
        finishWithFailure();
        return;
    L6:
        r4.startActivity(jc1.k.n(IHostVerify.class).getVerifyActivityIntent(r4));
        this.a = xs2.b.a().b(b30.s.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r3));
        xs2.b.a().post(b30.r.class);
    }
}
