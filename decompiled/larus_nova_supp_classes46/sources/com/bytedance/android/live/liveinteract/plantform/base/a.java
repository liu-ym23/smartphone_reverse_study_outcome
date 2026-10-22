package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.liveinteract.plantform.AnchorRtcLinkerContext;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {
    public static final C0047a g0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.base.a$a, reason: collision with other inner class name */
    public static final class C0047a {
        public static final /* synthetic */ C0047a a = null;

        public C0047a() {
        }

        static {
            a = new C0047a();
        }

        public static a a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("rtc_anchor_linker_service");
            if ((r0 instanceof AnchorRtcLinkerContext) == true) goto L5;
            r0 = null;
        L5:
            AnchorRtcLinkerContext r1 = (AnchorRtcLinkerContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<a> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (a) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        g0 = C0047a.a;
    }

    hg6.g R1();
}
