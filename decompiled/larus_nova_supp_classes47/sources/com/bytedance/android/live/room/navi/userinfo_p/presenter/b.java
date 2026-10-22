package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ UserInfoPopupPresenter a;

    public b(UserInfoPopupPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        DataCenter r5 = this.a.a();
        if (r5 == null) goto L6;
        r5.put("fans_rank_list_lottie", Boolean.FALSE);
        return;
    }
}
