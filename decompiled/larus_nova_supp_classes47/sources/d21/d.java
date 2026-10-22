package d21;

import c21.f;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public d(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public static PkBaseStateMachine.Source b(int r1) {
        if (r1 == 0) goto L27;
        if (r1 == 1) goto L39;
        if (r1 == 4) goto L38;
        if (r1 == 6) goto L37;
        if (r1 == 7) goto L36;
        if (r1 == 8) goto L35;
        switch(r1) {
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            default: goto L14;
        };
    L14:
        return null;
    L29:
        return PkBaseStateMachine.Source.StartOpenGame;
    L30:
        return PkBaseStateMachine.Source.PunishTimeUp;
    L31:
        return PkBaseStateMachine.Source.ChangeMode;
    L32:
        return PkBaseStateMachine.Source.MultipleInvite;
    L33:
        return PkBaseStateMachine.Source.NormalToMultiple;
    L34:
        return PkBaseStateMachine.Source.RoomClose;
    L35:
        return PkBaseStateMachine.Source.RtcLinkerLeave;
    L36:
        return PkBaseStateMachine.Source.ScoreControl;
    L37:
        return PkBaseStateMachine.Source.BattleFinishInstantKill;
    L38:
        return PkBaseStateMachine.Source.ChangeMode;
    L39:
        return PkBaseStateMachine.Source.CutShort;
    L27:
        return PkBaseStateMachine.Source.BattleFinishTimeUp;
    }

    public static String c(int r1) {
        if (r1 != PkDoubleAudienceDataContext.BattleStatsFromType.PKingInRoom.ordinal()) goto L6;
        return "enter_room_in_pk";
    L6:
        if (r1 != PkDoubleAudienceDataContext.BattleStatsFromType.SEI.ordinal()) goto L9;
        return "receive_pk_sei_backup";
    L9:
        if (r1 != PkDoubleAudienceDataContext.BattleStatsFromType.NoFinishIM.ordinal()) goto L12;
        return "audience_no_finish_im";
    L12:
        if (r1 != PkDoubleAudienceDataContext.BattleStatsFromType.Feed.ordinal()) goto L14;
        return "pk_feed";
    L14:
        return "";
    }

    public static BattleInviteType d(int r1) {
        if (r1 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Again.ordinal()) goto L6;
        return BattleInviteType.AGAIN;
    L6:
        if (r1 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Multiple_Again.ordinal()) goto L9;
        return BattleInviteType.MULTIPLE_AGAIN;
    L9:
        if (r1 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Normal_Activity.ordinal()) goto L12;
        return BattleInviteType.NORMAL_ACTIVITY;
    L12:
        if (r1 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Multiple_Activity.ordinal()) goto L15;
        return BattleInviteType.MULTIPLE_ACTIVITY;
    L15:
        if (r1 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_ChangeMultiPkMode.ordinal()) goto L18;
        return BattleInviteType.CHANGE_MULTI_PK_MODE;
    L18:
        return BattleInviteType.UNKNOWN;
    }

    public static q11.b f(PkBaseStateMachine.c r1) {
        Intrinsics.checkNotNullParameter(r1, "value");
        r1.getClass();
        if ((r1 instanceof PkBaseStateMachine.c.C0130c) == false) goto L6;
        return q11.b.d.b;
    L6:
        if ((r1 instanceof PkBaseStateMachine.c.d) == false) goto L9;
        return q11.b.c.b;
    L9:
        if ((r1 instanceof PkBaseStateMachine.c.b) == false) goto L12;
        return q11.b.C0295b.b;
    L12:
        return q11.b.a.b;
    }

    public final RevPkResult e(Map<String, ? extends PkBaseResult> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        s r1 = r0.getRevLinkCommonUtil();
    L6:
        if (r1 == null) goto L9;
        String r3 = r1.c();
        if (r3 == null) goto L9;
    L10:
        PkBaseResult r4 = r2.get(r3);
        if (r4 == null) goto L24;
        int r5 = c.a[r4.ordinal()];
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L26;
        if (r5 != 3) goto L24;
        return RevPkResult.EVEN;
    L26:
        return RevPkResult.RIGHT_WON;
    L23:
        return RevPkResult.LEFT_WON;
    L24:
        return RevPkResult.UNFINISHED;
    L9:
        r3 = "";
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static f a(d r8, IBattleConfigSetting r9, int r10, int r12) {
        PlayMode r13 = h21.c.a(Integer.valueOf(r10));
        if (r9 != null) goto L5;
        f r14 = new f.h(r12, r13);
    L73:
        return r14;
    L5:
        if (r9.getVoteData() != null) goto L74;
        v2 r15 = r9.getSelfSettingRate();
        boolean r0 = false;
        if (r15 == null) goto L15;
        long r2 = 99;
        long r4 = r15.getPkValueType();
        if (1 > r4) goto L15;
        if (r2 < r4) goto L15;
        boolean r16 = true;
    L16:
        if (r16 == false) goto L20;
        f r17 = new f.d(r12, r13, r9.getSelfData(), r9.getSelfSettingRate());
    L75:
        return r17;
    L20:
        if (r9.getActivityId() == null) goto L32;
        String r18 = r9.getActivityId();
        if (r18 == null) goto L32;
        if (r18.length() <= 0) goto L26;
        boolean r19 = true;
    L27:
        if (r19 != true) goto L32;
        String r20 = r9.getActivityId();
        if (r20 != null) goto L76;
        r20 = "";
    L76:
        return new f.e(r20);
    L26:
        r19 = false;
    L32:
        w2 r110 = r9.getShellConfig();
        if (r110 == null) goto L35;
        long r5 = r110.getType();
    L37:
        if (r5 <= 0) goto L40;
        r17 = new f.k(r12, r13, r9.getShellConfig());
        goto L75
    L40:
        if (r9.getModType() == PkBaseDataContext.PKModType.BreakThrough.getType()) goto L77;
        h9 r111 = r9.getSpecifyGiftConfig();
        if (r111 == null) goto L56;
        List r112 = r111.getGiftIds();
        if ((!r112.isEmpty()) == true) goto L48;
        r112 = null;
    L48:
        if (r112 == null) goto L52;
        Long r113 = (Long) ListProtector.get(r112, 0);
        if (r113 == null) goto L52;
        long r6 = r113.longValue();
    L54:
        if (r6 <= 0) goto L56;
        r0 = true;
    L52:
        r6 = 0;
    L56:
        if (r0 == false) goto L59;
        r17 = new f.l(r12, r13, r9.getSpecifyGiftConfig());
        goto L75
    L59:
        if (r9.getModType() != PkBaseDataContext.PKModType.Custom.getType()) goto L62;
        r17 = new f.g(r12, r13, r9.getCustomConfig());
        goto L75
    L62:
        if (r9.getModType() != PkBaseDataContext.PKModType.RobC.getType()) goto L65;
        r14 = new f.i(r13);
        goto L73
    L65:
        if (r9.getModType() != PkBaseDataContext.PKModType.CloudCollaborate.getType()) goto L68;
        r17 = new f.b(r12, r13, r9.getCloudCollaborateConfig());
        goto L75
    L68:
        if (r9.getModType() != PkBaseDataContext.PKModType.InteractPk.getType()) goto L70;
        r17 = new f.C0009f(r12, r13, r9);
        goto L75
    L70:
        r14 = new f.h(r12, r13);
        goto L73
    L77:
        return new f.a(r12, r9.getBreakthroughConfig());
    L35:
        r5 = 0;
    L15:
        r16 = false;
        goto L16
    L74:
        return new f.m(r12, r9.getVoteData());
    }
}
