package a19;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.larus.utils.logger.FLogger;
import fi7.a;
import java.util.Iterator;
import ji7.b;
import kotlin.jvm.internal.Intrinsics;
import mi7.c;
import mi7.h;
import mi7.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f$a implements Callback<String> {
    public final /* synthetic */ a a;

    public f$a(a r1) {
        this.a = r1;
    }

    public final void onFailure(Call<String> r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r11, "call");
        Intrinsics.checkNotNullParameter(r12, "t");
        ji7.a.a r13 = this.a;
        if (r13 == null) goto L6;
        ji7.a.a r14 = r13;
        long r6 = System.currentTimeMillis() - r14.a;
        c.e(r14.b, -1, r6, r14.c, "ttnet");
        m.b(0, r14.b, r14.e);
        c.f(0, r14.b, "ttnet");
        String r5 = r14.d;
        h.a(new b(r14.b, r14.c, r5, r14.e, r14.f));
        return;
    }

    public final void onResponse(Call<String> r6, SsResponse<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "call");
        Intrinsics.checkNotNullParameter(r7, "response");
        String r0 = "";
        Iterator r1 = r7.headers().iterator();     // Catch: Throwable -> L15
    L5:
        if (r1.hasNext() == false) goto L11;
        Header r2 = (Header) r1.next();     // Catch: Throwable -> L15
        if (r2.getName().equals("location") == true) goto L10;
        if (r2.getName().equals("Location") == false) goto L5;
    L10:
        r0 = r2.getValue();     // Catch: Throwable -> L15
    L11:
        ji7.a.a r3 = this.a;     // Catch: Throwable -> L15
        if (r3 == null) goto L17;
        ji7.a.a r4 = r3;     // Catch: Throwable -> L15
        r4.a(r7.code(), r0);     // Catch: Throwable -> L15
    L17:
        r6.cancel();
        return;
    L15:
        th = move-exception;
        FLogger.a.e("ZlinkSdkManager", th.getMessage(), th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r6.cancel();
        throw th;
    }
}
