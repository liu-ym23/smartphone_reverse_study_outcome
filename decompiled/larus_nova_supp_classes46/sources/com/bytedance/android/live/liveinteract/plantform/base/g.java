package com.bytedance.android.live.liveinteract.plantform.base;

import android.content.DialogInterface;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardWidget;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface g {
    public static final PublishSubject<g> m0 = null;

    void Cj(String r1);

    void Hm(String r1);

    void I1(int r1, boolean r2);

    void Ik(boolean r1);

    void K7(String r1);

    void Lp(boolean r1);

    void Nf();

    void Sc();

    boolean Sd();

    BehaviorSubject<Boolean> U4();

    boolean W1();

    void Zc(int r1, String r2);

    void Zl(int r1);

    void a5(int r1, boolean r2);

    void d9(int r1);

    Widget em();

    void fastMatchJump(long r1, String r3, String r4);

    int getCurrentMode();

    i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    void getUserWaitingInfo(String r1, int r2, i.c r3);

    void handleInteractClick();

    void id(int r1, String r2);

    void initAndTurnOnChorusKTV();

    void initAndTurnOnKTV();

    void initAndTurnOnRadioLinkmicRoom(Runnable r1, Runnable r2);

    void initAndTurnOnVideoLinkmicRoom(Runnable r1, Runnable r2, int r3, int r4, String r5);

    void initAndTurnOnVoiceChatRoom();

    boolean isMicRoomHost(String r1);

    View j();

    boolean j7();

    boolean k0(int r1);

    void ld(int r1, int r2, int r3, String r4);

    void mq(Disposable r1);

    void multiAnchorLoadVideoTalk();

    void multiAnchorUnloadVideoTalk();

    void nb(int r1);

    boolean nd();

    void o6(String r1, boolean r2);

    void oa(String r1, int r2, int r3, DialogInterface.OnDismissListener r4);

    void permitPrepareApply(long r1, String r3);

    void pkInviteFailLoadWidget();

    void pkInviteUnloadWidget();

    void prepareApply(String r1);

    void prepareInvite(long r1, IBaseUser r3, String r4);

    void s4();

    boolean s8();

    void ua(long r1, String r3, int r4, String r5);

    void uo();

    void updateLinkMicStatus(ih0.f r1, ih0.h r2, IJsBridgeManager r3);

    void updateViewInLiveBg(String r1, JsonObject r2, ih0.h r3);

    void v7(boolean r1, int r2, int r3, String r4);

    void xh(PaidProfileCardWidget r1);

    com.bytedance.android.live.ui.c y4();

    void y6(boolean r1, int r2, int r3, int r4, String r5, int r6);

    void ye();

    void yg(int r1, int r2, List<Integer> r3);

    static {
        m0 = PublishSubject.create();
    }
}
