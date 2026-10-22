package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import com.bytedance.android.live.base.model.message.s0;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import vh7.f;
import zg1.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ DouPlusDataChangeMonitor a;

    public c(DouPlusDataChangeMonitor r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        tlc.d r0 = (s0) f.c(s0.class);
        DouPlusDataChangeMonitor r1 = this.a;
        ((x) r5).getClass();
        r0.setStatus(Long.valueOf(-1));
        r0.setNumber(Long.valueOf(0));
        r0.setToast("");
        Unit r6 = Unit.INSTANCE;
        r1.onMessage(r0);
    }
}
