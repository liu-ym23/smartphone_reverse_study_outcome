package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdkapi.message.OfficialCommentConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface q5 extends t, h0 {
    VSShowChatMessageCommentRoleConfig G0();

    void K1(List<String> r1);

    void R0(r5 r1);

    boolean a();

    List<String> b();

    void c1(long r1);

    void f1(o1 r1);

    long getAgreeMsgId();

    o1 getLandscapeAreaCommon();

    j0 getMedal();

    OfficialCommentConfig getOfficialCommentConfig();

    IBaseUser getUserInfo();

    boolean isSelfSendFake();

    void setBackground(py.k r1);

    void setBaseMessage(m0 r1);

    void setContent(String r1);

    void setEpisodeId(long r1);

    void setMsgId(String r1);

    void setSelfSendFake(boolean r1);

    void setUserInfo(IBaseUser r1);

    void w1(long r1);
}
