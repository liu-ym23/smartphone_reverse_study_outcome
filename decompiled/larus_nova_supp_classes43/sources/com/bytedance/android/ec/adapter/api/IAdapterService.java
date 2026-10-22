package com.bytedance.android.ec.adapter.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001d\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\tH&J.\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u0004H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0018H&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\n\u0010#\u001a\u0004\u0018\u00010\"H&J\n\u0010%\u001a\u0004\u0018\u00010$H&J\b\u0010&\u001a\u00020\u0013H&J\b\u0010'\u001a\u00020\u0004H&J\b\u0010(\u001a\u00020\u0004H&J\u0011\u0010)\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b)\u0010*J \u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010/\u001a\u00020.H&J0\u00106\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u0013H&J0\u00107\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u0013H&J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0013H&J\n\u0010;\u001a\u0004\u0018\u00010:H&J\b\u0010<\u001a\u00020\u0013H&J\n\u0010=\u001a\u0004\u0018\u00010\tH&J\n\u0010?\u001a\u0004\u0018\u00010>H&J\n\u0010@\u001a\u0004\u0018\u00010\tH&J4\u0010D\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\"\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0Aj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`BH&J\u0018\u0010G\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u0015H&J\"\u0010L\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020\u00132\b\u0010K\u001a\u0004\u0018\u00010JH&J\b\u0010M\u001a\u00020\u0004H&J\u0010\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0001H\u0016J\u0018\u0010Q\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\tH&J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020RH&J\b\u0010U\u001a\u00020\u0004H&J\u001c\u0010X\u001a\u00020\u00042\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040VH&J\u001c\u0010Y\u001a\u00020\u00042\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040VH&J,\u0010]\u001a\u00020\u00042\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\t2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040VH&J\n\u0010_\u001a\u0004\u0018\u00010^H&JN\u0010e\u001a\u0004\u0018\u00010d2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\t2\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`2\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`H&J\\\u0010h\u001a\u00020\u00042\u0006\u0010[\u001a\u00020Z2\b\b\u0002\u0010P\u001a\u00020\t2\b\b\u0002\u0010f\u001a\u00020\t2\b\b\u0002\u0010\\\u001a\u00020\t2\b\b\u0002\u0010g\u001a\u00020\u00132\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010`H&J\u0010\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010iH&J\n\u0010l\u001a\u0004\u0018\u00010kH&J\u0010\u0010o\u001a\u00020\u00042\u0006\u0010n\u001a\u00020mH&J\u0014\u0010p\u001a\u00020\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\tH&J.\u0010z\u001a\u0004\u0018\u00010y2\u0006\u0010r\u001a\u00020q2\u0006\u0010t\u001a\u00020s2\u0006\u0010v\u001a\u00020u2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010wH&J\n\u0010|\u001a\u0004\u0018\u00010{H&J\u0010\u0010}\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\tH&J\u0010\u0010~\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\tH&J\u0010\u0010\u007f\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\tH&J\u001c\u0010\u0083\u0001\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u00020\t2\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001H&J\u000b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\tH&J\n\u0010\u0086\u0001\u001a\u00030\u0085\u0001H&¨\u0006\u0087\u0001"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/IAdapterService;", "", "Lrd/b;", "controllerProvider", "", "injectRoomControllerProvider", "T", "injectRoomControllerProviderV2", "(Ljava/lang/Object;)V", "", "key", "defaultValue", "getLiveSettingsValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getOriginSettingValue", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "withHost", "Landroid/os/Bundle;", "bundle", "handleSchemaWithLive", "", com.bytedance.android.ec.core.event.a.KEY_STATUS, "notifyPushStream", "notifyShowBubble", "count", "notifyMiniApp", "Lcom/bytedance/android/ec/adapter/api/e;", "getFragmentDispatcher", "Lcom/bytedance/android/ec/adapter/api/j;", "getLiveWindowService", "Lcom/bytedance/android/ec/adapter/api/i;", "getUxTracerService", "Lpd/e;", "getIExternaHybridService", "isLiveServiceReady", "muteLiveRoom", "cancelMuteLiveRoom", "hasLivePlayingMute", "()Ljava/lang/Boolean;", "", "factor", "totalHeight", "", BdpAwemeConstant.KEY_ROOM_ID, "onOffsetChanged", com.bytedance.android.ec.core.event.a.VALUE_OPEN, "panelHeight", "openAnimatorDuration", "closeAnimatorDuration", "syncNotify", "notifyPanelEventByLiveList", "notifyPanelEventByLiveCard", "autoUnmute", "setAutoUnmute", "Lcom/bytedance/android/ec/adapter/api/player/IECPlayerViewService;", "getPlayerViewService", "isLiving", "getIfClearModeValueWithClick", "Lcom/bytedance/android/ec/adapter/api/g;", "getLivePerformanceManager", "getIfClearModeValueWithIntroCardShow", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "sendLiveLogger", "isWrite", "noFilterStatus", "preOperateNoFilterStatus", "hasCommodity", "isNoFilterEnable", "Lcom/bytedance/android/ec/adapter/api/b;", "callBack", "notifyCommodityNoFilterStatus", "injectMessage", "injectionStub", "injectMessageOnSaas", "enterFrom", "requestForShoppingAccess", "Lke/a;", "performanceStrategyTask", "registerPerformanceStrategyTask", "unregisterPerformanceStrategyTask", "Lkotlin/Function1;", "callback", "getCurrentAccountPhoneNumber", "isPhoneNumberUsedInDouyin", "Landroid/app/Activity;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "source", "doDouyinAuth", "Lod/a;", "getAuthReport", "Lkotlin/Function0;", "onResultOK", "onResultError", "onExtra", "Landroid/app/Dialog;", "showProtocolConfirmDialog", "enterMethod", "userAgreeAuth", "loginUserAgreeAuth", "Landroidx/lifecycle/MutableLiveData;", "getAppEnterBackgroundOb", "Loe/a;", "getStrategyService", "Lhe/a;", com.bytedance.android.ec.core.event.a.KEY_MSG, "sendMessage", "forceResumePlayer", "Landroid/widget/FrameLayout;", "rootView", "Landroidx/fragment/app/FragmentManager;", "fm", "Lcom/bytedance/android/ec/adapter/api/a;", "floatExtra", "Lcom/bytedance/android/ec/adapter/api/d;", "iFloatLiveWindow", "Landroidx/fragment/app/Fragment;", "showFloatLiveWindow", "Lfe/b;", "getMessageManagerService", "excActionBySetting", "showInteractionMask", "showInteractionAndEnterRoom", "uuid", "Lcom/bytedance/android/ec/adapter/api/h;", "lifecycle", "ecAnnieLifeCallback", "getWebcastAppId", "Lwu1/a;", "getECLiveStateController", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAdapterService {

    public static final class a {
        public static /* synthetic */ boolean a(IAdapterService r1, Context r10, Uri r11, boolean r12, int r13) {
            if ((r13 & 4) == 0) goto L6;
            r12 = false;
        L6:
            if ((r13 & 8) == 0) goto L8;
            Bundle r14 = new Bundle();
        L10:
            return r1.handleSchemaWithLive(r10, r11, r12, r14);
        L8:
            r14 = null;
            goto L10
        }
    }

    void cancelMuteLiveRoom();

    void doDouyinAuth(Activity r1, String r10, Function1<? super Boolean, Unit> r11);

    void ecAnnieLifeCallback(String r1, h r10);

    void excActionBySetting(String r1);

    void forceResumePlayer(String r1);

    MutableLiveData<Boolean> getAppEnterBackgroundOb();

    od.a getAuthReport();

    void getCurrentAccountPhoneNumber(Function1<? super String, Unit> r1);

    wu1.a getECLiveStateController();

    e getFragmentDispatcher();

    pd.e getIExternaHybridService();

    String getIfClearModeValueWithClick();

    String getIfClearModeValueWithIntroCardShow();

    g getLivePerformanceManager();

    <T> T getLiveSettingsValue(String r1, T r10);

    j getLiveWindowService();

    fe.b getMessageManagerService();

    Object getOriginSettingValue(String r1);

    IECPlayerViewService getPlayerViewService();

    oe.a getStrategyService();

    i getUxTracerService();

    String getWebcastAppId();

    boolean handleSchemaWithLive(Context r1, Uri r10, boolean r11, Bundle r12);

    Boolean hasLivePlayingMute();

    void injectMessage();

    void injectMessageOnSaas(Object r1);

    void injectRoomControllerProvider(rd.b r1);

    <T> void injectRoomControllerProviderV2(T r1);

    boolean isLiveServiceReady();

    boolean isLiving();

    void isPhoneNumberUsedInDouyin(Function1<? super Boolean, Unit> r1);

    void loginUserAgreeAuth(Activity r1, String r10, String r11, String r12, boolean r13, Function0<Unit> r14, Function0<Unit> r15);

    void muteLiveRoom();

    void notifyCommodityNoFilterStatus(boolean r1, boolean r10, b r11);

    void notifyMiniApp(int r1);

    void notifyPanelEventByLiveCard(boolean r1, int r10, long r11, long r12, boolean r13);

    void notifyPanelEventByLiveList(boolean r1, int r10, long r11, long r12, boolean r13);

    void notifyPushStream(int r1);

    void notifyShowBubble();

    void onOffsetChanged(float r1, int r10, long r11);

    void preOperateNoFilterStatus(boolean r1, Bundle r10);

    void registerPerformanceStrategyTask(ke.a r1);

    void requestForShoppingAccess(Context r1, String r10);

    void sendLiveLogger(String r1, HashMap<String, String> r10);

    void sendMessage(he.a r1);

    void setAutoUnmute(boolean r1);

    Fragment showFloatLiveWindow(FrameLayout r1, FragmentManager r10, com.bytedance.android.ec.adapter.api.a r11, d r12);

    void showInteractionAndEnterRoom(String r1);

    void showInteractionMask(String r1);

    Dialog showProtocolConfirmDialog(Context r1, String r10, Function0<Unit> r11, Function0<Unit> r12, Function0<Unit> r13);

    void unregisterPerformanceStrategyTask();
}
