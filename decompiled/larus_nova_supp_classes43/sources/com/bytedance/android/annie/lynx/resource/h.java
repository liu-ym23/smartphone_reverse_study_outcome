package com.bytedance.android.annie.lynx.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.lynx.LynxComponent;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements f76.b<f76.c> {
    public final com.bytedance.android.annie.service.resource.g a;
    public final com.bytedance.android.annie.card.base.c b;

    public final f76.c j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "resUrl");
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == false) goto L15;
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.annie.card.base.c r11 = this.b;
        if (r11 == null) goto L7;
        r11.b(r10, AnnieResType.LYNX_CHILD_RESOURCE, IHybridComponent.HybridType.LYNX, r0);
    L7:
        RequestConfig r12 = new RequestConfig(AnnieResType.LYNX_CHILD_RESOURCE);
        r12.c = false;
        r12.d = true;
        r12.e = false;
        r12.a().putAll(r0);
        com.bytedance.android.annie.service.resource.g r1 = this.a;
        if (r1.c == false) goto L10;
        r12.h = r1.d;
    L10:
        String r13 = n.d(r10, r12);
        if (r13 != null) goto L14;
        r13 = n.a(r10);
    L14:
        return new f76.c(UriProtector.parse(r13), r13);
    L15:
        return null;
    }

    public h(com.bytedance.android.annie.service.resource.g r10, LynxComponent.d r11) {
        Intrinsics.checkNotNullParameter(r10, "loaderConfig");
        this.a = r10;
        this.b = r11;
    }
}
