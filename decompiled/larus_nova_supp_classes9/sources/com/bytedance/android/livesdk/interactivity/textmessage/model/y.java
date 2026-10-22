package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
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
public final class y extends com.bytedance.android.livesdk.interactivity.api.entity.f<s3> implements o {
    public boolean G;

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        IBaseUser r1 = this.b.getChatUserInfo();
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
        s3 r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageIdentity();
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
        s3 r0 = this.b;
        if (r0 == null) goto L7;
        return r0.getOrInitPublicAreaCommon();
    L7:
        return super.v();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        this.G = com.bytedance.android.livesdk.interactivity.common.utils.h.a(this.e);
        if (this.b.getSelfFakeRichContent() != null) goto L5;
    L8:
        TextMessageSpanAction r1 = null;
        if (this.b.getRichText() != null) goto L11;
    L14:
        tb2.d r0 = new tb2.d().a(new w(this));
        tb2.c r2 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getChatContent());
        if (this.G == false) goto L17;
        r1 = TextMessageSpanAction.CHAT_CONTENT;
    L17:
        r0.c(r2.setClickAction(r1));
        return r0;
    L11:
        if (this.b.getChatUserInfo() == null) goto L14;
        tb2.d r3 = PublicScreenRichTextUtilsKt.a(this.b, j(), this.G, TextMessageSpanAction.CHAT_CONTENT);
        r3.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(this.b.getChatUserInfo(), null, true, this.e));
        return r3;
    L5:
        if (this.b.getChatUserInfo() == null) goto L8;
        return new tb2.d().a(new w(this)).a(new x(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getChatUserInfo();
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
    public final Spannable q() {
        super.m();
        Spannable r0 = this.j;
        UIUtils.dip2Px(s1.getContext(), 16.0f);
        ab2.a.c(r0);
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
    public final boolean G(Context r1) {
        return super.G(r1);
    }

    public y(s3 r2, MessageSceneType r3) {
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
        r2.mSource = "personal_profile";
        r2.mReportTypeForLog = "data_card_audience";
        r2.setClickUserPosition("personal_profile");
        r2.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        if (r1 != ReportObject.User) goto L14;
        String r4 = "at_user";
    L15:
        r2.addProfileShowExtraLog("comment_enter_position", r4);
        if (this.b != 0) goto L18;
    L22:
        r2.setReportObject(r1.name());
        xs2.b.a().post(r2);
        return true;
    L18:
        if (TextUtils.isEmpty(r20.getCastSecUid()) == false) goto L20;
        r2.mCommentReportModel = new zg1.u(y(), this.b.getChatContent(), this.b.getMessageId(), 1, r20.getWebcastUid());
    L21:
        r2.mClickFromMessage = this.b;
        goto L22
    L20:
        r2.mCommentReportModel = new zg1.u(r20.getCastSecUid(), this.b.getChatContent(), this.b.getMessageId(), 1, r20.getWebcastUid());
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
