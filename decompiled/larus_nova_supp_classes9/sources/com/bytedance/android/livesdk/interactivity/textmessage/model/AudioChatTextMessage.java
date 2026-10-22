package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AudioChatTextMessage extends com.bytedance.android.livesdk.interactivity.api.entity.f<com.bytedance.android.live.base.model.message.r> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean d() {
        T r0 = this.b;
        if (r0 != 0) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L19;
        IBaseUser r2 = x();
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.service.model.d r3 = (com.bytedance.android.livesdk.interactivity.service.model.d) r2.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.d.class);
        if (r3 == null) goto L16;
        PublicAreaBadgeInfo r4 = r3.getPublicAreaBadgeInfo();
    L17:
        if (r4 != null) goto L19;
        return true;
    L16:
        r4 = null;
    L19:
        return false;
    L5:
        if (r0.isInsert() == false) goto L9;
        if (A() == false) goto L9;
        r1 = true;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        IBaseUser r0 = this.b.getUserInfo();
        SpannableType r1 = SpannableType.NORMAL;
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        int r3 = i0.a(2131107646);
        if (r0 == null) goto L15;
        if (TextUtils.isEmpty(gm2.q.b(r0)) == true) goto L15;
        StringBuilder r4 = new StringBuilder();
        String r5 = null;
        if (TextUtils.isEmpty(null) == false) goto L10;
        r5 = gm2.q.b(r0);
    L10:
        r4.append(r5);
        r4.append("：");
        String r6 = r4.toString();
        if (TextUtils.isEmpty(r6) == true) goto L16;
        ForegroundColorSpan r7 = new ForegroundColorSpan(r3);
        SpannableString r8 = new SpannableString(r6);
        r8.setSpan(r7, 0, r6.length(), 33);
        return r8;
    L16:
        return sb2.a.a;
    L15:
        return sb2.a.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final MessageIdentity n() {
        com.bytedance.android.live.base.model.message.r r0 = this.b;
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
        com.bytedance.android.live.base.model.message.r r0 = this.b;
        if (r0 == null) goto L6;
        return r0.getOrInitPublicAreaCommon();
    L6:
        return super.v();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        return new tb2.d().a(new AudioChatTextMessage$getRenderText$1(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r19) {
        if (x() != null) goto L6;
        return false;
    L6:
        UserProfileEvent r1 = new UserProfileEvent(x());
        r1.setClickUserPosition("personal_profile");
        r1.mSource = "personal_profile";
        r1.mReportTypeForLog = "data_card_audience";
        r1.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        if (this.b == null) goto L24;
        IBaseUser r2 = x();
        Intrinsics.checkNotNull(r2);
        String r3 = null;
        if (TextUtils.isEmpty(com.bytedance.android.live.base.model.user.o.a(r2)) == false) goto L14;
        String r5 = y();
        String r6 = this.b.getContent();
        long r7 = this.b.getMessageId();
        IBaseUser r4 = x();
        if (r4 == null) goto L13;
        r3 = r4.getWebcastUid();
    L13:
        r1.mCommentReportModel = new zg1.u(r5, r6, r7, 1, r3);
    L18:
        zg1.u r8 = r1.mCommentReportModel;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a r9 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0;
        T r10 = this.b;
        r9.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r11 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r10);
        if (r11 == null) goto L22;
        String r13 = r11.e();
        if (r13 == null) goto L22;
    L23:
        r8.g(r13);
    L22:
        r13 = BuildConfig.FLAVOR;
        goto L23
    L14:
        IBaseUser r14 = x();
        Intrinsics.checkNotNull(r14);
        String r15 = com.bytedance.android.live.base.model.user.o.a(r14);
        String r16 = this.b.getContent();
        long r17 = this.b.getMessageId();
        IBaseUser r18 = x();
        if (r18 == null) goto L17;
        r3 = r18.getWebcastUid();
    L17:
        r1.mCommentReportModel = new zg1.u(r15, r16, r17, 1, r3);
    L24:
        xs2.b.a().post(r1);
        J("default_user");
        return true;
    }

    public AudioChatTextMessage(com.bytedance.android.live.base.model.message.r r2, MessageSceneType r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        super(r2, r3, 6);
    }
}
