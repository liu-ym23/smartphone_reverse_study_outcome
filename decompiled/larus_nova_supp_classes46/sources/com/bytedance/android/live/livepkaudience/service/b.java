package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.base.p;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractAnchorContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {
    public static final a v0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("linkpk_interact_anchor_service");
            if ((r0 instanceof LinkPkInteractAnchorContext) == true) goto L5;
            r0 = null;
        L5:
            LinkPkInteractAnchorContext r1 = (LinkPkInteractAnchorContext) r0;
            if (r1 == null) goto L11;
            j<b> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.service.b$b, reason: collision with other inner class name */
    public static final class C0120b {
        public static /* synthetic */ void a(b r1, String r2, String r3) {
            r1.kickOut(r2, r3, "");
        }
    }

    static {
        v0 = a.a;
    }

    void Fl(User r1);

    int H();

    p X4();

    void b5(String r1);

    void bf(boolean r1);

    void finishInteract(String r1);

    i getLinkUserCenter();

    void invite(long r1, String r3, String r4, int r5, long r6);

    void kickOut(String r1, String r2, String r3);

    void markSwitchToMulti(boolean r1);

    void switchAudioByClient(boolean r1, List<AnchorLinkUser> r2, long r3, Map<Long, ? extends RoomLinkerContent> r5);

    void u3(String r1);
}
