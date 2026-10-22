package com.bytedance.android.ec;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.buynow.IECBuyNowService;
import com.bytedance.android.livesdkapi.drawer.ILiveDrawerCommonFragment;
import com.bytedance.android.livesdkapi.drawer.ILiveDrawerParentAction;
import com.bytedance.android.livesdkapi.linkmic.IECLiveLinkmicService;
import com.bytedance.android.livesdkapi.livereplay.IECLiveReplayService;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ILivePlayFragmentCreatedEnv;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.service.IMiddlewareHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility;
import com.bytedance.android.livesdkapi.service.userinfo.IECUserInfoService;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u001e\u0010'\u001a\u00020\n2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016J\u0018\u0010+\u001a\u00020\n2\u0006\u0010(\u001a\u00020\r2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\u0010H\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020&H\u0016J\b\u00105\u001a\u00020\u0010H\u0016J&\u00106\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010\r2\b\u0010:\u001a\u0004\u0018\u00010\rH\u0016J6\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\r2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0)H\u0016J(\u0010@\u001a\u00020\n2\b\u0010A\u001a\u0004\u0018\u00010$2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\n\u0018\u00010CH\u0016J\"\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020&2\b\u0010G\u001a\u0004\u0018\u00010\rH\u0016J&\u0010H\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010\r2\b\u0010L\u001a\u0004\u0018\u00010-H\u0016J\u001c\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010I\u001a\u00020J2\b\u0010O\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\u0010H\u0016J0\u0010R\u001a\u00020\n2\u0006\u0010I\u001a\u00020J2\b\u0010,\u001a\u0004\u0018\u00010-2\u0014\u0010S\u001a\u0010\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\n\u0018\u00010CH\u0016J,\u0010U\u001a\u00020\n2\u0006\u0010I\u001a\u00020J2\u0006\u0010V\u001a\u00020-2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\n0CH\u0016J\b\u0010W\u001a\u00020\nH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006X"}, d2 = {"Lcom/bytedance/android/ec/SaaSHostCommerceAdaptor;", "Lcom/bytedance/android/livesdkapi/service/IHostCommerceServiceLive;", "()V", "saasHostCommerceService", "Lcom/bytedance/android/livesdkapi/commerce/IHostCommerceServiceLive;", "getSaasHostCommerceService", "()Lcom/bytedance/android/livesdkapi/commerce/IHostCommerceServiceLive;", "saasHostCommerceService$delegate", "Lkotlin/Lazy;", "callInjection", "", "chooseCategory", "names", "", "ids", "enableFullLiveCommerce", "", "getBuyNowService", "Lcom/bytedance/android/livesdkapi/buynow/IECBuyNowService;", "getECLiveLinkmicService", "Lcom/bytedance/android/livesdkapi/linkmic/IECLiveLinkmicService;", "getECLiveReplayService", "Lcom/bytedance/android/livesdkapi/livereplay/IECLiveReplayService;", "getECUserInfoService", "Lcom/bytedance/android/livesdkapi/service/userinfo/IECUserInfoService;", "getLiveBizWindowLayoutAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLayoutAbility;", "getLiveBizWindowLogAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLogAbility;", "getLiveBizWindowWidgetAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowWidgetAbility;", "getLiveDrawerCommonFragment", "Lcom/bytedance/android/livesdkapi/drawer/ILiveDrawerCommonFragment;", "parentAction", "Lcom/bytedance/android/livesdkapi/drawer/ILiveDrawerParentAction;", "getLiveShoppingData", "Lorg/json/JSONObject;", "count", "", "handleWebcastInRoomSchema", "params", "", "", "hookECOMLiveParams", "bundle", "Landroid/os/Bundle;", "initPlayFragmentEnv", "playFragmentCreatedEnv", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ILivePlayFragmentCreatedEnv;", "injectMessage", "isProductDetailPageExpanded", "notifyPromotionNum", "num", "onBackPressed", "onExistLiveSession", a.VALUE_ACTIVITY, "Landroid/app/Activity;", "enterFromMerge", "enterMethod", "roomEnter", BdpAwemeConstant.KEY_ROOM_ID, "anchorId", "ecomLiveParams", "eventParmas", "sendMessage", a.KEY_MSG, "callBack", "Lkotlin/Function1;", "setAddress", "addressId", "addressType", "addressStrategyType", "setEnterRoomInfo", "context", "Landroid/content/Context;", "businessName", "businessArgs", "showLivePromotionListFragment", "Landroidx/fragment/app/Fragment;", "livePromotionListParams", "switchFlashConfig", "isOpen", "tryShowLiveFlashFragment", "callback", "Landroidx/fragment/app/DialogFragment;", "tryShowSaasCouponDialog", "args", "updatePromotionList", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class SaaSHostCommerceAdaptor implements IHostCommerceServiceLive {
    private final Lazy saasHostCommerceService$delegate;

    private final com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive getSaasHostCommerceService() {
        return (com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive) this.saasHostCommerceService$delegate.getValue();
    }

    public boolean enableFullLiveCommerce() {
        return true;
    }

    public IECLiveLinkmicService getECLiveLinkmicService() {
        return null;
    }

    public IECLiveReplayService getECLiveReplayService() {
        return null;
    }

    public IECUserInfoService getECUserInfoService() {
        return null;
    }

    public AbsLiveBizWindowLayoutAbility getLiveBizWindowLayoutAbility() {
        return null;
    }

    public AbsLiveBizWindowLogAbility getLiveBizWindowLogAbility() {
        return null;
    }

    public AbsLiveBizWindowWidgetAbility getLiveBizWindowWidgetAbility() {
        return null;
    }

    public ILiveDrawerCommonFragment getLiveDrawerCommonFragment(ILiveDrawerParentAction r10) {
        Intrinsics.checkNotNullParameter(r10, "parentAction");
        return null;
    }

    public JSONObject getLiveShoppingData(int r1) {
        return null;
    }

    public void hookECOMLiveParams(String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "bundle");
    }

    public boolean initPlayFragmentEnv(ILivePlayFragmentCreatedEnv r1) {
        return false;
    }

    public void injectMessage() {
    }

    public boolean isProductDetailPageExpanded() {
        return false;
    }

    public void notifyPromotionNum(int r1) {
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onExistLiveSession(Activity r1, String r10, String r11) {
    }

    public SaaSHostCommerceAdaptor() {
        k.l(IHostCommerceServiceLive.class, this);
        k.l(IMiddlewareHostCommerceServiceLive.class, this);
        this.saasHostCommerceService$delegate = LazyKt.lazy(SaaSHostCommerceAdaptor$saasHostCommerceService$2.INSTANCE);
    }

    public void callInjection() {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.callInjection();
        return;
    }

    public IECBuyNowService getBuyNowService() {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBuyNowService();
    }

    public void updatePromotionList() {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.updatePromotionList();
        return;
    }

    public void handleWebcastInRoomSchema(Map<String, Object> r10) {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.handleWebcastInRoomSchema(r10);
        return;
    }

    public void switchFlashConfig(boolean r10) {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.switchFlashConfig(r10);
        return;
    }

    public void chooseCategory(String r10, String r11) {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.chooseCategory(r10, r11);
        return;
    }

    public void sendMessage(JSONObject r10, Function1<? super JSONObject, Unit> r11) {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.sendMessage(r10, r11);
        return;
    }

    public Fragment showLivePromotionListFragment(Context r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.showLivePromotionListFragment(r10, r11);
    }

    public void setAddress(String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "addressId");
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.setAddress(r10, r11, r12);
        return;
    }

    public void setEnterRoomInfo(Context r10, String r11, Bundle r12) {
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.setEnterRoomInfo(r10, r11, r12);
        return;
    }

    public void tryShowLiveFlashFragment(Context r10, Bundle r11, Function1<? super DialogFragment, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L5;
        DialogFragment r13 = r0.showLiveFlashFragment(r10, r11);
    L6:
        if (r13 == null) goto L10;
        if (r12 == null) goto L11;
        Unit r14 = (Unit) r12.invoke(r13);
        return;
    L11:
        return;
    L10:
        return;
    L5:
        r13 = null;
        goto L6
    }

    public void tryShowSaasCouponDialog(Context r10, Bundle r11, Function1<? super JSONObject, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "args");
        Intrinsics.checkNotNullParameter(r12, "callBack");
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.tryShowSaasCouponDialog(r10, r11, r12);
        return;
    }

    public void roomEnter(String r10, String r11, String r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r11, "anchorId");
        Intrinsics.checkNotNullParameter(r13, "eventParmas");
        com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive r0 = getSaasHostCommerceService();
        if (r0 == null) goto L6;
        r0.roomEnter(r10, r11, r12, r13);
        return;
    }
}
