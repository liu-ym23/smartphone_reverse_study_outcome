package com.bytedance.android.livesdk.interactivity.square.plugin;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.square.common.common.CommonModelSpanClickListener;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tb2.g;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SquareModelSpanClickListener extends CommonModelSpanClickListener {
    public final Function2<View, g, Boolean> b;
    public final Function1<View, Unit> c;

    public SquareModelSpanClickListener() {
        this.b = new SquareModelSpanClickListener$userSpanListener$1(this);
        this.c = new SquareModelSpanClickListener$viewClickListener$1(this);
    }

    public static final UserProfileEvent c(SquareModelSpanClickListener r20, IBaseUser r21, gc2.a r23) {
        r20.getClass();
        if (r21 == null) goto L20;
        if (r23 == null) goto L20;
        UserProfileEvent r2 = new UserProfileEvent(r21);
        r2.mSource = "personal_profile";
        r2.setClickUserPosition("personal_profile");
        r2.forceHideDynamicComponent = true;
        r2.forceShowProfile = true;
        r2.setExtraFollowParams(j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        vh r3 = r23.n;
        if (r3 == null) goto L10;
        String r4 = String.valueOf(r3.c());
        if (r4 == null) goto L10;
    L11:
        r2.addProfileShowExtraLog("go_to_ta_live_room_id", r4);
        r2.addProfileShowExtraLog("from_comment_id", String.valueOf(r23.m));
        r2.addProfileShowExtraLog("from_square_msg_type", "common");
        Intrinsics.checkNotNullParameter(r21, "$this$secUidExt");
        if (TextUtils.isEmpty(r21.getCastSecUid()) == false) goto L18;
        String r7 = r21.getIdString();
        String r5 = r23.c;
        if (r5 != null) goto L16;
        String r8 = BuildConfig.FLAVOR;
    L17:
        r2.mCommentReportModel = new u(r7, r8, r23.m, 5, r21.getWebcastUid());
    L19:
        r2.setReportObject(ReportObject.Comment.name());
        r2.addProfileShowExtraLog("comment_enter_position", "comment_user");
        return r2;
    L16:
        r8 = r5;
        goto L17
    L18:
        Intrinsics.checkNotNullParameter(r21, "$this$secUidExt");
        r2.mCommentReportModel = new u(r21.getCastSecUid(), r23.c, r23.m, 5, r21.getWebcastUid());
    L10:
        r4 = BuildConfig.FLAVOR;
    L20:
        return null;
    }

    public static final void d(SquareModelSpanClickListener r2, gc2.a r3, String r4) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "clickType");
        LinkedHashMap r5 = new LinkedHashMap();
        IPublicAreaCommon r0 = r3.e;
        if (r0 == null) goto L7;
        Map r1 = r0.getTrackingParams();
        if (r1 == null) goto L7;
        r5.putAll(r1);
    L7:
        r5.put("msg_id", String.valueOf(r3.m));
        if (r3.j != MessageModelType.Square) goto L10;
        r5.put("square_msg_type", "common");
    L10:
        Boolean r6 = p.a;
        p.b(r3.d, r4, r5);
    }
}
