package com.bytedance.android.live.liveinteract.plantform.base;

import android.content.Context;
import android.view.SurfaceView;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceVideoWindowManager;
import com.bytedance.android.live.liveinteract.interact.audience.context.InteractGuestContext;
import com.bytedance.android.live.liveinteract.plantform.core.n;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface e {
    public static final a l0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static e a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("interact_guest_service");
            if ((r0 instanceof InteractGuestContext) == true) goto L5;
            r0 = null;
        L5:
            InteractGuestContext r1 = (InteractGuestContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<e> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (e) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(e r2) {
            r2.Q6(null, true, true);
        }
    }

    static {
        l0 = a.a;
    }

    void D5(int r1, int r2, boolean r3, boolean r4, int r5, xc.a r6);

    void Dn();

    void F3(String r1);

    int H();

    void Q6(h80.a<Boolean> r1, boolean r2, boolean r3);

    SurfaceView R0();

    n W4();

    void X3(long r1, String r3, String r4, int r5);

    void c2(int r1, int r2, String r3, LinkApplyType r4);

    void disconnect();

    y getLinkUserCenter();

    com.bytedance.android.live.pushstream.d getLiveStream();

    boolean isCurrentLinkPaid();

    boolean isEngineOn();

    void n4(SurfaceView r1);

    void r0(Context r1, IRoom r2, rj0.b r3);

    void w4();

    InteractAudienceVideoWindowManager windowManager();
}
