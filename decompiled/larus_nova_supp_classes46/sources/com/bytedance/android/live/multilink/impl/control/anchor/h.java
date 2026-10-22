package com.bytedance.android.live.multilink.impl.control.anchor;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.live.kmp.util.KmpToastUtil;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ MultiControlAnchorService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ c c;

    public h(MultiControlAnchorService r1, long r2, LinkMultiControlPresenter.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r6) {
        ApiServerException r7 = (Throwable) r6;
        this.a.a = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r2 = this.b;
        r0.getClass();
        JSONObject r1 = new JSONObject();
        TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.GetLinkMicInfoWithRtcInfoApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r2), r7, r1);
        if (this.c == null) goto L6;
        int r3 = x.a;
        LinkedHashMap r4 = new LinkedHashMap();
        x.X(r7, r4);
        x.t0("anchor_continue_room_linkmic_failed", r4);
    L6:
        if ((r7 instanceof ApiServerException) == false) goto L8;
        int r8 = r7.getErrorCode();
    L10:
        if (r8 != 10001) goto L12;
        return;
    L12:
        if (r8 == 31001) goto L17;
        KmpToastUtil.a("服务繁忙, 请稍后重试", 0);
        return;
    L17:
        return;
    L8:
        r8 = -1;
        goto L10
    }
}
