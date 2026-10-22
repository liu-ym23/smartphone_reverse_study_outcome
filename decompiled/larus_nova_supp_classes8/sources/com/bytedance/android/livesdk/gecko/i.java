package com.bytedance.android.livesdk.gecko;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.j3;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i {
    public static final nv5.e a = null;
    public static final PolarisFileWrapper b = null;

    static {
        b = new PolarisFileWrapper(LiveGeckoConfig.c());
        OfflineResourceClient.c.a(jc1.a.b());
        String r0 = LiveGeckoConfig.b();
        ArrayList r1 = new ArrayList();
        j3 r2 = j3.a;
        if (r2 == null) goto L10;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L10;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r1.add(PatternProtector.compile((String) r4.next()));
    L10:
        nv5.f.a r5 = new nv5.f.a(jc1.a.b());
        r5.b = r0;
        r5.f = r1;
        boolean r6 = true;
        r5.g = CollectionsKt.mutableListOf(new Uri[]{Uri.fromFile(b)});
        r5.i = "gecko.zijieapi.com";
        String r7 = jc1.k.n(IMiddleWareHostContext.class).getServerDeviceId();
        if (r7 != null) goto L13;
    L16:
        if (r6 == false) goto L18;
        r7 = "test";
    L18:
        r5.h = r7;
        r5.j = "CN";
        a = new nv5.e(new nv5.f(r5));
        ALogger.i("GlobalContainerOffline", "GlobalContainerOffline->init");
        return;
    L13:
        if (StringsKt.isBlank(r7) == true) goto L16;
        r6 = false;
        goto L16
    }

    public static WebResourceResponse a(String r5) {
        WebResourceResponse r1 = null;
        if (com.bytedance.android.livesdk.gecko.offline.h.a(r5) == false) goto L15;
        if (r5 == null) goto L19;
        boolean r0 = OfflineResourceClient.a;
        d1 r2 = OfflineResourceClient.e(r5);
        if (r2 == null) goto L8;
        WebResourceResponse r3 = r2.y;
    L9:
        if (r3 != null) goto L13;
        nv5.e r4 = a;
        if (r4 == null) goto L14;
        r1 = r4.a(null, r5);
    L14:
        ALogger.i("GlobalContainerOffline", "GlobalContainerOffline->XResource interceptRequest, url=" + r5 + ", response = " + r1);
        goto L19
    L13:
        r1 = r3;
        goto L14
    L8:
        r3 = null;
    L19:
        if (r1 == null) goto L21;
        return r1;
    L21:
        return jc1.k.n(IHostWebView.class).interceptRequest(r5);
    L15:
        nv5.e r6 = a;
        if (r6 == null) goto L18;
        r1 = r6.a(null, r5);
    L18:
        ALogger.i("GlobalContainerOffline", "GlobalContainerOffline->Falcon interceptRequest, url=" + r5 + ", response = " + r1);
        goto L19
    }
}
