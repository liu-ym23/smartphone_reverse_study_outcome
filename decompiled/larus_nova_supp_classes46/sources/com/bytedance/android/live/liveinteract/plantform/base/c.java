package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.liveinteract.interact.audience.context.InteractAdminContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c extends e {
    public static final a i0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static c a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("interact_admin_service");
            if ((r0 instanceof InteractAdminContext) == true) goto L5;
            r0 = null;
        L5:
            InteractAdminContext r1 = (InteractAdminContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<c> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (c) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        i0 = a.a;
    }

    com.bytedance.android.live.liveinteract.plantform.core.e A0();

    void kickOut(String r1, String r2, String r3);

    void permit(ILinkPlayerInfoBridge r1);

    void t2(long r1, String r3, String r4);
}
