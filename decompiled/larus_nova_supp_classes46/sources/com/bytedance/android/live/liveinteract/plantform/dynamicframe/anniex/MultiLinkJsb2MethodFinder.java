package com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex;

import com.bytedance.android.annie.xbridge.mix.n;
import com.bytedance.android.live.lynx.api.Jsb2MethodFinder;
import com.bytedance.ies.bullet.base.bridge.i;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkJsb2MethodFinder extends Jsb2MethodFinder {
    public final Lazy j;

    public MultiLinkJsb2MethodFinder() {
        this.j = LazyKt.lazy(MultiLinkJsb2MethodFinder$statelessMethod$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.lynx.api.Jsb2MethodFinder
    public final IDLXBridgeMethod d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        Intrinsics.checkNotNullParameter(r3, "methodName");
        IDLXBridgeMethod r0 = (IDLXBridgeMethod) ((Map) this.j.getValue()).get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.d(r2, r3);
    }

    @Override // com.bytedance.android.live.lynx.api.Jsb2MethodFinder, com.bytedance.android.live.lynx.api.a
    public final <P, R> void l(String r3, com.bytedance.ies.web.jsbridge2.g<P, R> r4, m16.b r5) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "method");
        Map r0 = (Map) this.j.getValue();
        int r1 = i.a;
        if (r5 != null) goto L5;
        r5 = new m16.b();
    L5:
        r0.put(r3, i.a(n.b(r3, r4, r5)));
    }
}
