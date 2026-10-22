package com.bytedance.android.live.revlink.impl.multianchor.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.a2;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.r5;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u0002:\u0001zB/\u0012\b\u0010`\u001a\u0004\u0018\u00010_\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010f\u001a\u00020e\u0012\b\b\u0002\u0010i\u001a\u00020h¢\u0006\u0004\bw\u0010xJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\t\u0010\"\u001a\u00020\u0003H\u0096\u0001J%\u0010(\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u001fH\u0096\u0001J\u0019\u0010+\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001dH\u0096\u0001J\u0019\u0010.\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020,H\u0096\u0001J\u0019\u0010/\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020,H\u0096\u0001J\u001b\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0001J\u001b\u0010\u001c\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0001J\u0013\u00100\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\u0019\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u0002012\u0006\u0010*\u001a\u00020\u001dH\u0096\u0001J\u0015\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,04H\u0096\u0001R1\u0010=\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u000607j\u0002`8\u0012\u0004\u0012\u00020104068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R!\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR!\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010AR!\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001f0>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010:\u001a\u0004\bG\u0010AR-\u0010L\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,0I0>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010:\u001a\u0004\bK\u0010AR1\u0010P\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u001fj\u0002`M\u0012\u0004\u0012\u00020\u001d04068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010:\u001a\u0004\bO\u0010<R!\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001f0>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010:\u001a\u0004\bR\u0010AR!\u0010W\u001a\b\u0012\u0004\u0012\u00020T068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010:\u001a\u0004\bV\u0010<R#\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001d0X8\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u0004\u0018\u00010_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u0004\u0018\u00010b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001e\u0010p\u001a\u0004\u0018\u00010k8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001e\u0010v\u001a\u0004\u0018\u00010q8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\br\u0010s\"\u0004\bt\u0010u¨\u0006{"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/connect/AnchorRtcConnectModel;", "Lcom/bytedance/live/datacontext/DataContext;", "", "", "onRtcClosed", "onMultiLinkFinished", "Lcom/bytedance/android/livesdk/link/model/v4;", "inviteResult", "onInviteSuccess", "Lcom/bytedance/android/livesdk/link/model/e6;", "inviteContent", "onReceiveInvite", "Lcom/bytedance/android/livesdk/link/model/f;", "applyResult", "onApplySuccess", "Lcom/bytedance/android/livesdk/link/model/o9;", "switchSceneData", "Lcom/bytedance/android/live/revenuelink/rtc/p;", "rtcUserList", "onPkSwitchLink", "Lcom/bytedance/android/livesdk/link/model/k6;", "replyContent", "onReceiveReply", "Lcom/bytedance/android/livesdk/link/model/q5;", "replyResult", "onReplySuccess", "Lcom/bytedance/android/livesdk/link/model/g6;", "leaveContent", "onReceiveLeaveMsg", "", "enableFirstFrameOpt", "", "forwardInfoString", "frameInfoString", "refreshForwardData", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "preRtcInfo", "Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "source", "updatePushRtcStreamInfo", "linkmicId", "canRender", "notifyFrameCanRender", "Lg21/a;", "renderView", "onFirstFrame", "onFirstFrameRender", "onUserLeave", "Lcom/bytedance/android/livesdk/link/model/bridge/z1;", "userInfo", "updateFrameCanRender", "", "validRemoteViews", "Lcom/bytedance/live/datacontext/n;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "preRtcInfoMap$delegate", "Lcom/bytedance/live/datacontext/p;", "getPreRtcInfoMap", "()Lcom/bytedance/live/datacontext/n;", "preRtcInfoMap", "Lcom/bytedance/live/datacontext/k;", "multiLinkLoadEvent$delegate", "getMultiLinkLoadEvent", "()Lcom/bytedance/live/datacontext/k;", "multiLinkLoadEvent", "onStartRtcEvent$delegate", "getOnStartRtcEvent", "onStartRtcEvent", "onRtcUserJoinEvent$delegate", "getOnRtcUserJoinEvent", "onRtcUserJoinEvent", "Lkotlin/Pair;", "onNewFrameRenderEvent$delegate", "getOnNewFrameRenderEvent", "onNewFrameRenderEvent", "Lcom/bytedance/android/live/revlink/link/utils/LinkerID;", "frameRenderState$delegate", "getFrameRenderState", "frameRenderState", "onRenderedFrameInvalidEvent$delegate", "getOnRenderedFrameInvalidEvent", "onRenderedFrameInvalidEvent", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/o;", "rtcForwardData$delegate", "getRtcForwardData", "rtcForwardData", "", "anchorWithAudienceMap", "Ljava/util/Map;", "getAnchorWithAudienceMap", "()Ljava/util/Map;", "firstFrameOpt", "Z", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkInstanceService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/c;", "rtcForwardModel", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/c;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/e;", "rtcFrameModel", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/e;", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "setMultiLiveCoreInfo", "(Lcom/bytedance/android/livesdk/link/model/d7;)V", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "setMultiRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/v1;)V", "multiRtcInfo", "<init>", "(Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lcom/bytedance/android/live/revlink/impl/multianchor/connect/c;Lcom/bytedance/android/live/revlink/impl/multianchor/connect/e;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorRtcConnectModel extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_connect_model";
    private final Map<String, Boolean> anchorWithAudienceMap;
    private boolean firstFrameOpt;
    private final com.bytedance.live.datacontext.p frameRenderState$delegate;
    private final com.bytedance.android.live.revlink.impl.global.c linkInstanceService;
    private final com.bytedance.live.datacontext.p multiLinkLoadEvent$delegate;
    private final com.bytedance.live.datacontext.p onNewFrameRenderEvent$delegate;
    private final com.bytedance.live.datacontext.p onRenderedFrameInvalidEvent$delegate;
    private final com.bytedance.live.datacontext.p onRtcUserJoinEvent$delegate;
    private final com.bytedance.live.datacontext.p onStartRtcEvent$delegate;
    private final com.bytedance.live.datacontext.p preRtcInfoMap$delegate;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final com.bytedance.live.datacontext.p rtcForwardData$delegate;
    private final c rtcForwardModel;
    private final e rtcFrameModel;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "preRtcInfoMap", "getPreRtcInfoMap()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "multiLinkLoadEvent", "getMultiLinkLoadEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "onStartRtcEvent", "getOnStartRtcEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "onRtcUserJoinEvent", "getOnRtcUserJoinEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "onNewFrameRenderEvent", "getOnNewFrameRenderEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "frameRenderState", "getFrameRenderState()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "onRenderedFrameInvalidEvent", "getOnRenderedFrameInvalidEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorRtcConnectModel.class, "rtcForwardData", "getRtcForwardData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.n<Map<String, Boolean>> getFrameRenderState() {
        return (com.bytedance.live.datacontext.n) this.frameRenderState$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getMultiLinkLoadEvent() {
        return (com.bytedance.live.datacontext.k) this.multiLinkLoadEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.k<Pair<String, g21.a>> getOnNewFrameRenderEvent() {
        return (com.bytedance.live.datacontext.k) this.onNewFrameRenderEvent$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.k<String> getOnRenderedFrameInvalidEvent() {
        return (com.bytedance.live.datacontext.k) this.onRenderedFrameInvalidEvent$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.k<String> getOnRtcUserJoinEvent() {
        return (com.bytedance.live.datacontext.k) this.onRtcUserJoinEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.k<Object> getOnStartRtcEvent() {
        return (com.bytedance.live.datacontext.k) this.onStartRtcEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.n<Map<Long, z1>> getPreRtcInfoMap() {
        return (com.bytedance.live.datacontext.n) this.preRtcInfoMap$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.n<o> getRtcForwardData() {
        return (com.bytedance.live.datacontext.n) this.rtcForwardData$delegate.a(this, $$delegatedProperties[7]);
    }

    public void notifyFrameCanRender(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        this.rtcFrameModel.b(r2, r3);
    }

    public void onPkSwitchLink(com.bytedance.android.live.revenuelink.rtc.p r2, b2 r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcUserList");
        this.rtcFrameModel.d(r2, r3);
    }

    public void onReceiveLeaveMsg(String r2, b2 r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        this.rtcFrameModel.e(r2, r3);
    }

    public final String forwardInfoString() {
        return this.rtcForwardModel.toString();
    }

    public final String frameInfoString() {
        return this.rtcFrameModel.toString();
    }

    public d7 getMultiLiveCoreInfo() {
        return this.rtcForwardModel.e;
    }

    public v1 getMultiRtcInfo() {
        return this.rtcForwardModel.d;
    }

    public final void onMultiLinkFinished() {
        c r0 = this.rtcForwardModel;
        r0.b(null);
        r0.c = null;
        r0.d = null;
        r0.e = null;
        AnchorRtcConnectModel r1 = r0.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L5:
        r1.getRtcForwardData().setValue(null);
        this.rtcFrameModel.b.clear();
        this.firstFrameOpt = false;
    }

    public void onRtcClosed() {
        c r0 = this.rtcForwardModel;
        r0.b(null);
        r0.c = null;
        r0.d = null;
        r0.e = null;
        AnchorRtcConnectModel r1 = r0.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L5:
        r1.getRtcForwardData().setValue(null);
        this.rtcFrameModel.b.clear();
        this.firstFrameOpt = false;
        this.anchorWithAudienceMap.clear();
    }

    public void refreshForwardData() {
        final c r0 = this.rtcForwardModel;
        b7 r1 = r0.c;
        b2 r2 = r0.b;
        Function2<b7, b2, Unit> r3 = new AnchorRtcForwardModel$refreshForwardData$1(r0);
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        r3.invoke(r1, r2);
        return;
    L8:
        return;
    }

    public Map<String, g21.a> validRemoteViews() {
        HashMap<String, g21.a> r0 = this.rtcFrameModel.b;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, g21.a>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, g21.a> r3 = r2.next();
        if (r3.getValue().b == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        return r1;
    }

    public final boolean enableFirstFrameOpt() {
        return this.firstFrameOpt;
    }

    public final Map<String, Boolean> getAnchorWithAudienceMap() {
        return this.anchorWithAudienceMap;
    }

    public final void onApplySuccess(com.bytedance.android.livesdk.link.model.f r3) {
        Intrinsics.checkNotNullParameter(r3, "applyResult");
        b2 r0 = r3.getPreRtcInfo();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.getRtcJoinChannel() != true) goto L7;
    L8:
        this.firstFrameOpt = r1;
        setMultiRtcInfo(r3.getMultiRtcInfo());
        setMultiLiveCoreInfo(r3.getMultiLiveCoreInfo());
        updatePushRtcStreamInfo(r3.getPreRtcInfo(), r3.getMultiChannelInfo(), "applySuccess");
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onInviteSuccess(v4 r6) {
        Intrinsics.checkNotNullParameter(r6, "inviteResult");
        b2 r0 = r6.getPreRtcInfo();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.getRtcJoinChannel() != true) goto L7;
    L8:
        this.firstFrameOpt = r1;
        setMultiRtcInfo(r6.getMultiRtcInfo());
        setMultiLiveCoreInfo(r6.getMultiLiveCoreInfo());
        Map<String, Boolean> r2 = this.anchorWithAudienceMap;
        com.bytedance.android.livesdk.revenue.service.room.c r3 = this.roomService;
        if (r3 == null) goto L16;
        Intrinsics.checkNotNullParameter(r3, "$this$ownRoomID");
        IRoomBase r4 = r3.getRoomContext().getCommonRoom();
        if ((r4 instanceof IRoom) == true) goto L13;
        r4 = null;
    L13:
        IRoomBase r5 = (IRoom) r4;
        if (r5 == null) goto L16;
        long r7 = IRoomKtKt.getId(r5);
    L17:
        r2.put(h.a(r6, r7), Boolean.valueOf(r6.getInviteeWithAudience()));
        jy0.b.c(TAG, "onInviteSuccess anchorWithAudienceMap " + this.anchorWithAudienceMap, null, 4);
        updatePushRtcStreamInfo(r6.getPreRtcInfo(), r6.getMultiChannelInfo(), "inviteSuccess");
        return;
    L16:
        r7 = 0;
    L7:
        r1 = false;
        goto L8
    }

    public final void onReceiveInvite(e6 r3) {
        Intrinsics.checkNotNullParameter(r3, "inviteContent");
        b2 r0 = r3.getPreRtcInfo();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.getRtcJoinChannel() != true) goto L7;
    L8:
        this.firstFrameOpt = r1;
        setMultiRtcInfo(r3.getMultiRtcInfo());
        setMultiLiveCoreInfo(r3.getMultiLiveCoreInfo());
        updatePushRtcStreamInfo(r3.getPreRtcInfo(), r3.getMultiChannelInfo(), "receiveInvite");
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onReceiveLeaveMsg(g6 r4) {
        Intrinsics.checkNotNullParameter(r4, "leaveContent");
        updatePushRtcStreamInfo(r4.getPreRtcInfo(), r4.getMultiChannelInfo(), "leaveMsg");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkInstanceService;
        if (r0 == null) goto L12;
        i11.b r1 = r0.c8();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.link.model.p r2 = r1.getGuestInfo(ILinkerLeaveContentBridgeKt.getUserIdEx(r4), null);
        if (r2 == null) goto L14;
        String r3 = r2.getLinkMicIdStr();
        if (r3 == null) goto L15;
        this.rtcFrameModel.e(r3, r4.getPreRtcInfo());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public void onUserLeave(String r6) {
        e r0 = this.rtcFrameModel;
        r0.getClass();
        jy0.b.f("ttlive_anchor_connect_frame", "onUserLeave " + r6, null, 4);
        HashMap<String, g21.a> r1 = r0.b;
        if (r1 == null) goto L7;
        TypeIntrinsics.asMutableMap(r1).remove(r6);
        r0.c();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public void setMultiLiveCoreInfo(d7 r2) {
        this.rtcForwardModel.e = r2;
    }

    public void setMultiRtcInfo(v1 r2) {
        this.rtcForwardModel.d = r2;
    }

    public void onFirstFrame(String r8, g21.a r9) {
        Intrinsics.checkNotNullParameter(r8, "linkmicId");
        Intrinsics.checkNotNullParameter(r9, "renderView");
        e r2 = this.rtcFrameModel;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "linkmicId");
        Intrinsics.checkNotNullParameter(r9, "renderView");
        g21.a r0 = r2.b.get(r8);
        if (r0 == null) goto L5;
        Object r1 = r0.a;
    L7:
        if (Intrinsics.areEqual(r1, r9.a) == false) goto L9;
        jy0.b.c("ttlive_anchor_connect_frame", "onFirstFrame same content " + r8 + ' ' + r9, null, 4);
        return;
    L9:
        jy0.b.f("ttlive_anchor_connect_frame", "onFirstVideoFrame " + r8 + ' ' + r9, null, 4);
        r2.b.put(r8, r9);
        if (r9.b == false) goto L15;
        AnchorRtcConnectModel r3 = r2.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L14:
        r3.getOnNewFrameRenderEvent().post(TuplesKt.to(r8, r9));
    L15:
        r2.c();
        return;
    L5:
        r1 = null;
        goto L7
    }

    public void onFirstFrameRender(String r8, g21.a r9) {
        Intrinsics.checkNotNullParameter(r8, "linkmicId");
        Intrinsics.checkNotNullParameter(r9, "renderView");
        e r2 = this.rtcFrameModel;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "linkmicId");
        Intrinsics.checkNotNullParameter(r9, "renderView");
        g21.a r0 = r2.b.get(r8);
        if (r0 == null) goto L5;
        Object r1 = r0.a;
    L7:
        if (Intrinsics.areEqual(r1, r9.a) == false) goto L9;
        jy0.b.c("ttlive_anchor_connect_frame", "onFirstFrameRender same content " + r8 + ' ' + r9, null, 4);
        return;
    L9:
        jy0.b.f("ttlive_anchor_connect_frame", "onFirstVideoFrameRender " + r8 + ' ' + r9, null, 4);
        r2.b.put(r8, r9);
        if (r9.b == false) goto L15;
        AnchorRtcConnectModel r3 = r2.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rtcConnectModel");
    L14:
        r3.getOnNewFrameRenderEvent().post(TuplesKt.to(r8, r9));
    L15:
        r2.c();
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onPkSwitchLink(o9 r4, com.bytedance.android.live.revenuelink.rtc.p r5) {
        Intrinsics.checkNotNullParameter(r4, "switchSceneData");
        b2 r0 = r4.getPreRtcInfo();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.getRtcJoinChannel() != true) goto L7;
    L8:
        this.firstFrameOpt = r1;
        updatePushRtcStreamInfo(r4.getPreRtcInfo(), r4.getMultiChannelInfo(), "pkSwitchLink");
        if (r5 == null) goto L12;
        this.rtcFrameModel.d(r5, r4.getPreRtcInfo());
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onReceiveReply(k6 r4, com.bytedance.android.live.revenuelink.rtc.p r5) {
        Intrinsics.checkNotNullParameter(r4, "replyContent");
        b2 r0 = r4.getPreRtcInfo();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.getRtcJoinChannel() != true) goto L7;
    L8:
        this.firstFrameOpt = r1;
        setMultiRtcInfo(r4.getMultiRtcInfo());
        setMultiLiveCoreInfo(r4.getMultiLiveCoreInfo());
        updatePushRtcStreamInfo(r4.getPreRtcInfo(), r4.getMultiChannelInfo(), "receiveReply");
        if (r5 == null) goto L12;
        this.rtcFrameModel.d(r5, r4.getPreRtcInfo());
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onReplySuccess(q5 r4, com.bytedance.android.live.revenuelink.rtc.p r5) {
        Intrinsics.checkNotNullParameter(r4, "replyResult");
        b2 r0 = r4.getPreRtcInfo();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.getRtcJoinChannel() != true) goto L7;
    L8:
        this.firstFrameOpt = r1;
        setMultiRtcInfo(r4.getMultiRtcInfo());
        setMultiLiveCoreInfo(r4.getMultiLiveCoreInfo());
        updatePushRtcStreamInfo(r4.getPreRtcInfo(), r5.a(r4), "replySuccess");
        if (r5 == null) goto L12;
        this.rtcFrameModel.d(r5, r4.getPreRtcInfo());
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void updateFrameCanRender(z1 r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "userInfo");
        e r1 = this.rtcFrameModel;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "userInfo");
        if (Intrinsics.areEqual(r4.getLinkmicIdStr(), r1.a()) == true) goto L14;
        g21.a r0 = r1.b.get(r4.getLinkmicIdStr());
        if (r0 != null) goto L8;
        jy0.b.d("ttlive_anchor_connect_frame", "refreshRenderStatus " + a2.a(r4) + " frame not ready");
    L12:
        r1.c();
        return;
    L8:
        if (r0.b == true) goto L12;
        if (r5 == false) goto L12;
        r1.b(r4.getLinkmicIdStr(), true);
        goto L12
    }

    public void updatePushRtcStreamInfo(b2 r13, b7 r14, final String r15) {
        Intrinsics.checkNotNullParameter(r15, "source");
        final c r1 = this.rtcForwardModel;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r15, "source");
        StringBuilder r2 = new StringBuilder("tryUpdatePushRtcStreamInfo source=");
        r2.append(r15);
        r2.append(' ');
        if (r13 == null) goto L5;
        String r5 = c2.a(r13);
    L6:
        r2.append(r5);
        r2.append(' ');
        if (r14 == null) goto L9;
        String r6 = c7.a(r14);
    L10:
        r2.append(r6);
        r2.append(' ');
        com.bytedance.android.live.revlink.impl.global.c r3 = r1.g;
        if (r3 == null) goto L13;
        com.bytedance.android.live.revenuelink.connect.g r4 = r3.getAnchorConnectUtils();
    L14:
        if (r4 == null) goto L18;
        LiveData<ey.f> r7 = r4.connectState();
        if (r7 == null) goto L18;
        ey.f r8 = (ey.f) r7.getValue();
    L19:
        r2.append(r8);
        jy0.b.a("ttlive_anchor_connect_forward", r2.toString());
        if (r13 == null) goto L55;
        if (r14 == null) goto L61;
        int r9 = o.c;
        Intrinsics.checkNotNullParameter(r15, "$this$isSwitchNewChannel");
        if (Intrinsics.areEqual(r15, "linkSwitchChannel") == true) goto L47;
        b2 r10 = r1.b;
        long r12 = -1;
        if (r10 == null) goto L28;
        long r16 = r10.getVersion();
    L30:
        if (r16 != r13.getVersion()) goto L32;
        jy0.b.f("ttlive_anchor_connect_forward", "preRtcInfo same version source=".concat(r15), null, 4);
        return;
    L32:
        b2 r17 = r1.b;
        if (r17 == null) goto L36;
        r12 = r17.getVersion();
    L36:
        if (r12 <= r13.getVersion()) goto L47;
        com.bytedance.android.live.revlink.impl.global.c r18 = r1.g;
        if (r18 == null) goto L40;
        g0 r19 = r18.Rn();
    L41:
        if (r19 == null) goto L57;
        b2 r110 = r1.b;
        Intrinsics.checkNotNullParameter(r15, "source");
        StringBuilder r0 = new StringBuilder("preRtcInfo version rollback source=");
        r0.append(r15);
        r0.append(" current=");
        if (r110 == null) goto L45;
        String r111 = c2.a(r110);
    L46:
        r0.append(r111);
        r0.append(" new=");
        r0.append(c2.a(r13));
        jy0.b.c("ttlive_anchor_connect", r0.toString(), null, 4);
        return;
    L45:
        r111 = null;
        goto L46
    L57:
        return;
    L40:
        r19 = null;
        goto L41
    L28:
        r16 = -1;
    L47:
        r1.b(r13);
        r1.c = r14;
        if (r14.getUseMultiChannel() == false) goto L62;
        b7 r112 = r1.c;
        b2 r113 = r1.b;
        Function2<b7, b2, Unit> r20 = new AnchorRtcForwardModel$updatePushRtcStreamInfo$1(r1, r15);
        if (r112 == null) goto L59;
        if (r113 == null) goto L60;
        r20.invoke(r112, r113);
        return;
    L60:
        return;
    L59:
        return;
    L62:
        return;
    L61:
        return;
    L55:
        return;
    L18:
        r8 = null;
        goto L19
    L13:
        r4 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public AnchorRtcConnectModel(com.bytedance.android.livesdk.revenue.service.room.c r2, com.bytedance.android.live.revlink.impl.global.c r3, c r4, e r5) {
        Intrinsics.checkNotNullParameter(r4, "rtcForwardModel");
        Intrinsics.checkNotNullParameter(r5, "rtcFrameModel");
        this.roomService = r2;
        this.linkInstanceService = r3;
        this.rtcForwardModel = r4;
        this.rtcFrameModel = r5;
        this.preRtcInfoMap$delegate = q.b(this, AnchorRtcConnectModel$preRtcInfoMap$2.INSTANCE);
        this.multiLinkLoadEvent$delegate = com.bytedance.live.datacontext.e.a(this, AnchorRtcConnectModel$multiLinkLoadEvent$2.INSTANCE);
        this.onStartRtcEvent$delegate = com.bytedance.live.datacontext.e.a(this, AnchorRtcConnectModel$onStartRtcEvent$2.INSTANCE);
        this.onRtcUserJoinEvent$delegate = com.bytedance.live.datacontext.e.a(this, AnchorRtcConnectModel$onRtcUserJoinEvent$2.INSTANCE);
        this.onNewFrameRenderEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.frameRenderState$delegate = q.b(this, AnchorRtcConnectModel$frameRenderState$2.INSTANCE);
        this.onRenderedFrameInvalidEvent$delegate = com.bytedance.live.datacontext.e.a(this, AnchorRtcConnectModel$onRenderedFrameInvalidEvent$2.INSTANCE);
        this.rtcForwardData$delegate = q.b(this, AnchorRtcConnectModel$rtcForwardData$2.INSTANCE);
        this.anchorWithAudienceMap = new LinkedHashMap();
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "rtcConnectModel");
        r4.a = this;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "rtcConnectModel");
        r5.a = this;
    }

    public /* synthetic */ AnchorRtcConnectModel(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2, c r3, e r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = new c(r1, r2);
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = new e(r2);
    L8:
        this(r1, r2, r3, r4);
    }
}
