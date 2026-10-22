package com.bytedance.android.live.revlink.impl.rtc;

import com.bytedance.android.live.revlink.link.domain.anchorimpl.i;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import pc0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends i {
    public static final C0196a G0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.rtc.a$a, reason: collision with other inner class name */
    public static final class C0196a {
        public static final /* synthetic */ C0196a a = null;

        public C0196a() {
        }

        static {
            a = new C0196a();
        }

        public static a a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("rtc_linker_service");
            if ((r0 instanceof RtcLinkerContext) == true) goto L5;
            r0 = null;
        L5:
            RtcLinkerContext r1 = (RtcLinkerContext) r0;
            if (r1 == null) goto L11;
            j<a> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (a) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        G0 = C0196a.a;
    }

    e e();
}
