package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ UserInfoTabPresenter a;

    public f(UserInfoTabPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.C.setAlpha(1.0f);
    }
}
