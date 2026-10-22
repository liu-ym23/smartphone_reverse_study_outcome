package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.c4;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.textmessage.render.TextMessageSpanAction;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 extends com.bytedance.android.livesdk.interactivity.api.entity.f<h4> implements o {
    public boolean G;

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        IBaseUser r1 = this.b.getUserInfo();
        String r3 = this.b.getChatContent();
        SpannableType r0 = SpannableType.NORMAL;
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        int r4 = i0.a(2131107646);
        Intrinsics.checkNotNullParameter(this.i, "type");
        return i0.c(r1, "：", r3, r4, i0.a(2131107647), null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        Intrinsics.checkNotNullParameter(this.i, "type");
        return i0.a(2131107647);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final MessageIdentity n() {
        h4 r0 = this.b;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.getMessageIdentity() == null) goto L40;
        if (((Boolean) c4.a.getValue()).booleanValue() == false) goto L40;
        if (this.b.getUserInfo() != null) goto L12;
    L38:
        return null;
    L12:
        if (this.b.getUserInfo().getIdString() == null) goto L38;
        String r1 = this.b.getUserInfo().getIdString();
        if (jc1.k.f(IRoomContextService.class) != null) goto L16;
    L18:
        User r2 = null;
    L20:
        if (jc1.k.f(IMiddlewareUserService.class) == null) goto L22;
        User r3 = jc1.k.f(IMiddlewareUserService.class).user().b();
    L24:
        if (r3 == null) goto L29;
        if (r2 != null) goto L27;
    L28:
        ALogger.w("ScreenMessageLabel", "userInRoomId: " + r3.getIdString());
        r2 = r3;
        goto L29
    L27:
        if (TextUtils.equals(r3.getIdString(), r2.getIdString()) == false) goto L28;
    L29:
        if (r1 == null) goto L34;
        if (r2 == null) goto L34;
        if (TextUtils.equals(r1, r2.getIdString()) == false) goto L34;
        ALogger.w("ScreenMessageLabel", "senderId:" + r1 + " userInRoom:" + r2.getIdString());
        boolean r4 = true;
    L35:
        if (r4 == false) goto L38;
        return this.b.getMessageIdentity();
    L34:
        ALogger.e("ScreenMessageLabel", "error! senderId:" + r1);
        r4 = false;
        goto L35
    L22:
        r3 = null;
        goto L24
    L16:
        if (jc1.k.f(IRoomContextService.class).getRoomDataContext(null, 0).getUser() == null) goto L18;
        r2 = jc1.k.f(IRoomContextService.class).getRoomDataContext(null, 0).getUser();
    L40:
        return this.b.getMessageIdentity();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.a(2131107646);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IPublicAreaCommon v() {
        h4 r0 = this.b;
        if (r0 == null) goto L7;
        return r0.getOrInitPublicAreaCommon();
    L7:
        return super.v();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        this.G = com.bytedance.android.livesdk.interactivity.common.utils.h.a(this.e);
        if (this.b.getSelfFakeRichContent() != null) goto L5;
        TextMessageSpanAction r1 = null;
        if (this.b.getRichText() == null) goto L10;
        tb2.d r0 = PublicScreenRichTextUtilsKt.a(this.b, j(), this.G, TextMessageSpanAction.CHAT_CONTENT);
        r0.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(this.b.getUserInfo(), null, true, this.e));
        return r0;
    L10:
        tb2.d r2 = new tb2.d().a(new e0(this));
        tb2.c r3 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getChatContent());
        if (this.G == false) goto L13;
        r1 = TextMessageSpanAction.CHAT_CONTENT;
    L13:
        r2.c(r3.setClickAction(r1));
        return r2;
    L5:
        return new tb2.d().a(new e0(this)).a(new f0(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable m() {
        super.m();
        Spannable r0 = this.j;
        ab2.a.b(r0, (int) UIUtils.dip2Px(s1.getContext(), 16.0f));
        this.j = r0;
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r3) {
        if (x() != null) goto L5;
        return false;
    L5:
        b(x(), ReportObject.Comment, false);
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean G(Context r13) {
        if (x() != null) goto L5;
        return false;
    L5:
        String r14 = gm2.q.b(x());
        h4 r1 = this.b;
        if (r1 != null) goto L8;
        long r2 = 0;
    L9:
        long r7 = r2;
        if (x() != null) goto L12;
        String r3 = null;
    L13:
        String r9 = r3;
        if (x() == null) goto L18;
        x().getIdString();
    L18:
        if (y() != this.f) goto L20;
        boolean r4 = true;
    L21:
        u22.m.a r10 = new u22.m.a("message", r4, y(), 2, r14, r7, r9);
        r10.j = x();
        u22.m r0 = new u22.m(r14);
        r0.e = r10;
        r0.l = OpenInputSource.LongPressMessage;
        r10.a("message_type", this.b.getMessageMethod());
        r10.a("is_reply_user_show", "0");
        h4 r15 = this.b;
        if (r15 == null) goto L28;
        r10.k = r15.isFromOtherIntercomRoom();
        if (this.b.getOfficialCommentConfig() == null) goto L28;
        if (this.b.getOfficialCommentConfig().a() == false) goto L28;
        r10.l = true;
    L28:
        xs2.b.a().post(r0);
        return true;
    L20:
        r4 = false;
        goto L21
    L12:
        r3 = x().getWebcastUid();
        goto L13
    L8:
        r2 = r1.getMessageId();
        goto L9
    }

    public g0(h4 r2, MessageSceneType r3) {
        super(r2, r3, 0);
        this.G = false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r20, ReportObject r21, boolean r23) {
        if (x() != null) goto L5;
    L7:
        ReportObject r1 = r21;
    L8:
        if (r23 == false) goto L10;
        J("text_user");
    L11:
        UserProfileEvent r2 = new UserProfileEvent(r20);
        r2.mSource = "live_barrage";
        r2.setClickUserPosition("personal_profile");
        r2.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        if (r1 != ReportObject.User) goto L14;
        String r4 = "at_user";
    L15:
        r2.addProfileShowExtraLog("comment_enter_position", r4);
        if (this.b != 0) goto L18;
    L25:
        r2.setReportObject(r1.name());
        xs2.b.a().post(r2);
        return true;
    L18:
        if (TextUtils.isEmpty(r20.getCastSecUid()) == false) goto L20;
        r2.mCommentReportModel = new zg1.u(y(), this.b.getChatContent(), this.b.getMessageId(), 2, r20.getWebcastUid());
    L21:
        T r3 = this.b;
        int r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.c.a;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a r6 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0;
        r6.getClass();
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r3) == null) goto L24;
        zg1.u r7 = r2.mCommentReportModel;
        T r8 = this.b;
        r6.getClass();
        r7.g(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r8).e());
    L24:
        r2.mClickFromMessage = this.b;
        goto L25
    L20:
        r2.mCommentReportModel = new zg1.u(r20.getCastSecUid(), this.b.getChatContent(), this.b.getMessageId(), 2, r20.getWebcastUid());
        goto L21
    L14:
        r4 = "comment_user";
        goto L15
    L10:
        J("default_user");
        goto L11
    L5:
        if (TextUtils.equals(r20.getIdString(), x().getIdString()) == false) goto L7;
        r1 = ReportObject.Comment;
        goto L8
    }
}
