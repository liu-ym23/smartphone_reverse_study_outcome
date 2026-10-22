package com.bytedance.android.annie.lynx.resource;

import android.os.Bundle;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.lynx.LynxComponent;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import d8a.k;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends k<LynxResourceRequest<Bundle>, String> {
    public final com.bytedance.android.annie.service.resource.g a;
    public final com.bytedance.android.annie.card.base.c b;

    public b(com.bytedance.android.annie.service.resource.g r10, LynxComponent.d r11) {
        Intrinsics.checkNotNullParameter(r10, "loaderConfig");
        this.a = r10;
        this.b = r11;
    }

    public final void request(LynxResourceRequest<LynxResourceRequest<Bundle>> r10, LynxResourceCallback<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r0 = r10.a;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L20;
        LinkedHashMap r12 = new LinkedHashMap();
        com.bytedance.android.annie.card.base.c r13 = this.b;
        if (r13 == null) goto L12;
        r13.b(r10.a, AnnieResType.LYNX_FONT, IHybridComponent.HybridType.LYNX, r12);
    L12:
        String r14 = r10.a;
        RequestConfig r15 = new RequestConfig(AnnieResType.LYNX_FONT);
        r15.c = false;
        r15.d = true;
        r15.e = false;
        r15.a().putAll(r12);
        com.bytedance.android.annie.service.resource.g r16 = this.a;
        if (r16.c == false) goto L15;
        r15.h = r16.d;
    L15:
        String r17 = n.d(r14, r15);
        if (r17 != null) goto L18;
        r17 = n.a(r10.a);
    L18:
        r11.onResponse(LynxResourceResponse.success(r17));
        return;
    L20:
        r11.onResponse(LynxResourceResponse.success(r10.a));
        return;
    L5:
        if (StringsKt.startsWith$default(r0, "http", false, 2, null) != true) goto L7;
        r1 = true;
        goto L8
    }
}
