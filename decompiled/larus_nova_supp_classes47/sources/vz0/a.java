package vz0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livesdk.revenue.network.d;
import com.bytedance.android.livesdk.revenue.network.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {
    public final com.bytedance.android.livesdk.revenue.service.network.a a;

    public a(com.bytedance.android.livesdk.revenue.service.network.a r2) {
        Intrinsics.checkNotNullParameter(r2, "revNetworkService");
        this.a = r2;
    }

    public final e A(String r10, d r12, int r13, e r14, Extra r15) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r12, "request");
        Intrinsics.checkNotNullParameter(r14, "error");
        Intrinsics.checkNotNullParameter(r15, "extra");
        RequestError r16 = new RequestError();
        r16.message = r14.a;
        r16.prompts = r14.b;
        r16.alert = r14.c;
        r16.setBlockNotice(r14.d);
        r16.url = r14.e;
        this.a.yf(r10, r13, r16, r15);
        return new e(r16.message, r16.prompts, r16.alert, r16.isBlockNotice(), r14.e, r14.f, r14.g);
    }
}
