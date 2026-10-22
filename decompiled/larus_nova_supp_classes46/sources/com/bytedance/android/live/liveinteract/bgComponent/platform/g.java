package com.bytedance.android.live.liveinteract.bgComponent.platform;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ MultiLinkThemeBgUIWidget a;

    public g(MultiLinkThemeBgUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MultiLinkThemeBgUIWidget r0 = this.a;
        r0.Xe((List) r2);
    }
}
