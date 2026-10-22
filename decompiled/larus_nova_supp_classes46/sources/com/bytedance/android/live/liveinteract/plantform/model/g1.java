package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g1 implements am3.c<LinkPlayerInfo> {
    public g1() {
    }

    public static LinkPlayerInfo a(am3.g r7) throws Exception {
        LinkPlayerInfo r0 = new LinkPlayerInfo();
        int r1 = 0;
        r0.setThreadSafe(false);
        ArrayList r2 = new ArrayList();
        r0.tags = new ArrayList();
        r0.songList = new ArrayList();
        long r3 = r7.c();
    L3:
        int r5 = r7.f();
        if (r5 == (-1)) goto L51;
        am3.g.a r6 = r0.decodeExtensionFields(r5, r7);
        switch(r5) {
            case 1: goto L50;
            case 2: goto L7;
            case 3: goto L49;
            case 4: goto L48;
            case 5: goto L47;
            case 6: goto L46;
            case 7: goto L45;
            case 8: goto L44;
            case 9: goto L43;
            case 10: goto L42;
            case 11: goto L41;
            case 12: goto L40;
            case 13: goto L39;
            case 14: goto L38;
            case 15: goto L37;
            case 16: goto L36;
            case 17: goto L35;
            case 18: goto L34;
            case 19: goto L33;
            case 20: goto L32;
            case 21: goto L31;
            case 22: goto L30;
            case 23: goto L29;
            case 24: goto L28;
            case 25: goto L27;
            case 26: goto L26;
            case 27: goto L25;
            case 28: goto L24;
            case 29: goto L23;
            case 30: goto L22;
            case 31: goto L21;
            case 32: goto L7;
            case 33: goto L20;
            case 34: goto L19;
            case 35: goto L18;
            case 36: goto L17;
            case 37: goto L16;
            case 38: goto L15;
            case 39: goto L7;
            case 40: goto L14;
            case 41: goto L13;
            case 42: goto L12;
            case 43: goto L11;
            case 44: goto L10;
            case 45: goto L9;
            case 46: goto L8;
            default: goto L7;
        };
    L8:
        r0.tag = (ListUserTag) vh7.f.a(r7, ListUserTag.class);
        goto L3
    L9:
        r0.chorusGuestStatus = r7.j();
        goto L3
    L10:
        r0.eventInfo = new ListUserEventInfo(r7);
        goto L3
    L11:
        r0.alreadyInvited = am3.h.a(r7);
        goto L3
    L12:
        r0.applyTypeNew = r7.i();
        goto L3
    L13:
        r0.isAnonymous = am3.h.a(r7);
        goto L3
    L14:
        r0.micPosTagInfo = new MicPosTagInfo(r7);
        goto L3
    L15:
        r0.addPriceTime = r7.j();
        goto L3
    L16:
        r0.isAddPrice = am3.h.a(r7);
        goto L3
    L17:
        r0.rank = r7.j();
        goto L3
    L18:
        r0.fuzzyFanTicket = am3.h.c(r7);
        goto L3
    L19:
        r0.joinTeamFightInfo = (TeamFightJoinTeamInfo) vh7.f.a(r7, TeamFightJoinTeamInfo.class);
        goto L3
    L20:
        r0.lastInvitedTimeMillis = r7.j();
        goto L3
    L21:
        r0.inviteeType = r7.i();
        goto L3
    L22:
        r2.add(Integer.valueOf(r7.i()));
        goto L3
    L23:
        r0.tags.add((ListTag) vh7.f.a(r7, ListTag.class));
        goto L3
    L24:
        r0.linkedListUserInfo = (LinkedListUserInfo) vh7.f.a(r7, LinkedListUserInfo.class);
        goto L3
    L25:
        r0.inviteListUserInfo = (InviteListUserInfo) vh7.f.a(r7, InviteListUserInfo.class);
        goto L3
    L26:
        r0.mInvitor = (IBaseUser) vh7.f.a(r7, IBaseUser.class);
        goto L3
    L27:
        r0.mcStatus = r7.j();
        goto L3
    L28:
        r0.waitingListUserInfo = (WaitingListUserInfo) vh7.f.a(r7, WaitingListUserInfo.class);
        goto L3
    L29:
        r0.listUserFromType = r7.i();
        goto L3
    L30:
        r0.listUserType = r7.i();
        goto L3
    L31:
        r0.isActive = am3.h.a(r7);
        goto L3
    L32:
        r0.devicePlatform = am3.h.c(r7);
        goto L3
    L33:
        r0.clientVersion = r7.j();
        goto L3
    L34:
        r0.appId = r7.j();
        goto L3
    L35:
        r0.songList.add(new KtvMusic(r7));
        goto L3
    L36:
        r0.isHost = am3.h.a(r7);
        goto L3
    L37:
        r0.modifyTimeInNano = r7.j();
        goto L3
    L38:
        r0.userRelationType = r7.i();
        goto L3
    L39:
        r0.location = am3.h.c(r7);
        goto L3
    L40:
        r0.mInteractIdStr = am3.h.c(r7);
        goto L3
    L41:
        r0.linkDuration = (int) r7.j();
        goto L3
    L42:
        r0.paidMoney = (int) r7.j();
        goto L3
    L43:
        r0.mFanTicket = r7.j();
        goto L3
    L44:
        r0.silenceStatus = r7.i();
        goto L3
    L45:
        r0.userPosition = (int) r7.j();
        goto L3
    L46:
        r0.mRoleType = r7.i();
        goto L3
    L47:
        r0.mLinkType = r7.i();
        goto L3
    L48:
        r0.mLinkStatus = r7.i();
        goto L3
    L49:
        r0.mModifyTime = r7.j();
        goto L3
    L50:
        r0.mUser = (IBaseUser) vh7.f.a(r7, IBaseUser.class);
        goto L3
    L7:
        am3.h.d(r6, r7);
        goto L3
    L51:
        r7.d(r3);
        int[] r8 = new int[r2.size()];
    L53:
        if (r1 >= r2.size()) goto L55;
        r8[r1] = ((Integer) ListProtector.get(r2, r1)).intValue();
        r1 = r1 + 1;
        goto L53
    L55:
        r0.interestedType = r8;
        r0.setThreadSafe(true);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
