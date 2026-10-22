package mz8;

import android.util.Pair;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements Interceptor {
    public final boolean a;

    public static final class a extends BDNetworkTagContextProviderAdapter {
        public final /* synthetic */ b a;

        public final int triggerType() {
            return !this.a.a ? 1 : 0;
        }

        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    public b(boolean r1) {
        this.a = r1;
    }

    public final SsResponse<?> intercept(Interceptor.Chain r6) {
        Pair r0 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(this));
        if (r6 == null) goto L9;
        Request r1 = r6.request();
        if (r1 == null) goto L11;
        Request.Builder r2 = r1.newBuilder();
        List r3 = CollectionsKt.toMutableList(r1.getHeaders());
        r3.add(new Header((String) r0.first, (String) r0.second));
        r2.headers(r3);
        return r6.proceed(r2.build());
    L11:
        return null;
    L9:
        return null;
    }
}
