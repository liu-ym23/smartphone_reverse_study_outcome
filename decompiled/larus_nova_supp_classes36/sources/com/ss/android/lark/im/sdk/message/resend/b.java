package com.ss.android.lark.im.sdk.message.resend;

import com.bytedance.lark.pb.media.v1.MGetResourcesResponse;
import com.bytedance.lark.pb.media.v1.Resource;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements SdkSender.IParser<Resource> {
    public b() {
    }

    public final Object parse(byte[] r3) {
        if (r3 == null) goto L18;
        MGetResourcesResponse r4 = (MGetResourcesResponse) MGetResourcesResponse.ADAPTER.decode(r3);
        if (r4 == null) goto L10;
        Map r5 = r4.resources;
        if (r5 == null) goto L10;
        List r6 = MapsKt.toList(r5);
    L11:
        if (r6 == null) goto L16;
        Pair r7 = (Pair) CollectionsKt.firstOrNull(r6);
        if (r7 != null) goto L15;
        return null;
    L15:
        return (Resource) r7.getSecond();
    L16:
        return null;
    L10:
        r6 = null;
        goto L11
    L18:
        return null;
    }
}
