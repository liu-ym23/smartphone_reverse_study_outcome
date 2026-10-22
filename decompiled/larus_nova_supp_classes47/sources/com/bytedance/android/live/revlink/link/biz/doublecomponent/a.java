package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.DoubleRematchType;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import h41.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class a {
    public boolean a;
    public boolean b;
    public DoubleRematchType c;

    public a(g r3, com.bytedance.android.livesdk.revenue.service.room.c r4, x11.a r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        Intrinsics.checkNotNullParameter(r5, "internalLinkService");
        new MutableLiveData();
        this.c = DoubleRematchType.None;
        new e(r3, true, r4.getRoomContext().getCommonRoom(), r5);
    }
}
