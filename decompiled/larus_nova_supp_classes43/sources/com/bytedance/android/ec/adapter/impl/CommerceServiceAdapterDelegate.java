package com.bytedance.android.ec.adapter.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.adapter.api.f;
import com.bytedance.android.livesdkapi.buynow.IECBuyNowService;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.commerce.param.ICommerceBehaviorLoadHandler;
import com.bytedance.android.livesdkapi.commerce.param.ICommerceLiveRoomProvider;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ILivePlayFragmentCreatedEnv;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J6\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012H\u0016J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010#\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0016J*\u0010*\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016J(\u0010/\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010\u001b2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0002\u0018\u00010-H\u0016J,\u00101\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u00172\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00020-H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0016J\u001e\u00106\u001a\u00020\u00022\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000204\u0018\u00010\u0012H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0016J\n\u0010<\u001a\u0004\u0018\u00010;H\u0016J \u0010A\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010\u0007J$\u0010D\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010B\u001a\u0004\u0018\u00010\u00072\b\u0010C\u001a\u0004\u0018\u00010\u0017R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/bytedance/android/ec/adapter/impl/CommerceServiceAdapterDelegate;", "Lcom/bytedance/android/livesdkapi/commerce/IHostCommerceServiceLive;", "", "updatePromotionList", "", "isOpen", "switchFlashConfig", "", "names", "ids", "chooseCategory", "callInjection", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ILivePlayFragmentCreatedEnv;", "playFragmentCreatedEnv", "initPlayFragmentEnv", BdpAwemeConstant.KEY_ROOM_ID, "anchorId", "ecomLiveParams", "", "eventParmas", "roomEnter", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "Landroidx/fragment/app/DialogFragment;", "showLiveFlashFragment", "Lorg/json/JSONObject;", "livePromotionListParams", "Landroidx/fragment/app/Fragment;", "showLivePromotionListFragment", "Lcom/bytedance/android/livesdkapi/commerce/param/ICommerceBehaviorLoadHandler;", "p0", "Landroidx/lifecycle/ViewModel;", "p1", "onToolbarCommerceBehaviorLoad", "Landroid/app/Activity;", "isBroadcast", "shouldBlockEndSession", "p2", "Lcom/bytedance/android/livesdkapi/commerce/param/ICommerceLiveRoomProvider;", "p3", "onEnterCommerceLiveRoomSuccess", "onWebViewDismiss", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lkotlin/Function1;", "callBack", "sendMessage", "args", "tryShowSaasCouponDialog", "satisfyFreqControl", "showEnterRoomTicketExpandDialog", "", "params", "handleWebcastInRoomSchema", "getEcomSdkVersion", "Ljava/lang/Runnable;", "afterInterceptRunnable", "showExitRoomTicketExpandDialog", "Lcom/bytedance/android/livesdkapi/buynow/IECBuyNowService;", "getBuyNowService", "addressId", "", "addressType", "addressStrategyType", "setAddress", "businessName", "businessArgs", "setEnterRoomInfo", "Lcom/bytedance/android/ec/adapter/api/f;", "realServiceLive", "Lcom/bytedance/android/ec/adapter/api/f;", "<init>", "(Lcom/bytedance/android/ec/adapter/api/f;)V", "ec-adapter-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceServiceAdapterDelegate implements IHostCommerceServiceLive {
    private final f realServiceLive;

    public IECBuyNowService getBuyNowService() {
        return null;
    }

    public boolean initPlayFragmentEnv(ILivePlayFragmentCreatedEnv r1) {
        return false;
    }

    public void onEnterCommerceLiveRoomSuccess(Fragment r1, String r10, String r11, ICommerceLiveRoomProvider r12) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        Intrinsics.checkNotNullParameter(r11, "p2");
    }

    public void onToolbarCommerceBehaviorLoad(ICommerceBehaviorLoadHandler r1, ViewModel r10) {
    }

    public void onWebViewDismiss() {
    }

    public final void setAddress(String r1, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "addressId");
    }

    public final void setEnterRoomInfo(Context r1, String r10, Bundle r11) {
    }

    public boolean shouldBlockEndSession(Activity r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return false;
    }

    public void callInjection() {
        this.realServiceLive.callInjection();
    }

    public void updatePromotionList() {
        this.realServiceLive.updatePromotionList();
    }

    public String getEcomSdkVersion() {
        return String.valueOf(44700);
    }

    public CommerceServiceAdapterDelegate(f r10) {
        Intrinsics.checkNotNullParameter(r10, "realServiceLive");
        this.realServiceLive = r10;
    }

    public void handleWebcastInRoomSchema(Map<String, Object> r10) {
        this.realServiceLive.handleWebcastInRoomSchema(r10);
    }

    public boolean showEnterRoomTicketExpandDialog(boolean r10) {
        return this.realServiceLive.showEnterRoomTicketExpandDialog(r10);
    }

    public void switchFlashConfig(boolean r10) {
        this.realServiceLive.switchFlashConfig(r10);
    }

    public void chooseCategory(String r10, String r11) {
        this.realServiceLive.chooseCategory(r10, r11);
    }

    public void sendMessage(JSONObject r10, Function1<? super JSONObject, Unit> r11) {
        this.realServiceLive.sendMessage(r10, r11);
    }

    public boolean showExitRoomTicketExpandDialog(boolean r10, Runnable r11) {
        Intrinsics.checkNotNullParameter(r11, "afterInterceptRunnable");
        return this.realServiceLive.showExitRoomTicketExpandDialog(r10, r11);
    }

    public DialogFragment showLiveFlashFragment(Context r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return this.realServiceLive.showLiveFlashFragment(r10, r11);
    }

    public Fragment showLivePromotionListFragment(Context r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return this.realServiceLive.showLivePromotionListFragment(r10, r11);
    }

    public void tryShowSaasCouponDialog(Context r10, Bundle r11, Function1<? super JSONObject, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "args");
        Intrinsics.checkNotNullParameter(r12, "callBack");
        this.realServiceLive.tryShowSaasCouponDialog(r10, r11, r12);
    }

    public void roomEnter(String r10, String r11, String r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r11, "anchorId");
        Intrinsics.checkNotNullParameter(r13, "eventParmas");
        this.realServiceLive.roomEnter(r10, r11, r12, r13);
    }
}
