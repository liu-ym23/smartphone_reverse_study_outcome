package u10;

import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Interceptor {
    public final String a;
    public final String b;

    public final SsResponse intercept(Interceptor.Chain r7) throws Exception {
        Request r0 = r7.request();
        ArrayList r2 = new ArrayList(r0.getHeaders());
        Header r1 = new Header("Referer", "https://tmaservice.developer.toutiao.com?appid=" + this.a + "&version=" + this.b);
        String r4 = System.getProperty("http.agent") + " " + jc1.k.f(IHostContext.class).appName() + "/" + jc1.k.f(IHostContext.class).getVersionCode() + " ToutiaoMicroApp/" + ((String) com.bytedance.android.livesdk.sharedpref.b.B2.getValue()) + " PluginVersion/" + this.b;     // Catch: Exception -> L5
    L6:
        Header r3 = new Header("User-Agent", r4);
        a(r2, r1);
        a(r2, r3);
        return r7.proceed(r0.newBuilder().headers(r2).build());
    L5:
        r4 = "android";
        goto L6
    }

    public a(String r2, String r3) {
        this.a = "";
        this.b = "";
        this.a = r2;
        this.b = r3;
    }

    public final void a(List<Header> r4, Header r5) {
        ArrayList r6 = (ArrayList) r4;
        Iterator r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((Header) r0.next()).getName().equals(r5.getName()) == false) goto L4;
        r0.remove();
        goto L4
    L8:
        r6.add(r5);
    }
}
