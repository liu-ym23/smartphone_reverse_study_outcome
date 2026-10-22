package com.ss.android.lark.contact.base.entity.bean;

import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class InvitationInfo implements Serializable {
    public static final ContactAvatarSourceStrategy a = null;
    public boolean canSearchWithToken;
    public String invMsg;
    public String invUrl;
    public String qrUrl;
    public String teamCode;
    public String teamName;
    public String uniqueId;
    public String userAvatarKey;
    public String userName;

    static {
        a = ContactAvatarSourceStrategy.FOREGROUND_USER;
    }

    public String getInAppShareContent() {
        return getInviteMsg();
    }

    public String getShareTitle() {
        return UIHelper.getString(2131892798);
    }

    public String getInviteMsg() {
        return this.invMsg;
    }

    public InvitationInfo(ContactAvatarSourceStrategy r5) {
        b r0 = (b) LarkContext.spiByDwarf(b.class);
        Chatter r1 = ImSdkService.d().ue(r0.d());
        this.userName = m.b(r1, ChatterNameDisplayRule.NAME, false);
        User r2 = r0.getForegroundUser();
        if (r2 != null) goto L5;
        return;
    L5:
        if (r5 != ContactAvatarSourceStrategy.LOGIN_CHATTER) goto L10;
        if (r1 == null) goto L10;
        if (r1.getAvatarKey() == null) goto L10;
        String r6 = r1.getAvatarKey();
    L11:
        this.userAvatarKey = r6;
        Tenant r7 = r2.tenant;
        if (r7 == null) goto L16;
        this.teamName = r7.name;
        return;
    L16:
        return;
    L10:
        r6 = r2.avatarKey;
        goto L11
    }

    public static InvitationInfo parseFromPb(GetContactTokenResponse.ContactTokenResponse r1) {
        return parseFromPb(r1, a);
    }

    public static InvitationInfo parseFromPb(GetContactTokenResponse.ContactTokenResponse r1, ContactAvatarSourceStrategy r2) {
        InvitationInfo r0 = new InvitationInfo(r2);
        String r3 = r1.invite_url;
        r0.invUrl = r3;
        r0.qrUrl = r3;
        r0.canSearchWithToken = r1.can_search_with_token.booleanValue();
        r0.invMsg = r1.invite_msg;
        r0.uniqueId = r1.unique_id;
        return r0;
    }
}
