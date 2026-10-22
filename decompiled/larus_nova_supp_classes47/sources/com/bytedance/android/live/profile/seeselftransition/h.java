package com.bytedance.android.live.profile.seeselftransition;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ NewProfileTransitionDialogManager a;

    public h(NewProfileTransitionDialogManager r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        NewProfileTransitionDialogManager.c(this.a);
    }
}
