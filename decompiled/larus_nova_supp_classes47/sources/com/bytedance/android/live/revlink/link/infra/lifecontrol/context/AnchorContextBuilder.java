package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import fr2.v;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorContextBuilder extends BaseContextBuilder {
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.i A;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.g B;
    public sc0.c C;
    public Function0<? extends v> D;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.f E;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.k F;
    public boolean G;
    public boolean H;
    public Map<Long, String> v;
    public Map<Long, String> w;
    public final Map<Long, String> x;
    public final Map<Long, String> y;
    public sc0.a z;

    public AnchorContextBuilder() {
        this.v = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.w = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.x = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.y = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.D = AnchorContextBuilder$liveVideoClientFactoryGetter$1.INSTANCE;
        this.H = true;
    }
}
