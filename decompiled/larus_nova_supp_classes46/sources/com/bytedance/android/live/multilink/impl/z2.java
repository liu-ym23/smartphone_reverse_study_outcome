package com.bytedance.android.live.multilink.impl;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z2<T> implements Consumer {
    public final /* synthetic */ MultiLinkSeiIndicator a;
    public final /* synthetic */ int b;

    public z2(MultiLinkSeiIndicator r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        Integer r11 = (Integer) r10;
        MultiLinkSeiIndicator r12 = this.a;
        int r0 = this.b;
        r12.getClass();
        HashMap r1 = new HashMap();
        HashMap<String, String> r2 = r12.a();
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        r1.put("current_mode", String.valueOf(r0));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_multi_link_sei_time_out", r1, new Object[]{IRoom.class});
        if (r12.a.c() == false) goto L14;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "logMap");
        JSONObject r4 = new JSONObject();
        Iterator r13 = r1.entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) r13.next();
        r4.put((String) r3.getKey(), r3.getValue());
        goto L9
    L11:
        nd0.c.o(nd0.c.a, LinkMonitorData.MultiLinkSeiTimeOut, r4, 0, null, true, 12);
        return;
    }
}
