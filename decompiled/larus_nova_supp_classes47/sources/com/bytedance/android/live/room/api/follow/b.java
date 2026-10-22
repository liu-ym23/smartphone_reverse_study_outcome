package com.bytedance.android.live.room.api.follow;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.b0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static boolean b(Long r5) {
        if (r5 != null) goto L5;
    L9:
        return false;
    L5:
        if (r5.longValue() != 2) goto L7;
    L10:
        return true;
    L7:
        if (r5.longValue() != 1) goto L9;
        goto L9
    }

    public static void a(final b0 r12, final Function1 r13) {
        final String r7 = "ProfileFollowButtonView-profile";
        final boolean r5 = true;
        Intrinsics.checkNotNullParameter(r12, "user");
        Intrinsics.checkNotNullParameter("ProfileFollowButtonView-profile", "source");
        Intrinsics.checkNotNullParameter(r13, "callback");
        ALogger.i("FollowUtil", "[source: ProfileFollowButtonView-profile]:: targetUid: " + r12.getBaseProfileInfo().getIdStr() + ", room: null");
        if (r12.getFollowInfo() == null) goto L8;
        if (r12.getFollowInfo().getFollowStatus() == 0) goto L8;
        ALogger.i("FollowUtil", "[source: ProfileFollowButtonView-profile]:: targetUser's followInfo success: " + r12.getFollowInfo().getFollowStatus());
        r13.invoke(Integer.valueOf((int) r12.getFollowInfo().getFollowStatus()));
        return;
    L8:
        if (r12.getFollowInfo() != null) goto L10;
    L17:
        ALogger.i("FollowUtil", "[source: ProfileFollowButtonView-profile]:: followInfo error");
        final a r2 = new a();
        r2.a = System.currentTimeMillis();
        final IRoom r4 = null;
        k.n(IMiddlewareHostBusiness.class).getFollowStatusFromIMDB(r12.getBaseProfileInfo().getIdStr(), r12.getBaseProfileInfo().getSecUid(), "ProfileFollowButtonView-profile", new FollowUtil$getFollowStatusWithIMDB$1(r7, r2, r12, r4, r5, r13));
        return;
    L10:
        if (r12.getFollowInfo() != null) goto L12;
    L16:
        ALogger.i("FollowUtil", "[source: ProfileFollowButtonView-profile]:: targetUser followInfo else success: 0");
        r13.invoke(0);
        return;
    L12:
        if (r12.getFollowInfo().getFollowStatus() != 0) goto L16;
        if (r12.getFollowInfo().getInvalidFollowStatus() == false) goto L16;
        goto L16
    }

    public static void c(final IBaseUser r12, final String r13, final IRoom r14, final Function1 r15) {
        final boolean r5 = true;
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r15, "callback");
        boolean r0 = true;
        if (r12 == null) goto L5;
        boolean r1 = r12 instanceof IBaseUser;
    L7:
        if (r1 == false) goto L36;
        if (r14 == null) goto L10;
        r0 = r14 instanceof IRoom;
    L10:
        if (r0 == false) goto L36;
        StringBuilder r2 = new StringBuilder("[source: ");
        r2.append(r13);
        r2.append("]:: targetUid: ");
        Integer r3 = null;
        if (r12 == null) goto L15;
        String r4 = r12.getIdString();
    L16:
        r2.append(r4);
        r2.append(", room: ");
        if (r14 == null) goto L19;
        r3 = Integer.valueOf(r14.hashCode());
    L19:
        r2.append(r3);
        ALogger.i("FollowUtil", r2.toString());
        if (r12 != null) goto L23;
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: targetUser is null");
        r15.invoke(Boolean.FALSE);
        return;
    L23:
        if (r12.isFollowing() == false) goto L26;
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: targetUser is following");
        r15.invoke(Boolean.TRUE);
        return;
    L26:
        if (r12.getFollowInfo() != null) goto L28;
    L35:
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: followInfo error");
        final a r6 = new a();
        r6.a = System.currentTimeMillis();
        IMiddlewareHostBusiness r7 = k.n(IMiddlewareHostBusiness.class);
        String r8 = r12.getIdString();
        Intrinsics.checkNotNullParameter(r12, "$this$secUidExt");
        r7.getFollowStatusFromIMDB(r8, r12.getCastSecUid(), r13, new FollowUtil$isFollowingWithIMDB$1(r13, r6, r12, r14, r5, r15));
        return;
    L28:
        if (r12.getFollowInfo() == null) goto L34;
        j r9 = r12.getFollowInfo();
        Intrinsics.checkNotNull(r9);
        if (r9.getFollowStatus() != 0) goto L34;
        j r10 = r12.getFollowInfo();
        Intrinsics.checkNotNull(r10);
        if (r10.getInvalidFollowStatus() == true) goto L35;
    L34:
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: targetUser isn't following");
        r15.invoke(Boolean.FALSE);
        return;
    L15:
        r4 = null;
    L36:
        ALogger.i("FollowUtil", "Now FollowUtil can only run on the main line");
        return;
    L5:
        r1 = true;
        goto L7
    }

    public static void d(boolean r7, boolean r8, long r9, final User r12, final String r13, final IRoom r14, final Function1 r15) {
        final boolean r5 = true;
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r15, "callback");
        if (r14 == null) goto L5;
        boolean r0 = r14 instanceof IRoom;
    L7:
        if (r0 == true) goto L9;
        ALogger.i("FollowUtil", "Now FollowUtil can only run on the main line");
        return;
    L9:
        StringBuilder r1 = new StringBuilder("[source: ");
        r1.append(r13);
        r1.append("]:: targetUid: ");
        Integer r3 = null;
        if (r12 == null) goto L12;
        String r4 = r12.getIdString();
    L13:
        r1.append(r4);
        r1.append(", room: ");
        if (r14 == null) goto L16;
        r3 = Integer.valueOf(r14.hashCode());
    L16:
        r1.append(r3);
        ALogger.i("FollowUtil", r1.toString());
        if (r12 != null) goto L19;
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: targetUser is null");
        r15.invoke(Boolean.FALSE);
        return;
    L19:
        if (r7 == false) goto L22;
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: targetUser is following");
        r15.invoke(Boolean.TRUE);
        return;
    L22:
        if (r9 != 0) goto L25;
        if (r8 == false) goto L25;
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: followInfo error");
        final a r2 = new a();
        r2.a = System.currentTimeMillis();
        IMiddlewareHostBusiness r10 = k.n(IMiddlewareHostBusiness.class);
        String r16 = r12.getIdString();
        Intrinsics.checkNotNullParameter(r12, "$this$secUidExt");
        r10.getFollowStatusFromIMDB(r16, r12.getCastSecUid(), r13, new FollowUtil$isFollowingWithIMDB$2(r13, r2, r12, r14, r5, r15));
        return;
    L25:
        ALogger.i("FollowUtil", "[source: " + r13 + "]:: targetUser isn't following");
        r15.invoke(Boolean.FALSE);
        return;
    L12:
        r4 = null;
        goto L13
    L5:
        r0 = true;
        goto L7
    }
}
