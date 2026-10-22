package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LandscapeZDanmakuWidget a;

    public f(LandscapeZDanmakuWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        LandscapeDanmakuPresenterV2 r9 = this.a.m;
        if (r9 == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("danmu_count_audit", String.valueOf(r9.l));
        r0.put("client_receive_duration_audit", String.valueOf(r9.m));
        r0.put("client_show_duration_audit", String.valueOf(r9.n));
        r0.put("danmu_count_not_audit", String.valueOf(r9.o));
        r0.put("client_receive_duration_not_audit", String.valueOf(r9.p));
        r0.put("client_show_duration_not_audit", String.valueOf(r9.q));
        j0.l().sendLog("livesdk_danmu_show_summary", r0, new Object[]{new x(), IRoom.class});
        r9.l = 0;
        r9.m = 0;
        r9.n = 0;
        r9.o = 0;
        r9.p = 0;
        r9.q = 0;
        return;
    }
}
