package com.bytedance.android.live.multilink.impl.control;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.h;
import com.bytedance.android.live.liveinteract.plantform.utils.i;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.multilink.common.message.MultiLinkMessageTypeKt;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.multilink.impl.control.anchor.MultiControlAnchorService;
import com.bytedance.android.live.multilink.impl.control.setting.FetchSettingType;
import com.bytedance.android.live.multilink.impl.w;
import com.bytedance.android.live.profit.dress.config.LinkmicPlayMode;
import com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent;
import com.bytedance.android.livesdk.chatroom.model.interact.s;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.message.model.e9;
import com.bytedance.android.livesdk.utils.b5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUILayoutChangeContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.kmp.util.KmpToastUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import gd0.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import rj0.l;
import yz0.f;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiControlService implements com.bytedance.android.live.multilink.impl.control.a {
    public final BehaviorSubject<fn0.a> a;
    public int b;
    public com.bytedance.android.live.multilink.impl.control.anchor.d c;
    public final MultiControlAnchorService d;
    public final tc0.b e;
    public final g f;
    public final jn0.b g;
    public final hd0.b h;
    public final j i;
    public final gn0.b j;
    public final f k;
    public final CompositeDisposable l;
    public long m;
    public final com.bytedance.android.live.multilink.impl.control.b n;
    public final bn0.b o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiControlService a;

        public b(MultiControlService r1) {
            this.a = r1;
        }

        public final void accept(Object r29) {
            com.bytedance.android.live.liveinteract.multianchor.model.b r0 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r29;
            MultiControlService r2 = this.a;
            r2.getClass();
            int r4 = (int) r0.getType2();
            if (r4 != 1) goto L5;
            IRoomBase r5 = null;
            StringBuilder r8 = new StringBuilder("TYPE_TURN_ON layout=");
            Intrinsics.checkNotNullParameter(r0, "$this$layoutExt");
            r8.append(r0.getLayout());
            r8.append(" sceneInfo=");
            Intrinsics.checkNotNullParameter(r0, "$this$sceneLayoutInfoExt");
            r8.append(r0.getSceneLayoutInfo());
            jy0.b.d("ttlive_link", r8.toString());
            g r6 = r2.f;
            if (r6 == null) goto L157;
            IRoomBase r7 = r6.getRoom();
        L159:
            if ((r7 instanceof IRoom) == true) goto L162;
            r7 = null;
        L162:
            if (je0.e.c(r0, (IRoom) r7) == false) goto L168;
            if (r2.b() == false) goto L166;
            r2.j.b(FetchSettingType.onReceiveTurnOnMessage);
        L166:
            int r9 = 8;
        L209:
            if (r9 == 8) goto L211;
        L212:
            r2.j.c(FetchSettingType.onReceiveTurnOnMessage);
        L213:
            Intrinsics.checkNotNullParameter(r0, "$this$validSceneExt");
            fn0.a r10 = new fn0.a(r9, r0.getValidScene(), r0.getUiLayout(), CollectionsKt.toList(r0.getPlayModes()));
            r2.a(r10);
            com.bytedance.android.live.multilink.impl.control.anchor.d r3 = r2.c;
            if (r3 == null) goto L284;
            LinkMultiControlPresenter r11 = (LinkMultiControlPresenter) r3;
            i.g(r0);
            if (r11.j == false) goto L218;
        L223:
            boolean r12 = true;
        L224:
            r11.l = r12;
            if (r11.w.getRoom() == null) goto L238;
            if (r11.w.getRoom().getValue() == null) goto L238;
            if (((IRoom) r11.w.getRoom().getValue()).getLinkerDetail() == null) goto L238;
            if (r0.getPlayModes() == null) goto L238;
            ArrayList r13 = new ArrayList();
            Iterator r14 = r0.getPlayModes().iterator();
        L234:
            if (r14.hasNext() == false) goto L236;
            r13.add(Long.valueOf(((Integer) r14.next()).intValue()));
            goto L234
        L236:
            ((IRoom) r11.w.getRoom().getValue()).getLinkerDetail().setPlayModes(r13);
        L238:
            if (r0.getLinkerBaseInfo() == null) goto L240;
            i0 r15 = TalkRoomLogUtils.a;
            TalkRoomLogUtils.s1(r0.getLinkerBaseInfo().getAnchorManualOpenUiLayout(), false);
            ALogger.i("AnchorManualUiLayout", "turnOnMessage, currentManualUiLayout=" + r0.getLinkerBaseInfo().getAnchorManualOpenUiLayout() + ", lastManualUiLayout=" + TalkRoomLogUtils.b.b);
        L240:
            int r16 = r10.a;
            if (r16 != 8) goto L261;
            boolean r17 = r11.j;
            if (r17 == true) goto L286;
            u r18 = r11.m;
            if (r18 == null) goto L259;
            if (r17 == true) goto L259;
            if (r18.I1() == null) goto L255;
            if (r0.getScene() != 9) goto L253;
            r11.m.I1().setValue(Boolean.TRUE);
            goto L255
        L253:
            r11.m.I1().setValue(Boolean.FALSE);
        L255:
            if (r11.m.s() == null) goto L259;
            if (r11.m.s().getValue() == null) goto L259;
            r11.I0();
            ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r11.m.s().getValue()).d(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r10.b, r10.c, r10.d, false, false, r0.getClientUIInfo()));
        L259:
            ((q46.b) r11).a.wu(8, MultiLinkOpenSource.MESSAGE);
        L271:
            if (r11.j == true) goto L273;
            LinkMultiControlPresenter.H0("apply_success", "");
        L273:
            HashMap r19 = new HashMap();
            r19.put("room_id", r11.i.getIdStr());
            r19.put("event", "LinkControlPresenter LinkMicMessageExtra.TYPE_TURN_ON");
            r19.put("anchor_id", String.valueOf(r11.i.getOwnerUserIdString()));
            b0.o().j("ttlive_pk", r19);
            wf0.b.g(r0.getValidScene());
            return;
        L286:
            return;
        L261:
            if (r16 != 2) goto L263;
            ((q46.b) r11).a.wu(2, MultiLinkOpenSource.MESSAGE);
            goto L271
        L263:
            if (r16 != 32) goto L271;
            if (r11.m.getVideoTalkRoomSubScene() != null) goto L267;
        L269:
            ((q46.b) r11).a.Gl(r0.getValidScene(), r0.getPlayModes(), r0.getUiLayout());
            ((q46.b) r11).a.wu(32, MultiLinkOpenSource.MESSAGE);
            goto L271
        L267:
            if (r11.m.getVideoTalkRoomSubScene().getValue() == null) goto L269;
            ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r11.m.getVideoTalkRoomSubScene().getValue()).e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r10.b, r10.d, r10.c, false, r0.getClientUIInfo()));
            goto L269
        L218:
            if (k.f(IInteractService.class) == null) goto L223;
            ((IInteractService) k.f(IInteractService.class)).updateVideoTalkRoomOpenSource(r0.getFunctionType2());
            if ("pre_apply_chat_room".equals(r0.getOpenSource()) == false) goto L222;
            r12 = true;
            us1.e.a = true;
            goto L224
        L222:
            r12 = true;
            us1.e.a = false;
            goto L224
        L284:
            return;
        L211:
            if (r2.b() == true) goto L213;
        L168:
            if (je0.e.a(r0) == true) goto L170;
            g r20 = r2.f;
            if (r20 == null) goto L178;
            IRoomBase r21 = r20.getRoom();
        L180:
            if ((r21 instanceof IRoom) == false) goto L184;
            r5 = r21;
        L184:
            if (je0.e.b(r0, (IRoom) r5) == true) goto L186;
        L208:
            r9 = 0;
            goto L209
        L186:
            if (r2.b() == true) goto L208;
            tc0.b r22 = r2.e;
            if (r22 == null) goto L191;
            r22.v6(r0.isSupportCamera());
        L191:
            if (r2.b() == true) goto L207;
            ((LinkMultiControlPresenter) r2.n).getClass();
            if (k.f(IInteractService.class) != null) goto L195;
        L197:
            boolean r23 = false;
        L198:
            if (r23 == false) goto L201;
            KmpToastUtil.a("主播开启了观众连线", 0);
            goto L207
        L201:
            if (r0.getUiLayout() != 63) goto L204;
            KmpToastUtil.a("主播开启了合唱玩法", 0);
            goto L207
        L204:
            if (r0.getPlayModes().contains(Integer.valueOf(LinkmicPlayMode.REALTIME_CHORUS_CONCERT.getValue())) == false) goto L206;
            KmpToastUtil.a("主播开启了合唱模式", 0);
            goto L207
        L206:
            KmpToastUtil.a("主播开启了聊天室", 0);
            goto L207
        L195:
            if (((IInteractService) k.f(IInteractService.class)).dynamicFromAudience() == false) goto L197;
            r23 = true;
        L207:
            r9 = 32;
            goto L209
        L178:
            r21 = null;
            goto L180
        L170:
            if (r0.getInitSource() == 1) goto L172;
        L174:
            r9 = 2;
            goto L209
        L172:
            if (r2.b() == true) goto L174;
            KmpToastUtil.a("主播开启了观众连线", 0);
            goto L174
        L157:
            r7 = null;
            goto L159
        L5:
            if (r4 == 4) goto L132;
            if (r4 != 17) goto L285;
            StringBuilder r24 = new StringBuilder("TYPE_SWITCH_SCENE layout=");
            Intrinsics.checkNotNullParameter(r0, "$this$layoutExt");
            r24.append(r0.getLayout());
            r24.append(" sceneInfo=");
            Intrinsics.checkNotNullParameter(r0, "$this$sceneLayoutInfoExt");
            r24.append(r0.getSceneLayoutInfo());
            jy0.b.c("ttlive_link", r24.toString(), null, 4);
            TalkRoomBusinessFullLinkMonitor r25 = TalkRoomBusinessFullLinkMonitor.a;
            com.bytedance.android.live.liveinteract.multianchor.model.b r26 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r0.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
            r25.getClass();
            Intrinsics.checkNotNullParameter(r26, "linkMicMessage");
            JSONObject r27 = new JSONObject();
            r27.put("msg_id", yh6.d.a(r26));
            pd0.b r28 = pd0.b.a;
            Intrinsics.checkNotNullParameter(r26, "$this$validSceneExt");
            r27.put("to_scene", pd0.b.e(r26.getValidScene()));
            r27.put("to_ui_layout", pd0.b.f(r26.getUiLayout()));
            r27.put("rtc_ext_info", r26.getRtcExtInfo());
            r27.put("live_core_ext_info", r26.getLiveCoreExtInfo());
            r27.put("multi_rtc_info", GsonProtectorUtils.toJson(l97.a.a, r26.getMultiRtcInfo()));
            r27.put("multi_live_core_info", GsonProtectorUtils.toJson(l97.a.a, r26.getMultiLiveCoreInfo()));
            r27.put("mcu_content", GsonProtectorUtils.toJson(l97.a.a, r26.getMcuContent()));
            if (nd0.e.b() != true) goto L12;
        L16:
            nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveSwitchSceneMsgMonitorData, r27, 0, null, false, 28);
            List<Integer> r30 = r26.getPlayModes();
            if (r30 != null) goto L19;
        L21:
            boolean r31 = false;
        L22:
            if (r31 == false) goto L25;
            Intrinsics.checkNotNullParameter(r26, "$this$messageIdExt");
            TalkRoomBusinessFullLinkMonitor.a(r26.getMessageId2(), r27);
        L25:
            if (((Boolean) vm2.e.V.getValue(null, vm2.e.a[46])).booleanValue() == true) goto L27;
        L29:
            r2.m = r0.getVersion();
            String r32 = r0.getRtcExtInfo();
            if (r32 != null) goto L32;
            String r110 = "";
        L33:
            tc0.b r33 = r2.e;
            if (r33 == null) goto L36;
            r33.setRtcExtInfo(r110);
        L36:
            v r34 = r0.getChorusCDNInfo();
            if (r34 == null) goto L41;
            tc0.b r35 = r2.e;
            if (r35 == null) goto L41;
            r35.setChorusCDNInfo(r34);
        L41:
            tc0.b r36 = r2.e;
            if (r36 == null) goto L45;
            r36.setRtcExtInfo(r110);
        L45:
            if (r0.getMultiRtcInfo() != null) goto L47;
        L51:
            Map r37 = null;
        L52:
            Map r38 = r0.getLinkerContentMap();
            if (r38 == null) goto L57;
            tc0.b r39 = r2.e;
            if (r39 == null) goto L57;
            r39.Cl(r38);
        L57:
            e0 r40 = r0.getMcuContent();
            tc0.b r41 = r2.e;
            if (r41 == null) goto L60;
            r41.setMcuContent(r40);
        L60:
            StringBuilder r42 = new StringBuilder("msgid: ");
            Intrinsics.checkNotNullParameter(r0, "$this$messageIdExt");
            r42.append(r0.getMessageId2());
            r42.append(" type switch scene ");
            r42.append(r0.getScene());
            r42.append(" layout ");
            Intrinsics.checkNotNullParameter(r0, "$this$layoutExt");
            r42.append(r0.getLayout());
            jy0.b.a(LinkRoomFightContext.TAG, r42.toString());
            jy0.b.a(LinkRoomFightContext.TAG, "rtcExtInfo ".concat(r110));
            jy0.b.a(LinkRoomFightContext.TAG, "multiRtcInfo " + r37);
            jy0.b.a(LinkRoomFightContext.TAG, "roomLinkerInfo " + r38);
            jy0.b.a(LinkRoomFightContext.TAG, "mcuContent " + r40);
            com.bytedance.android.live.multilink.impl.control.anchor.d r43 = r2.c;
            if (r43 == null) goto L277;
            LinkMultiControlPresenter r44 = (LinkMultiControlPresenter) r43;
            if (r44.j == true) goto L71;
            if (k.f(IInteractService.class) == null) goto L71;
            ((IInteractService) k.f(IInteractService.class)).updateVideoTalkRoomOpenSource(r0.getFunctionType2());
            if ("pre_apply_chat_room".equals(r0.getOpenSource()) == false) goto L69;
            us1.e.a = true;
            goto L71
        L69:
            us1.e.a = false;
        L71:
            if (r0.getLinkerBaseInfo() == null) goto L76;
            i0 r45 = TalkRoomLogUtils.a;
            h r46 = TalkRoomLogUtils.b;
            if (r46.a == r0.getLinkerBaseInfo().getAnchorManualOpenUiLayout()) goto L76;
            TalkRoomLogUtils.s1(r0.getLinkerBaseInfo().getAnchorManualOpenUiLayout(), false);
            ALogger.i("AnchorManualUiLayout", "switchSceneMessage currentManualUiLayout = " + r0.getLinkerBaseInfo().getAnchorManualOpenUiLayout() + ", lastManualUiLayout=" + r46.b);
        L76:
            if (r0.getScene() != 16) goto L92;
            zi0.e r47 = zi0.b.d;
            com.bytedance.android.livesdk.utils.ntp.e.a();
            r47.getClass();
            Intrinsics.checkNotNullParameter(r0, MultiLinkOpenSource.MESSAGE);
            if (zi0.b.b() == false) goto L92;
            JSONObject r48 = new JSONObject();
            zi0.c.a(r48, "msg_id", Long.valueOf(r0.getMessageId2()));
            String r49 = (String) r47.a.getSecond();
            m r50 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r50 == null) goto L85;
            IRoom r51 = (IRoom) r50.getValue();
            if (r51 == null) goto L85;
            String r52 = r51.getIdStr();
        L86:
            zi0.c.a(r48, "is_inviter", Boolean.valueOf(Intrinsics.areEqual(r49, r52)));
            zi0.c.a(r48, "msg_type", "switch_scene");
            if (r2.a(r47.c) == false) goto L92;
            if (Intrinsics.areEqual(r47.c, je0.d.b0()) == false) goto L92;
            zi0.c.a(r48, "create_type", "unknown");
            zi0.b.a(r48);
            nd0.c.p(nd0.c.a, LinkMonitorData.LayoutReady, r48, zi0.b.a, 0, null, false, null, 120);
            zi0.b.b.onNext(Unit.INSTANCE);
        L85:
            r52 = null;
        L92:
            if (je0.e.c(r0, r44.i) == false) goto L122;
            if (r44.m == null) goto L122;
            ReadOnlyProperty r53 = vm2.c.n;
            KProperty[] r54 = vm2.c.a;
            if (((Boolean) r53.getValue(null, r54[12])).booleanValue() == false) goto L106;
            if (r44.j == true) goto L112;
            if (r44.m.I1() == null) goto L112;
            if (r0.getScene() != 9) goto L104;
            r44.m.I1().setValue(Boolean.TRUE);
            goto L112
        L104:
            r44.m.I1().setValue(Boolean.FALSE);
        L112:
            if (((Boolean) vm2.c.o.getValue(null, r54[13])).booleanValue() == true) goto L114;
        L120:
            r0.getValidScene();
            r0.getUiLayout();
            r0.getMessageId2();
            ((q46.b) r44).a.d1(r0);
            goto L122
        L114:
            if (r44.j == true) goto L120;
            if (r44.m.s() == null) goto L120;
            if (r44.m.s().getValue() == null) goto L120;
            r44.I0();
            goto L120
        L106:
            if (r44.m.I1() == null) goto L112;
            if (r0.getScene() != 9) goto L110;
            r44.m.I1().setValue(Boolean.TRUE);
            goto L112
        L110:
            r44.m.I1().setValue(Boolean.FALSE);
        L122:
            if (je0.e.b(r0, r44.i) == true) goto L124;
            return;
        L124:
            if (r44.j == false) goto L128;
            rj0.k.m2.getClass();
            if (rj0.k.a.a() == null) goto L279;
            rj0.k.a.a().onSwitchSceneMessage(r0);
            return;
        L279:
            return;
        L128:
            tc0.c.h().E = r0.isSupportCamera();
            l.n2.getClass();
            if (l.a.a() == null) goto L281;
            l.a.a().Wg(r0);
            return;
        L281:
            return;
        L277:
            return;
        L47:
            if (r0.getMultiRtcInfo().getCrossRoomLinkmicRtcInfo() == null) goto L51;
            s r55 = r0.getMultiRtcInfo().getCrossRoomLinkmicRtcInfo();
            if (r55 == null) goto L51;
            r37 = r55.getRtcInfoMap();
            goto L52
        L32:
            r110 = r32;
            goto L33
        L27:
            if (r0.getVersion() >= r2.m) goto L29;
            jy0.b.c("ttlive_link", "TYPE_SWITCH_SCENE return, cause: invalid version", null, 4);
            return;
        L19:
            if (r30.contains(Integer.valueOf(LinkmicPlayMode.C_POSITION_LAYOUT.getValue())) == false) goto L21;
            r31 = true;
            goto L22
        L12:
            if (nd0.e.c() == true) goto L16;
            nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveSwitchSceneMsgMonitorDataSampling, r27, 0, null, false, 28);
            goto L25
        L285:
            return;
        L132:
            if (r2.b() == true) goto L138;
            hd0.b r56 = r2.h;
            if (r56 == null) goto L138;
            if (r56.getState() != 1) goto L138;
            r2.h.V7(0);
        L138:
            com.bytedance.android.live.multilink.impl.control.anchor.d r57 = r2.c;
            if (r57 == null) goto L153;
            LinkMultiControlPresenter r58 = (LinkMultiControlPresenter) r57;
            if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L143;
            com.bytedance.android.live.liveinteract.plantform.base.f.a().Sc();
        L143:
            TalkRoomBusinessFullLinkMonitor r59 = TalkRoomBusinessFullLinkMonitor.a;
            long r60 = r0.getMessageId2();
            r59.getClass();
            JSONObject r111 = new JSONObject();
            r111.put("msg_id", r60);
            r111.put("banner_type", "anchor_finish");
            nd0.c.o(nd0.c.a, LinkMonitorData.BannerMsgMonitorData, r111, 0, null, false, 28);
            ALogger.i("ttlive_link", "TYPE_TURN_FINISH layout=" + r0.getLayout() + " scene=" + r0.getScene());
            if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() == 2) goto L146;
        L148:
            ((q46.b) r58).a.fV(r0);
            xs2.b.a().post(new k42.d());
            wf0.b.g(r0.getValidScene());
            if (je0.d.D() == true) goto L153;
            DataCenter r1 = ((n) r58).c;
            if (r1 == null) goto L153;
            r1.put("data_guest_receive_finish_msg", Boolean.TRUE);
            goto L153
        L146:
            if (r58.m.y() == null) goto L148;
            r58.m.y().setValue(Boolean.TRUE);
        L153:
            r2.a(null);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            jy0.b.c("MultiControlService", "WebcastLinkMicMethod subscribe error " + ((Throwable) r4), null, 4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiControlService a;

        public d(MultiControlService r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            final e9 r13 = (e9) r12;
            MultiControlService r0 = this.a;
            r0.getClass();
            int r2 = (int) r13.getType2();
            if (r2 != 54) goto L5;
            ILinkerUILayoutChangeContent r1 = r13.getLinkerUILayoutChangeContent();
            if (r1 == null) goto L37;
            StringBuilder r3 = new StringBuilder("onUILayoutChangeMessage: \n messageId = ");
            Intrinsics.checkNotNullParameter(r13, "$this$messageId");
            r3.append(r13.getMessageId3());
            r3.append(", scene = ");
            Intrinsics.checkNotNullParameter(r13, "$this$sceneExt");
            r3.append(r13.getScene());
            r3.append(", content_ui_layout = ");
            r3.append(r1.getUiLayout());
            r3.append("\n multiLiveCoreInfo = ");
            r3.append(r1.getMultiLiveCoreInfo());
            r3.append("\n liveCoreExtInfo = ");
            r3.append(r1.getLiveCoreExtInfo());
            r3.append("\n multiRtcInfo = ");
            r3.append(r1.getMultiRtcInfo());
            r3.append("\n rtcExtInfo = ");
            r3.append(r1.getRtcExtInfo());
            og6.a.a("RtcParamsUpdate", r3.toString());
            tc0.b r4 = r0.e;
            if (r4 == null) goto L29;
            r4.setMultiLiveCoreInfo(r1.getMultiLiveCoreInfo());
            r4.setMultiRtcInfo(r1.getMultiRtcInfo());
            r4.setLiveCoreExtInfo(r1.getLiveCoreExtInfo());
            String r5 = r1.getRtcExtInfo();
            if (r5 != null) goto L28;
            r5 = "";
        L28:
            r4.setRtcExtInfo(r5);
        L29:
            com.bytedance.android.live.multilink.impl.control.anchor.d r6 = r0.c;
            if (r6 == null) goto L38;
            LinkMultiControlPresenter r7 = (LinkMultiControlPresenter) r6;
            ILinkerUILayoutChangeContent r14 = r13.getLinkerUILayoutChangeContent();
            if (r14 == null) goto L39;
            ((q46.b) r7).a.Zi((int) r14.getUiLayout());
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L5:
            if (r2 != 59) goto L40;
            com.bytedance.android.live.multilink.impl.control.anchor.d r8 = r0.c;
            if (r8 == null) goto L35;
            final LinkMultiControlPresenter r9 = (LinkMultiControlPresenter) r8;
            if (((Boolean) vm2.d.d4.getValue(null, vm2.d.a[261(0x105, float:3.66E-43)])).booleanValue() == false) goto L41;
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            Intrinsics.checkNotNullParameter(r13, "linkerMessage");
            LinkerConfirmUnsilenceContent r10 = r13.getLinkerConfirmUnsilenceContent();
            if (r10 == null) goto L17;
            JSONObject r11 = new JSONObject();
            Intrinsics.checkNotNullParameter(r13, "$this$messageId");
            r11.put("msg_id", r13.getMessageId3());
            Intrinsics.checkNotNullParameter(r10, "$this$fromUserId");
            o0.a r15 = o0.a;
            Long r16 = Long.valueOf(r10.get_fromUserId());
            String r17 = r10.get_fromOpenId();
            r15.getClass();
            r11.put("from_user_id", o0.a.g(r16, r17));
            r11.put("from_room_id", r10.getFromRoomId());
            nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveConfirmUnsilenceMsgMonitorData, r11, 0, null, false, 28);
        L17:
            if (r13.getLinkerConfirmUnsilenceContent() == null) goto L19;
            String r18 = r13.getLinkerConfirmUnsilenceContent().getToast();
        L20:
            x0.b r19 = new x0.b(((q46.b) r9).a.getContext(), 4);
            r19.a.d = r18;
            r19.i(0, 2131919204, new com.bytedance.android.live.multilink.impl.v(r9, r13));
            r19.i(1, 2131919401, new w(r9, r13));
            r19.n();
            return;
        L19:
            r18 = s1.B(2131923175);
            goto L20
        L41:
            return;
        L35:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            jy0.b.c("MultiControlService", "WebcastLinkMicMethod subscribe error " + ((Throwable) r4), null, 4);
        }
    }

    static {
    }

    public final boolean b() {
        g r0 = this.f;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAnchor();
    }

    public final void c() {
        gn0.b r0 = this.j;
        r0.getClass();
        f r1 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), f.class);
        r0.c = r1;
        if (r1 == null) goto L9;
        com.bytedance.android.live.multilink.common.message.a r4 = com.bytedance.android.live.multilink.common.message.a.b;
        Lazy r5 = MultiLinkMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r4, "$this$LINK_SETTING_NOTIFY_MESSAGE");
        Observable r2 = yz0.h.a.a(r1, (yh6.b) MultiLinkMessageTypeKt.d.getValue(), false, 6);
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new gn0.d(r0), gn0.e.a);
        if (r3 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, r0.d);
    L9:
        f r6 = this.k;
        if (r6 == null) goto L16;
        Observable r7 = yz0.h.a.a(r6, MultiLinkMessageTypeKt.b(com.bytedance.android.live.multilink.common.message.a.b), false, 6);
        if (r7 == null) goto L16;
        Disposable r8 = r7.subscribe(new b(this), c.a);
        if (r8 == null) goto L16;
        com.bytedance.revenue.platform.api.core.rx.f.a(r8, this.l);
    L16:
        f r9 = this.k;
        if (r9 == null) goto L23;
        Observable r10 = yz0.h.a.a(r9, MultiLinkMessageTypeKt.a(com.bytedance.android.live.multilink.common.message.a.b), false, 6);
        if (r10 == null) goto L23;
        Disposable r11 = r10.subscribe(new d(this), e.a);
        if (r11 == null) goto L23;
        com.bytedance.revenue.platform.api.core.rx.f.a(r11, this.l);
    L23:
        Pair r12 = com.bytedance.live.datacontext.d.a(new MultiControlService$init$5(this));
        ((MultiControlContext) r12.getFirst()).shareByRoomScope();
        ((MultiControlContext) r12.getFirst()).getService().d(this);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r12.getSecond(), this.l);
    }

    @Override // com.bytedance.android.live.multilink.impl.control.a
    public final void a(fn0.a r5) {
        bn0.b r0 = this.o;
        if (r0 == null) goto L10;
        jn0.b r1 = jn0.c.a(r0);
        if (r1 == null) goto L10;
        BehaviorSubject<Integer> r2 = r1.b5();
        if (r2 == null) goto L10;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L10;
    L11:
        int r4 = r3.intValue();
        if (r5 != null) goto L19;
        int r6 = b5.a;
        int r7 = this.b;
        if ((r4 & r7) != r7) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L20;
        r4 = r4 ^ r7;
    L20:
        bn0.b r9 = this.o;
        if (r9 == null) goto L27;
        jn0.b r10 = jn0.c.a(r9);
        if (r10 == null) goto L27;
        BehaviorSubject<Integer> r11 = r10.b5();
        if (r11 == null) goto L27;
        r11.onNext(Integer.valueOf(r4));
    L27:
        if (r5 == null) goto L29;
        int r12 = r5.a;
    L30:
        this.b = r12;
        BehaviorSubject<fn0.a> r13 = this.a;
        if (r5 != null) goto L33;
        r5 = new fn0.a(0);
    L33:
        r13.onNext(r5);
        return;
    L29:
        r12 = 0;
        goto L30
    L16:
        r8 = false;
        goto L17
    L19:
        int r14 = b5.a;
        r4 = r4 | r5.a;
    L10:
        r3 = 0;
        goto L11
    }

    public MultiControlService(com.bytedance.android.live.multilink.impl.control.b r4, bn0.b r5) {
        Intrinsics.checkNotNullParameter(r4, "multiControlHostService");
        this.n = r4;
        this.o = r5;
        int r0 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.a = BehaviorSubject.create();
        this.d = new MultiControlAnchorService(r4, r5, this);
        f r1 = null;
        if (r5 == null) goto L5;
        KClass r2 = Reflection.getOrCreateKotlinClass(tc0.b.class);
        com.bytedance.android.scope.m.e.getClass();
        tc0.b r3 = (tc0.b) com.bytedance.android.scope.m.b(r5).a(r2);
    L6:
        this.e = r3;
        if (r5 == null) goto L9;
        KClass r6 = Reflection.getOrCreateKotlinClass(g.class);
        com.bytedance.android.scope.m.e.getClass();
        g r7 = (g) com.bytedance.android.scope.m.b(r5).a(r6);
    L10:
        this.f = r7;
        if (r5 == null) goto L13;
        KClass r8 = Reflection.getOrCreateKotlinClass(jn0.b.class);
        com.bytedance.android.scope.m.e.getClass();
        jn0.b r9 = (jn0.b) com.bytedance.android.scope.m.b(r5).a(r8);
    L14:
        this.g = r9;
        if (r5 == null) goto L17;
        KClass r10 = Reflection.getOrCreateKotlinClass(hd0.b.class);
        com.bytedance.android.scope.m.e.getClass();
        hd0.b r11 = (hd0.b) com.bytedance.android.scope.m.b(r5).a(r10);
    L18:
        this.h = r11;
        if (r5 == null) goto L21;
        com.bytedance.android.scope.m.e.getClass();
        j r12 = (j) com.bytedance.android.scope.m.b(r5).b(j.class);
    L22:
        this.i = r12;
        this.j = new gn0.b(r5, r4);
        if (r5 == null) goto L25;
        KClass r13 = Reflection.getOrCreateKotlinClass(f.class);
        com.bytedance.android.scope.m.e.getClass();
        r1 = (f) com.bytedance.android.scope.m.b(r5).a(r13);
    L25:
        this.k = r1;
        this.l = new CompositeDisposable();
        this.m = -1;
        return;
    L21:
        r12 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
