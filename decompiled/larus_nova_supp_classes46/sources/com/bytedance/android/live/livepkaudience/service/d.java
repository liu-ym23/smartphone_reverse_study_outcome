package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d {
    public static final a x0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static d a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("linkpk_interact_guest_service");
            if ((r0 instanceof LinkPkInteractGuestContext) == true) goto L5;
            r0 = null;
        L5:
            LinkPkInteractGuestContext r1 = (LinkPkInteractGuestContext) r0;
            if (r1 == null) goto L11;
            j<d> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (d) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void b(d r1) {
            r1.disconnect("leave_normally");
        }

        public static /* synthetic */ void a(d r1, int r2, int r3, String r4) {
            r1.c2(r2, r3, r4, LinkApplyType.NORMAL);
        }
    }

    static {
        x0 = a.a;
    }

    void Rc(long r1, String r3, int r4);

    boolean T2();

    void c2(int r1, int r2, String r3, LinkApplyType r4);

    void cancelApply();

    void disconnect(String r1);

    m00.g getGuestLinkViewNew();

    i getLinkUserCenter();

    m00.g go();

    boolean isEngineOn();

    void onFirstRemoteVideoSend();

    void switchAudioByClient(boolean r1, List<AnchorLinkUser> r2, long r3, Map<Long, ? extends RoomLinkerContent> r5);
}
