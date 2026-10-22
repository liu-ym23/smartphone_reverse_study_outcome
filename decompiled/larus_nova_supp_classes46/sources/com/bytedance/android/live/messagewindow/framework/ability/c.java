package com.bytedance.android.live.messagewindow.framework.ability;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ CardAbilityImpl a;

    public c(CardAbilityImpl r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.q.L();
    }
}
