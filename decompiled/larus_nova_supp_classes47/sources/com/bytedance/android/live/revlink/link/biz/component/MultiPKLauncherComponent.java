package com.bytedance.android.live.revlink.link.biz.component;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.params.ReplyType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c0;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.link.biz.utils.BattleInviteUtils;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.AlertBizType;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.bridge.q0;
import com.bytedance.android.livesdk.link.model.e5;
import com.bytedance.android.livesdk.link.model.h5;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.j7;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiPKLauncherComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public zy0.d b;
    public final MultiPKLauncher c;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a d;
    public final CompositeDisposable e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f;
    public final h g;
    public final d h;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncherComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$a;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.C0127a, Unit> {
        public AnonymousClass1(MultiPKLauncherComponent r8) {
            super(1, r8, MultiPKLauncherComponent.class, "onBattleInviteMsg", "onBattleInviteMsg(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/IPkAnchorLauncher$BattleInviteEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.C0127a r28) {
            final MultiPKLauncherComponent r2 = (MultiPKLauncherComponent) ((CallableReference) this).receiver;
            r2.getClass();
            if (r28 == null) goto L314;
            final ILinkMicBattleInviteMessage r1 = r28.a;
            if (r1 == null) goto L324;
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r3 = com.bytedance.android.live.revlink.link.biz.service.i.n(r2);
            r3.getClass();
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r3.c = "";
            r2.getContext().ko().h(AlertBizType.BattleInvite);
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r4 = r2.getContext().Q1();
            if (r4 == null) goto L10;
            r4.setPkLauncher(false);
        L10:
            final int r6 = r1.getInviteType();
            final int r7 = r1.getMultiPkMode();
            final Ref.ObjectRef r13 = new Ref.ObjectRef();
            int r5 = com.bytedance.android.live.revlink.impl.mergepk.pkmulti.f.a;
            r13.element = com.bytedance.android.live.revlink.impl.mergepk.pkmulti.f.a(r1.getBattleConfigSetting(), h21.c.a(Integer.valueOf(r1.getMultiPkMode())));
            IBattleConfigSetting r8 = r1.getBattleConfigSetting();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9 = r2.getContext().Ig();
            r2.getContext().Q1();
            if (r8 == null) goto L13;
            aa r10 = r8.getVoteData();
        L15:
            if (r10 == null) goto L20;
            if (r9 == null) goto L20;
            if (r9.isInVote() != true) goto L20;
        L26:
            String r12 = "";
        L88:
            final boolean r14 = true;
        L90:
            int r15 = BattleInviteUtils.a;
            String r16 = BattleInviteUtils.a(r2.getContext(), r1).a;
            IBattleConfigSetting r17 = r1.getBattleConfigSetting();
            if (r17 == null) goto L93;
            h9 r18 = r17.getSpecifyGiftConfig();
        L95:
            if (r18 == null) goto L128;
            e51.c r19 = e51.c.d;
            r19.getClass();
            String r20 = (String) e51.c.c.getValue(r19, e51.c.a[1]);
            if (r20.length() <= 0) goto L99;
            boolean r110 = true;
        L100:
            if (r110 == false) goto L102;
            String r111 = r20;
        L103:
            if (r111 == null) goto L315;
            HashMap r22 = new HashMap();
            String r23 = q0.a(r1);
            if (r23 != null) goto L108;
            r23 = r12;
        L108:
            r22.put("invite_uid", r23);
            String r24 = String.valueOf(r1.getInviteType());
            if (r24 != null) goto L111;
            r24 = r12;
        L111:
            r22.put("invite_type", r24);
            String r25 = String.valueOf(r1.getMultiPkMode());
            if (r25 != null) goto L114;
            r25 = r12;
        L114:
            r22.put("multi_pk_mode", r25);
            r22.put("channel_id", String.valueOf(r2.getContext().G()));
            r22.put("room_id", String.valueOf(r2.getContext().getRoomID()));
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r26 = r2.getContext().Ig();
            if (r26 == null) goto L120;
            IBaseBattleSetting r27 = r26.getBattleSettings();
            if (r27 == null) goto L120;
            String r29 = String.valueOf(r27.getBattleId());
            if (r29 == null) goto L120;
        L121:
            r22.put("battle_id", r29);
            r22.put("scene", String.valueOf(7));
            r22.put("battle_config_setting", GsonProtectorUtils.toJson(l97.a.a, r1.getBattleConfigSetting()));
            String r30 = r1.getPrompts();
            if (r30 != null) goto L124;
            String r112 = r12;
        L125:
            r22.put("prompts", r112);
            zz0.e.a(u.b(r111, r22));
            com.bytedance.android.live.revlink.impl.multianchor.service.c r32 = com.bytedance.android.live.revlink.link.biz.service.i.D(r2);
            if (r32 == null) goto L316;
            r32.Ob();
            return;
        L316:
            return;
        L124:
            r112 = r30;
        L120:
            r29 = r12;
            goto L121
        L315:
            return;
        L102:
            r111 = null;
            goto L103
        L99:
            r110 = false;
            goto L100
        L128:
            boolean r113 = true;
            if ((!StringsKt.isBlank(r1.getPrompts())) == false) goto L132;
            r16 = r1.getPrompts();
        L134:
            final String r33 = r16;
            b51.b r34 = b51.b.c0;
            r34.getClass();
            ReadOnlyProperty r114 = b51.b.K;
            KProperty[] r210 = b51.b.a;
            if (((Boolean) r114.getValue(r34, r210[35])).booleanValue() == false) goto L148;
            String r0 = (String) b51.b.L.getValue(r34, r210[36]);
            if (r0.length() <= 0) goto L139;
            boolean r115 = true;
        L140:
            if (r115 == false) goto L318;
            final x0 r35 = new x0(r0);
            x0 r36 = r35.d("url");
            r36.b("room_id", String.valueOf(r2.getContext().getRoomID()));
            r36.b("business_type", r41.b.a());
            r36.b("group", r41.b.a());
            r36.b("title_content", r33);
            r36.b("invite_uid", q0.a(r1));
            r36.b("invite_type", String.valueOf(r6));
            r36.b("multi_pk_mode", String.valueOf(r7));
            yz0.g r37 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
            if (r37 == null) goto L319;
            Context r38 = r37.getContext();
            if (r38 == null) goto L320;
            cy0.e.a.getClass();
            cy0.j r39 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r40 = com.bytedance.android.scope.m.b(r39).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
            Intrinsics.checkNotNull(r40);
            HybridDialogImpl r42 = ((vy0.b) ((f80.a) r40)).U0(r38, r35.c(), null);
            r2.b = r42;
            if (r42 == null) goto L321;
            r42.j0(new MultiPKLauncherComponent$onBattleInviteMsg$$inlined$let$lambda$1(r2, r35));
            return;
        L321:
            return;
        L320:
            return;
        L319:
            return;
        L318:
            return;
        L139:
            r115 = false;
            goto L140
        L148:
            r2.getContext().ko().j(new MultiPKLauncherComponent$onBattleInviteMsg$2(r2, r1, r6, r7, r14, r13, r33));
            String r43 = q0.a(r1);
            String r44 = (String) r13.element;
            v3 r45 = e21.e.a(r1);
            IBattleConfigSetting r46 = r1.getBattleConfigSetting();
            Map<String, String> r47 = h41.h.a(r1.getEventTrackingInfo());
            if (r47 == null) goto L151;
            Map<String, String> r48 = MapsKt.toMap(r47);
        L152:
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r49 = com.bytedance.android.live.revlink.link.biz.service.i.M(r2);
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r50 = com.bytedance.android.live.revlink.link.biz.service.i.S(r2);
            if (r50 == null) goto L157;
            LiveData<PlayMode> r52 = r50.getTeamMode();
            if (r52 == null) goto L157;
            PlayMode r53 = (PlayMode) r52.getValue();
        L159:
            if (r53 != PlayMode.TEAM_PK) goto L161;
            boolean r116 = true;
        L162:
            if (r50 == null) goto L167;
            String r54 = r50.getTeamModeStr();
            if (r54 == null) goto L167;
            String r211 = r54;
        L168:
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r55 = com.bytedance.android.live.revlink.link.biz.service.i.B(r2);
            int r56 = ((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(r2).a).size();
            if (r43 == null) goto L176;
            com.bytedance.android.livesdk.link.model.p r57 = com.bytedance.android.live.revlink.link.biz.service.i.t(r2).getGuestInfo(r43, null);
            if (r57 == null) goto L176;
            IBaseUser r58 = r57.getUser();
            if (r58 == null) goto L176;
            String r59 = String.valueOf(com.bytedance.android.live.base.model.user.n.a(r58));
            if (r59 == null) goto L176;
        L177:
            if (r48 != null) goto L180;
            r48 = null;
        L180:
            int r117 = ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Again.ordinal();
            r55.getClass();
            Intrinsics.checkNotNullParameter(r44, "inviteMode");
            Intrinsics.checkNotNullParameter(r12, FileUtils.PICTURE_THEME);
            LinkedHashMap r118 = new LinkedHashMap();
            if (r46 == null) goto L185;
            u2 r212 = r46.getSelfData();
            if (r212 == null) goto L185;
            int r60 = r212.getPkValueType();
        L186:
            LinkCrossRoomDataHolder r213 = r55.f();
            if (r213 == null) goto L189;
            Long r214 = Long.valueOf(r213.c());
        L190:
            r118.put("channel_id", String.valueOf(r214));
            r118.put("is_oncemore", DataType.TRUE);
            if (r117 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Multiple_Activity.ordinal()) goto L193;
        L196:
            String r119 = "double";
        L197:
            r118.put("npk_link_type", r119);
            com.bytedance.android.live.revlink.impl.global.c r120 = r55.d;
            if (r120 == null) goto L200;
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r121 = r120.getMultiAnchorLinkLogUtils();
        L201:
            if (r121 == null) goto L203;
            String r122 = r121.p();
        L204:
            r118.put("invitee_connection_status", r122);
            r118.put("anchor_connect_status", String.valueOf(r56));
            r118.put("inviter_connect_cnt", DataType.FALSE);
            r118.put("anchor_connection_type", "invite");
            if (r43 != null) goto L207;
            r43 = r12;
        L207:
            r118.put("inviter_id", r43);
            r118.put("inviter_room_id", r59);
            d31.d r62 = r55.m();
            if (r62 == null) goto L210;
            String r63 = r62.s();
        L211:
            r118.put("room_status", r63);
            com.bytedance.android.live.revlink.impl.global.c r64 = r55.d;
            if (r64 == null) goto L214;
            d31.e r65 = r64.q4();
        L215:
            if (r65 == null) goto L217;
            String r66 = r65.a();
        L218:
            r118.put("source", r66);
            r118.put("pk_description", "routine");
            if (r60 <= 0) goto L222;
            if (r60 >= 100) goto L222;
            String r67 = "customize_pk";
        L223:
            r118.put("invite_mode", r67);
            Long r68 = 0L;
            if (r68.longValue() > 0) goto L227;
            r113 = false;
        L227:
            if (r113 == true) goto L230;
            r68 = null;
        L230:
            if (r68 == null) goto L232;
            r118.put("pk_time", String.valueOf(r68.longValue()));
        L232:
            int r69 = UserListInviteType.a;
            LinkCrossRoomDataHolder r70 = r55.f();
            if (r70 == null) goto L235;
            int r72 = r70.f();
        L236:
            r118.put("invitee_list", UserListInviteType.a(r72, null));
            if (r60 <= 0) goto L275;
            if (r60 >= 100) goto L275;
            r118.put("customize_pk_type", String.valueOf(r60));
            if (r46 == null) goto L245;
            u2 r73 = r46.getSelfData();
            if (r73 == null) goto L245;
            String r74 = String.valueOf(r73.getPkGiftValueLevel());
            if (r74 == null) goto L245;
        L246:
            r118.put("giftvalue_exchange_rate", r74);
            if (r46 == null) goto L252;
            u2 r75 = r46.getSelfData();
            if (r75 == null) goto L252;
            String r76 = String.valueOf(r75.getPkUVLevel());
            if (r76 == null) goto L252;
        L253:
            r118.put("giftuv_exchange_rate", r76);
            if (r46 == null) goto L259;
            u2 r77 = r46.getSelfData();
            if (r77 == null) goto L259;
            String r78 = String.valueOf(r77.getPkTicketLevel());
            if (r78 == null) goto L259;
        L260:
            r118.put("ticket_exchange_rate", r78);
            if (r46 == null) goto L266;
            u2 r79 = r46.getSelfData();
            if (r79 == null) goto L266;
            String r80 = String.valueOf(r79.getPkLikeLevel());
            if (r80 == null) goto L266;
        L267:
            r118.put("like_exchange_rate", r80);
            if (r46 == null) goto L273;
            v2 r82 = r46.getSelfSettingRate();
            if (r82 == null) goto L273;
            String r83 = String.valueOf(r82.getPkVIPRate());
            if (r83 == null) goto L273;
        L274:
            r118.put("membership_exchange_rate", r83);
        L273:
            r83 = r12;
        L266:
            r80 = r12;
        L259:
            r78 = r12;
        L252:
            r76 = r12;
        L245:
            r74 = r12;
        L275:
            r118.put("audience_connect_cnt", String.valueOf(n41.a.b()));
            d31.d r84 = r55.m();
            if (r84 == null) goto L278;
            String r85 = r84.s();
        L279:
            r118.put("room_status", r85);
            r118.put("invite_type", "play");
            d31.d r86 = r55.m();
            if (r86 == null) goto L282;
            String r87 = r86.d();
        L283:
            r118.put("battle_mode", r87);
            w31.c r88 = r55.k();
            if (r88 == null) goto L286;
            Long r89 = Long.valueOf(r88.i());
        L287:
            r118.put("pk_id", String.valueOf(r89));
            d31.d r90 = r55.m();
            if (r90 == null) goto L290;
            String r92 = r90.b();
        L291:
            r118.put("connection_sub_type", r92);
            d31.d r93 = r55.m();
            if (r93 == null) goto L294;
            r93.r(r118);
        L294:
            r118.put("if_strategy_invite", DataType.FALSE);
            mz0.n r94 = new mz0.n();
            mz0.o r95 = new mz0.o(r94.a);
            r95.b(r118);
            e21.e.d(r95, r45);
            if (r48 == null) goto L297;
            r95.b(r48);
        L297:
            mz0.m r96 = new mz0.m();
            r96.b(LogCommon.ROOM);
            ((ArrayList) r94.b).addAll(r96.a);
            cy0.e.a.getClass();
            cy0.j r97 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r98 = com.bytedance.android.scope.m.b(r97).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r98);
            ((mz0.i) ((f80.a) r98)).w3("livesdk_connection_invited_page_show", r94.a, r94.b);
            if (r116 == false) goto L308;
            if (r49 == null) goto L302;
            Pair<List<String>, List<String>> r99 = r49.getTeamPkUids();
            if (r99 == null) goto L302;
        L303:
            List r100 = (List) r99.component1();
            List r101 = (List) r99.component2();
            h41.f r215 = com.bytedance.android.live.revlink.link.biz.service.i.V(r2);
            int r216 = ((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(r2).a).size();
            if (r49 == null) goto L306;
            int r217 = r49.getPkUserCnt();
        L307:
            r215.b(r216, r217, r211, Integer.valueOf(r100.size()), Integer.valueOf(r101.size()));
            return;
        L306:
            r217 = 0;
        L302:
            r99 = TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
            goto L303
        L308:
            h41.f r218 = com.bytedance.android.live.revlink.link.biz.service.i.V(r2);
            int r219 = ((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(r2).a).size();
            if (r49 == null) goto L311;
            int r220 = r49.getPkUserCnt();
        L312:
            r218.b(r219, r220, r211, null, null);
            return;
        L311:
            r220 = 0;
            goto L312
        L290:
            r92 = r12;
            goto L291
        L286:
            r89 = null;
            goto L287
        L282:
            r87 = r12;
            goto L283
        L278:
            r85 = r12;
            goto L279
        L235:
            r72 = 0;
        L222:
            r67 = r44;
            goto L223
        L217:
            r66 = r12;
            goto L218
        L214:
            r65 = null;
            goto L215
        L210:
            r63 = r12;
            goto L211
        L203:
            r122 = r12;
            goto L204
        L200:
            r121 = null;
            goto L201
        L193:
            if (r117 == ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Multiple_Again.ordinal()) goto L196;
            r119 = "single";
            goto L197
        L189:
            r214 = null;
        L185:
            r60 = 0;
        L176:
            r59 = r12;
        L167:
            r211 = r12;
            goto L168
        L161:
            r116 = false;
        L157:
            r53 = null;
            goto L159
        L151:
            r48 = null;
            goto L152
        L132:
            if ((!StringsKt.isBlank(r1.getInviteTitle())) == false) goto L134;
            r16 = r1.getInviteTitle();
            goto L134
        L93:
            r18 = null;
        L20:
            if (r8 != null) goto L22;
        L27:
            if (r8 != null) goto L29;
        L63:
            r12 = "";
        L64:
            if (r8 == null) goto L68;
            w2 r102 = r8.getShellConfig();
            if (r102 == null) goto L68;
            long r103 = r102.getType();
        L70:
            if (r103 <= 0) goto L75;
            if (r9 == null) goto L75;
            if (r9.isInCompetition() == true) goto L88;
        L75:
            if (r8 != null) goto L77;
        L82:
            if (r8 == null) goto L89;
            if (r9 == null) goto L85;
            c21.f r104 = r9.getBattlePlayMode();
        L87:
            if ((r104 instanceof c21.f.h) == false) goto L89;
        L85:
            r104 = null;
        L89:
            r14 = false;
            goto L90
        L77:
            if (r8.getModType() != PkBaseDataContext.PKModType.RobC.getType()) goto L82;
            if (r9 == null) goto L82;
            if (r9.isInRobC() != true) goto L82;
        L68:
            r103 = 0;
            goto L70
        L29:
            if (com.bytedance.android.live.revlink.impl.mergepk.pkmulti.e.a(r8) != true) goto L63;
            u2 r105 = r8.getSelfData();
            PkCustomizePlayDataContext r106 = com.bytedance.android.live.revlink.link.biz.service.i.W(r2).f();
            if (r106 == null) goto L35;
            IBattleConfigSetting r107 = r106.getBattleConfigSetting();
            if (r107 == null) goto L35;
            v2 r108 = r107.getSelfSettingRate();
        L36:
            if (r105 != null) goto L38;
            r12 = "";
        L60:
            boolean r109 = false;
        L61:
            if (r109 == false) goto L64;
        L38:
            if (r105.getPkValueType() == 3) goto L44;
            r12 = "";
            long r123 = r105.getPkValueType();
            if (r108 == null) goto L60;
            if (r123 != r108.getPkValueType()) goto L60;
        L58:
            r109 = true;
            goto L61
        L44:
            r12 = "";
            if (r105.getPkGiftValueLevel() <= 0) goto L52;
            if (r108 == null) goto L48;
            long r124 = r108.getPkGiftRate();
        L50:
            if (((int) r124) > 0) goto L58;
        L48:
            r124 = 0;
        L52:
            if (r105.getPkUVLevel() <= 0) goto L60;
            if (r108 == null) goto L55;
            long r125 = r108.getPkUVRate();
        L57:
            if (((int) r125) <= 0) goto L60;
        L55:
            r125 = 0;
        L35:
            r108 = null;
            goto L36
        L22:
            if (r8.getModType() != PkBaseDataContext.PKModType.BreakThrough.getType()) goto L27;
            if (r9 == null) goto L27;
            if (r9.isInBreakThrough() != true) goto L27;
        L13:
            r10 = null;
            goto L15
        L324:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.C0127a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncherComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.c, Unit> {
        public AnonymousClass2(MultiPKLauncherComponent r8) {
            super(1, r8, MultiPKLauncherComponent.class, "onBattleRejectMsg", "onBattleRejectMsg(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/IPkAnchorLauncher$BattleReplyEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.c r8) {
            MultiPKLauncherComponent r0 = (MultiPKLauncherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            String r1 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0);
            StringBuilder r2 = new StringBuilder("onBattleRejectMsg, promote: ");
            if (r8 == null) goto L7;
            e5 r4 = r8.a;
            if (r4 == null) goto L7;
            String r5 = r4.getPrompt();
        L8:
            r2.append(r5);
            jy0.b.c(r1, r2.toString(), null, 4);
            if (r8 == null) goto L19;
            e5 r9 = r8.a;
            if (r9 != null) goto L14;
            return;
        L14:
            if ((!StringsKt.isBlank(r9.getPrompt())) == false) goto L16;
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "onBattleRejectMsg, toast with promote " + r9.getPrompt(), null, 4);
            int r3 = ToastUtil.a;
            ToastUtil.b(r9.getPrompt(), 0);
        L17:
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r10 = com.bytedance.android.live.revlink.link.biz.service.i.n(r0);
            r10.getClass();
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r10.c = "";
            r0.getContext().ko().h(AlertBizType.BattleInvite);
            return;
        L16:
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "onBattleRejectMsg, toast with promote fix ttlive_live_interact_battle_invite_reject", null, 4);
            int r12 = ToastUtil.a;
            int r13 = w11.a.a;
            ToastUtil.a(2131919242, 0);
            goto L17
        L19:
            return;
        L7:
            r5 = null;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncherComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$d;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$d;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.d, Unit> {
        public AnonymousClass3(MultiPKLauncherComponent r8) {
            super(1, r8, MultiPKLauncherComponent.class, "onBizInviteMessage", "onBizInviteMessage(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/IPkAnchorLauncher$BizInviteEvent;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.d) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.d r1) {
            ((MultiPKLauncherComponent) ((CallableReference) this).receiver).getClass();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncherComponent$attach$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$e;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$e;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.e, Unit> {
        public AnonymousClass4(MultiPKLauncherComponent r8) {
            super(1, r8, MultiPKLauncherComponent.class, "onBizReplyEvent", "onBizReplyEvent(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/IPkAnchorLauncher$BizReplyEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.e r9) {
            MultiPKLauncherComponent r0 = (MultiPKLauncherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r9 == null) goto L23;
            ILinkMicBizReplyMessage r1 = r9.a;
            if (r1 == null) goto L24;
            Integer r2 = r1.getRepCode();
            int r3 = ReplyType.Accept.ordinal();
            if (r2 != null) goto L12;
        L20:
            int r10 = ToastUtil.a;
            ToastUtil.b(r1.getRejectPrompts(), 0);
            return;
        L12:
            if (r2.intValue() != r3) goto L20;
            h r4 = r0.g;
            h5 r12 = r9.a.getLinkMicBizExtra();
            if (r12 == null) goto L18;
            j7 r13 = r12.getOpenGameConfig();
            if (r13 == null) goto L18;
            String r14 = r13.getGameAppId();
        L19:
            r4.d = r14;
            r0.h.startSwitchPk(new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g(null, 0, null, false, null, 131071));
            return;
        L18:
            r14 = null;
            goto L19
        L24:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.e) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncherComponent$attach$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$f;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.f, Unit> {
        public AnonymousClass5(MultiPKLauncherComponent r8) {
            super(1, r8, MultiPKLauncherComponent.class, "onBizReplyResponse", "onBizReplyResponse(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/IPkAnchorLauncher$BizReplyResponseEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.f r2) {
            ((MultiPKLauncherComponent) ((CallableReference) this).receiver).g.d = null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.f) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncherComponent$attach$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass6(MultiPKLauncherComponent r8) {
            super(0, r8, MultiPKLauncherComponent.class, "onPkStateChange", "onPkStateChange()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m895invoke() {
            MultiPKLauncherComponent r0 = (MultiPKLauncherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = com.bytedance.android.live.revlink.link.biz.service.i.S(r0);
            if (r1 == null) goto L12;
            LiveData<PkBaseStateMachine.c> r2 = r1.getPkBaseState();
            if (r2 == null) goto L13;
            PkBaseStateMachine.c r3 = (PkBaseStateMachine.c) r2.getValue();
            if (r3 != null) goto L9;
            return;
        L9:
            if (r3.b() != true) goto L15;
            r0.getContext().ko().h(AlertBizType.BattleInvite);
            return;
        L15:
            return;
        L13:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m895invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r0 = this.d;
        if (r0 == null) goto L5;
        r0.n();
    L5:
        this.e.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        getContext().T6(MultiPKLauncher.TAG, this.c);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r0 = this.d;
        if (r0 == null) goto L9;
        MutableLiveData r1 = r0.f();
        if (r1 == null) goto L9;
        Disposable r2 = UtilsKt.d(r1, new AnonymousClass1(this));
        if (r2 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r2, this.e);
    L9:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r3 = this.d;
        if (r3 == null) goto L16;
        MutableLiveData r4 = r3.j();
        if (r4 == null) goto L16;
        Disposable r5 = UtilsKt.d(r4, new AnonymousClass2(this));
        if (r5 == null) goto L16;
        com.bytedance.revenue.platform.api.core.rx.f.a(r5, this.e);
    L16:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r6 = this.d;
        if (r6 == null) goto L23;
        MutableLiveData r7 = r6.l();
        if (r7 == null) goto L23;
        Disposable r8 = UtilsKt.d(r7, new AnonymousClass3(this));
        if (r8 == null) goto L23;
        com.bytedance.revenue.platform.api.core.rx.f.a(r8, this.e);
    L23:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r9 = this.d;
        if (r9 == null) goto L30;
        MutableLiveData r10 = r9.e();
        if (r10 == null) goto L30;
        Disposable r12 = UtilsKt.d(r10, new AnonymousClass4(this));
        if (r12 == null) goto L30;
        com.bytedance.revenue.platform.api.core.rx.f.a(r12, this.e);
    L30:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r13 = this.d;
        if (r13 == null) goto L37;
        MutableLiveData r14 = r13.h();
        if (r14 == null) goto L37;
        Disposable r15 = UtilsKt.d(r14, new AnonymousClass5(this));
        if (r15 == null) goto L37;
        com.bytedance.revenue.platform.api.core.rx.f.a(r15, this.e);
    L37:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r16 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r16 == null) goto L45;
        LiveData<PkBaseStateMachine.c> r17 = r16.getPkBaseState();
        if (r17 == null) goto L46;
        Disposable r18 = UtilsKt.f(r17, new AnonymousClass6(this));
        if (r18 == null) goto L47;
        com.bytedance.revenue.platform.api.core.rx.f.a(r18, this.e);
        return;
    L47:
        return;
    L46:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
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
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.f;
    }

    public static final void a(MultiPKLauncherComponent r12, String r13) {
        r12.getClass();
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r0 = com.bytedance.android.live.revlink.link.biz.service.i.M(r12);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = com.bytedance.android.live.revlink.link.biz.service.i.S(r12);
        if (r1 == null) goto L7;
        LiveData<PlayMode> r2 = r1.getTeamMode();
        if (r2 == null) goto L7;
        PlayMode r3 = (PlayMode) r2.getValue();
    L9:
        if (r3 != PlayMode.TEAM_PK) goto L11;
        boolean r4 = true;
    L12:
        if (r1 == null) goto L15;
        String r5 = r1.getTeamModeStr();
        if (r5 == null) goto L15;
    L16:
        String r9 = r5;
        if (r4 == false) goto L27;
        if (r0 == null) goto L21;
        Pair<List<String>, List<String>> r6 = r0.getTeamPkUids();
        if (r6 == null) goto L21;
    L22:
        List r7 = (List) r6.component1();
        List r8 = (List) r6.component2();
        h41.f r10 = com.bytedance.android.live.revlink.link.biz.service.i.V(r12);
        int r14 = ((CopyOnWriteArrayList) r12.getContext().getAnchorLinkUserCenter().a).size();
        if (r0 == null) goto L25;
        int r15 = r0.getPkUserCnt();
    L26:
        r10.a(r13, r14, r15, r9, Integer.valueOf(r7.size()), Integer.valueOf(r8.size()));
        return;
    L25:
        r15 = 0;
    L21:
        r6 = TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        goto L22
    L27:
        h41.f r16 = com.bytedance.android.live.revlink.link.biz.service.i.V(r12);
        int r17 = ((CopyOnWriteArrayList) r12.getContext().getAnchorLinkUserCenter().a).size();
        if (r0 == null) goto L30;
        int r18 = r0.getPkUserCnt();
    L31:
        r16.a(r13, r17, r18, r9, null, null);
        return;
    L30:
        r18 = 0;
    L15:
        r5 = "";
        goto L16
    L11:
        r4 = false;
    L7:
        r3 = null;
        goto L9
    }

    public MultiPKLauncherComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r12, h r13, MultiSwitchToPkImplV2 r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "bizDataContext");
        Intrinsics.checkNotNullParameter(r14, "switchToPkImpl");
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.a = "MultiPKLauncherComponent";
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r15 = getContext();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r0 = null;
        jy0.b.c("xuzr_scope", "create multiPkLaunch", null, 4);
        this.c = new MultiPKLauncher(r15.getLinkOptLogContext(), r15.getMergePkHelper(), r15.getClientAttachedInfoObj(), r15.getRevLinkLogHelper(), r15.Ig(), r15.Q1(), r15.getPkSwitchLogger());
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r16 = getContext().Ig();
        if (r16 == null) goto L5;
        r0 = r16.getPkAnchorLauncher();
    L5:
        this.d = r0;
        this.e = new CompositeDisposable();
    }

    public final void b(String r4, IBattleConfigSetting r5, boolean r6, String r7, v3 r8, Map r9) {
        Intrinsics.checkNotNullParameter(r4, "selection");
        Intrinsics.checkNotNullParameter(r7, "inviteMode");
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r2 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r2 == null) goto L5;
        r1.putAll(r2.getCurrentSceneLogParam());
    L5:
        r1.put("selection", r4);
        if (r6 == false) goto L8;
        String r10 = DataType.TRUE;
    L9:
        r1.put("is_oncemore", r10);
        r1.put("invite_type", "play");
        r1.put("inviter_room_status", "pk");
        r1.put("audience_connect_cnt", DataType.FALSE);
        r1.put("inviter_connect_cnt", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).a());
        r1.put("invite_mode", r7);
        r1.put("battle_mode", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).d());
        r1.put("anchor_connection_type", "invite");
        r1.put("invitee_list", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).p(com.bytedance.android.live.revlink.link.biz.service.i.A(this).b()));
        if (r5 == null) goto L18;
        aa r12 = r5.getVoteData();
        if (r12 == null) goto L18;
        String r13 = r12.getVoteDes();
        if (r13 == null) goto L18;
        if ((!StringsKt.isBlank(r13)) == false) goto L18;
        r1.put(FileUtils.PICTURE_THEME, r13);
    L18:
        if (r5 == null) goto L22;
        h9 r14 = r5.getSpecifyGiftConfig();
        if (r14 == null) goto L22;
        c0.a(r14, r1);
    L22:
        if (r5 == null) goto L24;
        com.bytedance.android.live.revlink.impl.multianchor.utils.r.a(r5, MapsKt.toMutableMap(r1));
    L24:
        Intrinsics.checkNotNullParameter(this, "$this$revLinkPanelLogger");
        r1.put("source", com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).q4().a());
        r1.put("if_strategy_invite", DataType.FALSE);
        r1.put("connection_type", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).c());
        r1.put("connection_sub_type", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).b());
        r1.put("anchor_connect_status", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).a());
        r1.put("room_status", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).s());
        LinkCrossRoomDataHolder r15 = com.bytedance.android.live.revlink.link.biz.service.i.B(this).f();
        p0 r16 = null;
        if (r15 == null) goto L27;
        Long r17 = Long.valueOf(r15.c());
    L28:
        r1.put("channel_id", String.valueOf(r17));
        mz0.n r18 = new mz0.n();
        mz0.o r19 = new mz0.o(r18.a);
        r19.b(r1);
        e21.e.d(r19, r8);
        if (r9 == null) goto L31;
        r19.b(r9);
    L31:
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r20 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r20 == null) goto L36;
        com.bytedance.live.datacontext.n<p0> r22 = r20.getLaunchBattleAttachInfo();
        if (r22 == null) goto L36;
        r16 = (p0) r22.getValue();
    L36:
        e21.c.e(r19, r16);
        mz0.m r23 = new mz0.m();
        r23.b(LogCommon.ROOM);
        ((ArrayList) r18.b).addAll(r23.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("livesdk_connection_invited", r18.a, r18.b);
        return;
    L27:
        r17 = null;
        goto L28
    L8:
        r10 = DataType.FALSE;
        goto L9
    }
}
