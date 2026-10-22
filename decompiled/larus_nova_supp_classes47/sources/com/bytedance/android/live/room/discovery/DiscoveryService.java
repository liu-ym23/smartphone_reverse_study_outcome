package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.text.Spannable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.IDiscoveryService;
import com.bytedance.android.live.room.discovery.drawer.NewLiveDrawerEntranceWidget;
import com.bytedance.android.live.room.discovery.drawer.template.LiveDrawerEntranceCommonWidget;
import com.bytedance.android.live.room.discovery.inspector.OfficialInspectorManager;
import com.bytedance.android.live.room.navi.userinfo_p.widget.ecom.ECLiveLynxRankEntrance;
import com.bytedance.android.live.room.navi.userinfo_p.widget.ecom.ECLiveUserInfoWidget;
import com.bytedance.android.livesdk.config.ua;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.rk;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016JG\u0010#\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2)\u0010\"\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dH\u0016J\"\u0010(\u001a\u00020\u00172\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010)\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u0005H\u0016R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/bytedance/android/live/room/discovery/DiscoveryService;", "Lcom/bytedance/android/live/room/api/IDiscoveryService;", "Lj70/j;", "Lh70/b;", "getDiscoveryDescriptor", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getECDiscoveryWidget", "getECAnchorAvatarWidget", "getDrawerEntranceWidget", "getDrawerEntranceCommonWidget", "getHotSpotWidget", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getNetStatusWidget", "getLiveSceneWidget", "Lj70/n;", "getDrawerEntranceDescriptor", "getLandscapeDrawerEntranceDescriptor", "getNetStatusDescriptor", "", "status", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "onNetworkStatus", "Lcom/bytedance/android/livesdk/message/model/rk;", "roomTopMessage", "Ld90/a;", "liveLayerContext", "Lkotlin/Function1;", "Lj70/h;", "Lkotlin/ParameterName;", "name", "descriptor", "loadElementBlock", "handleRoomTopMsg", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/message/model/kj;", "remindMessage", "handleOfficialInspectorRemindMsg", "getAnchorPerfWidgetClass", "Lcom/bytedance/android/live/room/discovery/p0;", "signalStatusEvent", "Lcom/bytedance/android/live/room/discovery/p0;", "getSignalStatusEvent", "()Lcom/bytedance/android/live/room/discovery/p0;", "Lcom/bytedance/android/live/room/discovery/inspector/OfficialInspectorManager;", "officialInspectorManager", "Lcom/bytedance/android/live/room/discovery/inspector/OfficialInspectorManager;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DiscoveryService implements IDiscoveryService {
    private OfficialInspectorManager officialInspectorManager;
    private final p0 signalStatusEvent;

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.j<? extends h70.b> getDiscoveryDescriptor() {
        return new o0();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.n<? extends h70.b> getDrawerEntranceDescriptor() {
        return new com.bytedance.android.live.room.discovery.drawer.a();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.n<? extends h70.b> getLandscapeDrawerEntranceDescriptor() {
        return new com.bytedance.android.live.room.discovery.drawer.i();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.n<? extends h70.b> getNetStatusDescriptor() {
        if (((Boolean) ua.a.getValue()).booleanValue() == false) goto L6;
        return new b();
    L6:
        return new l0();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Widget getNetStatusWidget() {
        return new NetSpeedMonitorWidget();
    }

    public DiscoveryService() {
        this.signalStatusEvent = new p0();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends Widget> getAnchorPerfWidgetClass() {
        return AnchorPerfMonitorWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getDrawerEntranceCommonWidget() {
        return LiveDrawerEntranceCommonWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getDrawerEntranceWidget() {
        return NewLiveDrawerEntranceWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getECAnchorAvatarWidget() {
        return ECLiveUserInfoWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getECDiscoveryWidget() {
        return ECLiveLynxRankEntrance.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getHotSpotWidget() {
        return LiveHotSpotWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getLiveSceneWidget() {
        return LiveSceneWidget.class;
    }

    public final p0 getSignalStatusEvent() {
        return this.signalStatusEvent;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public void onNetworkStatus(int r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        LayerEventDispatcher r4 = o70.c.a(Integer.valueOf(r3.hashCode()));
        p0 r0 = this.signalStatusEvent;
        r0.a = r2;
        if (r4 == null) goto L6;
        r4.b(r0);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public void handleOfficialInspectorRemindMsg(Context r2, d90.a r3, kj r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "liveLayerContext");
        OfficialInspectorManager.b.getClass();
        OfficialInspectorManager.Companion.a(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public void handleRoomTopMsg(rk r13, d90.a r14, Function1<? super j70.h<d90.a>, Unit> r15) {
        com.bytedance.android.live.room.discovery.inspector.l r4 = null;
        if (this.officialInspectorManager != null) goto L46;
        OfficialInspectorManager.Companion r0 = OfficialInspectorManager.b;
        if (r14 == null) goto L7;
        DataCenter r5 = ((d90.d) r14).h;
    L8:
        r0.getClass();
        if (r5 == null) goto L29;
        if (r14 == null) goto L29;
        if (r15 == null) goto L29;
        if (jr1.b.a(r14) == true) goto L16;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == true) goto L26;
        StringBuilder r16 = new StringBuilder("get OfficialInspectorManager failed: isAnchor is ");
        r16.append(jr1.b.a(r14));
        r16.append(". LiveMode is ");
        LiveMode r17 = d90.c.o(r14);
        if (r17 == null) goto L23;
        String r18 = r17.toString();
    L24:
        r16.append(r18);
        ALogger.e("OfficialInspectorManager", r16.toString());
    L42:
        OfficialInspectorManager r19 = null;
    L43:
        this.officialInspectorManager = r19;
        if (r19 != null) goto L46;
        return;
    L23:
        r18 = null;
        goto L24
    L26:
        if (OfficialInspectorManager.Companion.b() == true) goto L28;
        ALogger.e("OfficialInspectorManager", "get OfficialInspectorManager failed: setting enable is " + OfficialInspectorManager.Companion.b());
        goto L42
    L28:
        r19 = new OfficialInspectorManager();
        r15.invoke(new com.bytedance.android.live.room.discovery.inspector.m());
        r19.a = r5;
        goto L43
    L16:
        if (d90.c.o(r14) != LiveMode.VIDEO) goto L18;
        r1 = true;
    L29:
        StringBuilder r2 = new StringBuilder("dataCenter or liveLayerContext or portrait2ndDelegate or layerManager is null.dataCenter is ");
        if (r5 == null) goto L32;
        String r6 = r5.toString();
    L33:
        r2.append(r6);
        r2.append("liveLayerContext is ");
        if (r14 == null) goto L36;
        String r110 = r14.toString();
    L37:
        r2.append(r110);
        r2.append(".layerManager is ");
        if (r15 == null) goto L40;
        String r111 = r15.toString();
    L41:
        r2.append(r111);
        ALogger.e("OfficialInspectorManager", r2.toString());
        goto L42
    L40:
        r111 = null;
        goto L41
    L36:
        r110 = null;
        goto L37
    L32:
        r6 = null;
        goto L33
    L7:
        r5 = null;
    L46:
        OfficialInspectorManager r112 = this.officialInspectorManager;
        if (r112 == null) goto L70;
        OfficialInspectorManager.b.getClass();
        if (OfficialInspectorManager.Companion.b() == true) goto L51;
        ALogger.e("OfficialInspectorManager", "setting enable is false when tryShowWithMessage");
        return;
    L51:
        if (r13 != null) goto L53;
        ALogger.e("OfficialInspectorManager", "try show with null message");
        return;
    L53:
        Spannable r10 = sb2.a.h(r13.G(), null, false);
        if (r10 == null) goto L64;
        boolean r7 = !Intrinsics.areEqual(r10, sb2.a.a);
        Text r113 = r13.P();
        Text r3 = r13.P();
        if (r3 == null) goto L59;
        String r8 = r3.getDefaultPattern();
    L60:
        Spannable r12 = sb2.a.h(r113, r8, false);
        if (r12 == null) goto L64;
        r4 = new com.bytedance.android.live.room.discovery.inspector.l(r7, r13.E(), r13.H(), r13.getDisplayDuration(), r10, r12);
        goto L64
    L59:
        r8 = null;
    L64:
        if (r4 != null) goto L66;
        ALogger.e("OfficialInspectorManager", "config is null, because of TextPieceHelper's error");
        return;
    L66:
        DataCenter r114 = r112.a;
        if (r114 == null) goto L74;
        r114.put("cmd_official_inspector", new com.bytedance.android.live.room.discovery.inspector.a(0, r4));
        return;
    L74:
        return;
    }
}
