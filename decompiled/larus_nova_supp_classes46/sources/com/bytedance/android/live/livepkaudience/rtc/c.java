package com.bytedance.android.live.livepkaudience.rtc;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerBattleConnectContent;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import gd0.x;
import hh1.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c {
    public static final a t0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static c a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("rtc__rev_guest_linker_service");
            if ((r0 instanceof GuestRtcLinkerContext) == true) goto L5;
            r0 = null;
        L5:
            GuestRtcLinkerContext r1 = (GuestRtcLinkerContext) r0;
            if (r1 == null) goto L11;
            j<c> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (c) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        t0 = a.a;
    }

    void I7(LinkerBattleConnectContent r1);

    x createRtcData();

    LinkerBattleConnectContent getLinkerContentMap();

    v0 getLiveVideoClientFactory();

    com.bytedance.android.live.livepkaudience.rtc.a getRtcManager();

    boolean isRtcEngineOn();

    void rd(x r1, v0 r2);
}
