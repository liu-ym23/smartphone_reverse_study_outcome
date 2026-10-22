package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.c4;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLiveCoreBizTagChangeContent;
import com.bytedance.badger.collect.impl.constants.Constants;
import fr2.u0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class AnchorRtcConnectManager$attach$1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public AnchorRtcConnectManager$attach$1(AnchorRtcConnectManager r8) {
        super(1, r8, AnchorRtcConnectManager.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(yh6.c r13) {
        AnchorRtcConnectManager r0 = (AnchorRtcConnectManager) ((CallableReference) this).receiver;
        int r1 = AnchorRtcConnectManager.o;
        r0.getClass();
        if ((r13 instanceof h1) == false) goto L128;
        i6 r14 = ((vh7.c) r13).castTo(i6.class);
        int r3 = (int) i1.c(r14);
        boolean r6 = false;
        boolean r7 = true;
        if (r3 != 7) goto L8;
        com.bytedance.android.live.revlink.impl.global.c r2 = r0.m;
        if (r2 == null) goto L122;
        com.bytedance.android.live.revenuelink.connect.g r4 = r2.getAnchorConnectUtils();
        if (r4 != null) goto L82;
        return;
    L82:
        if (r4.u1() != true) goto L124;
        Intrinsics.checkNotNullParameter(r14, "$this$sceneExt");
        if (ArraysKt.contains((Integer[]) AnchorRtcConnectUtilsKt.c.getValue(null, AnchorRtcConnectUtilsKt.a[0]), Integer.valueOf((int) r14.getScene())) == false) goto L133;
        Intrinsics.checkNotNullParameter(r14, "$this$linkerIdExt");
        long r5 = r14.getLinkerId();
        com.bytedance.android.live.revlink.impl.global.c r8 = r0.m;
        if (r8 == null) goto L107;
        com.bytedance.android.live.revenuelink.connect.g r9 = r8.getAnchorConnectUtils();
        if (r9 == null) goto L107;
        if (r5 != r9.getChannelId()) goto L107;
        int r10 = w.a;
        if (v.a() == true) goto L96;
    L100:
        if (r6 == true) goto L134;
        ILinkerLeaveContentBridge r15 = r14.getLeave();
        if (r15 == null) goto L125;
        g6 r16 = r15.castTo(g6.class);
        if (r16 == null) goto L126;
        r0.j.onReceiveLeaveMsg(r16);
        return;
    L126:
        return;
    L125:
        return;
    L134:
        return;
    L96:
        if (AnchorRtcConnectUtilsKt.f() == false) goto L100;
        y41.f r12 = y41.f.N;
        r12.getClass();
        if (((Boolean) y41.f.j.getValue(r12, y41.f.a[8])).booleanValue() == false) goto L100;
        r6 = true;
    L107:
        jy0.b.c("ttlive_anchor_connect_mgr", "unexpected leaveMsg from different channel", null, 4);
        return;
    L133:
        return;
    L124:
        return;
    L122:
        return;
    L8:
        if (r3 != 49) goto L10;
        com.bytedance.android.live.revlink.impl.global.c r17 = r0.m;
        if (r17 == null) goto L57;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r18 = r17.getMultiLinkMonitor();
        if (r18 == null) goto L57;
        Intrinsics.checkNotNullParameter(r14, Constants.OperatorKey.MSG);
        JSONObject r19 = new JSONObject();
        c4 r20 = r14.getCrossRoomRTCInfoContent();
        if (r20 == null) goto L56;
        int r22 = y50.b.a;
        b7 r23 = r20.getMultiChannelInfo();
        if (r23 == null) goto L50;
        String r24 = c7.a(r23);
    L51:
        y50.b.a.d(r19, "multi_channel_info", r24);
        b2 r25 = r20.getPreRtcInfo();
        if (r25 == null) goto L54;
        String r26 = c2.a(r25);
    L55:
        y50.b.a.d(r19, "pre_rtc_info", r26);
        goto L56
    L54:
        r26 = null;
        goto L55
    L50:
        r24 = null;
    L56:
        com.bytedance.android.live.revlink.impl.multianchor.utils.v.m(r14, r19);
        r18.c(r19);
        r18.I("receive_cross_room_rtc_info_msg", r19, false);
    L57:
        com.bytedance.android.live.revlink.impl.global.c r27 = r0.m;
        if (r27 == null) goto L63;
        com.bytedance.android.live.revenuelink.connect.g r28 = r27.getAnchorConnectUtils();
        if (r28 == null) goto L63;
        if (r28.u1() == true) goto L63;
        return;
    L63:
        Intrinsics.checkNotNullParameter(r14, "$this$sceneExt");
        if (ArraysKt.contains((Integer[]) AnchorRtcConnectUtilsKt.c.getValue(null, AnchorRtcConnectUtilsKt.a[0]), Integer.valueOf((int) r14.getScene())) == false) goto L132;
        Intrinsics.checkNotNullParameter(r14, "$this$linkerIdExt");
        long r29 = r14.getLinkerId();
        com.bytedance.android.live.revlink.impl.global.c r30 = r0.m;
        if (r30 == null) goto L76;
        com.bytedance.android.live.revenuelink.connect.g r32 = r30.getAnchorConnectUtils();
        if (r32 == null) goto L76;
        if (r29 != r32.getChannelId()) goto L76;
        c4 r110 = r14.getCrossRoomRTCInfoContent();
        if (r110 == null) goto L119;
        r0.j.updatePushRtcStreamInfo(r110.getPreRtcInfo(), r110.getMultiChannelInfo(), "crossRoomRtcInfoMsg");
        return;
    L119:
        return;
    L76:
        jy0.b.c("ttlive_anchor_connect_mgr", "unexpected crossRoomRtcInfoMsg from different channel", null, 4);
        return;
    L132:
        return;
    L10:
        if (r3 != 72) goto L129;
        Intrinsics.checkNotNullParameter(r14, "$this$BizTagExt");
        ILinkerLiveCoreBizTagChangeContent r111 = r14.getLinkerLiveCoreBizTagChangeContent();
        if (r111 == null) goto L15;
        String r112 = r111.getBizTag();
    L16:
        IRoom r33 = r0.a;
        if (r33 != null) goto L19;
        return;
    L19:
        if (((int) r33.getLiveRoomMode()) != 3) goto L130;
        if (r112 == null) goto L27;
        if (StringsKt.isBlank(r112) == true) goto L27;
        r7 = false;
    L27:
        if (r7 == false) goto L109;
        fr2.v r113 = r0.i;
        if (r113 == null) goto L112;
        fr2.p r114 = r113.getLiveCore();
        if (r114 == null) goto L113;
        r114.y3(new u0(0, "", ""));
        return;
    L113:
        return;
    L112:
        return;
    L109:
        jy0.b.d("ttlive_anchor_connect_mgr", "handleAudioSceneVideoExpOpt bizTagJsonStr " + r112 + " from anchor msg");     // Catch: Exception -> L39
        JSONObject r34 = new JSONObject(r112);     // Catch: Exception -> L39
        int r35 = r34.optInt("LiveRoomMode", 0);     // Catch: Exception -> L39
        String r36 = r34.optString("BizType", "");     // Catch: Exception -> L39
        String r37 = r34.optString("SceneType", "");     // Catch: Exception -> L39
        fr2.v r38 = r0.i;     // Catch: Exception -> L39
        if (r38 == null) goto L115;
        fr2.p r39 = r38.getLiveCore();     // Catch: Exception -> L39
        if (r39 == null) goto L116;
        r39.y3(new u0(r35, r36, r37));     // Catch: Exception -> L39
        return;
    L116:
        return;
    L115:
        return;
    L39:
        e = move-exception;
        jy0.b.c("ttlive_anchor_connect_mgr", "handleAudioSceneVideoExpOpt bizTagJsonStr " + r112 + " from anchor msg set biz tag failed " + e.getMessage(), null, 4);
        return;
    L130:
        return;
    L15:
        r112 = null;
        goto L16
    L129:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yh6.c) r1);
        return Unit.INSTANCE;
    }
}
