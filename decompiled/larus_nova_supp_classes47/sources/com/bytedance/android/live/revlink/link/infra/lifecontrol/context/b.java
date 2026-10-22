package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends d {
    sc0.d G6();

    sc0.b W0();

    PublishSubject<Unit> ci();

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    com.bytedance.android.live.revlink.link.domain.anchorimpl.h getCommonService();

    NextLiveData<RevSeiFrame> lb();

    NextLiveData<String> ul();
}
