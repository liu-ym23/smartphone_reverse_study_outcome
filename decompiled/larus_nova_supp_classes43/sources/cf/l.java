package cf;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface l {
    void Aa(int r1, String r10);

    boolean Ba(ECPromotionCampaign r1, long r10);

    void Ca(String r1, com.bytedance.android.ec.model.live.r r10);

    com.bytedance.android.livesdk.livecommerce.promotion.card.b Da(ViewGroup r1, com.bytedance.android.livesdk.livecommerce.promotion.card.g r10, boolean r11);

    boolean Ea();

    void Fa(boolean r1, Fragment r10, LiveClearScreenMode r11, LiveScreenMoveMode r12);

    d Ga(Context r1, com.bytedance.android.shopping.store.home.presenter.preview.c r10, LiveRoomParams r11, com.bytedance.android.shopping.store.home.presenter.preview.d r12, im.m r13);

    ECUIPromotion Ha(ECPromotion r1, Context r10, long r11, Boolean r12);

    View Ia();

    hf.a Ja();

    void Ka(String r1, com.bytedance.android.ec.model.live.r r10);

    void La();

    void Ma();

    boolean Na();

    void Oa(boolean r1);

    float[] Pa();

    void Qa(String r1);

    void a(FragmentActivity r1, String r10, Window r11);

    void b(FragmentActivity r1, String r10, Window r11);

    void c();

    void d();

    void f(FragmentActivity r1, String r10, Window r11);

    w getRoomInfo();

    void showInteractionAndEnterRoom(String r1);

    void showInteractionMask(String r1);

    void startShowFloatInNextLifecycle(Activity r1, String r10);

    void ya();

    boolean za();
}
