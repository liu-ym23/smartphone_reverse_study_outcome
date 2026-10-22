package com.bytedance.android.livesdk.gecko;

import android.webkit.WebResourceResponse;
import com.bytedance.android.live.core.setting.i3;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n {
    public static final n b = null;
    public final /* synthetic */ LiveResourcesDistributionImpl a;

    static {
        b = new n();
    }

    public final String b() {
        j r0 = this.a.a;
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public n() {
        this.a = new LiveResourcesDistributionImpl();
    }

    public final WebResourceResponse c(String r3) {
        LiveResourcesDistributionImpl r0 = this.a;
        r0.getClass();
        if (((Boolean) i3.a.getValue()).booleanValue() == true) goto L16;
        j r1 = r0.a;
        if (r1 == null) goto L11;
        WebResourceResponse r2 = r1.interceptRequest(r3);
        if (r2 == null) goto L11;
        return r2;
    L11:
        Function1<? super String, ? extends WebResourceResponse> r4 = r0.b;
        if (r4 != null) goto L18;
        return null;
    L18:
        return (WebResourceResponse) r4.invoke(r3);
    L16:
        return i.a(r3);
    }

    public final InputStream a(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "relativePath");
        Intrinsics.checkNotNullParameter(r10, "channel");
        LiveResourcesDistributionImpl r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "relativePath");
        Intrinsics.checkNotNullParameter(r10, "channel");
        if (LiveResourcesDistributionImpl.d == true) goto L10;
        LinkedHashMap r0 = new LinkedHashMap();
        List r1 = (List) r2.c.getValue();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        String r5 = (String) r4.next();
        r0.put(r5, CollectionsKt.listOf(new String[]{"prefetch." + r5 + ".json", "protobuf/definitions_v2.json", "protobuf/definitions.json", "protobuf/shrink_config.json", "latch.json"}));
        r3.add(Unit.INSTANCE);
        goto L6
    L8:
        com.bytedance.geckox.b r6 = com.bytedance.geckox.b.a.a;
        ((ConcurrentHashMap) com.bytedance.iesgurd.core.f.a).put(LiveGeckoConfig.b(), r0);
        LiveResourcesDistributionImpl.d = true;
    L10:
        return ResLoadUtils.getPrefetchDataForPath(new PolarisFileWrapper(LiveGeckoConfig.c()), LiveGeckoConfig.b(), r10, r9);
    }
}
