package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements IDLXBridgeMethod.a {
    public final /* synthetic */ q.a a;

    public r(q.a r1) {
        this.a = r1;
    }

    public final void invoke(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.a.finishWithRawResult(ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, r10, 0, 2, null));
    }
}
