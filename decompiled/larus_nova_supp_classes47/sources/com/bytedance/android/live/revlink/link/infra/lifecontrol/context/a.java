package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import fr2.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends d {
    com.bytedance.android.live.revlink.link.domain.anchorimpl.f E4();

    sc0.c Wi();

    String Zl();

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    com.bytedance.android.live.revlink.link.domain.anchorimpl.g getCommonService();

    v getLiveVideoClientFactory();

    com.bytedance.android.live.revlink.link.domain.anchorimpl.k ko();

    NextLiveData<com.bytedance.android.live.revlink.link.core.layoutstatus.l> m6();

    Function1<Boolean, Unit> oo();

    com.bytedance.android.live.revlink.link.domain.anchorimpl.i qa();

    sc0.a sd();
}
