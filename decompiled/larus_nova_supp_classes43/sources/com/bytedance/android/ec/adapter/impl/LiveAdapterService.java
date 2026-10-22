package com.bytedance.android.ec.adapter.impl;

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
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.adapter.impl.adapters.UxTracerAdapter;
import com.bytedance.android.ec.adapter.impl.adapters.VideoFloatWindowAdapter;
import com.bytedance.android.ec.adapter.impl.adapters.browser.ExternalHybridServiceAdapter;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.live.api.commerce.LiveECCommerce;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.LiveVolume;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.AppLifeCycleMonitor;
import com.bytedance.android.livesdkapi.LiveSaaSInternalService;
import com.bytedance.android.livesdkapi.TTInternalBusinessService;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.auth.IAuthDialogCallback;
import com.bytedance.android.livesdkapi.auth.IAuthDialogSourceProvider;
import com.bytedance.android.livesdkapi.auth.IAuthGuideService;
import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.android.livesdkapi.auth.INewAuthReport;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.service.IInternalBusinessService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.ISaaSInternalService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016J*\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\u0015H\u0016J\n\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\u0002H\u0016J\n\u0010.\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020\u0015H\u0016J\n\u00100\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u000bH\u0016J4\u00105\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\"\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b02j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`3H\u0016J\u0018\u00108\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0017H\u0016J\"\u0010=\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\b\u0010>\u001a\u00020\u0002H\u0016J\u0010\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\nH\u0016J\u0018\u0010B\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u000bH\u0016J\u0010\u0010E\u001a\u00020\u00022\u0006\u0010D\u001a\u00020CH\u0016J\b\u0010F\u001a\u00020\u0002H\u0016J\u001c\u0010I\u001a\u00020\u00022\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020GH\u0016J\u001c\u0010J\u001a\u00020\u00022\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020GH\u0016J,\u0010N\u001a\u00020\u00022\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u000b2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020GH\u0016J\n\u0010P\u001a\u0004\u0018\u00010OH\u0016JJ\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u000b2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010Q2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010Q2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010QH\u0016JP\u0010Y\u001a\u00020\u00022\u0006\u0010L\u001a\u00020K2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u00152\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010Q2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010QH\u0016J\u0010\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010ZH\u0016J\n\u0010]\u001a\u0004\u0018\u00010\\H\u0016J\u0010\u0010`\u001a\u00020\u00022\u0006\u0010_\u001a\u00020^H\u0016J \u0010f\u001a\u00020\u00022\u0006\u0010b\u001a\u00020a2\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010e\u001a\u00020dH\u0016J0\u0010l\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u00152\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010i\u001a\u00020d2\u0006\u0010j\u001a\u00020d2\u0006\u0010k\u001a\u00020\u0015H\u0016J0\u0010m\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u00152\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010i\u001a\u00020d2\u0006\u0010j\u001a\u00020d2\u0006\u0010k\u001a\u00020\u0015H\u0016J\u0010\u0010o\u001a\u00020\u00022\u0006\u0010n\u001a\u00020\u0015H\u0016J\u0011\u0010p\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\bp\u0010qJ\u0012\u0010r\u001a\u00020\u00022\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010t\u001a\u0004\u0018\u00010sH\u0016J,\u0010~\u001a\u0004\u0018\u00010}2\u0006\u0010v\u001a\u00020u2\u0006\u0010x\u001a\u00020w2\u0006\u0010z\u001a\u00020y2\b\u0010|\u001a\u0004\u0018\u00010{H\u0016J\u0010\u0010\u007f\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\u000bH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\u000bH\u0016J\u0011\u0010\u0081\u0001\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\u000bH\u0016J\u001c\u0010\u0085\u0001\u001a\u00020\u00022\u0007\u0010\u0082\u0001\u001a\u00020\u000b2\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0016J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0088\u0001\u001a\u00030\u0087\u0001H\u0016¨\u0006\u008b\u0001"}, d2 = {"Lcom/bytedance/android/ec/adapter/impl/LiveAdapterService;", "Lcom/bytedance/android/ec/adapter/api/IAdapterService;", "", "ensureNewAuthGuideManagerInitialized", "Lrd/b;", "controllerProvider", "injectRoomControllerProvider", "T", "injectRoomControllerProviderV2", "(Ljava/lang/Object;)V", "", "", "key", "defaultValue", "getLiveSettingsValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getOriginSettingValue", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "withHost", "Landroid/os/Bundle;", "bundle", "handleSchemaWithLive", "", com.bytedance.android.ec.core.event.a.KEY_STATUS, "notifyPushStream", "notifyShowBubble", "count", "notifyMiniApp", "Lcom/bytedance/android/ec/adapter/api/e;", "getFragmentDispatcher", "Lcom/bytedance/android/ec/adapter/api/j;", "getLiveWindowService", "Lcom/bytedance/android/ec/adapter/api/i;", "getUxTracerService", "Lpd/e;", "getIExternaHybridService", "isLiveServiceReady", "Lcom/bytedance/android/ec/adapter/api/g;", "getLivePerformanceManager", "muteLiveRoom", "cancelMuteLiveRoom", "Lcom/bytedance/android/ec/adapter/api/player/IECPlayerViewService;", "getPlayerViewService", "isLiving", "getIfClearModeValueWithClick", "getIfClearModeValueWithIntroCardShow", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "sendLiveLogger", "isWrite", "noFilterStatus", "preOperateNoFilterStatus", "hasCommodity", "isNoFilterEnable", "Lcom/bytedance/android/ec/adapter/api/b;", "callBack", "notifyCommodityNoFilterStatus", "injectMessage", "injectionStub", "injectMessageOnSaas", "enterFrom", "requestForShoppingAccess", "Lke/a;", "performanceStrategyTask", "registerPerformanceStrategyTask", "unregisterPerformanceStrategyTask", "Lkotlin/Function1;", "callback", "getCurrentAccountPhoneNumber", "isPhoneNumberUsedInDouyin", "Landroid/app/Activity;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "source", "doDouyinAuth", "Lod/a;", "getAuthReport", "Lkotlin/Function0;", "onResultOK", "onResultError", "onExtra", "Landroid/app/Dialog;", "showProtocolConfirmDialog", "enterMethod", "userAgreeAuth", "loginUserAgreeAuth", "Landroidx/lifecycle/MutableLiveData;", "getAppEnterBackgroundOb", "Loe/a;", "getStrategyService", "Lhe/a;", com.bytedance.android.ec.core.event.a.KEY_MSG, "sendMessage", "", "factor", "totalHeight", "", BdpAwemeConstant.KEY_ROOM_ID, "onOffsetChanged", com.bytedance.android.ec.core.event.a.VALUE_OPEN, "panelHeight", "openAnimatorDuration", "closeAnimatorDuration", "syncNotify", "notifyPanelEventByLiveList", "notifyPanelEventByLiveCard", "autoUnmute", "setAutoUnmute", "hasLivePlayingMute", "()Ljava/lang/Boolean;", "forceResumePlayer", "Lfe/b;", "getMessageManagerService", "Landroid/widget/FrameLayout;", "rootView", "Landroidx/fragment/app/FragmentManager;", "fm", "Lcom/bytedance/android/ec/adapter/api/a;", "floatExtra", "Lcom/bytedance/android/ec/adapter/api/d;", "floatLiveWindow", "Landroidx/fragment/app/Fragment;", "showFloatLiveWindow", "excActionBySetting", "showInteractionMask", "showInteractionAndEnterRoom", "uuid", "Lcom/bytedance/android/ec/adapter/api/h;", "lifecycle", "ecAnnieLifeCallback", "getWebcastAppId", "Lwu1/a;", "getECLiveStateController", "<init>", "()V", "ec-adapter-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAdapterService implements IAdapterService {

    public static final class a implements TokenRefreshCallback {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r10) {
            this.a.invoke(Boolean.FALSE);
        }

        public final void onSuccess(TokenInfo r10) {
            this.a.invoke(Boolean.TRUE);
        }
    }

    public static final class b implements od.a {
        public final /* synthetic */ INewAuthReport a;

        @Override // od.a
        public final void a() {
            this.a.setOnClickLogin(true);
        }

        public b(INewAuthReport r1) {
            this.a = r1;
        }

        @Override // od.a
        public final void c(boolean r10) {
            Intrinsics.checkNotNullParameter("coupon_popup", "source");
            this.a.logAuthDialogShow(r10, "coupon_popup");
        }

        @Override // od.a
        public final void b(boolean r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "buttonType");
            Intrinsics.checkNotNullParameter("coupon_popup", "source");
            this.a.logAuthDialogClick(r10, r11, "coupon_popup");
        }
    }

    public static final class c<T> implements sy.a {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void invoke(Object r10) {
            Function1 r0 = this.a;
            r0.invoke((String) r10);
        }
    }

    public static final class d implements wu1.a {
        public d() {
        }

        public final void a(Scene r10) {
            Intrinsics.checkNotNullParameter(r10, "scene");
        }

        public final void b(FloatWindowState r10) {
            Intrinsics.checkNotNullParameter(r10, "state");
        }

        public final Pair c() {
            return TuplesKt.to(null, "");
        }

        public final void d(LiveVolume r10) {
            Intrinsics.checkNotNullParameter(r10, "volume");
        }

        public final void e() {
        }
    }

    public static final class e<T> implements sy.a {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final void invoke(Object r10) {
            Function1 r0 = this.a;
            r0.invoke((Boolean) r10);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public f(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            IBaseUser r10 = (IBaseUser) r1;
            Function0 r11 = this.a;
            if (r11 == null) goto L6;
            Unit r12 = (Unit) r11.invoke();
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public g(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
            Function0 r11 = this.a;
            if (r11 == null) goto L6;
            Unit r12 = (Unit) r11.invoke();
            return;
        }
    }

    public static final class h implements IAuthDialogCallback {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Function0 c;

        public final void onCancel() {
            Function0 r0 = this.b;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }

        public final void onConfirm() {
            Function0 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }

        public final void onExtraButtonClicked(String r10) {
            Intrinsics.checkNotNullParameter(r10, "buttonTag");
            Function0 r11 = this.c;
            if (r11 == null) goto L6;
            Unit r12 = (Unit) r11.invoke();
            return;
        }

        public h(Function0 r1, Function0 r10, Function0 r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public static final class i implements IAuthDialogSourceProvider {
        public final /* synthetic */ String a;

        public final String source() {
            return this.a;
        }

        public i(String r1) {
            this.a = r1;
        }
    }

    public LiveAdapterService() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void cancelMuteLiveRoom() {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void ecAnnieLifeCallback(String r10, com.bytedance.android.ec.adapter.api.h r11) {
        Intrinsics.checkNotNullParameter(r10, "uuid");
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void excActionBySetting(String r10) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_ROOM_ID);
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void forceResumePlayer(String r1) {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public String getIfClearModeValueWithClick() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public String getIfClearModeValueWithIntroCardShow() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public com.bytedance.android.ec.adapter.api.g getLivePerformanceManager() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public fe.b getMessageManagerService() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public Object getOriginSettingValue(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public oe.a getStrategyService() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public Boolean hasLivePlayingMute() {
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void injectMessage() {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void muteLiveRoom() {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void notifyCommodityNoFilterStatus(boolean r1, boolean r10, com.bytedance.android.ec.adapter.api.b r11) {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void notifyMiniApp(int r1) {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void notifyPanelEventByLiveCard(boolean r1, int r10, long r11, long r12, boolean r13) {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void notifyShowBubble() {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void onOffsetChanged(float r1, int r10, long r11) {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void preOperateNoFilterStatus(boolean r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "noFilterStatus");
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void registerPerformanceStrategyTask(ke.a r10) {
        Intrinsics.checkNotNullParameter(r10, "performanceStrategyTask");
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void requestForShoppingAccess(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void sendLiveLogger(String r10, HashMap<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "map");
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void sendMessage(he.a r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void setAutoUnmute(boolean r1) {
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public Fragment showFloatLiveWindow(FrameLayout r1, FragmentManager r10, com.bytedance.android.ec.adapter.api.a r11, com.bytedance.android.ec.adapter.api.d r12) {
        Intrinsics.checkNotNullParameter(r1, "rootView");
        Intrinsics.checkNotNullParameter(r10, "fm");
        Intrinsics.checkNotNullParameter(r11, "floatExtra");
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void showInteractionAndEnterRoom(String r10) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_ROOM_ID);
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void showInteractionMask(String r10) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_ROOM_ID);
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void unregisterPerformanceStrategyTask() {
    }

    private final void ensureNewAuthGuideManagerInitialized() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Class r1 = INVOKESTATIC_com_bytedance_android_ec_adapter_impl_LiveAdapterService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService");     // Catch: Throwable -> L7
        Object r10 = k.class.getMethod("f", new Class[]{Class.class}).invoke(null, new Object[]{r1});     // Catch: Throwable -> L7
        if (r10 != null) goto L5;
        return;
    L5:
        Result.constructor-impl(r1.getMethod("ensureNewAuthGuideManagerInitialized", new Class[0]).invoke(r10, new Object[0]));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public MutableLiveData<Boolean> getAppEnterBackgroundOb() {
        return AppLifeCycleMonitor.INSTANCE.getAppEnterBackgroundOb();
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public od.a getAuthReport() {
        IAuthGuideService r0 = k.f(IAuthGuideService.class);
        if (r0 == null) goto L9;
        INewAuthReport r1 = r0.report();
        if (r1 != null) goto L8;
        return null;
    L8:
        return new b(r1);
    L9:
        return null;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public wu1.a getECLiveStateController() {
        return new d();
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public IECPlayerViewService getPlayerViewService() {
        return new com.bytedance.android.ec.adapter.impl.adapters.reverse.player.c();
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public String getWebcastAppId() {
        IMiddleWareHostContext r0 = k.f(IMiddleWareHostContext.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return String.valueOf(r0.appId());
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public boolean isLiveServiceReady() {
        if (TTInternalBusinessService.Companion.getBusinessService() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public com.bytedance.android.ec.adapter.api.e getFragmentDispatcher() {
        if (ECSettingKeys.R() != 1) goto L6;
        return com.bytedance.android.ec.adapter.impl.adapters.c.b;
    L6:
        return com.bytedance.android.ec.adapter.impl.adapters.a.a;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public j getLiveWindowService() {
        if (ECSettingKeys.R() != 1) goto L6;
        return VideoFloatWindowAdapter.d;
    L6:
        return com.bytedance.android.ec.adapter.impl.adapters.b.a;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public boolean isLiving() {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L7;
        ILiveRoomService r1 = r0.roomService();
        if (r1 == null) goto L7;
        Room r10 = r1.getCurrentRoom();
    L8:
        if (r10 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r10 = null;
        goto L8
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public pd.e getIExternaHybridService() {
        return ExternalHybridServiceAdapter.INSTANCE;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public com.bytedance.android.ec.adapter.api.i getUxTracerService() {
        return UxTracerAdapter.b;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_ec_adapter_impl_LiveAdapterService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r11 = access$000(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class r12 = access$000(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void getCurrentAccountPhoneNumber(Function1<? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        ISaaSInternalService r0 = LiveSaaSInternalService.getSaaSInternalService();
        if (r0 == null) goto L7;
        IAuthRoutine r1 = r0.authRoutine();
        if (r1 == null) goto L7;
        r1.getCurrentAccountPhoneNumber(new c(r10));
        return;
    L7:
        Unit r11 = (Unit) r10.invoke("");
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void injectMessageOnSaas(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "injectionStub");
        if ((r10 instanceof IExternalMessageInject) == true) goto L5;
        r10 = null;
    L5:
        IExternalMessageInject r11 = (IExternalMessageInject) r10;
        if (r11 == null) goto L9;
        HashMap r0 = new HashMap();
        r0.put("WebcastLiveShoppingMessage", ve.a.class);
        r0.put("WebcastLiveEcomGeneralMessage", com.bytedance.android.ec.adapter.impl.messagev2.a.class);
        r11.injectAllMessageClz(r0);
        r11.injectMessageDecoder(jd.a.a);
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void injectRoomControllerProvider(rd.b r10) {
        Intrinsics.checkNotNullParameter(r10, "controllerProvider");
        IInternalBusinessService r0 = TTInternalBusinessService.Companion.getBusinessService();
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.injectRoomControllerProvider(com.bytedance.android.ec.adapter.impl.converter.c.g.c.a(r10));
    L13:
        Object r11 = INVOKESTATIC_com_bytedance_android_ec_adapter_impl_LiveAdapterService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.livesdk.livecommerce.room.service.CommerceServiceDelegate").getConstructor(new Class[]{tk.b.class}).newInstance(new Object[]{LiveECCommerce.getCommerceInstanceWithReflect()});     // Catch: Exception -> L10
        if (r11 == null) goto L9;
        k.l(IHostCommerceServiceLive.class, new CommerceServiceAdapterDelegate((com.bytedance.android.ec.adapter.api.f) r11));     // Catch: Exception -> L10
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.adapter.api.IHostCommerceServiceAdapter");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.toString();
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public <T> void injectRoomControllerProviderV2(T r10) {
        IInternalBusinessService r0 = TTInternalBusinessService.Companion.getBusinessService();
        if (r0 == null) goto L16;
        if (r10 == null) goto L7;
        r0.injectRoomControllerProvider((ILiveRoomControllerProvider) r10);
        goto L16
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider");
    L16:
        T r11 = INVOKESTATIC_com_bytedance_android_ec_adapter_impl_LiveAdapterService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.livesdk.livecommerce.room.service.CommerceServiceDelegate").getConstructor(new Class[]{tk.b.class}).newInstance(new Object[]{LiveECCommerce.getCommerceInstanceWithReflect()});     // Catch: Exception -> L13
        if (r11 == null) goto L12;
        k.l(IHostCommerceServiceLive.class, new CommerceServiceAdapterDelegate((com.bytedance.android.ec.adapter.api.f) r11));     // Catch: Exception -> L13
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.adapter.api.IHostCommerceServiceAdapter");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.toString();
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void isPhoneNumberUsedInDouyin(Function1<? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        ISaaSInternalService r0 = LiveSaaSInternalService.getSaaSInternalService();
        if (r0 == null) goto L8;
        IAuthRoutine r1 = r0.authRoutine();
        if (r1 == null) goto L9;
        r1.isPhoneNumberUsedInDouyin(new e(r10));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void notifyPushStream(int r10) {
        IInternalBusinessService r0 = TTInternalBusinessService.Companion.getBusinessService();
        if (r0 == null) goto L6;
        r0.asyncCommerceGoodsPageStatus(r10);
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public <T> T getLiveSettingsValue(final String r10, final T r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        int r0 = sg.a.a;
        return (T) sg.a.a(r10, r11, new AnonymousClass1(r10, r11));
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void doDouyinAuth(Activity r10, String r11, Function1<? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "callback");
        ISaaSInternalService r0 = LiveSaaSInternalService.getSaaSInternalService();
        if (r0 == null) goto L8;
        IAuthRoutine r1 = r0.authRoutine();
        if (r1 == null) goto L9;
        r1.doDouyinAuth(r10, new a(r12), r11);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public boolean handleSchemaWithLive(Context r1, Uri r10, boolean r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        IInternalBusinessService r13 = TTInternalBusinessService.Companion.getBusinessService();
        if (r13 == null) goto L5;
        r13.handleSchema(r1, r10);
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void notifyPanelEventByLiveList(boolean r10, int r11, long r12, long r13, boolean r14) {
        int r0 = com.bytedance.android.ec.adapter.impl.a.a;
        LivePanelType r1 = LivePanelType.SHOPPING_CAT;
        Intrinsics.checkNotNullParameter(r1, "panelType");
        ds0.b r15 = new ds0.b();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r15.a = r1;
        if (r10 == false) goto L5;
        String r16 = com.bytedance.android.ec.core.event.a.VALUE_OPEN;
    L6:
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.b = r16;
        r15.c = r11;
        r15.f = r12;
        r15.g = r13;
        r15.h = r14;
        com.bytedance.android.live.platformplayer.service.b r17 = k.f(com.bytedance.android.live.platformplayer.service.b.class);
        if (r17 == null) goto L10;
        r17.w1(r15);
        return;
    L10:
        return;
    L5:
        r16 = com.bytedance.android.ec.core.event.a.VALUE_CLOSE;
        goto L6
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public Dialog showProtocolConfirmDialog(Context r10, String r11, Function0<Unit> r12, Function0<Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "source");
        ensureNewAuthGuideManagerInitialized();
        IAuthGuideService r0 = k.f(IAuthGuideService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.showProtocolConfirmDialog(r10, new h(r12, r13, r14), new i(r11));
    }

    @Override // com.bytedance.android.ec.adapter.api.IAdapterService
    public void loginUserAgreeAuth(Activity r10, String r11, String r12, String r13, boolean r14, Function0<Unit> r15, Function0<Unit> r16) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        Intrinsics.checkNotNullParameter(r13, "source");
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L11;
        l.a r17 = new l.a();
        r17.e = r11;
        r17.g = r12;
        r17.i = r14;
        r17.d = r13;
        Observable r18 = r1.login(r10, new l(r17));
        if (r18 == null) goto L12;
        r18.subscribe(new f(r15), new g(r16));
        return;
    L12:
        return;
    L11:
        return;
    }
}
