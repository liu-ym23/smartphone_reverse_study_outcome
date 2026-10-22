package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.liveinteract.plantform.GuestRtcLinkerContext;
import com.bytedance.live.datacontext.DataContext;
import hh1.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {
    public static final a h0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("guest_rtc_linker_service");
            if ((r0 instanceof GuestRtcLinkerContext) == true) goto L5;
            r0 = null;
        L5:
            GuestRtcLinkerContext r1 = (GuestRtcLinkerContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<b> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        h0 = a.a;
    }

    hg6.g P2();

    ei6.a V0();

    v0 getLiveVideoClientFactory();
}
