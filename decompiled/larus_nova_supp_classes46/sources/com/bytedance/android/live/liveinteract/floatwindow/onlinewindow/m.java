package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public m(long r2) {
        this.a = "small_window";
        this.b = r2;
    }

    public final void accept(Object r6) {
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        String r1 = this.a;
        long r2 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "requestSource");
        JSONObject r3 = new JSONObject();
        r3.put("request_source", r1);
        LinkMonitorData r4 = LinkMonitorData.LinkOnlineFloatWindowCheckAudienceLinkers;
        long r5 = TalkRoomBusinessFullLinkMonitor.h(r2);
        TalkRoomBusinessFullLinkMonitor.Y(r4, r5, (Throwable) r6, r3);
    }
}
