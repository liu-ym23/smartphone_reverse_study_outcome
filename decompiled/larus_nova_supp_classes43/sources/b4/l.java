package b4;

import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements Client.Provider {
    public l() {
    }

    public final Client get() {
        return new SsRetrofitClient();
    }
}
