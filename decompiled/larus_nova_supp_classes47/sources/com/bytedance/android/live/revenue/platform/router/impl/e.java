package com.bytedance.android.live.revenue.platform.router.impl;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements SingleOnSubscribe {
    public final /* synthetic */ String a;

    public static final class a implements com.bytedance.android.live.schema.api.d.a {
        public final /* synthetic */ SingleEmitter a;

        public a(SingleEmitter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.schema.api.d.a
        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "finalSchema");
            this.a.onSuccess(r2);
        }

        @Override // com.bytedance.android.live.schema.api.d.a
        public final void onFail(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
            this.a.onError(com.bytedance.platform.aio.d.e(r3, null));
        }
    }

    public e(String r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<String> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        com.bytedance.android.live.schema.api.d r4 = null;
        if (StringsKt.contains$default(this.a, "webcast_redirect", false, 2, null) == false) goto L11;
        com.bytedance.android.live.schema.api.b r0 = com.bytedance.android.live.schema.api.utils.b.b(this.a);
        if (r0 == null) goto L13;
        IBrowserService r1 = k.f(IBrowserService.class);
        if (r1 == null) goto L9;
        r4 = r1.createRedirectProcessor();
    L9:
        if (r4 == null) goto L14;
        r4.a(r0, new a(r6));
        return;
    L14:
        return;
    L13:
        return;
    L11:
        r6.onSuccess(this.a);
    }
}
