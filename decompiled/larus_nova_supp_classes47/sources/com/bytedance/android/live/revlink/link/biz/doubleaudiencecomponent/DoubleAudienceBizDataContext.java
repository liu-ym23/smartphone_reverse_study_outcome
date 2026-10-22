package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import com.bytedance.android.live.revlink.impl.utils.d0;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.livesdk.link.model.aa;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class DoubleAudienceBizDataContext {
    public aa a;
    public final d0 b;

    public DoubleAudienceBizDataContext(final b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.b = new d0(r5, r5.G(), new DoubleAudienceBizDataContext$seiChecker$1(r5));
    }
}
