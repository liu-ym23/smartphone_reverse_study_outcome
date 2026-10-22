package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.b9;
import com.bytedance.android.livesdk.link.model.bridge.k2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface n {
    long G();

    String a();

    String c();

    boolean d();

    boolean e();

    String f();

    boolean g();

    String getActivityName();

    IBattleConfigSetting getBattleConfigSetting();

    List<String> getCannotPkAnchorIds();

    int getDuration();

    String getGameAppId();

    IRoom getGuestRoom();

    IBaseUser getGuestUser();

    int getInviteType();

    boolean getInviteeWithAudience();

    boolean getInviterWithAudience();

    Map<Long, b9> getLinkerContentMap();

    int getMatchType();

    int getPeakSwitchPlayMode();

    aa getPeakVoteSetting();

    String getRtcInfo();

    String getTheme();

    boolean h();

    boolean i();

    k2 j();

    boolean k();

    PkDoubleAnchorDataContext.d l();

    ArrayList<IBattleRivalTag> m();

    boolean n();

    boolean o();

    String y3();
}
