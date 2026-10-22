package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.VideoTalkAdminContext;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface k extends l {
    public static final a n0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static k a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("admin_video_talk");
            if ((r0 instanceof VideoTalkAdminContext) == true) goto L5;
            r0 = null;
        L5:
            VideoTalkAdminContext r1 = (VideoTalkAdminContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<k> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (k) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        n0 = a.a;
    }

    void closeMultiEnlargePosition(long r1, List<String> r3);

    void dj(String r1, String r2);

    void g0(IBaseUser r1);

    void ge(String r1, String r2);

    void invite(com.bytedance.android.live.liveinteract.videolink.a r1);

    void permit(ILinkPlayerInfoBridge r1);

    void setCPosition(long r1, String r3, boolean r4, String r5);

    void setInviteCallback(uf0.c r1);

    void setPermitCallback(uf0.d r1);

    void updateMultiEnlargePosition(long r1, String r3, long r4, String r6);

    void v0(int r1, String r2, int r3, String r4);
}
