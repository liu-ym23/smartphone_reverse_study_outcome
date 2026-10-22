package b4;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements Client.Provider {

    public static final class a implements Client {
        public a() {
        }

        public final SsCall newSsCall(Request r10) throws IOException {
            Context r0 = TTNetInit.getTTNetDepend().getContext();
            SsOkHttp3Client r1 = SsOkHttp3Client.inst(r0);
            if (com.bytedance.frameworks.baselib.network.http.util.i.c(r0) == false) goto L6;
            r1.setOk3TncBridge(TNCManager.getInstance());
        L6:
            return r1.newSsCall(r10);
        }
    }

    public i() {
    }

    public final Client get() {
        return new a();
    }
}
