package com.bytedance.android.livesdk.dislike.recommendlive;

import am2.x;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livehostapi.business.depend.dislike.RecommendToFriendsParams;
import com.bytedance.android.livesdk.config.jm0;
import com.bytedance.android.livesdk.config.mm0;
import com.bytedance.android.livesdk.config.nm0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous.LiveRecommendRequestParams;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous.LiveRecommendStatusRequestParams;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RecommendLiveHelper {
    public static final /* synthetic */ int a = 0;

    public RecommendLiveHelper() {
    }

    public static boolean b(long r3) {
        if (r3 != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static ILiveRecommendToFriendsService d() {
        IHostBusiness r0 = k.f(IHostBusiness.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveRecommendToFiendsService();
    }

    public static boolean e() {
        if (nm0.a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (mm0.a.getValue().getEnableInputDialog() == false) goto L7;
        return true;
    }

    public static boolean f() {
        ILiveRecommendToFriendsService r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRecommendedLive();
    }

    public static void k() {
        ILiveRecommendToFriendsService r0 = d();
        if (r0 == null) goto L6;
        r0.setIsRecommendedLive();
        return;
    }

    static {
    }

    public static boolean g(long r1) {
        ILiveRecommendToFriendsService r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRoomRecommended(r1);
    }

    public static void l(long r1) {
        ILiveRecommendToFriendsService r0 = d();
        if (r0 == null) goto L6;
        r0.setRoomRecommended(r1);
        return;
    }

    public static Disposable c(long r10, final ILiveRecommendToFriendsCallback r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "tag");
        if (jm0.a.getValue().getEnable() == false) goto L12;
        ILiveRecommendToFriendsService r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (g(r10) == false) goto L9;
        long r2 = 1;
    L11:
        return r0.requestRecommendLiveStatus(new LiveRecommendStatusRequestParams(r10, r13, r2, new RecommendLiveHelper$getRecommendStatus$1(r12), new RecommendLiveHelper$getRecommendStatus$2(r12)));
    L9:
        r2 = 0;
        goto L11
    L12:
        ILiveRecommendToFriendsService r14 = d();
        if (r14 != null) goto L15;
        return null;
    L15:
        return r14.getRoomRecommendStatus(r10, r12);
    }

    public static void a(long r15, String r17, final ILiveRecommendToFriendsCallback r18, String r19) {
        Intrinsics.checkNotNullParameter(r17, "anchorId");
        Intrinsics.checkNotNullParameter(r18, "callback");
        Intrinsics.checkNotNullParameter(r19, "tag");
        if (jm0.a.getValue().getEnable() == false) goto L8;
        ILiveRecommendToFriendsService r1 = d();
        if (r1 == null) goto L12;
        r1.requestLiveRecommendApi(new LiveRecommendRequestParams(r15, r17, r19, new RecommendLiveHelper$cancelRecommend$1(r18), new RecommendLiveHelper$cancelRecommend$2(r18), -1, false, null, 192, null), true);
        return;
    L12:
        return;
    L8:
        ILiveRecommendToFriendsService r2 = d();
        if (r2 == null) goto L13;
        r2.cancelRecommendRoom(r15, false, r18);
        return;
    }

    public static void i(Room r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "sharePlatform");
        HashMap r0 = new HashMap();
        if (r5 == null) goto L9;
        User r3 = r5.getOwner();
        if (r3 == null) goto L9;
        if (r3.isFollowing() != true) goto L9;
        String r4 = "1";
    L10:
        r0.put("is_fans", r4);
        r0.put("status", r6);
        r0.put("share_platform", r7);
        r0.put("entrance_name", r7);
        if (r8 == null) goto L13;
        r0.put("entrance_name", r8);
    L13:
        if (r5 == null) goto L15;
        LiveMode r9 = r5.getStreamType();
    L16:
        int r10 = h1.a;
        r0.put("live_type", i1.a(r9));
        r0.put("event_page", "live_detail");
        u.l().sendLog("livesdk_follower_share_show", r0, new Object[]{x.class, Room.class});
        g r11 = u.l();
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("is_live", "1");
        r12.put("enter_method", "live_inner_long_press");
        r12.put("action_type", "show");
        Unit r13 = Unit.INSTANCE;
        r11.h("recommend_video_toast", r12, new Object[0]);
        return;
    L15:
        r9 = null;
    L9:
        r4 = "0";
        goto L10
    }

    public static void m(FragmentManager r1, RecommendToFriendsParams r2, DataCenter r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "fragmentManager");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r4, "recommendEntranceName");
        a r0 = new a(r2, r4, r3);
        ILiveRecommendToFriendsService r5 = d();
        if (r5 == null) goto L6;
        r5.showPromptDialog(r1, r2, r0);
        return;
    }

    public static void h(Room r5, String r6, String r7, String r8, int r9) {
        if ((r9 & 4) == 0) goto L5;
        r7 = "long_press";
    L5:
        LiveMode r0 = null;
        if ((r9 & 8) == 0) goto L8;
        r8 = null;
    L8:
        Intrinsics.checkNotNullParameter(r7, "sharePlatform");
        HashMap r10 = new HashMap();
        if (r5 == null) goto L15;
        User r3 = r5.getOwner();
        if (r3 == null) goto L15;
        if (r3.isFollowing() != true) goto L15;
        String r4 = "1";
    L16:
        r10.put("is_fans", r4);
        r10.put("share_platform", r7);
        r10.put("entrance_name", r7);
        if (r8 == null) goto L19;
        r10.put("entrance_name", r8);
    L19:
        r10.put("event_page", "live_detail");
        if (r5 == null) goto L22;
        r0 = r5.getStreamType();
    L22:
        int r11 = h1.a;
        r10.put("live_type", i1.a(r0));
        r10.put("status", r6);
        u.l().sendLog("livesdk_follower_share", r10, new Object[]{x.class, Room.class});
        g r12 = u.l();
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("is_live", "1");
        r13.put("enter_method", "live_inner_long_press");
        r13.put("action_type", "click");
        Unit r14 = Unit.INSTANCE;
        r12.h("recommend_video_toast", r13, new Object[0]);
        return;
    L15:
        r4 = "0";
        goto L16
    }

    public static void j(long r14, String r16, final ILiveRecommendToFriendsCallback r17, String r18, boolean r19, final DataCenter r20) {
        Intrinsics.checkNotNullParameter(r16, "anchorId");
        Intrinsics.checkNotNullParameter(r17, "callback");
        Intrinsics.checkNotNullParameter(r18, "tag");
        if (jm0.a.getValue().getEnable() == false) goto L18;
        o r1 = u.l().c(x.class);
        if (r1 == null) goto L9;
        Map r2 = r1.getMap();
        if (r2 == null) goto L9;
        String r3 = (String) r2.get("enter_from_merge");
    L11:
        if (Intrinsics.areEqual(r3, "homepage_hot") == false) goto L13;
        int r9 = 2;
    L14:
        ILiveRecommendToFriendsService r4 = d();
        if (r4 == null) goto L22;
        r4.requestLiveRecommendApi(new LiveRecommendRequestParams(r14, r16, r18, new RecommendLiveHelper$recommendRoom$1(r17), new RecommendLiveHelper$recommendRoom$2(r17), r9, r19, new RecommendLiveHelper$recommendRoom$3(r20)), false);
        return;
    L22:
        return;
    L13:
        r9 = 0;
    L9:
        r3 = null;
        goto L11
    L18:
        ILiveRecommendToFriendsService r5 = d();
        if (r5 == null) goto L23;
        r5.recommendRoom(r14, false, r17);
        return;
    }
}
