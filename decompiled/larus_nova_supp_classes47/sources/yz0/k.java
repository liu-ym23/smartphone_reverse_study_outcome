package yz0;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.revenue.room.RevPadOrientation;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface k extends dy0.d, f80.b, g {
    long Hl();

    Observable<IBaseUser> L0();

    String Ln();

    Observable<Boolean> Z2();

    boolean e4();

    dq2.a getActivityRoomSkinInfo();

    Observable<dq2.e> getAudioTalkSwitchSceneEvent();

    /* synthetic */ Context getContext();

    DataCenter getDataCenter();

    long getDesireId();

    long getEnterRoomTime();

    long getForbiddenBeforeEnd();

    boolean getHasCommerceEntrance();

    long getLiveDurationStartTime();

    ILiveMode getLiveMode();

    String getLogPb();

    RevPadOrientation getPadOrientationData();

    IRoom getRoom();

    List<IToolbarComponentData> getToolbarDataList();

    IBaseUser getUser();

    long getUserFrom();

    dq2.g getVideoTalkRoomSubScene();

    boolean isAnchor();

    boolean isAudioRoom();

    boolean isCleanMode();

    boolean isGameRoom();

    boolean isLiveTypeSandbox();

    boolean isPortraitInteraction();

    void xc(long r1);
}
