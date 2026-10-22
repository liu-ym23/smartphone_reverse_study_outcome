package ca0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import org.json.JSONObject;
import zg1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface j extends dy0.c {
    void addGiftSendResultListener(s r1);

    void clearBattlePropCardMessageQueue();

    void convertHonorImageModel(py.k r1);

    List<String> convertRichContentImageUrls(List<String> r1);

    void downloadAssets(String r1, long r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r4, int r5);

    void downloadAssets(String r1, long r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r4, int r5, AssetDownloadPriority r6);

    h1 findGiftById(long r1);

    h2 findLiteGiftById(long r1);

    IAssetsManager getAssetsManager();

    String getAssetsPath(String r1, long r2);

    BaseCommentGiftGuideView getCommentGiftGuideView(Context r1);

    h1 getFastGift();

    i getGiftRenderFilterWrapper();

    BehaviorSubject<Long> getGiftSelectObservable();

    boolean getGiftTraySwitch();

    l getGiftWallPreRequestManager();

    List<IBaseUser> getGroupMemberList();

    int getGroupMemberNum();

    Widget getMatchRoomGiftTrayWidget();

    boolean getNeedShowGiftEffectSwitch();

    q getUICanvasMonitor();

    boolean hasPKPropCard();

    boolean isAssetsDownloaded(String r1, long r2);

    void notifyLowPriorityDownloadTask(Boolean r1);

    void openGiftDialog(IBaseUser r1, Bundle r2);

    void processRevenueApiResponse(String r1, JSONObject r2);

    void registerGiftPreviewDebugWidgetInstance(LiveRecyclableWidget r1);

    void removeGiftSendResultListener(s r1);

    Observable<ExtraResponse<p2, ? extends Extra>> sendGift(b0 r1, int r2);

    void setAllowSendToGuest(boolean r1);

    void setNeedShowGiftEffectSwitch(boolean r1);

    void syncAssetsList(String r1, int r2);

    void syncGiftList(int r1);

    void syncGiftPanel();

    void syncMultiAnchorList();

    void triggerGiftAsyncSort(JSONObject r1);

    void updateGiftTrayPosition(f0 r1);
}
