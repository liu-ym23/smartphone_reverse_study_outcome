package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import ec2.z;
import kotlin.jvm.internal.Intrinsics;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    static {
    }

    public static UserProfileEvent a(t r21, IBaseUser r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r21, "message");
        Intrinsics.checkNotNullParameter(r23, "user");
        UserProfileEvent r2 = new UserProfileEvent(r23);
        r2.mSource = "personal_profile";
        r2.setClickUserPosition("personal_profile");
        r2.forceShowToast = r24;
        r2.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        boolean r3 = r21 instanceof h0;
        t r4 = null;
        if (r3 == false) goto L5;
    L6:
        Intrinsics.checkNotNullParameter(r23, "$this$secUidExt");
        if (TextUtils.isEmpty(r23.getCastSecUid()) == false) goto L17;
        String r8 = r23.getIdString();
        if (r3 == true) goto L11;
        t r5 = null;
    L12:
        h0 r6 = (h0) r5;
        if (r6 == null) goto L15;
        String r9 = r6.getChatContent();
    L16:
        r2.mCommentReportModel = new u(r8, r9, r21.getMessageId(), 1, r23.getWebcastUid());
    L26:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r21) == null) goto L33;
        u r1 = r2.mCommentReportModel;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r7 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r21);
        if (r7 == null) goto L31;
        String r10 = r7.e();
    L32:
        r1.g(r10);
        goto L33
    L31:
        r10 = null;
    L33:
        r2.setReportObject(ReportObject.Comment.name());
    L35:
        if (r21.isFromOtherIntercomRoom() == false) goto L45;
        r2.setFromOtherIntercomRoom(true);
        if ((r21 instanceof k0) == false) goto L40;
        r4 = r21;
    L40:
        k0 r11 = (k0) r4;
        if (r11 == null) goto L43;
        boolean r13 = r11.intercomHideUserCard();
    L44:
        r2.setIntercomHideUserCard(r13);
        goto L45
    L43:
        r13 = false;
    L45:
        r2.addProfileShowExtraLog("comment_enter_position", "comment_user");
        r2.mClickFromMessage = (tlc.d) r21;
        return r2;
    L15:
        r9 = null;
        goto L16
    L11:
        r5 = r21;
        goto L12
    L17:
        Intrinsics.checkNotNullParameter(r23, "$this$secUidExt");
        String r15 = r23.getCastSecUid();
        if (r3 == true) goto L20;
        t r14 = null;
    L21:
        h0 r16 = (h0) r14;
        if (r16 == null) goto L24;
        String r17 = r16.getChatContent();
    L25:
        r2.mCommentReportModel = new u(r15, r17, r21.getMessageId(), 1, r23.getWebcastUid());
        goto L26
    L24:
        r17 = null;
        goto L25
    L20:
        r14 = r21;
        goto L21
    L5:
        if (((Boolean) z.a.getValue()).booleanValue() == false) goto L35;
        goto L6
    }
}
