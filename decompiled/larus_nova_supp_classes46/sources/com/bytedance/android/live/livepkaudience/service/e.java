package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface e {
    public static final a y0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static e a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(PkAudienceInternalServiceContext.TAG);
            if ((r0 instanceof PkAudienceInternalServiceContext) == true) goto L5;
            r0 = null;
        L5:
            PkAudienceInternalServiceContext r1 = (PkAudienceInternalServiceContext) r0;
            if (r1 == null) goto L11;
            j<e> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (e) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        y0 = a.a;
    }

    String Wc();

    boolean getSelfHasAudienceBeforePk();

    boolean handleInteractClick();

    void hideInteractDialog();

    g ml();

    void tryLoadPkAudienceWidget();

    void tryUnLoadPkAudienceWidget();

    void unLoadOtherWidget(int r1);
}
