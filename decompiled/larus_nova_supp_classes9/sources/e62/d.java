package e62;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.j;
import gm2.q;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import u22.m;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(User r2) {
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L7;
        f r1 = r0.user();
        if (r1 == null) goto L7;
        String r3 = r1.n();
    L8:
        String r4 = r2.getIdStr();
        o0.a.getClass();
        return o0.a.a(r3, r4);
    L7:
        r3 = null;
        goto L8
    }

    public static void d(User r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        UserProfileEvent r0 = new UserProfileEvent(r2);
        r0.mReportTypeForLog = "data_card_audience";
        r0.setForceSecret(!a(r2));
        r0.fromRoomChannelType = 1;
        r0.setExtraFollowParams(j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        xs2.b.a().post(r0);
    }

    public static void b(User r10, long r11, String r13) {
        Intrinsics.checkNotNullParameter(r10, "user");
        Intrinsics.checkNotNullParameter(r13, "content");
        UserProfileEvent r1 = new UserProfileEvent(r10);
        r1.mSource = "personal_profile";
        r1.mReportTypeForLog = "data_card_audience";
        if (TextUtils.isEmpty(r10.getCastSecUid()) == true) goto L5;
        u r9 = new u(r10.getCastSecUid(), r13, r11, 4, r10.getWebcastUid());
    L6:
        r1.mCommentReportModel = r9;
        r1.setForceSecret(!a(r10));
        r1.fromRoomChannelType = 1;
        r1.setExtraFollowParams(j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        xs2.b.a().post(r1);
        return;
    L5:
        r9 = new u(r10.getIdStr(), r13, r11, 4, r10.getWebcastUid());
        goto L6
    }

    public static void c(User r11, long r13, long r14) {
        Intrinsics.checkNotNullParameter(r11, "user");
        String r0 = q.b(r11);
        m.a r10 = new m.a("message", false, r11.getIdString(), 2, r0, r13, r11.getWebcastUid());
        r10.j = r11;
        m r15 = new m(r0);
        r15.e = r10;
        r15.m = 1;
        r15.l = OpenInputSource.LongPressMessage;
        r15.n = r14;
        xs2.b.a().post(r15);
    }
}
