package qs0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface i {
    String changeMode2String(int r1);

    Boolean chatRoomIsOpen();

    void g(long r1, IBaseUser r3);

    mv0.k.a getAudioTalkService();

    String getCurrentFunctionType();

    int getCurrentScene();

    String getFunctionType2();

    String getLinkConnectionType();

    mv0.k.d getLinkUserInfoCenter();

    mv0.k.e getVideoTalkService();

    mv0.k.b h(DataCenter r1);

    boolean isAnonymousUser(String r1);

    boolean isInLinkMicGameAnchorLinkMode();

    boolean isMicRoomHost(String r1);

    mv0.k.c linkRoomFightService();
}
