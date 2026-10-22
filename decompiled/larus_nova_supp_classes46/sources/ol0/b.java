package ol0;

import android.webkit.WebResourceResponse;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.gecko.n;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.android.livesdk.gecko.offline.h;
import java.io.InputStream;
import jc1.k;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends d8a.b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void loadTemplate(String r4, d8a.b.a r5) {
        Intrinsics.checkNotNullParameter(r4, "url");
        n r0 = n.b;
        r0.a.getClass();
        boolean r1 = OfflineResourceClient.a;
        boolean r2 = true;
        if (h.a(r4) != true) goto L13;
        WebResourceResponse r3 = r0.c(r4);
        if (r3 == null) goto L9;
        InputStream r6 = r3.getData();
        if (r6 == null) goto L9;
        byte[] r7 = ByteStreamsKt.readBytes(r6);
    L10:
        if (r7 == null) goto L13;
        if (r5 == null) goto L14;
        r5.onSuccess(r7);
    L14:
        if (r2 == true) goto L17;
        k.n(IHostBusiness.class).loadTemplate(r4, new a(r5));
        return;
    L17:
        return;
    L9:
        r7 = null;
    L13:
        r2 = false;
        goto L14
    }
}
