package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;

    public s(o r1, boolean r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        ApiServerException r9 = (Throwable) r8;
        new qh0.h(1, new VideoLinkModeSelectManager$openTalkRoom$2$1(this), VideoLinkModeSelectManager$openTalkRoom$2$2.INSTANCE).c(r9);
        this.a.b = false;
        long r2 = System.currentTimeMillis() - this.c;
        com.bytedance.android.live.liveinteract.plantform.utils.x.y0(r9, r2);
        InteractLinkFullLinkMonitor.j("8,12", 0, r2, r9, "click_bottom_bar_icon");
        o r0 = this.a;
        r0.getClass();
        if ((r9 instanceof ApiServerException) == true) goto L5;
    L7:
        ExceptionUtils.handleException(r0.e, r9, 2131919444);
    L8:
        this.a.a = false;
        return;
    L5:
        if (r9.getErrorCode() != 31011) goto L7;
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getLatestBanRecord(13).compose(RxUtil.rxSchedulerHelper()).subscribe(new p(r0), q.a);
        goto L8
    }
}
