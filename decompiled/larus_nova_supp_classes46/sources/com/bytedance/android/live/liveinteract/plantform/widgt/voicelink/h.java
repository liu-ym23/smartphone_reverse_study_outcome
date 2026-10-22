package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceAnchorContainerWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public h(MultiLinkVoiceAnchorContainerWidget r1, int r2, int r3, String r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        this.a.j = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        int r1 = this.b;
        int r2 = this.c;
        String r4 = this.d;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        long r5 = this.e;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.y0(r1, r2, 0, r4, r5, r9);
        ExceptionUtils.handleException(((Widget) this.a).context, r9);
    }
}
