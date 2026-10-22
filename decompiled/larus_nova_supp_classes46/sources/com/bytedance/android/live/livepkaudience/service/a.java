package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.livepkaudience.base.o;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractAdminContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends d {
    public static final C0119a u0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.service.a$a, reason: collision with other inner class name */
    public static final class C0119a {
        public static final /* synthetic */ C0119a a = null;

        public C0119a() {
        }

        static {
            a = new C0119a();
        }

        public static a a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("linkpk_interact_admin_service");
            if ((r0 instanceof LinkPkInteractAdminContext) == true) goto L5;
            r0 = null;
        L5:
            LinkPkInteractAdminContext r1 = (LinkPkInteractAdminContext) r0;
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
        u0 = C0119a.a;
    }

    o A0();

    void b5(String r1);

    void kickOut(String r1, String r2, String r3);

    void t2(long r1, String r3, String r4);

    void u3(String r1);

    void v0(int r1, String r2, int r3, String r4);

    void wi(LinkPlayerInfo r1);
}
