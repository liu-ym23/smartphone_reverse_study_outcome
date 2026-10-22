package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.browser.jsbridge.newmethods.d2;
import com.bytedance.android.live.browser.jsbridge.newmethods.e2;
import com.bytedance.android.live.browser.jsbridge.newmethods.u4;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface v {
    com.bytedance.android.live.browser.jsbridge.i.d a(String r1, JSBridgeManager r2);

    Observable b(a0 r1);

    IJsBridgeManager c(ILiveHybridContainer r1, kl0.c r2);

    IJsBridgeManager createJsBridgeManager(Activity r1, com.bytedance.ies.web.jsbridge2.b r2, int r3);

    d2 d(HybridDialog r1);

    e2 e(HybridDialog r1);

    Collection<BaseJsBridgeMethodFactory> getFactoryCollection();

    List<String> getSafeHostList();

    w30.a getStorageProcessor(Context r1);

    void initPermissionCheck();

    void initTTLiveSdkJsb();

    <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass();

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideClipMethod(View r1);

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r1, RegisterPolicy r2);

    Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideDefaultStatelessMethods(com.bytedance.ies.web.jsbridge2.d0 r1, RegisterPolicy r2);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r1);

    u4 provideGetLiveNtpTimeMethod(DataCenter r1);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r1);

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r1);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r1);

    Map<String, y6.b<? extends com.bytedance.ies.web.jsbridge2.f<?, ?>>> provideStateFulFragmentMethods(Fragment r1);

    void registerDataShare();

    Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r1);

    Observable<SubscriberJsEvent> registerJsEventSubscriber(String r1);

    void registerMatchShareMethods();

    void registerState();

    void registerXBridgeMethods(y6.c r1, String r2);

    <T> void sendEventToAllJsBridges(String r1, T r2);
}
