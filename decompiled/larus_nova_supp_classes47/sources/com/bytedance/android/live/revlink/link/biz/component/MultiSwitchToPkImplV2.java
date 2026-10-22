package com.bytedance.android.live.revlink.link.biz.component;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.launchcontext.PkAnchorLaunchType;
import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.PkMultiDataContext;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.AnchorLinkInitType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.link.core.UILayoutServerIndex;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.link.streaminteract.biz.PushModeManagerService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.n1;
import com.bytedance.android.livesdk.link.model.bridge.o1;
import com.bytedance.android.livesdk.link.model.bridge.p1;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.p9;
import com.bytedance.android.livesdk.link.model.q6;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.link.model.x6;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiSwitchToPkImplV2 implements com.bytedance.android.live.revlink.link.biz.service.c, d {
    public final String a;
    public final CompositeDisposable b;
    public final boolean c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final com.bytedance.android.live.revenuelink.rtc.i f;
    public final h g;
    public final MultiAnchorLinkContext h;
    public final MultiPKContextHolder i;
    public final MultiRTCBizComponent j;
    public final AnchorUILayoutManager k;
    public final PushModeManagerService l;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiSwitchToPkImplV2$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i6;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<i6, Unit> {
        public AnonymousClass1(MultiSwitchToPkImplV2 r8) {
            super(1, r8, MultiSwitchToPkImplV2.class, "onLinkerMessage", "onLinkerMessage(Lcom/bytedance/android/livesdk/link/model/ILinkerMessage;)V", 0);
        }

        public final void invoke(i6 r47) {
            Intrinsics.checkNotNullParameter(r47, "p1");
            MultiSwitchToPkImplV2 r2 = (MultiSwitchToPkImplV2) ((CallableReference) this).receiver;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r47, "$this$sceneExt");
            if (((int) r47.getScene()) == 7) goto L9;
            Intrinsics.checkNotNullParameter(r47, "$this$sceneExt");
            if (((int) r47.getScene()) == 2) goto L9;
            Intrinsics.checkNotNullParameter(r47, "$this$sceneExt");
            if (((int) r47.getScene()) == 1) goto L9;
            return;
        L9:
            Intrinsics.checkNotNullParameter(r47, "$this$typeExt");
            if (((int) r47.getType2()) != 31) goto L468;
            v r5 = com.bytedance.android.live.revlink.link.biz.service.i.H(r2);
            r5.getClass();
            Intrinsics.checkNotNullParameter(r47, Constants.OperatorKey.MSG);
            LinkedHashMap r9 = new LinkedHashMap();
            r9.put("msg_id", String.valueOf(qj.a(r47)));
            Intrinsics.checkNotNullParameter(r47, "$this$sceneExt");
            r9.put("msg_scene", Long.valueOf(r47.getScene()));
            q6 r3 = r47.getSwitchSceneContent();
            if (r3 == null) goto L44;
            o9 r4 = r3.getSwitchSceneData();
            if (r4 == null) goto L44;
            r9.put("to_linker_id", Long.valueOf(r4.getToLinkerId()));
            r9.put("to_scene", Integer.valueOf(r4.getToScene()));
            r9.put("ui_layout", Integer.valueOf(r4.getDefaultUILayout()));
            n1 r6 = r4.getMultiAnchorExtra();
            if (r6 == null) goto L19;
            r9.put("multi_anchor_extra", ef2.a.c(r6));
        L19:
            b7 r7 = r4.getMultiChannelInfo();
            if (r7 == null) goto L23;
            String r8 = c7.a(r7);
            if (r8 == null) goto L23;
        L24:
            r9.put("multi_channel_info", r8);
            b2 r10 = r4.getPreRtcInfo();
            if (r10 == null) goto L28;
            String r12 = c2.a(r10);
            if (r12 == null) goto L28;
        L29:
            r9.put("pre_rtc_info", r12);
            com.bytedance.android.livesdk.link.model.m r13 = r4.getLayoutInfo();
            if (r13 == null) goto L32;
            r9.put("layout_info", ef2.a.c(r13));
        L32:
            r9.put("multi_channel_version", Long.valueOf(r4.getVersion()));
            List r14 = r4.getLinkedUsers();
            if (r14 == null) goto L42;
            List r15 = r14;
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r17 = r15.iterator();
        L36:
            if (r17.hasNext() == false) goto L43;
            IBaseUser r18 = ((com.bytedance.android.livesdk.link.model.p) r17.next()).getUser();
            if (r18 == null) goto L40;
            String r19 = r18.getIdString();
        L41:
            r16.add(r19);
            goto L36
        L40:
            r19 = null;
        L43:
            r9.put("switch_link_users", String.valueOf(r16));
            goto L44
        L42:
            r16 = null;
        L28:
            r12 = "null";
        L23:
            r8 = "null";
        L44:
            r5.b(r9);
            r5.H("receive_linker_switch_scene_msg", r9);
            q6 r20 = r47.getSwitchSceneContent();
            if (r20 == null) goto L461;
            o9 r22 = r20.getSwitchSceneData();
            if (r22 != null) goto L49;
            return;
        L49:
            if (r22.getToScene() != 7) goto L450;
            x6 r23 = p9.a(r22);
            if (r23 == null) goto L55;
            if (com.bytedance.android.live.revenuelink.connect.b.b((int) r23.getMatchType()) != true) goto L55;
        L56:
            long r110 = r2.getContext().d.p;
            if (p9.b(r22) == true) goto L59;
        L87:
            MultiLinkAnchorControlContext r24 = com.bytedance.android.live.revlink.link.biz.service.i.G(r2);
            if (r24 == null) goto L90;
            UnexpectedFrameMonitor r25 = r24.getUnexpectedFrameMonitor();
        L92:
            if (r25 == null) goto L94;
            Intrinsics.checkNotNullParameter(r22, "switchSceneData");
            r25.q(r22.getPreRtcInfo());
        L94:
            MultiAnchorLinkContext r26 = r2.h;
            p0.a r111 = p0.Companion;
            r26.updateLaunchBattleAttachedInfo(e21.c.c(r111, r22.getBattleAttachedInfoStr()));
            if (r2.c == false) goto L103;
            AnchorRtcConnectModel r27 = r2.getContext().Hb();
            if (r27 == null) goto L104;
            b2 r112 = r22.getPreRtcInfo();
            b7 r113 = r22.getMultiChannelInfo();
            if (p9.b(r22) == false) goto L101;
            String r114 = "linkSwitchChannel";
        L102:
            r27.updatePushRtcStreamInfo(r112, r113, r114);
            goto L104
        L101:
            r114 = "linkSwitchLink";
        L104:
            x6 r0 = p9.a(r22);
            long r115 = 0;
            if (p9.b(r22) == false) goto L225;
            if (com.bytedance.android.live.revenuelink.connect.b.c(r0) == false) goto L225;
            d31.b r28 = com.bytedance.android.live.revlink.link.biz.service.i.C(r2);
            r2.i.c.getBasePKContext();
            PkMultiDataContext r29 = r2.i.c;
            h r30 = r2.g;
            long r116 = r30.h;
            int r32 = r30.g;
            r28.getClass();
            LinkedHashMap r33 = new LinkedHashMap();
            r33.put("enter_from", r28.c.getRoomContext().getPixEnterFrom());
            f21.a r1 = r28.c();
            if (r1 == null) goto L111;
            long r117 = r1.s;
        L113:
            if (r117 <= 0) goto L118;
            f21.a r34 = r28.c();
            if (r34 == null) goto L117;
            long r118 = r34.s;
        L119:
            i97.a r35 = i97.a.a;
            long r210 = (System.currentTimeMillis() - r118) / ((long) WebcastRedirectException.UNKNOWN);
            d31.d r36 = com.bytedance.android.live.revlink.link.biz.service.i.Z(r28);
            if (r36 == null) goto L123;
            String r37 = r36.a();
            if (r37 == null) goto L123;
        L124:
            r33.put("anchor_connect_status", r37);
            r33.put("diamond", DataType.FALSE);
            r33.put("connection_time", String.valueOf(r210));
            if (l51.a.e() == false) goto L127;
            String r38 = "on";
        L128:
            r33.put("gift_guest_switch_type", r38);
            if (r0 == null) goto L131;
            Integer r119 = Integer.valueOf((int) r0.getMatchType());
        L132:
            if (r119 != null) goto L135;
        L137:
            String r120 = "relink";
        L138:
            r33.put("end_type", r120);
            r33.put("end_reason", "passive");
            RelinkDataContext r121 = com.bytedance.android.live.revlink.link.biz.service.i.X(r28);
            if (r121 == null) goto L143;
            boolean r122 = r121.isRelinkInviter();
            String r211 = DataType.FALSE;
            if (r122 != true) goto L144;
            r33.put("end_reason", "active");
        L144:
            r33.put("pk_id", String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.T(r28).i()));
            r33.put("connection_anchor_cnt", String.valueOf(r32));
            RelinkDataContext r39 = com.bytedance.android.live.revlink.link.biz.service.i.X(r28);
            if (r39 == null) goto L163;
            String r40 = r39.getInviteMode();
            if (r40.length() != 0) goto L149;
            boolean r123 = true;
        L150:
            if (r123 == false) goto L152;
            r40 = "connection";
        L152:
            r33.put("invite_mode", r40);
            String r42 = r39.getRoomStatus();
            if (r42.length() != 0) goto L155;
            boolean r124 = true;
        L157:
            if (r124 == false) goto L159;
            r42 = "room_status";
        L159:
            r33.put("room_status", r42);
            Map<String, String> r43 = r39.getPkEventTrackingInfo();
            if (r43 == null) goto L162;
            r33.putAll(r43);
        L162:
            r39.clearEventParams();
            goto L163
        L155:
            r124 = false;
            goto L157
        L149:
            r123 = false;
        L163:
            r33.put("connection_type", com.bytedance.android.live.revlink.link.biz.service.i.Z(r28).c());
            r33.put("is_manager", com.bytedance.android.live.revlink.link.biz.service.i.Z(r28).o());
            com.bytedance.android.live.revlink.link.biz.service.i.Z(r28).getClass();
            r33.put("audience_connect_cnt", String.valueOf(n41.a.b()));
            if (r29 == null) goto L166;
            String r44 = r29.getTeamType();
        L167:
            if (r44 != null) goto L169;
        L172:
            boolean r45 = true;
        L173:
            if (r45 == true) goto L179;
            if (r29 == null) goto L177;
            String r46 = r29.getTeamType();
            if (r46 == null) goto L177;
        L178:
            r33.put("team_type", r46);
        L177:
            r46 = "";
        L179:
            r33.put("invitee_list", com.bytedance.android.live.revlink.link.biz.service.i.Z(r28).p(0));
            if (r29 == null) goto L186;
            j31.a r48 = r29.getPkStartParam();
            if (r48 == null) goto L186;
            if (r48.e != true) goto L186;
            String r49 = DataType.TRUE;
        L187:
            r33.put("is_oncemore", r49);
            r33.put("is_manager", com.bytedance.android.live.revlink.link.biz.service.i.Z(r28).o());
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r50 = com.bytedance.android.live.revlink.link.biz.service.i.B(r28);
            f21.a r52 = r28.c();
            if (r52 == null) goto L190;
            boolean r53 = r52.k;
        L191:
            f21.a r125 = r28.c();
            if (r125 == null) goto L194;
            int r126 = r125.d;
            int r127 = 4;
        L195:
            r33.put("npk_link_type", com.bytedance.android.live.revlink.impl.multianchor.utils.q.E(r50, r53, r126, r127));
            com.bytedance.android.live.revlink.impl.multianchor.vm.b r54 = com.bytedance.android.live.revlink.link.biz.service.i.z(r28);
            if (r54 == null) goto L202;
            com.bytedance.live.datacontext.m<String> r55 = r54.getConnectionSubType();
            if (r55 == null) goto L202;
            if ((!StringsKt.isBlank((CharSequence) r55.getValue())) == false) goto L202;
            r33.put("connection_sub_type", r55.getValue());
        L202:
            r33.put("channel_id", String.valueOf(r110));
            if (r29 == null) goto L209;
            j31.a r56 = r29.getPkStartParam();
            if (r56 == null) goto L209;
            Integer r57 = r56.f;
            if (r57 == null) goto L209;
            int r58 = r57.intValue();
        L210:
            if (r58 == 0) goto L217;
            if (r29 == null) goto L215;
            j31.a r59 = r29.getPkStartParam();
            if (r59 == null) goto L215;
            Integer r60 = r59.f;
        L216:
            r33.put("pk_time", String.valueOf(r60));
        L215:
            r60 = null;
        L217:
            if (r29 == null) goto L223;
            j31.a r62 = r29.getPkStartParam();
            if (r62 == null) goto L223;
            String r63 = r62.n;
            if (r63 == null) goto L223;
            r33.put("customize_pk_type", r63);
        L223:
            r28.b(r33);
            mz0.n r64 = new mz0.n();
            Map<String, String> r65 = r64.a;
            Intrinsics.checkNotNullParameter(r65, "map");
            Intrinsics.checkNotNullParameter(r33, "map");
            r65.putAll(r33);
            mz0.m r66 = new mz0.m();
            com.bytedance.android.livesdk.revenue.log.i r67 = vh6.c.b(kr2.a.class).ud();
            Intrinsics.checkNotNullParameter(r67, "pageSourceLog");
            Intrinsics.checkNotNullParameter("live", "belong");
            r67.a("live");
            Intrinsics.checkNotNullParameter("other", "type");
            r67.d("other");
            ((ArrayList) r66.a).add(r67.a);
            com.bytedance.android.live.revlink.link.biz.service.i.m(r28).a(r66);
            r66.b(LogCommon.ROOM);
            ((ArrayList) r64.b).addAll(r66.a);
            cy0.e.a.getClass();
            cy0.j r68 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r69 = com.bytedance.android.scope.m.b(r68).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r69);
            ((mz0.i) ((f80.a) r69)).w3("livesdk_connection_over", r64.a, r64.b);
        L209:
            r58 = 0;
            goto L210
        L194:
            r127 = 4;
            r126 = 0;
            goto L195
        L190:
            r53 = false;
        L186:
            r49 = r211;
            goto L187
        L169:
            if (r44.length() == 0) goto L172;
            r45 = false;
            goto L173
        L166:
            r44 = null;
            goto L167
        L143:
            r211 = r13;
            goto L144
        L135:
            if (r119.intValue() != 20) goto L137;
            r120 = "team_quit";
            goto L138
        L131:
            r119 = null;
            goto L132
        L127:
            r38 = "off";
        L123:
            r37 = "";
            goto L124
        L117:
            r118 = 0;
            goto L119
        L118:
            r118 = r116;
            goto L119
        L111:
            r117 = 0;
        L225:
            x6 r70 = p9.a(r22);
            if (r70 == null) goto L259;
            r2.h.getMatchType().setValue(Integer.valueOf((int) r70.getMatchType()));
            int r72 = r70.getInviteRole();
            if (r72 != 2) goto L230;
        L233:
            boolean r73 = true;
        L234:
            if (r73 == false) goto L236;
            String r74 = "null";
            r2.h.getInviteeList().setValue(r74);
        L237:
            int r75 = (int) r70.getMatchType();
            if (r75 != 4) goto L240;
            r2.h.getConnectionSubType().setValue("random_nlink");
        L260:
            com.bytedance.android.live.revlink.impl.control.launchcontext.a r76 = com.bytedance.android.live.revlink.link.biz.service.i.x(r2);
            if (r76 == null) goto L263;
            u r77 = r76.a;
        L264:
            if (r77 == null) goto L266;
            Integer r78 = Integer.valueOf(r77.d);
        L267:
            if (r78 == null) goto L269;
            r2.h.getInviteType().setValue(Integer.valueOf(r77.d));
        L269:
            if (r0 != null) goto L271;
        L273:
            if (r0 != null) goto L275;
        L277:
            Intrinsics.checkNotNullParameter(r2, "$this$anchorConnectionContextObj");
            f21.b r79 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(r2).Rb();
            f21.a r80 = com.bytedance.android.live.revlink.link.biz.service.i.i(r2);
            r79.getClass();
            Intrinsics.checkNotNullParameter(r22, "switchSceneData");
            x6 r82 = p9.a(r22);
            if (r82 != null) goto L280;
            r82 = (x6) vh7.f.c(x6.class);
        L280:
            int r128 = (int) r82.getMatchType();
            boolean r310 = p9.b(r22);
            int r129 = r22.getInviterFromScene();
            if (((int) r82.getMatchType()) != 4) goto L283;
        L284:
            if (r80 != null) goto L286;
        L290:
            boolean r212 = false;
        L292:
            if (r128 == 20) goto L301;
            if (r128 == 21) goto L300;
            if (r80 == null) goto L299;
            String r83 = r80.m;
            if (r83 == null) goto L299;
            String r311 = r83;
        L303:
            if (x.c(r128) == true) goto L309;
            if (r310 == false) goto L307;
        L310:
            boolean r312 = true;
        L312:
            if (x.c(r128) == false) goto L314;
            i97.a r84 = i97.a.a;
            r115 = System.currentTimeMillis();
        L314:
            long r410 = r115;
            com.bytedance.android.live.revlink.impl.global.c r85 = r79.a;
            AnchorLinkInitType r213 = AnchorLinkInitType.LINK_SWITCH_CHANNEL;
            int r130 = (int) r82.getMatchType();
            int r131 = r82.getInviteRole();
            Integer r132 = Integer.valueOf(r128);
            if (r132 != null) goto L317;
            String r411 = "";
        L320:
            if (r132 == null) goto L326;
            if (r132.intValue() != 20) goto L326;
            String r214 = "relink_team";
        L342:
            int r313 = r82.getInviteRole();
            if (r80 == null) goto L346;
            String r86 = r80.n;
            if (r86 == null) goto L346;
        L347:
            f21.a r87 = new f21.a(r85, r213, r130, r212, r214, false, false, r310, r312, r313, r311, r86, new f21.a.C0236a(0, false, null, r129, r22, 23), r22.getMultiLiveCoreInfo(), r22.getMultiRtcInfo(), null, r410, r22.getLayoutInfo(), 1180128);
            Intrinsics.checkNotNullParameter(r2, "$this$connectionContext");
            sc0.a r88 = r2.getContext().sd();
            if ((r88 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.a) == true) goto L350;
            r88 = null;
        L350:
            com.bytedance.android.live.revlink.impl.control.launchcontext.a r89 = (com.bytedance.android.live.revlink.impl.control.launchcontext.a) r88;
            if (r89 == null) goto L353;
            r89.b = r87;
        L353:
            r2.h.getConnectionContext().setValue(com.bytedance.android.live.revlink.link.biz.service.i.i(r2));
            AnchorUILayoutManager r90 = r2.k;
            com.bytedance.android.livesdk.link.model.m r92 = r22.getLayoutInfo();
            if (r92 == null) goto L356;
            com.bytedance.android.live.revlink.link.core.service.r r93 = com.bytedance.android.live.revlink.link.core.service.c.b(r92);
        L357:
            r90.d(r93, "switch_scene link_switch_to_link");
            int r94 = f31.g.c;
            f21.a r95 = com.bytedance.android.live.revlink.link.biz.service.i.i(r2);
            if (r95 != null) goto L360;
            f31.g r96 = null;
        L361:
            PushModeManagerService r133 = r2.l;
            if (r96 == null) goto L368;
            v1 r97 = r96.a;
            if (r97 == null) goto L368;
            o1 r98 = r97.getMultiAnchorLinkMicRtcInfo();
            if (r98 == null) goto L368;
            Map r134 = r98.getPushStreamModeRTCMap();
        L369:
            if (r96 == null) goto L375;
            u1 r99 = r96.b;
            if (r99 == null) goto L375;
            p1 r100 = r99.getMultiAnchorLiveCoreInfo();
            if (r100 == null) goto L375;
            Map r135 = r100.getPushStreamModeLiveCoreMap();
        L376:
            if (r96 == null) goto L382;
            v1 r101 = r96.a;
            if (r101 == null) goto L382;
            o1 r102 = r101.getMultiAnchorLinkMicRtcInfo();
            if (r102 == null) goto L382;
            Map r136 = r102.getRtcInfoMap();
        L383:
            if (r96 == null) goto L389;
            u1 r103 = r96.b;
            if (r103 == null) goto L389;
            p1 r104 = r103.getMultiAnchorLiveCoreInfo();
            if (r104 == null) goto L389;
            Map r137 = r104.getLiveCoreExtInfoMap();
        L390:
            PushModeManagerService.d(r133, r134, r135, r136, r137, "onLinkSwitchToLink");
            jy0.b.f("ttlive_anchor_link", "onLinkSwitchToLink " + com.bytedance.android.live.revlink.link.biz.service.i.i(r2), null, 4);
            if (r0 == null) goto L400;
            if (((int) r0.getMatchType()) != 6) goto L400;
            AnchorUILayoutManager r105 = r2.k;
            com.bytedance.android.livesdk.link.model.m r106 = r22.getLayoutInfo();
            if (r106 == null) goto L397;
            com.bytedance.android.live.revlink.link.core.service.r r107 = com.bytedance.android.live.revlink.link.core.service.c.b(r106);
        L398:
            r105.d(r107, "switch_scene_team_random");
            goto L400
        L397:
            r107 = null;
        L400:
            if (p9.b(r22) == false) goto L410;
            d31.b r108 = com.bytedance.android.live.revlink.link.biz.service.i.C(r2);
            String r109 = r22.getBattleAttachedInfoStr();
            if (r109 == null) goto L408;
            p0 r138 = e21.c.c(r111, r109);
            if (r138 != null) goto L409;
            com.bytedance.android.live.revlink.impl.control.launchcontext.a r139 = com.bytedance.android.live.revlink.link.biz.service.i.x(r2);
            if (r139 == null) goto L408;
            r138 = r139.d;
        L409:
            r108.a(null, r138, r22.getEventTrackingInfo());
            MultiRTCBizComponent r140 = r2.j;
            com.bytedance.android.live.revlink.link.biz.service.i.m(r2).c();
            r140.f.getClass();
        L408:
            r138 = null;
        L410:
            b7 r141 = com.bytedance.android.live.revlink.link.biz.service.i.A(r2).f();
            if (r141 != null) goto L413;
        L425:
            MultiRTCBizComponent r142 = r2.j;
            r142.getClass();
            Intrinsics.checkNotNullParameter("switch_channel", "source");
            r142.f.b("switch_channel");
            if (r0 != null) goto L428;
        L438:
            d31.f r143 = com.bytedance.android.live.revlink.link.biz.service.i.b0(r2);
            if (r0 == null) goto L441;
            int r144 = (int) r0.getMatchType();
        L442:
            if (r0 == null) goto L444;
            Integer r145 = Integer.valueOf(r0.getInviteRole());
        L445:
            String r146 = String.valueOf(r145);
            if (p9.b(r22) == false) goto L448;
            String r147 = "switch_channel";
        L449:
            d31.f.f(r143, "link_switch_link", 0, null, 0, r144, r146, null, r147, 78);
            return;
        L448:
            r147 = r411;
            goto L449
        L444:
            r145 = null;
            goto L445
        L441:
            r144 = -1;
            goto L442
        L428:
            if (com.bytedance.android.live.revenuelink.connect.b.c(r0) != true) goto L438;
            AnchorUILayoutManager r148 = r2.k;
            com.bytedance.android.livesdk.link.model.m r149 = r22.getLayoutInfo();
            if (r149 == null) goto L432;
            com.bytedance.android.live.revlink.link.core.service.r r150 = com.bytedance.android.live.revlink.link.core.service.c.b(r149);
        L433:
            r148.d(r150, "switch_scene_relink");
            RelinkDataContext r151 = com.bytedance.android.live.revlink.link.biz.service.i.X(r2);
            if (r151 == null) goto L438;
            com.bytedance.live.datacontext.k<o9> r152 = r151.getRelinkSwitchSuccess();
            if (r152 == null) goto L438;
            r152.post(r22);
            goto L438
        L432:
            r150 = null;
            goto L433
        L413:
            if (r141.getUseMultiChannel() == false) goto L425;
            if (r2.c == true) goto L425;
            Map<Long, String> r153 = r141.getChannelMap();
            if (r153 == null) goto L419;
            r2.f.a1(r153, "switchChannel", String.valueOf(r2.getContext().d.p));
        L419:
            MultiLinkAnchorControlContext r154 = com.bytedance.android.live.revlink.link.biz.service.i.G(r2);
            if (r154 == null) goto L422;
            UnexpectedFrameMonitor r155 = r154.getUnexpectedFrameMonitor();
        L423:
            if (r155 == null) goto L425;
            r155.o("switchChannel");
            goto L425
        L422:
            r155 = null;
        L389:
            r137 = null;
        L382:
            r136 = null;
        L375:
            r135 = null;
        L368:
            r134 = null;
            goto L369
        L360:
            r96 = new f31.g(r95.q, r95.p);
            goto L361
        L356:
            r93 = null;
        L346:
            r86 = "link_banner";
        L326:
            if (r131 != 2) goto L328;
        L331:
            boolean r156 = true;
        L332:
            if (r156 == false) goto L334;
            String r157 = r74;
        L341:
            r214 = r157;
            goto L342
        L334:
            com.bytedance.android.live.revlink.impl.global.c r158 = r79.a;
            if (r158 == null) goto L337;
            LinkCrossRoomDataHolder r159 = r158.getLinkCrossRoomDataHolder();
        L338:
            if (r159 == null) goto L340;
            r157 = r159.h();
            goto L341
        L340:
            r157 = r411;
            goto L341
        L337:
            r159 = null;
            goto L338
        L328:
            if (r131 == 4) goto L331;
            r156 = false;
            goto L332
        L317:
            r411 = "";
            if (r132.intValue() != 21) goto L320;
            r214 = "relink_player";
            goto L342
        L307:
            if (com.bytedance.android.live.revenuelink.connect.b.b(r128) == true) goto L310;
        L309:
            r312 = false;
        L299:
            r311 = "";
            goto L303
        L300:
            r311 = "relink_player";
            goto L303
        L301:
            r311 = "relink_team";
            goto L303
        L286:
            if (r80.d != 1) goto L288;
            boolean r160 = false;
        L289:
            r212 = r160;
            goto L292
        L288:
            r160 = r80.a;
            goto L289
        L283:
            if (((int) r82.getMatchType()) != 6) goto L290;
        L275:
            if (((int) r0.getMatchType()) != 21) goto L277;
            r2.h.getInviteType().setValue(21);
            goto L277
        L271:
            if (((int) r0.getMatchType()) != 20) goto L273;
            r2.h.getInviteType().setValue(20);
            goto L277
        L266:
            r78 = null;
            goto L267
        L263:
            r77 = null;
            goto L264
        L240:
            if (r75 == 5) goto L257;
            if (r75 != 6) goto L243;
            r2.h.getConnectionSubType().setValue("random_npk");
            goto L260
        L243:
            if (r75 != 11) goto L245;
            r2.h.getConnectionSubType().setValue("random_individual");
            goto L260
        L245:
            if (r75 == 20) goto L248;
            if (r75 != 21) goto L260;
        L248:
            Intrinsics.checkNotNullParameter(r22, "$this$linkedUserSize");
            List r161 = r22.getLinkedUsers();
            if (r161 == null) goto L251;
            int r162 = r161.size();
        L253:
            if (r162 <= 2) goto L260;
            r2.h.getConnectionSubType().setValue("manual_nlink");
            goto L260
        L251:
            r162 = 0;
            goto L253
        L257:
            r2.h.getConnectionSubType().setValue("manual_nlink");
            goto L260
        L236:
            r74 = r14;
            goto L237
        L230:
            if (r72 == 4) goto L233;
            r73 = false;
            goto L234
        L259:
            r74 = r14;
            goto L260
        L103:
            r2.h.setMultiChannelInfo(r22.getMultiChannelInfo(), true);
            goto L104
        L90:
            r25 = null;
            goto L92
        L59:
            if (com.bytedance.android.live.revenuelink.connect.b.c(p9.a(r22)) == true) goto L61;
        L77:
            jy0.b.c("ttlive_anchor_link", "switchChannel: " + r110 + "->" + r22.getToLinkerId(), null, 4);
            r2.h.getChannelId().setValue(Long.valueOf(r22.getToLinkerId()));
            com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r163 = r2.getContext();
            if ((r163 instanceof com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g) == true) goto L80;
            r163 = null;
        L80:
            if (r163 == null) goto L84;
            RevLinkBizContext r164 = r163.d;
            if (r164 == null) goto L84;
            r164.a(r22.getToLinkerId());
        L84:
            com.bytedance.android.live.revlink.impl.multianchor.service.a r165 = com.bytedance.android.live.revlink.link.biz.service.i.w(r2);
            if (r165 == null) goto L87;
            r165.S9(r22.getToLinkerId());
            goto L87
        L61:
            if (r110 != r22.getToLinkerId()) goto L77;
            Intrinsics.checkNotNullParameter(r2, "$this$relinkMonitor");
            e0 r166 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(r2).ti();
            r166.getClass();
            Intrinsics.checkNotNullParameter(r47, Constants.OperatorKey.MSG);
            JSONObject r167 = new JSONObject();
            q6 r168 = r47.getSwitchSceneContent();
            int r169 = y50.b.a;
            if (r168 == null) goto L73;
            o9 r170 = r168.getSwitchSceneData();
            if (r170 == null) goto L73;
            n1 r171 = r170.getMultiAnchorExtra();
            if (r171 == null) goto L69;
            y50.b.a.d(r167, "multi_anchor_extra", ef2.a.c(r171));
        L69:
            b7 r172 = r170.getMultiChannelInfo();
            if (r172 == null) goto L72;
            y50.b.a.d(r167, "multi_channel_info", c7.a(r172));
        L72:
            y50.b.a.d(r167, "multi_channel_version", String.valueOf(r170.getVersion()));
        L73:
            RelinkDataContext r173 = com.bytedance.android.live.revlink.link.biz.service.i.X(r166);
            if (r173 == null) goto L76;
            long r174 = r173.getRelinkSuccessTimestamp();
            i97.a r175 = i97.a.a;
            y50.b.a.c(r167, "relink_success_time_gap", System.currentTimeMillis() - r174);
        L76:
            com.bytedance.android.live.revlink.link.biz.service.i.H(r166).getClass();
            v.m(r47, r167);
            r166.c(r167);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r166).I("duplicate_switch_scene_msg", r167, false);
            return;
        L55:
            if (com.bytedance.android.live.revenuelink.connect.b.c(p9.a(r22)) == true) goto L56;
            return;
        L450:
            q6 r176 = r47.getSwitchSceneContent();
            if (r176 == null) goto L456;
            o9 r177 = r176.getSwitchSceneData();
            if (r177 == null) goto L456;
            if (r177.getToScene() != 1) goto L456;
            return;
        L456:
            jy0.b.c("ttlive_anchor_link", "abnormal switch scene msg", null, 4);
            return;
        L461:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i6) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiSwitchToPkImplV2$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo51/e;", "p1", "", "invoke", "(Lo51/e;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<o51.e, Unit> {
        public AnonymousClass2(MultiSwitchToPkImplV2 r8) {
            super(1, r8, MultiSwitchToPkImplV2.class, "onUILayoutChange", "onUILayoutChange(Lcom/bytedance/android/live/revlink/link/core/UILayout;)V", 0);
        }

        public final void invoke(o51.e r3) {
            MultiSwitchToPkImplV2 r0 = (MultiSwitchToPkImplV2) ((CallableReference) this).receiver;
            if (r3 == null) goto L8;
            r0.getClass();
            o51.f r4 = r3.a;
            if (r4 == null) goto L8;
            if (r4.b != UILayoutServerIndex.Normal.ordinal()) goto L8;
            return;
        L8:
            r0.a(7, false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((o51.e) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiSwitchToPkImplV2$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass3(MultiSwitchToPkImplV2 r8) {
            super(1, r8, MultiSwitchToPkImplV2.class, "onPKStateChange", "onPKStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r4) {
            MultiSwitchToPkImplV2 r5 = (MultiSwitchToPkImplV2) ((CallableReference) this).receiver;
            r5.getClass();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = com.bytedance.android.live.revlink.link.biz.service.i.S(r5);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.inClassicDoublePK() == true) goto L7;
            return;
        L7:
            if (((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(r5).a).size() > 2) goto L12;
            r5.a(1, true);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiSwitchToPkImplV2$attach$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass4(MultiSwitchToPkImplV2 r8) {
            super(2, r8, MultiSwitchToPkImplV2.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            MultiSwitchToPkImplV2 r5 = (MultiSwitchToPkImplV2) ((CallableReference) this).receiver;
            r5.getClass();
            if (r3.size() < 3) goto L5;
            r5.a(7, false);
            return;
        L5:
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = com.bytedance.android.live.revlink.link.biz.service.i.S(r5);
            if (r6 != null) goto L8;
            return;
        L8:
            if (r6.inClassicDoublePK() != true) goto L13;
            r5.a(1, false);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        Observable r0 = yz0.h.a.a(getContext().d.w, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new a(r1)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(getContext().d.i, new AnonymousClass2(this)), this.b);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r2 == null) goto L9;
        LiveData<PkBaseStateMachine.c> r3 = r2.getPkBaseState();
        if (r3 == null) goto L9;
        Disposable r4 = UtilsKt.d(r3, new AnonymousClass3(this));
        if (r4 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r4, this.b);
    L9:
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).m(new AnonymousClass4(this)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g getContext() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.d
    public final void startSwitchPk(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r32) {
        IRoom r2 = null;
        if (r32 == null) goto L11;
        r32.a = r32.a;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r3 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r3 == null) goto L9;
        com.bytedance.live.datacontext.n<p0> r4 = r3.getLaunchBattleAttachInfo();
        if (r4 == null) goto L9;
        p0 r5 = (p0) r4.getValue();
    L10:
        r32.i = r5;
        Unit r6 = Unit.INSTANCE;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r7 = r32;
    L12:
        this.g.j = true;
        CopyOnWriteArrayList r8 = (CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(this).a;
        Iterator r9 = r8.iterator();
        com.bytedance.android.livesdk.link.model.p r10 = null;
        long r13 = 0;
        int r17 = 0;
    L14:
        if (r9.hasNext() == false) goto L34;
        com.bytedance.android.livesdk.link.model.p r12 = (com.bytedance.android.livesdk.link.model.p) r9.next();
        IBaseUser r14 = r12.getUser();
        if (r14 == null) goto L18;
        String r15 = r14.getIdString();
    L19:
        IRoomBase r16 = this.e.getRoomContext().getCommonRoom();
        if ((r16 instanceof IRoom) == true) goto L22;
        r16 = null;
    L22:
        IRoom r18 = (IRoom) r16;
        if (r18 == null) goto L25;
        String r19 = IRoomKt_androidKt.getOwnerUserIdString(r18);
    L27:
        if ((!Intrinsics.areEqual(r15, r19)) == false) goto L14;
        com.bytedance.android.live.revenuelink.rtc.o r20 = this.f.L().k(r12.getLinkMicIdStr());
        if (r20 != null) goto L31;
    L33:
        IBaseUser r22 = r12.getUser();
        Intrinsics.checkNotNull(r22);
        r13 = com.bytedance.android.live.base.model.user.n.a(r22);
        r10 = r12;
        goto L14
    L31:
        if (r20.g != true) goto L33;
        r17 = 1;
        goto L33
    L25:
        r19 = null;
        goto L27
    L18:
        r15 = null;
        goto L19
    L34:
        String r110 = "";
        if (r8.size() == 2) goto L49;
        v r23 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        r23.getClass();
        LinkedHashMap r111 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r112 = r23.d;
        if (r112 == null) goto L39;
        IPKLinkBizDataService r113 = r112.mk();
    L40:
        if (r113 == null) goto L47;
        IPKLinkBizDataService.c r114 = r113.getGuestInfo();
        if (r114 == null) goto L47;
        IBaseUser r115 = r114.c;
        if (r115 == null) goto L47;
        String r116 = r115.toString();
        if (r116 == null) goto L47;
    L48:
        r111.put("pk_guest_user", r116);
        r23.b(r111);
        r23.f(r111);
        int r24 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "switch_to_pk_state_error: " + r111, null);
    L47:
        r116 = "";
        goto L48
    L39:
        r113 = null;
    L49:
        IPKLinkBizDataService r25 = com.bytedance.android.live.revlink.link.biz.service.i.P(this);
        if (r25 == null) goto L79;
        if (r7 == null) goto L77;
        r7.b = r10;
        String r117 = com.bytedance.android.live.revlink.link.biz.service.i.A(this).c();
        if (r117 != null) goto L55;
        r117 = "";
    L55:
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        f21.a r118 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r118 == null) goto L59;
        String r119 = r118.m;
        if (r119 == null) goto L59;
    L60:
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r120 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r120 == null) goto L67;
        com.bytedance.live.datacontext.m<Integer> r121 = r120.getInviteType();
        if (r121 == null) goto L67;
        Integer r122 = (Integer) r121.getValue();
        if (r122 == null) goto L67;
        int r123 = r122.intValue();
    L68:
        r7.e = r123;
        f21.a r124 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r124 == null) goto L71;
        long r125 = r124.s;
    L73:
        if (r125 <= 0) goto L75;
        com.bytedance.android.live.revlink.link.biz.service.i.i(this);
    L76:
        com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        String r26 = this.g.d;
        Unit r27 = Unit.INSTANCE;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r28 = r7;
    L78:
        r25.switchFromLink(r28);
        goto L79
    L75:
        long r29 = this.g.h;
        goto L76
    L71:
        r125 = 0;
    L67:
        r123 = 0;
    L59:
        r119 = "";
        goto L60
    L77:
        r28 = null;
    L79:
        com.bytedance.android.live.revenuelink.rtc.i r30 = this.f;
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        r30.i(false);
        if (((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(this).a).size() != 2) goto L82;
        int r33 = this.g.e;
        jy0.b.d("ttlive_anchor_link", "updateCrossRoomStats targetRoomId=" + r13 + " guestIsBackground=" + r33);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(getContext().getLinkNetwork().g(com.bytedance.android.live.revlink.link.biz.service.i.A(this).a(), getContext().d.m, r13, r17, r33)).subscribe(q.a, r.a), this.b);
    L82:
        com.bytedance.android.live.revenuelink.i.d r34 = com.bytedance.android.live.revenuelink.i.d.b;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r35 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r35 == null) goto L87;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revenuelink.i> r36 = r35.getUnloadSource();
        if (r36 == null) goto L87;
        r36.setValue(r34);
    L87:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r37 = com.bytedance.android.live.revlink.link.biz.service.i.w(this);
        if (r37 == null) goto L90;
        r37.vo("switchToPk", r34);
    L90:
        y41.e r38 = y41.e.o;
        r38.getClass();
        if (((Boolean) y41.e.n.getValue(r38, y41.e.a[12])).booleanValue() == false) goto L95;
        IPKLinkBizDataService r39 = com.bytedance.android.live.revlink.link.biz.service.i.P(this);
        if (r39 == null) goto L95;
        r39.switchFromLink();
    L95:
        com.bytedance.android.live.revlink.impl.service.internal.a r40 = com.bytedance.android.live.revlink.link.biz.service.i.p(this);
        if (r40 == null) goto L127;
        int r42 = RevLinkSwitchExtraContext.g;
        long r43 = com.bytedance.android.live.revlink.link.biz.service.i.d(this).getChannelId();
        com.bytedance.android.live.revlink.impl.pk.service.d r44 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).h();
        if (r44 == null) goto L103;
        String r45 = r44.linkmicId();
        if (r45 == null) goto L103;
        String r46 = r45;
    L104:
        String r126 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).c();
        PkAnchorLaunchType r127 = PkAnchorLaunchType.SWITCH_FROM_LINK;
        com.bytedance.android.live.revlink.impl.pk.service.d r47 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).h();
        if (r47 == null) goto L107;
        v1 r128 = r47.multiRtcInfo();
    L108:
        com.bytedance.android.live.revlink.impl.pk.service.d r48 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).h();
        if (r48 == null) goto L111;
        d7 r129 = r48.multiLiveCoreInfo();
    L112:
        if (r7 == null) goto L116;
        o9 r49 = r7.a;
        if (r49 == null) goto L116;
        com.bytedance.android.livesdk.link.model.m r130 = r49.getLayoutInfo();
    L117:
        if (r7 == null) goto L119;
        p0 r131 = r7.i;
    L120:
        if (r7 == null) goto L124;
        o9 r50 = r7.a;
        if (r50 == null) goto L124;
        String r132 = r50.getEventTrackingInfo();
    L125:
        r40.Gp(4, RevLinkSwitchExtraContext.Companion.c(r43, r46, r126, r127, r128, r129, r130, r131, r132));
    L124:
        r132 = null;
        goto L125
    L119:
        r131 = null;
    L116:
        r130 = null;
        goto L117
    L111:
        r129 = null;
        goto L112
    L107:
        r128 = null;
    L103:
        r46 = "";
    L127:
        if (this.g.d != null) goto L129;
        BizType r52 = BizType.PK;
    L130:
        r52.ordinal();
        this.g.d = null;
        if (r7 == null) goto L133;
        PkDoubleAnchorDataContext.d r53 = r7.c;
    L134:
        Intrinsics.checkNotNullParameter(this, "$this$pKCustomizePlayDataService");
        com.bytedance.android.live.revlink.impl.pk.service.c r54 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).Yi();
        if (r54 == null) goto L139;
        PkCustomizePlayDataContext.a r55 = r54.getCustomizePkSelfData();
        if (r55 == null) goto L139;
        u2 r56 = r55.a;
    L140:
        if (r7 == null) goto L142;
        w2 r57 = r7.f;
    L143:
        if (r7 == null) goto L145;
        boolean r58 = r7.g;
    L146:
        if (r7 == null) goto L150;
        IBattleConfigSetting r59 = r7.h;
        if (r59 == null) goto L150;
        h9 r60 = r59.getSpecifyGiftConfig();
    L151:
        if (r7 == null) goto L153;
        IBattleConfigSetting r133 = r7.h;
    L154:
        if (r53 == null) goto L157;
        long r134 = r53.a;
    L156:
        long r210 = r134;
        if (r7 == null) goto L162;
        int r135 = r7.e;
    L164:
        if (u41.a.c.a() == false) goto L166;
        int r136 = com.bytedance.android.live.revenue.common.h.a;
        r110 = com.bytedance.android.live.revenue.common.h.a(String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.d(this).getChannelId()) + com.bytedance.android.live.revlink.link.biz.service.i.T(this).a() + DataType.FALSE + r135);
    L166:
        String r211 = r110;
        Intrinsics.checkNotNullParameter(this, "$this$mergePKHelper");
        d21.d r137 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).getMergePkHelper();
        if (r7 == null) goto L169;
        int r138 = r7.d;
    L170:
        r137.getClass();
        BattleInviteType r212 = d21.d.d(r138);
        if (r7 == null) goto L173;
        IBattleConfigSetting r213 = r7.h;
    L174:
        c21.e.a r139 = new c21.e.a(r210, 1, null, r212, null, r211, null, r213, 212);
        if (r53 == null) goto L177;
        aa r62 = r53.b;
    L178:
        if (r62 == null) goto L180;
        c21.e r63 = new c21.e(r139, new c21.f.m(1, r53.b), "Vote");
    L203:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r64 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r64 == null) goto L208;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r65 = r64.getPkAnchorLauncher();
        if (r65 == null) goto L208;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r65, r63, null, null, 6);
    L208:
        z41.g r66 = z41.g.o;
        r66.getClass();
        if (((Boolean) z41.g.g.getValue(r66, z41.g.a[5])).booleanValue() == false) goto L211;
        a(1, false);
    L211:
        if (r32 == null) goto L213;
        PkDoubleAnchorDataContext.d r67 = r32.c;
    L214:
        if (r67 == null) goto L230;
        Intrinsics.checkNotNullParameter(this, "$this$linkStartLogger");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g r68 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).Yg();
        IRoom r69 = this.e.getRoomContext().getCommonRoom();
        if ((r69 instanceof IRoom) == false) goto L219;
        r2 = r69;
    L219:
        IRoom r70 = r2;
        if (r32.d != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_MultipleMatches3.ordinal()) goto L222;
        String r1 = "2in3pk";
    L223:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g.a(r68, r70, true, r1, false, false, 56);
        return;
    L222:
        r1 = "routine_pk";
        goto L223
    L230:
        return;
    L213:
        r67 = null;
        goto L214
    L180:
        if (r56 == null) goto L182;
        r63 = new c21.e(r139, new c21.f.d(1, PlayMode.PERSONAL_PK, r56, null), "CustomPlay");
        goto L203
    L182:
        if (r57 == null) goto L184;
        r63 = new c21.e(r139, new c21.f.k(1, PlayMode.PERSONAL_PK, r57), "ShellPk");
        goto L203
    L184:
        if (r58 == false) goto L186;
        r63 = new c21.e(r139, new c21.f.a(1, null), "BreakThrough");
        goto L203
    L186:
        if (r60 == null) goto L188;
        r63 = new c21.e(r139, new c21.f.l(1, PlayMode.PERSONAL_PK, r60), "SpecifyGiftPk");
        goto L203
    L188:
        if (r133 == null) goto L193;
        if (r133.getModType() != PkBaseDataContext.PKModType.Custom.getType()) goto L193;
        r63 = new c21.e(r139, new c21.f.g(1, PlayMode.PERSONAL_PK, r133.getCustomConfig()), "NewCustomPlay");
    L193:
        if (r133 != null) goto L195;
    L197:
        if (r133 != null) goto L199;
    L201:
        c21.e r72 = new c21.e(r139, new c21.f.h(1, PlayMode.PERSONAL_PK), "NormalPk");
    L202:
        r63 = r72;
        goto L203
    L199:
        if (r133.getModType() != PkBaseDataContext.PKModType.CloudCollaborate.getType()) goto L201;
        r63 = new c21.e(r139, new c21.f.b(1, PlayMode.PERSONAL_PK, r133.getCloudCollaborateConfig()), "CloudCollaborate");
        goto L203
    L195:
        if (r133.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L197;
        r72 = new c21.e(r139, c21.f.j.b, "NormalPk");
        goto L202
    L177:
        r62 = null;
        goto L178
    L173:
        r213 = null;
        goto L174
    L169:
        r138 = 0;
        goto L170
    L162:
        r135 = 0;
        goto L164
    L157:
        if (r56 == null) goto L159;
        r134 = r56.getPkCustomDuration();
        goto L156
    L159:
        r134 = l51.a.j();
        goto L156
    L153:
        r133 = null;
    L150:
        r60 = null;
        goto L151
    L145:
        r58 = false;
        goto L146
    L142:
        r57 = null;
    L139:
        r56 = null;
        goto L140
    L133:
        r53 = null;
        goto L134
    L129:
        r52 = BizType.OpenGame;
    L9:
        r5 = null;
        goto L10
    L11:
        r7 = null;
        goto L12
    }

    public final void a(int r17, boolean r18) {
        if (r17 != 1) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
    L22:
        if (r3 == true) goto L24;
        return;
    L24:
        if (getContext().d.o != 7) goto L34;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "refreshClassicScene  switch to double", null, 4);
        com.bytedance.android.live.revlink.impl.service.internal.a r4 = com.bytedance.android.live.revlink.link.biz.service.i.p(this);
        if (r4 == null) goto L28;
        int r5 = RevLinkAnchorLaunchParam.q;
        r4.Gp(4, new RevLinkSwitchExtraContext(null, null, null, RevLinkAnchorLaunchParam.Companion.a(1, getContext().d.p, !r18), null, 47));
    L28:
        AnchorUILayoutManager r2 = this.k;
        int r6 = UILayoutServerIndex.Normal.ordinal();
        int r7 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown.ordinal();
        int r8 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationUnknown.ordinal();
        com.bytedance.android.live.revlink.link.core.service.o r9 = (com.bytedance.android.live.revlink.link.core.service.o) getContext().b.getValue();
        if (r9 != null) goto L31;
        r9 = new com.bytedance.android.live.revlink.link.core.service.o(com.bytedance.revenue.platform.api.core.d.a(new Pair[0]));
    L31:
        r2.d(new com.bytedance.android.live.revlink.link.core.service.r(r6, r7, r8, false, "", r9), "switch_to_pk");
        return;
    L34:
        return;
    L9:
        if (getContext().d.o != 1) goto L22;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "refreshClassicScene  switch to multi", null, 4);
        this.g.a = true;
        Intrinsics.checkNotNullParameter(this, "$this$pKCustomizePlayDataService");
        com.bytedance.android.live.revlink.impl.pk.service.c r10 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).Yi();
        if (r10 == null) goto L13;
        r10.reset();
    L13:
        vh6.c.b(qr2.c.class).markSwitchToMulti(true);
        com.bytedance.android.live.revenuelink.rtc.i r12 = this.f;
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        r12.i(false);
        com.bytedance.android.live.revlink.impl.service.internal.a r13 = com.bytedance.android.live.revlink.link.biz.service.i.p(this);
        if (r13 == null) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.d r14 = com.bytedance.android.live.revlink.link.biz.service.i.T(this).h();
        if (r14 == null) goto L18;
        r14.setUnLoadSource(m41.b.C0272b.c);
    L18:
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r13, 4, true, 4);
    L19:
        com.bytedance.android.live.revlink.impl.service.internal.a r15 = com.bytedance.android.live.revlink.link.biz.service.i.p(this);
        if (r15 == null) goto L22;
        int r16 = RevLinkAnchorLaunchParam.q;
        r15.Gp(64, new RevLinkSwitchExtraContext(null, null, null, RevLinkAnchorLaunchParam.Companion.a(7, getContext().d.p, true), null, 47));
        goto L22
    L5:
        r3 = false;
        goto L7
    }

    public MultiSwitchToPkImplV2(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3, com.bytedance.android.live.revenuelink.rtc.i r4, h r5, MultiAnchorLinkContext r6, MultiPKContextHolder r7, MultiRTCBizComponent r8, AnchorUILayoutManager r9, PushModeManagerService r10, AutoStartPKComponent r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "rtcManager");
        Intrinsics.checkNotNullParameter(r5, "bizDataContext");
        Intrinsics.checkNotNullParameter(r6, "linkContext");
        Intrinsics.checkNotNullParameter(r7, "pkContextHolder");
        Intrinsics.checkNotNullParameter(r8, "multiRTCBizComponent");
        Intrinsics.checkNotNullParameter(r9, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r10, "pushModeManagerService");
        Intrinsics.checkNotNullParameter(r12, "autoStartPKComponent");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.a = "MultiSwitchToPkImpl";
        this.b = new CompositeDisposable();
        this.c = AnchorRtcConnectUtilsKt.f();
    }
}
