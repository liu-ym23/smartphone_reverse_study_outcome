package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public u(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        List r6 = (List) r5;
        MultiLinkCommonVoiceFeedPreview r7 = this.a;
        int r0 = MultiLinkCommonVoiceFeedPreview.h2;
        if (r7.Z() == false) goto L12;
        LinkApi r1 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r2 = r7.G;
        if (r2 == null) goto L7;
        long r3 = r2.getId();
    L8:
        Disposable r4 = r1.fetchPlayModeInfo(r3, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(r7), l.a);
        if (r4 == null) goto L13;
        RxUtilKt.c(r4, r7.T);
        return;
    L13:
        return;
    L7:
        r3 = 0;
        goto L8
    }
}
