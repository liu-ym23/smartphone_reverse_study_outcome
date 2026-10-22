package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceVideoWindowManager;
import com.bytedance.android.live.liveinteract.interact.audience.context.InteractAnchorContext;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d {
    public static final a j0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static d a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("interact_anchor_service");
            if ((r0 instanceof InteractAnchorContext) == true) goto L5;
            r0 = null;
        L5:
            InteractAnchorContext r1 = (InteractAnchorContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<d> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (d) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        j0 = a.a;
    }

    int H();

    com.bytedance.android.live.liveinteract.plantform.core.f X4();

    void Zn();

    void finishInteract(String r1);

    void g0(IBaseUser r1);

    y getLinkUserCenter();

    void h2(gd0.d r1);

    void invite(long r1, String r3, String r4, int r5, long r6);

    boolean isEngineOn();

    void kickOut(String r1, String r2, String r3);

    void showInviteAndPermitDialog();

    InteractAudienceVideoWindowManager windowManager();

    com.bytedance.android.live.pushstream.d xd();
}
