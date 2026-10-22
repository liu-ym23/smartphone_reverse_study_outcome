package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.textmessage.render.TextMessageSpanAction;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends com.bytedance.android.livesdk.interactivity.api.entity.f<k0> implements o {
    public boolean G;

    public class a implements DisplayTimeRecorder.a {
        public final /* synthetic */ d a;

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void b(DisplayTimeRecorder.b r1) {
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void a(int r2) {
            if (r2 != 1) goto L6;
            com.bytedance.android.livesdk.interactivity.api.q r3 = com.bytedance.android.livesdk.interactivity.api.q.a;
            boolean r4 = this.a.b.isFromOtherIntercomRoom();
            com.bytedance.android.livesdk.interactivity.api.base.b.m.getClass();
            com.bytedance.android.livesdk.interactivity.api.base.b.a.c(r4);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final DisplayTimeRecorder I() {
        return new DisplayTimeRecorder(this.b, new a(this));
    }

    public final int K() {
        if (this.b.isFromOtherIntercomRoom() == false) goto L6;
        int r0 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.a(2131107651);
    L6:
        int r1 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.a(2131107646);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        IBaseUser r1 = this.b.getUserInfo();
        String r3 = this.b.getChatContent();
        SpannableType r0 = SpannableType.NORMAL;
        int r4 = K();
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
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
        k0 r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageIdentity();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Long p() {
        k0 r0 = this.b;
        if (r0 == null) goto L7;
        return Long.valueOf(r0.getReceiveTime());
    L7:
        return 0L;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        SpannableType r0 = SpannableType.NORMAL;
        return K();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IPublicAreaCommon v() {
        k0 r0 = this.b;
        if (r0 == null) goto L7;
        return r0.getCommonArea();
    L7:
        return super.v();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        this.G = com.bytedance.android.livesdk.interactivity.common.utils.h.a(this.e);
        if (this.b.getSelfFakeRichContent() != null) goto L13;
        TextMessageSpanAction r1 = null;
        if (this.b.getRichText() == null) goto L8;
        tb2.d r0 = PublicScreenRichTextUtilsKt.a(this.b, j(), this.G, TextMessageSpanAction.CHAT_CONTENT);
        r0.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(this.b.getUserInfo(), null, true, this.e));
        return r0;
    L8:
        tb2.d r2 = new tb2.d().a(new b(this));
        tb2.c r3 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getChatContent());
        if (this.G == false) goto L11;
        r1 = TextMessageSpanAction.CHAT_CONTENT;
    L11:
        r2.c(r3.setClickAction(r1));
        return r2;
    L13:
        return new tb2.d().a(new b(this)).a(new c(this));
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
        if (this.b.isFromFirstRequest() == false) goto L8;
    L9:
        Map r4 = this.b.getMessageExtra();
        if (r4 != null) goto L12;
    L14:
        String r5 = BuildConfig.FLAVOR;
    L15:
        r42.q.a(r5);
        return true;
    L12:
        if (r4.get("history_comment_type") == null) goto L14;
        r5 = (String) r4.get("history_comment_type");
        goto L15
    L8:
        if (this.g == true) goto L9;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean G(Context r1) {
        return super.G(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void i(HashMap<String, String> r4) {
        k0 r0 = this.b;
        if (r0 == null) goto L12;
        IPublicAreaCommon r1 = r0.getOrInitPublicAreaCommon();
        if (r1 == null) goto L13;
        Map r2 = r1.getTrackingParams();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.containsKey("msg_show_type") == false) goto L15;
        r4.put("msg_show_type", (String) r2.get("msg_show_type"));
        return;
    L15:
        return;
    L13:
        return;
    }

    public d(k0 r2, MessageSceneType r3) {
        super(r2, r3, 0);
        this.G = false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r21, ReportObject r23, boolean r24) {
        if (x() != null) goto L5;
    L7:
        ReportObject r1 = r23;
    L8:
        if (r24 == false) goto L10;
        J("text_user");
    L11:
        UserProfileEvent r2 = new UserProfileEvent(r21);
        r2.mSource = "personal_profile";
        r2.setClickUserPosition("personal_profile");
        r2.mReportTypeForLog = "data_card_audience";
        r2.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        if (r1 != ReportObject.User) goto L14;
        String r4 = "at_user";
    L15:
        r2.addProfileShowExtraLog("comment_enter_position", r4);
        if (this.b != 0) goto L18;
    L27:
        r2.mClickFromMessage = this.b;
        r2.setReportObject(r1.name());
        xs2.b.a().post(r2);
        return true;
    L18:
        if (TextUtils.isEmpty(r21.getCastSecUid()) == false) goto L20;
        r2.mCommentReportModel = new zg1.u(y(), this.b.getChatContent(), this.b.getMessageId(), 1, r21.getWebcastUid());
    L21:
        T r3 = this.b;
        int r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.c.a;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a r6 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0;
        r6.getClass();
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r3) == null) goto L25;
        zg1.u r7 = r2.mCommentReportModel;
        T r8 = this.b;
        r6.getClass();
        r7.g(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r8).e());
    L25:
        if (this.b.isFromOtherIntercomRoom() == false) goto L27;
        r2.setFromOtherIntercomRoom(true);
        r2.setIntercomHideUserCard(this.b.intercomHideUserCard());
        goto L27
    L20:
        r2.mCommentReportModel = new zg1.u(r21.getCastSecUid(), this.b.getChatContent(), this.b.getMessageId(), 1, r21.getWebcastUid());
        goto L21
    L14:
        r4 = "comment_user";
        goto L15
    L10:
        J("default_user");
        goto L11
    L5:
        if (TextUtils.equals(r21.getIdString(), x().getIdString()) == false) goto L7;
        r1 = ReportObject.Comment;
        goto L8
    }
}
