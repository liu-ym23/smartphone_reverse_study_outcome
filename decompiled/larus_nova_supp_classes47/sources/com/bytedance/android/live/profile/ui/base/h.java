package com.bytedance.android.live.profile.ui.base;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.profile.event.EventHub;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.live.profile.usecase.q;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface h {
    void dismiss();

    void enterWaitFor(Observable<Object> r1);

    py.k getDressImageModelWithFallback(DressType r1);

    com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.a> getEnterExitState();

    EventHub getEventHub();

    /* JADX INFO: renamed from: getFinalProfileUser */
    com.bytedance.android.live.core.arch.mvvm.d<sh6.b<NewProfileUser>> mo5getFinalProfileUser();

    String getFlashCardAsset();

    /* JADX INFO: renamed from: getLifecycleState */
    com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.b> mo6getLifecycleState();

    NewProfileTrackUseCase getLogUseCase();

    q getPageTypeUseCase();

    String getParallaxAsset();

    NewProfileUser getPreTargetUser();

    ProfileMode getProfileMode();

    ProfileMonitor getProfileMonitor();

    int getProfileWidth(Boolean r1);

    ps0.b getRoom();

    DataCenter getRoomDataCenter();

    IBaseUser getRoomUser();

    NewProfileUser getTargetUser();

    UserProfileEvent getUserProfileEvent();

    boolean isMyLive();

    boolean isPad();

    boolean isVertical();

    void logSubscribeVIPCardShow();

    void recordBusinessClick(String r1, Map<? extends String, String> r2);

    void recordBusinessShow(TrackArea r1, String r2);

    void recordShowMap(Map<String, String> r1);

    void sendLog(String r1, Map<String, String> r2, Object... r3);

    void showFansClub(FragmentActivity r1, String r2, boolean r3);

    void showKtvPanel(FragmentActivity r1);

    void showSubscribePanel(FragmentActivity r1, boolean r2);

    void showWhiteCertPageNoLog(Context r1, WhiteCategoryCert.SubCertInfo r2);
}
