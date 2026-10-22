package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.BattlePanelActionResultModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.PkPanelService;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.o6;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.r7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BattlePanelActionMethod extends wy0.b<r7, BattlePanelActionResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/BattlePanelActionMethod$BattlePanelType;", "", "", "type", "I", "getType", "()I", "DebugInfoPanel", "TeamPkMatchPanel", "InvitePanel", "ModeChoosePanel", "SettingPanel", "Close", "FeedbackPanel", "VoteStartPanel", "QuitTopConfirmDialog", "InviteSelectedRelink", "InviteMateRelink", "PlayBeInvitedReply", "StartPkPanel", "RelinkReply", "RelinkCancel", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattlePanelType extends Enum<BattlePanelType> {
        public static final BattlePanelType Close = null;
        public static final BattlePanelType DebugInfoPanel = null;
        public static final BattlePanelType FeedbackPanel = null;
        public static final BattlePanelType InviteMateRelink = null;
        public static final BattlePanelType InvitePanel = null;
        public static final BattlePanelType InviteSelectedRelink = null;
        public static final BattlePanelType ModeChoosePanel = null;
        public static final BattlePanelType PlayBeInvitedReply = null;
        public static final BattlePanelType QuitTopConfirmDialog = null;
        public static final BattlePanelType RelinkCancel = null;
        public static final BattlePanelType RelinkReply = null;
        public static final BattlePanelType SettingPanel = null;
        public static final BattlePanelType StartPkPanel = null;
        public static final BattlePanelType TeamPkMatchPanel = null;
        public static final BattlePanelType VoteStartPanel = null;
        public static final /* synthetic */ BattlePanelType[] a = null;
        private final int type;

        public static BattlePanelType valueOf(String r1) {
            return (BattlePanelType) r27.a.a(BattlePanelType.class, r1);
        }

        public static BattlePanelType[] values() {
            return (BattlePanelType[]) a.clone();
        }

        static {
            BattlePanelType r1 = new BattlePanelType("DebugInfoPanel", 0, -1);
            DebugInfoPanel = r1;
            BattlePanelType r2 = new BattlePanelType("TeamPkMatchPanel", 1, 1);
            TeamPkMatchPanel = r2;
            BattlePanelType r3 = new BattlePanelType("InvitePanel", 2, 2);
            InvitePanel = r3;
            BattlePanelType r4 = new BattlePanelType("ModeChoosePanel", 3, 3);
            ModeChoosePanel = r4;
            BattlePanelType r5 = new BattlePanelType("SettingPanel", 4, 4);
            SettingPanel = r5;
            BattlePanelType r6 = new BattlePanelType("Close", 5, 5);
            Close = r6;
            BattlePanelType r7 = new BattlePanelType("FeedbackPanel", 6, 6);
            FeedbackPanel = r7;
            BattlePanelType r8 = new BattlePanelType("VoteStartPanel", 7, 7);
            VoteStartPanel = r8;
            BattlePanelType r9 = new BattlePanelType("QuitTopConfirmDialog", 8, 8);
            QuitTopConfirmDialog = r9;
            BattlePanelType r10 = new BattlePanelType("InviteSelectedRelink", 9, 9);
            InviteSelectedRelink = r10;
            BattlePanelType r12 = new BattlePanelType("InviteMateRelink", 10, 10);
            InviteMateRelink = r12;
            BattlePanelType r13 = new BattlePanelType("PlayBeInvitedReply", 11, 11);
            PlayBeInvitedReply = r13;
            BattlePanelType r14 = new BattlePanelType("StartPkPanel", 12, 12);
            StartPkPanel = r14;
            BattlePanelType r15 = new BattlePanelType("RelinkReply", 13, 13);
            RelinkReply = r15;
            BattlePanelType r16 = new BattlePanelType("RelinkCancel", 14, 14);
            RelinkCancel = r16;
            a = new BattlePanelType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16};
        }

        public final int getType() {
            return this.type;
        }

        public BattlePanelType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.service.a m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.u5();
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public BattlePanelActionMethod(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(r7.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r18, CallContext r19) {
        r7 r1 = (r7) r18;
        Intrinsics.checkNotNullParameter(r1, "param");
        Intrinsics.checkNotNullParameter(r19, "callContext");
        int r2 = r1.getEventName();
        Pair<List<String>, List<String>> r4 = null;
        String r5 = "";
        if (r2 != BattlePanelType.TeamPkMatchPanel.getType()) goto L20;
        JsonObject r3 = r1.getExtra();
        if (r3 == null) goto L9;
        String r6 = r3.toString();
        if (r6 == null) goto L9;
        r4 = new JSONObject(r6);
    L9:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r7 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r7 == null) goto L281;
        if (r4 == null) goto L18;
        Object r8 = r4.get("match_info");
        if (r8 == null) goto L18;
        String r9 = r8.toString();
        if (r9 == null) goto L18;
        r5 = r9;
    L18:
        r7.startTeamPkMatch(r5);
    L281:
        BattlePanelActionResultModel r10 = new BattlePanelActionResultModel();
        r10.a(BattlePanelActionResultModel.Code.Success);
        finishWithResult(r10);
        return;
    L20:
        if (r2 != BattlePanelType.InvitePanel.getType()) goto L25;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r12 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r12 == null) goto L281;
        r12.openInviteMorePanel();
        goto L281
    L25:
        if (r2 != BattlePanelType.SettingPanel.getType()) goto L29;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r13 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r13 == null) goto L281;
        r13.openSetPanel();
        goto L281
    L29:
        int r14 = 0;
        if (r2 != BattlePanelType.Close.getType()) goto L55;
        com.bytedance.android.live.revlink.impl.global.c r15 = this.b;
        if (r15 == null) goto L34;
        com.bytedance.android.live.revlink.impl.service.internal.a r16 = r15.Do();
    L35:
        if (r16 == null) goto L37;
        int r17 = r16.getCurrentMode();
    L39:
        if (com.bytedance.android.live.utils.c.a(r17, 4) == false) goto L41;
        char r20 = 1;
    L42:
        if (r20 != 1) goto L46;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r22 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r22 == null) goto L281;
        r22.closeLink();
        goto L281
    L46:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r23 = m();
        if (r23 == null) goto L49;
        r23.finishMultiAnchor(7, null, false, "ceiling_view_leave", true);
    L49:
        com.bytedance.android.live.revlink.impl.global.c r24 = this.b;
        if (r24 == null) goto L52;
        r4 = r24.Mf();
    L52:
        if (r4 == null) goto L281;
        r4.ni(0, "quit_link");
        goto L281
    L41:
        r20 = 7;
        goto L42
    L37:
        r17 = 0;
        goto L39
    L34:
        r16 = null;
        goto L35
    L55:
        if (r2 != BattlePanelType.FeedbackPanel.getType()) goto L60;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r25 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r25 == null) goto L281;
        r25.showFeedBackDialog();
        goto L281
    L60:
        if (r2 != BattlePanelType.VoteStartPanel.getType()) goto L65;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r26 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r26 == null) goto L281;
        r26.openVoteStartDialog();
        goto L281
    L65:
        if (r2 != BattlePanelType.DebugInfoPanel.getType()) goto L70;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r27 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r27 == null) goto L281;
        r27.openAnchorLinkDebugDialog();
        goto L281
    L70:
        if (r2 != BattlePanelType.ModeChoosePanel.getType()) goto L77;
        com.bytedance.android.live.revlink.impl.global.c r28 = this.b;
        if (r28 == null) goto L74;
        r4 = r28.O4();
    L74:
        if (r4 == null) goto L281;
        r4.Md(r1.getExtra());
        goto L281
    L77:
        if (r2 != BattlePanelType.QuitTopConfirmDialog.getType()) goto L84;
        com.bytedance.android.live.revlink.impl.global.c r29 = this.b;
        if (r29 == null) goto L81;
        r4 = r29.O4();
    L81:
        if (r4 == null) goto L281;
        r4.t8();
        goto L281
    L84:
        if (r2 != BattlePanelType.InviteSelectedRelink.getType()) goto L113;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r30 = m();
        if (r30 == null) goto L281;
        MultiAnchorRelinkService r32 = r30.Fa();
        if (r32 == null) goto L281;
        JsonElement r33 = r1.getExtra().get("invite_anchor_ids");
        if (r33 == null) goto L95;
        String r34 = r33.getAsString();
        if (r34 == null) goto L95;
        List<String> r35 = StringsKt.split$default(r34, new String[]{","}, false, 0, 6, null);
        if (r35 == null) goto L95;
    L96:
        JsonObject r36 = r1.getExtra();
        if (r36 == null) goto L103;
        JsonElement r37 = r36.get("match_type");
        if (r37 == null) goto L103;
        String r38 = r37.getAsString();
        if (r38 == null) goto L103;
        int r39 = CastIntegerProtector.parseInt(r38);
    L104:
        JsonObject r40 = r1.getExtra();
        if (r40 == null) goto L111;
        JsonElement r42 = r40.get("invite_type");
        if (r42 == null) goto L111;
        String r43 = r42.getAsString();
        if (r43 == null) goto L111;
        r14 = CastIntegerProtector.parseInt(r43);
    L111:
        r32.n(r35, r39, r14);
    L103:
        r39 = 0;
    L95:
        r35 = CollectionsKt.emptyList();
        goto L96
    L113:
        if (r2 != BattlePanelType.InviteMateRelink.getType()) goto L157;
        com.bytedance.android.live.revlink.impl.global.c r44 = this.b;
        if (r44 == null) goto L281;
        com.bytedance.android.live.revlink.impl.multianchor.utils.b0 r45 = r44.Tj();
        if (r45 == null) goto L281;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r46 = r45.b();
        if (r46 != null) goto L121;
    L125:
        if (r14 != 1) goto L281;
        com.bytedance.android.live.revlink.impl.global.c r47 = this.b;
        if (r47 == null) goto L134;
        com.bytedance.android.live.revlink.impl.multianchor.utils.b0 r48 = r47.Tj();
        if (r48 == null) goto L134;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r49 = r48.a();
        if (r49 == null) goto L133;
        r4 = r49.getTeamPkUids();
    L133:
        if (r4 == null) goto L134;
    L135:
        List r50 = (List) r4.component1();
        List r52 = (List) r4.component2();
        if (CollectionsKt.contains(r50, com.bytedance.android.live.revenuelink.connect.b.d()) == true) goto L143;
        if (CollectionsKt.contains(r52, com.bytedance.android.live.revenuelink.connect.b.d()) == false) goto L141;
        r50 = r52;
        goto L143
    L141:
        r50 = CollectionsKt.emptyList();
    L143:
        if (r50.size() <= 1) goto L281;
        ArrayList r53 = new ArrayList();
        Iterator r54 = r50.iterator();
    L146:
        if (r54.hasNext() == false) goto L150;
        Object r55 = r54.next();
        if ((!Intrinsics.areEqual((String) r55, com.bytedance.android.live.revenuelink.connect.b.d())) == false) goto L146;
        r53.add(r55);
        goto L146
    L150:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r56 = m();
        if (r56 == null) goto L155;
        MultiAnchorRelinkService r57 = r56.Fa();
        if (r57 == null) goto L155;
        r57.n(r53, 20, 20);
    L155:
        this.b.getLinkOptLogContext().c(20);
    L134:
        r4 = TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        goto L135
    L121:
        if (r46.isBattleShow() != true) goto L125;
        if (r45.d() != PlayMode.TEAM_PK) goto L125;
        r14 = 1;
        goto L125
    L157:
        if (r2 != BattlePanelType.PlayBeInvitedReply.getType()) goto L198;
        JsonElement r58 = r1.getExtra().get("reply_type");
        if (r58 == null) goto L162;
        String r59 = r58.getAsString();
        if (r59 == null) goto L162;
    L163:
        JsonElement r60 = r1.getExtra().get("invite_uid");
        if (r60 == null) goto L167;
        String r62 = r60.getAsString();
        if (r62 == null) goto L167;
    L168:
        JsonElement r63 = r1.getExtra().get("invite_type");
        if (r63 == null) goto L172;
        String r64 = r63.getAsString();
        if (r64 == null) goto L172;
    L173:
        JsonElement r65 = r1.getExtra().get("multi_pk_mode");
        if (r65 == null) goto L180;
        String r66 = r65.getAsString();
        if (r66 == null) goto L180;
        r5 = r66;
    L180:
        if (Intrinsics.areEqual(r59, "agree") == false) goto L189;
        com.bytedance.android.live.revlink.impl.global.c r67 = this.b;
        if (r67 == null) goto L184;
        r4 = r67.Ig();
    L184:
        if (r4 == null) goto L281;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r68 = r4.getPkAnchorLauncher();
        if (r68 == null) goto L281;
        r68.c(new c21.g.a(r62, CastIntegerProtector.parseInt(r64), CastIntegerProtector.parseInt(r5)));
        goto L281
    L189:
        if (Intrinsics.areEqual(r59, "reject") == false) goto L281;
        com.bytedance.android.live.revlink.impl.global.c r69 = this.b;
        if (r69 == null) goto L193;
        r4 = r69.Ig();
    L193:
        if (r4 == null) goto L281;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r70 = r4.getPkAnchorLauncher();
        if (r70 == null) goto L281;
        r70.c(new c21.g.b(r62, CastIntegerProtector.parseInt(r64), CastIntegerProtector.parseInt(r5)));
    L172:
        r64 = "";
    L167:
        r62 = "";
    L162:
        r59 = "";
        goto L163
    L198:
        if (r2 != BattlePanelType.StartPkPanel.getType()) goto L214;
        JsonObject r72 = r1.getExtra();
        if (r72 != null) goto L202;
    L208:
        com.bytedance.android.live.revlink.impl.global.c r73 = this.b;
        if (r73 == null) goto L281;
        com.bytedance.android.live.revlink.impl.service.internal.a r74 = r73.Do();
        if (r74 == null) goto L281;
        r74.Sa();
        goto L281
    L202:
        if (r72.has("tabIndex") != true) goto L208;
        JsonObject r75 = r1.getExtra();
        if (r75 == null) goto L208;
        JsonElement r76 = r75.get("tabIndex");
        if (r76 == null) goto L208;
        r76.getAsInt();
        goto L208
    L214:
        if (r2 != BattlePanelType.RelinkReply.getType()) goto L267;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r77 = m();
        if (r77 == null) goto L281;
        MultiAnchorRelinkService r78 = r77.Fa();
        if (r78 == null) goto L281;
        RelinkDataContext r79 = r78.b;
        if (r79 == null) goto L281;
        com.bytedance.android.live.revlink.impl.multianchor.connect.n r80 = (com.bytedance.android.live.revlink.impl.multianchor.connect.n) r79.getRelinkState().getValue();
        if ((r80 instanceof com.bytedance.android.live.revlink.impl.multianchor.connect.n.a) == false) goto L281;
        JsonElement r82 = r1.getExtra().get("reply_status");
        if (r82 == null) goto L228;
        String r83 = r82.getAsString();
        if (r83 == null) goto L228;
        int r84 = CastIntegerProtector.parseInt(r83);
    L229:
        com.bytedance.android.live.revlink.impl.multianchor.connect.n.a r85 = (com.bytedance.android.live.revlink.impl.multianchor.connect.n.a) r80;
        o6 r86 = r85.a.getSwitchChannelInviteContent();
        if (r86 == null) goto L241;
        e6 r87 = r86.getInviteContent();
        if (r87 == null) goto L241;
        com.bytedance.android.livesdk.link.model.p r88 = r87.getInviteUser();
        if (r88 == null) goto L241;
        IBaseUser r89 = r88.getUser();
        if (r89 == null) goto L241;
        String r90 = r89.getIdString();
        if (r90 == null) goto L241;
        String r110 = r90;
    L242:
        o6 r92 = r85.a.getSwitchChannelInviteContent();
        long r93 = 0;
        if (r92 == null) goto L247;
        e6 r94 = r92.getInviteContent();
        if (r94 == null) goto L247;
        long r111 = r94.getFromRoomId();
    L248:
        o6 r95 = r85.a.getSwitchChannelInviteContent();
        if (r95 == null) goto L253;
        e6 r96 = r95.getInviteContent();
        if (r96 == null) goto L253;
        long r112 = r96.getToJoinChannelId();
    L254:
        IBattleLinkerInviteMessageExtra r97 = j6.a(r85.a);
        if (r97 == null) goto L257;
        long r98 = r97.getMatchType();
    L258:
        IBattleLinkerInviteMessageExtra r99 = j6.a(r85.a);
        if (r99 == null) goto L261;
        r93 = r99.getInviteType();
    L261:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r100 = m();
        if (r100 == null) goto L281;
        MultiAnchorRelinkService r101 = r100.Fa();
        if (r101 == null) goto L281;
        r101.s(r84, r110, r111, r112, (int) r98, (int) r93);
        goto L281
    L257:
        r98 = 0;
    L253:
        r112 = 0;
    L247:
        r111 = 0;
    L241:
        r110 = "";
    L228:
        r84 = 0;
        goto L229
    L267:
        if (r2 != BattlePanelType.RelinkCancel.getType()) goto L281;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r102 = m();
        if (r102 == null) goto L281;
        MultiAnchorRelinkService r103 = r102.Fa();
        if (r103 == null) goto L281;
        RelinkDataContext r104 = r103.b;
        if (r104 == null) goto L281;
        com.bytedance.android.live.revlink.impl.multianchor.connect.n r105 = (com.bytedance.android.live.revlink.impl.multianchor.connect.n) r104.getRelinkState().getValue();
        if ((r105 instanceof com.bytedance.android.live.revlink.impl.multianchor.connect.n.b) == false) goto L281;
        d11.o r106 = ((com.bytedance.android.live.revlink.impl.multianchor.connect.n.b) r105).a;
        int r107 = r106.b;
        int r108 = r106.c;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r109 = m();
        if (r109 == null) goto L281;
        MultiAnchorRelinkService r113 = r109.Fa();
        if (r113 == null) goto L281;
        r113.i(Integer.valueOf(r107), Integer.valueOf(r108));
        goto L281
    }
}
