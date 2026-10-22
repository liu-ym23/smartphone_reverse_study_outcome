package com.bytedance.android.live.room.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.rk;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.a;
import h70.b;
import j70.h;
import j70.j;
import j70.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.discovery.DiscoveryService")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H&J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H&J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H&J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H&J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H&J\b\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH&J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH&J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH&J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&JG\u0010#\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2)\u0010\"\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dH&J\"\u0010(\u001a\u00020\u00172\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&H&J\u0012\u0010)\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u0005H&¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/room/api/IDiscoveryService;", "Lcom/bytedance/android/live/base/IService;", "Lj70/j;", "Lh70/b;", "getDiscoveryDescriptor", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getECDiscoveryWidget", "getECAnchorAvatarWidget", "getDrawerEntranceWidget", "getDrawerEntranceCommonWidget", "getHotSpotWidget", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getNetStatusWidget", "getLiveSceneWidget", "Lj70/n;", "getDrawerEntranceDescriptor", "getLandscapeDrawerEntranceDescriptor", "getNetStatusDescriptor", "", "status", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "onNetworkStatus", "Lcom/bytedance/android/livesdk/message/model/rk;", "roomTopMessage", "Ld90/a;", "liveLayerContext", "Lkotlin/Function1;", "Lj70/h;", "Lkotlin/ParameterName;", "name", "descriptor", "loadElementBlock", "handleRoomTopMsg", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/message/model/kj;", "remindMessage", "handleOfficialInspectorRemindMsg", "getAnchorPerfWidgetClass", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDiscoveryService extends IService {
    Class<? extends Widget> getAnchorPerfWidgetClass();

    j<? extends b> getDiscoveryDescriptor();

    Class<? extends LiveRecyclableWidget> getDrawerEntranceCommonWidget();

    n<? extends b> getDrawerEntranceDescriptor();

    Class<? extends LiveRecyclableWidget> getDrawerEntranceWidget();

    Class<? extends LiveRecyclableWidget> getECAnchorAvatarWidget();

    Class<? extends LiveRecyclableWidget> getECDiscoveryWidget();

    Class<? extends LiveRecyclableWidget> getHotSpotWidget();

    n<? extends b> getLandscapeDrawerEntranceDescriptor();

    Class<? extends LiveRecyclableWidget> getLiveSceneWidget();

    n<? extends b> getNetStatusDescriptor();

    Widget getNetStatusWidget();

    void handleOfficialInspectorRemindMsg(Context r1, a r2, kj r3);

    void handleRoomTopMsg(rk r1, a r2, Function1<? super h<a>, Unit> r3);

    void onNetworkStatus(int r1, DataCenter r2);
}
