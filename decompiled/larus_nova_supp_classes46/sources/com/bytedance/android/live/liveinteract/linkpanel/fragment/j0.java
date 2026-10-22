package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ SettingLynxContainerFragment a;

    public j0(SettingLynxContainerFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131915982), 0);
        ALogger.e("SettingLynxContainerFragment", "handleLynxVideoPreClose=" + ((Throwable) r3).getMessage());
        this.a.d.dismiss();
    }
}
