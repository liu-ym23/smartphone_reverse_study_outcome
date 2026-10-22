package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.live.revenue.common.ToastUtil;
import eu0.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ FollowMVIViewModel a;

    public c(FollowMVIViewModel r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        if ((r4 instanceof ApiServerException) == true) goto L5;
        r4 = null;
    L5:
        ApiServerException r5 = (ApiServerException) r4;
        if (r5 == null) goto L8;
        int r1 = ToastUtil.a;
        ToastUtil.b(r5.getPrompt(), 0);
    L9:
        EntranceMVIFacade r6 = fu0.b.b(this.a.getDataCenter());
        if (r6 == null) goto L12;
        r6.a(new v(this.a.getDataCenter()));
    L12:
        FollowMVIViewModel.e1(this.a, "关注失败");
        return;
    L8:
        ToastUtil.a(2131919116, 0);
        goto L9
    }
}
