package com.bytedance.android.live.profile;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.GiftExhibitionHomeStats;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.profile.p000enum.DressClickArea;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    void atUser(Context r1);

    void attention(Context r1);

    void clickAvatar(FragmentActivity r1);

    void clickDynamicSpaceView();

    void clickEcomSet(DialogFragment r1, NewProfileUser r2);

    void clickFansGroupCreate(Context r1);

    void clickFansGroupManage(Context r1);

    void clickGiftExhibitionCard(Context r1, GiftExhibitionHomeStats r2);

    void clickOwnerCenter(DialogFragment r1, NewProfileUser r2);

    void clickShopEntrance(Context r1, int r2, Class<Object> r3, String r4);

    void digg(Context r1, String r2);

    void dismiss();

    LiveData<Boolean> getAnonymousSilentLiveData();

    LiveData<Integer> getFollowInfoLiveData();

    v32.b getLikeView(Context r1);

    ut0.f getLogUseCaseForUi();

    Map<String, String> getSquareJumpTrackParams();

    void goStartLive(DialogFragment r1);

    void goToSquareUserLiveRoom(FragmentActivity r1);

    void goUserLiveRoom(FragmentActivity r1);

    void handleDynamicAction(Context r1, String r2);

    void kickOut(Context r1);

    void logOwnerCenterShow();

    @Deprecated(message = "直接使用NewProfileInfoViewModel的getLogUseCase或getLogUseCaseForUi")
    void logProile(NewProfileTrackUseCase.LogProfileType r1, HashMap<String, String> r2);

    void manage(Context r1);

    boolean needPerformHapticFeedback();

    void onDressClick(DressClickArea r1);

    void onVerifyViewClick(Context r1, String r2);

    void openIM(Fragment r1);

    void report(Activity r1);

    void showAnonymousUserSilentDialog(Context r1);

    void showDressUpCenter(DialogFragment r1);

    void showFansClub(FragmentActivity r1, String r2, boolean r3);

    void showFansGroupDialog(FragmentActivity r1);

    void showFlashShop(Context r1);

    void showGradePage(Context r1, String r2);

    boolean showJumpLinkAnchorButton();

    void showKtvPanel(FragmentActivity r1);

    void showNewCertDescPage(Context r1, String r2);

    void showShopEntrance(int r1, String r2);

    boolean showSquareButtonArea();

    void showSubscribePanel(FragmentActivity r1, boolean r2);

    void showVerifyPage(Context r1, String r2);

    void showWhiteCertPage(Context r1, WhiteCategoryCert.SubCertInfo r2);
}
