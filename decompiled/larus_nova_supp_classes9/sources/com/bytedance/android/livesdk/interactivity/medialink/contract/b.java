package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    public static final a R0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MediaLinkContext.class);
            if ((r0 instanceof MediaLinkContext) == true) goto L5;
            r0 = null;
        L5:
            MediaLinkContext r1 = (MediaLinkContext) r0;
            if (r1 == null) goto L11;
            j<b> r2 = r1.getLinkService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        R0 = a.a;
    }

    hy.e Np();

    void jg(int r1, String r2, boolean r3);
}
