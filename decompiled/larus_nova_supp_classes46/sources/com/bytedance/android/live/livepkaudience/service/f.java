package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.livepkaudience.PkGuestRtcLinkerContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface f {
    public static final a z0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static f a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("pk_guest_rtc_linker_service");
            if ((r0 instanceof PkGuestRtcLinkerContext) == true) goto L5;
            r0 = null;
        L5:
            PkGuestRtcLinkerContext r1 = (PkGuestRtcLinkerContext) r0;
            if (r1 == null) goto L11;
            j<f> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (f) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        z0 = a.a;
    }

    com.bytedance.android.live.livepkaudience.rtc.a P2();
}
