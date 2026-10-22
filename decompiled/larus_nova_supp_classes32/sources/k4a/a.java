package k4a;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.ss.android.token.f;
import com.ss.android.token.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends qx5.a {
    public a() {
    }

    public final Request processBeforeSendRequest(Request r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        super.processBeforeSendRequest(r6);
        Request.Builder r0 = r6.newBuilder();
        ArrayList r1 = new ArrayList();
        if (r6.getHeaders() == null) goto L5;
        r1.addAll(r6.getHeaders());
    L5:
        Map r2 = null;
        f r7 = p.a(r6.getUrl(), null, null, false);
        if (r7 == null) goto L9;
        r2 = r7.a;
    L9:
        Intrinsics.checkNotNull(r2);
        Iterator r8 = ((HashMap) r2).entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) r8.next();
        r1.add(new Header((String) r3.getKey(), (String) r3.getValue()));
        goto L11
    L13:
        r0.headers(r1);
        return r0.build();
    }
}
