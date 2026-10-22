package k00;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.model.l1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ String a;

    public c(String r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        e r0 = e.e;
        e.d = true;
        l1 r5 = (l1) ((BaseResponse) ((Response) r4)).data;
        if (r5 == null) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<String> r1 = e.a;
        String r2 = GsonProtectorUtils.toJson(GsonHelper.get(), r5);
        r1.getClass();
        f.d(r1, r2);
        com.bytedance.android.livesdk.sharedpref.e<String> r3 = e.b;
        String r6 = this.a;
        r3.getClass();
        f.d(r3, r6);
        e.a(r0, r5);
        return;
    }
}
